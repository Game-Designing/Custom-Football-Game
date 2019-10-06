package p005cm.aptoide.p006pt.search.view;

import android.view.MenuItem;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p002b.p003c.p053g.p061f.C1268l;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.AptoideBottomNavigator;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.search.SearchManager;
import p005cm.aptoide.p006pt.search.SearchNavigator;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.search.analytics.SearchSource;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.search.model.SearchAdResultWrapper;
import p005cm.aptoide.p006pt.search.model.SearchAppResult;
import p005cm.aptoide.p006pt.search.model.SearchAppResultWrapper;
import p005cm.aptoide.p006pt.search.model.SearchResultCount;
import p005cm.aptoide.p006pt.search.suggestions.SearchQueryEvent;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionManager;
import p005cm.aptoide.p006pt.search.suggestions.TrendingManager;
import p005cm.aptoide.p006pt.search.view.SearchResultView.Model;
import p019d.p022i.p296a.p298b.p303c.p304a.C13030k;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;

/* renamed from: cm.aptoide.pt.search.view.SearchResultPresenter */
public class SearchResultPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = SearchResultPresenter.class.getName();
    private final SearchAnalytics analytics;
    private final BottomNavigationMapper bottomNavigationMapper;
    private final AptoideBottomNavigator bottomNavigator;
    private final CrashReport crashReport;
    private final C0126V ioScheduler;
    private final SearchNavigator navigator;
    private final SearchManager searchManager;
    private final SearchSuggestionManager suggestionManager;
    private final TrendingManager trendingManager;
    private final SearchResultView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(55660824169838431L, "cm/aptoide/pt/search/view/SearchResultPresenter", 584);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[583] = true;
    }

    public SearchResultPresenter(SearchResultView view2, SearchAnalytics analytics2, SearchNavigator navigator2, CrashReport crashReport2, C0126V viewScheduler2, SearchManager searchManager2, TrendingManager trendingManager2, SearchSuggestionManager suggestionManager2, AptoideBottomNavigator bottomNavigator2, BottomNavigationMapper bottomNavigationMapper2, C0126V ioScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.analytics = analytics2;
        this.navigator = navigator2;
        this.crashReport = crashReport2;
        this.viewScheduler = viewScheduler2;
        this.searchManager = searchManager2;
        this.trendingManager = trendingManager2;
        this.suggestionManager = suggestionManager2;
        this.bottomNavigator = bottomNavigator2;
        this.bottomNavigationMapper = bottomNavigationMapper2;
        this.ioScheduler = ioScheduler2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        getTrendingOnStart();
        $jacocoInit[1] = true;
        handleToolbarClick();
        $jacocoInit[2] = true;
        handleSearchMenuItemClick();
        $jacocoInit[3] = true;
        focusInSearchBar();
        $jacocoInit[4] = true;
        handleSuggestionClicked();
        $jacocoInit[5] = true;
        stopLoadingMoreOnDestroy();
        $jacocoInit[6] = true;
        handleFragmentRestorationVisibility();
        $jacocoInit[7] = true;
        doFirstSearch();
        $jacocoInit[8] = true;
        firstAdsDataLoad();
        $jacocoInit[9] = true;
        handleClickFollowedStoresSearchButton();
        $jacocoInit[10] = true;
        handleClickEverywhereSearchButton();
        $jacocoInit[11] = true;
        handleClickToOpenAppViewFromItem();
        $jacocoInit[12] = true;
        handleClickToOpenAppViewFromAdd();
        $jacocoInit[13] = true;
        handleClickOnNoResultsImage();
        $jacocoInit[14] = true;
        handleAllStoresListReachedBottom();
        $jacocoInit[15] = true;
        handleFollowedStoresListReachedBottom();
        $jacocoInit[16] = true;
        handleQueryTextSubmitted();
        $jacocoInit[17] = true;
        handleQueryTextChanged();
        $jacocoInit[18] = true;
        handleQueryTextCleaned();
        $jacocoInit[19] = true;
        handleClickOnBottomNavWithResults();
        $jacocoInit[20] = true;
        handleClickOnBottomNavWithoutResults();
        $jacocoInit[21] = true;
        listenToSearchQueries();
        $jacocoInit[22] = true;
        loadBannerAd();
        $jacocoInit[23] = true;
    }

    private void loadBannerAd() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4682Ac ac = C4682Ac.f8314a;
        $jacocoInit[24] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ac);
        C4729Ma ma = new C4729Ma(this);
        $jacocoInit[25] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ma);
        C0126V v = this.ioScheduler;
        $jacocoInit[26] = true;
        C0120S a = f.mo3616a(v);
        C4885sc scVar = new C4885sc(this);
        $jacocoInit[27] = true;
        C0120S i = a.mo3668i(scVar);
        C4690Cb cb = C4690Cb.f8321a;
        $jacocoInit[28] = true;
        C0120S d2 = i.mo3653d((C0132p<? super T, Boolean>) cb);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[29] = true;
        C0120S a2 = d2.mo3616a(v2);
        C4823ha haVar = new C4823ha(this);
        $jacocoInit[30] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) haVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[31] = true;
        C0120S a3 = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4788aa aaVar = C4788aa.f8423a;
        C4702Fb fb = new C4702Fb(this);
        $jacocoInit[32] = true;
        a3.mo3626a((C0129b<? super T>) aaVar, (C0129b<Throwable>) fb);
        $jacocoInit[33] = true;
    }

    /* renamed from: Q */
    static /* synthetic */ Boolean m9053Q(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[582] = true;
        return valueOf;
    }

    /* renamed from: R */
    public /* synthetic */ C0120S mo16242R(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showingSearchResultsView = this.view.showingSearchResultsView();
        $jacocoInit[581] = true;
        return showingSearchResultsView;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo16246a(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadBannerAd = this.searchManager.shouldLoadBannerAd();
        $jacocoInit[580] = true;
        return shouldLoadBannerAd;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m9067b(Boolean loadBanner) {
        $jacocoInit()[579] = true;
        return loadBanner;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16266c(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showBannerAd();
        $jacocoInit[578] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m9082d(Boolean __) {
        $jacocoInit()[577] = true;
    }

    /* renamed from: v */
    public /* synthetic */ void mo16360v(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[576] = true;
    }

    public void handleFragmentRestorationVisibility() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4890tc tcVar = C4890tc.f8529a;
        $jacocoInit[34] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) tcVar);
        C4845kc kcVar = new C4845kc(this);
        $jacocoInit[35] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) kcVar);
        C4748Ra ra = new C4748Ra(this);
        $jacocoInit[36] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) ra);
        C4825hc hcVar = new C4825hc(this);
        $jacocoInit[37] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) hcVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[38] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4695Dc dc = C4695Dc.f8326a;
        C4799cb cbVar = new C4799cb(this);
        $jacocoInit[39] = true;
        a.mo3626a((C0129b<? super T>) dc, (C0129b<Throwable>) cbVar);
        $jacocoInit[40] = true;
    }

    /* renamed from: A */
    static /* synthetic */ Boolean m9045A(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[575] = true;
        return valueOf;
    }

    /* renamed from: B */
    public /* synthetic */ C0120S mo16233B(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S searchSetup = this.view.searchSetup();
        $jacocoInit[574] = true;
        return searchSetup;
    }

    /* renamed from: m */
    public /* synthetic */ Boolean mo16333m(Void __) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.view.shouldFocusInSearchBar()) {
            $jacocoInit[569] = true;
        } else if (!this.view.shouldShowSuggestions()) {
            $jacocoInit[570] = true;
        } else {
            $jacocoInit[571] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[573] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[572] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[573] = true;
        return valueOf2;
    }

    /* renamed from: k */
    public /* synthetic */ void mo16328k(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setVisibilityOnRestore();
        $jacocoInit[568] = true;
    }

    /* renamed from: l */
    static /* synthetic */ void m9100l(Void __) {
        $jacocoInit()[567] = true;
    }

    /* renamed from: n */
    public /* synthetic */ void mo16340n(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[566] = true;
    }

    public void getTrendingOnStart() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4794bb bbVar = C4794bb.f8429a;
        $jacocoInit[41] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bbVar);
        C4777Ya ya = new C4777Ya(this);
        $jacocoInit[42] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ya);
        C4709Ha ha = new C4709Ha(this);
        $jacocoInit[43] = true;
        C0120S i = f.mo3668i(ha);
        $jacocoInit[44] = true;
        C0120S g = i.mo3662g();
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[45] = true;
        C0120S a = g.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4803da daVar = C4803da.f8438a;
        C4688C c = new C4688C(this);
        $jacocoInit[46] = true;
        a.mo3626a((C0129b<? super T>) daVar, (C0129b<Throwable>) c);
        $jacocoInit[47] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m9086g(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[565] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo16299h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S searchSetup = this.view.searchSetup();
        $jacocoInit[564] = true;
        return searchSetup;
    }

    /* renamed from: d */
    public /* synthetic */ Single mo16273d(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single trendingListSuggestions = this.trendingManager.getTrendingListSuggestions();
        C0126V v = this.viewScheduler;
        $jacocoInit[560] = true;
        Single a = trendingListSuggestions.mo3686a(v);
        C4737Oa oa = new C4737Oa(this);
        $jacocoInit[561] = true;
        Single b = a.mo3695b((C0129b<? super T>) oa);
        $jacocoInit[562] = true;
        return b;
    }

    /* renamed from: p */
    public /* synthetic */ void mo16348p(List trending) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setTrendingList(trending);
        $jacocoInit[563] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9066a(List __) {
        $jacocoInit()[559] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo16276d(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[558] = true;
    }

    public void focusInSearchBar() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4770Wb wb = C4770Wb.f8405a;
        $jacocoInit[48] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) wb);
        C4858na naVar = new C4858na(this);
        $jacocoInit[49] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) naVar);
        $jacocoInit[50] = true;
        C0120S d2 = f.mo3647d();
        C4780Z z = new C4780Z(this);
        $jacocoInit[51] = true;
        C0120S d3 = d2.mo3653d((C0132p<? super T, Boolean>) z);
        C0126V v = this.viewScheduler;
        $jacocoInit[52] = true;
        C0120S a = d3.mo3616a(v);
        C4717Ja ja = new C4717Ja(this);
        $jacocoInit[53] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) ja);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[54] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4708H h = C4708H.f8340a;
        C4815fc fcVar = new C4815fc(this);
        $jacocoInit[55] = true;
        a2.mo3626a((C0129b<? super T>) h, (C0129b<Throwable>) fcVar);
        $jacocoInit[56] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m9083e(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[557] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo16286f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S searchSetup = this.view.searchSetup();
        $jacocoInit[556] = true;
        return searchSetup;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo16244a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.view.shouldFocusInSearchBar());
        $jacocoInit[555] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16263b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.focusInSearchBar();
        $jacocoInit[554] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9080c(Void __) {
        $jacocoInit()[553] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16269c(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[552] = true;
    }

    public void stopLoadingMoreOnDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4740P p = C4740P.f8373a;
        $jacocoInit[57] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) p);
        $jacocoInit[58] = true;
        C0120S d2 = d.mo3647d();
        $jacocoInit[59] = true;
        Single n = d2.mo3678n();
        C0126V v = this.viewScheduler;
        $jacocoInit[60] = true;
        Single a = n.mo3686a(v);
        C4900vc vcVar = new C4900vc(this);
        C4741Pa pa = new C4741Pa(this);
        $jacocoInit[61] = true;
        a.mo3690a((C0129b<? super T>) vcVar, (C0129b<Throwable>) pa);
        $jacocoInit[62] = true;
    }

    /* renamed from: S */
    static /* synthetic */ Boolean m9054S(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.DESTROY));
        $jacocoInit[551] = true;
        return valueOf;
    }

    /* renamed from: B */
    public /* synthetic */ void mo16234B(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[549] = true;
    }

    /* renamed from: T */
    public /* synthetic */ void mo16243T(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoadingMore();
        $jacocoInit[550] = true;
    }

    public void handleAllStoresListReachedBottom() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4813fa faVar = C4813fa.f8449a;
        $jacocoInit[63] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) faVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[64] = true;
        C0120S a = d.mo3616a(v);
        C4752Sa sa = new C4752Sa(this);
        $jacocoInit[65] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sa);
        C4701Fa fa = new C4701Fa(this);
        $jacocoInit[66] = true;
        C0120S j = f.mo3669j(fa);
        C4873qa qaVar = C4873qa.f8512a;
        $jacocoInit[67] = true;
        C0120S d2 = j.mo3653d((C0132p<? super T, Boolean>) qaVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[68] = true;
        C0120S a2 = d2.mo3616a(v2);
        C4722Kb kb = new C4722Kb(this);
        $jacocoInit[69] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) kb);
        C4819gb gbVar = new C4819gb(this);
        $jacocoInit[70] = true;
        C0120S i = b.mo3668i(gbVar);
        C0126V v3 = this.viewScheduler;
        $jacocoInit[71] = true;
        C0120S a3 = i.mo3616a(v3);
        C4818ga gaVar = new C4818ga(this);
        $jacocoInit[72] = true;
        C0120S b2 = a3.mo3636b((C0129b<? super T>) gaVar);
        C4893ua uaVar = C4893ua.f8532a;
        $jacocoInit[73] = true;
        C0120S d3 = b2.mo3653d((C0132p<? super T, Boolean>) uaVar);
        C4772X x = new C4772X(this);
        $jacocoInit[74] = true;
        C0120S b3 = d3.mo3636b((C0129b<? super T>) x);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[75] = true;
        C0120S a4 = b3.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4686Bb bb = C4686Bb.f8317a;
        C4754Sc sc = new C4754Sc(this);
        $jacocoInit[76] = true;
        a4.mo3626a((C0129b<? super T>) bb, (C0129b<Throwable>) sc);
        $jacocoInit[77] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m9091i(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[548] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo16323j(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S allStoresResultReachedBottom = this.view.allStoresResultReachedBottom();
        $jacocoInit[547] = true;
        return allStoresResultReachedBottom;
    }

    /* renamed from: e */
    public /* synthetic */ Model mo16279e(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Model viewModel = this.view.getViewModel();
        $jacocoInit[546] = true;
        return viewModel;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m9092i(Model viewModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!viewModel.hasReachedBottomOfAllStores()) {
            $jacocoInit[543] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[544] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[545] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ void mo16324j(Model __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoadingMore();
        $jacocoInit[542] = true;
    }

    /* renamed from: k */
    public /* synthetic */ Single mo16326k(Model viewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        String currentQuery = viewModel.getCurrentQuery();
        $jacocoInit[536] = true;
        boolean isOnlyTrustedApps = viewModel.isOnlyTrustedApps();
        int allStoresOffset = viewModel.getAllStoresOffset();
        $jacocoInit[537] = true;
        Single loadDataFromNonFollowedStores = loadDataFromNonFollowedStores(currentQuery, isOnlyTrustedApps, allStoresOffset);
        C4744Q q = new C4744Q(this);
        $jacocoInit[538] = true;
        Single e = loadDataFromNonFollowedStores.mo3699e(q);
        $jacocoInit[539] = true;
        return e;
    }

    /* renamed from: y */
    public /* synthetic */ Single mo16363y(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[540] = true;
        Single a = Single.m734a(null);
        $jacocoInit[541] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16264b(List __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoadingMore();
        $jacocoInit[535] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m9075c(List data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (data != null) {
            $jacocoInit[532] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[533] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[534] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ void mo16277d(List data) {
        boolean[] $jacocoInit = $jacocoInit();
        Model viewModel = this.view.getViewModel();
        $jacocoInit[530] = true;
        viewModel.incrementOffsetAndCheckIfReachedBottomOfFollowedStores(getItemCount(data));
        $jacocoInit[531] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m9084e(List __) {
        $jacocoInit()[529] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo16284e(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[528] = true;
    }

    private int getItemCount(List<SearchAppResult> data) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        if (data != null) {
            i = data.size();
            $jacocoInit[78] = true;
        } else {
            i = 0;
            $jacocoInit[79] = true;
        }
        $jacocoInit[80] = true;
        return i;
    }

    public void handleFollowedStoresListReachedBottom() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4912ya yaVar = C4912ya.f8551a;
        $jacocoInit[81] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) yaVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[82] = true;
        C0120S a = d.mo3616a(v);
        C4793ba baVar = new C4793ba(this);
        $jacocoInit[83] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) baVar);
        C4699Ec ec = new C4699Ec(this);
        $jacocoInit[84] = true;
        C0120S j = f.mo3669j(ec);
        C4917zb zbVar = C4917zb.f8556a;
        $jacocoInit[85] = true;
        C0120S d2 = j.mo3653d((C0132p<? super T, Boolean>) zbVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[86] = true;
        C0120S a2 = d2.mo3616a(v2);
        C4706Gb gb = new C4706Gb(this);
        $jacocoInit[87] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) gb);
        C4782Zb zb = new C4782Zb(this);
        $jacocoInit[88] = true;
        C0120S i = b.mo3668i(zb);
        C0126V v3 = this.viewScheduler;
        $jacocoInit[89] = true;
        C0120S a3 = i.mo3616a(v3);
        C4679A a4 = new C4679A(this);
        $jacocoInit[90] = true;
        C0120S b2 = a3.mo3636b((C0129b<? super T>) a4);
        C4899vb vbVar = C4899vb.f8538a;
        $jacocoInit[91] = true;
        C0120S d3 = b2.mo3653d((C0132p<? super T, Boolean>) vbVar);
        C4720K k = new C4720K(this);
        $jacocoInit[92] = true;
        C0120S b3 = d3.mo3636b((C0129b<? super T>) k);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[93] = true;
        C0120S a5 = b3.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4731Mc mc = C4731Mc.f8363a;
        C4874qb qbVar = new C4874qb(this);
        $jacocoInit[94] = true;
        a5.mo3626a((C0129b<? super T>) mc, (C0129b<Throwable>) qbVar);
        $jacocoInit[95] = true;
    }

    /* renamed from: y */
    static /* synthetic */ Boolean m9109y(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[527] = true;
        return valueOf;
    }

    /* renamed from: z */
    public /* synthetic */ C0120S mo16364z(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S followedStoresResultReachedBottom = this.view.followedStoresResultReachedBottom();
        $jacocoInit[526] = true;
        return followedStoresResultReachedBottom;
    }

    /* renamed from: j */
    public /* synthetic */ Model mo16322j(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Model viewModel = this.view.getViewModel();
        $jacocoInit[525] = true;
        return viewModel;
    }

    /* renamed from: l */
    static /* synthetic */ Boolean m9099l(Model viewModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!viewModel.hasReachedBottomOfFollowedStores()) {
            $jacocoInit[522] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[523] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[524] = true;
        return valueOf;
    }

    /* renamed from: m */
    public /* synthetic */ void mo16334m(Model __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoadingMore();
        $jacocoInit[521] = true;
    }

    /* renamed from: n */
    public /* synthetic */ Single mo16339n(Model viewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        String currentQuery = viewModel.getCurrentQuery();
        $jacocoInit[515] = true;
        boolean isOnlyTrustedApps = viewModel.isOnlyTrustedApps();
        int followedStoresOffset = viewModel.getFollowedStoresOffset();
        $jacocoInit[516] = true;
        Single loadDataFromFollowedStores = loadDataFromFollowedStores(currentQuery, isOnlyTrustedApps, followedStoresOffset);
        C4746Qb qb = new C4746Qb(this);
        $jacocoInit[517] = true;
        Single e = loadDataFromFollowedStores.mo3699e(qb);
        $jacocoInit[518] = true;
        return e;
    }

    /* renamed from: z */
    public /* synthetic */ Single mo16365z(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[519] = true;
        Single a = Single.m734a(null);
        $jacocoInit[520] = true;
        return a;
    }

    /* renamed from: f */
    public /* synthetic */ void mo16291f(List __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoadingMore();
        $jacocoInit[514] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m9088g(List data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (data != null) {
            $jacocoInit[511] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[512] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[513] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ void mo16303h(List data) {
        boolean[] $jacocoInit = $jacocoInit();
        Model viewModel = this.view.getViewModel();
        $jacocoInit[509] = true;
        viewModel.incrementOffsetAndCheckIfReachedBottomOfFollowedStores(getItemCount(data));
        $jacocoInit[510] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m9095i(List __) {
        $jacocoInit()[508] = true;
    }

    /* renamed from: m */
    public /* synthetic */ void mo16335m(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[507] = true;
    }

    public void firstAdsDataLoad() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4685Ba ba = C4685Ba.f8316a;
        $jacocoInit[96] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ba);
        C4809eb ebVar = new C4809eb(this);
        $jacocoInit[97] = true;
        C0120S j = d.mo3669j(ebVar);
        C4916za zaVar = new C4916za(this);
        $jacocoInit[98] = true;
        C0120S d2 = j.mo3653d((C0132p<? super T, Boolean>) zaVar);
        C4680Aa aa = C4680Aa.f8312a;
        $jacocoInit[99] = true;
        C0120S d3 = d2.mo3653d((C0132p<? super T, Boolean>) aa);
        C4843ka kaVar = new C4843ka(this);
        $jacocoInit[100] = true;
        C0120S f = d3.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) kaVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[101] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4757Ta ta = C4757Ta.f8391a;
        C4829ib ibVar = new C4829ib(this);
        $jacocoInit[102] = true;
        a.mo3626a((C0129b<? super T>) ta, (C0129b<Throwable>) ibVar);
        $jacocoInit[103] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m9074c(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[506] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ Model mo16270d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Model viewModel = this.view.getViewModel();
        $jacocoInit[505] = true;
        return viewModel;
    }

    /* renamed from: f */
    public /* synthetic */ Boolean mo16285f(Model viewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(hasValidQuery(viewModel));
        $jacocoInit[504] = true;
        return valueOf;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m9087g(Model viewModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!viewModel.hasLoadedAds()) {
            $jacocoInit[501] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[502] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[503] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo16300h(Model viewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S adsForQuery = this.searchManager.getAdsForQuery(viewModel.getCurrentQuery());
        C4865oc ocVar = new C4865oc(this);
        $jacocoInit[488] = true;
        C0120S l = adsForQuery.mo3674l(ocVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[489] = true;
        C0120S a = l.mo3616a(v);
        C4800cc ccVar = new C4800cc(viewModel);
        $jacocoInit[490] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) ccVar);
        C4732N n = new C4732N(this);
        $jacocoInit[491] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) n);
        $jacocoInit[492] = true;
        return b2;
    }

    /* renamed from: A */
    public /* synthetic */ SearchAdResult mo16232A(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[500] = true;
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m9064a(Model viewModel, SearchAdResult __) {
        boolean[] $jacocoInit = $jacocoInit();
        viewModel.setHasLoadedAds();
        $jacocoInit[499] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16259b(SearchAdResult ad) {
        boolean[] $jacocoInit = $jacocoInit();
        if (ad == null) {
            $jacocoInit[493] = true;
            this.view.setFollowedStoresAdsEmpty();
            $jacocoInit[494] = true;
            this.view.setAllStoresAdsEmpty();
            $jacocoInit[495] = true;
        } else {
            this.view.setAllStoresAdsResult(ad);
            $jacocoInit[496] = true;
            this.view.setFollowedStoresAdsResult(ad);
            $jacocoInit[497] = true;
        }
        $jacocoInit[498] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9063a(SearchAdResult __) {
        $jacocoInit()[487] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16262b(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[486] = true;
    }

    public boolean hasValidQuery(Model viewModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (viewModel.getCurrentQuery() == null) {
            $jacocoInit[104] = true;
        } else {
            String currentQuery = viewModel.getCurrentQuery();
            $jacocoInit[105] = true;
            if (currentQuery.isEmpty()) {
                $jacocoInit[106] = true;
            } else {
                $jacocoInit[107] = true;
                z = true;
                $jacocoInit[109] = true;
                return z;
            }
        }
        z = false;
        $jacocoInit[108] = true;
        $jacocoInit[109] = true;
        return z;
    }

    public void handleClickToOpenAppViewFromItem() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4820gc gcVar = C4820gc.f8456a;
        $jacocoInit[110] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) gcVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[111] = true;
        C0120S a = d.mo3616a(v);
        C4784_a _aVar = new C4784_a(this);
        $jacocoInit[112] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) _aVar);
        C4716J j = new C4716J(this);
        $jacocoInit[113] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) j);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[114] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4895uc ucVar = C4895uc.f8534a;
        C4918zc zcVar = new C4918zc(this);
        $jacocoInit[115] = true;
        a2.mo3626a((C0129b<? super T>) ucVar, (C0129b<Throwable>) zcVar);
        $jacocoInit[116] = true;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m9107w(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[485] = true;
        return valueOf;
    }

    /* renamed from: x */
    public /* synthetic */ C0120S mo16362x(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S onViewItemClicked = this.view.onViewItemClicked();
        $jacocoInit[484] = true;
        return onViewItemClicked;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16249a(SearchAppResultWrapper data) {
        boolean[] $jacocoInit = $jacocoInit();
        openAppView(data);
        $jacocoInit[483] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9070b(SearchAppResultWrapper __) {
        $jacocoInit()[482] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo16330l(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[481] = true;
    }

    public void handleClickToOpenAppViewFromAdd() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4696E e = C4696E.f8327a;
        $jacocoInit[117] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) e);
        C0126V v = this.viewScheduler;
        $jacocoInit[118] = true;
        C0120S a = d.mo3616a(v);
        C4880rc rcVar = new C4880rc(this);
        $jacocoInit[119] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rcVar);
        C4908xa xaVar = new C4908xa(this);
        $jacocoInit[120] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) xaVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[121] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4810ec ecVar = C4810ec.f8446a;
        C4713Ia ia = new C4713Ia(this);
        $jacocoInit[122] = true;
        a2.mo3626a((C0129b<? super T>) ecVar, (C0129b<Throwable>) ia);
        $jacocoInit[123] = true;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m9106u(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[480] = true;
        return valueOf;
    }

    /* renamed from: v */
    public /* synthetic */ C0120S mo16359v(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S onAdClicked = this.view.onAdClicked();
        $jacocoInit[479] = true;
        return onAdClicked;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16248a(SearchAdResultWrapper data) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAnalytics searchAnalytics = this.analytics;
        Model viewModel = this.view.getViewModel();
        $jacocoInit[474] = true;
        String currentQuery = viewModel.getCurrentQuery();
        SearchAdResult searchAdResult = data.getSearchAdResult();
        $jacocoInit[475] = true;
        String packageName = searchAdResult.getPackageName();
        int position = data.getPosition();
        $jacocoInit[476] = true;
        searchAnalytics.searchAdClick(currentQuery, packageName, position);
        $jacocoInit[477] = true;
        this.navigator.goToAppView(data.getSearchAdResult());
        $jacocoInit[478] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9069b(SearchAdResultWrapper __) {
        $jacocoInit()[473] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo16327k(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[472] = true;
    }

    public void handleClickOnNoResultsImage() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4687Bc bc = C4687Bc.f8318a;
        $jacocoInit[124] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bc);
        C0126V v = this.viewScheduler;
        $jacocoInit[125] = true;
        C0120S a = d.mo3616a(v);
        C4743Pc pc = new C4743Pc(this);
        $jacocoInit[126] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pc);
        C4705Ga ga = C4705Ga.f8336a;
        $jacocoInit[127] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) ga);
        C4828ia iaVar = new C4828ia(this);
        $jacocoInit[128] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) iaVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[129] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4878ra raVar = C4878ra.f8517a;
        C4790ac acVar = new C4790ac(this);
        $jacocoInit[130] = true;
        a2.mo3626a((C0129b<? super T>) raVar, (C0129b<Throwable>) acVar);
        $jacocoInit[131] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m9105s(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[471] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo16356t(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickNoResultsSearchButton = this.view.clickNoResultsSearchButton();
        $jacocoInit[470] = true;
        return clickNoResultsSearchButton;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9061a(String query) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (query.length() > 1) {
            $jacocoInit[467] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[468] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[469] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16260b(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.goToSearchFragment(query);
        $jacocoInit[466] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9079c(String __) {
        $jacocoInit()[465] = true;
    }

    /* renamed from: j */
    public /* synthetic */ void mo16325j(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[464] = true;
    }

    private void openAppView(SearchAppResultWrapper searchApp) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAppResult searchAppResult = searchApp.getSearchAppResult();
        $jacocoInit[132] = true;
        String packageName = searchAppResult.getPackageName();
        $jacocoInit[133] = true;
        SearchAppResult searchAppResult2 = searchApp.getSearchAppResult();
        $jacocoInit[134] = true;
        long appId = searchAppResult2.getAppId();
        $jacocoInit[135] = true;
        SearchAppResult searchAppResult3 = searchApp.getSearchAppResult();
        $jacocoInit[136] = true;
        String storeName = searchAppResult3.getStoreName();
        $jacocoInit[137] = true;
        SearchAnalytics searchAnalytics = this.analytics;
        Model viewModel = this.view.getViewModel();
        $jacocoInit[138] = true;
        String currentQuery = viewModel.getCurrentQuery();
        int position = searchApp.getPosition();
        $jacocoInit[139] = true;
        searchAnalytics.searchAppClick(currentQuery, packageName, position);
        $jacocoInit[140] = true;
        SearchNavigator searchNavigator = this.navigator;
        Model viewModel2 = this.view.getViewModel();
        $jacocoInit[141] = true;
        String storeTheme = viewModel2.getStoreTheme();
        $jacocoInit[142] = true;
        searchNavigator.goToAppView(appId, packageName, storeTheme, storeName);
        $jacocoInit[143] = true;
    }

    public void handleClickFollowedStoresSearchButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4884sb sbVar = C4884sb.f8523a;
        $jacocoInit[144] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) sbVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[145] = true;
        C0120S a = d.mo3616a(v);
        C4691Cc cc = new C4691Cc(this);
        $jacocoInit[146] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) cc);
        C4778Yb yb = new C4778Yb(this);
        $jacocoInit[147] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) yb);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[148] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4864ob obVar = C4864ob.f8502a;
        C4703Fc fc = new C4703Fc(this);
        $jacocoInit[149] = true;
        a2.mo3626a((C0129b<? super T>) obVar, (C0129b<Throwable>) fc);
        $jacocoInit[150] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m9101m(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[463] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo16337n(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickFollowedStoresSearchButton = this.view.clickFollowedStoresSearchButton();
        $jacocoInit[462] = true;
        return clickFollowedStoresSearchButton;
    }

    /* renamed from: h */
    public /* synthetic */ void mo16302h(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showFollowedStoresResult();
        $jacocoInit[461] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m9094i(Void __) {
        $jacocoInit()[460] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo16296g(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[459] = true;
    }

    public void handleClickEverywhereSearchButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4765Va va = C4765Va.f8399a;
        $jacocoInit[151] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) va);
        C0126V v = this.viewScheduler;
        $jacocoInit[152] = true;
        C0120S a = d.mo3616a(v);
        C4734Nb nb = new C4734Nb(this);
        $jacocoInit[153] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nb);
        C4781Za za = new C4781Za(this);
        $jacocoInit[154] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) za);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[155] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4776Y y = C4776Y.f8411a;
        C4681Ab ab = new C4681Ab(this);
        $jacocoInit[156] = true;
        a2.mo3626a((C0129b<? super T>) y, (C0129b<Throwable>) ab);
        $jacocoInit[157] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m9097k(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[458] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo16329l(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickEverywhereSearchButton = this.view.clickEverywhereSearchButton();
        $jacocoInit[457] = true;
        return clickEverywhereSearchButton;
    }

    /* renamed from: f */
    public /* synthetic */ void mo16290f(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showAllStoresResult();
        $jacocoInit[456] = true;
    }

    /* renamed from: g */
    static /* synthetic */ void m9089g(Void __) {
        $jacocoInit()[455] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo16289f(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[454] = true;
    }

    private Single<Integer> loadData(String query, String storeName, boolean onlyTrustedApps) {
        boolean[] $jacocoInit = $jacocoInit();
        if (storeName == null) {
            $jacocoInit[158] = true;
        } else {
            String trim = storeName.trim();
            $jacocoInit[159] = true;
            if (trim.equals("")) {
                $jacocoInit[160] = true;
            } else {
                $jacocoInit[161] = true;
                C0117M c = C0117M.m597c((C0128a) new C4733Na(this, storeName));
                $jacocoInit[162] = true;
                Single<Integer> a = c.mo3587a(loadDataForSpecificStore(query, storeName, 0).mo3698d(C4758Tb.f8392a));
                $jacocoInit[163] = true;
                return a;
            }
        }
        Single loadDataFromFollowedStores = loadDataFromFollowedStores(query, onlyTrustedApps, 0);
        $jacocoInit[164] = true;
        Single loadDataFromNonFollowedStores = loadDataFromNonFollowedStores(query, onlyTrustedApps, 0);
        C4736O o = new C4736O(this);
        $jacocoInit[165] = true;
        Single<Integer> a2 = Single.m740a(loadDataFromFollowedStores, loadDataFromNonFollowedStores, o);
        $jacocoInit[166] = true;
        return a2;
    }

    /* renamed from: f */
    public /* synthetic */ void mo16288f(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setViewWithStoreNameAsSingleTab(storeName);
        $jacocoInit[453] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Integer m9098k(List list) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        if (list != null) {
            i = list.size();
            $jacocoInit[450] = true;
        } else {
            i = 0;
            $jacocoInit[451] = true;
        }
        Integer valueOf = Integer.valueOf(i);
        $jacocoInit[452] = true;
        return valueOf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.lang.Integer mo16245a(java.util.List r6, java.util.List r7) {
        /*
            r5 = this;
            boolean[] r0 = $jacocoInit()
            r1 = 0
            r2 = 1
            r3 = 438(0x1b6, float:6.14E-43)
            r0[r3] = r2
            if (r6 != 0) goto L_0x0011
            r3 = 439(0x1b7, float:6.15E-43)
            r0[r3] = r2
            goto L_0x001b
        L_0x0011:
            int r3 = r6.size()
            if (r3 > 0) goto L_0x0025
            r3 = 440(0x1b8, float:6.17E-43)
            r0[r3] = r2
        L_0x001b:
            cm.aptoide.pt.search.view.SearchResultView r3 = r5.view
            r3.hideFollowedStoresTab()
            r3 = 443(0x1bb, float:6.21E-43)
            r0[r3] = r2
            goto L_0x0032
        L_0x0025:
            r3 = 441(0x1b9, float:6.18E-43)
            r0[r3] = r2
            int r3 = r6.size()
            int r1 = r1 + r3
            r3 = 442(0x1ba, float:6.2E-43)
            r0[r3] = r2
        L_0x0032:
            if (r7 != 0) goto L_0x0039
            r3 = 444(0x1bc, float:6.22E-43)
            r0[r3] = r2
            goto L_0x0043
        L_0x0039:
            int r3 = r7.size()
            if (r3 > 0) goto L_0x004d
            r3 = 445(0x1bd, float:6.24E-43)
            r0[r3] = r2
        L_0x0043:
            cm.aptoide.pt.search.view.SearchResultView r3 = r5.view
            r3.hideNonFollowedStoresTab()
            r3 = 448(0x1c0, float:6.28E-43)
            r0[r3] = r2
            goto L_0x005a
        L_0x004d:
            r3 = 446(0x1be, float:6.25E-43)
            r0[r3] = r2
            int r3 = r7.size()
            int r1 = r1 + r3
            r3 = 447(0x1bf, float:6.26E-43)
            r0[r3] = r2
        L_0x005a:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r4 = 449(0x1c1, float:6.29E-43)
            r0[r4] = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.search.view.SearchResultPresenter.mo16245a(java.util.List, java.util.List):java.lang.Integer");
    }

    private Single<List<SearchAppResult>> loadDataFromNonFollowedStores(String query, boolean onlyTrustedApps, int offset) {
        boolean[] $jacocoInit = $jacocoInit();
        Single searchInNonFollowedStores = this.searchManager.searchInNonFollowedStores(query, onlyTrustedApps, offset);
        C0126V v = this.viewScheduler;
        $jacocoInit[167] = true;
        Single a = searchInNonFollowedStores.mo3686a(v);
        C4769Wa wa = new C4769Wa(this, query);
        $jacocoInit[168] = true;
        Single b = a.mo3695b((C0129b<? super T>) wa);
        C4868pa paVar = new C4868pa(this);
        $jacocoInit[169] = true;
        Single b2 = b.mo3695b((C0129b<? super T>) paVar);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[170] = true;
        Single a2 = b2.mo3686a(v2);
        C4870pc pcVar = new C4870pc(this, query);
        $jacocoInit[171] = true;
        Single<List<SearchAppResult>> a3 = a2.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) pcVar);
        $jacocoInit[172] = true;
        return a3;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16268c(String query, List dataList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.addAllStoresResult(query, dataList);
        $jacocoInit[437] = true;
    }

    /* renamed from: n */
    public /* synthetic */ void mo16341n(List data) {
        boolean[] $jacocoInit = $jacocoInit();
        Model viewModel = this.view.getViewModel();
        $jacocoInit[435] = true;
        viewModel.incrementOffsetAndCheckIfReachedBottomOfAllStores(getItemCount(data));
        $jacocoInit[436] = true;
    }

    /* renamed from: d */
    public /* synthetic */ Single mo16272d(String query, List nonFollowedStoresSearchResult) {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadNativeAds = this.searchManager.shouldLoadNativeAds();
        C0126V v = this.viewScheduler;
        $jacocoInit[426] = true;
        Single a = shouldLoadNativeAds.mo3686a(v);
        C4742Pb pb = new C4742Pb(this, query);
        $jacocoInit[427] = true;
        Single b = a.mo3695b((C0129b<? super T>) pb);
        C4723Kc kc = new C4723Kc(nonFollowedStoresSearchResult);
        $jacocoInit[428] = true;
        Single d = b.mo3698d(kc);
        $jacocoInit[429] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16252a(String query, Boolean loadNativeAds) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!loadNativeAds.booleanValue()) {
            $jacocoInit[431] = true;
        } else {
            $jacocoInit[432] = true;
            this.view.showNativeAds(query);
            $jacocoInit[433] = true;
        }
        $jacocoInit[434] = true;
    }

    /* renamed from: a */
    static /* synthetic */ List m9062a(List nonFollowedStoresSearchResult, Boolean __) {
        $jacocoInit()[430] = true;
        return nonFollowedStoresSearchResult;
    }

    private Single<List<SearchAppResult>> loadDataFromFollowedStores(String query, boolean onlyTrustedApps, int offset) {
        boolean[] $jacocoInit = $jacocoInit();
        Single searchInFollowedStores = this.searchManager.searchInFollowedStores(query, onlyTrustedApps, offset);
        C0126V v = this.viewScheduler;
        $jacocoInit[173] = true;
        Single a = searchInFollowedStores.mo3686a(v);
        C4808ea eaVar = new C4808ea(this, query);
        $jacocoInit[174] = true;
        Single b = a.mo3695b((C0129b<? super T>) eaVar);
        C4824hb hbVar = new C4824hb(this);
        $jacocoInit[175] = true;
        Single<List<SearchAppResult>> b2 = b.mo3695b((C0129b<? super T>) hbVar);
        $jacocoInit[176] = true;
        return b2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16261b(String query, List dataList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.addFollowedStoresResult(query, dataList);
        $jacocoInit[425] = true;
    }

    /* renamed from: m */
    public /* synthetic */ void mo16336m(List data) {
        boolean[] $jacocoInit = $jacocoInit();
        Model viewModel = this.view.getViewModel();
        $jacocoInit[423] = true;
        viewModel.incrementOffsetAndCheckIfReachedBottomOfFollowedStores(getItemCount(data));
        $jacocoInit[424] = true;
    }

    private Single<List<SearchAppResult>> loadDataForSpecificStore(String query, String storeName, int offset) {
        boolean[] $jacocoInit = $jacocoInit();
        Single searchInStore = this.searchManager.searchInStore(query, storeName, offset);
        C0126V v = this.viewScheduler;
        $jacocoInit[177] = true;
        Single a = searchInStore.mo3686a(v);
        C4707Gc gc = new C4707Gc(this, query);
        $jacocoInit[178] = true;
        Single b = a.mo3695b((C0129b<? super T>) gc);
        C4725La la = new C4725La(this);
        $jacocoInit[179] = true;
        Single<List<SearchAppResult>> b2 = b.mo3695b((C0129b<? super T>) la);
        $jacocoInit[180] = true;
        return b2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16253a(String query, List dataList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.addFollowedStoresResult(query, dataList);
        $jacocoInit[422] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo16331l(List data) {
        boolean[] $jacocoInit = $jacocoInit();
        Model viewModel = this.view.getViewModel();
        $jacocoInit[419] = true;
        viewModel.setAllStoresSelected(false);
        $jacocoInit[420] = true;
        viewModel.incrementOffsetAndCheckIfReachedBottomOfFollowedStores(getItemCount(data));
        $jacocoInit[421] = true;
    }

    public void doFirstSearch() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4860nc ncVar = C4860nc.f8498a;
        $jacocoInit[181] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ncVar);
        C4698Eb eb = new C4698Eb(this);
        $jacocoInit[182] = true;
        C0120S j = d.mo3669j(eb);
        C4855mc mcVar = C4855mc.f8493a;
        $jacocoInit[183] = true;
        C0120S d2 = j.mo3653d((C0132p<? super T, Boolean>) mcVar);
        C4711Hc hc = new C4711Hc(this);
        $jacocoInit[184] = true;
        C0120S d3 = d2.mo3653d((C0132p<? super T, Boolean>) hc);
        C0126V v = this.viewScheduler;
        $jacocoInit[185] = true;
        C0120S a = d3.mo3616a(v);
        C4749Rb rb = new C4749Rb(this);
        $jacocoInit[186] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) rb);
        C4830ic icVar = new C4830ic(this);
        $jacocoInit[187] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) icVar);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[188] = true;
        C0120S a2 = b2.mo3616a(v2);
        C4766Vb vb = new C4766Vb(this);
        $jacocoInit[189] = true;
        C0120S i = a2.mo3668i(vb);
        C4910xc xcVar = C4910xc.f8549a;
        $jacocoInit[190] = true;
        C0120S d4 = i.mo3653d((C0132p<? super T, Boolean>) xcVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[191] = true;
        C0120S a3 = d4.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4739Oc oc = C4739Oc.f8372a;
        C4839jb jbVar = new C4839jb(this);
        $jacocoInit[192] = true;
        a3.mo3626a((C0129b<? super T>) oc, (C0129b<Throwable>) jbVar);
        $jacocoInit[193] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9057a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[418] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ Model mo16255b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Model viewModel = this.view.getViewModel();
        $jacocoInit[417] = true;
        return viewModel;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9060a(Model viewModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (viewModel.getAllStoresOffset() != 0) {
            $jacocoInit[411] = true;
        } else {
            $jacocoInit[412] = true;
            if (viewModel.getFollowedStoresOffset() != 0) {
                $jacocoInit[413] = true;
            } else {
                $jacocoInit[414] = true;
                z = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[416] = true;
                return valueOf;
            }
        }
        z = false;
        $jacocoInit[415] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[416] = true;
        return valueOf2;
    }

    /* renamed from: b */
    public /* synthetic */ Boolean mo16256b(Model viewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(hasValidQuery(viewModel));
        $jacocoInit[410] = true;
        return valueOf;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16265c(Model __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideSuggestionsViews();
        $jacocoInit[409] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo16274d(Model __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[408] = true;
    }

    /* renamed from: e */
    public /* synthetic */ Single mo16281e(Model viewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        String currentQuery = viewModel.getCurrentQuery();
        String storeName = viewModel.getStoreName();
        $jacocoInit[388] = true;
        boolean isOnlyTrustedApps = viewModel.isOnlyTrustedApps();
        $jacocoInit[389] = true;
        Single loadData = loadData(currentQuery, storeName, isOnlyTrustedApps);
        C4805dc dcVar = new C4805dc(this);
        $jacocoInit[390] = true;
        Single e = loadData.mo3699e(dcVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[391] = true;
        Single a = e.mo3686a(v);
        C4738Ob ob = new C4738Ob(this);
        $jacocoInit[392] = true;
        Single b = a.mo3695b((C0129b<? super T>) ob);
        C4745Qa qa = new C4745Qa(this, viewModel);
        $jacocoInit[393] = true;
        Single b2 = b.mo3695b((C0129b<? super T>) qa);
        $jacocoInit[394] = true;
        Single a2 = b2.mo3685a(Single.m734a(viewModel), (C14541q<? super T, ? super T2, ? extends R>) C4859nb.f8497a);
        $jacocoInit[395] = true;
        return a2;
    }

    /* renamed from: w */
    public /* synthetic */ Single mo16361w(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[406] = true;
        Single a = Single.m734a(Integer.valueOf(-1));
        $jacocoInit[407] = true;
        return a;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16267c(Integer __2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[405] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16250a(Model viewModel, Integer itemCount) {
        boolean[] $jacocoInit = $jacocoInit();
        if (itemCount.intValue() <= 0) {
            $jacocoInit[397] = true;
            this.view.showNoResultsView();
            $jacocoInit[398] = true;
            this.analytics.searchNoResults(viewModel.getCurrentQuery());
            $jacocoInit[399] = true;
        } else {
            this.view.showResultsView();
            $jacocoInit[400] = true;
            if (viewModel.isAllStoresSelected()) {
                $jacocoInit[401] = true;
                this.view.showAllStoresResult();
                $jacocoInit[402] = true;
            } else {
                this.view.showFollowedStoresResult();
                $jacocoInit[403] = true;
            }
        }
        $jacocoInit[404] = true;
    }

    /* renamed from: a */
    static /* synthetic */ SearchResultCount m9055a(Integer itemCount, Model model) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchResultCount searchResultCount = new SearchResultCount(itemCount.intValue(), model);
        $jacocoInit[396] = true;
        return searchResultCount;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9058a(SearchResultCount result) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getResultCount() != -1) {
            $jacocoInit[385] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[386] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[387] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ void m9071b(SearchResultCount __) {
        $jacocoInit()[384] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16254a(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[383] = true;
    }

    public void handleQueryTextCleaned() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4848la laVar = C4848la.f8486a;
        $jacocoInit[194] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) laVar);
        C4724L l = new C4724L(this);
        $jacocoInit[195] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) l);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[196] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4764V v = C4764V.f8398a;
        C4751S s = new C4751S(this);
        $jacocoInit[197] = true;
        a.mo3626a((C0129b<? super T>) v, (C0129b<Throwable>) s);
        $jacocoInit[198] = true;
    }

    /* renamed from: E */
    static /* synthetic */ Boolean m9047E(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[382] = true;
        return valueOf;
    }

    /* renamed from: F */
    public /* synthetic */ C0120S mo16236F(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getDebouncedQueryChanges().mo3653d((C0132p<? super T, Boolean>) new C4726Lb<Object,Boolean>(this));
        C0126V v = this.viewScheduler;
        $jacocoInit[372] = true;
        C0120S a = d.mo3616a(v);
        C4853ma maVar = new C4853ma(this);
        $jacocoInit[373] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) maVar);
        $jacocoInit[374] = true;
        return b;
    }

    /* renamed from: g */
    public /* synthetic */ Boolean mo16294g(SearchQueryEvent data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (data.hasQuery()) {
            $jacocoInit[377] = true;
        } else if (!this.view.isSearchViewExpanded()) {
            $jacocoInit[378] = true;
        } else {
            $jacocoInit[379] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[381] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[380] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[381] = true;
        return valueOf2;
    }

    /* renamed from: h */
    public /* synthetic */ void mo16301h(SearchQueryEvent data) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.clearUnsubmittedQuery();
        $jacocoInit[375] = true;
        this.view.toggleTrendingView();
        $jacocoInit[376] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9078c(SearchQueryEvent __) {
        $jacocoInit()[371] = true;
    }

    /* renamed from: p */
    public /* synthetic */ void mo16346p(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[370] = true;
    }

    public void handleQueryTextChanged() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4689Ca ca = C4689Ca.f8320a;
        $jacocoInit[199] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ca);
        C4909xb xbVar = new C4909xb(this);
        $jacocoInit[200] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xbVar);
        $jacocoInit[201] = true;
        C0120S d2 = f.mo3647d();
        C4905wc wcVar = new C4905wc(this);
        $jacocoInit[202] = true;
        C0120S f2 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wcVar);
        C4693Da da = C4693Da.f8324a;
        $jacocoInit[203] = true;
        C0120S d3 = f2.mo3653d((C0132p<? super T, Boolean>) da);
        C4894ub ubVar = C4894ub.f8533a;
        $jacocoInit[204] = true;
        C0120S j = d3.mo3669j(ubVar);
        C4768W w = new C4768W(this);
        $jacocoInit[205] = true;
        C0120S b = j.mo3636b((C0129b<? super T>) w);
        C4844kb kbVar = new C4844kb(this);
        $jacocoInit[206] = true;
        C0120S i = b.mo3668i(kbVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[207] = true;
        C0120S a = i.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4869pb pbVar = C4869pb.f8507a;
        C4760U u = new C4760U(this);
        $jacocoInit[208] = true;
        a.mo3626a((C0129b<? super T>) pbVar, (C0129b<Throwable>) u);
        $jacocoInit[209] = true;
    }

    /* renamed from: C */
    static /* synthetic */ Boolean m9046C(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[369] = true;
        return valueOf;
    }

    /* renamed from: D */
    public /* synthetic */ C0120S mo16235D(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S searchSetup = this.view.searchSetup();
        $jacocoInit[368] = true;
        return searchSetup;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo16338n(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S debouncedQueryChanges = getDebouncedQueryChanges();
        $jacocoInit[367] = true;
        return debouncedQueryChanges;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9059a(SearchQueryEvent data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!data.hasQuery()) {
            $jacocoInit[362] = true;
        } else if (data.isSubmitted()) {
            $jacocoInit[363] = true;
        } else {
            $jacocoInit[364] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[366] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[365] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[366] = true;
        return valueOf2;
    }

    /* renamed from: b */
    static /* synthetic */ String m9068b(SearchQueryEvent data) {
        boolean[] $jacocoInit = $jacocoInit();
        String query = data.getQuery();
        $jacocoInit[361] = true;
        return query;
    }

    /* renamed from: d */
    public /* synthetic */ void mo16275d(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setUnsubmittedQuery(query);
        $jacocoInit[360] = true;
    }

    /* renamed from: e */
    public /* synthetic */ Single mo16282e(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        Single suggestionsForApp = this.suggestionManager.getSuggestionsForApp(query);
        C4913yb ybVar = C4913yb.f8552a;
        $jacocoInit[349] = true;
        Single e = suggestionsForApp.mo3699e(ybVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[350] = true;
        Single a = e.mo3686a(v);
        C4814fb fbVar = new C4814fb(this);
        $jacocoInit[351] = true;
        Single b = a.mo3695b((C0129b<? super T>) fbVar);
        $jacocoInit[352] = true;
        return b;
    }

    /* renamed from: x */
    static /* synthetic */ Single m9108x(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!(err instanceof TimeoutException)) {
            $jacocoInit[355] = true;
        } else {
            $jacocoInit[356] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[357] = true;
            instance.mo2145i(str, "Timeout reached while waiting for application suggestions");
            $jacocoInit[358] = true;
        }
        Single a = Single.m735a(err);
        $jacocoInit[359] = true;
        return a;
    }

    /* renamed from: o */
    public /* synthetic */ void mo16344o(List queryResults) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setSuggestionsList(queryResults);
        $jacocoInit[353] = true;
        this.view.toggleSuggestionsView();
        $jacocoInit[354] = true;
    }

    /* renamed from: j */
    static /* synthetic */ void m9096j(List __) {
        $jacocoInit()[348] = true;
    }

    /* renamed from: o */
    public /* synthetic */ void mo16343o(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[347] = true;
    }

    public void handleQueryTextSubmitted() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4728M m = C4728M.f8360a;
        $jacocoInit[210] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) m);
        C4753Sb sb = new C4753Sb(this);
        $jacocoInit[211] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sb);
        $jacocoInit[212] = true;
        C0120S d2 = f.mo3647d();
        C4747Qc qc = new C4747Qc(this);
        $jacocoInit[213] = true;
        C0120S f2 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qc);
        C4712I i = C4712I.f8344a;
        $jacocoInit[214] = true;
        C0120S d3 = f2.mo3653d((C0132p<? super T, Boolean>) i);
        C0126V v = this.viewScheduler;
        $jacocoInit[215] = true;
        C0120S a = d3.mo3616a(v);
        C4903wa waVar = new C4903wa(this);
        $jacocoInit[216] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) waVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[217] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4898va vaVar = C4898va.f8537a;
        C4795bc bcVar = new C4795bc(this);
        $jacocoInit[218] = true;
        a2.mo3626a((C0129b<? super T>) vaVar, (C0129b<Throwable>) bcVar);
        $jacocoInit[219] = true;
    }

    /* renamed from: G */
    static /* synthetic */ Boolean m9048G(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[346] = true;
        return valueOf;
    }

    /* renamed from: H */
    public /* synthetic */ C0120S mo16237H(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S searchSetup = this.view.searchSetup();
        $jacocoInit[345] = true;
        return searchSetup;
    }

    /* renamed from: o */
    public /* synthetic */ C0120S mo16342o(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S debouncedQueryChanges = getDebouncedQueryChanges();
        $jacocoInit[344] = true;
        return debouncedQueryChanges;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m9081d(SearchQueryEvent data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!data.hasQuery()) {
            $jacocoInit[339] = true;
        } else if (!data.isSubmitted()) {
            $jacocoInit[340] = true;
        } else {
            $jacocoInit[341] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[343] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[342] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[343] = true;
        return valueOf2;
    }

    /* renamed from: e */
    public /* synthetic */ void mo16283e(SearchQueryEvent data) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.collapseSearchBar(false);
        $jacocoInit[335] = true;
        this.view.hideSuggestionsViews();
        $jacocoInit[336] = true;
        this.analytics.search(data.getQuery());
        $jacocoInit[337] = true;
        this.navigator.navigate(data.getQuery());
        $jacocoInit[338] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m9085f(SearchQueryEvent __) {
        $jacocoInit()[334] = true;
    }

    /* renamed from: q */
    public /* synthetic */ void mo16349q(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[333] = true;
    }

    public void handleSuggestionClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4879rb rbVar = C4879rb.f8518a;
        $jacocoInit[220] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) rbVar);
        C4762Ub ub = new C4762Ub(this);
        $jacocoInit[221] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ub);
        C4904wb wbVar = C4904wb.f8543a;
        $jacocoInit[222] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) wbVar);
        C4850lc lcVar = new C4850lc(this);
        $jacocoInit[223] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) lcVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[224] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4863oa oaVar = C4863oa.f8501a;
        C4715Ic ic = new C4715Ic(this);
        $jacocoInit[225] = true;
        a.mo3626a((C0129b<? super T>) oaVar, (C0129b<Throwable>) ic);
        $jacocoInit[226] = true;
    }

    /* renamed from: K */
    static /* synthetic */ Boolean m9050K(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[332] = true;
        return valueOf;
    }

    /* renamed from: L */
    public /* synthetic */ C0120S mo16239L(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S listenToSuggestionClick = this.view.listenToSuggestionClick();
        $jacocoInit[331] = true;
        return listenToSuggestionClick;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9056a(C1268l data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!((SearchQueryEvent) data.f4070b).hasQuery()) {
            $jacocoInit[326] = true;
        } else if (!((SearchQueryEvent) data.f4070b).isSubmitted()) {
            $jacocoInit[327] = true;
        } else {
            $jacocoInit[328] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[330] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[329] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[330] = true;
        return valueOf2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16258b(C1268l data) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.collapseSearchBar(false);
        $jacocoInit[322] = true;
        this.view.hideSuggestionsViews();
        $jacocoInit[323] = true;
        this.navigator.navigate(((SearchQueryEvent) data.f4070b).getQuery());
        $jacocoInit[324] = true;
        this.analytics.searchFromSuggestion(((SearchQueryEvent) data.f4070b).getQuery(), ((SearchQueryEvent) data.f4070b).getPosition(), (String) data.f4069a);
        $jacocoInit[325] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9077c(C1268l __) {
        $jacocoInit()[321] = true;
    }

    /* renamed from: s */
    public /* synthetic */ void mo16354s(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[320] = true;
    }

    public void handleToolbarClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4840jc jcVar = C4840jc.f8478a;
        $jacocoInit[227] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jcVar);
        C4704G g = new C4704G(this);
        $jacocoInit[228] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) g);
        C4774Xb xb = new C4774Xb(this);
        $jacocoInit[229] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) xb);
        C4914yc ycVar = new C4914yc(this);
        $jacocoInit[230] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) ycVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[231] = true;
        C0120S a = b2.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4710Hb hb = C4710Hb.f8342a;
        C4761Ua ua = new C4761Ua(this);
        $jacocoInit[232] = true;
        a.mo3626a((C0129b<? super T>) hb, (C0129b<Throwable>) ua);
        $jacocoInit[233] = true;
    }

    /* renamed from: M */
    static /* synthetic */ Boolean m9051M(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[317] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[318] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[319] = true;
        return valueOf;
    }

    /* renamed from: N */
    public /* synthetic */ C0120S mo16240N(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.view.toolbarClick();
        $jacocoInit[316] = true;
        return s;
    }

    /* renamed from: p */
    public /* synthetic */ void mo16347p(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.view.shouldFocusInSearchBar()) {
            $jacocoInit[312] = true;
        } else {
            $jacocoInit[313] = true;
            this.analytics.searchStart(SearchSource.SEARCH_TOOLBAR, true);
            $jacocoInit[314] = true;
        }
        $jacocoInit[315] = true;
    }

    /* renamed from: q */
    public /* synthetic */ void mo16350q(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.focusInSearchBar();
        $jacocoInit[311] = true;
    }

    /* renamed from: r */
    static /* synthetic */ void m9104r(Void __) {
        $jacocoInit()[310] = true;
    }

    /* renamed from: t */
    public /* synthetic */ void mo16357t(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[309] = true;
    }

    public void handleSearchMenuItemClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4756T t = C4756T.f8390a;
        $jacocoInit[234] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) t);
        C4889tb tbVar = new C4889tb(this);
        $jacocoInit[235] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) tbVar);
        C4719Jc jc = new C4719Jc(this);
        $jacocoInit[236] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) jc);
        C4750Rc rc = new C4750Rc(this);
        $jacocoInit[237] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) rc);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.PAUSE;
        $jacocoInit[238] = true;
        C0120S a = b2.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4804db dbVar = C4804db.f8439a;
        C4849lb lbVar = new C4849lb(this);
        $jacocoInit[239] = true;
        a.mo3626a((C0129b<? super T>) dbVar, (C0129b<Throwable>) lbVar);
        $jacocoInit[240] = true;
    }

    /* renamed from: I */
    static /* synthetic */ Boolean m9049I(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.RESUME) {
            $jacocoInit[306] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[307] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[308] = true;
        return valueOf;
    }

    /* renamed from: J */
    public /* synthetic */ C0120S mo16238J(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S searchMenuItemClick = this.view.searchMenuItemClick();
        $jacocoInit[305] = true;
        return searchMenuItemClick;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16247a(MenuItem __) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.view.shouldFocusInSearchBar()) {
            $jacocoInit[302] = true;
        } else {
            this.analytics.searchStart(SearchSource.SEARCH_ICON, true);
            $jacocoInit[303] = true;
        }
        $jacocoInit[304] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16257b(MenuItem __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.focusInSearchBar();
        $jacocoInit[301] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9076c(MenuItem __) {
        $jacocoInit()[300] = true;
    }

    /* renamed from: r */
    public /* synthetic */ void mo16352r(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[299] = true;
    }

    public void handleClickOnBottomNavWithResults() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4730Mb mb = C4730Mb.f8362a;
        $jacocoInit[241] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) mb);
        C4883sa saVar = new C4883sa(this);
        $jacocoInit[242] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) saVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[243] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4773Xa xa = C4773Xa.f8408a;
        C4700F f2 = C4700F.f8331a;
        $jacocoInit[244] = true;
        a.mo3626a((C0129b<? super T>) xa, (C0129b<Throwable>) f2);
        $jacocoInit[245] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m9102o(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[298] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo16345p(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigationEvent = this.bottomNavigator.navigationEvent();
        C4875qc qcVar = new C4875qc(this);
        $jacocoInit[287] = true;
        C0120S d = navigationEvent.mo3653d((C0132p<? super T, Boolean>) qcVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[288] = true;
        C0120S a = d.mo3616a(v);
        C4697Ea ea = new C4697Ea(this);
        $jacocoInit[289] = true;
        C0120S d2 = a.mo3653d((C0132p<? super T, Boolean>) ea);
        C4694Db db = new C4694Db(this);
        $jacocoInit[290] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) db);
        $jacocoInit[291] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[292] = true;
        return g;
    }

    /* renamed from: d */
    public /* synthetic */ Boolean mo16271d(Integer navigationEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationItem mapItemClicked = this.bottomNavigationMapper.mapItemClicked(navigationEvent);
        BottomNavigationItem bottomNavigationItem = BottomNavigationItem.SEARCH;
        $jacocoInit[295] = true;
        boolean equals = mapItemClicked.equals(bottomNavigationItem);
        $jacocoInit[296] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[297] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ Boolean mo16280e(Integer navigated) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.view.hasResults());
        $jacocoInit[294] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ void mo16287f(Integer __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.scrollToTop();
        $jacocoInit[293] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9065a(Integer __) {
        $jacocoInit()[286] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m9090h(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[285] = true;
        throw onErrorNotImplementedException;
    }

    public void handleClickOnBottomNavWithoutResults() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4838ja jaVar = C4838ja.f8476a;
        $jacocoInit[246] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jaVar);
        C4785_b _bVar = new C4785_b(this);
        $jacocoInit[247] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) _bVar);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[248] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4735Nc nc = C4735Nc.f8368a;
        C4798ca caVar = C4798ca.f8433a;
        $jacocoInit[249] = true;
        a.mo3626a((C0129b<? super T>) nc, (C0129b<Throwable>) caVar);
        $jacocoInit[250] = true;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m9103q(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[284] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo16351r(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigationEvent = this.bottomNavigator.navigationEvent();
        C4854mb mbVar = new C4854mb(this);
        $jacocoInit[271] = true;
        C0120S d = navigationEvent.mo3653d((C0132p<? super T, Boolean>) mbVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[272] = true;
        C0120S a = d.mo3616a(v);
        C4888ta taVar = new C4888ta(this);
        $jacocoInit[273] = true;
        C0120S d2 = a.mo3653d((C0132p<? super T, Boolean>) taVar);
        C4684B b = new C4684B(this);
        $jacocoInit[274] = true;
        C0120S b2 = d2.mo3636b((C0129b<? super T>) b);
        $jacocoInit[275] = true;
        C0120S g = b2.mo3662g();
        $jacocoInit[276] = true;
        return g;
    }

    /* renamed from: g */
    public /* synthetic */ Boolean mo16295g(Integer navigationEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationItem mapItemClicked = this.bottomNavigationMapper.mapItemClicked(navigationEvent);
        BottomNavigationItem bottomNavigationItem = BottomNavigationItem.SEARCH;
        $jacocoInit[281] = true;
        boolean equals = mapItemClicked.equals(bottomNavigationItem);
        $jacocoInit[282] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[283] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ Boolean mo16298h(Integer navigated) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.view.hasResults()) {
            $jacocoInit[278] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[279] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[280] = true;
        return valueOf;
    }

    /* renamed from: i */
    public /* synthetic */ void mo16321i(Integer __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.focusInSearchBar();
        $jacocoInit[277] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9073b(Integer __) {
        $jacocoInit()[270] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m9093i(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[269] = true;
        throw onErrorNotImplementedException;
    }

    public void listenToSearchQueries() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4727Lc lc = C4727Lc.f8359a;
        $jacocoInit[251] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) lc);
        C4714Ib ib = new C4714Ib(this);
        $jacocoInit[252] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ib);
        $jacocoInit[253] = true;
        C0120S d2 = f.mo3647d();
        C4692D d3 = new C4692D(this);
        $jacocoInit[254] = true;
        C0120S f2 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) d3);
        C4718Jb jb = new C4718Jb(this);
        $jacocoInit[255] = true;
        C0120S b = f2.mo3636b((C0129b<? super T>) jb);
        SearchResultView searchResultView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[256] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) searchResultView.bindUntilEvent(lifecycleEvent2));
        C4721Ka ka = C4721Ka.f8353a;
        C4789ab abVar = new C4789ab(this);
        $jacocoInit[257] = true;
        a.mo3626a((C0129b<? super T>) ka, (C0129b<Throwable>) abVar);
        $jacocoInit[258] = true;
    }

    /* renamed from: O */
    static /* synthetic */ Boolean m9052O(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.RESUME) {
            $jacocoInit[266] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[267] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[268] = true;
        return valueOf;
    }

    /* renamed from: P */
    public /* synthetic */ C0120S mo16241P(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S searchSetup = this.view.searchSetup();
        $jacocoInit[265] = true;
        return searchSetup;
    }

    /* renamed from: s */
    public /* synthetic */ C0120S mo16353s(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S queryChanged = this.view.queryChanged();
        $jacocoInit[264] = true;
        return queryChanged;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16251a(C13030k event) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.queryEvent(event);
        $jacocoInit[263] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9072b(C13030k __) {
        $jacocoInit()[262] = true;
    }

    /* renamed from: u */
    public /* synthetic */ void mo16358u(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[261] = true;
    }

    private C0120S<SearchQueryEvent> getDebouncedQueryChanges() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S onQueryTextChanged = this.view.onQueryTextChanged();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[259] = true;
        C0120S<SearchQueryEvent> a = onQueryTextChanged.mo3607a(250, timeUnit);
        $jacocoInit[260] = true;
        return a;
    }
}
