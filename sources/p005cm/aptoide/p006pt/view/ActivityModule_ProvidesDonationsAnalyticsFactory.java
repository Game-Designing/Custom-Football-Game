package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesDonationsAnalyticsFactory */
public final class ActivityModule_ProvidesDonationsAnalyticsFactory implements C13181b<DonationsAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final ActivityModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1640035056954477064L, "cm/aptoide/pt/view/ActivityModule_ProvidesDonationsAnalyticsFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesDonationsAnalyticsFactory(ActivityModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        $jacocoInit[0] = true;
    }

    public DonationsAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<AnalyticsManager> provider = this.analyticsManagerProvider;
        $jacocoInit[1] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider.get();
        NavigationTracker navigationTracker = (NavigationTracker) this.navigationTrackerProvider.get();
        $jacocoInit[2] = true;
        DonationsAnalytics providesDonationsAnalytics = activityModule.providesDonationsAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesDonationsAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        DonationsAnalytics donationsAnalytics = providesDonationsAnalytics;
        $jacocoInit[4] = true;
        return donationsAnalytics;
    }

    public static C13181b<DonationsAnalytics> create(ActivityModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesDonationsAnalyticsFactory activityModule_ProvidesDonationsAnalyticsFactory = new ActivityModule_ProvidesDonationsAnalyticsFactory(module2, analyticsManagerProvider2, navigationTrackerProvider2);
        $jacocoInit[5] = true;
        return activityModule_ProvidesDonationsAnalyticsFactory;
    }

    public static DonationsAnalytics proxyProvidesDonationsAnalytics(ActivityModule instance, AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        DonationsAnalytics providesDonationsAnalytics = instance.providesDonationsAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[6] = true;
        return providesDonationsAnalytics;
    }
}
