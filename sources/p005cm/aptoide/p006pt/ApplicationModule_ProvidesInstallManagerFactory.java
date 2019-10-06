package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.downloadmanager.DownloadsRepository;
import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.install.InstallerAnalytics;
import p005cm.aptoide.p006pt.install.PackageInstallerManager;
import p005cm.aptoide.p006pt.packageinstaller.AppInstaller;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesInstallManagerFactory */
public final class ApplicationModule_ProvidesInstallManagerFactory implements C13181b<InstallManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> apkPathProvider;
    private final Provider<AppInstaller> appInstallerProvider;
    private final Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider;
    private final Provider<AptoideDownloadManager> aptoideDownloadManagerProvider;
    private final Provider<String> cachePathProvider;
    private final Provider<SharedPreferences> defaultSharedPreferencesProvider;
    private final Provider<DownloadsRepository> downloadsRepositoryProvider;
    private final Provider<InstalledRepository> installedRepositoryProvider;
    private final Provider<InstallerAnalytics> installerAnalyticsProvider;
    private final ApplicationModule module;
    private final Provider<String> obbPathProvider;
    private final Provider<PackageInstallerManager> packageInstallerManagerProvider;
    private final Provider<RootAvailabilityManager> rootAvailabilityManagerProvider;
    private final Provider<SharedPreferences> secureSharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3051526717522626328L, "cm/aptoide/pt/ApplicationModule_ProvidesInstallManagerFactory", 20);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesInstallManagerFactory(ApplicationModule module2, Provider<AptoideDownloadManager> aptoideDownloadManagerProvider2, Provider<InstallerAnalytics> installerAnalyticsProvider2, Provider<RootAvailabilityManager> rootAvailabilityManagerProvider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<SharedPreferences> secureSharedPreferencesProvider2, Provider<DownloadsRepository> downloadsRepositoryProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<String> cachePathProvider2, Provider<String> apkPathProvider2, Provider<String> obbPathProvider2, Provider<AppInstaller> appInstallerProvider2, Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider2, Provider<PackageInstallerManager> packageInstallerManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.aptoideDownloadManagerProvider = aptoideDownloadManagerProvider2;
        this.installerAnalyticsProvider = installerAnalyticsProvider2;
        this.rootAvailabilityManagerProvider = rootAvailabilityManagerProvider2;
        this.defaultSharedPreferencesProvider = defaultSharedPreferencesProvider2;
        this.secureSharedPreferencesProvider = secureSharedPreferencesProvider2;
        this.downloadsRepositoryProvider = downloadsRepositoryProvider2;
        this.installedRepositoryProvider = installedRepositoryProvider2;
        this.cachePathProvider = cachePathProvider2;
        this.apkPathProvider = apkPathProvider2;
        this.obbPathProvider = obbPathProvider2;
        this.appInstallerProvider = appInstallerProvider2;
        this.appInstallerStatusReceiverProvider = appInstallerStatusReceiverProvider2;
        this.packageInstallerManagerProvider = packageInstallerManagerProvider2;
        $jacocoInit[0] = true;
    }

    public InstallManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AptoideDownloadManager> provider = this.aptoideDownloadManagerProvider;
        $jacocoInit[1] = true;
        AptoideDownloadManager aptoideDownloadManager = (AptoideDownloadManager) provider.get();
        Provider<InstallerAnalytics> provider2 = this.installerAnalyticsProvider;
        $jacocoInit[2] = true;
        InstallerAnalytics installerAnalytics = (InstallerAnalytics) provider2.get();
        Provider<RootAvailabilityManager> provider3 = this.rootAvailabilityManagerProvider;
        $jacocoInit[3] = true;
        RootAvailabilityManager rootAvailabilityManager = (RootAvailabilityManager) provider3.get();
        Provider<SharedPreferences> provider4 = this.defaultSharedPreferencesProvider;
        $jacocoInit[4] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider4.get();
        Provider<SharedPreferences> provider5 = this.secureSharedPreferencesProvider;
        $jacocoInit[5] = true;
        SharedPreferences sharedPreferences2 = (SharedPreferences) provider5.get();
        Provider<DownloadsRepository> provider6 = this.downloadsRepositoryProvider;
        $jacocoInit[6] = true;
        DownloadsRepository downloadsRepository = (DownloadsRepository) provider6.get();
        Provider<InstalledRepository> provider7 = this.installedRepositoryProvider;
        $jacocoInit[7] = true;
        InstalledRepository installedRepository = (InstalledRepository) provider7.get();
        Provider<String> provider8 = this.cachePathProvider;
        $jacocoInit[8] = true;
        String str = (String) provider8.get();
        Provider<String> provider9 = this.apkPathProvider;
        $jacocoInit[9] = true;
        String str2 = (String) provider9.get();
        Provider<String> provider10 = this.obbPathProvider;
        $jacocoInit[10] = true;
        String str3 = (String) provider10.get();
        Provider<AppInstaller> provider11 = this.appInstallerProvider;
        $jacocoInit[11] = true;
        AppInstaller appInstaller = (AppInstaller) provider11.get();
        Provider<AppInstallerStatusReceiver> provider12 = this.appInstallerStatusReceiverProvider;
        $jacocoInit[12] = true;
        AppInstallerStatusReceiver appInstallerStatusReceiver = (AppInstallerStatusReceiver) provider12.get();
        Provider<PackageInstallerManager> provider13 = this.packageInstallerManagerProvider;
        $jacocoInit[13] = true;
        PackageInstallerManager packageInstallerManager = (PackageInstallerManager) provider13.get();
        $jacocoInit[14] = true;
        InstallManager providesInstallManager = applicationModule.providesInstallManager(aptoideDownloadManager, installerAnalytics, rootAvailabilityManager, sharedPreferences, sharedPreferences2, downloadsRepository, installedRepository, str, str2, str3, appInstaller, appInstallerStatusReceiver, packageInstallerManager);
        $jacocoInit[15] = true;
        C13182c.m43111a(providesInstallManager, "Cannot return null from a non-@Nullable @Provides method");
        InstallManager installManager = providesInstallManager;
        $jacocoInit[16] = true;
        return installManager;
    }

    public static C13181b<InstallManager> create(ApplicationModule module2, Provider<AptoideDownloadManager> aptoideDownloadManagerProvider2, Provider<InstallerAnalytics> installerAnalyticsProvider2, Provider<RootAvailabilityManager> rootAvailabilityManagerProvider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<SharedPreferences> secureSharedPreferencesProvider2, Provider<DownloadsRepository> downloadsRepositoryProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<String> cachePathProvider2, Provider<String> apkPathProvider2, Provider<String> obbPathProvider2, Provider<AppInstaller> appInstallerProvider2, Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider2, Provider<PackageInstallerManager> packageInstallerManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesInstallManagerFactory applicationModule_ProvidesInstallManagerFactory = new ApplicationModule_ProvidesInstallManagerFactory(module2, aptoideDownloadManagerProvider2, installerAnalyticsProvider2, rootAvailabilityManagerProvider2, defaultSharedPreferencesProvider2, secureSharedPreferencesProvider2, downloadsRepositoryProvider2, installedRepositoryProvider2, cachePathProvider2, apkPathProvider2, obbPathProvider2, appInstallerProvider2, appInstallerStatusReceiverProvider2, packageInstallerManagerProvider2);
        $jacocoInit[17] = true;
        return applicationModule_ProvidesInstallManagerFactory;
    }

    public static InstallManager proxyProvidesInstallManager(ApplicationModule instance, AptoideDownloadManager aptoideDownloadManager, InstallerAnalytics installerAnalytics, RootAvailabilityManager rootAvailabilityManager, SharedPreferences defaultSharedPreferences, SharedPreferences secureSharedPreferences, DownloadsRepository downloadsRepository, InstalledRepository installedRepository, String cachePath, String apkPath, String obbPath, AppInstaller appInstaller, AppInstallerStatusReceiver appInstallerStatusReceiver, PackageInstallerManager packageInstallerManager) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager providesInstallManager = instance.providesInstallManager(aptoideDownloadManager, installerAnalytics, rootAvailabilityManager, defaultSharedPreferences, secureSharedPreferences, downloadsRepository, installedRepository, cachePath, apkPath, obbPath, appInstaller, appInstallerStatusReceiver, packageInstallerManager);
        $jacocoInit[18] = true;
        return providesInstallManager;
    }
}
