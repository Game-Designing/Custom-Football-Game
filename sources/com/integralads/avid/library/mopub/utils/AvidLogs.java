package com.integralads.avid.library.mopub.utils;

import android.text.TextUtils;
import android.util.Log;

public class AvidLogs {
    private static final boolean DEBUG = true;
    private static final String TAG = "AVID";

    /* renamed from: d */
    public static void m35377d(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.d("AVID", msg);
        }
    }

    /* renamed from: w */
    public static void m35381w(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.w("AVID", msg);
        }
    }

    /* renamed from: i */
    public static void m35380i(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.i("AVID", msg);
        }
    }

    /* renamed from: e */
    public static void m35378e(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.e("AVID", msg);
        }
    }

    /* renamed from: e */
    public static void m35379e(String msg, Exception e) {
        if (!TextUtils.isEmpty(msg) || e != null) {
            Log.e("AVID", msg, e);
        }
    }
}
