package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public final class zzdjh implements zzdby {

    /* renamed from: a */
    private final SecretKey f27896a;

    /* renamed from: b */
    private final int f27897b;

    /* renamed from: c */
    private byte[] f27898c;

    /* renamed from: d */
    private byte[] f27899d;

    /* renamed from: a */
    private static Cipher m29578a() throws GeneralSecurityException {
        return (Cipher) zzdkx.f27942c.mo31525a("AES/ECB/NoPadding");
    }

    /* renamed from: a */
    public final byte[] mo31381a(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        Cipher a = m29578a();
        a.init(1, this.f27896a);
        double length = (double) bArr.length;
        Double.isNaN(length);
        int max = Math.max(1, (int) Math.ceil(length / 16.0d));
        if ((max << 4) == bArr.length) {
            bArr2 = zzdjs.m29588a(bArr, (max - 1) << 4, this.f27898c, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
            if (copyOfRange.length < 16) {
                byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                copyOf[copyOfRange.length] = Byte.MIN_VALUE;
                bArr2 = zzdjs.m29589a(copyOf, this.f27899d);
            } else {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
        }
        byte[] bArr3 = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr3 = a.doFinal(zzdjs.m29588a(bArr3, 0, bArr, i << 4, 16));
        }
        byte[] bArr4 = new byte[this.f27897b];
        System.arraycopy(a.doFinal(zzdjs.m29589a(bArr2, bArr3)), 0, bArr4, 0, this.f27897b);
        return bArr4;
    }
}
