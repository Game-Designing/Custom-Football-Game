package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.Wb */
final class C9206Wb extends zzawv {

    /* renamed from: d */
    private final /* synthetic */ zzawm f21886d;

    C9206Wb(zzawm zzawm) {
        this.f21886d = zzawm;
    }

    /* renamed from: a */
    public final void mo26663a() {
        zzacx zzacx = new zzacx(this.f21886d.f24902f, this.f21886d.f24903g.f25057a);
        synchronized (this.f21886d.f24897a) {
            try {
                zzk.zzlp();
                zzada.m24797a(this.f21886d.f24904h, zzacx);
            } catch (IllegalArgumentException e) {
                zzbad.m26358c("Cannot config CSI reporter.", e);
            }
        }
    }
}
