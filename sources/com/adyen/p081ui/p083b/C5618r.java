package com.adyen.p081ui.p083b;

import android.os.Bundle;
import com.adyen.p081ui.C5633f;
import com.adyen.p081ui.p083b.C5614q.C5617c;
import java.util.ArrayList;
import java.util.List;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: com.adyen.ui.b.r */
/* compiled from: PaymentMethodSelectionFragmentBuilder */
public class C5618r {

    /* renamed from: a */
    private ArrayList<C6889d> f9504a = new ArrayList<>();

    /* renamed from: b */
    private ArrayList<C6889d> f9505b = new ArrayList<>();

    /* renamed from: c */
    private int f9506c = C5633f.AdyenTheme;

    /* renamed from: d */
    private C5617c f9507d;

    /* renamed from: a */
    public C5618r mo17771a(List<C6889d> paymentMethods) {
        this.f9504a.clear();
        this.f9504a.addAll(paymentMethods);
        return this;
    }

    /* renamed from: b */
    public C5618r mo17772b(List<C6889d> preferredPaymentMethods) {
        this.f9505b.clear();
        this.f9505b.addAll(preferredPaymentMethods);
        return this;
    }

    /* renamed from: a */
    public C5618r mo17770a(C5617c paymentMethodSelectionListener) {
        this.f9507d = paymentMethodSelectionListener;
        return this;
    }

    /* renamed from: a */
    public C5614q mo17769a() {
        m9904b();
        C5614q fragment = new C5614q();
        Bundle bundle = new Bundle();
        bundle.putSerializable("filteredPaymentMethods", this.f9504a);
        bundle.putSerializable("preferredPaymentMethods", this.f9505b);
        bundle.putInt("theme", this.f9506c);
        fragment.setArguments(bundle);
        fragment.mo17766a(this.f9507d);
        return fragment;
    }

    /* renamed from: b */
    private void m9904b() {
        if (this.f9504a == null) {
            throw new IllegalStateException("PaymentMethods not set.");
        } else if (this.f9507d == null) {
            throw new IllegalStateException("PaymentMethodSelectionListener not set.");
        }
    }
}
