package com.bumptech.glide.p107h;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

/* renamed from: com.bumptech.glide.h.e */
/* compiled from: LogTime */
public final class C6020e {

    /* renamed from: a */
    private static final double f10655a;

    static {
        double d = 1.0d;
        if (VERSION.SDK_INT >= 17) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f10655a = d;
    }

    @TargetApi(17)
    /* renamed from: a */
    public static long m11250a() {
        if (VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    /* renamed from: a */
    public static double m11249a(long logTime) {
        double a = (double) (m11250a() - logTime);
        double d = f10655a;
        Double.isNaN(a);
        return a * d;
    }
}
