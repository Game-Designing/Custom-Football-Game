package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.Fa */
final class C11871Fa implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ C11869Ea f37305a;

    C11871Fa(C11869Ea ea) {
        this.f37305a = ea;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37305a.f37301a.mo38803a(i);
        C11869Ea ea = this.f37305a;
        PaymentConfirmActivity.m39466b(ea.f37303c, ea.f37302b, i);
    }
}
