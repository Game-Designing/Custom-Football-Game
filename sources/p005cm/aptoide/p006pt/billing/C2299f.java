package p005cm.aptoide.p006pt.billing;

import p005cm.aptoide.p006pt.billing.payment.Payment;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.f */
/* compiled from: lambda */
public final /* synthetic */ class C2299f implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Billing f5386a;

    /* renamed from: b */
    private final /* synthetic */ Payment f5387b;

    /* renamed from: c */
    private final /* synthetic */ String f5388c;

    public /* synthetic */ C2299f(Billing billing, Payment payment, String str) {
        this.f5386a = billing;
        this.f5387b = payment;
        this.f5388c = str;
    }

    public final Object call(Object obj) {
        return this.f5386a.mo830a(this.f5387b, this.f5388c, (String) obj);
    }
}
