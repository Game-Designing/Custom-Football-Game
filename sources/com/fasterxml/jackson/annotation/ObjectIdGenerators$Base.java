package com.fasterxml.jackson.annotation;

abstract class ObjectIdGenerators$Base<T> extends ObjectIdGenerator<T> {
    protected final Class<?> _scope;

    protected ObjectIdGenerators$Base(Class<?> scope) {
        this._scope = scope;
    }

    public Class<?> getScope() {
        return this._scope;
    }

    public boolean canUseFor(ObjectIdGenerator<?> gen) {
        return gen.getClass() == getClass() && gen.getScope() == this._scope;
    }
}
