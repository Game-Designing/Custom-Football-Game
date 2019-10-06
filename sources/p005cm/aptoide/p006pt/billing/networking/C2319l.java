package p005cm.aptoide.p006pt.billing.networking;

import p026rx.p027b.C0132p;
import retrofit2.Response;

/* renamed from: cm.aptoide.pt.billing.networking.l */
/* compiled from: lambda */
public final /* synthetic */ class C2319l implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ BillingServiceV7 f5431a;

    /* renamed from: b */
    private final /* synthetic */ String f5432b;

    public /* synthetic */ C2319l(BillingServiceV7 billingServiceV7, String str) {
        this.f5431a = billingServiceV7;
        this.f5432b = str;
    }

    public final Object call(Object obj) {
        return this.f5431a.mo11162a(this.f5432b, (Response) obj);
    }
}
