package p030a.p031a.p032a.p033a;

import adyen.com.adyencse.encrypter.exception.EncrypterException;
import android.util.Base64;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: a.a.a.a.a */
/* compiled from: ClientSideEncrypter */
public class C0138a {

    /* renamed from: a */
    private PublicKey f166a;

    /* renamed from: b */
    private Cipher f167b;

    /* renamed from: c */
    private Cipher f168c;

    /* renamed from: d */
    private SecureRandom f169d = new SecureRandom();

    public C0138a(String publicKeyString) throws EncrypterException {
        C0139b.m783b();
        String[] keyComponents = publicKeyString.split("\\|");
        try {
            try {
                this.f166a = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(keyComponents[1].toLowerCase(Locale.getDefault()), 16), new BigInteger(keyComponents[0].toLowerCase(Locale.getDefault()), 16)));
                try {
                    this.f167b = Cipher.getInstance("AES/CCM/NoPadding", "BC");
                } catch (NoSuchAlgorithmException e) {
                    throw new EncrypterException("Problem instantiation AES Cipher Algorithm", e);
                } catch (NoSuchPaddingException e2) {
                    throw new EncrypterException("Problem instantiation AES Cipher Padding", e2);
                } catch (NoSuchProviderException e3) {
                    e3.printStackTrace();
                }
                try {
                    this.f168c = Cipher.getInstance("RSA/None/PKCS1Padding");
                    this.f168c.init(1, this.f166a);
                } catch (NoSuchAlgorithmException e4) {
                    throw new EncrypterException("Problem instantiation RSA Cipher Algorithm", e4);
                } catch (NoSuchPaddingException e5) {
                    throw new EncrypterException("Problem instantiation RSA Cipher Padding", e5);
                } catch (InvalidKeyException e6) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid public key: ");
                    sb.append(publicKeyString);
                    throw new EncrypterException(sb.toString(), e6);
                }
            } catch (InvalidKeySpecException e7) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Problem reading public key: ");
                sb2.append(publicKeyString);
                throw new EncrypterException(sb2.toString(), e7);
            }
        } catch (NoSuchAlgorithmException e8) {
            e8.printStackTrace();
        }
    }

    /* renamed from: a */
    public String mo3720a(String plainText) throws EncrypterException {
        String str = "$";
        SecretKey aesKey = m779a((int) Opcodes.ACC_NATIVE);
        byte[] iv = m780b(12);
        try {
            this.f167b.init(1, aesKey, new IvParameterSpec(iv));
            byte[] encrypted = this.f167b.doFinal(plainText.getBytes());
            byte[] result = new byte[(iv.length + encrypted.length)];
            System.arraycopy(iv, 0, result, 0, iv.length);
            System.arraycopy(encrypted, 0, result, iv.length, encrypted.length);
            try {
                return String.format("%s%s%s%s%s%s", new Object[]{"adyenan", "0_1_1", str, Base64.encodeToString(this.f168c.doFinal(aesKey.getEncoded()), 2), str, Base64.encodeToString(result, 2)});
            } catch (IllegalBlockSizeException e) {
                throw new EncrypterException("Incorrect RSA Block Size", e);
            } catch (BadPaddingException e2) {
                throw new EncrypterException("Incorrect RSA Padding", e2);
            }
        } catch (IllegalBlockSizeException e3) {
            throw new EncrypterException("Incorrect AES Block Size", e3);
        } catch (BadPaddingException e4) {
            throw new EncrypterException("Incorrect AES Padding", e4);
        } catch (InvalidKeyException e5) {
            throw new EncrypterException("Invalid AES Key", e5);
        } catch (InvalidAlgorithmParameterException e6) {
            throw new EncrypterException("Invalid AES Parameters", e6);
        }
    }

    /* renamed from: a */
    private SecretKey m779a(int keySize) throws EncrypterException {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(keySize);
            return kgen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new EncrypterException("Unable to get AES algorithm", e);
        }
    }

    /* renamed from: b */
    private synchronized byte[] m780b(int ivSize) {
        byte[] iv;
        iv = new byte[ivSize];
        this.f169d.nextBytes(iv);
        return iv;
    }
}
