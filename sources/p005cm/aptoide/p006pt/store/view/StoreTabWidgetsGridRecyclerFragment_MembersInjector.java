package p005cm.aptoide.p006pt.store.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment_MembersInjector */
public final class StoreTabWidgetsGridRecyclerFragment_MembersInjector implements C13183b<StoreTabWidgetsGridRecyclerFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<String> marketNameProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6109702866453168888L, "cm/aptoide/pt/store/view/StoreTabWidgetsGridRecyclerFragment_MembersInjector", 10);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((StoreTabWidgetsGridRecyclerFragment) obj);
        $jacocoInit[9] = true;
    }

    public StoreTabWidgetsGridRecyclerFragment_MembersInjector(Provider<String> marketNameProvider2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<StoreTabWidgetsGridRecyclerFragment> create(Provider<String> marketNameProvider2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreTabWidgetsGridRecyclerFragment_MembersInjector storeTabWidgetsGridRecyclerFragment_MembersInjector = new StoreTabWidgetsGridRecyclerFragment_MembersInjector(marketNameProvider2, analyticsManagerProvider2);
        $jacocoInit[1] = true;
        return storeTabWidgetsGridRecyclerFragment_MembersInjector;
    }

    public void injectMembers(StoreTabWidgetsGridRecyclerFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = this.marketNameProvider;
        $jacocoInit[2] = true;
        String str = (String) provider.get();
        $jacocoInit[3] = true;
        StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(instance, str);
        $jacocoInit[4] = true;
        injectAnalyticsManager(instance, (AnalyticsManager) this.analyticsManagerProvider.get());
        $jacocoInit[5] = true;
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[6] = true;
    }

    public static void injectAnalyticsManager(StoreTabWidgetsGridRecyclerFragment instance, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.analyticsManager = analyticsManager;
        $jacocoInit[7] = true;
    }

    public static void injectMarketName(StoreTabWidgetsGridRecyclerFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[8] = true;
    }
}
