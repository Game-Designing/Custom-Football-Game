package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAccountAnalyticsFactory */
public final class ApplicationModule_ProvideAccountAnalyticsFactory implements C13181b<AccountAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final ApplicationModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5246746494863556941L, "cm/aptoide/pt/ApplicationModule_ProvideAccountAnalyticsFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAccountAnalyticsFactory(ApplicationModule module2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public AccountAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<NavigationTracker> provider = this.navigationTrackerProvider;
        $jacocoInit[1] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider.get();
        AnalyticsManager analyticsManager = (AnalyticsManager) this.analyticsManagerProvider.get();
        $jacocoInit[2] = true;
        AccountAnalytics provideAccountAnalytics = applicationModule.provideAccountAnalytics(navigationTracker, analyticsManager);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideAccountAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        AccountAnalytics accountAnalytics = provideAccountAnalytics;
        $jacocoInit[4] = true;
        return accountAnalytics;
    }

    public static C13181b<AccountAnalytics> create(ApplicationModule module2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAccountAnalyticsFactory applicationModule_ProvideAccountAnalyticsFactory = new ApplicationModule_ProvideAccountAnalyticsFactory(module2, navigationTrackerProvider2, analyticsManagerProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvideAccountAnalyticsFactory;
    }

    public static AccountAnalytics proxyProvideAccountAnalytics(ApplicationModule instance, NavigationTracker navigationTracker, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountAnalytics provideAccountAnalytics = instance.provideAccountAnalytics(navigationTracker, analyticsManager);
        $jacocoInit[6] = true;
        return provideAccountAnalytics;
    }
}
