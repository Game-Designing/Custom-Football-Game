package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.io.Serializable;

public class ObjectIdReader implements Serializable {
    protected final JsonDeserializer<Object> _deserializer;
    protected final JavaType _idType;
    public final ObjectIdGenerator<?> generator;
    public final SettableBeanProperty idProperty;
    public final PropertyName propertyName;
    public final ObjectIdResolver resolver;

    protected ObjectIdReader(JavaType t, PropertyName propName, ObjectIdGenerator<?> gen, JsonDeserializer<?> deser, SettableBeanProperty idProp, ObjectIdResolver resolver2) {
        this._idType = t;
        this.propertyName = propName;
        this.generator = gen;
        this.resolver = resolver2;
        this._deserializer = deser;
        this.idProperty = idProp;
    }

    public static ObjectIdReader construct(JavaType idType, PropertyName propName, ObjectIdGenerator<?> generator2, JsonDeserializer<?> deser, SettableBeanProperty idProp, ObjectIdResolver resolver2) {
        ObjectIdReader objectIdReader = new ObjectIdReader(idType, propName, generator2, deser, idProp, resolver2);
        return objectIdReader;
    }

    public JsonDeserializer<Object> getDeserializer() {
        return this._deserializer;
    }

    public JavaType getIdType() {
        return this._idType;
    }

    public boolean maySerializeAsObject() {
        return this.generator.maySerializeAsObject();
    }

    public boolean isValidReferencePropertyName(String name, JsonParser parser) {
        return this.generator.isValidReferencePropertyName(name, parser);
    }

    public Object readObjectReference(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return this._deserializer.deserialize(jp, ctxt);
    }
}
