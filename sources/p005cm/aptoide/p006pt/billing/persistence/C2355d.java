package p005cm.aptoide.p006pt.billing.persistence;

import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.persistence.d */
/* compiled from: lambda */
public final /* synthetic */ class C2355d implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ String f5497a;

    /* renamed from: b */
    private final /* synthetic */ String f5498b;

    public /* synthetic */ C2355d(String str, String str2) {
        this.f5497a = str;
        this.f5498b = str2;
    }

    public final Object call(Object obj) {
        return InMemoryTransactionPersistence.m7023a(this.f5497a, this.f5498b, (Transaction) obj);
    }
}
