package com.moat.analytics.mobile.inm;

import android.util.Log;
import android.view.View;
import com.mopub.mobileads.VastExtensionXmlManager;

/* renamed from: com.moat.analytics.mobile.inm.p */
class C10969p {
    C10969p() {
    }

    /* renamed from: a */
    static String m36111a(View view) {
        if (view == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(view.getClass().getSimpleName());
        sb.append("@");
        sb.append(view.hashCode());
        return sb.toString();
    }

    /* renamed from: a */
    private static String m36112a(String str) {
        StringBuilder sb = new StringBuilder(VastExtensionXmlManager.MOAT);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    static void m36113a(int i, String str, Object obj, String str2) {
        if (C10984w.m36151a().f33562b) {
            if (obj == null) {
                Log.println(i, m36112a(str), String.format("message = %s", new Object[]{str2}));
                return;
            }
            Log.println(i, m36112a(str), String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2}));
        }
    }

    /* renamed from: a */
    static void m36114a(String str, int i, String str2, Object obj, String str3) {
        m36113a(i, str2, obj, str3);
        m36116a(str, str3);
    }

    /* renamed from: a */
    static void m36115a(String str, Object obj, String str2, Throwable th) {
        if (C10984w.m36151a().f33562b) {
            Log.e(m36112a(str), String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2}), th);
        }
    }

    /* renamed from: a */
    static void m36116a(String str, String str2) {
        if (!C10984w.m36151a().f33562b && ((C10958k) MoatAnalytics.getInstance()).f33506a) {
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
    static void m36117b(int i, String str, Object obj, String str2) {
        if (C10984w.m36151a().f33563c) {
            String a = m36112a(str);
            Object[] objArr = new Object[2];
            objArr[0] = obj == null ? "null" : Integer.valueOf(obj.hashCode());
            objArr[1] = str2;
            Log.println(i, a, String.format("id = %s, message = %s", objArr));
        }
    }
}
