package p005cm.aptoide.p006pt.account;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.BaseV3Response;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.c */
/* compiled from: lambda */
public final /* synthetic */ class C1432c implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AccountServiceV3 f4349a;

    /* renamed from: b */
    private final /* synthetic */ String f4350b;

    /* renamed from: c */
    private final /* synthetic */ String f4351c;

    public /* synthetic */ C1432c(AccountServiceV3 accountServiceV3, String str, String str2) {
        this.f4349a = accountServiceV3;
        this.f4350b = str;
        this.f4351c = str2;
    }

    public final Object call(Object obj) {
        return this.f4349a.mo9583a(this.f4350b, this.f4351c, (BaseV3Response) obj);
    }
}
