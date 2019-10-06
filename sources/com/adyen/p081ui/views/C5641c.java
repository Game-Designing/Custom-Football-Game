package com.adyen.p081ui.views;

import android.content.Intent;
import android.support.p000v4.content.C0515e;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.adyen.p081ui.C5626c;
import p019d.p135a.p136a.p139c.p140a.C6884d;

/* renamed from: com.adyen.ui.views.c */
/* compiled from: CVCDialog */
class C5641c implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CVCEditText f9555a;

    /* renamed from: b */
    final /* synthetic */ Button f9556b;

    /* renamed from: c */
    final /* synthetic */ Button f9557c;

    /* renamed from: d */
    final /* synthetic */ C5644f f9558d;

    C5641c(C5644f this$0, CVCEditText cVCEditText, Button button, Button button2) {
        this.f9558d = this$0;
        this.f9555a = cVCEditText;
        this.f9556b = button;
        this.f9557c = button2;
    }

    public void onClick(View v) {
        if (this.f9555a.mo17784a()) {
            Intent intent = new Intent("com.adyen.core.ui.PaymentDetailsProvided");
            C6884d paymentDetails = new C6884d(this.f9558d.f9563b.mo22327b());
            paymentDetails.mo22320a("cardDetails.cvc", this.f9555a.getCVC());
            intent.putExtra("PaymentDetails", paymentDetails);
            C0515e.m2597a(this.f9558d.getContext().getApplicationContext()).mo5314a(intent);
            this.f9555a.setEnabled(false);
            this.f9556b.setEnabled(false);
            this.f9557c.setEnabled(false);
            this.f9558d.f9564c = false;
            this.f9558d.findViewById(C5626c.dialog_view).setVisibility(4);
            this.f9558d.findViewById(C5626c.progress_bar).setVisibility(0);
        }
    }
}
