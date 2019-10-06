package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.Og */
final /* synthetic */ class C9040Og implements Runnable {

    /* renamed from: a */
    private final zzbtu f21538a;

    /* renamed from: b */
    private final Object f21539b;

    C9040Og(zzbtu zzbtu, Object obj) {
        this.f21538a = zzbtu;
        this.f21539b = obj;
    }

    public final void run() {
        try {
            this.f21538a.mo28017a(this.f21539b);
        } catch (Throwable th) {
            zzk.zzlk().mo30170b(th, "EventEmitter.notify");
            zzawz.m26002e("Event emitter exception.", th);
        }
    }
}
