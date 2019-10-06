package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public final class ManagedReferenceProperty extends Delegating {
    protected final SettableBeanProperty _backProperty;
    protected final boolean _isContainer;
    protected final String _referenceName;

    public ManagedReferenceProperty(SettableBeanProperty forward, String refName, SettableBeanProperty backward, boolean isContainer) {
        super(forward);
        this._referenceName = refName;
        this._backProperty = backward;
        this._isContainer = isContainer;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty withDelegate(SettableBeanProperty d) {
        throw new IllegalStateException("Should never try to reset delegate");
    }

    public void fixAccess(DeserializationConfig config) {
        this.delegate.fixAccess(config);
        this._backProperty.fixAccess(config);
    }

    public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
        set(instance, this.delegate.deserialize(p, ctxt));
    }

    public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
        return setAndReturn(instance, deserialize(p, ctxt));
    }

    public final void set(Object instance, Object value) throws IOException {
        setAndReturn(instance, value);
    }

    public Object setAndReturn(Object instance, Object value) throws IOException {
        Object[] arr$;
        if (value != null) {
            if (!this._isContainer) {
                this._backProperty.set(value, instance);
            } else if (value instanceof Object[]) {
                for (Object ob : (Object[]) value) {
                    if (ob != null) {
                        this._backProperty.set(ob, instance);
                    }
                }
            } else if (value instanceof Collection) {
                for (Object ob2 : (Collection) value) {
                    if (ob2 != null) {
                        this._backProperty.set(ob2, instance);
                    }
                }
            } else if (value instanceof Map) {
                for (Object ob3 : ((Map) value).values()) {
                    if (ob3 != null) {
                        this._backProperty.set(ob3, instance);
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unsupported container type (");
                sb.append(value.getClass().getName());
                sb.append(") when resolving reference '");
                sb.append(this._referenceName);
                sb.append("'");
                throw new IllegalStateException(sb.toString());
            }
        }
        return this.delegate.setAndReturn(instance, value);
    }
}
