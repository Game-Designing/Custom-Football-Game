package com.google.android.gms.internal.ads;

import java.util.Arrays;

public class zzrd implements zzrm {

    /* renamed from: a */
    private final zzra f29220a;

    /* renamed from: b */
    private final int f29221b;

    /* renamed from: c */
    private final int[] f29222c;

    /* renamed from: d */
    private final zzlh[] f29223d;

    /* renamed from: e */
    private final long[] f29224e;

    /* renamed from: f */
    private int f29225f;

    public zzrd(zzra zzra, int... iArr) {
        int i = 0;
        zzsk.m31082b(iArr.length > 0);
        zzsk.m31078a(zzra);
        this.f29220a = zzra;
        this.f29221b = iArr.length;
        this.f29223d = new zzlh[this.f29221b];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f29223d[i2] = zzra.mo32143a(iArr[i2]);
        }
        Arrays.sort(this.f29223d, new C9160Ts());
        this.f29222c = new int[this.f29221b];
        while (true) {
            int i3 = this.f29221b;
            if (i < i3) {
                this.f29222c[i] = zzra.mo32142a(this.f29223d[i]);
                i++;
            } else {
                this.f29224e = new long[i3];
                return;
            }
        }
    }

    /* renamed from: a */
    public final zzra mo32151a() {
        return this.f29220a;
    }

    public final int length() {
        return this.f29222c.length;
    }

    /* renamed from: b */
    public final zzlh mo32152b(int i) {
        return this.f29223d[i];
    }

    /* renamed from: a */
    public final int mo32150a(int i) {
        return this.f29222c[0];
    }

    public int hashCode() {
        if (this.f29225f == 0) {
            this.f29225f = (System.identityHashCode(this.f29220a) * 31) + Arrays.hashCode(this.f29222c);
        }
        return this.f29225f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzrd zzrd = (zzrd) obj;
        if (this.f29220a != zzrd.f29220a || !Arrays.equals(this.f29222c, zzrd.f29222c)) {
            return false;
        }
        return true;
    }
}
