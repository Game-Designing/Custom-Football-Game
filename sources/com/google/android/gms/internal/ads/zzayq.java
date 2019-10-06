package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzayq {

    /* renamed from: a */
    private final String[] f24993a;

    /* renamed from: b */
    private final double[] f24994b;

    /* renamed from: c */
    private final double[] f24995c;

    /* renamed from: d */
    private final int[] f24996d;

    /* renamed from: e */
    private int f24997e;

    private zzayq(zzayt zzayt) {
        int size = zzayt.f25004b.size();
        this.f24993a = (String[]) zzayt.f25003a.toArray(new String[size]);
        this.f24994b = m26246a(zzayt.f25004b);
        this.f24995c = m26246a(zzayt.f25005c);
        this.f24996d = new int[size];
        this.f24997e = 0;
    }

    /* renamed from: a */
    private static double[] m26246a(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    /* renamed from: a */
    public final void mo30288a(double d) {
        this.f24997e++;
        int i = 0;
        while (true) {
            double[] dArr = this.f24995c;
            if (i < dArr.length) {
                if (dArr[i] <= d && d < this.f24994b[i]) {
                    int[] iArr = this.f24996d;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= this.f24995c[i]) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final List<zzays> mo30287a() {
        ArrayList arrayList = new ArrayList(this.f24993a.length);
        int i = 0;
        while (true) {
            String[] strArr = this.f24993a;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.f24995c[i];
            double d2 = this.f24994b[i];
            int[] iArr = this.f24996d;
            double d3 = (double) iArr[i];
            double d4 = (double) this.f24997e;
            Double.isNaN(d3);
            Double.isNaN(d4);
            zzays zzays = new zzays(str, d, d2, d3 / d4, iArr[i]);
            arrayList.add(zzays);
            i++;
        }
    }
}
