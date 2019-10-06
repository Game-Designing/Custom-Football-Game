package com.paypal.android.sdk.payments;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11761Rb;
import com.paypal.android.sdk.C11773Vb;
import java.util.ArrayList;

/* renamed from: com.paypal.android.sdk.payments.Ba */
final class C11863Ba implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C11773Vb f37294a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f37295b;

    /* renamed from: c */
    final /* synthetic */ PaymentConfirmActivity f37296c;

    C11863Ba(PaymentConfirmActivity paymentConfirmActivity, C11773Vb vb, ArrayList arrayList) {
        this.f37296c = paymentConfirmActivity;
        this.f37294a = vb;
        this.f37295b = arrayList;
    }

    public final void onClick(View view) {
        Builder builder = new Builder(view.getContext());
        builder.setTitle(C11756Pb.m38949a(C11761Rb.PREFERRED_PAYMENT_METHOD)).setAdapter(this.f37294a, new C11865Ca(this));
        builder.create().show();
    }
}
