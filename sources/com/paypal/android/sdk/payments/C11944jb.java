package com.paypal.android.sdk.payments;

import android.content.Context;
import com.paypal.android.sdk.C11757Q;
import com.paypal.android.sdk.C11769Ua;

/* renamed from: com.paypal.android.sdk.payments.jb */
class C11944jb {

    /* renamed from: a */
    private static final String f37571a = C11944jb.class.getSimpleName();

    C11944jb() {
    }

    /* renamed from: a */
    static boolean m39590a(Context context, PayPalService payPalService) {
        boolean z = false;
        if (C11757Q.m38957e(payPalService.mo38980e())) {
            new StringBuilder("Is mock or sandbox:").append(payPalService.mo38980e());
        } else if (payPalService.mo39004w()) {
            C11769Ua ua = new C11769Ua();
            boolean x = payPalService.mo39005x();
            boolean a = ua.mo38826a(context, "com.paypal.android.p2pmobile.Sdk", "com.paypal.android.lib.authenticator.activity.SdkActivity");
            if (ua.mo38827a(context, x) && a) {
                z = true;
            }
        }
        new StringBuilder("returning isValid:").append(z);
        return z;
    }
}
