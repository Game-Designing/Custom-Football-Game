package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;

@JacksonStdImpl
public final class StringArrayDeserializer extends StdDeserializer<String[]> implements ContextualDeserializer {
    private static final String[] NO_STRINGS = new String[0];
    public static final StringArrayDeserializer instance = new StringArrayDeserializer();
    protected JsonDeserializer<String> _elementDeserializer;
    protected final NullValueProvider _nullProvider;
    protected final boolean _skipNullValues;
    protected final Boolean _unwrapSingle;

    public StringArrayDeserializer() {
        this(null, null, null);
    }

    protected StringArrayDeserializer(JsonDeserializer<?> deser, NullValueProvider nuller, Boolean unwrapSingle) {
        super(String[].class);
        this._elementDeserializer = deser;
        this._nullProvider = nuller;
        this._unwrapSingle = unwrapSingle;
        this._skipNullValues = NullsConstantProvider.isSkipper(nuller);
    }

    public Boolean supportsUpdate(DeserializationConfig config) {
        return Boolean.TRUE;
    }

    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        return NO_STRINGS;
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<?> deser;
        JsonDeserializer<?> deser2 = findConvertingContentDeserializer(ctxt, property, this._elementDeserializer);
        JavaType type = ctxt.constructType(String.class);
        if (deser2 == null) {
            deser = ctxt.findContextualValueDeserializer(type, property);
        } else {
            deser = ctxt.handleSecondaryContextualization(deser2, property, type);
        }
        Boolean unwrapSingle = findFormatFeature(ctxt, property, String[].class, Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        NullValueProvider nuller = findContentNullProvider(ctxt, property, deser);
        if (deser != null && isDefaultDeserializer(deser)) {
            deser = null;
        }
        if (this._elementDeserializer == deser && this._unwrapSingle == unwrapSingle && this._nullProvider == nuller) {
            return this;
        }
        return new StringArrayDeserializer(deser, nuller, unwrapSingle);
    }

    public String[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (!p.isExpectedStartArrayToken()) {
            return handleNonArray(p, ctxt);
        }
        if (this._elementDeserializer != null) {
            return _deserializeCustom(p, ctxt, null);
        }
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        Object[] chunk = buffer.resetAndStart();
        int ix = 0;
        while (true) {
            try {
                String value = p.nextTextValue();
                if (value == null) {
                    JsonToken t = p.getCurrentToken();
                    if (t == JsonToken.END_ARRAY) {
                        String[] result = (String[]) buffer.completeAndClearBuffer(chunk, ix, String.class);
                        ctxt.returnObjectBuffer(buffer);
                        return result;
                    } else if (t != JsonToken.VALUE_NULL) {
                        value = _parseString(p, ctxt);
                    } else if (!this._skipNullValues) {
                        value = (String) this._nullProvider.getNullValue(ctxt);
                    }
                }
                if (ix >= chunk.length) {
                    chunk = buffer.appendCompletedChunk(chunk);
                    ix = 0;
                }
                int ix2 = ix + 1;
                try {
                    chunk[ix] = value;
                    ix = ix2;
                } catch (Exception e) {
                    e = e;
                    ix = ix2;
                    throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, buffer.bufferedSize() + ix);
                }
            } catch (Exception e2) {
                e = e2;
                throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, buffer.bufferedSize() + ix);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String[] _deserializeCustom(JsonParser p, DeserializationContext ctxt, String[] old) throws IOException {
        Object[] chunk;
        int ix;
        String value;
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        if (old == null) {
            ix = 0;
            chunk = buffer.resetAndStart();
        } else {
            ix = old.length;
            chunk = buffer.resetAndStart(old, ix);
        }
        JsonDeserializer<String> deser = this._elementDeserializer;
        while (true) {
            try {
                if (p.nextTextValue() == null) {
                    JsonToken t = p.getCurrentToken();
                    if (t == JsonToken.END_ARRAY) {
                        String[] result = (String[]) buffer.completeAndClearBuffer(chunk, ix, String.class);
                        ctxt.returnObjectBuffer(buffer);
                        return result;
                    } else if (t != JsonToken.VALUE_NULL) {
                        value = (String) deser.deserialize(p, ctxt);
                    } else if (!this._skipNullValues) {
                        value = (String) this._nullProvider.getNullValue(ctxt);
                    }
                } else {
                    value = (String) deser.deserialize(p, ctxt);
                }
                if (ix >= chunk.length) {
                    chunk = buffer.appendCompletedChunk(chunk);
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
                    throw JsonMappingException.wrapWithPath((Throwable) e, (Object) String.class, ix);
                }
            } catch (Exception e2) {
                e = e2;
                throw JsonMappingException.wrapWithPath((Throwable) e, (Object) String.class, ix);
            }
        }
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromArray(p, ctxt);
    }

    public String[] deserialize(JsonParser p, DeserializationContext ctxt, String[] intoValue) throws IOException {
        if (!p.isExpectedStartArrayToken()) {
            String[] arr = handleNonArray(p, ctxt);
            if (arr == null) {
                return intoValue;
            }
            int offset = intoValue.length;
            String[] result = new String[(arr.length + offset)];
            System.arraycopy(intoValue, 0, result, 0, offset);
            System.arraycopy(arr, 0, result, offset, arr.length);
            return result;
        } else if (this._elementDeserializer != null) {
            return _deserializeCustom(p, ctxt, intoValue);
        } else {
            ObjectBuffer buffer = ctxt.leaseObjectBuffer();
            int ix = intoValue.length;
            Object[] chunk = buffer.resetAndStart(intoValue, ix);
            while (true) {
                try {
                    String value = p.nextTextValue();
                    if (value == null) {
                        JsonToken t = p.getCurrentToken();
                        if (t == JsonToken.END_ARRAY) {
                            String[] result2 = (String[]) buffer.completeAndClearBuffer(chunk, ix, String.class);
                            ctxt.returnObjectBuffer(buffer);
                            return result2;
                        } else if (t != JsonToken.VALUE_NULL) {
                            value = _parseString(p, ctxt);
                        } else if (this._skipNullValues) {
                            return NO_STRINGS;
                        } else {
                            value = (String) this._nullProvider.getNullValue(ctxt);
                        }
                    }
                    if (ix >= chunk.length) {
                        chunk = buffer.appendCompletedChunk(chunk);
                        ix = 0;
                    }
                    int ix2 = ix + 1;
                    try {
                        chunk[ix] = value;
                        ix = ix2;
                    } catch (Exception e) {
                        e = e;
                        ix = ix2;
                        throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, buffer.bufferedSize() + ix);
                    }
                } catch (Exception e2) {
                    e = e2;
                    throw JsonMappingException.wrapWithPath((Throwable) e, (Object) chunk, buffer.bufferedSize() + ix);
                }
            }
        }
    }

    private final String[] handleNonArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        Boolean bool = this._unwrapSingle;
        if (bool == Boolean.TRUE || (bool == null && ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return new String[]{p.hasToken(JsonToken.VALUE_NULL) ? (String) this._nullProvider.getNullValue(ctxt) : _parseString(p, ctxt)};
        } else if (!p.hasToken(JsonToken.VALUE_STRING) || !ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) || p.getText().length() != 0) {
            return (String[]) ctxt.handleUnexpectedToken(this._valueClass, p);
        } else {
            return null;
        }
    }
}
