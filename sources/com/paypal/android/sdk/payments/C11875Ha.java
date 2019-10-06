package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.Ha */
final class C11875Ha implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ PaymentConfirmActivity f37311a;

    C11875Ha(PaymentConfirmActivity paymentConfirmActivity) {
        this.f37311a = paymentConfirmActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37311a.m39461a(true);
    }
}
