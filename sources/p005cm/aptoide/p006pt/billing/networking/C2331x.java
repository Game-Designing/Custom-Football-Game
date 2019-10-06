package p005cm.aptoide.p006pt.billing.networking;

import p026rx.p027b.C0132p;
import retrofit2.Response;

/* renamed from: cm.aptoide.pt.billing.networking.x */
/* compiled from: lambda */
public final /* synthetic */ class C2331x implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ TransactionServiceV7 f5461a;

    /* renamed from: b */
    private final /* synthetic */ String f5462b;

    /* renamed from: c */
    private final /* synthetic */ String f5463c;

    public /* synthetic */ C2331x(TransactionServiceV7 transactionServiceV7, String str, String str2) {
        this.f5461a = transactionServiceV7;
        this.f5462b = str;
        this.f5463c = str2;
    }

    public final Object call(Object obj) {
        return this.f5461a.mo11181a(this.f5462b, this.f5463c, (Response) obj);
    }
}
