package p005cm.aptoide.p006pt.promotions;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.promotions.Pa */
/* compiled from: lambda */
public final /* synthetic */ class C4470Pa implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ PromotionsManager f8080a;

    /* renamed from: b */
    private final /* synthetic */ Download f8081b;

    /* renamed from: c */
    private final /* synthetic */ PromotionViewApp f8082c;

    public /* synthetic */ C4470Pa(PromotionsManager promotionsManager, Download download, PromotionViewApp promotionViewApp) {
        this.f8080a = promotionsManager;
        this.f8081b = download;
        this.f8082c = promotionViewApp;
    }

    public final void call(Object obj) {
        this.f8080a.mo15713a(this.f8081b, this.f8082c, (OfferResponseStatus) obj);
    }
}
