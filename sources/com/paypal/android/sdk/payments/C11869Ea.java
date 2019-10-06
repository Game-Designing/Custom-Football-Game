package com.paypal.android.sdk.payments;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11761Rb;
import com.paypal.android.sdk.C11829hc;
import java.util.ArrayList;

/* renamed from: com.paypal.android.sdk.payments.Ea */
final class C11869Ea implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C11829hc f37301a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f37302b;

    /* renamed from: c */
    final /* synthetic */ PaymentConfirmActivity f37303c;

    C11869Ea(PaymentConfirmActivity paymentConfirmActivity, C11829hc hcVar, ArrayList arrayList) {
        this.f37303c = paymentConfirmActivity;
        this.f37301a = hcVar;
        this.f37302b = arrayList;
    }

    public final void onClick(View view) {
        Builder builder = new Builder(view.getContext());
        builder.setTitle(C11756Pb.m38949a(C11761Rb.SHIPPING_ADDRESS)).setAdapter(this.f37301a, new C11871Fa(this));
        builder.create().show();
    }
}
