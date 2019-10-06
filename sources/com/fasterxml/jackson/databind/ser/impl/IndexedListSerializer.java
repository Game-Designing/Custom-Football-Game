package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import java.io.IOException;
import java.util.List;

@JacksonStdImpl
public final class IndexedListSerializer extends AsArraySerializerBase<List<?>> {
    public IndexedListSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> valueSerializer) {
        super(List.class, elemType, staticTyping, vts, valueSerializer);
    }

    public IndexedListSerializer(IndexedListSerializer src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> valueSerializer, Boolean unwrapSingle) {
        super((AsArraySerializerBase<?>) src, property, vts, valueSerializer, unwrapSingle);
    }

    public IndexedListSerializer withResolved(BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer, Boolean unwrapSingle) {
        IndexedListSerializer indexedListSerializer = new IndexedListSerializer(this, property, vts, elementSerializer, unwrapSingle);
        return indexedListSerializer;
    }

    public boolean isEmpty(SerializerProvider prov, List<?> value) {
        return value.isEmpty();
    }

    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) {
        IndexedListSerializer indexedListSerializer = new IndexedListSerializer(this, this._property, vts, this._elementSerializer, this._unwrapSingle);
        return indexedListSerializer;
    }

    public final void serialize(List<?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        int len = value.size();
        if (len != 1 || ((this._unwrapSingle != null || !provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this._unwrapSingle != Boolean.TRUE)) {
            gen.writeStartArray(len);
            serializeContents(value, gen, provider);
            gen.writeEndArray();
            return;
        }
        serializeContents(value, gen, provider);
    }

    public void serializeContents(List<?> value, JsonGenerator g, SerializerProvider provider) throws IOException {
        JsonSerializer<Object> jsonSerializer = this._elementSerializer;
        if (jsonSerializer != null) {
            serializeContentsUsing(value, g, provider, jsonSerializer);
        } else if (this._valueTypeSerializer != null) {
            serializeTypedContents(value, g, provider);
        } else {
            int len = value.size();
            if (len != 0) {
                try {
                    PropertySerializerMap serializers = this._dynamicSerializers;
                    for (int i = 0; i < len; i++) {
                        Object elem = value.get(i);
                        if (elem == null) {
                            provider.defaultSerializeNull(g);
                        } else {
                            Class<?> cc = elem.getClass();
                            JsonSerializer serializerFor = serializers.serializerFor(cc);
                            if (serializerFor == null) {
                                if (this._elementType.hasGenericTypes()) {
                                    serializerFor = _findAndAddDynamic(serializers, provider.constructSpecializedType(this._elementType, cc), provider);
                                } else {
                                    serializerFor = _findAndAddDynamic(serializers, cc, provider);
                                }
                                serializers = this._dynamicSerializers;
                            }
                            serializerFor.serialize(elem, g, provider);
                        }
                    }
                } catch (Exception e) {
                    wrapAndThrow(provider, (Throwable) e, (Object) value, 0);
                    throw null;
                }
            }
        }
    }

    public void serializeContentsUsing(List<?> value, JsonGenerator jgen, SerializerProvider provider, JsonSerializer<Object> ser) throws IOException {
        int len = value.size();
        if (len != 0) {
            TypeSerializer typeSer = this._valueTypeSerializer;
            for (int i = 0; i < len; i++) {
                Object elem = value.get(i);
                if (elem == null) {
                    try {
                        provider.defaultSerializeNull(jgen);
                    } catch (Exception e) {
                        wrapAndThrow(provider, (Throwable) e, (Object) value, i);
                    }
                } else if (typeSer == null) {
                    ser.serialize(elem, jgen, provider);
                } else {
                    ser.serializeWithType(elem, jgen, provider, typeSer);
                }
            }
        }
    }

    public void serializeTypedContents(List<?> value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        int len = value.size();
        if (len != 0) {
            try {
                TypeSerializer typeSer = this._valueTypeSerializer;
                PropertySerializerMap serializers = this._dynamicSerializers;
                for (int i = 0; i < len; i++) {
                    Object elem = value.get(i);
                    if (elem == null) {
                        provider.defaultSerializeNull(jgen);
                    } else {
                        Class<?> cc = elem.getClass();
                        JsonSerializer serializerFor = serializers.serializerFor(cc);
                        if (serializerFor == null) {
                            if (this._elementType.hasGenericTypes()) {
                                serializerFor = _findAndAddDynamic(serializers, provider.constructSpecializedType(this._elementType, cc), provider);
                            } else {
                                serializerFor = _findAndAddDynamic(serializers, cc, provider);
                            }
                            serializers = this._dynamicSerializers;
                        }
                        serializerFor.serializeWithType(elem, jgen, provider, typeSer);
                    }
                }
            } catch (Exception e) {
                wrapAndThrow(provider, (Throwable) e, (Object) value, 0);
                throw null;
            }
        }
    }
}
