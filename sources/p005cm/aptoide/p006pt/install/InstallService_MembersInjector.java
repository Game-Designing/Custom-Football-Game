package p005cm.aptoide.p006pt.install;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.file.CacheHelper;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.install.InstallService_MembersInjector */
public final class InstallService_MembersInjector implements C13183b<InstallService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<CacheHelper> cacheManagerProvider;
    private final Provider<Installer> defaultInstallerProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final Provider<AptoideDownloadManager> downloadManagerProvider;
    private final Provider<InstalledRepository> installedRepositoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5579141962141312680L, "cm/aptoide/pt/install/InstallService_MembersInjector", 13);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((InstallService) obj);
        $jacocoInit[12] = true;
    }

    public InstallService_MembersInjector(Provider<AptoideDownloadManager> downloadManagerProvider2, Provider<Installer> defaultInstallerProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<CacheHelper> cacheManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadManagerProvider = downloadManagerProvider2;
        this.defaultInstallerProvider = defaultInstallerProvider2;
        this.installedRepositoryProvider = installedRepositoryProvider2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        this.cacheManagerProvider = cacheManagerProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<InstallService> create(Provider<AptoideDownloadManager> downloadManagerProvider2, Provider<Installer> defaultInstallerProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<CacheHelper> cacheManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallService_MembersInjector installService_MembersInjector = new InstallService_MembersInjector(downloadManagerProvider2, defaultInstallerProvider2, installedRepositoryProvider2, downloadAnalyticsProvider2, cacheManagerProvider2);
        $jacocoInit[1] = true;
        return installService_MembersInjector;
    }

    public void injectMembers(InstallService instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectDownloadManager(instance, (AptoideDownloadManager) this.downloadManagerProvider.get());
        $jacocoInit[2] = true;
        injectDefaultInstaller(instance, (Installer) this.defaultInstallerProvider.get());
        $jacocoInit[3] = true;
        injectInstalledRepository(instance, (InstalledRepository) this.installedRepositoryProvider.get());
        $jacocoInit[4] = true;
        injectDownloadAnalytics(instance, (DownloadAnalytics) this.downloadAnalyticsProvider.get());
        $jacocoInit[5] = true;
        injectCacheManager(instance, (CacheHelper) this.cacheManagerProvider.get());
        $jacocoInit[6] = true;
    }

    public static void injectDownloadManager(InstallService instance, AptoideDownloadManager downloadManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.downloadManager = downloadManager;
        $jacocoInit[7] = true;
    }

    public static void injectDefaultInstaller(InstallService instance, Installer defaultInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.defaultInstaller = defaultInstaller;
        $jacocoInit[8] = true;
    }

    public static void injectInstalledRepository(InstallService instance, InstalledRepository installedRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.installedRepository = installedRepository;
        $jacocoInit[9] = true;
    }

    public static void injectDownloadAnalytics(InstallService instance, DownloadAnalytics downloadAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.downloadAnalytics = downloadAnalytics;
        $jacocoInit[10] = true;
    }

    public static void injectCacheManager(InstallService instance, CacheHelper cacheManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.cacheManager = cacheManager;
        $jacocoInit[11] = true;
    }
}
