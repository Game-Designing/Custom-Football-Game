package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties.Value;
import com.fasterxml.jackson.annotation.JsonTypeInfo.C0078As;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BeanSerializerFactory extends BasicSerializerFactory implements Serializable {
    public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);

    protected BeanSerializerFactory(SerializerFactoryConfig config) {
        super(config);
    }

    /* access modifiers changed from: protected */
    public Iterable<Serializers> customSerializers() {
        return this._factoryConfig.serializers();
    }

    public JsonSerializer<Object> createSerializer(SerializerProvider prov, JavaType origType) throws JsonMappingException {
        JavaType type;
        boolean staticTyping;
        SerializationConfig config = prov.getConfig();
        BeanDescription beanDesc = config.introspect(origType);
        JsonSerializer<?> ser = findSerializerFromAnnotation(prov, beanDesc.getClassInfo());
        if (ser != null) {
            return ser;
        }
        AnnotationIntrospector intr = config.getAnnotationIntrospector();
        if (intr == null) {
            type = origType;
        } else {
            try {
                type = intr.refineSerializationType(config, beanDesc.getClassInfo(), origType);
            } catch (JsonMappingException e) {
                prov.reportBadTypeDefinition(beanDesc, e.getMessage(), new Object[0]);
                throw null;
            }
        }
        if (type == origType) {
            staticTyping = false;
        } else {
            staticTyping = true;
            if (!type.hasRawClass(origType.getRawClass())) {
                beanDesc = config.introspect(type);
            }
        }
        Converter<Object, Object> conv = beanDesc.findSerializationConverter();
        if (conv == null) {
            return _createSerializer2(prov, type, beanDesc, staticTyping);
        }
        JavaType delegateType = conv.getOutputType(prov.getTypeFactory());
        if (!delegateType.hasRawClass(type.getRawClass())) {
            beanDesc = config.introspect(delegateType);
            ser = findSerializerFromAnnotation(prov, beanDesc.getClassInfo());
        }
        if (ser == null && !delegateType.isJavaLangObject()) {
            ser = _createSerializer2(prov, delegateType, beanDesc, true);
        }
        return new StdDelegatingSerializer(conv, delegateType, ser);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> _createSerializer2(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        JsonSerializer<?> ser = null;
        SerializationConfig config = prov.getConfig();
        if (type.isContainerType()) {
            if (!staticTyping) {
                staticTyping = usesStaticTyping(config, beanDesc, null);
            }
            ser = buildContainerSerializer(prov, type, beanDesc, staticTyping);
            if (ser != null) {
                return ser;
            }
        } else {
            if (!type.isReferenceType()) {
                for (Serializers serializers : customSerializers()) {
                    ser = serializers.findSerializer(config, type, beanDesc);
                    if (ser != null) {
                        break;
                    }
                }
            } else {
                ser = findReferenceSerializer(prov, (ReferenceType) type, beanDesc, staticTyping);
            }
            if (ser == null) {
                ser = findSerializerByAnnotations(prov, type, beanDesc);
            }
        }
        if (ser == null) {
            ser = findSerializerByLookup(type, config, beanDesc, staticTyping);
            if (ser == null) {
                ser = findSerializerByPrimaryType(prov, type, beanDesc, staticTyping);
                if (ser == null) {
                    ser = findBeanSerializer(prov, type, beanDesc);
                    if (ser == null) {
                        ser = findSerializerByAddonType(config, type, beanDesc, staticTyping);
                        if (ser == null) {
                            ser = prov.getUnknownTypeSerializer(beanDesc.getBeanClass());
                        }
                    }
                }
            }
        }
        if (ser != null && this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                ser = mod.modifySerializer(config, beanDesc, ser);
            }
        }
        return ser;
    }

    public JsonSerializer<Object> findBeanSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        if (isPotentialBeanType(type.getRawClass()) || type.isEnumType()) {
            return constructBeanSerializer(prov, beanDesc);
        }
        return null;
    }

    public TypeSerializer findPropertyTypeSerializer(JavaType baseType, SerializationConfig config, AnnotatedMember accessor) throws JsonMappingException {
        TypeResolverBuilder<?> b = config.getAnnotationIntrospector().findPropertyTypeResolver(config, accessor, baseType);
        if (b == null) {
            return createTypeSerializer(config, baseType);
        }
        return b.buildTypeSerializer(config, baseType, config.getSubtypeResolver().collectAndResolveSubtypesByClass(config, accessor, baseType));
    }

    public TypeSerializer findPropertyContentTypeSerializer(JavaType containerType, SerializationConfig config, AnnotatedMember accessor) throws JsonMappingException {
        JavaType contentType = containerType.getContentType();
        TypeResolverBuilder<?> b = config.getAnnotationIntrospector().findPropertyContentTypeResolver(config, accessor, containerType);
        if (b == null) {
            return createTypeSerializer(config, contentType);
        }
        return b.buildTypeSerializer(config, contentType, config.getSubtypeResolver().collectAndResolveSubtypesByClass(config, accessor, contentType));
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> constructBeanSerializer(SerializerProvider prov, BeanDescription beanDesc) throws JsonMappingException {
        List list;
        JavaType valueType;
        JsonSerializer<?> anySer;
        SerializerProvider serializerProvider = prov;
        BeanDescription beanDescription = beanDesc;
        if (beanDesc.getBeanClass() == Object.class) {
            return serializerProvider.getUnknownTypeSerializer(Object.class);
        }
        SerializationConfig config = prov.getConfig();
        BeanSerializerBuilder builder = constructBeanSerializerBuilder(beanDescription);
        builder.setConfig(config);
        List<BeanPropertyWriter> props = findBeanProperties(serializerProvider, beanDescription, builder);
        if (props == null) {
            list = new ArrayList();
        } else {
            list = removeOverlappingTypeIds(serializerProvider, beanDescription, builder, props);
        }
        prov.getAnnotationIntrospector().findAndAddVirtualProperties(config, beanDesc.getClassInfo(), list);
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                list = mod.changeProperties(config, beanDescription, list);
            }
        }
        List<BeanPropertyWriter> props2 = filterBeanProperties(config, beanDescription, list);
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod2 : this._factoryConfig.serializerModifiers()) {
                props2 = mod2.orderProperties(config, beanDescription, props2);
            }
        }
        builder.setObjectIdWriter(constructObjectIdHandler(serializerProvider, beanDescription, props2));
        builder.setProperties(props2);
        builder.setFilterId(findFilterId(config, beanDescription));
        AnnotatedMember anyGetter = beanDesc.findAnyGetter();
        if (anyGetter != null) {
            JavaType type = anyGetter.getType();
            boolean staticTyping = config.isEnabled(MapperFeature.USE_STATIC_TYPING);
            JavaType valueType2 = type.getContentType();
            TypeSerializer typeSer = createTypeSerializer(config, valueType2);
            JsonSerializer<?> anySer2 = findSerializerFromAnnotation(serializerProvider, anyGetter);
            if (anySer2 == null) {
                valueType = valueType2;
                anySer = MapSerializer.construct(null, type, staticTyping, typeSer, null, null, null);
            } else {
                valueType = valueType2;
                anySer = anySer2;
            }
            Std anyProp = new Std(PropertyName.construct(anyGetter.getName()), valueType, null, anyGetter, PropertyMetadata.STD_OPTIONAL);
            builder.setAnyGetter(new AnyGetterWriter(anyProp, anyGetter, anySer));
        }
        processViews(config, builder);
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod3 : this._factoryConfig.serializerModifiers()) {
                builder = mod3.updateBuilder(config, beanDescription, builder);
            }
        }
        try {
            JsonSerializer build = builder.build();
            if (build != null || !beanDesc.hasKnownClassAnnotations()) {
                return build;
            }
            return builder.createDummy();
        } catch (RuntimeException e) {
            RuntimeException e2 = e;
            serializerProvider.reportBadTypeDefinition(beanDescription, "Failed to construct BeanSerializer for %s: (%s) %s", beanDesc.getType(), e2.getClass().getName(), e2.getMessage());
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public ObjectIdWriter constructObjectIdHandler(SerializerProvider prov, BeanDescription beanDesc, List<BeanPropertyWriter> props) throws JsonMappingException {
        ObjectIdInfo objectIdInfo = beanDesc.getObjectIdInfo();
        if (objectIdInfo == null) {
            return null;
        }
        Class<?> implClass = objectIdInfo.getGeneratorType();
        if (implClass == ObjectIdGenerators$PropertyGenerator.class) {
            String propName = objectIdInfo.getPropertyName().getSimpleName();
            int len = props.size();
            for (int i = 0; i != len; i++) {
                BeanPropertyWriter prop = (BeanPropertyWriter) props.get(i);
                if (propName.equals(prop.getName())) {
                    BeanPropertyWriter idProp = prop;
                    if (i > 0) {
                        props.remove(i);
                        props.add(0, idProp);
                    }
                    return ObjectIdWriter.construct(idProp.getType(), null, new PropertyBasedObjectIdGenerator<>(objectIdInfo, idProp), objectIdInfo.getAlwaysAsId());
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid Object Id definition for ");
            sb.append(beanDesc.getBeanClass().getName());
            sb.append(": cannot find property with name '");
            sb.append(propName);
            sb.append("'");
            throw new IllegalArgumentException(sb.toString());
        }
        return ObjectIdWriter.construct(prov.getTypeFactory().findTypeParameters(prov.constructType(implClass), ObjectIdGenerator.class)[0], objectIdInfo.getPropertyName(), prov.objectIdGeneratorInstance(beanDesc.getClassInfo(), objectIdInfo), objectIdInfo.getAlwaysAsId());
    }

    /* access modifiers changed from: protected */
    public BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter writer, Class<?>[] inViews) {
        return FilteredBeanPropertyWriter.constructViewBased(writer, inViews);
    }

    /* access modifiers changed from: protected */
    public PropertyBuilder constructPropertyBuilder(SerializationConfig config, BeanDescription beanDesc) {
        return new PropertyBuilder(config, beanDesc);
    }

    /* access modifiers changed from: protected */
    public BeanSerializerBuilder constructBeanSerializerBuilder(BeanDescription beanDesc) {
        return new BeanSerializerBuilder(beanDesc);
    }

    /* access modifiers changed from: protected */
    public boolean isPotentialBeanType(Class<?> type) {
        return ClassUtil.canBeABeanType(type) == null && !ClassUtil.isProxyType(type);
    }

    /* access modifiers changed from: protected */
    public List<BeanPropertyWriter> findBeanProperties(SerializerProvider prov, BeanDescription beanDesc, BeanSerializerBuilder builder) throws JsonMappingException {
        BeanDescription beanDescription = beanDesc;
        List<BeanPropertyDefinition> properties = beanDesc.findProperties();
        SerializationConfig config = prov.getConfig();
        removeIgnorableTypes(config, beanDescription, properties);
        if (config.isEnabled(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
            removeSetterlessGetters(config, beanDescription, properties);
        }
        if (properties.isEmpty()) {
            return null;
        }
        boolean staticTyping = usesStaticTyping(config, beanDescription, null);
        PropertyBuilder pb = constructPropertyBuilder(config, beanDescription);
        ArrayList arrayList = new ArrayList(properties.size());
        for (BeanPropertyDefinition property : properties) {
            AnnotatedMember accessor = property.getAccessor();
            if (!property.isTypeId()) {
                BeanSerializerBuilder beanSerializerBuilder = builder;
                ReferenceProperty refType = property.findReferenceType();
                if (refType == null || !refType.isBackReference()) {
                    if (accessor instanceof AnnotatedMethod) {
                        arrayList.add(_constructWriter(prov, property, pb, staticTyping, (AnnotatedMethod) accessor));
                    } else {
                        arrayList.add(_constructWriter(prov, property, pb, staticTyping, (AnnotatedField) accessor));
                    }
                }
            } else if (accessor != null) {
                builder.setTypeId(accessor);
            } else {
                BeanSerializerBuilder beanSerializerBuilder2 = builder;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<BeanPropertyWriter> filterBeanProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> props) {
        Value ignorals = config.getDefaultPropertyIgnorals(beanDesc.getBeanClass(), beanDesc.getClassInfo());
        if (ignorals != null) {
            Set<String> ignored = ignorals.findIgnoredForSerialization();
            if (!ignored.isEmpty()) {
                Iterator<BeanPropertyWriter> it = props.iterator();
                while (it.hasNext()) {
                    if (ignored.contains(((BeanPropertyWriter) it.next()).getName())) {
                        it.remove();
                    }
                }
            }
        }
        return props;
    }

    /* access modifiers changed from: protected */
    public void processViews(SerializationConfig config, BeanSerializerBuilder builder) {
        List<BeanPropertyWriter> props = builder.getProperties();
        boolean includeByDefault = config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        int propCount = props.size();
        int viewsFound = 0;
        BeanPropertyWriter[] filtered = new BeanPropertyWriter[propCount];
        for (int i = 0; i < propCount; i++) {
            BeanPropertyWriter bpw = (BeanPropertyWriter) props.get(i);
            Class<?>[] views = bpw.getViews();
            if (views != null) {
                viewsFound++;
                filtered[i] = constructFilteredBeanWriter(bpw, views);
            } else if (includeByDefault) {
                filtered[i] = bpw;
            }
        }
        if (!includeByDefault || viewsFound != 0) {
            builder.setFilteredProperties(filtered);
        }
    }

    /* access modifiers changed from: protected */
    public void removeIgnorableTypes(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyDefinition> properties) {
        AnnotationIntrospector intr = config.getAnnotationIntrospector();
        HashMap<Class<?>, Boolean> ignores = new HashMap<>();
        Iterator<BeanPropertyDefinition> it = properties.iterator();
        while (it.hasNext()) {
            BeanPropertyDefinition property = (BeanPropertyDefinition) it.next();
            if (property.getAccessor() == null) {
                it.remove();
            } else {
                Class<?> type = property.getRawPrimaryType();
                Boolean result = (Boolean) ignores.get(type);
                if (result == null) {
                    result = config.getConfigOverride(type).getIsIgnoredType();
                    if (result == null) {
                        result = intr.isIgnorableType(config.introspectClassAnnotations(type).getClassInfo());
                        if (result == null) {
                            result = Boolean.FALSE;
                        }
                    }
                    ignores.put(type, result);
                }
                if (result.booleanValue()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeSetterlessGetters(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyDefinition> properties) {
        Iterator<BeanPropertyDefinition> it = properties.iterator();
        while (it.hasNext()) {
            BeanPropertyDefinition property = (BeanPropertyDefinition) it.next();
            if (!property.couldDeserialize() && !property.isExplicitlyIncluded()) {
                it.remove();
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<BeanPropertyWriter> removeOverlappingTypeIds(SerializerProvider prov, BeanDescription beanDesc, BeanSerializerBuilder builder, List<BeanPropertyWriter> props) {
        int end = props.size();
        for (int i = 0; i < end; i++) {
            BeanPropertyWriter bpw = (BeanPropertyWriter) props.get(i);
            TypeSerializer td = bpw.getTypeSerializer();
            if (td != null && td.getTypeInclusion() == C0078As.EXTERNAL_PROPERTY) {
                PropertyName typePropName = PropertyName.construct(td.getPropertyName());
                Iterator i$ = props.iterator();
                while (true) {
                    if (!i$.hasNext()) {
                        break;
                    }
                    BeanPropertyWriter w2 = (BeanPropertyWriter) i$.next();
                    if (w2 != bpw && w2.wouldConflictWithName(typePropName)) {
                        bpw.assignTypeSerializer(null);
                        break;
                    }
                }
            }
        }
        return props;
    }

    /* access modifiers changed from: protected */
    public BeanPropertyWriter _constructWriter(SerializerProvider prov, BeanPropertyDefinition propDef, PropertyBuilder pb, boolean staticTyping, AnnotatedMember accessor) throws JsonMappingException {
        TypeSerializer contentTypeSer;
        SerializerProvider serializerProvider = prov;
        AnnotatedMember annotatedMember = accessor;
        PropertyName name = propDef.getFullName();
        JavaType type = accessor.getType();
        Std std = new Std(name, type, propDef.getWrapperName(), accessor, propDef.getMetadata());
        Std property = std;
        JsonSerializer<?> annotatedSerializer = findSerializerFromAnnotation(serializerProvider, annotatedMember);
        if (annotatedSerializer instanceof ResolvableSerializer) {
            ((ResolvableSerializer) annotatedSerializer).resolve(serializerProvider);
        }
        JsonSerializer<?> annotatedSerializer2 = serializerProvider.handlePrimaryContextualization(annotatedSerializer, property);
        if (type.isContainerType() || type.isReferenceType()) {
            contentTypeSer = findPropertyContentTypeSerializer(type, prov.getConfig(), annotatedMember);
        } else {
            contentTypeSer = null;
        }
        return pb.buildWriter(prov, propDef, type, annotatedSerializer2, findPropertyTypeSerializer(type, prov.getConfig(), annotatedMember), contentTypeSer, accessor, staticTyping);
    }
}
