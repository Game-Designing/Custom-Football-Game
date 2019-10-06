package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza;

/* renamed from: com.google.android.gms.internal.ads.zq */
final class C9865zq implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f23755a;

    /* renamed from: b */
    private final /* synthetic */ boolean f23756b;

    /* renamed from: c */
    private final /* synthetic */ zzdy f23757c;

    C9865zq(zzdy zzdy, int i, boolean z) {
        this.f23757c = zzdy;
        this.f23755a = i;
        this.f23756b = z;
    }

    public final void run() {
        zza b = this.f23757c.mo31713b(this.f23755a, this.f23756b);
        this.f23757c.f28333k = b;
        if (zzdy.m30140b(this.f23755a, b)) {
            this.f23757c.mo31711a(this.f23755a + 1, this.f23756b);
        }
    }
}
