package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

public final class zzru implements zzrv {

    /* renamed from: a */
    private final byte[] f29263a;

    /* renamed from: b */
    private Uri f29264b;

    /* renamed from: c */
    private int f29265c;

    /* renamed from: d */
    private int f29266d;

    public zzru(byte[] bArr) {
        zzsk.m31078a(bArr);
        zzsk.m31080a(bArr.length > 0);
        this.f29263a = bArr;
    }

    /* renamed from: a */
    public final long mo29017a(zzry zzry) throws IOException {
        this.f29264b = zzry.f29268a;
        long j = zzry.f29271d;
        this.f29265c = (int) j;
        long j2 = zzry.f29272e;
        if (j2 == -1) {
            j2 = ((long) this.f29263a.length) - j;
        }
        this.f29266d = (int) j2;
        int i = this.f29266d;
        if (i > 0 && this.f29265c + i <= this.f29263a.length) {
            return (long) i;
        }
        int i2 = this.f29265c;
        long j3 = zzry.f29272e;
        int length = this.f29263a.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i2);
        sb.append(", ");
        sb.append(j3);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.f29266d;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.f29263a, this.f29265c, bArr, i, min);
        this.f29265c += min;
        this.f29266d -= min;
        return min;
    }

    public final Uri getUri() {
        return this.f29264b;
    }

    public final void close() throws IOException {
        this.f29264b = null;
    }
}
