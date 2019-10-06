package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p134io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;

public final class ObjectIdWriter {
    public final boolean alwaysAsId;
    public final ObjectIdGenerator<?> generator;
    public final JavaType idType;
    public final SerializableString propertyName;
    public final JsonSerializer<Object> serializer;

    protected ObjectIdWriter(JavaType t, SerializableString propName, ObjectIdGenerator<?> gen, JsonSerializer<?> ser, boolean alwaysAsId2) {
        this.idType = t;
        this.propertyName = propName;
        this.generator = gen;
        this.serializer = ser;
        this.alwaysAsId = alwaysAsId2;
    }

    public static ObjectIdWriter construct(JavaType idType2, PropertyName propName, ObjectIdGenerator<?> generator2, boolean alwaysAsId2) {
        SerializedString serializedString = null;
        String simpleName = propName == null ? null : propName.getSimpleName();
        if (simpleName != null) {
            serializedString = new SerializedString(simpleName);
        }
        ObjectIdWriter objectIdWriter = new ObjectIdWriter(idType2, serializedString, generator2, null, alwaysAsId2);
        return objectIdWriter;
    }

    public ObjectIdWriter withSerializer(JsonSerializer<?> ser) {
        ObjectIdWriter objectIdWriter = new ObjectIdWriter(this.idType, this.propertyName, this.generator, ser, this.alwaysAsId);
        return objectIdWriter;
    }

    public ObjectIdWriter withAlwaysAsId(boolean newState) {
        if (newState == this.alwaysAsId) {
            return this;
        }
        ObjectIdWriter objectIdWriter = new ObjectIdWriter(this.idType, this.propertyName, this.generator, this.serializer, newState);
        return objectIdWriter;
    }
}
