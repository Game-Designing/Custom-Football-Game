package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Lf */
final /* synthetic */ class C8976Lf implements Runnable {

    /* renamed from: a */
    private final zzbkz f21424a;

    /* renamed from: b */
    private final Runnable f21425b;

    C8976Lf(zzbkz zzbkz, Runnable runnable) {
        this.f21424a = zzbkz;
        this.f21425b = runnable;
    }

    public final void run() {
        zzbbm.f25064a.execute(new C8997Mf(this.f21424a, this.f21425b));
    }
}
