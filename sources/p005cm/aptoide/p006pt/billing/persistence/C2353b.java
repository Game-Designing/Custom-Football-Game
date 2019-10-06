package p005cm.aptoide.p006pt.billing.persistence;

import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.billing.persistence.b */
/* compiled from: lambda */
public final /* synthetic */ class C2353b implements C0128a {

    /* renamed from: a */
    private final /* synthetic */ InMemoryTransactionPersistence f5493a;

    /* renamed from: b */
    private final /* synthetic */ Transaction f5494b;

    public /* synthetic */ C2353b(InMemoryTransactionPersistence inMemoryTransactionPersistence, Transaction transaction) {
        this.f5493a = inMemoryTransactionPersistence;
        this.f5494b = transaction;
    }

    public final void call() {
        this.f5493a.mo11211a(this.f5494b);
    }
}
