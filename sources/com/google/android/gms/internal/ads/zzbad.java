package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public class zzbad {
    /* renamed from: a */
    public static void m26352a(String str) {
        if (m26354a(3)) {
            Log.d("Ads", str);
        }
    }

    /* renamed from: a */
    public static void m26353a(String str, Throwable th) {
        if (m26354a(3)) {
            Log.d("Ads", str, th);
        }
    }

    /* renamed from: b */
    public static void m26355b(String str) {
        if (m26354a(6)) {
            Log.e("Ads", str);
        }
    }

    /* renamed from: b */
    public static void m26356b(String str, Throwable th) {
        if (m26354a(6)) {
            Log.e("Ads", str, th);
        }
    }

    /* renamed from: c */
    public static void m26357c(String str) {
        if (m26354a(4)) {
            Log.i("Ads", str);
        }
    }

    /* renamed from: d */
    public static void m26359d(String str) {
        if (m26354a(5)) {
            Log.w("Ads", str);
        }
    }

    /* renamed from: c */
    public static void m26358c(String str, Throwable th) {
        if (m26354a(5)) {
            Log.w("Ads", str, th);
        }
    }

    @VisibleForTesting
    /* renamed from: f */
    private static String m26362f(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    /* renamed from: d */
    public static void m26360d(String str, Throwable th) {
        if (m26354a(5)) {
            if (th != null) {
                m26358c(m26362f(str), th);
                return;
            }
            m26359d(m26362f(str));
        }
    }

    /* renamed from: e */
    public static void m26361e(String str) {
        m26360d(str, null);
    }

    /* renamed from: a */
    public static boolean m26354a(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }
}
