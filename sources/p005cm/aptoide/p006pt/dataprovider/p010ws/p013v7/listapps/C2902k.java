package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppsUpdatesRequest.Body;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.listapps.k */
/* compiled from: lambda */
public final /* synthetic */ class C2902k implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Interfaces f6177a;

    /* renamed from: b */
    private final /* synthetic */ boolean f6178b;

    public /* synthetic */ C2902k(Interfaces interfaces, boolean z) {
        this.f6177a = interfaces;
        this.f6178b = z;
    }

    public final Object call(Object obj) {
        return this.f6177a.listAppsUpdates((Body) obj, this.f6178b);
    }
}
