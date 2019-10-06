package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.Y */
final class C9942Y {

    /* renamed from: a */
    private static final C9938W<?> f30041a = new C9940X();

    /* renamed from: b */
    private static final C9938W<?> f30042b = m31964c();

    /* renamed from: c */
    private static C9938W<?> m31964c() {
        try {
            return (C9938W) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    static C9938W<?> m31962a() {
        return f30041a;
    }

    /* renamed from: b */
    static C9938W<?> m31963b() {
        C9938W<?> w = f30042b;
        if (w != null) {
            return w;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
