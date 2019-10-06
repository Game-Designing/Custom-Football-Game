package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.flurry.sdk.ec */
public final class C7513ec {

    /* renamed from: a */
    private static boolean f14815a = false;

    /* renamed from: b */
    private static int f14816b = 5;

    /* renamed from: c */
    private static boolean f14817c = false;

    /* renamed from: d */
    private static boolean f14818d = false;

    /* renamed from: a */
    public static void m16637a() {
        f14815a = true;
    }

    /* renamed from: b */
    public static void m16643b() {
        f14815a = false;
    }

    /* renamed from: c */
    public static int m16647c() {
        return f14816b;
    }

    /* renamed from: a */
    public static void m16638a(int i) {
        f14816b = i;
    }

    /* renamed from: d */
    public static boolean m16652d() {
        return f14817c;
    }

    /* renamed from: b */
    private static void m16645b(int i, String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        m16644b(i, str, sb.toString());
    }

    /* renamed from: b */
    private static void m16644b(int i, String str, String str2) {
        if (!f14815a && f14816b <= i) {
            m16648c(i, str, str2);
        }
    }

    /* renamed from: c */
    private static void m16648c(int i, String str, String str2) {
        if (!f14817c) {
            str = "FlurryAgent";
        }
        int i2 = 0;
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        while (i2 < length) {
            int i3 = 4000 > length - i2 ? length : i2 + 4000;
            if (Log.println(i, str, str2.substring(i2, i3)) > 0) {
                i2 = i3;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m16641a(String str, String str2) {
        m16644b(3, str, str2);
    }

    /* renamed from: a */
    public static void m16642a(String str, String str2, Throwable th) {
        m16645b(6, str, str2, th);
    }

    /* renamed from: b */
    public static void m16646b(String str, String str2) {
        m16644b(6, str, str2);
    }

    /* renamed from: c */
    public static void m16649c(String str, String str2) {
        m16644b(4, str, str2);
    }

    /* renamed from: d */
    public static void m16651d(String str, String str2) {
        m16644b(5, str, str2);
    }

    /* renamed from: a */
    public static void m16640a(int i, String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        m16650d(i, str, sb.toString());
    }

    /* renamed from: d */
    private static void m16650d(int i, String str, String str2) {
        if (f14817c) {
            m16648c(i, str, str2);
        }
    }

    /* renamed from: a */
    public static void m16639a(int i, String str, String str2) {
        m16650d(i, str, str2);
    }
}
