package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.editorial.EditorialAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesEditorialAnalyticsFactory */
public final class FragmentModule_ProvidesEditorialAnalyticsFactory implements C13181b<EditorialAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final FragmentModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(189416124416042761L, "cm/aptoide/pt/view/FragmentModule_ProvidesEditorialAnalyticsFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesEditorialAnalyticsFactory(FragmentModule module2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<DownloadAnalytics> provider = this.downloadAnalyticsProvider;
        $jacocoInit[1] = true;
        DownloadAnalytics downloadAnalytics = (DownloadAnalytics) provider.get();
        Provider<AnalyticsManager> provider2 = this.analyticsManagerProvider;
        $jacocoInit[2] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider2.get();
        Provider<NavigationTracker> provider3 = this.navigationTrackerProvider;
        $jacocoInit[3] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider3.get();
        $jacocoInit[4] = true;
        EditorialAnalytics providesEditorialAnalytics = fragmentModule.providesEditorialAnalytics(downloadAnalytics, analyticsManager, navigationTracker);
        $jacocoInit[5] = true;
        C13182c.m43111a(providesEditorialAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        EditorialAnalytics editorialAnalytics = providesEditorialAnalytics;
        $jacocoInit[6] = true;
        return editorialAnalytics;
    }

    public static C13181b<EditorialAnalytics> create(FragmentModule module2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesEditorialAnalyticsFactory fragmentModule_ProvidesEditorialAnalyticsFactory = new FragmentModule_ProvidesEditorialAnalyticsFactory(module2, downloadAnalyticsProvider2, analyticsManagerProvider2, navigationTrackerProvider2);
        $jacocoInit[7] = true;
        return fragmentModule_ProvidesEditorialAnalyticsFactory;
    }

    public static EditorialAnalytics proxyProvidesEditorialAnalytics(FragmentModule instance, DownloadAnalytics downloadAnalytics, AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialAnalytics providesEditorialAnalytics = instance.providesEditorialAnalytics(downloadAnalytics, analyticsManager, navigationTracker);
        $jacocoInit[8] = true;
        return providesEditorialAnalytics;
    }
}
