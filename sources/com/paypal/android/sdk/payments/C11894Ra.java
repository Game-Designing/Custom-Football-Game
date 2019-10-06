package com.paypal.android.sdk.payments;

import java.util.TimerTask;

/* renamed from: com.paypal.android.sdk.payments.Ra */
final class C11894Ra extends TimerTask {

    /* renamed from: a */
    private /* synthetic */ PaymentMethodActivity f37473a;

    C11894Ra(PaymentMethodActivity paymentMethodActivity) {
        this.f37473a = paymentMethodActivity;
    }

    public final void run() {
        this.f37473a.removeDialog(3);
        PaymentMethodActivity paymentMethodActivity = this.f37473a;
        PaymentConfirmActivity.m39453a(paymentMethodActivity, 2, C11883La.PayPal, null, paymentMethodActivity.f37462i.mo38979d());
    }
}
