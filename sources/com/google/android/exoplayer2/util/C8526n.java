package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.google.android.exoplayer2.util.n */
/* compiled from: Log */
public final class C8526n {

    /* renamed from: a */
    private static int f18829a = 0;

    /* renamed from: b */
    private static boolean f18830b = true;

    /* renamed from: a */
    public static void m20529a(String tag, String message) {
        if (f18829a == 0) {
            Log.d(tag, message);
        }
    }

    /* renamed from: c */
    public static void m20533c(String tag, String message) {
        if (f18829a <= 1) {
            Log.i(tag, message);
        }
    }

    /* renamed from: d */
    public static void m20534d(String tag, String message) {
        if (f18829a <= 2) {
            Log.w(tag, message);
        }
    }

    /* renamed from: b */
    public static void m20532b(String tag, String message, Throwable throwable) {
        if (!f18830b) {
            m20534d(tag, m20528a(message, throwable));
        }
        if (f18829a <= 2) {
            Log.w(tag, message, throwable);
        }
    }

    /* renamed from: b */
    public static void m20531b(String tag, String message) {
        if (f18829a <= 3) {
            Log.e(tag, message);
        }
    }

    /* renamed from: a */
    public static void m20530a(String tag, String message, Throwable throwable) {
        if (!f18830b) {
            m20531b(tag, m20528a(message, throwable));
        }
        if (f18829a <= 3) {
            Log.e(tag, message, throwable);
        }
    }

    /* renamed from: a */
    private static String m20528a(String message, Throwable throwable) {
        String str;
        if (throwable == null) {
            return message;
        }
        String throwableMessage = throwable.getMessage();
        if (TextUtils.isEmpty(throwableMessage)) {
            str = message;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(message);
            sb.append(" - ");
            sb.append(throwableMessage);
            str = sb.toString();
        }
        return str;
    }
}
