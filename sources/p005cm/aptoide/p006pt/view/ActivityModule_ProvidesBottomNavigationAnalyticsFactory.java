package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesBottomNavigationAnalyticsFactory */
public final class ActivityModule_ProvidesBottomNavigationAnalyticsFactory implements C13181b<BottomNavigationAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> managerProvider;
    private final ActivityModule module;
    private final Provider<NavigationTracker> trackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6625071228294929969L, "cm/aptoide/pt/view/ActivityModule_ProvidesBottomNavigationAnalyticsFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesBottomNavigationAnalyticsFactory(ActivityModule module2, Provider<AnalyticsManager> managerProvider2, Provider<NavigationTracker> trackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.managerProvider = managerProvider2;
        this.trackerProvider = trackerProvider2;
        $jacocoInit[0] = true;
    }

    public BottomNavigationAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<AnalyticsManager> provider = this.managerProvider;
        $jacocoInit[1] = true;
        BottomNavigationAnalytics providesBottomNavigationAnalytics = activityModule.providesBottomNavigationAnalytics((AnalyticsManager) provider.get(), (NavigationTracker) this.trackerProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesBottomNavigationAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        BottomNavigationAnalytics bottomNavigationAnalytics = providesBottomNavigationAnalytics;
        $jacocoInit[3] = true;
        return bottomNavigationAnalytics;
    }

    public static C13181b<BottomNavigationAnalytics> create(ActivityModule module2, Provider<AnalyticsManager> managerProvider2, Provider<NavigationTracker> trackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesBottomNavigationAnalyticsFactory activityModule_ProvidesBottomNavigationAnalyticsFactory = new ActivityModule_ProvidesBottomNavigationAnalyticsFactory(module2, managerProvider2, trackerProvider2);
        $jacocoInit[4] = true;
        return activityModule_ProvidesBottomNavigationAnalyticsFactory;
    }

    public static BottomNavigationAnalytics proxyProvidesBottomNavigationAnalytics(ActivityModule instance, AnalyticsManager manager, NavigationTracker tracker) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationAnalytics providesBottomNavigationAnalytics = instance.providesBottomNavigationAnalytics(manager, tracker);
        $jacocoInit[5] = true;
        return providesBottomNavigationAnalytics;
    }
}
