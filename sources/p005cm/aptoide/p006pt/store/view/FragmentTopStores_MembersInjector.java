package p005cm.aptoide.p006pt.store.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.store.view.FragmentTopStores_MembersInjector */
public final class FragmentTopStores_MembersInjector implements C13183b<FragmentTopStores> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(429286778898283768L, "cm/aptoide/pt/store/view/FragmentTopStores_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((FragmentTopStores) obj);
        $jacocoInit[6] = true;
    }

    public FragmentTopStores_MembersInjector(Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<FragmentTopStores> create(Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentTopStores_MembersInjector fragmentTopStores_MembersInjector = new FragmentTopStores_MembersInjector(analyticsManagerProvider2, navigationTrackerProvider2);
        $jacocoInit[1] = true;
        return fragmentTopStores_MembersInjector;
    }

    public void injectMembers(FragmentTopStores instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectAnalyticsManager(instance, (AnalyticsManager) this.analyticsManagerProvider.get());
        $jacocoInit[2] = true;
        injectNavigationTracker(instance, (NavigationTracker) this.navigationTrackerProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectAnalyticsManager(FragmentTopStores instance, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.analyticsManager = analyticsManager;
        $jacocoInit[4] = true;
    }

    public static void injectNavigationTracker(FragmentTopStores instance, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.navigationTracker = navigationTracker;
        $jacocoInit[5] = true;
    }
}
