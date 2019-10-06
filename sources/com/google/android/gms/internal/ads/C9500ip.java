package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ip */
final class C9500ip {

    /* renamed from: a */
    private static final C9456gp f22569a = m23701c();

    /* renamed from: b */
    private static final C9456gp f22570b = new C9478hp();

    /* renamed from: a */
    static C9456gp m23699a() {
        return f22569a;
    }

    /* renamed from: b */
    static C9456gp m23700b() {
        return f22570b;
    }

    /* renamed from: c */
    private static C9456gp m23701c() {
        try {
            return (C9456gp) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
