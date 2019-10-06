package com.fasterxml.jackson.databind.cfg;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class ContextAttributes {

    public static class Impl extends ContextAttributes implements Serializable {
        protected static final Impl EMPTY = new Impl(Collections.emptyMap());
        protected static final Object NULL_SURROGATE = new Object();
        protected transient Map<Object, Object> _nonShared;
        protected final Map<?, ?> _shared;

        protected Impl(Map<?, ?> shared) {
            this._shared = shared;
            this._nonShared = null;
        }

        protected Impl(Map<?, ?> shared, Map<Object, Object> nonShared) {
            this._shared = shared;
            this._nonShared = nonShared;
        }

        public static ContextAttributes getEmpty() {
            return EMPTY;
        }

        public Object getAttribute(Object key) {
            Map<Object, Object> map = this._nonShared;
            if (map != null) {
                Object ob = map.get(key);
                if (ob != null) {
                    if (ob == NULL_SURROGATE) {
                        return null;
                    }
                    return ob;
                }
            }
            return this._shared.get(key);
        }

        public ContextAttributes withPerCallAttribute(Object key, Object value) {
            if (value == null) {
                if (this._shared.containsKey(key)) {
                    value = NULL_SURROGATE;
                } else {
                    Map<Object, Object> map = this._nonShared;
                    if (map == null || !map.containsKey(key)) {
                        return this;
                    }
                    this._nonShared.remove(key);
                    return this;
                }
            }
            Map<Object, Object> map2 = this._nonShared;
            if (map2 == null) {
                return nonSharedInstance(key, value);
            }
            map2.put(key, value);
            return this;
        }

        /* access modifiers changed from: protected */
        public ContextAttributes nonSharedInstance(Object key, Object value) {
            Map<Object, Object> m = new HashMap<>();
            if (value == null) {
                value = NULL_SURROGATE;
            }
            m.put(key, value);
            return new Impl(this._shared, m);
        }
    }

    public abstract Object getAttribute(Object obj);

    public abstract ContextAttributes withPerCallAttribute(Object obj, Object obj2);

    public static ContextAttributes getEmpty() {
        return Impl.getEmpty();
    }
}
