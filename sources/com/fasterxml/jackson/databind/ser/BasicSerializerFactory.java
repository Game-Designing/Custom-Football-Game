package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IteratorSerializer;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.AtomicReferenceSerializer;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.ByteBufferSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.CollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSetSerializer;
import com.fasterxml.jackson.databind.ser.std.InetAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasicSerializerFactory extends SerializerFactory implements Serializable {
    protected static final HashMap<String, JsonSerializer<?>> _concrete;
    protected static final HashMap<String, Class<? extends JsonSerializer<?>>> _concreteLazy;
    protected final SerializerFactoryConfig _factoryConfig;

    /* renamed from: com.fasterxml.jackson.databind.ser.BasicSerializerFactory$1 */
    static /* synthetic */ class C68351 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape = new int[Shape.values().length];
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
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.USE_DEFAULTS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[Shape.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[Shape.OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[Shape.ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract Iterable<Serializers> customSerializers();

    static {
        HashMap<String, Class<? extends JsonSerializer<?>>> concLazy = new HashMap<>();
        HashMap<String, JsonSerializer<?>> concrete = new HashMap<>();
        concrete.put(String.class.getName(), new StringSerializer());
        ToStringSerializer sls = ToStringSerializer.instance;
        concrete.put(StringBuffer.class.getName(), sls);
        concrete.put(StringBuilder.class.getName(), sls);
        concrete.put(Character.class.getName(), sls);
        concrete.put(Character.TYPE.getName(), sls);
        NumberSerializers.addAll(concrete);
        concrete.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
        concrete.put(Boolean.class.getName(), new BooleanSerializer(false));
        concrete.put(BigInteger.class.getName(), new NumberSerializer(BigInteger.class));
        concrete.put(BigDecimal.class.getName(), new NumberSerializer(BigDecimal.class));
        concrete.put(Calendar.class.getName(), CalendarSerializer.instance);
        concrete.put(Date.class.getName(), DateSerializer.instance);
        for (Entry<Class<?>, Object> en : StdJdkSerializers.all()) {
            Object value = en.getValue();
            if (value instanceof JsonSerializer) {
                concrete.put(((Class) en.getKey()).getName(), (JsonSerializer) value);
            } else {
                concLazy.put(((Class) en.getKey()).getName(), (Class) value);
            }
        }
        concLazy.put(TokenBuffer.class.getName(), TokenBufferSerializer.class);
        _concrete = concrete;
        _concreteLazy = concLazy;
    }

    protected BasicSerializerFactory(SerializerFactoryConfig config) {
        this._factoryConfig = config == null ? new SerializerFactoryConfig() : config;
    }

    public JsonSerializer<Object> createKeySerializer(SerializationConfig config, JavaType keyType, JsonSerializer<Object> defaultImpl) {
        BeanDescription beanDesc = config.introspectClassAnnotations(keyType.getRawClass());
        JsonSerializer<Object> jsonSerializer = null;
        if (this._factoryConfig.hasKeySerializers()) {
            for (Serializers serializers : this._factoryConfig.keySerializers()) {
                jsonSerializer = serializers.findSerializer(config, keyType, beanDesc);
                if (jsonSerializer != null) {
                    break;
                }
            }
        }
        if (jsonSerializer == null) {
            jsonSerializer = defaultImpl;
            if (jsonSerializer == null) {
                jsonSerializer = StdKeySerializers.getStdKeySerializer(config, keyType.getRawClass(), false);
                if (jsonSerializer == null) {
                    beanDesc = config.introspect(keyType);
                    AnnotatedMember am = beanDesc.findJsonValueAccessor();
                    if (am != null) {
                        JsonSerializer<?> delegate = StdKeySerializers.getStdKeySerializer(config, am.getRawType(), true);
                        if (config.canOverrideAccessModifiers()) {
                            ClassUtil.checkAndFixAccess(am.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                        }
                        jsonSerializer = new JsonValueSerializer<>(am, delegate);
                    } else {
                        jsonSerializer = StdKeySerializers.getFallbackKeySerializer(config, keyType.getRawClass());
                    }
                }
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                jsonSerializer = mod.modifyKeySerializer(config, keyType, beanDesc, jsonSerializer);
            }
        }
        return jsonSerializer;
    }

    public TypeSerializer createTypeSerializer(SerializationConfig config, JavaType baseType) {
        AnnotatedClass ac = config.introspectClassAnnotations(baseType.getRawClass()).getClassInfo();
        TypeResolverBuilder<?> b = config.getAnnotationIntrospector().findTypeResolver(config, ac, baseType);
        Collection<NamedType> subtypes = null;
        if (b == null) {
            b = config.getDefaultTyper(baseType);
        } else {
            subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByClass(config, ac);
        }
        if (b == null) {
            return null;
        }
        return b.buildTypeSerializer(config, baseType, subtypes);
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<?> findSerializerByLookup(JavaType type, SerializationConfig config, BeanDescription beanDesc, boolean staticTyping) {
        String clsName = type.getRawClass().getName();
        JsonSerializer<?> ser = (JsonSerializer) _concrete.get(clsName);
        if (ser == null) {
            Class<? extends JsonSerializer<?>> serClass = (Class) _concreteLazy.get(clsName);
            if (serClass != null) {
                return (JsonSerializer) ClassUtil.createInstance(serClass, false);
            }
        }
        return ser;
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<?> findSerializerByAnnotations(SerializerProvider prov, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        if (JsonSerializable.class.isAssignableFrom(type.getRawClass())) {
            return SerializableSerializer.instance;
        }
        AnnotatedMember valueAccessor = beanDesc.findJsonValueAccessor();
        if (valueAccessor == null) {
            return null;
        }
        if (prov.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(valueAccessor.getMember(), prov.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new JsonValueSerializer(valueAccessor, findSerializerFromAnnotation(prov, valueAccessor));
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<?> findSerializerByPrimaryType(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        JavaType javaType = type;
        BeanDescription beanDescription = beanDesc;
        Class<?> raw = type.getRawClass();
        JsonSerializer<?> ser = findOptionalStdSerializer(prov, type, beanDesc, staticTyping);
        if (ser != null) {
            return ser;
        }
        if (Calendar.class.isAssignableFrom(raw)) {
            return CalendarSerializer.instance;
        }
        if (Date.class.isAssignableFrom(raw)) {
            return DateSerializer.instance;
        }
        if (Entry.class.isAssignableFrom(raw)) {
            JavaType mapEntryType = javaType.findSuperType(Entry.class);
            return buildMapEntrySerializer(prov, type, beanDesc, staticTyping, mapEntryType.containedTypeOrUnknown(0), mapEntryType.containedTypeOrUnknown(1));
        } else if (ByteBuffer.class.isAssignableFrom(raw)) {
            return new ByteBufferSerializer();
        } else {
            if (InetAddress.class.isAssignableFrom(raw)) {
                return new InetAddressSerializer();
            }
            if (InetSocketAddress.class.isAssignableFrom(raw)) {
                return new InetSocketAddressSerializer();
            }
            if (TimeZone.class.isAssignableFrom(raw)) {
                return new TimeZoneSerializer();
            }
            if (Charset.class.isAssignableFrom(raw)) {
                return ToStringSerializer.instance;
            }
            if (Number.class.isAssignableFrom(raw)) {
                Value format = beanDescription.findExpectedFormat(null);
                if (format != null) {
                    int i = C68351.$SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[format.getShape().ordinal()];
                    if (i == 1) {
                        return ToStringSerializer.instance;
                    }
                    if (i == 2 || i == 3) {
                        return null;
                    }
                }
                return NumberSerializer.instance;
            } else if (Enum.class.isAssignableFrom(raw)) {
                return buildEnumSerializer(prov.getConfig(), javaType, beanDescription);
            } else {
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> findOptionalStdSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findSerializer(prov.getConfig(), type, beanDesc);
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<?> findSerializerByAddonType(SerializationConfig config, JavaType javaType, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        Class<?> rawType = javaType.getRawClass();
        if (Iterator.class.isAssignableFrom(rawType)) {
            JavaType[] params = config.getTypeFactory().findTypeParameters(javaType, Iterator.class);
            return buildIteratorSerializer(config, javaType, beanDesc, staticTyping, (params == null || params.length != 1) ? TypeFactory.unknownType() : params[0]);
        } else if (Iterable.class.isAssignableFrom(rawType)) {
            JavaType[] params2 = config.getTypeFactory().findTypeParameters(javaType, Iterable.class);
            return buildIterableSerializer(config, javaType, beanDesc, staticTyping, (params2 == null || params2.length != 1) ? TypeFactory.unknownType() : params2[0]);
        } else if (CharSequence.class.isAssignableFrom(rawType)) {
            return ToStringSerializer.instance;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> findSerializerFromAnnotation(SerializerProvider prov, Annotated a) throws JsonMappingException {
        Object serDef = prov.getAnnotationIntrospector().findSerializer(a);
        if (serDef == null) {
            return null;
        }
        return findConvertingSerializer(prov, a, prov.serializerInstance(a, serDef));
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> findConvertingSerializer(SerializerProvider prov, Annotated a, JsonSerializer<?> ser) throws JsonMappingException {
        Converter<Object, Object> conv = findConverter(prov, a);
        if (conv == null) {
            return ser;
        }
        return new StdDelegatingSerializer(conv, conv.getOutputType(prov.getTypeFactory()), ser);
    }

    /* access modifiers changed from: protected */
    public Converter<Object, Object> findConverter(SerializerProvider prov, Annotated a) throws JsonMappingException {
        Object convDef = prov.getAnnotationIntrospector().findSerializationConverter(a);
        if (convDef == null) {
            return null;
        }
        return prov.converterInstance(a, convDef);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildContainerSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        boolean staticTyping2;
        boolean staticTyping3;
        JsonSerializer jsonSerializer;
        SerializerProvider serializerProvider = prov;
        BeanDescription beanDescription = beanDesc;
        SerializationConfig config = prov.getConfig();
        if (staticTyping || !type.useStaticType() || (type.isContainerType() && type.getContentType().isJavaLangObject())) {
            staticTyping2 = staticTyping;
        } else {
            staticTyping2 = true;
        }
        TypeSerializer elementTypeSerializer = createTypeSerializer(config, type.getContentType());
        if (elementTypeSerializer != null) {
            staticTyping3 = false;
        } else {
            staticTyping3 = staticTyping2;
        }
        JsonSerializer<Object> elementValueSerializer = _findContentSerializer(serializerProvider, beanDesc.getClassInfo());
        if (type.isMapLikeType()) {
            MapLikeType mlt = (MapLikeType) type;
            JsonSerializer<Object> keySerializer = _findKeySerializer(serializerProvider, beanDesc.getClassInfo());
            if (mlt.isTrueMapType()) {
                return buildMapSerializer(prov, (MapType) mlt, beanDesc, staticTyping3, keySerializer, elementTypeSerializer, elementValueSerializer);
            }
            MapLikeType mlType = (MapLikeType) type;
            JsonSerializer jsonSerializer2 = null;
            for (Serializers serializers : customSerializers()) {
                jsonSerializer2 = serializers.findMapLikeSerializer(config, mlType, beanDesc, keySerializer, elementTypeSerializer, elementValueSerializer);
                if (jsonSerializer2 != null) {
                    break;
                }
            }
            if (jsonSerializer2 == null) {
                jsonSerializer2 = findSerializerByAnnotations(prov, type, beanDesc);
            }
            if (jsonSerializer2 == null || !this._factoryConfig.hasSerializerModifiers()) {
                jsonSerializer = jsonSerializer2;
            } else {
                jsonSerializer = jsonSerializer2;
                for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                    jsonSerializer = mod.modifyMapLikeSerializer(config, mlType, beanDescription, jsonSerializer);
                }
            }
            return jsonSerializer;
        } else if (type.isCollectionLikeType()) {
            CollectionLikeType clt = (CollectionLikeType) type;
            if (clt.isTrueCollectionType()) {
                return buildCollectionSerializer(prov, (CollectionType) clt, beanDesc, staticTyping3, elementTypeSerializer, elementValueSerializer);
            }
            CollectionLikeType clType = (CollectionLikeType) type;
            JsonSerializer jsonSerializer3 = null;
            for (Serializers serializers2 : customSerializers()) {
                jsonSerializer3 = serializers2.findCollectionLikeSerializer(config, clType, beanDesc, elementTypeSerializer, elementValueSerializer);
                if (jsonSerializer3 != null) {
                    break;
                }
            }
            if (jsonSerializer3 == null) {
                jsonSerializer3 = findSerializerByAnnotations(prov, type, beanDesc);
            }
            if (jsonSerializer3 != null && this._factoryConfig.hasSerializerModifiers()) {
                JsonSerializer jsonSerializer4 = jsonSerializer3;
                for (BeanSerializerModifier mod2 : this._factoryConfig.serializerModifiers()) {
                    jsonSerializer4 = mod2.modifyCollectionLikeSerializer(config, clType, beanDescription, jsonSerializer4);
                }
                jsonSerializer3 = jsonSerializer4;
            }
            return jsonSerializer3;
        } else if (!type.isArrayType()) {
            return null;
        } else {
            return buildArraySerializer(prov, (ArrayType) type, beanDesc, staticTyping3, elementTypeSerializer, elementValueSerializer);
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildCollectionSerializer(SerializerProvider prov, CollectionType type, BeanDescription beanDesc, boolean staticTyping, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) throws JsonMappingException {
        BeanDescription beanDescription = beanDesc;
        boolean z = staticTyping;
        TypeSerializer typeSerializer = elementTypeSerializer;
        JsonSerializer<Object> jsonSerializer = elementValueSerializer;
        SerializationConfig config = prov.getConfig();
        JsonSerializer jsonSerializer2 = null;
        for (Serializers serializers : customSerializers()) {
            jsonSerializer2 = serializers.findCollectionSerializer(config, type, beanDesc, elementTypeSerializer, elementValueSerializer);
            if (jsonSerializer2 != null) {
                break;
            }
        }
        if (jsonSerializer2 == null) {
            jsonSerializer2 = findSerializerByAnnotations(prov, type, beanDesc);
            if (jsonSerializer2 == null) {
                Value format = beanDescription.findExpectedFormat(null);
                if (format != null && format.getShape() == Shape.OBJECT) {
                    return null;
                }
                Class<?> raw = type.getRawClass();
                if (EnumSet.class.isAssignableFrom(raw)) {
                    JavaType enumType = type.getContentType();
                    if (!enumType.isEnumType()) {
                        enumType = null;
                    }
                    jsonSerializer2 = buildEnumSetSerializer(enumType);
                } else {
                    Class<?> elementRaw = type.getContentType().getRawClass();
                    if (isIndexedList(raw)) {
                        if (elementRaw != String.class) {
                            jsonSerializer2 = buildIndexedListSerializer(type.getContentType(), z, typeSerializer, jsonSerializer);
                        } else if (ClassUtil.isJacksonStdImpl((Object) elementValueSerializer)) {
                            jsonSerializer2 = IndexedStringListSerializer.instance;
                        }
                    } else if (elementRaw == String.class && ClassUtil.isJacksonStdImpl((Object) elementValueSerializer)) {
                        jsonSerializer2 = StringCollectionSerializer.instance;
                    }
                    if (jsonSerializer2 == null) {
                        jsonSerializer2 = buildCollectionSerializer(type.getContentType(), z, typeSerializer, jsonSerializer);
                    }
                }
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                jsonSerializer2 = mod.modifyCollectionSerializer(config, type, beanDescription, jsonSerializer2);
            }
            CollectionType collectionType = type;
        } else {
            CollectionType collectionType2 = type;
        }
        return jsonSerializer2;
    }

    /* access modifiers changed from: protected */
    public boolean isIndexedList(Class<?> cls) {
        return RandomAccess.class.isAssignableFrom(cls);
    }

    public ContainerSerializer<?> buildIndexedListSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> valueSerializer) {
        return new IndexedListSerializer(elemType, staticTyping, vts, valueSerializer);
    }

    public ContainerSerializer<?> buildCollectionSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> valueSerializer) {
        return new CollectionSerializer(elemType, staticTyping, vts, valueSerializer);
    }

    public JsonSerializer<?> buildEnumSetSerializer(JavaType enumType) {
        return new EnumSetSerializer(enumType);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildMapSerializer(SerializerProvider prov, MapType type, BeanDescription beanDesc, boolean staticTyping, JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) throws JsonMappingException {
        BeanDescription beanDescription = beanDesc;
        Set set = null;
        Value format = beanDescription.findExpectedFormat(null);
        if (format != null && format.getShape() == Shape.OBJECT) {
            return null;
        }
        SerializationConfig config = prov.getConfig();
        JsonSerializer jsonSerializer = null;
        for (Serializers serializers : customSerializers()) {
            jsonSerializer = serializers.findMapSerializer(config, type, beanDesc, keySerializer, elementTypeSerializer, elementValueSerializer);
            if (jsonSerializer != null) {
                break;
            }
        }
        if (jsonSerializer == null) {
            jsonSerializer = findSerializerByAnnotations(prov, type, beanDesc);
            if (jsonSerializer == null) {
                Object filterId = findFilterId(config, beanDescription);
                JsonIgnoreProperties.Value ignorals = config.getDefaultPropertyIgnorals(Map.class, beanDesc.getClassInfo());
                if (ignorals != null) {
                    set = ignorals.findIgnoredForSerialization();
                }
                jsonSerializer = _checkMapContentInclusion(prov, beanDescription, MapSerializer.construct(set, type, staticTyping, elementTypeSerializer, keySerializer, elementValueSerializer, filterId));
            } else {
                SerializerProvider serializerProvider = prov;
            }
        } else {
            SerializerProvider serializerProvider2 = prov;
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                jsonSerializer = mod.modifyMapSerializer(config, type, beanDescription, jsonSerializer);
            }
            MapType mapType = type;
        } else {
            MapType mapType2 = type;
        }
        return jsonSerializer;
    }

    /* access modifiers changed from: protected */
    public MapSerializer _checkMapContentInclusion(SerializerProvider prov, BeanDescription beanDesc, MapSerializer mapSer) throws JsonMappingException {
        Object valueToSuppress;
        JavaType contentType = mapSer.getContentType();
        JsonInclude.Value inclV = _findInclusionWithContent(prov, beanDesc, contentType, Map.class);
        Include incl = inclV == null ? Include.USE_DEFAULTS : inclV.getContentInclusion();
        Object obj = null;
        if (incl != Include.USE_DEFAULTS && incl != Include.ALWAYS) {
            boolean suppressNulls = true;
            int i = C68351.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[incl.ordinal()];
            if (i == 1) {
                valueToSuppress = BeanUtil.getDefaultValue(contentType);
                if (valueToSuppress != null && valueToSuppress.getClass().isArray()) {
                    valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress);
                }
            } else if (i == 2) {
                if (contentType.isReferenceType()) {
                    obj = MapSerializer.MARKER_FOR_EMPTY;
                }
                valueToSuppress = obj;
            } else if (i == 3) {
                valueToSuppress = MapSerializer.MARKER_FOR_EMPTY;
            } else if (i != 4) {
                valueToSuppress = null;
            } else {
                valueToSuppress = prov.includeFilterInstance(null, inclV.getContentFilter());
                suppressNulls = valueToSuppress == null ? true : prov.includeFilterSuppressNulls(valueToSuppress);
            }
            return mapSer.withContentInclusion(valueToSuppress, suppressNulls);
        } else if (!prov.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
            return mapSer.withContentInclusion(null, true);
        } else {
            return mapSer;
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildMapEntrySerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping, JavaType keyType, JavaType valueType) throws JsonMappingException {
        SerializerProvider serializerProvider = prov;
        BeanDescription beanDescription = beanDesc;
        Object valueToSuppress = null;
        if (Value.merge(beanDescription.findExpectedFormat(null), serializerProvider.getDefaultPropertyFormat(Entry.class)).getShape() == Shape.OBJECT) {
            return null;
        }
        MapEntrySerializer mapEntrySerializer = new MapEntrySerializer(valueType, keyType, valueType, staticTyping, createTypeSerializer(prov.getConfig(), valueType), null);
        JavaType contentType = mapEntrySerializer.getContentType();
        JsonInclude.Value inclV = _findInclusionWithContent(serializerProvider, beanDescription, contentType, Entry.class);
        Include incl = inclV == null ? Include.USE_DEFAULTS : inclV.getContentInclusion();
        if (incl == Include.USE_DEFAULTS || incl == Include.ALWAYS) {
            return mapEntrySerializer;
        }
        boolean suppressNulls = true;
        int i = C68351.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[incl.ordinal()];
        if (i == 1) {
            valueToSuppress = BeanUtil.getDefaultValue(contentType);
            if (valueToSuppress != null && valueToSuppress.getClass().isArray()) {
                valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress);
            }
        } else if (i != 2) {
            if (i == 3) {
                valueToSuppress = MapSerializer.MARKER_FOR_EMPTY;
            } else if (i != 4) {
                valueToSuppress = null;
            } else {
                valueToSuppress = serializerProvider.includeFilterInstance(null, inclV.getContentFilter());
                suppressNulls = valueToSuppress == null ? true : serializerProvider.includeFilterSuppressNulls(valueToSuppress);
            }
        } else if (contentType.isReferenceType()) {
            valueToSuppress = MapSerializer.MARKER_FOR_EMPTY;
        }
        return mapEntrySerializer.withContentInclusion(valueToSuppress, suppressNulls);
    }

    /* access modifiers changed from: protected */
    public JsonInclude.Value _findInclusionWithContent(SerializerProvider prov, BeanDescription beanDesc, JavaType contentType, Class<?> configType) throws JsonMappingException {
        SerializationConfig config = prov.getConfig();
        JsonInclude.Value inclV = config.getDefaultPropertyInclusion(configType, beanDesc.findPropertyInclusion(config.getDefaultPropertyInclusion()));
        JsonInclude.Value valueIncl = config.getDefaultPropertyInclusion(contentType.getRawClass(), null);
        if (valueIncl == null) {
            return inclV;
        }
        int i = C68351.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[valueIncl.getValueInclusion().ordinal()];
        if (i == 4) {
            return inclV.withContentFilter(valueIncl.getContentFilter());
        }
        if (i != 6) {
            return inclV.withContentInclusion(valueIncl.getValueInclusion());
        }
        return inclV;
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildArraySerializer(SerializerProvider prov, ArrayType type, BeanDescription beanDesc, boolean staticTyping, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializer = elementValueSerializer;
        SerializationConfig config = prov.getConfig();
        JsonSerializer jsonSerializer2 = null;
        for (Serializers serializers : customSerializers()) {
            jsonSerializer2 = serializers.findArraySerializer(config, type, beanDesc, elementTypeSerializer, elementValueSerializer);
            if (jsonSerializer2 != null) {
                break;
            }
        }
        if (jsonSerializer2 == null) {
            Class<?> raw = type.getRawClass();
            if (jsonSerializer == null || ClassUtil.isJacksonStdImpl((Object) elementValueSerializer)) {
                if (String[].class == raw) {
                    jsonSerializer2 = StringArraySerializer.instance;
                } else {
                    jsonSerializer2 = StdArraySerializers.findStandardImpl(raw);
                }
            }
            if (jsonSerializer2 == null) {
                jsonSerializer2 = new ObjectArraySerializer(type.getContentType(), staticTyping, elementTypeSerializer, jsonSerializer);
            } else {
                boolean z = staticTyping;
                TypeSerializer typeSerializer = elementTypeSerializer;
            }
        } else {
            boolean z2 = staticTyping;
            TypeSerializer typeSerializer2 = elementTypeSerializer;
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                ArrayType arrayType = type;
                BeanDescription beanDescription = beanDesc;
                jsonSerializer2 = mod.modifyArraySerializer(config, type, beanDesc, jsonSerializer2);
            }
            ArrayType arrayType2 = type;
            BeanDescription beanDescription2 = beanDesc;
        } else {
            ArrayType arrayType3 = type;
            BeanDescription beanDescription3 = beanDesc;
        }
        return jsonSerializer2;
    }

    public JsonSerializer<?> findReferenceSerializer(SerializerProvider prov, ReferenceType refType, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        JavaType contentType = refType.getContentType();
        TypeSerializer contentTypeSerializer = (TypeSerializer) contentType.getTypeHandler();
        SerializationConfig config = prov.getConfig();
        if (contentTypeSerializer == null) {
            contentTypeSerializer = createTypeSerializer(config, contentType);
        }
        JsonSerializer<Object> contentSerializer = (JsonSerializer) contentType.getValueHandler();
        for (Serializers serializers : customSerializers()) {
            JsonSerializer<?> ser = serializers.findReferenceSerializer(config, refType, beanDesc, contentTypeSerializer, contentSerializer);
            if (ser != null) {
                return ser;
            }
        }
        if (refType.isTypeOrSubTypeOf(AtomicReference.class)) {
            return buildAtomicReferenceSerializer(prov, refType, beanDesc, staticTyping, contentTypeSerializer, contentSerializer);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildAtomicReferenceSerializer(SerializerProvider prov, ReferenceType refType, BeanDescription beanDesc, boolean staticTyping, TypeSerializer contentTypeSerializer, JsonSerializer<Object> contentSerializer) throws JsonMappingException {
        Object valueToSuppress;
        boolean suppressNulls;
        JavaType contentType = refType.getReferencedType();
        JsonInclude.Value inclV = _findInclusionWithContent(prov, beanDesc, contentType, AtomicReference.class);
        Include incl = inclV == null ? Include.USE_DEFAULTS : inclV.getContentInclusion();
        if (incl == Include.USE_DEFAULTS || incl == Include.ALWAYS) {
            valueToSuppress = null;
            suppressNulls = false;
        } else {
            suppressNulls = true;
            int i = C68351.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[incl.ordinal()];
            if (i != 1) {
                Object obj = null;
                if (i == 2) {
                    if (contentType.isReferenceType()) {
                        obj = MapSerializer.MARKER_FOR_EMPTY;
                    }
                    valueToSuppress = obj;
                } else if (i == 3) {
                    valueToSuppress = MapSerializer.MARKER_FOR_EMPTY;
                } else if (i != 4) {
                    valueToSuppress = null;
                } else {
                    valueToSuppress = prov.includeFilterInstance(null, inclV.getContentFilter());
                    suppressNulls = valueToSuppress == null ? true : prov.includeFilterSuppressNulls(valueToSuppress);
                }
            } else {
                valueToSuppress = BeanUtil.getDefaultValue(contentType);
                if (valueToSuppress != null && valueToSuppress.getClass().isArray()) {
                    valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress);
                }
            }
        }
        return new AtomicReferenceSerializer(refType, staticTyping, contentTypeSerializer, contentSerializer).withContentInclusion(valueToSuppress, suppressNulls);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildIteratorSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc, boolean staticTyping, JavaType valueType) throws JsonMappingException {
        return new IteratorSerializer(valueType, staticTyping, createTypeSerializer(config, valueType));
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildIterableSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc, boolean staticTyping, JavaType valueType) throws JsonMappingException {
        return new IterableSerializer(valueType, staticTyping, createTypeSerializer(config, valueType));
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> buildEnumSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        Value format = beanDesc.findExpectedFormat(null);
        if (format == null || format.getShape() != Shape.OBJECT) {
            JsonSerializer<?> ser = EnumSerializer.construct(type.getRawClass(), config, beanDesc, format);
            if (this._factoryConfig.hasSerializerModifiers()) {
                for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                    ser = mod.modifyEnumSerializer(config, type, beanDesc, ser);
                }
            }
            return ser;
        }
        ((BasicBeanDescription) beanDesc).removeProperty("declaringClass");
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> _findKeySerializer(SerializerProvider prov, Annotated a) throws JsonMappingException {
        Object serDef = prov.getAnnotationIntrospector().findKeySerializer(a);
        if (serDef != null) {
            return prov.serializerInstance(a, serDef);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> _findContentSerializer(SerializerProvider prov, Annotated a) throws JsonMappingException {
        Object serDef = prov.getAnnotationIntrospector().findContentSerializer(a);
        if (serDef != null) {
            return prov.serializerInstance(a, serDef);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Object findFilterId(SerializationConfig config, BeanDescription beanDesc) {
        return config.getAnnotationIntrospector().findFilterId(beanDesc.getClassInfo());
    }

    /* access modifiers changed from: protected */
    public boolean usesStaticTyping(SerializationConfig config, BeanDescription beanDesc, TypeSerializer typeSer) {
        boolean z = false;
        if (typeSer != null) {
            return false;
        }
        Typing t = config.getAnnotationIntrospector().findSerializationTyping(beanDesc.getClassInfo());
        if (t == null || t == Typing.DEFAULT_TYPING) {
            return config.isEnabled(MapperFeature.USE_STATIC_TYPING);
        }
        if (t == Typing.STATIC) {
            z = true;
        }
        return z;
    }
}
