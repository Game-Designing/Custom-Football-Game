package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.F */
final class C9905F {

    /* renamed from: a */
    private static final Class<?> f29996a = m31778a("libcore.io.Memory");

    /* renamed from: b */
    private static final boolean f29997b = (m31778a("org.robolectric.Robolectric") != null);

    /* renamed from: a */
    static boolean m31779a() {
        return f29996a != null && !f29997b;
    }

    /* renamed from: b */
    static Class<?> m31780b() {
        return f29996a;
    }

    /* renamed from: a */
    private static <T> Class<T> m31778a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
