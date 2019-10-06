package com.paypal.android.sdk.payments;

import android.os.Bundle;
import com.paypal.android.sdk.C11807dx;

/* renamed from: com.paypal.android.sdk.payments.kb */
class C11947kb {

    /* renamed from: a */
    private static final String f37573a = C11947kb.class.getSimpleName();

    C11947kb() {
    }

    /* renamed from: a */
    public static C11941ib m39592a(Bundle bundle) {
        String string = bundle.getString("authAccount");
        String string2 = bundle.getString("code");
        String string3 = bundle.getString("nonce");
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                String.format("%s:null", new Object[]{str});
            } else {
                String.format("%s:%s (%s)", new Object[]{str, obj.toString(), obj.getClass().getName()});
            }
        }
        return new C11941ib(string3, new C11807dx(string2, null), string);
    }
}
