package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.ads.sp */
final class C9717sp {

    /* renamed from: a */
    private static final C9717sp f22966a = new C9717sp();

    /* renamed from: b */
    private final C9843yp f22967b = new C9346bp();

    /* renamed from: c */
    private final ConcurrentMap<Class<?>, C9822xp<?>> f22968c = new ConcurrentHashMap();

    /* renamed from: a */
    public static C9717sp m24069a() {
        return f22966a;
    }

    /* renamed from: a */
    public final <T> C9822xp<T> mo29169a(Class<T> cls) {
        String str = "messageType";
        zzdod.m29917a(cls, str);
        C9822xp<T> xpVar = (C9822xp) this.f22968c.get(cls);
        if (xpVar != null) {
            return xpVar;
        }
        C9822xp<T> a = this.f22967b.mo28875a(cls);
        zzdod.m29917a(cls, str);
        zzdod.m29917a(a, "schema");
        C9822xp xpVar2 = (C9822xp) this.f22968c.putIfAbsent(cls, a);
        if (xpVar2 != null) {
            return xpVar2;
        }
        return a;
    }

    /* renamed from: a */
    public final <T> C9822xp<T> mo29170a(T t) {
        return mo29169a(t.getClass());
    }

    private C9717sp() {
    }
}
