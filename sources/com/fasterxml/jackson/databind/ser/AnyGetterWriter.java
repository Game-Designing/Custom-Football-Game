package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import java.util.Map;

public class AnyGetterWriter {
    protected final AnnotatedMember _accessor;
    protected MapSerializer _mapSerializer;
    protected final BeanProperty _property;
    protected JsonSerializer<Object> _serializer;

    public AnyGetterWriter(BeanProperty property, AnnotatedMember accessor, JsonSerializer<?> serializer) {
        this._accessor = accessor;
        this._property = property;
        this._serializer = serializer;
        if (serializer instanceof MapSerializer) {
            this._mapSerializer = (MapSerializer) serializer;
        }
    }

    public void fixAccess(SerializationConfig config) {
        this._accessor.fixAccess(config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public void getAndSerialize(Object bean, JsonGenerator gen, SerializerProvider provider) throws Exception {
        Object value = this._accessor.getValue(bean);
        if (value != null) {
            if (value instanceof Map) {
                MapSerializer mapSerializer = this._mapSerializer;
                if (mapSerializer != null) {
                    mapSerializer.serializeFields((Map) value, gen, provider);
                } else {
                    this._serializer.serialize(value, gen, provider);
                }
            } else {
                provider.reportBadDefinition(this._property.getType(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", new Object[]{this._accessor.getName(), value.getClass().getName()}));
                throw null;
            }
        }
    }

    public void getAndFilter(Object bean, JsonGenerator gen, SerializerProvider provider, PropertyFilter filter) throws Exception {
        Object value = this._accessor.getValue(bean);
        if (value != null) {
            if (value instanceof Map) {
                MapSerializer mapSerializer = this._mapSerializer;
                if (mapSerializer != null) {
                    mapSerializer.serializeFilteredAnyProperties(provider, gen, bean, (Map) value, filter, null);
                    return;
                }
                this._serializer.serialize(value, gen, provider);
                return;
            }
            provider.reportBadDefinition(this._property.getType(), String.format("Value returned by 'any-getter' (%s()) not java.util.Map but %s", new Object[]{this._accessor.getName(), value.getClass().getName()}));
            throw null;
        }
    }

    public void resolve(SerializerProvider provider) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializer = this._serializer;
        if (jsonSerializer instanceof ContextualSerializer) {
            JsonSerializer<?> ser = provider.handlePrimaryContextualization(jsonSerializer, this._property);
            this._serializer = ser;
            if (ser instanceof MapSerializer) {
                this._mapSerializer = (MapSerializer) ser;
            }
        }
    }
}
