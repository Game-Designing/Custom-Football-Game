package p005cm.aptoide.p006pt.store.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.p000v4.app.C0478k;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.view.C0642s;
import android.support.p000v4.view.ViewPager.C0600i;
import android.support.p001v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.astuetz.PagerSlidingTabStrip;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.List;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV7Exception;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Error;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Name;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHome;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHomeMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHomeMeta.Data;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStore;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreTabs;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreTabs.Tab;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.HomeUser;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Urls;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.StoreUserAbstraction;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.StoreUserAbstraction.Nodes;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetHomeRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.search.SearchNavigator;
import p005cm.aptoide.p006pt.search.SuggestionCursorAdapter;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.search.suggestions.TrendingManager;
import p005cm.aptoide.p006pt.search.view.AppSearchSuggestionsView;
import p005cm.aptoide.p006pt.search.view.SearchSuggestionsPresenter;
import p005cm.aptoide.p006pt.share.ShareStoreHelper;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreError;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.view.ThemeUtils;
import p005cm.aptoide.p006pt.view.custom.AptoideViewPager;
import p005cm.aptoide.p006pt.view.fragment.BasePagerToolbarFragment;
import p019d.p022i.p296a.p298b.p303c.p304a.C13026g;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;
import p026rx.p387a.p389b.C14522a;
import p026rx.p398d.C14908d;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.store.view.StoreFragment */
public class StoreFragment extends BasePagerToolbarFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.STORES;
    private final int PRIVATE_STORE_REQUEST_CODE = 20;
    private AptoideAccountManager accountManager;
    @Inject
    AnalyticsManager analyticsManager;
    @Inject
    AppNavigator appNavigator;
    private AppSearchSuggestionsView appSearchSuggestionsView;
    private BodyInterceptor<BaseBody> bodyInterceptor;
    private BottomNavigationActivity bottomNavigationActivity;
    private Factory converterFactory;
    private CrashReport crashReport;
    private Name defaultTab;
    private OkHttpClient httpClient;
    private String iconPath;
    @Inject
    String marketName;
    @Inject
    MarketResourceFormatter marketResourceFormatter;
    @Inject
    NavigationTracker navigationTracker;
    private OpenType openType;
    C0600i pageChangeListener;
    protected PagerSlidingTabStrip pagerSlidingTabStrip;
    private Runnable registerViewpagerCurrentItem;
    private SearchAnalytics searchAnalytics;
    private SearchNavigator searchNavigator;
    private ShareStoreHelper shareStoreHelper;
    private SharedPreferences sharedPreferences;
    private StoreAnalytics storeAnalytics;
    private StoreContext storeContext;
    private StoreCredentialsProvider storeCredentialsProvider;
    private Long storeId;
    private String storeName;
    private String storeTheme;
    private String storeUrl;
    private List<Tab> tabs;
    @Inject
    String theme;
    private String title;
    private TokenInvalidator tokenInvalidator;
    private TrendingManager trendingManager;
    private Long userId;

    /* renamed from: cm.aptoide.pt.store.view.StoreFragment$3 */
    static /* synthetic */ class C49693 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$store$StoreError = new int[StoreError.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$store$view$StoreFragment$OpenType = new int[OpenType.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$utils$GenericDialogs$EResponse = new int[EResponse.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(4160843495211668269L, "cm/aptoide/pt/store/view/StoreFragment$3", 20);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$utils$GenericDialogs$EResponse[EResponse.NO.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        $jacocoInit[6] = true;
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$utils$GenericDialogs$EResponse[EResponse.YES.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$utils$GenericDialogs$EResponse[EResponse.CANCEL.ordinal()] = 3;
            $jacocoInit[5] = true;
            try {
                $jacocoInit[7] = true;
                $SwitchMap$cm$aptoide$pt$store$StoreError[StoreError.PRIVATE_STORE_ERROR.ordinal()] = 1;
                $jacocoInit[8] = true;
            } catch (NoSuchFieldError e4) {
                try {
                    $jacocoInit[9] = true;
                } catch (NoSuchFieldError e5) {
                    try {
                        $jacocoInit[11] = true;
                    } catch (NoSuchFieldError e6) {
                        $jacocoInit[13] = true;
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$store$StoreError[StoreError.PRIVATE_STORE_WRONG_CREDENTIALS.ordinal()] = 2;
            $jacocoInit[10] = true;
            $SwitchMap$cm$aptoide$pt$store$StoreError[StoreError.STORE_SUSPENDED.ordinal()] = 3;
            $jacocoInit[12] = true;
            try {
                $jacocoInit[14] = true;
                $SwitchMap$cm$aptoide$pt$store$view$StoreFragment$OpenType[OpenType.GetHome.ordinal()] = 1;
                $jacocoInit[15] = true;
            } catch (NoSuchFieldError e7) {
                try {
                    $jacocoInit[16] = true;
                } catch (NoSuchFieldError e8) {
                    $jacocoInit[18] = true;
                }
            }
            $SwitchMap$cm$aptoide$pt$store$view$StoreFragment$OpenType[OpenType.GetStore.ordinal()] = 2;
            $jacocoInit[17] = true;
            $jacocoInit[19] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.store.view.StoreFragment$BundleKeys */
    private enum BundleKeys {
        STORE_NAME,
        STORE_CONTEXT,
        STORE_THEME,
        DEFAULT_TAB_TO_OPEN,
        USER_ID,
        OPEN_TYPE;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.store.view.StoreFragment$OpenType */
    public enum OpenType {
        GetHome,
        GetStore;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8928805913093238092L, "cm/aptoide/pt/store/view/StoreFragment", 288);
        $jacocoData = probes;
        return probes;
    }

    public StoreFragment() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.pageChangeListener = new C0600i(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ StoreFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-922104452046541827L, "cm/aptoide/pt/store/view/StoreFragment$1", 7);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onPageSelected(int position) {
                boolean[] $jacocoInit = $jacocoInit();
                if (position != 0) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    NavigationTracker navigationTracker = this.this$0.navigationTracker;
                    Class cls = getClass();
                    $jacocoInit[3] = true;
                    String simpleName = cls.getSimpleName();
                    String name = StoreFragment.access$000(this.this$0).name();
                    $jacocoInit[4] = true;
                    navigationTracker.registerScreen(Builder.build(simpleName, "home", name));
                    $jacocoInit[5] = true;
                }
                $jacocoInit[6] = true;
            }
        };
        $jacocoInit[1] = true;
    }

    static /* synthetic */ StoreContext access$000(StoreFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreContext storeContext2 = x0.storeContext;
        $jacocoInit[283] = true;
        return storeContext2;
    }

    static /* synthetic */ AptoideViewPager access$100(StoreFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideViewPager aptoideViewPager = x0.viewPager;
        $jacocoInit[284] = true;
        return aptoideViewPager;
    }

    static /* synthetic */ String access$200(StoreFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = x0.storeName;
        $jacocoInit[285] = true;
        return str;
    }

    static /* synthetic */ StoreAnalytics access$300(StoreFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreAnalytics storeAnalytics2 = x0.storeAnalytics;
        $jacocoInit[286] = true;
        return storeAnalytics2;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[287] = true;
    }

    public static StoreFragment newInstance(long userId2, String storeTheme2, OpenType openType2) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreFragment newInstance = newInstance(userId2, storeTheme2, (Name) null, openType2);
        $jacocoInit[2] = true;
        return newInstance;
    }

    public static StoreFragment newInstance(long userId2, String storeTheme2, Name defaultTab2, OpenType openType2) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[3] = true;
        args.putLong(BundleKeys.USER_ID.name(), userId2);
        $jacocoInit[4] = true;
        args.putSerializable(BundleKeys.STORE_CONTEXT.name(), StoreContext.meta);
        $jacocoInit[5] = true;
        args.putSerializable(BundleKeys.OPEN_TYPE.name(), openType2);
        $jacocoInit[6] = true;
        args.putString(BundleKeys.STORE_THEME.name(), storeTheme2);
        $jacocoInit[7] = true;
        args.putSerializable(BundleKeys.DEFAULT_TAB_TO_OPEN.name(), defaultTab2);
        $jacocoInit[8] = true;
        StoreFragment fragment = new StoreFragment();
        $jacocoInit[9] = true;
        fragment.setArguments(args);
        $jacocoInit[10] = true;
        return fragment;
    }

    public static StoreFragment newInstance(String storeName2, String storeTheme2, Name defaultTab2, OpenType openType2) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreFragment storeFragment = newInstance(storeName2, storeTheme2, openType2);
        $jacocoInit[11] = true;
        Bundle arguments = storeFragment.getArguments();
        BundleKeys bundleKeys = BundleKeys.DEFAULT_TAB_TO_OPEN;
        $jacocoInit[12] = true;
        arguments.putSerializable(bundleKeys.name(), defaultTab2);
        $jacocoInit[13] = true;
        return storeFragment;
    }

    public static StoreFragment newInstance(String storeName2, String storeTheme2, OpenType openType2) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[14] = true;
        args.putString(BundleKeys.STORE_NAME.name(), storeName2);
        $jacocoInit[15] = true;
        args.putSerializable(BundleKeys.OPEN_TYPE.name(), openType2);
        $jacocoInit[16] = true;
        args.putSerializable(BundleKeys.STORE_CONTEXT.name(), StoreContext.meta);
        $jacocoInit[17] = true;
        args.putString(BundleKeys.STORE_THEME.name(), storeTheme2);
        $jacocoInit[18] = true;
        StoreFragment fragment = new StoreFragment();
        $jacocoInit[19] = true;
        fragment.setArguments(args);
        $jacocoInit[20] = true;
        return fragment;
    }

    public static StoreFragment newInstance(String storeName2, String storeTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreFragment newInstance = newInstance(storeName2, storeTheme2, OpenType.GetStore);
        $jacocoInit[21] = true;
        return newInstance;
    }

    public ScreenTagHistory getHistoryTracker() {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[22] = true;
        String simpleName = cls.getSimpleName();
        StoreContext storeContext2 = this.storeContext;
        if (storeContext2 != null) {
            str = storeContext2.name();
            $jacocoInit[23] = true;
        } else {
            str = null;
            $jacocoInit[24] = true;
        }
        ScreenTagHistory build = Builder.build(simpleName, "", str);
        $jacocoInit[25] = true;
        return build;
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        if (!(activity instanceof BottomNavigationActivity)) {
            $jacocoInit[26] = true;
        } else {
            this.bottomNavigationActivity = (BottomNavigationActivity) activity;
            $jacocoInit[27] = true;
        }
        $jacocoInit[28] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        $jacocoInit[29] = true;
        ThemeUtils.setStatusBarThemeColor(getActivity(), this.theme);
        $jacocoInit[30] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[31] = true;
        if (!hasSearchFromStoreFragment()) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            inflater.inflate(C1375R.C1377menu.fragment_store, menu);
            $jacocoInit[34] = true;
            MenuItem menuItem = menu.findItem(C1375R.C1376id.menu_item_search);
            AppSearchSuggestionsView appSearchSuggestionsView2 = this.appSearchSuggestionsView;
            if (appSearchSuggestionsView2 == null) {
                $jacocoInit[35] = true;
            } else if (menuItem == null) {
                $jacocoInit[36] = true;
            } else {
                $jacocoInit[37] = true;
                appSearchSuggestionsView2.initialize(menuItem);
                $jacocoInit[38] = true;
            }
            if (menuItem != null) {
                $jacocoInit[39] = true;
                menuItem.setVisible(false);
                $jacocoInit[40] = true;
            } else {
                menu.removeItem(C1375R.C1376id.menu_item_search);
                $jacocoInit[41] = true;
            }
        }
        $jacocoInit[42] = true;
    }

    public void onDetach() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationActivity = null;
        $jacocoInit[43] = true;
        super.onDetach();
        $jacocoInit[44] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[45] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[46] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[47] = true;
        this.tokenInvalidator = application.getTokenInvalidator();
        $jacocoInit[48] = true;
        this.storeCredentialsProvider = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(application.getDatabase(), Store.class));
        $jacocoInit[49] = true;
        this.accountManager = application.getAccountManager();
        $jacocoInit[50] = true;
        this.bodyInterceptor = application.getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[51] = true;
        this.httpClient = application.getDefaultClient();
        $jacocoInit[52] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[53] = true;
        this.sharedPreferences = application.getDefaultSharedPreferences();
        $jacocoInit[54] = true;
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        $jacocoInit[55] = true;
        this.shareStoreHelper = new ShareStoreHelper(getActivity(), this.marketResourceFormatter);
        $jacocoInit[56] = true;
        if (!hasSearchFromStoreFragment()) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            this.searchAnalytics = new SearchAnalytics(this.analyticsManager, this.navigationTracker);
            $jacocoInit[59] = true;
            this.searchNavigator = new SearchNavigator(getFragmentNavigator(), this.storeName, this.storeTheme, this.appNavigator);
            $jacocoInit[60] = true;
            this.trendingManager = application.getTrendingManager();
            $jacocoInit[61] = true;
            this.crashReport = CrashReport.getInstance();
            $jacocoInit[62] = true;
        }
        setHasOptionsMenu(true);
        $jacocoInit[63] = true;
    }

    public void loadExtras(Bundle args) {
        OpenType openType2;
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[64] = true;
        this.storeName = args.getString(BundleKeys.STORE_NAME.name());
        $jacocoInit[65] = true;
        this.storeContext = (StoreContext) args.get(BundleKeys.STORE_CONTEXT.name());
        $jacocoInit[66] = true;
        if (args.containsKey(BundleKeys.OPEN_TYPE.name())) {
            BundleKeys bundleKeys = BundleKeys.OPEN_TYPE;
            $jacocoInit[67] = true;
            String name = bundleKeys.name();
            $jacocoInit[68] = true;
            openType2 = (OpenType) args.get(name);
            $jacocoInit[69] = true;
        } else {
            openType2 = OpenType.GetStore;
            $jacocoInit[70] = true;
        }
        this.openType = openType2;
        $jacocoInit[71] = true;
        this.storeTheme = args.getString(BundleKeys.STORE_THEME.name());
        $jacocoInit[72] = true;
        this.defaultTab = (Name) args.get(BundleKeys.DEFAULT_TAB_TO_OPEN.name());
        $jacocoInit[73] = true;
        if (!args.containsKey(BundleKeys.USER_ID.name())) {
            $jacocoInit[74] = true;
        } else {
            $jacocoInit[75] = true;
            this.userId = Long.valueOf(args.getLong(BundleKeys.USER_ID.name()));
            $jacocoInit[76] = true;
        }
        $jacocoInit[77] = true;
    }

    /* access modifiers changed from: protected */
    public boolean hasSearchFromStoreFragment() {
        $jacocoInit()[78] = true;
        return true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        ThemeUtils.setStatusBarThemeColor(getActivity(), this.theme);
        $jacocoInit[79] = true;
        ThemeUtils.setAptoideTheme(getActivity(), this.theme);
        $jacocoInit[80] = true;
        ThemeUtils.setStoreTheme(getActivity(), this.theme);
        PagerSlidingTabStrip pagerSlidingTabStrip2 = this.pagerSlidingTabStrip;
        if (pagerSlidingTabStrip2 == null) {
            $jacocoInit[81] = true;
        } else {
            $jacocoInit[82] = true;
            pagerSlidingTabStrip2.setOnTabReselectedListener(null);
            this.pagerSlidingTabStrip = null;
            $jacocoInit[83] = true;
        }
        this.viewPager.removeCallbacks(this.registerViewpagerCurrentItem);
        $jacocoInit[84] = true;
        this.viewPager.removeOnPageChangeListener(this.pageChangeListener);
        $jacocoInit[85] = true;
        super.onDestroyView();
        $jacocoInit[86] = true;
    }

    /* access modifiers changed from: protected */
    public void setupViewPager() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViewPager();
        $jacocoInit[87] = true;
        this.pagerSlidingTabStrip = (PagerSlidingTabStrip) getView().findViewById(C1375R.C1376id.tabs);
        $jacocoInit[88] = true;
        PagerSlidingTabStrip pagerSlidingTabStrip2 = this.pagerSlidingTabStrip;
        StoreTheme storeTheme2 = StoreTheme.get(this.storeTheme);
        $jacocoInit[89] = true;
        int gradientDrawable = storeTheme2.getGradientDrawable();
        $jacocoInit[90] = true;
        pagerSlidingTabStrip2.setBackgroundResource(gradientDrawable);
        PagerSlidingTabStrip pagerSlidingTabStrip3 = this.pagerSlidingTabStrip;
        if (pagerSlidingTabStrip3 == null) {
            $jacocoInit[91] = true;
        } else {
            $jacocoInit[92] = true;
            pagerSlidingTabStrip3.setViewPager(this.viewPager);
            $jacocoInit[93] = true;
        }
        this.viewPager.addOnPageChangeListener(new C0600i(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ StoreFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(255512282717549290L, "cm/aptoide/pt/store/view/StoreFragment$2", 8);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onPageSelected(int position) {
                boolean[] $jacocoInit = $jacocoInit();
                StorePagerAdapter adapter = (StorePagerAdapter) StoreFragment.access$100(this.this$0).getAdapter();
                $jacocoInit[1] = true;
                if (!StoreFragment.access$000(this.this$0).equals(StoreContext.meta)) {
                    $jacocoInit[2] = true;
                } else {
                    $jacocoInit[3] = true;
                    StoreAnalytics access$300 = StoreFragment.access$300(this.this$0);
                    CharSequence pageTitle = adapter.getPageTitle(position);
                    $jacocoInit[4] = true;
                    String charSequence = pageTitle.toString();
                    String access$200 = StoreFragment.access$200(this.this$0);
                    $jacocoInit[5] = true;
                    access$300.sendStoreInteractEvent("Open Tab", charSequence, access$200);
                    $jacocoInit[6] = true;
                }
                $jacocoInit[7] = true;
            }
        });
        $jacocoInit[94] = true;
        this.viewPager.addOnPageChangeListener(this.pageChangeListener);
        $jacocoInit[95] = true;
        this.registerViewpagerCurrentItem = new C5063na(this);
        $jacocoInit[96] = true;
        this.viewPager.post(this.registerViewpagerCurrentItem);
        $jacocoInit[97] = true;
        changeToTab(this.defaultTab);
        $jacocoInit[98] = true;
        finishLoading();
        $jacocoInit[99] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16584b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.pageChangeListener.onPageSelected(this.viewPager.getCurrentItem());
        $jacocoInit[282] = true;
    }

    /* access modifiers changed from: protected */
    public C0642s createPagerAdapter() {
        boolean[] $jacocoInit = $jacocoInit();
        C0486t childFragmentManager = getChildFragmentManager();
        List<Tab> list = this.tabs;
        StoreContext storeContext2 = this.storeContext;
        Long l = this.storeId;
        String str = this.storeTheme;
        $jacocoInit[100] = true;
        StorePagerAdapter storePagerAdapter = new StorePagerAdapter(childFragmentManager, list, storeContext2, l, str, getContext().getApplicationContext(), this.marketName);
        $jacocoInit[101] = true;
        return storePagerAdapter;
    }

    public int getContentViewId() {
        $jacocoInit()[102] = true;
        return C1375R.layout.store_activity;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 20) {
            $jacocoInit[103] = true;
        } else if (resultCode != -1) {
            $jacocoInit[104] = true;
        } else {
            load(true, true, null);
            $jacocoInit[105] = true;
        }
        $jacocoInit[106] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9334a(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.RESUME) {
            $jacocoInit[279] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[280] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[281] = true;
        return valueOf;
    }

    private void handleOptionsItemSelected(C0120S<MenuItem> toolbarMenuItemClick) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getLifecycleEvent().mo3653d((C0132p<? super T, Boolean>) C5084sa.f8783a);
        C5069qa qaVar = new C5069qa(toolbarMenuItemClick);
        $jacocoInit[107] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qaVar);
        C5030ma maVar = C5030ma.f8712a;
        $jacocoInit[108] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) maVar);
        C5091ua uaVar = new C5091ua(this);
        $jacocoInit[109] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) uaVar);
        LifecycleEvent lifecycleEvent = LifecycleEvent.PAUSE;
        $jacocoInit[110] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(lifecycleEvent));
        C5071ra raVar = C5071ra.f8760a;
        C5087ta taVar = new C5087ta(this);
        $jacocoInit[111] = true;
        a.mo3626a((C0129b<? super T>) raVar, (C0129b<Throwable>) taVar);
        $jacocoInit[112] = true;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m9335a(C0120S toolbarMenuItemClick, LifecycleEvent __) {
        $jacocoInit()[278] = true;
        return toolbarMenuItemClick;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9333a(MenuItem menuItem) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (menuItem == null) {
            $jacocoInit[273] = true;
        } else if (menuItem.getItemId() != C1375R.C1376id.menu_item_share) {
            $jacocoInit[274] = true;
        } else {
            $jacocoInit[275] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[277] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[276] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[277] = true;
        return valueOf2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16585b(MenuItem __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.shareStoreHelper.shareStore(this.storeUrl, this.iconPath);
        $jacocoInit[272] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9336c(MenuItem __) {
        $jacocoInit()[271] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16583a(Throwable trowable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(trowable);
        $jacocoInit[270] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationActivity bottomNavigationActivity2 = this.bottomNavigationActivity;
        if (bottomNavigationActivity2 == null) {
            $jacocoInit[113] = true;
        } else {
            $jacocoInit[114] = true;
            bottomNavigationActivity2.requestFocus(BOTTOM_NAVIGATION_ITEM);
            $jacocoInit[115] = true;
        }
        $jacocoInit[116] = true;
        SuggestionCursorAdapter suggestionCursorAdapter = new SuggestionCursorAdapter(getContext());
        $jacocoInit[117] = true;
        if (!hasSearchFromStoreFragment()) {
            $jacocoInit[118] = true;
        } else {
            $jacocoInit[119] = true;
            Toolbar toolbar = getToolbar();
            $jacocoInit[120] = true;
            C0120S a = C13026g.m42484a(toolbar);
            $jacocoInit[121] = true;
            C14908d f = a.mo3661f();
            $jacocoInit[122] = true;
            C0120S o = f.mo46115o();
            $jacocoInit[123] = true;
            C0120S a2 = C13034a.m42490a(toolbar);
            CrashReport crashReport2 = this.crashReport;
            $jacocoInit[124] = true;
            AppSearchSuggestionsView appSearchSuggestionsView2 = new AppSearchSuggestionsView(this, a2, crashReport2, suggestionCursorAdapter, C14963c.m46753p(), o, this.searchAnalytics);
            this.appSearchSuggestionsView = appSearchSuggestionsView2;
            $jacocoInit[125] = true;
            AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
            AppSearchSuggestionsView appSearchSuggestionsView3 = this.appSearchSuggestionsView;
            $jacocoInit[126] = true;
            SearchSuggestionsPresenter searchSuggestionsPresenter = new SearchSuggestionsPresenter(appSearchSuggestionsView3, application.getSearchSuggestionManager(), C14522a.m46170a(), suggestionCursorAdapter, this.crashReport, this.trendingManager, this.searchNavigator, false, this.searchAnalytics);
            $jacocoInit[127] = true;
            attachPresenter(searchSuggestionsPresenter);
            $jacocoInit[128] = true;
            handleOptionsItemSelected(o);
            $jacocoInit[129] = true;
        }
        $jacocoInit[130] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.storeTheme == null) {
            $jacocoInit[131] = true;
        } else {
            $jacocoInit[132] = true;
            ThemeUtils.setStoreTheme(getActivity(), this.storeTheme);
            $jacocoInit[133] = true;
            ThemeUtils.setStatusBarThemeColor(getActivity(), this.storeTheme);
            $jacocoInit[134] = true;
        }
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[135] = true;
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    public int[] getViewsToShowAfterLoadingId() {
        int[] iArr = {C1375R.C1376id.pager, C1375R.C1376id.tabs};
        $jacocoInit()[136] = true;
        return iArr;
    }

    /* access modifiers changed from: protected */
    public int getViewToShowAfterLoadingId() {
        $jacocoInit()[137] = true;
        return -1;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (create) {
            $jacocoInit[138] = true;
        } else if (this.tabs == null) {
            $jacocoInit[139] = true;
        } else {
            setupViewPager();
            $jacocoInit[143] = true;
            $jacocoInit[144] = true;
        }
        C0120S a = loadData(refresh, this.openType).mo3616a(C14522a.m46170a());
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[140] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        C5067pa paVar = new C5067pa(this);
        C5065oa oaVar = new C5065oa(this);
        $jacocoInit[141] = true;
        a2.mo3626a((C0129b<? super T>) paVar, (C0129b<Throwable>) oaVar);
        $jacocoInit[142] = true;
        $jacocoInit[144] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16581a(String title2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = title2;
        if (this.storeContext == StoreContext.home) {
            $jacocoInit[266] = true;
        } else {
            $jacocoInit[267] = true;
            setupToolbarDetails(getToolbar());
            $jacocoInit[268] = true;
        }
        setupViewPager();
        $jacocoInit[269] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16586b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        handleError(throwable);
        $jacocoInit[265] = true;
    }

    private C0120S<String> loadData(boolean refresh, OpenType openType2) {
        boolean z = refresh;
        boolean[] $jacocoInit = $jacocoInit();
        String str = "window";
        if (C49693.$SwitchMap$cm$aptoide$pt$store$view$StoreFragment$OpenType[openType2.ordinal()] != 1) {
            String str2 = this.storeName;
            StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
            $jacocoInit[152] = true;
            StoreCredentials storeCredentials = StoreUtils.getStoreCredentials(str2, storeCredentialsProvider2);
            StoreContext storeContext2 = this.storeContext;
            BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
            OkHttpClient okHttpClient = this.httpClient;
            Factory factory = this.converterFactory;
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            $jacocoInit[153] = true;
            Resources resources = getContext().getResources();
            $jacocoInit[154] = true;
            WindowManager windowManager = (WindowManager) getContext().getSystemService(str);
            $jacocoInit[155] = true;
            GetStoreRequest of = GetStoreRequest.m7583of(storeCredentials, storeContext2, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, resources, windowManager);
            $jacocoInit[156] = true;
            C0120S observe = of.observe(z);
            C5097xa xaVar = new C5097xa(this);
            $jacocoInit[157] = true;
            C0120S<String> j = observe.mo3669j(xaVar);
            $jacocoInit[158] = true;
            return j;
        }
        String str3 = this.storeName;
        StoreCredentialsProvider storeCredentialsProvider3 = this.storeCredentialsProvider;
        $jacocoInit[145] = true;
        StoreCredentials storeCredentials2 = StoreUtils.getStoreCredentials(str3, storeCredentialsProvider3);
        Long l = this.userId;
        StoreContext storeContext3 = this.storeContext;
        BodyInterceptor<BaseBody> bodyInterceptor3 = this.bodyInterceptor;
        OkHttpClient okHttpClient2 = this.httpClient;
        Factory factory2 = this.converterFactory;
        TokenInvalidator tokenInvalidator3 = this.tokenInvalidator;
        SharedPreferences sharedPreferences3 = this.sharedPreferences;
        $jacocoInit[146] = true;
        Resources resources2 = getContext().getResources();
        $jacocoInit[147] = true;
        WindowManager windowManager2 = (WindowManager) getContext().getSystemService(str);
        $jacocoInit[148] = true;
        GetHomeRequest of2 = GetHomeRequest.m7579of(storeCredentials2, l, storeContext3, bodyInterceptor3, okHttpClient2, factory2, tokenInvalidator3, sharedPreferences3, resources2, windowManager2);
        $jacocoInit[149] = true;
        C0120S observe2 = of2.observe(z);
        C5093va vaVar = new C5093va(this);
        $jacocoInit[150] = true;
        C0120S<String> j2 = observe2.mo3669j(vaVar);
        $jacocoInit[151] = true;
        return j2;
    }

    /* renamed from: a */
    public /* synthetic */ String mo16579a(GetHome getHome) {
        String storeName2;
        Long storeId2;
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Nodes nodes = getHome.getNodes();
        $jacocoInit[244] = true;
        GetHomeMeta getHomeMeta = (GetHomeMeta) nodes.getMeta();
        $jacocoInit[245] = true;
        Data data = getHomeMeta.getData();
        $jacocoInit[246] = true;
        p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store = data.getStore();
        $jacocoInit[247] = true;
        String str2 = null;
        if (store != null) {
            String name = store.getName();
            $jacocoInit[248] = true;
            storeName2 = name;
        } else {
            $jacocoInit[249] = true;
            storeName2 = null;
        }
        $jacocoInit[250] = true;
        if (store != null) {
            Long valueOf = Long.valueOf(store.getId());
            $jacocoInit[251] = true;
            storeId2 = valueOf;
        } else {
            $jacocoInit[252] = true;
            storeId2 = null;
        }
        $jacocoInit[253] = true;
        if (store != null) {
            str2 = store.getAvatar();
            $jacocoInit[254] = true;
        } else {
            $jacocoInit[255] = true;
        }
        String avatar = str2;
        $jacocoInit[256] = true;
        setupVariables(parseTabs(getHome), storeId2, storeName2, this.storeUrl, avatar);
        $jacocoInit[257] = true;
        Nodes nodes2 = getHome.getNodes();
        $jacocoInit[258] = true;
        GetHomeMeta getHomeMeta2 = (GetHomeMeta) nodes2.getMeta();
        $jacocoInit[259] = true;
        Data data2 = getHomeMeta2.getData();
        $jacocoInit[260] = true;
        HomeUser user = data2.getUser();
        $jacocoInit[261] = true;
        if (TextUtils.isEmpty(storeName2)) {
            str = user.getName();
            $jacocoInit[262] = true;
        } else {
            $jacocoInit[263] = true;
            str = storeName2;
        }
        $jacocoInit[264] = true;
        return str;
    }

    /* renamed from: a */
    public /* synthetic */ String mo16580a(GetStore getStore) {
        boolean[] $jacocoInit = $jacocoInit();
        List parseTabs = parseTabs(getStore);
        Nodes nodes = getStore.getNodes();
        $jacocoInit[223] = true;
        GetStoreMeta getStoreMeta = (GetStoreMeta) nodes.getMeta();
        $jacocoInit[224] = true;
        p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store data = getStoreMeta.getData();
        $jacocoInit[225] = true;
        long id = data.getId();
        $jacocoInit[226] = true;
        Long valueOf = Long.valueOf(id);
        $jacocoInit[227] = true;
        Nodes nodes2 = getStore.getNodes();
        $jacocoInit[228] = true;
        GetStoreMeta getStoreMeta2 = (GetStoreMeta) nodes2.getMeta();
        $jacocoInit[229] = true;
        p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store data2 = getStoreMeta2.getData();
        $jacocoInit[230] = true;
        String name = data2.getName();
        Nodes nodes3 = getStore.getNodes();
        $jacocoInit[231] = true;
        GetStoreMeta getStoreMeta3 = (GetStoreMeta) nodes3.getMeta();
        $jacocoInit[232] = true;
        p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store data3 = getStoreMeta3.getData();
        $jacocoInit[233] = true;
        Urls urls = data3.getUrls();
        $jacocoInit[234] = true;
        String mobile = urls.getMobile();
        Nodes nodes4 = getStore.getNodes();
        $jacocoInit[235] = true;
        GetStoreMeta getStoreMeta4 = (GetStoreMeta) nodes4.getMeta();
        $jacocoInit[236] = true;
        p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store data4 = getStoreMeta4.getData();
        $jacocoInit[237] = true;
        String avatar = data4.getAvatar();
        $jacocoInit[238] = true;
        setupVariables(parseTabs, valueOf, name, mobile, avatar);
        $jacocoInit[239] = true;
        Nodes nodes5 = getStore.getNodes();
        $jacocoInit[240] = true;
        GetStoreMeta getStoreMeta5 = (GetStoreMeta) nodes5.getMeta();
        $jacocoInit[241] = true;
        p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store data5 = getStoreMeta5.getData();
        $jacocoInit[242] = true;
        String name2 = data5.getName();
        $jacocoInit[243] = true;
        return name2;
    }

    private List<Tab> parseTabs(StoreUserAbstraction<?> storeUserAbstraction) {
        boolean[] $jacocoInit = $jacocoInit();
        Nodes nodes = storeUserAbstraction.getNodes();
        $jacocoInit[159] = true;
        GetStoreTabs tabs2 = nodes.getTabs();
        $jacocoInit[160] = true;
        List list = tabs2.getList();
        $jacocoInit[161] = true;
        Tab tab = (Tab) list.get(0);
        $jacocoInit[162] = true;
        Event event = tab.getEvent();
        $jacocoInit[163] = true;
        String action = event.getAction();
        $jacocoInit[164] = true;
        String str = "/getStore/";
        if (!action.contains(str)) {
            $jacocoInit[165] = true;
        } else {
            $jacocoInit[166] = true;
            Event event2 = tab.getEvent();
            Name name = Name.getStoreWidgets;
            $jacocoInit[167] = true;
            event2.setName(name);
            $jacocoInit[168] = true;
            Event event3 = tab.getEvent();
            $jacocoInit[169] = true;
            String action2 = event3.getAction();
            $jacocoInit[170] = true;
            String parsedEventAction = action2.replace(str, "/getStoreWidgets/");
            $jacocoInit[171] = true;
            Event event4 = tab.getEvent();
            $jacocoInit[172] = true;
            event4.setAction(parsedEventAction);
            $jacocoInit[173] = true;
        }
        Nodes nodes2 = storeUserAbstraction.getNodes();
        $jacocoInit[174] = true;
        GetStoreTabs tabs3 = nodes2.getTabs();
        $jacocoInit[175] = true;
        List<Tab> list2 = tabs3.getList();
        $jacocoInit[176] = true;
        return list2;
    }

    private void handleError(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof AptoideWsV7Exception) {
            $jacocoInit[177] = true;
            BaseV7Response baseResponse = ((AptoideWsV7Exception) throwable).getBaseResponse();
            $jacocoInit[178] = true;
            int[] iArr = C49693.$SwitchMap$cm$aptoide$pt$store$StoreError;
            Error error = baseResponse.getError();
            $jacocoInit[179] = true;
            String code = error.getCode();
            $jacocoInit[180] = true;
            int i = iArr[StoreUtils.getErrorType(code).ordinal()];
            if (i == 1 || i == 2) {
                $jacocoInit[182] = true;
                C0486t fragmentManager = getFragmentManager();
                String str = PrivateStoreDialog.TAG;
                if (((C0478k) fragmentManager.mo4908a(str)) != null) {
                    $jacocoInit[183] = true;
                } else {
                    String str2 = this.storeName;
                    $jacocoInit[184] = true;
                    C0478k dialogFragment = PrivateStoreDialog.newInstance(this, 20, str2, true);
                    $jacocoInit[185] = true;
                    dialogFragment.show(getFragmentManager(), str);
                    $jacocoInit[186] = true;
                }
            } else {
                if (i != 3) {
                    $jacocoInit[181] = true;
                } else {
                    showStoreSuspendedPopup(this.storeName);
                    $jacocoInit[187] = true;
                }
                finishLoading(throwable);
                $jacocoInit[188] = true;
            }
            $jacocoInit[189] = true;
        } else {
            finishLoading(throwable);
            $jacocoInit[190] = true;
        }
        $jacocoInit[191] = true;
    }

    private void setupVariables(List<Tab> tabs2, Long storeId2, String storeName2, String storeUrl2, String iconPath2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.tabs = tabs2;
        this.storeId = storeId2;
        this.storeName = storeName2;
        this.storeUrl = storeUrl2;
        this.iconPath = iconPath2;
        $jacocoInit[192] = true;
    }

    /* access modifiers changed from: protected */
    public void changeToTab(Name tabToChange) {
        StorePagerAdapter storePagerAdapter;
        boolean[] $jacocoInit = $jacocoInit();
        if (tabToChange == null) {
            $jacocoInit[193] = true;
        } else {
            $jacocoInit[194] = true;
            if (this.viewPager.getAdapter() instanceof StorePagerAdapter) {
                AptoideViewPager aptoideViewPager = this.viewPager;
                $jacocoInit[195] = true;
                storePagerAdapter = (StorePagerAdapter) aptoideViewPager.getAdapter();
                $jacocoInit[196] = true;
            } else {
                storePagerAdapter = null;
                $jacocoInit[197] = true;
            }
            if (storePagerAdapter == null) {
                $jacocoInit[198] = true;
            } else {
                AptoideViewPager aptoideViewPager2 = this.viewPager;
                $jacocoInit[199] = true;
                int eventNamePosition = ((StorePagerAdapter) aptoideViewPager2.getAdapter()).getEventNamePosition(tabToChange);
                $jacocoInit[200] = true;
                aptoideViewPager2.setCurrentItem(eventNamePosition);
                $jacocoInit[201] = true;
            }
        }
        $jacocoInit[202] = true;
    }

    private void showStoreSuspendedPopup(String storeName2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S createGenericOkCancelMessage = GenericDialogs.createGenericOkCancelMessage(getContext(), "", C1375R.string.store_suspended_message, 17039370, C1375R.string.unfollow);
        C5095wa waVar = new C5095wa(this, storeName2);
        $jacocoInit[203] = true;
        createGenericOkCancelMessage.mo3646c((C0129b<? super T>) waVar);
        $jacocoInit[204] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16582a(String storeName2, EResponse eResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C49693.$SwitchMap$cm$aptoide$pt$utils$GenericDialogs$EResponse[eResponse.ordinal()];
        if (i == 1) {
            AptoideAccountManager aptoideAccountManager = this.accountManager;
            StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
            $jacocoInit[216] = true;
            Context applicationContext = getContext().getApplicationContext();
            $jacocoInit[217] = true;
            $jacocoInit[218] = true;
            StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class);
            $jacocoInit[219] = true;
            StoreUtils.unSubscribeStore(storeName2, aptoideAccountManager, storeCredentialsProvider2, storeAccessor);
            $jacocoInit[220] = true;
        } else if (i == 2 || i == 3) {
            $jacocoInit[215] = true;
        } else {
            $jacocoInit[214] = true;
            $jacocoInit[222] = true;
        }
        getActivity().onBackPressed();
        $jacocoInit[221] = true;
        $jacocoInit[222] = true;
    }

    public void setupToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupToolbar();
        $jacocoInit[205] = true;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[206] = true;
        return true;
    }

    /* access modifiers changed from: protected */
    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        toolbar.setTitle((CharSequence) this.title);
        $jacocoInit[207] = true;
        StoreTheme storeTheme2 = StoreTheme.get(this.storeTheme);
        $jacocoInit[208] = true;
        int gradientDrawable = storeTheme2.getGradientDrawable();
        $jacocoInit[209] = true;
        toolbar.setBackgroundResource(gradientDrawable);
        if (this.userId != null) {
            $jacocoInit[210] = true;
            toolbar.setLogo((int) C1375R.drawable.ic_user_shape_white);
            $jacocoInit[211] = true;
        } else {
            toolbar.setLogo((int) C1375R.drawable.ic_store_white);
            $jacocoInit[212] = true;
        }
        $jacocoInit[213] = true;
    }
}
