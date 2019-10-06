package p005cm.aptoide.p006pt.promotions;

import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.promotions.Xa */
/* compiled from: lambda */
public final /* synthetic */ class C4497Xa implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ PromotionsManager f8108a;

    /* renamed from: b */
    private final /* synthetic */ Download f8109b;

    /* renamed from: c */
    private final /* synthetic */ String f8110c;

    /* renamed from: d */
    private final /* synthetic */ long f8111d;

    public /* synthetic */ C4497Xa(PromotionsManager promotionsManager, Download download, String str, long j) {
        this.f8108a = promotionsManager;
        this.f8109b = download;
        this.f8110c = str;
        this.f8111d = j;
    }

    public final void call(Object obj) {
        this.f8108a.mo15714a(this.f8109b, this.f8110c, this.f8111d, (OfferResponseStatus) obj);
    }
}
