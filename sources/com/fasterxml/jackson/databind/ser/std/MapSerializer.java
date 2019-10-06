package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

@JacksonStdImpl
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements ContextualSerializer {
    public static final Object MARKER_FOR_EMPTY = Include.NON_EMPTY;
    protected static final JavaType UNSPECIFIED_TYPE = TypeFactory.unknownType();
    protected PropertySerializerMap _dynamicValueSerializers;
    protected final Object _filterId;
    protected final Set<String> _ignoredEntries;
    protected JsonSerializer<Object> _keySerializer;
    protected final JavaType _keyType;
    protected final BeanProperty _property;
    protected final boolean _sortKeys;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected JsonSerializer<Object> _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final TypeSerializer _valueTypeSerializer;

    /* renamed from: com.fasterxml.jackson.databind.ser.std.MapSerializer$1 */
    static /* synthetic */ class C68391 {
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

    protected MapSerializer(Set<String> ignoredEntries, JavaType keyType, JavaType valueType, boolean valueTypeIsStatic, TypeSerializer vts, JsonSerializer<?> keySerializer, JsonSerializer<?> valueSerializer) {
        super(Map.class, false);
        this._ignoredEntries = (ignoredEntries == null || ignoredEntries.isEmpty()) ? null : ignoredEntries;
        this._keyType = keyType;
        this._valueType = valueType;
        this._valueTypeIsStatic = valueTypeIsStatic;
        this._valueTypeSerializer = vts;
        this._keySerializer = keySerializer;
        this._valueSerializer = valueSerializer;
        this._dynamicValueSerializers = PropertySerializerMap.emptyForProperties();
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
        this._suppressNulls = false;
    }

    protected MapSerializer(MapSerializer src, BeanProperty property, JsonSerializer<?> keySerializer, JsonSerializer<?> valueSerializer, Set<String> ignoredEntries) {
        super(Map.class, false);
        this._ignoredEntries = (ignoredEntries == null || ignoredEntries.isEmpty()) ? null : ignoredEntries;
        this._keyType = src._keyType;
        this._valueType = src._valueType;
        this._valueTypeIsStatic = src._valueTypeIsStatic;
        this._valueTypeSerializer = src._valueTypeSerializer;
        this._keySerializer = keySerializer;
        this._valueSerializer = valueSerializer;
        this._dynamicValueSerializers = src._dynamicValueSerializers;
        this._property = property;
        this._filterId = src._filterId;
        this._sortKeys = src._sortKeys;
        this._suppressableValue = src._suppressableValue;
        this._suppressNulls = src._suppressNulls;
    }

    protected MapSerializer(MapSerializer src, TypeSerializer vts, Object suppressableValue, boolean suppressNulls) {
        super(Map.class, false);
        this._ignoredEntries = src._ignoredEntries;
        this._keyType = src._keyType;
        this._valueType = src._valueType;
        this._valueTypeIsStatic = src._valueTypeIsStatic;
        this._valueTypeSerializer = vts;
        this._keySerializer = src._keySerializer;
        this._valueSerializer = src._valueSerializer;
        this._dynamicValueSerializers = src._dynamicValueSerializers;
        this._property = src._property;
        this._filterId = src._filterId;
        this._sortKeys = src._sortKeys;
        this._suppressableValue = suppressableValue;
        this._suppressNulls = suppressNulls;
    }

    protected MapSerializer(MapSerializer src, Object filterId, boolean sortKeys) {
        super(Map.class, false);
        this._ignoredEntries = src._ignoredEntries;
        this._keyType = src._keyType;
        this._valueType = src._valueType;
        this._valueTypeIsStatic = src._valueTypeIsStatic;
        this._valueTypeSerializer = src._valueTypeSerializer;
        this._keySerializer = src._keySerializer;
        this._valueSerializer = src._valueSerializer;
        this._dynamicValueSerializers = src._dynamicValueSerializers;
        this._property = src._property;
        this._filterId = filterId;
        this._sortKeys = sortKeys;
        this._suppressableValue = src._suppressableValue;
        this._suppressNulls = src._suppressNulls;
    }

    public MapSerializer _withValueTypeSerializer(TypeSerializer vts) {
        if (this._valueTypeSerializer == vts) {
            return this;
        }
        _ensureOverride("_withValueTypeSerializer");
        return new MapSerializer(this, vts, this._suppressableValue, this._suppressNulls);
    }

    public MapSerializer withResolved(BeanProperty property, JsonSerializer<?> keySerializer, JsonSerializer<?> valueSerializer, Set<String> ignored, boolean sortKeys) {
        _ensureOverride("withResolved");
        MapSerializer mapSerializer = new MapSerializer(this, property, keySerializer, valueSerializer, ignored);
        if (sortKeys != mapSerializer._sortKeys) {
            return new MapSerializer(mapSerializer, this._filterId, sortKeys);
        }
        return mapSerializer;
    }

    public MapSerializer withFilterId(Object filterId) {
        if (this._filterId == filterId) {
            return this;
        }
        _ensureOverride("withFilterId");
        return new MapSerializer(this, filterId, this._sortKeys);
    }

    public MapSerializer withContentInclusion(Object suppressableValue, boolean suppressNulls) {
        if (suppressableValue == this._suppressableValue && suppressNulls == this._suppressNulls) {
            return this;
        }
        _ensureOverride("withContentInclusion");
        return new MapSerializer(this, this._valueTypeSerializer, suppressableValue, suppressNulls);
    }

    public static MapSerializer construct(Set<String> ignoredEntries, JavaType mapType, boolean staticValueType, TypeSerializer vts, JsonSerializer<Object> keySerializer, JsonSerializer<Object> valueSerializer, Object filterId) {
        JavaType valueType;
        JavaType keyType;
        boolean staticValueType2;
        Object obj = filterId;
        if (mapType == null) {
            keyType = UNSPECIFIED_TYPE;
            valueType = keyType;
        } else {
            keyType = mapType.getKeyType();
            valueType = mapType.getContentType();
        }
        if (!staticValueType) {
            staticValueType2 = valueType != null && valueType.isFinal();
        } else if (valueType.getRawClass() == Object.class) {
            staticValueType2 = false;
        } else {
            staticValueType2 = staticValueType;
        }
        MapSerializer ser = new MapSerializer(ignoredEntries, keyType, valueType, staticValueType2, vts, keySerializer, valueSerializer);
        if (obj != null) {
            return ser.withFilterId(obj);
        }
        return ser;
    }

    /* access modifiers changed from: protected */
    public void _ensureOverride(String method) {
        ClassUtil.verifyMustOverride(MapSerializer.class, this, method);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r20, com.fasterxml.jackson.databind.BeanProperty r21) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r19 = this;
            r6 = r19
            r7 = r20
            r8 = r21
            r0 = 0
            r1 = 0
            com.fasterxml.jackson.databind.AnnotationIntrospector r9 = r20.getAnnotationIntrospector()
            r10 = 0
            if (r8 != 0) goto L_0x0011
            r2 = r10
            goto L_0x0015
        L_0x0011:
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r21.getMember()
        L_0x0015:
            r11 = r2
            boolean r2 = com.fasterxml.jackson.databind.ser.std.StdSerializer._neitherNull(r11, r9)
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r9.findKeySerializer(r11)
            if (r2 == 0) goto L_0x0026
            com.fasterxml.jackson.databind.JsonSerializer r1 = r7.serializerInstance(r11, r2)
        L_0x0026:
            java.lang.Object r2 = r9.findContentSerializer(r11)
            if (r2 == 0) goto L_0x0030
            com.fasterxml.jackson.databind.JsonSerializer r0 = r7.serializerInstance(r11, r2)
        L_0x0030:
            if (r0 != 0) goto L_0x0034
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r0 = r6._valueSerializer
        L_0x0034:
            com.fasterxml.jackson.databind.JsonSerializer r0 = r6.findContextualConvertingSerializer(r7, r8, r0)
            if (r0 != 0) goto L_0x004e
            boolean r2 = r6._valueTypeIsStatic
            if (r2 == 0) goto L_0x004e
            com.fasterxml.jackson.databind.JavaType r2 = r6._valueType
            boolean r2 = r2.isJavaLangObject()
            if (r2 != 0) goto L_0x004e
            com.fasterxml.jackson.databind.JavaType r2 = r6._valueType
            com.fasterxml.jackson.databind.JsonSerializer r0 = r7.findValueSerializer(r2, r8)
            r12 = r0
            goto L_0x004f
        L_0x004e:
            r12 = r0
        L_0x004f:
            if (r1 != 0) goto L_0x0053
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r1 = r6._keySerializer
        L_0x0053:
            if (r1 != 0) goto L_0x005d
            com.fasterxml.jackson.databind.JavaType r0 = r6._keyType
            com.fasterxml.jackson.databind.JsonSerializer r0 = r7.findKeySerializer(r0, r8)
            r13 = r0
            goto L_0x0062
        L_0x005d:
            com.fasterxml.jackson.databind.JsonSerializer r0 = r7.handleSecondaryContextualization(r1, r8)
            r13 = r0
        L_0x0062:
            java.util.Set<java.lang.String> r0 = r6._ignoredEntries
            r1 = 0
            boolean r2 = com.fasterxml.jackson.databind.ser.std.StdSerializer._neitherNull(r11, r9)
            if (r2 == 0) goto L_0x00a9
            com.fasterxml.jackson.annotation.JsonIgnoreProperties$Value r2 = r9.findPropertyIgnorals(r11)
            if (r2 == 0) goto L_0x009d
            java.util.Set r3 = r2.findIgnoredForSerialization()
            boolean r4 = com.fasterxml.jackson.databind.ser.std.StdSerializer._nonEmpty(r3)
            if (r4 == 0) goto L_0x009d
            if (r0 != 0) goto L_0x0083
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            goto L_0x0088
        L_0x0083:
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>(r0)
        L_0x0088:
            r0 = r4
            java.util.Iterator r4 = r3.iterator()
        L_0x008d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x009d
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            r0.add(r5)
            goto L_0x008d
        L_0x009d:
            java.lang.Boolean r3 = r9.findSerializationSortAlphabetically(r11)
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            boolean r1 = r4.equals(r3)
            r14 = r0
            goto L_0x00aa
        L_0x00a9:
            r14 = r0
        L_0x00aa:
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            com.fasterxml.jackson.annotation.JsonFormat$Value r15 = r6.findFormatOverrides(r7, r8, r0)
            if (r15 == 0) goto L_0x00c1
            com.fasterxml.jackson.annotation.JsonFormat$Feature r0 = com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_SORTED_MAP_ENTRIES
            java.lang.Boolean r0 = r15.getFeature(r0)
            if (r0 == 0) goto L_0x00c1
            boolean r1 = r0.booleanValue()
            r16 = r1
            goto L_0x00c3
        L_0x00c1:
            r16 = r1
        L_0x00c3:
            r0 = r19
            r1 = r21
            r2 = r13
            r3 = r12
            r4 = r14
            r5 = r16
            com.fasterxml.jackson.databind.ser.std.MapSerializer r0 = r0.withResolved(r1, r2, r3, r4, r5)
            if (r8 == 0) goto L_0x0173
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r1 = r21.getMember()
            if (r1 == 0) goto L_0x00e2
            java.lang.Object r2 = r9.findFilterId(r1)
            if (r2 == 0) goto L_0x00e2
            com.fasterxml.jackson.databind.ser.std.MapSerializer r0 = r0.withFilterId(r2)
        L_0x00e2:
            com.fasterxml.jackson.databind.SerializationConfig r2 = r20.getConfig()
            com.fasterxml.jackson.annotation.JsonInclude$Value r2 = r8.findPropertyInclusion(r2, r10)
            if (r2 == 0) goto L_0x0171
            com.fasterxml.jackson.annotation.JsonInclude$Include r3 = r2.getContentInclusion()
            com.fasterxml.jackson.annotation.JsonInclude$Include r4 = com.fasterxml.jackson.annotation.JsonInclude.Include.USE_DEFAULTS
            if (r3 == r4) goto L_0x016e
            int[] r4 = com.fasterxml.jackson.databind.ser.std.MapSerializer.C68391.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include
            int r5 = r3.ordinal()
            r4 = r4[r5]
            r5 = 1
            if (r4 == r5) goto L_0x0150
            r5 = 2
            r17 = 0
            if (r4 == r5) goto L_0x013e
            r5 = 3
            if (r4 == r5) goto L_0x0135
            r5 = 4
            if (r4 == r5) goto L_0x011d
            r5 = 5
            if (r4 == r5) goto L_0x0115
            r4 = r10
            r5 = r17
            r4 = 0
            r5 = 0
            r18 = r1
            goto L_0x0169
        L_0x0115:
            r4 = r10
            r5 = r17
            r4 = 0
            r5 = 1
            r18 = r1
            goto L_0x0169
        L_0x011d:
            r4 = r17
            r5 = r10
            r18 = r1
            java.lang.Class r1 = r2.getContentFilter()
            java.lang.Object r1 = r7.includeFilterInstance(r10, r1)
            if (r1 != 0) goto L_0x012f
            r5 = 1
            r4 = r1
            goto L_0x0169
        L_0x012f:
            boolean r5 = r7.includeFilterSuppressNulls(r1)
            r4 = r1
            goto L_0x0169
        L_0x0135:
            r18 = r1
            r1 = r17
            r4 = r10
            r5 = 1
            java.lang.Object r4 = MARKER_FOR_EMPTY
            goto L_0x0169
        L_0x013e:
            r18 = r1
            r1 = r17
            r4 = r10
            r5 = 1
            com.fasterxml.jackson.databind.JavaType r1 = r6._valueType
            boolean r1 = r1.isReferenceType()
            if (r1 == 0) goto L_0x014e
            java.lang.Object r10 = MARKER_FOR_EMPTY
        L_0x014e:
            r4 = r10
            goto L_0x0169
        L_0x0150:
            r18 = r1
            com.fasterxml.jackson.databind.JavaType r1 = r6._valueType
            java.lang.Object r4 = com.fasterxml.jackson.databind.util.BeanUtil.getDefaultValue(r1)
            r5 = 1
            if (r4 == 0) goto L_0x0169
            java.lang.Class r1 = r4.getClass()
            boolean r1 = r1.isArray()
            if (r1 == 0) goto L_0x0169
            java.lang.Object r4 = com.fasterxml.jackson.databind.util.ArrayBuilders.getArrayComparator(r4)
        L_0x0169:
            com.fasterxml.jackson.databind.ser.std.MapSerializer r0 = r0.withContentInclusion(r4, r5)
            goto L_0x0173
        L_0x016e:
            r18 = r1
            goto L_0x0173
        L_0x0171:
            r18 = r1
        L_0x0173:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer");
    }

    public JavaType getContentType() {
        return this._valueType;
    }

    public boolean isEmpty(SerializerProvider prov, Map<?, ?> value) {
        if (value.isEmpty()) {
            return true;
        }
        Object supp = this._suppressableValue;
        if (supp == null && !this._suppressNulls) {
            return false;
        }
        JsonSerializer<Object> valueSer = this._valueSerializer;
        boolean checkEmpty = MARKER_FOR_EMPTY == supp;
        if (valueSer != null) {
            for (Object elemValue : value.values()) {
                if (elemValue == null) {
                    if (!this._suppressNulls) {
                        return false;
                    }
                } else if (checkEmpty) {
                    if (!valueSer.isEmpty(prov, elemValue)) {
                        return false;
                    }
                } else if (supp == null || !supp.equals(value)) {
                    return false;
                }
            }
            return true;
        }
        for (Object elemValue2 : value.values()) {
            if (elemValue2 != null) {
                try {
                    JsonSerializer _findSerializer = _findSerializer(prov, elemValue2);
                    if (checkEmpty) {
                        if (!_findSerializer.isEmpty(prov, elemValue2)) {
                            return false;
                        }
                    } else if (supp == null || !supp.equals(value)) {
                        return false;
                    }
                } catch (JsonMappingException e) {
                    return false;
                }
            } else if (!this._suppressNulls) {
                return false;
            }
        }
        return true;
    }

    public void serialize(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject(value);
        if (!value.isEmpty()) {
            if (this._sortKeys || provider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                value = _orderEntries(value, gen, provider);
            }
            Object obj = this._filterId;
            if (obj != null) {
                PropertyFilter findPropertyFilter = findPropertyFilter(provider, obj, value);
                PropertyFilter pf = findPropertyFilter;
                if (findPropertyFilter != null) {
                    serializeFilteredFields(value, gen, provider, pf, this._suppressableValue);
                }
            }
            if (this._suppressableValue != null || this._suppressNulls) {
                serializeOptionalFields(value, gen, provider, this._suppressableValue);
            } else {
                JsonSerializer<Object> jsonSerializer = this._valueSerializer;
                if (jsonSerializer != null) {
                    serializeFieldsUsing(value, gen, provider, jsonSerializer);
                } else {
                    serializeFields(value, gen, provider);
                }
            }
        }
        gen.writeEndObject();
    }

    public void serializeWithType(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        gen.setCurrentValue(value);
        WritableTypeId typeIdDef = typeSer.writeTypePrefix(gen, typeSer.typeId(value, JsonToken.START_OBJECT));
        if (!value.isEmpty()) {
            if (this._sortKeys || provider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                value = _orderEntries(value, gen, provider);
            }
            Object obj = this._filterId;
            if (obj != null) {
                PropertyFilter findPropertyFilter = findPropertyFilter(provider, obj, value);
                PropertyFilter pf = findPropertyFilter;
                if (findPropertyFilter != null) {
                    serializeFilteredFields(value, gen, provider, pf, this._suppressableValue);
                }
            }
            if (this._suppressableValue != null || this._suppressNulls) {
                serializeOptionalFields(value, gen, provider, this._suppressableValue);
            } else {
                JsonSerializer<Object> jsonSerializer = this._valueSerializer;
                if (jsonSerializer != null) {
                    serializeFieldsUsing(value, gen, provider, jsonSerializer);
                } else {
                    serializeFields(value, gen, provider);
                }
            }
        }
        typeSer.writeTypeSuffix(gen, typeIdDef);
    }

    public void serializeFields(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(value, gen, provider, null);
            return;
        }
        JsonSerializer<Object> keySerializer = this._keySerializer;
        Set<String> ignored = this._ignoredEntries;
        try {
            for (Entry<?, ?> entry : value.entrySet()) {
                Object valueElem = entry.getValue();
                Object keyElem = entry.getKey();
                if (keyElem == null) {
                    provider.findNullKeySerializer(this._keyType, this._property).serialize(null, gen, provider);
                } else if (ignored == null || !ignored.contains(keyElem)) {
                    keySerializer.serialize(keyElem, gen, provider);
                }
                if (valueElem == null) {
                    provider.defaultSerializeNull(gen);
                } else {
                    JsonSerializer<Object> serializer = this._valueSerializer;
                    if (serializer == null) {
                        serializer = _findSerializer(provider, valueElem);
                    }
                    serializer.serialize(valueElem, gen, provider);
                }
            }
        } catch (Exception e) {
            wrapAndThrow(provider, (Throwable) e, (Object) value, String.valueOf(null));
            throw null;
        }
    }

    public void serializeOptionalFields(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, Object suppressableValue) throws IOException {
        JsonSerializer<Object> keySerializer;
        JsonSerializer<Object> valueSer;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(value, gen, provider, suppressableValue);
            return;
        }
        Set<String> ignored = this._ignoredEntries;
        boolean checkEmpty = MARKER_FOR_EMPTY == suppressableValue;
        for (Entry<?, ?> entry : value.entrySet()) {
            Object keyElem = entry.getKey();
            if (keyElem == null) {
                keySerializer = provider.findNullKeySerializer(this._keyType, this._property);
            } else if (ignored == null || !ignored.contains(keyElem)) {
                keySerializer = this._keySerializer;
            }
            Object valueElem = entry.getValue();
            if (valueElem != null) {
                valueSer = this._valueSerializer;
                if (valueSer == null) {
                    valueSer = _findSerializer(provider, valueElem);
                }
                if (checkEmpty) {
                    if (valueSer.isEmpty(provider, valueElem)) {
                    }
                } else if (suppressableValue != null && suppressableValue.equals(valueElem)) {
                }
            } else if (!this._suppressNulls) {
                valueSer = provider.getDefaultNullValueSerializer();
            }
            try {
                keySerializer.serialize(keyElem, gen, provider);
                valueSer.serialize(valueElem, gen, provider);
            } catch (Exception e) {
                wrapAndThrow(provider, (Throwable) e, (Object) value, String.valueOf(keyElem));
                throw null;
            }
        }
    }

    public void serializeFieldsUsing(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, JsonSerializer<Object> ser) throws IOException {
        JsonSerializer<Object> keySerializer = this._keySerializer;
        Set<String> ignored = this._ignoredEntries;
        TypeSerializer typeSer = this._valueTypeSerializer;
        for (Entry<?, ?> entry : value.entrySet()) {
            Object keyElem = entry.getKey();
            if (ignored == null || !ignored.contains(keyElem)) {
                if (keyElem == null) {
                    provider.findNullKeySerializer(this._keyType, this._property).serialize(null, gen, provider);
                } else {
                    keySerializer.serialize(keyElem, gen, provider);
                }
                Object valueElem = entry.getValue();
                if (valueElem == null) {
                    provider.defaultSerializeNull(gen);
                } else if (typeSer == null) {
                    try {
                        ser.serialize(valueElem, gen, provider);
                    } catch (Exception e) {
                        wrapAndThrow(provider, (Throwable) e, (Object) value, String.valueOf(keyElem));
                        throw null;
                    }
                } else {
                    ser.serializeWithType(valueElem, gen, provider, typeSer);
                }
            }
        }
    }

    public void serializeFilteredFields(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, PropertyFilter filter, Object suppressableValue) throws IOException {
        JsonSerializer<Object> keySerializer;
        JsonSerializer<Object> valueSer;
        Set<String> ignored = this._ignoredEntries;
        MapProperty prop = new MapProperty(this._valueTypeSerializer, this._property);
        boolean checkEmpty = MARKER_FOR_EMPTY == suppressableValue;
        for (Entry<?, ?> entry : value.entrySet()) {
            Object keyElem = entry.getKey();
            if (ignored == null || !ignored.contains(keyElem)) {
                if (keyElem == null) {
                    keySerializer = provider.findNullKeySerializer(this._keyType, this._property);
                } else {
                    keySerializer = this._keySerializer;
                }
                Object valueElem = entry.getValue();
                if (valueElem != null) {
                    valueSer = this._valueSerializer;
                    if (valueSer == null) {
                        valueSer = _findSerializer(provider, valueElem);
                    }
                    if (checkEmpty) {
                        if (valueSer.isEmpty(provider, valueElem)) {
                        }
                    } else if (suppressableValue != null && suppressableValue.equals(valueElem)) {
                    }
                } else if (!this._suppressNulls) {
                    valueSer = provider.getDefaultNullValueSerializer();
                }
                prop.reset(keyElem, valueElem, keySerializer, valueSer);
                try {
                    filter.serializeAsField(value, gen, provider, prop);
                } catch (Exception e) {
                    wrapAndThrow(provider, (Throwable) e, (Object) value, String.valueOf(keyElem));
                    throw null;
                }
            }
        }
    }

    public void serializeTypedFields(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, Object suppressableValue) throws IOException {
        JsonSerializer<Object> keySerializer;
        JsonSerializer<Object> valueSer;
        Set<String> ignored = this._ignoredEntries;
        boolean checkEmpty = MARKER_FOR_EMPTY == suppressableValue;
        for (Entry<?, ?> entry : value.entrySet()) {
            Object keyElem = entry.getKey();
            if (keyElem == null) {
                keySerializer = provider.findNullKeySerializer(this._keyType, this._property);
            } else if (ignored == null || !ignored.contains(keyElem)) {
                keySerializer = this._keySerializer;
            }
            Object valueElem = entry.getValue();
            if (valueElem != null) {
                valueSer = this._valueSerializer;
                if (valueSer == null) {
                    valueSer = _findSerializer(provider, valueElem);
                }
                if (checkEmpty) {
                    if (valueSer.isEmpty(provider, valueElem)) {
                    }
                } else if (suppressableValue != null && suppressableValue.equals(valueElem)) {
                }
            } else if (!this._suppressNulls) {
                valueSer = provider.getDefaultNullValueSerializer();
            }
            keySerializer.serialize(keyElem, gen, provider);
            try {
                valueSer.serializeWithType(valueElem, gen, provider, this._valueTypeSerializer);
            } catch (Exception e) {
                wrapAndThrow(provider, (Throwable) e, (Object) value, String.valueOf(keyElem));
                throw null;
            }
        }
    }

    public void serializeFilteredAnyProperties(SerializerProvider provider, JsonGenerator gen, Object bean, Map<?, ?> value, PropertyFilter filter, Object suppressableValue) throws IOException {
        JsonSerializer<Object> keySerializer;
        JsonSerializer<Object> valueSer;
        SerializerProvider serializerProvider = provider;
        Object obj = suppressableValue;
        Set<String> ignored = this._ignoredEntries;
        MapProperty prop = new MapProperty(this._valueTypeSerializer, this._property);
        boolean checkEmpty = MARKER_FOR_EMPTY == obj;
        for (Entry<?, ?> entry : value.entrySet()) {
            Object keyElem = entry.getKey();
            if (ignored == null || !ignored.contains(keyElem)) {
                if (keyElem == null) {
                    keySerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
                } else {
                    keySerializer = this._keySerializer;
                }
                Object valueElem = entry.getValue();
                if (valueElem != null) {
                    valueSer = this._valueSerializer;
                    if (valueSer == null) {
                        valueSer = _findSerializer(serializerProvider, valueElem);
                    }
                    if (checkEmpty) {
                        if (valueSer.isEmpty(serializerProvider, valueElem)) {
                        }
                    } else if (obj != null && obj.equals(valueElem)) {
                    }
                } else if (!this._suppressNulls) {
                    valueSer = provider.getDefaultNullValueSerializer();
                }
                prop.reset(keyElem, valueElem, keySerializer, valueSer);
                try {
                    filter.serializeAsField(bean, gen, serializerProvider, prop);
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) value, String.valueOf(keyElem));
                    throw null;
                }
            }
        }
        JsonGenerator jsonGenerator = gen;
        Object obj2 = bean;
        Map<?, ?> map = value;
        PropertyFilter propertyFilter = filter;
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

    /* access modifiers changed from: protected */
    public Map<?, ?> _orderEntries(Map<?, ?> input, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (input instanceof SortedMap) {
            return input;
        }
        if (!_hasNullKey(input)) {
            return new TreeMap(input);
        }
        TreeMap<Object, Object> result = new TreeMap<>();
        for (Entry<?, ?> entry : input.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                _writeNullKeyedEntry(gen, provider, entry.getValue());
            } else {
                result.put(key, entry.getValue());
            }
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public boolean _hasNullKey(Map<?, ?> input) {
        return (input instanceof HashMap) && input.containsKey(null);
    }

    /* access modifiers changed from: protected */
    public void _writeNullKeyedEntry(JsonGenerator gen, SerializerProvider provider, Object value) throws IOException {
        JsonSerializer<Object> valueSer;
        JsonSerializer<Object> keySerializer = provider.findNullKeySerializer(this._keyType, this._property);
        if (value != null) {
            valueSer = this._valueSerializer;
            if (valueSer == null) {
                valueSer = _findSerializer(provider, value);
            }
            Object obj = this._suppressableValue;
            if (obj == MARKER_FOR_EMPTY) {
                if (valueSer.isEmpty(provider, value)) {
                    return;
                }
            } else if (obj != null && obj.equals(value)) {
                return;
            }
        } else if (!this._suppressNulls) {
            valueSer = provider.getDefaultNullValueSerializer();
        } else {
            return;
        }
        try {
            keySerializer.serialize(null, gen, provider);
            valueSer.serialize(value, gen, provider);
        } catch (Exception e) {
            wrapAndThrow(provider, (Throwable) e, value, "");
            throw null;
        }
    }

    private final JsonSerializer<Object> _findSerializer(SerializerProvider provider, Object value) throws JsonMappingException {
        Class<?> cc = value.getClass();
        JsonSerializer<Object> valueSer = this._dynamicValueSerializers.serializerFor(cc);
        if (valueSer != null) {
            return valueSer;
        }
        if (this._valueType.hasGenericTypes()) {
            return _findAndAddDynamic(this._dynamicValueSerializers, provider.constructSpecializedType(this._valueType, cc), provider);
        }
        return _findAndAddDynamic(this._dynamicValueSerializers, cc, provider);
    }
}
