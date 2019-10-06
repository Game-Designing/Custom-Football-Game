package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.L */
final class C11882L implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ PayPalFuturePaymentActivity f37316a;

    C11882L(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        this.f37316a = payPalFuturePaymentActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37316a.f37368d.mo38964a(this.f37316a.m39324c(), true);
    }
}
