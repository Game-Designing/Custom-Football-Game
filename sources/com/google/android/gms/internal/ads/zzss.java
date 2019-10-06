package com.google.android.gms.internal.ads;

public final class zzss {

    /* renamed from: a */
    private byte[] f29330a;

    /* renamed from: b */
    private int f29331b;

    /* renamed from: c */
    private int f29332c;

    /* renamed from: d */
    private int f29333d;

    public zzss() {
    }

    public zzss(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzss(byte[] bArr, int i) {
        this.f29330a = bArr;
        this.f29333d = i;
    }

    /* renamed from: a */
    public final int mo32193a(int i) {
        byte b;
        byte b2;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        int i3 = i;
        byte b3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.f29332c;
            if (i5 != 0) {
                byte[] bArr = this.f29330a;
                int i6 = this.f29331b;
                b2 = ((bArr[i6 + 1] & 255) >>> (8 - i5)) | ((bArr[i6] & 255) << i5);
            } else {
                b2 = this.f29330a[this.f29331b];
            }
            i3 -= 8;
            b3 = b | ((255 & b2) << i3);
            this.f29331b++;
        }
        if (i3 > 0) {
            int i7 = this.f29332c + i3;
            byte b4 = (byte) (255 >> (8 - i3));
            if (i7 > 8) {
                byte[] bArr2 = this.f29330a;
                int i8 = this.f29331b;
                byte b5 = (b4 & (((bArr2[i8 + 1] & 255) >> (16 - i7)) | ((bArr2[i8] & 255) << (i7 - 8)))) | b;
                this.f29331b = i8 + 1;
                b = b5;
            } else {
                byte[] bArr3 = this.f29330a;
                int i9 = this.f29331b;
                byte b6 = (b4 & ((bArr3[i9] & 255) >> (8 - i7))) | b;
                if (i7 == 8) {
                    this.f29331b = i9 + 1;
                }
                b = b6;
            }
            this.f29332c = i7 % 8;
        }
        int i10 = this.f29331b;
        if (i10 >= 0) {
            int i11 = this.f29332c;
            if (i11 >= 0 && i11 < 8) {
                int i12 = this.f29333d;
                if (i10 < i12 || (i10 == i12 && i11 == 0)) {
                    z = true;
                }
            }
        }
        zzsk.m31082b(z);
        return b;
    }
}
