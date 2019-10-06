package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

public abstract class zzrj extends zzrp {

    /* renamed from: b */
    private final SparseArray<Map<zzrb, zzrl>> f29243b = new SparseArray<>();

    /* renamed from: c */
    private final SparseBooleanArray f29244c = new SparseBooleanArray();

    /* renamed from: d */
    private int f29245d = 0;

    /* renamed from: e */
    private zzrk f29246e;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract zzrm[] mo32156a(zzlp[] zzlpArr, zzrb[] zzrbArr, int[][][] iArr) throws zzku;

    /* renamed from: a */
    public final void mo32160a(int i, boolean z) {
        if (this.f29244c.get(i) != z) {
            this.f29244c.put(i, z);
            mo32166a();
        }
    }

    /* renamed from: a */
    public final zzrr mo32159a(zzlp[] zzlpArr, zzrb zzrb) throws zzku {
        int[] iArr;
        zzlp[] zzlpArr2 = zzlpArr;
        zzrb zzrb2 = zzrb;
        int[] iArr2 = new int[(zzlpArr2.length + 1)];
        zzra[][] zzraArr = new zzra[(zzlpArr2.length + 1)][];
        int[][][] iArr3 = new int[(zzlpArr2.length + 1)][][];
        for (int i = 0; i < zzraArr.length; i++) {
            int i2 = zzrb2.f29216b;
            zzraArr[i] = new zzra[i2];
            iArr3[i] = new int[i2][];
        }
        int[] iArr4 = new int[zzlpArr2.length];
        for (int i3 = 0; i3 < iArr4.length; i3++) {
            iArr4[i3] = zzlpArr2[i3].mo31923m();
        }
        for (int i4 = 0; i4 < zzrb2.f29216b; i4++) {
            zzra a = zzrb2.mo32147a(i4);
            int length = zzlpArr2.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 >= zzlpArr2.length) {
                    i5 = length;
                    break;
                }
                zzlp zzlp = zzlpArr2[i5];
                int i7 = length;
                int i8 = i6;
                for (int i9 = 0; i9 < a.f29212a; i9++) {
                    int a2 = zzlp.mo31955a(a.mo32143a(i9)) & 3;
                    if (a2 > i8) {
                        if (a2 == 3) {
                            break;
                        }
                        i7 = i5;
                        i8 = a2;
                    }
                }
                i5++;
                i6 = i8;
                length = i7;
            }
            if (i5 == zzlpArr2.length) {
                iArr = new int[a.f29212a];
            } else {
                zzlp zzlp2 = zzlpArr2[i5];
                int[] iArr5 = new int[a.f29212a];
                for (int i10 = 0; i10 < a.f29212a; i10++) {
                    iArr5[i10] = zzlp2.mo31955a(a.mo32143a(i10));
                }
                iArr = iArr5;
            }
            int i11 = iArr2[i5];
            zzraArr[i5][i11] = a;
            iArr3[i5][i11] = iArr;
            iArr2[i5] = iArr2[i5] + 1;
        }
        zzrb[] zzrbArr = new zzrb[zzlpArr2.length];
        int[] iArr6 = new int[zzlpArr2.length];
        for (int i12 = 0; i12 < zzlpArr2.length; i12++) {
            int i13 = iArr2[i12];
            zzrbArr[i12] = new zzrb((zzra[]) Arrays.copyOf(zzraArr[i12], i13));
            iArr3[i12] = (int[][]) Arrays.copyOf(iArr3[i12], i13);
            iArr6[i12] = zzlpArr2[i12].mo31914d();
        }
        zzrb zzrb3 = new zzrb((zzra[]) Arrays.copyOf(zzraArr[zzlpArr2.length], iArr2[zzlpArr2.length]));
        zzrm[] a3 = mo32156a(zzlpArr2, zzrbArr, iArr3);
        int i14 = 0;
        while (true) {
            zzrl zzrl = null;
            if (i14 < zzlpArr2.length) {
                if (this.f29244c.get(i14)) {
                    a3[i14] = null;
                } else {
                    zzrb zzrb4 = zzrbArr[i14];
                    Map map = (Map) this.f29243b.get(i14);
                    if (map != null) {
                        zzrl = (zzrl) map.get(zzrb4);
                    }
                    if (zzrl != null) {
                        throw new NoSuchMethodError();
                    }
                }
                i14++;
            } else {
                zzrk zzrk = new zzrk(iArr6, zzrbArr, iArr4, iArr3, zzrb3);
                zzlq[] zzlqArr = new zzlq[zzlpArr2.length];
                for (int i15 = 0; i15 < zzlpArr2.length; i15++) {
                    zzlqArr[i15] = a3[i15] != null ? zzlq.f28813a : null;
                }
                return new zzrr(zzrb2, new zzro(a3), zzrk, zzlqArr);
            }
        }
    }

    /* renamed from: a */
    public final void mo32161a(Object obj) {
        this.f29246e = (zzrk) obj;
    }
}
