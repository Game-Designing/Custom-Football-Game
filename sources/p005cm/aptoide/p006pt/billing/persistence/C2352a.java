package p005cm.aptoide.p006pt.billing.persistence;

import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.persistence.a */
/* compiled from: lambda */
public final /* synthetic */ class C2352a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ String f5490a;

    /* renamed from: b */
    private final /* synthetic */ String f5491b;

    /* renamed from: c */
    private final /* synthetic */ String f5492c;

    public /* synthetic */ C2352a(String str, String str2, String str3) {
        this.f5490a = str;
        this.f5491b = str2;
        this.f5492c = str3;
    }

    public final Object call(Object obj) {
        return InMemoryTransactionPersistence.m7024a(this.f5490a, this.f5491b, this.f5492c, (Transaction) obj);
    }
}
