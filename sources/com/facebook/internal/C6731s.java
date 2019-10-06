package com.facebook.internal;

import com.facebook.FacebookRequestError.C6541a;

/* renamed from: com.facebook.internal.s */
/* compiled from: FacebookRequestErrorClassification */
/* synthetic */ class C6731s {

    /* renamed from: a */
    static final /* synthetic */ int[] f12298a = new int[C6541a.values().length];

    static {
        try {
            f12298a[C6541a.OTHER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f12298a[C6541a.LOGIN_RECOVERABLE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f12298a[C6541a.TRANSIENT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
