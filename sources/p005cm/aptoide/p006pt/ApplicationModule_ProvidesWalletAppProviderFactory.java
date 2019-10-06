package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.view.app.AppCenter;
import p005cm.aptoide.p006pt.wallet.WalletAppProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesWalletAppProviderFactory */
public final class ApplicationModule_ProvidesWalletAppProviderFactory implements C13181b<WalletAppProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppCenter> appCenterProvider;
    private final Provider<DownloadStateParser> downloadStateParserProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final Provider<InstalledRepository> installedRepositoryProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8584390793527567378L, "cm/aptoide/pt/ApplicationModule_ProvidesWalletAppProviderFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesWalletAppProviderFactory(ApplicationModule module2, Provider<AppCenter> appCenterProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<InstallManager> installManagerProvider2, Provider<DownloadStateParser> downloadStateParserProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.appCenterProvider = appCenterProvider2;
        this.installedRepositoryProvider = installedRepositoryProvider2;
        this.installManagerProvider = installManagerProvider2;
        this.downloadStateParserProvider = downloadStateParserProvider2;
        $jacocoInit[0] = true;
    }

    public WalletAppProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AppCenter> provider = this.appCenterProvider;
        $jacocoInit[1] = true;
        AppCenter appCenter = (AppCenter) provider.get();
        Provider<InstalledRepository> provider2 = this.installedRepositoryProvider;
        $jacocoInit[2] = true;
        InstalledRepository installedRepository = (InstalledRepository) provider2.get();
        Provider<InstallManager> provider3 = this.installManagerProvider;
        $jacocoInit[3] = true;
        InstallManager installManager = (InstallManager) provider3.get();
        Provider<DownloadStateParser> provider4 = this.downloadStateParserProvider;
        $jacocoInit[4] = true;
        DownloadStateParser downloadStateParser = (DownloadStateParser) provider4.get();
        $jacocoInit[5] = true;
        WalletAppProvider providesWalletAppProvider = applicationModule.providesWalletAppProvider(appCenter, installedRepository, installManager, downloadStateParser);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesWalletAppProvider, "Cannot return null from a non-@Nullable @Provides method");
        WalletAppProvider walletAppProvider = providesWalletAppProvider;
        $jacocoInit[7] = true;
        return walletAppProvider;
    }

    public static C13181b<WalletAppProvider> create(ApplicationModule module2, Provider<AppCenter> appCenterProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<InstallManager> installManagerProvider2, Provider<DownloadStateParser> downloadStateParserProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesWalletAppProviderFactory applicationModule_ProvidesWalletAppProviderFactory = new ApplicationModule_ProvidesWalletAppProviderFactory(module2, appCenterProvider2, installedRepositoryProvider2, installManagerProvider2, downloadStateParserProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvidesWalletAppProviderFactory;
    }

    public static WalletAppProvider proxyProvidesWalletAppProvider(ApplicationModule instance, AppCenter appCenter, InstalledRepository installedRepository, InstallManager installManager, DownloadStateParser downloadStateParser) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletAppProvider providesWalletAppProvider = instance.providesWalletAppProvider(appCenter, installedRepository, installManager, downloadStateParser);
        $jacocoInit[9] = true;
        return providesWalletAppProvider;
    }
}
