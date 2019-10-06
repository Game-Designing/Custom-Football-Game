package p005cm.aptoide.p006pt.app.view.donations;

import p005cm.aptoide.p006pt.app.view.donations.data.GetDonations;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.donations.a */
/* compiled from: lambda */
public final /* synthetic */ class C2038a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ DonationsService f5081a;

    public /* synthetic */ C2038a(DonationsService donationsService) {
        this.f5081a = donationsService;
    }

    public final Object call(Object obj) {
        return this.f5081a.mapToDonationsList((GetDonations) obj);
    }
}
