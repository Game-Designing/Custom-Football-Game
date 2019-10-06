package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzkk {

    /* renamed from: a */
    private int f28741a;

    /* renamed from: b */
    private long[] f28742b;

    public zzkk() {
        this(32);
    }

    private zzkk(int i) {
        this.f28742b = new long[32];
    }

    /* renamed from: a */
    public final void mo31888a(long j) {
        int i = this.f28741a;
        long[] jArr = this.f28742b;
        if (i == jArr.length) {
            this.f28742b = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.f28742b;
        int i2 = this.f28741a;
        this.f28741a = i2 + 1;
        jArr2[i2] = j;
    }

    /* renamed from: a */
    public final long mo31887a(int i) {
        if (i >= 0 && i < this.f28741a) {
            return this.f28742b[i];
        }
        int i2 = this.f28741a;
        StringBuilder sb = new StringBuilder(45);
        sb.append("Invalid size ");
        sb.append(i);
        sb.append(", size is ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* renamed from: a */
    public final int mo31886a() {
        return this.f28741a;
    }
}
