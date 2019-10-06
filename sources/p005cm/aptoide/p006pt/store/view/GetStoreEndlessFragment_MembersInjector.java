package p005cm.aptoide.p006pt.store.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessResponse;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.store.view.GetStoreEndlessFragment_MembersInjector */
public final class GetStoreEndlessFragment_MembersInjector<T extends BaseV7EndlessResponse> implements C13183b<GetStoreEndlessFragment<T>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<String> marketNameProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6883006817634136594L, "cm/aptoide/pt/store/view/GetStoreEndlessFragment_MembersInjector", 10);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((GetStoreEndlessFragment) obj);
        $jacocoInit[9] = true;
    }

    public GetStoreEndlessFragment_MembersInjector(Provider<String> marketNameProvider2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public static <T extends BaseV7EndlessResponse> C13183b<GetStoreEndlessFragment<T>> create(Provider<String> marketNameProvider2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        GetStoreEndlessFragment_MembersInjector getStoreEndlessFragment_MembersInjector = new GetStoreEndlessFragment_MembersInjector(marketNameProvider2, analyticsManagerProvider2);
        $jacocoInit[1] = true;
        return getStoreEndlessFragment_MembersInjector;
    }

    public void injectMembers(GetStoreEndlessFragment<T> instance) {
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
    }
}
