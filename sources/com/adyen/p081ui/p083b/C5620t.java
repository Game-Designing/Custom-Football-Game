package com.adyen.p081ui.p083b;

import android.view.View;
import android.view.View.OnClickListener;
import com.adyen.p081ui.views.CheckoutCheckBox;

/* renamed from: com.adyen.ui.b.t */
/* compiled from: SepaDirectDebitFragment */
class C5620t implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckoutCheckBox f9511a;

    /* renamed from: b */
    final /* synthetic */ C5623w f9512b;

    C5620t(C5623w this$0, CheckoutCheckBox checkoutCheckBox) {
        this.f9512b = this$0;
        this.f9511a = checkoutCheckBox;
    }

    public void onClick(View v) {
        this.f9511a.mo17791a();
        this.f9511a.toggle();
    }
}
