package p005cm.aptoide.p006pt.view.app;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.widget.SwipeRefreshLayout;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.GridLayoutManager;
import android.support.p001v7.widget.GridLayoutManager.C0936a;
import android.support.p001v7.widget.GridLayoutManager.C0938c;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.support.p001v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.view.BackButtonFragment;
import p019d.p022i.p296a.p298b.p303c.p304a.C13020a;
import p019d.p022i.p296a.p298b.p303c.p304a.C13024e;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.view.app.ListStoreAppsFragment */
public class ListStoreAppsFragment extends BackButtonFragment implements ListStoreAppsView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String LIST_STATE_KEY = "cm.aptoide.pt.ListStoreAppsFragment.ListState";
    public static final int LOAD_THRESHOLD = 5;
    public static final String STORE_ID = "cm.aptoide.pt.ListStoreAppsFragment.storeId";
    private ListStoreAppsAdapter adapter;
    @Inject
    AppCenter appCenter;
    private C14963c<Application> appClicks;
    private View genericErrorLayout;
    private GridLayoutManager layoutManager;
    private Parcelable listState;
    @Inject
    ListStoreAppsNavigator listStoreAppsNavigator;
    private View noNetworkErrorLayout;
    private View noNetworkRetryButton;
    private RecyclerView recyclerView;
    private C14963c<Void> refreshEvent;
    private View retryButton;
    private ProgressBar startingLoadingLayout;
    private long storeId;
    private SwipeRefreshLayout swipeRefreshLayout;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6560806643497124772L, "cm/aptoide/pt/view/app/ListStoreAppsFragment", 97);
        $jacocoData = probes;
        return probes;
    }

    public ListStoreAppsFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ ListStoreAppsAdapter access$000(ListStoreAppsFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoreAppsAdapter listStoreAppsAdapter = x0.adapter;
        $jacocoInit[96] = true;
        return listStoreAppsAdapter;
    }

    public static Fragment newInstance(long storeId2) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[1] = true;
        args.putLong(STORE_ID, storeId2);
        $jacocoInit[2] = true;
        Fragment fragment = new ListStoreAppsFragment();
        $jacocoInit[3] = true;
        fragment.setArguments(args);
        $jacocoInit[4] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[5] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[6] = true;
        this.storeId = getArguments().getLong(STORE_ID);
        $jacocoInit[7] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        View view2 = view;
        Bundle bundle = savedInstanceState;
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        if (bundle == null) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            String str = LIST_STATE_KEY;
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
        this.appClicks = C14963c.m46753p();
        $jacocoInit[14] = true;
        this.refreshEvent = C14963c.m46753p();
        $jacocoInit[15] = true;
        this.recyclerView = (RecyclerView) view2.findViewById(C1375R.C1376id.recycler_view);
        $jacocoInit[16] = true;
        this.recyclerView.setVisibility(8);
        $jacocoInit[17] = true;
        this.swipeRefreshLayout = (SwipeRefreshLayout) view2.findViewById(C1375R.C1376id.swipe_container);
        $jacocoInit[18] = true;
        this.genericErrorLayout = view2.findViewById(C1375R.C1376id.generic_error);
        $jacocoInit[19] = true;
        this.noNetworkErrorLayout = view2.findViewById(C1375R.C1376id.no_network_connection);
        $jacocoInit[20] = true;
        this.retryButton = this.genericErrorLayout.findViewById(C1375R.C1376id.retry);
        $jacocoInit[21] = true;
        this.noNetworkRetryButton = this.noNetworkErrorLayout.findViewById(C1375R.C1376id.retry);
        $jacocoInit[22] = true;
        this.swipeRefreshLayout.setOnRefreshListener(new C5257Z(this));
        $jacocoInit[23] = true;
        setupToolbar(view);
        $jacocoInit[24] = true;
        this.adapter = new ListStoreAppsAdapter(new ArrayList(), this.appClicks);
        $jacocoInit[25] = true;
        this.recyclerView.setAdapter(this.adapter);
        $jacocoInit[26] = true;
        final int spanSize = getSpanSize(3);
        $jacocoInit[27] = true;
        this.layoutManager = new GridLayoutManager(getContext(), spanSize);
        $jacocoInit[28] = true;
        this.layoutManager.setSpanSizeLookup(new C0938c(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ ListStoreAppsFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(6091299439680395651L, "cm/aptoide/pt/view/app/ListStoreAppsFragment$1", 5);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public int getSpanSize(int position) {
                boolean[] $jacocoInit = $jacocoInit();
                if (ListStoreAppsFragment.access$000(this.this$0) == null) {
                    $jacocoInit[1] = true;
                } else if (!(ListStoreAppsFragment.access$000(this.this$0).getItem(position) instanceof AppLoading)) {
                    $jacocoInit[2] = true;
                } else {
                    int i = spanSize;
                    $jacocoInit[3] = true;
                    return i;
                }
                $jacocoInit[4] = true;
                return 1;
            }
        });
        $jacocoInit[29] = true;
        this.recyclerView.setLayoutManager(this.layoutManager);
        $jacocoInit[30] = true;
        this.startingLoadingLayout = (ProgressBar) view2.findViewById(C1375R.C1376id.progress_bar);
        $jacocoInit[31] = true;
        this.startingLoadingLayout.setVisibility(0);
        $jacocoInit[32] = true;
        this.recyclerView.mo7527a((C0980h) new C0980h(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ ListStoreAppsFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(6544352962933534338L, "cm/aptoide/pt/view/app/ListStoreAppsFragment$2", 6);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, C0997t state) {
                boolean[] $jacocoInit = $jacocoInit();
                if (this.this$0.getHost() == null) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    int margin = ScreenU.getPixelsForDip(5, this.this$0.getResources());
                    $jacocoInit[3] = true;
                    outRect.set(margin, margin, margin, margin);
                    $jacocoInit[4] = true;
                }
                $jacocoInit[5] = true;
            }
        });
        int limit = spanSize * 10;
        long j = this.storeId;
        $jacocoInit[33] = true;
        C0126V a = C14522a.m46170a();
        AppCenter appCenter2 = this.appCenter;
        $jacocoInit[34] = true;
        ListStoreAppsPresenter listStoreAppsPresenter = r0;
        ListStoreAppsPresenter listStoreAppsPresenter2 = new ListStoreAppsPresenter(this, j, a, appCenter2, CrashReport.getInstance(), this.listStoreAppsNavigator, limit);
        $jacocoInit[35] = true;
        attachPresenter(listStoreAppsPresenter);
        $jacocoInit[36] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17084b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.refreshEvent.onNext(null);
        $jacocoInit[95] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[37] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[38] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[39] = true;
        return build;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.listState = this.layoutManager.onSaveInstanceState();
        this.recyclerView = null;
        this.adapter = null;
        $jacocoInit[40] = true;
        this.layoutManager.setSpanSizeLookup(new C0936a());
        this.layoutManager = null;
        this.startingLoadingLayout = null;
        this.swipeRefreshLayout = null;
        this.appClicks = null;
        this.refreshEvent = null;
        $jacocoInit[41] = true;
        super.onDestroyView();
        $jacocoInit[42] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        setHasOptionsMenu(true);
        $jacocoInit[43] = true;
        View inflate = inflater.inflate(C1375R.layout.list_store_apps_fragment_layout, container, false);
        $jacocoInit[44] = true;
        return inflate;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        if (this.adapter == null) {
            $jacocoInit[45] = true;
        } else {
            $jacocoInit[46] = true;
            outState.putParcelable(LIST_STATE_KEY, this.layoutManager.onSaveInstanceState());
            $jacocoInit[47] = true;
        }
        $jacocoInit[48] = true;
    }

    public void addApps(List<Application> appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.addApps(appsList);
        $jacocoInit[49] = true;
        showApps();
        $jacocoInit[50] = true;
    }

    public C0120S<Application> getAppClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Application> cVar = this.appClicks;
        $jacocoInit[51] = true;
        return cVar;
    }

    public C0120S<Object> reachesBottom() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13024e.m42482a(this.recyclerView);
        $jacocoInit[52] = true;
        C0120S b = a.mo3628b();
        C5259aa aaVar = new C5259aa(this);
        $jacocoInit[53] = true;
        $jacocoInit[54] = true;
        C0120S<Object> a2 = b.mo3653d((C0132p<? super T, Boolean>) aaVar).mo3611a(Object.class);
        $jacocoInit[55] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo17082a(C13020a scroll) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(isEndReached());
        $jacocoInit[94] = true;
        return valueOf;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.hideLoading();
        $jacocoInit[56] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.showLoading();
        $jacocoInit[57] = true;
    }

    public C14963c<Void> getRefreshEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.refreshEvent;
        $jacocoInit[58] = true;
        return cVar;
    }

    public void hideRefreshLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.swipeRefreshLayout.setRefreshing(false);
        $jacocoInit[59] = true;
    }

    public void setApps(List<Application> applications) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.setApps(applications);
        Parcelable parcelable = this.listState;
        if (parcelable == null) {
            $jacocoInit[60] = true;
        } else {
            $jacocoInit[61] = true;
            this.layoutManager.onRestoreInstanceState(parcelable);
            this.listState = null;
            $jacocoInit[62] = true;
        }
        showApps();
        $jacocoInit[63] = true;
    }

    public void showNetworkError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.noNetworkErrorLayout.setVisibility(0);
        $jacocoInit[64] = true;
        this.startingLoadingLayout.setVisibility(8);
        $jacocoInit[65] = true;
        this.recyclerView.setVisibility(8);
        $jacocoInit[66] = true;
        this.genericErrorLayout.setVisibility(8);
        $jacocoInit[67] = true;
    }

    public void showGenericError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.genericErrorLayout.setVisibility(0);
        $jacocoInit[68] = true;
        this.startingLoadingLayout.setVisibility(8);
        $jacocoInit[69] = true;
        this.recyclerView.setVisibility(8);
        $jacocoInit[70] = true;
        this.noNetworkErrorLayout.setVisibility(8);
        $jacocoInit[71] = true;
    }

    public C0120S<Void> getRetryEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> b = C0120S.m649b(C13034a.m42490a(this.retryButton), C13034a.m42490a(this.noNetworkRetryButton));
        $jacocoInit[72] = true;
        return b;
    }

    public void showStartingLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.startingLoadingLayout.setVisibility(0);
        $jacocoInit[73] = true;
        this.recyclerView.setVisibility(8);
        $jacocoInit[74] = true;
        this.genericErrorLayout.setVisibility(8);
        $jacocoInit[75] = true;
        this.noNetworkErrorLayout.setVisibility(8);
        $jacocoInit[76] = true;
    }

    private void showApps() {
        boolean[] $jacocoInit = $jacocoInit();
        this.recyclerView.setVisibility(0);
        $jacocoInit[77] = true;
        this.startingLoadingLayout.setVisibility(8);
        $jacocoInit[78] = true;
        this.genericErrorLayout.setVisibility(8);
        $jacocoInit[79] = true;
        this.noNetworkErrorLayout.setVisibility(8);
        $jacocoInit[80] = true;
    }

    private boolean isEndReached() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.layoutManager.getItemCount() - this.layoutManager.findLastVisibleItemPosition() <= 5) {
            $jacocoInit[81] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[82] = true;
        }
        $jacocoInit[83] = true;
        return z;
    }

    public int getSpanSize(int defaultSpan) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[84] = true;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        $jacocoInit[85] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[86] = true;
        int screenWidthInDip = (int) ((ScreenU.getScreenWidthInDip(windowManager, resources) / 360.0f) * ((float) defaultSpan));
        $jacocoInit[87] = true;
        return screenWidthInDip;
    }

    public void setupToolbar(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        Toolbar toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[88] = true;
        ((C0019n) getActivity()).setSupportActionBar(toolbar);
        $jacocoInit[89] = true;
        C0760a actionBar = ((C0019n) getActivity()).getSupportActionBar();
        $jacocoInit[90] = true;
        actionBar.mo6153d(true);
        $jacocoInit[91] = true;
        toolbar.setTitle((int) C1375R.string.list_store_apps_fragment_title);
        $jacocoInit[92] = true;
        actionBar.mo6147a(toolbar.getTitle());
        $jacocoInit[93] = true;
    }
}
