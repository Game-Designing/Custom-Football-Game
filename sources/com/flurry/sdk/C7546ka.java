package com.flurry.sdk;

/* renamed from: com.flurry.sdk.ka */
public enum C7546ka {
    f14902a(r1, 0),
    f14903b(r1, 1),
    f14904c(r1, 2);
    

    /* renamed from: e */
    String f14906e;

    /* renamed from: f */
    int f14907f;

    private C7546ka(String str, int i) {
        this.f14906e = str;
        this.f14907f = i;
    }

    /* renamed from: a */
    public static C7546ka m16708a(int i) {
        if (i == 0) {
            return f14902a;
        }
        if (i == 1) {
            return f14903b;
        }
        if (i != 2) {
            return null;
        }
        return f14904c;
    }
}
