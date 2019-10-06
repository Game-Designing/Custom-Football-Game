package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.qr */
final class C9677qr {

    /* renamed from: a */
    private static final int[] f22915a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b */
    private final byte[] f22916b = new byte[8];

    /* renamed from: c */
    private int f22917c;

    /* renamed from: d */
    private int f22918d;

    /* renamed from: a */
    public final void mo29147a() {
        this.f22917c = 0;
        this.f22918d = 0;
    }

    /* renamed from: a */
    public final long mo29146a(zzie zzie, boolean z, boolean z2) throws IOException, InterruptedException {
        if (this.f22917c == 0) {
            if (!zzie.mo31841a(this.f22916b, 0, 1, z)) {
                return -1;
            }
            byte b = this.f22916b[0] & 255;
            this.f22918d = -1;
            int i = 0;
            while (true) {
                int[] iArr = f22915a;
                if (i >= iArr.length) {
                    break;
                } else if ((iArr[i] & b) != 0) {
                    this.f22918d = i + 1;
                    break;
                } else {
                    i++;
                }
            }
            if (this.f22918d != -1) {
                this.f22917c = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        zzie.readFully(this.f22916b, 1, this.f22918d - 1);
        if (z2) {
            byte[] bArr = this.f22916b;
            bArr[0] = (byte) (bArr[0] & (f22915a[this.f22918d - 1] ^ -1));
        }
        long j = 0;
        for (int i2 = 0; i2 < this.f22918d; i2++) {
            j = (j << 8) | ((long) (this.f22916b[i2] & 255));
        }
        this.f22917c = 0;
        return j;
    }

    /* renamed from: b */
    public final int mo29148b() {
        return this.f22918d;
    }
}
