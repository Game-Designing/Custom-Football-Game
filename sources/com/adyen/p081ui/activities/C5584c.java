package com.adyen.p081ui.activities;

import android.content.Intent;
import android.support.p000v4.content.C0515e;
import com.adyen.p081ui.p083b.C5596e.C5597a;
import p019d.p135a.p136a.p139c.p140a.C6879a;

/* renamed from: com.adyen.ui.activities.c */
/* compiled from: CheckoutActivity */
class C5584c implements C5597a {

    /* renamed from: a */
    final /* synthetic */ CheckoutActivity f9411a;

    C5584c(CheckoutActivity this$0) {
        this.f9411a = this$0;
    }

    /* renamed from: a */
    public void mo17722a(C6879a creditCardPaymentDetails) {
        Intent intent = new Intent("com.adyen.core.ui.PaymentDetailsProvided");
        intent.putExtra("PaymentDetails", creditCardPaymentDetails);
        C0515e.m2597a(this.f9411a.f9402b).mo5314a(intent);
        this.f9411a.f9401a = true;
    }
}
