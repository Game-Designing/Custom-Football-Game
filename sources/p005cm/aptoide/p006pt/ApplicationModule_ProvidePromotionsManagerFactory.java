package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.promotions.PromotionViewAppMapper;
import p005cm.aptoide.p006pt.promotions.PromotionsAnalytics;
import p005cm.aptoide.p006pt.promotions.PromotionsManager;
import p005cm.aptoide.p006pt.promotions.PromotionsService;
import p005cm.aptoide.p006pt.wallet.WalletAppProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidePromotionsManagerFactory */
public final class ApplicationModule_ProvidePromotionsManagerFactory implements C13181b<PromotionsManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<DownloadFactory> downloadFactoryProvider;
    private final Provider<DownloadStateParser> downloadStateParserProvider;
    private final Provider<InstallAnalytics> installAnalyticsProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final Provider<InstalledRepository> installedRepositoryProvider;
    private final Provider<MoPubAdsManager> moPubAdsManagerProvider;
    private final ApplicationModule module;
    private final Provider<NotificationAnalytics> notificationAnalyticsProvider;
    private final Provider<PromotionViewAppMapper> promotionViewAppMapperProvider;
    private final Provider<PromotionsAnalytics> promotionsAnalyticsProvider;
    private final Provider<PromotionsService> promotionsServiceProvider;
    private final Provider<WalletAppProvider> walletAppProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2516615009489721818L, "cm/aptoide/pt/ApplicationModule_ProvidePromotionsManagerFactory", 18);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidePromotionsManagerFactory(ApplicationModule module2, Provider<InstallManager> installManagerProvider2, Provider<PromotionViewAppMapper> promotionViewAppMapperProvider2, Provider<DownloadFactory> downloadFactoryProvider2, Provider<DownloadStateParser> downloadStateParserProvider2, Provider<PromotionsAnalytics> promotionsAnalyticsProvider2, Provider<NotificationAnalytics> notificationAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<PromotionsService> promotionsServiceProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2, Provider<WalletAppProvider> walletAppProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.installManagerProvider = installManagerProvider2;
        this.promotionViewAppMapperProvider = promotionViewAppMapperProvider2;
        this.downloadFactoryProvider = downloadFactoryProvider2;
        this.downloadStateParserProvider = downloadStateParserProvider2;
        this.promotionsAnalyticsProvider = promotionsAnalyticsProvider2;
        this.notificationAnalyticsProvider = notificationAnalyticsProvider2;
        this.installAnalyticsProvider = installAnalyticsProvider2;
        this.promotionsServiceProvider = promotionsServiceProvider2;
        this.installedRepositoryProvider = installedRepositoryProvider2;
        this.moPubAdsManagerProvider = moPubAdsManagerProvider2;
        this.walletAppProvider = walletAppProvider2;
        $jacocoInit[0] = true;
    }

    public PromotionsManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<InstallManager> provider = this.installManagerProvider;
        $jacocoInit[1] = true;
        InstallManager installManager = (InstallManager) provider.get();
        Provider<PromotionViewAppMapper> provider2 = this.promotionViewAppMapperProvider;
        $jacocoInit[2] = true;
        PromotionViewAppMapper promotionViewAppMapper = (PromotionViewAppMapper) provider2.get();
        Provider<DownloadFactory> provider3 = this.downloadFactoryProvider;
        $jacocoInit[3] = true;
        DownloadFactory downloadFactory = (DownloadFactory) provider3.get();
        Provider<DownloadStateParser> provider4 = this.downloadStateParserProvider;
        $jacocoInit[4] = true;
        DownloadStateParser downloadStateParser = (DownloadStateParser) provider4.get();
        Provider<PromotionsAnalytics> provider5 = this.promotionsAnalyticsProvider;
        $jacocoInit[5] = true;
        PromotionsAnalytics promotionsAnalytics = (PromotionsAnalytics) provider5.get();
        Provider<NotificationAnalytics> provider6 = this.notificationAnalyticsProvider;
        $jacocoInit[6] = true;
        NotificationAnalytics notificationAnalytics = (NotificationAnalytics) provider6.get();
        Provider<InstallAnalytics> provider7 = this.installAnalyticsProvider;
        $jacocoInit[7] = true;
        InstallAnalytics installAnalytics = (InstallAnalytics) provider7.get();
        Provider<PromotionsService> provider8 = this.promotionsServiceProvider;
        $jacocoInit[8] = true;
        PromotionsService promotionsService = (PromotionsService) provider8.get();
        Provider<InstalledRepository> provider9 = this.installedRepositoryProvider;
        $jacocoInit[9] = true;
        InstalledRepository installedRepository = (InstalledRepository) provider9.get();
        Provider<MoPubAdsManager> provider10 = this.moPubAdsManagerProvider;
        $jacocoInit[10] = true;
        MoPubAdsManager moPubAdsManager = (MoPubAdsManager) provider10.get();
        Provider<WalletAppProvider> provider11 = this.walletAppProvider;
        $jacocoInit[11] = true;
        WalletAppProvider walletAppProvider2 = (WalletAppProvider) provider11.get();
        $jacocoInit[12] = true;
        PromotionsManager providePromotionsManager = applicationModule.providePromotionsManager(installManager, promotionViewAppMapper, downloadFactory, downloadStateParser, promotionsAnalytics, notificationAnalytics, installAnalytics, promotionsService, installedRepository, moPubAdsManager, walletAppProvider2);
        $jacocoInit[13] = true;
        C13182c.m43111a(providePromotionsManager, "Cannot return null from a non-@Nullable @Provides method");
        PromotionsManager promotionsManager = providePromotionsManager;
        $jacocoInit[14] = true;
        return promotionsManager;
    }

    public static C13181b<PromotionsManager> create(ApplicationModule module2, Provider<InstallManager> installManagerProvider2, Provider<PromotionViewAppMapper> promotionViewAppMapperProvider2, Provider<DownloadFactory> downloadFactoryProvider2, Provider<DownloadStateParser> downloadStateParserProvider2, Provider<PromotionsAnalytics> promotionsAnalyticsProvider2, Provider<NotificationAnalytics> notificationAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<PromotionsService> promotionsServiceProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2, Provider<WalletAppProvider> walletAppProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidePromotionsManagerFactory applicationModule_ProvidePromotionsManagerFactory = new ApplicationModule_ProvidePromotionsManagerFactory(module2, installManagerProvider2, promotionViewAppMapperProvider2, downloadFactoryProvider2, downloadStateParserProvider2, promotionsAnalyticsProvider2, notificationAnalyticsProvider2, installAnalyticsProvider2, promotionsServiceProvider2, installedRepositoryProvider2, moPubAdsManagerProvider2, walletAppProvider2);
        $jacocoInit[15] = true;
        return applicationModule_ProvidePromotionsManagerFactory;
    }

    public static PromotionsManager proxyProvidePromotionsManager(ApplicationModule instance, InstallManager installManager, PromotionViewAppMapper promotionViewAppMapper, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, PromotionsAnalytics promotionsAnalytics, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, PromotionsService promotionsService, InstalledRepository installedRepository, MoPubAdsManager moPubAdsManager, WalletAppProvider walletAppProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsManager providePromotionsManager = instance.providePromotionsManager(installManager, promotionViewAppMapper, downloadFactory, downloadStateParser, promotionsAnalytics, notificationAnalytics, installAnalytics, promotionsService, installedRepository, moPubAdsManager, walletAppProvider2);
        $jacocoInit[16] = true;
        return providePromotionsManager;
    }
}
