package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Oi */
final /* synthetic */ class C9042Oi implements Runnable {

    /* renamed from: a */
    private final zzbbh f21541a;

    C9042Oi(zzbbh zzbbh) {
        this.f21541a = zzbbh;
    }

    public final void run() {
        this.f21541a.cancel(true);
    }
}
