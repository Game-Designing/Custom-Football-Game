package p005cm.aptoide.p006pt.app.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.widget.SwipeRefreshLayout;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p005cm.aptoide.p006pt.home.AdHomeEvent;
import p005cm.aptoide.p006pt.home.AdsBundlesViewHolderFactory;
import p005cm.aptoide.p006pt.home.AppHomeEvent;
import p005cm.aptoide.p006pt.home.BundlesAdapter;
import p005cm.aptoide.p006pt.home.HomeBundle;
import p005cm.aptoide.p006pt.home.HomeEvent;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.home.ProgressBundle;
import p005cm.aptoide.p006pt.home.ScrollableView;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment.BundleCons;
import p005cm.aptoide.p006pt.view.Translator;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;
import p019d.p022i.p296a.p298b.p301b.p302a.C13016e;
import p019d.p022i.p296a.p298b.p303c.p304a.C13020a;
import p019d.p022i.p296a.p298b.p303c.p304a.C13024e;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.app.view.MoreBundleFragment */
public class MoreBundleFragment extends NavigationTrackFragment implements MoreBundleView, ScrollableView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String MORE_LIST_STATE_KEY = "cm.aptoide.pt.more.ListState";
    private static final int VISIBLE_THRESHOLD = 1;
    private C14963c<AdHomeEvent> adClickedEvents;
    private BundlesAdapter adapter;
    private RecyclerView bundlesList;
    @Inject
    CaptionBackgroundPainter captionBackgroundPainter;
    private View genericErrorView;
    private LinearLayoutManager layoutManager;
    private Parcelable listState;
    @Inject
    String marketName;
    private View noNetworkErrorView;
    private View noNetworkRetryButton;
    private C14963c<Boolean> notifyItemsAdded;
    private DecimalFormat oneDecimalFormatter;
    @Inject
    MoreBundlePresenter presenter;
    private ProgressBar progressBar;
    private View retryButton;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Toolbar toolbar;
    private View toolbarElement;
    private C14963c<HomeEvent> uiEventsListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6521601031559033752L, "cm/aptoide/pt/app/view/MoreBundleFragment", Opcodes.IFNE);
        $jacocoData = probes;
        return probes;
    }

    public MoreBundleFragment() {
        $jacocoInit()[0] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        this.uiEventsListener = C14963c.m46753p();
        $jacocoInit[2] = true;
        this.adClickedEvents = C14963c.m46753p();
        $jacocoInit[3] = true;
        this.notifyItemsAdded = C14963c.m46753p();
        $jacocoInit[4] = true;
        this.oneDecimalFormatter = new DecimalFormat("0.0");
        $jacocoInit[5] = true;
        setHasOptionsMenu(true);
        $jacocoInit[6] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        View view2 = view;
        Bundle bundle = savedInstanceState;
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[7] = true;
        getFragmentComponent(bundle).inject(this);
        if (bundle == null) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            String str = MORE_LIST_STATE_KEY;
            if (!bundle.containsKey(str)) {
                $jacocoInit[10] = true;
            } else {
                $jacocoInit[11] = true;
                this.listState = bundle.getParcelable(str);
                $jacocoInit[12] = true;
                bundle.putParcelable(str, null);
                $jacocoInit[13] = true;
            }
        }
        this.bundlesList = (RecyclerView) view2.findViewById(C1375R.C1376id.more_bundles_list);
        $jacocoInit[14] = true;
        this.toolbarElement = view2.findViewById(C1375R.C1376id.action_bar);
        $jacocoInit[15] = true;
        this.genericErrorView = view2.findViewById(C1375R.C1376id.generic_error);
        $jacocoInit[16] = true;
        this.noNetworkErrorView = view2.findViewById(C1375R.C1376id.no_network_connection);
        $jacocoInit[17] = true;
        this.progressBar = (ProgressBar) view2.findViewById(C1375R.C1376id.progress_bar);
        $jacocoInit[18] = true;
        this.retryButton = this.genericErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[19] = true;
        this.noNetworkRetryButton = this.noNetworkErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[20] = true;
        this.swipeRefreshLayout = (SwipeRefreshLayout) view2.findViewById(C1375R.C1376id.more_refresh_layout);
        $jacocoInit[21] = true;
        this.toolbar = (Toolbar) view2.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[22] = true;
        this.swipeRefreshLayout.setColorSchemeResources(C1375R.color.default_progress_bar_color, C1375R.color.default_color, C1375R.color.default_progress_bar_color, C1375R.color.default_color);
        $jacocoInit[23] = true;
        ArrayList arrayList = new ArrayList();
        ProgressBundle progressBundle = new ProgressBundle();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        DecimalFormat decimalFormat = this.oneDecimalFormatter;
        String str2 = this.marketName;
        String str3 = str2;
        DecimalFormat decimalFormat2 = decimalFormat;
        AdsBundlesViewHolderFactory adsBundlesViewHolderFactory = new AdsBundlesViewHolderFactory(cVar, this.adClickedEvents, decimalFormat, str2, false);
        BundlesAdapter bundlesAdapter = new BundlesAdapter(arrayList, progressBundle, cVar, decimalFormat2, str3, adsBundlesViewHolderFactory, this.captionBackgroundPainter);
        this.adapter = bundlesAdapter;
        $jacocoInit[24] = true;
        this.layoutManager = new LinearLayoutManager(getContext());
        $jacocoInit[25] = true;
        this.bundlesList.setLayoutManager(this.layoutManager);
        $jacocoInit[26] = true;
        this.bundlesList.setAdapter(this.adapter);
        $jacocoInit[27] = true;
        C0019n appCompatActivity = (C0019n) getActivity();
        $jacocoInit[28] = true;
        if (getArguments().getBoolean(BundleCons.TOOLBAR, true)) {
            $jacocoInit[29] = true;
            appCompatActivity.setSupportActionBar(this.toolbar);
            $jacocoInit[30] = true;
            C0760a actionBar = appCompatActivity.getSupportActionBar();
            if (actionBar == null) {
                $jacocoInit[31] = true;
            } else {
                $jacocoInit[32] = true;
                actionBar.mo6153d(true);
                $jacocoInit[33] = true;
            }
            $jacocoInit[34] = true;
        } else {
            this.toolbarElement.setVisibility(8);
            $jacocoInit[35] = true;
        }
        attachPresenter(this.presenter);
        $jacocoInit[36] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[37] = true;
        String simpleName = cls.getSimpleName();
        String name = StoreContext.home.name();
        $jacocoInit[38] = true;
        ScreenTagHistory build = Builder.build(simpleName, "", name);
        $jacocoInit[39] = true;
        return build;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.more_bundles_view, container, false);
        $jacocoInit[40] = true;
        return inflate;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        RecyclerView recyclerView = this.bundlesList;
        if (recyclerView == null) {
            $jacocoInit[41] = true;
        } else {
            $jacocoInit[42] = true;
            C0981i layoutManager2 = recyclerView.getLayoutManager();
            $jacocoInit[43] = true;
            Parcelable onSaveInstanceState = layoutManager2.onSaveInstanceState();
            $jacocoInit[44] = true;
            outState.putParcelable(MORE_LIST_STATE_KEY, onSaveInstanceState);
            $jacocoInit[45] = true;
        }
        $jacocoInit[46] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        C0981i layoutManager2 = this.bundlesList.getLayoutManager();
        $jacocoInit[47] = true;
        this.listState = layoutManager2.onSaveInstanceState();
        this.bundlesList = null;
        this.adapter = null;
        this.layoutManager = null;
        this.swipeRefreshLayout = null;
        this.genericErrorView = null;
        this.noNetworkErrorView = null;
        this.progressBar = null;
        this.toolbar = null;
        $jacocoInit[48] = true;
        super.onDestroyView();
        $jacocoInit[49] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.uiEventsListener = null;
        this.oneDecimalFormatter = null;
        this.adClickedEvents = null;
        $jacocoInit[50] = true;
        super.onDestroy();
        $jacocoInit[51] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[52] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[53] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[54] = true;
            getActivity().onBackPressed();
            $jacocoInit[55] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[56] = true;
        return onOptionsItemSelected;
    }

    public void showBundles(List<HomeBundle> bundles) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.update(bundles);
        if (this.listState == null) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            C0981i layoutManager2 = this.bundlesList.getLayoutManager();
            Parcelable parcelable = this.listState;
            $jacocoInit[59] = true;
            layoutManager2.onRestoreInstanceState(parcelable);
            this.listState = null;
            $jacocoInit[60] = true;
        }
        $jacocoInit[61] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundlesList.setVisibility(8);
        $jacocoInit[62] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[63] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[64] = true;
        this.progressBar.setVisibility(0);
        $jacocoInit[65] = true;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundlesList.setVisibility(0);
        $jacocoInit[66] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[67] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[68] = true;
        this.progressBar.setVisibility(8);
        $jacocoInit[69] = true;
        this.swipeRefreshLayout.setVisibility(0);
        $jacocoInit[70] = true;
    }

    public void showGenericError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.genericErrorView.setVisibility(0);
        $jacocoInit[71] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[72] = true;
        this.bundlesList.setVisibility(8);
        $jacocoInit[73] = true;
        this.progressBar.setVisibility(8);
        $jacocoInit[74] = true;
        if (!this.swipeRefreshLayout.mo5859b()) {
            $jacocoInit[75] = true;
        } else {
            $jacocoInit[76] = true;
            this.swipeRefreshLayout.setRefreshing(false);
            $jacocoInit[77] = true;
        }
        $jacocoInit[78] = true;
    }

    public C0120S<Void> refreshes() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13016e.m42477a(this.swipeRefreshLayout);
        $jacocoInit[79] = true;
        return a;
    }

    public C0120S<Object> reachesBottom() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13024e.m42482a(this.bundlesList);
        C1996_g _gVar = new C1996_g(this);
        $jacocoInit[80] = true;
        C0120S j = a.mo3669j(_gVar);
        C14963c<Boolean> cVar = this.notifyItemsAdded;
        $jacocoInit[81] = true;
        C0120S b = C0120S.m649b(j, (C0120S<? extends T>) cVar);
        $jacocoInit[82] = true;
        C0120S b2 = b.mo3628b();
        C2069eh ehVar = C2069eh.f5118a;
        $jacocoInit[83] = true;
        $jacocoInit[84] = true;
        C0120S<Object> a2 = b2.mo3653d((C0132p<? super T, Boolean>) ehVar).mo3611a(Object.class);
        $jacocoInit[85] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo10778a(C13020a scroll) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(isEndReached());
        $jacocoInit[153] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6899a(Boolean isEnd) {
        $jacocoInit()[152] = true;
        return isEnd;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m6902c(HomeEvent homeClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeClick.getType();
        Type type2 = Type.MORE;
        $jacocoInit[145] = true;
        if (type.equals(type2)) {
            $jacocoInit[146] = true;
        } else {
            Type type3 = homeClick.getType();
            Type type4 = Type.MORE_TOP;
            $jacocoInit[147] = true;
            if (type3.equals(type4)) {
                $jacocoInit[148] = true;
            } else {
                z = false;
                $jacocoInit[150] = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[151] = true;
                return valueOf;
            }
        }
        $jacocoInit[149] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[151] = true;
        return valueOf2;
    }

    public C0120S<HomeEvent> moreClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<HomeEvent> d = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C2026ch.f5064a);
        $jacocoInit[86] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6898a(HomeEvent homeClick) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeClick.getType();
        Type type2 = Type.APP;
        $jacocoInit[142] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[143] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[144] = true;
        return valueOf;
    }

    public C0120S<AppHomeEvent> appClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[87] = true;
        C0120S<AppHomeEvent> a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C2089gh.f5144a).mo3611a(AppHomeEvent.class);
        $jacocoInit[88] = true;
        return a;
    }

    public C0120S<AdHomeEvent> adClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<AdHomeEvent> cVar = this.adClickedEvents;
        $jacocoInit[89] = true;
        return cVar;
    }

    public void showLoadMore() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.addLoadMore();
        $jacocoInit[90] = true;
    }

    public void hideShowMore() {
        boolean[] $jacocoInit = $jacocoInit();
        BundlesAdapter bundlesAdapter = this.adapter;
        if (bundlesAdapter == null) {
            $jacocoInit[91] = true;
        } else {
            $jacocoInit[92] = true;
            bundlesAdapter.removeLoadMore();
            $jacocoInit[93] = true;
        }
        $jacocoInit[94] = true;
    }

    public void showMoreHomeBundles(List<HomeBundle> bundles) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.add(bundles);
        $jacocoInit[95] = true;
        this.notifyItemsAdded.onNext(Boolean.valueOf(false));
        $jacocoInit[96] = true;
    }

    public void hideRefresh() {
        boolean[] $jacocoInit = $jacocoInit();
        this.swipeRefreshLayout.setRefreshing(false);
        $jacocoInit[97] = true;
    }

    public void showNetworkError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.noNetworkErrorView.setVisibility(0);
        $jacocoInit[98] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[99] = true;
        this.bundlesList.setVisibility(8);
        $jacocoInit[100] = true;
        this.progressBar.setVisibility(8);
        $jacocoInit[101] = true;
        if (!this.swipeRefreshLayout.mo5859b()) {
            $jacocoInit[102] = true;
        } else {
            $jacocoInit[103] = true;
            this.swipeRefreshLayout.setRefreshing(false);
            $jacocoInit[104] = true;
        }
        $jacocoInit[105] = true;
    }

    public C0120S<Void> retryClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> b = C0120S.m649b(C13034a.m42490a(this.retryButton), C13034a.m42490a(this.noNetworkRetryButton));
        $jacocoInit[106] = true;
        return b;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m6901b(HomeEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = click.getType();
        Type type2 = Type.SCROLL_RIGHT;
        $jacocoInit[139] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[140] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[141] = true;
        return valueOf;
    }

    public C0120S<HomeEvent> bundleScrolled() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C2006ah.f5044a);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[107] = true;
        C0120S<HomeEvent> a = d.mo3607a(200, timeUnit);
        $jacocoInit[108] = true;
        return a;
    }

    public C0120S<HomeEvent> visibleBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13024e.m42482a(this.bundlesList);
        $jacocoInit[109] = true;
        C0120S b = a.mo3634b(C14522a.m46170a());
        C2079fh fhVar = new C2079fh(this);
        $jacocoInit[110] = true;
        C0120S j = b.mo3669j(fhVar);
        C2036dh dhVar = C2036dh.f5079a;
        $jacocoInit[111] = true;
        C0120S d = j.mo3653d((C0132p<? super T, Boolean>) dhVar);
        $jacocoInit[112] = true;
        C0120S b2 = d.mo3628b();
        C2016bh bhVar = new C2016bh(this);
        $jacocoInit[113] = true;
        C0120S<HomeEvent> j2 = b2.mo3669j(bhVar);
        $jacocoInit[114] = true;
        return j2;
    }

    /* renamed from: b */
    public /* synthetic */ Integer mo10782b(C13020a recyclerViewScrollEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(this.layoutManager.findFirstVisibleItemPosition());
        $jacocoInit[138] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6900a(Integer position) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (position.intValue() != -1) {
            $jacocoInit[135] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[136] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[137] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ HomeEvent mo10781b(Integer visibleItem) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeEvent homeEvent = new HomeEvent(this.adapter.getBundle(visibleItem.intValue()), visibleItem.intValue(), null);
        $jacocoInit[134] = true;
        return homeEvent;
    }

    public void updateEditorialCards() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.updateEditorials();
        if (this.listState == null) {
            $jacocoInit[115] = true;
        } else {
            $jacocoInit[116] = true;
            C0981i layoutManager2 = this.bundlesList.getLayoutManager();
            Parcelable parcelable = this.listState;
            $jacocoInit[117] = true;
            layoutManager2.onRestoreInstanceState(parcelable);
            this.listState = null;
            $jacocoInit[118] = true;
        }
        $jacocoInit[119] = true;
    }

    public void setToolbarInfo(String title) {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbar.setTitle((CharSequence) Translator.translate(title, getContext(), ""));
        $jacocoInit[120] = true;
        this.toolbar.setLogo((int) C1375R.drawable.logo_toolbar);
        $jacocoInit[121] = true;
    }

    private boolean isEndReached() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.layoutManager.getItemCount() - this.layoutManager.findLastVisibleItemPosition() <= 1) {
            $jacocoInit[122] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[123] = true;
        }
        $jacocoInit[124] = true;
        return z;
    }

    public void scrollToTop() {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayoutManager layoutManager2 = (LinearLayoutManager) this.bundlesList.getLayoutManager();
        $jacocoInit[125] = true;
        if (layoutManager2.findLastVisibleItemPosition() <= 10) {
            $jacocoInit[126] = true;
        } else {
            $jacocoInit[127] = true;
            this.bundlesList.mo7618i(10);
            $jacocoInit[128] = true;
        }
        this.bundlesList.mo7622j(0);
        $jacocoInit[129] = true;
    }

    public boolean isAtTop() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayoutManager layoutManager2 = (LinearLayoutManager) this.bundlesList.getLayoutManager();
        $jacocoInit[130] = true;
        if (layoutManager2.findFirstVisibleItemPosition() == 0) {
            $jacocoInit[131] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[132] = true;
        }
        $jacocoInit[133] = true;
        return z;
    }
}
