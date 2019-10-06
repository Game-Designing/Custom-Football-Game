package com.fasterxml.jackson.databind.deser.std;

import android.support.p001v7.widget.LinearLayoutManager;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.p134io.NumberInput;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;

public class NumberDeserializers {
    private static final HashSet<String> _classNames = new HashSet<>();

    /* renamed from: com.fasterxml.jackson.databind.deser.std.NumberDeserializers$1 */
    static /* synthetic */ class C68211 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType = new int[NumberType.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[NumberType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[NumberType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[NumberType.BIG_INTEGER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @JacksonStdImpl
    public static class BigDecimalDeserializer extends StdScalarDeserializer<BigDecimal> {
        public static final BigDecimalDeserializer instance = new BigDecimalDeserializer();

        public BigDecimalDeserializer() {
            super(BigDecimal.class);
        }

        public Object getEmptyValue(DeserializationContext ctxt) {
            return BigDecimal.ZERO;
        }

        public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            int currentTokenId = p.getCurrentTokenId();
            if (currentTokenId == 3) {
                return (BigDecimal) _deserializeFromArray(p, ctxt);
            }
            if (currentTokenId != 6) {
                return (currentTokenId == 7 || currentTokenId == 8) ? p.getDecimalValue() : (BigDecimal) ctxt.handleUnexpectedToken(this._valueClass, p);
            }
            String text = p.getText().trim();
            if (_isEmptyOrTextualNull(text)) {
                _verifyNullForScalarCoercion(ctxt, text);
                return (BigDecimal) getNullValue(ctxt);
            }
            _verifyStringForScalarCoercion(ctxt, text);
            try {
                return new BigDecimal(text);
            } catch (IllegalArgumentException e) {
                return (BigDecimal) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid representation", new Object[0]);
            }
        }
    }

    @JacksonStdImpl
    public static class BigIntegerDeserializer extends StdScalarDeserializer<BigInteger> {
        public static final BigIntegerDeserializer instance = new BigIntegerDeserializer();

        public BigIntegerDeserializer() {
            super(BigInteger.class);
        }

        public Object getEmptyValue(DeserializationContext ctxt) {
            return BigInteger.ZERO;
        }

        public BigInteger deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            int currentTokenId = p.getCurrentTokenId();
            if (currentTokenId == 3) {
                return (BigInteger) _deserializeFromArray(p, ctxt);
            }
            if (currentTokenId != 6) {
                if (currentTokenId == 7) {
                    int i = C68211.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[p.getNumberType().ordinal()];
                    if (i == 1 || i == 2 || i == 3) {
                        return p.getBigIntegerValue();
                    }
                } else if (currentTokenId == 8) {
                    if (ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                        return p.getDecimalValue().toBigInteger();
                    }
                    _failDoubleToIntCoercion(p, ctxt, "java.math.BigInteger");
                    throw null;
                }
                return (BigInteger) ctxt.handleUnexpectedToken(this._valueClass, p);
            }
            String text = p.getText().trim();
            if (_isEmptyOrTextualNull(text)) {
                _verifyNullForScalarCoercion(ctxt, text);
                return (BigInteger) getNullValue(ctxt);
            }
            _verifyStringForScalarCoercion(ctxt, text);
            try {
                return new BigInteger(text);
            } catch (IllegalArgumentException e) {
                return (BigInteger) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid representation", new Object[0]);
            }
        }
    }

    @JacksonStdImpl
    public static final class BooleanDeserializer extends PrimitiveOrWrapperDeserializer<Boolean> {
        static final BooleanDeserializer primitiveInstance = new BooleanDeserializer(Boolean.TYPE, Boolean.FALSE);
        static final BooleanDeserializer wrapperInstance = new BooleanDeserializer(Boolean.class, null);

        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext x0) throws JsonMappingException {
            return super.getEmptyValue(x0);
        }

        public BooleanDeserializer(Class<Boolean> cls, Boolean nvl) {
            super(cls, nvl, Boolean.FALSE);
        }

        public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (t == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            return _parseBoolean(p, ctxt);
        }

        public Boolean deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (t == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            return _parseBoolean(p, ctxt);
        }

        /* access modifiers changed from: protected */
        public final Boolean _parseBoolean(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.VALUE_NULL) {
                return (Boolean) _coerceNullToken(ctxt, this._primitive);
            }
            if (t == JsonToken.START_ARRAY) {
                return (Boolean) _deserializeFromArray(p, ctxt);
            }
            if (t == JsonToken.VALUE_NUMBER_INT) {
                return Boolean.valueOf(_parseBooleanFromInt(p, ctxt));
            }
            if (t == JsonToken.VALUE_STRING) {
                String text = p.getText().trim();
                if ("true".equals(text) || "True".equals(text)) {
                    _verifyStringForScalarCoercion(ctxt, text);
                    return Boolean.TRUE;
                } else if (AdultContentAnalytics.UNLOCK.equals(text) || "False".equals(text)) {
                    _verifyStringForScalarCoercion(ctxt, text);
                    return Boolean.FALSE;
                } else if (text.length() == 0) {
                    return (Boolean) _coerceEmptyString(ctxt, this._primitive);
                } else {
                    if (_hasTextualNull(text)) {
                        return (Boolean) _coerceTextualNull(ctxt, this._primitive);
                    }
                    return (Boolean) ctxt.handleWeirdStringValue(this._valueClass, text, "only \"true\" or \"false\" recognized", new Object[0]);
                }
            } else if (t == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            } else {
                if (t == JsonToken.VALUE_FALSE) {
                    return Boolean.FALSE;
                }
                return (Boolean) ctxt.handleUnexpectedToken(this._valueClass, p);
            }
        }
    }

    @JacksonStdImpl
    public static class ByteDeserializer extends PrimitiveOrWrapperDeserializer<Byte> {
        static final ByteDeserializer primitiveInstance = new ByteDeserializer(Byte.TYPE, Byte.valueOf(0));
        static final ByteDeserializer wrapperInstance = new ByteDeserializer(Byte.class, null);

        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext x0) throws JsonMappingException {
            return super.getEmptyValue(x0);
        }

        public ByteDeserializer(Class<Byte> cls, Byte nvl) {
            super(cls, nvl, Byte.valueOf(0));
        }

        public Byte deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
                return Byte.valueOf(p.getByteValue());
            }
            return _parseByte(p, ctxt);
        }

        /* access modifiers changed from: protected */
        public Byte _parseByte(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.VALUE_STRING) {
                String text = p.getText().trim();
                if (_hasTextualNull(text)) {
                    return (Byte) _coerceTextualNull(ctxt, this._primitive);
                }
                if (text.length() == 0) {
                    return (Byte) _coerceEmptyString(ctxt, this._primitive);
                }
                _verifyStringForScalarCoercion(ctxt, text);
                try {
                    int value = NumberInput.parseInt(text);
                    if (!_byteOverflow(value)) {
                        return Byte.valueOf((byte) value);
                    }
                    return (Byte) ctxt.handleWeirdStringValue(this._valueClass, text, "overflow, value cannot be represented as 8-bit value", new Object[0]);
                } catch (IllegalArgumentException e) {
                    return (Byte) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid Byte value", new Object[0]);
                }
            } else if (t == JsonToken.VALUE_NUMBER_FLOAT) {
                if (ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                    return Byte.valueOf(p.getByteValue());
                }
                _failDoubleToIntCoercion(p, ctxt, "Byte");
                throw null;
            } else if (t == JsonToken.VALUE_NULL) {
                return (Byte) _coerceNullToken(ctxt, this._primitive);
            } else {
                if (t == JsonToken.START_ARRAY) {
                    return (Byte) _deserializeFromArray(p, ctxt);
                }
                if (t == JsonToken.VALUE_NUMBER_INT) {
                    return Byte.valueOf(p.getByteValue());
                }
                return (Byte) ctxt.handleUnexpectedToken(this._valueClass, p);
            }
        }
    }

    @JacksonStdImpl
    public static class CharacterDeserializer extends PrimitiveOrWrapperDeserializer<Character> {
        static final CharacterDeserializer primitiveInstance = new CharacterDeserializer(Character.TYPE, Character.valueOf(0));
        static final CharacterDeserializer wrapperInstance = new CharacterDeserializer(Character.class, null);

        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext x0) throws JsonMappingException {
            return super.getEmptyValue(x0);
        }

        public CharacterDeserializer(Class<Character> cls, Character nvl) {
            super(cls, nvl, Character.valueOf(0));
        }

        public Character deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            int currentTokenId = p.getCurrentTokenId();
            if (currentTokenId == 3) {
                return (Character) _deserializeFromArray(p, ctxt);
            }
            if (currentTokenId == 11) {
                return (Character) _coerceNullToken(ctxt, this._primitive);
            }
            if (currentTokenId == 6) {
                String text = p.getText();
                if (text.length() == 1) {
                    return Character.valueOf(text.charAt(0));
                }
                if (text.length() == 0) {
                    return (Character) _coerceEmptyString(ctxt, this._primitive);
                }
            } else if (currentTokenId == 7) {
                _verifyNumberForScalarCoercion(ctxt, p);
                int value = p.getIntValue();
                if (value >= 0 && value <= 65535) {
                    return Character.valueOf((char) value);
                }
            }
            return (Character) ctxt.handleUnexpectedToken(this._valueClass, p);
        }
    }

    @JacksonStdImpl
    public static class DoubleDeserializer extends PrimitiveOrWrapperDeserializer<Double> {
        static final DoubleDeserializer primitiveInstance = new DoubleDeserializer(Double.TYPE, Double.valueOf(0.0d));
        static final DoubleDeserializer wrapperInstance = new DoubleDeserializer(Double.class, null);

        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext x0) throws JsonMappingException {
            return super.getEmptyValue(x0);
        }

        public DoubleDeserializer(Class<Double> cls, Double nvl) {
            super(cls, nvl, Double.valueOf(0.0d));
        }

        public Double deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return _parseDouble(p, ctxt);
        }

        public Double deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
            return _parseDouble(p, ctxt);
        }

        /* access modifiers changed from: protected */
        public final Double _parseDouble(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.VALUE_NUMBER_INT || t == JsonToken.VALUE_NUMBER_FLOAT) {
                return Double.valueOf(p.getDoubleValue());
            }
            if (t == JsonToken.VALUE_STRING) {
                String text = p.getText().trim();
                if (text.length() == 0) {
                    return (Double) _coerceEmptyString(ctxt, this._primitive);
                }
                if (_hasTextualNull(text)) {
                    return (Double) _coerceTextualNull(ctxt, this._primitive);
                }
                char charAt = text.charAt(0);
                if (charAt != '-') {
                    if (charAt != 'I') {
                        if (charAt == 'N' && _isNaN(text)) {
                            return Double.valueOf(Double.NaN);
                        }
                    } else if (_isPosInf(text)) {
                        return Double.valueOf(Double.POSITIVE_INFINITY);
                    }
                } else if (_isNegInf(text)) {
                    return Double.valueOf(Double.NEGATIVE_INFINITY);
                }
                _verifyStringForScalarCoercion(ctxt, text);
                try {
                    return Double.valueOf(StdDeserializer.parseDouble(text));
                } catch (IllegalArgumentException e) {
                    return (Double) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid Double value", new Object[0]);
                }
            } else if (t == JsonToken.VALUE_NULL) {
                return (Double) _coerceNullToken(ctxt, this._primitive);
            } else {
                if (t == JsonToken.START_ARRAY) {
                    return (Double) _deserializeFromArray(p, ctxt);
                }
                return (Double) ctxt.handleUnexpectedToken(this._valueClass, p);
            }
        }
    }

    @JacksonStdImpl
    public static class FloatDeserializer extends PrimitiveOrWrapperDeserializer<Float> {
        static final FloatDeserializer primitiveInstance = new FloatDeserializer(Float.TYPE, Float.valueOf(0.0f));
        static final FloatDeserializer wrapperInstance = new FloatDeserializer(Float.class, null);

        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext x0) throws JsonMappingException {
            return super.getEmptyValue(x0);
        }

        public FloatDeserializer(Class<Float> cls, Float nvl) {
            super(cls, nvl, Float.valueOf(0.0f));
        }

        public Float deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return _parseFloat(p, ctxt);
        }

        /* access modifiers changed from: protected */
        public final Float _parseFloat(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.VALUE_NUMBER_FLOAT || t == JsonToken.VALUE_NUMBER_INT) {
                return Float.valueOf(p.getFloatValue());
            }
            if (t == JsonToken.VALUE_STRING) {
                String text = p.getText().trim();
                if (text.length() == 0) {
                    return (Float) _coerceEmptyString(ctxt, this._primitive);
                }
                if (_hasTextualNull(text)) {
                    return (Float) _coerceTextualNull(ctxt, this._primitive);
                }
                char charAt = text.charAt(0);
                if (charAt != '-') {
                    if (charAt != 'I') {
                        if (charAt == 'N' && _isNaN(text)) {
                            return Float.valueOf(Float.NaN);
                        }
                    } else if (_isPosInf(text)) {
                        return Float.valueOf(Float.POSITIVE_INFINITY);
                    }
                } else if (_isNegInf(text)) {
                    return Float.valueOf(Float.NEGATIVE_INFINITY);
                }
                _verifyStringForScalarCoercion(ctxt, text);
                try {
                    return Float.valueOf(Float.parseFloat(text));
                } catch (IllegalArgumentException e) {
                    return (Float) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid Float value", new Object[0]);
                }
            } else if (t == JsonToken.VALUE_NULL) {
                return (Float) _coerceNullToken(ctxt, this._primitive);
            } else {
                if (t == JsonToken.START_ARRAY) {
                    return (Float) _deserializeFromArray(p, ctxt);
                }
                return (Float) ctxt.handleUnexpectedToken(this._valueClass, p);
            }
        }
    }

    @JacksonStdImpl
    public static final class IntegerDeserializer extends PrimitiveOrWrapperDeserializer<Integer> {
        static final IntegerDeserializer primitiveInstance = new IntegerDeserializer(Integer.TYPE, Integer.valueOf(0));
        static final IntegerDeserializer wrapperInstance = new IntegerDeserializer(Integer.class, null);

        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext x0) throws JsonMappingException {
            return super.getEmptyValue(x0);
        }

        public IntegerDeserializer(Class<Integer> cls, Integer nvl) {
            super(cls, nvl, Integer.valueOf(0));
        }

        public boolean isCachable() {
            return true;
        }

        public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
                return Integer.valueOf(p.getIntValue());
            }
            return _parseInteger(p, ctxt);
        }

        public Integer deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
            if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
                return Integer.valueOf(p.getIntValue());
            }
            return _parseInteger(p, ctxt);
        }

        /* access modifiers changed from: protected */
        public final Integer _parseInteger(JsonParser p, DeserializationContext ctxt) throws IOException {
            int currentTokenId = p.getCurrentTokenId();
            if (currentTokenId == 3) {
                return (Integer) _deserializeFromArray(p, ctxt);
            }
            if (currentTokenId == 11) {
                return (Integer) _coerceNullToken(ctxt, this._primitive);
            }
            if (currentTokenId == 6) {
                String text = p.getText().trim();
                int len = text.length();
                if (len == 0) {
                    return (Integer) _coerceEmptyString(ctxt, this._primitive);
                }
                if (_hasTextualNull(text)) {
                    return (Integer) _coerceTextualNull(ctxt, this._primitive);
                }
                _verifyStringForScalarCoercion(ctxt, text);
                if (len <= 9) {
                    return Integer.valueOf(NumberInput.parseInt(text));
                }
                try {
                    long l = Long.parseLong(text);
                    if (!_intOverflow(l)) {
                        return Integer.valueOf((int) l);
                    }
                    return (Integer) ctxt.handleWeirdStringValue(this._valueClass, text, String.format("Overflow: numeric value (%s) out of range of Integer (%d - %d)", new Object[]{text, Integer.valueOf(LinearLayoutManager.INVALID_OFFSET), Integer.valueOf(MoPubClientPositioning.NO_REPEAT)}), new Object[0]);
                } catch (IllegalArgumentException e) {
                    return (Integer) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid Integer value", new Object[0]);
                }
            } else if (currentTokenId == 7) {
                return Integer.valueOf(p.getIntValue());
            } else {
                if (currentTokenId != 8) {
                    return (Integer) ctxt.handleUnexpectedToken(this._valueClass, p);
                }
                if (ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                    return Integer.valueOf(p.getValueAsInt());
                }
                _failDoubleToIntCoercion(p, ctxt, "Integer");
                throw null;
            }
        }
    }

    @JacksonStdImpl
    public static final class LongDeserializer extends PrimitiveOrWrapperDeserializer<Long> {
        static final LongDeserializer primitiveInstance = new LongDeserializer(Long.TYPE, Long.valueOf(0));
        static final LongDeserializer wrapperInstance = new LongDeserializer(Long.class, null);

        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext x0) throws JsonMappingException {
            return super.getEmptyValue(x0);
        }

        public LongDeserializer(Class<Long> cls, Long nvl) {
            super(cls, nvl, Long.valueOf(0));
        }

        public boolean isCachable() {
            return true;
        }

        public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
                return Long.valueOf(p.getLongValue());
            }
            return _parseLong(p, ctxt);
        }

        /* access modifiers changed from: protected */
        public final Long _parseLong(JsonParser p, DeserializationContext ctxt) throws IOException {
            int currentTokenId = p.getCurrentTokenId();
            if (currentTokenId == 3) {
                return (Long) _deserializeFromArray(p, ctxt);
            }
            if (currentTokenId == 11) {
                return (Long) _coerceNullToken(ctxt, this._primitive);
            }
            if (currentTokenId == 6) {
                String text = p.getText().trim();
                if (text.length() == 0) {
                    return (Long) _coerceEmptyString(ctxt, this._primitive);
                }
                if (_hasTextualNull(text)) {
                    return (Long) _coerceTextualNull(ctxt, this._primitive);
                }
                _verifyStringForScalarCoercion(ctxt, text);
                try {
                    return Long.valueOf(NumberInput.parseLong(text));
                } catch (IllegalArgumentException e) {
                    return (Long) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid Long value", new Object[0]);
                }
            } else if (currentTokenId == 7) {
                return Long.valueOf(p.getLongValue());
            } else {
                if (currentTokenId != 8) {
                    return (Long) ctxt.handleUnexpectedToken(this._valueClass, p);
                }
                if (ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                    return Long.valueOf(p.getValueAsLong());
                }
                _failDoubleToIntCoercion(p, ctxt, "Long");
                throw null;
            }
        }
    }

    @JacksonStdImpl
    public static class NumberDeserializer extends StdScalarDeserializer<Object> {
        public static final NumberDeserializer instance = new NumberDeserializer();

        public NumberDeserializer() {
            super(Number.class);
        }

        public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            int currentTokenId = p.getCurrentTokenId();
            if (currentTokenId == 3) {
                return _deserializeFromArray(p, ctxt);
            }
            if (currentTokenId == 6) {
                String text = p.getText().trim();
                if (text.length() == 0) {
                    return getNullValue(ctxt);
                }
                if (_hasTextualNull(text)) {
                    return getNullValue(ctxt);
                }
                if (_isPosInf(text)) {
                    return Double.valueOf(Double.POSITIVE_INFINITY);
                }
                if (_isNegInf(text)) {
                    return Double.valueOf(Double.NEGATIVE_INFINITY);
                }
                if (_isNaN(text)) {
                    return Double.valueOf(Double.NaN);
                }
                _verifyStringForScalarCoercion(ctxt, text);
                try {
                    if (!_isIntNumber(text)) {
                        if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                            return new BigDecimal(text);
                        }
                        return Double.valueOf(text);
                    } else if (ctxt.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                        return new BigInteger(text);
                    } else {
                        long value = Long.parseLong(text);
                        if (ctxt.isEnabled(DeserializationFeature.USE_LONG_FOR_INTS) || value > 2147483647L || value < -2147483648L) {
                            return Long.valueOf(value);
                        }
                        return Integer.valueOf((int) value);
                    }
                } catch (IllegalArgumentException e) {
                    return ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid number", new Object[0]);
                }
            } else if (currentTokenId != 7) {
                if (currentTokenId != 8) {
                    return ctxt.handleUnexpectedToken(this._valueClass, p);
                }
                if (!ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) || p.isNaN()) {
                    return p.getNumberValue();
                }
                return p.getDecimalValue();
            } else if (ctxt.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS)) {
                return _coerceIntegral(p, ctxt);
            } else {
                return p.getNumberValue();
            }
        }

        public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
            int currentTokenId = p.getCurrentTokenId();
            if (currentTokenId == 6 || currentTokenId == 7 || currentTokenId == 8) {
                return deserialize(p, ctxt);
            }
            return typeDeserializer.deserializeTypedFromScalar(p, ctxt);
        }
    }

    protected static abstract class PrimitiveOrWrapperDeserializer<T> extends StdScalarDeserializer<T> {
        protected final T _emptyValue;
        protected final T _nullValue;
        protected final boolean _primitive;

        protected PrimitiveOrWrapperDeserializer(Class<T> vc, T nvl, T empty) {
            super(vc);
            this._nullValue = nvl;
            this._emptyValue = empty;
            this._primitive = vc.isPrimitive();
        }

        public final T getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            if (!this._primitive || !ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
                return this._nullValue;
            }
            ctxt.reportInputMismatch((JsonDeserializer<?>) this, "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", handledType().toString());
            throw null;
        }

        public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
            return this._emptyValue;
        }
    }

    @JacksonStdImpl
    public static class ShortDeserializer extends PrimitiveOrWrapperDeserializer<Short> {
        static final ShortDeserializer primitiveInstance = new ShortDeserializer(Short.TYPE, Short.valueOf(0));
        static final ShortDeserializer wrapperInstance = new ShortDeserializer(Short.class, null);

        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext x0) throws JsonMappingException {
            return super.getEmptyValue(x0);
        }

        public ShortDeserializer(Class<Short> cls, Short nvl) {
            super(cls, nvl, Short.valueOf(0));
        }

        public Short deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return _parseShort(p, ctxt);
        }

        /* access modifiers changed from: protected */
        public Short _parseShort(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.VALUE_NUMBER_INT) {
                return Short.valueOf(p.getShortValue());
            }
            if (t == JsonToken.VALUE_STRING) {
                String text = p.getText().trim();
                if (text.length() == 0) {
                    return (Short) _coerceEmptyString(ctxt, this._primitive);
                }
                if (_hasTextualNull(text)) {
                    return (Short) _coerceTextualNull(ctxt, this._primitive);
                }
                _verifyStringForScalarCoercion(ctxt, text);
                try {
                    int value = NumberInput.parseInt(text);
                    if (!_shortOverflow(value)) {
                        return Short.valueOf((short) value);
                    }
                    return (Short) ctxt.handleWeirdStringValue(this._valueClass, text, "overflow, value cannot be represented as 16-bit value", new Object[0]);
                } catch (IllegalArgumentException e) {
                    return (Short) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid Short value", new Object[0]);
                }
            } else if (t == JsonToken.VALUE_NUMBER_FLOAT) {
                if (ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                    return Short.valueOf(p.getShortValue());
                }
                _failDoubleToIntCoercion(p, ctxt, "Short");
                throw null;
            } else if (t == JsonToken.VALUE_NULL) {
                return (Short) _coerceNullToken(ctxt, this._primitive);
            } else {
                if (t == JsonToken.START_ARRAY) {
                    return (Short) _deserializeFromArray(p, ctxt);
                }
                return (Short) ctxt.handleUnexpectedToken(this._valueClass, p);
            }
        }
    }

    static {
        for (Class name : new Class[]{Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class}) {
            _classNames.add(name.getName());
        }
    }

    public static JsonDeserializer<?> find(Class<?> rawType, String clsName) {
        if (rawType.isPrimitive()) {
            if (rawType == Integer.TYPE) {
                return IntegerDeserializer.primitiveInstance;
            }
            if (rawType == Boolean.TYPE) {
                return BooleanDeserializer.primitiveInstance;
            }
            if (rawType == Long.TYPE) {
                return LongDeserializer.primitiveInstance;
            }
            if (rawType == Double.TYPE) {
                return DoubleDeserializer.primitiveInstance;
            }
            if (rawType == Character.TYPE) {
                return CharacterDeserializer.primitiveInstance;
            }
            if (rawType == Byte.TYPE) {
                return ByteDeserializer.primitiveInstance;
            }
            if (rawType == Short.TYPE) {
                return ShortDeserializer.primitiveInstance;
            }
            if (rawType == Float.TYPE) {
                return FloatDeserializer.primitiveInstance;
            }
        } else if (!_classNames.contains(clsName)) {
            return null;
        } else {
            if (rawType == Integer.class) {
                return IntegerDeserializer.wrapperInstance;
            }
            if (rawType == Boolean.class) {
                return BooleanDeserializer.wrapperInstance;
            }
            if (rawType == Long.class) {
                return LongDeserializer.wrapperInstance;
            }
            if (rawType == Double.class) {
                return DoubleDeserializer.wrapperInstance;
            }
            if (rawType == Character.class) {
                return CharacterDeserializer.wrapperInstance;
            }
            if (rawType == Byte.class) {
                return ByteDeserializer.wrapperInstance;
            }
            if (rawType == Short.class) {
                return ShortDeserializer.wrapperInstance;
            }
            if (rawType == Float.class) {
                return FloatDeserializer.wrapperInstance;
            }
            if (rawType == Number.class) {
                return NumberDeserializer.instance;
            }
            if (rawType == BigDecimal.class) {
                return BigDecimalDeserializer.instance;
            }
            if (rawType == BigInteger.class) {
                return BigIntegerDeserializer.instance;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Internal error: can't find deserializer for ");
        sb.append(rawType.getName());
        throw new IllegalArgumentException(sb.toString());
    }
}
