package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.C0078As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.C0079Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$None;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.JsonSerializer.None;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.ext.Java7Support;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.AttributePropertyWriter;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class JacksonAnnotationIntrospector extends AnnotationIntrospector implements Serializable {
    private static final Class<? extends Annotation>[] ANNOTATIONS_TO_INFER_DESER = {JsonDeserialize.class, JsonView.class, JsonFormat.class, JsonTypeInfo.class, JsonUnwrapped.class, JsonBackReference.class, JsonManagedReference.class, JsonMerge.class};
    private static final Class<? extends Annotation>[] ANNOTATIONS_TO_INFER_SER = {JsonSerialize.class, JsonView.class, JsonFormat.class, JsonTypeInfo.class, JsonRawValue.class, JsonUnwrapped.class, JsonBackReference.class, JsonManagedReference.class};
    private static final Java7Support _java7Helper;
    protected transient LRUMap<Class<?>, Boolean> _annotationsInside = new LRUMap<>(48, 48);
    protected boolean _cfgConstructorPropertiesImpliesCreator = true;

    /* renamed from: com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector$1 */
    static /* synthetic */ class C68221 {

        /* renamed from: $SwitchMap$com$fasterxml$jackson$databind$annotation$JsonSerialize$Inclusion */
        static final /* synthetic */ int[] f12554xfdbfedae = new int[Inclusion.values().length];

        static {
            try {
                f12554xfdbfedae[Inclusion.ALWAYS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12554xfdbfedae[Inclusion.NON_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12554xfdbfedae[Inclusion.NON_DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12554xfdbfedae[Inclusion.NON_EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f12554xfdbfedae[Inclusion.DEFAULT_INCLUSION.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static {
        Java7Support x = null;
        try {
            x = Java7Support.instance();
        } catch (Throwable th) {
        }
        _java7Helper = x;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        if (this._annotationsInside == null) {
            this._annotationsInside = new LRUMap<>(48, 48);
        }
        return this;
    }

    public boolean isAnnotationBundle(Annotation ann) {
        Class<?> type = ann.annotationType();
        Boolean b = (Boolean) this._annotationsInside.get(type);
        if (b == null) {
            b = Boolean.valueOf(type.getAnnotation(JacksonAnnotationsInside.class) != null);
            this._annotationsInside.putIfAbsent(type, b);
        }
        return b.booleanValue();
    }

    public String[] findEnumValues(Class<?> enumType, Enum<?>[] enumValues, String[] names) {
        Field[] arr$;
        HashMap hashMap = null;
        for (Field f : ClassUtil.getDeclaredFields(enumType)) {
            if (f.isEnumConstant()) {
                JsonProperty prop = (JsonProperty) f.getAnnotation(JsonProperty.class);
                if (prop != null) {
                    String n = prop.value();
                    if (!n.isEmpty()) {
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        hashMap.put(f.getName(), n);
                    }
                }
            }
        }
        if (hashMap != null) {
            int end = enumValues.length;
            for (int i = 0; i < end; i++) {
                String explValue = (String) hashMap.get(enumValues[i].name());
                if (explValue != null) {
                    names[i] = explValue;
                }
            }
        }
        return names;
    }

    public Enum<?> findDefaultEnumValue(Class<Enum<?>> enumCls) {
        return ClassUtil.findFirstAnnotatedEnumValue(enumCls, JsonEnumDefaultValue.class);
    }

    public PropertyName findRootName(AnnotatedClass ac) {
        JsonRootName ann = (JsonRootName) _findAnnotation(ac, JsonRootName.class);
        if (ann == null) {
            return null;
        }
        String ns = ann.namespace();
        if (ns != null && ns.length() == 0) {
            ns = null;
        }
        return PropertyName.construct(ann.value(), ns);
    }

    public Value findPropertyIgnorals(Annotated a) {
        JsonIgnoreProperties v = (JsonIgnoreProperties) _findAnnotation(a, JsonIgnoreProperties.class);
        if (v == null) {
            return Value.empty();
        }
        return Value.from(v);
    }

    public Boolean isIgnorableType(AnnotatedClass ac) {
        JsonIgnoreType ignore = (JsonIgnoreType) _findAnnotation(ac, JsonIgnoreType.class);
        if (ignore == null) {
            return null;
        }
        return Boolean.valueOf(ignore.value());
    }

    public Object findFilterId(Annotated a) {
        JsonFilter ann = (JsonFilter) _findAnnotation(a, JsonFilter.class);
        if (ann != null) {
            String id = ann.value();
            if (id.length() > 0) {
                return id;
            }
        }
        return null;
    }

    public Object findNamingStrategy(AnnotatedClass ac) {
        JsonNaming ann = (JsonNaming) _findAnnotation(ac, JsonNaming.class);
        if (ann == null) {
            return null;
        }
        return ann.value();
    }

    public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass ac, VisibilityChecker<?> checker) {
        JsonAutoDetect ann = (JsonAutoDetect) _findAnnotation(ac, JsonAutoDetect.class);
        return ann == null ? checker : checker.with(ann);
    }

    public String findImplicitPropertyName(AnnotatedMember m) {
        PropertyName n = _findConstructorName(m);
        if (n == null) {
            return null;
        }
        return n.getSimpleName();
    }

    public List<PropertyName> findPropertyAliases(Annotated m) {
        JsonAlias ann = (JsonAlias) _findAnnotation(m, JsonAlias.class);
        if (ann == null) {
            return null;
        }
        if (len == 0) {
            return Collections.emptyList();
        }
        List<PropertyName> result = new ArrayList<>(len);
        for (String construct : ann.value()) {
            result.add(PropertyName.construct(construct));
        }
        return result;
    }

    public boolean hasIgnoreMarker(AnnotatedMember m) {
        return _isIgnorable(m);
    }

    public Boolean hasRequiredMarker(AnnotatedMember m) {
        JsonProperty ann = (JsonProperty) _findAnnotation(m, JsonProperty.class);
        if (ann != null) {
            return Boolean.valueOf(ann.required());
        }
        return null;
    }

    public Access findPropertyAccess(Annotated m) {
        JsonProperty ann = (JsonProperty) _findAnnotation(m, JsonProperty.class);
        if (ann != null) {
            return ann.access();
        }
        return null;
    }

    public String findPropertyDescription(Annotated ann) {
        JsonPropertyDescription desc = (JsonPropertyDescription) _findAnnotation(ann, JsonPropertyDescription.class);
        if (desc == null) {
            return null;
        }
        return desc.value();
    }

    public Integer findPropertyIndex(Annotated ann) {
        JsonProperty prop = (JsonProperty) _findAnnotation(ann, JsonProperty.class);
        if (prop != null) {
            int ix = prop.index();
            if (ix != -1) {
                return Integer.valueOf(ix);
            }
        }
        return null;
    }

    public String findPropertyDefaultValue(Annotated ann) {
        JsonProperty prop = (JsonProperty) _findAnnotation(ann, JsonProperty.class);
        String str = null;
        if (prop == null) {
            return null;
        }
        String str2 = prop.defaultValue();
        if (!str2.isEmpty()) {
            str = str2;
        }
        return str;
    }

    public JsonFormat.Value findFormat(Annotated ann) {
        JsonFormat f = (JsonFormat) _findAnnotation(ann, JsonFormat.class);
        if (f == null) {
            return null;
        }
        return new JsonFormat.Value(f);
    }

    public ReferenceProperty findReferenceType(AnnotatedMember member) {
        JsonManagedReference ref1 = (JsonManagedReference) _findAnnotation(member, JsonManagedReference.class);
        if (ref1 != null) {
            return ReferenceProperty.managed(ref1.value());
        }
        JsonBackReference ref2 = (JsonBackReference) _findAnnotation(member, JsonBackReference.class);
        if (ref2 != null) {
            return ReferenceProperty.back(ref2.value());
        }
        return null;
    }

    public NameTransformer findUnwrappingNameTransformer(AnnotatedMember member) {
        JsonUnwrapped ann = (JsonUnwrapped) _findAnnotation(member, JsonUnwrapped.class);
        if (ann == null || !ann.enabled()) {
            return null;
        }
        return NameTransformer.simpleTransformer(ann.prefix(), ann.suffix());
    }

    public JacksonInject.Value findInjectableValue(AnnotatedMember m) {
        Object id;
        JacksonInject ann = (JacksonInject) _findAnnotation(m, JacksonInject.class);
        if (ann == null) {
            return null;
        }
        JacksonInject.Value v = JacksonInject.Value.from(ann);
        if (!v.hasId()) {
            if (!(m instanceof AnnotatedMethod)) {
                id = m.getRawType().getName();
            } else {
                AnnotatedMethod am = (AnnotatedMethod) m;
                if (am.getParameterCount() == 0) {
                    id = m.getRawType().getName();
                } else {
                    id = am.getRawParameterType(0).getName();
                }
            }
            v = v.withId(id);
        }
        return v;
    }

    @Deprecated
    public Object findInjectableValueId(AnnotatedMember m) {
        JacksonInject.Value v = findInjectableValue(m);
        if (v == null) {
            return null;
        }
        return v.getId();
    }

    public Class<?>[] findViews(Annotated a) {
        JsonView ann = (JsonView) _findAnnotation(a, JsonView.class);
        if (ann == null) {
            return null;
        }
        return ann.value();
    }

    public AnnotatedMethod resolveSetterConflict(MapperConfig<?> mapperConfig, AnnotatedMethod setter1, AnnotatedMethod setter2) {
        Class<?> cls1 = setter1.getRawParameterType(0);
        Class<?> cls2 = setter2.getRawParameterType(0);
        if (cls1.isPrimitive()) {
            if (!cls2.isPrimitive()) {
                return setter1;
            }
        } else if (cls2.isPrimitive()) {
            return setter2;
        }
        if (cls1 == String.class) {
            if (cls2 != String.class) {
                return setter1;
            }
        } else if (cls2 == String.class) {
            return setter2;
        }
        return null;
    }

    public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> config, AnnotatedClass ac, JavaType baseType) {
        return _findTypeResolver(config, ac, baseType);
    }

    public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> config, AnnotatedMember am, JavaType baseType) {
        if (baseType.isContainerType() || baseType.isReferenceType()) {
            return null;
        }
        return _findTypeResolver(config, am, baseType);
    }

    public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> config, AnnotatedMember am, JavaType containerType) {
        if (containerType.getContentType() != null) {
            return _findTypeResolver(config, am, containerType);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Must call method with a container or reference type (got ");
        sb.append(containerType);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    public List<NamedType> findSubtypes(Annotated a) {
        Type[] arr$;
        JsonSubTypes t = (JsonSubTypes) _findAnnotation(a, JsonSubTypes.class);
        if (t == null) {
            return null;
        }
        Type[] types = t.value();
        ArrayList<NamedType> result = new ArrayList<>(types.length);
        for (Type type : types) {
            result.add(new NamedType(type.value(), type.name()));
        }
        return result;
    }

    public String findTypeName(AnnotatedClass ac) {
        JsonTypeName tn = (JsonTypeName) _findAnnotation(ac, JsonTypeName.class);
        if (tn == null) {
            return null;
        }
        return tn.value();
    }

    public Boolean isTypeId(AnnotatedMember member) {
        return Boolean.valueOf(_hasAnnotation(member, JsonTypeId.class));
    }

    public ObjectIdInfo findObjectIdInfo(Annotated ann) {
        JsonIdentityInfo info = (JsonIdentityInfo) _findAnnotation(ann, JsonIdentityInfo.class);
        if (info == null || info.generator() == ObjectIdGenerators$None.class) {
            return null;
        }
        return new ObjectIdInfo(PropertyName.construct(info.property()), info.scope(), info.generator(), info.resolver());
    }

    public ObjectIdInfo findObjectReferenceInfo(Annotated ann, ObjectIdInfo objectIdInfo) {
        JsonIdentityReference ref = (JsonIdentityReference) _findAnnotation(ann, JsonIdentityReference.class);
        if (ref == null) {
            return objectIdInfo;
        }
        if (objectIdInfo == null) {
            objectIdInfo = ObjectIdInfo.empty();
        }
        return objectIdInfo.withAlwaysAsId(ref.alwaysAsId());
    }

    public Object findSerializer(Annotated a) {
        JsonSerialize ann = (JsonSerialize) _findAnnotation(a, JsonSerialize.class);
        if (ann != null) {
            Class<? extends JsonSerializer> serClass = ann.using();
            if (serClass != None.class) {
                return serClass;
            }
        }
        JsonRawValue annRaw = (JsonRawValue) _findAnnotation(a, JsonRawValue.class);
        if (annRaw == null || !annRaw.value()) {
            return null;
        }
        return new RawSerializer(a.getRawType());
    }

    public Object findKeySerializer(Annotated a) {
        JsonSerialize ann = (JsonSerialize) _findAnnotation(a, JsonSerialize.class);
        if (ann != null) {
            Class<? extends JsonSerializer> serClass = ann.keyUsing();
            if (serClass != None.class) {
                return serClass;
            }
        }
        return null;
    }

    public Object findContentSerializer(Annotated a) {
        JsonSerialize ann = (JsonSerialize) _findAnnotation(a, JsonSerialize.class);
        if (ann != null) {
            Class<? extends JsonSerializer> serClass = ann.contentUsing();
            if (serClass != None.class) {
                return serClass;
            }
        }
        return null;
    }

    public Object findNullSerializer(Annotated a) {
        JsonSerialize ann = (JsonSerialize) _findAnnotation(a, JsonSerialize.class);
        if (ann != null) {
            Class<? extends JsonSerializer> serClass = ann.nullsUsing();
            if (serClass != None.class) {
                return serClass;
            }
        }
        return null;
    }

    public JsonInclude.Value findPropertyInclusion(Annotated a) {
        JsonInclude inc = (JsonInclude) _findAnnotation(a, JsonInclude.class);
        JsonInclude.Value value = inc == null ? JsonInclude.Value.empty() : JsonInclude.Value.from(inc);
        if (value.getValueInclusion() == Include.USE_DEFAULTS) {
            return _refinePropertyInclusion(a, value);
        }
        return value;
    }

    private JsonInclude.Value _refinePropertyInclusion(Annotated a, JsonInclude.Value value) {
        JsonSerialize ann = (JsonSerialize) _findAnnotation(a, JsonSerialize.class);
        if (ann != null) {
            int i = C68221.f12554xfdbfedae[ann.include().ordinal()];
            if (i == 1) {
                return value.withValueInclusion(Include.ALWAYS);
            }
            if (i == 2) {
                return value.withValueInclusion(Include.NON_NULL);
            }
            if (i == 3) {
                return value.withValueInclusion(Include.NON_DEFAULT);
            }
            if (i == 4) {
                return value.withValueInclusion(Include.NON_EMPTY);
            }
        }
        return value;
    }

    public Typing findSerializationTyping(Annotated a) {
        JsonSerialize ann = (JsonSerialize) _findAnnotation(a, JsonSerialize.class);
        if (ann == null) {
            return null;
        }
        return ann.typing();
    }

    public Object findSerializationConverter(Annotated a) {
        JsonSerialize ann = (JsonSerialize) _findAnnotation(a, JsonSerialize.class);
        if (ann == null) {
            return null;
        }
        return _classIfExplicit(ann.converter(), Converter.None.class);
    }

    public Object findSerializationContentConverter(AnnotatedMember a) {
        JsonSerialize ann = (JsonSerialize) _findAnnotation(a, JsonSerialize.class);
        if (ann == null) {
            return null;
        }
        return _classIfExplicit(ann.contentConverter(), Converter.None.class);
    }

    public JavaType refineSerializationType(MapperConfig<?> config, Annotated a, JavaType baseType) throws JsonMappingException {
        JavaType contentType;
        JavaType contentType2;
        JavaType keyType;
        JavaType type = baseType;
        TypeFactory tf = config.getTypeFactory();
        JsonSerialize jsonSer = (JsonSerialize) _findAnnotation(a, JsonSerialize.class);
        Class _classIfExplicit = jsonSer == null ? null : _classIfExplicit(jsonSer.mo3059as());
        if (_classIfExplicit != null) {
            if (type.hasRawClass(_classIfExplicit)) {
                type = type.withStaticTyping();
            } else {
                Class<?> currRaw = type.getRawClass();
                try {
                    if (_classIfExplicit.isAssignableFrom(currRaw)) {
                        type = tf.constructGeneralizedType(type, _classIfExplicit);
                    } else if (currRaw.isAssignableFrom(_classIfExplicit)) {
                        type = tf.constructSpecializedType(type, _classIfExplicit);
                    } else if (_primitiveAndWrapper(currRaw, _classIfExplicit)) {
                        type = type.withStaticTyping();
                    } else {
                        throw new JsonMappingException(null, String.format("Cannot refine serialization type %s into %s; types not related", new Object[]{type, _classIfExplicit.getName()}));
                    }
                } catch (IllegalArgumentException iae) {
                    throw new JsonMappingException((Closeable) null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", new Object[]{type, _classIfExplicit.getName(), a.getName(), iae.getMessage()}), (Throwable) iae);
                }
            }
        }
        if (type.isMapLikeType()) {
            JavaType keyType2 = type.getKeyType();
            Class _classIfExplicit2 = jsonSer == null ? null : _classIfExplicit(jsonSer.keyAs());
            if (_classIfExplicit2 != null) {
                if (keyType2.hasRawClass(_classIfExplicit2)) {
                    keyType = keyType2.withStaticTyping();
                } else {
                    Class<?> currRaw2 = keyType2.getRawClass();
                    try {
                        if (_classIfExplicit2.isAssignableFrom(currRaw2)) {
                            keyType = tf.constructGeneralizedType(keyType2, _classIfExplicit2);
                        } else if (currRaw2.isAssignableFrom(_classIfExplicit2)) {
                            keyType = tf.constructSpecializedType(keyType2, _classIfExplicit2);
                        } else if (_primitiveAndWrapper(currRaw2, _classIfExplicit2)) {
                            keyType = keyType2.withStaticTyping();
                        } else {
                            throw new JsonMappingException(null, String.format("Cannot refine serialization key type %s into %s; types not related", new Object[]{keyType2, _classIfExplicit2.getName()}));
                        }
                    } catch (IllegalArgumentException iae2) {
                        throw new JsonMappingException((Closeable) null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{type, _classIfExplicit2.getName(), a.getName(), iae2.getMessage()}), (Throwable) iae2);
                    }
                }
                type = ((MapLikeType) type).withKeyType(keyType);
            }
        }
        JavaType contentType3 = type.getContentType();
        if (contentType3 == null) {
            return type;
        }
        Class _classIfExplicit3 = jsonSer == null ? null : _classIfExplicit(jsonSer.contentAs());
        if (_classIfExplicit3 == null) {
            return type;
        }
        if (contentType3.hasRawClass(_classIfExplicit3)) {
            contentType = contentType3.withStaticTyping();
        } else {
            Class<?> currRaw3 = contentType3.getRawClass();
            try {
                if (_classIfExplicit3.isAssignableFrom(currRaw3)) {
                    contentType2 = tf.constructGeneralizedType(contentType3, _classIfExplicit3);
                } else if (currRaw3.isAssignableFrom(_classIfExplicit3)) {
                    contentType2 = tf.constructSpecializedType(contentType3, _classIfExplicit3);
                } else if (_primitiveAndWrapper(currRaw3, _classIfExplicit3)) {
                    contentType2 = contentType3.withStaticTyping();
                } else {
                    throw new JsonMappingException(null, String.format("Cannot refine serialization content type %s into %s; types not related", new Object[]{contentType3, _classIfExplicit3.getName()}));
                }
                contentType = contentType2;
            } catch (IllegalArgumentException iae3) {
                throw new JsonMappingException((Closeable) null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{type, _classIfExplicit3.getName(), a.getName(), iae3.getMessage()}), (Throwable) iae3);
            }
        }
        return type.withContentType(contentType);
    }

    public String[] findSerializationPropertyOrder(AnnotatedClass ac) {
        JsonPropertyOrder order = (JsonPropertyOrder) _findAnnotation(ac, JsonPropertyOrder.class);
        if (order == null) {
            return null;
        }
        return order.value();
    }

    public Boolean findSerializationSortAlphabetically(Annotated ann) {
        return _findSortAlpha(ann);
    }

    private final Boolean _findSortAlpha(Annotated ann) {
        JsonPropertyOrder order = (JsonPropertyOrder) _findAnnotation(ann, JsonPropertyOrder.class);
        if (order == null || !order.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    public void findAndAddVirtualProperties(MapperConfig<?> config, AnnotatedClass ac, List<BeanPropertyWriter> properties) {
        JsonAppend ann = (JsonAppend) _findAnnotation(ac, JsonAppend.class);
        if (ann != null) {
            boolean prepend = ann.prepend();
            JavaType propType = null;
            Attr[] attrs = ann.attrs();
            int len = attrs.length;
            for (int i = 0; i < len; i++) {
                if (propType == null) {
                    propType = config.constructType(Object.class);
                }
                BeanPropertyWriter bpw = _constructVirtualProperty(attrs[i], config, ac, propType);
                if (prepend) {
                    properties.add(i, bpw);
                } else {
                    properties.add(bpw);
                }
            }
            Prop[] props = ann.props();
            int len2 = props.length;
            for (int i2 = 0; i2 < len2; i2++) {
                BeanPropertyWriter bpw2 = _constructVirtualProperty(props[i2], config, ac);
                if (prepend) {
                    properties.add(i2, bpw2);
                } else {
                    properties.add(bpw2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public BeanPropertyWriter _constructVirtualProperty(Attr attr, MapperConfig<?> config, AnnotatedClass ac, JavaType type) {
        PropertyMetadata metadata = attr.required() ? PropertyMetadata.STD_REQUIRED : PropertyMetadata.STD_OPTIONAL;
        String attrName = attr.value();
        PropertyName propName = _propertyName(attr.propName(), attr.propNamespace());
        if (!propName.hasSimpleName()) {
            propName = PropertyName.construct(attrName);
        }
        return AttributePropertyWriter.construct(attrName, SimpleBeanPropertyDefinition.construct(config, new VirtualAnnotatedMember(ac, ac.getRawType(), attrName, type), propName, metadata, attr.include()), ac.getAnnotations(), type);
    }

    /* access modifiers changed from: protected */
    public BeanPropertyWriter _constructVirtualProperty(Prop prop, MapperConfig<?> config, AnnotatedClass ac) {
        PropertyMetadata metadata = prop.required() ? PropertyMetadata.STD_REQUIRED : PropertyMetadata.STD_OPTIONAL;
        PropertyName propName = _propertyName(prop.name(), prop.namespace());
        JavaType type = config.constructType(prop.type());
        SimpleBeanPropertyDefinition propDef = SimpleBeanPropertyDefinition.construct(config, new VirtualAnnotatedMember(ac, ac.getRawType(), propName.getSimpleName(), type), propName, metadata, prop.include());
        Class<?> implClass = prop.value();
        HandlerInstantiator hi = config.getHandlerInstantiator();
        VirtualBeanPropertyWriter bpw = hi == null ? null : hi.virtualPropertyWriterInstance(config, implClass);
        if (bpw == null) {
            bpw = (VirtualBeanPropertyWriter) ClassUtil.createInstance(implClass, config.canOverrideAccessModifiers());
        }
        return bpw.withConfig(config, ac, propDef, type);
    }

    public PropertyName findNameForSerialization(Annotated a) {
        JsonGetter jg = (JsonGetter) _findAnnotation(a, JsonGetter.class);
        if (jg != null) {
            return PropertyName.construct(jg.value());
        }
        JsonProperty pann = (JsonProperty) _findAnnotation(a, JsonProperty.class);
        if (pann != null) {
            return PropertyName.construct(pann.value());
        }
        if (_hasOneOf(a, ANNOTATIONS_TO_INFER_SER)) {
            return PropertyName.USE_DEFAULT;
        }
        return null;
    }

    public Boolean hasAsValue(Annotated a) {
        JsonValue ann = (JsonValue) _findAnnotation(a, JsonValue.class);
        if (ann == null) {
            return null;
        }
        return Boolean.valueOf(ann.value());
    }

    public Boolean hasAnyGetter(Annotated a) {
        JsonAnyGetter ann = (JsonAnyGetter) _findAnnotation(a, JsonAnyGetter.class);
        if (ann == null) {
            return null;
        }
        return Boolean.valueOf(ann.enabled());
    }

    @Deprecated
    public boolean hasAnyGetterAnnotation(AnnotatedMethod am) {
        return _hasAnnotation(am, JsonAnyGetter.class);
    }

    @Deprecated
    public boolean hasAsValueAnnotation(AnnotatedMethod am) {
        JsonValue ann = (JsonValue) _findAnnotation(am, JsonValue.class);
        return ann != null && ann.value();
    }

    public Object findDeserializer(Annotated a) {
        JsonDeserialize ann = (JsonDeserialize) _findAnnotation(a, JsonDeserialize.class);
        if (ann != null) {
            Class<? extends JsonDeserializer> deserClass = ann.using();
            if (deserClass != JsonDeserializer.None.class) {
                return deserClass;
            }
        }
        return null;
    }

    public Object findKeyDeserializer(Annotated a) {
        JsonDeserialize ann = (JsonDeserialize) _findAnnotation(a, JsonDeserialize.class);
        if (ann != null) {
            Class<? extends KeyDeserializer> deserClass = ann.keyUsing();
            if (deserClass != KeyDeserializer.None.class) {
                return deserClass;
            }
        }
        return null;
    }

    public Object findContentDeserializer(Annotated a) {
        JsonDeserialize ann = (JsonDeserialize) _findAnnotation(a, JsonDeserialize.class);
        if (ann != null) {
            Class<? extends JsonDeserializer> deserClass = ann.contentUsing();
            if (deserClass != JsonDeserializer.None.class) {
                return deserClass;
            }
        }
        return null;
    }

    public Object findDeserializationConverter(Annotated a) {
        JsonDeserialize ann = (JsonDeserialize) _findAnnotation(a, JsonDeserialize.class);
        if (ann == null) {
            return null;
        }
        return _classIfExplicit(ann.converter(), Converter.None.class);
    }

    public Object findDeserializationContentConverter(AnnotatedMember a) {
        JsonDeserialize ann = (JsonDeserialize) _findAnnotation(a, JsonDeserialize.class);
        if (ann == null) {
            return null;
        }
        return _classIfExplicit(ann.contentConverter(), Converter.None.class);
    }

    public JavaType refineDeserializationType(MapperConfig<?> config, Annotated a, JavaType baseType) throws JsonMappingException {
        JavaType type = baseType;
        TypeFactory tf = config.getTypeFactory();
        JsonDeserialize jsonDeser = (JsonDeserialize) _findAnnotation(a, JsonDeserialize.class);
        Class _classIfExplicit = jsonDeser == null ? null : _classIfExplicit(jsonDeser.mo3047as());
        if (_classIfExplicit != null && !type.hasRawClass(_classIfExplicit) && !_primitiveAndWrapper(type, _classIfExplicit)) {
            try {
                type = tf.constructSpecializedType(type, _classIfExplicit);
            } catch (IllegalArgumentException e) {
                IllegalArgumentException iae = e;
                throw new JsonMappingException((Closeable) null, String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", new Object[]{type, _classIfExplicit.getName(), a.getName(), iae.getMessage()}), (Throwable) iae);
            }
        }
        if (type.isMapLikeType()) {
            JavaType keyType = type.getKeyType();
            Class _classIfExplicit2 = jsonDeser == null ? null : _classIfExplicit(jsonDeser.keyAs());
            if (_classIfExplicit2 != null && !_primitiveAndWrapper(keyType, _classIfExplicit2)) {
                try {
                    type = ((MapLikeType) type).withKeyType(tf.constructSpecializedType(keyType, _classIfExplicit2));
                } catch (IllegalArgumentException iae2) {
                    throw new JsonMappingException((Closeable) null, String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{type, _classIfExplicit2.getName(), a.getName(), iae2.getMessage()}), (Throwable) iae2);
                }
            }
        }
        JavaType contentType = type.getContentType();
        if (contentType == null) {
            return type;
        }
        Class _classIfExplicit3 = jsonDeser == null ? null : _classIfExplicit(jsonDeser.contentAs());
        if (_classIfExplicit3 == null || _primitiveAndWrapper(contentType, _classIfExplicit3)) {
            return type;
        }
        try {
            return type.withContentType(tf.constructSpecializedType(contentType, _classIfExplicit3));
        } catch (IllegalArgumentException iae3) {
            throw new JsonMappingException((Closeable) null, String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{type, _classIfExplicit3.getName(), a.getName(), iae3.getMessage()}), (Throwable) iae3);
        }
    }

    public Object findValueInstantiator(AnnotatedClass ac) {
        JsonValueInstantiator ann = (JsonValueInstantiator) _findAnnotation(ac, JsonValueInstantiator.class);
        if (ann == null) {
            return null;
        }
        return ann.value();
    }

    public Class<?> findPOJOBuilder(AnnotatedClass ac) {
        JsonDeserialize ann = (JsonDeserialize) _findAnnotation(ac, JsonDeserialize.class);
        if (ann == null) {
            return null;
        }
        return _classIfExplicit(ann.builder());
    }

    public JsonPOJOBuilder.Value findPOJOBuilderConfig(AnnotatedClass ac) {
        JsonPOJOBuilder ann = (JsonPOJOBuilder) _findAnnotation(ac, JsonPOJOBuilder.class);
        if (ann == null) {
            return null;
        }
        return new JsonPOJOBuilder.Value(ann);
    }

    public PropertyName findNameForDeserialization(Annotated a) {
        JsonSetter js = (JsonSetter) _findAnnotation(a, JsonSetter.class);
        if (js != null) {
            return PropertyName.construct(js.value());
        }
        JsonProperty pann = (JsonProperty) _findAnnotation(a, JsonProperty.class);
        if (pann != null) {
            return PropertyName.construct(pann.value());
        }
        if (_hasOneOf(a, ANNOTATIONS_TO_INFER_DESER)) {
            return PropertyName.USE_DEFAULT;
        }
        return null;
    }

    public Boolean hasAnySetter(Annotated a) {
        JsonAnySetter ann = (JsonAnySetter) _findAnnotation(a, JsonAnySetter.class);
        if (ann == null) {
            return null;
        }
        return Boolean.valueOf(ann.enabled());
    }

    public JsonSetter.Value findSetterInfo(Annotated a) {
        return JsonSetter.Value.from((JsonSetter) _findAnnotation(a, JsonSetter.class));
    }

    public Boolean findMergeInfo(Annotated a) {
        JsonMerge ann = (JsonMerge) _findAnnotation(a, JsonMerge.class);
        if (ann == null) {
            return null;
        }
        return ann.value().asBoolean();
    }

    @Deprecated
    public boolean hasCreatorAnnotation(Annotated a) {
        JsonCreator ann = (JsonCreator) _findAnnotation(a, JsonCreator.class);
        boolean z = false;
        if (ann != null) {
            if (ann.mode() != Mode.DISABLED) {
                z = true;
            }
            return z;
        }
        if (this._cfgConstructorPropertiesImpliesCreator && (a instanceof AnnotatedConstructor)) {
            Java7Support java7Support = _java7Helper;
            if (java7Support != null) {
                Boolean b = java7Support.hasCreatorAnnotation(a);
                if (b != null) {
                    return b.booleanValue();
                }
            }
        }
        return false;
    }

    @Deprecated
    public Mode findCreatorBinding(Annotated a) {
        JsonCreator ann = (JsonCreator) _findAnnotation(a, JsonCreator.class);
        if (ann == null) {
            return null;
        }
        return ann.mode();
    }

    public Mode findCreatorAnnotation(MapperConfig<?> config, Annotated a) {
        JsonCreator ann = (JsonCreator) _findAnnotation(a, JsonCreator.class);
        if (ann != null) {
            return ann.mode();
        }
        if (this._cfgConstructorPropertiesImpliesCreator && config.isEnabled(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES) && (a instanceof AnnotatedConstructor)) {
            Java7Support java7Support = _java7Helper;
            if (java7Support != null) {
                Boolean b = java7Support.hasCreatorAnnotation(a);
                if (b != null && b.booleanValue()) {
                    return Mode.PROPERTIES;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean _isIgnorable(Annotated a) {
        JsonIgnore ann = (JsonIgnore) _findAnnotation(a, JsonIgnore.class);
        if (ann != null) {
            return ann.value();
        }
        Java7Support java7Support = _java7Helper;
        if (java7Support != null) {
            Boolean b = java7Support.findTransient(a);
            if (b != null) {
                return b.booleanValue();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Class<?> _classIfExplicit(Class<?> cls) {
        if (cls == null || ClassUtil.isBogusClass(cls)) {
            return null;
        }
        return cls;
    }

    /* access modifiers changed from: protected */
    public Class<?> _classIfExplicit(Class<?> cls, Class<?> implicit) {
        Class<?> cls2 = _classIfExplicit(cls);
        if (cls2 == null || cls2 == implicit) {
            return null;
        }
        return cls2;
    }

    /* access modifiers changed from: protected */
    public PropertyName _propertyName(String localName, String namespace) {
        if (localName.isEmpty()) {
            return PropertyName.USE_DEFAULT;
        }
        if (namespace == null || namespace.isEmpty()) {
            return PropertyName.construct(localName);
        }
        return PropertyName.construct(localName, namespace);
    }

    /* access modifiers changed from: protected */
    public PropertyName _findConstructorName(Annotated a) {
        if (a instanceof AnnotatedParameter) {
            AnnotatedParameter p = (AnnotatedParameter) a;
            if (p.getOwner() != null) {
                Java7Support java7Support = _java7Helper;
                if (java7Support != null) {
                    PropertyName name = java7Support.findConstructorName(p);
                    if (name != null) {
                        return name;
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public TypeResolverBuilder<?> _findTypeResolver(MapperConfig<?> config, Annotated ann, JavaType baseType) {
        TypeResolverBuilder<?> b;
        JsonTypeInfo info = (JsonTypeInfo) _findAnnotation(ann, JsonTypeInfo.class);
        JsonTypeResolver resAnn = (JsonTypeResolver) _findAnnotation(ann, JsonTypeResolver.class);
        TypeIdResolver idRes = null;
        if (resAnn != null) {
            if (info == null) {
                return null;
            }
            b = config.typeResolverBuilderInstance(ann, resAnn.value());
        } else if (info == null) {
            return null;
        } else {
            if (info.use() == C0079Id.NONE) {
                return _constructNoTypeResolverBuilder();
            }
            b = _constructStdTypeResolverBuilder();
        }
        JsonTypeIdResolver idResInfo = (JsonTypeIdResolver) _findAnnotation(ann, JsonTypeIdResolver.class);
        if (idResInfo != null) {
            idRes = config.typeIdResolverInstance(ann, idResInfo.value());
        }
        if (idRes != null) {
            idRes.init(baseType);
        }
        TypeResolverBuilder<?> b2 = b.init(info.use(), idRes);
        C0078As inclusion = info.include();
        if (inclusion == C0078As.EXTERNAL_PROPERTY && (ann instanceof AnnotatedClass)) {
            inclusion = C0078As.PROPERTY;
        }
        TypeResolverBuilder<?> b3 = b2.inclusion(inclusion).typeProperty(info.property());
        Class<?> defaultImpl = info.defaultImpl();
        if (defaultImpl != JsonTypeInfo.None.class && !defaultImpl.isAnnotation()) {
            b3 = b3.defaultImpl(defaultImpl);
        }
        return b3.typeIdVisibility(info.visible());
    }

    /* access modifiers changed from: protected */
    public StdTypeResolverBuilder _constructStdTypeResolverBuilder() {
        return new StdTypeResolverBuilder();
    }

    /* access modifiers changed from: protected */
    public StdTypeResolverBuilder _constructNoTypeResolverBuilder() {
        return StdTypeResolverBuilder.noTypeInfoBuilder();
    }

    private boolean _primitiveAndWrapper(Class<?> baseType, Class<?> refinement) {
        boolean z = true;
        if (baseType.isPrimitive()) {
            if (baseType != ClassUtil.primitiveType(refinement)) {
                z = false;
            }
            return z;
        } else if (!refinement.isPrimitive()) {
            return false;
        } else {
            if (refinement != ClassUtil.primitiveType(baseType)) {
                z = false;
            }
            return z;
        }
    }

    private boolean _primitiveAndWrapper(JavaType baseType, Class<?> refinement) {
        if (baseType.isPrimitive()) {
            return baseType.hasRawClass(ClassUtil.primitiveType(refinement));
        }
        boolean z = false;
        if (!refinement.isPrimitive()) {
            return false;
        }
        if (refinement == ClassUtil.primitiveType(baseType.getRawClass())) {
            z = true;
        }
        return z;
    }
}
