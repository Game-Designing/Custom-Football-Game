package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

/* renamed from: com.flurry.sdk.wd */
public final class C7619wd {

    /* renamed from: a */
    private static final String f15125a = C7619wd.class.getSimpleName();

    /* renamed from: a */
    public static String m16849a(Context context) {
        PackageInfo c = m16851c(context);
        if (c != null) {
            String str = c.packageName;
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    /* renamed from: c */
    private static PackageInfo m16851c(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (NameNotFoundException e) {
                String str = f15125a;
                StringBuilder sb = new StringBuilder("Cannot find package info for package: ");
                sb.append(context.getPackageName());
                C7513ec.m16641a(str, sb.toString());
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m16850b(Context context) {
        PackageInfo c = m16851c(context);
        if (c != null) {
            String str = c.versionName;
            if (str != null) {
                return str;
            }
        }
        return "";
    }
}
