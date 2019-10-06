package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.SystemClock;

/* renamed from: com.google.android.exoplayer2.util.A */
/* compiled from: SystemClock */
final class C8503A implements C8517g {
    C8503A() {
    }

    /* renamed from: a */
    public long mo26036a() {
        return SystemClock.elapsedRealtime();
    }

    /* renamed from: b */
    public long mo26038b() {
        return SystemClock.uptimeMillis();
    }

    /* renamed from: a */
    public C8525m mo26037a(Looper looper, Callback callback) {
        return new C8504B(new Handler(looper, callback));
    }
}
