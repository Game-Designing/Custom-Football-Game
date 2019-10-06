package p005cm.aptoide.p006pt.search.view;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.search.SearchNavigator;
import p005cm.aptoide.p006pt.search.SuggestionCursorAdapter;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.search.suggestions.SearchQueryEvent;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionManager;
import p005cm.aptoide.p006pt.search.suggestions.TrendingManager;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.search.view.SearchSuggestionsPresenter */
public class SearchSuggestionsPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = SearchSuggestionsPresenter.class.getName();
    private final CrashReport crashReport;
    private final SearchNavigator navigator;
    private final SearchAnalytics searchAnalytics;
    private final SearchSuggestionManager searchSuggestionManager;
    private boolean showSuggestionsOnFirstLoadWithEmptyQuery;
    private final SuggestionCursorAdapter suggestionCursorAdapter;
    private final TrendingManager trendingManager;
    private final SearchSuggestionsView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8410261116792936557L, "cm/aptoide/pt/search/view/SearchSuggestionsPresenter", 115);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[114] = true;
    }

    public SearchSuggestionsPresenter(SearchSuggestionsView view2, SearchSuggestionManager searchSuggestionManager2, C0126V viewScheduler2, SuggestionCursorAdapter suggestionCursorAdapter2, CrashReport crashReport2, TrendingManager trendingManager2, SearchNavigator navigator2, boolean showSuggestionsOnFirstLoadWithEmptyQuery2, SearchAnalytics searchAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.searchSuggestionManager = searchSuggestionManager2;
        this.viewScheduler = viewScheduler2;
        this.suggestionCursorAdapter = suggestionCursorAdapter2;
        this.crashReport = crashReport2;
        this.trendingManager = trendingManager2;
        this.navigator = navigator2;
        this.showSuggestionsOnFirstLoadWithEmptyQuery = showSuggestionsOnFirstLoadWithEmptyQuery2;
        this.searchAnalytics = searchAnalytics2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handleQueryTextSubmitted();
        $jacocoInit[1] = true;
        handleQueryTextCleaned();
        $jacocoInit[2] = true;
        handleQueryTextChanged();
        if (!this.showSuggestionsOnFirstLoadWithEmptyQuery) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            showSuggestionsIfCurrentQueryIsEmpty();
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
    }

    private void handleQueryTextSubmitted() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4886sd sdVar = C4886sd.f8525a;
        $jacocoInit[7] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) sdVar);
        C4759Tc tc = new C4759Tc(this);
        $jacocoInit[8] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) tc);
        C0126V v = this.viewScheduler;
        $jacocoInit[9] = true;
        C0120S a = f.mo3616a(v);
        C4891td tdVar = new C4891td(this);
        $jacocoInit[10] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) tdVar);
        SearchSuggestionsView searchSuggestionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[11] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) searchSuggestionsView.bindUntilEvent(lifecycleEvent2));
        C4801cd cdVar = C4801cd.f8436a;
        C4811ed edVar = new C4811ed(this);
        $jacocoInit[12] = true;
        a2.mo3626a((C0129b<? super T>) cdVar, (C0129b<Throwable>) edVar);
        $jacocoInit[13] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m9228e(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[113] = true;
        return valueOf;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m9225c(SearchQueryEvent data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!data.hasQuery()) {
            $jacocoInit[108] = true;
        } else if (!data.isSubmitted()) {
            $jacocoInit[109] = true;
        } else {
            $jacocoInit[110] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[112] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[111] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[112] = true;
        return valueOf2;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo16381f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getDebouncedQueryChanges().mo3653d((C0132p<? super T, Boolean>) C4901vd.f8540a);
        $jacocoInit[107] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16371a(SearchQueryEvent data) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.collapseSearchBar(true);
        $jacocoInit[101] = true;
        this.navigator.navigate(data.getQuery());
        $jacocoInit[102] = true;
        if (data.isSuggestion()) {
            $jacocoInit[103] = true;
            this.searchAnalytics.searchFromSuggestion(data.getQuery(), data.getPosition(), "");
            $jacocoInit[104] = true;
        } else {
            this.searchAnalytics.search(data.getQuery());
            $jacocoInit[105] = true;
        }
        $jacocoInit[106] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9223b(SearchQueryEvent __) {
        $jacocoInit()[100] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16376c(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[99] = true;
    }

    private C0120S<SearchQueryEvent> getDebouncedQueryChanges() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S onQueryTextChanged = this.view.onQueryTextChanged();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[14] = true;
        C0120S<SearchQueryEvent> a = onQueryTextChanged.mo3607a(250, timeUnit);
        $jacocoInit[15] = true;
        return a;
    }

    private void handleQueryTextCleaned() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4796bd bdVar = C4796bd.f8431a;
        $jacocoInit[16] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bdVar);
        C4841jd jdVar = new C4841jd(this);
        $jacocoInit[17] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jdVar);
        SearchSuggestionsView searchSuggestionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[18] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) searchSuggestionsView.bindUntilEvent(lifecycleEvent2));
        C4821gd gdVar = C4821gd.f8457a;
        C4767Vc vc = new C4767Vc(this);
        $jacocoInit[19] = true;
        a.mo3626a((C0129b<? super T>) gdVar, (C0129b<Throwable>) vc);
        $jacocoInit[20] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m9226d(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[98] = true;
        return valueOf;
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m9231f(SearchQueryEvent data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!data.hasQuery()) {
            $jacocoInit[95] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[96] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[97] = true;
        return valueOf;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo16375c(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getDebouncedQueryChanges().mo3653d((C0132p<? super T, Boolean>) C4786_c.f8421a);
        C4783Zc zc = new C4783Zc(this);
        $jacocoInit[88] = true;
        C0120S i = d.mo3668i(zc);
        $jacocoInit[89] = true;
        C0120S g = i.mo3662g();
        $jacocoInit[90] = true;
        return g;
    }

    /* renamed from: g */
    public /* synthetic */ Single mo16383g(SearchQueryEvent data) {
        boolean[] $jacocoInit = $jacocoInit();
        Single trendingCursorSuggestions = this.trendingManager.getTrendingCursorSuggestions();
        C0126V v = this.viewScheduler;
        $jacocoInit[91] = true;
        Single a = trendingCursorSuggestions.mo3686a(v);
        C4876qd qdVar = new C4876qd(this);
        $jacocoInit[92] = true;
        Single b = a.mo3695b((C0129b<? super T>) qdVar);
        $jacocoInit[93] = true;
        return b;
    }

    /* renamed from: d */
    public /* synthetic */ void mo16379d(List trendingList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setTrendingCursor(trendingList);
        $jacocoInit[94] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9224b(List __) {
        $jacocoInit()[87] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16374b(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[86] = true;
    }

    private void handleQueryTextChanged() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4771Wc wc = C4771Wc.f8406a;
        $jacocoInit[21] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) wc);
        C4791ad adVar = new C4791ad(this);
        $jacocoInit[22] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) adVar);
        SearchSuggestionsView searchSuggestionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[23] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) searchSuggestionsView.bindUntilEvent(lifecycleEvent2));
        C4866od odVar = C4866od.f8504a;
        C4831id idVar = new C4831id(this);
        $jacocoInit[24] = true;
        a.mo3626a((C0129b<? super T>) odVar, (C0129b<Throwable>) idVar);
        $jacocoInit[25] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9221a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[85] = true;
        return valueOf;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m9227d(SearchQueryEvent data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!data.hasQuery()) {
            $jacocoInit[80] = true;
        } else if (data.isSubmitted()) {
            $jacocoInit[81] = true;
        } else {
            $jacocoInit[82] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[84] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[83] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[84] = true;
        return valueOf2;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo16373b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getDebouncedQueryChanges().mo3653d((C0132p<? super T, Boolean>) C4846kd.f8484a);
        C4779Yc yc = C4779Yc.f8414a;
        $jacocoInit[64] = true;
        C0120S j = d.mo3669j(yc);
        C4775Xc xc = new C4775Xc(this);
        $jacocoInit[65] = true;
        C0120S i = j.mo3668i(xc);
        $jacocoInit[66] = true;
        C0120S g = i.mo3662g();
        $jacocoInit[67] = true;
        return g;
    }

    /* renamed from: e */
    static /* synthetic */ String m9230e(SearchQueryEvent data) {
        boolean[] $jacocoInit = $jacocoInit();
        String query = data.getQuery();
        $jacocoInit[78] = true;
        String str = query.toString();
        $jacocoInit[79] = true;
        return str;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo16370a(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        Single suggestionsForApp = this.searchSuggestionManager.getSuggestionsForApp(query);
        C4856md mdVar = new C4856md(this);
        $jacocoInit[68] = true;
        Single e = suggestionsForApp.mo3699e(mdVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[69] = true;
        Single a = e.mo3686a(v);
        C4906wd wdVar = new C4906wd(this);
        $jacocoInit[70] = true;
        Single b = a.mo3695b((C0129b<? super T>) wdVar);
        $jacocoInit[71] = true;
        return b;
    }

    /* renamed from: d */
    public /* synthetic */ Single mo16378d(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        if (err instanceof TimeoutException) {
            $jacocoInit[73] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[74] = true;
            instance.mo2145i(str, "Timeout reached while waiting for application suggestions");
            $jacocoInit[75] = true;
            Single a = Single.m734a(this.suggestionCursorAdapter.getSuggestions());
            $jacocoInit[76] = true;
            return a;
        }
        Single a2 = Single.m735a(err);
        $jacocoInit[77] = true;
        return a2;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16377c(List queryResults) {
        boolean[] $jacocoInit = $jacocoInit();
        this.suggestionCursorAdapter.setData(queryResults);
        $jacocoInit[72] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9222a(List __) {
        $jacocoInit()[63] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16372a(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[62] = true;
    }

    private void showSuggestionsIfCurrentQueryIsEmpty() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4861nd ndVar = C4861nd.f8499a;
        $jacocoInit[26] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ndVar);
        C4806dd ddVar = new C4806dd(this);
        $jacocoInit[27] = true;
        C0120S i = d.mo3668i(ddVar);
        C4851ld ldVar = new C4851ld(this);
        $jacocoInit[28] = true;
        C0120S d2 = i.mo3653d((C0132p<? super T, Boolean>) ldVar);
        C4763Uc uc = new C4763Uc(this);
        $jacocoInit[29] = true;
        C0120S i2 = d2.mo3668i(uc);
        C4871pd pdVar = C4871pd.f8510a;
        $jacocoInit[30] = true;
        C0120S d3 = i2.mo3653d((C0132p<? super T, Boolean>) pdVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[31] = true;
        C0120S a = d3.mo3616a(v);
        C4826hd hdVar = new C4826hd(this);
        $jacocoInit[32] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) hdVar);
        C4896ud udVar = new C4896ud(this);
        $jacocoInit[33] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) udVar);
        SearchSuggestionsView searchSuggestionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[34] = true;
        C0120S a2 = b2.mo3614a((C0121c<? super T, ? extends R>) searchSuggestionsView.bindUntilEvent(lifecycleEvent2));
        C4816fd fdVar = C4816fd.f8452a;
        C4881rd rdVar = new C4881rd(this);
        $jacocoInit[35] = true;
        a2.mo3626a((C0129b<? super T>) fdVar, (C0129b<Throwable>) rdVar);
        $jacocoInit[36] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m9232g(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[61] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ Single mo16386h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S onQueryTextChanged = this.view.onQueryTextChanged();
        $jacocoInit[58] = true;
        C0120S d = onQueryTextChanged.mo3647d();
        $jacocoInit[59] = true;
        Single n = d.mo3678n();
        $jacocoInit[60] = true;
        return n;
    }

    /* renamed from: h */
    public /* synthetic */ Boolean mo16385h(SearchQueryEvent data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String currentQuery = this.view.getCurrentQuery();
        if (data == null) {
            $jacocoInit[47] = true;
        } else {
            $jacocoInit[48] = true;
            String query = data.getQuery();
            $jacocoInit[49] = true;
            if (query.length() != 0) {
                $jacocoInit[50] = true;
                z = false;
                $jacocoInit[56] = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[57] = true;
                return valueOf;
            }
            $jacocoInit[51] = true;
        }
        if (currentQuery == null) {
            $jacocoInit[52] = true;
        } else if (!currentQuery.isEmpty()) {
            $jacocoInit[53] = true;
            z = false;
            $jacocoInit[56] = true;
            Boolean valueOf2 = Boolean.valueOf(z);
            $jacocoInit[57] = true;
            return valueOf2;
        } else {
            $jacocoInit[54] = true;
        }
        $jacocoInit[55] = true;
        z = true;
        Boolean valueOf22 = Boolean.valueOf(z);
        $jacocoInit[57] = true;
        return valueOf22;
    }

    /* renamed from: i */
    public /* synthetic */ Single mo16387i(SearchQueryEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single trendingCursorSuggestions = this.trendingManager.getTrendingCursorSuggestions();
        $jacocoInit[46] = true;
        return trendingCursorSuggestions;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m9229e(List data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (data == null) {
            $jacocoInit[41] = true;
        } else if (data.size() <= 0) {
            $jacocoInit[42] = true;
        } else {
            $jacocoInit[43] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[45] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[44] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[45] = true;
        return valueOf2;
    }

    /* renamed from: f */
    public /* synthetic */ void mo16382f(List data) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setTrendingCursor(data);
        $jacocoInit[40] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo16384g(List __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.focusInSearchBar();
        $jacocoInit[39] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m9233h(List __) {
        $jacocoInit()[38] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo16380e(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[37] = true;
    }
}
