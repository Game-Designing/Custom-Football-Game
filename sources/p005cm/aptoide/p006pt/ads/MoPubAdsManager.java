package p005cm.aptoide.p006pt.ads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubBannerAdExperiment;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubInterstitialAdExperiment;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubNativeAdExperiment;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.ads.MoPubAdsManager */
public class MoPubAdsManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final MoPubBannerAdExperiment moPubBannerAdExperiment;
    private final MoPubConsentDialogManager moPubConsentDialogManager;
    private final MoPubInterstitialAdExperiment moPubInterstitialAdExperiment;
    private final MoPubNativeAdExperiment moPubNativeAdExperiment;
    private final WalletAdsOfferManager walletAdsOfferManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8589538723552290976L, "cm/aptoide/pt/ads/MoPubAdsManager", 26);
        $jacocoData = probes;
        return probes;
    }

    public MoPubAdsManager(MoPubInterstitialAdExperiment moPubInterstitialAdExperiment2, MoPubBannerAdExperiment moPubBannerAdExperiment2, MoPubNativeAdExperiment moPubNativeAdExperiment2, WalletAdsOfferManager walletAdsOfferManager2, MoPubConsentDialogManager moPubConsentDialogManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.moPubInterstitialAdExperiment = moPubInterstitialAdExperiment2;
        this.moPubBannerAdExperiment = moPubBannerAdExperiment2;
        this.moPubNativeAdExperiment = moPubNativeAdExperiment2;
        this.walletAdsOfferManager = walletAdsOfferManager2;
        this.moPubConsentDialogManager = moPubConsentDialogManager2;
        $jacocoInit[0] = true;
    }

    public Single<OfferResponseStatus> getAdsVisibilityStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadInterstitial = this.moPubInterstitialAdExperiment.shouldLoadInterstitial();
        C1672u uVar = new C1672u(this);
        $jacocoInit[1] = true;
        Single<OfferResponseStatus> a = shouldLoadInterstitial.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) uVar);
        $jacocoInit[2] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo10004a(Boolean experimentShouldLoadAds) {
        boolean[] $jacocoInit = $jacocoInit();
        if (experimentShouldLoadAds.booleanValue()) {
            $jacocoInit[18] = true;
            Single shouldRequestMoPubAd = this.walletAdsOfferManager.shouldRequestMoPubAd();
            C1675x xVar = C1675x.f4628a;
            $jacocoInit[19] = true;
            Single a = shouldRequestMoPubAd.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) xVar);
            $jacocoInit[20] = true;
            return a;
        }
        Single a2 = Single.m734a(OfferResponseStatus.NO_ADS);
        $jacocoInit[21] = true;
        return a2;
    }

    /* renamed from: b */
    static /* synthetic */ Single m6400b(Boolean shouldRequestAds) {
        Single single;
        boolean[] $jacocoInit = $jacocoInit();
        if (shouldRequestAds.booleanValue()) {
            single = Single.m734a(OfferResponseStatus.ADS_SHOW);
            $jacocoInit[22] = true;
        } else {
            OfferResponseStatus offerResponseStatus = OfferResponseStatus.ADS_HIDE;
            $jacocoInit[23] = true;
            single = Single.m734a(offerResponseStatus);
            $jacocoInit[24] = true;
        }
        $jacocoInit[25] = true;
        return single;
    }

    public Single<Boolean> shouldHaveInterstitialAds() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> shouldLoadInterstitial = this.moPubInterstitialAdExperiment.shouldLoadInterstitial();
        $jacocoInit[3] = true;
        return shouldLoadInterstitial;
    }

    public Single<Boolean> shouldLoadBannerAd() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> a = shouldShowAds().mo3688a((C0132p<? super T, ? extends Single<? extends R>>) new C1674w<Object,Object>(this));
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: c */
    public /* synthetic */ Single mo10005c(Boolean requestInterstitialAd) {
        boolean[] $jacocoInit = $jacocoInit();
        if (requestInterstitialAd.booleanValue()) {
            $jacocoInit[15] = true;
            Single shouldHaveBannerAds = shouldHaveBannerAds();
            $jacocoInit[16] = true;
            return shouldHaveBannerAds;
        }
        Single a = Single.m734a(Boolean.valueOf(false));
        $jacocoInit[17] = true;
        return a;
    }

    private Single<Boolean> shouldHaveBannerAds() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> shouldLoadBanner = this.moPubBannerAdExperiment.shouldLoadBanner();
        $jacocoInit[5] = true;
        return shouldLoadBanner;
    }

    public Single<Boolean> shouldLoadNativeAds() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> a = shouldShowAds().mo3688a((C0132p<? super T, ? extends Single<? extends R>>) new C1673v<Object,Object>(this));
        $jacocoInit[6] = true;
        return a;
    }

    /* renamed from: d */
    public /* synthetic */ Single mo10006d(Boolean requestInterstitialAd) {
        boolean[] $jacocoInit = $jacocoInit();
        if (requestInterstitialAd.booleanValue()) {
            $jacocoInit[12] = true;
            Single shouldHaveNativeAds = shouldHaveNativeAds();
            $jacocoInit[13] = true;
            return shouldHaveNativeAds;
        }
        Single a = Single.m734a(Boolean.valueOf(false));
        $jacocoInit[14] = true;
        return a;
    }

    private Single<Boolean> shouldHaveNativeAds() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> shouldLoadNative = this.moPubNativeAdExperiment.shouldLoadNative();
        $jacocoInit[7] = true;
        return shouldLoadNative;
    }

    public Single<Boolean> recordInterstitialAdImpression() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> recordAdImpression = this.moPubInterstitialAdExperiment.recordAdImpression();
        $jacocoInit[8] = true;
        return recordAdImpression;
    }

    public Single<Boolean> recordInterstitialAdClick() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> recordAdClick = this.moPubInterstitialAdExperiment.recordAdClick();
        $jacocoInit[9] = true;
        return recordAdClick;
    }

    public Single<Boolean> shouldShowAds() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> shouldRequestMoPubAd = this.walletAdsOfferManager.shouldRequestMoPubAd();
        $jacocoInit[10] = true;
        return shouldRequestMoPubAd;
    }

    public Single<Boolean> shouldShowConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> shouldShowConsentDialog = this.moPubConsentDialogManager.shouldShowConsentDialog();
        $jacocoInit[11] = true;
        return shouldShowConsentDialog;
    }
}
