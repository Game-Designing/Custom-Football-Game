package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzbez implements zzll {

    /* renamed from: a */
    private final zzrz f25249a;

    /* renamed from: b */
    private long f25250b;

    /* renamed from: c */
    private long f25251c;

    /* renamed from: d */
    private long f25252d;

    /* renamed from: e */
    private long f25253e;

    /* renamed from: f */
    private int f25254f;

    /* renamed from: g */
    private boolean f25255g;

    zzbez() {
        this(15000, 30000, 2500, 5000);
    }

    private zzbez(int i, int i2, long j, long j2) {
        this.f25249a = new zzrz(true, 65536);
        this.f25250b = 15000000;
        this.f25251c = 30000000;
        this.f25252d = 2500000;
        this.f25253e = 5000000;
    }

    /* renamed from: i */
    public final void mo30499i() {
        m26647a(false);
    }

    /* renamed from: a */
    public final void mo30491a(zzlo[] zzloArr, zzrb zzrb, zzro zzro) {
        this.f25254f = 0;
        for (int i = 0; i < zzloArr.length; i++) {
            if (zzro.mo32162a(i) != null) {
                this.f25254f += zzsy.m31154b(zzloArr[i].mo31914d());
            }
        }
        this.f25249a.mo32177a(this.f25254f);
    }

    /* renamed from: a */
    public final void mo30489a() {
        m26647a(true);
    }

    /* renamed from: b */
    public final void mo30494b() {
        m26647a(true);
    }

    /* renamed from: c */
    public final zzrt mo30496c() {
        return this.f25249a;
    }

    /* renamed from: a */
    public final synchronized boolean mo30493a(long j, boolean z) {
        long j2;
        j2 = z ? this.f25253e : this.f25252d;
        return j2 <= 0 || j >= j2;
    }

    /* renamed from: a */
    public final synchronized boolean mo30492a(long j) {
        boolean z = false;
        char c = j > this.f25251c ? 0 : j < this.f25250b ? (char) 2 : 1;
        boolean z2 = this.f25249a.mo32179e() >= this.f25254f;
        if (c == 2 || (c == 1 && this.f25255g && !z2)) {
            z = true;
        }
        this.f25255g = z;
        return this.f25255g;
    }

    /* renamed from: c */
    public final synchronized void mo30497c(int i) {
        this.f25250b = ((long) i) * 1000;
    }

    /* renamed from: d */
    public final synchronized void mo30498d(int i) {
        this.f25251c = ((long) i) * 1000;
    }

    /* renamed from: a */
    public final synchronized void mo30490a(int i) {
        this.f25252d = ((long) i) * 1000;
    }

    /* renamed from: b */
    public final synchronized void mo30495b(int i) {
        this.f25253e = ((long) i) * 1000;
    }

    @VisibleForTesting
    /* renamed from: a */
    private final void m26647a(boolean z) {
        this.f25254f = 0;
        this.f25255g = false;
        if (z) {
            this.f25249a.mo32178d();
        }
    }
}
