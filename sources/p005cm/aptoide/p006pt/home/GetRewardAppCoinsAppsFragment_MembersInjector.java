package p005cm.aptoide.p006pt.home;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.repository.request.RewardAppCoinsAppsRepository;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment_MembersInjector;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.home.GetRewardAppCoinsAppsFragment_MembersInjector */
public final class GetRewardAppCoinsAppsFragment_MembersInjector implements C13183b<GetRewardAppCoinsAppsFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<RewardAppCoinsAppsRepository> rewardAppsRepositoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4193401614662324129L, "cm/aptoide/pt/home/GetRewardAppCoinsAppsFragment_MembersInjector", 12);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((GetRewardAppCoinsAppsFragment) obj);
        $jacocoInit[11] = true;
    }

    public GetRewardAppCoinsAppsFragment_MembersInjector(Provider<String> marketNameProvider2, Provider<RewardAppCoinsAppsRepository> rewardAppsRepositoryProvider2, Provider<AppNavigator> appNavigatorProvider2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        this.rewardAppsRepositoryProvider = rewardAppsRepositoryProvider2;
        this.appNavigatorProvider = appNavigatorProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<GetRewardAppCoinsAppsFragment> create(Provider<String> marketNameProvider2, Provider<RewardAppCoinsAppsRepository> rewardAppsRepositoryProvider2, Provider<AppNavigator> appNavigatorProvider2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        GetRewardAppCoinsAppsFragment_MembersInjector getRewardAppCoinsAppsFragment_MembersInjector = new GetRewardAppCoinsAppsFragment_MembersInjector(marketNameProvider2, rewardAppsRepositoryProvider2, appNavigatorProvider2, analyticsManagerProvider2);
        $jacocoInit[1] = true;
        return getRewardAppCoinsAppsFragment_MembersInjector;
    }

    public void injectMembers(GetRewardAppCoinsAppsFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = this.marketNameProvider;
        $jacocoInit[2] = true;
        String str = (String) provider.get();
        $jacocoInit[3] = true;
        StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(instance, str);
        $jacocoInit[4] = true;
        injectRewardAppsRepository(instance, (RewardAppCoinsAppsRepository) this.rewardAppsRepositoryProvider.get());
        $jacocoInit[5] = true;
        injectAppNavigator(instance, (AppNavigator) this.appNavigatorProvider.get());
        $jacocoInit[6] = true;
        injectAnalyticsManager(instance, (AnalyticsManager) this.analyticsManagerProvider.get());
        $jacocoInit[7] = true;
    }

    public static void injectRewardAppsRepository(GetRewardAppCoinsAppsFragment instance, RewardAppCoinsAppsRepository rewardAppsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.rewardAppsRepository = rewardAppsRepository;
        $jacocoInit[8] = true;
    }

    public static void injectAppNavigator(GetRewardAppCoinsAppsFragment instance, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.appNavigator = appNavigator;
        $jacocoInit[9] = true;
    }

    public static void injectAnalyticsManager(GetRewardAppCoinsAppsFragment instance, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.analyticsManager = analyticsManager;
        $jacocoInit[10] = true;
    }
}
