package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class BuilderBasedDeserializer extends BeanDeserializerBase {
    protected final AnnotatedMethod _buildMethod;
    protected final JavaType _targetType;

    public BuilderBasedDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, JavaType targetType, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, Set<String> ignorableProps, boolean ignoreAllUnknown, boolean hasViews) {
        super(builder, beanDesc, properties, backRefs, ignorableProps, ignoreAllUnknown, hasViews);
        this._targetType = targetType;
        this._buildMethod = builder.getBuildMethod();
        if (this._objectIdReader != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot use Object Id with Builder-based deserialization (type ");
            sb.append(beanDesc.getType());
            sb.append(")");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    protected BuilderBasedDeserializer(BuilderBasedDeserializer src, NameTransformer unwrapper) {
        super((BeanDeserializerBase) src, unwrapper);
        this._buildMethod = src._buildMethod;
        this._targetType = src._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer src, ObjectIdReader oir) {
        super((BeanDeserializerBase) src, oir);
        this._buildMethod = src._buildMethod;
        this._targetType = src._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer src, Set<String> ignorableProps) {
        super((BeanDeserializerBase) src, ignorableProps);
        this._buildMethod = src._buildMethod;
        this._targetType = src._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer src, BeanPropertyMap props) {
        super((BeanDeserializerBase) src, props);
        this._buildMethod = src._buildMethod;
        this._targetType = src._targetType;
    }

    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer unwrapper) {
        return new BuilderBasedDeserializer(this, unwrapper);
    }

    public BeanDeserializerBase withObjectIdReader(ObjectIdReader oir) {
        return new BuilderBasedDeserializer(this, oir);
    }

    public BeanDeserializerBase withIgnorableProperties(Set<String> ignorableProps) {
        return new BuilderBasedDeserializer(this, ignorableProps);
    }

    public BeanDeserializerBase withBeanProperties(BeanPropertyMap props) {
        return new BuilderBasedDeserializer(this, props);
    }

    /* access modifiers changed from: protected */
    public BeanDeserializerBase asArrayDeserializer() {
        return new BeanAsArrayBuilderDeserializer(this, this._targetType, this._beanProperties.getPropertiesInInsertionOrder(), this._buildMethod);
    }

    public Boolean supportsUpdate(DeserializationConfig config) {
        return Boolean.FALSE;
    }

    /* access modifiers changed from: protected */
    public Object finishBuild(DeserializationContext ctxt, Object builder) throws IOException {
        AnnotatedMethod annotatedMethod = this._buildMethod;
        if (annotatedMethod == null) {
            return builder;
        }
        try {
            return annotatedMethod.getMember().invoke(builder, null);
        } catch (Exception e) {
            return wrapInstantiationProblem(e, ctxt);
        }
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.isExpectedStartObjectToken()) {
            JsonToken t = p.nextToken();
            if (this._vanillaProcessing) {
                return finishBuild(ctxt, vanillaDeserialize(p, ctxt, t));
            }
            return finishBuild(ctxt, deserializeFromObject(p, ctxt));
        }
        switch (p.getCurrentTokenId()) {
            case 2:
            case 5:
                return finishBuild(ctxt, deserializeFromObject(p, ctxt));
            case 3:
                return finishBuild(ctxt, deserializeFromArray(p, ctxt));
            case 6:
                return finishBuild(ctxt, deserializeFromString(p, ctxt));
            case 7:
                return finishBuild(ctxt, deserializeFromNumber(p, ctxt));
            case 8:
                return finishBuild(ctxt, deserializeFromDouble(p, ctxt));
            case 9:
            case 10:
                return finishBuild(ctxt, deserializeFromBoolean(p, ctxt));
            case 12:
                return p.getEmbeddedObject();
            default:
                return ctxt.handleUnexpectedToken(handledType(), p);
        }
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt, Object value) throws IOException {
        JavaType javaType = this._targetType;
        Class<?> builderRawType = handledType();
        Class<?> instRawType = value.getClass();
        if (builderRawType.isAssignableFrom(instRawType)) {
            ctxt.reportBadDefinition(javaType, String.format("Deserialization of %s by passing existing Builder (%s) instance not supported", new Object[]{javaType, builderRawType.getName()}));
            throw null;
        }
        ctxt.reportBadDefinition(javaType, String.format("Deserialization of %s by passing existing instance (of %s) not supported", new Object[]{javaType, instRawType.getName()}));
        throw null;
    }

    private final Object vanillaDeserialize(JsonParser p, DeserializationContext ctxt, JsonToken t) throws IOException {
        Object bean = this._valueInstantiator.createUsingDefault(ctxt);
        while (p.getCurrentToken() != JsonToken.END_OBJECT) {
            String propName = p.getCurrentName();
            p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop != null) {
                try {
                    bean = prop.deserializeSetAndReturn(p, ctxt, bean);
                } catch (Exception e) {
                    wrapAndThrow(e, bean, propName, ctxt);
                    throw null;
                }
            } else {
                handleUnknownVanilla(p, ctxt, bean, propName);
            }
            p.nextToken();
        }
        return bean;
    }

    public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (!this._nonStandardCreation) {
            Object bean = this._valueInstantiator.createUsingDefault(ctxt);
            if (this._injectables != null) {
                injectValues(ctxt, bean);
            }
            if (this._needViewProcesing) {
                Class<?> view = ctxt.getActiveView();
                if (view != null) {
                    return deserializeWithView(p, ctxt, bean, view);
                }
            }
            while (p.getCurrentToken() != JsonToken.END_OBJECT) {
                String propName = p.getCurrentName();
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    try {
                        bean = prop.deserializeSetAndReturn(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                        throw null;
                    }
                } else {
                    handleUnknownVanilla(p, ctxt, bean, propName);
                }
                p.nextToken();
            }
            return bean;
        } else if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(p, ctxt);
        } else {
            if (this._externalTypeIdHandler != null) {
                return deserializeWithExternalTypeId(p, ctxt);
            }
            return deserializeFromObjectUsingNonDefault(p, ctxt);
        }
    }

    /* access modifiers changed from: protected */
    public Object _deserializeUsingPropertyBased(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object builder;
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        Class activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        JsonToken t = p.getCurrentToken();
        TokenBuffer unknown = null;
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            p.nextToken();
            SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
            if (creatorProp != null) {
                if (activeView != null && !creatorProp.visibleInView(activeView)) {
                    p.skipChildren();
                } else if (buffer.assignParameter(creatorProp, creatorProp.deserialize(p, ctxt))) {
                    p.nextToken();
                    try {
                        Object builder2 = creator.build(ctxt, buffer);
                        if (builder2.getClass() != this._beanType.getRawClass()) {
                            return handlePolymorphic(p, ctxt, builder2, unknown);
                        }
                        if (unknown != null) {
                            builder2 = handleUnknownProperties(ctxt, builder2, unknown);
                        }
                        return _deserialize(p, ctxt, builder2);
                    } catch (Exception e) {
                        wrapAndThrow(e, this._beanType.getRawClass(), propName, ctxt);
                        throw null;
                    }
                }
            } else if (!buffer.readIdProperty(propName)) {
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    buffer.bufferProperty(prop, prop.deserialize(p, ctxt));
                } else {
                    Set<String> set = this._ignorableProps;
                    if (set == null || !set.contains(propName)) {
                        SettableAnyProperty settableAnyProperty = this._anySetter;
                        if (settableAnyProperty != null) {
                            buffer.bufferAnyProperty(settableAnyProperty, propName, settableAnyProperty.deserialize(p, ctxt));
                        } else {
                            if (unknown == null) {
                                unknown = new TokenBuffer(p, ctxt);
                            }
                            unknown.writeFieldName(propName);
                            unknown.copyCurrentStructure(p);
                        }
                    } else {
                        handleIgnoredProperty(p, ctxt, handledType(), propName);
                    }
                }
            }
            t = p.nextToken();
        }
        try {
            builder = creator.build(ctxt, buffer);
        } catch (Exception e2) {
            builder = wrapInstantiationProblem(e2, ctxt);
        }
        if (unknown == null) {
            return builder;
        }
        if (builder.getClass() != this._beanType.getRawClass()) {
            return handlePolymorphic(null, ctxt, builder, unknown);
        }
        handleUnknownProperties(ctxt, builder, unknown);
        return builder;
    }

    /* access modifiers changed from: protected */
    public final Object _deserialize(JsonParser p, DeserializationContext ctxt, Object builder) throws IOException {
        if (this._injectables != null) {
            injectValues(ctxt, builder);
        }
        if (this._unwrappedPropertyHandler != null) {
            if (p.hasToken(JsonToken.START_OBJECT)) {
                p.nextToken();
            }
            TokenBuffer tokens = new TokenBuffer(p, ctxt);
            tokens.writeStartObject();
            return deserializeWithUnwrapped(p, ctxt, builder, tokens);
        } else if (this._externalTypeIdHandler != null) {
            return deserializeWithExternalTypeId(p, ctxt, builder);
        } else {
            if (this._needViewProcesing) {
                Class<?> view = ctxt.getActiveView();
                if (view != null) {
                    return deserializeWithView(p, ctxt, builder, view);
                }
            }
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.START_OBJECT) {
                t = p.nextToken();
            }
            while (t == JsonToken.FIELD_NAME) {
                String propName = p.getCurrentName();
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    try {
                        builder = prop.deserializeSetAndReturn(p, ctxt, builder);
                    } catch (Exception e) {
                        wrapAndThrow(e, builder, propName, ctxt);
                        throw null;
                    }
                } else {
                    handleUnknownVanilla(p, ctxt, handledType(), propName);
                }
                t = p.nextToken();
            }
            return builder;
        }
    }

    /* access modifiers changed from: protected */
    public final Object deserializeWithView(JsonParser p, DeserializationContext ctxt, Object bean, Class<?> activeView) throws IOException {
        JsonToken t = p.getCurrentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop == null) {
                handleUnknownVanilla(p, ctxt, bean, propName);
            } else if (!prop.visibleInView(activeView)) {
                p.skipChildren();
            } else {
                try {
                    bean = prop.deserializeSetAndReturn(p, ctxt, bean);
                } catch (Exception e) {
                    wrapAndThrow(e, bean, propName, ctxt);
                    throw null;
                }
            }
            t = p.nextToken();
        }
        return bean;
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(ctxt, jsonDeserializer.deserialize(p, ctxt));
        }
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithUnwrapped(p, ctxt);
        }
        TokenBuffer tokens = new TokenBuffer(p, ctxt);
        tokens.writeStartObject();
        Object bean = this._valueInstantiator.createUsingDefault(ctxt);
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        Class activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        while (p.getCurrentToken() != JsonToken.END_OBJECT) {
            String propName = p.getCurrentName();
            p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop == null) {
                Set<String> set = this._ignorableProps;
                if (set == null || !set.contains(propName)) {
                    tokens.writeFieldName(propName);
                    tokens.copyCurrentStructure(p);
                    SettableAnyProperty settableAnyProperty = this._anySetter;
                    if (settableAnyProperty != null) {
                        try {
                            settableAnyProperty.deserializeAndSet(p, ctxt, bean, propName);
                        } catch (Exception e) {
                            wrapAndThrow(e, bean, propName, ctxt);
                            throw null;
                        }
                    }
                } else {
                    handleIgnoredProperty(p, ctxt, bean, propName);
                }
            } else if (activeView == null || prop.visibleInView(activeView)) {
                try {
                    bean = prop.deserializeSetAndReturn(p, ctxt, bean);
                } catch (Exception e2) {
                    wrapAndThrow(e2, bean, propName, ctxt);
                    throw null;
                }
            } else {
                p.skipChildren();
            }
            p.nextToken();
        }
        tokens.writeEndObject();
        this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
        return bean;
    }

    /* access modifiers changed from: protected */
    public Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        TokenBuffer tokens = new TokenBuffer(p, ctxt);
        tokens.writeStartObject();
        Object builder = null;
        JsonToken t = p.getCurrentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            p.nextToken();
            SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
            if (creatorProp != null) {
                if (buffer.assignParameter(creatorProp, creatorProp.deserialize(p, ctxt))) {
                    JsonToken t2 = p.nextToken();
                    try {
                        Object builder2 = creator.build(ctxt, buffer);
                        if (builder2.getClass() != this._beanType.getRawClass()) {
                            return handlePolymorphic(p, ctxt, builder2, tokens);
                        }
                        return deserializeWithUnwrapped(p, ctxt, builder2, tokens);
                    } catch (Exception e) {
                        wrapAndThrow(e, this._beanType.getRawClass(), propName, ctxt);
                        throw null;
                    }
                }
            } else if (!buffer.readIdProperty(propName)) {
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    buffer.bufferProperty(prop, prop.deserialize(p, ctxt));
                } else {
                    Set<String> set = this._ignorableProps;
                    if (set == null || !set.contains(propName)) {
                        tokens.writeFieldName(propName);
                        tokens.copyCurrentStructure(p);
                        SettableAnyProperty settableAnyProperty = this._anySetter;
                        if (settableAnyProperty != null) {
                            buffer.bufferAnyProperty(settableAnyProperty, propName, settableAnyProperty.deserialize(p, ctxt));
                        }
                    } else {
                        handleIgnoredProperty(p, ctxt, handledType(), propName);
                    }
                }
            }
            t = p.nextToken();
        }
        if (0 == 0) {
            try {
                builder = creator.build(ctxt, buffer);
            } catch (Exception e2) {
                return wrapInstantiationProblem(e2, ctxt);
            }
        }
        this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, builder, tokens);
        return builder;
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithUnwrapped(JsonParser p, DeserializationContext ctxt, Object builder, TokenBuffer tokens) throws IOException {
        Class activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        JsonToken t = p.getCurrentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            p.nextToken();
            if (prop == null) {
                Set<String> set = this._ignorableProps;
                if (set == null || !set.contains(propName)) {
                    tokens.writeFieldName(propName);
                    tokens.copyCurrentStructure(p);
                    SettableAnyProperty settableAnyProperty = this._anySetter;
                    if (settableAnyProperty != null) {
                        settableAnyProperty.deserializeAndSet(p, ctxt, builder, propName);
                    }
                } else {
                    handleIgnoredProperty(p, ctxt, builder, propName);
                }
            } else if (activeView == null || prop.visibleInView(activeView)) {
                try {
                    builder = prop.deserializeSetAndReturn(p, ctxt, builder);
                } catch (Exception e) {
                    wrapAndThrow(e, builder, propName, ctxt);
                    throw null;
                }
            } else {
                p.skipChildren();
            }
            t = p.nextToken();
        }
        tokens.writeEndObject();
        this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, builder, tokens);
        return builder;
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithExternalTypeId(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._propertyBasedCreator == null) {
            return deserializeWithExternalTypeId(p, ctxt, this._valueInstantiator.createUsingDefault(ctxt));
        }
        deserializeUsingPropertyBasedWithExternalTypeId(p, ctxt);
        throw null;
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithExternalTypeId(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        Class activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        ExternalTypeHandler ext = this._externalTypeIdHandler.start();
        JsonToken t = p.getCurrentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            JsonToken t2 = p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop != null) {
                if (t2.isScalarValue()) {
                    ext.handleTypePropertyValue(p, ctxt, propName, bean);
                }
                if (activeView == null || prop.visibleInView(activeView)) {
                    try {
                        bean = prop.deserializeSetAndReturn(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                        throw null;
                    }
                } else {
                    p.skipChildren();
                }
            } else {
                Set<String> set = this._ignorableProps;
                if (set != null && set.contains(propName)) {
                    handleIgnoredProperty(p, ctxt, bean, propName);
                } else if (!ext.handlePropertyValue(p, ctxt, propName, bean)) {
                    SettableAnyProperty settableAnyProperty = this._anySetter;
                    if (settableAnyProperty != null) {
                        try {
                            settableAnyProperty.deserializeAndSet(p, ctxt, bean, propName);
                        } catch (Exception e2) {
                            wrapAndThrow(e2, bean, propName, ctxt);
                            throw null;
                        }
                    } else {
                        handleUnknownProperty(p, ctxt, bean, propName);
                    }
                }
            }
            t = p.nextToken();
        }
        ext.complete(p, ctxt, bean);
        return bean;
    }

    /* access modifiers changed from: protected */
    public Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser p, DeserializationContext ctxt) throws IOException {
        JavaType t = this._targetType;
        ctxt.reportBadDefinition(t, String.format("Deserialization (of %s) with Builder, External type id, @JsonCreator not yet implemented", new Object[]{t}));
        throw null;
    }
}
