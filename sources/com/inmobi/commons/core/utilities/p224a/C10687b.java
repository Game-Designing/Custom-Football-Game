package com.inmobi.commons.core.utilities.p224a;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.inmobi.commons.core.utilities.a.b */
/* compiled from: RequestEncryptionUtils */
public class C10687b {

    /* renamed from: a */
    private static final String f32611a = C10687b.class.getSimpleName();

    /* renamed from: b */
    private static String f32612b = "AES";

    /* renamed from: c */
    private static String f32613c = "AES/CBC/PKCS7Padding";

    /* renamed from: d */
    private static byte[] f32614d;

    /* renamed from: a */
    public static String m35078a(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, String str2, String str3) {
        try {
            byte[] b = m35087b(str.getBytes("UTF-8"), bArr, bArr2);
            byte[] b2 = m35086b(b, bArr3);
            byte[] a = m35081a(b);
            byte[] a2 = m35081a(b2);
            return new String(Base64.encode(m35083a(m35081a(m35082a(m35083a(m35083a(m35081a(bArr), m35081a(bArr3)), m35081a(bArr2)), str3, str2)), m35083a(a, a2)), 8));
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in generating secret message; ").append(e.getMessage());
            return null;
        }
    }

    @SuppressLint({"TrulyRandom"})
    /* renamed from: b */
    private static byte[] m35087b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f32612b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        try {
            Cipher instance = Cipher.getInstance(f32613c);
            instance.init(1, secretKeySpec, ivParameterSpec);
            instance.init(1, secretKeySpec, ivParameterSpec);
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            new StringBuilder("SDK encountered unexpected error in getting encrypted AES bytes; ").append(th.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m35085b() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128, new SecureRandom());
            SecretKey generateKey = instance.generateKey();
            if (generateKey != null) {
                return generateKey.getEncoded();
            }
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in generating AES public key; ").append(e.getMessage());
        }
        return null;
    }

    /* renamed from: b */
    private static byte[] m35086b(byte[] bArr, byte[] bArr2) {
        String str = "HmacSHA1";
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, 0, bArr2.length, str);
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(secretKeySpec);
            return instance.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m35081a(byte[] bArr) {
        long length = (long) bArr.length;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putLong(length);
        byte[] array = allocate.array();
        byte[] bArr2 = new byte[(array.length + bArr.length)];
        System.arraycopy(array, 0, bArr2, 0, array.length);
        System.arraycopy(bArr, 0, bArr2, array.length, bArr.length);
        return bArr2;
    }

    /* renamed from: a */
    public static byte[] m35082a(byte[] bArr, String str, String str2) {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(str2, 16), new BigInteger(str, 16)));
            Cipher instance = Cipher.getInstance("RSA/ECB/nopadding");
            instance.init(1, rSAPublicKey);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            new StringBuilder("SDK encountered unexpected error in getting encrypted RSA bytes; ").append(th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m35083a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: a */
    public static synchronized byte[] m35079a() {
        byte[] bArr;
        synchronized (C10687b.class) {
            C10686a aVar = new C10686a();
            if ((System.currentTimeMillis() / 1000) - aVar.f32610a.mo34481b("last_generated_ts", 0) > 86400) {
                try {
                    byte[] b = m35085b();
                    f32614d = b;
                    aVar.mo34520a(Base64.encodeToString(b, 0));
                } catch (Exception e) {
                }
            } else if (f32614d == null) {
                try {
                    f32614d = Base64.decode(aVar.f32610a.mo34483c("aes_public_key"), 0);
                } catch (IllegalArgumentException e2) {
                    byte[] b2 = m35085b();
                    f32614d = b2;
                    aVar.mo34520a(Base64.encodeToString(b2, 0));
                }
            }
            bArr = f32614d;
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m35084a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f32612b);
        try {
            Cipher instance = Cipher.getInstance(f32613c);
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            new StringBuilder("SDK encountered unexpected error in decrypting AES response; ").append(th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m35080a(int i) {
        byte[] bArr = new byte[i];
        try {
            new SecureRandom().nextBytes(bArr);
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in generating crypto key; ").append(e.getMessage());
        }
        return bArr;
    }
}
