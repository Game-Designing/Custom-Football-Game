package p019d.p273h.p276c.p284h;

import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p278b.C12784h;

/* renamed from: d.h.c.h.i */
/* compiled from: IronSourceAES */
public class C12915i {

    /* renamed from: a */
    private static boolean f39674a = false;

    /* renamed from: b */
    public static synchronized String m41954b(String keyString, String stringToEncode) {
        synchronized (C12915i.class) {
            if (TextUtils.isEmpty(keyString)) {
                String str = "";
                return str;
            } else if (TextUtils.isEmpty(stringToEncode)) {
                String str2 = "";
                return str2;
            } else {
                try {
                    SecretKeySpec skeySpec = m41953a(keyString);
                    byte[] clearText = stringToEncode.getBytes("UTF8");
                    byte[] iv = new byte[16];
                    Arrays.fill(iv, 0);
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    cipher.init(1, skeySpec, ivParameterSpec);
                    String encrypedValue = Base64.encodeToString(cipher.doFinal(clearText), 0).replaceAll(System.getProperty("line.separator"), "");
                    return encrypedValue;
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized String m41952a(String keyString, String stringToDecode) {
        synchronized (C12915i.class) {
            if (TextUtils.isEmpty(keyString)) {
                String str = "";
                return str;
            } else if (TextUtils.isEmpty(stringToDecode)) {
                String str2 = "";
                return str2;
            } else {
                try {
                    SecretKey key = m41953a(keyString);
                    byte[] iv = new byte[16];
                    Arrays.fill(iv, 0);
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
                    byte[] encrypedPwdBytes = Base64.decode(stringToDecode, 0);
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    cipher.init(2, key, ivParameterSpec);
                    String decrypedValue = new String(cipher.doFinal(encrypedPwdBytes));
                    return decrypedValue;
                } catch (Exception e) {
                    e.printStackTrace();
                    if (!f39674a) {
                        f39674a = true;
                        JSONObject data = C12916j.m41965a(false);
                        try {
                            data.put("status", AdultContentAnalytics.UNLOCK);
                            data.put("reason", 1);
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                        C12784h.m41502g().mo41351a(new C12733b(114, data), "https://outcome-ssp.supersonicads.com/mediation?adUnit=2");
                    }
                    return "";
                }
            }
        }
    }

    /* renamed from: a */
    private static SecretKeySpec m41953a(String key) throws UnsupportedEncodingException {
        byte[] keyBytes = new byte[(Opcodes.ACC_NATIVE / 8)];
        Arrays.fill(keyBytes, 0);
        byte[] passwordBytes = key.getBytes("UTF-8");
        System.arraycopy(passwordBytes, 0, keyBytes, 0, passwordBytes.length < keyBytes.length ? passwordBytes.length : keyBytes.length);
        return new SecretKeySpec(keyBytes, "AES");
    }
}
