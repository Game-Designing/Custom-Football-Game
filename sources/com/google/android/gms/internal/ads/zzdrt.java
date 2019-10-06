package com.google.android.gms.internal.ads;

public final class zzdrt implements Cloneable {

    /* renamed from: a */
    private static final C9457gq f28158a = new C9457gq();

    /* renamed from: b */
    private boolean f28159b;

    /* renamed from: c */
    private int[] f28160c;

    /* renamed from: d */
    private C9457gq[] f28161d;

    /* renamed from: e */
    private int f28162e;

    zzdrt() {
        this(10);
    }

    private zzdrt(int i) {
        this.f28159b = false;
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.f28160c = new int[i5];
        this.f28161d = new C9457gq[i5];
        this.f28162e = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo31676a() {
        return this.f28162e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C9457gq mo31677a(int i) {
        return this.f28161d[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdrt)) {
            return false;
        }
        zzdrt zzdrt = (zzdrt) obj;
        int i = this.f28162e;
        if (i != zzdrt.f28162e) {
            return false;
        }
        int[] iArr = this.f28160c;
        int[] iArr2 = zzdrt.f28160c;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            C9457gq[] gqVarArr = this.f28161d;
            C9457gq[] gqVarArr2 = zzdrt.f28161d;
            int i3 = this.f28162e;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!gqVarArr[i4].equals(gqVarArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f28162e; i2++) {
            i = (((i * 31) + this.f28160c[i2]) * 31) + this.f28161d[i2].hashCode();
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.f28162e;
        zzdrt zzdrt = new zzdrt(i);
        System.arraycopy(this.f28160c, 0, zzdrt.f28160c, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            C9457gq[] gqVarArr = this.f28161d;
            if (gqVarArr[i2] != null) {
                zzdrt.f28161d[i2] = (C9457gq) gqVarArr[i2].clone();
            }
        }
        zzdrt.f28162e = i;
        return zzdrt;
    }
}
