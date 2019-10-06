package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanDeserializer extends BeanDeserializerBase implements Serializable {
    private volatile transient NameTransformer _currentlyTransforming;
    protected transient Exception _nullFromCreator;

    /* renamed from: com.fasterxml.jackson.databind.deser.BeanDeserializer$1 */
    static /* synthetic */ class C68191 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken = new int[JsonToken.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NULL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_OBJECT.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    static class BeanReferring extends Referring {
        private Object _bean;
        private final DeserializationContext _context;
        private final SettableBeanProperty _prop;

        BeanReferring(DeserializationContext ctxt, UnresolvedForwardReference ref, JavaType valueType, PropertyValueBuffer buffer, SettableBeanProperty prop) {
            super(ref, valueType);
            this._context = ctxt;
            this._prop = prop;
        }

        public void setBean(Object bean) {
            this._bean = bean;
        }

        public void handleResolvedForwardReference(Object id, Object value) throws IOException {
            Object obj = this._bean;
            if (obj != null) {
                this._prop.set(obj, value);
                return;
            }
            DeserializationContext deserializationContext = this._context;
            SettableBeanProperty settableBeanProperty = this._prop;
            deserializationContext.reportInputMismatch((BeanProperty) settableBeanProperty, "Cannot resolve ObjectId forward reference using property '%s' (of type %s): Bean not yet resolved", settableBeanProperty.getName(), this._prop.getDeclaringClass().getName());
            throw null;
        }
    }

    public BeanDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, HashSet<String> ignorableProps, boolean ignoreAllUnknown, boolean hasViews) {
        super(builder, beanDesc, properties, backRefs, ignorableProps, ignoreAllUnknown, hasViews);
    }

    protected BeanDeserializer(BeanDeserializerBase src) {
        super(src, src._ignoreAllUnknown);
    }

    protected BeanDeserializer(BeanDeserializerBase src, NameTransformer unwrapper) {
        super(src, unwrapper);
    }

    public BeanDeserializer(BeanDeserializerBase src, ObjectIdReader oir) {
        super(src, oir);
    }

    public BeanDeserializer(BeanDeserializerBase src, Set<String> ignorableProps) {
        super(src, ignorableProps);
    }

    public BeanDeserializer(BeanDeserializerBase src, BeanPropertyMap props) {
        super(src, props);
    }

    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer transformer) {
        if (getClass() != BeanDeserializer.class || this._currentlyTransforming == transformer) {
            return this;
        }
        this._currentlyTransforming = transformer;
        try {
            return new BeanDeserializer((BeanDeserializerBase) this, transformer);
        } finally {
            this._currentlyTransforming = null;
        }
    }

    public BeanDeserializer withObjectIdReader(ObjectIdReader oir) {
        return new BeanDeserializer((BeanDeserializerBase) this, oir);
    }

    public BeanDeserializer withIgnorableProperties(Set<String> ignorableProps) {
        return new BeanDeserializer((BeanDeserializerBase) this, ignorableProps);
    }

    public BeanDeserializerBase withBeanProperties(BeanPropertyMap props) {
        return new BeanDeserializer((BeanDeserializerBase) this, props);
    }

    /* access modifiers changed from: protected */
    public BeanDeserializerBase asArrayDeserializer() {
        return new BeanAsArrayDeserializer(this, this._beanProperties.getPropertiesInInsertionOrder());
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (!p.isExpectedStartObjectToken()) {
            return _deserializeOther(p, ctxt, p.getCurrentToken());
        }
        if (this._vanillaProcessing) {
            return vanillaDeserialize(p, ctxt, p.nextToken());
        }
        p.nextToken();
        if (this._objectIdReader != null) {
            return deserializeWithObjectId(p, ctxt);
        }
        return deserializeFromObject(p, ctxt);
    }

    /* access modifiers changed from: protected */
    public final Object _deserializeOther(JsonParser p, DeserializationContext ctxt, JsonToken t) throws IOException {
        if (t != null) {
            switch (C68191.$SwitchMap$com$fasterxml$jackson$core$JsonToken[t.ordinal()]) {
                case 1:
                    return deserializeFromString(p, ctxt);
                case 2:
                    return deserializeFromNumber(p, ctxt);
                case 3:
                    return deserializeFromDouble(p, ctxt);
                case 4:
                    return deserializeFromEmbedded(p, ctxt);
                case 5:
                case 6:
                    return deserializeFromBoolean(p, ctxt);
                case 7:
                    return deserializeFromNull(p, ctxt);
                case 8:
                    return deserializeFromArray(p, ctxt);
                case 9:
                case 10:
                    if (this._vanillaProcessing) {
                        return vanillaDeserialize(p, ctxt, t);
                    }
                    if (this._objectIdReader != null) {
                        return deserializeWithObjectId(p, ctxt);
                    }
                    return deserializeFromObject(p, ctxt);
            }
        }
        return ctxt.handleUnexpectedToken(handledType(), p);
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        String propName;
        String nextFieldName;
        p.setCurrentValue(bean);
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        if (this._unwrappedPropertyHandler != null) {
            deserializeWithUnwrapped(p, ctxt, bean);
            return bean;
        } else if (this._externalTypeIdHandler != null) {
            deserializeWithExternalTypeId(p, ctxt, bean);
            return bean;
        } else {
            if (p.isExpectedStartObjectToken()) {
                propName = p.nextFieldName();
                if (propName == null) {
                    return bean;
                }
            } else if (!p.hasTokenId(5)) {
                return bean;
            } else {
                propName = p.getCurrentName();
            }
            if (this._needViewProcesing) {
                Class<?> view = ctxt.getActiveView();
                if (view != null) {
                    deserializeWithView(p, ctxt, bean, view);
                    return bean;
                }
            }
            do {
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                        throw null;
                    }
                } else {
                    handleUnknownVanilla(p, ctxt, bean, propName);
                }
                nextFieldName = p.nextFieldName();
                propName = nextFieldName;
            } while (nextFieldName != null);
            return bean;
        }
    }

    private final Object vanillaDeserialize(JsonParser p, DeserializationContext ctxt, JsonToken t) throws IOException {
        String nextFieldName;
        Object bean = this._valueInstantiator.createUsingDefault(ctxt);
        p.setCurrentValue(bean);
        if (p.hasTokenId(5)) {
            String propName = p.getCurrentName();
            do {
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                        throw null;
                    }
                } else {
                    handleUnknownVanilla(p, ctxt, bean, propName);
                }
                nextFieldName = p.nextFieldName();
                propName = nextFieldName;
            } while (nextFieldName != null);
        }
        return bean;
    }

    public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt) throws IOException {
        String nextFieldName;
        ObjectIdReader objectIdReader = this._objectIdReader;
        if (objectIdReader != null && objectIdReader.maySerializeAsObject() && p.hasTokenId(5) && this._objectIdReader.isValidReferencePropertyName(p.getCurrentName(), p)) {
            return deserializeFromObjectId(p, ctxt);
        }
        if (!this._nonStandardCreation) {
            Object bean = this._valueInstantiator.createUsingDefault(ctxt);
            p.setCurrentValue(bean);
            if (p.canReadObjectId()) {
                Object id = p.getObjectId();
                if (id != null) {
                    _handleTypedObjectId(p, ctxt, bean, id);
                }
            }
            if (this._injectables != null) {
                injectValues(ctxt, bean);
            }
            if (this._needViewProcesing) {
                Class<?> view = ctxt.getActiveView();
                if (view != null) {
                    deserializeWithView(p, ctxt, bean, view);
                    return bean;
                }
            }
            if (p.hasTokenId(5)) {
                String propName = p.getCurrentName();
                do {
                    p.nextToken();
                    SettableBeanProperty prop = this._beanProperties.find(propName);
                    if (prop != null) {
                        try {
                            prop.deserializeAndSet(p, ctxt, bean);
                        } catch (Exception e) {
                            wrapAndThrow(e, bean, propName, ctxt);
                            throw null;
                        }
                    } else {
                        handleUnknownVanilla(p, ctxt, bean, propName);
                    }
                    nextFieldName = p.nextFieldName();
                    propName = nextFieldName;
                } while (nextFieldName != null);
            }
            return bean;
        } else if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(p, ctxt);
        } else {
            if (this._externalTypeIdHandler != null) {
                return deserializeWithExternalTypeId(p, ctxt);
            }
            Object bean2 = deserializeFromObjectUsingNonDefault(p, ctxt);
            if (this._injectables != null) {
                injectValues(ctxt, bean2);
            }
            return bean2;
        }
    }

    /* access modifiers changed from: protected */
    public Object _deserializeUsingPropertyBased(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object bean;
        Object bean2;
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        Class activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        JsonToken t = p.getCurrentToken();
        List<BeanReferring> referrings = null;
        TokenBuffer unknown = null;
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            p.nextToken();
            if (!buffer.readIdProperty(propName)) {
                SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
                if (creatorProp == null) {
                    SettableBeanProperty prop = this._beanProperties.find(propName);
                    if (prop != null) {
                        try {
                            buffer.bufferProperty(prop, _deserializeWithErrorWrapping(p, ctxt, prop));
                        } catch (UnresolvedForwardReference reference) {
                            BeanReferring referring = handleUnresolvedReference(ctxt, prop, buffer, reference);
                            if (referrings == null) {
                                referrings = new ArrayList<>();
                            }
                            referrings.add(referring);
                        }
                    } else {
                        Set<String> set = this._ignorableProps;
                        if (set == null || !set.contains(propName)) {
                            SettableAnyProperty settableAnyProperty = this._anySetter;
                            if (settableAnyProperty != null) {
                                try {
                                    buffer.bufferAnyProperty(settableAnyProperty, propName, settableAnyProperty.deserialize(p, ctxt));
                                } catch (Exception e) {
                                    wrapAndThrow(e, this._beanType.getRawClass(), propName, ctxt);
                                    throw null;
                                }
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
                } else if (activeView != null && !creatorProp.visibleInView(activeView)) {
                    p.skipChildren();
                } else if (buffer.assignParameter(creatorProp, _deserializeWithErrorWrapping(p, ctxt, creatorProp))) {
                    p.nextToken();
                    try {
                        bean2 = creator.build(ctxt, buffer);
                    } catch (Exception e2) {
                        bean2 = wrapInstantiationProblem(e2, ctxt);
                    }
                    if (bean2 == null) {
                        return ctxt.handleInstantiationProblem(handledType(), null, _creatorReturnedNullException());
                    }
                    p.setCurrentValue(bean2);
                    if (bean2.getClass() != this._beanType.getRawClass()) {
                        return handlePolymorphic(p, ctxt, bean2, unknown);
                    }
                    if (unknown != null) {
                        bean2 = handleUnknownProperties(ctxt, bean2, unknown);
                    }
                    deserialize(p, ctxt, bean2);
                    return bean2;
                }
            }
            t = p.nextToken();
        }
        try {
            bean = creator.build(ctxt, buffer);
        } catch (Exception e3) {
            wrapInstantiationProblem(e3, ctxt);
            bean = null;
        }
        if (referrings != null) {
            for (BeanReferring referring2 : referrings) {
                referring2.setBean(bean);
            }
        }
        if (unknown == null) {
            return bean;
        }
        if (bean.getClass() != this._beanType.getRawClass()) {
            return handlePolymorphic(null, ctxt, bean, unknown);
        }
        handleUnknownProperties(ctxt, bean, unknown);
        return bean;
    }

    private BeanReferring handleUnresolvedReference(DeserializationContext ctxt, SettableBeanProperty prop, PropertyValueBuffer buffer, UnresolvedForwardReference reference) throws JsonMappingException {
        BeanReferring referring = new BeanReferring(ctxt, reference, prop.getType(), buffer, prop);
        reference.getRoid().appendReferring(referring);
        return referring;
    }

    /* access modifiers changed from: protected */
    public final Object _deserializeWithErrorWrapping(JsonParser p, DeserializationContext ctxt, SettableBeanProperty prop) throws IOException {
        try {
            return prop.deserialize(p, ctxt);
        } catch (Exception e) {
            wrapAndThrow(e, this._beanType.getRawClass(), prop.getName(), ctxt);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public Object deserializeFromNull(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (!p.requiresCustomCodec()) {
            return ctxt.handleUnexpectedToken(handledType(), p);
        }
        TokenBuffer tb = new TokenBuffer(p, ctxt);
        tb.writeEndObject();
        JsonParser p2 = tb.asParser(p);
        p2.nextToken();
        Object ob = this._vanillaProcessing ? vanillaDeserialize(p2, ctxt, JsonToken.END_OBJECT) : deserializeFromObject(p2, ctxt);
        p2.close();
        return ob;
    }

    /* access modifiers changed from: protected */
    public final Object deserializeWithView(JsonParser p, DeserializationContext ctxt, Object bean, Class<?> activeView) throws IOException {
        String nextFieldName;
        if (p.hasTokenId(5)) {
            String propName = p.getCurrentName();
            do {
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop == null) {
                    handleUnknownVanilla(p, ctxt, bean, propName);
                } else if (!prop.visibleInView(activeView)) {
                    p.skipChildren();
                } else {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                        throw null;
                    }
                }
                nextFieldName = p.nextFieldName();
                propName = nextFieldName;
            } while (nextFieldName != null);
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
        p.setCurrentValue(bean);
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        Class activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        String propName = p.hasTokenId(5) ? p.getCurrentName() : null;
        while (propName != null) {
            p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop == null) {
                Set<String> set = this._ignorableProps;
                if (set != null && set.contains(propName)) {
                    handleIgnoredProperty(p, ctxt, bean, propName);
                } else if (this._anySetter == null) {
                    tokens.writeFieldName(propName);
                    tokens.copyCurrentStructure(p);
                } else {
                    TokenBuffer b2 = TokenBuffer.asCopyOfValue(p);
                    tokens.writeFieldName(propName);
                    tokens.append(b2);
                    try {
                        this._anySetter.deserializeAndSet(b2.asParserOnFirstToken(), ctxt, bean, propName);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                        throw null;
                    }
                }
            } else if (activeView == null || prop.visibleInView(activeView)) {
                try {
                    prop.deserializeAndSet(p, ctxt, bean);
                } catch (Exception e2) {
                    wrapAndThrow(e2, bean, propName, ctxt);
                    throw null;
                }
            } else {
                p.skipChildren();
            }
            propName = p.nextFieldName();
        }
        tokens.writeEndObject();
        this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
        return bean;
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithUnwrapped(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.START_OBJECT) {
            t = p.nextToken();
        }
        TokenBuffer tokens = new TokenBuffer(p, ctxt);
        tokens.writeStartObject();
        Class activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            p.nextToken();
            if (prop == null) {
                Set<String> set = this._ignorableProps;
                if (set != null && set.contains(propName)) {
                    handleIgnoredProperty(p, ctxt, bean, propName);
                } else if (this._anySetter == null) {
                    tokens.writeFieldName(propName);
                    tokens.copyCurrentStructure(p);
                } else {
                    TokenBuffer b2 = TokenBuffer.asCopyOfValue(p);
                    tokens.writeFieldName(propName);
                    tokens.append(b2);
                    try {
                        this._anySetter.deserializeAndSet(b2.asParserOnFirstToken(), ctxt, bean, propName);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                        throw null;
                    }
                }
            } else if (activeView == null || prop.visibleInView(activeView)) {
                try {
                    prop.deserializeAndSet(p, ctxt, bean);
                } catch (Exception e2) {
                    wrapAndThrow(e2, bean, propName, ctxt);
                    throw null;
                }
            } else {
                p.skipChildren();
            }
            t = p.nextToken();
        }
        tokens.writeEndObject();
        this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
        return bean;
    }

    /* access modifiers changed from: protected */
    public Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object bean;
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        TokenBuffer tokens = new TokenBuffer(p, ctxt);
        tokens.writeStartObject();
        JsonToken t = p.getCurrentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            p.nextToken();
            SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
            if (creatorProp != null) {
                if (buffer.assignParameter(creatorProp, _deserializeWithErrorWrapping(p, ctxt, creatorProp))) {
                    JsonToken t2 = p.nextToken();
                    try {
                        bean = creator.build(ctxt, buffer);
                    } catch (Exception e) {
                        bean = wrapInstantiationProblem(e, ctxt);
                    }
                    p.setCurrentValue(bean);
                    while (t2 == JsonToken.FIELD_NAME) {
                        p.nextToken();
                        tokens.copyCurrentStructure(p);
                        t2 = p.nextToken();
                    }
                    tokens.writeEndObject();
                    if (bean.getClass() == this._beanType.getRawClass()) {
                        this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
                        return bean;
                    }
                    ctxt.reportInputMismatch((BeanProperty) creatorProp, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
                    throw null;
                }
            } else if (!buffer.readIdProperty(propName)) {
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    buffer.bufferProperty(prop, _deserializeWithErrorWrapping(p, ctxt, prop));
                } else {
                    Set<String> set = this._ignorableProps;
                    if (set != null && set.contains(propName)) {
                        handleIgnoredProperty(p, ctxt, handledType(), propName);
                    } else if (this._anySetter == null) {
                        tokens.writeFieldName(propName);
                        tokens.copyCurrentStructure(p);
                    } else {
                        TokenBuffer b2 = TokenBuffer.asCopyOfValue(p);
                        tokens.writeFieldName(propName);
                        tokens.append(b2);
                        try {
                            buffer.bufferAnyProperty(this._anySetter, propName, this._anySetter.deserialize(b2.asParserOnFirstToken(), ctxt));
                        } catch (Exception e2) {
                            wrapAndThrow(e2, this._beanType.getRawClass(), propName, ctxt);
                            throw null;
                        }
                    }
                }
            }
            t = p.nextToken();
        }
        try {
            Object bean2 = creator.build(ctxt, buffer);
            this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean2, tokens);
            return bean2;
        } catch (Exception e3) {
            wrapInstantiationProblem(e3, ctxt);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithExternalTypeId(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithExternalTypeId(p, ctxt);
        }
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(ctxt, jsonDeserializer.deserialize(p, ctxt));
        }
        Object createUsingDefault = this._valueInstantiator.createUsingDefault(ctxt);
        deserializeWithExternalTypeId(p, ctxt, createUsingDefault);
        return createUsingDefault;
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
                        prop.deserializeAndSet(p, ctxt, bean);
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
        ExternalTypeHandler ext = this._externalTypeIdHandler.start();
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        TokenBuffer tokens = new TokenBuffer(p, ctxt);
        tokens.writeStartObject();
        JsonToken t = p.getCurrentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            p.nextToken();
            SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
            if (creatorProp != null) {
                if (!ext.handlePropertyValue(p, ctxt, propName, null) && buffer.assignParameter(creatorProp, _deserializeWithErrorWrapping(p, ctxt, creatorProp))) {
                    JsonToken t2 = p.nextToken();
                    try {
                        Object bean = creator.build(ctxt, buffer);
                        while (t2 == JsonToken.FIELD_NAME) {
                            p.nextToken();
                            tokens.copyCurrentStructure(p);
                            t2 = p.nextToken();
                        }
                        if (bean.getClass() == this._beanType.getRawClass()) {
                            ext.complete(p, ctxt, bean);
                            return bean;
                        }
                        JavaType javaType = this._beanType;
                        ctxt.reportBadDefinition(javaType, String.format("Cannot create polymorphic instances with external type ids (%s -> %s)", new Object[]{javaType, bean.getClass()}));
                        throw null;
                    } catch (Exception e) {
                        wrapAndThrow(e, this._beanType.getRawClass(), propName, ctxt);
                        throw null;
                    }
                }
            } else if (!buffer.readIdProperty(propName)) {
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    buffer.bufferProperty(prop, prop.deserialize(p, ctxt));
                } else if (!ext.handlePropertyValue(p, ctxt, propName, null)) {
                    Set<String> set = this._ignorableProps;
                    if (set == null || !set.contains(propName)) {
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
        try {
            return ext.complete(p, ctxt, buffer, creator);
        } catch (Exception e2) {
            return wrapInstantiationProblem(e2, ctxt);
        }
    }

    /* access modifiers changed from: protected */
    public Exception _creatorReturnedNullException() {
        if (this._nullFromCreator == null) {
            this._nullFromCreator = new NullPointerException("JSON Creator returned null");
        }
        return this._nullFromCreator;
    }
}
