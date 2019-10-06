package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.mo */
final class C9587mo {

    /* renamed from: a */
    private static final Class<?> f22767a = m23883a("libcore.io.Memory");

    /* renamed from: b */
    private static final boolean f22768b = (m23883a("org.robolectric.Robolectric") != null);

    /* renamed from: a */
    static boolean m23884a() {
        return f22767a != null && !f22768b;
    }

    /* renamed from: b */
    static Class<?> m23885b() {
        return f22767a;
    }

    /* renamed from: a */
    private static <T> Class<T> m23883a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
