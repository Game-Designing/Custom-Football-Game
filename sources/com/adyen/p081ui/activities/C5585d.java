package com.adyen.p081ui.activities;

import android.content.Intent;
import android.support.p000v4.content.C0515e;
import com.adyen.p081ui.p083b.C5608l.C5609a;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.p140a.C6880b;

/* renamed from: com.adyen.ui.activities.d */
/* compiled from: CheckoutActivity */
class C5585d implements C5609a {

    /* renamed from: a */
    final /* synthetic */ C6889d f9412a;

    /* renamed from: b */
    final /* synthetic */ CheckoutActivity f9413b;

    C5585d(CheckoutActivity this$0, C6889d dVar) {
        this.f9413b = this$0;
        this.f9412a = dVar;
    }

    /* renamed from: a */
    public void mo17723a(String issuer) {
        C6880b paymentDetails = new C6880b(this.f9412a.mo22327b());
        paymentDetails.mo22305a(issuer);
        Intent intent = new Intent("com.adyen.core.ui.PaymentDetailsProvided");
        intent.putExtra("PaymentDetails", paymentDetails);
        C0515e.m2597a(this.f9413b.f9402b).mo5314a(intent);
    }
}
