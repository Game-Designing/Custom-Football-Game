package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.Qa */
final class C11893Qa implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ PaymentMethodActivity f37472a;

    C11893Qa(PaymentMethodActivity paymentMethodActivity) {
        this.f37472a = paymentMethodActivity;
    }

    public final void onClick(View view) {
        this.f37472a.showDialog(2);
    }
}
