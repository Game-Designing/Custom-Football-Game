package p005cm.aptoide.p006pt.store.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.store.view.ListStoresFragment_MembersInjector */
public final class ListStoresFragment_MembersInjector implements C13183b<ListStoresFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1296595721271459525L, "cm/aptoide/pt/store/view/ListStoresFragment_MembersInjector", 14);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((ListStoresFragment) obj);
        $jacocoInit[13] = true;
    }

    public ListStoresFragment_MembersInjector(Provider<String> marketNameProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<ListStoresFragment> create(Provider<String> marketNameProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoresFragment_MembersInjector listStoresFragment_MembersInjector = new ListStoresFragment_MembersInjector(marketNameProvider2, analyticsManagerProvider2, navigationTrackerProvider2);
        $jacocoInit[1] = true;
        return listStoresFragment_MembersInjector;
    }

    public void injectMembers(ListStoresFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = this.marketNameProvider;
        $jacocoInit[2] = true;
        String str = (String) provider.get();
        $jacocoInit[3] = true;
        StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(instance, str);
        Provider<AnalyticsManager> provider2 = this.analyticsManagerProvider;
        $jacocoInit[4] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider2.get();
        $jacocoInit[5] = true;
        StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
        Provider<String> provider3 = this.marketNameProvider;
        $jacocoInit[6] = true;
        String str2 = (String) provider3.get();
        $jacocoInit[7] = true;
        StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(instance, str2);
        $jacocoInit[8] = true;
        injectAnalyticsManager(instance, (AnalyticsManager) this.analyticsManagerProvider.get());
        $jacocoInit[9] = true;
        injectNavigationTracker(instance, (NavigationTracker) this.navigationTrackerProvider.get());
        $jacocoInit[10] = true;
    }

    public static void injectAnalyticsManager(ListStoresFragment instance, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.analyticsManager = analyticsManager;
        $jacocoInit[11] = true;
    }

    public static void injectNavigationTracker(ListStoresFragment instance, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.navigationTracker = navigationTracker;
        $jacocoInit[12] = true;
    }
}
