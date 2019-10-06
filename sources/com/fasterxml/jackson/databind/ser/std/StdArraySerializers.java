package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.util.HashMap;

public class StdArraySerializers {
    protected static final HashMap<String, JsonSerializer<?>> _arraySerializers = new HashMap<>();

    @JacksonStdImpl
    public static class BooleanArraySerializer extends ArraySerializerBase<boolean[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Boolean.class);

        public BooleanArraySerializer() {
            super(boolean[].class);
        }

        protected BooleanArraySerializer(BooleanArraySerializer src, BeanProperty prop, Boolean unwrapSingle) {
            super(src, prop, unwrapSingle);
        }

        public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle) {
            return new BooleanArraySerializer(this, prop, unwrapSingle);
        }

        public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) {
            return this;
        }

        public boolean isEmpty(SerializerProvider prov, boolean[] value) {
            return value.length == 0;
        }

        public final void serialize(boolean[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            int len = value.length;
            if (len != 1 || !_shouldUnwrapSingle(provider)) {
                g.writeStartArray(len);
                g.setCurrentValue(value);
                serializeContents(value, g, provider);
                g.writeEndArray();
                return;
            }
            serializeContents(value, g, provider);
        }

        public void serializeContents(boolean[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            for (boolean writeBoolean : value) {
                g.writeBoolean(writeBoolean);
            }
        }
    }

    @JacksonStdImpl
    public static class CharArraySerializer extends StdSerializer<char[]> {
        public CharArraySerializer() {
            super(char[].class);
        }

        public boolean isEmpty(SerializerProvider prov, char[] value) {
            return value.length == 0;
        }

        public void serialize(char[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            if (provider.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                g.writeStartArray(value.length);
                g.setCurrentValue(value);
                _writeArrayContents(g, value);
                g.writeEndArray();
                return;
            }
            g.writeString(value, 0, value.length);
        }

        public void serializeWithType(char[] value, JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
            WritableTypeId typeIdDef;
            if (provider.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                typeIdDef = typeSer.writeTypePrefix(g, typeSer.typeId(value, JsonToken.START_ARRAY));
                _writeArrayContents(g, value);
            } else {
                typeIdDef = typeSer.writeTypePrefix(g, typeSer.typeId(value, JsonToken.VALUE_STRING));
                g.writeString(value, 0, value.length);
            }
            typeSer.writeTypeSuffix(g, typeIdDef);
        }

        private final void _writeArrayContents(JsonGenerator g, char[] value) throws IOException {
            int len = value.length;
            for (int i = 0; i < len; i++) {
                g.writeString(value, i, 1);
            }
        }
    }

    @JacksonStdImpl
    public static class DoubleArraySerializer extends ArraySerializerBase<double[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Double.TYPE);

        public DoubleArraySerializer() {
            super(double[].class);
        }

        protected DoubleArraySerializer(DoubleArraySerializer src, BeanProperty prop, Boolean unwrapSingle) {
            super(src, prop, unwrapSingle);
        }

        public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle) {
            return new DoubleArraySerializer(this, prop, unwrapSingle);
        }

        public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) {
            return this;
        }

        public boolean isEmpty(SerializerProvider prov, double[] value) {
            return value.length == 0;
        }

        public final void serialize(double[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            if (value.length != 1 || !_shouldUnwrapSingle(provider)) {
                g.setCurrentValue(value);
                g.writeArray(value, 0, value.length);
                return;
            }
            serializeContents(value, g, provider);
        }

        public void serializeContents(double[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            for (double writeNumber : value) {
                g.writeNumber(writeNumber);
            }
        }
    }

    @JacksonStdImpl
    public static class FloatArraySerializer extends TypedPrimitiveArraySerializer<float[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Float.TYPE);

        public FloatArraySerializer() {
            super(float[].class);
        }

        public FloatArraySerializer(FloatArraySerializer src, BeanProperty prop, Boolean unwrapSingle) {
            super(src, prop, unwrapSingle);
        }

        public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle) {
            return new FloatArraySerializer(this, prop, unwrapSingle);
        }

        public boolean isEmpty(SerializerProvider prov, float[] value) {
            return value.length == 0;
        }

        public final void serialize(float[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            int len = value.length;
            if (len != 1 || !_shouldUnwrapSingle(provider)) {
                g.writeStartArray(len);
                g.setCurrentValue(value);
                serializeContents(value, g, provider);
                g.writeEndArray();
                return;
            }
            serializeContents(value, g, provider);
        }

        public void serializeContents(float[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            for (float writeNumber : value) {
                g.writeNumber(writeNumber);
            }
        }
    }

    @JacksonStdImpl
    public static class IntArraySerializer extends ArraySerializerBase<int[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Integer.TYPE);

        public IntArraySerializer() {
            super(int[].class);
        }

        protected IntArraySerializer(IntArraySerializer src, BeanProperty prop, Boolean unwrapSingle) {
            super(src, prop, unwrapSingle);
        }

        public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle) {
            return new IntArraySerializer(this, prop, unwrapSingle);
        }

        public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) {
            return this;
        }

        public boolean isEmpty(SerializerProvider prov, int[] value) {
            return value.length == 0;
        }

        public final void serialize(int[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            if (value.length != 1 || !_shouldUnwrapSingle(provider)) {
                g.setCurrentValue(value);
                g.writeArray(value, 0, value.length);
                return;
            }
            serializeContents(value, g, provider);
        }

        public void serializeContents(int[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            for (int writeNumber : value) {
                g.writeNumber(writeNumber);
            }
        }
    }

    @JacksonStdImpl
    public static class LongArraySerializer extends TypedPrimitiveArraySerializer<long[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Long.TYPE);

        public LongArraySerializer() {
            super(long[].class);
        }

        public LongArraySerializer(LongArraySerializer src, BeanProperty prop, Boolean unwrapSingle) {
            super(src, prop, unwrapSingle);
        }

        public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle) {
            return new LongArraySerializer(this, prop, unwrapSingle);
        }

        public boolean isEmpty(SerializerProvider prov, long[] value) {
            return value.length == 0;
        }

        public final void serialize(long[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            if (value.length != 1 || !_shouldUnwrapSingle(provider)) {
                g.setCurrentValue(value);
                g.writeArray(value, 0, value.length);
                return;
            }
            serializeContents(value, g, provider);
        }

        public void serializeContents(long[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            for (long writeNumber : value) {
                g.writeNumber(writeNumber);
            }
        }
    }

    @JacksonStdImpl
    public static class ShortArraySerializer extends TypedPrimitiveArraySerializer<short[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Short.TYPE);

        public ShortArraySerializer() {
            super(short[].class);
        }

        public ShortArraySerializer(ShortArraySerializer src, BeanProperty prop, Boolean unwrapSingle) {
            super(src, prop, unwrapSingle);
        }

        public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle) {
            return new ShortArraySerializer(this, prop, unwrapSingle);
        }

        public boolean isEmpty(SerializerProvider prov, short[] value) {
            return value.length == 0;
        }

        public final void serialize(short[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            int len = value.length;
            if (len != 1 || !_shouldUnwrapSingle(provider)) {
                g.writeStartArray(len);
                g.setCurrentValue(value);
                serializeContents(value, g, provider);
                g.writeEndArray();
                return;
            }
            serializeContents(value, g, provider);
        }

        public void serializeContents(short[] value, JsonGenerator g, SerializerProvider provider) throws IOException {
            for (short writeNumber : value) {
                g.writeNumber((int) writeNumber);
            }
        }
    }

    protected static abstract class TypedPrimitiveArraySerializer<T> extends ArraySerializerBase<T> {
        protected TypedPrimitiveArraySerializer(Class<T> cls) {
            super(cls);
        }

        protected TypedPrimitiveArraySerializer(TypedPrimitiveArraySerializer<T> src, BeanProperty prop, Boolean unwrapSingle) {
            super(src, prop, unwrapSingle);
        }

        public final ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) {
            return this;
        }
    }

    static {
        _arraySerializers.put(boolean[].class.getName(), new BooleanArraySerializer());
        _arraySerializers.put(byte[].class.getName(), new ByteArraySerializer());
        _arraySerializers.put(char[].class.getName(), new CharArraySerializer());
        _arraySerializers.put(short[].class.getName(), new ShortArraySerializer());
        _arraySerializers.put(int[].class.getName(), new IntArraySerializer());
        _arraySerializers.put(long[].class.getName(), new LongArraySerializer());
        _arraySerializers.put(float[].class.getName(), new FloatArraySerializer());
        _arraySerializers.put(double[].class.getName(), new DoubleArraySerializer());
    }

    public static JsonSerializer<?> findStandardImpl(Class<?> cls) {
        return (JsonSerializer) _arraySerializers.get(cls.getName());
    }
}
