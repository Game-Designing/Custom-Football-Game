package p005cm.aptoide.p006pt.promotions;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.promotions.La */
/* compiled from: lambda */
public final /* synthetic */ class C4458La implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f8065a;

    public /* synthetic */ C4458La(Download download) {
        this.f8065a = download;
    }

    public final Object call(Object obj) {
        Download download = this.f8065a;
        PromotionsManager.m8881b(download, (OfferResponseStatus) obj);
        return download;
    }
}
