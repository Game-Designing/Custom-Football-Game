package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.downloadmanager.AppDownloaderProvider;
import p005cm.aptoide.p006pt.downloadmanager.RetryFileDownloaderProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppDownloaderProviderFactory */
public final class ApplicationModule_ProvidesAppDownloaderProviderFactory implements C13181b<AppDownloaderProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final Provider<RetryFileDownloaderProvider> fileDownloaderProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5046202853572996494L, "cm/aptoide/pt/ApplicationModule_ProvidesAppDownloaderProviderFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppDownloaderProviderFactory(ApplicationModule module2, Provider<RetryFileDownloaderProvider> fileDownloaderProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fileDownloaderProvider = fileDownloaderProvider2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public AppDownloaderProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<RetryFileDownloaderProvider> provider = this.fileDownloaderProvider;
        $jacocoInit[1] = true;
        RetryFileDownloaderProvider retryFileDownloaderProvider = (RetryFileDownloaderProvider) provider.get();
        DownloadAnalytics downloadAnalytics = (DownloadAnalytics) this.downloadAnalyticsProvider.get();
        $jacocoInit[2] = true;
        AppDownloaderProvider providesAppDownloaderProvider = applicationModule.providesAppDownloaderProvider(retryFileDownloaderProvider, downloadAnalytics);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesAppDownloaderProvider, "Cannot return null from a non-@Nullable @Provides method");
        AppDownloaderProvider appDownloaderProvider = providesAppDownloaderProvider;
        $jacocoInit[4] = true;
        return appDownloaderProvider;
    }

    public static C13181b<AppDownloaderProvider> create(ApplicationModule module2, Provider<RetryFileDownloaderProvider> fileDownloaderProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppDownloaderProviderFactory applicationModule_ProvidesAppDownloaderProviderFactory = new ApplicationModule_ProvidesAppDownloaderProviderFactory(module2, fileDownloaderProvider2, downloadAnalyticsProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesAppDownloaderProviderFactory;
    }

    public static AppDownloaderProvider proxyProvidesAppDownloaderProvider(ApplicationModule instance, RetryFileDownloaderProvider fileDownloaderProvider2, DownloadAnalytics downloadAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        AppDownloaderProvider providesAppDownloaderProvider = instance.providesAppDownloaderProvider(fileDownloaderProvider2, downloadAnalytics);
        $jacocoInit[6] = true;
        return providesAppDownloaderProvider;
    }
}
