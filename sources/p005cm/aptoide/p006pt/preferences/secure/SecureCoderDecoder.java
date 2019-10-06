package p005cm.aptoide.p006pt.preferences.secure;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Base64;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: cm.aptoide.pt.preferences.secure.SecureCoderDecoder */
public class SecureCoderDecoder {
    private static final String AES_KEY_ALG = "AES";
    private static final String BACKUP_PBE_KEY_ALG = "PBEWithMD5AndDES";
    private static final int ITERATIONS = 2000;
    private static final int KEY_SIZE = 256;
    private static final String PRIMARY_PBE_KEY_ALG = "PBKDF2WithHmacSHA1";
    private static final String PROVIDER = "BC";
    private static final String TAG = SecureCoderDecoder.class.getSimpleName();
    private byte[] sKey;

    /* renamed from: cm.aptoide.pt.preferences.secure.SecureCoderDecoder$Builder */
    public static class Builder {
        private Context context;
        private SharedPreferences defaultSharedPreferences;

        public Builder(Context context2, SharedPreferences defaultSharedPreferences2) {
            this.context = context2;
            this.defaultSharedPreferences = defaultSharedPreferences2;
        }

        public SecureCoderDecoder create() {
            try {
                String key = SecureCoderDecoder.generateAesKeyName(this.context);
                String value = this.defaultSharedPreferences.getString(key, null);
                if (value == null) {
                    value = SecureCoderDecoder.generateAesKeyValue();
                    this.defaultSharedPreferences.edit().putString(key, value).commit();
                }
                return new SecureCoderDecoder(SecureCoderDecoder.decode(value));
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public SecureCoderDecoder(byte[] sKey2) {
        this.sKey = sKey2;
    }

    static String generateAesKeyName(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {
        SecretKey key;
        char[] password = context.getPackageName().toCharArray();
        byte[] salt = getDeviceSerialNumber(context).getBytes();
        try {
            key = generatePBEKey(password, salt, PRIMARY_PBE_KEY_ALG, ITERATIONS, 256);
        } catch (NoSuchAlgorithmException e) {
            key = generatePBEKey(password, salt, BACKUP_PBE_KEY_ALG, ITERATIONS, 256);
        }
        return encode(key.getEncoded());
    }

    static String getDeviceSerialNumber(Context context) {
        String str = "android_id";
        try {
            String deviceSerial = (String) Build.class.getField("SERIAL").get(null);
            if (TextUtils.isEmpty(deviceSerial)) {
                deviceSerial = Secure.getString(context.getContentResolver(), str);
            }
            return deviceSerial;
        } catch (Exception e) {
            return Secure.getString(context.getContentResolver(), str);
        }
    }

    static SecretKey generatePBEKey(char[] passphraseOrPin, byte[] salt, String algorthm, int iterations, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        if (iterations == 0) {
            iterations = 1000;
        }
        return SecretKeyFactory.getInstance(algorthm, PROVIDER).generateSecret(new PBEKeySpec(passphraseOrPin, salt, iterations, keyLength));
    }

    private static String encode(byte[] input) {
        return Base64.encodeToString(input, 3);
    }

    static String generateAesKeyValue() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        KeyGenerator generator = KeyGenerator.getInstance(AES_KEY_ALG);
        try {
            generator.init(256, random);
        } catch (Exception e) {
            try {
                generator.init(Opcodes.CHECKCAST, random);
            } catch (Exception e2) {
                generator.init(128, random);
            }
        }
        return encode(generator.generateKey().getEncoded());
    }

    static byte[] decode(String input) {
        return Base64.decode(input, 3);
    }

    public String decrypt(String ciphertext) {
        String str = AES_KEY_ALG;
        if (ciphertext == null || ciphertext.length() == 0) {
            return ciphertext;
        }
        try {
            Cipher cipher = Cipher.getInstance(str, PROVIDER);
            cipher.init(2, new SecretKeySpec(this.sKey, str));
            return new String(cipher.doFinal(decode(ciphertext)), "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

    public String encrypt(String cleartext) {
        String str = AES_KEY_ALG;
        if (cleartext == null || cleartext.length() == 0) {
            return cleartext;
        }
        try {
            Cipher cipher = Cipher.getInstance(str, PROVIDER);
            cipher.init(1, new SecretKeySpec(this.sKey, str));
            return encode(cipher.doFinal(cleartext.getBytes("UTF-8")));
        } catch (Exception e) {
            return null;
        }
    }
}
