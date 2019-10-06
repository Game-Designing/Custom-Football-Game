package p005cm.aptoide.p006pt.home.apps;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.home.apps.ha */
/* compiled from: lambda */
public final /* synthetic */ class C3703ha implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AppsManager f7106a;

    /* renamed from: b */
    private final /* synthetic */ OfferResponseStatus f7107b;

    public /* synthetic */ C3703ha(AppsManager appsManager, OfferResponseStatus offerResponseStatus) {
        this.f7106a = appsManager;
        this.f7107b = offerResponseStatus;
    }

    public final void call(Object obj) {
        this.f7106a.mo14663a(this.f7107b, (Download) obj);
    }
}
