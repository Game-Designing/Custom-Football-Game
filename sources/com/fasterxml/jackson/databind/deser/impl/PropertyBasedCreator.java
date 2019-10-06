package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public final class PropertyBasedCreator {
    protected final SettableBeanProperty[] _allProperties;
    protected final int _propertyCount;
    protected final HashMap<String, SettableBeanProperty> _propertyLookup;
    protected final ValueInstantiator _valueInstantiator;

    static class CaseInsensitiveMap extends HashMap<String, SettableBeanProperty> {
        CaseInsensitiveMap() {
        }

        public SettableBeanProperty get(Object key0) {
            return (SettableBeanProperty) super.get(((String) key0).toLowerCase());
        }

        public SettableBeanProperty put(String key, SettableBeanProperty value) {
            return (SettableBeanProperty) super.put(key.toLowerCase(), value);
        }
    }

    protected PropertyBasedCreator(DeserializationContext ctxt, ValueInstantiator valueInstantiator, SettableBeanProperty[] creatorProps, boolean caseInsensitive, boolean addAliases) {
        SettableBeanProperty[] arr$;
        SettableBeanProperty[] settableBeanPropertyArr = creatorProps;
        this._valueInstantiator = valueInstantiator;
        if (caseInsensitive) {
            this._propertyLookup = new CaseInsensitiveMap();
        } else {
            this._propertyLookup = new HashMap<>();
        }
        int len = settableBeanPropertyArr.length;
        this._propertyCount = len;
        this._allProperties = new SettableBeanProperty[len];
        if (addAliases) {
            DeserializationConfig config = ctxt.getConfig();
            for (SettableBeanProperty prop : creatorProps) {
                if (!prop.isIgnorable()) {
                    List<PropertyName> aliases = prop.findAliases(config);
                    if (!aliases.isEmpty()) {
                        for (PropertyName pn : aliases) {
                            this._propertyLookup.put(pn.getSimpleName(), prop);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            SettableBeanProperty prop2 = settableBeanPropertyArr[i];
            this._allProperties[i] = prop2;
            if (!prop2.isIgnorable()) {
                this._propertyLookup.put(prop2.getName(), prop2);
            }
        }
    }

    public static PropertyBasedCreator construct(DeserializationContext ctxt, ValueInstantiator valueInstantiator, SettableBeanProperty[] srcCreatorProps, BeanPropertyMap allProperties) throws JsonMappingException {
        int len = srcCreatorProps.length;
        SettableBeanProperty[] creatorProps = new SettableBeanProperty[len];
        for (int i = 0; i < len; i++) {
            SettableBeanProperty prop = srcCreatorProps[i];
            if (!prop.hasValueDeserializer()) {
                prop = prop.withValueDeserializer(ctxt.findContextualValueDeserializer(prop.getType(), prop));
            }
            creatorProps[i] = prop;
        }
        PropertyBasedCreator propertyBasedCreator = new PropertyBasedCreator(ctxt, valueInstantiator, creatorProps, allProperties.isCaseInsensitive(), allProperties.hasAliases());
        return propertyBasedCreator;
    }

    public static PropertyBasedCreator construct(DeserializationContext ctxt, ValueInstantiator valueInstantiator, SettableBeanProperty[] srcCreatorProps, boolean caseInsensitive) throws JsonMappingException {
        int len = srcCreatorProps.length;
        SettableBeanProperty[] creatorProps = new SettableBeanProperty[len];
        for (int i = 0; i < len; i++) {
            SettableBeanProperty prop = srcCreatorProps[i];
            if (!prop.hasValueDeserializer()) {
                prop = prop.withValueDeserializer(ctxt.findContextualValueDeserializer(prop.getType(), prop));
            }
            creatorProps[i] = prop;
        }
        PropertyBasedCreator propertyBasedCreator = new PropertyBasedCreator(ctxt, valueInstantiator, creatorProps, caseInsensitive, false);
        return propertyBasedCreator;
    }

    public SettableBeanProperty findCreatorProperty(String name) {
        return (SettableBeanProperty) this._propertyLookup.get(name);
    }

    public PropertyValueBuffer startBuilding(JsonParser p, DeserializationContext ctxt, ObjectIdReader oir) {
        return new PropertyValueBuffer(p, ctxt, this._propertyCount, oir);
    }

    public Object build(DeserializationContext ctxt, PropertyValueBuffer buffer) throws IOException {
        Object bean = this._valueInstantiator.createFromObjectWith(ctxt, this._allProperties, buffer);
        if (bean != null) {
            bean = buffer.handleIdValue(ctxt, bean);
            for (PropertyValue pv = buffer.buffered(); pv != null; pv = pv.next) {
                pv.assign(bean);
            }
        }
        return bean;
    }
}
