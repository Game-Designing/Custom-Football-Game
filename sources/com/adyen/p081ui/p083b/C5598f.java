package com.adyen.p081ui.p083b;

import android.os.Bundle;
import com.adyen.p081ui.C5633f;
import com.adyen.p081ui.p083b.C5596e.C5597a;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: com.adyen.ui.b.f */
/* compiled from: CreditCardFragmentBuilder */
public class C5598f {

    /* renamed from: a */
    private C6878a f9449a;

    /* renamed from: b */
    private C6889d f9450b;

    /* renamed from: c */
    private String f9451c;

    /* renamed from: d */
    private String f9452d;

    /* renamed from: e */
    private C5599a f9453e;

    /* renamed from: f */
    private boolean f9454f;

    /* renamed from: g */
    private C5597a f9455g;

    /* renamed from: h */
    private String f9456h;

    /* renamed from: i */
    private int f9457i = C5633f.AdyenTheme;

    /* renamed from: com.adyen.ui.b.f$a */
    /* compiled from: CreditCardFragmentBuilder */
    public enum C5599a {
        REQUIRED,
        OPTIONAL,
        NOCVC
    }

    /* renamed from: a */
    public C5598f mo17739a(C6889d paymentMethod) {
        this.f9450b = paymentMethod;
        return this;
    }

    /* renamed from: a */
    public C5598f mo17738a(C6878a amount) {
        this.f9449a = amount;
        return this;
    }

    /* renamed from: c */
    public C5598f mo17743c(String shopperReference) {
        this.f9456h = shopperReference;
        return this;
    }

    /* renamed from: b */
    public C5598f mo17742b(String publicKey) {
        this.f9452d = publicKey;
        return this;
    }

    /* renamed from: a */
    public C5598f mo17740a(String generationtime) {
        this.f9451c = generationtime;
        return this;
    }

    /* renamed from: a */
    public C5598f mo17736a(C5597a creditCardInfoListener) {
        this.f9455g = creditCardInfoListener;
        return this;
    }

    /* renamed from: a */
    public C5598f mo17737a(C5599a cvcFieldStatus) {
        this.f9453e = cvcFieldStatus;
        return this;
    }

    /* renamed from: a */
    public C5598f mo17741a(boolean paymentCardScanEnabled) {
        this.f9454f = paymentCardScanEnabled;
        return this;
    }

    /* renamed from: a */
    public C5596e mo17735a() {
        m9858b();
        C5596e fragment = new C5596e();
        Bundle bundle = new Bundle();
        bundle.putSerializable("amount", this.f9449a);
        bundle.putString("shopper_reference", this.f9456h);
        bundle.putString("public_key", this.f9452d);
        bundle.putString("generation_time", this.f9451c);
        bundle.putSerializable("PaymentMethod", this.f9450b);
        bundle.putString("cvc_field_status", this.f9453e.name());
        bundle.putBoolean("payment_card_scan_enabled", this.f9454f);
        bundle.putInt("theme", this.f9457i);
        fragment.setArguments(bundle);
        fragment.mo17733a(this.f9455g);
        return fragment;
    }

    /* renamed from: b */
    private void m9858b() {
        if (this.f9449a == null) {
            throw new IllegalStateException("Amount not set.");
        } else if (this.f9450b == null) {
            throw new IllegalStateException("PaymentMethod not set.");
        } else if (this.f9452d == null) {
            throw new IllegalStateException("PublicKey not set.");
        } else if (this.f9451c == null) {
            throw new IllegalStateException("Generationtime not set.");
        } else if (this.f9455g == null) {
            throw new IllegalStateException("CreditCardInfoListener not set.");
        }
    }
}
