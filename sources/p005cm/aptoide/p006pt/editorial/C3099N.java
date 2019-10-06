package p005cm.aptoide.p006pt.editorial;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.editorial.N */
/* compiled from: lambda */
public final /* synthetic */ class C3099N implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ EditorialManager f6448a;

    /* renamed from: b */
    private final /* synthetic */ Download f6449b;

    /* renamed from: c */
    private final /* synthetic */ EditorialDownloadEvent f6450c;

    public /* synthetic */ C3099N(EditorialManager editorialManager, Download download, EditorialDownloadEvent editorialDownloadEvent) {
        this.f6448a = editorialManager;
        this.f6449b = download;
        this.f6450c = editorialDownloadEvent;
    }

    public final void call(Object obj) {
        this.f6448a.mo13860a(this.f6449b, this.f6450c, (OfferResponseStatus) obj);
    }
}
