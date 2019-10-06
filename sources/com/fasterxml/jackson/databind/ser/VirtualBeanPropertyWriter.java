package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.util.Annotations;
import java.io.Serializable;

public abstract class VirtualBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    /* access modifiers changed from: protected */
    public abstract Object value(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception;

    public abstract VirtualBeanPropertyWriter withConfig(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, BeanPropertyDefinition beanPropertyDefinition, JavaType javaType);

    protected VirtualBeanPropertyWriter() {
    }

    protected VirtualBeanPropertyWriter(BeanPropertyDefinition propDef, Annotations contextAnnotations, JavaType declaredType, JsonSerializer<?> ser, TypeSerializer typeSer, JavaType serType, Value inclusion, Class<?>[] includeInViews) {
        super(propDef, propDef.getPrimaryMember(), contextAnnotations, declaredType, ser, typeSer, serType, _suppressNulls(inclusion), _suppressableValue(inclusion), includeInViews);
    }

    protected static boolean _suppressNulls(Value inclusion) {
        boolean z = false;
        if (inclusion == null) {
            return false;
        }
        Include incl = inclusion.getValueInclusion();
        if (!(incl == Include.ALWAYS || incl == Include.USE_DEFAULTS)) {
            z = true;
        }
        return z;
    }

    protected static Object _suppressableValue(Value inclusion) {
        if (inclusion == null) {
            return Boolean.valueOf(false);
        }
        Include incl = inclusion.getValueInclusion();
        if (incl == Include.ALWAYS || incl == Include.NON_NULL || incl == Include.USE_DEFAULTS) {
            return null;
        }
        return BeanPropertyWriter.MARKER_FOR_EMPTY;
    }

    public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
        Object value = value(bean, gen, prov);
        if (value == null) {
            if (this._nullSerializer != null) {
                gen.writeFieldName((SerializableString) this._name);
                this._nullSerializer.serialize(null, gen, prov);
            }
            return;
        }
        JsonSerializer<Object> ser = this._serializer;
        if (ser == null) {
            Class<?> cls = value.getClass();
            PropertySerializerMap m = this._dynamicSerializers;
            ser = m.serializerFor(cls);
            if (ser == null) {
                ser = _findAndAddDynamic(m, cls, prov);
            }
        }
        Object obj = this._suppressableValue;
        if (obj != null) {
            if (BeanPropertyWriter.MARKER_FOR_EMPTY == obj) {
                if (ser.isEmpty(prov, value)) {
                    return;
                }
            } else if (obj.equals(value)) {
                return;
            }
        }
        if (value != bean || !_handleSelfReference(bean, gen, prov, ser)) {
            gen.writeFieldName((SerializableString) this._name);
            TypeSerializer typeSerializer = this._typeSerializer;
            if (typeSerializer == null) {
                ser.serialize(value, gen, prov);
            } else {
                ser.serializeWithType(value, gen, prov, typeSerializer);
            }
        }
    }

    public void serializeAsElement(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
        Object value = value(bean, gen, prov);
        if (value == null) {
            JsonSerializer<Object> jsonSerializer = this._nullSerializer;
            if (jsonSerializer != null) {
                jsonSerializer.serialize(null, gen, prov);
            } else {
                gen.writeNull();
            }
            return;
        }
        JsonSerializer<Object> ser = this._serializer;
        if (ser == null) {
            Class<?> cls = value.getClass();
            PropertySerializerMap map = this._dynamicSerializers;
            ser = map.serializerFor(cls);
            if (ser == null) {
                ser = _findAndAddDynamic(map, cls, prov);
            }
        }
        Object obj = this._suppressableValue;
        if (obj != null) {
            if (BeanPropertyWriter.MARKER_FOR_EMPTY == obj) {
                if (ser.isEmpty(prov, value)) {
                    serializeAsPlaceholder(bean, gen, prov);
                    return;
                }
            } else if (obj.equals(value)) {
                serializeAsPlaceholder(bean, gen, prov);
                return;
            }
        }
        if (value != bean || !_handleSelfReference(bean, gen, prov, ser)) {
            TypeSerializer typeSerializer = this._typeSerializer;
            if (typeSerializer == null) {
                ser.serialize(value, gen, prov);
            } else {
                ser.serializeWithType(value, gen, prov, typeSerializer);
            }
        }
    }
}
