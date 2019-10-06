package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.u */
/* compiled from: lambda */
public final /* synthetic */ class C2328u implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ TransactionServiceV3 f5452a;

    /* renamed from: b */
    private final /* synthetic */ String f5453b;

    /* renamed from: c */
    private final /* synthetic */ String f5454c;

    public /* synthetic */ C2328u(TransactionServiceV3 transactionServiceV3, String str, String str2) {
        this.f5452a = transactionServiceV3;
        this.f5453b = str;
        this.f5454c = str2;
    }

    public final Object call(Object obj) {
        return this.f5452a.mo11175b(this.f5453b, this.f5454c, (PaidApp) obj);
    }
}
