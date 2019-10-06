package p005cm.aptoide.p006pt.analytics.analytics;

import p005cm.aptoide.analytics.implementation.network.AnalyticsBaseBody;
import p005cm.aptoide.p006pt.networking.Authentication;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.analytics.analytics.a */
/* compiled from: lambda */
public final /* synthetic */ class C1680a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AnalyticsBodyInterceptorV7 f4632a;

    /* renamed from: b */
    private final /* synthetic */ AnalyticsBaseBody f4633b;

    public /* synthetic */ C1680a(AnalyticsBodyInterceptorV7 analyticsBodyInterceptorV7, AnalyticsBaseBody analyticsBaseBody) {
        this.f4632a = analyticsBodyInterceptorV7;
        this.f4633b = analyticsBaseBody;
    }

    public final Object call(Object obj) {
        return this.f4632a.mo10062a(this.f4633b, (Authentication) obj);
    }
}
