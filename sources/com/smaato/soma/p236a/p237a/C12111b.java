package com.smaato.soma.p236a.p237a;

/* renamed from: com.smaato.soma.a.a.b */
/* compiled from: BannerStatus */
public enum C12111b {
    MEDIATION(""),
    f37994b(r3),
    f37995c(r4);
    

    /* renamed from: e */
    private String f37997e;

    private C12111b(String responseString) {
        this.f37997e = responseString;
    }

    /* renamed from: a */
    public static C12111b m39908a(String string) {
        for (C12111b value : values()) {
            if (value.f37997e.equalsIgnoreCase(string)) {
                return value;
            }
        }
        return null;
    }
}
