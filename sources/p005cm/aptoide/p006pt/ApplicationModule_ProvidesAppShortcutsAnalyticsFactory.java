package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppShortcutsAnalyticsFactory */
public final class ApplicationModule_ProvidesAppShortcutsAnalyticsFactory implements C13181b<AppShortcutsAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final ApplicationModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5937771409771136895L, "cm/aptoide/pt/ApplicationModule_ProvidesAppShortcutsAnalyticsFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppShortcutsAnalyticsFactory(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        $jacocoInit[0] = true;
    }

    public AppShortcutsAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AnalyticsManager> provider = this.analyticsManagerProvider;
        $jacocoInit[1] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider.get();
        NavigationTracker navigationTracker = (NavigationTracker) this.navigationTrackerProvider.get();
        $jacocoInit[2] = true;
        AppShortcutsAnalytics providesAppShortcutsAnalytics = applicationModule.providesAppShortcutsAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesAppShortcutsAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        AppShortcutsAnalytics appShortcutsAnalytics = providesAppShortcutsAnalytics;
        $jacocoInit[4] = true;
        return appShortcutsAnalytics;
    }

    public static C13181b<AppShortcutsAnalytics> create(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppShortcutsAnalyticsFactory applicationModule_ProvidesAppShortcutsAnalyticsFactory = new ApplicationModule_ProvidesAppShortcutsAnalyticsFactory(module2, analyticsManagerProvider2, navigationTrackerProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesAppShortcutsAnalyticsFactory;
    }

    public static AppShortcutsAnalytics proxyProvidesAppShortcutsAnalytics(ApplicationModule instance, AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        AppShortcutsAnalytics providesAppShortcutsAnalytics = instance.providesAppShortcutsAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[6] = true;
        return providesAppShortcutsAnalytics;
    }
}
