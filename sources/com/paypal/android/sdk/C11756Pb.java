package com.paypal.android.sdk;

import java.util.Set;

/* renamed from: com.paypal.android.sdk.Pb */
public final class C11756Pb {

    /* renamed from: a */
    public static boolean f36876a;

    /* renamed from: b */
    private static final C11776Wb f36877b = new C11776Wb(C11761Rb.class, C11713Cc.f36647a);

    /* renamed from: c */
    private static Set f36878c = new C11759Qb();

    /* renamed from: a */
    public static String m38949a(C11761Rb rb) {
        return f36877b.mo38644a((Enum) rb);
    }

    /* renamed from: a */
    public static String m38950a(String str) {
        if (str.equals(C11793ba.DEVICE_OS_TOO_OLD.toString())) {
            return f36877b.mo38644a((Enum) C11761Rb.ANDROID_OS_TOO_OLD);
        }
        if (str.equals(C11793ba.SERVER_COMMUNICATION_ERROR.toString())) {
            return f36877b.mo38644a((Enum) C11761Rb.SERVER_PROBLEM);
        }
        if (!str.equals(C11793ba.INTERNAL_SERVER_ERROR.toString())) {
            return str.equals(C11793ba.PARSE_RESPONSE_ERROR.toString()) ? f36877b.mo38644a((Enum) C11761Rb.PP_SERVICE_ERROR_JSON_PARSE_ERROR) : f36877b.mo38645a(str, C11761Rb.SYSTEM_ERROR_WITH_CODE);
        }
        return f36877b.mo38645a("INTERNAL_SERVICE_ERROR", C11761Rb.SYSTEM_ERROR_WITH_CODE);
    }

    /* renamed from: b */
    public static void m38951b(String str) {
        f36877b.mo38646a(str);
        f36876a = C11723Fa.m38822b((CharSequence) str) && f36878c.contains(str);
    }

    /* renamed from: c */
    public static String m38952c(String str) {
        String a = f36877b.mo38643a();
        String str2 = "_";
        if (a.contains(str2)) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }
}
