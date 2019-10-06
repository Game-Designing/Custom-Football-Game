package com.paypal.android.sdk.payments;

import android.content.Intent;

/* renamed from: com.paypal.android.sdk.payments.sa */
final class C11970sa {

    /* renamed from: a */
    private Intent f37608a;

    C11970sa(Intent intent) {
        this.f37608a = intent;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final PayPalPayment mo39150a() {
        return (PayPalPayment) this.f37608a.getParcelableExtra("com.paypal.android.sdk.payment");
    }

    /* renamed from: b */
    public final C11926dx mo39151b() {
        return (C11926dx) this.f37608a.getParcelableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_INFO");
    }
}
