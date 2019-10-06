package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.wb */
final class C11983wb implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ C11950lb f37621a;

    C11983wb(C11950lb lbVar) {
        this.f37621a = lbVar;
    }

    public final void onClick(View view) {
        view.setEnabled(false);
        C11950lb.m39617f(this.f37621a);
    }
}
