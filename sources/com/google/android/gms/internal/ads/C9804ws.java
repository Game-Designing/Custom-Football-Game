package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ws */
final class C9804ws {

    /* renamed from: a */
    public final int f23423a;

    /* renamed from: b */
    public final long[] f23424b;

    /* renamed from: c */
    public final int[] f23425c;

    /* renamed from: d */
    public final int f23426d;

    /* renamed from: e */
    public final long[] f23427e;

    /* renamed from: f */
    public final int[] f23428f;

    public C9804ws(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        zzsk.m31080a(iArr.length == jArr2.length);
        zzsk.m31080a(jArr.length == jArr2.length);
        if (iArr2.length != jArr2.length) {
            z = false;
        }
        zzsk.m31080a(z);
        this.f23424b = jArr;
        this.f23425c = iArr;
        this.f23426d = i;
        this.f23427e = jArr2;
        this.f23428f = iArr2;
        this.f23423a = jArr.length;
    }

    /* renamed from: a */
    public final int mo29258a(long j) {
        for (int a = zzsy.m31147a(this.f23427e, j, true, false); a >= 0; a--) {
            if ((this.f23428f[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public final int mo29259b(long j) {
        for (int b = zzsy.m31157b(this.f23427e, j, true, false); b < this.f23427e.length; b++) {
            if ((this.f23428f[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
