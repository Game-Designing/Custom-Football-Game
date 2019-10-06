package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.yd */
final class C9831yd implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ boolean f23515a;

    /* renamed from: b */
    private final /* synthetic */ zzbcq f23516b;

    C9831yd(zzbcq zzbcq, boolean z) {
        this.f23516b = zzbcq;
        this.f23515a = z;
    }

    public final void run() {
        this.f23516b.m26462b("windowVisibilityChanged", "isVisible", String.valueOf(this.f23515a));
    }
}
