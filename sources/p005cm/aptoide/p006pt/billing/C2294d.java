package p005cm.aptoide.p006pt.billing;

import p005cm.aptoide.p006pt.billing.transaction.AuthorizedTransaction;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.d */
/* compiled from: lambda */
public final /* synthetic */ class C2294d implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Billing f5380a;

    /* renamed from: b */
    private final /* synthetic */ String f5381b;

    public /* synthetic */ C2294d(Billing billing, String str) {
        this.f5380a = billing;
        this.f5381b = str;
    }

    public final Object call(Object obj) {
        return this.f5380a.mo823a(this.f5381b, (AuthorizedTransaction) obj);
    }
}
