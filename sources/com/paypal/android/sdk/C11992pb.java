package com.paypal.android.sdk;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.paypal.android.sdk.pb */
public class C11992pb {

    /* renamed from: a */
    private static List f37650a = Arrays.asList(new String[]{"AU", "BR", "CA", "ES", "FR", "GB", "IT", "MY", "SG", "US"});

    /* renamed from: b */
    private static Pattern f37651b = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,} *$");

    /* renamed from: c */
    private static Pattern f37652c = Pattern.compile("^[0-9]{4,8}$");

    /* renamed from: d */
    private static Pattern f37653d = Pattern.compile("^\\+?[0-9]{7,14}$");

    /* renamed from: e */
    private static Pattern f37654e = Pattern.compile("[ .\\-\\(\\)]*");

    /* renamed from: f */
    private static Pattern f37655f = Pattern.compile("^\\+?0+$");

    /* renamed from: g */
    private static /* synthetic */ boolean f37656g = (!C11992pb.class.desiredAssertionStatus());

    /* renamed from: a */
    public static boolean m39649a(String str) {
        if (f37656g || str != null) {
            return f37651b.matcher(str).matches();
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public static boolean m39650b(String str) {
        if (f37656g || str != null) {
            return f37652c.matcher(str).matches();
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public static boolean m39651c(String str) {
        return str.length() >= 8;
    }

    /* renamed from: d */
    public static boolean m39652d(String str) {
        if (f37656g || str != null) {
            String replaceAll = f37654e.matcher(str).replaceAll("");
            return f37653d.matcher(replaceAll).matches() && !f37655f.matcher(replaceAll).matches();
        }
        throw new AssertionError();
    }

    /* renamed from: e */
    public static String m39653e(String str) {
        return f37654e.matcher(str).replaceAll("");
    }

    /* renamed from: f */
    public static boolean m39654f(String str) {
        if (C11723Fa.m38818a((CharSequence) str)) {
            return false;
        }
        return f37650a.contains(str.toUpperCase());
    }
}
