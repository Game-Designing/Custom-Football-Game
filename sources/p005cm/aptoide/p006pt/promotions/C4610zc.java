package p005cm.aptoide.p006pt.promotions;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPromotionAppsResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.promotions.zc */
/* compiled from: lambda */
public final /* synthetic */ class C4610zc implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ PromotionsService f8243a;

    public /* synthetic */ C4610zc(PromotionsService promotionsService) {
        this.f8243a = promotionsService;
    }

    public final Object call(Object obj) {
        return this.f8243a.mapPromotionsResponse((GetPromotionAppsResponse) obj);
    }
}
