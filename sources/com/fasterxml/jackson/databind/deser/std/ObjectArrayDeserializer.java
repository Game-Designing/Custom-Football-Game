package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.lang.reflect.Array;

@JacksonStdImpl
public class ObjectArrayDeserializer extends ContainerDeserializerBase<Object[]> implements ContextualDeserializer {
    protected static final Object[] NO_OBJECTS = new Object[0];
    protected final Class<?> _elementClass;
    protected JsonDeserializer<Object> _elementDeserializer;
    protected final TypeDeserializer _elementTypeDeserializer;
    protected final boolean _untyped;

    public ObjectArrayDeserializer(JavaType arrayType, JsonDeserializer<Object> elemDeser, TypeDeserializer elemTypeDeser) {
        super(arrayType, (NullValueProvider) null, (Boolean) null);
        this._elementClass = arrayType.getContentType().getRawClass();
        this._untyped = this._elementClass == Object.class;
        this._elementDeserializer = elemDeser;
        this._elementTypeDeserializer = elemTypeDeser;
    }

    protected ObjectArrayDeserializer(ObjectArrayDeserializer base, JsonDeserializer<Object> elemDeser, TypeDeserializer elemTypeDeser, NullValueProvider nuller, Boolean unwrapSingle) {
        super((ContainerDeserializerBase<?>) base, nuller, unwrapSingle);
        this._elementClass = base._elementClass;
        this._untyped = base._untyped;
        this._elementDeserializer = elemDeser;
        this._elementTypeDeserializer = elemTypeDeser;
    }

    public ObjectArrayDeserializer withResolved(TypeDeserializer elemTypeDeser, JsonDeserializer<?> elemDeser, NullValueProvider nuller, Boolean unwrapSingle) {
        if (unwrapSingle == this._unwrapSingle && nuller == this._nullProvider && elemDeser == this._elementDeserializer && elemTypeDeser == this._elementTypeDeserializer) {
            return this;
        }
        ObjectArrayDeserializer objectArrayDeserializer = new ObjectArrayDeserializer(this, elemDeser, elemTypeDeser, nuller, unwrapSingle);
        return objectArrayDeserializer;
    }

    public boolean isCachable() {
        return this._elementDeserializer == null && this._elementTypeDeserializer == null;
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<?> valueDeser;
        JsonDeserializer<Object> jsonDeserializer = this._elementDeserializer;
        Boolean unwrapSingle = findFormatFeature(ctxt, property, this._containerType.getRawClass(), Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        JsonDeserializer<?> valueDeser2 = findConvertingContentDeserializer(ctxt, property, jsonDeserializer);
        JavaType vt = this._containerType.getContentType();
        if (valueDeser2 == null) {
            valueDeser = ctxt.findContextualValueDeserializer(vt, property);
        } else {
            valueDeser = ctxt.handleSecondaryContextualization(valueDeser2, property, vt);
        }
        TypeDeserializer elemTypeDeser = this._elementTypeDeserializer;
        if (elemTypeDeser != null) {
            elemTypeDeser = elemTypeDeser.forProperty(property);
        }
        return withResolved(elemTypeDeser, valueDeser, findContentNullProvider(ctxt, property, valueDeser), unwrapSingle);
    }

    public JsonDeserializer<Object> getContentDeserializer() {
        return this._elementDeserializer;
    }

    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        return NO_OBJECTS;
    }

    public Object[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Throwable e;
        Object[] result;
        Object value;
        if (!p.isExpectedStartArrayToken()) {
            return handleNonArray(p, ctxt);
        }
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        Object[] chunk = buffer.resetAndStart();
        int ix = 0;
        TypeDeserializer typeDeser = this._elementTypeDeserializer;
        JsonToken jsonToken = null;
        while (true) {
            try {
                JsonToken nextToken = p.nextToken();
                JsonToken t = nextToken;
                try {
                    if (nextToken == JsonToken.END_ARRAY) {
                        break;
                    }
                    if (t == JsonToken.VALUE_NULL) {
                        if (this._skipNullValues) {
                            jsonToken = t;
                        } else {
                            value = this._nullProvider.getNullValue(ctxt);
                        }
                    } else if (typeDeser == null) {
                        value = this._elementDeserializer.deserialize(p, ctxt);
                    } else {
                        value = this._elementDeserializer.deserializeWithType(p, ctxt, typeDeser);
                    }
                    if (ix >= chunk.length) {
                        chunk = buffer.appendCompletedChunk(chunk);
                        ix = 0;
                    }
                    int ix2 = ix + 1;
                    try {
                        chunk[ix] = value;
                        jsonToken = t;
                        ix = ix2;
                    } catch (Exception e2) {
                        e = e2;
                        ix = ix2;
                        throw JsonMappingException.wrapWithPath(e, (Object) chunk, buffer.bufferedSize() + ix);
                    }
                } catch (Exception e3) {
                    e = e3;
                    throw JsonMappingException.wrapWithPath(e, (Object) chunk, buffer.bufferedSize() + ix);
                }
            } catch (Exception e4) {
                Throwable th = e4;
                JsonToken jsonToken2 = jsonToken;
                e = th;
                throw JsonMappingException.wrapWithPath(e, (Object) chunk, buffer.bufferedSize() + ix);
            }
        }
        if (this._untyped) {
            result = buffer.completeAndClearBuffer(chunk, ix);
        } else {
            result = buffer.completeAndClearBuffer(chunk, ix, this._elementClass);
        }
        ctxt.returnObjectBuffer(buffer);
        return result;
    }

    public Object[] deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return (Object[]) typeDeserializer.deserializeTypedFromArray(p, ctxt);
    }

    public Object[] deserialize(JsonParser p, DeserializationContext ctxt, Object[] intoValue) throws IOException {
        Throwable e;
        Object[] result;
        Object value;
        if (!p.isExpectedStartArrayToken()) {
            Object[] arr = handleNonArray(p, ctxt);
            if (arr == null) {
                return intoValue;
            }
            int offset = intoValue.length;
            Object[] result2 = new Object[(arr.length + offset)];
            System.arraycopy(intoValue, 0, result2, 0, offset);
            System.arraycopy(arr, 0, result2, offset, arr.length);
            return result2;
        }
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        int ix = intoValue.length;
        Object[] chunk = buffer.resetAndStart(intoValue, ix);
        TypeDeserializer typeDeser = this._elementTypeDeserializer;
        JsonToken jsonToken = null;
        while (true) {
            try {
                JsonToken nextToken = p.nextToken();
                JsonToken t = nextToken;
                try {
                    if (nextToken == JsonToken.END_ARRAY) {
                        break;
                    }
                    if (t == JsonToken.VALUE_NULL) {
                        if (this._skipNullValues) {
                            jsonToken = t;
                        } else {
                            value = this._nullProvider.getNullValue(ctxt);
                        }
                    } else if (typeDeser == null) {
                        value = this._elementDeserializer.deserialize(p, ctxt);
                    } else {
                        value = this._elementDeserializer.deserializeWithType(p, ctxt, typeDeser);
                    }
                    if (ix >= chunk.length) {
                        chunk = buffer.appendCompletedChunk(chunk);
                        ix = 0;
                    }
                    int ix2 = ix + 1;
                    try {
                        chunk[ix] = value;
                        jsonToken = t;
                        ix = ix2;
                    } catch (Exception e2) {
                        e = e2;
                        ix = ix2;
                        throw JsonMappingException.wrapWithPath(e, (Object) chunk, buffer.bufferedSize() + ix);
                    }
                } catch (Exception e3) {
                    e = e3;
                    throw JsonMappingException.wrapWithPath(e, (Object) chunk, buffer.bufferedSize() + ix);
                }
            } catch (Exception e4) {
                Throwable th = e4;
                JsonToken jsonToken2 = jsonToken;
                e = th;
                throw JsonMappingException.wrapWithPath(e, (Object) chunk, buffer.bufferedSize() + ix);
            }
        }
        if (this._untyped) {
            result = buffer.completeAndClearBuffer(chunk, ix);
        } else {
            result = buffer.completeAndClearBuffer(chunk, ix, this._elementClass);
        }
        ctxt.returnObjectBuffer(buffer);
        return result;
    }

    /* access modifiers changed from: protected */
    public Byte[] deserializeFromBase64(JsonParser p, DeserializationContext ctxt) throws IOException {
        byte[] b = p.getBinaryValue(ctxt.getBase64Variant());
        Byte[] result = new Byte[b.length];
        int len = b.length;
        for (int i = 0; i < len; i++) {
            result[i] = Byte.valueOf(b[i]);
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public Object[] handleNonArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object value;
        Object[] result;
        if (p.hasToken(JsonToken.VALUE_STRING) && ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && p.getText().length() == 0) {
            return null;
        }
        Boolean bool = this._unwrapSingle;
        if (bool == Boolean.TRUE || (bool == null && ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            if (p.getCurrentToken() != JsonToken.VALUE_NULL) {
                TypeDeserializer typeDeserializer = this._elementTypeDeserializer;
                if (typeDeserializer == null) {
                    value = this._elementDeserializer.deserialize(p, ctxt);
                } else {
                    value = this._elementDeserializer.deserializeWithType(p, ctxt, typeDeserializer);
                }
            } else if (this._skipNullValues) {
                return NO_OBJECTS;
            } else {
                value = this._nullProvider.getNullValue(ctxt);
            }
            if (this._untyped) {
                result = new Object[1];
            } else {
                result = (Object[]) Array.newInstance(this._elementClass, 1);
            }
            result[0] = value;
            return result;
        } else if (p.getCurrentToken() == JsonToken.VALUE_STRING && this._elementClass == Byte.class) {
            return deserializeFromBase64(p, ctxt);
        } else {
            return (Object[]) ctxt.handleUnexpectedToken(this._containerType.getRawClass(), p);
        }
    }
}
