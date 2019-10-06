package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public final class WritableObjectId {
    public final ObjectIdGenerator<?> generator;

    /* renamed from: id */
    public Object f12555id;
    protected boolean idWritten = false;

    public WritableObjectId(ObjectIdGenerator<?> generator2) {
        this.generator = generator2;
    }

    public boolean writeAsId(JsonGenerator gen, SerializerProvider provider, ObjectIdWriter w) throws IOException {
        if (this.f12555id == null || (!this.idWritten && !w.alwaysAsId)) {
            return false;
        }
        if (!gen.canWriteObjectId()) {
            w.serializer.serialize(this.f12555id, gen, provider);
            return true;
        }
        gen.writeObjectRef(String.valueOf(this.f12555id));
        throw null;
    }

    public Object generateId(Object forPojo) {
        if (this.f12555id == null) {
            this.f12555id = this.generator.generateId(forPojo);
        }
        return this.f12555id;
    }

    public void writeAsField(JsonGenerator gen, SerializerProvider provider, ObjectIdWriter w) throws IOException {
        this.idWritten = true;
        if (gen.canWriteObjectId()) {
            gen.writeObjectId(String.valueOf(this.f12555id));
            return;
        }
        SerializableString name = w.propertyName;
        if (name != null) {
            gen.writeFieldName(name);
            w.serializer.serialize(this.f12555id, gen, provider);
        }
    }
}
