package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.measurement.Da */
final class C9902Da {

    /* renamed from: a */
    private static final C9902Da f29988a = new C9902Da();

    /* renamed from: b */
    private final C9908Ga f29989b = new C9991na();

    /* renamed from: c */
    private final ConcurrentMap<Class<?>, C9906Fa<?>> f29990c = new ConcurrentHashMap();

    /* renamed from: a */
    public static C9902Da m31767a() {
        return f29988a;
    }

    /* renamed from: a */
    public final <T> C9906Fa<T> mo32533a(Class<T> cls) {
        String str = "messageType";
        zzuq.m32542a(cls, str);
        C9906Fa<T> fa = (C9906Fa) this.f29990c.get(cls);
        if (fa != null) {
            return fa;
        }
        C9906Fa<T> a = this.f29989b.mo32561a(cls);
        zzuq.m32542a(cls, str);
        zzuq.m32542a(a, "schema");
        C9906Fa fa2 = (C9906Fa) this.f29990c.putIfAbsent(cls, a);
        if (fa2 != null) {
            return fa2;
        }
        return a;
    }

    /* renamed from: a */
    public final <T> C9906Fa<T> mo32534a(T t) {
        return mo32533a(t.getClass());
    }

    private C9902Da() {
    }
}
