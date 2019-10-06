package p005cm.aptoide.p006pt;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import javax.inject.Named;
import javax.inject.Singleton;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountService;
import p005cm.aptoide.accountmanager.AdultContent;
import p005cm.aptoide.p006pt.abtesting.ABTestManager;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubBannerAdExperiment;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubInterstitialAdExperiment;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubNativeAdExperiment;
import p005cm.aptoide.p006pt.account.LoginPreferences;
import p005cm.aptoide.p006pt.ads.MoPubAnalytics;
import p005cm.aptoide.p006pt.ads.MoPubConsentDialogManager;
import p005cm.aptoide.p006pt.ads.MoPubConsentDialogView;
import p005cm.aptoide.p006pt.ads.MoPubConsentManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferCardManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferService;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p005cm.aptoide.p006pt.preferences.AdultContentManager;
import p005cm.aptoide.p006pt.preferences.LocalPersistenceAdultContent;
import p005cm.aptoide.p006pt.preferences.Preferences;
import p005cm.aptoide.p006pt.preferences.SecurePreferences;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule */
public class FlavourApplicationModule {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideApplication application;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4436994914439307442L, "cm/aptoide/pt/FlavourApplicationModule", 16);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule(AptoideApplication application2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.application = application2;
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AdultContent provideAdultContent(LocalPersistenceAdultContent localAdultContent, AccountService accountService) {
        boolean[] $jacocoInit = $jacocoInit();
        AdultContentManager adultContentManager = new AdultContentManager(localAdultContent, accountService);
        $jacocoInit[1] = true;
        return adultContentManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public LocalPersistenceAdultContent provideLocalAdultContent(Preferences preferences, @Named("secure") SecurePreferences securePreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        LocalPersistenceAdultContent localPersistenceAdultContent = new LocalPersistenceAdultContent(preferences, securePreferences);
        $jacocoInit[2] = true;
        return localPersistenceAdultContent;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideAutoUpdateStoreName() {
        $jacocoInit()[3] = true;
        return "v9";
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String providesSupportEmail() {
        boolean[] $jacocoInit = $jacocoInit();
        String string = this.application.getString(C1375R.string.aptoide_email);
        $jacocoInit[4] = true;
        return string;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public LoginPreferences provideLoginPreferences() {
        boolean[] $jacocoInit = $jacocoInit();
        LoginPreferences loginPreferences = new LoginPreferences(this.application, GoogleApiAvailability.getInstance());
        $jacocoInit[5] = true;
        return loginPreferences;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MoPubBannerAdExperiment providesMoPubBannerAdExperiment(@Named("ab-test") ABTestManager abTestManager, MoPubAnalytics moPubAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubBannerAdExperiment moPubBannerAdExperiment = new MoPubBannerAdExperiment(abTestManager, moPubAnalytics);
        $jacocoInit[6] = true;
        return moPubBannerAdExperiment;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MoPubNativeAdExperiment providesMoPubNativeAdExperiment(@Named("ab-test") ABTestManager abTestManager, MoPubAnalytics moPubAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubNativeAdExperiment moPubNativeAdExperiment = new MoPubNativeAdExperiment(abTestManager, moPubAnalytics);
        $jacocoInit[7] = true;
        return moPubNativeAdExperiment;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MoPubInterstitialAdExperiment providesMoPubInterstitialAdExperiment(@Named("ab-test") ABTestManager abTestManager, MoPubAnalytics moPubAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubInterstitialAdExperiment moPubInterstitialAdExperiment = new MoPubInterstitialAdExperiment(abTestManager, moPubAnalytics);
        $jacocoInit[8] = true;
        return moPubInterstitialAdExperiment;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String providePartnerID() {
        $jacocoInit()[9] = true;
        return "";
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public WalletAdsOfferManager providesWalletAdsOfferManager(WalletAdsOfferService walletAdsOfferService) {
        boolean[] $jacocoInit = $jacocoInit();
        Context applicationContext = this.application.getApplicationContext();
        $jacocoInit[10] = true;
        WalletAdsOfferManager walletAdsOfferManager = new WalletAdsOfferManager(applicationContext.getPackageManager(), walletAdsOfferService);
        $jacocoInit[11] = true;
        return walletAdsOfferManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public WalletAdsOfferCardManager providesWalletAdsOfferCardManager(BlacklistManager blacklistManager, PackageRepository packageRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletAdsOfferCardManager walletAdsOfferCardManager = new WalletAdsOfferCardManager(blacklistManager, packageRepository);
        $jacocoInit[12] = true;
        return walletAdsOfferCardManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MoPubConsentManager providesMoPubConsentManager() {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubConsentManager moPubConsentManager = new MoPubConsentManager();
        $jacocoInit[13] = true;
        return moPubConsentManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MoPubConsentDialogView providesMoPubConsentDialogView(MoPubConsentManager moPubConsentManager) {
        $jacocoInit()[14] = true;
        return moPubConsentManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MoPubConsentDialogManager providesMoPubConsentDialogManager(MoPubConsentManager moPubConsentManager) {
        $jacocoInit()[15] = true;
        return moPubConsentManager;
    }
}
