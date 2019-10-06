package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class SettableAnyProperty implements Serializable {
    protected final KeyDeserializer _keyDeserializer;
    protected final BeanProperty _property;
    protected final AnnotatedMember _setter;
    final boolean _setterIsField;
    protected final JavaType _type;
    protected JsonDeserializer<Object> _valueDeserializer;
    protected final TypeDeserializer _valueTypeDeserializer;

    private static class AnySetterReferring extends Referring {
        private final SettableAnyProperty _parent;
        private final Object _pojo;
        private final String _propName;

        public AnySetterReferring(SettableAnyProperty parent, UnresolvedForwardReference reference, Class<?> type, Object instance, String propName) {
            super(reference, type);
            this._parent = parent;
            this._pojo = instance;
            this._propName = propName;
        }

        public void handleResolvedForwardReference(Object id, Object value) throws IOException {
            if (hasId(id)) {
                this._parent.set(this._pojo, this._propName, value);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to resolve a forward reference with id [");
            sb.append(id.toString());
            sb.append("] that wasn't previously registered.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public SettableAnyProperty(BeanProperty property, AnnotatedMember setter, JavaType type, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer typeDeser) {
        this._property = property;
        this._setter = setter;
        this._type = type;
        this._valueDeserializer = valueDeser;
        this._valueTypeDeserializer = typeDeser;
        this._keyDeserializer = keyDeser;
        this._setterIsField = setter instanceof AnnotatedField;
    }

    public SettableAnyProperty withValueDeserializer(JsonDeserializer<Object> deser) {
        SettableAnyProperty settableAnyProperty = new SettableAnyProperty(this._property, this._setter, this._type, this._keyDeserializer, deser, this._valueTypeDeserializer);
        return settableAnyProperty;
    }

    public void fixAccess(DeserializationConfig config) {
        this._setter.fixAccess(config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    /* access modifiers changed from: 0000 */
    public Object readResolve() {
        AnnotatedMember annotatedMember = this._setter;
        if (annotatedMember != null && annotatedMember.getAnnotated() != null) {
            return this;
        }
        throw new IllegalArgumentException("Missing method (broken JDK (de)serialization?)");
    }

    public BeanProperty getProperty() {
        return this._property;
    }

    public boolean hasValueDeserializer() {
        return this._valueDeserializer != null;
    }

    public JavaType getType() {
        return this._type;
    }

    public final void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance, String propName) throws IOException {
        try {
            set(instance, this._keyDeserializer == null ? propName : this._keyDeserializer.deserializeKey(propName, ctxt), deserialize(p, ctxt));
        } catch (UnresolvedForwardReference reference) {
            if (this._valueDeserializer.getObjectIdReader() != null) {
                AnySetterReferring referring = new AnySetterReferring(this, reference, this._type.getRawClass(), instance, propName);
                reference.getRoid().appendReferring(referring);
                return;
            }
            throw JsonMappingException.from(p, "Unresolved forward reference but no identity info.", (Throwable) reference);
        }
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.getCurrentToken() == JsonToken.VALUE_NULL) {
            return this._valueDeserializer.getNullValue(ctxt);
        }
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (typeDeserializer != null) {
            return this._valueDeserializer.deserializeWithType(p, ctxt, typeDeserializer);
        }
        return this._valueDeserializer.deserialize(p, ctxt);
    }

    public void set(Object instance, Object propName, Object value) throws IOException {
        try {
            if (this._setterIsField) {
                Map<Object, Object> val = (Map) ((AnnotatedField) this._setter).getValue(instance);
                if (val != null) {
                    val.put(propName, value);
                }
                return;
            }
            ((AnnotatedMethod) this._setter).callOnWith(instance, propName, value);
        } catch (Exception e) {
            _throwAsIOE(e, propName, value);
        }
    }

    /* access modifiers changed from: protected */
    public void _throwAsIOE(Exception e, Object propName, Object value) throws IOException {
        if (e instanceof IllegalArgumentException) {
            String actType = ClassUtil.classNameOf(value);
            StringBuilder msg = new StringBuilder("Problem deserializing \"any\" property '").append(propName);
            StringBuilder sb = new StringBuilder();
            sb.append("' of class ");
            sb.append(getClassName());
            sb.append(" (expected type: ");
            msg.append(sb.toString());
            msg.append(this._type);
            msg.append("; actual type: ");
            msg.append(actType);
            msg.append(")");
            String origMsg = e.getMessage();
            if (origMsg != null) {
                msg.append(", problem: ");
                msg.append(origMsg);
            } else {
                msg.append(" (no error message provided)");
            }
            throw new JsonMappingException((Closeable) null, msg.toString(), (Throwable) e);
        }
        ClassUtil.throwIfIOE(e);
        ClassUtil.throwIfRTE(e);
        Throwable t = ClassUtil.getRootCause(e);
        throw new JsonMappingException((Closeable) null, t.getMessage(), t);
    }

    private String getClassName() {
        return this._setter.getDeclaringClass().getName();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[any property on class ");
        sb.append(getClassName());
        sb.append("]");
        return sb.toString();
    }
}
