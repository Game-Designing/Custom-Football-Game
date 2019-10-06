package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.fs */
final class C9437fs {

    /* renamed from: a */
    private final zzst f22358a = new zzst(8);

    /* renamed from: b */
    private int f22359b;

    /* renamed from: a */
    public final boolean mo28955a(zzno zzno) throws IOException, InterruptedException {
        zzno zzno2 = zzno;
        long length = zzno.getLength();
        long j = 1024;
        if (length != -1 && length <= 1024) {
            j = length;
        }
        int i = (int) j;
        zzno2.mo32046a(this.f22358a.f29334a, 0, 4);
        this.f22359b = 4;
        for (long j2 = this.f22358a.mo32210j(); j2 != 440786851; j2 = ((j2 << 8) & -256) | ((long) (this.f22358a.f29334a[0] & 255))) {
            int i2 = this.f22359b + 1;
            this.f22359b = i2;
            if (i2 == i) {
                return false;
            }
            zzno2.mo32046a(this.f22358a.f29334a, 0, 1);
        }
        long b = m23621b(zzno);
        long j3 = (long) this.f22359b;
        if (b == Long.MIN_VALUE || (length != -1 && j3 + b >= length)) {
            return false;
        }
        while (true) {
            int i3 = this.f22359b;
            long j4 = j3 + b;
            if (((long) i3) < j4) {
                if (m23621b(zzno) == Long.MIN_VALUE) {
                    return false;
                }
                long b2 = m23621b(zzno);
                if (b2 < 0 || b2 > 2147483647L) {
                    return false;
                }
                if (b2 != 0) {
                    zzno2.mo32049c((int) b2);
                    this.f22359b = (int) (((long) this.f22359b) + b2);
                }
            } else if (((long) i3) == j4) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    private final long m23621b(zzno zzno) throws IOException, InterruptedException {
        int i = 0;
        zzno.mo32046a(this.f22358a.f29334a, 0, 1);
        byte b = this.f22358a.f29334a[0] & 255;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (i2 ^ -1);
        zzno.mo32046a(this.f22358a.f29334a, 1, i3);
        while (i < i3) {
            i++;
            i4 = (this.f22358a.f29334a[i] & 255) + (i4 << 8);
        }
        this.f22359b += i3 + 1;
        return (long) i4;
    }
}
