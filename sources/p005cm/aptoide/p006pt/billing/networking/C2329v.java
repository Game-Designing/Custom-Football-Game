package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.CreateTransactionRequest.ResponseBody;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.v */
/* compiled from: lambda */
public final /* synthetic */ class C2329v implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ TransactionServiceV7 f5455a;

    /* renamed from: b */
    private final /* synthetic */ String f5456b;

    /* renamed from: c */
    private final /* synthetic */ String f5457c;

    public /* synthetic */ C2329v(TransactionServiceV7 transactionServiceV7, String str, String str2) {
        this.f5455a = transactionServiceV7;
        this.f5456b = str;
        this.f5457c = str2;
    }

    public final Object call(Object obj) {
        return this.f5455a.mo11182b(this.f5456b, this.f5457c, (ResponseBody) obj);
    }
}
