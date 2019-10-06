package p005cm.aptoide.p006pt.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.ads.WalletAdsOfferManager */
public class WalletAdsOfferManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String WALLET_PACKAGE_NAME = "com.appcoins.wallet";
    private final PackageManager packageManager;
    private final WalletAdsOfferService walletAdsOfferService;

    /* renamed from: cm.aptoide.pt.ads.WalletAdsOfferManager$OfferResponseStatus */
    public enum OfferResponseStatus {
        NO_ADS,
        ADS_SHOW,
        ADS_HIDE;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(641517444925944374L, "cm/aptoide/pt/ads/WalletAdsOfferManager", 13);
        $jacocoData = probes;
        return probes;
    }

    public WalletAdsOfferManager(PackageManager packageManager2, WalletAdsOfferService walletAdsOfferService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.packageManager = packageManager2;
        this.walletAdsOfferService = walletAdsOfferService2;
        $jacocoInit[0] = true;
    }

    public Single<Boolean> shouldRequestMoPubAd() {
        boolean[] $jacocoInit = $jacocoInit();
        Single isWalletOfferActive = this.walletAdsOfferService.isWalletOfferActive();
        C1645B b = new C1645B(this);
        $jacocoInit[1] = true;
        Single<Boolean> a = isWalletOfferActive.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) b);
        $jacocoInit[2] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo10035a(Boolean isOfferActive) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (isOfferActive.booleanValue()) {
            $jacocoInit[8] = true;
            if (!isWalletInstalled()) {
                $jacocoInit[9] = true;
                z = true;
            } else {
                z = false;
                $jacocoInit[10] = true;
            }
            Single a = Single.m734a(Boolean.valueOf(z));
            $jacocoInit[11] = true;
            return a;
        }
        Single a2 = Single.m734a(Boolean.valueOf(true));
        $jacocoInit[12] = true;
        return a2;
    }

    private boolean isWalletInstalled() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[3] = true;
        for (ApplicationInfo applicationInfo : this.packageManager.getInstalledApplications(0)) {
            $jacocoInit[4] = true;
            if (applicationInfo.packageName.equals(WALLET_PACKAGE_NAME)) {
                $jacocoInit[5] = true;
                return true;
            }
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
        return false;
    }
}
