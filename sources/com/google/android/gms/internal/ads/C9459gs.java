package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.gs */
final class C9459gs {

    /* renamed from: a */
    private static final long[] f22386a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b */
    private final byte[] f22387b = new byte[8];

    /* renamed from: c */
    private int f22388c;

    /* renamed from: d */
    private int f22389d;

    /* renamed from: a */
    public final void mo28980a() {
        this.f22388c = 0;
        this.f22389d = 0;
    }

    /* renamed from: a */
    public final long mo28979a(zzno zzno, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.f22388c == 0) {
            if (!zzno.mo32047a(this.f22387b, 0, 1, z)) {
                return -1;
            }
            this.f22389d = m23656a(this.f22387b[0] & 255);
            if (this.f22389d != -1) {
                this.f22388c = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.f22389d;
        if (i2 > i) {
            this.f22388c = 0;
            return -2;
        }
        if (i2 != 1) {
            zzno.readFully(this.f22387b, 1, i2 - 1);
        }
        this.f22388c = 0;
        return m23657a(this.f22387b, this.f22389d, z2);
    }

    /* renamed from: b */
    public final int mo28981b() {
        return this.f22389d;
    }

    /* renamed from: a */
    public static int m23656a(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = f22386a;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    /* renamed from: a */
    public static long m23657a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= f22386a[i - 1] ^ -1;
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }
}
