package com.google.android.gms.internal.ads;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.ads.Ar */
final class C8757Ar {

    /* renamed from: a */
    public final zzqj f20472a;

    /* renamed from: b */
    public final Object f20473b;

    /* renamed from: c */
    public final int f20474c;

    /* renamed from: d */
    public final zzqw[] f20475d;

    /* renamed from: e */
    private final boolean[] f20476e;

    /* renamed from: f */
    public final long f20477f;

    /* renamed from: g */
    public int f20478g;

    /* renamed from: h */
    public long f20479h;

    /* renamed from: i */
    public boolean f20480i;

    /* renamed from: j */
    public boolean f20481j;

    /* renamed from: k */
    public boolean f20482k;

    /* renamed from: l */
    public C8757Ar f20483l;

    /* renamed from: m */
    public zzrr f20484m;

    /* renamed from: n */
    private final zzlo[] f20485n;

    /* renamed from: o */
    private final zzlp[] f20486o;

    /* renamed from: p */
    private final zzrp f20487p;

    /* renamed from: q */
    private final zzll f20488q;

    /* renamed from: r */
    private final zzql f20489r;

    /* renamed from: s */
    private zzrr f20490s;

    public C8757Ar(zzlo[] zzloArr, zzlp[] zzlpArr, long j, zzrp zzrp, zzll zzll, zzql zzql, Object obj, int i, int i2, boolean z, long j2) {
        this.f20485n = zzloArr;
        this.f20486o = zzlpArr;
        this.f20477f = j;
        this.f20487p = zzrp;
        this.f20488q = zzll;
        this.f20489r = zzql;
        zzsk.m31078a(obj);
        this.f20473b = obj;
        this.f20474c = i;
        this.f20478g = i2;
        this.f20480i = z;
        this.f20479h = j2;
        this.f20475d = new zzqw[zzloArr.length];
        this.f20476e = new boolean[zzloArr.length];
        this.f20472a = zzql.mo32104a(i2, zzll.mo30496c());
    }

    /* renamed from: b */
    public final long mo28048b() {
        return this.f20477f - this.f20479h;
    }

    /* renamed from: a */
    public final void mo28047a(int i, boolean z) {
        this.f20478g = i;
        this.f20480i = z;
    }

    /* renamed from: c */
    public final boolean mo28049c() {
        return this.f20481j && (!this.f20482k || this.f20472a.mo28294b() == Long.MIN_VALUE);
    }

    /* renamed from: d */
    public final boolean mo28050d() throws zzku {
        boolean z;
        zzrr a = this.f20487p.mo32159a(this.f20486o, this.f20472a.mo28300e());
        zzrr zzrr = this.f20490s;
        if (zzrr != null) {
            int i = 0;
            while (true) {
                if (i >= a.f29258b.f29253a) {
                    z = true;
                    break;
                } else if (!a.mo32168a(zzrr, i)) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        this.f20484m = a;
        return true;
    }

    /* renamed from: a */
    public final long mo28044a(long j, boolean z) {
        return mo28045a(j, false, new boolean[this.f20485n.length]);
    }

    /* renamed from: a */
    public final long mo28045a(long j, boolean z, boolean[] zArr) {
        zzro zzro = this.f20484m.f29258b;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzro.f29253a) {
                break;
            }
            boolean[] zArr2 = this.f20476e;
            if (z || !this.f20484m.mo32168a(this.f20490s, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long a = this.f20472a.mo28286a(zzro.mo32163a(), this.f20476e, this.f20475d, zArr, j);
        this.f20490s = this.f20484m;
        this.f20482k = false;
        int i2 = 0;
        while (true) {
            zzqw[] zzqwArr = this.f20475d;
            if (i2 < zzqwArr.length) {
                if (zzqwArr[i2] != null) {
                    zzsk.m31082b(zzro.mo32162a(i2) != null);
                    this.f20482k = true;
                } else {
                    zzsk.m31082b(zzro.mo32162a(i2) == null);
                }
                i2++;
            } else {
                this.f20488q.mo30491a(this.f20485n, this.f20484m.f29257a, zzro);
                return a;
            }
        }
    }

    /* renamed from: a */
    public final void mo28046a() {
        try {
            this.f20489r.mo32107a(this.f20472a);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }
}
