package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TransactionResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.d */
/* compiled from: lambda */
public final /* synthetic */ class C2311d implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AuthorizationServiceV3 f5413a;

    /* renamed from: b */
    private final /* synthetic */ String f5414b;

    /* renamed from: c */
    private final /* synthetic */ String f5415c;

    /* renamed from: d */
    private final /* synthetic */ PaidApp f5416d;

    public /* synthetic */ C2311d(AuthorizationServiceV3 authorizationServiceV3, String str, String str2, PaidApp paidApp) {
        this.f5413a = authorizationServiceV3;
        this.f5414b = str;
        this.f5415c = str2;
        this.f5416d = paidApp;
    }

    public final Object call(Object obj) {
        return this.f5413a.mo11151b(this.f5414b, this.f5415c, this.f5416d, (TransactionResponse) obj);
    }
}
