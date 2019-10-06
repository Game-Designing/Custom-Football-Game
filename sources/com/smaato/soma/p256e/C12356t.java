package com.smaato.soma.p256e;

import java.lang.reflect.Constructor;

/* renamed from: com.smaato.soma.e.t */
/* compiled from: MediationEventInterstitialFactory */
public class C12356t {

    /* renamed from: a */
    private static C12356t f38602a = new C12356t();

    /* renamed from: a */
    public static C12351p m40614a(String className) throws Exception {
        return f38602a.mo39773b(className);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C12351p mo39773b(String className) throws Exception {
        Constructor<?> interstitialConstructor = Class.forName(className).asSubclass(C12351p.class).getDeclaredConstructor(null);
        interstitialConstructor.setAccessible(true);
        return (C12351p) interstitialConstructor.newInstance(new Object[0]);
    }
}
