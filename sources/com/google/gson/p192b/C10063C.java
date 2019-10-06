package com.google.gson.p192b;

import java.lang.reflect.Method;

/* renamed from: com.google.gson.b.C */
/* compiled from: UnsafeAllocator */
class C10063C extends C10067G {

    /* renamed from: a */
    final /* synthetic */ Method f30651a;

    /* renamed from: b */
    final /* synthetic */ Object f30652b;

    C10063C(Method method, Object obj) {
        this.f30651a = method;
        this.f30652b = obj;
    }

    /* renamed from: b */
    public <T> T mo33265b(Class<T> c) throws Exception {
        C10067G.m32840a(c);
        return this.f30651a.invoke(this.f30652b, new Object[]{c});
    }
}
