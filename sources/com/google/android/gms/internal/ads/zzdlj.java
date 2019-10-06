package com.google.android.gms.internal.ads;

public final class zzdlj {

    /* renamed from: a */
    private final byte[] f27958a;

    /* renamed from: a */
    public static zzdlj m29622a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new zzdlj(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public final byte[] mo31528a() {
        byte[] bArr = this.f27958a;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private zzdlj(byte[] bArr, int i, int i2) {
        this.f27958a = new byte[i2];
        System.arraycopy(bArr, 0, this.f27958a, 0, i2);
    }
}
