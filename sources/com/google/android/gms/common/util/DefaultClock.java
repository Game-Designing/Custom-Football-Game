package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class DefaultClock implements Clock {

    /* renamed from: a */
    private static final DefaultClock f20292a = new DefaultClock();

    @KeepForSdk
    /* renamed from: d */
    public static Clock m22087d() {
        return f20292a;
    }

    /* renamed from: b */
    public long mo27935b() {
        return System.currentTimeMillis();
    }

    /* renamed from: a */
    public long mo27934a() {
        return SystemClock.elapsedRealtime();
    }

    /* renamed from: c */
    public long mo27936c() {
        return System.nanoTime();
    }

    private DefaultClock() {
    }
}
