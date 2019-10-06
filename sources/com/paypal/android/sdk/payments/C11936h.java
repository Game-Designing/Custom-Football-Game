package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.h */
final class C11936h implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ FuturePaymentInfoActivity f37552a;

    C11936h(FuturePaymentInfoActivity futurePaymentInfoActivity) {
        this.f37552a = futurePaymentInfoActivity;
    }

    public final void onClick(View view) {
        this.f37552a.finish();
    }
}
