package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;

@JacksonStdImpl
public final class BooleanSerializer extends StdScalarSerializer<Object> implements ContextualSerializer {
    protected final boolean _forPrimitive;

    static final class AsNumber extends StdScalarSerializer<Object> implements ContextualSerializer {
        protected final boolean _forPrimitive;

        public AsNumber(boolean forPrimitive) {
            super(forPrimitive ? Boolean.TYPE : Boolean.class, false);
            this._forPrimitive = forPrimitive;
        }

        public void serialize(Object value, JsonGenerator g, SerializerProvider provider) throws IOException {
            g.writeNumber(Boolean.FALSE.equals(value) ^ true ? 1 : 0);
        }

        public final void serializeWithType(Object value, JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
            g.writeBoolean(Boolean.TRUE.equals(value));
        }

        public JsonSerializer<?> createContextual(SerializerProvider serializers, BeanProperty property) throws JsonMappingException {
            Value format = findFormatOverrides(serializers, property, Boolean.class);
            if (format == null || format.getShape().isNumeric()) {
                return this;
            }
            return new BooleanSerializer(this._forPrimitive);
        }
    }

    public BooleanSerializer(boolean forPrimitive) {
        super(forPrimitive ? Boolean.TYPE : Boolean.class, false);
        this._forPrimitive = forPrimitive;
    }

    public JsonSerializer<?> createContextual(SerializerProvider serializers, BeanProperty property) throws JsonMappingException {
        Value format = findFormatOverrides(serializers, property, Boolean.class);
        if (format == null || !format.getShape().isNumeric()) {
            return this;
        }
        return new AsNumber(this._forPrimitive);
    }

    public void serialize(Object value, JsonGenerator g, SerializerProvider provider) throws IOException {
        g.writeBoolean(Boolean.TRUE.equals(value));
    }

    public final void serializeWithType(Object value, JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        g.writeBoolean(Boolean.TRUE.equals(value));
    }
}
