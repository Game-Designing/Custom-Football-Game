package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.qp */
final class C9675qp {

    /* renamed from: a */
    private static final C9632op f22912a = m24049c();

    /* renamed from: b */
    private static final C9632op f22913b = new C9654pp();

    /* renamed from: a */
    static C9632op m24047a() {
        return f22912a;
    }

    /* renamed from: b */
    static C9632op m24048b() {
        return f22913b;
    }

    /* renamed from: c */
    private static C9632op m24049c() {
        try {
            return (C9632op) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
