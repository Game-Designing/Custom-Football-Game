package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.Ja */
final class C11879Ja implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ PaymentConfirmActivity f37313a;

    C11879Ja(PaymentConfirmActivity paymentConfirmActivity) {
        this.f37313a = paymentConfirmActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37313a.onBackPressed();
    }
}
