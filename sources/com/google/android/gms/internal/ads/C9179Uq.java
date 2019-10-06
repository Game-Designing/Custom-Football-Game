package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Uq */
final class C9179Uq implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f21822a;

    /* renamed from: b */
    private final /* synthetic */ int f21823b;

    /* renamed from: c */
    private final /* synthetic */ float f21824c;

    /* renamed from: d */
    private final /* synthetic */ zzhd f21825d;

    C9179Uq(zzhd zzhd, int i, int i2, float f) {
        this.f21825d = zzhd;
        this.f21822a = i;
        this.f21823b = i2;
        this.f21824c = f;
    }

    public final void run() {
        this.f21825d.f28493H.mo28346a(this.f21822a, this.f21823b, this.f21824c);
    }
}
