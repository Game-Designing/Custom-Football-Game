package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.home.AdMapper;
import p005cm.aptoide.p006pt.home.Home;
import p005cm.aptoide.p006pt.home.HomeAnalytics;
import p005cm.aptoide.p006pt.home.HomeNavigator;
import p005cm.aptoide.p006pt.home.HomePresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesHomePresenterFactory */
public final class FragmentModule_ProvidesHomePresenterFactory implements C13181b<HomePresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AdMapper> adMapperProvider;
    private final Provider<AptoideAccountManager> aptoideAccountManagerProvider;
    private final Provider<HomeAnalytics> homeAnalyticsProvider;
    private final Provider<HomeNavigator> homeNavigatorProvider;
    private final Provider<Home> homeProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3818570444679699136L, "cm/aptoide/pt/view/FragmentModule_ProvidesHomePresenterFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesHomePresenterFactory(FragmentModule module2, Provider<Home> homeProvider2, Provider<HomeNavigator> homeNavigatorProvider2, Provider<AdMapper> adMapperProvider2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<HomeAnalytics> homeAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.homeProvider = homeProvider2;
        this.homeNavigatorProvider = homeNavigatorProvider2;
        this.adMapperProvider = adMapperProvider2;
        this.aptoideAccountManagerProvider = aptoideAccountManagerProvider2;
        this.homeAnalyticsProvider = homeAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public HomePresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<Home> provider = this.homeProvider;
        $jacocoInit[1] = true;
        Home home = (Home) provider.get();
        Provider<HomeNavigator> provider2 = this.homeNavigatorProvider;
        $jacocoInit[2] = true;
        HomeNavigator homeNavigator = (HomeNavigator) provider2.get();
        Provider<AdMapper> provider3 = this.adMapperProvider;
        $jacocoInit[3] = true;
        AdMapper adMapper = (AdMapper) provider3.get();
        Provider<AptoideAccountManager> provider4 = this.aptoideAccountManagerProvider;
        $jacocoInit[4] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider4.get();
        Provider<HomeAnalytics> provider5 = this.homeAnalyticsProvider;
        $jacocoInit[5] = true;
        HomeAnalytics homeAnalytics = (HomeAnalytics) provider5.get();
        $jacocoInit[6] = true;
        HomePresenter providesHomePresenter = fragmentModule.providesHomePresenter(home, homeNavigator, adMapper, aptoideAccountManager, homeAnalytics);
        $jacocoInit[7] = true;
        C13182c.m43111a(providesHomePresenter, "Cannot return null from a non-@Nullable @Provides method");
        HomePresenter homePresenter = providesHomePresenter;
        $jacocoInit[8] = true;
        return homePresenter;
    }

    public static C13181b<HomePresenter> create(FragmentModule module2, Provider<Home> homeProvider2, Provider<HomeNavigator> homeNavigatorProvider2, Provider<AdMapper> adMapperProvider2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<HomeAnalytics> homeAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesHomePresenterFactory fragmentModule_ProvidesHomePresenterFactory = new FragmentModule_ProvidesHomePresenterFactory(module2, homeProvider2, homeNavigatorProvider2, adMapperProvider2, aptoideAccountManagerProvider2, homeAnalyticsProvider2);
        $jacocoInit[9] = true;
        return fragmentModule_ProvidesHomePresenterFactory;
    }

    public static HomePresenter proxyProvidesHomePresenter(FragmentModule instance, Home home, HomeNavigator homeNavigator, AdMapper adMapper, AptoideAccountManager aptoideAccountManager, HomeAnalytics homeAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        HomePresenter providesHomePresenter = instance.providesHomePresenter(home, homeNavigator, adMapper, aptoideAccountManager, homeAnalytics);
        $jacocoInit[10] = true;
        return providesHomePresenter;
    }
}
