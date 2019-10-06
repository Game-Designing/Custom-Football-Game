package com.google.android.gms.internal.ads;

public final class zzkh {
    /* renamed from: a */
    public static void m30535a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public static void m30536a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: b */
    public static void m30537b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public static <T> T m30534a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
