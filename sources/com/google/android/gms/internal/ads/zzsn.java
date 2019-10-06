package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzsn {

    /* renamed from: a */
    private int f29314a;

    /* renamed from: b */
    private long[] f29315b;

    public zzsn() {
        this(32);
    }

    private zzsn(int i) {
        this.f29315b = new long[32];
    }

    /* renamed from: a */
    public final void mo32192a(long j) {
        int i = this.f29314a;
        long[] jArr = this.f29315b;
        if (i == jArr.length) {
            this.f29315b = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.f29315b;
        int i2 = this.f29314a;
        this.f29314a = i2 + 1;
        jArr2[i2] = j;
    }

    /* renamed from: a */
    public final long mo32191a(int i) {
        if (i >= 0 && i < this.f29314a) {
            return this.f29315b[i];
        }
        int i2 = this.f29314a;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i);
        sb.append(", size is ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* renamed from: a */
    public final int mo32190a() {
        return this.f29314a;
    }
}
