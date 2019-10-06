package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.CreateTransactionRequest.ResponseBody;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.w */
/* compiled from: lambda */
public final /* synthetic */ class C2330w implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ TransactionServiceV7 f5458a;

    /* renamed from: b */
    private final /* synthetic */ String f5459b;

    /* renamed from: c */
    private final /* synthetic */ String f5460c;

    public /* synthetic */ C2330w(TransactionServiceV7 transactionServiceV7, String str, String str2) {
        this.f5458a = transactionServiceV7;
        this.f5459b = str;
        this.f5460c = str2;
    }

    public final Object call(Object obj) {
        return this.f5458a.mo11180a(this.f5459b, this.f5460c, (ResponseBody) obj);
    }
}
