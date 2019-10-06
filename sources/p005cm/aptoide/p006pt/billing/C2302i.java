package p005cm.aptoide.p006pt.billing;

import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.i */
/* compiled from: lambda */
public final /* synthetic */ class C2302i implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Billing f5391a;

    /* renamed from: b */
    private final /* synthetic */ Transaction f5392b;

    public /* synthetic */ C2302i(Billing billing, Transaction transaction) {
        this.f5391a = billing;
        this.f5392b = transaction;
    }

    public final Object call(Object obj) {
        return this.f5391a.mo826a(this.f5392b, (Authorization) obj);
    }
}
