package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.util.BitSet;

public class PropertyValueBuffer {
    protected PropertyValue _buffered;
    protected final DeserializationContext _context;
    protected final Object[] _creatorParameters;
    protected Object _idValue;
    protected final ObjectIdReader _objectIdReader;
    protected int _paramsNeeded;
    protected int _paramsSeen;
    protected final BitSet _paramsSeenBig;
    protected final JsonParser _parser;

    public PropertyValueBuffer(JsonParser p, DeserializationContext ctxt, int paramCount, ObjectIdReader oir) {
        this._parser = p;
        this._context = ctxt;
        this._paramsNeeded = paramCount;
        this._objectIdReader = oir;
        this._creatorParameters = new Object[paramCount];
        if (paramCount < 32) {
            this._paramsSeenBig = null;
        } else {
            this._paramsSeenBig = new BitSet();
        }
    }

    public Object[] getParameters(SettableBeanProperty[] props) throws JsonMappingException {
        if (this._paramsNeeded > 0) {
            if (this._paramsSeenBig != null) {
                int len = this._creatorParameters.length;
                int ix = 0;
                while (true) {
                    int nextClearBit = this._paramsSeenBig.nextClearBit(ix);
                    int ix2 = nextClearBit;
                    if (nextClearBit >= len) {
                        break;
                    }
                    this._creatorParameters[ix2] = _findMissing(props[ix2]);
                    ix = ix2 + 1;
                }
            } else {
                int mask = this._paramsSeen;
                int ix3 = 0;
                int len2 = this._creatorParameters.length;
                while (ix3 < len2) {
                    if ((mask & 1) == 0) {
                        this._creatorParameters[ix3] = _findMissing(props[ix3]);
                    }
                    ix3++;
                    mask >>= 1;
                }
            }
        }
        if (this._context.isEnabled(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES)) {
            int ix4 = 0;
            while (ix4 < props.length) {
                if (this._creatorParameters[ix4] != null) {
                    ix4++;
                } else {
                    SettableBeanProperty prop = props[ix4];
                    this._context.reportInputMismatch(prop.getType(), "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_FOR_CREATOR_PARAMETERS` enabled", prop.getName(), Integer.valueOf(props[ix4].getCreatorIndex()));
                    throw null;
                }
            }
        }
        return this._creatorParameters;
    }

    /* access modifiers changed from: protected */
    public Object _findMissing(SettableBeanProperty prop) throws JsonMappingException {
        if (prop.getInjectableValueId() != null) {
            return this._context.findInjectableValue(prop.getInjectableValueId(), prop, null);
        }
        if (prop.isRequired()) {
            this._context.reportInputMismatch((BeanProperty) prop, "Missing required creator property '%s' (index %d)", prop.getName(), Integer.valueOf(prop.getCreatorIndex()));
            throw null;
        } else if (!this._context.isEnabled(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES)) {
            return prop.getValueDeserializer().getNullValue(this._context);
        } else {
            this._context.reportInputMismatch((BeanProperty) prop, "Missing creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES` enabled", prop.getName(), Integer.valueOf(prop.getCreatorIndex()));
            throw null;
        }
    }

    public boolean readIdProperty(String propName) throws IOException {
        ObjectIdReader objectIdReader = this._objectIdReader;
        if (objectIdReader == null || !propName.equals(objectIdReader.propertyName.getSimpleName())) {
            return false;
        }
        this._idValue = this._objectIdReader.readObjectReference(this._parser, this._context);
        return true;
    }

    public Object handleIdValue(DeserializationContext ctxt, Object bean) throws IOException {
        ObjectIdReader objectIdReader = this._objectIdReader;
        if (objectIdReader != null) {
            Object obj = this._idValue;
            if (obj != null) {
                ctxt.findObjectId(obj, objectIdReader.generator, objectIdReader.resolver).bindItem(bean);
                SettableBeanProperty idProp = this._objectIdReader.idProperty;
                if (idProp != null) {
                    return idProp.setAndReturn(bean, this._idValue);
                }
            } else {
                ctxt.reportUnresolvedObjectId(objectIdReader, bean);
                throw null;
            }
        }
        return bean;
    }

    /* access modifiers changed from: protected */
    public PropertyValue buffered() {
        return this._buffered;
    }

    public boolean assignParameter(SettableBeanProperty prop, Object value) {
        int ix = prop.getCreatorIndex();
        this._creatorParameters[ix] = value;
        BitSet bitSet = this._paramsSeenBig;
        boolean z = false;
        if (bitSet == null) {
            int old = this._paramsSeen;
            int newValue = (1 << ix) | old;
            if (old != newValue) {
                this._paramsSeen = newValue;
                int i = this._paramsNeeded - 1;
                this._paramsNeeded = i;
                if (i <= 0) {
                    if (this._objectIdReader == null || this._idValue != null) {
                        z = true;
                    }
                    return z;
                }
            }
        } else if (!bitSet.get(ix)) {
            this._paramsSeenBig.set(ix);
            this._paramsNeeded--;
        }
        return false;
    }

    public void bufferProperty(SettableBeanProperty prop, Object value) {
        this._buffered = new Regular(this._buffered, value, prop);
    }

    public void bufferAnyProperty(SettableAnyProperty prop, String propName, Object value) {
        this._buffered = new Any(this._buffered, value, prop, propName);
    }

    public void bufferMapProperty(Object key, Object value) {
        this._buffered = new Map(this._buffered, value, key);
    }
}
