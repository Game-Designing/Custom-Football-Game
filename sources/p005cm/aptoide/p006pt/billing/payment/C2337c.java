package p005cm.aptoide.p006pt.billing.payment;

import p019d.p135a.p136a.p139c.C6889d;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.payment.c */
/* compiled from: lambda */
public final /* synthetic */ class C2337c implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ C6889d f5473a;

    public /* synthetic */ C2337c(C6889d dVar) {
        this.f5473a = dVar;
    }

    public final Object call(Object obj) {
        return Adyen.m175a(this.f5473a, (AdyenPaymentStatus) obj);
    }
}
