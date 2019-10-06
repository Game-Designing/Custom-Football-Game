package com.paypal.android.sdk;

import android.content.Intent;
import android.os.Bundle;

/* renamed from: com.paypal.android.sdk.Ua */
public class C11769Ua extends C11854o {

    /* renamed from: c */
    private static final String f37038c = C11769Ua.class.getSimpleName();

    /* renamed from: a */
    public final Intent mo38633a(String str, C11772Va va, C11775Wa wa, String str2) {
        Intent a = C11854o.m39206a("com.paypal.android.p2pmobile.Sdk", "com.paypal.android.lib.authenticator.activity.SdkActivity");
        Bundle bundle = new Bundle();
        bundle.putString("target_client_id", str);
        if (va != null) {
            bundle.putString("token_request_type", va.toString());
        }
        if (wa != null) {
            bundle.putString("response_type", wa.toString());
        }
        bundle.putString("app_guid", str2);
        new StringBuilder("launching authenticator with bundle:").append(bundle);
        a.putExtras(bundle);
        return a;
    }
}
