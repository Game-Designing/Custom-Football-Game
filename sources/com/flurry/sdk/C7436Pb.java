package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.flurry.sdk.Pb */
public class C7436Pb<ObjectType> {

    /* renamed from: a */
    private static final String f14594a = C7436Pb.class.getSimpleName();

    /* renamed from: b */
    private C7493ad<ObjectType> f14595b;

    /* renamed from: com.flurry.sdk.Pb$a */
    public enum C7437a {
        NONE(""),
        CRYPTO_ALGO_PADDING_7("AES/CBC/PKCS7Padding"),
        CRYPTO_ALGO_PADDING_5("AES/CBC/PKCS5Padding");
        

        /* renamed from: e */
        String f14600e;

        private C7437a(String str) {
            this.f14600e = str;
        }

        /* renamed from: a */
        public static C7437a m16450a(int i) {
            C7437a[] values;
            for (C7437a aVar : values()) {
                if (aVar.ordinal() == i) {
                    return aVar;
                }
            }
            return NONE;
        }
    }

    public C7436Pb(C7493ad<ObjectType> adVar) {
        this.f14595b = adVar;
    }

    /* renamed from: a */
    public final byte[] mo23879a(ObjectType objecttype, Key key, IvParameterSpec ivParameterSpec, C7437a aVar) throws IOException {
        if (objecttype == null || key == null || aVar == null) {
            C7513ec.m16639a(5, f14594a, "Cannot encrypt, invalid params.");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f14595b.mo23856a(byteArrayOutputStream, objecttype);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            Cipher instance = Cipher.getInstance(aVar.f14600e);
            instance.init(1, key, ivParameterSpec);
            return instance.doFinal(byteArray);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            String str = f14594a;
            StringBuilder sb = new StringBuilder("Error in encrypt ");
            sb.append(e.getMessage());
            C7513ec.m16639a(5, str, sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    public final ObjectType mo23878a(byte[] bArr, Key key, IvParameterSpec ivParameterSpec, C7437a aVar) throws IOException {
        if (bArr == null || key == null || aVar == null) {
            C7513ec.m16639a(5, f14594a, "Cannot decrypt, invalid params.");
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance(aVar.f14600e);
            instance.init(2, key, ivParameterSpec);
            return this.f14595b.mo23855a(new ByteArrayInputStream(instance.doFinal(bArr)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            String str = f14594a;
            StringBuilder sb = new StringBuilder("Error in decrypt ");
            sb.append(e.getMessage());
            C7513ec.m16639a(5, str, sb.toString());
            return null;
        }
    }
}
