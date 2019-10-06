package p005cm.aptoide.p006pt.editorial;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorial.K */
/* compiled from: lambda */
public final /* synthetic */ class C3090K implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f6435a;

    public /* synthetic */ C3090K(Download download) {
        this.f6435a = download;
    }

    public final Object call(Object obj) {
        Download download = this.f6435a;
        EditorialManager.m7700b(download, (OfferResponseStatus) obj);
        return download;
    }
}
