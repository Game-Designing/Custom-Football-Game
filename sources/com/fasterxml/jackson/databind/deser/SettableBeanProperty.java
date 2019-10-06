package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.FailingDeserializer;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.ViewMatcher;
import java.io.IOException;
import java.io.Serializable;

public abstract class SettableBeanProperty extends ConcreteBeanPropertyBase implements Serializable {
    protected static final JsonDeserializer<Object> MISSING_VALUE_DESERIALIZER = new FailingDeserializer("No _valueDeserializer assigned");
    protected final transient Annotations _contextAnnotations;
    protected String _managedReferenceName;
    protected final NullValueProvider _nullProvider;
    protected ObjectIdInfo _objectIdInfo;
    protected final PropertyName _propName;
    protected int _propertyIndex;
    protected final JavaType _type;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final TypeDeserializer _valueTypeDeserializer;
    protected ViewMatcher _viewMatcher;
    protected final PropertyName _wrapperName;

    public static abstract class Delegating extends SettableBeanProperty {
        protected final SettableBeanProperty delegate;

        /* access modifiers changed from: protected */
        public abstract SettableBeanProperty withDelegate(SettableBeanProperty settableBeanProperty);

        protected Delegating(SettableBeanProperty d) {
            super(d);
            this.delegate = d;
        }

        /* access modifiers changed from: protected */
        public SettableBeanProperty _with(SettableBeanProperty newDelegate) {
            if (newDelegate == this.delegate) {
                return this;
            }
            return withDelegate(newDelegate);
        }

        public SettableBeanProperty withValueDeserializer(JsonDeserializer<?> deser) {
            return _with(this.delegate.withValueDeserializer(deser));
        }

        public SettableBeanProperty withName(PropertyName newName) {
            return _with(this.delegate.withName(newName));
        }

        public SettableBeanProperty withNullProvider(NullValueProvider nva) {
            return _with(this.delegate.withNullProvider(nva));
        }

        public void assignIndex(int index) {
            this.delegate.assignIndex(index);
        }

        public void fixAccess(DeserializationConfig config) {
            this.delegate.fixAccess(config);
        }

        /* access modifiers changed from: protected */
        public Class<?> getDeclaringClass() {
            return this.delegate.getDeclaringClass();
        }

        public String getManagedReferenceName() {
            return this.delegate.getManagedReferenceName();
        }

        public ObjectIdInfo getObjectIdInfo() {
            return this.delegate.getObjectIdInfo();
        }

        public boolean hasValueDeserializer() {
            return this.delegate.hasValueDeserializer();
        }

        public boolean hasValueTypeDeserializer() {
            return this.delegate.hasValueTypeDeserializer();
        }

        public JsonDeserializer<Object> getValueDeserializer() {
            return this.delegate.getValueDeserializer();
        }

        public TypeDeserializer getValueTypeDeserializer() {
            return this.delegate.getValueTypeDeserializer();
        }

        public boolean visibleInView(Class<?> activeView) {
            return this.delegate.visibleInView(activeView);
        }

        public boolean hasViews() {
            return this.delegate.hasViews();
        }

        public int getCreatorIndex() {
            return this.delegate.getCreatorIndex();
        }

        public Object getInjectableValueId() {
            return this.delegate.getInjectableValueId();
        }

        public AnnotatedMember getMember() {
            return this.delegate.getMember();
        }

        public void set(Object instance, Object value) throws IOException {
            this.delegate.set(instance, value);
        }

        public Object setAndReturn(Object instance, Object value) throws IOException {
            return this.delegate.setAndReturn(instance, value);
        }
    }

    public abstract void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException;

    public abstract Object deserializeSetAndReturn(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException;

    public abstract AnnotatedMember getMember();

    public abstract void set(Object obj, Object obj2) throws IOException;

    public abstract Object setAndReturn(Object obj, Object obj2) throws IOException;

    public abstract SettableBeanProperty withName(PropertyName propertyName);

    public abstract SettableBeanProperty withNullProvider(NullValueProvider nullValueProvider);

    public abstract SettableBeanProperty withValueDeserializer(JsonDeserializer<?> jsonDeserializer);

    protected SettableBeanProperty(BeanPropertyDefinition propDef, JavaType type, TypeDeserializer typeDeser, Annotations contextAnnotations) {
        this(propDef.getFullName(), type, propDef.getWrapperName(), typeDeser, contextAnnotations, propDef.getMetadata());
    }

    protected SettableBeanProperty(PropertyName propName, JavaType type, PropertyName wrapper, TypeDeserializer typeDeser, Annotations contextAnnotations, PropertyMetadata metadata) {
        super(metadata);
        this._propertyIndex = -1;
        if (propName == null) {
            this._propName = PropertyName.NO_NAME;
        } else {
            this._propName = propName.internSimpleName();
        }
        this._type = type;
        this._wrapperName = wrapper;
        this._contextAnnotations = contextAnnotations;
        this._viewMatcher = null;
        if (typeDeser != null) {
            typeDeser = typeDeser.forProperty(this);
        }
        this._valueTypeDeserializer = typeDeser;
        JsonDeserializer<Object> jsonDeserializer = MISSING_VALUE_DESERIALIZER;
        this._valueDeserializer = jsonDeserializer;
        this._nullProvider = jsonDeserializer;
    }

    protected SettableBeanProperty(PropertyName propName, JavaType type, PropertyMetadata metadata, JsonDeserializer<Object> valueDeser) {
        super(metadata);
        this._propertyIndex = -1;
        if (propName == null) {
            this._propName = PropertyName.NO_NAME;
        } else {
            this._propName = propName.internSimpleName();
        }
        this._type = type;
        this._wrapperName = null;
        this._contextAnnotations = null;
        this._viewMatcher = null;
        this._valueTypeDeserializer = null;
        this._valueDeserializer = valueDeser;
        this._nullProvider = valueDeser;
    }

    protected SettableBeanProperty(SettableBeanProperty src) {
        super((ConcreteBeanPropertyBase) src);
        this._propertyIndex = -1;
        this._propName = src._propName;
        this._type = src._type;
        this._wrapperName = src._wrapperName;
        this._contextAnnotations = src._contextAnnotations;
        this._valueDeserializer = src._valueDeserializer;
        this._valueTypeDeserializer = src._valueTypeDeserializer;
        this._managedReferenceName = src._managedReferenceName;
        this._propertyIndex = src._propertyIndex;
        this._viewMatcher = src._viewMatcher;
        this._nullProvider = src._nullProvider;
    }

    protected SettableBeanProperty(SettableBeanProperty src, JsonDeserializer<?> deser, NullValueProvider nuller) {
        super((ConcreteBeanPropertyBase) src);
        this._propertyIndex = -1;
        this._propName = src._propName;
        this._type = src._type;
        this._wrapperName = src._wrapperName;
        this._contextAnnotations = src._contextAnnotations;
        this._valueTypeDeserializer = src._valueTypeDeserializer;
        this._managedReferenceName = src._managedReferenceName;
        this._propertyIndex = src._propertyIndex;
        if (deser == null) {
            this._valueDeserializer = MISSING_VALUE_DESERIALIZER;
        } else {
            this._valueDeserializer = deser;
        }
        this._viewMatcher = src._viewMatcher;
        if (nuller == MISSING_VALUE_DESERIALIZER) {
            nuller = this._valueDeserializer;
        }
        this._nullProvider = nuller;
    }

    protected SettableBeanProperty(SettableBeanProperty src, PropertyName newName) {
        super((ConcreteBeanPropertyBase) src);
        this._propertyIndex = -1;
        this._propName = newName;
        this._type = src._type;
        this._wrapperName = src._wrapperName;
        this._contextAnnotations = src._contextAnnotations;
        this._valueDeserializer = src._valueDeserializer;
        this._valueTypeDeserializer = src._valueTypeDeserializer;
        this._managedReferenceName = src._managedReferenceName;
        this._propertyIndex = src._propertyIndex;
        this._viewMatcher = src._viewMatcher;
        this._nullProvider = src._nullProvider;
    }

    public SettableBeanProperty withSimpleName(String simpleName) {
        PropertyName propertyName = this._propName;
        PropertyName n = propertyName == null ? new PropertyName(simpleName) : propertyName.withSimpleName(simpleName);
        return n == this._propName ? this : withName(n);
    }

    public void setManagedReferenceName(String n) {
        this._managedReferenceName = n;
    }

    public void setObjectIdInfo(ObjectIdInfo objectIdInfo) {
        this._objectIdInfo = objectIdInfo;
    }

    public void setViews(Class<?>[] views) {
        if (views == null) {
            this._viewMatcher = null;
        } else {
            this._viewMatcher = ViewMatcher.construct(views);
        }
    }

    public void assignIndex(int index) {
        if (this._propertyIndex == -1) {
            this._propertyIndex = index;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Property '");
        sb.append(getName());
        sb.append("' already had index (");
        sb.append(this._propertyIndex);
        sb.append("), trying to assign ");
        sb.append(index);
        throw new IllegalStateException(sb.toString());
    }

    public void fixAccess(DeserializationConfig config) {
    }

    public void markAsIgnorable() {
    }

    public boolean isIgnorable() {
        return false;
    }

    public final String getName() {
        return this._propName.getSimpleName();
    }

    public PropertyName getFullName() {
        return this._propName;
    }

    public JavaType getType() {
        return this._type;
    }

    /* access modifiers changed from: protected */
    public Class<?> getDeclaringClass() {
        return getMember().getDeclaringClass();
    }

    public String getManagedReferenceName() {
        return this._managedReferenceName;
    }

    public ObjectIdInfo getObjectIdInfo() {
        return this._objectIdInfo;
    }

    public boolean hasValueDeserializer() {
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        return (jsonDeserializer == null || jsonDeserializer == MISSING_VALUE_DESERIALIZER) ? false : true;
    }

    public boolean hasValueTypeDeserializer() {
        return this._valueTypeDeserializer != null;
    }

    public JsonDeserializer<Object> getValueDeserializer() {
        JsonDeserializer<Object> deser = this._valueDeserializer;
        if (deser == MISSING_VALUE_DESERIALIZER) {
            return null;
        }
        return deser;
    }

    public TypeDeserializer getValueTypeDeserializer() {
        return this._valueTypeDeserializer;
    }

    public boolean visibleInView(Class<?> activeView) {
        ViewMatcher viewMatcher = this._viewMatcher;
        return viewMatcher == null || viewMatcher.isVisibleForView(activeView);
    }

    public boolean hasViews() {
        return this._viewMatcher != null;
    }

    public int getCreatorIndex() {
        throw new IllegalStateException(String.format("Internal error: no creator index for property '%s' (of type %s)", new Object[]{getName(), getClass().getName()}));
    }

    public Object getInjectableValueId() {
        return null;
    }

    public final Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_NULL)) {
            return this._nullProvider.getNullValue(ctxt);
        }
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (typeDeserializer != null) {
            return this._valueDeserializer.deserializeWithType(p, ctxt, typeDeserializer);
        }
        return this._valueDeserializer.deserialize(p, ctxt);
    }

    public final Object deserializeWith(JsonParser p, DeserializationContext ctxt, Object toUpdate) throws IOException {
        if (p.hasToken(JsonToken.VALUE_NULL)) {
            if (NullsConstantProvider.isSkipper(this._nullProvider)) {
                return toUpdate;
            }
            return this._nullProvider.getNullValue(ctxt);
        } else if (this._valueTypeDeserializer == null) {
            return this._valueDeserializer.deserialize(p, ctxt, toUpdate);
        } else {
            ctxt.reportBadDefinition(getType(), String.format("Cannot merge polymorphic property '%s'", new Object[]{getName()}));
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void _throwAsIOE(JsonParser p, Exception e, Object value) throws IOException {
        if (e instanceof IllegalArgumentException) {
            String actType = ClassUtil.classNameOf(value);
            StringBuilder sb = new StringBuilder("Problem deserializing property '");
            sb.append(getName());
            sb.append("' (expected type: ");
            sb.append(getType());
            sb.append("; actual type: ");
            sb.append(actType);
            StringBuilder msg = sb.append(")");
            String origMsg = e.getMessage();
            if (origMsg != null) {
                msg.append(", problem: ");
                msg.append(origMsg);
            } else {
                msg.append(" (no error message provided)");
            }
            throw JsonMappingException.from(p, msg.toString(), (Throwable) e);
        }
        _throwAsIOE(p, e);
    }

    /* access modifiers changed from: protected */
    public IOException _throwAsIOE(JsonParser p, Exception e) throws IOException {
        ClassUtil.throwIfIOE(e);
        ClassUtil.throwIfRTE(e);
        Throwable th = ClassUtil.getRootCause(e);
        throw JsonMappingException.from(p, th.getMessage(), th);
    }

    /* access modifiers changed from: protected */
    public void _throwAsIOE(Exception e, Object value) throws IOException {
        _throwAsIOE(null, e, value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[property '");
        sb.append(getName());
        sb.append("']");
        return sb.toString();
    }
}
