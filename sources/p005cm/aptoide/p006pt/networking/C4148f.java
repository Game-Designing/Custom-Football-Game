package p005cm.aptoide.p006pt.networking;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.networking.f */
/* compiled from: lambda */
public final /* synthetic */ class C4148f implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ BodyInterceptorV7 f7692a;

    /* renamed from: b */
    private final /* synthetic */ BaseBody f7693b;

    public /* synthetic */ C4148f(BodyInterceptorV7 bodyInterceptorV7, BaseBody baseBody) {
        this.f7692a = bodyInterceptorV7;
        this.f7693b = baseBody;
    }

    public final Object call(Object obj) {
        return this.f7692a.mo15222a(this.f7693b, (Authentication) obj);
    }
}
