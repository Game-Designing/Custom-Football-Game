package com.fasterxml.jackson.databind.deser.std;

import android.support.p001v7.widget.LinearLayoutManager;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.p134io.NumberInput;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.NullsAsEmptyProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsFailProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;

public abstract class StdDeserializer<T> extends JsonDeserializer<T> implements Serializable {
    protected static final int F_MASK_ACCEPT_ARRAYS = (DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS.getMask() | DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.getMask());
    protected static final int F_MASK_INT_COERCIONS = (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.getMask() | DeserializationFeature.USE_LONG_FOR_INTS.getMask());
    protected final Class<?> _valueClass;

    protected StdDeserializer(Class<?> vc) {
        this._valueClass = vc;
    }

    protected StdDeserializer(JavaType valueType) {
        this._valueClass = valueType == null ? Object.class : valueType.getRawClass();
    }

    protected StdDeserializer(StdDeserializer<?> src) {
        this._valueClass = src._valueClass;
    }

    public Class<?> handledType() {
        return this._valueClass;
    }

    public JavaType getValueType() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isDefaultDeserializer(JsonDeserializer<?> deserializer) {
        return ClassUtil.isJacksonStdImpl((Object) deserializer);
    }

    /* access modifiers changed from: protected */
    public boolean isDefaultKeyDeserializer(KeyDeserializer keyDeser) {
        return ClassUtil.isJacksonStdImpl((Object) keyDeser);
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(p, ctxt);
    }

    /* access modifiers changed from: protected */
    public final boolean _parseBooleanPrimitive(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (t == JsonToken.VALUE_FALSE) {
            return false;
        }
        if (t == JsonToken.VALUE_NULL) {
            _verifyNullForPrimitive(ctxt);
            return false;
        } else if (t == JsonToken.VALUE_NUMBER_INT) {
            return _parseBooleanFromInt(p, ctxt);
        } else {
            if (t == JsonToken.VALUE_STRING) {
                String text = p.getText().trim();
                if ("true".equals(text) || "True".equals(text)) {
                    return true;
                }
                if (AdultContentAnalytics.UNLOCK.equals(text) || "False".equals(text)) {
                    return false;
                }
                if (_isEmptyOrTextualNull(text)) {
                    _verifyNullForPrimitiveCoercion(ctxt, text);
                    return false;
                }
                return Boolean.TRUE.equals((Boolean) ctxt.handleWeirdStringValue(this._valueClass, text, "only \"true\" or \"false\" recognized", new Object[0]));
            } else if (t != JsonToken.START_ARRAY || !ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                return ((Boolean) ctxt.handleUnexpectedToken(this._valueClass, p)).booleanValue();
            } else {
                p.nextToken();
                boolean parsed = _parseBooleanPrimitive(p, ctxt);
                _verifyEndArrayForSingle(p, ctxt);
                return parsed;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean _parseBooleanFromInt(JsonParser p, DeserializationContext ctxt) throws IOException {
        _verifyNumberForScalarCoercion(ctxt, p);
        return !BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID.equals(p.getText());
    }

    /* access modifiers changed from: protected */
    public final byte _parseBytePrimitive(JsonParser p, DeserializationContext ctxt) throws IOException {
        int value = _parseIntPrimitive(p, ctxt);
        if (!_byteOverflow(value)) {
            return (byte) value;
        }
        return _nonNullNumber((Number) ctxt.handleWeirdStringValue(this._valueClass, String.valueOf(value), "overflow, value cannot be represented as 8-bit value", new Object[0])).byteValue();
    }

    /* access modifiers changed from: protected */
    public final short _parseShortPrimitive(JsonParser p, DeserializationContext ctxt) throws IOException {
        int value = _parseIntPrimitive(p, ctxt);
        if (!_shortOverflow(value)) {
            return (short) value;
        }
        return _nonNullNumber((Number) ctxt.handleWeirdStringValue(this._valueClass, String.valueOf(value), "overflow, value cannot be represented as 16-bit value", new Object[0])).shortValue();
    }

    /* access modifiers changed from: protected */
    public final int _parseIntPrimitive(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
            return p.getIntValue();
        }
        int currentTokenId = p.getCurrentTokenId();
        if (currentTokenId != 3) {
            if (currentTokenId == 6) {
                String text = p.getText().trim();
                if (!_isEmptyOrTextualNull(text)) {
                    return _parseIntPrimitive(ctxt, text);
                }
                _verifyNullForPrimitiveCoercion(ctxt, text);
                return 0;
            } else if (currentTokenId != 8) {
                if (currentTokenId == 11) {
                    _verifyNullForPrimitive(ctxt);
                    return 0;
                }
            } else if (ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                return p.getValueAsInt();
            } else {
                _failDoubleToIntCoercion(p, ctxt, "int");
                throw null;
            }
        } else if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            p.nextToken();
            int parsed = _parseIntPrimitive(p, ctxt);
            _verifyEndArrayForSingle(p, ctxt);
            return parsed;
        }
        return ((Number) ctxt.handleUnexpectedToken(this._valueClass, p)).intValue();
    }

    /* access modifiers changed from: protected */
    public final int _parseIntPrimitive(DeserializationContext ctxt, String text) throws IOException {
        try {
            if (text.length() <= 9) {
                return NumberInput.parseInt(text);
            }
            long l = Long.parseLong(text);
            if (!_intOverflow(l)) {
                return (int) l;
            }
            return _nonNullNumber((Number) ctxt.handleWeirdStringValue(this._valueClass, text, "Overflow: numeric value (%s) out of range of int (%d -%d)", text, Integer.valueOf(LinearLayoutManager.INVALID_OFFSET), Integer.valueOf(MoPubClientPositioning.NO_REPEAT))).intValue();
        } catch (IllegalArgumentException e) {
            return _nonNullNumber((Number) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid int value", new Object[0])).intValue();
        }
    }

    /* access modifiers changed from: protected */
    public final long _parseLongPrimitive(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
            return p.getLongValue();
        }
        int currentTokenId = p.getCurrentTokenId();
        if (currentTokenId != 3) {
            if (currentTokenId == 6) {
                String text = p.getText().trim();
                if (!_isEmptyOrTextualNull(text)) {
                    return _parseLongPrimitive(ctxt, text);
                }
                _verifyNullForPrimitiveCoercion(ctxt, text);
                return 0;
            } else if (currentTokenId != 8) {
                if (currentTokenId == 11) {
                    _verifyNullForPrimitive(ctxt);
                    return 0;
                }
            } else if (ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                return p.getValueAsLong();
            } else {
                _failDoubleToIntCoercion(p, ctxt, "long");
                throw null;
            }
        } else if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            p.nextToken();
            long parsed = _parseLongPrimitive(p, ctxt);
            _verifyEndArrayForSingle(p, ctxt);
            return parsed;
        }
        return ((Number) ctxt.handleUnexpectedToken(this._valueClass, p)).longValue();
    }

    /* access modifiers changed from: protected */
    public final long _parseLongPrimitive(DeserializationContext ctxt, String text) throws IOException {
        try {
            return NumberInput.parseLong(text);
        } catch (IllegalArgumentException e) {
            return _nonNullNumber((Number) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid long value", new Object[0])).longValue();
        }
    }

    /* access modifiers changed from: protected */
    public final float _parseFloatPrimitive(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_NUMBER_FLOAT)) {
            return p.getFloatValue();
        }
        int currentTokenId = p.getCurrentTokenId();
        if (currentTokenId != 3) {
            if (currentTokenId == 11) {
                _verifyNullForPrimitive(ctxt);
                return 0.0f;
            } else if (currentTokenId == 6) {
                String text = p.getText().trim();
                if (!_isEmptyOrTextualNull(text)) {
                    return _parseFloatPrimitive(ctxt, text);
                }
                _verifyNullForPrimitiveCoercion(ctxt, text);
                return 0.0f;
            } else if (currentTokenId == 7) {
                return p.getFloatValue();
            }
        } else if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            p.nextToken();
            float parsed = _parseFloatPrimitive(p, ctxt);
            _verifyEndArrayForSingle(p, ctxt);
            return parsed;
        }
        return ((Number) ctxt.handleUnexpectedToken(this._valueClass, p)).floatValue();
    }

    /* access modifiers changed from: protected */
    public final float _parseFloatPrimitive(DeserializationContext ctxt, String text) throws IOException {
        char charAt = text.charAt(0);
        if (charAt != '-') {
            if (charAt != 'I') {
                if (charAt == 'N' && _isNaN(text)) {
                    return Float.NaN;
                }
            } else if (_isPosInf(text)) {
                return Float.POSITIVE_INFINITY;
            }
        } else if (_isNegInf(text)) {
            return Float.NEGATIVE_INFINITY;
        }
        try {
            return Float.parseFloat(text);
        } catch (IllegalArgumentException e) {
            return _nonNullNumber((Number) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid float value", new Object[0])).floatValue();
        }
    }

    /* access modifiers changed from: protected */
    public final double _parseDoublePrimitive(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_NUMBER_FLOAT)) {
            return p.getDoubleValue();
        }
        int currentTokenId = p.getCurrentTokenId();
        if (currentTokenId != 3) {
            if (currentTokenId == 11) {
                _verifyNullForPrimitive(ctxt);
                return 0.0d;
            } else if (currentTokenId == 6) {
                String text = p.getText().trim();
                if (!_isEmptyOrTextualNull(text)) {
                    return _parseDoublePrimitive(ctxt, text);
                }
                _verifyNullForPrimitiveCoercion(ctxt, text);
                return 0.0d;
            } else if (currentTokenId == 7) {
                return p.getDoubleValue();
            }
        } else if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            p.nextToken();
            double parsed = _parseDoublePrimitive(p, ctxt);
            _verifyEndArrayForSingle(p, ctxt);
            return parsed;
        }
        return ((Number) ctxt.handleUnexpectedToken(this._valueClass, p)).doubleValue();
    }

    /* access modifiers changed from: protected */
    public final double _parseDoublePrimitive(DeserializationContext ctxt, String text) throws IOException {
        char charAt = text.charAt(0);
        if (charAt != '-') {
            if (charAt != 'I') {
                if (charAt == 'N' && _isNaN(text)) {
                    return Double.NaN;
                }
            } else if (_isPosInf(text)) {
                return Double.POSITIVE_INFINITY;
            }
        } else if (_isNegInf(text)) {
            return Double.NEGATIVE_INFINITY;
        }
        try {
            return parseDouble(text);
        } catch (IllegalArgumentException e) {
            return _nonNullNumber((Number) ctxt.handleWeirdStringValue(this._valueClass, text, "not a valid double value (as String to convert)", new Object[0])).doubleValue();
        }
    }

    /* access modifiers changed from: protected */
    public Date _parseDate(JsonParser p, DeserializationContext ctxt) throws IOException {
        long ts;
        int currentTokenId = p.getCurrentTokenId();
        if (currentTokenId == 3) {
            return _parseDateFromArray(p, ctxt);
        }
        if (currentTokenId == 11) {
            return (Date) getNullValue(ctxt);
        }
        if (currentTokenId == 6) {
            return _parseDate(p.getText().trim(), ctxt);
        }
        if (currentTokenId != 7) {
            return (Date) ctxt.handleUnexpectedToken(this._valueClass, p);
        }
        try {
            ts = p.getLongValue();
        } catch (JsonParseException e) {
            ts = ((Number) ctxt.handleWeirdNumberValue(this._valueClass, p.getNumberValue(), "not a valid 64-bit long for creating `java.util.Date`", new Object[0])).longValue();
        }
        return new Date(ts);
    }

    /* access modifiers changed from: protected */
    public Date _parseDateFromArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken t;
        if (ctxt.hasSomeOfFeatures(F_MASK_ACCEPT_ARRAYS)) {
            t = p.nextToken();
            if (t == JsonToken.END_ARRAY && ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                return (Date) getNullValue(ctxt);
            }
            if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                Date parsed = _parseDate(p, ctxt);
                _verifyEndArrayForSingle(p, ctxt);
                return parsed;
            }
        } else {
            t = p.getCurrentToken();
        }
        return (Date) ctxt.handleUnexpectedToken(this._valueClass, t, p, null, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public Date _parseDate(String value, DeserializationContext ctxt) throws IOException {
        try {
            if (_isEmptyOrTextualNull(value)) {
                return (Date) getNullValue(ctxt);
            }
            return ctxt.parseDate(value);
        } catch (IllegalArgumentException iae) {
            return (Date) ctxt.handleWeirdStringValue(this._valueClass, value, "not a valid representation (error: %s)", iae.getMessage());
        }
    }

    protected static final double parseDouble(String numStr) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(numStr)) {
            return Double.MIN_NORMAL;
        }
        return Double.parseDouble(numStr);
    }

    /* access modifiers changed from: protected */
    public final String _parseString(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
            return p.getText();
        }
        String value = p.getValueAsString();
        if (value != null) {
            return value;
        }
        return (String) ctxt.handleUnexpectedToken(String.class, p);
    }

    /* access modifiers changed from: protected */
    public T _deserializeFromEmpty(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.START_ARRAY) {
            if (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                if (p.nextToken() == JsonToken.END_ARRAY) {
                    return null;
                }
                return ctxt.handleUnexpectedToken(handledType(), p);
            }
        } else if (t == JsonToken.VALUE_STRING && ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && p.getText().trim().isEmpty()) {
            return null;
        }
        return ctxt.handleUnexpectedToken(handledType(), p);
    }

    /* access modifiers changed from: protected */
    public boolean _hasTextualNull(String value) {
        return "null".equals(value);
    }

    /* access modifiers changed from: protected */
    public boolean _isEmptyOrTextualNull(String value) {
        return value.isEmpty() || "null".equals(value);
    }

    /* access modifiers changed from: protected */
    public final boolean _isNegInf(String text) {
        return "-Infinity".equals(text) || "-INF".equals(text);
    }

    /* access modifiers changed from: protected */
    public final boolean _isPosInf(String text) {
        return "Infinity".equals(text) || "INF".equals(text);
    }

    /* access modifiers changed from: protected */
    public final boolean _isNaN(String text) {
        return "NaN".equals(text);
    }

    /* access modifiers changed from: protected */
    public T _deserializeFromArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken t;
        if (ctxt.hasSomeOfFeatures(F_MASK_ACCEPT_ARRAYS)) {
            t = p.nextToken();
            if (t == JsonToken.END_ARRAY && ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                return getNullValue(ctxt);
            }
            if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                T parsed = deserialize(p, ctxt);
                if (p.nextToken() == JsonToken.END_ARRAY) {
                    return parsed;
                }
                handleMissingEndArrayForSingle(p, ctxt);
                throw null;
            }
        } else {
            t = p.getCurrentToken();
        }
        return ctxt.handleUnexpectedToken(this._valueClass, t, p, null, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void _failDoubleToIntCoercion(JsonParser p, DeserializationContext ctxt, String type) throws IOException {
        ctxt.reportInputMismatch(handledType(), "Cannot coerce a floating-point value ('%s') into %s (enable `DeserializationFeature.ACCEPT_FLOAT_AS_INT` to allow)", p.getValueAsString(), type);
        throw null;
    }

    /* access modifiers changed from: protected */
    public Object _coerceIntegral(JsonParser p, DeserializationContext ctxt) throws IOException {
        int feats = ctxt.getDeserializationFeatures();
        if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(feats)) {
            return p.getBigIntegerValue();
        }
        if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(feats)) {
            return Long.valueOf(p.getLongValue());
        }
        return p.getBigIntegerValue();
    }

    /* access modifiers changed from: protected */
    public Object _coerceNullToken(DeserializationContext ctxt, boolean isPrimitive) throws JsonMappingException {
        if (isPrimitive) {
            _verifyNullForPrimitive(ctxt);
        }
        return getNullValue(ctxt);
    }

    /* access modifiers changed from: protected */
    public Object _coerceTextualNull(DeserializationContext ctxt, boolean isPrimitive) throws JsonMappingException {
        Enum<?> feat;
        boolean enable;
        if (!ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
            feat = MapperFeature.ALLOW_COERCION_OF_SCALARS;
            enable = true;
        } else if (!isPrimitive || !ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            return getNullValue(ctxt);
        } else {
            feat = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
            enable = false;
        }
        _reportFailedNullCoerce(ctxt, enable, feat, "String \"null\"");
        throw null;
    }

    /* access modifiers changed from: protected */
    public Object _coerceEmptyString(DeserializationContext ctxt, boolean isPrimitive) throws JsonMappingException {
        Enum<?> feat;
        boolean enable;
        if (!ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
            feat = MapperFeature.ALLOW_COERCION_OF_SCALARS;
            enable = true;
        } else if (!isPrimitive || !ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            return getNullValue(ctxt);
        } else {
            feat = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
            enable = false;
        }
        _reportFailedNullCoerce(ctxt, enable, feat, "empty String (\"\")");
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void _verifyNullForPrimitive(DeserializationContext ctxt) throws JsonMappingException {
        if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            ctxt.reportInputMismatch((JsonDeserializer<?>) this, "Cannot coerce `null` %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", _coercedTypeDesc());
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public final void _verifyNullForPrimitiveCoercion(DeserializationContext ctxt, String str) throws JsonMappingException {
        boolean enable;
        Enum<?> feat;
        String strDesc;
        if (!ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
            feat = MapperFeature.ALLOW_COERCION_OF_SCALARS;
            enable = true;
        } else if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            feat = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
            enable = false;
        } else {
            return;
        }
        if (str.isEmpty()) {
            strDesc = "empty String (\"\")";
        } else {
            strDesc = String.format("String \"%s\"", new Object[]{str});
        }
        _reportFailedNullCoerce(ctxt, enable, feat, strDesc);
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void _verifyNullForScalarCoercion(DeserializationContext ctxt, String str) throws JsonMappingException {
        String strDesc;
        if (!ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
            if (str.isEmpty()) {
                strDesc = "empty String (\"\")";
            } else {
                strDesc = String.format("String \"%s\"", new Object[]{str});
            }
            _reportFailedNullCoerce(ctxt, true, MapperFeature.ALLOW_COERCION_OF_SCALARS, strDesc);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void _verifyStringForScalarCoercion(DeserializationContext ctxt, String str) throws JsonMappingException {
        MapperFeature feat = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (!ctxt.isEnabled(feat)) {
            ctxt.reportInputMismatch((JsonDeserializer<?>) this, "Cannot coerce String \"%s\" %s (enable `%s.%s` to allow)", str, _coercedTypeDesc(), feat.getClass().getSimpleName(), feat.name());
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void _verifyNumberForScalarCoercion(DeserializationContext ctxt, JsonParser p) throws IOException {
        MapperFeature feat = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (!ctxt.isEnabled(feat)) {
            ctxt.reportInputMismatch((JsonDeserializer<?>) this, "Cannot coerce Number (%s) %s (enable `%s.%s` to allow)", p.getText(), _coercedTypeDesc(), feat.getClass().getSimpleName(), feat.name());
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void _reportFailedNullCoerce(DeserializationContext ctxt, boolean state, Enum<?> enumR, String inputDesc) throws JsonMappingException {
        ctxt.reportInputMismatch((JsonDeserializer<?>) this, "Cannot coerce %s to Null value %s (%s `%s.%s` to allow)", inputDesc, _coercedTypeDesc(), state ? "enable" : "disable", enumR.getClass().getSimpleName(), enumR.name());
        throw null;
    }

    /* access modifiers changed from: protected */
    public String _coercedTypeDesc() {
        String typeDesc;
        JavaType t = getValueType();
        boolean structured = false;
        if (t == null || t.isPrimitive()) {
            Class<?> cls = handledType();
            if (cls.isArray() || Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) {
                structured = true;
            }
            typeDesc = ClassUtil.nameOf(cls);
        } else {
            if (t.isContainerType() || t.isReferenceType()) {
                structured = true;
            }
            StringBuilder sb = new StringBuilder();
            String str = "'";
            sb.append(str);
            sb.append(t.toString());
            sb.append(str);
            typeDesc = sb.toString();
        }
        if (structured) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("as content of type ");
            sb2.append(typeDesc);
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("for type ");
        sb3.append(typeDesc);
        return sb3.toString();
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> findDeserializer(DeserializationContext ctxt, JavaType type, BeanProperty property) throws JsonMappingException {
        return ctxt.findContextualValueDeserializer(type, property);
    }

    /* access modifiers changed from: protected */
    public final boolean _isIntNumber(String text) {
        int len = text.length();
        if (len <= 0) {
            return false;
        }
        char c = text.charAt(0);
        for (int i = (c == '-' || c == '+') ? 1 : 0; i < len; i++) {
            int ch = text.charAt(i);
            if (ch > 57 || ch < 48) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> findConvertingContentDeserializer(DeserializationContext ctxt, BeanProperty prop, JsonDeserializer<?> existingDeserializer) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (_neitherNull(intr, prop)) {
            AnnotatedMember member = prop.getMember();
            if (member != null) {
                Object convDef = intr.findDeserializationContentConverter(member);
                if (convDef != null) {
                    Converter<Object, Object> conv = ctxt.converterInstance(prop.getMember(), convDef);
                    JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
                    if (existingDeserializer == null) {
                        existingDeserializer = ctxt.findContextualValueDeserializer(delegateType, prop);
                    }
                    return new StdDelegatingDeserializer(conv, delegateType, existingDeserializer);
                }
            }
        }
        return existingDeserializer;
    }

    /* access modifiers changed from: protected */
    public Value findFormatOverrides(DeserializationContext ctxt, BeanProperty prop, Class<?> typeForDefaults) {
        if (prop != null) {
            return prop.findPropertyFormat(ctxt.getConfig(), typeForDefaults);
        }
        return ctxt.getDefaultPropertyFormat(typeForDefaults);
    }

    /* access modifiers changed from: protected */
    public Boolean findFormatFeature(DeserializationContext ctxt, BeanProperty prop, Class<?> typeForDefaults, Feature feat) {
        Value format = findFormatOverrides(ctxt, prop, typeForDefaults);
        if (format != null) {
            return format.getFeature(feat);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final NullValueProvider findValueNullProvider(DeserializationContext ctxt, SettableBeanProperty prop, PropertyMetadata propMetadata) throws JsonMappingException {
        if (prop != null) {
            return _findNullProvider(ctxt, prop, propMetadata.getValueNulls(), prop.getValueDeserializer());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public NullValueProvider findContentNullProvider(DeserializationContext ctxt, BeanProperty prop, JsonDeserializer<?> valueDeser) throws JsonMappingException {
        Nulls nulls = findContentNullStyle(ctxt, prop);
        if (nulls == Nulls.SKIP) {
            return NullsConstantProvider.skipper();
        }
        NullValueProvider prov = _findNullProvider(ctxt, prop, nulls, valueDeser);
        if (prov != null) {
            return prov;
        }
        return valueDeser;
    }

    /* access modifiers changed from: protected */
    public Nulls findContentNullStyle(DeserializationContext ctxt, BeanProperty prop) throws JsonMappingException {
        if (prop != null) {
            return prop.getMetadata().getContentNulls();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final NullValueProvider _findNullProvider(DeserializationContext ctxt, BeanProperty prop, Nulls nulls, JsonDeserializer<?> valueDeser) throws JsonMappingException {
        if (nulls == Nulls.FAIL) {
            if (prop == null) {
                return NullsFailProvider.constructForRootValue(ctxt.constructType(valueDeser.handledType()));
            }
            return NullsFailProvider.constructForProperty(prop);
        } else if (nulls == Nulls.AS_EMPTY) {
            if (valueDeser == null) {
                return null;
            }
            if (!(valueDeser instanceof BeanDeserializerBase) || ((BeanDeserializerBase) valueDeser).getValueInstantiator().canCreateUsingDefault()) {
                AccessPattern access = valueDeser.getEmptyAccessPattern();
                if (access == AccessPattern.ALWAYS_NULL) {
                    return NullsConstantProvider.nuller();
                }
                if (access == AccessPattern.CONSTANT) {
                    return NullsConstantProvider.forValue(valueDeser.getEmptyValue(ctxt));
                }
                return new NullsAsEmptyProvider(valueDeser);
            }
            JavaType type = prop.getType();
            ctxt.reportBadDefinition(type, String.format("Cannot create empty instance of %s, no default Creator", new Object[]{type}));
            throw null;
        } else if (nulls == Nulls.SKIP) {
            return NullsConstantProvider.skipper();
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void handleUnknownProperty(JsonParser p, DeserializationContext ctxt, Object instanceOrClass, String propName) throws IOException {
        if (instanceOrClass == null) {
            instanceOrClass = handledType();
        }
        if (!ctxt.handleUnknownProperty(p, this, instanceOrClass, propName)) {
            p.skipChildren();
        }
    }

    /* access modifiers changed from: protected */
    public void handleMissingEndArrayForSingle(JsonParser p, DeserializationContext ctxt) throws IOException {
        ctxt.reportWrongTokenException((JsonDeserializer<?>) this, JsonToken.END_ARRAY, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", handledType().getName());
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _verifyEndArrayForSingle(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.nextToken() != JsonToken.END_ARRAY) {
            handleMissingEndArrayForSingle(p, ctxt);
            throw null;
        }
    }

    protected static final boolean _neitherNull(Object a, Object b) {
        return (a == null || b == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    public final boolean _byteOverflow(int value) {
        return value < -128 || value > 255;
    }

    /* access modifiers changed from: protected */
    public final boolean _shortOverflow(int value) {
        return value < -32768 || value > 32767;
    }

    /* access modifiers changed from: protected */
    public final boolean _intOverflow(long value) {
        return value < -2147483648L || value > 2147483647L;
    }

    /* access modifiers changed from: protected */
    public Number _nonNullNumber(Number n) {
        if (n == null) {
            return Integer.valueOf(0);
        }
        return n;
    }
}
