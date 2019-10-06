package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetProductsRequest.ResponseBody.Product;
import p026rx.p027b.C14541q;

/* renamed from: cm.aptoide.pt.billing.networking.r */
/* compiled from: lambda */
public final /* synthetic */ class C2325r implements C14541q {

    /* renamed from: a */
    private final /* synthetic */ BillingServiceV7 f5443a;

    /* renamed from: b */
    private final /* synthetic */ String f5444b;

    /* renamed from: c */
    private final /* synthetic */ Product f5445c;

    public /* synthetic */ C2325r(BillingServiceV7 billingServiceV7, String str, Product product) {
        this.f5443a = billingServiceV7;
        this.f5444b = str;
        this.f5445c = product;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f5443a.mo11157a(this.f5444b, this.f5445c, (Integer) obj, (String) obj2);
    }
}
