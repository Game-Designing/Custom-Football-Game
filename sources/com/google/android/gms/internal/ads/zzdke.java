package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class zzdke {

    /* renamed from: a */
    private ECPublicKey f27923a;

    public zzdke(ECPublicKey eCPublicKey) {
        this.f27923a = eCPublicKey;
    }

    /* renamed from: a */
    public final zzdkf mo31522a(String str, byte[] bArr, byte[] bArr2, int i, zzdkv zzdkv) throws GeneralSecurityException {
        byte[] bArr3;
        KeyPair a = zzdkr.m29600a(this.f27923a.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) a.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) a.getPrivate();
        ECPublicKey eCPublicKey2 = this.f27923a;
        try {
            ECParameterSpec params = eCPublicKey2.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            if (!params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            byte[] a2 = zzdkr.m29607a(eCPrivateKey, eCPublicKey2.getW());
            EllipticCurve curve = eCPublicKey.getParams().getCurve();
            ECPoint w = eCPublicKey.getW();
            zzdkr.m29606a(w, curve);
            int a3 = zzdkr.m29599a(curve);
            int i2 = C9345bo.f22129a[zzdkv.ordinal()];
            int i3 = 1;
            if (i2 == 1) {
                int i4 = (a3 * 2) + 1;
                bArr3 = new byte[i4];
                byte[] byteArray = w.getAffineX().toByteArray();
                byte[] byteArray2 = w.getAffineY().toByteArray();
                System.arraycopy(byteArray2, 0, bArr3, i4 - byteArray2.length, byteArray2.length);
                System.arraycopy(byteArray, 0, bArr3, (a3 + 1) - byteArray.length, byteArray.length);
                bArr3[0] = 4;
            } else if (i2 != 2) {
                int i5 = 3;
                if (i2 == 3) {
                    int i6 = a3 + 1;
                    byte[] bArr4 = new byte[i6];
                    byte[] byteArray3 = w.getAffineX().toByteArray();
                    System.arraycopy(byteArray3, 0, bArr4, i6 - byteArray3.length, byteArray3.length);
                    if (!w.getAffineY().testBit(0)) {
                        i5 = 2;
                    }
                    bArr4[0] = (byte) i5;
                    bArr3 = bArr4;
                } else {
                    String valueOf = String.valueOf(zzdkv);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
                    sb.append("invalid format:");
                    sb.append(valueOf);
                    throw new GeneralSecurityException(sb.toString());
                }
            } else {
                int i7 = a3 * 2;
                bArr3 = new byte[i7];
                byte[] byteArray4 = w.getAffineX().toByteArray();
                if (byteArray4.length > a3) {
                    byteArray4 = Arrays.copyOfRange(byteArray4, byteArray4.length - a3, byteArray4.length);
                }
                byte[] byteArray5 = w.getAffineY().toByteArray();
                if (byteArray5.length > a3) {
                    byteArray5 = Arrays.copyOfRange(byteArray5, byteArray5.length - a3, byteArray5.length);
                }
                System.arraycopy(byteArray5, 0, bArr3, i7 - byteArray5.length, byteArray5.length);
                System.arraycopy(byteArray4, 0, bArr3, a3 - byteArray4.length, byteArray4.length);
            }
            byte[] a4 = zzdjs.m29590a(bArr3, a2);
            Mac mac = (Mac) zzdkx.f27943d.mo31525a(str);
            if (i <= mac.getMacLength() * 255) {
                if (bArr == null || bArr.length == 0) {
                    mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
                } else {
                    mac.init(new SecretKeySpec(bArr, str));
                }
                byte[] doFinal = mac.doFinal(a4);
                byte[] bArr5 = new byte[i];
                mac.init(new SecretKeySpec(doFinal, str));
                byte[] bArr6 = new byte[0];
                int i8 = 0;
                while (true) {
                    mac.update(bArr6);
                    mac.update(bArr2);
                    mac.update((byte) i3);
                    bArr6 = mac.doFinal();
                    if (bArr6.length + i8 < i) {
                        System.arraycopy(bArr6, 0, bArr5, i8, bArr6.length);
                        i8 += bArr6.length;
                        i3++;
                    } else {
                        System.arraycopy(bArr6, 0, bArr5, i8, i - i8);
                        return new zzdkf(bArr3, bArr5);
                    }
                }
            } else {
                throw new GeneralSecurityException("size too large");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e.toString());
        }
    }
}
