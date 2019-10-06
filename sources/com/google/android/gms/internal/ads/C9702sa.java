package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.sa */
final /* synthetic */ class C9702sa implements Runnable {

    /* renamed from: a */
    private final zzajw f22946a;

    private C9702sa(zzajw zzajw) {
        this.f22946a = zzajw;
    }

    /* renamed from: a */
    static Runnable m24065a(zzajw zzajw) {
        return new C9702sa(zzajw);
    }

    public final void run() {
        this.f22946a.destroy();
    }
}
