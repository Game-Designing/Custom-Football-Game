package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.ta */
final class C11973ta implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ PaymentConfirmActivity f37611a;

    C11973ta(PaymentConfirmActivity paymentConfirmActivity) {
        this.f37611a = paymentConfirmActivity;
    }

    public final void onClick(View view) {
        view.setEnabled(false);
        this.f37611a.m39477g();
    }
}
