package p005cm.aptoide.p006pt.promotions;

import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.promotions.Ya */
/* compiled from: lambda */
public final /* synthetic */ class C4500Ya implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ PromotionsManager f8114a;

    /* renamed from: b */
    private final /* synthetic */ String f8115b;

    /* renamed from: c */
    private final /* synthetic */ long f8116c;

    public /* synthetic */ C4500Ya(PromotionsManager promotionsManager, String str, long j) {
        this.f8114a = promotionsManager;
        this.f8115b = str;
        this.f8116c = j;
    }

    public final Object call(Object obj) {
        return this.f8114a.mo15712a(this.f8115b, this.f8116c, (Download) obj);
    }
}
