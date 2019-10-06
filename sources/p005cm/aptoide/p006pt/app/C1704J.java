package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.app.J */
/* compiled from: lambda */
public final /* synthetic */ class C1704J implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AppViewManager f4661a;

    /* renamed from: b */
    private final /* synthetic */ Download f4662b;

    /* renamed from: c */
    private final /* synthetic */ WalletApp f4663c;

    public /* synthetic */ C1704J(AppViewManager appViewManager, Download download, WalletApp walletApp) {
        this.f4661a = appViewManager;
        this.f4662b = download;
        this.f4663c = walletApp;
    }

    public final void call(Object obj) {
        this.f4661a.mo10172a(this.f4662b, this.f4663c, (OfferResponseStatus) obj);
    }
}
