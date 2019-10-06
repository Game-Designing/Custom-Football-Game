package p005cm.aptoide.p006pt.billing;

import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.g */
/* compiled from: lambda */
public final /* synthetic */ class C2300g implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Transaction f5389a;

    public /* synthetic */ C2300g(Transaction transaction) {
        this.f5389a = transaction;
    }

    public final Object call(Object obj) {
        return Billing.m155b(this.f5389a, (Authorization) obj);
    }
}
