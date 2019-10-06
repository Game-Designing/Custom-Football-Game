package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.Ca */
final class C11865Ca implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ C11863Ba f37298a;

    C11865Ca(C11863Ba ba) {
        this.f37298a = ba;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37298a.f37294a.mo38641a(i);
        C11863Ba ba = this.f37298a;
        PaymentConfirmActivity.m39458a(ba.f37296c, ba.f37295b, i);
    }
}
