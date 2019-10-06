package p005cm.aptoide.p006pt.store.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.store.view.StoreFragment_MembersInjector */
public final class StoreFragment_MembersInjector implements C13183b<StoreFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<MarketResourceFormatter> marketResourceFormatterProvider;
    private final Provider<NavigationTracker> navigationTrackerProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9086346174965001529L, "cm/aptoide/pt/store/view/StoreFragment_MembersInjector", 15);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((StoreFragment) obj);
        $jacocoInit[14] = true;
    }

    public StoreFragment_MembersInjector(Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<AppNavigator> appNavigatorProvider2, Provider<String> themeProvider2, Provider<String> marketNameProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        this.appNavigatorProvider = appNavigatorProvider2;
        this.themeProvider = themeProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.marketResourceFormatterProvider = marketResourceFormatterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<StoreFragment> create(Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<AppNavigator> appNavigatorProvider2, Provider<String> themeProvider2, Provider<String> marketNameProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreFragment_MembersInjector storeFragment_MembersInjector = new StoreFragment_MembersInjector(analyticsManagerProvider2, navigationTrackerProvider2, appNavigatorProvider2, themeProvider2, marketNameProvider2, marketResourceFormatterProvider2);
        $jacocoInit[1] = true;
        return storeFragment_MembersInjector;
    }

    public void injectMembers(StoreFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectAnalyticsManager(instance, (AnalyticsManager) this.analyticsManagerProvider.get());
        $jacocoInit[2] = true;
        injectNavigationTracker(instance, (NavigationTracker) this.navigationTrackerProvider.get());
        $jacocoInit[3] = true;
        injectAppNavigator(instance, (AppNavigator) this.appNavigatorProvider.get());
        $jacocoInit[4] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[5] = true;
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[6] = true;
        injectMarketResourceFormatter(instance, (MarketResourceFormatter) this.marketResourceFormatterProvider.get());
        $jacocoInit[7] = true;
    }

    public static void injectAnalyticsManager(StoreFragment instance, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.analyticsManager = analyticsManager;
        $jacocoInit[8] = true;
    }

    public static void injectNavigationTracker(StoreFragment instance, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.navigationTracker = navigationTracker;
        $jacocoInit[9] = true;
    }

    public static void injectAppNavigator(StoreFragment instance, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.appNavigator = appNavigator;
        $jacocoInit[10] = true;
    }

    public static void injectTheme(StoreFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[11] = true;
    }

    public static void injectMarketName(StoreFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[12] = true;
    }

    public static void injectMarketResourceFormatter(StoreFragment instance, MarketResourceFormatter marketResourceFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketResourceFormatter = marketResourceFormatter;
        $jacocoInit[13] = true;
    }
}
