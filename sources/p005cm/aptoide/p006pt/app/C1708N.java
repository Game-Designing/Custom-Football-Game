package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.N */
/* compiled from: lambda */
public final /* synthetic */ class C1708N implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f4667a;

    public /* synthetic */ C1708N(Download download) {
        this.f4667a = download;
    }

    public final Object call(Object obj) {
        Download download = this.f4667a;
        AppViewManager.m6425a(download, (OfferResponseStatus) obj);
        return download;
    }
}
