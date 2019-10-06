package p019d.p135a.p136a;

import android.content.Context;
import android.content.IntentFilter;
import android.support.p000v4.content.C0515e;
import p019d.p135a.p136a.p137a.C6850f;
import p019d.p135a.p136a.p137a.C6851g;
import p019d.p135a.p136a.p138b.C6875t;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: d.a.a.k */
/* compiled from: PaymentRequest */
public class C6919k {

    /* renamed from: a */
    private static final String f12706a = C6919k.class.getSimpleName();

    /* renamed from: b */
    private Context f12707b;

    /* renamed from: c */
    private C6924p f12708c;

    public C6919k(Context context, C6851g paymentRequestListener, C6850f paymentRequestDetailsListener) {
        this.f12707b = context;
        this.f12708c = new C6924p(context, this, paymentRequestListener, paymentRequestDetailsListener);
        C0515e.m2597a(this.f12707b).mo5313a(this.f12708c.mo22389d().mo22373h(), new IntentFilter("com.adyen.core.ui.PaymentRequestCancelled"));
    }

    /* renamed from: g */
    public void mo22380g() {
        if (this.f12708c.mo22394i()) {
            this.f12708c.mo22391f().mo22283a(C6875t.PAYMENT_REQUESTED);
        } else {
            this.f12708c.mo22391f().mo22283a(C6875t.ERROR_OCCURRED);
        }
    }

    /* renamed from: a */
    public void mo22374a() {
        this.f12708c.mo22391f().mo22283a(C6875t.PAYMENT_CANCELLED);
    }

    /* renamed from: d */
    public C6889d mo22377d() {
        return this.f12708c.mo22390e();
    }

    /* renamed from: e */
    public String mo22378e() {
        return this.f12708c.mo22392g();
    }

    /* renamed from: c */
    public String mo22376c() {
        return this.f12708c.mo22388c();
    }

    /* renamed from: b */
    public C6878a mo22375b() {
        return this.f12708c.mo22386b();
    }

    /* renamed from: f */
    public String mo22379f() {
        return this.f12708c.mo22393h();
    }
}
