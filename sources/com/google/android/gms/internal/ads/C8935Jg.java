package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.Jg */
final class C8935Jg implements Runnable {

    /* renamed from: a */
    private final WeakReference<zzbtb> f21353a;

    private C8935Jg(zzbtb zzbtb) {
        this.f21353a = new WeakReference<>(zzbtb);
    }

    public final void run() {
        zzbtb zzbtb = (zzbtb) this.f21353a.get();
        if (zzbtb != null) {
            zzbtb.m27752H();
        }
    }
}
