package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsFailProvider;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.FloatBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.IntBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.LongBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.ShortBuilder;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class PrimitiveArrayDeserializers<T> extends StdDeserializer<T> implements ContextualDeserializer {
    private transient Object _emptyValue;
    protected final NullValueProvider _nuller;
    protected final Boolean _unwrapSingle;

    @JacksonStdImpl
    static final class BooleanDeser extends PrimitiveArrayDeserializers<boolean[]> {
        public BooleanDeser() {
            super(boolean[].class);
        }

        protected BooleanDeser(BooleanDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new BooleanDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public boolean[] _constructEmpty() {
            return new boolean[0];
        }

        public boolean[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            boolean value;
            if (!p.isExpectedStartArrayToken()) {
                return (boolean[]) handleNonArray(p, ctxt);
            }
            BooleanBuilder builder = ctxt.getArrayBuilders().getBooleanBuilder();
            boolean[] chunk = (boolean[]) builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken nextToken = p.nextToken();
                    JsonToken t = nextToken;
                    if (nextToken == JsonToken.END_ARRAY) {
                        return (boolean[]) builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t == JsonToken.VALUE_TRUE) {
                        value = true;
                    } else if (t == JsonToken.VALUE_FALSE) {
                        value = false;
                    } else if (t != JsonToken.VALUE_NULL) {
                        value = _parseBooleanPrimitive(p, ctxt);
                    } else if (this._nuller != null) {
                        this._nuller.getNullValue(ctxt);
                    } else {
                        _verifyNullForPrimitive(ctxt);
                        value = false;
                    }
                    if (ix >= chunk.length) {
                        chunk = (boolean[]) builder.appendCompletedChunk(chunk, ix);
                        ix = 0;
                    }
                    int ix2 = ix + 1;
                    try {
                        chunk[ix] = value;
                        ix = ix2;
                    } catch (Exception e) {
                        e = e;
                        ix = ix2;
                        throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                    }
                } catch (Exception e2) {
                    e = e2;
                    throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        public boolean[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new boolean[]{_parseBooleanPrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public boolean[] _concat(boolean[] oldValue, boolean[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            boolean[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    @JacksonStdImpl
    static final class ByteDeser extends PrimitiveArrayDeserializers<byte[]> {
        public ByteDeser() {
            super(byte[].class);
        }

        protected ByteDeser(ByteDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new ByteDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public byte[] _constructEmpty() {
            return new byte[0];
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x008f A[Catch:{ Exception -> 0x00a8 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte[] deserialize(com.fasterxml.jackson.core.JsonParser r7, com.fasterxml.jackson.databind.DeserializationContext r8) throws java.io.IOException {
            /*
                r6 = this;
                com.fasterxml.jackson.core.JsonToken r0 = r7.getCurrentToken()
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
                if (r0 != r1) goto L_0x002e
                com.fasterxml.jackson.core.Base64Variant r1 = r8.getBase64Variant()     // Catch:{ JsonParseException -> 0x0011 }
                byte[] r1 = r7.getBinaryValue(r1)     // Catch:{ JsonParseException -> 0x0011 }
                return r1
            L_0x0011:
                r1 = move-exception
                java.lang.String r2 = r1.getOriginalMessage()
                java.lang.String r3 = "base64"
                boolean r3 = r2.contains(r3)
                if (r3 == 0) goto L_0x002e
                java.lang.Class<byte[]> r3 = byte[].class
                java.lang.String r4 = r7.getText()
                r5 = 0
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.Object r3 = r8.handleWeirdStringValue(r3, r4, r2, r5)
                byte[] r3 = (byte[]) r3
                return r3
            L_0x002e:
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_EMBEDDED_OBJECT
                if (r0 != r1) goto L_0x0042
                java.lang.Object r1 = r7.getEmbeddedObject()
                if (r1 != 0) goto L_0x003a
                r2 = 0
                return r2
            L_0x003a:
                boolean r2 = r1 instanceof byte[]
                if (r2 == 0) goto L_0x0042
                r2 = r1
                byte[] r2 = (byte[]) r2
                return r2
            L_0x0042:
                boolean r1 = r7.isExpectedStartArrayToken()
                if (r1 != 0) goto L_0x004f
                java.lang.Object r1 = r6.handleNonArray(r7, r8)
                byte[] r1 = (byte[]) r1
                return r1
            L_0x004f:
                com.fasterxml.jackson.databind.util.ArrayBuilders r1 = r8.getArrayBuilders()
                com.fasterxml.jackson.databind.util.ArrayBuilders$ByteBuilder r1 = r1.getByteBuilder()
                java.lang.Object r2 = r1.resetAndStart()
                byte[] r2 = (byte[]) r2
                r3 = 0
            L_0x005e:
                com.fasterxml.jackson.core.JsonToken r4 = r7.nextToken()     // Catch:{ Exception -> 0x00a8 }
                r0 = r4
                com.fasterxml.jackson.core.JsonToken r5 = com.fasterxml.jackson.core.JsonToken.END_ARRAY     // Catch:{ Exception -> 0x00a8 }
                if (r4 == r5) goto L_0x00a0
                com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT     // Catch:{ Exception -> 0x00a8 }
                if (r0 == r4) goto L_0x0088
                com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT     // Catch:{ Exception -> 0x00a8 }
                if (r0 != r4) goto L_0x0070
                goto L_0x0088
            L_0x0070:
                com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL     // Catch:{ Exception -> 0x00a8 }
                if (r0 != r4) goto L_0x0083
                com.fasterxml.jackson.databind.deser.NullValueProvider r4 = r6._nuller     // Catch:{ Exception -> 0x00a8 }
                if (r4 == 0) goto L_0x007e
                com.fasterxml.jackson.databind.deser.NullValueProvider r4 = r6._nuller     // Catch:{ Exception -> 0x00a8 }
                r4.getNullValue(r8)     // Catch:{ Exception -> 0x00a8 }
                goto L_0x005e
            L_0x007e:
                r6._verifyNullForPrimitive(r8)     // Catch:{ Exception -> 0x00a8 }
                r4 = 0
                goto L_0x008c
            L_0x0083:
                byte r4 = r6._parseBytePrimitive(r7, r8)     // Catch:{ Exception -> 0x00a8 }
                goto L_0x008c
            L_0x0088:
                byte r4 = r7.getByteValue()     // Catch:{ Exception -> 0x00a8 }
            L_0x008c:
                int r5 = r2.length     // Catch:{ Exception -> 0x00a8 }
                if (r3 < r5) goto L_0x0097
                java.lang.Object r5 = r1.appendCompletedChunk(r2, r3)     // Catch:{ Exception -> 0x00a8 }
                byte[] r5 = (byte[]) r5     // Catch:{ Exception -> 0x00a8 }
                r2 = r5
                r3 = 0
            L_0x0097:
                int r5 = r3 + 1
                r2[r3] = r4     // Catch:{ Exception -> 0x009d }
                r3 = r5
                goto L_0x005e
            L_0x009d:
                r4 = move-exception
                r3 = r5
                goto L_0x00a9
            L_0x00a0:
                java.lang.Object r4 = r1.completeAndClearBuffer(r2, r3)
                byte[] r4 = (byte[]) r4
                return r4
            L_0x00a8:
                r4 = move-exception
            L_0x00a9:
                int r5 = r1.bufferedSize()
                int r5 = r5 + r3
                com.fasterxml.jackson.databind.JsonMappingException r5 = com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(r4, r2, r5)
                goto L_0x00b4
            L_0x00b3:
                throw r5
            L_0x00b4:
                goto L_0x00b3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.ByteDeser.deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):byte[]");
        }

        /* access modifiers changed from: protected */
        public byte[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            byte value;
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.VALUE_NUMBER_INT || t == JsonToken.VALUE_NUMBER_FLOAT) {
                value = p.getByteValue();
            } else if (t == JsonToken.VALUE_NULL) {
                NullValueProvider nullValueProvider = this._nuller;
                if (nullValueProvider != null) {
                    nullValueProvider.getNullValue(ctxt);
                    return (byte[]) getEmptyValue(ctxt);
                }
                _verifyNullForPrimitive(ctxt);
                return null;
            } else {
                value = ((Number) ctxt.handleUnexpectedToken(this._valueClass.getComponentType(), p)).byteValue();
            }
            return new byte[]{value};
        }

        /* access modifiers changed from: protected */
        public byte[] _concat(byte[] oldValue, byte[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            byte[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    @JacksonStdImpl
    static final class CharDeser extends PrimitiveArrayDeserializers<char[]> {
        public CharDeser() {
            super(char[].class);
        }

        /* access modifiers changed from: protected */
        public PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return this;
        }

        /* access modifiers changed from: protected */
        public char[] _constructEmpty() {
            return new char[0];
        }

        public char[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String str;
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.VALUE_STRING) {
                char[] buffer = p.getTextCharacters();
                int offset = p.getTextOffset();
                int len = p.getTextLength();
                char[] result = new char[len];
                System.arraycopy(buffer, offset, result, 0, len);
                return result;
            } else if (p.isExpectedStartArrayToken()) {
                StringBuilder sb = new StringBuilder(64);
                while (true) {
                    JsonToken nextToken = p.nextToken();
                    JsonToken t2 = nextToken;
                    if (nextToken == JsonToken.END_ARRAY) {
                        return sb.toString().toCharArray();
                    }
                    if (t2 == JsonToken.VALUE_STRING) {
                        str = p.getText();
                    } else if (t2 == JsonToken.VALUE_NULL) {
                        NullValueProvider nullValueProvider = this._nuller;
                        if (nullValueProvider != null) {
                            nullValueProvider.getNullValue(ctxt);
                        } else {
                            _verifyNullForPrimitive(ctxt);
                            str = "\u0000";
                        }
                    } else {
                        str = ((CharSequence) ctxt.handleUnexpectedToken(Character.TYPE, p)).toString();
                    }
                    if (str.length() == 1) {
                        sb.append(str.charAt(0));
                    } else {
                        ctxt.reportInputMismatch((JsonDeserializer<?>) this, "Cannot convert a JSON String of length %d into a char element of char array", Integer.valueOf(str.length()));
                        throw null;
                    }
                }
            } else {
                if (t == JsonToken.VALUE_EMBEDDED_OBJECT) {
                    Object ob = p.getEmbeddedObject();
                    if (ob == null) {
                        return null;
                    }
                    if (ob instanceof char[]) {
                        return (char[]) ob;
                    }
                    if (ob instanceof String) {
                        return ((String) ob).toCharArray();
                    }
                    if (ob instanceof byte[]) {
                        return Base64Variants.getDefaultVariant().encode((byte[]) ob, false).toCharArray();
                    }
                }
                return (char[]) ctxt.handleUnexpectedToken(this._valueClass, p);
            }
        }

        /* access modifiers changed from: protected */
        public char[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return (char[]) ctxt.handleUnexpectedToken(this._valueClass, p);
        }

        /* access modifiers changed from: protected */
        public char[] _concat(char[] oldValue, char[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            char[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    @JacksonStdImpl
    static final class DoubleDeser extends PrimitiveArrayDeserializers<double[]> {
        public DoubleDeser() {
            super(double[].class);
        }

        protected DoubleDeser(DoubleDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new DoubleDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public double[] _constructEmpty() {
            return new double[0];
        }

        public double[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            if (!p.isExpectedStartArrayToken()) {
                return (double[]) handleNonArray(p, ctxt);
            }
            DoubleBuilder builder = ctxt.getArrayBuilders().getDoubleBuilder();
            double[] chunk = (double[]) builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken nextToken = p.nextToken();
                    JsonToken t = nextToken;
                    if (nextToken == JsonToken.END_ARRAY) {
                        return (double[]) builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t != JsonToken.VALUE_NULL || this._nuller == null) {
                        double value = _parseDoublePrimitive(p, ctxt);
                        if (ix >= chunk.length) {
                            chunk = (double[]) builder.appendCompletedChunk(chunk, ix);
                            ix = 0;
                        }
                        int ix2 = ix + 1;
                        try {
                            chunk[ix] = value;
                            ix = ix2;
                        } catch (Exception e) {
                            int i = ix2;
                            e = e;
                            ix = i;
                            throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                        }
                    } else {
                        this._nuller.getNullValue(ctxt);
                    }
                } catch (Exception e2) {
                    e = e2;
                    throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        public double[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new double[]{_parseDoublePrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public double[] _concat(double[] oldValue, double[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            double[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    @JacksonStdImpl
    static final class FloatDeser extends PrimitiveArrayDeserializers<float[]> {
        public FloatDeser() {
            super(float[].class);
        }

        protected FloatDeser(FloatDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new FloatDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public float[] _constructEmpty() {
            return new float[0];
        }

        public float[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            if (!p.isExpectedStartArrayToken()) {
                return (float[]) handleNonArray(p, ctxt);
            }
            FloatBuilder builder = ctxt.getArrayBuilders().getFloatBuilder();
            float[] chunk = (float[]) builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken nextToken = p.nextToken();
                    JsonToken t = nextToken;
                    if (nextToken == JsonToken.END_ARRAY) {
                        return (float[]) builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t != JsonToken.VALUE_NULL || this._nuller == null) {
                        float value = _parseFloatPrimitive(p, ctxt);
                        if (ix >= chunk.length) {
                            chunk = (float[]) builder.appendCompletedChunk(chunk, ix);
                            ix = 0;
                        }
                        int ix2 = ix + 1;
                        try {
                            chunk[ix] = value;
                            ix = ix2;
                        } catch (Exception e) {
                            e = e;
                            ix = ix2;
                            throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                        }
                    } else {
                        this._nuller.getNullValue(ctxt);
                    }
                } catch (Exception e2) {
                    e = e2;
                    throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        public float[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new float[]{_parseFloatPrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public float[] _concat(float[] oldValue, float[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            float[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    @JacksonStdImpl
    static final class IntDeser extends PrimitiveArrayDeserializers<int[]> {
        public static final IntDeser instance = new IntDeser();

        public IntDeser() {
            super(int[].class);
        }

        protected IntDeser(IntDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new IntDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public int[] _constructEmpty() {
            return new int[0];
        }

        public int[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            int value;
            if (!p.isExpectedStartArrayToken()) {
                return (int[]) handleNonArray(p, ctxt);
            }
            IntBuilder builder = ctxt.getArrayBuilders().getIntBuilder();
            int[] chunk = (int[]) builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken nextToken = p.nextToken();
                    JsonToken t = nextToken;
                    if (nextToken == JsonToken.END_ARRAY) {
                        return (int[]) builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t == JsonToken.VALUE_NUMBER_INT) {
                        value = p.getIntValue();
                    } else if (t != JsonToken.VALUE_NULL) {
                        value = _parseIntPrimitive(p, ctxt);
                    } else if (this._nuller != null) {
                        this._nuller.getNullValue(ctxt);
                    } else {
                        _verifyNullForPrimitive(ctxt);
                        value = 0;
                    }
                    if (ix >= chunk.length) {
                        chunk = (int[]) builder.appendCompletedChunk(chunk, ix);
                        ix = 0;
                    }
                    int ix2 = ix + 1;
                    try {
                        chunk[ix] = value;
                        ix = ix2;
                    } catch (Exception e) {
                        e = e;
                        ix = ix2;
                        throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                    }
                } catch (Exception e2) {
                    e = e2;
                    throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        public int[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new int[]{_parseIntPrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public int[] _concat(int[] oldValue, int[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            int[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    @JacksonStdImpl
    static final class LongDeser extends PrimitiveArrayDeserializers<long[]> {
        public static final LongDeser instance = new LongDeser();

        public LongDeser() {
            super(long[].class);
        }

        protected LongDeser(LongDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new LongDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public long[] _constructEmpty() {
            return new long[0];
        }

        public long[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            long value;
            if (!p.isExpectedStartArrayToken()) {
                return (long[]) handleNonArray(p, ctxt);
            }
            LongBuilder builder = ctxt.getArrayBuilders().getLongBuilder();
            long[] chunk = (long[]) builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken nextToken = p.nextToken();
                    JsonToken t = nextToken;
                    if (nextToken == JsonToken.END_ARRAY) {
                        return (long[]) builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t == JsonToken.VALUE_NUMBER_INT) {
                        value = p.getLongValue();
                    } else if (t != JsonToken.VALUE_NULL) {
                        value = _parseLongPrimitive(p, ctxt);
                    } else if (this._nuller != null) {
                        this._nuller.getNullValue(ctxt);
                    } else {
                        _verifyNullForPrimitive(ctxt);
                        value = 0;
                    }
                    if (ix >= chunk.length) {
                        chunk = (long[]) builder.appendCompletedChunk(chunk, ix);
                        ix = 0;
                    }
                    int ix2 = ix + 1;
                    try {
                        chunk[ix] = value;
                        ix = ix2;
                    } catch (Exception e) {
                        int i = ix2;
                        e = e;
                        ix = i;
                        throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                    }
                } catch (Exception e2) {
                    e = e2;
                    throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        public long[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new long[]{_parseLongPrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public long[] _concat(long[] oldValue, long[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            long[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    @JacksonStdImpl
    static final class ShortDeser extends PrimitiveArrayDeserializers<short[]> {
        public ShortDeser() {
            super(short[].class);
        }

        protected ShortDeser(ShortDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new ShortDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        public short[] _constructEmpty() {
            return new short[0];
        }

        public short[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            short value;
            if (!p.isExpectedStartArrayToken()) {
                return (short[]) handleNonArray(p, ctxt);
            }
            ShortBuilder builder = ctxt.getArrayBuilders().getShortBuilder();
            short[] chunk = (short[]) builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken nextToken = p.nextToken();
                    JsonToken t = nextToken;
                    if (nextToken == JsonToken.END_ARRAY) {
                        return (short[]) builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t != JsonToken.VALUE_NULL) {
                        value = _parseShortPrimitive(p, ctxt);
                    } else if (this._nuller != null) {
                        this._nuller.getNullValue(ctxt);
                    } else {
                        _verifyNullForPrimitive(ctxt);
                        value = 0;
                    }
                    if (ix >= chunk.length) {
                        chunk = (short[]) builder.appendCompletedChunk(chunk, ix);
                        ix = 0;
                    }
                    int ix2 = ix + 1;
                    try {
                        chunk[ix] = value;
                        ix = ix2;
                    } catch (Exception e) {
                        e = e;
                        ix = ix2;
                        throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                    }
                } catch (Exception e2) {
                    e = e2;
                    throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        public short[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new short[]{_parseShortPrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public short[] _concat(short[] oldValue, short[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            short[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    /* access modifiers changed from: protected */
    public abstract T _concat(T t, T t2);

    /* access modifiers changed from: protected */
    public abstract T _constructEmpty();

    /* access modifiers changed from: protected */
    public abstract T handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    /* access modifiers changed from: protected */
    public abstract PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nullValueProvider, Boolean bool);

    protected PrimitiveArrayDeserializers(Class<T> cls) {
        super(cls);
        this._unwrapSingle = null;
        this._nuller = null;
    }

    protected PrimitiveArrayDeserializers(PrimitiveArrayDeserializers<?> base, NullValueProvider nuller, Boolean unwrapSingle) {
        super(base._valueClass);
        this._unwrapSingle = unwrapSingle;
        this._nuller = nuller;
    }

    public static JsonDeserializer<?> forType(Class<?> rawType) {
        if (rawType == Integer.TYPE) {
            return IntDeser.instance;
        }
        if (rawType == Long.TYPE) {
            return LongDeser.instance;
        }
        if (rawType == Byte.TYPE) {
            return new ByteDeser();
        }
        if (rawType == Short.TYPE) {
            return new ShortDeser();
        }
        if (rawType == Float.TYPE) {
            return new FloatDeser();
        }
        if (rawType == Double.TYPE) {
            return new DoubleDeser();
        }
        if (rawType == Boolean.TYPE) {
            return new BooleanDeser();
        }
        if (rawType == Character.TYPE) {
            return new CharDeser();
        }
        throw new IllegalStateException();
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        Boolean unwrapSingle = findFormatFeature(ctxt, property, this._valueClass, Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        NullValueProvider nuller = null;
        Nulls nullStyle = findContentNullStyle(ctxt, property);
        if (nullStyle == Nulls.SKIP) {
            nuller = NullsConstantProvider.skipper();
        } else if (nullStyle == Nulls.FAIL) {
            if (property == null) {
                nuller = NullsFailProvider.constructForRootValue(ctxt.constructType(this._valueClass));
            } else {
                nuller = NullsFailProvider.constructForProperty(property);
            }
        }
        if (unwrapSingle == this._unwrapSingle && nuller == this._nuller) {
            return this;
        }
        return withResolved(nuller, unwrapSingle);
    }

    public Boolean supportsUpdate(DeserializationConfig config) {
        return Boolean.TRUE;
    }

    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        Object empty = this._emptyValue;
        if (empty != null) {
            return empty;
        }
        Object _constructEmpty = _constructEmpty();
        Object empty2 = _constructEmpty;
        this._emptyValue = _constructEmpty;
        return empty2;
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromArray(p, ctxt);
    }

    public T deserialize(JsonParser p, DeserializationContext ctxt, T existing) throws IOException {
        T newValue = deserialize(p, ctxt);
        if (existing == null || Array.getLength(existing) == 0) {
            return newValue;
        }
        return _concat(existing, newValue);
    }

    /* access modifiers changed from: protected */
    public T handleNonArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_STRING) && ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && p.getText().length() == 0) {
            return null;
        }
        Boolean bool = this._unwrapSingle;
        if (bool == Boolean.TRUE || (bool == null && ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return handleSingleElementUnwrapped(p, ctxt);
        }
        return ctxt.handleUnexpectedToken(this._valueClass, p);
    }
}
