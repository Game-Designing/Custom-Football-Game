package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.K */
/* compiled from: lambda */
public final /* synthetic */ class C1705K implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f4664a;

    public /* synthetic */ C1705K(Download download) {
        this.f4664a = download;
    }

    public final Object call(Object obj) {
        Download download = this.f4664a;
        AppViewManager.m6432c(download, (OfferResponseStatus) obj);
        return download;
    }
}
