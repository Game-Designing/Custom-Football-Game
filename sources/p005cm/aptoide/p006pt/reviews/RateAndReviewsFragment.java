package p005cm.aptoide.p006pt.reviews;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.p001v7.widget.RecyclerView.C0988n;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.List;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.comments.ListFullReviewsSuccessRequestListener;
import p005cm.aptoide.p006pt.comments.view.CommentDisplayable;
import p005cm.aptoide.p006pt.comments.view.CommentsAdapter;
import p005cm.aptoide.p006pt.comments.view.CommentsReadMoreDisplayable;
import p005cm.aptoide.p006pt.comments.view.ItemCommentAdderView;
import p005cm.aptoide.p006pt.comments.view.RateAndReviewCommentDisplayable;
import p005cm.aptoide.p006pt.comments.view.SimpleReviewCommentAdder;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetApp;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetApp.Nodes;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetAppRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListReviewsRequest;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.reviews.LanguageFilterHelper.LanguageFilter;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.view.ThemeUtils;
import p005cm.aptoide.p006pt.view.dialog.DialogUtils;
import p005cm.aptoide.p006pt.view.fragment.AptoideBaseFragment;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.ProgressBarDisplayable;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.reviews.RateAndReviewsFragment */
public class RateAndReviewsFragment extends AptoideBaseFragment<CommentsAdapter> implements ItemCommentAdderView<Review, CommentsAdapter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = RateAndReviewsFragment.class.getSimpleName();
    private AptoideAccountManager accountManager;
    private long appId;
    private String appName;
    @Inject
    AppNavigator appNavigator;
    private BodyInterceptor<BaseBody> baseBodyInterceptor;
    private Factory converterFactory;
    private DialogUtils dialogUtils;
    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;
    private OkHttpClient httpClient;
    private MenuItem installMenuItem;
    private InstalledRepository installedRepository;
    @Inject
    String marketName;
    @Inject
    MarketResourceFormatter marketResourceFormatter;
    private String packageName;
    private SharedPreferences preferences;
    private long reviewId;
    private ReviewsLanguageFilterDisplayable reviewsLanguageFilterDisplayable;
    private StoreCredentialsProvider storeCredentialsProvider;
    private String storeName;
    private String storeTheme;
    @Inject
    String theme;
    private TokenInvalidator tokenInvalidator;

    /* renamed from: cm.aptoide.pt.reviews.RateAndReviewsFragment$BundleCons */
    public static class BundleCons {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        public static final String APP_ID = "app_id";
        public static final String APP_NAME = "app_name";
        public static final String PACKAGE_NAME = "package_name";
        public static final String REVIEW_ID = "review_id";
        public static final String STORE_NAME = "store_name";
        public static final String STORE_THEME = "store_theme";

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(956410055638827092L, "cm/aptoide/pt/reviews/RateAndReviewsFragment$BundleCons", 1);
            $jacocoData = probes;
            return probes;
        }

        public BundleCons() {
            $jacocoInit()[0] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3679116817678450055L, "cm/aptoide/pt/reviews/RateAndReviewsFragment", Opcodes.IFGT);
        $jacocoData = probes;
        return probes;
    }

    public RateAndReviewsFragment() {
        $jacocoInit()[0] = true;
    }

    public /* bridge */ /* synthetic */ Displayable createReadMoreDisplayable(int i, Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        CommentsReadMoreDisplayable createReadMoreDisplayable = createReadMoreDisplayable(i, (Review) obj);
        $jacocoInit[124] = true;
        return createReadMoreDisplayable;
    }

    public /* bridge */ /* synthetic */ CommentsAdapter getAdapter() {
        CommentsAdapter commentsAdapter = (CommentsAdapter) super.getAdapter();
        $jacocoInit()[125] = true;
        return commentsAdapter;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[156] = true;
    }

    public static RateAndReviewsFragment newInstance(long appId2, String appName2, String storeName2, String packageName2, String storeTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        RateAndReviewsFragment fragment = new RateAndReviewsFragment();
        $jacocoInit[1] = true;
        Bundle args = new Bundle();
        $jacocoInit[2] = true;
        args.putLong(BundleCons.APP_ID, appId2);
        $jacocoInit[3] = true;
        args.putString("app_name", appName2);
        $jacocoInit[4] = true;
        args.putString("store_name", storeName2);
        $jacocoInit[5] = true;
        args.putString("package_name", packageName2);
        $jacocoInit[6] = true;
        args.putString(BundleCons.STORE_THEME, storeTheme2);
        $jacocoInit[7] = true;
        fragment.setArguments(args);
        $jacocoInit[8] = true;
        return fragment;
    }

    public static RateAndReviewsFragment newInstance(long appId2, String appName2, String storeName2, String packageName2, long reviewId2) {
        boolean[] $jacocoInit = $jacocoInit();
        RateAndReviewsFragment fragment = new RateAndReviewsFragment();
        $jacocoInit[9] = true;
        Bundle args = new Bundle();
        $jacocoInit[10] = true;
        args.putLong(BundleCons.APP_ID, appId2);
        $jacocoInit[11] = true;
        args.putString("app_name", appName2);
        $jacocoInit[12] = true;
        args.putString("store_name", storeName2);
        $jacocoInit[13] = true;
        args.putString("package_name", packageName2);
        $jacocoInit[14] = true;
        args.putLong(BundleCons.REVIEW_ID, reviewId2);
        $jacocoInit[15] = true;
        fragment.setArguments(args);
        $jacocoInit[16] = true;
        return fragment;
    }

    public long getReviewId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.reviewId;
        $jacocoInit[17] = true;
        return j;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[18] = true;
        return str;
    }

    public String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[19] = true;
        return str;
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
        inflater.inflate(C1375R.C1377menu.menu_install, menu);
        $jacocoInit[22] = true;
        this.installMenuItem = menu.findItem(C1375R.C1376id.menu_install);
        $jacocoInit[23] = true;
        C0120S installed = this.installedRepository.getInstalled(this.packageName);
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[24] = true;
        C0120S a = installed.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        C4637l lVar = new C4637l(this);
        C4638m mVar = C4638m.f8279a;
        $jacocoInit[25] = true;
        a.mo3626a((C0129b<? super T>) lVar, (C0129b<Throwable>) mVar);
        $jacocoInit[26] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15970a(Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installed == null) {
            $jacocoInit[152] = true;
        } else {
            $jacocoInit[153] = true;
            this.installMenuItem.setTitle(C1375R.string.reviewappview_button_open);
            $jacocoInit[154] = true;
        }
        $jacocoInit[155] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8995d(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[150] = true;
        instance.log(err);
        $jacocoInit[151] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            $jacocoInit[27] = true;
            getActivity().onBackPressed();
            $jacocoInit[28] = true;
            return true;
        } else if (itemId == C1375R.C1376id.menu_install) {
            $jacocoInit[29] = true;
            this.appNavigator.navigateWithPackageAndStoreNames(this.packageName, this.storeName, OpenType.OPEN_AND_INSTALL);
            $jacocoInit[30] = true;
            return true;
        } else {
            boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
            $jacocoInit[31] = true;
            return onOptionsItemSelected;
        }
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[32] = true;
        this.appId = args.getLong(BundleCons.APP_ID);
        $jacocoInit[33] = true;
        this.reviewId = args.getLong(BundleCons.REVIEW_ID);
        $jacocoInit[34] = true;
        this.packageName = args.getString("package_name");
        $jacocoInit[35] = true;
        this.storeName = args.getString("store_name");
        $jacocoInit[36] = true;
        this.appName = args.getString("app_name");
        $jacocoInit[37] = true;
        this.storeTheme = args.getString(BundleCons.STORE_THEME);
        $jacocoInit[38] = true;
    }

    public int getContentViewId() {
        $jacocoInit()[39] = true;
        return C1375R.layout.fragment_rate_and_reviews;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[40] = true;
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C1375R.C1376id.fab);
        $jacocoInit[41] = true;
        C0120S a = C13034a.m42490a(floatingActionButton);
        C4634i iVar = new C4634i(this);
        $jacocoInit[42] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) iVar);
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[43] = true;
        C0120S a2 = f.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        C4629d dVar = C4629d.f8269a;
        C4636k kVar = C4636k.f8277a;
        $jacocoInit[44] = true;
        a2.mo3626a((C0129b<? super T>) dVar, (C0129b<Throwable>) kVar);
        $jacocoInit[45] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15969a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showRateDialog = this.dialogUtils.showRateDialog(getActivity(), this.appName, this.packageName, this.storeName);
        $jacocoInit[149] = true;
        return showRateDialog;
    }

    /* renamed from: a */
    static /* synthetic */ void m8991a(EResponse __) {
        $jacocoInit()[148] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8992a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[146] = true;
        instance.log(err);
        $jacocoInit[147] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        ThemeUtils.setStatusBarThemeColor(getActivity(), this.theme);
        $jacocoInit[46] = true;
        ThemeUtils.setStoreTheme(getActivity(), this.theme);
        $jacocoInit[47] = true;
        super.onDestroyView();
        $jacocoInit[48] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        if (this.storeTheme == null) {
            $jacocoInit[49] = true;
        } else {
            $jacocoInit[50] = true;
            ThemeUtils.setStatusBarThemeColor(getActivity(), this.storeTheme);
            $jacocoInit[51] = true;
            ThemeUtils.setStoreTheme(getActivity(), this.storeTheme);
            $jacocoInit[52] = true;
        }
        $jacocoInit[53] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.load(create, refresh, savedInstanceState);
        $jacocoInit[54] = true;
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Other versions should refresh? ");
        sb.append(create);
        String sb2 = sb.toString();
        $jacocoInit[55] = true;
        instance.mo2136d(str, sb2);
        $jacocoInit[56] = true;
        fetchRating(refresh);
        $jacocoInit[57] = true;
    }

    public void onViewCreated() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated();
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        $jacocoInit[58] = true;
        AccountNavigator accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        InstalledRepository installedRepository2 = this.installedRepository;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[59] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[60] = true;
        DialogUtils dialogUtils2 = new DialogUtils(aptoideAccountManager, accountNavigator, bodyInterceptor, okHttpClient, factory, installedRepository2, tokenInvalidator2, defaultSharedPreferences, getContext().getResources(), this.marketName, this.marketResourceFormatter);
        this.dialogUtils = dialogUtils2;
        $jacocoInit[61] = true;
    }

    private void fetchRating(boolean refresh) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyInterceptor;
        long j = this.appId;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[62] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[63] = true;
        GetAppRequest of = GetAppRequest.m7461of(str, bodyInterceptor, j, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences);
        SharedPreferences sharedPreferences = this.preferences;
        $jacocoInit[64] = true;
        C0120S observe = of.observe(refresh, ManagerPreferences.getAndResetForceServerRefresh(sharedPreferences));
        $jacocoInit[65] = true;
        C0120S b = observe.mo3634b(Schedulers.m776io());
        $jacocoInit[66] = true;
        C0120S a = b.mo3616a(C14522a.m46170a());
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[67] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        C4635j jVar = new C4635j(this);
        C4631f fVar = C4631f.f8271a;
        $jacocoInit[68] = true;
        a2.mo3626a((C0129b<? super T>) jVar, (C0129b<Throwable>) fVar);
        $jacocoInit[69] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15971a(GetApp getApp) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!getApp.isOk()) {
            $jacocoInit[135] = true;
        } else {
            $jacocoInit[136] = true;
            Nodes nodes = getApp.getNodes();
            $jacocoInit[137] = true;
            GetAppMeta meta = nodes.getMeta();
            $jacocoInit[138] = true;
            App data = meta.getData();
            $jacocoInit[139] = true;
            setupTitle(data.getName());
            $jacocoInit[140] = true;
            addDisplayable(0, (Displayable) new ReviewsRatingDisplayable(data), true);
            $jacocoInit[141] = true;
            ReviewsLanguageFilterDisplayable reviewsLanguageFilterDisplayable2 = new ReviewsLanguageFilterDisplayable(new C4632g(this));
            this.reviewsLanguageFilterDisplayable = reviewsLanguageFilterDisplayable2;
            addDisplayable(reviewsLanguageFilterDisplayable2);
            $jacocoInit[142] = true;
        }
        finishLoading();
        $jacocoInit[143] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15972a(LanguageFilter languageFilter) {
        boolean[] $jacocoInit = $jacocoInit();
        removeDisplayables(1, getDisplayablesSize() - 1);
        $jacocoInit[144] = true;
        fetchReviews(languageFilter);
        $jacocoInit[145] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8993b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[133] = true;
        instance.log(err);
        $jacocoInit[134] = true;
    }

    /* access modifiers changed from: 0000 */
    public void fetchReviews(LanguageFilter languageFilter) {
        boolean[] $jacocoInit = $jacocoInit();
        addDisplayable(this.reviewsLanguageFilterDisplayable);
        $jacocoInit[70] = true;
        ListReviewsRequest reviewsRequest = createListReviewsRequest(languageFilter.getValue());
        $jacocoInit[71] = true;
        getRecyclerView().mo7549b((C0988n) this.endlessRecyclerOnScrollListener);
        $jacocoInit[72] = true;
        BaseAdapter adapter = getAdapter();
        $jacocoInit[73] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[74] = true;
        $jacocoInit[75] = true;
        StoreCredentialsProviderImpl storeCredentialsProviderImpl = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[76] = true;
        ListFullReviewsSuccessRequestListener listFullReviewsSuccessRequestListener = new ListFullReviewsSuccessRequestListener(this, storeCredentialsProviderImpl, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
        this.endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(adapter, reviewsRequest, listFullReviewsSuccessRequestListener, C4630e.f8270a);
        $jacocoInit[77] = true;
        this.endlessRecyclerOnScrollListener.addOnEndlessFinishListener(new C4633h(this, languageFilter));
        $jacocoInit[78] = true;
        getRecyclerView().mo7530a((C0988n) this.endlessRecyclerOnScrollListener);
        $jacocoInit[79] = true;
        this.endlessRecyclerOnScrollListener.onLoadMore(false, false);
        $jacocoInit[80] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8994c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[132] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15973a(LanguageFilter languageFilter, EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener1) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!languageFilter.hasMoreCountryCodes()) {
            $jacocoInit[126] = true;
        } else {
            $jacocoInit[127] = true;
            EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener2 = this.endlessRecyclerOnScrollListener;
            LanguageFilter inc = languageFilter.inc();
            $jacocoInit[128] = true;
            String value = inc.getValue();
            $jacocoInit[129] = true;
            endlessRecyclerOnScrollListener2.reset(createListReviewsRequest(value));
            $jacocoInit[130] = true;
        }
        $jacocoInit[131] = true;
    }

    private ListReviewsRequest createListReviewsRequest(String languagesFilterSort) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        String str2 = this.packageName;
        StoreCredentials storeCredentials = this.storeCredentialsProvider.get(str);
        BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[81] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[82] = true;
        ListReviewsRequest of = ListReviewsRequest.m7476of(str, str2, storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences, languagesFilterSort);
        $jacocoInit[83] = true;
        return of;
    }

    public void setupTitle(String title) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!hasToolbar()) {
            $jacocoInit[84] = true;
        } else {
            $jacocoInit[85] = true;
            getToolbar().setTitle((CharSequence) title);
            $jacocoInit[86] = true;
        }
        $jacocoInit[87] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[88] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[89] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[90] = true;
        return build;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[91] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[92] = true;
        this.preferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[93] = true;
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[94] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[95] = true;
        this.installedRepository = RepositoryFactory.getInstalledRepository(getContext().getApplicationContext());
        $jacocoInit[96] = true;
        this.baseBodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[97] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[98] = true;
        $jacocoInit[99] = true;
        this.storeCredentialsProvider = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[100] = true;
        this.installedRepository = RepositoryFactory.getInstalledRepository(getContext().getApplicationContext());
        $jacocoInit[101] = true;
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[102] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[103] = true;
        setHasOptionsMenu(true);
        $jacocoInit[104] = true;
    }

    public CommentsReadMoreDisplayable createReadMoreDisplayable(int itemPosition, Review review) {
        boolean[] $jacocoInit = $jacocoInit();
        long id = review.getId();
        ListComments commentList = review.getCommentList();
        $jacocoInit[105] = true;
        DataList dataList = commentList.getDataList();
        $jacocoInit[106] = true;
        CommentsReadMoreDisplayable commentsReadMoreDisplayable = new CommentsReadMoreDisplayable(id, true, dataList.getNext(), new SimpleReviewCommentAdder(itemPosition, this));
        $jacocoInit[107] = true;
        return commentsReadMoreDisplayable;
    }

    /* access modifiers changed from: protected */
    public CommentsAdapter createAdapter() {
        boolean[] $jacocoInit = $jacocoInit();
        CommentsAdapter commentsAdapter = new CommentsAdapter(RateAndReviewCommentDisplayable.class);
        $jacocoInit[108] = true;
        return commentsAdapter;
    }

    public void createDisplayableComments(List<Comment> comments, List<Displayable> displayables) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[109] = true;
        for (Comment comment : comments) {
            $jacocoInit[110] = true;
            FragmentNavigator fragmentNavigator = getFragmentNavigator();
            $jacocoInit[111] = true;
            AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
            CommentDisplayable commentDisplayable = new CommentDisplayable(comment, fragmentNavigator, AptoideApplication.getFragmentProvider());
            $jacocoInit[112] = true;
            displayables.add(commentDisplayable);
            $jacocoInit[113] = true;
        }
        $jacocoInit[114] = true;
    }

    public void checkAndRemoveProgressBarDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[115] = true;
        while (i < ((CommentsAdapter) getAdapter()).getItemCount()) {
            $jacocoInit[116] = true;
            if (!(((CommentsAdapter) getAdapter()).getDisplayable(i) instanceof ProgressBarDisplayable)) {
                $jacocoInit[117] = true;
            } else {
                $jacocoInit[118] = true;
                ((CommentsAdapter) getAdapter()).removeDisplayable(i);
                $jacocoInit[119] = true;
                ((CommentsAdapter) getAdapter()).notifyItemRemoved(i);
                $jacocoInit[120] = true;
            }
            i++;
            $jacocoInit[121] = true;
        }
        $jacocoInit[122] = true;
    }
}
