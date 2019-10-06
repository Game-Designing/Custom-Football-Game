package com.google.android.gms.internal.ads;

public final class zznl implements zznu {

    /* renamed from: a */
    private final int f28962a;

    /* renamed from: b */
    private final int[] f28963b;

    /* renamed from: c */
    private final long[] f28964c;

    /* renamed from: d */
    private final long[] f28965d;

    /* renamed from: e */
    private final long[] f28966e;

    /* renamed from: f */
    private final long f28967f;

    public zznl(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f28963b = iArr;
        this.f28964c = jArr;
        this.f28965d = jArr2;
        this.f28966e = jArr3;
        this.f28962a = iArr.length;
        int i = this.f28962a;
        if (i > 0) {
            this.f28967f = jArr2[i - 1] + jArr3[i - 1];
        } else {
            this.f28967f = 0;
        }
    }

    /* renamed from: c */
    public final boolean mo32043c() {
        return true;
    }

    /* renamed from: b */
    public final long mo32042b() {
        return this.f28967f;
    }

    /* renamed from: a */
    public final long mo32041a(long j) {
        return this.f28964c[zzsy.m31147a(this.f28966e, j, true, true)];
    }
}
