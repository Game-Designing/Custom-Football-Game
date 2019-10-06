package p005cm.aptoide.p006pt;

import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideInstallAnalyticsFactory */
public final class ApplicationModule_ProvideInstallAnalyticsFactory implements C13181b<InstallAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConnectivityManager> connectivityManagerProvider;
    private final ApplicationModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;
    private final Provider<TelephonyManager> telephonyManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5812248780999670326L, "cm/aptoide/pt/ApplicationModule_ProvideInstallAnalyticsFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideInstallAnalyticsFactory(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<ConnectivityManager> connectivityManagerProvider2, Provider<TelephonyManager> telephonyManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        this.connectivityManagerProvider = connectivityManagerProvider2;
        this.telephonyManagerProvider = telephonyManagerProvider2;
        $jacocoInit[0] = true;
    }

    public InstallAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AnalyticsManager> provider = this.analyticsManagerProvider;
        $jacocoInit[1] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider.get();
        Provider<NavigationTracker> provider2 = this.navigationTrackerProvider;
        $jacocoInit[2] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider2.get();
        Provider<ConnectivityManager> provider3 = this.connectivityManagerProvider;
        $jacocoInit[3] = true;
        ConnectivityManager connectivityManager = (ConnectivityManager) provider3.get();
        Provider<TelephonyManager> provider4 = this.telephonyManagerProvider;
        $jacocoInit[4] = true;
        TelephonyManager telephonyManager = (TelephonyManager) provider4.get();
        $jacocoInit[5] = true;
        InstallAnalytics provideInstallAnalytics = applicationModule.provideInstallAnalytics(analyticsManager, navigationTracker, connectivityManager, telephonyManager);
        $jacocoInit[6] = true;
        C13182c.m43111a(provideInstallAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        InstallAnalytics installAnalytics = provideInstallAnalytics;
        $jacocoInit[7] = true;
        return installAnalytics;
    }

    public static C13181b<InstallAnalytics> create(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<ConnectivityManager> connectivityManagerProvider2, Provider<TelephonyManager> telephonyManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideInstallAnalyticsFactory applicationModule_ProvideInstallAnalyticsFactory = new ApplicationModule_ProvideInstallAnalyticsFactory(module2, analyticsManagerProvider2, navigationTrackerProvider2, connectivityManagerProvider2, telephonyManagerProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvideInstallAnalyticsFactory;
    }

    public static InstallAnalytics proxyProvideInstallAnalytics(ApplicationModule instance, AnalyticsManager analyticsManager, NavigationTracker navigationTracker, ConnectivityManager connectivityManager, TelephonyManager telephonyManager) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallAnalytics provideInstallAnalytics = instance.provideInstallAnalytics(analyticsManager, navigationTracker, connectivityManager, telephonyManager);
        $jacocoInit[9] = true;
        return provideInstallAnalytics;
    }
}
