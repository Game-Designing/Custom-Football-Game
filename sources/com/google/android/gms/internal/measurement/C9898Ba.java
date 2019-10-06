package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.Ba */
final class C9898Ba {

    /* renamed from: a */
    private static final C10016za f29985a = m31766c();

    /* renamed from: b */
    private static final C10016za f29986b = new C9896Aa();

    /* renamed from: a */
    static C10016za m31764a() {
        return f29985a;
    }

    /* renamed from: b */
    static C10016za m31765b() {
        return f29986b;
    }

    /* renamed from: c */
    private static C10016za m31766c() {
        try {
            return (C10016za) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
