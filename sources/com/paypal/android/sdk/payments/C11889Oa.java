package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.Oa */
final class C11889Oa implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ PaymentMethodActivity f37344a;

    C11889Oa(PaymentMethodActivity paymentMethodActivity) {
        this.f37344a = paymentMethodActivity;
    }

    public final void onClick(View view) {
        this.f37344a.showDialog(1);
    }
}
