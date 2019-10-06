package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.internal.ads.Sc */
final /* synthetic */ class C9119Sc implements Runnable {

    /* renamed from: a */
    private final zzbbr f21688a;

    C9119Sc(zzbbr zzbbr) {
        this.f21688a = zzbbr;
    }

    public final void run() {
        this.f21688a.mo30337a(new TimeoutException());
    }
}
