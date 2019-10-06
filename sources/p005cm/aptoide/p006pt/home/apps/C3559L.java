package p005cm.aptoide.p006pt.home.apps;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.home.apps.L */
/* compiled from: lambda */
public final /* synthetic */ class C3559L implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AppsManager f6941a;

    /* renamed from: b */
    private final /* synthetic */ Download f6942b;

    public /* synthetic */ C3559L(AppsManager appsManager, Download download) {
        this.f6941a = appsManager;
        this.f6942b = download;
    }

    public final void call(Object obj) {
        this.f6941a.mo14672c(this.f6942b, (OfferResponseStatus) obj);
    }
}
