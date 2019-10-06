package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class BeanPropertyMap implements Iterable<SettableBeanProperty>, Serializable {
    private final Map<String, List<PropertyName>> _aliasDefs;
    private final Map<String, String> _aliasMapping;
    protected final boolean _caseInsensitive;
    private Object[] _hashArea;
    private int _hashMask;
    private SettableBeanProperty[] _propsInOrder;
    private int _size;
    private int _spillCount;

    public BeanPropertyMap(boolean caseInsensitive, Collection<SettableBeanProperty> props, Map<String, List<PropertyName>> aliasDefs) {
        this._caseInsensitive = caseInsensitive;
        this._propsInOrder = (SettableBeanProperty[]) props.toArray(new SettableBeanProperty[props.size()]);
        this._aliasDefs = aliasDefs;
        this._aliasMapping = _buildAliasMapping(aliasDefs);
        init(props);
    }

    protected BeanPropertyMap(BeanPropertyMap base, boolean caseInsensitive) {
        this._caseInsensitive = caseInsensitive;
        this._aliasDefs = base._aliasDefs;
        this._aliasMapping = base._aliasMapping;
        SettableBeanProperty[] settableBeanPropertyArr = base._propsInOrder;
        this._propsInOrder = (SettableBeanProperty[]) Arrays.copyOf(settableBeanPropertyArr, settableBeanPropertyArr.length);
        init(Arrays.asList(this._propsInOrder));
    }

    public BeanPropertyMap withCaseInsensitivity(boolean state) {
        if (this._caseInsensitive == state) {
            return this;
        }
        return new BeanPropertyMap(this, state);
    }

    /* access modifiers changed from: protected */
    public void init(Collection<SettableBeanProperty> props) {
        this._size = props.size();
        int hashSize = findSize(this._size);
        this._hashMask = hashSize - 1;
        Object[] hashed = new Object[(((hashSize >> 1) + hashSize) * 2)];
        int spillCount = 0;
        for (SettableBeanProperty prop : props) {
            if (prop != null) {
                String key = getPropertyName(prop);
                int slot = _hashCode(key);
                int ix = slot << 1;
                if (hashed[ix] != null) {
                    ix = ((slot >> 1) + hashSize) << 1;
                    if (hashed[ix] != null) {
                        ix = (((hashSize >> 1) + hashSize) << 1) + spillCount;
                        spillCount += 2;
                        if (ix >= hashed.length) {
                            hashed = Arrays.copyOf(hashed, hashed.length + 4);
                        }
                    }
                }
                hashed[ix] = key;
                hashed[ix + 1] = prop;
            }
        }
        this._hashArea = hashed;
        this._spillCount = spillCount;
    }

    private static final int findSize(int size) {
        if (size <= 5) {
            return 8;
        }
        if (size <= 12) {
            return 16;
        }
        int result = 32;
        while (result < (size >> 2) + size) {
            result += result;
        }
        return result;
    }

    public static BeanPropertyMap construct(Collection<SettableBeanProperty> props, boolean caseInsensitive, Map<String, List<PropertyName>> aliasMapping) {
        return new BeanPropertyMap(caseInsensitive, props, aliasMapping);
    }

    public BeanPropertyMap withProperty(SettableBeanProperty newProp) {
        String key = getPropertyName(newProp);
        int i = 1;
        int end = this._hashArea.length;
        while (i < end) {
            SettableBeanProperty prop = (SettableBeanProperty) this._hashArea[i];
            if (prop == null || !prop.getName().equals(key)) {
                i += 2;
            } else {
                this._hashArea[i] = newProp;
                this._propsInOrder[_findFromOrdered(prop)] = newProp;
                return this;
            }
        }
        int i2 = _hashCode(key);
        int hashSize = this._hashMask + 1;
        int ix = i2 << 1;
        Object[] objArr = this._hashArea;
        if (objArr[ix] != null) {
            ix = ((i2 >> 1) + hashSize) << 1;
            if (objArr[ix] != null) {
                int i3 = ((hashSize >> 1) + hashSize) << 1;
                int i4 = this._spillCount;
                ix = i3 + i4;
                this._spillCount = i4 + 2;
                if (ix >= objArr.length) {
                    this._hashArea = Arrays.copyOf(objArr, objArr.length + 4);
                }
            }
        }
        Object[] objArr2 = this._hashArea;
        objArr2[ix] = key;
        objArr2[ix + 1] = newProp;
        SettableBeanProperty[] settableBeanPropertyArr = this._propsInOrder;
        int last = settableBeanPropertyArr.length;
        this._propsInOrder = (SettableBeanProperty[]) Arrays.copyOf(settableBeanPropertyArr, last + 1);
        this._propsInOrder[last] = newProp;
        return this;
    }

    public BeanPropertyMap assignIndexes() {
        int index = 0;
        int end = this._hashArea.length;
        for (int i = 1; i < end; i += 2) {
            SettableBeanProperty prop = (SettableBeanProperty) this._hashArea[i];
            if (prop != null) {
                int index2 = index + 1;
                prop.assignIndex(index);
                index = index2;
            }
        }
        return this;
    }

    public BeanPropertyMap renameAll(NameTransformer transformer) {
        if (transformer == null || transformer == NameTransformer.NOP) {
            return this;
        }
        ArrayList<SettableBeanProperty> newProps = new ArrayList<>(len);
        for (SettableBeanProperty prop : this._propsInOrder) {
            if (prop == null) {
                newProps.add(prop);
            } else {
                newProps.add(_rename(prop, transformer));
            }
        }
        return new BeanPropertyMap(this._caseInsensitive, newProps, this._aliasDefs);
    }

    public BeanPropertyMap withoutProperties(Collection<String> toExclude) {
        if (toExclude.isEmpty()) {
            return this;
        }
        ArrayList<SettableBeanProperty> newProps = new ArrayList<>(len);
        for (SettableBeanProperty prop : this._propsInOrder) {
            if (prop != null && !toExclude.contains(prop.getName())) {
                newProps.add(prop);
            }
        }
        return new BeanPropertyMap(this._caseInsensitive, newProps, this._aliasDefs);
    }

    public void replace(SettableBeanProperty origProp, SettableBeanProperty newProp) {
        int end = this._hashArea.length;
        for (int i = 1; i <= end; i += 2) {
            Object[] objArr = this._hashArea;
            if (objArr[i] == origProp) {
                objArr[i] = newProp;
                this._propsInOrder[_findFromOrdered(origProp)] = newProp;
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No entry '");
        sb.append(origProp.getName());
        sb.append("' found, can't replace");
        throw new NoSuchElementException(sb.toString());
    }

    public void remove(SettableBeanProperty propToRm) {
        ArrayList<SettableBeanProperty> props = new ArrayList<>(this._size);
        String key = getPropertyName(propToRm);
        boolean found = false;
        int end = this._hashArea.length;
        for (int i = 1; i < end; i += 2) {
            Object[] objArr = this._hashArea;
            SettableBeanProperty prop = (SettableBeanProperty) objArr[i];
            if (prop != null) {
                if (!found) {
                    found = key.equals(objArr[i - 1]);
                    if (found) {
                        this._propsInOrder[_findFromOrdered(prop)] = null;
                    }
                }
                props.add(prop);
            }
        }
        if (found) {
            init(props);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No entry '");
        sb.append(propToRm.getName());
        sb.append("' found, can't remove");
        throw new NoSuchElementException(sb.toString());
    }

    public int size() {
        return this._size;
    }

    public boolean isCaseInsensitive() {
        return this._caseInsensitive;
    }

    public boolean hasAliases() {
        return !this._aliasDefs.isEmpty();
    }

    public Iterator<SettableBeanProperty> iterator() {
        return _properties().iterator();
    }

    private List<SettableBeanProperty> _properties() {
        ArrayList<SettableBeanProperty> p = new ArrayList<>(this._size);
        int end = this._hashArea.length;
        for (int i = 1; i < end; i += 2) {
            SettableBeanProperty prop = (SettableBeanProperty) this._hashArea[i];
            if (prop != null) {
                p.add(prop);
            }
        }
        return p;
    }

    public SettableBeanProperty[] getPropertiesInInsertionOrder() {
        return this._propsInOrder;
    }

    /* access modifiers changed from: protected */
    public final String getPropertyName(SettableBeanProperty prop) {
        return this._caseInsensitive ? prop.getName().toLowerCase() : prop.getName();
    }

    public SettableBeanProperty find(String key) {
        if (key != null) {
            if (this._caseInsensitive) {
                key = key.toLowerCase();
            }
            int slot = key.hashCode() & this._hashMask;
            int ix = slot << 1;
            Object match = this._hashArea[ix];
            if (match == key || key.equals(match)) {
                return (SettableBeanProperty) this._hashArea[ix + 1];
            }
            return _find2(key, slot, match);
        }
        throw new IllegalArgumentException("Cannot pass null property name");
    }

    private final SettableBeanProperty _find2(String key, int slot, Object match) {
        if (match == null) {
            return _findWithAlias((String) this._aliasMapping.get(key));
        }
        int hashSize = this._hashMask + 1;
        int ix = ((slot >> 1) + hashSize) << 1;
        Object match2 = this._hashArea[ix];
        if (key.equals(match2)) {
            return (SettableBeanProperty) this._hashArea[ix + 1];
        }
        if (match2 != null) {
            int i = ((hashSize >> 1) + hashSize) << 1;
            int end = this._spillCount + i;
            while (i < end) {
                Object match3 = this._hashArea[i];
                if (match3 == key || key.equals(match3)) {
                    return (SettableBeanProperty) this._hashArea[i + 1];
                }
                i += 2;
            }
        }
        return _findWithAlias((String) this._aliasMapping.get(key));
    }

    private SettableBeanProperty _findWithAlias(String keyFromAlias) {
        if (keyFromAlias == null) {
            return null;
        }
        int slot = _hashCode(keyFromAlias);
        int ix = slot << 1;
        Object match = this._hashArea[ix];
        if (keyFromAlias.equals(match)) {
            return (SettableBeanProperty) this._hashArea[ix + 1];
        }
        if (match == null) {
            return null;
        }
        return _find2ViaAlias(keyFromAlias, slot, match);
    }

    private SettableBeanProperty _find2ViaAlias(String key, int slot, Object match) {
        int hashSize = this._hashMask + 1;
        int ix = ((slot >> 1) + hashSize) << 1;
        Object match2 = this._hashArea[ix];
        if (key.equals(match2)) {
            return (SettableBeanProperty) this._hashArea[ix + 1];
        }
        if (match2 != null) {
            int i = ((hashSize >> 1) + hashSize) << 1;
            int end = this._spillCount + i;
            while (i < end) {
                Object match3 = this._hashArea[i];
                if (match3 == key || key.equals(match3)) {
                    return (SettableBeanProperty) this._hashArea[i + 1];
                }
                i += 2;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Properties=[");
        int count = 0;
        Iterator<SettableBeanProperty> it = iterator();
        while (it.hasNext()) {
            SettableBeanProperty prop = (SettableBeanProperty) it.next();
            int count2 = count + 1;
            if (count > 0) {
                sb.append(", ");
            }
            sb.append(prop.getName());
            sb.append('(');
            sb.append(prop.getType());
            sb.append(')');
            count = count2;
        }
        sb.append(']');
        if (!this._aliasDefs.isEmpty()) {
            sb.append("(aliases: ");
            sb.append(this._aliasDefs);
            sb.append(")");
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty _rename(SettableBeanProperty prop, NameTransformer xf) {
        if (prop == null) {
            return prop;
        }
        SettableBeanProperty prop2 = prop.withSimpleName(xf.transform(prop.getName()));
        JsonDeserializer<Object> deser = prop2.getValueDeserializer();
        if (deser != null) {
            JsonDeserializer<Object> newDeser = deser.unwrappingDeserializer(xf);
            if (newDeser != deser) {
                prop2 = prop2.withValueDeserializer(newDeser);
            }
        }
        return prop2;
    }

    private final int _findFromOrdered(SettableBeanProperty prop) {
        int end = this._propsInOrder.length;
        for (int i = 0; i < end; i++) {
            if (this._propsInOrder[i] == prop) {
                return i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal state: property '");
        sb.append(prop.getName());
        sb.append("' missing from _propsInOrder");
        throw new IllegalStateException(sb.toString());
    }

    private final int _hashCode(String key) {
        return key.hashCode() & this._hashMask;
    }

    private Map<String, String> _buildAliasMapping(Map<String, List<PropertyName>> defs) {
        if (defs == null || defs.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<String, String> aliases = new HashMap<>();
        for (Entry<String, List<PropertyName>> entry : defs.entrySet()) {
            String key = (String) entry.getKey();
            if (this._caseInsensitive) {
                key = key.toLowerCase();
            }
            for (PropertyName pn : (List) entry.getValue()) {
                String mapped = pn.getSimpleName();
                if (this._caseInsensitive) {
                    mapped = mapped.toLowerCase();
                }
                aliases.put(mapped, key);
            }
        }
        return aliases;
    }
}
