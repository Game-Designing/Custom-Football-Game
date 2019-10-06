package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.impl.ErrorThrowingDeserializer;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.SubTypeValidator;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BeanDeserializerFactory extends BasicDeserializerFactory implements Serializable {
    private static final Class<?>[] INIT_CAUSE_PARAMS = {Throwable.class};
    public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(new DeserializerFactoryConfig());

    public BeanDeserializerFactory(DeserializerFactoryConfig config) {
        super(config);
    }

    public JsonDeserializer<Object> createBeanDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        JsonDeserializer<Object> custom = _findCustomBeanDeserializer(type, config, beanDesc);
        if (custom != null) {
            return custom;
        }
        if (type.isThrowable()) {
            return buildThrowableDeserializer(ctxt, type, beanDesc);
        }
        if (type.isAbstract() && !type.isPrimitive() && !type.isEnumType()) {
            JavaType concreteType = materializeAbstractType(ctxt, type, beanDesc);
            if (concreteType != null) {
                return buildBeanDeserializer(ctxt, concreteType, config.introspect(concreteType));
            }
        }
        JsonDeserializer<Object> deser = findStdDeserializer(ctxt, type, beanDesc);
        if (deser != null) {
            return deser;
        }
        if (!isPotentialBeanType(type.getRawClass())) {
            return null;
        }
        _validateSubType(ctxt, type, beanDesc);
        return buildBeanDeserializer(ctxt, type, beanDesc);
    }

    public JsonDeserializer<Object> createBuilderBasedDeserializer(DeserializationContext ctxt, JavaType valueType, BeanDescription beanDesc, Class<?> builderClass) throws JsonMappingException {
        return buildBuilderBasedDeserializer(ctxt, valueType, ctxt.getConfig().introspectForBuilder(ctxt.constructType(builderClass)));
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> findStdDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        JsonDeserializer<?> deser = findDefaultDeserializer(ctxt, type, beanDesc);
        if (deser != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyDeserializer(ctxt.getConfig(), beanDesc, deser);
            }
        }
        return deser;
    }

    /* access modifiers changed from: protected */
    public JavaType materializeAbstractType(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        for (AbstractTypeResolver r : this._factoryConfig.abstractTypeResolvers()) {
            JavaType concrete = r.resolveAbstractType(ctxt.getConfig(), beanDesc);
            if (concrete != null) {
                return concrete;
            }
        }
        return null;
    }

    public JsonDeserializer<Object> buildBeanDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        JsonDeserializer<?> deserializer;
        try {
            ValueInstantiator valueInstantiator = findValueInstantiator(ctxt, beanDesc);
            BeanDeserializerBuilder builder = constructBeanDeserializerBuilder(ctxt, beanDesc);
            builder.setValueInstantiator(valueInstantiator);
            addBeanProps(ctxt, beanDesc, builder);
            addObjectIdReader(ctxt, beanDesc, builder);
            addBackReferenceProperties(ctxt, beanDesc, builder);
            addInjectables(ctxt, beanDesc, builder);
            DeserializationConfig config = ctxt.getConfig();
            if (this._factoryConfig.hasDeserializerModifiers()) {
                for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                    builder = mod.updateBuilder(config, beanDesc, builder);
                }
            }
            if (!type.isAbstract() || valueInstantiator.canInstantiate()) {
                deserializer = builder.build();
            } else {
                deserializer = builder.buildAbstract();
            }
            if (this._factoryConfig.hasDeserializerModifiers()) {
                for (BeanDeserializerModifier mod2 : this._factoryConfig.deserializerModifiers()) {
                    deserializer = mod2.modifyDeserializer(config, beanDesc, deserializer);
                }
            }
            return deserializer;
        } catch (NoClassDefFoundError error) {
            return new ErrorThrowingDeserializer(error);
        } catch (IllegalArgumentException e) {
            throw InvalidDefinitionException.from(ctxt.getParser(), e.getMessage(), beanDesc, (BeanPropertyDefinition) null);
        }
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> buildBuilderBasedDeserializer(DeserializationContext ctxt, JavaType valueType, BeanDescription builderDesc) throws JsonMappingException {
        try {
            ValueInstantiator valueInstantiator = findValueInstantiator(ctxt, builderDesc);
            DeserializationConfig config = ctxt.getConfig();
            BeanDeserializerBuilder builder = constructBeanDeserializerBuilder(ctxt, builderDesc);
            builder.setValueInstantiator(valueInstantiator);
            addBeanProps(ctxt, builderDesc, builder);
            addObjectIdReader(ctxt, builderDesc, builder);
            addBackReferenceProperties(ctxt, builderDesc, builder);
            addInjectables(ctxt, builderDesc, builder);
            Value builderConfig = builderDesc.findPOJOBuilderConfig();
            String buildMethodName = builderConfig == null ? "build" : builderConfig.buildMethodName;
            AnnotatedMethod buildMethod = builderDesc.findMethod(buildMethodName, null);
            if (buildMethod != null && config.canOverrideAccessModifiers()) {
                ClassUtil.checkAndFixAccess(buildMethod.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            builder.setPOJOBuilder(buildMethod, builderConfig);
            if (this._factoryConfig.hasDeserializerModifiers()) {
                for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                    builder = mod.updateBuilder(config, builderDesc, builder);
                }
            }
            JsonDeserializer<?> deserializer = builder.buildBuilderBased(valueType, buildMethodName);
            if (this._factoryConfig.hasDeserializerModifiers()) {
                for (BeanDeserializerModifier mod2 : this._factoryConfig.deserializerModifiers()) {
                    deserializer = mod2.modifyDeserializer(config, builderDesc, deserializer);
                }
            }
            return deserializer;
        } catch (NoClassDefFoundError error) {
            return new ErrorThrowingDeserializer(error);
        } catch (IllegalArgumentException e) {
            throw InvalidDefinitionException.from(ctxt.getParser(), e.getMessage(), builderDesc, (BeanPropertyDefinition) null);
        }
    }

    /* access modifiers changed from: protected */
    public void addObjectIdReader(DeserializationContext ctxt, BeanDescription beanDesc, BeanDeserializerBuilder builder) throws JsonMappingException {
        SettableBeanProperty idProp;
        ObjectIdGenerator objectIdGenerator;
        JavaType idType;
        DeserializationContext deserializationContext = ctxt;
        BeanDeserializerBuilder beanDeserializerBuilder = builder;
        ObjectIdInfo objectIdInfo = beanDesc.getObjectIdInfo();
        if (objectIdInfo != null) {
            Class<?> implClass = objectIdInfo.getGeneratorType();
            ObjectIdResolver resolver = deserializationContext.objectIdResolverInstance(beanDesc.getClassInfo(), objectIdInfo);
            if (implClass == ObjectIdGenerators$PropertyGenerator.class) {
                PropertyName propName = objectIdInfo.getPropertyName();
                SettableBeanProperty idProp2 = beanDeserializerBuilder.findProperty(propName);
                if (idProp2 != null) {
                    JavaType idType2 = idProp2.getType();
                    objectIdGenerator = new PropertyBasedObjectIdGenerator(objectIdInfo.getScope());
                    idProp = idProp2;
                    idType = idType2;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid Object Id definition for ");
                    sb.append(beanDesc.getBeanClass().getName());
                    sb.append(": cannot find property with name '");
                    sb.append(propName);
                    sb.append("'");
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                JavaType idType3 = ctxt.getTypeFactory().findTypeParameters(deserializationContext.constructType(implClass), ObjectIdGenerator.class)[0];
                objectIdGenerator = deserializationContext.objectIdGeneratorInstance(beanDesc.getClassInfo(), objectIdInfo);
                idType = idType3;
                idProp = null;
            }
            JavaType javaType = idType;
            beanDeserializerBuilder.setObjectIdReader(ObjectIdReader.construct(javaType, objectIdInfo.getPropertyName(), objectIdGenerator, deserializationContext.findRootValueDeserializer(idType), idProp, resolver));
        }
    }

    public JsonDeserializer<Object> buildThrowableDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        BeanDeserializerBuilder builder = constructBeanDeserializerBuilder(ctxt, beanDesc);
        builder.setValueInstantiator(findValueInstantiator(ctxt, beanDesc));
        addBeanProps(ctxt, beanDesc, builder);
        AnnotatedMethod am = beanDesc.findMethod("initCause", INIT_CAUSE_PARAMS);
        if (am != null) {
            SettableBeanProperty prop = constructSettableProperty(ctxt, beanDesc, SimpleBeanPropertyDefinition.construct(ctxt.getConfig(), am, new PropertyName("cause")), am.getParameterType(0));
            if (prop != null) {
                builder.addOrReplaceProperty(prop, true);
            }
        }
        builder.addIgnorable("localizedMessage");
        builder.addIgnorable("suppressed");
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                builder = mod.updateBuilder(config, beanDesc, builder);
            }
        }
        JsonDeserializer build = builder.build();
        if (build instanceof BeanDeserializer) {
            build = new ThrowableDeserializer((BeanDeserializer) build);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod2 : this._factoryConfig.deserializerModifiers()) {
                build = mod2.modifyDeserializer(config, beanDesc, build);
            }
        }
        return build;
    }

    /* access modifiers changed from: protected */
    public BeanDeserializerBuilder constructBeanDeserializerBuilder(DeserializationContext ctxt, BeanDescription beanDesc) {
        return new BeanDeserializerBuilder(beanDesc, ctxt);
    }

    /* access modifiers changed from: protected */
    public void addBeanProps(DeserializationContext ctxt, BeanDescription beanDesc, BeanDeserializerBuilder builder) throws JsonMappingException {
        Set set;
        List list;
        Iterator i$;
        List list2;
        DeserializationContext deserializationContext = ctxt;
        BeanDescription beanDescription = beanDesc;
        BeanDeserializerBuilder beanDeserializerBuilder = builder;
        SettableBeanProperty[] creatorProps = beanDesc.getType().isAbstract() ^ true ? builder.getValueInstantiator().getFromObjectArguments(ctxt.getConfig()) : null;
        int i = 0;
        boolean hasCreatorProps = creatorProps != null;
        JsonIgnoreProperties.Value ignorals = ctxt.getConfig().getDefaultPropertyIgnorals(beanDesc.getBeanClass(), beanDesc.getClassInfo());
        if (ignorals != null) {
            beanDeserializerBuilder.setIgnoreUnknownProperties(ignorals.getIgnoreUnknown());
            Set<String> ignored = ignorals.findIgnoredForDeserialization();
            for (String propName : ignored) {
                beanDeserializerBuilder.addIgnorable(propName);
            }
            set = ignored;
        } else {
            set = Collections.emptySet();
        }
        AnnotatedMember anySetter = beanDesc.findAnySetterAccessor();
        if (anySetter != null) {
            beanDeserializerBuilder.setAnySetter(constructAnySetter(deserializationContext, beanDescription, anySetter));
        } else {
            Collection<String> ignored2 = beanDesc.getIgnoredPropertyNames();
            if (ignored2 != null) {
                for (String propName2 : ignored2) {
                    beanDeserializerBuilder.addIgnorable(propName2);
                }
            }
        }
        boolean useGettersAsSetters = deserializationContext.isEnabled(MapperFeature.USE_GETTERS_AS_SETTERS) && deserializationContext.isEnabled(MapperFeature.AUTO_DETECT_GETTERS);
        AnnotatedMember annotatedMember = anySetter;
        List filterBeanProps = filterBeanProps(ctxt, beanDesc, builder, beanDesc.findProperties(), set);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                filterBeanProps = mod.updateProperties(ctxt.getConfig(), beanDescription, filterBeanProps);
            }
        }
        Iterator i$2 = list.iterator();
        while (i$2.hasNext()) {
            BeanPropertyDefinition propDef = (BeanPropertyDefinition) i$2.next();
            SettableBeanProperty prop = null;
            if (propDef.hasSetter()) {
                prop = constructSettableProperty(deserializationContext, beanDescription, propDef, propDef.getSetter().getParameterType(i));
            } else if (propDef.hasField()) {
                prop = constructSettableProperty(deserializationContext, beanDescription, propDef, propDef.getField().getType());
            } else {
                AnnotatedMethod getter = propDef.getGetter();
                if (getter != null) {
                    if (!useGettersAsSetters || !_isSetterlessType(getter.getRawType())) {
                        if (!propDef.hasConstructorParameter() && propDef.getMetadata().getMergeInfo() != null) {
                            prop = constructSetterlessProperty(deserializationContext, beanDescription, propDef);
                        }
                    } else if (!beanDeserializerBuilder.hasIgnorable(propDef.getName())) {
                        prop = constructSetterlessProperty(deserializationContext, beanDescription, propDef);
                    }
                }
            }
            if (!hasCreatorProps || !propDef.hasConstructorParameter()) {
                List list3 = list;
                Iterator i$3 = i$2;
                if (prop != null) {
                    Class<?>[] views = propDef.findViews();
                    if (views == null) {
                        views = beanDesc.findDefaultViews();
                    }
                    prop.setViews(views);
                    beanDeserializerBuilder.addProperty(prop);
                }
                list = list3;
                i$2 = i$3;
                i = 0;
            } else {
                String name = propDef.getName();
                CreatorProperty cprop = null;
                if (creatorProps != null) {
                    SettableBeanProperty[] arr$ = creatorProps;
                    int len$ = arr$.length;
                    int i$4 = 0;
                    while (true) {
                        if (i$4 >= len$) {
                            list2 = list;
                            i$ = i$2;
                            break;
                        }
                        list2 = list;
                        SettableBeanProperty cp = arr$[i$4];
                        i$ = i$2;
                        if (name.equals(cp.getName()) && (cp instanceof CreatorProperty)) {
                            cprop = (CreatorProperty) cp;
                            break;
                        }
                        i$4++;
                        list = list2;
                        i$2 = i$;
                    }
                } else {
                    list2 = list;
                    i$ = i$2;
                }
                if (cprop == null) {
                    ArrayList arrayList = new ArrayList();
                    for (SettableBeanProperty cp2 : creatorProps) {
                        arrayList.add(cp2.getName());
                    }
                    deserializationContext.reportBadPropertyDefinition(beanDescription, propDef, "Could not find creator property with name '%s' (known Creator properties: %s)", name, arrayList);
                    throw null;
                }
                if (prop != null) {
                    cprop.setFallbackSetter(prop);
                }
                Class<?>[] views2 = propDef.findViews();
                if (views2 == null) {
                    views2 = beanDesc.findDefaultViews();
                }
                cprop.setViews(views2);
                beanDeserializerBuilder.addCreatorProperty(cprop);
                list = list2;
                i$2 = i$;
                i = 0;
            }
        }
        List list4 = list;
        Iterator it = i$2;
    }

    private boolean _isSetterlessType(Class<?> rawType) {
        return Collection.class.isAssignableFrom(rawType) || Map.class.isAssignableFrom(rawType);
    }

    /* access modifiers changed from: protected */
    public List<BeanPropertyDefinition> filterBeanProps(DeserializationContext ctxt, BeanDescription beanDesc, BeanDeserializerBuilder builder, List<BeanPropertyDefinition> propDefsIn, Set<String> ignored) throws JsonMappingException {
        ArrayList<BeanPropertyDefinition> result = new ArrayList<>(Math.max(4, propDefsIn.size()));
        HashMap<Class<?>, Boolean> ignoredTypes = new HashMap<>();
        for (BeanPropertyDefinition property : propDefsIn) {
            String name = property.getName();
            if (!ignored.contains(name)) {
                if (!property.hasConstructorParameter()) {
                    Class<?> rawPropertyType = property.getRawPrimaryType();
                    if (rawPropertyType != null && isIgnorableType(ctxt.getConfig(), property, rawPropertyType, ignoredTypes)) {
                        builder.addIgnorable(name);
                    }
                }
                result.add(property);
            }
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public void addBackReferenceProperties(DeserializationContext ctxt, BeanDescription beanDesc, BeanDeserializerBuilder builder) throws JsonMappingException {
        List<BeanPropertyDefinition> refProps = beanDesc.findBackReferences();
        if (refProps != null) {
            for (BeanPropertyDefinition refProp : refProps) {
                builder.addBackReferenceProperty(refProp.findReferenceName(), constructSettableProperty(ctxt, beanDesc, refProp, refProp.getPrimaryType()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addInjectables(DeserializationContext ctxt, BeanDescription beanDesc, BeanDeserializerBuilder builder) throws JsonMappingException {
        Map<Object, AnnotatedMember> raw = beanDesc.findInjectables();
        if (raw != null) {
            for (Entry<Object, AnnotatedMember> entry : raw.entrySet()) {
                AnnotatedMember m = (AnnotatedMember) entry.getValue();
                builder.addInjectable(PropertyName.construct(m.getName()), m.getType(), beanDesc.getClassAnnotations(), m, entry.getKey());
            }
        }
    }

    /* access modifiers changed from: protected */
    public SettableAnyProperty constructAnySetter(DeserializationContext ctxt, BeanDescription beanDesc, AnnotatedMember mutator) throws JsonMappingException {
        JavaType valueType;
        Std std;
        JavaType keyType;
        KeyDeserializer keyDeser;
        JsonDeserializer<Object> deser;
        DeserializationContext deserializationContext = ctxt;
        AnnotatedMember annotatedMember = mutator;
        if (annotatedMember instanceof AnnotatedMethod) {
            AnnotatedMethod am = (AnnotatedMethod) annotatedMember;
            keyType = am.getParameterType(0);
            JavaType valueType2 = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, am.getParameterType(1));
            Std std2 = new Std(PropertyName.construct(mutator.getName()), valueType2, null, mutator, PropertyMetadata.STD_OPTIONAL);
            valueType = valueType2;
            std = std2;
        } else if (annotatedMember instanceof AnnotatedField) {
            JavaType mapType = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, ((AnnotatedField) annotatedMember).getType());
            JavaType keyType2 = mapType.getKeyType();
            valueType = mapType.getContentType();
            Std std3 = new Std(PropertyName.construct(mutator.getName()), mapType, null, mutator, PropertyMetadata.STD_OPTIONAL);
            keyType = keyType2;
            std = std3;
        } else {
            deserializationContext.reportBadDefinition(beanDesc.getType(), String.format("Unrecognized mutator type for any setter: %s", new Object[]{mutator.getClass()}));
            throw null;
        }
        KeyDeserializer keyDeser2 = findKeyDeserializerFromAnnotation(deserializationContext, annotatedMember);
        if (keyDeser2 == null) {
            keyDeser2 = (KeyDeserializer) keyType.getValueHandler();
        }
        if (keyDeser2 == null) {
            keyDeser = deserializationContext.findKeyDeserializer(keyType, std);
        } else if (keyDeser2 instanceof ContextualKeyDeserializer) {
            keyDeser = ((ContextualKeyDeserializer) keyDeser2).createContextual(deserializationContext, std);
        } else {
            keyDeser = keyDeser2;
        }
        JsonDeserializer<Object> deser2 = findContentDeserializerFromAnnotation(deserializationContext, annotatedMember);
        if (deser2 == null) {
            deser2 = (JsonDeserializer) valueType.getValueHandler();
        }
        if (deser2 != null) {
            deser = deserializationContext.handlePrimaryContextualization(deser2, std, valueType);
        } else {
            deser = deser2;
        }
        SettableAnyProperty settableAnyProperty = new SettableAnyProperty(std, mutator, valueType, keyDeser, deser, (TypeDeserializer) valueType.getTypeHandler());
        return settableAnyProperty;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty constructSettableProperty(DeserializationContext ctxt, BeanDescription beanDesc, BeanPropertyDefinition propDef, JavaType propType0) throws JsonMappingException {
        SettableBeanProperty prop;
        AnnotatedMember mutator = propDef.getNonConstructorMutator();
        if (mutator != null) {
            JavaType type = resolveMemberAndTypeAnnotations(ctxt, mutator, propType0);
            TypeDeserializer typeDeser = (TypeDeserializer) type.getTypeHandler();
            if (mutator instanceof AnnotatedMethod) {
                MethodProperty methodProperty = new MethodProperty(propDef, type, typeDeser, beanDesc.getClassAnnotations(), (AnnotatedMethod) mutator);
                prop = methodProperty;
            } else {
                FieldProperty prop2 = new FieldProperty(propDef, type, typeDeser, beanDesc.getClassAnnotations(), (AnnotatedField) mutator);
                prop = prop2;
            }
            JsonDeserializer<?> deser = findDeserializerFromAnnotation(ctxt, mutator);
            if (deser == null) {
                deser = (JsonDeserializer) type.getValueHandler();
            }
            if (deser != null) {
                prop = prop.withValueDeserializer(ctxt.handlePrimaryContextualization(deser, prop, type));
            }
            ReferenceProperty ref = propDef.findReferenceType();
            if (ref != null && ref.isManagedReference()) {
                prop.setManagedReferenceName(ref.getName());
            }
            ObjectIdInfo objectIdInfo = propDef.findObjectIdInfo();
            if (objectIdInfo != null) {
                prop.setObjectIdInfo(objectIdInfo);
            }
            return prop;
        }
        ctxt.reportBadPropertyDefinition(beanDesc, propDef, "No non-constructor mutator available", new Object[0]);
        throw null;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty constructSetterlessProperty(DeserializationContext ctxt, BeanDescription beanDesc, BeanPropertyDefinition propDef) throws JsonMappingException {
        AnnotatedMethod getter = propDef.getGetter();
        JavaType type = resolveMemberAndTypeAnnotations(ctxt, getter, getter.getType());
        SetterlessProperty setterlessProperty = new SetterlessProperty(propDef, type, (TypeDeserializer) type.getTypeHandler(), beanDesc.getClassAnnotations(), getter);
        JsonDeserializer<?> deser = findDeserializerFromAnnotation(ctxt, getter);
        if (deser == null) {
            deser = (JsonDeserializer) type.getValueHandler();
        }
        if (deser != null) {
            return setterlessProperty.withValueDeserializer(ctxt.handlePrimaryContextualization(deser, setterlessProperty, type));
        }
        return setterlessProperty;
    }

    /* access modifiers changed from: protected */
    public boolean isPotentialBeanType(Class<?> type) {
        String typeStr = ClassUtil.canBeABeanType(type);
        String str = ") as a Bean";
        String str2 = " (of type ";
        String str3 = "Cannot deserialize Class ";
        if (typeStr != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(type.getName());
            sb.append(str2);
            sb.append(typeStr);
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        } else if (!ClassUtil.isProxyType(type)) {
            String typeStr2 = ClassUtil.isLocalType(type, true);
            if (typeStr2 == null) {
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(type.getName());
            sb2.append(str2);
            sb2.append(typeStr2);
            sb2.append(str);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Cannot deserialize Proxy class ");
            sb3.append(type.getName());
            sb3.append(" as a Bean");
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* access modifiers changed from: protected */
    public boolean isIgnorableType(DeserializationConfig config, BeanPropertyDefinition propDef, Class<?> type, Map<Class<?>, Boolean> ignoredTypes) {
        Boolean status;
        Boolean status2 = (Boolean) ignoredTypes.get(type);
        if (status2 != null) {
            return status2.booleanValue();
        }
        if (type == String.class || type.isPrimitive()) {
            status = Boolean.FALSE;
        } else {
            status = config.getConfigOverride(type).getIsIgnoredType();
            if (status == null) {
                status = config.getAnnotationIntrospector().isIgnorableType(config.introspectClassAnnotations(type).getClassInfo());
                if (status == null) {
                    status = Boolean.FALSE;
                }
            }
        }
        ignoredTypes.put(type, status);
        return status.booleanValue();
    }

    /* access modifiers changed from: protected */
    public void _validateSubType(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        SubTypeValidator.instance().validateSubType(ctxt, type, beanDesc);
    }
}
