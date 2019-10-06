package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class FuturePaymentConsentActivity extends C11950lb {

    /* renamed from: m */
    private static final String f37306m = FuturePaymentConsentActivity.class.getSimpleName();

    /* renamed from: a */
    static void m39252a(Activity activity, int i, PayPalConfiguration payPalConfiguration) {
        Intent intent = new Intent(activity, FuturePaymentConsentActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        activity.startActivityForResult(intent, 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo38849a() {
        this.f37581e = new PayPalOAuthScopes((Set) new HashSet(Arrays.asList(new String[]{PayPalOAuthScopes.f37377a})));
    }

    public final /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    public final /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }
}
