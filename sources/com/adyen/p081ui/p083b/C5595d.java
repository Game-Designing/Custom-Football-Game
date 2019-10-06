package com.adyen.p081ui.p083b;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.adyen.p081ui.C5626c;
import com.adyen.p081ui.views.loadinganimation.ThreeDotsLoadingView;
import java.util.Collection;
import p019d.p135a.p136a.p139c.p140a.C6879a;
import p019d.p135a.p136a.p139c.p140a.C6881c.C6882a;
import p019d.p135a.p136a.p142e.C6912j;

/* renamed from: com.adyen.ui.b.d */
/* compiled from: CreditCardFragment */
class C5595d implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Collection f9424a;

    /* renamed from: b */
    final /* synthetic */ TextView f9425b;

    /* renamed from: c */
    final /* synthetic */ View f9426c;

    /* renamed from: d */
    final /* synthetic */ C5596e f9427d;

    C5595d(C5596e this$0, Collection collection, TextView textView, View view) {
        this.f9427d = this$0;
        this.f9424a = collection;
        this.f9425b = textView;
        this.f9426c = view;
    }

    public void onClick(View view) {
        String token = this.f9427d.m9846d();
        boolean storeDetails = !C6912j.m14060a(this.f9427d.f9434g) && this.f9427d.f9443p.isChecked();
        if (this.f9427d.f9430c != null) {
            C6879a creditCardPaymentDetails = new C6879a(this.f9424a);
            creditCardPaymentDetails.mo22302a(token);
            if (this.f9427d.f9444q != null) {
                creditCardPaymentDetails.mo22303a(Short.valueOf(((C6882a) this.f9427d.f9444q.getSelectedItem()).mo22315a()).shortValue());
            }
            creditCardPaymentDetails.mo22304a(storeDetails);
            this.f9427d.f9430c.mo17722a(creditCardPaymentDetails);
        } else {
            Log.w(C5596e.f9428a, "No listener provided.");
        }
        this.f9425b.setVisibility(8);
        ((ThreeDotsLoadingView) this.f9426c.findViewById(C5626c.processing_progress_bar)).setVisibility(0);
        this.f9427d.f9441n.setEnabled(false);
        this.f9427d.f9438k.setEnabled(false);
        if (this.f9427d.f9432e) {
            this.f9427d.f9442o.setEnabled(false);
        }
        this.f9427d.f9440m.setEnabled(false);
        ((InputMethodManager) this.f9427d.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }
}
