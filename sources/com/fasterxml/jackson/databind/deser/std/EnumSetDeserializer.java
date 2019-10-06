package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.EnumSet;

public class EnumSetDeserializer extends StdDeserializer<EnumSet<?>> implements ContextualDeserializer {
    protected final Class<Enum> _enumClass;
    protected JsonDeserializer<Enum<?>> _enumDeserializer;
    protected final JavaType _enumType;
    protected final Boolean _unwrapSingle;

    public EnumSetDeserializer(JavaType enumType, JsonDeserializer<?> deser) {
        super(EnumSet.class);
        this._enumType = enumType;
        this._enumClass = enumType.getRawClass();
        if (this._enumClass.isEnum()) {
            this._enumDeserializer = deser;
            this._unwrapSingle = null;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Type ");
        sb.append(enumType);
        sb.append(" not Java Enum type");
        throw new IllegalArgumentException(sb.toString());
    }

    protected EnumSetDeserializer(EnumSetDeserializer base, JsonDeserializer<?> deser, Boolean unwrapSingle) {
        super((StdDeserializer<?>) base);
        this._enumType = base._enumType;
        this._enumClass = base._enumClass;
        this._enumDeserializer = deser;
        this._unwrapSingle = unwrapSingle;
    }

    public EnumSetDeserializer withResolved(JsonDeserializer<?> deser, Boolean unwrapSingle) {
        if (this._unwrapSingle == unwrapSingle && this._enumDeserializer == deser) {
            return this;
        }
        return new EnumSetDeserializer(this, deser, unwrapSingle);
    }

    public boolean isCachable() {
        if (this._enumType.getValueHandler() != null) {
            return false;
        }
        return true;
    }

    public Boolean supportsUpdate(DeserializationConfig config) {
        return Boolean.TRUE;
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<?> deser;
        Boolean unwrapSingle = findFormatFeature(ctxt, property, EnumSet.class, Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        JsonDeserializer<Enum<?>> jsonDeserializer = this._enumDeserializer;
        if (jsonDeserializer == null) {
            deser = ctxt.findContextualValueDeserializer(this._enumType, property);
        } else {
            deser = ctxt.handleSecondaryContextualization(jsonDeserializer, property, this._enumType);
        }
        return withResolved(deser, unwrapSingle);
    }

    public EnumSet<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        EnumSet result = constructSet();
        if (!p.isExpectedStartArrayToken()) {
            return handleNonArray(p, ctxt, result);
        }
        return _deserialize(p, ctxt, result);
    }

    public EnumSet<?> deserialize(JsonParser p, DeserializationContext ctxt, EnumSet<?> result) throws IOException {
        if (!p.isExpectedStartArrayToken()) {
            return handleNonArray(p, ctxt, result);
        }
        return _deserialize(p, ctxt, result);
    }

    /* access modifiers changed from: protected */
    public final EnumSet<?> _deserialize(JsonParser p, DeserializationContext ctxt, EnumSet result) throws IOException {
        Throwable e;
        JsonToken jsonToken = null;
        while (true) {
            try {
                JsonToken nextToken = p.nextToken();
                JsonToken t = nextToken;
                try {
                    if (nextToken == JsonToken.END_ARRAY) {
                        return result;
                    }
                    if (t == JsonToken.VALUE_NULL) {
                        return (EnumSet) ctxt.handleUnexpectedToken(this._enumClass, p);
                    }
                    Enum<?> value = (Enum) this._enumDeserializer.deserialize(p, ctxt);
                    if (value != null) {
                        result.add(value);
                    }
                    jsonToken = t;
                } catch (Exception e2) {
                    e = e2;
                    throw JsonMappingException.wrapWithPath(e, (Object) result, result.size());
                }
            } catch (Exception e3) {
                Throwable th = e3;
                JsonToken jsonToken2 = jsonToken;
                e = th;
                throw JsonMappingException.wrapWithPath(e, (Object) result, result.size());
            }
        }
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromArray(p, ctxt);
    }

    private EnumSet constructSet() {
        return EnumSet.noneOf(this._enumClass);
    }

    /* access modifiers changed from: protected */
    public EnumSet<?> handleNonArray(JsonParser p, DeserializationContext ctxt, EnumSet result) throws IOException {
        Boolean bool = this._unwrapSingle;
        if (!(bool == Boolean.TRUE || (bool == null && ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)))) {
            return (EnumSet) ctxt.handleUnexpectedToken(EnumSet.class, p);
        }
        if (p.hasToken(JsonToken.VALUE_NULL)) {
            return (EnumSet) ctxt.handleUnexpectedToken(this._enumClass, p);
        }
        try {
            Enum<?> value = (Enum) this._enumDeserializer.deserialize(p, ctxt);
            if (value != null) {
                result.add(value);
            }
            return result;
        } catch (Exception e) {
            throw JsonMappingException.wrapWithPath((Throwable) e, (Object) result, result.size());
        }
    }
}
