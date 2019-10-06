package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbov implements zzbsr, zzue {

    /* renamed from: a */
    private final zzcxm f25692a;

    /* renamed from: b */
    private final zzbrt f25693b;

    /* renamed from: c */
    private final AtomicBoolean f25694c = new AtomicBoolean();

    public zzbov(zzcxm zzcxm, zzbrt zzbrt) {
        this.f25692a = zzcxm;
        this.f25693b = zzbrt;
    }

    public final synchronized void onAdLoaded() {
        if (this.f25692a.f27554e != 1) {
            m27334C();
        }
    }

    /* renamed from: a */
    public final void mo28694a(zzud zzud) {
        if (this.f25692a.f27554e == 1 && zzud.f29465m) {
            m27334C();
        }
    }

    /* renamed from: C */
    private final void m27334C() {
        if (this.f25694c.compareAndSet(false, true)) {
            this.f25693b.mo30877G();
        }
    }
}
