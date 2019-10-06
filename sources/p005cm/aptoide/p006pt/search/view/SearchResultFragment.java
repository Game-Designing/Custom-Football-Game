package p005cm.aptoide.p006pt.search.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.C0629j;
import android.support.p000v4.view.C0629j.C0633d;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.CardView;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.SearchView;
import android.support.p001v7.widget.Toolbar;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.mopub.mobileads.MoPubView;
import com.mopub.nativeads.InMobiNativeAdRenderer;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.MoPubRecyclerAdapter;
import com.mopub.nativeads.MoPubStaticNativeAdRenderer;
import com.mopub.nativeads.RequestParameters;
import com.mopub.nativeads.RequestParameters.Builder;
import com.mopub.nativeads.ViewBinder;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14377B;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p053g.p061f.C1268l;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.ads.MoPubBannerAdListener;
import p005cm.aptoide.p006pt.ads.MoPubNativeAdsListener;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.search.model.SearchAdResultWrapper;
import p005cm.aptoide.p006pt.search.model.SearchAppResult;
import p005cm.aptoide.p006pt.search.model.SearchAppResultWrapper;
import p005cm.aptoide.p006pt.search.model.SearchViewModel;
import p005cm.aptoide.p006pt.search.model.Suggestion;
import p005cm.aptoide.p006pt.search.suggestions.SearchQueryEvent;
import p005cm.aptoide.p006pt.search.view.SearchResultView.Model;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.view.BackButtonFragment;
import p005cm.aptoide.p006pt.view.ThemeUtils;
import p005cm.aptoide.p006pt.view.custom.DividerItemDecoration;
import p019d.p022i.p023b.C0100e;
import p019d.p022i.p296a.p298b.p303c.p304a.C13020a;
import p019d.p022i.p296a.p298b.p303c.p304a.C13024e;
import p019d.p022i.p296a.p298b.p303c.p304a.C13025f;
import p019d.p022i.p296a.p298b.p303c.p304a.C13026g;
import p019d.p022i.p296a.p298b.p303c.p304a.C13030k;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.search.view.SearchResultFragment */
public class SearchResultFragment extends BackButtonFragment implements SearchResultView, SearchSuggestionsView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ALL_STORES_SEARCH_LIST_STATE = "all_stores_search_list_state";
    private static final long ANIMATION_DURATION = 125;
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.SEARCH;
    private static final int COMPLETION_THRESHOLD = 0;
    private static final String FOCUS_IN_SEARCH = "focus_in_search";
    private static final String FOLLOWED_STORES_SEARCH_LIST_STATE = "followed_stores_search_list_state";
    private static final int LAYOUT = 2131427518;
    private static final String TRENDING_LIST_STATE = "trending_list_state";
    private static final String UNSUBMITTED_QUERY = "unsubmitted_query";
    private static final String VIEW_MODEL = "view_model";
    private static final int VISIBLE_THRESHOLD = 2;
    private C0760a actionBar;
    private CardView allAndFollowedStoresButtonsLayout;
    private Button allStoresButton;
    private SearchResultAdapter allStoresResultAdapter;
    private RecyclerView allStoresResultList;
    private MoPubView bannerAd;
    private BottomNavigationActivity bottomNavigationActivity;
    private String currentQuery;
    private boolean focusInSearchBar;
    private Button followedStoresButton;
    private SearchResultAdapter followedStoresResultAdapter;
    private RecyclerView followedStoresResultList;
    private boolean isSearchExpanded;
    private float listItemPadding;
    private MoPubRecyclerAdapter moPubRecyclerAdapter;
    private boolean noResults;
    private ImageView noResultsSearchButton;
    private View noSearchLayout;
    private EditText noSearchLayoutSearchQuery;
    private C0100e<SearchAdResultWrapper> onAdClickRelay;
    private C0100e<SearchAppResultWrapper> onItemViewClickRelay;
    private ProgressBar progressBar;
    private C14963c<SearchQueryEvent> queryTextChangedPublisher;
    private MenuItem searchMenuItem;
    @Inject
    SearchResultPresenter searchResultPresenter;
    private View searchResultsLayout;
    private C14963c<Void> searchSetupPublishSubject;
    private SearchSuggestionsAdapter searchSuggestionsAdapter;
    private SearchSuggestionsAdapter searchTrendingAdapter;
    private SearchView searchView;
    private C14963c<Boolean> showingSearchResultsView;
    private C14963c<SearchQueryEvent> suggestionClickedPublishSubject;
    private RecyclerView suggestionsResultList;
    @Inject
    String theme;
    private Toolbar toolbar;
    private RecyclerView trendingResultList;
    private String unsubmittedQuery;
    private SearchViewModel viewModel;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3997355915023616278L, "cm/aptoide/pt/search/view/SearchResultFragment", 541);
        $jacocoData = probes;
        return probes;
    }

    public SearchResultFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ boolean access$002(SearchResultFragment x0, boolean x1) {
        boolean[] $jacocoInit = $jacocoInit();
        x0.isSearchExpanded = x1;
        $jacocoInit[536] = true;
        return x1;
    }

    static /* synthetic */ boolean access$100(SearchResultFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean hasSearchResults = x0.hasSearchResults();
        $jacocoInit[537] = true;
        return hasSearchResults;
    }

    static /* synthetic */ boolean access$200(SearchResultFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = x0.noResults;
        $jacocoInit[538] = true;
        return z;
    }

    static /* synthetic */ void access$300(SearchResultFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        x0.forceSuggestions();
        $jacocoInit[539] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[540] = true;
    }

    public static SearchResultFragment newInstance(String currentQuery2) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchResultFragment newInstance = newInstance(currentQuery2, false);
        $jacocoInit[1] = true;
        return newInstance;
    }

    public static SearchResultFragment newInstance(boolean focusInSearchBar2) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchResultFragment newInstance = newInstance("", false, focusInSearchBar2);
        $jacocoInit[2] = true;
        return newInstance;
    }

    public static SearchResultFragment newInstance(String currentQuery2, boolean onlyTrustedApps) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchViewModel viewModel2 = new SearchViewModel(currentQuery2, onlyTrustedApps);
        $jacocoInit[3] = true;
        Bundle args = new Bundle();
        $jacocoInit[4] = true;
        args.putParcelable(VIEW_MODEL, C14377B.m45944a(viewModel2));
        $jacocoInit[5] = true;
        SearchResultFragment fragment = new SearchResultFragment();
        $jacocoInit[6] = true;
        fragment.setArguments(args);
        $jacocoInit[7] = true;
        return fragment;
    }

    public static SearchResultFragment newInstance(String currentQuery2, boolean onlyTrustedApps, boolean focusInSearchBar2) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchViewModel viewModel2 = new SearchViewModel(currentQuery2, onlyTrustedApps);
        $jacocoInit[8] = true;
        Bundle args = new Bundle();
        $jacocoInit[9] = true;
        args.putParcelable(VIEW_MODEL, C14377B.m45944a(viewModel2));
        $jacocoInit[10] = true;
        args.putBoolean(FOCUS_IN_SEARCH, focusInSearchBar2);
        $jacocoInit[11] = true;
        SearchResultFragment fragment = new SearchResultFragment();
        $jacocoInit[12] = true;
        fragment.setArguments(args);
        $jacocoInit[13] = true;
        return fragment;
    }

    public static SearchResultFragment newInstance(String currentQuery2, String storeName, String storeTheme) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchViewModel viewModel2 = new SearchViewModel(currentQuery2, storeName, storeTheme);
        $jacocoInit[14] = true;
        Bundle args = new Bundle();
        $jacocoInit[15] = true;
        args.putParcelable(VIEW_MODEL, C14377B.m45944a(viewModel2));
        $jacocoInit[16] = true;
        SearchResultFragment fragment = new SearchResultFragment();
        $jacocoInit[17] = true;
        fragment.setArguments(args);
        $jacocoInit[18] = true;
        return fragment;
    }

    private void findChildViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.allAndFollowedStoresButtonsLayout = (CardView) view.findViewById(C1375R.C1376id.fragment_search_result_all_followed_stores_buttons_layout);
        $jacocoInit[19] = true;
        this.allStoresResultList = (RecyclerView) view.findViewById(C1375R.C1376id.fragment_search_result_all_stores_app_list);
        $jacocoInit[20] = true;
        this.suggestionsResultList = (RecyclerView) view.findViewById(C1375R.C1376id.suggestions_list);
        $jacocoInit[21] = true;
        this.trendingResultList = (RecyclerView) view.findViewById(C1375R.C1376id.trending_list);
        $jacocoInit[22] = true;
        this.followedStoresResultList = (RecyclerView) view.findViewById(C1375R.C1376id.fragment_search_result_followed_stores_app_list);
        $jacocoInit[23] = true;
        this.allStoresButton = (Button) view.findViewById(C1375R.C1376id.fragment_search_result_all_stores_button);
        $jacocoInit[24] = true;
        this.followedStoresButton = (Button) view.findViewById(C1375R.C1376id.fragment_search_result_followed_stores_button);
        $jacocoInit[25] = true;
        this.searchResultsLayout = view.findViewById(C1375R.C1376id.fragment_search_result_layout);
        $jacocoInit[26] = true;
        this.noSearchLayout = view.findViewById(C1375R.C1376id.no_search_results_layout);
        $jacocoInit[27] = true;
        this.noSearchLayoutSearchQuery = (EditText) view.findViewById(C1375R.C1376id.search_text);
        $jacocoInit[28] = true;
        this.noResultsSearchButton = (ImageView) view.findViewById(C1375R.C1376id.ic_search_button);
        $jacocoInit[29] = true;
        this.progressBar = (ProgressBar) view.findViewById(C1375R.C1376id.progress_bar);
        $jacocoInit[30] = true;
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[31] = true;
        this.bannerAd = (MoPubView) view.findViewById(C1375R.C1376id.mopub_banner);
        $jacocoInit[32] = true;
    }

    public void showFollowedStoresResult() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.followedStoresResultList.getVisibility() == 0) {
            $jacocoInit[33] = true;
            setFollowedStoresButtonSelected();
            $jacocoInit[34] = true;
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            $jacocoInit[35] = true;
            int viewWidth = this.allStoresResultList.getWidth();
            $jacocoInit[36] = true;
            this.followedStoresResultList.setTranslationX((float) (-viewWidth));
            $jacocoInit[37] = true;
            this.followedStoresResultList.setVisibility(0);
            $jacocoInit[38] = true;
            ViewPropertyAnimator animate = this.followedStoresResultList.animate();
            float f = (float) viewWidth;
            $jacocoInit[39] = true;
            ViewPropertyAnimator translationXBy = animate.translationXBy(f);
            $jacocoInit[40] = true;
            ViewPropertyAnimator duration = translationXBy.setDuration(ANIMATION_DURATION);
            $jacocoInit[41] = true;
            duration.start();
            $jacocoInit[42] = true;
            ViewPropertyAnimator animate2 = this.allStoresResultList.animate();
            float f2 = (float) viewWidth;
            $jacocoInit[43] = true;
            ViewPropertyAnimator translationXBy2 = animate2.translationXBy(f2);
            $jacocoInit[44] = true;
            ViewPropertyAnimator duration2 = translationXBy2.setDuration(ANIMATION_DURATION);
            C4882s sVar = new C4882s(this);
            $jacocoInit[45] = true;
            ViewPropertyAnimator withEndAction = duration2.withEndAction(sVar);
            $jacocoInit[46] = true;
            withEndAction.start();
            $jacocoInit[47] = true;
        } else {
            this.followedStoresResultList.setVisibility(0);
            $jacocoInit[48] = true;
            this.allStoresResultList.setVisibility(4);
            $jacocoInit[49] = true;
            setFollowedStoresButtonSelected();
            $jacocoInit[50] = true;
        }
        $jacocoInit[51] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16182c() {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresResultList.setVisibility(4);
        $jacocoInit[534] = true;
        setFollowedStoresButtonSelected();
        $jacocoInit[535] = true;
    }

    public void showAllStoresResult() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.allStoresResultList.getVisibility() == 0) {
            $jacocoInit[52] = true;
            setAllStoresButtonSelected();
            $jacocoInit[53] = true;
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            $jacocoInit[54] = true;
            int viewWidth = this.followedStoresResultList.getWidth();
            $jacocoInit[55] = true;
            ViewPropertyAnimator animate = this.followedStoresResultList.animate();
            float f = (float) (-viewWidth);
            $jacocoInit[56] = true;
            ViewPropertyAnimator translationXBy = animate.translationXBy(f);
            $jacocoInit[57] = true;
            ViewPropertyAnimator duration = translationXBy.setDuration(ANIMATION_DURATION);
            $jacocoInit[58] = true;
            duration.start();
            $jacocoInit[59] = true;
            this.allStoresResultList.setTranslationX((float) viewWidth);
            $jacocoInit[60] = true;
            this.allStoresResultList.setVisibility(0);
            $jacocoInit[61] = true;
            ViewPropertyAnimator animate2 = this.allStoresResultList.animate();
            float f2 = (float) (-viewWidth);
            $jacocoInit[62] = true;
            ViewPropertyAnimator translationXBy2 = animate2.translationXBy(f2);
            $jacocoInit[63] = true;
            ViewPropertyAnimator duration2 = translationXBy2.setDuration(ANIMATION_DURATION);
            C4887t tVar = new C4887t(this);
            $jacocoInit[64] = true;
            ViewPropertyAnimator withEndAction = duration2.withEndAction(tVar);
            $jacocoInit[65] = true;
            withEndAction.start();
            $jacocoInit[66] = true;
        } else {
            this.followedStoresResultList.setVisibility(4);
            $jacocoInit[67] = true;
            this.allStoresResultList.setVisibility(0);
            $jacocoInit[68] = true;
            setAllStoresButtonSelected();
            $jacocoInit[69] = true;
        }
        $jacocoInit[70] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16181b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.followedStoresResultList.setVisibility(4);
        $jacocoInit[532] = true;
        setAllStoresButtonSelected();
        $jacocoInit[533] = true;
    }

    public C0120S<Void> clickFollowedStoresSearchButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.followedStoresButton);
        $jacocoInit[71] = true;
        return a;
    }

    public C0120S<Void> clickEverywhereSearchButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.allStoresButton);
        $jacocoInit[72] = true;
        return a;
    }

    public C0120S<String> clickNoResultsSearchButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.noResultsSearchButton);
        C4897v vVar = new C4897v(this);
        $jacocoInit[73] = true;
        C0120S<String> j = a.mo3669j(vVar);
        $jacocoInit[74] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ String mo16177a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Editable text = this.noSearchLayoutSearchQuery.getText();
        $jacocoInit[530] = true;
        String obj = text.toString();
        $jacocoInit[531] = true;
        return obj;
    }

    public void showNoResultsView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.noSearchLayout.setVisibility(0);
        $jacocoInit[75] = true;
        this.searchResultsLayout.setVisibility(8);
        $jacocoInit[76] = true;
        this.allAndFollowedStoresButtonsLayout.setVisibility(8);
        $jacocoInit[77] = true;
        this.followedStoresResultList.setVisibility(8);
        $jacocoInit[78] = true;
        this.allStoresResultList.setVisibility(8);
        $jacocoInit[79] = true;
        this.suggestionsResultList.setVisibility(8);
        $jacocoInit[80] = true;
        this.trendingResultList.setVisibility(8);
        this.noResults = true;
        $jacocoInit[81] = true;
        this.bannerAd.setVisibility(8);
        $jacocoInit[82] = true;
    }

    public void showResultsView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.noSearchLayout.setVisibility(8);
        $jacocoInit[83] = true;
        this.suggestionsResultList.setVisibility(8);
        $jacocoInit[84] = true;
        this.trendingResultList.setVisibility(8);
        $jacocoInit[85] = true;
        this.searchResultsLayout.setVisibility(0);
        $jacocoInit[86] = true;
        this.showingSearchResultsView.onNext(Boolean.valueOf(true));
        $jacocoInit[87] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressBar.setVisibility(0);
        $jacocoInit[88] = true;
        this.noSearchLayout.setVisibility(8);
        $jacocoInit[89] = true;
        this.searchResultsLayout.setVisibility(8);
        $jacocoInit[90] = true;
        this.bannerAd.setVisibility(8);
        $jacocoInit[91] = true;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressBar.setVisibility(8);
        $jacocoInit[92] = true;
    }

    public void addFollowedStoresResult(String query, List<SearchAppResult> dataList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followedStoresResultAdapter.addResultForSearch(query, dataList);
        $jacocoInit[93] = true;
        this.viewModel.addFollowedStoresSearchAppResults(dataList);
        $jacocoInit[94] = true;
    }

    public void addAllStoresResult(String query, List<SearchAppResult> dataList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresResultAdapter.addResultForSearch(query, dataList);
        $jacocoInit[95] = true;
        this.viewModel.addAllStoresSearchAppResults(dataList);
        $jacocoInit[96] = true;
    }

    public Model getViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchViewModel searchViewModel = this.viewModel;
        $jacocoInit[97] = true;
        return searchViewModel;
    }

    public void setFollowedStoresAdsResult(SearchAdResult ad) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followedStoresResultAdapter.setResultForAd(ad);
        $jacocoInit[98] = true;
        this.viewModel.addFollowedStoresSearchAdResults(Arrays.asList(new SearchAdResult[]{ad}));
        $jacocoInit[99] = true;
    }

    public void setAllStoresAdsResult(SearchAdResult ad) {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresResultAdapter.setResultForAd(ad);
        $jacocoInit[100] = true;
        this.viewModel.addAllStoresSearchAdResults(Arrays.asList(new SearchAdResult[]{ad}));
        $jacocoInit[101] = true;
    }

    public void setFollowedStoresAdsEmpty() {
        boolean[] $jacocoInit = $jacocoInit();
        this.followedStoresResultAdapter.setAdsLoaded();
        $jacocoInit[102] = true;
    }

    public void setAllStoresAdsEmpty() {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresResultAdapter.setAdsLoaded();
        $jacocoInit[103] = true;
    }

    public C0120S<Void> followedStoresResultReachedBottom() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> recyclerViewReachedBottom = recyclerViewReachedBottom(this.followedStoresResultList);
        $jacocoInit[104] = true;
        return recyclerViewReachedBottom;
    }

    public C0120S<Void> allStoresResultReachedBottom() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> recyclerViewReachedBottom = recyclerViewReachedBottom(this.allStoresResultList);
        $jacocoInit[105] = true;
        return recyclerViewReachedBottom;
    }

    public void showLoadingMore() {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresResultAdapter.setIsLoadingMore(true);
        $jacocoInit[106] = true;
        this.followedStoresResultAdapter.setIsLoadingMore(true);
        $jacocoInit[107] = true;
    }

    public void hideLoadingMore() {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresResultAdapter.setIsLoadingMore(false);
        $jacocoInit[108] = true;
        this.followedStoresResultAdapter.setIsLoadingMore(false);
        $jacocoInit[109] = true;
    }

    public void setViewWithStoreNameAsSingleTab(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followedStoresButton.setText(storeName);
        $jacocoInit[110] = true;
        this.allStoresButton.setVisibility(8);
        $jacocoInit[111] = true;
    }

    public void hideFollowedStoresTab() {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresButton.setVisibility(0);
        $jacocoInit[112] = true;
        this.allStoresResultList.setVisibility(0);
        $jacocoInit[113] = true;
        this.followedStoresButton.setVisibility(8);
        $jacocoInit[114] = true;
        this.followedStoresResultList.setVisibility(8);
        $jacocoInit[115] = true;
        setAllStoresButtonSelected();
        $jacocoInit[116] = true;
        this.viewModel.setAllStoresSelected(true);
        $jacocoInit[117] = true;
    }

    public void hideNonFollowedStoresTab() {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresButton.setVisibility(8);
        $jacocoInit[118] = true;
        this.allStoresResultList.setVisibility(8);
        $jacocoInit[119] = true;
        this.followedStoresButton.setVisibility(0);
        $jacocoInit[120] = true;
        this.followedStoresResultList.setVisibility(0);
        $jacocoInit[121] = true;
        setFollowedStoresButtonSelected();
        $jacocoInit[122] = true;
        this.viewModel.setAllStoresSelected(false);
        $jacocoInit[123] = true;
    }

    public C0120S<Void> searchSetup() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.searchSetupPublishSubject;
        $jacocoInit[124] = true;
        return cVar;
    }

    public void toggleSuggestionsView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.suggestionsResultList.setVisibility(0);
        $jacocoInit[125] = true;
        this.trendingResultList.setVisibility(8);
        $jacocoInit[126] = true;
    }

    public void toggleTrendingView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.suggestionsResultList.setVisibility(8);
        $jacocoInit[127] = true;
        this.trendingResultList.setVisibility(0);
        $jacocoInit[128] = true;
    }

    public void hideSuggestionsViews() {
        boolean[] $jacocoInit = $jacocoInit();
        this.suggestionsResultList.setVisibility(8);
        $jacocoInit[129] = true;
        this.trendingResultList.setVisibility(8);
        $jacocoInit[130] = true;
    }

    public boolean isSearchViewExpanded() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isActionViewExpanded = this.searchMenuItem.isActionViewExpanded();
        $jacocoInit[131] = true;
        return isActionViewExpanded;
    }

    /* renamed from: a */
    public /* synthetic */ C1268l mo16175a(SearchQueryEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        C1268l lVar = new C1268l(this.unsubmittedQuery, event);
        $jacocoInit[529] = true;
        return lVar;
    }

    public C0120S<C1268l<String, SearchQueryEvent>> listenToSuggestionClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<C1268l<String, SearchQueryEvent>> j = this.suggestionClickedPublishSubject.mo3669j(new C4892u(this));
        $jacocoInit[132] = true;
        return j;
    }

    public C0120S<Void> toolbarClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.toolbar);
        $jacocoInit[133] = true;
        return a;
    }

    public C0120S<MenuItem> searchMenuItemClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13026g.m42484a(this.toolbar);
        C4902w wVar = new C4902w(this);
        $jacocoInit[134] = true;
        C0120S<MenuItem> d = a.mo3653d((C0132p<? super T, Boolean>) wVar);
        $jacocoInit[135] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo16176a(MenuItem item) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == this.searchMenuItem.getItemId()) {
            $jacocoInit[526] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[527] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[528] = true;
        return valueOf;
    }

    public C0120S<SearchAdResultWrapper> onAdClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<SearchAdResultWrapper> eVar = this.onAdClickRelay;
        $jacocoInit[136] = true;
        return eVar;
    }

    public C0120S<SearchAppResultWrapper> onViewItemClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<SearchAppResultWrapper> eVar = this.onItemViewClickRelay;
        $jacocoInit[137] = true;
        return eVar;
    }

    public C0120S<C13030k> queryChanged() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<C13030k> a = C13025f.m42483a(this.searchView);
        $jacocoInit[138] = true;
        return a;
    }

    public void queryEvent(C13030k event) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<SearchQueryEvent> cVar = this.queryTextChangedPublisher;
        CharSequence c = event.mo41921c();
        $jacocoInit[139] = true;
        SearchQueryEvent searchQueryEvent = new SearchQueryEvent(c.toString(), event.mo41920b());
        $jacocoInit[140] = true;
        cVar.onNext(searchQueryEvent);
        $jacocoInit[141] = true;
    }

    public boolean shouldFocusInSearchBar() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.focusInSearchBar;
        $jacocoInit[142] = true;
        return z;
    }

    public void scrollToTop() {
        RecyclerView list;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.followedStoresResultList.getVisibility() == 0) {
            list = this.followedStoresResultList;
            $jacocoInit[143] = true;
        } else {
            list = this.allStoresResultList;
            $jacocoInit[144] = true;
        }
        LinearLayoutManager layoutManager = (LinearLayoutManager) list.getLayoutManager();
        $jacocoInit[145] = true;
        if (layoutManager.findLastVisibleItemPosition() <= 10) {
            $jacocoInit[146] = true;
        } else {
            $jacocoInit[147] = true;
            list.mo7618i(10);
            $jacocoInit[148] = true;
        }
        list.mo7622j(0);
        $jacocoInit[149] = true;
    }

    public boolean hasResults() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.allStoresResultAdapter.getItemCount() != 0) {
            $jacocoInit[150] = true;
        } else {
            SearchResultAdapter searchResultAdapter = this.followedStoresResultAdapter;
            $jacocoInit[151] = true;
            if (searchResultAdapter.getItemCount() == 0) {
                $jacocoInit[152] = true;
                z = false;
                $jacocoInit[157] = true;
                $jacocoInit[158] = true;
                return z;
            }
            $jacocoInit[153] = true;
        }
        MenuItem menuItem = this.searchMenuItem;
        $jacocoInit[154] = true;
        if (menuItem.isActionViewExpanded()) {
            $jacocoInit[155] = true;
            z = false;
            $jacocoInit[157] = true;
            $jacocoInit[158] = true;
            return z;
        }
        $jacocoInit[156] = true;
        z = true;
        $jacocoInit[158] = true;
        return z;
    }

    public void disableUpNavigation() {
        boolean[] $jacocoInit = $jacocoInit();
        C0760a aVar = this.actionBar;
        if (aVar == null) {
            $jacocoInit[159] = true;
        } else {
            $jacocoInit[160] = true;
            aVar.mo6156f(false);
            $jacocoInit[161] = true;
            this.actionBar.mo6153d(false);
            $jacocoInit[162] = true;
            this.actionBar.mo6154e(false);
            $jacocoInit[163] = true;
        }
        $jacocoInit[164] = true;
    }

    public boolean shouldHideUpNavigation() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.allStoresResultAdapter.getItemCount() == 0) {
            $jacocoInit[165] = true;
        } else {
            SearchResultAdapter searchResultAdapter = this.followedStoresResultAdapter;
            $jacocoInit[166] = true;
            if (searchResultAdapter.getItemCount() != 0) {
                $jacocoInit[167] = true;
                z = false;
                $jacocoInit[172] = true;
                $jacocoInit[173] = true;
                return z;
            }
            $jacocoInit[168] = true;
        }
        View view = this.noSearchLayout;
        $jacocoInit[169] = true;
        if (view.getVisibility() == 0) {
            $jacocoInit[170] = true;
            z = false;
            $jacocoInit[172] = true;
            $jacocoInit[173] = true;
            return z;
        }
        $jacocoInit[171] = true;
        z = true;
        $jacocoInit[173] = true;
        return z;
    }

    public void setUnsubmittedQuery(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        this.unsubmittedQuery = query;
        $jacocoInit[174] = true;
    }

    public void clearUnsubmittedQuery() {
        boolean[] $jacocoInit = $jacocoInit();
        this.unsubmittedQuery = "";
        $jacocoInit[175] = true;
    }

    public void setVisibilityOnRestore() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.focusInSearchBar) {
            $jacocoInit[176] = true;
        } else {
            $jacocoInit[177] = true;
            if (hasSearchResults()) {
                $jacocoInit[178] = true;
                showResultsView();
                $jacocoInit[179] = true;
            } else {
                showSuggestionsView();
                $jacocoInit[180] = true;
            }
        }
        $jacocoInit[181] = true;
    }

    public boolean shouldShowSuggestions() {
        boolean[] $jacocoInit = $jacocoInit();
        CharSequence title = this.toolbar.getTitle();
        $jacocoInit[182] = true;
        boolean equals = title.equals(getResources().getString(C1375R.string.search_hint_title));
        $jacocoInit[183] = true;
        return equals;
    }

    public void showBannerAd() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bannerAd.setBannerAdListener(new MoPubBannerAdListener());
        $jacocoInit[184] = true;
        this.bannerAd.setAdUnitId("d225547d92b743179d8a04b75bf7d116");
        $jacocoInit[185] = true;
        this.bannerAd.setVisibility(0);
        $jacocoInit[186] = true;
        this.bannerAd.loadAd();
        $jacocoInit[187] = true;
    }

    public C0120S<Boolean> showingSearchResultsView() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Boolean> cVar = this.showingSearchResultsView;
        $jacocoInit[188] = true;
        return cVar;
    }

    public void showNativeAds(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        Builder keywords = new Builder().keywords(query);
        $jacocoInit[189] = true;
        RequestParameters requestParameters = keywords.build();
        if (VERSION.SDK_INT < 21) {
            $jacocoInit[190] = true;
        } else {
            $jacocoInit[191] = true;
            this.moPubRecyclerAdapter.loadAds(BuildConfig.MOPUB_NATIVE_SEARCH_PLACEMENT_ID, requestParameters);
            $jacocoInit[192] = true;
        }
        $jacocoInit[193] = true;
    }

    public void showSuggestionsView() {
        boolean[] $jacocoInit = $jacocoInit();
        CharSequence query = this.searchView.getQuery();
        $jacocoInit[194] = true;
        String charSequence = query.toString();
        $jacocoInit[195] = true;
        if (charSequence.isEmpty()) {
            $jacocoInit[196] = true;
            this.noSearchLayout.setVisibility(8);
            $jacocoInit[197] = true;
            this.searchResultsLayout.setVisibility(8);
            $jacocoInit[198] = true;
            this.trendingResultList.setVisibility(0);
            $jacocoInit[199] = true;
            this.suggestionsResultList.setVisibility(8);
            $jacocoInit[200] = true;
            this.bannerAd.setVisibility(8);
            $jacocoInit[201] = true;
        } else {
            this.noSearchLayout.setVisibility(8);
            $jacocoInit[202] = true;
            this.searchResultsLayout.setVisibility(8);
            $jacocoInit[203] = true;
            this.suggestionsResultList.setVisibility(0);
            $jacocoInit[204] = true;
            this.trendingResultList.setVisibility(8);
            $jacocoInit[205] = true;
            this.bannerAd.setVisibility(8);
            $jacocoInit[206] = true;
        }
        $jacocoInit[207] = true;
    }

    private void forceSuggestions() {
        boolean[] $jacocoInit = $jacocoInit();
        this.noSearchLayout.setVisibility(8);
        $jacocoInit[208] = true;
        this.searchResultsLayout.setVisibility(8);
        $jacocoInit[209] = true;
        this.trendingResultList.setVisibility(0);
        $jacocoInit[210] = true;
        this.suggestionsResultList.setVisibility(8);
        MoPubView moPubView = this.bannerAd;
        if (moPubView == null) {
            $jacocoInit[211] = true;
        } else {
            $jacocoInit[212] = true;
            moPubView.setVisibility(8);
            $jacocoInit[213] = true;
        }
        $jacocoInit[214] = true;
    }

    private C0120S<Void> recyclerViewReachedBottom(RecyclerView recyclerView) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13024e.m42482a(recyclerView);
        C4911y yVar = new C4911y(this);
        $jacocoInit[215] = true;
        C0120S j = a.mo3669j(yVar);
        $jacocoInit[216] = true;
        C0120S b = j.mo3628b();
        C4915z zVar = C4915z.f8554a;
        $jacocoInit[217] = true;
        C0120S d = b.mo3653d((C0132p<? super T, Boolean>) zVar);
        C4907x xVar = C4907x.f8546a;
        $jacocoInit[218] = true;
        C0120S<Void> j2 = d.mo3669j(xVar);
        $jacocoInit[219] = true;
        return j2;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9037a(Boolean isEnd) {
        $jacocoInit()[525] = true;
        return isEnd;
    }

    /* renamed from: b */
    static /* synthetic */ Void m9039b(Boolean __) {
        $jacocoInit()[524] = true;
        return null;
    }

    /* access modifiers changed from: private */
    public boolean isEndReached(C13020a event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        RecyclerView recyclerView = (RecyclerView) event.mo41928a();
        $jacocoInit[220] = true;
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        $jacocoInit[221] = true;
        if (layoutManager.getItemCount() - layoutManager.findLastVisibleItemPosition() <= 2) {
            $jacocoInit[222] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[223] = true;
        }
        $jacocoInit[224] = true;
        return z;
    }

    private void setFollowedStoresButtonSelected() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.followedStoresButton.getVisibility() != 0) {
            $jacocoInit[225] = true;
        } else {
            $jacocoInit[226] = true;
            this.followedStoresButton.setTextColor(getResources().getColor(C1375R.color.white));
            $jacocoInit[227] = true;
            Button button = this.followedStoresButton;
            StoreTheme storeTheme = StoreTheme.get(this.theme);
            $jacocoInit[228] = true;
            int roundGradientButtonDrawable = storeTheme.getRoundGradientButtonDrawable();
            $jacocoInit[229] = true;
            button.setBackgroundResource(roundGradientButtonDrawable);
            $jacocoInit[230] = true;
        }
        if (this.allStoresButton.getVisibility() != 0) {
            $jacocoInit[231] = true;
        } else {
            $jacocoInit[232] = true;
            this.allStoresButton.setTextColor(getResources().getColor(C1375R.color.silver_dark));
            $jacocoInit[233] = true;
            this.allStoresButton.setBackgroundResource(C1375R.drawable.disabled_search_button_background);
            $jacocoInit[234] = true;
        }
        this.viewModel.setAllStoresSelected(false);
        $jacocoInit[235] = true;
        String storeTheme2 = this.viewModel.getStoreTheme();
        $jacocoInit[236] = true;
        if (!storeThemeExists(storeTheme2)) {
            $jacocoInit[237] = true;
        } else {
            $jacocoInit[238] = true;
            Button button2 = this.followedStoresButton;
            StoreTheme storeTheme3 = StoreTheme.get(storeTheme2);
            $jacocoInit[239] = true;
            int roundGradientButtonDrawable2 = storeTheme3.getRoundGradientButtonDrawable();
            $jacocoInit[240] = true;
            button2.setBackgroundResource(roundGradientButtonDrawable2);
            $jacocoInit[241] = true;
        }
        $jacocoInit[242] = true;
    }

    private void setAllStoresButtonSelected() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.followedStoresButton.getVisibility() != 0) {
            $jacocoInit[243] = true;
        } else {
            $jacocoInit[244] = true;
            this.followedStoresButton.setTextColor(getResources().getColor(C1375R.color.silver_dark));
            $jacocoInit[245] = true;
            this.followedStoresButton.setBackgroundResource(C1375R.drawable.disabled_search_button_background);
            $jacocoInit[246] = true;
        }
        if (this.allStoresButton.getVisibility() != 0) {
            $jacocoInit[247] = true;
        } else {
            $jacocoInit[248] = true;
            this.allStoresButton.setTextColor(getResources().getColor(C1375R.color.white));
            $jacocoInit[249] = true;
            Button button = this.allStoresButton;
            StoreTheme storeTheme = StoreTheme.get(this.theme);
            $jacocoInit[250] = true;
            int roundGradientButtonDrawable = storeTheme.getRoundGradientButtonDrawable();
            $jacocoInit[251] = true;
            button.setBackgroundResource(roundGradientButtonDrawable);
            $jacocoInit[252] = true;
        }
        this.viewModel.setAllStoresSelected(true);
        $jacocoInit[253] = true;
        String storeTheme2 = this.viewModel.getStoreTheme();
        $jacocoInit[254] = true;
        if (!storeThemeExists(storeTheme2)) {
            $jacocoInit[255] = true;
        } else {
            $jacocoInit[256] = true;
            Button button2 = this.allStoresButton;
            StoreTheme storeTheme3 = StoreTheme.get(storeTheme2);
            $jacocoInit[257] = true;
            int roundGradientButtonDrawable2 = storeTheme3.getRoundGradientButtonDrawable();
            $jacocoInit[258] = true;
            button2.setBackgroundResource(roundGradientButtonDrawable2);
            $jacocoInit[259] = true;
        }
        $jacocoInit[260] = true;
    }

    private boolean storeThemeExists(String storeTheme) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (storeTheme == null) {
            $jacocoInit[261] = true;
        } else if (storeTheme.length() <= 0) {
            $jacocoInit[262] = true;
        } else {
            $jacocoInit[263] = true;
            z = true;
            $jacocoInit[265] = true;
            return z;
        }
        z = false;
        $jacocoInit[264] = true;
        $jacocoInit[265] = true;
        return z;
    }

    private boolean hasSearchResults() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.allStoresResultAdapter.getItemCount() > 0) {
            $jacocoInit[266] = true;
        } else {
            SearchResultAdapter searchResultAdapter = this.followedStoresResultAdapter;
            $jacocoInit[267] = true;
            if (searchResultAdapter.getItemCount() > 0) {
                $jacocoInit[268] = true;
            } else {
                z = false;
                $jacocoInit[270] = true;
                $jacocoInit[271] = true;
                return z;
            }
        }
        $jacocoInit[269] = true;
        z = true;
        $jacocoInit[271] = true;
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean[] r2 = $jacocoInit()
            super.onCreate(r18)
            r3 = 1
            r4 = 272(0x110, float:3.81E-43)
            r2[r4] = r3
            cm.aptoide.pt.view.FragmentComponent r4 = r17.getFragmentComponent(r18)
            r4.inject(r0)
            r4 = 273(0x111, float:3.83E-43)
            r2[r4] = r3
            cm.aptoide.pt.crashreports.CrashReport r4 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r5 = 274(0x112, float:3.84E-43)
            r2[r5] = r3
            cm.aptoide.pt.search.model.SearchViewModel r5 = r0.viewModel
            java.lang.String r6 = "view_model"
            if (r5 == 0) goto L_0x002e
            r5 = 275(0x113, float:3.85E-43)
            r2[r5] = r3
            goto L_0x003f
        L_0x002e:
            if (r1 != 0) goto L_0x0035
            r5 = 276(0x114, float:3.87E-43)
            r2[r5] = r3
            goto L_0x003f
        L_0x0035:
            boolean r5 = r1.containsKey(r6)
            if (r5 != 0) goto L_0x0070
            r5 = 277(0x115, float:3.88E-43)
            r2[r5] = r3
        L_0x003f:
            cm.aptoide.pt.search.model.SearchViewModel r5 = r0.viewModel
            if (r5 == 0) goto L_0x0048
            r5 = 280(0x118, float:3.92E-43)
            r2[r5] = r3
            goto L_0x0084
        L_0x0048:
            android.os.Bundle r5 = r17.getArguments()
            boolean r5 = r5.containsKey(r6)
            if (r5 != 0) goto L_0x0057
            r5 = 281(0x119, float:3.94E-43)
            r2[r5] = r3
            goto L_0x0084
        L_0x0057:
            r5 = 282(0x11a, float:3.95E-43)
            r2[r5] = r3
            android.os.Bundle r5 = r17.getArguments()
            android.os.Parcelable r5 = r5.getParcelable(r6)
            java.lang.Object r5 = org.parceler.C14377B.m45945a(r5)
            cm.aptoide.pt.search.model.SearchViewModel r5 = (p005cm.aptoide.p006pt.search.model.SearchViewModel) r5
            r0.viewModel = r5
            r5 = 283(0x11b, float:3.97E-43)
            r2[r5] = r3
            goto L_0x0084
        L_0x0070:
            r5 = 278(0x116, float:3.9E-43)
            r2[r5] = r3
            android.os.Parcelable r5 = r1.getParcelable(r6)
            java.lang.Object r5 = org.parceler.C14377B.m45945a(r5)
            cm.aptoide.pt.search.model.SearchViewModel r5 = (p005cm.aptoide.p006pt.search.model.SearchViewModel) r5
            r0.viewModel = r5
            r5 = 279(0x117, float:3.91E-43)
            r2[r5] = r3
        L_0x0084:
            java.lang.String r5 = "focus_in_search"
            if (r1 != 0) goto L_0x008d
            r6 = 284(0x11c, float:3.98E-43)
            r2[r6] = r3
            goto L_0x0097
        L_0x008d:
            boolean r6 = r1.containsKey(r5)
            if (r6 != 0) goto L_0x00c0
            r6 = 285(0x11d, float:4.0E-43)
            r2[r6] = r3
        L_0x0097:
            android.os.Bundle r6 = r17.getArguments()
            boolean r6 = r6.containsKey(r5)
            if (r6 != 0) goto L_0x00a6
            r5 = 288(0x120, float:4.04E-43)
            r2[r5] = r3
            goto L_0x00ce
        L_0x00a6:
            if (r1 == 0) goto L_0x00ad
            r5 = 289(0x121, float:4.05E-43)
            r2[r5] = r3
            goto L_0x00ce
        L_0x00ad:
            r6 = 290(0x122, float:4.06E-43)
            r2[r6] = r3
            android.os.Bundle r6 = r17.getArguments()
            boolean r5 = r6.getBoolean(r5)
            r0.focusInSearchBar = r5
            r5 = 291(0x123, float:4.08E-43)
            r2[r5] = r3
            goto L_0x00ce
        L_0x00c0:
            r6 = 286(0x11e, float:4.01E-43)
            r2[r6] = r3
            boolean r5 = r1.getBoolean(r5)
            r0.focusInSearchBar = r5
            r5 = 287(0x11f, float:4.02E-43)
            r2[r5] = r3
        L_0x00ce:
            cm.aptoide.pt.search.model.SearchViewModel r5 = r0.viewModel
            if (r5 != 0) goto L_0x00d7
            r5 = 292(0x124, float:4.09E-43)
            r2[r5] = r3
            goto L_0x00e1
        L_0x00d7:
            java.lang.String r5 = r5.getCurrentQuery()
            r0.currentQuery = r5
            r5 = 293(0x125, float:4.1E-43)
            r2[r5] = r3
        L_0x00e1:
            android.support.v4.app.p r5 = r17.getActivity()
            android.app.Application r5 = r5.getApplication()
            r16 = r5
            r5 = 0
            r0.noResults = r5
            r5 = 294(0x126, float:4.12E-43)
            r2[r5] = r3
            d.i.b.e r5 = p019d.p022i.p023b.C0100e.m565o()
            r0.onItemViewClickRelay = r5
            r5 = 295(0x127, float:4.13E-43)
            r2[r5] = r3
            d.i.b.e r5 = p019d.p022i.p023b.C0100e.m565o()
            r0.onAdClickRelay = r5
            r5 = 296(0x128, float:4.15E-43)
            r2[r5] = r3
            rx.h.c r5 = p026rx.p028h.C14963c.m46753p()
            r0.suggestionClickedPublishSubject = r5
            r5 = 297(0x129, float:4.16E-43)
            r2[r5] = r3
            rx.h.c r5 = p026rx.p028h.C14963c.m46753p()
            r0.searchSetupPublishSubject = r5
            r5 = 298(0x12a, float:4.18E-43)
            r2[r5] = r3
            rx.h.c r5 = p026rx.p028h.C14963c.m46753p()
            r0.queryTextChangedPublisher = r5
            r5 = 299(0x12b, float:4.19E-43)
            r2[r5] = r3
            rx.h.c r5 = p026rx.p028h.C14963c.m46753p()
            r0.showingSearchResultsView = r5
            r5 = 300(0x12c, float:4.2E-43)
            r2[r5] = r3
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r5 = 301(0x12d, float:4.22E-43)
            r2[r5] = r3
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r5 = 302(0x12e, float:4.23E-43)
            r2[r5] = r3
            cm.aptoide.pt.search.view.SearchResultAdapter r11 = new cm.aptoide.pt.search.view.SearchResultAdapter
            d.i.b.e<cm.aptoide.pt.search.model.SearchAdResultWrapper> r6 = r0.onAdClickRelay
            d.i.b.e<cm.aptoide.pt.search.model.SearchAppResultWrapper> r7 = r0.onItemViewClickRelay
            r5 = r11
            r10 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            r0.followedStoresResultAdapter = r11
            r5 = 303(0x12f, float:4.25E-43)
            r2[r5] = r3
            android.content.res.Resources r5 = r17.getResources()
            r6 = 2131165432(0x7f0700f8, float:1.794508E38)
            float r5 = r5.getDimension(r6)
            r0.listItemPadding = r5
            r5 = 304(0x130, float:4.26E-43)
            r2[r5] = r3
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r5 = 305(0x131, float:4.27E-43)
            r2[r5] = r3
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r5 = 306(0x132, float:4.29E-43)
            r2[r5] = r3
            cm.aptoide.pt.search.view.SearchResultAdapter r5 = new cm.aptoide.pt.search.view.SearchResultAdapter
            d.i.b.e<cm.aptoide.pt.search.model.SearchAdResultWrapper> r11 = r0.onAdClickRelay
            d.i.b.e<cm.aptoide.pt.search.model.SearchAppResultWrapper> r12 = r0.onItemViewClickRelay
            r10 = r5
            r15 = r4
            r10.<init>(r11, r12, r13, r14, r15)
            r0.allStoresResultAdapter = r5
            r5 = 307(0x133, float:4.3E-43)
            r2[r5] = r3
            cm.aptoide.pt.search.view.SearchSuggestionsAdapter r5 = new cm.aptoide.pt.search.view.SearchSuggestionsAdapter
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            rx.h.c<cm.aptoide.pt.search.suggestions.SearchQueryEvent> r7 = r0.suggestionClickedPublishSubject
            r5.<init>(r6, r7)
            r0.searchSuggestionsAdapter = r5
            r5 = 308(0x134, float:4.32E-43)
            r2[r5] = r3
            cm.aptoide.pt.search.view.SearchSuggestionsAdapter r5 = new cm.aptoide.pt.search.view.SearchSuggestionsAdapter
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            rx.h.c<cm.aptoide.pt.search.suggestions.SearchQueryEvent> r7 = r0.suggestionClickedPublishSubject
            r5.<init>(r6, r7)
            r0.searchTrendingAdapter = r5
            r5 = 309(0x135, float:4.33E-43)
            r2[r5] = r3
            r0.setHasOptionsMenu(r3)
            r5 = 310(0x136, float:4.34E-43)
            r2[r5] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.search.view.SearchResultFragment.onCreate(android.os.Bundle):void");
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        Parcelable parcelable;
        Parcelable parcelable2;
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationActivity bottomNavigationActivity2 = this.bottomNavigationActivity;
        if (bottomNavigationActivity2 == null) {
            $jacocoInit[311] = true;
        } else {
            $jacocoInit[312] = true;
            bottomNavigationActivity2.requestFocus(BOTTOM_NAVIGATION_ITEM);
            $jacocoInit[313] = true;
        }
        findChildViews(view);
        $jacocoInit[314] = true;
        attachFollowedStoresResultListDependencies();
        $jacocoInit[315] = true;
        attachAllStoresResultListDependencies();
        $jacocoInit[316] = true;
        setupToolbar();
        $jacocoInit[317] = true;
        setupTheme();
        $jacocoInit[318] = true;
        this.suggestionsResultList.setLayoutManager(new LinearLayoutManager(getContext()));
        $jacocoInit[319] = true;
        this.trendingResultList.setLayoutManager(new LinearLayoutManager(getContext()));
        $jacocoInit[320] = true;
        this.suggestionsResultList.setAdapter(this.searchSuggestionsAdapter);
        $jacocoInit[321] = true;
        this.trendingResultList.setAdapter(this.searchTrendingAdapter);
        $jacocoInit[322] = true;
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel == null) {
            $jacocoInit[323] = true;
        } else if (!searchViewModel.hasData()) {
            $jacocoInit[324] = true;
        } else {
            $jacocoInit[325] = true;
            Parcelable parcelable3 = null;
            if (savedInstanceState != null) {
                parcelable = savedInstanceState.getParcelable(ALL_STORES_SEARCH_LIST_STATE);
                $jacocoInit[326] = true;
            } else {
                $jacocoInit[327] = true;
                parcelable = null;
            }
            if (savedInstanceState != null) {
                $jacocoInit[328] = true;
                parcelable2 = savedInstanceState.getParcelable(FOLLOWED_STORES_SEARCH_LIST_STATE);
                $jacocoInit[329] = true;
            } else {
                $jacocoInit[330] = true;
                parcelable2 = null;
            }
            if (savedInstanceState != null) {
                $jacocoInit[331] = true;
                parcelable3 = savedInstanceState.getParcelable(TRENDING_LIST_STATE);
                $jacocoInit[332] = true;
            } else {
                $jacocoInit[333] = true;
            }
            restoreViewState(parcelable, parcelable2, parcelable3);
            $jacocoInit[334] = true;
        }
        if (savedInstanceState == null) {
            $jacocoInit[335] = true;
        } else {
            $jacocoInit[336] = true;
            String str2 = UNSUBMITTED_QUERY;
            if (savedInstanceState.containsKey(str2)) {
                str = savedInstanceState.getString(str2);
                $jacocoInit[337] = true;
            } else {
                $jacocoInit[338] = true;
                str = "";
            }
            this.unsubmittedQuery = str;
            $jacocoInit[339] = true;
        }
        attachPresenter(this.searchResultPresenter);
        $jacocoInit[340] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[341] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[342] = true;
        ScreenTagHistory build = ScreenTagHistory.Builder.build(simpleName);
        $jacocoInit[343] = true;
        return build;
    }

    private void setupTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel == null) {
            $jacocoInit[344] = true;
        } else if (!storeThemeExists(searchViewModel.getStoreTheme())) {
            $jacocoInit[345] = true;
        } else {
            $jacocoInit[346] = true;
            String storeTheme = this.viewModel.getStoreTheme();
            $jacocoInit[347] = true;
            ThemeUtils.setStoreTheme(getActivity(), storeTheme);
            $jacocoInit[348] = true;
            ThemeUtils.setStatusBarThemeColor(getActivity(), storeTheme);
            $jacocoInit[349] = true;
            Toolbar toolbar2 = this.toolbar;
            StoreTheme storeTheme2 = StoreTheme.get(storeTheme);
            $jacocoInit[350] = true;
            int gradientDrawable = storeTheme2.getGradientDrawable();
            $jacocoInit[351] = true;
            toolbar2.setBackgroundResource(gradientDrawable);
            if (VERSION.SDK_INT < 21) {
                $jacocoInit[352] = true;
                Drawable wrapDrawable = C1200a.m5741i(this.progressBar.getIndeterminateDrawable());
                $jacocoInit[353] = true;
                Context context = getContext();
                $jacocoInit[354] = true;
                StoreTheme storeTheme3 = StoreTheme.get(storeTheme);
                $jacocoInit[355] = true;
                int primaryColor = storeTheme3.getPrimaryColor();
                $jacocoInit[356] = true;
                C1200a.m5734b(wrapDrawable, C0510b.m2564a(context, primaryColor));
                $jacocoInit[357] = true;
                this.progressBar.setIndeterminateDrawable(C1200a.m5740h(wrapDrawable));
                $jacocoInit[358] = true;
            } else {
                Drawable indeterminateDrawable = this.progressBar.getIndeterminateDrawable();
                $jacocoInit[359] = true;
                Context context2 = getContext();
                StoreTheme storeTheme4 = StoreTheme.get(storeTheme);
                $jacocoInit[360] = true;
                int primaryColor2 = storeTheme4.getPrimaryColor();
                $jacocoInit[361] = true;
                indeterminateDrawable.setColorFilter(C0510b.m2564a(context2, primaryColor2), Mode.SRC_IN);
                $jacocoInit[362] = true;
            }
        }
        $jacocoInit[363] = true;
    }

    private void setupDefaultTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!storeThemeExists(this.theme)) {
            $jacocoInit[364] = true;
        } else {
            $jacocoInit[365] = true;
            ThemeUtils.setStoreTheme(getActivity(), this.theme);
            $jacocoInit[366] = true;
            ThemeUtils.setStatusBarThemeColor(getActivity(), this.theme);
            if (VERSION.SDK_INT < 21) {
                $jacocoInit[367] = true;
                Drawable wrapDrawable = C1200a.m5741i(this.progressBar.getIndeterminateDrawable());
                $jacocoInit[368] = true;
                Context context = getContext();
                String str = this.theme;
                $jacocoInit[369] = true;
                StoreTheme storeTheme = StoreTheme.get(str);
                $jacocoInit[370] = true;
                int primaryColor = storeTheme.getPrimaryColor();
                $jacocoInit[371] = true;
                C1200a.m5734b(wrapDrawable, C0510b.m2564a(context, primaryColor));
                $jacocoInit[372] = true;
                this.progressBar.setIndeterminateDrawable(C1200a.m5740h(wrapDrawable));
                $jacocoInit[373] = true;
            } else {
                Drawable indeterminateDrawable = this.progressBar.getIndeterminateDrawable();
                $jacocoInit[374] = true;
                Context context2 = getContext();
                StoreTheme storeTheme2 = StoreTheme.get(this.theme);
                $jacocoInit[375] = true;
                int primaryColor2 = storeTheme2.getPrimaryColor();
                $jacocoInit[376] = true;
                indeterminateDrawable.setColorFilter(C0510b.m2564a(context2, primaryColor2), Mode.SRC_IN);
                $jacocoInit[377] = true;
            }
        }
        $jacocoInit[378] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresResultList.clearAnimation();
        $jacocoInit[379] = true;
        this.followedStoresResultList.clearAnimation();
        $jacocoInit[380] = true;
        setupDefaultTheme();
        $jacocoInit[381] = true;
        super.onDestroyView();
        MoPubRecyclerAdapter moPubRecyclerAdapter2 = this.moPubRecyclerAdapter;
        if (moPubRecyclerAdapter2 == null) {
            $jacocoInit[382] = true;
        } else {
            $jacocoInit[383] = true;
            moPubRecyclerAdapter2.destroy();
            this.moPubRecyclerAdapter = null;
            $jacocoInit[384] = true;
        }
        MoPubView moPubView = this.bannerAd;
        if (moPubView == null) {
            $jacocoInit[385] = true;
        } else {
            $jacocoInit[386] = true;
            moPubView.destroy();
            this.bannerAd = null;
            $jacocoInit[387] = true;
        }
        $jacocoInit[388] = true;
    }

    public void onDetach() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationActivity = null;
        $jacocoInit[389] = true;
        super.onDetach();
        $jacocoInit[390] = true;
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        if (!(activity instanceof BottomNavigationActivity)) {
            $jacocoInit[391] = true;
        } else {
            this.bottomNavigationActivity = (BottomNavigationActivity) activity;
            $jacocoInit[392] = true;
        }
        $jacocoInit[393] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        this.showingSearchResultsView = null;
        $jacocoInit[394] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[395] = true;
        inflater.inflate(C1375R.C1377menu.fragment_search_result, menu);
        $jacocoInit[396] = true;
        this.searchMenuItem = menu.findItem(C1375R.C1376id.menu_item_search);
        $jacocoInit[397] = true;
        this.searchView = (SearchView) this.searchMenuItem.getActionView();
        $jacocoInit[398] = true;
        this.searchView.setMaxWidth(MoPubClientPositioning.NO_REPEAT);
        SearchView searchView2 = this.searchView;
        $jacocoInit[399] = true;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) searchView2.findViewById(C1375R.C1376id.search_src_text);
        $jacocoInit[400] = true;
        boolean z = false;
        autoCompleteTextView.setThreshold(0);
        $jacocoInit[401] = true;
        C0629j.m2890a(this.searchMenuItem, (C0633d) new C0633d(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ SearchResultFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(4881145263337462707L, "cm/aptoide/pt/search/view/SearchResultFragment$1", 11);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0.enableUpNavigation();
                $jacocoInit[1] = true;
                SearchResultFragment.access$002(this.this$0, true);
                $jacocoInit[2] = true;
                return true;
            }

            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                boolean[] $jacocoInit = $jacocoInit();
                if (SearchResultFragment.access$100(this.this$0)) {
                    $jacocoInit[3] = true;
                    this.this$0.showResultsView();
                    $jacocoInit[4] = true;
                } else if (SearchResultFragment.access$200(this.this$0)) {
                    $jacocoInit[5] = true;
                    this.this$0.showNoResultsView();
                    $jacocoInit[6] = true;
                } else {
                    SearchResultFragment.access$300(this.this$0);
                    $jacocoInit[7] = true;
                }
                if (!this.this$0.shouldHideUpNavigation()) {
                    $jacocoInit[8] = true;
                } else {
                    this.this$0.disableUpNavigation();
                    $jacocoInit[9] = true;
                }
                SearchResultFragment.access$002(this.this$0, false);
                $jacocoInit[10] = true;
                return true;
            }
        });
        $jacocoInit[402] = true;
        if (!this.currentQuery.isEmpty()) {
            $jacocoInit[403] = true;
        } else if (this.noResults) {
            $jacocoInit[404] = true;
        } else {
            $jacocoInit[405] = true;
            z = true;
            this.focusInSearchBar = z;
            $jacocoInit[407] = true;
            this.searchSetupPublishSubject.onNext(null);
            $jacocoInit[408] = true;
        }
        $jacocoInit[406] = true;
        this.focusInSearchBar = z;
        $jacocoInit[407] = true;
        this.searchSetupPublishSubject.onNext(null);
        $jacocoInit[408] = true;
    }

    private DividerItemDecoration getDefaultItemDecoration() {
        boolean[] $jacocoInit = $jacocoInit();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), this.listItemPadding);
        $jacocoInit[409] = true;
        return dividerItemDecoration;
    }

    private LinearLayoutManager getDefaultLayoutManager() {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        $jacocoInit[410] = true;
        return linearLayoutManager;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.global_search_fragment, container, false);
        $jacocoInit[411] = true;
        return inflate;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[412] = true;
        outState.putParcelable(VIEW_MODEL, C14377B.m45944a(this.viewModel));
        $jacocoInit[413] = true;
        C0981i layoutManager = this.allStoresResultList.getLayoutManager();
        $jacocoInit[414] = true;
        Parcelable onSaveInstanceState = layoutManager.onSaveInstanceState();
        $jacocoInit[415] = true;
        outState.putParcelable(ALL_STORES_SEARCH_LIST_STATE, onSaveInstanceState);
        $jacocoInit[416] = true;
        outState.putString(UNSUBMITTED_QUERY, this.unsubmittedQuery);
        $jacocoInit[417] = true;
        if (!this.isSearchExpanded) {
            $jacocoInit[418] = true;
        } else {
            outState.putBoolean(FOCUS_IN_SEARCH, true);
            $jacocoInit[419] = true;
        }
        RecyclerView recyclerView = this.followedStoresResultList;
        $jacocoInit[420] = true;
        C0981i layoutManager2 = recyclerView.getLayoutManager();
        $jacocoInit[421] = true;
        Parcelable onSaveInstanceState2 = layoutManager2.onSaveInstanceState();
        $jacocoInit[422] = true;
        outState.putParcelable(FOLLOWED_STORES_SEARCH_LIST_STATE, onSaveInstanceState2);
        $jacocoInit[423] = true;
    }

    private void restoreViewState(Parcelable allStoresSearchListState, Parcelable followedStoresSearchListState, Parcelable trendingListState) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchViewModel searchViewModel = this.viewModel;
        $jacocoInit[424] = true;
        List<SearchAppResult> allStoresSearchAppResults = searchViewModel.getAllStoresSearchAppResults();
        $jacocoInit[425] = true;
        if (allStoresSearchAppResults.size() <= 0) {
            $jacocoInit[426] = true;
        } else {
            SearchResultAdapter searchResultAdapter = this.allStoresResultAdapter;
            SearchViewModel searchViewModel2 = this.viewModel;
            $jacocoInit[427] = true;
            List allStoresSearchAdResults = searchViewModel2.getAllStoresSearchAdResults();
            $jacocoInit[428] = true;
            searchResultAdapter.restoreState(allStoresSearchAppResults, allStoresSearchAdResults);
            $jacocoInit[429] = true;
            this.allStoresResultAdapter.notifyDataSetChanged();
            $jacocoInit[430] = true;
        }
        if (allStoresSearchListState == null) {
            $jacocoInit[431] = true;
        } else {
            $jacocoInit[432] = true;
            C0981i layoutManager = this.allStoresResultList.getLayoutManager();
            if (layoutManager != null) {
                $jacocoInit[433] = true;
            } else {
                $jacocoInit[434] = true;
                layoutManager = getDefaultLayoutManager();
                $jacocoInit[435] = true;
                this.allStoresResultList.setLayoutManager(layoutManager);
                $jacocoInit[436] = true;
            }
            layoutManager.onRestoreInstanceState(allStoresSearchListState);
            $jacocoInit[437] = true;
        }
        SearchViewModel searchViewModel3 = this.viewModel;
        $jacocoInit[438] = true;
        List<SearchAppResult> followedStoresSearchAppResults = searchViewModel3.getFollowedStoresSearchAppResults();
        $jacocoInit[439] = true;
        if (followedStoresSearchAppResults.size() <= 0) {
            $jacocoInit[440] = true;
        } else {
            SearchResultAdapter searchResultAdapter2 = this.followedStoresResultAdapter;
            SearchViewModel searchViewModel4 = this.viewModel;
            $jacocoInit[441] = true;
            List followedStoresSearchAdResults = searchViewModel4.getFollowedStoresSearchAdResults();
            $jacocoInit[442] = true;
            searchResultAdapter2.restoreState(followedStoresSearchAppResults, followedStoresSearchAdResults);
            $jacocoInit[443] = true;
            this.followedStoresResultAdapter.notifyDataSetChanged();
            $jacocoInit[444] = true;
        }
        if (followedStoresSearchListState == null) {
            $jacocoInit[445] = true;
        } else {
            $jacocoInit[446] = true;
            C0981i layoutManager2 = this.followedStoresResultList.getLayoutManager();
            if (layoutManager2 != null) {
                $jacocoInit[447] = true;
            } else {
                $jacocoInit[448] = true;
                layoutManager2 = getDefaultLayoutManager();
                $jacocoInit[449] = true;
                this.followedStoresResultList.setLayoutManager(layoutManager2);
                $jacocoInit[450] = true;
            }
            layoutManager2.onRestoreInstanceState(followedStoresSearchListState);
            $jacocoInit[451] = true;
        }
        showResultsView();
        $jacocoInit[452] = true;
        if (this.viewModel.isAllStoresSelected()) {
            $jacocoInit[453] = true;
            showAllStoresResult();
            $jacocoInit[454] = true;
        } else {
            showFollowedStoresResult();
            $jacocoInit[455] = true;
        }
        $jacocoInit[456] = true;
    }

    private void attachFollowedStoresResultListDependencies() {
        boolean[] $jacocoInit = $jacocoInit();
        this.followedStoresResultList.mo7527a((C0980h) getDefaultItemDecoration());
        $jacocoInit[457] = true;
        this.followedStoresResultList.setAdapter(this.followedStoresResultAdapter);
        $jacocoInit[458] = true;
        this.followedStoresResultList.setLayoutManager(getDefaultLayoutManager());
        $jacocoInit[459] = true;
    }

    private void attachAllStoresResultListDependencies() {
        boolean[] $jacocoInit = $jacocoInit();
        this.moPubRecyclerAdapter = new MoPubRecyclerAdapter(getActivity(), this.allStoresResultAdapter);
        $jacocoInit[460] = true;
        configureAdRenderers();
        $jacocoInit[461] = true;
        this.moPubRecyclerAdapter.setAdLoadedListener(new MoPubNativeAdsListener());
        if (VERSION.SDK_INT >= 21) {
            $jacocoInit[462] = true;
            this.allStoresResultList.setAdapter(this.moPubRecyclerAdapter);
            $jacocoInit[463] = true;
        } else {
            this.allStoresResultList.setAdapter(this.allStoresResultAdapter);
            $jacocoInit[464] = true;
        }
        this.allStoresResultList.setLayoutManager(getDefaultLayoutManager());
        $jacocoInit[465] = true;
        this.allStoresResultList.mo7527a((C0980h) getDefaultItemDecoration());
        $jacocoInit[466] = true;
    }

    public void configureAdRenderers() {
        boolean[] $jacocoInit = $jacocoInit();
        ViewBinder viewBinder = getMoPubViewBinder();
        $jacocoInit[467] = true;
        this.moPubRecyclerAdapter.registerAdRenderer(new MoPubStaticNativeAdRenderer(viewBinder));
        $jacocoInit[468] = true;
        this.moPubRecyclerAdapter.registerAdRenderer(new InMobiNativeAdRenderer(viewBinder));
        $jacocoInit[469] = true;
    }

    private ViewBinder getMoPubViewBinder() {
        boolean[] $jacocoInit = $jacocoInit();
        ViewBinder.Builder titleId = new ViewBinder.Builder(C1375R.layout.search_ad).titleId(C1375R.C1376id.app_name);
        $jacocoInit[470] = true;
        ViewBinder.Builder mainImageId = titleId.mainImageId(C1375R.C1376id.native_main_image);
        $jacocoInit[471] = true;
        ViewBinder.Builder addExtra = mainImageId.addExtra(InMobiNativeAdRenderer.VIEW_BINDER_KEY_PRIMARY_AD_VIEW_LAYOUT, C1375R.C1376id.primary_ad_view_layout);
        $jacocoInit[472] = true;
        ViewBinder.Builder iconImageId = addExtra.iconImageId(C1375R.C1376id.app_icon);
        $jacocoInit[473] = true;
        ViewBinder build = iconImageId.build();
        $jacocoInit[474] = true;
        return build;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setupToolbar() {
        /*
            r5 = this;
            boolean[] r0 = $jacocoInit()
            cm.aptoide.pt.search.model.SearchViewModel r1 = r5.viewModel
            java.lang.String r1 = r1.getCurrentQuery()
            r2 = 1
            r3 = 475(0x1db, float:6.66E-43)
            r0[r3] = r2
            boolean r1 = r1.isEmpty()
            r3 = 2131690365(0x7f0f037d, float:1.9009772E38)
            if (r1 != 0) goto L_0x001d
            r1 = 476(0x1dc, float:6.67E-43)
            r0[r1] = r2
            goto L_0x0025
        L_0x001d:
            boolean r1 = r5.noResults
            if (r1 == 0) goto L_0x0053
            r1 = 477(0x1dd, float:6.68E-43)
            r0[r1] = r2
        L_0x0025:
            cm.aptoide.pt.search.model.SearchViewModel r1 = r5.viewModel
            java.lang.String r1 = r1.getCurrentQuery()
            r4 = 481(0x1e1, float:6.74E-43)
            r0[r4] = r2
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0043
            r1 = 482(0x1e2, float:6.75E-43)
            r0[r1] = r2
            android.support.v7.widget.Toolbar r1 = r5.toolbar
            r1.setTitle(r3)
            r1 = 483(0x1e3, float:6.77E-43)
            r0[r1] = r2
            goto L_0x006b
        L_0x0043:
            android.support.v7.widget.Toolbar r1 = r5.toolbar
            cm.aptoide.pt.search.model.SearchViewModel r3 = r5.viewModel
            java.lang.String r3 = r3.getCurrentQuery()
            r1.setTitle(r3)
            r1 = 484(0x1e4, float:6.78E-43)
            r0[r1] = r2
            goto L_0x006b
        L_0x0053:
            r1 = 478(0x1de, float:6.7E-43)
            r0[r1] = r2
            android.support.v7.widget.Toolbar r1 = r5.toolbar
            r1.setTitle(r3)
            r1 = 479(0x1df, float:6.71E-43)
            r0[r1] = r2
            android.support.v7.widget.Toolbar r1 = r5.toolbar
            r3 = 100
            r1.setTitleMarginStart(r3)
            r1 = 480(0x1e0, float:6.73E-43)
            r0[r1] = r2
        L_0x006b:
            android.support.v4.app.p r1 = r5.getActivity()
            android.support.v7.app.n r1 = (android.support.p001v7.app.C0019n) r1
            r3 = 485(0x1e5, float:6.8E-43)
            r0[r3] = r2
            android.support.v7.widget.Toolbar r3 = r5.toolbar
            r1.setSupportActionBar(r3)
            r3 = 486(0x1e6, float:6.81E-43)
            r0[r3] = r2
            android.support.v7.app.a r3 = r1.getSupportActionBar()
            r5.actionBar = r3
            android.support.v7.app.a r3 = r5.actionBar
            if (r3 != 0) goto L_0x008d
            r3 = 487(0x1e7, float:6.82E-43)
            r0[r3] = r2
            goto L_0x00a7
        L_0x008d:
            r4 = 488(0x1e8, float:6.84E-43)
            r0[r4] = r2
            r3.mo6153d(r2)
            r3 = 489(0x1e9, float:6.85E-43)
            r0[r3] = r2
            android.support.v7.app.a r3 = r5.actionBar
            android.support.v7.widget.Toolbar r4 = r5.toolbar
            java.lang.CharSequence r4 = r4.getTitle()
            r3.mo6147a(r4)
            r3 = 490(0x1ea, float:6.87E-43)
            r0[r3] = r2
        L_0x00a7:
            r3 = 491(0x1eb, float:6.88E-43)
            r0[r3] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.search.view.SearchResultFragment.setupToolbar():void");
    }

    public void enableUpNavigation() {
        boolean[] $jacocoInit = $jacocoInit();
        C0760a aVar = this.actionBar;
        if (aVar == null) {
            $jacocoInit[492] = true;
        } else {
            $jacocoInit[493] = true;
            aVar.mo6156f(true);
            $jacocoInit[494] = true;
            this.actionBar.mo6153d(true);
            $jacocoInit[495] = true;
            this.actionBar.mo6154e(true);
            $jacocoInit[496] = true;
        }
        $jacocoInit[497] = true;
    }

    public C0120S<SearchQueryEvent> onQueryTextChanged() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<SearchQueryEvent> cVar = this.queryTextChangedPublisher;
        $jacocoInit[498] = true;
        return cVar;
    }

    public void collapseSearchBar(boolean shouldShowSuggestions) {
        boolean[] $jacocoInit = $jacocoInit();
        MenuItem menuItem = this.searchMenuItem;
        if (menuItem == null) {
            $jacocoInit[499] = true;
        } else {
            menuItem.collapseActionView();
            $jacocoInit[500] = true;
        }
        if (hasResults()) {
            $jacocoInit[501] = true;
        } else {
            $jacocoInit[502] = true;
            this.toolbar.setTitle((int) C1375R.string.search_hint_title);
            $jacocoInit[503] = true;
        }
        $jacocoInit[504] = true;
    }

    public String getCurrentQuery() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.currentQuery;
        if (str != null) {
            $jacocoInit[505] = true;
        } else {
            $jacocoInit[506] = true;
            str = "";
        }
        $jacocoInit[507] = true;
        return str;
    }

    public void focusInSearchBar() {
        boolean[] $jacocoInit = $jacocoInit();
        MenuItem menuItem = this.searchMenuItem;
        if (menuItem == null) {
            $jacocoInit[508] = true;
        } else {
            $jacocoInit[509] = true;
            menuItem.expandActionView();
            $jacocoInit[510] = true;
        }
        SearchView searchView2 = this.searchView;
        if (searchView2 == null) {
            $jacocoInit[511] = true;
        } else {
            String str = this.unsubmittedQuery;
            if (str == null) {
                $jacocoInit[512] = true;
            } else {
                $jacocoInit[513] = true;
                searchView2.setQuery(str, false);
                $jacocoInit[514] = true;
                showSuggestionsView();
                $jacocoInit[520] = true;
            }
        }
        if (this.searchView == null) {
            $jacocoInit[515] = true;
        } else if (getCurrentQuery().isEmpty()) {
            $jacocoInit[516] = true;
        } else {
            $jacocoInit[517] = true;
            String currentQuery2 = getCurrentQuery();
            $jacocoInit[518] = true;
            this.searchView.setQuery(currentQuery2, false);
            $jacocoInit[519] = true;
        }
        showSuggestionsView();
        $jacocoInit[520] = true;
    }

    public void setTrendingList(List<Suggestion> trending) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchTrendingAdapter.addSuggestions(trending);
        $jacocoInit[521] = true;
    }

    public void setSuggestionsList(List<String> suggestions) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchSuggestionsAdapter.addSuggestionsFromString(suggestions);
        $jacocoInit[522] = true;
    }

    public void setTrendingCursor(List<String> list) {
        $jacocoInit()[523] = true;
    }
}
