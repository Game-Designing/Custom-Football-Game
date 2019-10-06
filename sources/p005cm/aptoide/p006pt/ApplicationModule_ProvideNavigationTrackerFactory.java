package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.implementation.PageViewsAnalytics;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideNavigationTrackerFactory */
public final class ApplicationModule_ProvideNavigationTrackerFactory implements C13181b<NavigationTracker> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsLogger> loggerProvider;
    private final ApplicationModule module;
    private final Provider<PageViewsAnalytics> pageViewsAnalyticsProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1565677901219335165L, "cm/aptoide/pt/ApplicationModule_ProvideNavigationTrackerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideNavigationTrackerFactory(ApplicationModule module2, Provider<PageViewsAnalytics> pageViewsAnalyticsProvider2, Provider<AnalyticsLogger> loggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.pageViewsAnalyticsProvider = pageViewsAnalyticsProvider2;
        this.loggerProvider = loggerProvider2;
        $jacocoInit[0] = true;
    }

    public NavigationTracker get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<PageViewsAnalytics> provider = this.pageViewsAnalyticsProvider;
        $jacocoInit[1] = true;
        NavigationTracker provideNavigationTracker = applicationModule.provideNavigationTracker((PageViewsAnalytics) provider.get(), (AnalyticsLogger) this.loggerProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideNavigationTracker, "Cannot return null from a non-@Nullable @Provides method");
        NavigationTracker navigationTracker = provideNavigationTracker;
        $jacocoInit[3] = true;
        return navigationTracker;
    }

    public static C13181b<NavigationTracker> create(ApplicationModule module2, Provider<PageViewsAnalytics> pageViewsAnalyticsProvider2, Provider<AnalyticsLogger> loggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideNavigationTrackerFactory applicationModule_ProvideNavigationTrackerFactory = new ApplicationModule_ProvideNavigationTrackerFactory(module2, pageViewsAnalyticsProvider2, loggerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideNavigationTrackerFactory;
    }

    public static NavigationTracker proxyProvideNavigationTracker(ApplicationModule instance, PageViewsAnalytics pageViewsAnalytics, AnalyticsLogger logger) {
        boolean[] $jacocoInit = $jacocoInit();
        NavigationTracker provideNavigationTracker = instance.provideNavigationTracker(pageViewsAnalytics, logger);
        $jacocoInit[5] = true;
        return provideNavigationTracker;
    }
}
