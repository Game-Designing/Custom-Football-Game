package com.paypal.android.sdk;

/* renamed from: com.paypal.android.sdk.y */
public final class C12026y {

    /* renamed from: a */
    private static String f37841a = null;

    /* renamed from: b */
    private static long f37842b = 0;

    /* renamed from: c */
    private static long f37843c = 0;

    /* renamed from: a */
    public static synchronized void m39769a() {
        synchronized (C12026y.class) {
            f37841a = C11754P.m38941b(Boolean.TRUE.booleanValue());
            f37842b = System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public static synchronized void m39770a(long j) {
        synchronized (C12026y.class) {
            f37843c = j;
        }
    }

    /* renamed from: b */
    public static synchronized String m39771b() {
        String str;
        synchronized (C12026y.class) {
            if (f37841a == null) {
                m39769a();
            }
            str = f37841a;
        }
        return str;
    }

    /* renamed from: c */
    public static synchronized boolean m39772c() {
        boolean z;
        synchronized (C12026y.class) {
            z = System.currentTimeMillis() - m39773d() <= f37843c;
        }
        return z;
    }

    /* renamed from: d */
    private static synchronized long m39773d() {
        long j;
        synchronized (C12026y.class) {
            if (f37842b == 0) {
                m39769a();
            }
            j = f37842b;
        }
        return j;
    }
}
