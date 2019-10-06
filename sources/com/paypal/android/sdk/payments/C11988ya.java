package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.ya */
final class C11988ya implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ PaymentConfirmActivity f37645a;

    C11988ya(PaymentConfirmActivity paymentConfirmActivity) {
        this.f37645a = paymentConfirmActivity;
    }

    public final void onClick(View view) {
        this.f37645a.onBackPressed();
    }
}
