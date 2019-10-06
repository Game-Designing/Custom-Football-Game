package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.c */
/* compiled from: lambda */
public final /* synthetic */ class C2310c implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AuthorizationServiceV3 f5409a;

    /* renamed from: b */
    private final /* synthetic */ String f5410b;

    /* renamed from: c */
    private final /* synthetic */ String f5411c;

    /* renamed from: d */
    private final /* synthetic */ String f5412d;

    public /* synthetic */ C2310c(AuthorizationServiceV3 authorizationServiceV3, String str, String str2, String str3) {
        this.f5409a = authorizationServiceV3;
        this.f5410b = str;
        this.f5411c = str2;
        this.f5412d = str3;
    }

    public final Object call(Object obj) {
        return this.f5409a.mo11150a(this.f5410b, this.f5411c, this.f5412d, (PaidApp) obj);
    }
}
