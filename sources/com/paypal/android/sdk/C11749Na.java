package com.paypal.android.sdk;

import com.paypal.android.sdk.payments.PayPalService;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.paypal.android.sdk.Na */
public final class C11749Na {

    /* renamed from: a */
    private static final String f36761a = PayPalService.class.getSimpleName();

    /* renamed from: b */
    private static Map f36762b = new HashMap();

    /* renamed from: a */
    public static C11806dv m38902a(String str) {
        C11806dv dvVar = (C11806dv) f36762b.get(str);
        StringBuilder sb = new StringBuilder("getLoginAccessToken(");
        sb.append(str);
        sb.append(") returns String:");
        sb.append(dvVar);
        return dvVar;
    }

    /* renamed from: a */
    public static void m38903a(C11806dv dvVar, String str) {
        f36762b.put(str, dvVar);
        StringBuilder sb = new StringBuilder("setLoginAccessToken(");
        sb.append(dvVar);
        sb.append(",");
        sb.append(str);
        sb.append(")");
    }

    /* renamed from: b */
    public static void m38904b(String str) {
        f36762b.remove(str);
    }
}
