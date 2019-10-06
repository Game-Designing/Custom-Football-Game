package p005cm.aptoide.p006pt.search.view;

import android.view.MenuItem;
import java.util.List;
import p002b.p003c.p053g.p061f.C1268l;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.search.model.SearchAdResultWrapper;
import p005cm.aptoide.p006pt.search.model.SearchAppResult;
import p005cm.aptoide.p006pt.search.model.SearchAppResultWrapper;
import p005cm.aptoide.p006pt.search.suggestions.SearchQueryEvent;
import p019d.p022i.p296a.p298b.p303c.p304a.C13030k;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.search.view.SearchResultView */
public interface SearchResultView extends SearchSuggestionsView {

    /* renamed from: cm.aptoide.pt.search.view.SearchResultView$Model */
    public interface Model {
        int getAllStoresOffset();

        List<SearchAdResult> getAllStoresSearchAdResults();

        List<SearchAppResult> getAllStoresSearchAppResults();

        String getCurrentQuery();

        int getFollowedStoresOffset();

        List<SearchAdResult> getFollowedStoresSearchAdResults();

        List<SearchAppResult> getFollowedStoresSearchAppResults();

        String getStoreName();

        String getStoreTheme();

        boolean hasData();

        boolean hasLoadedAds();

        boolean hasReachedBottomOfAllStores();

        boolean hasReachedBottomOfFollowedStores();

        void incrementOffsetAndCheckIfReachedBottomOfAllStores(int i);

        void incrementOffsetAndCheckIfReachedBottomOfFollowedStores(int i);

        boolean isAllStoresSelected();

        boolean isOnlyTrustedApps();

        void setAllStoresSelected(boolean z);

        void setHasLoadedAds();
    }

    void addAllStoresResult(String str, List<SearchAppResult> list);

    void addFollowedStoresResult(String str, List<SearchAppResult> list);

    C0120S<Void> allStoresResultReachedBottom();

    void clearUnsubmittedQuery();

    C0120S<Void> clickEverywhereSearchButton();

    C0120S<Void> clickFollowedStoresSearchButton();

    C0120S<String> clickNoResultsSearchButton();

    void disableUpNavigation();

    C0120S<Void> followedStoresResultReachedBottom();

    Model getViewModel();

    boolean hasResults();

    void hideFollowedStoresTab();

    void hideLoading();

    void hideLoadingMore();

    void hideNonFollowedStoresTab();

    void hideSuggestionsViews();

    boolean isSearchViewExpanded();

    C0120S<C1268l<String, SearchQueryEvent>> listenToSuggestionClick();

    C0120S<SearchAdResultWrapper> onAdClicked();

    C0120S<SearchAppResultWrapper> onViewItemClicked();

    C0120S<C13030k> queryChanged();

    void queryEvent(C13030k kVar);

    void scrollToTop();

    C0120S<MenuItem> searchMenuItemClick();

    C0120S<Void> searchSetup();

    void setAllStoresAdsEmpty();

    void setAllStoresAdsResult(SearchAdResult searchAdResult);

    void setFollowedStoresAdsEmpty();

    void setFollowedStoresAdsResult(SearchAdResult searchAdResult);

    void setUnsubmittedQuery(String str);

    void setViewWithStoreNameAsSingleTab(String str);

    void setVisibilityOnRestore();

    boolean shouldFocusInSearchBar();

    boolean shouldHideUpNavigation();

    boolean shouldShowSuggestions();

    void showAllStoresResult();

    void showBannerAd();

    void showFollowedStoresResult();

    void showLoading();

    void showLoadingMore();

    void showNativeAds(String str);

    void showNoResultsView();

    void showResultsView();

    C0120S<Boolean> showingSearchResultsView();

    void toggleSuggestionsView();

    void toggleTrendingView();

    C0120S<Void> toolbarClick();
}
