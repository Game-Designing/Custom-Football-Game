package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

@zzard
/* renamed from: com.google.android.gms.internal.ads.se */
final class C9706se implements zzrv {

    /* renamed from: a */
    private final zzrv f22951a;

    /* renamed from: b */
    private final long f22952b;

    /* renamed from: c */
    private final zzrv f22953c;

    /* renamed from: d */
    private long f22954d;

    /* renamed from: e */
    private Uri f22955e;

    C9706se(zzrv zzrv, int i, zzrv zzrv2) {
        this.f22951a = zzrv;
        this.f22952b = (long) i;
        this.f22953c = zzrv2;
    }

    /* renamed from: a */
    public final long mo29017a(zzry zzry) throws IOException {
        zzry zzry2;
        zzry zzry3;
        long j;
        long j2;
        long j3;
        zzry zzry4 = zzry;
        this.f22955e = zzry4.f29268a;
        long j4 = zzry4.f29271d;
        long j5 = this.f22952b;
        if (j4 >= j5) {
            zzry2 = null;
        } else {
            long j6 = zzry4.f29272e;
            if (j6 != -1) {
                j3 = Math.min(j6, j5 - j4);
            } else {
                j3 = j5 - j4;
            }
            zzry2 = new zzry(zzry4.f29268a, j4, j3, null);
        }
        long j7 = zzry4.f29272e;
        if (j7 == -1 || zzry4.f29271d + j7 > this.f22952b) {
            long max = Math.max(this.f22952b, zzry4.f29271d);
            long j8 = zzry4.f29272e;
            if (j8 != -1) {
                j2 = Math.min(j8, (zzry4.f29271d + j8) - this.f22952b);
            } else {
                j2 = -1;
            }
            zzry3 = new zzry(zzry4.f29268a, max, j2, null);
        } else {
            zzry3 = null;
        }
        long j9 = 0;
        if (zzry2 != null) {
            j = this.f22951a.mo29017a(zzry2);
        } else {
            j = 0;
        }
        if (zzry3 != null) {
            j9 = this.f22953c.mo29017a(zzry3);
        }
        this.f22954d = zzry4.f29271d;
        if (j == -1 || j9 == -1) {
            return -1;
        }
        return j + j9;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.f22954d;
        long j2 = this.f22952b;
        if (j < j2) {
            i3 = this.f22951a.read(bArr, i, (int) Math.min((long) i2, j2 - j));
            this.f22954d += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.f22954d < this.f22952b) {
            return i3;
        }
        int read = this.f22953c.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.f22954d += (long) read;
        return i4;
    }

    public final Uri getUri() {
        return this.f22955e;
    }

    public final void close() throws IOException {
        this.f22951a.close();
        this.f22953c.close();
    }
}
