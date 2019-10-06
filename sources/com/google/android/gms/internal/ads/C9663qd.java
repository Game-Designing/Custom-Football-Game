package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.qd */
final class C9663qd implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f22893a;

    /* renamed from: b */
    private final /* synthetic */ int f22894b;

    /* renamed from: c */
    private final /* synthetic */ zzbcd f22895c;

    C9663qd(zzbcd zzbcd, int i, int i2) {
        this.f22895c = zzbcd;
        this.f22893a = i;
        this.f22894b = i2;
    }

    public final void run() {
        if (this.f22895c.f25092r != null) {
            this.f22895c.f25092r.mo30373a(this.f22893a, this.f22894b);
        }
    }
}
