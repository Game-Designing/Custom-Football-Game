package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.Map;

public class SimpleMixInResolver implements MixInResolver, Serializable {
    protected Map<ClassKey, Class<?>> _localMixIns;
    protected final MixInResolver _overrides;

    public SimpleMixInResolver(MixInResolver overrides) {
        this._overrides = overrides;
    }

    public Class<?> findMixInClassFor(Class<?> cls) {
        MixInResolver mixInResolver = this._overrides;
        Class<?> mixin = mixInResolver == null ? null : mixInResolver.findMixInClassFor(cls);
        if (mixin != null) {
            return mixin;
        }
        Map<ClassKey, Class<?>> map = this._localMixIns;
        if (map != null) {
            return (Class) map.get(new ClassKey(cls));
        }
        return mixin;
    }
}
