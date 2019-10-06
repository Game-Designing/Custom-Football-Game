package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ls */
final class C9569ls {

    /* renamed from: a */
    public final int f22736a;

    /* renamed from: b */
    public int f22737b;

    /* renamed from: c */
    public int f22738c;

    /* renamed from: d */
    public long f22739d;

    /* renamed from: e */
    private final boolean f22740e;

    /* renamed from: f */
    private final zzst f22741f;

    /* renamed from: g */
    private final zzst f22742g;

    /* renamed from: h */
    private int f22743h;

    /* renamed from: i */
    private int f22744i;

    public C9569ls(zzst zzst, zzst zzst2, boolean z) {
        this.f22742g = zzst;
        this.f22741f = zzst2;
        this.f22740e = z;
        zzst2.mo32199b(12);
        this.f22736a = zzst2.mo32212l();
        zzst.mo32199b(12);
        this.f22744i = zzst.mo32212l();
        boolean z2 = true;
        if (zzst.mo32202d() != 1) {
            z2 = false;
        }
        zzsk.m31083b(z2, "first_chunk must be 1");
        this.f22737b = -1;
    }

    /* renamed from: a */
    public final boolean mo29072a() {
        long j;
        int i = this.f22737b + 1;
        this.f22737b = i;
        if (i == this.f22736a) {
            return false;
        }
        if (this.f22740e) {
            j = this.f22741f.mo32213m();
        } else {
            j = this.f22741f.mo32210j();
        }
        this.f22739d = j;
        if (this.f22737b == this.f22743h) {
            this.f22738c = this.f22742g.mo32212l();
            this.f22742g.mo32201c(4);
            int i2 = this.f22744i - 1;
            this.f22744i = i2;
            this.f22743h = i2 > 0 ? this.f22742g.mo32212l() - 1 : -1;
        }
        return true;
    }
}
