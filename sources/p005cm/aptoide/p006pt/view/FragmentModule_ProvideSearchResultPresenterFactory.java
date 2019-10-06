package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.search.SearchManager;
import p005cm.aptoide.p006pt.search.SearchNavigator;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionManager;
import p005cm.aptoide.p006pt.search.suggestions.TrendingManager;
import p005cm.aptoide.p006pt.search.view.SearchResultPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvideSearchResultPresenterFactory */
public final class FragmentModule_ProvideSearchResultPresenterFactory implements C13181b<SearchResultPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BottomNavigationMapper> bottomNavigationMapperProvider;
    private final FragmentModule module;
    private final Provider<SearchAnalytics> searchAnalyticsProvider;
    private final Provider<SearchManager> searchManagerProvider;
    private final Provider<SearchNavigator> searchNavigatorProvider;
    private final Provider<SearchSuggestionManager> searchSuggestionManagerProvider;
    private final Provider<TrendingManager> trendingManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7795563038958013067L, "cm/aptoide/pt/view/FragmentModule_ProvideSearchResultPresenterFactory", 13);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvideSearchResultPresenterFactory(FragmentModule module2, Provider<SearchAnalytics> searchAnalyticsProvider2, Provider<SearchNavigator> searchNavigatorProvider2, Provider<SearchManager> searchManagerProvider2, Provider<TrendingManager> trendingManagerProvider2, Provider<SearchSuggestionManager> searchSuggestionManagerProvider2, Provider<BottomNavigationMapper> bottomNavigationMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.searchAnalyticsProvider = searchAnalyticsProvider2;
        this.searchNavigatorProvider = searchNavigatorProvider2;
        this.searchManagerProvider = searchManagerProvider2;
        this.trendingManagerProvider = trendingManagerProvider2;
        this.searchSuggestionManagerProvider = searchSuggestionManagerProvider2;
        this.bottomNavigationMapperProvider = bottomNavigationMapperProvider2;
        $jacocoInit[0] = true;
    }

    public SearchResultPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<SearchAnalytics> provider = this.searchAnalyticsProvider;
        $jacocoInit[1] = true;
        SearchAnalytics searchAnalytics = (SearchAnalytics) provider.get();
        Provider<SearchNavigator> provider2 = this.searchNavigatorProvider;
        $jacocoInit[2] = true;
        SearchNavigator searchNavigator = (SearchNavigator) provider2.get();
        Provider<SearchManager> provider3 = this.searchManagerProvider;
        $jacocoInit[3] = true;
        SearchManager searchManager = (SearchManager) provider3.get();
        Provider<TrendingManager> provider4 = this.trendingManagerProvider;
        $jacocoInit[4] = true;
        TrendingManager trendingManager = (TrendingManager) provider4.get();
        Provider<SearchSuggestionManager> provider5 = this.searchSuggestionManagerProvider;
        $jacocoInit[5] = true;
        SearchSuggestionManager searchSuggestionManager = (SearchSuggestionManager) provider5.get();
        Provider<BottomNavigationMapper> provider6 = this.bottomNavigationMapperProvider;
        $jacocoInit[6] = true;
        BottomNavigationMapper bottomNavigationMapper = (BottomNavigationMapper) provider6.get();
        $jacocoInit[7] = true;
        SearchResultPresenter provideSearchResultPresenter = fragmentModule.provideSearchResultPresenter(searchAnalytics, searchNavigator, searchManager, trendingManager, searchSuggestionManager, bottomNavigationMapper);
        $jacocoInit[8] = true;
        C13182c.m43111a(provideSearchResultPresenter, "Cannot return null from a non-@Nullable @Provides method");
        SearchResultPresenter searchResultPresenter = provideSearchResultPresenter;
        $jacocoInit[9] = true;
        return searchResultPresenter;
    }

    public static C13181b<SearchResultPresenter> create(FragmentModule module2, Provider<SearchAnalytics> searchAnalyticsProvider2, Provider<SearchNavigator> searchNavigatorProvider2, Provider<SearchManager> searchManagerProvider2, Provider<TrendingManager> trendingManagerProvider2, Provider<SearchSuggestionManager> searchSuggestionManagerProvider2, Provider<BottomNavigationMapper> bottomNavigationMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvideSearchResultPresenterFactory fragmentModule_ProvideSearchResultPresenterFactory = new FragmentModule_ProvideSearchResultPresenterFactory(module2, searchAnalyticsProvider2, searchNavigatorProvider2, searchManagerProvider2, trendingManagerProvider2, searchSuggestionManagerProvider2, bottomNavigationMapperProvider2);
        $jacocoInit[10] = true;
        return fragmentModule_ProvideSearchResultPresenterFactory;
    }

    public static SearchResultPresenter proxyProvideSearchResultPresenter(FragmentModule instance, SearchAnalytics searchAnalytics, SearchNavigator searchNavigator, SearchManager searchManager, TrendingManager trendingManager, SearchSuggestionManager searchSuggestionManager, BottomNavigationMapper bottomNavigationMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchResultPresenter provideSearchResultPresenter = instance.provideSearchResultPresenter(searchAnalytics, searchNavigator, searchManager, trendingManager, searchSuggestionManager, bottomNavigationMapper);
        $jacocoInit[11] = true;
        return provideSearchResultPresenter;
    }
}
