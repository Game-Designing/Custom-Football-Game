package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.C11737Ja;
import com.paypal.android.sdk.C11756Pb;

/* renamed from: com.paypal.android.sdk.payments.cb */
class C11921cb {

    /* renamed from: a */
    private static final String f37524a = C11921cb.class.getSimpleName();

    C11921cb() {
    }

    /* renamed from: a */
    static String m39527a() {
        String a = C11737Ja.m38864a().mo38577c().mo38767a();
        return String.format("https://www.paypal.com/signup/account?country.x=%s&locale.x=%s", new Object[]{a, C11756Pb.m38952c(a)});
    }
}
