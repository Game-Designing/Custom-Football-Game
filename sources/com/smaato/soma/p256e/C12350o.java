package com.smaato.soma.p256e;

import java.lang.reflect.Constructor;

/* renamed from: com.smaato.soma.e.o */
/* compiled from: MediationEventBannerFactory */
public class C12350o {

    /* renamed from: a */
    private static C12350o f38589a = new C12350o();

    /* renamed from: a */
    public static C12345k m40600a(String className) throws Exception {
        return f38589a.mo39764b(className);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C12345k mo39764b(String className) throws Exception {
        Constructor<?> bannerConstructor = Class.forName(className).asSubclass(C12345k.class).getDeclaredConstructor(null);
        bannerConstructor.setAccessible(true);
        return (C12345k) bannerConstructor.newInstance(new Object[0]);
    }
}
