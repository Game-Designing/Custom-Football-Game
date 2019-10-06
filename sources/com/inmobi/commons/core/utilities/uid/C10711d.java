package com.inmobi.commons.core.utilities.uid;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.commons.core.utilities.uid.d */
/* compiled from: UidMap */
public class C10711d {

    /* renamed from: a */
    private Map<String, Boolean> f32675a;

    public C10711d(Map<String, Boolean> map) {
        this.f32675a = map;
    }

    /* renamed from: a */
    public final Map<String, String> mo34531a(String str, boolean z) {
        String str2 = "GPID";
        HashMap hashMap = new HashMap();
        String str3 = null;
        try {
            if (((Boolean) this.f32675a.get(str2)).booleanValue()) {
                C10709c.m35160a();
                C10707a f = C10709c.m35165f();
                if (f != null) {
                    str3 = f.f32666a;
                    if (str3 != null) {
                        if (z) {
                            str3 = m35171a(str3, str);
                        }
                        hashMap.put(str2, str3);
                    }
                }
            }
            m35172a(str, z, hashMap, str3);
        } catch (Exception e) {
            C10711d.class.getSimpleName();
            m35172a(str, z, hashMap, null);
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m35172a(String str, boolean z, Map<String, String> map, String str2) {
        String str3 = "O1";
        String str4 = "UM5";
        try {
            if (((Boolean) this.f32675a.get(str4)).booleanValue() && str2 == null) {
                C10709c.m35160a();
                C10709c.m35160a();
                String a = C10709c.m35161a(C10709c.m35164e(), "MD5");
                if (z) {
                    a = m35171a(a, str);
                }
                map.put(str4, a);
            }
            if (((Boolean) this.f32675a.get(str3)).booleanValue() && str2 == null) {
                C10709c.m35160a();
                C10709c.m35160a();
                String a2 = C10709c.m35161a(C10709c.m35164e(), "SHA-1");
                if (z) {
                    a2 = m35171a(a2, str);
                }
                map.put(str3, a2);
            }
        } catch (Exception e) {
            C10711d.class.getSimpleName();
        }
    }

    /* renamed from: a */
    private static String m35171a(String str, String str2) {
        String str3 = "UTF-8";
        try {
            byte[] bytes = str.getBytes(str3);
            byte[] bArr = new byte[bytes.length];
            byte[] bytes2 = str2.getBytes(str3);
            for (int i = 0; i < bytes.length; i++) {
                bArr[i] = (byte) (bytes[i] ^ bytes2[i % bytes2.length]);
            }
            return new String(Base64.encode(bArr, 2), str3);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
