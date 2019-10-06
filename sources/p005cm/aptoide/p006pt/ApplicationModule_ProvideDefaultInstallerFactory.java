package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.install.Installer;
import p005cm.aptoide.p006pt.install.InstallerAnalytics;
import p005cm.aptoide.p006pt.install.installer.InstallationProvider;
import p005cm.aptoide.p006pt.packageinstaller.AppInstaller;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideDefaultInstallerFactory */
public final class ApplicationModule_ProvideDefaultInstallerFactory implements C13181b<Installer> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppInstaller> appInstallerProvider;
    private final Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider;
    private final Provider<InstallationProvider> installationProvider;
    private final Provider<InstalledRepository> installedRepositoryProvider;
    private final Provider<InstallerAnalytics> installerAnalyticsProvider;
    private final ApplicationModule module;
    private final Provider<RootAvailabilityManager> rootAvailabilityManagerProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5946949034279408757L, "cm/aptoide/pt/ApplicationModule_ProvideDefaultInstallerFactory", 14);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideDefaultInstallerFactory(ApplicationModule module2, Provider<InstallationProvider> installationProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<RootAvailabilityManager> rootAvailabilityManagerProvider2, Provider<InstallerAnalytics> installerAnalyticsProvider2, Provider<AppInstaller> appInstallerProvider2, Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.installationProvider = installationProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.installedRepositoryProvider = installedRepositoryProvider2;
        this.rootAvailabilityManagerProvider = rootAvailabilityManagerProvider2;
        this.installerAnalyticsProvider = installerAnalyticsProvider2;
        this.appInstallerProvider = appInstallerProvider2;
        this.appInstallerStatusReceiverProvider = appInstallerStatusReceiverProvider2;
        $jacocoInit[0] = true;
    }

    public Installer get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<InstallationProvider> provider = this.installationProvider;
        $jacocoInit[1] = true;
        InstallationProvider installationProvider2 = (InstallationProvider) provider.get();
        Provider<SharedPreferences> provider2 = this.sharedPreferencesProvider;
        $jacocoInit[2] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider2.get();
        Provider<InstalledRepository> provider3 = this.installedRepositoryProvider;
        $jacocoInit[3] = true;
        InstalledRepository installedRepository = (InstalledRepository) provider3.get();
        Provider<RootAvailabilityManager> provider4 = this.rootAvailabilityManagerProvider;
        $jacocoInit[4] = true;
        RootAvailabilityManager rootAvailabilityManager = (RootAvailabilityManager) provider4.get();
        Provider<InstallerAnalytics> provider5 = this.installerAnalyticsProvider;
        $jacocoInit[5] = true;
        InstallerAnalytics installerAnalytics = (InstallerAnalytics) provider5.get();
        Provider<AppInstaller> provider6 = this.appInstallerProvider;
        $jacocoInit[6] = true;
        AppInstaller appInstaller = (AppInstaller) provider6.get();
        Provider<AppInstallerStatusReceiver> provider7 = this.appInstallerStatusReceiverProvider;
        $jacocoInit[7] = true;
        AppInstallerStatusReceiver appInstallerStatusReceiver = (AppInstallerStatusReceiver) provider7.get();
        $jacocoInit[8] = true;
        Installer provideDefaultInstaller = applicationModule.provideDefaultInstaller(installationProvider2, sharedPreferences, installedRepository, rootAvailabilityManager, installerAnalytics, appInstaller, appInstallerStatusReceiver);
        $jacocoInit[9] = true;
        C13182c.m43111a(provideDefaultInstaller, "Cannot return null from a non-@Nullable @Provides method");
        Installer installer = provideDefaultInstaller;
        $jacocoInit[10] = true;
        return installer;
    }

    public static C13181b<Installer> create(ApplicationModule module2, Provider<InstallationProvider> installationProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<RootAvailabilityManager> rootAvailabilityManagerProvider2, Provider<InstallerAnalytics> installerAnalyticsProvider2, Provider<AppInstaller> appInstallerProvider2, Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideDefaultInstallerFactory applicationModule_ProvideDefaultInstallerFactory = new ApplicationModule_ProvideDefaultInstallerFactory(module2, installationProvider2, sharedPreferencesProvider2, installedRepositoryProvider2, rootAvailabilityManagerProvider2, installerAnalyticsProvider2, appInstallerProvider2, appInstallerStatusReceiverProvider2);
        $jacocoInit[11] = true;
        return applicationModule_ProvideDefaultInstallerFactory;
    }

    public static Installer proxyProvideDefaultInstaller(ApplicationModule instance, InstallationProvider installationProvider2, SharedPreferences sharedPreferences, InstalledRepository installedRepository, RootAvailabilityManager rootAvailabilityManager, InstallerAnalytics installerAnalytics, AppInstaller appInstaller, AppInstallerStatusReceiver appInstallerStatusReceiver) {
        boolean[] $jacocoInit = $jacocoInit();
        Installer provideDefaultInstaller = instance.provideDefaultInstaller(installationProvider2, sharedPreferences, installedRepository, rootAvailabilityManager, installerAnalytics, appInstaller, appInstallerStatusReceiver);
        $jacocoInit[12] = true;
        return provideDefaultInstaller;
    }
}
