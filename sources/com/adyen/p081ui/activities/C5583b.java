package com.adyen.p081ui.activities;

import android.content.Intent;
import android.support.p000v4.content.C0515e;
import com.adyen.p081ui.p083b.C5614q.C5617c;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: com.adyen.ui.activities.b */
/* compiled from: CheckoutActivity */
class C5583b implements C5617c {

    /* renamed from: a */
    final /* synthetic */ CheckoutActivity f9410a;

    C5583b(CheckoutActivity this$0) {
        this.f9410a = this$0;
    }

    /* renamed from: a */
    public void mo17721a(C6889d paymentMethod) {
        if (paymentMethod.mo22338j() || (paymentMethod.mo22337i() && !paymentMethod.mo22339k())) {
            this.f9410a.f9402b.startActivity(new Intent(this.f9410a.f9402b.getApplicationContext(), TranslucentLoadingScreenActivity.class));
        }
        Intent intent = new Intent("com.adyen.core.ui.PaymentMethodSelected");
        intent.putExtra("PaymentMethod", paymentMethod);
        C0515e.m2597a(this.f9410a.f9402b).mo5314a(intent);
    }
}
