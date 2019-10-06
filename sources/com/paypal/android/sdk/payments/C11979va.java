package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.va */
final class C11979va implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ PaymentConfirmActivity f37617a;

    C11979va(PaymentConfirmActivity paymentConfirmActivity) {
        this.f37617a = paymentConfirmActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37617a.onBackPressed();
    }
}
