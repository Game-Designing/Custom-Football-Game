package p005cm.aptoide.p006pt.ads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.install.PackageRepository;

/* renamed from: cm.aptoide.pt.ads.WalletAdsOfferCardManager */
public class WalletAdsOfferCardManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BlacklistManager blacklistManager;
    private final PackageRepository packageRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1660985606557429127L, "cm/aptoide/pt/ads/WalletAdsOfferCardManager", 6);
        $jacocoData = probes;
        return probes;
    }

    public WalletAdsOfferCardManager(BlacklistManager blacklistManager2, PackageRepository packageRepository2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.blacklistManager = blacklistManager2;
        this.packageRepository = packageRepository2;
        $jacocoInit[0] = true;
    }

    public boolean shouldShowWalletOfferCard(String type, String id) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.blacklistManager.isBlacklisted(type, id)) {
            $jacocoInit[1] = true;
        } else if (this.packageRepository.isAppInstalled("com.appcoins.wallet")) {
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
            z = true;
            $jacocoInit[5] = true;
            return z;
        }
        z = false;
        $jacocoInit[4] = true;
        $jacocoInit[5] = true;
        return z;
    }
}
