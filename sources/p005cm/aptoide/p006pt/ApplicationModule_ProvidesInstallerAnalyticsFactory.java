package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallerAnalytics;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesInstallerAnalyticsFactory */
public final class ApplicationModule_ProvidesInstallerAnalyticsFactory implements C13181b<InstallerAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<InstallAnalytics> installAnalyticsProvider;
    private final ApplicationModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;
    private final Provider<RootAvailabilityManager> rootAvailabilityManagerProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2074659260481453076L, "cm/aptoide/pt/ApplicationModule_ProvidesInstallerAnalyticsFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesInstallerAnalyticsFactory(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<RootAvailabilityManager> rootAvailabilityManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.installAnalyticsProvider = installAnalyticsProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.rootAvailabilityManagerProvider = rootAvailabilityManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        $jacocoInit[0] = true;
    }

    public InstallerAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AnalyticsManager> provider = this.analyticsManagerProvider;
        $jacocoInit[1] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider.get();
        Provider<InstallAnalytics> provider2 = this.installAnalyticsProvider;
        $jacocoInit[2] = true;
        InstallAnalytics installAnalytics = (InstallAnalytics) provider2.get();
        Provider<SharedPreferences> provider3 = this.sharedPreferencesProvider;
        $jacocoInit[3] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider3.get();
        Provider<RootAvailabilityManager> provider4 = this.rootAvailabilityManagerProvider;
        $jacocoInit[4] = true;
        RootAvailabilityManager rootAvailabilityManager = (RootAvailabilityManager) provider4.get();
        Provider<NavigationTracker> provider5 = this.navigationTrackerProvider;
        $jacocoInit[5] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider5.get();
        $jacocoInit[6] = true;
        InstallerAnalytics providesInstallerAnalytics = applicationModule.providesInstallerAnalytics(analyticsManager, installAnalytics, sharedPreferences, rootAvailabilityManager, navigationTracker);
        $jacocoInit[7] = true;
        C13182c.m43111a(providesInstallerAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        InstallerAnalytics installerAnalytics = providesInstallerAnalytics;
        $jacocoInit[8] = true;
        return installerAnalytics;
    }

    public static C13181b<InstallerAnalytics> create(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<RootAvailabilityManager> rootAvailabilityManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesInstallerAnalyticsFactory applicationModule_ProvidesInstallerAnalyticsFactory = new ApplicationModule_ProvidesInstallerAnalyticsFactory(module2, analyticsManagerProvider2, installAnalyticsProvider2, sharedPreferencesProvider2, rootAvailabilityManagerProvider2, navigationTrackerProvider2);
        $jacocoInit[9] = true;
        return applicationModule_ProvidesInstallerAnalyticsFactory;
    }

    public static InstallerAnalytics proxyProvidesInstallerAnalytics(ApplicationModule instance, AnalyticsManager analyticsManager, InstallAnalytics installAnalytics, SharedPreferences sharedPreferences, RootAvailabilityManager rootAvailabilityManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallerAnalytics providesInstallerAnalytics = instance.providesInstallerAnalytics(analyticsManager, installAnalytics, sharedPreferences, rootAvailabilityManager, navigationTracker);
        $jacocoInit[10] = true;
        return providesInstallerAnalytics;
    }
}
