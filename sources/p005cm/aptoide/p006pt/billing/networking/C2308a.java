package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.a */
/* compiled from: lambda */
public final /* synthetic */ class C2308a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AuthorizationServiceV3 f5402a;

    /* renamed from: b */
    private final /* synthetic */ String f5403b;

    /* renamed from: c */
    private final /* synthetic */ String f5404c;

    public /* synthetic */ C2308a(AuthorizationServiceV3 authorizationServiceV3, String str, String str2) {
        this.f5402a = authorizationServiceV3;
        this.f5403b = str;
        this.f5404c = str2;
    }

    public final Object call(Object obj) {
        return this.f5402a.mo11149a(this.f5403b, this.f5404c, (PaidApp) obj);
    }
}
