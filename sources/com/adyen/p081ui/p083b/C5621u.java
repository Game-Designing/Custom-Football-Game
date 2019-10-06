package com.adyen.p081ui.p083b;

import android.view.View;
import android.view.View.OnClickListener;
import com.adyen.p081ui.views.IBANEditText;

/* renamed from: com.adyen.ui.b.u */
/* compiled from: SepaDirectDebitFragment */
class C5621u implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ IBANEditText f9513a;

    /* renamed from: b */
    final /* synthetic */ C5623w f9514b;

    C5621u(C5623w this$0, IBANEditText iBANEditText) {
        this.f9514b = this$0;
        this.f9513a = iBANEditText;
    }

    public void onClick(View v) {
        this.f9514b.f9519c.mo17724a(this.f9513a.getIbanNumber(), this.f9513a.getIbanNumber());
    }
}
