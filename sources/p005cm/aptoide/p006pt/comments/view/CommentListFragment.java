package p005cm.aptoide.p006pt.comments.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0988n;
import android.support.p001v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.comments.CommentDialogCallbackContract;
import p005cm.aptoide.p006pt.comments.CommentNode;
import p005cm.aptoide.p006pt.comments.ComplexComment;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment.Parent;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment.User;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.SetComment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.SetComment.Data;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListCommentsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.dataprovider.util.CommentType;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.util.CommentOperations;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.custom.HorizontalDividerItemDecoration;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeFragment;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayableGroup;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.comments.view.CommentListFragment */
public class CommentListFragment extends GridRecyclerSwipeFragment implements CommentDialogCallbackContract {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String COMMENT_TYPE = "comment_type";
    private static final String ELEMENT_ID_AS_LONG = "element_id_as_long";
    private static final String STORE_ANALYTICS_ACTION = "store_analytics_action";
    private static final String STORE_CONTEXT = "store_context";
    private static final String URL_VAL = "url_val";
    private AptoideAccountManager accountManager;
    private AccountNavigator accountNavigator;
    @Inject
    AnalyticsManager analyticsManager;
    private BodyInterceptor<BaseBody> bodyDecorator;
    private CommentOperations commentOperations;
    private CommentType commentType;
    private List<CommentNode> comments;
    private Factory converterFactory;
    private List<Displayable> displayables;
    private long elementIdAsLong;
    private FloatingActionButton floatingActionButton;
    private OkHttpClient httpClient;
    @Inject
    NavigationTracker navigationTracker;
    private SharedPreferences sharedPreferences;
    private StoreAnalytics storeAnalytics;
    private String storeAnalyticsAction;
    private StoreContext storeContext;
    private StoreCredentialsProvider storeCredentialsProvider;
    private String storeName;
    private TokenInvalidator tokenInvalidator;
    private String url;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5056011891489107142L, "cm/aptoide/pt/comments/view/CommentListFragment", 247);
        $jacocoData = probes;
        return probes;
    }

    public CommentListFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstanceUrl(CommentType commentType2, String url2, String storeAnalyticsAction2, StoreContext storeContext2) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[1] = true;
        args.putString(URL_VAL, url2);
        $jacocoInit[2] = true;
        args.putSerializable(STORE_CONTEXT, storeContext2);
        $jacocoInit[3] = true;
        args.putString(COMMENT_TYPE, commentType2.name());
        $jacocoInit[4] = true;
        args.putString(STORE_ANALYTICS_ACTION, storeAnalyticsAction2);
        $jacocoInit[5] = true;
        CommentListFragment fragment = new CommentListFragment();
        $jacocoInit[6] = true;
        fragment.setArguments(args);
        $jacocoInit[7] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[8] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[9] = true;
        this.sharedPreferences = application.getDefaultSharedPreferences();
        $jacocoInit[10] = true;
        this.tokenInvalidator = application.getTokenInvalidator();
        $jacocoInit[11] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[12] = true;
        $jacocoInit[13] = true;
        this.storeCredentialsProvider = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[14] = true;
        this.httpClient = application.getDefaultClient();
        $jacocoInit[15] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[16] = true;
        super.onCreate(savedInstanceState);
        $jacocoInit[17] = true;
        setHasOptionsMenu(true);
        $jacocoInit[18] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View v = super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[19] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[20] = true;
        this.bodyDecorator = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[21] = true;
        this.accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        $jacocoInit[22] = true;
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        $jacocoInit[23] = true;
        return v;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[24] = true;
        return true;
    }

    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.commentType != CommentType.STORE) {
            $jacocoInit[25] = true;
        } else if (TextUtils.isEmpty(this.storeName)) {
            $jacocoInit[26] = true;
        } else {
            $jacocoInit[27] = true;
            String title = String.format(getString(C1375R.string.commentlist_title_comment_on_store), new Object[]{this.storeName});
            $jacocoInit[28] = true;
            toolbar.setTitle((CharSequence) title);
            $jacocoInit[29] = true;
            $jacocoInit[31] = true;
        }
        toolbar.setTitle((int) C1375R.string.comments_title_comments);
        $jacocoInit[30] = true;
        $jacocoInit[31] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[32] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[33] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[34] = true;
            getActivity().onBackPressed();
            $jacocoInit[35] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[36] = true;
        return onOptionsItemSelected;
    }

    public int getContentViewId() {
        $jacocoInit()[37] = true;
        return C1375R.layout.recycler_swipe_fragment_with_toolbar;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[38] = true;
        this.storeContext = (StoreContext) args.getSerializable(STORE_CONTEXT);
        $jacocoInit[39] = true;
        this.elementIdAsLong = args.getLong(ELEMENT_ID_AS_LONG);
        $jacocoInit[40] = true;
        this.url = args.getString(URL_VAL);
        $jacocoInit[41] = true;
        this.commentType = CommentType.valueOf(args.getString(COMMENT_TYPE));
        $jacocoInit[42] = true;
        this.storeAnalyticsAction = args.getString(STORE_ANALYTICS_ACTION);
        if (this.commentType != CommentType.STORE) {
            $jacocoInit[43] = true;
        } else {
            String str = this.url;
            StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
            $jacocoInit[44] = true;
            StoreCredentials storeCredentials = StoreUtils.getStoreCredentialsFromUrl(str, storeCredentialsProvider2);
            if (storeCredentials == null) {
                $jacocoInit[45] = true;
            } else {
                $jacocoInit[46] = true;
                Long id = storeCredentials.getId();
                if (id == null) {
                    $jacocoInit[47] = true;
                } else {
                    $jacocoInit[48] = true;
                    this.elementIdAsLong = id.longValue();
                    $jacocoInit[49] = true;
                }
                if (TextUtils.isEmpty(storeCredentials.getName())) {
                    $jacocoInit[50] = true;
                } else {
                    $jacocoInit[51] = true;
                    this.storeName = storeCredentials.getName();
                    $jacocoInit[52] = true;
                }
            }
        }
        $jacocoInit[53] = true;
    }

    public void bindViews(View view) {
        Drawable drawable;
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[54] = true;
        this.commentOperations = new CommentOperations();
        $jacocoInit[55] = true;
        this.floatingActionButton = (FloatingActionButton) view.findViewById(C1375R.C1376id.fabAdd);
        if (this.floatingActionButton == null) {
            $jacocoInit[56] = true;
        } else {
            if (VERSION.SDK_INT >= 21) {
                $jacocoInit[57] = true;
                drawable = getContext().getDrawable(C1375R.drawable.forma_1);
                $jacocoInit[58] = true;
            } else {
                Resources resources = getActivity().getResources();
                $jacocoInit[59] = true;
                drawable = resources.getDrawable(C1375R.drawable.forma_1);
                $jacocoInit[60] = true;
            }
            this.floatingActionButton.setImageDrawable(drawable);
            $jacocoInit[61] = true;
            this.floatingActionButton.setVisibility(0);
            $jacocoInit[62] = true;
        }
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[63] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        if (this.commentType != CommentType.STORE) {
            $jacocoInit[64] = true;
        } else {
            $jacocoInit[65] = true;
            StoreAnalytics storeAnalytics2 = this.storeAnalytics;
            String str = this.storeAnalyticsAction;
            String str2 = this.storeName;
            if (str2 == null) {
                $jacocoInit[66] = true;
                str2 = "unknown";
            } else {
                $jacocoInit[67] = true;
            }
            storeAnalytics2.sendStoreInteractEvent(str, "Home", str2);
            $jacocoInit[68] = true;
        }
        $jacocoInit[69] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.load(create, refresh, savedInstanceState);
        if (create) {
            $jacocoInit[70] = true;
        } else if (!refresh) {
            $jacocoInit[71] = true;
            $jacocoInit[74] = true;
        } else {
            $jacocoInit[72] = true;
        }
        refreshData();
        $jacocoInit[73] = true;
        $jacocoInit[74] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[75] = true;
        String simpleName = cls.getSimpleName();
        StoreContext storeContext2 = this.storeContext;
        if (storeContext2 != null) {
            str = storeContext2.name();
            $jacocoInit[76] = true;
        } else {
            str = null;
            $jacocoInit[77] = true;
        }
        ScreenTagHistory build = Builder.build(simpleName, "", str);
        $jacocoInit[78] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    public void refreshData() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.url;
        caseListStoreComments(str, StoreUtils.getStoreCredentialsFromUrl(str, this.storeCredentialsProvider), true);
        $jacocoInit[79] = true;
    }

    /* access modifiers changed from: 0000 */
    public void caseListStoreComments(String url2, StoreCredentials storeCredentials, boolean refresh) {
        long storeId;
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> bodyInterceptor = this.bodyDecorator;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[80] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[81] = true;
        ListCommentsRequest listCommentsRequest = ListCommentsRequest.ofStoreAction(url2, refresh, storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences);
        $jacocoInit[82] = true;
        if (storeCredentials == null) {
            boolean z = refresh;
            $jacocoInit[83] = true;
        } else if (storeCredentials.getId() != null) {
            if (storeCredentials.getId() != null) {
                storeId = storeCredentials.getId().longValue();
                $jacocoInit[88] = true;
            } else {
                storeId = -1;
                $jacocoInit[89] = true;
            }
            $jacocoInit[90] = true;
            String storeName2 = storeCredentials.getName();
            $jacocoInit[91] = true;
            C2709s sVar = new C2709s(this, storeId, storeName2);
            $jacocoInit[92] = true;
            getRecyclerView().mo7557c();
            $jacocoInit[93] = true;
            EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(getAdapter(), listCommentsRequest, sVar, C2706p.f5900a, true, false);
            $jacocoInit[94] = true;
            getRecyclerView().mo7530a((C0988n) endlessRecyclerOnScrollListener);
            $jacocoInit[95] = true;
            boolean z2 = refresh;
            endlessRecyclerOnScrollListener.onLoadMore(z2, z2);
            $jacocoInit[96] = true;
            return;
        } else {
            boolean z3 = refresh;
            $jacocoInit[84] = true;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Current store credentials does not have a store id");
        $jacocoInit[85] = true;
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[86] = true;
        instance.log(illegalStateException);
        $jacocoInit[87] = true;
        throw illegalStateException;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11586a(long storeId, String storeName2, ListComments listComments) {
        boolean[] $jacocoInit = $jacocoInit();
        if (listComments == null) {
            $jacocoInit[222] = true;
        } else {
            $jacocoInit[223] = true;
            if (listComments.getDataList() == null) {
                $jacocoInit[224] = true;
            } else {
                $jacocoInit[225] = true;
                DataList dataList = listComments.getDataList();
                $jacocoInit[226] = true;
                if (dataList.getList() == null) {
                    $jacocoInit[227] = true;
                } else {
                    CommentOperations commentOperations2 = this.commentOperations;
                    $jacocoInit[228] = true;
                    DataList dataList2 = listComments.getDataList();
                    $jacocoInit[229] = true;
                    List list = dataList2.getList();
                    $jacocoInit[230] = true;
                    this.comments = commentOperations2.flattenByDepth(commentOperations2.transform(list));
                    $jacocoInit[231] = true;
                    ArrayList arrayList = new ArrayList(this.comments.size());
                    $jacocoInit[232] = true;
                    ArrayList arrayList2 = arrayList;
                    $jacocoInit[233] = true;
                    for (CommentNode commentNode : this.comments) {
                        $jacocoInit[234] = true;
                        Comment comment = commentNode.getComment();
                        $jacocoInit[235] = true;
                        long id = comment.getId();
                        $jacocoInit[236] = true;
                        ComplexComment complexComment = new ComplexComment(commentNode, createNewCommentFragment(storeId, id, storeName2));
                        $jacocoInit[237] = true;
                        FragmentNavigator fragmentNavigator = getFragmentNavigator();
                        $jacocoInit[238] = true;
                        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
                        CommentDisplayable commentDisplayable = new CommentDisplayable(complexComment, fragmentNavigator, AptoideApplication.getFragmentProvider());
                        $jacocoInit[239] = true;
                        arrayList2.add(commentDisplayable);
                        $jacocoInit[240] = true;
                    }
                    this.displayables = new ArrayList(arrayList2.size());
                    List<Displayable> list2 = this.displayables;
                    $jacocoInit[241] = true;
                    WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
                    $jacocoInit[242] = true;
                    DisplayableGroup displayableGroup = new DisplayableGroup(arrayList2, windowManager, getContext().getResources());
                    $jacocoInit[243] = true;
                    list2.add(displayableGroup);
                    $jacocoInit[244] = true;
                    addDisplayables(this.displayables);
                    $jacocoInit[245] = true;
                }
            }
        }
        $jacocoInit[246] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7327a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        err.printStackTrace();
        $jacocoInit[221] = true;
    }

    private C0117M createNewCommentFragment(long storeId, long previousCommentId, String storeName2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[97] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[98] = true;
        Single n = d.mo3678n();
        C2707q qVar = new C2707q(this, storeId, previousCommentId, storeName2);
        $jacocoInit[99] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) qVar);
        $jacocoInit[100] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11583a(long storeId, long previousCommentId, String storeName2, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        if (account.isLoggedIn()) {
            $jacocoInit[209] = true;
            C0014p activity = getActivity();
            $jacocoInit[210] = true;
            C0486t fm = activity.getSupportFragmentManager();
            $jacocoInit[211] = true;
            CommentDialogFragment commentDialogFragment = CommentDialogFragment.newInstanceStoreCommentReply(storeId, previousCommentId, storeName2);
            $jacocoInit[212] = true;
            commentDialogFragment.setCommentDialogCallbackContract(this);
            $jacocoInit[213] = true;
            C0120S lifecycle = commentDialogFragment.lifecycle();
            C2711u uVar = new C2711u(commentDialogFragment, fm);
            $jacocoInit[214] = true;
            C0120S b = lifecycle.mo3635b((C0128a) uVar);
            C2700k kVar = C2700k.f5893a;
            $jacocoInit[215] = true;
            C0120S d = b.mo3653d((C0132p<? super T, Boolean>) kVar);
            $jacocoInit[216] = true;
            C0117M l = d.mo3673l();
            $jacocoInit[217] = true;
            return l;
        }
        C0117M showSignInMessage = showSignInMessage();
        $jacocoInit[218] = true;
        return showSignInMessage;
    }

    /* renamed from: b */
    static /* synthetic */ void m7329b(CommentDialogFragment commentDialogFragment, C0486t fm) {
        boolean[] $jacocoInit = $jacocoInit();
        commentDialogFragment.show(fm, "fragment_comment_dialog");
        $jacocoInit[220] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7330c(C12543b event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(C12543b.DESTROY_VIEW));
        $jacocoInit[219] = true;
        return valueOf;
    }

    private C0117M showSignInMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Single a = Single.m734a(this.floatingActionButton);
        C2708r rVar = new C2708r(this);
        $jacocoInit[101] = true;
        C0117M b = a.mo3693b((C0132p<? super T, ? extends C0117M>) rVar);
        $jacocoInit[102] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo11590b(FloatingActionButton view) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C2703m(this, view));
        $jacocoInit[204] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11587a(FloatingActionButton view) {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1623a((View) view, (int) C1375R.string.you_need_to_be_logged_in, 0);
        C2704n nVar = new C2704n(this);
        $jacocoInit[205] = true;
        a.mo4552a((int) C1375R.string.login, (OnClickListener) nVar);
        $jacocoInit[206] = true;
        a.mo4690h();
        $jacocoInit[207] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11588a(View snackView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToAccountView(AccountOrigins.COMMENT_LIST);
        $jacocoInit[208] = true;
    }

    private C0120S<Void> reloadComments() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C0120S.m633a((Callable<? extends T>) new C2702l<Object>(this));
        $jacocoInit[103] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ Void mo11589b() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        ManagerPreferences.setForceServerRefreshFlag(true, this.sharedPreferences);
        $jacocoInit[202] = true;
        super.reload();
        $jacocoInit[203] = true;
        return null;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViews();
        $jacocoInit[104] = true;
        setupToolbar();
        $jacocoInit[105] = true;
        C0120S a = C13034a.m42490a(this.floatingActionButton);
        C2710t tVar = new C2710t(this);
        $jacocoInit[106] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) tVar);
        LifecycleEvent lifecycleEvent = LifecycleEvent.DESTROY;
        $jacocoInit[107] = true;
        C0120S a2 = f.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(lifecycleEvent));
        C2705o oVar = C2705o.f5899a;
        $jacocoInit[108] = true;
        a2.mo3646c((C0129b<? super T>) oVar);
        $jacocoInit[109] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11585a(Void a) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S f = createNewCommentFragment(this.elementIdAsLong, this.storeName).mo3604f();
        $jacocoInit[201] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ void m7326a(Object a) {
        $jacocoInit()[200] = true;
    }

    /* access modifiers changed from: protected */
    public C0980h getItemDecoration() {
        boolean[] $jacocoInit = $jacocoInit();
        HorizontalDividerItemDecoration horizontalDividerItemDecoration = new HorizontalDividerItemDecoration(getContext(), 0);
        $jacocoInit[110] = true;
        return horizontalDividerItemDecoration;
    }

    public C0117M createNewCommentFragment(long storeCommentId, String storeName2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[111] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[112] = true;
        Single n = d.mo3678n();
        C2698j jVar = new C2698j(this, storeCommentId, storeName2);
        $jacocoInit[113] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) jVar);
        $jacocoInit[114] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11584a(long storeCommentId, String storeName2, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        if (account.isLoggedIn()) {
            $jacocoInit[188] = true;
            C0014p activity = getActivity();
            $jacocoInit[189] = true;
            C0486t fm = activity.getSupportFragmentManager();
            $jacocoInit[190] = true;
            CommentDialogFragment commentDialogFragment = CommentDialogFragment.newInstanceStoreComment(storeCommentId, storeName2);
            $jacocoInit[191] = true;
            commentDialogFragment.setCommentDialogCallbackContract(this);
            $jacocoInit[192] = true;
            C0120S lifecycle = commentDialogFragment.lifecycle();
            C2696i iVar = new C2696i(commentDialogFragment, fm);
            $jacocoInit[193] = true;
            C0120S b = lifecycle.mo3635b((C0128a) iVar);
            C2694h hVar = C2694h.f5884a;
            $jacocoInit[194] = true;
            C0120S d = b.mo3653d((C0132p<? super T, Boolean>) hVar);
            $jacocoInit[195] = true;
            C0117M l = d.mo3673l();
            $jacocoInit[196] = true;
            return l;
        }
        C0117M showSignInMessage = showSignInMessage();
        $jacocoInit[197] = true;
        return showSignInMessage;
    }

    /* renamed from: a */
    static /* synthetic */ void m7325a(CommentDialogFragment commentDialogFragment, C0486t fm) {
        boolean[] $jacocoInit = $jacocoInit();
        commentDialogFragment.show(fm, "fragment_comment_dialog");
        $jacocoInit[199] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m7328b(C12543b event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(C12543b.DESTROY_VIEW));
        $jacocoInit[198] = true;
        return valueOf;
    }

    public void okSelected(BaseV7Response response, long longAsId, Long previousCommentId, String idAsString) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!(response instanceof SetComment)) {
            $jacocoInit[115] = true;
        } else {
            $jacocoInit[116] = true;
            Data data = ((SetComment) response).getData();
            $jacocoInit[117] = true;
            String body = data.getBody();
            Data data2 = ((SetComment) response).getData();
            $jacocoInit[118] = true;
            long id = data2.getId();
            $jacocoInit[119] = true;
            ComplexComment complexComment = getComplexComment(body, previousCommentId, id);
            $jacocoInit[120] = true;
            FragmentNavigator fragmentNavigator = getFragmentNavigator();
            $jacocoInit[121] = true;
            AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
            CommentDisplayable commentDisplayable = new CommentDisplayable(complexComment, fragmentNavigator, AptoideApplication.getFragmentProvider());
            $jacocoInit[122] = true;
            if (complexComment.getParent() != null) {
                $jacocoInit[123] = true;
                insertChildCommentInsideParent(complexComment);
                $jacocoInit[124] = true;
            } else {
                addDisplayable(0, (Displayable) commentDisplayable, true);
                $jacocoInit[125] = true;
            }
            ManagerPreferences.setForceServerRefreshFlag(true, this.sharedPreferences);
            $jacocoInit[126] = true;
            ShowMessage.asSnack((Activity) getActivity(), (int) C1375R.string.comment_submitted);
            $jacocoInit[127] = true;
        }
        $jacocoInit[128] = true;
    }

    private void insertChildCommentInsideParent(ComplexComment complexComment) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.clear();
        boolean added = false;
        $jacocoInit[129] = true;
        ArrayList<Displayable> displayables2 = new ArrayList<>(this.comments.size() + 1);
        $jacocoInit[130] = true;
        $jacocoInit[131] = true;
        for (CommentNode commentNode : this.comments) {
            long j = this.elementIdAsLong;
            $jacocoInit[132] = true;
            Comment comment = commentNode.getComment();
            $jacocoInit[133] = true;
            long id = comment.getId();
            String str = this.storeName;
            $jacocoInit[134] = true;
            ComplexComment complexComment2 = new ComplexComment(commentNode, createNewCommentFragment(j, id, str));
            $jacocoInit[135] = true;
            FragmentNavigator fragmentNavigator = getFragmentNavigator();
            $jacocoInit[136] = true;
            AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
            CommentDisplayable commentDisplayable = new CommentDisplayable(complexComment2, fragmentNavigator, AptoideApplication.getFragmentProvider());
            $jacocoInit[137] = true;
            displayables2.add(commentDisplayable);
            $jacocoInit[138] = true;
            Comment comment2 = commentNode.getComment();
            $jacocoInit[139] = true;
            long id2 = comment2.getId();
            Parent parent = complexComment.getParent();
            $jacocoInit[140] = true;
            if (id2 != parent.getId()) {
                $jacocoInit[141] = true;
            } else if (added) {
                $jacocoInit[142] = true;
            } else {
                $jacocoInit[143] = true;
                FragmentNavigator fragmentNavigator2 = getFragmentNavigator();
                $jacocoInit[144] = true;
                AptoideApplication aptoideApplication2 = (AptoideApplication) getContext().getApplicationContext();
                CommentDisplayable commentDisplayable2 = new CommentDisplayable(complexComment, fragmentNavigator2, AptoideApplication.getFragmentProvider());
                $jacocoInit[145] = true;
                displayables2.add(commentDisplayable2);
                added = true;
                $jacocoInit[146] = true;
            }
            $jacocoInit[147] = true;
        }
        this.displayables = new ArrayList(displayables2.size());
        List<Displayable> list = this.displayables;
        $jacocoInit[148] = true;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        $jacocoInit[149] = true;
        DisplayableGroup displayableGroup = new DisplayableGroup(displayables2, windowManager, getContext().getResources());
        $jacocoInit[150] = true;
        list.add(displayableGroup);
        $jacocoInit[151] = true;
        clearDisplayables();
        $jacocoInit[152] = true;
        addDisplayables(this.displayables);
        $jacocoInit[153] = true;
    }

    private ComplexComment getComplexComment(String inputText, Long previousCommentId, long id) {
        boolean[] $jacocoInit = $jacocoInit();
        Comment comment = new Comment();
        $jacocoInit[154] = true;
        Comment comment2 = comment;
        User user = new User();
        $jacocoInit[155] = true;
        User user2 = user;
        Account account = this.accountManager.getAccount();
        $jacocoInit[156] = true;
        String avatar = account.getAvatar();
        $jacocoInit[157] = true;
        if (!TextUtils.isEmpty(avatar)) {
            $jacocoInit[158] = true;
            Account account2 = this.accountManager.getAccount();
            $jacocoInit[159] = true;
            String avatar2 = account2.getAvatar();
            $jacocoInit[160] = true;
            user2.setAvatar(avatar2);
            $jacocoInit[161] = true;
        } else {
            Account account3 = this.accountManager.getAccount();
            $jacocoInit[162] = true;
            p005cm.aptoide.accountmanager.Store store = account3.getStore();
            $jacocoInit[163] = true;
            String avatar3 = store.getAvatar();
            $jacocoInit[164] = true;
            if (TextUtils.isEmpty(avatar3)) {
                $jacocoInit[165] = true;
            } else {
                $jacocoInit[166] = true;
                Account account4 = this.accountManager.getAccount();
                $jacocoInit[167] = true;
                p005cm.aptoide.accountmanager.Store store2 = account4.getStore();
                $jacocoInit[168] = true;
                String avatar4 = store2.getAvatar();
                $jacocoInit[169] = true;
                user2.setAvatar(avatar4);
                $jacocoInit[170] = true;
            }
        }
        Account account5 = this.accountManager.getAccount();
        $jacocoInit[171] = true;
        String nickname = account5.getNickname();
        $jacocoInit[172] = true;
        user2.setName(nickname);
        $jacocoInit[173] = true;
        comment2.setUser(user2);
        $jacocoInit[174] = true;
        comment2.setBody(inputText);
        $jacocoInit[175] = true;
        comment2.setAdded(new Date());
        $jacocoInit[176] = true;
        comment2.setId(id);
        $jacocoInit[177] = true;
        CommentNode commentNode = new CommentNode(comment2);
        if (previousCommentId == null) {
            $jacocoInit[178] = true;
        } else {
            $jacocoInit[179] = true;
            Parent parent = new Parent();
            $jacocoInit[180] = true;
            parent.setId(previousCommentId.longValue());
            $jacocoInit[181] = true;
            comment2.setParent(parent);
            $jacocoInit[182] = true;
            commentNode.setLevel(2);
            $jacocoInit[183] = true;
        }
        long j = this.elementIdAsLong;
        $jacocoInit[184] = true;
        Comment comment3 = commentNode.getComment();
        $jacocoInit[185] = true;
        long id2 = comment3.getId();
        String str = this.storeName;
        $jacocoInit[186] = true;
        ComplexComment complexComment = new ComplexComment(commentNode, createNewCommentFragment(j, id2, str));
        $jacocoInit[187] = true;
        return complexComment;
    }
}
