package p005cm.aptoide.p006pt;

import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesDownloadAnalyticsFactory */
public final class ApplicationModule_ProvidesDownloadAnalyticsFactory implements C13181b<DownloadAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConnectivityManager> connectivityManagerProvider;
    private final ApplicationModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;
    private final Provider<TelephonyManager> providesSystemServiceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5559606602970132858L, "cm/aptoide/pt/ApplicationModule_ProvidesDownloadAnalyticsFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesDownloadAnalyticsFactory(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<ConnectivityManager> connectivityManagerProvider2, Provider<TelephonyManager> providesSystemServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        this.connectivityManagerProvider = connectivityManagerProvider2;
        this.providesSystemServiceProvider = providesSystemServiceProvider2;
        $jacocoInit[0] = true;
    }

    public DownloadAnalytics get() {
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
        Provider<TelephonyManager> provider4 = this.providesSystemServiceProvider;
        $jacocoInit[4] = true;
        TelephonyManager telephonyManager = (TelephonyManager) provider4.get();
        $jacocoInit[5] = true;
        DownloadAnalytics providesDownloadAnalytics = applicationModule.providesDownloadAnalytics(analyticsManager, navigationTracker, connectivityManager, telephonyManager);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesDownloadAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        DownloadAnalytics downloadAnalytics = providesDownloadAnalytics;
        $jacocoInit[7] = true;
        return downloadAnalytics;
    }

    public static C13181b<DownloadAnalytics> create(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<ConnectivityManager> connectivityManagerProvider2, Provider<TelephonyManager> providesSystemServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesDownloadAnalyticsFactory applicationModule_ProvidesDownloadAnalyticsFactory = new ApplicationModule_ProvidesDownloadAnalyticsFactory(module2, analyticsManagerProvider2, navigationTrackerProvider2, connectivityManagerProvider2, providesSystemServiceProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvidesDownloadAnalyticsFactory;
    }

    public static DownloadAnalytics proxyProvidesDownloadAnalytics(ApplicationModule instance, AnalyticsManager analyticsManager, NavigationTracker navigationTracker, ConnectivityManager connectivityManager, TelephonyManager providesSystemService) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAnalytics providesDownloadAnalytics = instance.providesDownloadAnalytics(analyticsManager, navigationTracker, connectivityManager, providesSystemService);
        $jacocoInit[9] = true;
        return providesDownloadAnalytics;
    }
}
