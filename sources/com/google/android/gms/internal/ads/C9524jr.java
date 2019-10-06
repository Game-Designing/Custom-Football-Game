package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.jr */
final class C9524jr {

    /* renamed from: a */
    public final int f22625a;

    /* renamed from: b */
    public final long[] f22626b;

    /* renamed from: c */
    public final int[] f22627c;

    /* renamed from: d */
    public final long[] f22628d;

    /* renamed from: e */
    public final int[] f22629e;

    C9524jr(long[] jArr, int[] iArr, long[] jArr2, int[] iArr2) {
        boolean z = true;
        zzkh.m30535a(iArr.length == jArr2.length);
        zzkh.m30535a(jArr.length == jArr2.length);
        if (iArr2.length != jArr2.length) {
            z = false;
        }
        zzkh.m30535a(z);
        this.f22626b = jArr;
        this.f22627c = iArr;
        this.f22628d = jArr2;
        this.f22629e = iArr2;
        this.f22625a = jArr.length;
    }
}
