package com.flurry.sdk;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec.Builder;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.KeyGenerator;

/* renamed from: com.flurry.sdk.yb */
public class C7627yb {

    /* renamed from: a */
    private static final String f15140a = C7627yb.class.getSimpleName();

    /* renamed from: b */
    private KeyStore f15141b;

    @TargetApi(23)
    public C7627yb() {
        String str = "fl.install.id.sec.key";
        String str2 = "AndroidKeyStore";
        if (VERSION.SDK_INT >= 23) {
            try {
                this.f15141b = KeyStore.getInstance(str2);
                this.f15141b.load(null);
                if (!this.f15141b.containsAlias(str)) {
                    KeyGenerator instance = KeyGenerator.getInstance("AES", str2);
                    instance.init(new Builder(str, 3).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setRandomizedEncryptionRequired(false).setDigests(new String[]{"SHA-256", "SHA-512"}).build());
                    instance.generateKey();
                }
            } catch (IOException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | CertificateException e) {
                String str3 = f15140a;
                StringBuilder sb = new StringBuilder("Error while generating Key");
                sb.append(e.getMessage());
                C7513ec.m16640a(5, str3, sb.toString(), e);
            }
        }
    }

    /* renamed from: a */
    public final Key mo24031a() {
        if (VERSION.SDK_INT < 23) {
            return null;
        }
        KeyStore keyStore = this.f15141b;
        if (keyStore == null) {
            return null;
        }
        try {
            return keyStore.getKey("fl.install.id.sec.key", null);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            C7513ec.m16639a(6, f15140a, "Error in getting key.");
            return null;
        }
    }
}
