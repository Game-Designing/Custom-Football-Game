package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.promotions.PromotionsAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesPromotionsAnalyticsFactory */
public final class ApplicationModule_ProvidesPromotionsAnalyticsFactory implements C13181b<PromotionsAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final ApplicationModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2076747754102220594L, "cm/aptoide/pt/ApplicationModule_ProvidesPromotionsAnalyticsFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesPromotionsAnalyticsFactory(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public PromotionsAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AnalyticsManager> provider = this.analyticsManagerProvider;
        $jacocoInit[1] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider.get();
        Provider<NavigationTracker> provider2 = this.navigationTrackerProvider;
        $jacocoInit[2] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider2.get();
        Provider<DownloadAnalytics> provider3 = this.downloadAnalyticsProvider;
        $jacocoInit[3] = true;
        DownloadAnalytics downloadAnalytics = (DownloadAnalytics) provider3.get();
        $jacocoInit[4] = true;
        PromotionsAnalytics providesPromotionsAnalytics = applicationModule.providesPromotionsAnalytics(analyticsManager, navigationTracker, downloadAnalytics);
        $jacocoInit[5] = true;
        C13182c.m43111a(providesPromotionsAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        PromotionsAnalytics promotionsAnalytics = providesPromotionsAnalytics;
        $jacocoInit[6] = true;
        return promotionsAnalytics;
    }

    public static C13181b<PromotionsAnalytics> create(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesPromotionsAnalyticsFactory applicationModule_ProvidesPromotionsAnalyticsFactory = new ApplicationModule_ProvidesPromotionsAnalyticsFactory(module2, analyticsManagerProvider2, navigationTrackerProvider2, downloadAnalyticsProvider2);
        $jacocoInit[7] = true;
        return applicationModule_ProvidesPromotionsAnalyticsFactory;
    }

    public static PromotionsAnalytics proxyProvidesPromotionsAnalytics(ApplicationModule instance, AnalyticsManager analyticsManager, NavigationTracker navigationTracker, DownloadAnalytics downloadAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsAnalytics providesPromotionsAnalytics = instance.providesPromotionsAnalytics(analyticsManager, navigationTracker, downloadAnalytics);
        $jacocoInit[8] = true;
        return providesPromotionsAnalytics;
    }
}
