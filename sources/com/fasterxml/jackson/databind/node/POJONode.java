package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;

public class POJONode extends ValueNode {
    protected final Object _value;

    public POJONode(Object v) {
        this._value = v;
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    public String asText() {
        Object obj = this._value;
        return obj == null ? "null" : obj.toString();
    }

    public final void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Object obj = this._value;
        if (obj == null) {
            serializers.defaultSerializeNull(gen);
        } else if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serialize(gen, serializers);
        } else {
            gen.writeObject(obj);
        }
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o != null && (o instanceof POJONode)) {
            return _pojoEquals((POJONode) o);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean _pojoEquals(POJONode other) {
        Object obj = this._value;
        if (obj != null) {
            return obj.equals(other._value);
        }
        return other._value == null;
    }

    public int hashCode() {
        return this._value.hashCode();
    }

    public String toString() {
        Object obj = this._value;
        if (obj instanceof byte[]) {
            return String.format("(binary value of %d bytes)", new Object[]{Integer.valueOf(((byte[]) obj).length)});
        } else if (!(obj instanceof RawValue)) {
            return String.valueOf(obj);
        } else {
            return String.format("(raw value '%s')", new Object[]{((RawValue) obj).toString()});
        }
    }
}
