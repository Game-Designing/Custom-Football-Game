package p005cm.aptoide.p006pt.home;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.p000v4.widget.SwipeRefreshLayout;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0975f;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver;
import p005cm.aptoide.p006pt.ads.MoPubConsentDialogView;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p005cm.aptoide.p006pt.editorial.EditorialFragment;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.promotions.PromotionsHomeDialog;
import p005cm.aptoide.p006pt.reactions.ReactionsHomeEvent;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;
import p019d.p022i.p296a.p298b.p301b.p302a.C13016e;
import p019d.p022i.p296a.p298b.p303c.p304a.C13020a;
import p019d.p022i.p296a.p298b.p303c.p304a.C13024e;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.home.HomeFragment */
public class HomeFragment extends NavigationTrackFragment implements HomeView, ScrollableView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.HOME;
    private static final String LIST_STATE_KEY = "cm.aptoide.pt.BottomHomeFragment.ListState";
    private static final String TAG = EditorialFragment.class.getName();
    private static final int VISIBLE_THRESHOLD = 2;
    private C14963c<AdHomeEvent> adClickedEvents;
    private BundlesAdapter adapter;
    private BottomNavigationActivity bottomNavigationActivity;
    private RecyclerView bundlesList;
    @Inject
    CaptionBackgroundPainter captionBackgroundPainter;
    @Inject
    MoPubConsentDialogView consentDialogView;
    private View genericErrorView;
    private LinearLayoutManager layoutManager;
    private Parcelable listState;
    @Inject
    String marketName;
    private View noNetworkErrorView;
    private View noNetworkRetryButton;
    private DecimalFormat oneDecimalFormatter;
    @Inject
    HomePresenter presenter;
    private ProgressBar progressBar;
    private PromotionsHomeDialog promotionsHomeDialog;
    private View retryButton;
    private C14963c<Void> snackListener;
    private SwipeRefreshLayout swipeRefreshLayout;
    private C14963c<HomeEvent> uiEventsListener;
    private ImageView userAvatar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(837522459446280753L, "cm/aptoide/pt/home/HomeFragment", 206);
        $jacocoData = probes;
        return probes;
    }

    public HomeFragment() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[205] = true;
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        if (!(activity instanceof BottomNavigationActivity)) {
            $jacocoInit[1] = true;
        } else {
            this.bottomNavigationActivity = (BottomNavigationActivity) activity;
            $jacocoInit[2] = true;
        }
        $jacocoInit[3] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.uiEventsListener = null;
        this.oneDecimalFormatter = null;
        this.adClickedEvents = null;
        this.userAvatar = null;
        this.snackListener = null;
        $jacocoInit[4] = true;
        super.onDestroy();
        $jacocoInit[5] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[6] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[7] = true;
        this.uiEventsListener = C14963c.m46753p();
        $jacocoInit[8] = true;
        this.adClickedEvents = C14963c.m46753p();
        $jacocoInit[9] = true;
        this.snackListener = C14963c.m46753p();
        $jacocoInit[10] = true;
        this.oneDecimalFormatter = new DecimalFormat("0.0");
        $jacocoInit[11] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationActivity bottomNavigationActivity2 = this.bottomNavigationActivity;
        if (bottomNavigationActivity2 == null) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            bottomNavigationActivity2.requestFocus(BOTTOM_NAVIGATION_ITEM);
            $jacocoInit[14] = true;
        }
        if (savedInstanceState == null) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            String str = LIST_STATE_KEY;
            if (!savedInstanceState.containsKey(str)) {
                $jacocoInit[17] = true;
            } else {
                $jacocoInit[18] = true;
                this.listState = savedInstanceState.getParcelable(str);
                $jacocoInit[19] = true;
                savedInstanceState.putParcelable(str, null);
                $jacocoInit[20] = true;
            }
        }
        this.userAvatar = (ImageView) view.findViewById(C1375R.C1376id.user_actionbar_icon);
        $jacocoInit[21] = true;
        this.bundlesList = (RecyclerView) view.findViewById(C1375R.C1376id.bundles_list);
        $jacocoInit[22] = true;
        C0975f itemAnimator = this.bundlesList.getItemAnimator();
        $jacocoInit[23] = true;
        itemAnimator.mo7722a(0);
        $jacocoInit[24] = true;
        this.genericErrorView = view.findViewById(C1375R.C1376id.generic_error);
        $jacocoInit[25] = true;
        this.noNetworkErrorView = view.findViewById(C1375R.C1376id.no_network_connection);
        $jacocoInit[26] = true;
        this.retryButton = this.genericErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[27] = true;
        this.noNetworkRetryButton = this.noNetworkErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[28] = true;
        this.progressBar = (ProgressBar) view.findViewById(C1375R.C1376id.progress_bar);
        $jacocoInit[29] = true;
        this.swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(C1375R.C1376id.refresh_layout);
        $jacocoInit[30] = true;
        this.swipeRefreshLayout.setColorSchemeResources(C1375R.color.default_progress_bar_color, C1375R.color.default_color, C1375R.color.default_progress_bar_color, C1375R.color.default_color);
        $jacocoInit[31] = true;
        this.layoutManager = new LinearLayoutManager(getContext());
        $jacocoInit[32] = true;
        this.bundlesList.setLayoutManager(this.layoutManager);
        $jacocoInit[33] = true;
        this.promotionsHomeDialog = new PromotionsHomeDialog(getContext());
        $jacocoInit[34] = true;
        attachPresenter(this.presenter);
        $jacocoInit[35] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[36] = true;
        String simpleName = cls.getSimpleName();
        String name = StoreContext.home.name();
        $jacocoInit[37] = true;
        ScreenTagHistory build = Builder.build(simpleName, "", name);
        $jacocoInit[38] = true;
        return build;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_home, container, false);
        $jacocoInit[39] = true;
        return inflate;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        RecyclerView recyclerView = this.bundlesList;
        if (recyclerView == null) {
            $jacocoInit[40] = true;
        } else {
            $jacocoInit[41] = true;
            C0981i layoutManager2 = recyclerView.getLayoutManager();
            $jacocoInit[42] = true;
            Parcelable onSaveInstanceState = layoutManager2.onSaveInstanceState();
            $jacocoInit[43] = true;
            outState.putParcelable(LIST_STATE_KEY, onSaveInstanceState);
            $jacocoInit[44] = true;
        }
        $jacocoInit[45] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        C0981i layoutManager2 = this.bundlesList.getLayoutManager();
        $jacocoInit[46] = true;
        this.listState = layoutManager2.onSaveInstanceState();
        this.bundlesList = null;
        this.adapter = null;
        this.layoutManager = null;
        this.swipeRefreshLayout = null;
        this.genericErrorView = null;
        this.noNetworkErrorView = null;
        this.progressBar = null;
        PromotionsHomeDialog promotionsHomeDialog2 = this.promotionsHomeDialog;
        if (promotionsHomeDialog2 == null) {
            $jacocoInit[47] = true;
        } else {
            $jacocoInit[48] = true;
            promotionsHomeDialog2.destroyDialog();
            this.promotionsHomeDialog = null;
            $jacocoInit[49] = true;
        }
        this.consentDialogView = null;
        $jacocoInit[50] = true;
        super.onDestroyView();
        $jacocoInit[51] = true;
    }

    public void onDetach() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationActivity = null;
        $jacocoInit[52] = true;
        super.onDetach();
        $jacocoInit[53] = true;
    }

    public void showBundles(List<HomeBundle> bundles) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.update(bundles);
        if (this.listState == null) {
            $jacocoInit[54] = true;
        } else {
            $jacocoInit[55] = true;
            C0981i layoutManager2 = this.bundlesList.getLayoutManager();
            Parcelable parcelable = this.listState;
            $jacocoInit[56] = true;
            layoutManager2.onRestoreInstanceState(parcelable);
            this.listState = null;
            $jacocoInit[57] = true;
        }
        $jacocoInit[58] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundlesList.setVisibility(8);
        $jacocoInit[59] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[60] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[61] = true;
        this.progressBar.setVisibility(0);
        $jacocoInit[62] = true;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundlesList.setVisibility(0);
        $jacocoInit[63] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[64] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[65] = true;
        this.progressBar.setVisibility(8);
        $jacocoInit[66] = true;
        this.swipeRefreshLayout.setVisibility(0);
        $jacocoInit[67] = true;
    }

    public void showGenericError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.genericErrorView.setVisibility(0);
        $jacocoInit[68] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[69] = true;
        this.bundlesList.setVisibility(8);
        $jacocoInit[70] = true;
        this.progressBar.setVisibility(8);
        $jacocoInit[71] = true;
        if (!this.swipeRefreshLayout.mo5859b()) {
            $jacocoInit[72] = true;
        } else {
            $jacocoInit[73] = true;
            this.swipeRefreshLayout.setRefreshing(false);
            $jacocoInit[74] = true;
        }
        $jacocoInit[75] = true;
    }

    public C0120S<Void> refreshes() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13016e.m42477a(this.swipeRefreshLayout);
        $jacocoInit[76] = true;
        return a;
    }

    public C0120S<Object> reachesBottom() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13024e.m42482a(this.bundlesList);
        C3361Db db = new C3361Db(this);
        $jacocoInit[77] = true;
        C0120S j = a.mo3669j(db);
        $jacocoInit[78] = true;
        C0120S b = j.mo3628b();
        C3947vb vbVar = C3947vb.f7427a;
        $jacocoInit[79] = true;
        $jacocoInit[80] = true;
        C0120S<Object> a2 = b.mo3653d((C0132p<? super T, Boolean>) vbVar).mo3611a(Object.class);
        $jacocoInit[81] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo14417a(C13020a scroll) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(isEndReached());
        $jacocoInit[204] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8047a(Boolean isEnd) {
        $jacocoInit()[203] = true;
        return isEnd;
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m8053f(HomeEvent homeClick) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeClick.getType();
        Type type2 = Type.MORE;
        $jacocoInit[200] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[201] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[202] = true;
        return valueOf;
    }

    public C0120S<HomeEvent> moreClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<HomeEvent> d = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3349Bb.f6730a);
        $jacocoInit[82] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8046a(HomeEvent homeClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeClick.getType();
        Type type2 = Type.APP;
        $jacocoInit[193] = true;
        if (type.equals(type2)) {
            $jacocoInit[194] = true;
        } else {
            Type type3 = homeClick.getType();
            Type type4 = Type.REWARD_APP;
            $jacocoInit[195] = true;
            if (type3.equals(type4)) {
                $jacocoInit[196] = true;
            } else {
                z = false;
                $jacocoInit[198] = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[199] = true;
                return valueOf;
            }
        }
        $jacocoInit[197] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[199] = true;
        return valueOf2;
    }

    public C0120S<AppHomeEvent> appClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[83] = true;
        C0120S<AppHomeEvent> a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3356Cb.f6735a).mo3611a(AppHomeEvent.class);
        $jacocoInit[84] = true;
        return a;
    }

    public C0120S<AdHomeEvent> adClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<AdHomeEvent> cVar = this.adClickedEvents;
        $jacocoInit[85] = true;
        return cVar;
    }

    public void showLoadMore() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.addLoadMore();
        $jacocoInit[86] = true;
    }

    public void hideShowMore() {
        boolean[] $jacocoInit = $jacocoInit();
        BundlesAdapter bundlesAdapter = this.adapter;
        if (bundlesAdapter == null) {
            $jacocoInit[87] = true;
        } else {
            $jacocoInit[88] = true;
            bundlesAdapter.removeLoadMore();
            $jacocoInit[89] = true;
        }
        $jacocoInit[90] = true;
    }

    public void showMoreHomeBundles(List<HomeBundle> bundles) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.add(bundles);
        $jacocoInit[91] = true;
    }

    public void hideRefresh() {
        boolean[] $jacocoInit = $jacocoInit();
        this.swipeRefreshLayout.setRefreshing(false);
        $jacocoInit[92] = true;
    }

    public void showNetworkError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.noNetworkErrorView.setVisibility(0);
        $jacocoInit[93] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[94] = true;
        this.bundlesList.setVisibility(8);
        $jacocoInit[95] = true;
        this.progressBar.setVisibility(8);
        $jacocoInit[96] = true;
        if (!this.swipeRefreshLayout.mo5859b()) {
            $jacocoInit[97] = true;
        } else {
            $jacocoInit[98] = true;
            this.swipeRefreshLayout.setRefreshing(false);
            $jacocoInit[99] = true;
        }
        $jacocoInit[100] = true;
    }

    public C0120S<Void> retryClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> b = C0120S.m649b(C13034a.m42490a(this.retryButton), C13034a.m42490a(this.noNetworkRetryButton));
        $jacocoInit[101] = true;
        return b;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8049b(HomeEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = click.getType();
        Type type2 = Type.SCROLL_RIGHT;
        $jacocoInit[190] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[191] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[192] = true;
        return valueOf;
    }

    public C0120S<HomeEvent> bundleScrolled() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3935tb.f7409a);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[102] = true;
        C0120S<HomeEvent> a = d.mo3607a(200, timeUnit);
        $jacocoInit[103] = true;
        return a;
    }

    public C0120S<HomeEvent> visibleBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13024e.m42482a(this.bundlesList);
        $jacocoInit[104] = true;
        C0120S b = a.mo3634b(C14522a.m46170a());
        C3953wb wbVar = new C3953wb(this);
        $jacocoInit[105] = true;
        C0120S j = b.mo3669j(wbVar);
        C3338Ab ab = C3338Ab.f6724a;
        $jacocoInit[106] = true;
        C0120S d = j.mo3653d((C0132p<? super T, Boolean>) ab);
        $jacocoInit[107] = true;
        C0120S b2 = d.mo3628b();
        C3390Ib ib = new C3390Ib(this);
        $jacocoInit[108] = true;
        C0120S<HomeEvent> j2 = b2.mo3669j(ib);
        $jacocoInit[109] = true;
        return j2;
    }

    /* renamed from: b */
    public /* synthetic */ Integer mo14420b(C13020a recyclerViewScrollEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(this.layoutManager.findFirstVisibleItemPosition());
        $jacocoInit[189] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8048a(Integer position) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (position.intValue() != -1) {
            $jacocoInit[186] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[187] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[188] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ HomeEvent mo14419b(Integer visibleItem) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeEvent homeEvent = new HomeEvent(this.adapter.getBundle(visibleItem.intValue()), visibleItem.intValue(), null);
        $jacocoInit[185] = true;
        return homeEvent;
    }

    public void updateEditorialCards() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.updateEditorials();
        if (this.listState == null) {
            $jacocoInit[110] = true;
        } else {
            $jacocoInit[111] = true;
            C0981i layoutManager2 = this.bundlesList.getLayoutManager();
            Parcelable parcelable = this.listState;
            $jacocoInit[112] = true;
            layoutManager2.onRestoreInstanceState(parcelable);
            this.listState = null;
            $jacocoInit[113] = true;
        }
        $jacocoInit[114] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m8051d(HomeEvent homeClick) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeClick.getType();
        Type type2 = Type.EDITORIAL;
        $jacocoInit[182] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[183] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[184] = true;
        return valueOf;
    }

    public C0120S<EditorialHomeEvent> editorialCardClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[115] = true;
        C0120S<EditorialHomeEvent> a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3373Fb.f6753a).mo3611a(EditorialHomeEvent.class);
        $jacocoInit[116] = true;
        return a;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8052e(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.KNOW_MORE;
        $jacocoInit[179] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[180] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[181] = true;
        return valueOf;
    }

    public C0120S<HomeEvent> infoBundleKnowMoreClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<HomeEvent> d = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3366Eb.f6747a);
        $jacocoInit[117] = true;
        return d;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m8056i(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.REACT_SINGLE_PRESS;
        $jacocoInit[176] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[177] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[178] = true;
        return valueOf;
    }

    public C0120S<EditorialHomeEvent> reactionsButtonClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[118] = true;
        C0120S<EditorialHomeEvent> a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3959xb.f7439a).mo3611a(EditorialHomeEvent.class);
        $jacocoInit[119] = true;
        return a;
    }

    public void scrollToTop() {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayoutManager layoutManager2 = (LinearLayoutManager) this.bundlesList.getLayoutManager();
        $jacocoInit[120] = true;
        if (layoutManager2.findLastVisibleItemPosition() <= 10) {
            $jacocoInit[121] = true;
        } else {
            $jacocoInit[122] = true;
            this.bundlesList.mo7618i(10);
            $jacocoInit[123] = true;
        }
        this.bundlesList.mo7622j(0);
        $jacocoInit[124] = true;
    }

    public void setUserImage(String userAvatarUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.userAvatar;
        $jacocoInit[125] = true;
        with.loadWithShadowCircleTransformWithPlaceholder(userAvatarUrl, imageView, C1375R.drawable.ic_account_circle);
        $jacocoInit[126] = true;
    }

    public C0120S<Void> imageClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.userAvatar);
        $jacocoInit[127] = true;
        return a;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8050c(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.DISMISS_BUNDLE;
        $jacocoInit[173] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[174] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[175] = true;
        return valueOf;
    }

    public C0120S<HomeEvent> dismissBundleClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<HomeEvent> d = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3965yb.f7446a);
        $jacocoInit[128] = true;
        return d;
    }

    public void hideBundle(int bundlePosition) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.remove(bundlePosition);
        $jacocoInit[129] = true;
    }

    public void setAdsTest(boolean showNatives) {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList arrayList = new ArrayList();
        ProgressBundle progressBundle = new ProgressBundle();
        C14963c<HomeEvent> cVar = this.uiEventsListener;
        DecimalFormat decimalFormat = this.oneDecimalFormatter;
        String str = this.marketName;
        AdsBundlesViewHolderFactory adsBundlesViewHolderFactory = new AdsBundlesViewHolderFactory(cVar, this.adClickedEvents, decimalFormat, str, showNatives);
        BundlesAdapter bundlesAdapter = new BundlesAdapter(arrayList, progressBundle, cVar, decimalFormat, str, adsBundlesViewHolderFactory, this.captionBackgroundPainter);
        this.adapter = bundlesAdapter;
        $jacocoInit[130] = true;
        this.bundlesList.setAdapter(this.adapter);
        $jacocoInit[131] = true;
    }

    /* renamed from: j */
    static /* synthetic */ Boolean m8057j(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.INSTALL_WALLET;
        $jacocoInit[170] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[171] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[172] = true;
        return valueOf;
    }

    public C0120S<HomeEvent> walletOfferCardInstallWalletClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<HomeEvent> d = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3971zb.f7453a);
        $jacocoInit[132] = true;
        return d;
    }

    public void sendDeeplinkToWalletAppView(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(getContext(), DeepLinkIntentReceiver.class);
        $jacocoInit[133] = true;
        intent.setData(Uri.parse(url));
        $jacocoInit[134] = true;
        startActivity(intent);
        $jacocoInit[135] = true;
    }

    public void showConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.consentDialogView.showConsentDialog();
        $jacocoInit[136] = true;
    }

    /* renamed from: h */
    static /* synthetic */ Boolean m8055h(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.REACTION;
        $jacocoInit[167] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[168] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[169] = true;
        return valueOf;
    }

    public C0120S<ReactionsHomeEvent> reactionClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[137] = true;
        C0120S<ReactionsHomeEvent> a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3941ub.f7417a).mo3611a(ReactionsHomeEvent.class);
        $jacocoInit[138] = true;
        return a;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m8054g(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.REACT_LONG_PRESS;
        $jacocoInit[164] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[165] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[166] = true;
        return valueOf;
    }

    public C0120S<EditorialHomeEvent> reactionButtonLongPress() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[139] = true;
        C0120S<EditorialHomeEvent> a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3378Gb.f6758a).mo3611a(EditorialHomeEvent.class);
        $jacocoInit[140] = true;
        return a;
    }

    public void showReactionsPopup(String cardId, String groupId, int bundlePosition) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[141] = true;
        EditorialBundleViewHolder editorialBundleViewHolder = getViewHolderForAdapterPosition(bundlePosition);
        if (editorialBundleViewHolder == null) {
            $jacocoInit[142] = true;
        } else {
            $jacocoInit[143] = true;
            editorialBundleViewHolder.showReactions(cardId, groupId, bundlePosition);
            $jacocoInit[144] = true;
        }
        $jacocoInit[145] = true;
    }

    public void showLogInDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        ShowMessage.asSnack((Activity) getActivity(), (int) C1375R.string.editorial_reactions_login_short, (int) C1375R.string.login, (OnClickListener) new C3383Hb(this), -1);
        $jacocoInit[146] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14418a(View snackView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.snackListener.onNext(null);
        $jacocoInit[163] = true;
    }

    public C0120S<Void> snackLogInClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.snackListener;
        $jacocoInit[147] = true;
        return cVar;
    }

    public void showGenericErrorToast() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a(getView(), (CharSequence) getString(C1375R.string.error_occured), 0);
        $jacocoInit[148] = true;
        a.mo4690h();
        $jacocoInit[149] = true;
    }

    public void showNetworkErrorToast() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a(getView(), (CharSequence) getString(C1375R.string.connection_error), 0);
        $jacocoInit[150] = true;
        a.mo4690h();
        $jacocoInit[151] = true;
    }

    public boolean isAtTop() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayoutManager layoutManager2 = (LinearLayoutManager) this.bundlesList.getLayoutManager();
        $jacocoInit[152] = true;
        if (layoutManager2.findFirstVisibleItemPosition() == 0) {
            $jacocoInit[153] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[154] = true;
        }
        $jacocoInit[155] = true;
        return z;
    }

    private boolean isEndReached() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.layoutManager.getItemCount() - this.layoutManager.findLastVisibleItemPosition() <= 2) {
            $jacocoInit[156] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[157] = true;
        }
        $jacocoInit[158] = true;
        return z;
    }

    private EditorialBundleViewHolder getViewHolderForAdapterPosition(int placeHolderPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            RecyclerView recyclerView = this.bundlesList;
            $jacocoInit[159] = true;
            EditorialBundleViewHolder placeHolderViewHolder = (EditorialBundleViewHolder) recyclerView.mo7544b(placeHolderPosition);
            $jacocoInit[160] = true;
            return placeHolderViewHolder;
        } catch (Exception e) {
            $jacocoInit[161] = true;
            Log.e(TAG, "Unable to find editorialViewHolder");
            $jacocoInit[162] = true;
            return null;
        }
    }
}
