package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.home.HomeAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesHomeAnalyticsFactory */
public final class FragmentModule_ProvidesHomeAnalyticsFactory implements C13181b<HomeAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final FragmentModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3220108478944301934L, "cm/aptoide/pt/view/FragmentModule_ProvidesHomeAnalyticsFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesHomeAnalyticsFactory(FragmentModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        $jacocoInit[0] = true;
    }

    public HomeAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AnalyticsManager> provider = this.analyticsManagerProvider;
        $jacocoInit[1] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider.get();
        NavigationTracker navigationTracker = (NavigationTracker) this.navigationTrackerProvider.get();
        $jacocoInit[2] = true;
        HomeAnalytics providesHomeAnalytics = fragmentModule.providesHomeAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesHomeAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        HomeAnalytics homeAnalytics = providesHomeAnalytics;
        $jacocoInit[4] = true;
        return homeAnalytics;
    }

    public static C13181b<HomeAnalytics> create(FragmentModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesHomeAnalyticsFactory fragmentModule_ProvidesHomeAnalyticsFactory = new FragmentModule_ProvidesHomeAnalyticsFactory(module2, analyticsManagerProvider2, navigationTrackerProvider2);
        $jacocoInit[5] = true;
        return fragmentModule_ProvidesHomeAnalyticsFactory;
    }

    public static HomeAnalytics proxyProvidesHomeAnalytics(FragmentModule instance, AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics providesHomeAnalytics = instance.providesHomeAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[6] = true;
        return providesHomeAnalytics;
    }
}
