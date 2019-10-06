package com.paypal.android.sdk;

import java.util.Arrays;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.paypal.android.sdk.Q */
public final class C11757Q {
    static {
        Arrays.asList(new String[]{BuildConfig.PAYPAL_ENVIRONMENT, "sandbox", "mock"});
    }

    /* renamed from: a */
    public static boolean m38953a(String str) {
        return str.equals("mock");
    }

    /* renamed from: b */
    public static boolean m38954b(String str) {
        return str.startsWith("sandbox");
    }

    /* renamed from: c */
    public static boolean m38955c(String str) {
        return str.equals(BuildConfig.PAYPAL_ENVIRONMENT);
    }

    /* renamed from: d */
    public static boolean m38956d(String str) {
        return !str.equals(BuildConfig.PAYPAL_ENVIRONMENT) && !str.startsWith("sandbox") && !str.equals("mock");
    }

    /* renamed from: e */
    public static boolean m38957e(String str) {
        return str.startsWith("sandbox") || str.equals("mock");
    }
}
