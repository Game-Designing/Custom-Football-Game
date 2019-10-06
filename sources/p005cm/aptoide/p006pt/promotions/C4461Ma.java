package p005cm.aptoide.p006pt.promotions;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.promotions.Ma */
/* compiled from: lambda */
public final /* synthetic */ class C4461Ma implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f8068a;

    public /* synthetic */ C4461Ma(Download download) {
        this.f8068a = download;
    }

    public final Object call(Object obj) {
        Download download = this.f8068a;
        PromotionsManager.m8877a(download, (OfferResponseStatus) obj);
        return download;
    }
}
