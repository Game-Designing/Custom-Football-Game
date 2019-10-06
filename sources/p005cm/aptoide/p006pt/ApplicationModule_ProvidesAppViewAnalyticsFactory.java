package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.app.AppViewAnalytics;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppViewAnalyticsFactory */
public final class ApplicationModule_ProvidesAppViewAnalyticsFactory implements C13181b<AppViewAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<BillingAnalytics> billingAnalyticsProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final ApplicationModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;
    private final Provider<StoreAnalytics> storeAnalyticsProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3722210807339678962L, "cm/aptoide/pt/ApplicationModule_ProvidesAppViewAnalyticsFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppViewAnalyticsFactory(ApplicationModule module2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<BillingAnalytics> billingAnalyticsProvider2, Provider<StoreAnalytics> storeAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        this.billingAnalyticsProvider = billingAnalyticsProvider2;
        this.storeAnalyticsProvider = storeAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public AppViewAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<DownloadAnalytics> provider = this.downloadAnalyticsProvider;
        $jacocoInit[1] = true;
        DownloadAnalytics downloadAnalytics = (DownloadAnalytics) provider.get();
        Provider<AnalyticsManager> provider2 = this.analyticsManagerProvider;
        $jacocoInit[2] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider2.get();
        Provider<NavigationTracker> provider3 = this.navigationTrackerProvider;
        $jacocoInit[3] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider3.get();
        Provider<BillingAnalytics> provider4 = this.billingAnalyticsProvider;
        $jacocoInit[4] = true;
        BillingAnalytics billingAnalytics = (BillingAnalytics) provider4.get();
        Provider<StoreAnalytics> provider5 = this.storeAnalyticsProvider;
        $jacocoInit[5] = true;
        StoreAnalytics storeAnalytics = (StoreAnalytics) provider5.get();
        $jacocoInit[6] = true;
        AppViewAnalytics providesAppViewAnalytics = applicationModule.providesAppViewAnalytics(downloadAnalytics, analyticsManager, navigationTracker, billingAnalytics, storeAnalytics);
        $jacocoInit[7] = true;
        C13182c.m43111a(providesAppViewAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        AppViewAnalytics appViewAnalytics = providesAppViewAnalytics;
        $jacocoInit[8] = true;
        return appViewAnalytics;
    }

    public static C13181b<AppViewAnalytics> create(ApplicationModule module2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<BillingAnalytics> billingAnalyticsProvider2, Provider<StoreAnalytics> storeAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppViewAnalyticsFactory applicationModule_ProvidesAppViewAnalyticsFactory = new ApplicationModule_ProvidesAppViewAnalyticsFactory(module2, downloadAnalyticsProvider2, analyticsManagerProvider2, navigationTrackerProvider2, billingAnalyticsProvider2, storeAnalyticsProvider2);
        $jacocoInit[9] = true;
        return applicationModule_ProvidesAppViewAnalyticsFactory;
    }

    public static AppViewAnalytics proxyProvidesAppViewAnalytics(ApplicationModule instance, DownloadAnalytics downloadAnalytics, AnalyticsManager analyticsManager, NavigationTracker navigationTracker, BillingAnalytics billingAnalytics, StoreAnalytics storeAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewAnalytics providesAppViewAnalytics = instance.providesAppViewAnalytics(downloadAnalytics, analyticsManager, navigationTracker, billingAnalytics, storeAnalytics);
        $jacocoInit[10] = true;
        return providesAppViewAnalytics;
    }
}
