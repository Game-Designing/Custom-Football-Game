package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetProductsRequest.ResponseBody;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.o */
/* compiled from: lambda */
public final /* synthetic */ class C2322o implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ BillingServiceV7 f5435a;

    /* renamed from: b */
    private final /* synthetic */ String f5436b;

    /* renamed from: c */
    private final /* synthetic */ String f5437c;

    public /* synthetic */ C2322o(BillingServiceV7 billingServiceV7, String str, String str2) {
        this.f5435a = billingServiceV7;
        this.f5436b = str;
        this.f5437c = str2;
    }

    public final Object call(Object obj) {
        return this.f5435a.mo11161a(this.f5436b, this.f5437c, (ResponseBody) obj);
    }
}
