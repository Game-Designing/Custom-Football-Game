package com.google.gson.p192b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.gson.b.A */
/* compiled from: Primitives */
public final class C10059A {

    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f30646a;

    /* renamed from: b */
    private static final Map<Class<?>, Class<?>> f30647b;

    static {
        Map<Class<?>, Class<?>> primToWrap = new HashMap<>(16);
        Map<Class<?>, Class<?>> wrapToPrim = new HashMap<>(16);
        m32830a(primToWrap, wrapToPrim, Boolean.TYPE, Boolean.class);
        m32830a(primToWrap, wrapToPrim, Byte.TYPE, Byte.class);
        m32830a(primToWrap, wrapToPrim, Character.TYPE, Character.class);
        m32830a(primToWrap, wrapToPrim, Double.TYPE, Double.class);
        m32830a(primToWrap, wrapToPrim, Float.TYPE, Float.class);
        m32830a(primToWrap, wrapToPrim, Integer.TYPE, Integer.class);
        m32830a(primToWrap, wrapToPrim, Long.TYPE, Long.class);
        m32830a(primToWrap, wrapToPrim, Short.TYPE, Short.class);
        m32830a(primToWrap, wrapToPrim, Void.TYPE, Void.class);
        f30646a = Collections.unmodifiableMap(primToWrap);
        f30647b = Collections.unmodifiableMap(wrapToPrim);
    }

    /* renamed from: a */
    private static void m32830a(Map<Class<?>, Class<?>> forward, Map<Class<?>, Class<?>> backward, Class<?> key, Class<?> value) {
        forward.put(key, value);
        backward.put(value, key);
    }

    /* renamed from: a */
    public static boolean m32831a(Type type) {
        return f30646a.containsKey(type);
    }

    /* renamed from: a */
    public static <T> Class<T> m32829a(Class<T> type) {
        Map<Class<?>, Class<?>> map = f30646a;
        C10068a.m32842a(type);
        Class<T> wrapped = (Class) map.get(type);
        return wrapped == null ? type : wrapped;
    }
}
