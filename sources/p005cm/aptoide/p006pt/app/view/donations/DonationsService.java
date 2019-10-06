package p005cm.aptoide.p006pt.app.view.donations;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.donations.data.GetDonations;
import p005cm.aptoide.p006pt.app.view.donations.data.GetDonations.Donor;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* renamed from: cm.aptoide.pt.app.view.donations.DonationsService */
public class DonationsService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C0126V ioScheduler;
    private ServiceV8 service;

    /* renamed from: cm.aptoide.pt.app.view.donations.DonationsService$ServiceV8 */
    public interface ServiceV8 {
        @GET("broker/8.20181010/leaderboard/donations")
        C0120S<GetDonations> getDonations(@Query("domain") String str, @Query("limit") int i);
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8958910446731640491L, "cm/aptoide/pt/app/view/donations/DonationsService", 11);
        $jacocoData = probes;
        return probes;
    }

    public DonationsService(ServiceV8 service2, C0126V ioScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service = service2;
        this.ioScheduler = ioScheduler2;
        $jacocoInit[0] = true;
    }

    public Single<List<Donation>> getDonations(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S donations = this.service.getDonations(packageName, 5);
        C0126V v = this.ioScheduler;
        $jacocoInit[1] = true;
        C0120S b = donations.mo3634b(v);
        C2038a aVar = new C2038a(this);
        $jacocoInit[2] = true;
        C0120S j = b.mo3669j(aVar);
        $jacocoInit[3] = true;
        Single<List<Donation>> n = j.mo3678n();
        $jacocoInit[4] = true;
        return n;
    }

    /* access modifiers changed from: private */
    public List<Donation> mapToDonationsList(GetDonations donationsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        List<Donation> result = new ArrayList<>();
        $jacocoInit[5] = true;
        $jacocoInit[6] = true;
        for (Donor donor : donationsResponse.getItems()) {
            $jacocoInit[7] = true;
            Donation donation = new Donation(donor.getDomain(), donor.getOwner(), Float.parseFloat(donor.getAppc()));
            $jacocoInit[8] = true;
            result.add(donation);
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
        return result;
    }
}
