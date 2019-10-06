package com.adyen.p081ui.p083b;

import android.os.Bundle;
import com.adyen.p081ui.C5633f;
import com.adyen.p081ui.p083b.C5623w.C5624a;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: com.adyen.ui.b.x */
/* compiled from: SepaDirectDebitFragmentBuilder */
public class C5625x {

    /* renamed from: a */
    private C6889d f9520a;

    /* renamed from: b */
    private C6878a f9521b;

    /* renamed from: c */
    private int f9522c = C5633f.AdyenTheme;

    /* renamed from: d */
    private C5624a f9523d;

    /* renamed from: a */
    public C5625x mo17779a(C6878a amount) {
        this.f9521b = amount;
        return this;
    }

    /* renamed from: a */
    public C5625x mo17778a(C5624a listener) {
        this.f9523d = listener;
        return this;
    }

    /* renamed from: a */
    public C5623w mo17777a() {
        m9913b();
        C5623w fragment = new C5623w();
        Bundle bundle = new Bundle();
        bundle.putSerializable("PaymentMethod", this.f9520a);
        bundle.putSerializable("amount", this.f9521b);
        bundle.putInt("theme", this.f9522c);
        fragment.setArguments(bundle);
        fragment.mo17776a(this.f9523d);
        return fragment;
    }

    /* renamed from: b */
    private void m9913b() {
        if (this.f9521b == null) {
            throw new IllegalStateException("Amount not set.");
        } else if (this.f9523d == null) {
            throw new IllegalStateException("SepaDirectDebitPaymentDetailsListener not set.");
        }
    }
}
