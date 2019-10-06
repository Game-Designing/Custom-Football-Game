package com.flurry.sdk;

/* renamed from: com.flurry.sdk.Ya */
public final class C7479Ya {

    /* renamed from: a */
    private static C7479Ya f14725a;

    private C7479Ya() {
    }

    /* renamed from: a */
    public static synchronized C7479Ya m16564a() {
        C7479Ya ya;
        synchronized (C7479Ya.class) {
            if (f14725a == null) {
                f14725a = new C7479Ya();
            }
            ya = f14725a;
        }
        return ya;
    }
}
