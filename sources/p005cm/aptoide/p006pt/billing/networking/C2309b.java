package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TransactionResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.b */
/* compiled from: lambda */
public final /* synthetic */ class C2309b implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AuthorizationServiceV3 f5405a;

    /* renamed from: b */
    private final /* synthetic */ String f5406b;

    /* renamed from: c */
    private final /* synthetic */ String f5407c;

    /* renamed from: d */
    private final /* synthetic */ PaidApp f5408d;

    public /* synthetic */ C2309b(AuthorizationServiceV3 authorizationServiceV3, String str, String str2, PaidApp paidApp) {
        this.f5405a = authorizationServiceV3;
        this.f5406b = str;
        this.f5407c = str2;
        this.f5408d = paidApp;
    }

    public final Object call(Object obj) {
        return this.f5405a.mo11148a(this.f5406b, this.f5407c, this.f5408d, (TransactionResponse) obj);
    }
}
