package com.fyber.inneractive.sdk.util;

/* renamed from: com.fyber.inneractive.sdk.util.ac */
public enum C7989ac {
    UNKNOWN(""),
    ETHERNET(r2),
    WIFI("wifi"),
    MOBILE_3G(r2),
    MOBILE_4G("4g");
    

    /* renamed from: f */
    public final String f16311f;

    private C7989ac(String str) {
        this.f16311f = str;
    }

    /* renamed from: a */
    public static C7989ac m18034a() {
        int b = C8005i.m18053b();
        if (b != 0) {
            if (b == 1) {
                return WIFI;
            }
            if (!(b == 2 || b == 3 || b == 4 || b == 5)) {
                if (b != 9) {
                    return UNKNOWN;
                }
                return ETHERNET;
            }
        }
        return C8005i.m18054c() == 13 ? MOBILE_4G : MOBILE_3G;
    }
}
