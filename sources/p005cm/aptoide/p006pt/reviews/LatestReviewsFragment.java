package p005cm.aptoide.p006pt.reviews;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.p001v7.widget.RecyclerView.C0988n;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.FullReview;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListFullReviews;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListFullReviewsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeFragment;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.reviews.LatestReviewsFragment */
public class LatestReviewsFragment extends GridRecyclerSwipeFragment {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int REVIEWS_LIMIT = 25;
    private static final String STORE_CONTEXT = "STORE_CONTEXT";
    private static final String STORE_ID = "storeId";
    @Inject
    AnalyticsManager analyticsManager;
    private BodyInterceptor<BaseBody> baseBodyInterceptor;
    private Factory converterFactory;
    private List<Displayable> displayables;
    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;
    private OkHttpClient httpClient;
    @Inject
    NavigationTracker navigationTracker;
    private StoreAnalytics storeAnalytics;
    private StoreContext storeContext;
    private StoreCredentialsProvider storeCredentialsProvider;
    private long storeId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8770904548999040739L, "cm/aptoide/pt/reviews/LatestReviewsFragment", 52);
        $jacocoData = probes;
        return probes;
    }

    public LatestReviewsFragment() {
        $jacocoInit()[0] = true;
    }

    public static LatestReviewsFragment newInstance(long storeId2, StoreContext storeContext2) {
        boolean[] $jacocoInit = $jacocoInit();
        LatestReviewsFragment fragment = new LatestReviewsFragment();
        $jacocoInit[1] = true;
        Bundle args = new Bundle();
        $jacocoInit[2] = true;
        args.putLong("storeId", storeId2);
        $jacocoInit[3] = true;
        args.putSerializable("STORE_CONTEXT", storeContext2);
        $jacocoInit[4] = true;
        fragment.setArguments(args);
        $jacocoInit[5] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[6] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[7] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[8] = true;
        $jacocoInit[9] = true;
        this.storeCredentialsProvider = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[10] = true;
        this.baseBodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[11] = true;
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[12] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[13] = true;
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        $jacocoInit[14] = true;
        setHasOptionsMenu(true);
        $jacocoInit[15] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[16] = true;
        String simpleName = cls.getSimpleName();
        StoreContext storeContext2 = this.storeContext;
        if (storeContext2 != null) {
            str = storeContext2.name();
            $jacocoInit[17] = true;
        } else {
            str = null;
            $jacocoInit[18] = true;
        }
        ScreenTagHistory build = Builder.build(simpleName, "", str);
        $jacocoInit[19] = true;
        return build;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[20] = true;
        return true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[21] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[22] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[23] = true;
            getActivity().onBackPressed();
            $jacocoInit[24] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[25] = true;
        return onOptionsItemSelected;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[26] = true;
        this.storeId = args.getLong("storeId", -1);
        $jacocoInit[27] = true;
        this.storeContext = (StoreContext) args.getSerializable("STORE_CONTEXT");
        $jacocoInit[28] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[29] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean z = refresh;
        boolean[] $jacocoInit = $jacocoInit();
        super.load(create, refresh, savedInstanceState);
        if (create) {
            $jacocoInit[30] = true;
        } else if (z) {
            $jacocoInit[31] = true;
        } else {
            getRecyclerView().mo7530a((C0988n) this.endlessRecyclerOnScrollListener);
            $jacocoInit[42] = true;
            $jacocoInit[43] = true;
        }
        long j = this.storeId;
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[32] = true;
        StoreCredentials storeCredentials = StoreUtils.getStoreCredentials(j, storeCredentialsProvider2);
        BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        $jacocoInit[33] = true;
        TokenInvalidator tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[34] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[35] = true;
        ListFullReviewsRequest listFullReviewsRequest = ListFullReviewsRequest.m7473of(j, 25, 0, storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator, defaultSharedPreferences);
        $jacocoInit[36] = true;
        C4628c cVar = new C4628c(this);
        $jacocoInit[37] = true;
        getRecyclerView().mo7557c();
        $jacocoInit[38] = true;
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener2 = new EndlessRecyclerOnScrollListener(getAdapter(), listFullReviewsRequest, cVar, C4627b.f8267a, true, refresh);
        this.endlessRecyclerOnScrollListener = endlessRecyclerOnScrollListener2;
        $jacocoInit[39] = true;
        getRecyclerView().mo7530a((C0988n) this.endlessRecyclerOnScrollListener);
        $jacocoInit[40] = true;
        this.endlessRecyclerOnScrollListener.onLoadMore(z, z);
        $jacocoInit[41] = true;
        $jacocoInit[43] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15966a(ListFullReviews listTopFullReviews) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = listTopFullReviews.getDataList();
        $jacocoInit[45] = true;
        List<FullReview> reviews = dataList.getList();
        $jacocoInit[46] = true;
        this.displayables = new LinkedList();
        $jacocoInit[47] = true;
        $jacocoInit[48] = true;
        for (FullReview review : reviews) {
            $jacocoInit[49] = true;
            this.displayables.add(new RowReviewDisplayable(review, this.storeAnalytics));
            $jacocoInit[50] = true;
        }
        addDisplayables(this.displayables);
        $jacocoInit[51] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8989a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        err.printStackTrace();
        $jacocoInit[44] = true;
    }
}
