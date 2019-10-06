package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;

public final class ProfileSharingConsentActivity extends C11950lb {

    /* renamed from: m */
    private static final String f37465m = ProfileSharingConsentActivity.class.getSimpleName();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public static void m39502a(Activity activity, int i, PayPalConfiguration payPalConfiguration) {
        Intent intent = new Intent(activity, ProfileSharingConsentActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        activity.startActivityForResult(intent, 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo38849a() {
        this.f37581e = (PayPalOAuthScopes) getIntent().getParcelableExtra("com.paypal.android.sdk.requested_scopes");
    }

    public final /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    public final /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }
}
