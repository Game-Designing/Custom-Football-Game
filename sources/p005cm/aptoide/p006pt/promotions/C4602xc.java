package p005cm.aptoide.p006pt.promotions;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.promotions.xc */
/* compiled from: lambda */
public final /* synthetic */ class C4602xc implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ PromotionsService f8234a;

    public /* synthetic */ C4602xc(PromotionsService promotionsService) {
        this.f8234a = promotionsService;
    }

    public final Object call(Object obj) {
        return this.f8234a.mapClaim((BaseV7Response) obj);
    }
}
