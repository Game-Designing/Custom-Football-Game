package p005cm.aptoide.p006pt.billing;

import java.util.List;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p005cm.aptoide.p006pt.billing.transaction.AuthorizedTransaction;
import p026rx.p027b.C14541q;

/* renamed from: cm.aptoide.pt.billing.m */
/* compiled from: lambda */
public final /* synthetic */ class C2306m implements C14541q {

    /* renamed from: a */
    private final /* synthetic */ Product f5397a;

    /* renamed from: b */
    private final /* synthetic */ AuthorizedTransaction f5398b;

    /* renamed from: c */
    private final /* synthetic */ List f5399c;

    public /* synthetic */ C2306m(Product product, AuthorizedTransaction authorizedTransaction, List list) {
        this.f5397a = product;
        this.f5398b = authorizedTransaction;
        this.f5399c = list;
    }

    public final Object call(Object obj, Object obj2) {
        return Billing.m152a(this.f5397a, this.f5398b, this.f5399c, (PaymentService) obj, (Purchase) obj2);
    }
}
