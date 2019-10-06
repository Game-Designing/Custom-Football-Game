package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetProductsRequest.ResponseBody;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.q */
/* compiled from: lambda */
public final /* synthetic */ class C2324q implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ BillingServiceV7 f5441a;

    /* renamed from: b */
    private final /* synthetic */ String f5442b;

    public /* synthetic */ C2324q(BillingServiceV7 billingServiceV7, String str) {
        this.f5441a = billingServiceV7;
        this.f5442b = str;
    }

    public final Object call(Object obj) {
        return this.f5441a.mo11160a(this.f5442b, (ResponseBody) obj);
    }
}
