package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.networking.Authentication;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.y */
/* compiled from: lambda */
public final /* synthetic */ class C2332y implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ TransactionServiceV7 f5464a;

    /* renamed from: b */
    private final /* synthetic */ String f5465b;

    /* renamed from: c */
    private final /* synthetic */ String f5466c;

    public /* synthetic */ C2332y(TransactionServiceV7 transactionServiceV7, String str, String str2) {
        this.f5464a = transactionServiceV7;
        this.f5465b = str;
        this.f5466c = str2;
    }

    public final Object call(Object obj) {
        return this.f5464a.mo11179a(this.f5465b, this.f5466c, (Authentication) obj);
    }
}
