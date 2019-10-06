package p005cm.aptoide.p006pt.app;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.donations.Donation;
import p005cm.aptoide.p006pt.app.view.donations.DonationsService;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.app.AppCoinsManager */
public class AppCoinsManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AppCoinsService appCoinsService;
    private DonationsService donationsService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2626820230551400926L, "cm/aptoide/pt/app/AppCoinsManager", 3);
        $jacocoData = probes;
        return probes;
    }

    public AppCoinsManager(AppCoinsService appCoinsService2, DonationsService donationsService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appCoinsService = appCoinsService2;
        this.donationsService = donationsService2;
        $jacocoInit[0] = true;
    }

    public Single<AppCoinsAdvertisingModel> getAdvertising(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AppCoinsAdvertisingModel> validCampaign = this.appCoinsService.getValidCampaign(packageName, versionCode);
        $jacocoInit[1] = true;
        return validCampaign;
    }

    public Single<List<Donation>> getDonationsList(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<List<Donation>> donations = this.donationsService.getDonations(packageName);
        $jacocoInit[2] = true;
        return donations;
    }
}
