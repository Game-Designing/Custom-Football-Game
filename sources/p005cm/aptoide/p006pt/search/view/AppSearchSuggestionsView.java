package p005cm.aptoide.p006pt.search.view;

import android.support.p001v7.widget.SearchView;
import android.support.p001v7.widget.SearchView.C1011d;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import com.trello.rxlifecycle.C0096f;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.search.SuggestionCursorAdapter;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.search.analytics.SearchSource;
import p005cm.aptoide.p006pt.search.model.Suggestion;
import p005cm.aptoide.p006pt.search.suggestions.SearchQueryEvent;
import p005cm.aptoide.p006pt.view.fragment.FragmentView;
import p019d.p022i.p296a.p298b.p303c.p304a.C13025f;
import p019d.p022i.p296a.p298b.p303c.p304a.C13030k;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.search.view.AppSearchSuggestionsView */
public class AppSearchSuggestionsView implements SearchSuggestionsView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final int COMPLETION_THRESHOLD = 0;
    private final CrashReport crashReport;
    private final String currentQuery;
    private final FragmentView parentView;
    private final C14963c<SearchQueryEvent> queryTextChangedPublisher;
    private final SearchAnalytics searchAnalytics;
    private MenuItem searchMenuItem;
    private SearchView searchView;
    private final SuggestionCursorAdapter suggestionCursorAdapter;
    private final C0120S<Void> toolbarClickObservable;
    private C0120S<MenuItem> toolbarMenuItemClick;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1090698356923771808L, "cm/aptoide/pt/search/view/AppSearchSuggestionsView", 80);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ SuggestionCursorAdapter access$000(AppSearchSuggestionsView x0) {
        boolean[] $jacocoInit = $jacocoInit();
        SuggestionCursorAdapter suggestionCursorAdapter2 = x0.suggestionCursorAdapter;
        $jacocoInit[78] = true;
        return suggestionCursorAdapter2;
    }

    static /* synthetic */ C14963c access$100(AppSearchSuggestionsView x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<SearchQueryEvent> cVar = x0.queryTextChangedPublisher;
        $jacocoInit[79] = true;
        return cVar;
    }

    public AppSearchSuggestionsView(FragmentView parentView2, C0120S<Void> toolbarClickObservable2, CrashReport crashReport2, SuggestionCursorAdapter suggestionCursorAdapter2, C14963c<SearchQueryEvent> queryTextChangedPublisher2, C0120S<MenuItem> toolbarMenuItemClick2, SearchAnalytics searchAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(parentView2, toolbarClickObservable2, crashReport2, "", suggestionCursorAdapter2, queryTextChangedPublisher2, toolbarMenuItemClick2, searchAnalytics2);
        $jacocoInit[0] = true;
    }

    public AppSearchSuggestionsView(FragmentView parentView2, C0120S<Void> toolbarClickObservable2, CrashReport crashReport2, String currentQuery2, SuggestionCursorAdapter suggestionCursorAdapter2, C14963c<SearchQueryEvent> queryTextChangedPublisher2, C0120S<MenuItem> toolbarMenuItemClick2, SearchAnalytics searchAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.parentView = parentView2;
        this.toolbarClickObservable = toolbarClickObservable2;
        this.crashReport = crashReport2;
        this.currentQuery = currentQuery2;
        this.suggestionCursorAdapter = suggestionCursorAdapter2;
        this.queryTextChangedPublisher = queryTextChangedPublisher2;
        this.toolbarMenuItemClick = toolbarMenuItemClick2;
        this.searchAnalytics = searchAnalytics2;
        $jacocoInit[1] = true;
    }

    public void initialize(MenuItem searchMenuItem2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchMenuItem = searchMenuItem2;
        $jacocoInit[2] = true;
        this.searchView = (SearchView) searchMenuItem2.getActionView();
        $jacocoInit[3] = true;
        this.searchView.setSuggestionsAdapter(this.suggestionCursorAdapter);
        $jacocoInit[4] = true;
        this.searchView.setOnSuggestionListener(new C1011d(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ AppSearchSuggestionsView this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-5301097495860297590L, "cm/aptoide/pt/search/view/AppSearchSuggestionsView$1", 6);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public boolean onSuggestionSelect(int position) {
                $jacocoInit()[1] = true;
                return false;
            }

            public boolean onSuggestionClick(int position) {
                boolean[] $jacocoInit = $jacocoInit();
                C14963c access$100 = AppSearchSuggestionsView.access$100(this.this$0);
                AppSearchSuggestionsView appSearchSuggestionsView = this.this$0;
                $jacocoInit[2] = true;
                CharSequence suggestionAt = AppSearchSuggestionsView.access$000(appSearchSuggestionsView).getSuggestionAt(position);
                $jacocoInit[3] = true;
                SearchQueryEvent searchQueryEvent = new SearchQueryEvent(suggestionAt.toString(), position, true, true);
                $jacocoInit[4] = true;
                access$100.onNext(searchQueryEvent);
                $jacocoInit[5] = true;
                return true;
            }
        });
        $jacocoInit[5] = true;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.searchView.findViewById(C1375R.C1376id.search_src_text);
        $jacocoInit[6] = true;
        autoCompleteTextView.setThreshold(0);
        $jacocoInit[7] = true;
        C0120S d = getLifecycleEvent().mo3653d((C0132p<? super T, Boolean>) C4847l.f8485a);
        C4862o oVar = new C4862o(this);
        $jacocoInit[8] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) oVar);
        C4842k kVar = new C4842k(this);
        $jacocoInit[9] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) kVar);
        LifecycleEvent lifecycleEvent = LifecycleEvent.PAUSE;
        $jacocoInit[10] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(lifecycleEvent));
        C4857n nVar = C4857n.f8495a;
        C4797c cVar = new C4797c(this);
        $jacocoInit[11] = true;
        a.mo3626a((C0129b<? super T>) nVar, (C0129b<Throwable>) cVar);
        $jacocoInit[12] = true;
        toolbarClickExpandsSearch();
        $jacocoInit[13] = true;
        searchMenuItemClickExpandsSearch();
        $jacocoInit[14] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9019a(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.RESUME) {
            $jacocoInit[75] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[76] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[77] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo16153b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13025f.m42483a(this.searchView);
        $jacocoInit[74] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16150a(C13030k event) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<SearchQueryEvent> cVar = this.queryTextChangedPublisher;
        CharSequence c = event.mo41921c();
        $jacocoInit[71] = true;
        SearchQueryEvent searchQueryEvent = new SearchQueryEvent(c.toString(), event.mo41920b());
        $jacocoInit[72] = true;
        cVar.onNext(searchQueryEvent);
        $jacocoInit[73] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9020b(C13030k __) {
        $jacocoInit()[70] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16151a(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[69] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m9024e(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.RESUME) {
            $jacocoInit[66] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[67] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[68] = true;
        return valueOf;
    }

    private void toolbarClickExpandsSearch() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getLifecycleEvent().mo3653d((C0132p<? super T, Boolean>) C4852m.f8490a);
        C4827i iVar = new C4827i(this);
        $jacocoInit[15] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) iVar);
        C4822h hVar = new C4822h(this);
        $jacocoInit[16] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) hVar);
        C4837j jVar = new C4837j(this);
        $jacocoInit[17] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) jVar);
        LifecycleEvent lifecycleEvent = LifecycleEvent.PAUSE;
        $jacocoInit[18] = true;
        C0120S a = b2.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(lifecycleEvent));
        C4787a aVar = C4787a.f8422a;
        C4867p pVar = new C4867p(this);
        $jacocoInit[19] = true;
        a.mo3626a((C0129b<? super T>) aVar, (C0129b<Throwable>) pVar);
        $jacocoInit[20] = true;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo16161f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> s = this.toolbarClickObservable;
        $jacocoInit[65] = true;
        return s;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16152a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchAnalytics.searchStart(SearchSource.SEARCH_TOOLBAR, true);
        $jacocoInit[64] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16156b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        focusInSearchBar();
        $jacocoInit[63] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9022c(Void __) {
        $jacocoInit()[62] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16158c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[61] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m9021c(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.RESUME) {
            $jacocoInit[58] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[59] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[60] = true;
        return valueOf;
    }

    private void searchMenuItemClickExpandsSearch() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getLifecycleEvent().mo3653d((C0132p<? super T, Boolean>) C4807e.f8442a);
        C4817g gVar = new C4817g(this);
        $jacocoInit[21] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gVar);
        C4877r rVar = new C4877r(this);
        $jacocoInit[22] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) rVar);
        C4792b bVar = new C4792b(this);
        $jacocoInit[23] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) bVar);
        C4802d dVar = new C4802d(this);
        $jacocoInit[24] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) dVar);
        LifecycleEvent lifecycleEvent = LifecycleEvent.PAUSE;
        $jacocoInit[25] = true;
        C0120S a = b2.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(lifecycleEvent));
        C4812f fVar = C4812f.f8448a;
        C4872q qVar = new C4872q(this);
        $jacocoInit[26] = true;
        a.mo3626a((C0129b<? super T>) fVar, (C0129b<Throwable>) qVar);
        $jacocoInit[27] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo16160d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<MenuItem> s = this.toolbarMenuItemClick;
        $jacocoInit[57] = true;
        return s;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo16149a(MenuItem item) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == this.searchMenuItem.getItemId()) {
            $jacocoInit[54] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[55] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[56] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16154b(MenuItem __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchAnalytics.searchStart(SearchSource.SEARCH_ICON, true);
        $jacocoInit[53] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16157c(MenuItem __) {
        boolean[] $jacocoInit = $jacocoInit();
        focusInSearchBar();
        $jacocoInit[52] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m9023d(MenuItem __) {
        $jacocoInit()[51] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16155b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[50] = true;
    }

    public C0120S<SearchQueryEvent> onQueryTextChanged() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<SearchQueryEvent> cVar = this.queryTextChangedPublisher;
        $jacocoInit[28] = true;
        return cVar;
    }

    public void collapseSearchBar(boolean shouldShowSuggestions) {
        boolean[] $jacocoInit = $jacocoInit();
        MenuItem menuItem = this.searchMenuItem;
        if (menuItem == null) {
            $jacocoInit[29] = true;
        } else {
            menuItem.collapseActionView();
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
    }

    public String getCurrentQuery() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.currentQuery;
        if (str != null) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            str = "";
        }
        $jacocoInit[34] = true;
        return str;
    }

    public void focusInSearchBar() {
        boolean[] $jacocoInit = $jacocoInit();
        MenuItem menuItem = this.searchMenuItem;
        if (menuItem == null) {
            $jacocoInit[35] = true;
        } else {
            $jacocoInit[36] = true;
            menuItem.expandActionView();
            $jacocoInit[37] = true;
        }
        if (this.searchView == null) {
            $jacocoInit[38] = true;
        } else if (getCurrentQuery().isEmpty()) {
            $jacocoInit[39] = true;
        } else {
            $jacocoInit[40] = true;
            String currentQuery2 = getCurrentQuery();
            $jacocoInit[41] = true;
            this.searchView.setQuery(currentQuery2, false);
            $jacocoInit[42] = true;
        }
        $jacocoInit[43] = true;
    }

    public void setTrendingList(List<Suggestion> list) {
        $jacocoInit()[44] = true;
    }

    public void setSuggestionsList(List<String> list) {
        $jacocoInit()[45] = true;
    }

    public void setTrendingCursor(List<String> trending) {
        boolean[] $jacocoInit = $jacocoInit();
        this.suggestionCursorAdapter.setData(trending);
        $jacocoInit[46] = true;
    }

    public <T> C0096f<T> bindUntilEvent(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0096f<T> bindUntilEvent = this.parentView.bindUntilEvent(lifecycleEvent);
        $jacocoInit[47] = true;
        return bindUntilEvent;
    }

    public C0120S<LifecycleEvent> getLifecycleEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<LifecycleEvent> lifecycleEvent = this.parentView.getLifecycleEvent();
        $jacocoInit[48] = true;
        return lifecycleEvent;
    }

    public void attachPresenter(Presenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.parentView.attachPresenter(presenter);
        $jacocoInit[49] = true;
    }
}
