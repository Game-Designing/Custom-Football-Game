package com.google.android.gms.internal.ads;

@zzard
/* renamed from: com.google.android.gms.internal.ads.Dd */
final class C8806Dd implements Runnable {

    /* renamed from: a */
    private zzbcq f20579a;

    /* renamed from: b */
    private boolean f20580b = false;

    C8806Dd(zzbcq zzbcq) {
        this.f20579a = zzbcq;
    }

    public final void run() {
        if (!this.f20580b) {
            this.f20579a.mo30409o();
            m22376c();
        }
    }

    /* renamed from: a */
    public final void mo28117a() {
        this.f20580b = true;
        this.f20579a.mo30409o();
    }

    /* renamed from: b */
    public final void mo28118b() {
        this.f20580b = false;
        m22376c();
    }

    /* renamed from: c */
    private final void m22376c() {
        zzaxi.f24961a.removeCallbacks(this);
        zzaxi.f24961a.postDelayed(this, 250);
    }
}
