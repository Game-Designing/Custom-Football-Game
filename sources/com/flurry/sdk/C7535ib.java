package com.flurry.sdk;

import java.util.Locale;

/* renamed from: com.flurry.sdk.ib */
public final class C7535ib {

    /* renamed from: a */
    public static C7535ib f14878a;

    private C7535ib() {
    }

    /* renamed from: a */
    public static synchronized C7535ib m16696a() {
        C7535ib ibVar;
        synchronized (C7535ib.class) {
            if (f14878a == null) {
                f14878a = new C7535ib();
            }
            ibVar = f14878a;
        }
        return ibVar;
    }

    /* renamed from: b */
    public static String m16697b() {
        StringBuilder sb = new StringBuilder();
        sb.append(Locale.getDefault().getLanguage());
        sb.append("_");
        sb.append(Locale.getDefault().getCountry());
        return sb.toString();
    }
}
