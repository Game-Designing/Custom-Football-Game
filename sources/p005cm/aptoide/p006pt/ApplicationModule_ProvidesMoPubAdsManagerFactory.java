package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubBannerAdExperiment;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubInterstitialAdExperiment;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubNativeAdExperiment;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.ads.MoPubConsentManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesMoPubAdsManagerFactory */
public final class ApplicationModule_ProvidesMoPubAdsManagerFactory implements C13181b<MoPubAdsManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<MoPubBannerAdExperiment> moPubBannerAdExperimentProvider;
    private final Provider<MoPubConsentManager> moPubConsentDialogManagerProvider;
    private final Provider<MoPubInterstitialAdExperiment> moPubInterstitialAdExperimentProvider;
    private final Provider<MoPubNativeAdExperiment> moPubNativeAdExperimentProvider;
    private final ApplicationModule module;
    private final Provider<WalletAdsOfferManager> walletAdsOfferManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6470859967506868291L, "cm/aptoide/pt/ApplicationModule_ProvidesMoPubAdsManagerFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesMoPubAdsManagerFactory(ApplicationModule module2, Provider<MoPubInterstitialAdExperiment> moPubInterstitialAdExperimentProvider2, Provider<MoPubBannerAdExperiment> moPubBannerAdExperimentProvider2, Provider<MoPubNativeAdExperiment> moPubNativeAdExperimentProvider2, Provider<WalletAdsOfferManager> walletAdsOfferManagerProvider2, Provider<MoPubConsentManager> moPubConsentDialogManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.moPubInterstitialAdExperimentProvider = moPubInterstitialAdExperimentProvider2;
        this.moPubBannerAdExperimentProvider = moPubBannerAdExperimentProvider2;
        this.moPubNativeAdExperimentProvider = moPubNativeAdExperimentProvider2;
        this.walletAdsOfferManagerProvider = walletAdsOfferManagerProvider2;
        this.moPubConsentDialogManagerProvider = moPubConsentDialogManagerProvider2;
        $jacocoInit[0] = true;
    }

    public MoPubAdsManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<MoPubInterstitialAdExperiment> provider = this.moPubInterstitialAdExperimentProvider;
        $jacocoInit[1] = true;
        MoPubInterstitialAdExperiment moPubInterstitialAdExperiment = (MoPubInterstitialAdExperiment) provider.get();
        Provider<MoPubBannerAdExperiment> provider2 = this.moPubBannerAdExperimentProvider;
        $jacocoInit[2] = true;
        MoPubBannerAdExperiment moPubBannerAdExperiment = (MoPubBannerAdExperiment) provider2.get();
        Provider<MoPubNativeAdExperiment> provider3 = this.moPubNativeAdExperimentProvider;
        $jacocoInit[3] = true;
        MoPubNativeAdExperiment moPubNativeAdExperiment = (MoPubNativeAdExperiment) provider3.get();
        Provider<WalletAdsOfferManager> provider4 = this.walletAdsOfferManagerProvider;
        $jacocoInit[4] = true;
        WalletAdsOfferManager walletAdsOfferManager = (WalletAdsOfferManager) provider4.get();
        Provider<MoPubConsentManager> provider5 = this.moPubConsentDialogManagerProvider;
        $jacocoInit[5] = true;
        MoPubConsentManager moPubConsentManager = (MoPubConsentManager) provider5.get();
        $jacocoInit[6] = true;
        MoPubAdsManager providesMoPubAdsManager = applicationModule.providesMoPubAdsManager(moPubInterstitialAdExperiment, moPubBannerAdExperiment, moPubNativeAdExperiment, walletAdsOfferManager, moPubConsentManager);
        $jacocoInit[7] = true;
        C13182c.m43111a(providesMoPubAdsManager, "Cannot return null from a non-@Nullable @Provides method");
        MoPubAdsManager moPubAdsManager = providesMoPubAdsManager;
        $jacocoInit[8] = true;
        return moPubAdsManager;
    }

    public static C13181b<MoPubAdsManager> create(ApplicationModule module2, Provider<MoPubInterstitialAdExperiment> moPubInterstitialAdExperimentProvider2, Provider<MoPubBannerAdExperiment> moPubBannerAdExperimentProvider2, Provider<MoPubNativeAdExperiment> moPubNativeAdExperimentProvider2, Provider<WalletAdsOfferManager> walletAdsOfferManagerProvider2, Provider<MoPubConsentManager> moPubConsentDialogManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesMoPubAdsManagerFactory applicationModule_ProvidesMoPubAdsManagerFactory = new ApplicationModule_ProvidesMoPubAdsManagerFactory(module2, moPubInterstitialAdExperimentProvider2, moPubBannerAdExperimentProvider2, moPubNativeAdExperimentProvider2, walletAdsOfferManagerProvider2, moPubConsentDialogManagerProvider2);
        $jacocoInit[9] = true;
        return applicationModule_ProvidesMoPubAdsManagerFactory;
    }

    public static MoPubAdsManager proxyProvidesMoPubAdsManager(ApplicationModule instance, MoPubInterstitialAdExperiment moPubInterstitialAdExperiment, MoPubBannerAdExperiment moPubBannerAdExperiment, MoPubNativeAdExperiment moPubNativeAdExperiment, WalletAdsOfferManager walletAdsOfferManager, MoPubConsentManager moPubConsentDialogManager) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubAdsManager providesMoPubAdsManager = instance.providesMoPubAdsManager(moPubInterstitialAdExperiment, moPubBannerAdExperiment, moPubNativeAdExperiment, walletAdsOfferManager, moPubConsentDialogManager);
        $jacocoInit[10] = true;
        return providesMoPubAdsManager;
    }
}
