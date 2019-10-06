package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import okhttp3.Interceptor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.Md5Comparator;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloaderProvider;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesFileDownloaderProviderFactory */
public final class ApplicationModule_ProvidesFileDownloaderProviderFactory implements C13181b<FileDownloaderProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<String> cachePathProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final Provider<InstallAnalytics> installAnalyticsProvider;
    private final Provider<Md5Comparator> md5ComparatorProvider;
    private final ApplicationModule module;
    private final Provider<Interceptor> userAgentInterceptorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7167998173968461602L, "cm/aptoide/pt/ApplicationModule_ProvidesFileDownloaderProviderFactory", 13);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesFileDownloaderProviderFactory(ApplicationModule module2, Provider<String> cachePathProvider2, Provider<Interceptor> userAgentInterceptorProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<Md5Comparator> md5ComparatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.cachePathProvider = cachePathProvider2;
        this.userAgentInterceptorProvider = userAgentInterceptorProvider2;
        this.authenticationPersistenceProvider = authenticationPersistenceProvider2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        this.installAnalyticsProvider = installAnalyticsProvider2;
        this.md5ComparatorProvider = md5ComparatorProvider2;
        $jacocoInit[0] = true;
    }

    public FileDownloaderProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<String> provider = this.cachePathProvider;
        $jacocoInit[1] = true;
        String str = (String) provider.get();
        Provider<Interceptor> provider2 = this.userAgentInterceptorProvider;
        $jacocoInit[2] = true;
        Interceptor interceptor = (Interceptor) provider2.get();
        Provider<AuthenticationPersistence> provider3 = this.authenticationPersistenceProvider;
        $jacocoInit[3] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider3.get();
        Provider<DownloadAnalytics> provider4 = this.downloadAnalyticsProvider;
        $jacocoInit[4] = true;
        DownloadAnalytics downloadAnalytics = (DownloadAnalytics) provider4.get();
        Provider<InstallAnalytics> provider5 = this.installAnalyticsProvider;
        $jacocoInit[5] = true;
        InstallAnalytics installAnalytics = (InstallAnalytics) provider5.get();
        Provider<Md5Comparator> provider6 = this.md5ComparatorProvider;
        $jacocoInit[6] = true;
        Md5Comparator md5Comparator = (Md5Comparator) provider6.get();
        $jacocoInit[7] = true;
        FileDownloaderProvider providesFileDownloaderProvider = applicationModule.providesFileDownloaderProvider(str, interceptor, authenticationPersistence, downloadAnalytics, installAnalytics, md5Comparator);
        $jacocoInit[8] = true;
        C13182c.m43111a(providesFileDownloaderProvider, "Cannot return null from a non-@Nullable @Provides method");
        FileDownloaderProvider fileDownloaderProvider = providesFileDownloaderProvider;
        $jacocoInit[9] = true;
        return fileDownloaderProvider;
    }

    public static C13181b<FileDownloaderProvider> create(ApplicationModule module2, Provider<String> cachePathProvider2, Provider<Interceptor> userAgentInterceptorProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<Md5Comparator> md5ComparatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesFileDownloaderProviderFactory applicationModule_ProvidesFileDownloaderProviderFactory = new ApplicationModule_ProvidesFileDownloaderProviderFactory(module2, cachePathProvider2, userAgentInterceptorProvider2, authenticationPersistenceProvider2, downloadAnalyticsProvider2, installAnalyticsProvider2, md5ComparatorProvider2);
        $jacocoInit[10] = true;
        return applicationModule_ProvidesFileDownloaderProviderFactory;
    }

    public static FileDownloaderProvider proxyProvidesFileDownloaderProvider(ApplicationModule instance, String cachePath, Interceptor userAgentInterceptor, AuthenticationPersistence authenticationPersistence, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, Md5Comparator md5Comparator) {
        boolean[] $jacocoInit = $jacocoInit();
        FileDownloaderProvider providesFileDownloaderProvider = instance.providesFileDownloaderProvider(cachePath, userAgentInterceptor, authenticationPersistence, downloadAnalytics, installAnalytics, md5Comparator);
        $jacocoInit[11] = true;
        return providesFileDownloaderProvider;
    }
}
