package com.adyen.p081ui.p083b;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.adyen.p081ui.p084c.C5628b;
import com.adyen.p081ui.views.CheckoutCheckBox;

/* renamed from: com.adyen.ui.b.s */
/* compiled from: SepaDirectDebitFragment */
class C5619s implements OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ C5628b f9508a;

    /* renamed from: b */
    final /* synthetic */ CheckoutCheckBox f9509b;

    /* renamed from: c */
    final /* synthetic */ C5623w f9510c;

    C5619s(C5623w this$0, C5628b bVar, CheckoutCheckBox checkoutCheckBox) {
        this.f9510c = this$0;
        this.f9508a = bVar;
        this.f9509b = checkoutCheckBox;
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        this.f9508a.mo17782a(this.f9509b, isChecked);
    }
}
