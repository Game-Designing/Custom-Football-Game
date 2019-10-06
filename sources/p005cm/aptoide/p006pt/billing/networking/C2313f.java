package p005cm.aptoide.p006pt.billing.networking;

import p026rx.p027b.C0132p;
import retrofit2.Response;

/* renamed from: cm.aptoide.pt.billing.networking.f */
/* compiled from: lambda */
public final /* synthetic */ class C2313f implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AuthorizationServiceV7 f5420a;

    /* renamed from: b */
    private final /* synthetic */ String f5421b;

    /* renamed from: c */
    private final /* synthetic */ String f5422c;

    public /* synthetic */ C2313f(AuthorizationServiceV7 authorizationServiceV7, String str, String str2) {
        this.f5420a = authorizationServiceV7;
        this.f5421b = str;
        this.f5422c = str2;
    }

    public final Object call(Object obj) {
        return this.f5420a.mo11154a(this.f5421b, this.f5422c, (Response) obj);
    }
}
