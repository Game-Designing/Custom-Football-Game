package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ua */
final class C9744ua implements zzbbt {

    /* renamed from: a */
    private final /* synthetic */ zzala f23048a;

    /* renamed from: b */
    private final /* synthetic */ zzakh f23049b;

    C9744ua(zzakh zzakh, zzala zzala) {
        this.f23049b = zzakh;
        this.f23048a = zzala;
    }

    public final void run() {
        synchronized (this.f23049b.f24384a) {
            this.f23049b.f24391h = 1;
            zzawz.m26003f("Failed loading new engine. Marking new engine destroyable.");
            this.f23048a.mo29803e();
        }
    }
}
