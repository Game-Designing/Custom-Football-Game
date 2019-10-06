package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateManager;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateRepository;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.install.InstallManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideAutoUpdateManagerFactory */
public final class ActivityModule_ProvideAutoUpdateManagerFactory implements C13181b<AutoUpdateManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AutoUpdateRepository> autoUpdateRepositoryProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final Provider<DownloadFactory> downloadFactoryProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final Provider<Integer> localVersionCodeProvider;
    private final ActivityModule module;
    private final Provider<PermissionManager> permissionManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7038195625613084183L, "cm/aptoide/pt/view/ActivityModule_ProvideAutoUpdateManagerFactory", 13);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideAutoUpdateManagerFactory(ActivityModule module2, Provider<DownloadFactory> downloadFactoryProvider2, Provider<PermissionManager> permissionManagerProvider2, Provider<InstallManager> installManagerProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<Integer> localVersionCodeProvider2, Provider<AutoUpdateRepository> autoUpdateRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.downloadFactoryProvider = downloadFactoryProvider2;
        this.permissionManagerProvider = permissionManagerProvider2;
        this.installManagerProvider = installManagerProvider2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        this.localVersionCodeProvider = localVersionCodeProvider2;
        this.autoUpdateRepositoryProvider = autoUpdateRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public AutoUpdateManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<DownloadFactory> provider = this.downloadFactoryProvider;
        $jacocoInit[1] = true;
        DownloadFactory downloadFactory = (DownloadFactory) provider.get();
        Provider<PermissionManager> provider2 = this.permissionManagerProvider;
        $jacocoInit[2] = true;
        PermissionManager permissionManager = (PermissionManager) provider2.get();
        Provider<InstallManager> provider3 = this.installManagerProvider;
        $jacocoInit[3] = true;
        InstallManager installManager = (InstallManager) provider3.get();
        Provider<DownloadAnalytics> provider4 = this.downloadAnalyticsProvider;
        $jacocoInit[4] = true;
        DownloadAnalytics downloadAnalytics = (DownloadAnalytics) provider4.get();
        Provider<Integer> provider5 = this.localVersionCodeProvider;
        $jacocoInit[5] = true;
        int intValue = ((Integer) provider5.get()).intValue();
        Provider<AutoUpdateRepository> provider6 = this.autoUpdateRepositoryProvider;
        $jacocoInit[6] = true;
        AutoUpdateRepository autoUpdateRepository = (AutoUpdateRepository) provider6.get();
        $jacocoInit[7] = true;
        AutoUpdateManager provideAutoUpdateManager = activityModule.provideAutoUpdateManager(downloadFactory, permissionManager, installManager, downloadAnalytics, intValue, autoUpdateRepository);
        $jacocoInit[8] = true;
        C13182c.m43111a(provideAutoUpdateManager, "Cannot return null from a non-@Nullable @Provides method");
        AutoUpdateManager autoUpdateManager = provideAutoUpdateManager;
        $jacocoInit[9] = true;
        return autoUpdateManager;
    }

    public static C13181b<AutoUpdateManager> create(ActivityModule module2, Provider<DownloadFactory> downloadFactoryProvider2, Provider<PermissionManager> permissionManagerProvider2, Provider<InstallManager> installManagerProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<Integer> localVersionCodeProvider2, Provider<AutoUpdateRepository> autoUpdateRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideAutoUpdateManagerFactory activityModule_ProvideAutoUpdateManagerFactory = new ActivityModule_ProvideAutoUpdateManagerFactory(module2, downloadFactoryProvider2, permissionManagerProvider2, installManagerProvider2, downloadAnalyticsProvider2, localVersionCodeProvider2, autoUpdateRepositoryProvider2);
        $jacocoInit[10] = true;
        return activityModule_ProvideAutoUpdateManagerFactory;
    }

    public static AutoUpdateManager proxyProvideAutoUpdateManager(ActivityModule instance, DownloadFactory downloadFactory, PermissionManager permissionManager, InstallManager installManager, DownloadAnalytics downloadAnalytics, int localVersionCode, AutoUpdateRepository autoUpdateRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateManager provideAutoUpdateManager = instance.provideAutoUpdateManager(downloadFactory, permissionManager, installManager, downloadAnalytics, localVersionCode, autoUpdateRepository);
        $jacocoInit[11] = true;
        return provideAutoUpdateManager;
    }
}
