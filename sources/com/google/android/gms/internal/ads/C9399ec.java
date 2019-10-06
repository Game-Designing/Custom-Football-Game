package com.google.android.gms.internal.ads;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.ads.ec */
final class C9399ec implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Context f22206a;

    /* renamed from: b */
    private final /* synthetic */ zzaxi f22207b;

    C9399ec(zzaxi zzaxi, Context context) {
        this.f22207b = zzaxi;
        this.f22206a = context;
    }

    public final void run() {
        synchronized (this.f22207b.f24965e) {
            this.f22207b.f24966f = zzaxi.m26127c(this.f22206a);
            this.f22207b.f24965e.notifyAll();
        }
    }
}
