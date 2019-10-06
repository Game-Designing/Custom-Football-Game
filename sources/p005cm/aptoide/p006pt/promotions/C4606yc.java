package p005cm.aptoide.p006pt.promotions;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPackagePromotionsResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.promotions.yc */
/* compiled from: lambda */
public final /* synthetic */ class C4606yc implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ PromotionsService f8238a;

    public /* synthetic */ C4606yc(PromotionsService promotionsService) {
        this.f8238a = promotionsService;
    }

    public final Object call(Object obj) {
        return this.f8238a.mapToPromotion((GetPackagePromotionsResponse) obj);
    }
}
