package com.integralads.avid.library.inmobi.utils;

import android.text.TextUtils;
import android.util.Log;

public class AvidLogs {
    private static final boolean DEBUG = true;
    private static final String TAG = "AVID";

    /* renamed from: d */
    public static void m35372d(String str) {
        if (!TextUtils.isEmpty(str)) {
            Log.d("AVID", str);
        }
    }

    /* renamed from: w */
    public static void m35376w(String str) {
        if (!TextUtils.isEmpty(str)) {
            Log.w("AVID", str);
        }
    }

    /* renamed from: i */
    public static void m35375i(String str) {
        if (!TextUtils.isEmpty(str)) {
            Log.i("AVID", str);
        }
    }

    /* renamed from: e */
    public static void m35373e(String str) {
        if (!TextUtils.isEmpty(str)) {
            Log.e("AVID", str);
        }
    }

    /* renamed from: e */
    public static void m35374e(String str, Exception exc) {
        if (!TextUtils.isEmpty(str) || exc != null) {
            Log.e("AVID", str, exc);
        }
    }
}
