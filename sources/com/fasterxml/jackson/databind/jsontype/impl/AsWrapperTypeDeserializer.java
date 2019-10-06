package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.C0078As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;

public class AsWrapperTypeDeserializer extends TypeDeserializerBase implements Serializable {
    public AsWrapperTypeDeserializer(JavaType bt, TypeIdResolver idRes, String typePropertyName, boolean typeIdVisible, JavaType defaultImpl) {
        super(bt, idRes, typePropertyName, typeIdVisible, defaultImpl);
    }

    protected AsWrapperTypeDeserializer(AsWrapperTypeDeserializer src, BeanProperty property) {
        super(src, property);
    }

    public TypeDeserializer forProperty(BeanProperty prop) {
        return prop == this._property ? this : new AsWrapperTypeDeserializer(this, prop);
    }

    public C0078As getTypeInclusion() {
        return C0078As.WRAPPER_OBJECT;
    }

    public Object deserializeTypedFromObject(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return _deserialize(jp, ctxt);
    }

    public Object deserializeTypedFromArray(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return _deserialize(jp, ctxt);
    }

    public Object deserializeTypedFromScalar(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return _deserialize(jp, ctxt);
    }

    public Object deserializeTypedFromAny(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return _deserialize(jp, ctxt);
    }

    /* access modifiers changed from: protected */
    public Object _deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.canReadTypeId()) {
            Object typeId = p.getTypeId();
            if (typeId != null) {
                return _deserializeWithNativeTypeId(p, ctxt, typeId);
            }
        }
        Object typeId2 = p.getCurrentToken();
        if (typeId2 == JsonToken.START_OBJECT) {
            if (p.nextToken() != JsonToken.FIELD_NAME) {
                JavaType baseType = baseType();
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                StringBuilder sb = new StringBuilder();
                sb.append("need JSON String that contains type id (for subtype of ");
                sb.append(baseTypeName());
                sb.append(")");
                ctxt.reportWrongTokenException(baseType, jsonToken, sb.toString(), new Object[0]);
                throw null;
            }
        } else if (typeId2 != JsonToken.FIELD_NAME) {
            JavaType baseType2 = baseType();
            JsonToken jsonToken2 = JsonToken.START_OBJECT;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("need JSON Object to contain As.WRAPPER_OBJECT type information for class ");
            sb2.append(baseTypeName());
            ctxt.reportWrongTokenException(baseType2, jsonToken2, sb2.toString(), new Object[0]);
            throw null;
        }
        String typeId3 = p.getText();
        JsonDeserializer<Object> deser = _findDeserializer(ctxt, typeId3);
        p.nextToken();
        if (this._typeIdVisible && p.getCurrentToken() == JsonToken.START_OBJECT) {
            TokenBuffer tb = new TokenBuffer((ObjectCodec) null, false);
            tb.writeStartObject();
            tb.writeFieldName(this._typePropertyName);
            tb.writeString(typeId3);
            p.clearCurrentToken();
            r9 = JsonParserSequence.createFlattened(false, tb.asParser(p), p);
            r9.nextToken();
            p = r9;
        }
        Object value = deser.deserialize(p, ctxt);
        if (p.nextToken() == JsonToken.END_OBJECT) {
            return value;
        }
        ctxt.reportWrongTokenException(baseType(), JsonToken.END_OBJECT, "expected closing END_OBJECT after type information and deserialized value", new Object[0]);
        throw null;
    }
}
