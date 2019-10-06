package com.fasterxml.jackson.core.type;

public abstract class ResolvedType {
    public abstract ResolvedType getReferencedType();

    public abstract String toCanonical();

    public boolean isReferenceType() {
        return getReferencedType() != null;
    }
}
