package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.downloadmanager.AppDownloaderProvider;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.downloadmanager.DownloadAppMapper;
import p005cm.aptoide.p006pt.downloadmanager.DownloadStatusMapper;
import p005cm.aptoide.p006pt.downloadmanager.DownloadsRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAptoideDownloadManagerFactory */
public final class ApplicationModule_ProvideAptoideDownloadManagerFactory implements C13181b<AptoideDownloadManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> apkPathProvider;
    private final Provider<AppDownloaderProvider> appDownloaderProvider;
    private final Provider<String> cachePathProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final Provider<DownloadAppMapper> downloadAppMapperProvider;
    private final Provider<DownloadStatusMapper> downloadStatusMapperProvider;
    private final Provider<DownloadsRepository> downloadsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<String> obbPathProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6615937345021369602L, "cm/aptoide/pt/ApplicationModule_ProvideAptoideDownloadManagerFactory", 15);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAptoideDownloadManagerFactory(ApplicationModule module2, Provider<DownloadsRepository> downloadsRepositoryProvider2, Provider<DownloadStatusMapper> downloadStatusMapperProvider2, Provider<String> cachePathProvider2, Provider<DownloadAppMapper> downloadAppMapperProvider2, Provider<AppDownloaderProvider> appDownloaderProvider2, Provider<String> apkPathProvider2, Provider<String> obbPathProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.downloadsRepositoryProvider = downloadsRepositoryProvider2;
        this.downloadStatusMapperProvider = downloadStatusMapperProvider2;
        this.cachePathProvider = cachePathProvider2;
        this.downloadAppMapperProvider = downloadAppMapperProvider2;
        this.appDownloaderProvider = appDownloaderProvider2;
        this.apkPathProvider = apkPathProvider2;
        this.obbPathProvider = obbPathProvider2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public AptoideDownloadManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<DownloadsRepository> provider = this.downloadsRepositoryProvider;
        $jacocoInit[1] = true;
        DownloadsRepository downloadsRepository = (DownloadsRepository) provider.get();
        Provider<DownloadStatusMapper> provider2 = this.downloadStatusMapperProvider;
        $jacocoInit[2] = true;
        DownloadStatusMapper downloadStatusMapper = (DownloadStatusMapper) provider2.get();
        Provider<String> provider3 = this.cachePathProvider;
        $jacocoInit[3] = true;
        String str = (String) provider3.get();
        Provider<DownloadAppMapper> provider4 = this.downloadAppMapperProvider;
        $jacocoInit[4] = true;
        DownloadAppMapper downloadAppMapper = (DownloadAppMapper) provider4.get();
        Provider<AppDownloaderProvider> provider5 = this.appDownloaderProvider;
        $jacocoInit[5] = true;
        AppDownloaderProvider appDownloaderProvider2 = (AppDownloaderProvider) provider5.get();
        Provider<String> provider6 = this.apkPathProvider;
        $jacocoInit[6] = true;
        String str2 = (String) provider6.get();
        Provider<String> provider7 = this.obbPathProvider;
        $jacocoInit[7] = true;
        String str3 = (String) provider7.get();
        Provider<DownloadAnalytics> provider8 = this.downloadAnalyticsProvider;
        $jacocoInit[8] = true;
        DownloadAnalytics downloadAnalytics = (DownloadAnalytics) provider8.get();
        $jacocoInit[9] = true;
        AptoideDownloadManager provideAptoideDownloadManager = applicationModule.provideAptoideDownloadManager(downloadsRepository, downloadStatusMapper, str, downloadAppMapper, appDownloaderProvider2, str2, str3, downloadAnalytics);
        $jacocoInit[10] = true;
        C13182c.m43111a(provideAptoideDownloadManager, "Cannot return null from a non-@Nullable @Provides method");
        AptoideDownloadManager aptoideDownloadManager = provideAptoideDownloadManager;
        $jacocoInit[11] = true;
        return aptoideDownloadManager;
    }

    public static C13181b<AptoideDownloadManager> create(ApplicationModule module2, Provider<DownloadsRepository> downloadsRepositoryProvider2, Provider<DownloadStatusMapper> downloadStatusMapperProvider2, Provider<String> cachePathProvider2, Provider<DownloadAppMapper> downloadAppMapperProvider2, Provider<AppDownloaderProvider> appDownloaderProvider2, Provider<String> apkPathProvider2, Provider<String> obbPathProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAptoideDownloadManagerFactory applicationModule_ProvideAptoideDownloadManagerFactory = new ApplicationModule_ProvideAptoideDownloadManagerFactory(module2, downloadsRepositoryProvider2, downloadStatusMapperProvider2, cachePathProvider2, downloadAppMapperProvider2, appDownloaderProvider2, apkPathProvider2, obbPathProvider2, downloadAnalyticsProvider2);
        $jacocoInit[12] = true;
        return applicationModule_ProvideAptoideDownloadManagerFactory;
    }

    public static AptoideDownloadManager proxyProvideAptoideDownloadManager(ApplicationModule instance, DownloadsRepository downloadsRepository, DownloadStatusMapper downloadStatusMapper, String cachePath, DownloadAppMapper downloadAppMapper, AppDownloaderProvider appDownloaderProvider2, String apkPath, String obbPath, DownloadAnalytics downloadAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideDownloadManager provideAptoideDownloadManager = instance.provideAptoideDownloadManager(downloadsRepository, downloadStatusMapper, cachePath, downloadAppMapper, appDownloaderProvider2, apkPath, obbPath, downloadAnalytics);
        $jacocoInit[13] = true;
        return provideAptoideDownloadManager;
    }
}
