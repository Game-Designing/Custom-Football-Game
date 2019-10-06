package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.wallet.WalletInstallAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesWalletInstallAnalyticsFactory */
public final class ActivityModule_ProvidesWalletInstallAnalyticsFactory implements C13181b<WalletInstallAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final Provider<DownloadStateParser> downloadStateParserProvider;
    private final Provider<InstallAnalytics> installAnalyticsProvider;
    private final ActivityModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;
    private final Provider<NotificationAnalytics> notificationAnalyticsProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8510969470752397058L, "cm/aptoide/pt/view/ActivityModule_ProvidesWalletInstallAnalyticsFactory", 13);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesWalletInstallAnalyticsFactory(ActivityModule module2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<NotificationAnalytics> notificationAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<DownloadStateParser> downloadStateParserProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        this.notificationAnalyticsProvider = notificationAnalyticsProvider2;
        this.installAnalyticsProvider = installAnalyticsProvider2;
        this.downloadStateParserProvider = downloadStateParserProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        $jacocoInit[0] = true;
    }

    public WalletInstallAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<DownloadAnalytics> provider = this.downloadAnalyticsProvider;
        $jacocoInit[1] = true;
        DownloadAnalytics downloadAnalytics = (DownloadAnalytics) provider.get();
        Provider<NotificationAnalytics> provider2 = this.notificationAnalyticsProvider;
        $jacocoInit[2] = true;
        NotificationAnalytics notificationAnalytics = (NotificationAnalytics) provider2.get();
        Provider<InstallAnalytics> provider3 = this.installAnalyticsProvider;
        $jacocoInit[3] = true;
        InstallAnalytics installAnalytics = (InstallAnalytics) provider3.get();
        Provider<DownloadStateParser> provider4 = this.downloadStateParserProvider;
        $jacocoInit[4] = true;
        DownloadStateParser downloadStateParser = (DownloadStateParser) provider4.get();
        Provider<AnalyticsManager> provider5 = this.analyticsManagerProvider;
        $jacocoInit[5] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider5.get();
        Provider<NavigationTracker> provider6 = this.navigationTrackerProvider;
        $jacocoInit[6] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider6.get();
        $jacocoInit[7] = true;
        WalletInstallAnalytics providesWalletInstallAnalytics = activityModule.providesWalletInstallAnalytics(downloadAnalytics, notificationAnalytics, installAnalytics, downloadStateParser, analyticsManager, navigationTracker);
        $jacocoInit[8] = true;
        C13182c.m43111a(providesWalletInstallAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        WalletInstallAnalytics walletInstallAnalytics = providesWalletInstallAnalytics;
        $jacocoInit[9] = true;
        return walletInstallAnalytics;
    }

    public static C13181b<WalletInstallAnalytics> create(ActivityModule module2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<NotificationAnalytics> notificationAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<DownloadStateParser> downloadStateParserProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesWalletInstallAnalyticsFactory activityModule_ProvidesWalletInstallAnalyticsFactory = new ActivityModule_ProvidesWalletInstallAnalyticsFactory(module2, downloadAnalyticsProvider2, notificationAnalyticsProvider2, installAnalyticsProvider2, downloadStateParserProvider2, analyticsManagerProvider2, navigationTrackerProvider2);
        $jacocoInit[10] = true;
        return activityModule_ProvidesWalletInstallAnalyticsFactory;
    }

    public static WalletInstallAnalytics proxyProvidesWalletInstallAnalytics(ActivityModule instance, DownloadAnalytics downloadAnalytics, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, DownloadStateParser downloadStateParser, AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallAnalytics providesWalletInstallAnalytics = instance.providesWalletInstallAnalytics(downloadAnalytics, notificationAnalytics, installAnalytics, downloadStateParser, analyticsManager, navigationTracker);
        $jacocoInit[11] = true;
        return providesWalletInstallAnalytics;
    }
}
