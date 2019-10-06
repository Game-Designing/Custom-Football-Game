package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.BeanUtil;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

@JacksonStdImpl
public class MapEntrySerializer extends ContainerSerializer<Entry<?, ?>> implements ContextualSerializer {
    public static final Object MARKER_FOR_EMPTY = Include.NON_EMPTY;
    protected PropertySerializerMap _dynamicValueSerializers;
    protected final JavaType _entryType;
    protected JsonSerializer<Object> _keySerializer;
    protected final JavaType _keyType;
    protected final BeanProperty _property;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected JsonSerializer<Object> _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final TypeSerializer _valueTypeSerializer;

    /* renamed from: com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer$1 */
    static /* synthetic */ class C68371 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include = new int[Include.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.ALWAYS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public MapEntrySerializer(JavaType type, JavaType keyType, JavaType valueType, boolean staticTyping, TypeSerializer vts, BeanProperty property) {
        super(type);
        this._entryType = type;
        this._keyType = keyType;
        this._valueType = valueType;
        this._valueTypeIsStatic = staticTyping;
        this._valueTypeSerializer = vts;
        this._property = property;
        this._dynamicValueSerializers = PropertySerializerMap.emptyForProperties();
        this._suppressableValue = null;
        this._suppressNulls = false;
    }

    protected MapEntrySerializer(MapEntrySerializer src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> keySer, JsonSerializer<?> valueSer, Object suppressableValue, boolean suppressNulls) {
        super(Map.class, false);
        this._entryType = src._entryType;
        this._keyType = src._keyType;
        this._valueType = src._valueType;
        this._valueTypeIsStatic = src._valueTypeIsStatic;
        this._valueTypeSerializer = src._valueTypeSerializer;
        this._keySerializer = keySer;
        this._valueSerializer = valueSer;
        this._dynamicValueSerializers = src._dynamicValueSerializers;
        this._property = src._property;
        this._suppressableValue = suppressableValue;
        this._suppressNulls = suppressNulls;
    }

    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) {
        MapEntrySerializer mapEntrySerializer = new MapEntrySerializer(this, this._property, vts, this._keySerializer, this._valueSerializer, this._suppressableValue, this._suppressNulls);
        return mapEntrySerializer;
    }

    public MapEntrySerializer withResolved(BeanProperty property, JsonSerializer<?> keySerializer, JsonSerializer<?> valueSerializer, Object suppressableValue, boolean suppressNulls) {
        MapEntrySerializer mapEntrySerializer = new MapEntrySerializer(this, property, this._valueTypeSerializer, keySerializer, valueSerializer, suppressableValue, suppressNulls);
        return mapEntrySerializer;
    }

    public MapEntrySerializer withContentInclusion(Object suppressableValue, boolean suppressNulls) {
        if (this._suppressableValue == suppressableValue && this._suppressNulls == suppressNulls) {
            return this;
        }
        MapEntrySerializer mapEntrySerializer = new MapEntrySerializer(this, this._property, this._valueTypeSerializer, this._keySerializer, this._valueSerializer, suppressableValue, suppressNulls);
        return mapEntrySerializer;
    }

    public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property) throws JsonMappingException {
        JsonSerializer<?> keySer;
        boolean suppressNulls;
        JsonSerializer<Object> jsonSerializer = null;
        JsonSerializer<Object> jsonSerializer2 = null;
        AnnotationIntrospector intr = provider.getAnnotationIntrospector();
        Object valueToSuppress = null;
        Annotated member = property == null ? null : property.getMember();
        if (!(member == null || intr == null)) {
            Object serDef = intr.findKeySerializer(member);
            if (serDef != null) {
                jsonSerializer2 = provider.serializerInstance(member, serDef);
            }
            Object serDef2 = intr.findContentSerializer(member);
            if (serDef2 != null) {
                jsonSerializer = provider.serializerInstance(member, serDef2);
            }
        }
        if (jsonSerializer == null) {
            jsonSerializer = this._valueSerializer;
        }
        JsonSerializer<?> ser = findContextualConvertingSerializer(provider, property, jsonSerializer);
        if (ser == null && this._valueTypeIsStatic && !this._valueType.isJavaLangObject()) {
            ser = provider.findValueSerializer(this._valueType, property);
        }
        if (jsonSerializer2 == null) {
            jsonSerializer2 = this._keySerializer;
        }
        if (jsonSerializer2 == null) {
            keySer = provider.findKeySerializer(this._keyType, property);
        } else {
            keySer = provider.handleSecondaryContextualization(jsonSerializer2, property);
        }
        Object valueToSuppress2 = this._suppressableValue;
        boolean suppressNulls2 = this._suppressNulls;
        if (property != null) {
            Value inclV = property.findPropertyInclusion(provider.getConfig(), null);
            if (inclV != null) {
                Include incl = inclV.getContentInclusion();
                if (incl != Include.USE_DEFAULTS) {
                    int i = C68371.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[incl.ordinal()];
                    if (i == 1) {
                        valueToSuppress = BeanUtil.getDefaultValue(this._valueType);
                        if (valueToSuppress == null || !valueToSuppress.getClass().isArray()) {
                            suppressNulls = true;
                        } else {
                            valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress);
                            suppressNulls = true;
                        }
                    } else if (i == 2) {
                        if (this._valueType.isReferenceType()) {
                            valueToSuppress = MARKER_FOR_EMPTY;
                        }
                        suppressNulls = true;
                    } else if (i == 3) {
                        suppressNulls = true;
                        valueToSuppress = MARKER_FOR_EMPTY;
                    } else if (i == 4) {
                        valueToSuppress = provider.includeFilterInstance(null, inclV.getContentFilter());
                        suppressNulls = valueToSuppress == null ? true : provider.includeFilterSuppressNulls(valueToSuppress);
                    } else if (i != 5) {
                        valueToSuppress = null;
                        suppressNulls = false;
                    } else {
                        valueToSuppress = null;
                        suppressNulls = true;
                    }
                    return withResolved(property, keySer, ser, valueToSuppress, suppressNulls);
                }
            }
        }
        valueToSuppress = valueToSuppress2;
        suppressNulls = suppressNulls2;
        return withResolved(property, keySer, ser, valueToSuppress, suppressNulls);
    }

    public JavaType getContentType() {
        return this._valueType;
    }

    public boolean isEmpty(SerializerProvider prov, Entry<?, ?> entry) {
        Object value = entry.getValue();
        if (value == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue == null) {
            return false;
        }
        JsonSerializer<Object> valueSer = this._valueSerializer;
        if (valueSer == null) {
            Class<?> cc = value.getClass();
            valueSer = this._dynamicValueSerializers.serializerFor(cc.getClass());
            if (valueSer == null) {
                try {
                    valueSer = _findAndAddDynamic(this._dynamicValueSerializers, cc, prov);
                } catch (JsonMappingException e) {
                    return false;
                }
            }
        }
        Object obj = this._suppressableValue;
        if (obj == MARKER_FOR_EMPTY) {
            return valueSer.isEmpty(prov, value);
        }
        return obj.equals(value);
    }

    public void serialize(Entry<?, ?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject(value);
        serializeDynamic(value, gen, provider);
        gen.writeEndObject();
    }

    public void serializeWithType(Entry<?, ?> value, JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        g.setCurrentValue(value);
        WritableTypeId typeIdDef = typeSer.writeTypePrefix(g, typeSer.typeId(value, JsonToken.START_OBJECT));
        serializeDynamic(value, g, provider);
        typeSer.writeTypeSuffix(g, typeIdDef);
    }

    /* access modifiers changed from: protected */
    public void serializeDynamic(Entry<?, ?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        JsonSerializer<Object> keySerializer;
        JsonSerializer<Object> valueSer;
        TypeSerializer vts = this._valueTypeSerializer;
        Object keyElem = value.getKey();
        if (keyElem == null) {
            keySerializer = provider.findNullKeySerializer(this._keyType, this._property);
        } else {
            keySerializer = this._keySerializer;
        }
        Object valueElem = value.getValue();
        if (valueElem != null) {
            valueSer = this._valueSerializer;
            if (valueSer == null) {
                Class<?> cc = valueElem.getClass();
                valueSer = this._dynamicValueSerializers.serializerFor(cc);
                if (valueSer == null) {
                    if (this._valueType.hasGenericTypes()) {
                        valueSer = _findAndAddDynamic(this._dynamicValueSerializers, provider.constructSpecializedType(this._valueType, cc), provider);
                    } else {
                        valueSer = _findAndAddDynamic(this._dynamicValueSerializers, cc, provider);
                    }
                }
            }
            Object obj = this._suppressableValue;
            if (obj != null && ((obj == MARKER_FOR_EMPTY && valueSer.isEmpty(provider, valueElem)) || this._suppressableValue.equals(valueElem))) {
                return;
            }
        } else if (!this._suppressNulls) {
            valueSer = provider.getDefaultNullValueSerializer();
        } else {
            return;
        }
        keySerializer.serialize(keyElem, gen, provider);
        if (vts == null) {
            try {
                valueSer.serialize(valueElem, gen, provider);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(keyElem);
                wrapAndThrow(provider, (Throwable) e, (Object) value, sb.toString());
                throw null;
            }
        } else {
            valueSer.serializeWithType(valueElem, gen, provider, vts);
        }
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, Class<?> type, SerializerProvider provider) throws JsonMappingException {
        SerializerAndMapResult result = map.findAndAddSecondarySerializer(type, provider, this._property);
        PropertySerializerMap propertySerializerMap = result.map;
        if (map != propertySerializerMap) {
            this._dynamicValueSerializers = propertySerializerMap;
        }
        return result.serializer;
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, JavaType type, SerializerProvider provider) throws JsonMappingException {
        SerializerAndMapResult result = map.findAndAddSecondarySerializer(type, provider, this._property);
        PropertySerializerMap propertySerializerMap = result.map;
        if (map != propertySerializerMap) {
            this._dynamicValueSerializers = propertySerializerMap;
        }
        return result.serializer;
    }
}
