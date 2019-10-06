package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.AdsUserPropertyManager;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.ads.MoPubAnalytics;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesMoPubAdsServiceFactory */
public final class ApplicationModule_ProvidesMoPubAdsServiceFactory implements C13181b<AdsUserPropertyManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<CrashReport> crashReportProvider;
    private final Provider<InstalledRepository> installedRepositoryProvider;
    private final Provider<MoPubAdsManager> moPubAdsManagerProvider;
    private final Provider<MoPubAnalytics> moPubAnalyticsProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7557031014835908255L, "cm/aptoide/pt/ApplicationModule_ProvidesMoPubAdsServiceFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesMoPubAdsServiceFactory(ApplicationModule module2, Provider<MoPubAdsManager> moPubAdsManagerProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<MoPubAnalytics> moPubAnalyticsProvider2, Provider<CrashReport> crashReportProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.moPubAdsManagerProvider = moPubAdsManagerProvider2;
        this.installedRepositoryProvider = installedRepositoryProvider2;
        this.moPubAnalyticsProvider = moPubAnalyticsProvider2;
        this.crashReportProvider = crashReportProvider2;
        $jacocoInit[0] = true;
    }

    public AdsUserPropertyManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<MoPubAdsManager> provider = this.moPubAdsManagerProvider;
        $jacocoInit[1] = true;
        MoPubAdsManager moPubAdsManager = (MoPubAdsManager) provider.get();
        Provider<InstalledRepository> provider2 = this.installedRepositoryProvider;
        $jacocoInit[2] = true;
        InstalledRepository installedRepository = (InstalledRepository) provider2.get();
        Provider<MoPubAnalytics> provider3 = this.moPubAnalyticsProvider;
        $jacocoInit[3] = true;
        MoPubAnalytics moPubAnalytics = (MoPubAnalytics) provider3.get();
        Provider<CrashReport> provider4 = this.crashReportProvider;
        $jacocoInit[4] = true;
        CrashReport crashReport = (CrashReport) provider4.get();
        $jacocoInit[5] = true;
        AdsUserPropertyManager providesMoPubAdsService = applicationModule.providesMoPubAdsService(moPubAdsManager, installedRepository, moPubAnalytics, crashReport);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesMoPubAdsService, "Cannot return null from a non-@Nullable @Provides method");
        AdsUserPropertyManager adsUserPropertyManager = providesMoPubAdsService;
        $jacocoInit[7] = true;
        return adsUserPropertyManager;
    }

    public static C13181b<AdsUserPropertyManager> create(ApplicationModule module2, Provider<MoPubAdsManager> moPubAdsManagerProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<MoPubAnalytics> moPubAnalyticsProvider2, Provider<CrashReport> crashReportProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesMoPubAdsServiceFactory applicationModule_ProvidesMoPubAdsServiceFactory = new ApplicationModule_ProvidesMoPubAdsServiceFactory(module2, moPubAdsManagerProvider2, installedRepositoryProvider2, moPubAnalyticsProvider2, crashReportProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvidesMoPubAdsServiceFactory;
    }

    public static AdsUserPropertyManager proxyProvidesMoPubAdsService(ApplicationModule instance, MoPubAdsManager moPubAdsManager, InstalledRepository installedRepository, MoPubAnalytics moPubAnalytics, CrashReport crashReport) {
        boolean[] $jacocoInit = $jacocoInit();
        AdsUserPropertyManager providesMoPubAdsService = instance.providesMoPubAdsService(moPubAdsManager, installedRepository, moPubAnalytics, crashReport);
        $jacocoInit[9] = true;
        return providesMoPubAdsService;
    }
}
