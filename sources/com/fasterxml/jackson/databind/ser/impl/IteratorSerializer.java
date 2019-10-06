package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import java.io.IOException;
import java.util.Iterator;

@JacksonStdImpl
public class IteratorSerializer extends AsArraySerializerBase<Iterator<?>> {
    public IteratorSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts) {
        super(Iterator.class, elemType, staticTyping, vts, null);
    }

    public IteratorSerializer(IteratorSerializer src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> valueSerializer, Boolean unwrapSingle) {
        super((AsArraySerializerBase<?>) src, property, vts, valueSerializer, unwrapSingle);
    }

    public boolean isEmpty(SerializerProvider prov, Iterator<?> value) {
        return !value.hasNext();
    }

    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) {
        IteratorSerializer iteratorSerializer = new IteratorSerializer(this, this._property, vts, this._elementSerializer, this._unwrapSingle);
        return iteratorSerializer;
    }

    public IteratorSerializer withResolved(BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer, Boolean unwrapSingle) {
        IteratorSerializer iteratorSerializer = new IteratorSerializer(this, property, vts, elementSerializer, unwrapSingle);
        return iteratorSerializer;
    }

    public final void serialize(Iterator<?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartArray();
        serializeContents(value, gen, provider);
        gen.writeEndArray();
    }

    public void serializeContents(Iterator<?> value, JsonGenerator g, SerializerProvider provider) throws IOException {
        if (value.hasNext()) {
            JsonSerializer<Object> serializer = this._elementSerializer;
            if (serializer == null) {
                _serializeDynamicContents(value, g, provider);
                return;
            }
            TypeSerializer typeSer = this._valueTypeSerializer;
            do {
                Object elem = value.next();
                if (elem == null) {
                    provider.defaultSerializeNull(g);
                } else if (typeSer == null) {
                    serializer.serialize(elem, g, provider);
                } else {
                    serializer.serializeWithType(elem, g, provider, typeSer);
                }
            } while (value.hasNext());
        }
    }

    /* access modifiers changed from: protected */
    public void _serializeDynamicContents(Iterator<?> value, JsonGenerator g, SerializerProvider provider) throws IOException {
        JsonSerializer<Object> serializer = this._elementSerializer;
        TypeSerializer typeSer = this._valueTypeSerializer;
        PropertySerializerMap serializers = this._dynamicSerializers;
        do {
            Object elem = value.next();
            if (elem == null) {
                provider.defaultSerializeNull(g);
            } else {
                Class<?> cc = elem.getClass();
                serializers.serializerFor(cc);
                if (serializer == null) {
                    if (this._elementType.hasGenericTypes()) {
                        serializer = _findAndAddDynamic(serializers, provider.constructSpecializedType(this._elementType, cc), provider);
                    } else {
                        serializer = _findAndAddDynamic(serializers, cc, provider);
                    }
                    serializers = this._dynamicSerializers;
                }
                if (typeSer == null) {
                    serializer.serialize(elem, g, provider);
                } else {
                    serializer.serializeWithType(elem, g, provider, typeSer);
                }
            }
        } while (value.hasNext());
    }
}
