package p005cm.aptoide.p006pt.editorial;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorial.G */
/* compiled from: lambda */
public final /* synthetic */ class C3078G implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f6417a;

    public /* synthetic */ C3078G(Download download) {
        this.f6417a = download;
    }

    public final Object call(Object obj) {
        Download download = this.f6417a;
        EditorialManager.m7699a(download, (OfferResponseStatus) obj);
        return download;
    }
}
