package com.flurry.sdk;

/* renamed from: com.flurry.sdk.Md */
public class C7422Md {

    /* renamed from: a */
    private static final String f14549a = C7422Md.class.getSimpleName();

    /* renamed from: b */
    private static boolean f14550b;

    /* renamed from: a */
    public static synchronized void m16415a() {
        synchronized (C7422Md.class) {
            if (!f14550b) {
                C7525gc.m16682a(C7475Xa.class);
                try {
                    C7525gc.m16682a(C7449Rd.class);
                } catch (NoClassDefFoundError e) {
                    C7513ec.m16639a(3, f14549a, "Analytics module not available");
                }
                try {
                    C7525gc.m16682a(C7409Kd.class);
                } catch (NoClassDefFoundError e2) {
                    C7513ec.m16639a(3, f14549a, "Crash module not available");
                }
                try {
                    C7525gc.m16682a(Class.forName("com.flurry.android.bridge.FlurryBridgeModule"));
                } catch (ClassNotFoundException | NoClassDefFoundError e3) {
                    C7513ec.m16639a(3, f14549a, "Ads module not available");
                }
                f14550b = true;
                return;
            }
            return;
        }
    }
}
