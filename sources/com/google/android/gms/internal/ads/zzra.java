package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzra {

    /* renamed from: a */
    public final int f29212a;

    /* renamed from: b */
    private final zzlh[] f29213b;

    /* renamed from: c */
    private int f29214c;

    public zzra(zzlh... zzlhArr) {
        zzsk.m31082b(zzlhArr.length > 0);
        this.f29213b = zzlhArr;
        this.f29212a = zzlhArr.length;
    }

    /* renamed from: a */
    public final zzlh mo32143a(int i) {
        return this.f29213b[i];
    }

    /* renamed from: a */
    public final int mo32142a(zzlh zzlh) {
        int i = 0;
        while (true) {
            zzlh[] zzlhArr = this.f29213b;
            if (i >= zzlhArr.length) {
                return -1;
            }
            if (zzlh == zzlhArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final int hashCode() {
        if (this.f29214c == 0) {
            this.f29214c = Arrays.hashCode(this.f29213b) + 527;
        }
        return this.f29214c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzra.class != obj.getClass()) {
            return false;
        }
        zzra zzra = (zzra) obj;
        if (this.f29212a != zzra.f29212a || !Arrays.equals(this.f29213b, zzra.f29213b)) {
            return false;
        }
        return true;
    }
}
