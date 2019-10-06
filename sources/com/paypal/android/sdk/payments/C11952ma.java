package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.ma */
final class C11952ma implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ PaymentActivity f37590a;

    C11952ma(PaymentActivity paymentActivity) {
        this.f37590a = paymentActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37590a.f37434d.mo38964a(this.f37590a.m39444c(), true);
    }
}
