package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.p134io.NumberOutput;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class FloatNode extends NumericNode {
    protected final float _value;

    public FloatNode(float v) {
        this._value = v;
    }

    public static FloatNode valueOf(float v) {
        return new FloatNode(v);
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public String asText() {
        return NumberOutput.toString(this._value);
    }

    public final void serialize(JsonGenerator g, SerializerProvider provider) throws IOException {
        g.writeNumber(this._value);
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof FloatNode)) {
            return false;
        }
        if (Float.compare(this._value, ((FloatNode) o)._value) != 0) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Float.floatToIntBits(this._value);
    }
}
