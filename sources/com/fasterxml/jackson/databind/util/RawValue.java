package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public class RawValue implements JsonSerializable {
    protected Object _value;

    public RawValue(String v) {
        this._value = v;
    }

    public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Object obj = this._value;
        if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serialize(gen, serializers);
        } else {
            _serialize(gen);
        }
    }

    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        Object obj = this._value;
        if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serializeWithType(gen, serializers, typeSer);
        } else if (obj instanceof SerializableString) {
            serialize(gen, serializers);
        }
    }

    public void serialize(JsonGenerator gen) throws IOException {
        Object obj = this._value;
        if (obj instanceof JsonSerializable) {
            gen.writeObject(obj);
        } else {
            _serialize(gen);
        }
    }

    /* access modifiers changed from: protected */
    public void _serialize(JsonGenerator gen) throws IOException {
        Object obj = this._value;
        if (obj instanceof SerializableString) {
            gen.writeRawValue((SerializableString) obj);
        } else {
            gen.writeRawValue(String.valueOf(obj));
        }
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof RawValue)) {
            return false;
        }
        RawValue other = (RawValue) o;
        Object obj = this._value;
        Object obj2 = other._value;
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        Object obj = this._value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return String.format("[RawValue of type %s]", new Object[]{ClassUtil.classNameOf(this._value)});
    }
}
