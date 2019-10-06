package com.flurry.sdk;

/* renamed from: com.flurry.sdk.S */
public enum C7450S {
    COMPLETE(1),
    TIMEOUT(2),
    INVALID_RESPONSE(3),
    PENDING_COMPLETION(4);
    

    /* renamed from: f */
    int f14652f;

    private C7450S(int i) {
        this.f14652f = i;
    }

    /* renamed from: a */
    public static C7450S m16492a(int i) {
        if (i == 1) {
            return COMPLETE;
        }
        if (i == 2) {
            return TIMEOUT;
        }
        if (i == 3) {
            return INVALID_RESPONSE;
        }
        if (i != 4) {
            return null;
        }
        return PENDING_COMPLETION;
    }
}
