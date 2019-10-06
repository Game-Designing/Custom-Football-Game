package p005cm.aptoide.p006pt.billing;

import java.util.List;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.billing.transaction.AuthorizedTransaction;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.b */
/* compiled from: lambda */
public final /* synthetic */ class C2290b implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Billing f5374a;

    /* renamed from: b */
    private final /* synthetic */ Product f5375b;

    /* renamed from: c */
    private final /* synthetic */ List f5376c;

    public /* synthetic */ C2290b(Billing billing, Product product, List list) {
        this.f5374a = billing;
        this.f5375b = product;
        this.f5376c = list;
    }

    public final Object call(Object obj) {
        return this.f5374a.mo824a(this.f5375b, this.f5376c, (AuthorizedTransaction) obj);
    }
}
