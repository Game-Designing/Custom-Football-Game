package com.google.gson.p192b;

import java.lang.reflect.Method;

/* renamed from: com.google.gson.b.D */
/* compiled from: UnsafeAllocator */
class C10064D extends C10067G {

    /* renamed from: a */
    final /* synthetic */ Method f30653a;

    /* renamed from: b */
    final /* synthetic */ int f30654b;

    C10064D(Method method, int i) {
        this.f30653a = method;
        this.f30654b = i;
    }

    /* renamed from: b */
    public <T> T mo33265b(Class<T> c) throws Exception {
        C10067G.m32840a(c);
        return this.f30653a.invoke(null, new Object[]{c, Integer.valueOf(this.f30654b)});
    }
}
