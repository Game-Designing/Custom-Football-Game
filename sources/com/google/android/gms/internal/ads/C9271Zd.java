package com.google.android.gms.internal.ads;

import java.io.IOException;

@zzard
/* renamed from: com.google.android.gms.internal.ads.Zd */
final class C9271Zd implements zzjp {

    /* renamed from: a */
    private final zzjp f22018a;

    /* renamed from: b */
    private final long f22019b;

    /* renamed from: c */
    private final zzjp f22020c;

    /* renamed from: d */
    private long f22021d;

    C9271Zd(zzjp zzjp, int i, zzjp zzjp2) {
        this.f22018a = zzjp;
        this.f22019b = (long) i;
        this.f22020c = zzjp2;
    }

    /* renamed from: a */
    public final long mo28817a(zzjq zzjq) throws IOException {
        zzjq zzjq2;
        zzjq zzjq3;
        long j;
        long j2;
        long j3;
        zzjq zzjq4 = zzjq;
        long j4 = zzjq4.f28692c;
        long j5 = this.f22019b;
        if (j4 >= j5) {
            zzjq2 = null;
        } else {
            long j6 = zzjq4.f28693d;
            if (j6 != -1) {
                j3 = Math.min(j6, j5 - j4);
            } else {
                j3 = j5 - j4;
            }
            zzjq2 = new zzjq(zzjq4.f28690a, j4, j3, null);
        }
        long j7 = zzjq4.f28693d;
        if (j7 == -1 || zzjq4.f28692c + j7 > this.f22019b) {
            long max = Math.max(this.f22019b, zzjq4.f28692c);
            long j8 = zzjq4.f28693d;
            if (j8 != -1) {
                j2 = Math.min(j8, (zzjq4.f28692c + j8) - this.f22019b);
            } else {
                j2 = -1;
            }
            zzjq3 = new zzjq(zzjq4.f28690a, max, j2, null);
        } else {
            zzjq3 = null;
        }
        long j9 = 0;
        if (zzjq2 != null) {
            j = this.f22018a.mo28817a(zzjq2);
        } else {
            j = 0;
        }
        if (zzjq3 != null) {
            j9 = this.f22020c.mo28817a(zzjq3);
        }
        this.f22021d = zzjq4.f28692c;
        if (j == -1 || j9 == -1) {
            return -1;
        }
        return j + j9;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.f22021d;
        long j2 = this.f22019b;
        if (j < j2) {
            i3 = this.f22018a.read(bArr, i, (int) Math.min((long) i2, j2 - j));
            this.f22021d += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.f22021d < this.f22019b) {
            return i3;
        }
        int read = this.f22020c.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.f22021d += (long) read;
        return i4;
    }

    public final void close() throws IOException {
        this.f22018a.close();
        this.f22020c.close();
    }
}
