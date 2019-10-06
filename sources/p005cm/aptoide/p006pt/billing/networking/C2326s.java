package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.s */
/* compiled from: lambda */
public final /* synthetic */ class C2326s implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ TransactionServiceV3 f5446a;

    /* renamed from: b */
    private final /* synthetic */ String f5447b;

    /* renamed from: c */
    private final /* synthetic */ String f5448c;

    public /* synthetic */ C2326s(TransactionServiceV3 transactionServiceV3, String str, String str2) {
        this.f5446a = transactionServiceV3;
        this.f5447b = str;
        this.f5448c = str2;
    }

    public final Object call(Object obj) {
        return this.f5446a.mo11173a(this.f5447b, this.f5448c, (PaidApp) obj);
    }
}
