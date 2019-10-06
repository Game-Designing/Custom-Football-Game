package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;

public abstract class AnnotatedWithParams extends AnnotatedMember {
    protected final AnnotationMap[] _paramAnnotations;

    public abstract Object call() throws Exception;

    public abstract Object call(Object[] objArr) throws Exception;

    public abstract Object call1(Object obj) throws Exception;

    public abstract int getParameterCount();

    public abstract JavaType getParameterType(int i);

    public abstract Class<?> getRawParameterType(int i);

    protected AnnotatedWithParams(TypeResolutionContext ctxt, AnnotationMap annotations, AnnotationMap[] paramAnnotations) {
        super(ctxt, annotations);
        this._paramAnnotations = paramAnnotations;
    }

    protected AnnotatedWithParams(AnnotatedWithParams base, AnnotationMap[] paramAnnotations) {
        super(base);
        this._paramAnnotations = paramAnnotations;
    }

    /* access modifiers changed from: protected */
    public AnnotatedParameter replaceParameterAnnotations(int index, AnnotationMap ann) {
        this._paramAnnotations[index] = ann;
        return getParameter(index);
    }

    public final AnnotationMap getParameterAnnotations(int index) {
        AnnotationMap[] annotationMapArr = this._paramAnnotations;
        if (annotationMapArr == null || index < 0 || index >= annotationMapArr.length) {
            return null;
        }
        return annotationMapArr[index];
    }

    public final AnnotatedParameter getParameter(int index) {
        AnnotatedParameter annotatedParameter = new AnnotatedParameter(this, getParameterType(index), this._typeContext, getParameterAnnotations(index), index);
        return annotatedParameter;
    }
}
