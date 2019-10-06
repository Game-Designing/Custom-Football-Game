package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.networking.Authentication;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.e */
/* compiled from: lambda */
public final /* synthetic */ class C2312e implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AuthorizationServiceV7 f5417a;

    /* renamed from: b */
    private final /* synthetic */ String f5418b;

    /* renamed from: c */
    private final /* synthetic */ String f5419c;

    public /* synthetic */ C2312e(AuthorizationServiceV7 authorizationServiceV7, String str, String str2) {
        this.f5417a = authorizationServiceV7;
        this.f5418b = str;
        this.f5419c = str2;
    }

    public final Object call(Object obj) {
        return this.f5417a.mo11152a(this.f5418b, this.f5419c, (Authentication) obj);
    }
}
