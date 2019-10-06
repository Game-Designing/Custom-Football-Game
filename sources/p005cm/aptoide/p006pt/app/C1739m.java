package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.app.m */
/* compiled from: lambda */
public final /* synthetic */ class C1739m implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AppViewManager f4715a;

    /* renamed from: b */
    private final /* synthetic */ Download f4716b;

    /* renamed from: c */
    private final /* synthetic */ Action f4717c;

    /* renamed from: d */
    private final /* synthetic */ long f4718d;

    public /* synthetic */ C1739m(AppViewManager appViewManager, Download download, Action action, long j) {
        this.f4715a = appViewManager;
        this.f4716b = download;
        this.f4717c = action;
        this.f4718d = j;
    }

    public final void call(Object obj) {
        this.f4715a.mo10170a(this.f4716b, this.f4717c, this.f4718d, (OfferResponseStatus) obj);
    }
}
