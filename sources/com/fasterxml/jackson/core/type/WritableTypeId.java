package com.fasterxml.jackson.core.type;

import com.fasterxml.jackson.core.JsonToken;

public class WritableTypeId {
    public String asProperty;
    public Object forValue;
    public Class<?> forValueType;

    /* renamed from: id */
    public Object f12553id;
    public Inclusion include;
    public JsonToken valueShape;
    public boolean wrapperWritten;

    public enum Inclusion {
        WRAPPER_ARRAY,
        WRAPPER_OBJECT,
        METADATA_PROPERTY,
        PAYLOAD_PROPERTY,
        PARENT_PROPERTY;

        public boolean requiresObjectContext() {
            return this == METADATA_PROPERTY || this == PAYLOAD_PROPERTY;
        }
    }

    public WritableTypeId(Object value, JsonToken valueShape0) {
        this(value, valueShape0, null);
    }

    public WritableTypeId(Object value, JsonToken valueShape0, Object id0) {
        this.forValue = value;
        this.f12553id = id0;
        this.valueShape = valueShape0;
    }
}
