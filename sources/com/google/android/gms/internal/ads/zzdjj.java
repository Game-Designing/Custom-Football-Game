package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdjj implements zzdlk {

    /* renamed from: a */
    private final SecretKeySpec f27900a;

    /* renamed from: b */
    private final int f27901b;

    /* renamed from: c */
    private final int f27902c = ((Cipher) zzdkx.f27942c.mo31525a("AES/CTR/NoPadding")).getBlockSize();

    public zzdjj(byte[] bArr, int i) throws GeneralSecurityException {
        zzdlx.m29630a(bArr.length);
        this.f27900a = new SecretKeySpec(bArr, "AES");
        if (i < 12 || i > this.f27902c) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f27901b = i;
    }

    /* renamed from: a */
    public final byte[] mo28835a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.f27901b;
        if (length <= MoPubClientPositioning.NO_REPEAT - i) {
            byte[] bArr2 = new byte[(bArr.length + i)];
            byte[] a = zzdlo.m29627a(i);
            System.arraycopy(a, 0, bArr2, 0, this.f27901b);
            int length2 = bArr.length;
            int i2 = this.f27901b;
            Cipher cipher = (Cipher) zzdkx.f27942c.mo31525a("AES/CTR/NoPadding");
            byte[] bArr3 = new byte[this.f27902c];
            System.arraycopy(a, 0, bArr3, 0, this.f27901b);
            cipher.init(1, this.f27900a, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length2, bArr2, i2) == length2) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        int i3 = MoPubClientPositioning.NO_REPEAT - i;
        StringBuilder sb = new StringBuilder(43);
        sb.append("plaintext length can not exceed ");
        sb.append(i3);
        throw new GeneralSecurityException(sb.toString());
    }
}
