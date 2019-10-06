package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

@JacksonStdImpl
public class MapEntryDeserializer extends ContainerDeserializerBase<Entry<Object, Object>> implements ContextualDeserializer {
    protected final KeyDeserializer _keyDeserializer;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final TypeDeserializer _valueTypeDeserializer;

    public /* bridge */ /* synthetic */ Object deserialize(JsonParser x0, DeserializationContext x1, Object x2) throws IOException {
        deserialize(x0, x1, (Entry) x2);
        throw null;
    }

    public MapEntryDeserializer(JavaType type, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser) {
        super(type);
        if (type.containedTypeCount() == 2) {
            this._keyDeserializer = keyDeser;
            this._valueDeserializer = valueDeser;
            this._valueTypeDeserializer = valueTypeDeser;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Missing generic type information for ");
        sb.append(type);
        throw new IllegalArgumentException(sb.toString());
    }

    protected MapEntryDeserializer(MapEntryDeserializer src, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser) {
        super((ContainerDeserializerBase<?>) src);
        this._keyDeserializer = keyDeser;
        this._valueDeserializer = valueDeser;
        this._valueTypeDeserializer = valueTypeDeser;
    }

    /* access modifiers changed from: protected */
    public MapEntryDeserializer withResolved(KeyDeserializer keyDeser, TypeDeserializer valueTypeDeser, JsonDeserializer<?> valueDeser) {
        if (this._keyDeserializer == keyDeser && this._valueDeserializer == valueDeser && this._valueTypeDeserializer == valueTypeDeser) {
            return this;
        }
        return new MapEntryDeserializer(this, keyDeser, valueDeser, valueTypeDeser);
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<?> vd;
        KeyDeserializer kd = this._keyDeserializer;
        if (kd == null) {
            kd = ctxt.findKeyDeserializer(this._containerType.containedType(0), property);
        } else if (kd instanceof ContextualKeyDeserializer) {
            kd = ((ContextualKeyDeserializer) kd).createContextual(ctxt, property);
        }
        JsonDeserializer<?> vd2 = findConvertingContentDeserializer(ctxt, property, this._valueDeserializer);
        JavaType contentType = this._containerType.containedType(1);
        if (vd2 == null) {
            vd = ctxt.findContextualValueDeserializer(contentType, property);
        } else {
            vd = ctxt.handleSecondaryContextualization(vd2, property, contentType);
        }
        TypeDeserializer vtd = this._valueTypeDeserializer;
        if (vtd != null) {
            vtd = vtd.forProperty(property);
        }
        return withResolved(kd, vtd, vd);
    }

    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public Entry<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object value;
        JsonToken t = p.getCurrentToken();
        if (t != JsonToken.START_OBJECT && t != JsonToken.FIELD_NAME && t != JsonToken.END_OBJECT) {
            return (Entry) _deserializeFromEmpty(p, ctxt);
        }
        if (t == JsonToken.START_OBJECT) {
            t = p.nextToken();
        }
        if (t == JsonToken.FIELD_NAME) {
            KeyDeserializer keyDes = this._keyDeserializer;
            JsonDeserializer<Object> valueDes = this._valueDeserializer;
            TypeDeserializer typeDeser = this._valueTypeDeserializer;
            String keyStr = p.getCurrentName();
            Object key = keyDes.deserializeKey(keyStr, ctxt);
            try {
                if (p.nextToken() == JsonToken.VALUE_NULL) {
                    value = valueDes.getNullValue(ctxt);
                } else if (typeDeser == null) {
                    value = valueDes.deserialize(p, ctxt);
                } else {
                    value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                }
                JsonToken t2 = p.nextToken();
                if (t2 == JsonToken.END_OBJECT) {
                    return new SimpleEntry(key, value);
                }
                if (t2 == JsonToken.FIELD_NAME) {
                    ctxt.reportInputMismatch((JsonDeserializer<?>) this, "Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '%s')", p.getCurrentName());
                    throw null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: ");
                sb.append(t2);
                ctxt.reportInputMismatch((JsonDeserializer<?>) this, sb.toString(), new Object[0]);
                throw null;
            } catch (Exception e) {
                wrapAndThrow(e, Entry.class, keyStr);
                throw null;
            }
        } else if (t != JsonToken.END_OBJECT) {
            return (Entry) ctxt.handleUnexpectedToken(handledType(), p);
        } else {
            ctxt.reportInputMismatch((JsonDeserializer<?>) this, "Cannot deserialize a Map.Entry out of empty JSON Object", new Object[0]);
            throw null;
        }
    }

    public Entry<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt, Entry<Object, Object> entry) throws IOException {
        throw new IllegalStateException("Cannot update Map.Entry values");
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromObject(p, ctxt);
    }
}
