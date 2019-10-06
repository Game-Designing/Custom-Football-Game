package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p134io.SerializedString;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;

public class UnwrappingBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    protected final NameTransformer _nameTransformer;

    public UnwrappingBeanPropertyWriter(BeanPropertyWriter base, NameTransformer unwrapper) {
        super(base);
        this._nameTransformer = unwrapper;
    }

    protected UnwrappingBeanPropertyWriter(UnwrappingBeanPropertyWriter base, NameTransformer transformer, SerializedString name) {
        super((BeanPropertyWriter) base, name);
        this._nameTransformer = transformer;
    }

    public UnwrappingBeanPropertyWriter rename(NameTransformer transformer) {
        return _new(NameTransformer.chainedTransformer(transformer, this._nameTransformer), new SerializedString(transformer.transform(this._name.getValue())));
    }

    /* access modifiers changed from: protected */
    public UnwrappingBeanPropertyWriter _new(NameTransformer transformer, SerializedString newName) {
        return new UnwrappingBeanPropertyWriter(this, transformer, newName);
    }

    public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
        Object value = get(bean);
        if (value != null) {
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
                        return;
                    }
                } else if (obj.equals(value)) {
                    return;
                }
            }
            if (value != bean || !_handleSelfReference(bean, gen, prov, ser)) {
                if (!ser.isUnwrappingSerializer()) {
                    gen.writeFieldName((SerializableString) this._name);
                }
                TypeSerializer typeSerializer = this._typeSerializer;
                if (typeSerializer == null) {
                    ser.serialize(value, gen, prov);
                } else {
                    ser.serializeWithType(value, gen, prov, typeSerializer);
                }
            }
        }
    }

    public void assignSerializer(JsonSerializer<Object> ser) {
        if (ser != null) {
            NameTransformer t = this._nameTransformer;
            if (ser.isUnwrappingSerializer()) {
                t = NameTransformer.chainedTransformer(t, ((UnwrappingBeanSerializer) ser)._nameTransformer);
            }
            ser = ser.unwrappingSerializer(t);
        }
        super.assignSerializer(ser);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, Class<?> type, SerializerProvider provider) throws JsonMappingException {
        JsonSerializer<Object> serializer;
        JavaType javaType = this._nonTrivialBaseType;
        if (javaType != null) {
            serializer = provider.findValueSerializer(provider.constructSpecializedType(javaType, type), (BeanProperty) this);
        } else {
            serializer = provider.findValueSerializer(type, (BeanProperty) this);
        }
        NameTransformer t = this._nameTransformer;
        if (serializer.isUnwrappingSerializer()) {
            t = NameTransformer.chainedTransformer(t, ((UnwrappingBeanSerializer) serializer)._nameTransformer);
        }
        JsonSerializer<Object> serializer2 = serializer.unwrappingSerializer(t);
        this._dynamicSerializers = this._dynamicSerializers.newWith(type, serializer2);
        return serializer2;
    }
}
