package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.C11723Fa;
import com.paypal.android.sdk.C11737Ja;
import com.paypal.android.sdk.C11756Pb;

/* renamed from: com.paypal.android.sdk.payments.g */
class C11933g {

    /* renamed from: a */
    private static final String f37550a = C11933g.class.getSimpleName();

    C11933g() {
    }

    /* renamed from: a */
    static String m39554a() {
        String a = C11737Ja.m38864a().mo38577c().mo38767a();
        if (C11723Fa.m38818a((CharSequence) a) || a.equalsIgnoreCase("US")) {
            return "https://www.paypal.com/webapps/accountrecovery/passwordrecovery";
        }
        return String.format("https://www.paypal.com/%s/cgi-bin/webscr?cmd=_account-recovery&from=%s&locale.x=%s", new Object[]{a.toLowerCase(), "PayPalMPL", C11756Pb.m38952c(a)});
    }
}
