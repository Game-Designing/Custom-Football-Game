package p005cm.aptoide.p006pt.home.apps;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.apps.fa */
/* compiled from: lambda */
public final /* synthetic */ class C3689fa implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f7092a;

    public /* synthetic */ C3689fa(Download download) {
        this.f7092a = download;
    }

    public final Object call(Object obj) {
        Download download = this.f7092a;
        AppsManager.m8238b(download, (OfferResponseStatus) obj);
        return download;
    }
}
