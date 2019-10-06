package p005cm.aptoide.p006pt.networking;

import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;

/* renamed from: cm.aptoide.pt.networking.h */
/* compiled from: lambda */
public final /* synthetic */ class C4150h implements Callable {

    /* renamed from: a */
    private final /* synthetic */ NoAuthenticationBodyInterceptorV3 f7696a;

    /* renamed from: b */
    private final /* synthetic */ BaseBody f7697b;

    public /* synthetic */ C4150h(NoAuthenticationBodyInterceptorV3 noAuthenticationBodyInterceptorV3, BaseBody baseBody) {
        this.f7696a = noAuthenticationBodyInterceptorV3;
        this.f7697b = baseBody;
    }

    public final Object call() {
        return this.f7696a.mo15226a(this.f7697b);
    }
}
