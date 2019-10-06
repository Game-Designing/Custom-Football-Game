package p005cm.aptoide.p006pt.view;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.AppShortcutsAnalytics;
import p005cm.aptoide.p006pt.DeepLinkAnalytics;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.search.SearchNavigator;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideDeepLinkManagerFactory */
public final class ActivityModule_ProvideDeepLinkManagerFactory implements C13181b<DeepLinkManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AdsRepository> adsRepositoryProvider;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<AppShortcutsAnalytics> appShortcutsAnalyticsProvider;
    private final Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider;
    private final Provider<DeepLinkAnalytics> deepLinkAnalyticsProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;
    private final Provider<NotificationAnalytics> notificationAnalyticsProvider;
    private final Provider<SearchAnalytics> searchAnalyticsProvider;
    private final Provider<SearchNavigator> searchNavigatorProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<StoreAccessor> storeAccessorProvider;
    private final Provider<StoreAnalytics> storeAnalyticsProvider;
    private final Provider<StoreRepository> storeRepositoryProvider;
    private final Provider<StoreUtilsProxy> storeUtilsProxyProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1998291250234943377L, "cm/aptoide/pt/view/ActivityModule_ProvideDeepLinkManagerFactory", 24);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideDeepLinkManagerFactory(ActivityModule module2, Provider<NotificationAnalytics> notificationAnalyticsProvider2, Provider<StoreUtilsProxy> storeUtilsProxyProvider2, Provider<StoreRepository> storeRepositoryProvider2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2, Provider<SearchNavigator> searchNavigatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<StoreAccessor> storeAccessorProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<SearchAnalytics> searchAnalyticsProvider2, Provider<DeepLinkAnalytics> deepLinkAnalyticsProvider2, Provider<AppShortcutsAnalytics> appShortcutsAnalyticsProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<StoreAnalytics> storeAnalyticsProvider2, Provider<AdsRepository> adsRepositoryProvider2, Provider<AppNavigator> appNavigatorProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.notificationAnalyticsProvider = notificationAnalyticsProvider2;
        this.storeUtilsProxyProvider = storeUtilsProxyProvider2;
        this.storeRepositoryProvider = storeRepositoryProvider2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.bottomNavigationNavigatorProvider = bottomNavigationNavigatorProvider2;
        this.searchNavigatorProvider = searchNavigatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.storeAccessorProvider = storeAccessorProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        this.searchAnalyticsProvider = searchAnalyticsProvider2;
        this.deepLinkAnalyticsProvider = deepLinkAnalyticsProvider2;
        this.appShortcutsAnalyticsProvider = appShortcutsAnalyticsProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.storeAnalyticsProvider = storeAnalyticsProvider2;
        this.adsRepositoryProvider = adsRepositoryProvider2;
        this.appNavigatorProvider = appNavigatorProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public DeepLinkManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<NotificationAnalytics> provider = this.notificationAnalyticsProvider;
        $jacocoInit[1] = true;
        NotificationAnalytics notificationAnalytics = (NotificationAnalytics) provider.get();
        Provider<StoreUtilsProxy> provider2 = this.storeUtilsProxyProvider;
        $jacocoInit[2] = true;
        StoreUtilsProxy storeUtilsProxy = (StoreUtilsProxy) provider2.get();
        Provider<StoreRepository> provider3 = this.storeRepositoryProvider;
        $jacocoInit[3] = true;
        StoreRepository storeRepository = (StoreRepository) provider3.get();
        Provider<FragmentNavigator> provider4 = this.fragmentNavigatorProvider;
        $jacocoInit[4] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider4.get();
        Provider<BottomNavigationNavigator> provider5 = this.bottomNavigationNavigatorProvider;
        $jacocoInit[5] = true;
        BottomNavigationNavigator bottomNavigationNavigator = (BottomNavigationNavigator) provider5.get();
        Provider<SearchNavigator> provider6 = this.searchNavigatorProvider;
        $jacocoInit[6] = true;
        SearchNavigator searchNavigator = (SearchNavigator) provider6.get();
        Provider<SharedPreferences> provider7 = this.sharedPreferencesProvider;
        $jacocoInit[7] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider7.get();
        Provider<StoreAccessor> provider8 = this.storeAccessorProvider;
        $jacocoInit[8] = true;
        StoreAccessor storeAccessor = (StoreAccessor) provider8.get();
        Provider<NavigationTracker> provider9 = this.navigationTrackerProvider;
        $jacocoInit[9] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider9.get();
        Provider<SearchAnalytics> provider10 = this.searchAnalyticsProvider;
        $jacocoInit[10] = true;
        SearchAnalytics searchAnalytics = (SearchAnalytics) provider10.get();
        Provider<DeepLinkAnalytics> provider11 = this.deepLinkAnalyticsProvider;
        $jacocoInit[11] = true;
        DeepLinkAnalytics deepLinkAnalytics = (DeepLinkAnalytics) provider11.get();
        Provider<AppShortcutsAnalytics> provider12 = this.appShortcutsAnalyticsProvider;
        $jacocoInit[12] = true;
        AppShortcutsAnalytics appShortcutsAnalytics = (AppShortcutsAnalytics) provider12.get();
        Provider<AptoideAccountManager> provider13 = this.accountManagerProvider;
        $jacocoInit[13] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider13.get();
        ActivityModule activityModule2 = activityModule;
        Provider<StoreAnalytics> provider14 = this.storeAnalyticsProvider;
        $jacocoInit[14] = true;
        StoreAnalytics storeAnalytics = (StoreAnalytics) provider14.get();
        Provider<AdsRepository> provider15 = this.adsRepositoryProvider;
        $jacocoInit[15] = true;
        AdsRepository adsRepository = (AdsRepository) provider15.get();
        Provider<AppNavigator> provider16 = this.appNavigatorProvider;
        $jacocoInit[16] = true;
        AppNavigator appNavigator = (AppNavigator) provider16.get();
        Provider<String> provider17 = this.themeProvider;
        $jacocoInit[17] = true;
        String str = (String) provider17.get();
        $jacocoInit[18] = true;
        DeepLinkManager provideDeepLinkManager = activityModule2.provideDeepLinkManager(notificationAnalytics, storeUtilsProxy, storeRepository, fragmentNavigator, bottomNavigationNavigator, searchNavigator, sharedPreferences, storeAccessor, navigationTracker, searchAnalytics, deepLinkAnalytics, appShortcutsAnalytics, aptoideAccountManager, storeAnalytics, adsRepository, appNavigator, str);
        $jacocoInit[19] = true;
        C13182c.m43111a(provideDeepLinkManager, "Cannot return null from a non-@Nullable @Provides method");
        DeepLinkManager deepLinkManager = provideDeepLinkManager;
        $jacocoInit[20] = true;
        return deepLinkManager;
    }

    public static C13181b<DeepLinkManager> create(ActivityModule module2, Provider<NotificationAnalytics> notificationAnalyticsProvider2, Provider<StoreUtilsProxy> storeUtilsProxyProvider2, Provider<StoreRepository> storeRepositoryProvider2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2, Provider<SearchNavigator> searchNavigatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<StoreAccessor> storeAccessorProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<SearchAnalytics> searchAnalyticsProvider2, Provider<DeepLinkAnalytics> deepLinkAnalyticsProvider2, Provider<AppShortcutsAnalytics> appShortcutsAnalyticsProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<StoreAnalytics> storeAnalyticsProvider2, Provider<AdsRepository> adsRepositoryProvider2, Provider<AppNavigator> appNavigatorProvider2, Provider<String> themeProvider2) {
        ActivityModule activityModule = module2;
        Provider<NotificationAnalytics> provider = notificationAnalyticsProvider2;
        Provider<StoreUtilsProxy> provider2 = storeUtilsProxyProvider2;
        Provider<StoreRepository> provider3 = storeRepositoryProvider2;
        Provider<FragmentNavigator> provider4 = fragmentNavigatorProvider2;
        Provider<BottomNavigationNavigator> provider5 = bottomNavigationNavigatorProvider2;
        Provider<SearchNavigator> provider6 = searchNavigatorProvider2;
        Provider<SharedPreferences> provider7 = sharedPreferencesProvider2;
        Provider<StoreAccessor> provider8 = storeAccessorProvider2;
        Provider<NavigationTracker> provider9 = navigationTrackerProvider2;
        Provider<SearchAnalytics> provider10 = searchAnalyticsProvider2;
        Provider<DeepLinkAnalytics> provider11 = deepLinkAnalyticsProvider2;
        Provider<AppShortcutsAnalytics> provider12 = appShortcutsAnalyticsProvider2;
        Provider<AptoideAccountManager> provider13 = accountManagerProvider2;
        Provider<StoreAnalytics> provider14 = storeAnalyticsProvider2;
        Provider<AdsRepository> provider15 = adsRepositoryProvider2;
        Provider<AppNavigator> provider16 = appNavigatorProvider2;
        Provider<String> provider17 = themeProvider2;
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideDeepLinkManagerFactory activityModule_ProvideDeepLinkManagerFactory = new ActivityModule_ProvideDeepLinkManagerFactory(activityModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
        $jacocoInit[21] = true;
        return activityModule_ProvideDeepLinkManagerFactory;
    }

    public static DeepLinkManager proxyProvideDeepLinkManager(ActivityModule instance, NotificationAnalytics notificationAnalytics, StoreUtilsProxy storeUtilsProxy, StoreRepository storeRepository, FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator, SearchNavigator searchNavigator, SharedPreferences sharedPreferences, StoreAccessor storeAccessor, NavigationTracker navigationTracker, SearchAnalytics searchAnalytics, DeepLinkAnalytics deepLinkAnalytics, AppShortcutsAnalytics appShortcutsAnalytics, AptoideAccountManager accountManager, StoreAnalytics storeAnalytics, AdsRepository adsRepository, AppNavigator appNavigator, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        DeepLinkManager provideDeepLinkManager = instance.provideDeepLinkManager(notificationAnalytics, storeUtilsProxy, storeRepository, fragmentNavigator, bottomNavigationNavigator, searchNavigator, sharedPreferences, storeAccessor, navigationTracker, searchAnalytics, deepLinkAnalytics, appShortcutsAnalytics, accountManager, storeAnalytics, adsRepository, appNavigator, theme);
        $jacocoInit[22] = true;
        return provideDeepLinkManager;
    }
}
