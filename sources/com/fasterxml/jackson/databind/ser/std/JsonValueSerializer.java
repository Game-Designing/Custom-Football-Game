package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonTypeInfo.C0078As;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;

@JacksonStdImpl
public class JsonValueSerializer extends StdSerializer<Object> implements ContextualSerializer, JsonFormatVisitable, SchemaAware {
    protected final AnnotatedMember _accessor;
    protected final boolean _forceTypeInformation;
    protected final BeanProperty _property;
    protected final JsonSerializer<Object> _valueSerializer;

    static class TypeSerializerRerouter extends TypeSerializer {
        protected final Object _forObject;
        protected final TypeSerializer _typeSerializer;

        public TypeSerializerRerouter(TypeSerializer ts, Object ob) {
            this._typeSerializer = ts;
            this._forObject = ob;
        }

        public TypeSerializer forProperty(BeanProperty prop) {
            throw new UnsupportedOperationException();
        }

        public C0078As getTypeInclusion() {
            return this._typeSerializer.getTypeInclusion();
        }

        public String getPropertyName() {
            return this._typeSerializer.getPropertyName();
        }

        public WritableTypeId writeTypePrefix(JsonGenerator g, WritableTypeId typeId) throws IOException {
            typeId.forValue = this._forObject;
            return this._typeSerializer.writeTypePrefix(g, typeId);
        }

        public WritableTypeId writeTypeSuffix(JsonGenerator g, WritableTypeId typeId) throws IOException {
            return this._typeSerializer.writeTypeSuffix(g, typeId);
        }
    }

    public JsonValueSerializer(AnnotatedMember accessor, JsonSerializer<?> ser) {
        super(accessor.getType());
        this._accessor = accessor;
        this._valueSerializer = ser;
        this._property = null;
        this._forceTypeInformation = true;
    }

    public JsonValueSerializer(JsonValueSerializer src, BeanProperty property, JsonSerializer<?> ser, boolean forceTypeInfo) {
        super(_notNullClass(src.handledType()));
        this._accessor = src._accessor;
        this._valueSerializer = ser;
        this._property = property;
        this._forceTypeInformation = forceTypeInfo;
    }

    private static final Class<Object> _notNullClass(Class<?> cls) {
        return cls == null ? Object.class : cls;
    }

    public JsonValueSerializer withResolved(BeanProperty property, JsonSerializer<?> ser, boolean forceTypeInfo) {
        if (this._property == property && this._valueSerializer == ser && forceTypeInfo == this._forceTypeInformation) {
            return this;
        }
        return new JsonValueSerializer(this, property, ser, forceTypeInfo);
    }

    public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializer = this._valueSerializer;
        if (jsonSerializer != null) {
            return withResolved(property, provider.handlePrimaryContextualization(jsonSerializer, property), this._forceTypeInformation);
        }
        JavaType t = this._accessor.getType();
        if (!provider.isEnabled(MapperFeature.USE_STATIC_TYPING) && !t.isFinal()) {
            return this;
        }
        JsonSerializer<?> ser = provider.findPrimaryPropertySerializer(t, property);
        return withResolved(property, ser, isNaturalTypeWithStdHandling(t.getRawClass(), ser));
    }

    public void serialize(Object bean, JsonGenerator gen, SerializerProvider prov) throws IOException {
        try {
            Object value = this._accessor.getValue(bean);
            if (value == null) {
                prov.defaultSerializeNull(gen);
                return;
            }
            JsonSerializer<Object> ser = this._valueSerializer;
            if (ser == null) {
                ser = prov.findTypedValueSerializer(value.getClass(), true, this._property);
            }
            ser.serialize(value, gen, prov);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(this._accessor.getName());
            sb.append("()");
            wrapAndThrow(prov, (Throwable) e, bean, sb.toString());
            throw null;
        }
    }

    public void serializeWithType(Object bean, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer0) throws IOException {
        try {
            Object value = this._accessor.getValue(bean);
            if (value == null) {
                provider.defaultSerializeNull(gen);
                return;
            }
            JsonSerializer<Object> ser = this._valueSerializer;
            if (ser == null) {
                ser = provider.findValueSerializer(value.getClass(), this._property);
            } else if (this._forceTypeInformation) {
                WritableTypeId typeIdDef = typeSer0.writeTypePrefix(gen, typeSer0.typeId(bean, JsonToken.VALUE_STRING));
                ser.serialize(value, gen, provider);
                typeSer0.writeTypeSuffix(gen, typeIdDef);
                return;
            }
            ser.serializeWithType(value, gen, provider, new TypeSerializerRerouter(typeSer0, bean));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(this._accessor.getName());
            sb.append("()");
            wrapAndThrow(provider, (Throwable) e, bean, sb.toString());
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isNaturalTypeWithStdHandling(Class<?> rawType, JsonSerializer<?> ser) {
        if (rawType.isPrimitive()) {
            if (!(rawType == Integer.TYPE || rawType == Boolean.TYPE || rawType == Double.TYPE)) {
                return false;
            }
        } else if (!(rawType == String.class || rawType == Integer.class || rawType == Boolean.class || rawType == Double.class)) {
            return false;
        }
        return isDefaultSerializer(ser);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(@JsonValue serializer for method ");
        sb.append(this._accessor.getDeclaringClass());
        sb.append("#");
        sb.append(this._accessor.getName());
        sb.append(")");
        return sb.toString();
    }
}
