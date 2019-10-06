package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.IOException;

public class MergingSettableBeanProperty extends Delegating {
    protected final AnnotatedMember _accessor;

    protected MergingSettableBeanProperty(SettableBeanProperty delegate, AnnotatedMember accessor) {
        super(delegate);
        this._accessor = accessor;
    }

    public static MergingSettableBeanProperty construct(SettableBeanProperty delegate, AnnotatedMember accessor) {
        return new MergingSettableBeanProperty(delegate, accessor);
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty withDelegate(SettableBeanProperty d) {
        return new MergingSettableBeanProperty(d, this._accessor);
    }

    public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
        Object newValue;
        Object oldValue = this._accessor.getValue(instance);
        if (oldValue == null) {
            newValue = this.delegate.deserialize(p, ctxt);
        } else {
            newValue = this.delegate.deserializeWith(p, ctxt, oldValue);
        }
        if (newValue != oldValue) {
            this.delegate.set(instance, newValue);
        }
    }

    public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
        Object newValue;
        Object oldValue = this._accessor.getValue(instance);
        if (oldValue == null) {
            newValue = this.delegate.deserialize(p, ctxt);
        } else {
            newValue = this.delegate.deserializeWith(p, ctxt, oldValue);
        }
        if (newValue == oldValue || newValue == null) {
            return instance;
        }
        return this.delegate.setAndReturn(instance, newValue);
    }

    public void set(Object instance, Object value) throws IOException {
        if (value != null) {
            this.delegate.set(instance, value);
        }
    }

    public Object setAndReturn(Object instance, Object value) throws IOException {
        if (value != null) {
            return this.delegate.setAndReturn(instance, value);
        }
        return instance;
    }
}
