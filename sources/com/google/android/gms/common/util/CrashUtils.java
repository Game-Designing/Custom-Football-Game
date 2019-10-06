package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class CrashUtils {

    /* renamed from: a */
    private static final String[] f20286a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    /* renamed from: b */
    private static DropBoxManager f20287b = null;

    /* renamed from: c */
    private static boolean f20288c = false;

    /* renamed from: d */
    private static int f20289d = -1;

    /* renamed from: e */
    private static int f20290e = 0;

    /* renamed from: f */
    private static int f20291f = 0;

    @KeepForSdk
    /* renamed from: a */
    public static boolean m22085a(Context context, Throwable th) {
        return m22086a(context, th, 536870912);
    }

    /* renamed from: a */
    private static boolean m22086a(Context context, Throwable th, int i) {
        try {
            Preconditions.m21857a(context);
            Preconditions.m21857a(th);
            return false;
        } catch (Exception e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
            return false;
        }
    }
}
