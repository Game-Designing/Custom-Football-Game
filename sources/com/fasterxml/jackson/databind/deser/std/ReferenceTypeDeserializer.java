package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.IOException;

public abstract class ReferenceTypeDeserializer<T> extends StdDeserializer<T> implements ContextualDeserializer {
    protected final JavaType _fullType;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    public abstract Object getReferenced(T t);

    public abstract T referenceValue(Object obj);

    public abstract T updateReference(T t, Object obj);

    /* access modifiers changed from: protected */
    public abstract ReferenceTypeDeserializer<T> withResolved(TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer);

    public ReferenceTypeDeserializer(JavaType fullType, ValueInstantiator vi, TypeDeserializer typeDeser, JsonDeserializer<?> deser) {
        super(fullType);
        this._valueInstantiator = vi;
        this._fullType = fullType;
        this._valueDeserializer = deser;
        this._valueTypeDeserializer = typeDeser;
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<?> deser;
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        if (jsonDeserializer == null) {
            deser = ctxt.findContextualValueDeserializer(this._fullType.getReferencedType(), property);
        } else {
            deser = ctxt.handleSecondaryContextualization(jsonDeserializer, property, this._fullType.getReferencedType());
        }
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        if (typeDeser != null) {
            typeDeser = typeDeser.forProperty(property);
        }
        if (deser == this._valueDeserializer && typeDeser == this._valueTypeDeserializer) {
            return this;
        }
        return withResolved(typeDeser, deser);
    }

    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    public JavaType getValueType() {
        return this._fullType;
    }

    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (valueInstantiator != null) {
            return deserialize(p, ctxt, valueInstantiator.createUsingDefault(ctxt));
        }
        T value = this._valueTypeDeserializer;
        return referenceValue(value == null ? this._valueDeserializer.deserialize(p, ctxt) : this._valueDeserializer.deserializeWithType(p, ctxt, value));
    }

    public T deserialize(JsonParser p, DeserializationContext ctxt, T reference) throws IOException {
        Object contents;
        if (this._valueDeserializer.supportsUpdate(ctxt.getConfig()).equals(Boolean.FALSE) || this._valueTypeDeserializer != null) {
            TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
            contents = typeDeserializer == null ? this._valueDeserializer.deserialize(p, ctxt) : this._valueDeserializer.deserializeWithType(p, ctxt, typeDeserializer);
        } else {
            Object contents2 = getReferenced(reference);
            if (contents2 == null) {
                TypeDeserializer typeDeserializer2 = this._valueTypeDeserializer;
                return referenceValue(typeDeserializer2 == null ? this._valueDeserializer.deserialize(p, ctxt) : this._valueDeserializer.deserializeWithType(p, ctxt, typeDeserializer2));
            }
            contents = this._valueDeserializer.deserialize(p, ctxt, contents2);
        }
        return updateReference(reference, contents);
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        if (p.getCurrentToken() == JsonToken.VALUE_NULL) {
            return getNullValue(ctxt);
        }
        TypeDeserializer typeDeserializer2 = this._valueTypeDeserializer;
        if (typeDeserializer2 == null) {
            return deserialize(p, ctxt);
        }
        return referenceValue(typeDeserializer2.deserializeTypedFromAny(p, ctxt));
    }
}
