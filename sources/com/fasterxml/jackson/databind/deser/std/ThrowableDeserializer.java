package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Set;

public class ThrowableDeserializer extends BeanDeserializer {
    public ThrowableDeserializer(BeanDeserializer baseDeserializer) {
        super(baseDeserializer);
        this._vanillaProcessing = false;
    }

    protected ThrowableDeserializer(BeanDeserializer src, NameTransformer unwrapper) {
        super((BeanDeserializerBase) src, unwrapper);
    }

    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer unwrapper) {
        if (getClass() != ThrowableDeserializer.class) {
            return this;
        }
        return new ThrowableDeserializer(this, unwrapper);
    }

    public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingPropertyBased(p, ctxt);
        }
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(ctxt, jsonDeserializer.deserialize(p, ctxt));
        }
        if (this._beanType.isAbstract()) {
            return ctxt.handleMissingInstantiator(handledType(), getValueInstantiator(), p, "abstract type (need to add/enable type information?)", new Object[0]);
        }
        boolean hasStringCreator = this._valueInstantiator.canCreateFromString();
        boolean hasDefaultCtor = this._valueInstantiator.canCreateUsingDefault();
        if (hasStringCreator || hasDefaultCtor) {
            Object throwable = null;
            Object[] pending = null;
            int pendingIx = 0;
            while (p.getCurrentToken() != JsonToken.END_OBJECT) {
                String propName = p.getCurrentName();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                p.nextToken();
                if (prop != null) {
                    if (throwable != null) {
                        prop.deserializeAndSet(p, ctxt, throwable);
                    } else {
                        if (pending == null) {
                            int len = this._beanProperties.size();
                            pending = new Object[(len + len)];
                        }
                        int pendingIx2 = pendingIx + 1;
                        pending[pendingIx] = prop;
                        pendingIx = pendingIx2 + 1;
                        pending[pendingIx2] = prop.deserialize(p, ctxt);
                    }
                } else if (!"message".equals(propName) || !hasStringCreator) {
                    Set<String> set = this._ignorableProps;
                    if (set == null || !set.contains(propName)) {
                        SettableAnyProperty settableAnyProperty = this._anySetter;
                        if (settableAnyProperty != null) {
                            settableAnyProperty.deserializeAndSet(p, ctxt, throwable, propName);
                        } else {
                            handleUnknownProperty(p, ctxt, throwable, propName);
                        }
                    } else {
                        p.skipChildren();
                    }
                } else {
                    throwable = this._valueInstantiator.createFromString(ctxt, p.getValueAsString());
                    if (pending != null) {
                        int len2 = pendingIx;
                        for (int i = 0; i < len2; i += 2) {
                            ((SettableBeanProperty) pending[i]).set(throwable, pending[i + 1]);
                        }
                        pending = null;
                    }
                }
                p.nextToken();
            }
            if (throwable == null) {
                if (hasStringCreator) {
                    throwable = this._valueInstantiator.createFromString(ctxt, null);
                } else {
                    throwable = this._valueInstantiator.createUsingDefault(ctxt);
                }
                if (pending != null) {
                    int len3 = pendingIx;
                    for (int i2 = 0; i2 < len3; i2 += 2) {
                        ((SettableBeanProperty) pending[i2]).set(throwable, pending[i2 + 1]);
                    }
                }
            }
            return throwable;
        }
        return ctxt.handleMissingInstantiator(handledType(), getValueInstantiator(), p, "Throwable needs a default contructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
    }
}
