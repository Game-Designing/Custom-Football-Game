package p005cm.aptoide.p006pt.editorial;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.editorial.M */
/* compiled from: lambda */
public final /* synthetic */ class C3096M implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ EditorialManager f6442a;

    /* renamed from: b */
    private final /* synthetic */ Download f6443b;

    /* renamed from: c */
    private final /* synthetic */ String f6444c;

    /* renamed from: d */
    private final /* synthetic */ long f6445d;

    public /* synthetic */ C3096M(EditorialManager editorialManager, Download download, String str, long j) {
        this.f6442a = editorialManager;
        this.f6443b = download;
        this.f6444c = str;
        this.f6445d = j;
    }

    public final void call(Object obj) {
        this.f6442a.mo13861a(this.f6443b, this.f6444c, this.f6445d, (OfferResponseStatus) obj);
    }
}
