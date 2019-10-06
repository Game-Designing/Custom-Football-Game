package com.moat.analytics.mobile.vng;

import android.util.Log;
import com.mopub.mobileads.VastExtensionXmlManager;

/* renamed from: com.moat.analytics.mobile.vng.p */
class C11185p {
    C11185p() {
    }

    /* renamed from: a */
    private static String m36816a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(VastExtensionXmlManager.MOAT);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    static void m36817a(int i, String str, Object obj, String str2) {
        String str3;
        String str4;
        if (C11198w.m36845a().f34159b) {
            if (obj == null) {
                str4 = m36816a(str);
                str3 = String.format("message = %s", new Object[]{str2});
            } else {
                str4 = m36816a(str);
                str3 = String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2});
            }
            Log.println(i, str4, str3);
        }
    }

    /* renamed from: a */
    static void m36818a(String str, Object obj, String str2, Throwable th) {
        if (C11198w.m36845a().f34159b) {
            Log.e(m36816a(str), String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2}), th);
        }
    }

    /* renamed from: a */
    static void m36819a(String str, String str2) {
        if (!C11198w.m36845a().f34159b && ((C11174k) MoatAnalytics.getInstance()).f34119a) {
            int i = 2;
            if (str.equals("[ERROR] ")) {
                i = 6;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            Log.println(i, "MoatAnalytics", sb.toString());
        }
    }

    /* renamed from: b */
    static void m36820b(int i, String str, Object obj, String str2) {
        if (C11198w.m36845a().f34160c) {
            String a = m36816a(str);
            Object[] objArr = new Object[2];
            objArr[0] = obj == null ? "null" : Integer.valueOf(obj.hashCode());
            objArr[1] = str2;
            Log.println(i, a, String.format("id = %s, message = %s", objArr));
        }
    }
}
