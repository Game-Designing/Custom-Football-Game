package com.paypal.android.sdk;

/* renamed from: com.paypal.android.sdk.Ya */
public enum C11781Ya {
    AMEX,
    DINERSCLUB,
    DISCOVER,
    JCB,
    MASTERCARD,
    VISA,
    MAESTRO,
    UNKNOWN,
    INSUFFICIENT_DIGITS;

    /* renamed from: a */
    public static C11781Ya m39015a(String str) {
        C11781Ya[] values;
        if (str == null) {
            return UNKNOWN;
        }
        for (C11781Ya ya : values()) {
            if (ya != UNKNOWN && ya != INSUFFICIENT_DIGITS && str.equalsIgnoreCase(ya.toString())) {
                return ya;
            }
        }
        return UNKNOWN;
    }
}
