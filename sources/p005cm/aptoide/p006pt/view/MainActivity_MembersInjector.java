package p005cm.aptoide.p006pt.view;

import android.content.res.Resources;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.analytics.FirstLaunchAnalytics;
import p005cm.aptoide.p006pt.analytics.view.AnalyticsActivity_MembersInjector;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity_MembersInjector;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator_MembersInjector;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.view.MainActivity_MembersInjector */
public final class MainActivity_MembersInjector implements C13183b<MainActivity> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<BottomNavigationMapper> bottomNavigationMapperProvider;
    private final Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider;
    private final Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<MarketResourceFormatter> marketResourceFormatterProvider;
    private final Provider<Presenter> presenterProvider;
    private final Provider<Resources> resourcesProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3643372425896136719L, "cm/aptoide/pt/view/MainActivity_MembersInjector", 23);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((MainActivity) obj);
        $jacocoInit[22] = true;
    }

    public MainActivity_MembersInjector(Provider<AccountNavigator> accountNavigatorProvider2, Provider<String> marketNameProvider2, Provider<String> themeProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider2, Provider<BottomNavigationMapper> bottomNavigationMapperProvider2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2, Provider<Presenter> presenterProvider2, Provider<Resources> resourcesProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigatorProvider = accountNavigatorProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.themeProvider = themeProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.firstLaunchAnalyticsProvider = firstLaunchAnalyticsProvider2;
        this.bottomNavigationMapperProvider = bottomNavigationMapperProvider2;
        this.bottomNavigationNavigatorProvider = bottomNavigationNavigatorProvider2;
        this.presenterProvider = presenterProvider2;
        this.resourcesProvider = resourcesProvider2;
        this.marketResourceFormatterProvider = marketResourceFormatterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<MainActivity> create(Provider<AccountNavigator> accountNavigatorProvider2, Provider<String> marketNameProvider2, Provider<String> themeProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider2, Provider<BottomNavigationMapper> bottomNavigationMapperProvider2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2, Provider<Presenter> presenterProvider2, Provider<Resources> resourcesProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        MainActivity_MembersInjector mainActivity_MembersInjector = new MainActivity_MembersInjector(accountNavigatorProvider2, marketNameProvider2, themeProvider2, analyticsManagerProvider2, firstLaunchAnalyticsProvider2, bottomNavigationMapperProvider2, bottomNavigationNavigatorProvider2, presenterProvider2, resourcesProvider2, marketResourceFormatterProvider2);
        $jacocoInit[1] = true;
        return mainActivity_MembersInjector;
    }

    public void injectMembers(MainActivity instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AccountNavigator> provider = this.accountNavigatorProvider;
        $jacocoInit[2] = true;
        AccountNavigator accountNavigator = (AccountNavigator) provider.get();
        $jacocoInit[3] = true;
        ActivityResultNavigator_MembersInjector.injectAccountNavigator(instance, accountNavigator);
        $jacocoInit[4] = true;
        ActivityResultNavigator_MembersInjector.injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[5] = true;
        ActivityResultNavigator_MembersInjector.injectTheme(instance, (String) this.themeProvider.get());
        Provider<AnalyticsManager> provider2 = this.analyticsManagerProvider;
        $jacocoInit[6] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider2.get();
        $jacocoInit[7] = true;
        AnalyticsActivity_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
        Provider<FirstLaunchAnalytics> provider3 = this.firstLaunchAnalyticsProvider;
        $jacocoInit[8] = true;
        FirstLaunchAnalytics firstLaunchAnalytics = (FirstLaunchAnalytics) provider3.get();
        $jacocoInit[9] = true;
        AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(instance, firstLaunchAnalytics);
        $jacocoInit[10] = true;
        ThemedActivityView_MembersInjector.injectTheme(instance, (String) this.themeProvider.get());
        Provider<BottomNavigationMapper> provider4 = this.bottomNavigationMapperProvider;
        $jacocoInit[11] = true;
        BottomNavigationMapper bottomNavigationMapper = (BottomNavigationMapper) provider4.get();
        $jacocoInit[12] = true;
        BottomNavigationActivity_MembersInjector.injectBottomNavigationMapper(instance, bottomNavigationMapper);
        Provider<BottomNavigationNavigator> provider5 = this.bottomNavigationNavigatorProvider;
        $jacocoInit[13] = true;
        BottomNavigationNavigator bottomNavigationNavigator = (BottomNavigationNavigator) provider5.get();
        $jacocoInit[14] = true;
        BottomNavigationActivity_MembersInjector.injectBottomNavigationNavigator(instance, bottomNavigationNavigator);
        $jacocoInit[15] = true;
        injectPresenter(instance, (Presenter) this.presenterProvider.get());
        $jacocoInit[16] = true;
        injectResources(instance, (Resources) this.resourcesProvider.get());
        $jacocoInit[17] = true;
        injectMarketResourceFormatter(instance, (MarketResourceFormatter) this.marketResourceFormatterProvider.get());
        $jacocoInit[18] = true;
    }

    public static void injectPresenter(MainActivity instance, Presenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[19] = true;
    }

    public static void injectResources(MainActivity instance, Resources resources) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.resources = resources;
        $jacocoInit[20] = true;
    }

    public static void injectMarketResourceFormatter(MainActivity instance, MarketResourceFormatter marketResourceFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketResourceFormatter = marketResourceFormatter;
        $jacocoInit[21] = true;
    }
}
