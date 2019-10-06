package com.adyen.p081ui.p083b;

import android.os.Bundle;
import com.adyen.p081ui.C5633f;
import com.adyen.p081ui.p083b.C5608l.C5609a;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: com.adyen.ui.b.m */
/* compiled from: IssuerSelectionFragmentBuilder */
public class C5610m {

    /* renamed from: a */
    private C6889d f9489a;

    /* renamed from: b */
    private C5609a f9490b;

    /* renamed from: c */
    private int f9491c = C5633f.AdyenTheme;

    /* renamed from: a */
    public C5610m mo17763a(C6889d paymentMethod) {
        this.f9489a = paymentMethod;
        return this;
    }

    /* renamed from: a */
    public C5610m mo17762a(C5609a listener) {
        this.f9490b = listener;
        return this;
    }

    /* renamed from: a */
    public C5608l mo17761a() {
        m9894b();
        C5608l fragment = new C5608l();
        Bundle bundle = new Bundle();
        bundle.putSerializable("PaymentMethod", this.f9489a);
        bundle.putInt("theme", this.f9491c);
        fragment.setArguments(bundle);
        fragment.mo17760a(this.f9490b);
        return fragment;
    }

    /* renamed from: b */
    private void m9894b() {
        if (this.f9489a == null) {
            throw new IllegalStateException("PaymentMethod not set.");
        }
    }
}
