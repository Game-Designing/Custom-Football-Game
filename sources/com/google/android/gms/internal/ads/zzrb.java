package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzrb {

    /* renamed from: a */
    public static final zzrb f29215a = new zzrb(new zzra[0]);

    /* renamed from: b */
    public final int f29216b;

    /* renamed from: c */
    private final zzra[] f29217c;

    /* renamed from: d */
    private int f29218d;

    public zzrb(zzra... zzraArr) {
        this.f29217c = zzraArr;
        this.f29216b = zzraArr.length;
    }

    /* renamed from: a */
    public final zzra mo32147a(int i) {
        return this.f29217c[i];
    }

    /* renamed from: a */
    public final int mo32146a(zzra zzra) {
        for (int i = 0; i < this.f29216b; i++) {
            if (this.f29217c[i] == zzra) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.f29218d == 0) {
            this.f29218d = Arrays.hashCode(this.f29217c);
        }
        return this.f29218d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzrb.class != obj.getClass()) {
            return false;
        }
        zzrb zzrb = (zzrb) obj;
        if (this.f29216b != zzrb.f29216b || !Arrays.equals(this.f29217c, zzrb.f29217c)) {
            return false;
        }
        return true;
    }
}
