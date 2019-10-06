package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.C */
/* compiled from: lambda */
public final /* synthetic */ class C1696C implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f4653a;

    public /* synthetic */ C1696C(Download download) {
        this.f4653a = download;
    }

    public final Object call(Object obj) {
        Download download = this.f4653a;
        AppViewManager.m6430b(download, (OfferResponseStatus) obj);
        return download;
    }
}
