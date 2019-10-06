package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.lang.reflect.Constructor;

public final class InnerClassProperty extends Delegating {
    protected AnnotatedConstructor _annotated;
    protected final transient Constructor<?> _creator;

    public InnerClassProperty(SettableBeanProperty delegate, Constructor<?> ctor) {
        super(delegate);
        this._creator = ctor;
    }

    protected InnerClassProperty(SettableBeanProperty src, AnnotatedConstructor ann) {
        super(src);
        this._annotated = ann;
        AnnotatedConstructor annotatedConstructor = this._annotated;
        this._creator = annotatedConstructor == null ? null : annotatedConstructor.getAnnotated();
        if (this._creator == null) {
            throw new IllegalArgumentException("Missing constructor (broken JDK (de)serialization?)");
        }
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty withDelegate(SettableBeanProperty d) {
        if (d == this.delegate) {
            return this;
        }
        return new InnerClassProperty(d, this._creator);
    }

    public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        Object value;
        if (p.getCurrentToken() == JsonToken.VALUE_NULL) {
            value = this._valueDeserializer.getNullValue(ctxt);
        } else {
            TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
            if (typeDeserializer != null) {
                value = this._valueDeserializer.deserializeWithType(p, ctxt, typeDeserializer);
            } else {
                try {
                    value = this._creator.newInstance(new Object[]{bean});
                    this._valueDeserializer.deserialize(p, ctxt, value);
                } catch (Exception e) {
                    ClassUtil.unwrapAndThrowAsIAE(e, String.format("Failed to instantiate class %s, problem: %s", new Object[]{this._creator.getDeclaringClass().getName(), e.getMessage()}));
                    throw null;
                }
            }
        }
        set(bean, value);
    }

    public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
        return setAndReturn(instance, deserialize(p, ctxt));
    }

    /* access modifiers changed from: 0000 */
    public Object readResolve() {
        return new InnerClassProperty((SettableBeanProperty) this, this._annotated);
    }

    /* access modifiers changed from: 0000 */
    public Object writeReplace() {
        if (this._annotated == null) {
            return new InnerClassProperty((SettableBeanProperty) this, new AnnotatedConstructor(null, this._creator, null, null));
        }
        return this;
    }
}
