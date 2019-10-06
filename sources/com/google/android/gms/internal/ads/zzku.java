package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzku extends Exception {

    /* renamed from: a */
    private final int f28763a;

    /* renamed from: b */
    private final int f28764b;

    /* renamed from: a */
    public static zzku m30599a(Exception exc, int i) {
        return new zzku(1, null, exc, i);
    }

    /* renamed from: a */
    public static zzku m30598a(IOException iOException) {
        return new zzku(0, null, iOException, -1);
    }

    /* renamed from: a */
    static zzku m30600a(RuntimeException runtimeException) {
        return new zzku(2, null, runtimeException, -1);
    }

    private zzku(int i, String str, Throwable th, int i2) {
        super(null, th);
        this.f28763a = i;
        this.f28764b = i2;
    }
}
