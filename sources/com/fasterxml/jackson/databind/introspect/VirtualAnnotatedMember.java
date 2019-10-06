package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

public class VirtualAnnotatedMember extends AnnotatedMember implements Serializable {
    protected final Class<?> _declaringClass;
    protected final String _name;
    protected final JavaType _type;

    public VirtualAnnotatedMember(TypeResolutionContext typeContext, Class<?> declaringClass, String name, JavaType type) {
        super(typeContext, null);
        this._declaringClass = declaringClass;
        this._type = type;
        this._name = name;
    }

    public Annotated withAnnotations(AnnotationMap fallback) {
        return this;
    }

    public Field getAnnotated() {
        return null;
    }

    public String getName() {
        return this._name;
    }

    public Class<?> getRawType() {
        return this._type.getRawClass();
    }

    public JavaType getType() {
        return this._type;
    }

    public Class<?> getDeclaringClass() {
        return this._declaringClass;
    }

    public Member getMember() {
        return null;
    }

    public void setValue(Object pojo, Object value) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot set virtual property '");
        sb.append(this._name);
        sb.append("'");
        throw new IllegalArgumentException(sb.toString());
    }

    public Object getValue(Object pojo) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot get virtual property '");
        sb.append(this._name);
        sb.append("'");
        throw new IllegalArgumentException(sb.toString());
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!ClassUtil.hasClass(o, getClass())) {
            return false;
        }
        VirtualAnnotatedMember other = (VirtualAnnotatedMember) o;
        if (other._declaringClass != this._declaringClass || !other._name.equals(this._name)) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[virtual ");
        sb.append(getFullName());
        sb.append("]");
        return sb.toString();
    }
}
