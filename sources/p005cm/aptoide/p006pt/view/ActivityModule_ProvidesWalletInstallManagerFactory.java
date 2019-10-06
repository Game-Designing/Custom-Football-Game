package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.wallet.WalletAppProvider;
import p005cm.aptoide.p006pt.wallet.WalletInstallAnalytics;
import p005cm.aptoide.p006pt.wallet.WalletInstallConfiguration;
import p005cm.aptoide.p006pt.wallet.WalletInstallManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesWalletInstallManagerFactory */
public final class ActivityModule_ProvidesWalletInstallManagerFactory implements C13181b<WalletInstallManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider;
    private final Provider<WalletInstallConfiguration> configurationProvider;
    private final Provider<DownloadFactory> downloadFactoryProvider;
    private final Provider<DownloadStateParser> downloadStateParserProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final Provider<InstalledRepository> installedRepositoryProvider;
    private final Provider<MoPubAdsManager> moPubAdsManagerProvider;
    private final ActivityModule module;
    private final Provider<WalletAppProvider> walletAppProvider;
    private final Provider<WalletInstallAnalytics> walletInstallAnalyticsProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3403718489329774958L, "cm/aptoide/pt/view/ActivityModule_ProvidesWalletInstallManagerFactory", 16);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesWalletInstallManagerFactory(ActivityModule module2, Provider<WalletInstallConfiguration> configurationProvider2, Provider<InstallManager> installManagerProvider2, Provider<DownloadFactory> downloadFactoryProvider2, Provider<DownloadStateParser> downloadStateParserProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2, Provider<WalletInstallAnalytics> walletInstallAnalyticsProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<WalletAppProvider> walletAppProvider2, Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.configurationProvider = configurationProvider2;
        this.installManagerProvider = installManagerProvider2;
        this.downloadFactoryProvider = downloadFactoryProvider2;
        this.downloadStateParserProvider = downloadStateParserProvider2;
        this.moPubAdsManagerProvider = moPubAdsManagerProvider2;
        this.walletInstallAnalyticsProvider = walletInstallAnalyticsProvider2;
        this.installedRepositoryProvider = installedRepositoryProvider2;
        this.walletAppProvider = walletAppProvider2;
        this.appInstallerStatusReceiverProvider = appInstallerStatusReceiverProvider2;
        $jacocoInit[0] = true;
    }

    public WalletInstallManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<WalletInstallConfiguration> provider = this.configurationProvider;
        $jacocoInit[1] = true;
        WalletInstallConfiguration walletInstallConfiguration = (WalletInstallConfiguration) provider.get();
        Provider<InstallManager> provider2 = this.installManagerProvider;
        $jacocoInit[2] = true;
        InstallManager installManager = (InstallManager) provider2.get();
        Provider<DownloadFactory> provider3 = this.downloadFactoryProvider;
        $jacocoInit[3] = true;
        DownloadFactory downloadFactory = (DownloadFactory) provider3.get();
        Provider<DownloadStateParser> provider4 = this.downloadStateParserProvider;
        $jacocoInit[4] = true;
        DownloadStateParser downloadStateParser = (DownloadStateParser) provider4.get();
        Provider<MoPubAdsManager> provider5 = this.moPubAdsManagerProvider;
        $jacocoInit[5] = true;
        MoPubAdsManager moPubAdsManager = (MoPubAdsManager) provider5.get();
        Provider<WalletInstallAnalytics> provider6 = this.walletInstallAnalyticsProvider;
        $jacocoInit[6] = true;
        WalletInstallAnalytics walletInstallAnalytics = (WalletInstallAnalytics) provider6.get();
        Provider<InstalledRepository> provider7 = this.installedRepositoryProvider;
        $jacocoInit[7] = true;
        InstalledRepository installedRepository = (InstalledRepository) provider7.get();
        Provider<WalletAppProvider> provider8 = this.walletAppProvider;
        $jacocoInit[8] = true;
        WalletAppProvider walletAppProvider2 = (WalletAppProvider) provider8.get();
        Provider<AppInstallerStatusReceiver> provider9 = this.appInstallerStatusReceiverProvider;
        $jacocoInit[9] = true;
        AppInstallerStatusReceiver appInstallerStatusReceiver = (AppInstallerStatusReceiver) provider9.get();
        $jacocoInit[10] = true;
        WalletInstallManager providesWalletInstallManager = activityModule.providesWalletInstallManager(walletInstallConfiguration, installManager, downloadFactory, downloadStateParser, moPubAdsManager, walletInstallAnalytics, installedRepository, walletAppProvider2, appInstallerStatusReceiver);
        $jacocoInit[11] = true;
        C13182c.m43111a(providesWalletInstallManager, "Cannot return null from a non-@Nullable @Provides method");
        WalletInstallManager walletInstallManager = providesWalletInstallManager;
        $jacocoInit[12] = true;
        return walletInstallManager;
    }

    public static C13181b<WalletInstallManager> create(ActivityModule module2, Provider<WalletInstallConfiguration> configurationProvider2, Provider<InstallManager> installManagerProvider2, Provider<DownloadFactory> downloadFactoryProvider2, Provider<DownloadStateParser> downloadStateParserProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2, Provider<WalletInstallAnalytics> walletInstallAnalyticsProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<WalletAppProvider> walletAppProvider2, Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesWalletInstallManagerFactory activityModule_ProvidesWalletInstallManagerFactory = new ActivityModule_ProvidesWalletInstallManagerFactory(module2, configurationProvider2, installManagerProvider2, downloadFactoryProvider2, downloadStateParserProvider2, moPubAdsManagerProvider2, walletInstallAnalyticsProvider2, installedRepositoryProvider2, walletAppProvider2, appInstallerStatusReceiverProvider2);
        $jacocoInit[13] = true;
        return activityModule_ProvidesWalletInstallManagerFactory;
    }

    public static WalletInstallManager proxyProvidesWalletInstallManager(ActivityModule instance, WalletInstallConfiguration configuration, InstallManager installManager, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, MoPubAdsManager moPubAdsManager, WalletInstallAnalytics walletInstallAnalytics, InstalledRepository installedRepository, WalletAppProvider walletAppProvider2, AppInstallerStatusReceiver appInstallerStatusReceiver) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallManager providesWalletInstallManager = instance.providesWalletInstallManager(configuration, installManager, downloadFactory, downloadStateParser, moPubAdsManager, walletInstallAnalytics, installedRepository, walletAppProvider2, appInstallerStatusReceiver);
        $jacocoInit[14] = true;
        return providesWalletInstallManager;
    }
}
