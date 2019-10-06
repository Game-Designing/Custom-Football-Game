package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import java.io.IOException;

public class ConstantValueInstantiator extends ValueInstantiator {
    protected final Object _value;

    public ConstantValueInstantiator(Object value) {
        this._value = value;
    }

    public Class<?> getValueClass() {
        return this._value.getClass();
    }

    public boolean canInstantiate() {
        return true;
    }

    public boolean canCreateUsingDefault() {
        return true;
    }

    public Object createUsingDefault(DeserializationContext ctxt) throws IOException {
        return this._value;
    }
}
