package com.flurry.sdk;

/* renamed from: com.flurry.sdk.la */
public enum C7552la {
    INSTALL(1),
    SESSION_START(2),
    SESSION_END(3),
    APPLICATION_EVENT(4);
    

    /* renamed from: f */
    final int f14931f;

    private C7552la(int i) {
        this.f14931f = i;
    }

    /* renamed from: a */
    public static C7552la m16730a(int i) {
        if (i == 1) {
            return INSTALL;
        }
        if (i == 2) {
            return SESSION_START;
        }
        if (i == 3) {
            return SESSION_END;
        }
        if (i != 4) {
            return null;
        }
        return APPLICATION_EVENT;
    }
}
