package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.ads.Xc */
final /* synthetic */ class C9228Xc implements Runnable {

    /* renamed from: a */
    private final zzbbc f21916a;

    /* renamed from: b */
    private final AtomicInteger f21917b;

    C9228Xc(zzbbc zzbbc, AtomicInteger atomicInteger) {
        this.f21916a = zzbbc;
        this.f21917b = atomicInteger;
    }

    public final void run() {
        this.f21916a.mo30335a(this.f21917b);
    }
}
