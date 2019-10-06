package com.inmobi.commons.core.utilities.p224a;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

/* renamed from: com.inmobi.commons.core.utilities.a.c */
/* compiled from: UidEncryptionUtils */
public class C10688c {

    /* renamed from: a */
    private static final String f32615a = C10688c.class.getSimpleName();

    @SuppressLint({"TrulyRandom"})
    /* renamed from: a */
    public static String m35088a(String str) {
        String str2 = null;
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger("C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B", 16), new BigInteger("010001", 16)));
            Cipher instance = Cipher.getInstance("RSA/ECB/nopadding");
            instance.init(1, rSAPublicKey);
            str2 = new String(Base64.encode(m35089a(str.getBytes("UTF-8"), instance), 0));
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in getting encrypted UID-map; ").append(e.getMessage());
        }
        return str2;
    }

    /* renamed from: a */
    private static byte[] m35089a(byte[] bArr, Cipher cipher) throws IllegalBlockSizeException, BadPaddingException {
        int i;
        byte[] bArr2 = new byte[0];
        int length = bArr.length;
        byte[] bArr3 = new byte[64];
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 > 0 && i2 % 64 == 0) {
                bArr2 = m35090a(bArr2, cipher.doFinal(bArr3));
                if (i2 + 64 > length) {
                    i = length - i2;
                } else {
                    i = 64;
                }
                bArr3 = new byte[i];
            }
            bArr3[i2 % 64] = bArr[i2];
        }
        return m35090a(bArr2, cipher.doFinal(bArr3));
    }

    /* renamed from: a */
    private static byte[] m35090a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }
}
