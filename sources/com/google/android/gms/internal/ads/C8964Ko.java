package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Ko */
final class C8964Ko {

    /* renamed from: a */
    private static final C8922Io<?> f21409a = new C8943Jo();

    /* renamed from: b */
    private static final C8922Io<?> f21410b = m22761c();

    /* renamed from: c */
    private static C8922Io<?> m22761c() {
        try {
            return (C8922Io) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    static C8922Io<?> m22759a() {
        return f21409a;
    }

    /* renamed from: b */
    static C8922Io<?> m22760b() {
        C8922Io<?> io = f21410b;
        if (io != null) {
            return io;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
