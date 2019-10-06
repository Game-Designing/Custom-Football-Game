package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.app.s */
/* compiled from: lambda */
public final /* synthetic */ class C1746s implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AppViewManager f4733a;

    /* renamed from: b */
    private final /* synthetic */ Download f4734b;

    /* renamed from: c */
    private final /* synthetic */ Action f4735c;

    /* renamed from: d */
    private final /* synthetic */ long f4736d;

    /* renamed from: e */
    private final /* synthetic */ String f4737e;

    /* renamed from: f */
    private final /* synthetic */ String f4738f;

    public /* synthetic */ C1746s(AppViewManager appViewManager, Download download, Action action, long j, String str, String str2) {
        this.f4733a = appViewManager;
        this.f4734b = download;
        this.f4735c = action;
        this.f4736d = j;
        this.f4737e = str;
        this.f4738f = str2;
    }

    public final void call(Object obj) {
        this.f4733a.mo10171a(this.f4734b, this.f4735c, this.f4736d, this.f4737e, this.f4738f, (OfferResponseStatus) obj);
    }
}
