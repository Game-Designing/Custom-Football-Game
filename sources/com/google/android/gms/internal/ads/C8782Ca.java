package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Ca */
final /* synthetic */ class C8782Ca implements Runnable {

    /* renamed from: a */
    private final C8761Ba f20531a;

    /* renamed from: b */
    private final zzajw f20532b;

    C8782Ca(C8761Ba ba, zzajw zzajw) {
        this.f20531a = ba;
        this.f20532b = zzajw;
    }

    public final void run() {
        C8761Ba ba = this.f20531a;
        zzajw zzajw = this.f20532b;
        ba.f20492a.f24401d.mo28191a(zzajw);
        zzajw.destroy();
    }
}
