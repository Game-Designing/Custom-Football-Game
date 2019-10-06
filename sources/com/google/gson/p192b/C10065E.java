package com.google.gson.p192b;

import java.lang.reflect.Method;

/* renamed from: com.google.gson.b.E */
/* compiled from: UnsafeAllocator */
class C10065E extends C10067G {

    /* renamed from: a */
    final /* synthetic */ Method f30655a;

    C10065E(Method method) {
        this.f30655a = method;
    }

    /* renamed from: b */
    public <T> T mo33265b(Class<T> c) throws Exception {
        C10067G.m32840a(c);
        return this.f30655a.invoke(null, new Object[]{c, Object.class});
    }
}
