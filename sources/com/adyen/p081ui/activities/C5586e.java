package com.adyen.p081ui.activities;

import android.content.Intent;
import android.support.p000v4.content.C0515e;
import com.adyen.p081ui.p083b.C5623w.C5624a;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.p140a.C6885e;

/* renamed from: com.adyen.ui.activities.e */
/* compiled from: CheckoutActivity */
class C5586e implements C5624a {

    /* renamed from: a */
    final /* synthetic */ C6889d f9414a;

    /* renamed from: b */
    final /* synthetic */ CheckoutActivity f9415b;

    C5586e(CheckoutActivity this$0, C6889d dVar) {
        this.f9415b = this$0;
        this.f9414a = dVar;
    }

    /* renamed from: a */
    public void mo17724a(String iban, String accountHolder) {
        C6885e paymentDetails = new C6885e(this.f9414a.mo22327b());
        paymentDetails.mo22322a(iban);
        paymentDetails.mo22323b(accountHolder);
        Intent intent = new Intent("com.adyen.core.ui.PaymentDetailsProvided");
        intent.putExtra("PaymentDetails", paymentDetails);
        C0515e.m2597a(this.f9415b.f9402b).mo5314a(intent);
    }
}
