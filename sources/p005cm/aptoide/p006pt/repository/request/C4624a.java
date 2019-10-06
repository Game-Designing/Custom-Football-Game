package p005cm.aptoide.p006pt.repository.request;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListAppCoinsCampaigns;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.repository.request.a */
/* compiled from: lambda */
public final /* synthetic */ class C4624a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ RewardAppCoinsAppsRepository f8264a;

    /* renamed from: b */
    private final /* synthetic */ String f8265b;

    public /* synthetic */ C4624a(RewardAppCoinsAppsRepository rewardAppCoinsAppsRepository, String str) {
        this.f8264a = rewardAppCoinsAppsRepository;
        this.f8265b = str;
    }

    public final Object call(Object obj) {
        return this.f8264a.mo15947a(this.f8265b, (ListAppCoinsCampaigns) obj);
    }
}
