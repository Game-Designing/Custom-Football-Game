package com.fasterxml.jackson.annotation;

import java.io.Serializable;

public abstract class ObjectIdGenerator<T> implements Serializable {

    public static final class IdKey implements Serializable {
        private final int hashCode;
        public final Object key;
        public final Class<?> scope;
        public final Class<?> type;

        public IdKey(Class<?> type2, Class<?> scope2, Object key2) {
            if (key2 != null) {
                this.type = type2;
                this.scope = scope2;
                this.key = key2;
                int h = key2.hashCode() + type2.getName().hashCode();
                if (scope2 != null) {
                    h ^= scope2.getName().hashCode();
                }
                this.hashCode = h;
                return;
            }
            throw new IllegalArgumentException("Can not construct IdKey for null key");
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object o) {
            boolean z = true;
            if (o == this) {
                return true;
            }
            if (o == null || o.getClass() != getClass()) {
                return false;
            }
            IdKey other = (IdKey) o;
            if (!(other.key.equals(this.key) && other.type == this.type && other.scope == this.scope)) {
                z = false;
            }
            return z;
        }

        public String toString() {
            Object[] objArr = new Object[3];
            objArr[0] = this.key;
            Class<?> cls = this.type;
            String str = "NONE";
            objArr[1] = cls == null ? str : cls.getName();
            Class<?> cls2 = this.scope;
            if (cls2 != null) {
                str = cls2.getName();
            }
            objArr[2] = str;
            return String.format("[ObjectId: key=%s, type=%s, scope=%s]", objArr);
        }
    }

    public abstract boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator);

    public abstract ObjectIdGenerator<T> forScope(Class<?> cls);

    public abstract T generateId(Object obj);

    public abstract Class<?> getScope();

    public abstract IdKey key(Object obj);

    public abstract ObjectIdGenerator<T> newForSerialization(Object obj);

    public boolean maySerializeAsObject() {
        return false;
    }

    public boolean isValidReferencePropertyName(String name, Object parser) {
        return false;
    }
}
