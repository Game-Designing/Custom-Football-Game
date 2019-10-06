package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationAnalytics;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideBottomNavigationNavigatorFactory */
public final class ActivityModule_ProvideBottomNavigationNavigatorFactory implements C13181b<BottomNavigationNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BottomNavigationAnalytics> bottomNavigationAnalyticsProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;
    private final Provider<SearchAnalytics> searchAnalyticsProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1107440765695249126L, "cm/aptoide/pt/view/ActivityModule_ProvideBottomNavigationNavigatorFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideBottomNavigationNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationAnalytics> bottomNavigationAnalyticsProvider2, Provider<SearchAnalytics> searchAnalyticsProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.bottomNavigationAnalyticsProvider = bottomNavigationAnalyticsProvider2;
        this.searchAnalyticsProvider = searchAnalyticsProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public BottomNavigationNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider.get();
        Provider<BottomNavigationAnalytics> provider2 = this.bottomNavigationAnalyticsProvider;
        $jacocoInit[2] = true;
        BottomNavigationAnalytics bottomNavigationAnalytics = (BottomNavigationAnalytics) provider2.get();
        Provider<SearchAnalytics> provider3 = this.searchAnalyticsProvider;
        $jacocoInit[3] = true;
        SearchAnalytics searchAnalytics = (SearchAnalytics) provider3.get();
        Provider<String> provider4 = this.themeProvider;
        $jacocoInit[4] = true;
        String str = (String) provider4.get();
        $jacocoInit[5] = true;
        BottomNavigationNavigator provideBottomNavigationNavigator = activityModule.provideBottomNavigationNavigator(fragmentNavigator, bottomNavigationAnalytics, searchAnalytics, str);
        $jacocoInit[6] = true;
        C13182c.m43111a(provideBottomNavigationNavigator, "Cannot return null from a non-@Nullable @Provides method");
        BottomNavigationNavigator bottomNavigationNavigator = provideBottomNavigationNavigator;
        $jacocoInit[7] = true;
        return bottomNavigationNavigator;
    }

    public static C13181b<BottomNavigationNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationAnalytics> bottomNavigationAnalyticsProvider2, Provider<SearchAnalytics> searchAnalyticsProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideBottomNavigationNavigatorFactory activityModule_ProvideBottomNavigationNavigatorFactory = new ActivityModule_ProvideBottomNavigationNavigatorFactory(module2, fragmentNavigatorProvider2, bottomNavigationAnalyticsProvider2, searchAnalyticsProvider2, themeProvider2);
        $jacocoInit[8] = true;
        return activityModule_ProvideBottomNavigationNavigatorFactory;
    }

    public static BottomNavigationNavigator proxyProvideBottomNavigationNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator, BottomNavigationAnalytics bottomNavigationAnalytics, SearchAnalytics searchAnalytics, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationNavigator provideBottomNavigationNavigator = instance.provideBottomNavigationNavigator(fragmentNavigator, bottomNavigationAnalytics, searchAnalytics, theme);
        $jacocoInit[9] = true;
        return provideBottomNavigationNavigator;
    }
}
