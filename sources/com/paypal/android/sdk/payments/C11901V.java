package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.V */
final class C11901V implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ PayPalProfileSharingActivity f37485a;

    C11901V(PayPalProfileSharingActivity payPalProfileSharingActivity) {
        this.f37485a = payPalProfileSharingActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37485a.f37406d.mo38964a(PayPalProfileSharingActivity.m39359a(this.f37485a), true);
    }
}
