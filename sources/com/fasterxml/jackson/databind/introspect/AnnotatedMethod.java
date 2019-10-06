package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class AnnotatedMethod extends AnnotatedWithParams implements Serializable {
    protected final transient Method _method;
    protected Class<?>[] _paramClasses;
    protected Serialization _serialization;

    private static final class Serialization implements Serializable {
        protected Class<?>[] args;
        protected Class<?> clazz;
        protected String name;

        public Serialization(Method setter) {
            this.clazz = setter.getDeclaringClass();
            this.name = setter.getName();
            this.args = setter.getParameterTypes();
        }
    }

    public AnnotatedMethod(TypeResolutionContext ctxt, Method method, AnnotationMap classAnn, AnnotationMap[] paramAnnotations) {
        super(ctxt, classAnn, paramAnnotations);
        if (method != null) {
            this._method = method;
            return;
        }
        throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
    }

    protected AnnotatedMethod(Serialization ser) {
        super(null, null, null);
        this._method = null;
        this._serialization = ser;
    }

    public AnnotatedMethod withAnnotations(AnnotationMap ann) {
        return new AnnotatedMethod(this._typeContext, this._method, ann, this._paramAnnotations);
    }

    public Method getAnnotated() {
        return this._method;
    }

    public String getName() {
        return this._method.getName();
    }

    public JavaType getType() {
        return this._typeContext.resolveType(this._method.getGenericReturnType());
    }

    public Class<?> getRawType() {
        return this._method.getReturnType();
    }

    public final Object call() throws Exception {
        return this._method.invoke(null, new Object[0]);
    }

    public final Object call(Object[] args) throws Exception {
        return this._method.invoke(null, args);
    }

    public final Object call1(Object arg) throws Exception {
        return this._method.invoke(null, new Object[]{arg});
    }

    public final Object callOnWith(Object pojo, Object... args) throws Exception {
        return this._method.invoke(pojo, args);
    }

    public int getParameterCount() {
        return getRawParameterTypes().length;
    }

    public Class<?> getRawParameterType(int index) {
        Class<?>[] types = getRawParameterTypes();
        if (index >= types.length) {
            return null;
        }
        return types[index];
    }

    public JavaType getParameterType(int index) {
        Type[] types = this._method.getGenericParameterTypes();
        if (index >= types.length) {
            return null;
        }
        return this._typeContext.resolveType(types[index]);
    }

    public Class<?> getDeclaringClass() {
        return this._method.getDeclaringClass();
    }

    public Method getMember() {
        return this._method;
    }

    public void setValue(Object pojo, Object value) throws IllegalArgumentException {
        try {
            this._method.invoke(pojo, new Object[]{value});
        } catch (IllegalAccessException | InvocationTargetException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to setValue() with method ");
            sb.append(getFullName());
            sb.append(": ");
            sb.append(e.getMessage());
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    public Object getValue(Object pojo) throws IllegalArgumentException {
        try {
            return this._method.invoke(pojo, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to getValue() with method ");
            sb.append(getFullName());
            sb.append(": ");
            sb.append(e.getMessage());
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    public String getFullName() {
        return String.format("%s(%d params)", new Object[]{super.getFullName(), Integer.valueOf(getParameterCount())});
    }

    public Class<?>[] getRawParameterTypes() {
        if (this._paramClasses == null) {
            this._paramClasses = this._method.getParameterTypes();
        }
        return this._paramClasses;
    }

    public Class<?> getRawReturnType() {
        return this._method.getReturnType();
    }

    public boolean hasReturnType() {
        Class<?> rt = getRawReturnType();
        return (rt == Void.TYPE || rt == Void.class) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[method ");
        sb.append(getFullName());
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        return this._method.getName().hashCode();
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!ClassUtil.hasClass(o, getClass()) || ((AnnotatedMethod) o)._method != this._method) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public Object writeReplace() {
        return new AnnotatedMethod(new Serialization(this._method));
    }

    /* access modifiers changed from: 0000 */
    public Object readResolve() {
        Serialization serialization = this._serialization;
        Class<?> clazz = serialization.clazz;
        try {
            Method m = clazz.getDeclaredMethod(serialization.name, serialization.args);
            if (!m.isAccessible()) {
                ClassUtil.checkAndFixAccess(m, false);
            }
            return new AnnotatedMethod(null, m, null, null);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find method '");
            sb.append(this._serialization.name);
            sb.append("' from Class '");
            sb.append(clazz.getName());
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
