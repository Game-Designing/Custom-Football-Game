package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

public abstract class AnnotatedMember extends Annotated implements Serializable {
    protected final transient AnnotationMap _annotations;
    protected final transient TypeResolutionContext _typeContext;

    public abstract Class<?> getDeclaringClass();

    public abstract Member getMember();

    public abstract Object getValue(Object obj) throws UnsupportedOperationException, IllegalArgumentException;

    public abstract void setValue(Object obj, Object obj2) throws UnsupportedOperationException, IllegalArgumentException;

    public abstract Annotated withAnnotations(AnnotationMap annotationMap);

    protected AnnotatedMember(TypeResolutionContext ctxt, AnnotationMap annotations) {
        this._typeContext = ctxt;
        this._annotations = annotations;
    }

    protected AnnotatedMember(AnnotatedMember base) {
        this._typeContext = base._typeContext;
        this._annotations = base._annotations;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDeclaringClass().getName());
        sb.append("#");
        sb.append(getName());
        return sb.toString();
    }

    public final <A extends Annotation> A getAnnotation(Class<A> acls) {
        AnnotationMap annotationMap = this._annotations;
        if (annotationMap == null) {
            return null;
        }
        return annotationMap.get(acls);
    }

    public final boolean hasAnnotation(Class<?> acls) {
        AnnotationMap annotationMap = this._annotations;
        if (annotationMap == null) {
            return false;
        }
        return annotationMap.has(acls);
    }

    public boolean hasOneOf(Class<? extends Annotation>[] annoClasses) {
        AnnotationMap annotationMap = this._annotations;
        if (annotationMap == null) {
            return false;
        }
        return annotationMap.hasOneOf(annoClasses);
    }

    public AnnotationMap getAllAnnotations() {
        return this._annotations;
    }

    public final void fixAccess(boolean force) {
        Member m = getMember();
        if (m != null) {
            ClassUtil.checkAndFixAccess(m, force);
        }
    }
}
