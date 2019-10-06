package com.paypal.android.sdk;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* renamed from: com.paypal.android.sdk.gb */
public final class C11824gb implements C11801da {

    /* renamed from: a */
    private static final String f37215a = C11824gb.class.getSimpleName();

    /* renamed from: b */
    private final String f37216b;

    public C11824gb(String str) {
        this.f37216b = str;
    }

    /* renamed from: a */
    private static String m39146a(Exception exc) {
        Log.e(f37215a, exc.getMessage());
        return null;
    }

    /* renamed from: a */
    public final String mo38712a(String str) {
        String str2 = "DES";
        String str3 = "UTF8";
        if (str == null) {
            return null;
        }
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance(str2).generateSecret(new DESKeySpec(this.f37216b.getBytes(str3)));
            byte[] bytes = str.getBytes(str3);
            Cipher instance = Cipher.getInstance(str2);
            instance.init(1, generateSecret);
            return Base64.encodeToString(instance.doFinal(bytes), 0);
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return m39146a(e);
        }
    }

    /* renamed from: b */
    public final String mo38713b(String str) {
        String str2 = "DES";
        if (str == null) {
            return null;
        }
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance(str2).generateSecret(new DESKeySpec(this.f37216b.getBytes("UTF8")));
            byte[] decode = Base64.decode(str, 0);
            Cipher instance = Cipher.getInstance(str2);
            instance.init(2, generateSecret);
            return new String(instance.doFinal(decode));
        } catch (UnsupportedEncodingException | IllegalArgumentException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return m39146a(e);
        }
    }
}
