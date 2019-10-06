package p005cm.aptoide.p006pt.home.apps;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.home.apps.ja */
/* compiled from: lambda */
public final /* synthetic */ class C3717ja implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AppsManager f7124a;

    /* renamed from: b */
    private final /* synthetic */ Download f7125b;

    public /* synthetic */ C3717ja(AppsManager appsManager, Download download) {
        this.f7124a = appsManager;
        this.f7125b = download;
    }

    public final void call(Object obj) {
        this.f7124a.mo14664a(this.f7125b, (OfferResponseStatus) obj);
    }
}
