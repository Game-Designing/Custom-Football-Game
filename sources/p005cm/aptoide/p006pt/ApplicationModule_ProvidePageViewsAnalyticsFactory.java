package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.PageViewsAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidePageViewsAnalyticsFactory */
public final class ApplicationModule_ProvidePageViewsAnalyticsFactory implements C13181b<PageViewsAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4038677211389518429L, "cm/aptoide/pt/ApplicationModule_ProvidePageViewsAnalyticsFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidePageViewsAnalyticsFactory(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public PageViewsAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AnalyticsManager> provider = this.analyticsManagerProvider;
        $jacocoInit[1] = true;
        PageViewsAnalytics providePageViewsAnalytics = applicationModule.providePageViewsAnalytics((AnalyticsManager) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providePageViewsAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        PageViewsAnalytics pageViewsAnalytics = providePageViewsAnalytics;
        $jacocoInit[3] = true;
        return pageViewsAnalytics;
    }

    public static C13181b<PageViewsAnalytics> create(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidePageViewsAnalyticsFactory applicationModule_ProvidePageViewsAnalyticsFactory = new ApplicationModule_ProvidePageViewsAnalyticsFactory(module2, analyticsManagerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidePageViewsAnalyticsFactory;
    }

    public static PageViewsAnalytics proxyProvidePageViewsAnalytics(ApplicationModule instance, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        PageViewsAnalytics providePageViewsAnalytics = instance.providePageViewsAnalytics(analyticsManager);
        $jacocoInit[5] = true;
        return providePageViewsAnalytics;
    }
}
