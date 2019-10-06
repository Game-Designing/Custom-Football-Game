package p005cm.aptoide.p006pt.billing.networking;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.UpdateAuthorizationRequest.ResponseBody;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.networking.g */
/* compiled from: lambda */
public final /* synthetic */ class C2314g implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AuthorizationServiceV7 f5423a;

    /* renamed from: b */
    private final /* synthetic */ String f5424b;

    /* renamed from: c */
    private final /* synthetic */ String f5425c;

    public /* synthetic */ C2314g(AuthorizationServiceV7 authorizationServiceV7, String str, String str2) {
        this.f5423a = authorizationServiceV7;
        this.f5424b = str;
        this.f5425c = str2;
    }

    public final Object call(Object obj) {
        return this.f5423a.mo11153a(this.f5424b, this.f5425c, (ResponseBody) obj);
    }
}
