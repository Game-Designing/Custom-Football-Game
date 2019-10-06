package com.google.android.gms.internal.ads;

public final class zzsu {

    /* renamed from: a */
    private byte[] f29337a;

    /* renamed from: b */
    private int f29338b;

    /* renamed from: c */
    private int f29339c;

    /* renamed from: d */
    private int f29340d = 0;

    public zzsu(byte[] bArr, int i, int i2) {
        this.f29337a = bArr;
        this.f29339c = i;
        this.f29338b = i2;
        m31128e();
    }

    /* renamed from: b */
    public final void mo32220b(int i) {
        int i2 = this.f29339c;
        this.f29339c = (i / 8) + i2;
        this.f29340d += i % 8;
        int i3 = this.f29340d;
        if (i3 > 7) {
            this.f29339c++;
            this.f29340d = i3 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.f29339c) {
                m31128e();
                return;
            } else if (m31126c(i2)) {
                this.f29339c++;
                i2 += 2;
            }
        }
    }

    /* renamed from: a */
    public final boolean mo32218a() {
        return mo32217a(1) == 1;
    }

    /* renamed from: a */
    public final int mo32217a(int i) {
        byte b;
        byte b2;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        byte b3 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = m31126c(this.f29339c + 1) ? this.f29339c + 2 : this.f29339c + 1;
            int i5 = this.f29340d;
            if (i5 != 0) {
                byte[] bArr = this.f29337a;
                b2 = ((bArr[i4] & 255) >>> (8 - i5)) | ((bArr[this.f29339c] & 255) << i5);
            } else {
                b2 = this.f29337a[this.f29339c];
            }
            i -= 8;
            b3 = b | ((255 & b2) << i);
            this.f29339c = i4;
        }
        if (i > 0) {
            int i6 = this.f29340d + i;
            byte b4 = (byte) (255 >> (8 - i));
            int i7 = m31126c(this.f29339c + 1) ? this.f29339c + 2 : this.f29339c + 1;
            if (i6 > 8) {
                byte[] bArr2 = this.f29337a;
                byte b5 = (b4 & (((255 & bArr2[i7]) >> (16 - i6)) | ((bArr2[this.f29339c] & 255) << (i6 - 8)))) | b;
                this.f29339c = i7;
                b = b5;
            } else {
                byte b6 = (b4 & ((255 & this.f29337a[this.f29339c]) >> (8 - i6))) | b;
                if (i6 == 8) {
                    this.f29339c = i7;
                }
                b = b6;
            }
            this.f29340d = i6 % 8;
        }
        m31128e();
        return b;
    }

    /* renamed from: b */
    public final int mo32219b() {
        return m31127d();
    }

    /* renamed from: c */
    public final int mo32221c() {
        int d = m31127d();
        return (d % 2 == 0 ? -1 : 1) * ((d + 1) / 2);
    }

    /* renamed from: d */
    private final int m31127d() {
        int i = 0;
        int i2 = 0;
        while (!mo32218a()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = mo32217a(i2);
        }
        return i3 + i;
    }

    /* renamed from: c */
    private final boolean m31126c(int i) {
        if (2 <= i && i < this.f29338b) {
            byte[] bArr = this.f29337a;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private final void m31128e() {
        boolean z;
        int i = this.f29339c;
        if (i >= 0) {
            int i2 = this.f29340d;
            if (i2 >= 0 && i2 < 8) {
                int i3 = this.f29338b;
                if (i < i3 || (i == i3 && i2 == 0)) {
                    z = true;
                    zzsk.m31082b(z);
                }
            }
        }
        z = false;
        zzsk.m31082b(z);
    }
}
