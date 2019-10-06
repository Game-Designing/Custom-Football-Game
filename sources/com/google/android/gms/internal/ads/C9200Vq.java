package com.google.android.gms.internal.ads;

import android.view.Surface;

/* renamed from: com.google.android.gms.internal.ads.Vq */
final class C9200Vq implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Surface f21864a;

    /* renamed from: b */
    private final /* synthetic */ zzhd f21865b;

    C9200Vq(zzhd zzhd, Surface surface) {
        this.f21865b = zzhd;
        this.f21864a = surface;
    }

    public final void run() {
        this.f21865b.f28493H.mo28348a(this.f21864a);
    }
}
