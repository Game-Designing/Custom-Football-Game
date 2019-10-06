package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.internal.ads.Wc */
final /* synthetic */ class C9207Wc implements Runnable {

    /* renamed from: a */
    private final zzbbh f21887a;

    /* renamed from: b */
    private final Future f21888b;

    C9207Wc(zzbbh zzbbh, Future future) {
        this.f21887a = zzbbh;
        this.f21888b = future;
    }

    public final void run() {
        zzbbh zzbbh = this.f21887a;
        Future future = this.f21888b;
        if (zzbbh.isCancelled()) {
            future.cancel(true);
        }
    }
}
