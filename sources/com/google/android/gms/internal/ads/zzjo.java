package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzjo implements zzjp {

    /* renamed from: a */
    private final byte[] f28687a;

    /* renamed from: b */
    private int f28688b;

    /* renamed from: c */
    private int f28689c;

    public zzjo(byte[] bArr) {
        zzkh.m30534a(bArr);
        zzkh.m30535a(bArr.length > 0);
        this.f28687a = bArr;
    }

    /* renamed from: a */
    public final long mo28817a(zzjq zzjq) throws IOException {
        long j = zzjq.f28692c;
        this.f28688b = (int) j;
        long j2 = zzjq.f28693d;
        if (j2 == -1) {
            j2 = ((long) this.f28687a.length) - j;
        }
        this.f28689c = (int) j2;
        int i = this.f28689c;
        if (i > 0 && this.f28688b + i <= this.f28687a.length) {
            return (long) i;
        }
        int i2 = this.f28688b;
        long j3 = zzjq.f28693d;
        int length = this.f28687a.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i2);
        sb.append(", ");
        sb.append(j3);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }

    public final void close() throws IOException {
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f28689c;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.f28687a, this.f28688b, bArr, i, min);
        this.f28688b += min;
        this.f28689c -= min;
        return min;
    }
}
