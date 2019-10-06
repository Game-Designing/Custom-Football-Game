package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

public class PlaceholderForType extends TypeBase {
    protected JavaType _actualType;
    protected final int _ordinal;

    public PlaceholderForType(int ordinal) {
        super(Object.class, TypeBindings.emptyBindings(), TypeFactory.unknownType(), null, 1, null, null, false);
        this._ordinal = ordinal;
    }

    public JavaType actualType() {
        return this._actualType;
    }

    public void actualType(JavaType t) {
        this._actualType = t;
    }

    /* access modifiers changed from: protected */
    public String buildCanonicalName() {
        return toString();
    }

    public StringBuilder getGenericSignature(StringBuilder sb) {
        getErasedSignature(sb);
        return sb;
    }

    public StringBuilder getErasedSignature(StringBuilder sb) {
        sb.append('$');
        sb.append(this._ordinal + 1);
        return sb;
    }

    public JavaType withTypeHandler(Object h) {
        _unsupported();
        throw null;
    }

    public JavaType withContentTypeHandler(Object h) {
        _unsupported();
        throw null;
    }

    public JavaType withValueHandler(Object h) {
        _unsupported();
        throw null;
    }

    public JavaType withContentValueHandler(Object h) {
        _unsupported();
        throw null;
    }

    public JavaType withContentType(JavaType contentType) {
        _unsupported();
        throw null;
    }

    public JavaType withStaticTyping() {
        _unsupported();
        throw null;
    }

    public JavaType refine(Class<?> cls, TypeBindings bindings, JavaType superClass, JavaType[] superInterfaces) {
        _unsupported();
        throw null;
    }

    public boolean isContainerType() {
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        getErasedSignature(sb);
        return sb.toString();
    }

    public boolean equals(Object o) {
        return o == this;
    }

    private <T> T _unsupported() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operation should not be attempted on ");
        sb.append(getClass().getName());
        throw new UnsupportedOperationException(sb.toString());
    }
}
