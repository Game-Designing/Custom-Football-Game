package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.i */
/* compiled from: lambda */
public final /* synthetic */ class C2316i implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ BillingServiceV3 f5427a;

    /* renamed from: b */
    private final /* synthetic */ String f5428b;

    public /* synthetic */ C2316i(BillingServiceV3 billingServiceV3, String str) {
        this.f5427a = billingServiceV3;
        this.f5428b = str;
    }

    public final Object call(Object obj) {
        return this.f5427a.mo11156a(this.f5428b, (PaidApp) obj);
    }
}
