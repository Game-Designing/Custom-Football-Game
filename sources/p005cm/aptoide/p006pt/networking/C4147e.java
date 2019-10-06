package p005cm.aptoide.p006pt.networking;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.networking.e */
/* compiled from: lambda */
public final /* synthetic */ class C4147e implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ BodyInterceptorV3 f7690a;

    /* renamed from: b */
    private final /* synthetic */ BaseBody f7691b;

    public /* synthetic */ C4147e(BodyInterceptorV3 bodyInterceptorV3, BaseBody baseBody) {
        this.f7690a = bodyInterceptorV3;
        this.f7691b = baseBody;
    }

    public final Object call(Object obj) {
        return this.f7690a.mo15220a(this.f7691b, (Authentication) obj);
    }
}
