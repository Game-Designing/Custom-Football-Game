package p005cm.aptoide.p006pt.home.apps;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Update;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.apps.U */
/* compiled from: lambda */
public final /* synthetic */ class C3612U implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppsManager f7001a;

    /* renamed from: b */
    private final /* synthetic */ OfferResponseStatus f7002b;

    public /* synthetic */ C3612U(AppsManager appsManager, OfferResponseStatus offerResponseStatus) {
        this.f7001a = appsManager;
        this.f7002b = offerResponseStatus;
    }

    public final Object call(Object obj) {
        return this.f7001a.mo14658a(this.f7002b, (Update) obj);
    }
}
