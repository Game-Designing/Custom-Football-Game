package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzp {

    /* renamed from: a */
    private static Object f20181a = new Object();

    /* renamed from: b */
    private static boolean f20182b;

    /* renamed from: c */
    private static String f20183c;

    /* renamed from: d */
    private static int f20184d;

    /* renamed from: a */
    public static String m22005a(Context context) {
        m22007c(context);
        return f20183c;
    }

    /* renamed from: b */
    public static int m22006b(Context context) {
        m22007c(context);
        return f20184d;
    }

    /* renamed from: c */
    private static void m22007c(Context context) {
        synchronized (f20181a) {
            if (!f20182b) {
                f20182b = true;
                try {
                    Bundle bundle = Wrappers.m22139a(context).mo27944a(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f20183c = bundle.getString("com.google.app.id");
                        f20184d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }
}
