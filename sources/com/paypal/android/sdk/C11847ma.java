package com.paypal.android.sdk;

import android.util.Log;
import org.json.JSONException;

/* renamed from: com.paypal.android.sdk.ma */
public abstract class C11847ma implements C12023xa {

    /* renamed from: a */
    private static final String f37275a = C11847ma.class.getSimpleName();

    /* renamed from: a */
    protected static void m39201a(C11703Aa aa, int i) {
        aa.mo38498a(Integer.valueOf(i));
        try {
            new StringBuilder("parsing error response:\n").append(aa.mo38510g());
            aa.mo38507d();
        } catch (JSONException e) {
            Log.e("paypal.sdk", "Exception parsing server response", e);
            String str = C11793ba.INTERNAL_SERVER_ERROR.toString();
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(" http response received.  Response not parsable: ");
            sb.append(e.getMessage());
            aa.mo38501a(str, sb.toString(), null);
        }
    }

    /* renamed from: b */
    protected static void m39202b(C11703Aa aa) {
        try {
            new StringBuilder("parsing success response\n:").append(aa.mo38510g());
            aa.mo38505c();
        } catch (Exception e) {
            Log.e("paypal.sdk", "Exception parsing server response", e);
            aa.mo38497a((C11789aa) new C11797ca(C11793ba.PARSE_RESPONSE_ERROR, e));
        }
    }
}
