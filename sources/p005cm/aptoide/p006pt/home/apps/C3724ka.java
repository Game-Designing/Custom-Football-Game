package p005cm.aptoide.p006pt.home.apps;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.apps.ka */
/* compiled from: lambda */
public final /* synthetic */ class C3724ka implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f7132a;

    public /* synthetic */ C3724ka(Download download) {
        this.f7132a = download;
    }

    public final Object call(Object obj) {
        Download download = this.f7132a;
        AppsManager.m8241d(download, (OfferResponseStatus) obj);
        return download;
    }
}
