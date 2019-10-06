package p005cm.aptoide.p006pt.store.view;

import android.os.Bundle;
import android.support.p001v7.widget.RecyclerView.C0988n;
import android.support.p001v7.widget.Toolbar;
import android.view.MenuItem;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.ListStores;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.ListStoresRequest;
import p005cm.aptoide.p006pt.repository.request.RequestFactory;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.view.fragment.AptoideBaseFragment;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.store.view.FragmentTopStores */
public class FragmentTopStores extends AptoideBaseFragment<BaseAdapter> implements Endless {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int STORES_LIMIT_PER_REQUEST = 10;
    public static String TAG = FragmentTopStores.class.getSimpleName();
    @Inject
    AnalyticsManager analyticsManager;
    private SuccessRequestListener<ListStores> listener;
    @Inject
    NavigationTracker navigationTracker;
    private int offset = 0;
    private StoreAnalytics storeAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3145161904798931661L, "cm/aptoide/pt/store/view/FragmentTopStores", 45);
        $jacocoData = probes;
        return probes;
    }

    public FragmentTopStores() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.listener = new C4946C(this);
        $jacocoInit[1] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[44] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16484a(ListStores listStores) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m633a((Callable<? extends T>) new C4948E<Object>(this, listStores));
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[37] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        C4947D d = new C4947D(this);
        C4950G g = C4950G.f8601a;
        $jacocoInit[38] = true;
        a2.mo3626a((C0129b<? super T>) d, (C0129b<Throwable>) g);
        $jacocoInit[39] = true;
    }

    /* renamed from: b */
    public /* synthetic */ List mo16486b(ListStores listStores) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        List createDisplayables = createDisplayables(listStores);
        $jacocoInit[43] = true;
        return createDisplayables;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16485a(List displayables) {
        boolean[] $jacocoInit = $jacocoInit();
        addDisplayables(displayables);
        $jacocoInit[42] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9299b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[40] = true;
        instance.log(err);
        $jacocoInit[41] = true;
    }

    public static FragmentTopStores newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentTopStores fragmentTopStores = new FragmentTopStores();
        $jacocoInit[2] = true;
        return fragmentTopStores;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[3] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[4] = true;
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        $jacocoInit[5] = true;
        setHasOptionsMenu(true);
        $jacocoInit[6] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[7] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[8] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[9] = true;
        return build;
    }

    private List<Displayable> createDisplayables(ListStores listStores) {
        boolean[] $jacocoInit = $jacocoInit();
        List<Displayable> displayables = new ArrayList<>();
        $jacocoInit[10] = true;
        DataList dataList = listStores.getDataList();
        $jacocoInit[11] = true;
        List<Store> list = dataList.getList();
        $jacocoInit[12] = true;
        $jacocoInit[13] = true;
        for (Store store : list) {
            $jacocoInit[14] = true;
            displayables.add(new GridStoreDisplayable(store, "Add Store Dialog Top Stores", this.storeAnalytics));
            $jacocoInit[15] = true;
        }
        $jacocoInit[16] = true;
        return displayables;
    }

    public int getContentViewId() {
        $jacocoInit()[17] = true;
        return C1375R.layout.fragment_with_toolbar_no_theme;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViews();
        $jacocoInit[18] = true;
        setupToolbar();
        $jacocoInit[19] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.load(create, refresh, savedInstanceState);
        $jacocoInit[20] = true;
        fetchStores();
        $jacocoInit[21] = true;
    }

    private void fetchStores() {
        boolean[] $jacocoInit = $jacocoInit();
        RequestFactory requestFactory = this.requestFactoryCdnPool;
        int i = this.offset;
        $jacocoInit[22] = true;
        ListStoresRequest listStoresRequest = requestFactory.newListStoresRequest(i, 10);
        $jacocoInit[23] = true;
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(getAdapter(), listStoresRequest, this.listener, C4949F.f8600a);
        $jacocoInit[24] = true;
        getRecyclerView().mo7530a((C0988n) endlessRecyclerOnScrollListener);
        $jacocoInit[25] = true;
        endlessRecyclerOnScrollListener.onLoadMore(false, false);
        $jacocoInit[26] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9298a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        err.printStackTrace();
        $jacocoInit[36] = true;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[27] = true;
        return true;
    }

    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        toolbar.setTitle((int) C1375R.string.top_stores_fragment_title);
        $jacocoInit[28] = true;
        toolbar.setLogo((int) C1375R.drawable.logo_toolbar);
        $jacocoInit[29] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[30] = true;
            getActivity().onBackPressed();
            $jacocoInit[31] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[32] = true;
        return onOptionsItemSelected;
    }

    public int getOffset() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.offset;
        $jacocoInit[33] = true;
        return i;
    }

    public void setOffset(int offset2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.offset = offset2;
        $jacocoInit[34] = true;
    }

    public Integer getLimit() {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(10);
        $jacocoInit[35] = true;
        return valueOf;
    }
}
