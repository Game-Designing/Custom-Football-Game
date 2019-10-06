package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TransactionResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.t */
/* compiled from: lambda */
public final /* synthetic */ class C2327t implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ TransactionServiceV3 f5449a;

    /* renamed from: b */
    private final /* synthetic */ String f5450b;

    /* renamed from: c */
    private final /* synthetic */ String f5451c;

    public /* synthetic */ C2327t(TransactionServiceV3 transactionServiceV3, String str, String str2) {
        this.f5449a = transactionServiceV3;
        this.f5450b = str;
        this.f5451c = str2;
    }

    public final Object call(Object obj) {
        return this.f5449a.mo11174a(this.f5450b, this.f5451c, (TransactionResponse) obj);
    }
}
