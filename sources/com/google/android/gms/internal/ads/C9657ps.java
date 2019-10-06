package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ps */
final class C9657ps implements C9591ms {

    /* renamed from: a */
    private final zzst f22879a;

    /* renamed from: b */
    private final int f22880b = this.f22879a.mo32212l();

    /* renamed from: c */
    private final int f22881c = (this.f22879a.mo32212l() & 255);

    /* renamed from: d */
    private int f22882d;

    /* renamed from: e */
    private int f22883e;

    public C9657ps(C9525js jsVar) {
        this.f22879a = jsVar.f22630Qa;
        this.f22879a.mo32199b(12);
    }

    /* renamed from: b */
    public final int mo29090b() {
        return this.f22880b;
    }

    /* renamed from: c */
    public final int mo29091c() {
        int i = this.f22881c;
        if (i == 8) {
            return this.f22879a.mo32207g();
        }
        if (i == 16) {
            return this.f22879a.mo32208h();
        }
        int i2 = this.f22882d;
        this.f22882d = i2 + 1;
        if (i2 % 2 != 0) {
            return this.f22883e & 15;
        }
        this.f22883e = this.f22879a.mo32207g();
        return (this.f22883e & 240) >> 4;
    }

    /* renamed from: a */
    public final boolean mo29089a() {
        return false;
    }
}
