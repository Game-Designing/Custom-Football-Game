package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo.C0078As;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyMetadata.MergeInfo;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;
import com.fasterxml.jackson.databind.deser.impl.InnerClassProperty;
import com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.MergingSettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BeanDeserializerBase extends StdDeserializer<Object> implements ContextualDeserializer, ResolvableDeserializer, Gettable, Serializable {
    protected static final PropertyName TEMP_PROPERTY_NAME = new PropertyName("#temporary-name");
    protected SettableAnyProperty _anySetter;
    protected JsonDeserializer<Object> _arrayDelegateDeserializer;
    protected final Map<String, SettableBeanProperty> _backRefs;
    protected final BeanPropertyMap _beanProperties;
    protected final JavaType _beanType;
    protected JsonDeserializer<Object> _delegateDeserializer;
    protected ExternalTypeHandler _externalTypeIdHandler;
    protected final Set<String> _ignorableProps;
    protected final boolean _ignoreAllUnknown;
    protected final ValueInjector[] _injectables;
    protected final boolean _needViewProcesing;
    protected boolean _nonStandardCreation;
    protected final ObjectIdReader _objectIdReader;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected final Shape _serializationShape;
    protected transient HashMap<ClassKey, JsonDeserializer<Object>> _subDeserializers;
    protected UnwrappedPropertyHandler _unwrappedPropertyHandler;
    protected final ValueInstantiator _valueInstantiator;
    protected boolean _vanillaProcessing;

    /* access modifiers changed from: protected */
    public abstract Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    /* access modifiers changed from: protected */
    public abstract BeanDeserializerBase asArrayDeserializer();

    public abstract Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    public abstract BeanDeserializerBase withIgnorableProperties(Set<String> set);

    public abstract BeanDeserializerBase withObjectIdReader(ObjectIdReader objectIdReader);

    protected BeanDeserializerBase(BeanDeserializerBuilder builder, BeanDescription beanDesc, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, Set<String> ignorableProps, boolean ignoreAllUnknown, boolean hasViews) {
        super(beanDesc.getType());
        this._beanType = beanDesc.getType();
        this._valueInstantiator = builder.getValueInstantiator();
        this._beanProperties = properties;
        this._backRefs = backRefs;
        this._ignorableProps = ignorableProps;
        this._ignoreAllUnknown = ignoreAllUnknown;
        this._anySetter = builder.getAnySetter();
        List<ValueInjector> injectables = builder.getInjectables();
        Shape shape = null;
        this._injectables = (injectables == null || injectables.isEmpty()) ? null : (ValueInjector[]) injectables.toArray(new ValueInjector[injectables.size()]);
        this._objectIdReader = builder.getObjectIdReader();
        boolean z = false;
        this._nonStandardCreation = this._unwrappedPropertyHandler != null || this._valueInstantiator.canCreateUsingDelegate() || this._valueInstantiator.canCreateUsingArrayDelegate() || this._valueInstantiator.canCreateFromObjectWith() || !this._valueInstantiator.canCreateUsingDefault();
        Value format = beanDesc.findExpectedFormat(null);
        if (format != null) {
            shape = format.getShape();
        }
        this._serializationShape = shape;
        this._needViewProcesing = hasViews;
        if (!this._nonStandardCreation && this._injectables == null && !this._needViewProcesing && this._objectIdReader == null) {
            z = true;
        }
        this._vanillaProcessing = z;
    }

    protected BeanDeserializerBase(BeanDeserializerBase src) {
        this(src, src._ignoreAllUnknown);
    }

    protected BeanDeserializerBase(BeanDeserializerBase src, boolean ignoreAllUnknown) {
        super(src._beanType);
        this._beanType = src._beanType;
        this._valueInstantiator = src._valueInstantiator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._beanProperties = src._beanProperties;
        this._backRefs = src._backRefs;
        this._ignorableProps = src._ignorableProps;
        this._ignoreAllUnknown = ignoreAllUnknown;
        this._anySetter = src._anySetter;
        this._injectables = src._injectables;
        this._objectIdReader = src._objectIdReader;
        this._nonStandardCreation = src._nonStandardCreation;
        this._unwrappedPropertyHandler = src._unwrappedPropertyHandler;
        this._needViewProcesing = src._needViewProcesing;
        this._serializationShape = src._serializationShape;
        this._vanillaProcessing = src._vanillaProcessing;
    }

    protected BeanDeserializerBase(BeanDeserializerBase src, NameTransformer unwrapper) {
        super(src._beanType);
        this._beanType = src._beanType;
        this._valueInstantiator = src._valueInstantiator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._backRefs = src._backRefs;
        this._ignorableProps = src._ignorableProps;
        this._ignoreAllUnknown = unwrapper != null || src._ignoreAllUnknown;
        this._anySetter = src._anySetter;
        this._injectables = src._injectables;
        this._objectIdReader = src._objectIdReader;
        this._nonStandardCreation = src._nonStandardCreation;
        UnwrappedPropertyHandler uph = src._unwrappedPropertyHandler;
        if (unwrapper != null) {
            if (uph != null) {
                uph = uph.renameAll(unwrapper);
            }
            this._beanProperties = src._beanProperties.renameAll(unwrapper);
        } else {
            this._beanProperties = src._beanProperties;
        }
        this._unwrappedPropertyHandler = uph;
        this._needViewProcesing = src._needViewProcesing;
        this._serializationShape = src._serializationShape;
        this._vanillaProcessing = false;
    }

    public BeanDeserializerBase(BeanDeserializerBase src, ObjectIdReader oir) {
        super(src._beanType);
        this._beanType = src._beanType;
        this._valueInstantiator = src._valueInstantiator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._backRefs = src._backRefs;
        this._ignorableProps = src._ignorableProps;
        this._ignoreAllUnknown = src._ignoreAllUnknown;
        this._anySetter = src._anySetter;
        this._injectables = src._injectables;
        this._nonStandardCreation = src._nonStandardCreation;
        this._unwrappedPropertyHandler = src._unwrappedPropertyHandler;
        this._needViewProcesing = src._needViewProcesing;
        this._serializationShape = src._serializationShape;
        this._objectIdReader = oir;
        if (oir == null) {
            this._beanProperties = src._beanProperties;
            this._vanillaProcessing = src._vanillaProcessing;
            return;
        }
        ObjectIdValueProperty idProp = new ObjectIdValueProperty(oir, PropertyMetadata.STD_REQUIRED);
        BeanPropertyMap beanPropertyMap = src._beanProperties;
        beanPropertyMap.withProperty(idProp);
        this._beanProperties = beanPropertyMap;
        this._vanillaProcessing = false;
    }

    public BeanDeserializerBase(BeanDeserializerBase src, Set<String> ignorableProps) {
        super(src._beanType);
        this._beanType = src._beanType;
        this._valueInstantiator = src._valueInstantiator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._backRefs = src._backRefs;
        this._ignorableProps = ignorableProps;
        this._ignoreAllUnknown = src._ignoreAllUnknown;
        this._anySetter = src._anySetter;
        this._injectables = src._injectables;
        this._nonStandardCreation = src._nonStandardCreation;
        this._unwrappedPropertyHandler = src._unwrappedPropertyHandler;
        this._needViewProcesing = src._needViewProcesing;
        this._serializationShape = src._serializationShape;
        this._vanillaProcessing = src._vanillaProcessing;
        this._objectIdReader = src._objectIdReader;
        this._beanProperties = src._beanProperties.withoutProperties(ignorableProps);
    }

    protected BeanDeserializerBase(BeanDeserializerBase src, BeanPropertyMap beanProps) {
        super(src._beanType);
        this._beanType = src._beanType;
        this._valueInstantiator = src._valueInstantiator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._beanProperties = beanProps;
        this._backRefs = src._backRefs;
        this._ignorableProps = src._ignorableProps;
        this._ignoreAllUnknown = src._ignoreAllUnknown;
        this._anySetter = src._anySetter;
        this._injectables = src._injectables;
        this._objectIdReader = src._objectIdReader;
        this._nonStandardCreation = src._nonStandardCreation;
        this._unwrappedPropertyHandler = src._unwrappedPropertyHandler;
        this._needViewProcesing = src._needViewProcesing;
        this._serializationShape = src._serializationShape;
        this._vanillaProcessing = src._vanillaProcessing;
    }

    public BeanDeserializerBase withBeanProperties(BeanPropertyMap props) {
        StringBuilder sb = new StringBuilder();
        sb.append("Class ");
        sb.append(getClass().getName());
        sb.append(" does not override `withBeanProperties()`, needs to");
        throw new UnsupportedOperationException(sb.toString());
    }

    public void resolve(DeserializationContext ctxt) throws JsonMappingException {
        SettableBeanProperty[] creatorProps;
        Builder extTypes = null;
        if (this._valueInstantiator.canCreateFromObjectWith()) {
            creatorProps = this._valueInstantiator.getFromObjectArguments(ctxt.getConfig());
            if (this._ignorableProps != null) {
                int end = creatorProps.length;
                for (int i = 0; i < end; i++) {
                    if (this._ignorableProps.contains(creatorProps[i].getName())) {
                        creatorProps[i].markAsIgnorable();
                    }
                }
            }
        } else {
            creatorProps = null;
        }
        UnwrappedPropertyHandler unwrapped = null;
        Iterator i$ = this._beanProperties.iterator();
        while (i$.hasNext()) {
            SettableBeanProperty prop = (SettableBeanProperty) i$.next();
            if (!prop.hasValueDeserializer()) {
                JsonDeserializer<?> deser = findConvertingDeserializer(ctxt, prop);
                if (deser == null) {
                    deser = ctxt.findNonContextualValueDeserializer(prop.getType());
                }
                _replaceProperty(this._beanProperties, creatorProps, prop, prop.withValueDeserializer(deser));
            }
        }
        Iterator i$2 = this._beanProperties.iterator();
        while (i$2.hasNext()) {
            SettableBeanProperty origProp = (SettableBeanProperty) i$2.next();
            SettableBeanProperty prop2 = origProp;
            SettableBeanProperty prop3 = _resolveManagedReferenceProperty(ctxt, prop2.withValueDeserializer(ctxt.handlePrimaryContextualization(prop2.getValueDeserializer(), prop2, prop2.getType())));
            if (!(prop3 instanceof ManagedReferenceProperty)) {
                prop3 = _resolvedObjectIdProperty(ctxt, prop3);
            }
            NameTransformer xform = _findPropertyUnwrapper(ctxt, prop3);
            if (xform != null) {
                JsonDeserializer<Object> orig = prop3.getValueDeserializer();
                JsonDeserializer<Object> unwrapping = orig.unwrappingDeserializer(xform);
                if (!(unwrapping == orig || unwrapping == null)) {
                    SettableBeanProperty prop4 = prop3.withValueDeserializer(unwrapping);
                    if (unwrapped == null) {
                        unwrapped = new UnwrappedPropertyHandler();
                    }
                    unwrapped.addProperty(prop4);
                    this._beanProperties.remove(prop4);
                }
            }
            SettableBeanProperty prop5 = _resolveInnerClassValuedProperty(ctxt, _resolveMergeAndNullSettings(ctxt, prop3, prop3.getMetadata()));
            if (prop5 != origProp) {
                _replaceProperty(this._beanProperties, creatorProps, origProp, prop5);
            }
            if (prop5.hasValueTypeDeserializer()) {
                TypeDeserializer typeDeser = prop5.getValueTypeDeserializer();
                if (typeDeser.getTypeInclusion() == C0078As.EXTERNAL_PROPERTY) {
                    if (extTypes == null) {
                        extTypes = ExternalTypeHandler.builder(this._beanType);
                    }
                    extTypes.addExternal(prop5, typeDeser);
                    this._beanProperties.remove(prop5);
                }
            }
        }
        SettableAnyProperty settableAnyProperty = this._anySetter;
        if (settableAnyProperty != null && !settableAnyProperty.hasValueDeserializer()) {
            SettableAnyProperty settableAnyProperty2 = this._anySetter;
            this._anySetter = settableAnyProperty2.withValueDeserializer(findDeserializer(ctxt, settableAnyProperty2.getType(), this._anySetter.getProperty()));
        }
        boolean z = false;
        if (this._valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(ctxt.getConfig());
            if (delegateType != null) {
                this._delegateDeserializer = _findDelegateDeserializer(ctxt, delegateType, this._valueInstantiator.getDelegateCreator());
            } else {
                JavaType javaType = this._beanType;
                ctxt.reportBadDefinition(javaType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{javaType, this._valueInstantiator.getClass().getName()}));
                throw null;
            }
        }
        if (this._valueInstantiator.canCreateUsingArrayDelegate()) {
            JavaType delegateType2 = this._valueInstantiator.getArrayDelegateType(ctxt.getConfig());
            if (delegateType2 != null) {
                this._arrayDelegateDeserializer = _findDelegateDeserializer(ctxt, delegateType2, this._valueInstantiator.getArrayDelegateCreator());
            } else {
                JavaType javaType2 = this._beanType;
                ctxt.reportBadDefinition(javaType2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{javaType2, this._valueInstantiator.getClass().getName()}));
                throw null;
            }
        }
        if (creatorProps != null) {
            this._propertyBasedCreator = PropertyBasedCreator.construct(ctxt, this._valueInstantiator, creatorProps, this._beanProperties);
        }
        if (extTypes != null) {
            this._externalTypeIdHandler = extTypes.build(this._beanProperties);
            this._nonStandardCreation = true;
        }
        this._unwrappedPropertyHandler = unwrapped;
        if (unwrapped != null) {
            this._nonStandardCreation = true;
        }
        if (this._vanillaProcessing && !this._nonStandardCreation) {
            z = true;
        }
        this._vanillaProcessing = z;
    }

    /* access modifiers changed from: protected */
    public void _replaceProperty(BeanPropertyMap props, SettableBeanProperty[] creatorProps, SettableBeanProperty origProp, SettableBeanProperty newProp) {
        props.replace(origProp, newProp);
        if (creatorProps != null) {
            int len = creatorProps.length;
            for (int i = 0; i < len; i++) {
                if (creatorProps[i] == origProp) {
                    creatorProps[i] = newProp;
                    return;
                }
            }
        }
    }

    private JsonDeserializer<Object> _findDelegateDeserializer(DeserializationContext ctxt, JavaType delegateType, AnnotatedWithParams delegateCreator) throws JsonMappingException {
        Std property = new Std(TEMP_PROPERTY_NAME, delegateType, null, delegateCreator, PropertyMetadata.STD_OPTIONAL);
        TypeDeserializer td = (TypeDeserializer) delegateType.getTypeHandler();
        if (td == null) {
            td = ctxt.getConfig().findTypeDeserializer(delegateType);
        }
        JsonDeserializer<Object> dd = findDeserializer(ctxt, delegateType, property);
        if (td != null) {
            return new TypeWrappedDeserializer(td.forProperty(property), dd);
        }
        return dd;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> findConvertingDeserializer(DeserializationContext ctxt, SettableBeanProperty prop) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null) {
            Object convDef = intr.findDeserializationConverter(prop.getMember());
            if (convDef != null) {
                Converter<Object, Object> conv = ctxt.converterInstance(prop.getMember(), convDef);
                JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
                return new StdDelegatingDeserializer(conv, delegateType, ctxt.findNonContextualValueDeserializer(delegateType));
            }
        }
        return null;
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        SettableBeanProperty idProp;
        ObjectIdGenerator objectIdGenerator;
        JavaType type;
        DeserializationContext deserializationContext = ctxt;
        BeanProperty beanProperty = property;
        ObjectIdReader oir = this._objectIdReader;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        Annotated member = StdDeserializer._neitherNull(beanProperty, intr) ? property.getMember() : null;
        if (member != null) {
            ObjectIdInfo objectIdInfo = intr.findObjectIdInfo(member);
            if (objectIdInfo != null) {
                ObjectIdInfo objectIdInfo2 = intr.findObjectReferenceInfo(member, objectIdInfo);
                Class<?> implClass = objectIdInfo2.getGeneratorType();
                ObjectIdResolver resolver = deserializationContext.objectIdResolverInstance(member, objectIdInfo2);
                if (implClass == ObjectIdGenerators$PropertyGenerator.class) {
                    PropertyName propName = objectIdInfo2.getPropertyName();
                    SettableBeanProperty idProp2 = findProperty(propName);
                    if (idProp2 != null) {
                        type = idProp2.getType();
                        objectIdGenerator = new PropertyBasedObjectIdGenerator(objectIdInfo2.getScope());
                        idProp = idProp2;
                    } else {
                        deserializationContext.reportBadDefinition(this._beanType, String.format("Invalid Object Id definition for %s: cannot find property with name '%s'", new Object[]{handledType().getName(), propName}));
                        throw null;
                    }
                } else {
                    JavaType idType = ctxt.getTypeFactory().findTypeParameters(deserializationContext.constructType(implClass), ObjectIdGenerator.class)[0];
                    objectIdGenerator = deserializationContext.objectIdGeneratorInstance(member, objectIdInfo2);
                    type = idType;
                    idProp = null;
                }
                oir = ObjectIdReader.construct(type, objectIdInfo2.getPropertyName(), objectIdGenerator, deserializationContext.findRootValueDeserializer(type), idProp, resolver);
            }
        }
        BeanDeserializerBase contextual = this;
        if (!(oir == null || oir == this._objectIdReader)) {
            contextual = contextual.withObjectIdReader(oir);
        }
        if (member != null) {
            JsonIgnoreProperties.Value ignorals = intr.findPropertyIgnorals(member);
            if (ignorals != null) {
                Set findIgnoredForDeserialization = ignorals.findIgnoredForDeserialization();
                if (!findIgnoredForDeserialization.isEmpty()) {
                    Set<String> prev = contextual._ignorableProps;
                    if (prev != null && !prev.isEmpty()) {
                        findIgnoredForDeserialization = new HashSet(findIgnoredForDeserialization);
                        findIgnoredForDeserialization.addAll(prev);
                    }
                    contextual = contextual.withIgnorableProperties(findIgnoredForDeserialization);
                }
            }
        }
        Value format = findFormatOverrides(deserializationContext, beanProperty, handledType());
        Shape shape = null;
        if (format != null) {
            if (format.hasShape()) {
                shape = format.getShape();
            }
            Boolean B = format.getFeature(Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
            if (B != null) {
                BeanPropertyMap propsOrig = this._beanProperties;
                BeanPropertyMap props = propsOrig.withCaseInsensitivity(B.booleanValue());
                if (props != propsOrig) {
                    contextual = contextual.withBeanProperties(props);
                }
            }
        }
        if (shape == null) {
            shape = this._serializationShape;
        }
        if (shape == Shape.ARRAY) {
            return contextual.asArrayDeserializer();
        }
        return contextual;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty _resolveManagedReferenceProperty(DeserializationContext ctxt, SettableBeanProperty prop) throws JsonMappingException {
        String refName = prop.getManagedReferenceName();
        if (refName == null) {
            return prop;
        }
        SettableBeanProperty backProp = prop.getValueDeserializer().findBackReference(refName);
        if (backProp != null) {
            JavaType referredType = this._beanType;
            JavaType backRefType = backProp.getType();
            boolean isContainer = prop.getType().isContainerType();
            if (backRefType.getRawClass().isAssignableFrom(referredType.getRawClass())) {
                return new ManagedReferenceProperty(prop, refName, backProp, isContainer);
            }
            ctxt.reportBadDefinition(this._beanType, String.format("Cannot handle managed/back reference '%s': back reference type (%s) not compatible with managed type (%s)", new Object[]{refName, backRefType.getRawClass().getName(), referredType.getRawClass().getName()}));
            throw null;
        }
        ctxt.reportBadDefinition(this._beanType, String.format("Cannot handle managed/back reference '%s': no back reference property found from type %s", new Object[]{refName, prop.getType()}));
        throw null;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty _resolvedObjectIdProperty(DeserializationContext ctxt, SettableBeanProperty prop) throws JsonMappingException {
        ObjectIdInfo objectIdInfo = prop.getObjectIdInfo();
        JsonDeserializer<Object> valueDeser = prop.getValueDeserializer();
        ObjectIdReader objectIdReader = valueDeser == null ? null : valueDeser.getObjectIdReader();
        if (objectIdInfo == null && objectIdReader == null) {
            return prop;
        }
        return new ObjectIdReferenceProperty(prop, objectIdInfo);
    }

    /* access modifiers changed from: protected */
    public NameTransformer _findPropertyUnwrapper(DeserializationContext ctxt, SettableBeanProperty prop) throws JsonMappingException {
        AnnotatedMember am = prop.getMember();
        if (am != null) {
            NameTransformer unwrapper = ctxt.getAnnotationIntrospector().findUnwrappingNameTransformer(am);
            if (unwrapper != null) {
                if (!(prop instanceof CreatorProperty)) {
                    return unwrapper;
                }
                ctxt.reportBadDefinition(getValueType(), String.format("Cannot define Creator property \"%s\" as `@JsonUnwrapped`: combination not yet supported", new Object[]{prop.getName()}));
                throw null;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty _resolveInnerClassValuedProperty(DeserializationContext ctxt, SettableBeanProperty prop) {
        JsonDeserializer<Object> deser = prop.getValueDeserializer();
        if ((deser instanceof BeanDeserializerBase) && !((BeanDeserializerBase) deser).getValueInstantiator().canCreateUsingDefault()) {
            Class<?> valueClass = prop.getType().getRawClass();
            Class<?> enclosing = ClassUtil.getOuterClass(valueClass);
            if (enclosing != null && enclosing == this._beanType.getRawClass()) {
                Constructor<?>[] arr$ = valueClass.getConstructors();
                int len$ = arr$.length;
                int i$ = 0;
                while (i$ < len$) {
                    Constructor<?> ctor = arr$[i$];
                    Class<?>[] paramTypes = ctor.getParameterTypes();
                    if (paramTypes.length != 1 || !enclosing.equals(paramTypes[0])) {
                        i$++;
                    } else {
                        if (ctxt.canOverrideAccessModifiers()) {
                            ClassUtil.checkAndFixAccess(ctor, ctxt.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                        }
                        return new InnerClassProperty(prop, ctor);
                    }
                }
            }
        }
        return prop;
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty _resolveMergeAndNullSettings(DeserializationContext ctxt, SettableBeanProperty prop, PropertyMetadata propMetadata) throws JsonMappingException {
        MergeInfo merge = propMetadata.getMergeInfo();
        if (merge != null) {
            JsonDeserializer<?> valueDeser = prop.getValueDeserializer();
            Boolean mayMerge = valueDeser.supportsUpdate(ctxt.getConfig());
            if (mayMerge == null) {
                if (merge.fromDefaults) {
                    return prop;
                }
            } else if (!mayMerge.booleanValue()) {
                if (!merge.fromDefaults) {
                    ctxt.reportBadMerge(valueDeser);
                }
                return prop;
            }
            AnnotatedMember accessor = merge.getter;
            accessor.fixAccess(ctxt.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            if (!(prop instanceof SetterlessProperty)) {
                prop = MergingSettableBeanProperty.construct(prop, accessor);
            }
        }
        NullValueProvider nuller = findValueNullProvider(ctxt, prop, propMetadata);
        if (nuller != null) {
            prop = prop.withNullProvider(nuller);
        }
        return prop;
    }

    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        try {
            return this._valueInstantiator.createUsingDefault(ctxt);
        } catch (IOException e) {
            ClassUtil.throwAsMappingException(ctxt, e);
            throw null;
        }
    }

    public boolean isCachable() {
        return true;
    }

    public Boolean supportsUpdate(DeserializationConfig config) {
        return Boolean.TRUE;
    }

    public Class<?> handledType() {
        return this._beanType.getRawClass();
    }

    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    public Collection<Object> getKnownPropertyNames() {
        ArrayList<Object> names = new ArrayList<>();
        Iterator i$ = this._beanProperties.iterator();
        while (i$.hasNext()) {
            names.add(((SettableBeanProperty) i$.next()).getName());
        }
        return names;
    }

    public JavaType getValueType() {
        return this._beanType;
    }

    public SettableBeanProperty findProperty(PropertyName propertyName) {
        return findProperty(propertyName.getSimpleName());
    }

    public SettableBeanProperty findProperty(String propertyName) {
        BeanPropertyMap beanPropertyMap = this._beanProperties;
        SettableBeanProperty prop = beanPropertyMap == null ? null : beanPropertyMap.find(propertyName);
        if (StdDeserializer._neitherNull(prop, this._propertyBasedCreator)) {
            return this._propertyBasedCreator.findCreatorProperty(propertyName);
        }
        return prop;
    }

    public SettableBeanProperty findBackReference(String logicalName) {
        Map<String, SettableBeanProperty> map = this._backRefs;
        if (map == null) {
            return null;
        }
        return (SettableBeanProperty) map.get(logicalName);
    }

    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        if (this._objectIdReader != null) {
            if (p.canReadObjectId()) {
                Object id = p.getObjectId();
                if (id != null) {
                    return _handleTypedObjectId(p, ctxt, typeDeserializer.deserializeTypedFromObject(p, ctxt), id);
                }
            }
            JsonToken t = p.getCurrentToken();
            if (t != null) {
                if (t.isScalarValue()) {
                    return deserializeFromObjectId(p, ctxt);
                }
                if (t == JsonToken.START_OBJECT) {
                    t = p.nextToken();
                }
                if (t == JsonToken.FIELD_NAME && this._objectIdReader.maySerializeAsObject() && this._objectIdReader.isValidReferencePropertyName(p.getCurrentName(), p)) {
                    return deserializeFromObjectId(p, ctxt);
                }
            }
        }
        return typeDeserializer.deserializeTypedFromObject(p, ctxt);
    }

    /* access modifiers changed from: protected */
    public Object _handleTypedObjectId(JsonParser p, DeserializationContext ctxt, Object pojo, Object rawId) throws IOException {
        Object id;
        JsonDeserializer<Object> idDeser = this._objectIdReader.getDeserializer();
        if (idDeser.handledType() == rawId.getClass()) {
            id = rawId;
        } else {
            id = _convertObjectId(p, ctxt, rawId, idDeser);
        }
        ObjectIdReader objectIdReader = this._objectIdReader;
        ctxt.findObjectId(id, objectIdReader.generator, objectIdReader.resolver).bindItem(pojo);
        SettableBeanProperty idProp = this._objectIdReader.idProperty;
        if (idProp != null) {
            return idProp.setAndReturn(pojo, id);
        }
        return pojo;
    }

    /* access modifiers changed from: protected */
    public Object _convertObjectId(JsonParser p, DeserializationContext ctxt, Object rawId, JsonDeserializer<Object> idDeser) throws IOException {
        TokenBuffer buf = new TokenBuffer(p, ctxt);
        if (rawId instanceof String) {
            buf.writeString((String) rawId);
        } else if (rawId instanceof Long) {
            buf.writeNumber(((Long) rawId).longValue());
        } else if (rawId instanceof Integer) {
            buf.writeNumber(((Integer) rawId).intValue());
        } else {
            buf.writeObject(rawId);
        }
        JsonParser bufParser = buf.asParser();
        bufParser.nextToken();
        return idDeser.deserialize(bufParser, ctxt);
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithObjectId(JsonParser p, DeserializationContext ctxt) throws IOException {
        return deserializeFromObject(p, ctxt);
    }

    /* access modifiers changed from: protected */
    public Object deserializeFromObjectId(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object id = this._objectIdReader.readObjectReference(p, ctxt);
        ObjectIdReader objectIdReader = this._objectIdReader;
        ReadableObjectId roid = ctxt.findObjectId(id, objectIdReader.generator, objectIdReader.resolver);
        Object pojo = roid.resolve();
        if (pojo != null) {
            return pojo;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not resolve Object Id [");
        sb.append(id);
        sb.append("] (for ");
        sb.append(this._beanType);
        sb.append(").");
        throw new UnresolvedForwardReference(p, sb.toString(), p.getCurrentLocation(), roid);
    }

    /* access modifiers changed from: protected */
    public Object deserializeFromObjectUsingNonDefault(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonDeserializer<Object> delegateDeser = _delegateDeserializer();
        if (delegateDeser != null) {
            return this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
        }
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingPropertyBased(p, ctxt);
        }
        Class<?> raw = this._beanType.getRawClass();
        if (ClassUtil.isNonStaticInnerClass(raw)) {
            return ctxt.handleMissingInstantiator(raw, null, p, "can only instantiate non-static inner class by using default, no-argument constructor", new Object[0]);
        }
        return ctxt.handleMissingInstantiator(raw, getValueInstantiator(), p, "cannot deserialize from Object value (no delegate- or property-based Creator)", new Object[0]);
    }

    public Object deserializeFromNumber(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(p, ctxt);
        }
        JsonDeserializer<Object> delegateDeser = _delegateDeserializer();
        NumberType nt = p.getNumberType();
        if (nt == NumberType.INT) {
            if (delegateDeser == null || this._valueInstantiator.canCreateFromInt()) {
                return this._valueInstantiator.createFromInt(ctxt, p.getIntValue());
            }
            Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
            if (this._injectables != null) {
                injectValues(ctxt, bean);
            }
            return bean;
        } else if (nt == NumberType.LONG) {
            if (delegateDeser == null || this._valueInstantiator.canCreateFromInt()) {
                return this._valueInstantiator.createFromLong(ctxt, p.getLongValue());
            }
            Object bean2 = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
            if (this._injectables != null) {
                injectValues(ctxt, bean2);
            }
            return bean2;
        } else if (delegateDeser != null) {
            Object bean3 = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
            if (this._injectables != null) {
                injectValues(ctxt, bean3);
            }
            return bean3;
        } else {
            return ctxt.handleMissingInstantiator(handledType(), getValueInstantiator(), p, "no suitable creator method found to deserialize from Number value (%s)", p.getNumberValue());
        }
    }

    public Object deserializeFromString(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(p, ctxt);
        }
        JsonDeserializer<Object> delegateDeser = _delegateDeserializer();
        if (delegateDeser == null || this._valueInstantiator.canCreateFromString()) {
            return this._valueInstantiator.createFromString(ctxt, p.getText());
        }
        Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        return bean;
    }

    public Object deserializeFromDouble(JsonParser p, DeserializationContext ctxt) throws IOException {
        NumberType t = p.getNumberType();
        if (t == NumberType.DOUBLE || t == NumberType.FLOAT) {
            JsonDeserializer<Object> delegateDeser = _delegateDeserializer();
            if (delegateDeser == null || this._valueInstantiator.canCreateFromDouble()) {
                return this._valueInstantiator.createFromDouble(ctxt, p.getDoubleValue());
            }
            Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
            if (this._injectables != null) {
                injectValues(ctxt, bean);
            }
            return bean;
        }
        JsonDeserializer<Object> delegateDeser2 = _delegateDeserializer();
        if (delegateDeser2 != null) {
            return this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser2.deserialize(p, ctxt));
        }
        return ctxt.handleMissingInstantiator(handledType(), getValueInstantiator(), p, "no suitable creator method found to deserialize from Number value (%s)", p.getNumberValue());
    }

    public Object deserializeFromBoolean(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonDeserializer<Object> delegateDeser = _delegateDeserializer();
        if (delegateDeser == null || this._valueInstantiator.canCreateFromBoolean()) {
            return this._valueInstantiator.createFromBoolean(ctxt, p.getCurrentToken() == JsonToken.VALUE_TRUE);
        }
        Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        return bean;
    }

    public Object deserializeFromArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonDeserializer<Object> delegateDeser = this._arrayDelegateDeserializer;
        if (delegateDeser == null) {
            JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
            delegateDeser = jsonDeserializer;
            if (jsonDeserializer == null) {
                if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                    if (p.nextToken() == JsonToken.END_ARRAY && ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                        return null;
                    }
                    Object value = deserialize(p, ctxt);
                    if (p.nextToken() == JsonToken.END_ARRAY) {
                        return value;
                    }
                    handleMissingEndArrayForSingle(p, ctxt);
                    throw null;
                } else if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                    return ctxt.handleUnexpectedToken(handledType(), p);
                } else {
                    if (p.nextToken() == JsonToken.END_ARRAY) {
                        return null;
                    }
                    return ctxt.handleUnexpectedToken(handledType(), JsonToken.START_ARRAY, p, null, new Object[0]);
                }
            }
        }
        Object bean = this._valueInstantiator.createUsingArrayDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        return bean;
    }

    public Object deserializeFromEmbedded(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(p, ctxt);
        }
        JsonDeserializer<Object> delegateDeser = _delegateDeserializer();
        if (delegateDeser == null || this._valueInstantiator.canCreateFromString()) {
            Object value = p.getEmbeddedObject();
            if (value != null && !this._beanType.isTypeOrSuperTypeOf(value.getClass())) {
                value = ctxt.handleWeirdNativeValue(this._beanType, value, p);
            }
            return value;
        }
        Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        return bean;
    }

    private final JsonDeserializer<Object> _delegateDeserializer() {
        JsonDeserializer<Object> deser = this._delegateDeserializer;
        if (deser == null) {
            return this._arrayDelegateDeserializer;
        }
        return deser;
    }

    /* access modifiers changed from: protected */
    public void injectValues(DeserializationContext ctxt, Object bean) throws IOException {
        for (ValueInjector injector : this._injectables) {
            injector.inject(ctxt, bean);
        }
    }

    /* access modifiers changed from: protected */
    public Object handleUnknownProperties(DeserializationContext ctxt, Object bean, TokenBuffer unknownTokens) throws IOException {
        unknownTokens.writeEndObject();
        JsonParser bufferParser = unknownTokens.asParser();
        while (bufferParser.nextToken() != JsonToken.END_OBJECT) {
            String propName = bufferParser.getCurrentName();
            bufferParser.nextToken();
            handleUnknownProperty(bufferParser, ctxt, bean, propName);
        }
        return bean;
    }

    /* access modifiers changed from: protected */
    public void handleUnknownVanilla(JsonParser p, DeserializationContext ctxt, Object bean, String propName) throws IOException {
        Set<String> set = this._ignorableProps;
        if (set == null || !set.contains(propName)) {
            SettableAnyProperty settableAnyProperty = this._anySetter;
            if (settableAnyProperty != null) {
                try {
                    settableAnyProperty.deserializeAndSet(p, ctxt, bean, propName);
                } catch (Exception e) {
                    wrapAndThrow(e, bean, propName, ctxt);
                    throw null;
                }
            } else {
                handleUnknownProperty(p, ctxt, bean, propName);
            }
        } else {
            handleIgnoredProperty(p, ctxt, bean, propName);
        }
    }

    /* access modifiers changed from: protected */
    public void handleUnknownProperty(JsonParser p, DeserializationContext ctxt, Object beanOrClass, String propName) throws IOException {
        if (this._ignoreAllUnknown) {
            p.skipChildren();
            return;
        }
        Set<String> set = this._ignorableProps;
        if (set != null && set.contains(propName)) {
            handleIgnoredProperty(p, ctxt, beanOrClass, propName);
        }
        super.handleUnknownProperty(p, ctxt, beanOrClass, propName);
    }

    /* access modifiers changed from: protected */
    public void handleIgnoredProperty(JsonParser p, DeserializationContext ctxt, Object beanOrClass, String propName) throws IOException {
        if (!ctxt.isEnabled(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)) {
            p.skipChildren();
            return;
        }
        throw IgnoredPropertyException.from(p, beanOrClass, propName, getKnownPropertyNames());
    }

    /* access modifiers changed from: protected */
    public Object handlePolymorphic(JsonParser p, DeserializationContext ctxt, Object bean, TokenBuffer unknownTokens) throws IOException {
        JsonDeserializer<Object> subDeser = _findSubclassDeserializer(ctxt, bean, unknownTokens);
        if (subDeser != null) {
            if (unknownTokens != null) {
                unknownTokens.writeEndObject();
                JsonParser p2 = unknownTokens.asParser();
                p2.nextToken();
                bean = subDeser.deserialize(p2, ctxt, bean);
            }
            if (p != null) {
                bean = subDeser.deserialize(p, ctxt, bean);
            }
            return bean;
        }
        if (unknownTokens != null) {
            bean = handleUnknownProperties(ctxt, bean, unknownTokens);
        }
        if (p != null) {
            bean = deserialize(p, ctxt, bean);
        }
        return bean;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r0 == null) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        r0 = r6.findRootValueDeserializer(r6.constructType(r7.getClass()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r0 == null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r5._subDeserializers != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        r5._subDeserializers = new java.util.HashMap<>();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        r5._subDeserializers.put(new com.fasterxml.jackson.databind.type.ClassKey(r7.getClass()), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object> _findSubclassDeserializer(com.fasterxml.jackson.databind.DeserializationContext r6, java.lang.Object r7, com.fasterxml.jackson.databind.util.TokenBuffer r8) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            java.util.HashMap<com.fasterxml.jackson.databind.type.ClassKey, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r1 = r5._subDeserializers     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x0007
            goto L_0x0019
        L_0x0007:
            java.util.HashMap<com.fasterxml.jackson.databind.type.ClassKey, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r1 = r5._subDeserializers     // Catch:{ all -> 0x004b }
            com.fasterxml.jackson.databind.type.ClassKey r2 = new com.fasterxml.jackson.databind.type.ClassKey     // Catch:{ all -> 0x004b }
            java.lang.Class r3 = r7.getClass()     // Catch:{ all -> 0x004b }
            r2.<init>(r3)     // Catch:{ all -> 0x004b }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x004b }
            com.fasterxml.jackson.databind.JsonDeserializer r1 = (com.fasterxml.jackson.databind.JsonDeserializer) r1     // Catch:{ all -> 0x004b }
            r0 = r1
        L_0x0019:
            monitor-exit(r5)     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x001d
            return r0
        L_0x001d:
            java.lang.Class r1 = r7.getClass()
            com.fasterxml.jackson.databind.JavaType r1 = r6.constructType(r1)
            com.fasterxml.jackson.databind.JsonDeserializer r0 = r6.findRootValueDeserializer(r1)
            if (r0 == 0) goto L_0x004a
            monitor-enter(r5)
            java.util.HashMap<com.fasterxml.jackson.databind.type.ClassKey, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r2 = r5._subDeserializers     // Catch:{ all -> 0x0047 }
            if (r2 != 0) goto L_0x0037
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0047 }
            r2.<init>()     // Catch:{ all -> 0x0047 }
            r5._subDeserializers = r2     // Catch:{ all -> 0x0047 }
        L_0x0037:
            java.util.HashMap<com.fasterxml.jackson.databind.type.ClassKey, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r2 = r5._subDeserializers     // Catch:{ all -> 0x0047 }
            com.fasterxml.jackson.databind.type.ClassKey r3 = new com.fasterxml.jackson.databind.type.ClassKey     // Catch:{ all -> 0x0047 }
            java.lang.Class r4 = r7.getClass()     // Catch:{ all -> 0x0047 }
            r3.<init>(r4)     // Catch:{ all -> 0x0047 }
            r2.put(r3, r0)     // Catch:{ all -> 0x0047 }
            monitor-exit(r5)     // Catch:{ all -> 0x0047 }
            goto L_0x004a
        L_0x0047:
            r2 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0047 }
            throw r2
        L_0x004a:
            return r0
        L_0x004b:
            r1 = move-exception
        L_0x004c:
            monitor-exit(r5)     // Catch:{ all -> 0x004e }
            throw r1
        L_0x004e:
            r1 = move-exception
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BeanDeserializerBase._findSubclassDeserializer(com.fasterxml.jackson.databind.DeserializationContext, java.lang.Object, com.fasterxml.jackson.databind.util.TokenBuffer):com.fasterxml.jackson.databind.JsonDeserializer");
    }

    public void wrapAndThrow(Throwable t, Object bean, String fieldName, DeserializationContext ctxt) throws IOException {
        throw JsonMappingException.wrapWithPath(throwOrReturnThrowable(t, ctxt), bean, fieldName);
    }

    private Throwable throwOrReturnThrowable(Throwable t, DeserializationContext ctxt) throws IOException {
        while ((t instanceof InvocationTargetException) && t.getCause() != null) {
            t = t.getCause();
        }
        ClassUtil.throwIfError(t);
        boolean wrap = ctxt == null || ctxt.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS);
        if (t instanceof IOException) {
            if (!wrap || !(t instanceof JsonProcessingException)) {
                throw ((IOException) t);
            }
        } else if (!wrap) {
            ClassUtil.throwIfRTE(t);
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public Object wrapInstantiationProblem(Throwable t, DeserializationContext ctxt) throws IOException {
        while ((t instanceof InvocationTargetException) && t.getCause() != null) {
            t = t.getCause();
        }
        ClassUtil.throwIfError(t);
        if (!(t instanceof IOException)) {
            if (!(ctxt == null || ctxt.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS))) {
                ClassUtil.throwIfRTE(t);
            }
            return ctxt.handleInstantiationProblem(this._beanType.getRawClass(), null, t);
        }
        throw ((IOException) t);
    }
}
