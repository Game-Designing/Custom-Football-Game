package p005cm.aptoide.p006pt.billing.payment;

import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.payment.g */
/* compiled from: lambda */
public final /* synthetic */ class C2341g implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Adyen f5477a;

    /* renamed from: b */
    private final /* synthetic */ String f5478b;

    public /* synthetic */ C2341g(Adyen adyen2, String str) {
        this.f5477a = adyen2;
        this.f5478b = str;
    }

    public final Object call(Object obj) {
        return this.f5477a.mo877a(this.f5478b, (AdyenPaymentStatus) obj);
    }
}
