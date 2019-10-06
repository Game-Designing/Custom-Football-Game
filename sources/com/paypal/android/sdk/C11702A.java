package com.paypal.android.sdk;

import android.os.Build;
import java.io.File;

/* renamed from: com.paypal.android.sdk.A */
public final class C11702A {

    /* renamed from: a */
    private static C12002s f36561a = new C12002s();

    /* renamed from: a */
    public static boolean m38680a() {
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || m38681b() || m38682c();
    }

    /* renamed from: b */
    private static boolean m38681b() {
        try {
            return new File(C12002s.m39704a("suFileName")).exists();
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m38682c() {
        try {
            return new File(C12002s.m39704a("superUserApk")).exists();
        } catch (Exception e) {
            return false;
        }
    }
}
