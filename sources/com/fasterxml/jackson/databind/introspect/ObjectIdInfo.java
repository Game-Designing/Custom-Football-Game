package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.util.ClassUtil;

public class ObjectIdInfo {
    private static final ObjectIdInfo EMPTY;
    protected final boolean _alwaysAsId;
    protected final Class<? extends ObjectIdGenerator<?>> _generator;
    protected final PropertyName _propertyName;
    protected final Class<? extends ObjectIdResolver> _resolver;
    protected final Class<?> _scope;

    static {
        ObjectIdInfo objectIdInfo = new ObjectIdInfo(PropertyName.NO_NAME, Object.class, null, false, null);
        EMPTY = objectIdInfo;
    }

    public ObjectIdInfo(PropertyName name, Class<?> scope, Class<? extends ObjectIdGenerator<?>> gen, Class<? extends ObjectIdResolver> resolver) {
        this(name, scope, gen, false, resolver);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<? extends com.fasterxml.jackson.annotation.ObjectIdResolver>, code=java.lang.Class, for r5v0, types: [java.lang.Class<? extends com.fasterxml.jackson.annotation.ObjectIdResolver>, java.lang.Class] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected ObjectIdInfo(com.fasterxml.jackson.databind.PropertyName r1, java.lang.Class<?> r2, java.lang.Class<? extends com.fasterxml.jackson.annotation.ObjectIdGenerator<?>> r3, boolean r4, java.lang.Class r5) {
        /*
            r0 = this;
            r0.<init>()
            r0._propertyName = r1
            r0._scope = r2
            r0._generator = r3
            r0._alwaysAsId = r4
            if (r5 != 0) goto L_0x000f
            java.lang.Class<com.fasterxml.jackson.annotation.SimpleObjectIdResolver> r5 = com.fasterxml.jackson.annotation.SimpleObjectIdResolver.class
        L_0x000f:
            r0._resolver = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.ObjectIdInfo.<init>(com.fasterxml.jackson.databind.PropertyName, java.lang.Class, java.lang.Class, boolean, java.lang.Class):void");
    }

    public static ObjectIdInfo empty() {
        return EMPTY;
    }

    public ObjectIdInfo withAlwaysAsId(boolean state) {
        if (this._alwaysAsId == state) {
            return this;
        }
        ObjectIdInfo objectIdInfo = new ObjectIdInfo(this._propertyName, this._scope, this._generator, state, this._resolver);
        return objectIdInfo;
    }

    public PropertyName getPropertyName() {
        return this._propertyName;
    }

    public Class<?> getScope() {
        return this._scope;
    }

    public Class<? extends ObjectIdGenerator<?>> getGeneratorType() {
        return this._generator;
    }

    public Class<? extends ObjectIdResolver> getResolverType() {
        return this._resolver;
    }

    public boolean getAlwaysAsId() {
        return this._alwaysAsId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjectIdInfo: propName=");
        sb.append(this._propertyName);
        sb.append(", scope=");
        sb.append(ClassUtil.nameOf(this._scope));
        sb.append(", generatorType=");
        sb.append(ClassUtil.nameOf(this._generator));
        sb.append(", alwaysAsId=");
        sb.append(this._alwaysAsId);
        return sb.toString();
    }
}
