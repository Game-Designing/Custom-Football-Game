package com.google.gson.p192b;

import com.google.gson.C10184o;
import com.google.gson.InstanceCreator;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.p195c.C10172a;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* renamed from: com.google.gson.b.q */
/* compiled from: ConstructorConstructor */
public final class C10157q {

    /* renamed from: a */
    private final Map<Type, C10184o<?>> f30819a;

    public C10157q(Map<Type, C10184o<?>> instanceCreators) {
        this.f30819a = instanceCreators;
    }

    /* renamed from: a */
    public <T> C10170z<T> mo33364a(C10172a<T> typeToken) {
        Type type = typeToken.mo33421b();
        Class<? super T> rawType = typeToken.mo33420a();
        InstanceCreator<T> typeCreator = (C10184o) this.f30819a.get(type);
        if (typeCreator != null) {
            return new C10148h(this, typeCreator, type);
        }
        InstanceCreator<T> rawTypeCreator = (C10184o) this.f30819a.get(rawType);
        if (rawTypeCreator != null) {
            return new C10149i(this, rawTypeCreator, type);
        }
        ObjectConstructor<T> defaultConstructor = m33083a(rawType);
        if (defaultConstructor != null) {
            return defaultConstructor;
        }
        ObjectConstructor<T> defaultImplementation = m33084a(type, rawType);
        if (defaultImplementation != null) {
            return defaultImplementation;
        }
        return m33085b(type, rawType);
    }

    /* renamed from: a */
    private <T> C10170z<T> m33083a(Class<? super T> rawType) {
        try {
            Constructor<? super T> constructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return new C10150j(this, constructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* renamed from: a */
    private <T> C10170z<T> m33084a(Type type, Class<? super T> rawType) {
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                return new C10151k(this);
            }
            if (EnumSet.class.isAssignableFrom(rawType)) {
                return new C10152l(this, type);
            }
            if (Set.class.isAssignableFrom(rawType)) {
                return new C10153m(this);
            }
            if (Queue.class.isAssignableFrom(rawType)) {
                return new C10154n(this);
            }
            return new C10155o(this);
        } else if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(rawType)) {
                return new C10156p(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(rawType)) {
                return new C10143c(this);
            }
            if (SortedMap.class.isAssignableFrom(rawType)) {
                return new C10144d(this);
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(C10172a.m33120a(((ParameterizedType) type).getActualTypeArguments()[0]).mo33420a())) {
                return new C10146f(this);
            }
            return new C10145e(this);
        }
    }

    /* renamed from: b */
    private <T> C10170z<T> m33085b(Type type, Class<? super T> rawType) {
        return new C10147g(this, rawType, type);
    }

    public String toString() {
        return this.f30819a.toString();
    }
}
