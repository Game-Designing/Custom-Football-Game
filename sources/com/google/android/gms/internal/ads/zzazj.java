package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

@zzard
public final class zzazj {

    /* renamed from: a */
    private long f25021a;

    /* renamed from: b */
    private long f25022b = Long.MIN_VALUE;

    /* renamed from: c */
    private final Object f25023c = new Object();

    public zzazj(long j) {
        this.f25021a = j;
    }

    /* renamed from: a */
    public final boolean mo30301a() {
        synchronized (this.f25023c) {
            long a = zzk.zzln().mo27934a();
            if (this.f25022b + this.f25021a > a) {
                return false;
            }
            this.f25022b = a;
            return true;
        }
    }

    /* renamed from: a */
    public final void mo30300a(long j) {
        synchronized (this.f25023c) {
            this.f25021a = j;
        }
    }
}
