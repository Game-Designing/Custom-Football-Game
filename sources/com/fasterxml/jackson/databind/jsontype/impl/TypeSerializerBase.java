package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public abstract class TypeSerializerBase extends TypeSerializer {
    protected final TypeIdResolver _idResolver;
    protected final BeanProperty _property;

    protected TypeSerializerBase(TypeIdResolver idRes, BeanProperty property) {
        this._idResolver = idRes;
        this._property = property;
    }

    public String getPropertyName() {
        return null;
    }

    public WritableTypeId writeTypePrefix(JsonGenerator g, WritableTypeId idMetadata) throws IOException {
        _generateTypeId(idMetadata);
        g.writeTypePrefix(idMetadata);
        return idMetadata;
    }

    public WritableTypeId writeTypeSuffix(JsonGenerator g, WritableTypeId idMetadata) throws IOException {
        g.writeTypeSuffix(idMetadata);
        return idMetadata;
    }

    /* access modifiers changed from: protected */
    public void _generateTypeId(WritableTypeId idMetadata) {
        Object id;
        if (idMetadata.f12553id == null) {
            Object value = idMetadata.forValue;
            Class<?> typeForId = idMetadata.forValueType;
            if (typeForId == null) {
                id = idFromValue(value);
            } else {
                id = idFromValueAndType(value, typeForId);
            }
            idMetadata.f12553id = id;
        }
    }

    /* access modifiers changed from: protected */
    public String idFromValue(Object value) {
        String id = this._idResolver.idFromValue(value);
        if (id == null) {
            handleMissingId(value);
        }
        return id;
    }

    /* access modifiers changed from: protected */
    public String idFromValueAndType(Object value, Class<?> type) {
        String id = this._idResolver.idFromValueAndType(value, type);
        if (id == null) {
            handleMissingId(value);
        }
        return id;
    }

    /* access modifiers changed from: protected */
    public void handleMissingId(Object value) {
    }
}
