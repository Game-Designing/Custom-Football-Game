package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesSearchAnalyticsFactory */
public final class ApplicationModule_ProvidesSearchAnalyticsFactory implements C13181b<SearchAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final ApplicationModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7546090731487572301L, "cm/aptoide/pt/ApplicationModule_ProvidesSearchAnalyticsFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesSearchAnalyticsFactory(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        $jacocoInit[0] = true;
    }

    public SearchAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AnalyticsManager> provider = this.analyticsManagerProvider;
        $jacocoInit[1] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider.get();
        NavigationTracker navigationTracker = (NavigationTracker) this.navigationTrackerProvider.get();
        $jacocoInit[2] = true;
        SearchAnalytics providesSearchAnalytics = applicationModule.providesSearchAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesSearchAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        SearchAnalytics searchAnalytics = providesSearchAnalytics;
        $jacocoInit[4] = true;
        return searchAnalytics;
    }

    public static C13181b<SearchAnalytics> create(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesSearchAnalyticsFactory applicationModule_ProvidesSearchAnalyticsFactory = new ApplicationModule_ProvidesSearchAnalyticsFactory(module2, analyticsManagerProvider2, navigationTrackerProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesSearchAnalyticsFactory;
    }

    public static SearchAnalytics proxyProvidesSearchAnalytics(ApplicationModule instance, AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAnalytics providesSearchAnalytics = instance.providesSearchAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[6] = true;
        return providesSearchAnalytics;
    }
}
