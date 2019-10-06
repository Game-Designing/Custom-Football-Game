package p005cm.aptoide.p006pt.store.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Name;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget.Data;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Layout;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.view.ActivityComponent;
import p005cm.aptoide.p006pt.view.MainActivity;
import p005cm.aptoide.p006pt.view.Translator;
import p005cm.aptoide.p006pt.view.fragment.DisplayableManager;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeFragment;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import rx.Observable;

/* renamed from: cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment */
public abstract class StoreTabGridRecyclerFragment extends GridRecyclerSwipeFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    protected String action;
    protected Type homeEventType;
    protected Layout layout;
    @Inject
    String marketName;
    protected Name name;
    protected StoreContext storeContext;
    protected StoreRepository storeRepository;
    protected String storeTheme;
    protected String tag;
    protected String title;
    protected Event.Type type;

    /* renamed from: cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment$BundleCons */
    public static class BundleCons {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        public static final String ACTION = "action";
        public static final String HOME_EVENT_TYPE = "HomeEventType";
        public static final String LAYOUT = "layout";
        public static final String NAME = "name";
        public static String STORE_CONTEXT = "Store_context";
        public static final String STORE_NAME = "store_name";
        public static final String STORE_THEME = "storeTheme";
        public static final String TAG = "tag";
        public static final String TITLE = "title";
        public static final String TOOLBAR = "toolbar";
        public static final String TYPE = "type";

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-7339076339267658355L, "cm/aptoide/pt/store/view/StoreTabGridRecyclerFragment$BundleCons", 2);
            $jacocoData = probes;
            return probes;
        }

        public BundleCons() {
            $jacocoInit()[0] = true;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[1] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5227985301271852326L, "cm/aptoide/pt/store/view/StoreTabGridRecyclerFragment", 109);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public abstract C0120S<List<Displayable>> buildDisplayables(boolean z, String str, boolean z2);

    public StoreTabGridRecyclerFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance(Event event, String storeTheme2, String tag2, StoreContext storeContext2) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment newInstance = newInstance(event, null, storeTheme2, tag2, storeContext2);
        $jacocoInit[1] = true;
        return newInstance;
    }

    public static Fragment newInstance(Event event, String title2, String storeTheme2, String tag2, StoreContext storeContext2) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment newInstance = newInstance(event, Type.NO_OP, title2, storeTheme2, tag2, storeContext2);
        $jacocoInit[2] = true;
        return newInstance;
    }

    public static Fragment newInstance(Event event, Type type2, String title2, String storeTheme2, String tag2, StoreContext storeContext2) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = buildBundle(event, type2, title2, storeTheme2, tag2, storeContext2);
        $jacocoInit[3] = true;
        Fragment fragment = StoreTabFragmentChooser.choose(event.getName());
        $jacocoInit[4] = true;
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            args.putAll(arguments);
            $jacocoInit[7] = true;
        }
        fragment.setArguments(args);
        $jacocoInit[8] = true;
        return fragment;
    }

    protected static Bundle buildBundle(Event event, Type homeEventType2, String title2, String storeTheme2, String tag2, StoreContext storeContext2) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        if (homeEventType2 == null) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            args.putString(BundleCons.HOME_EVENT_TYPE, homeEventType2.toString());
            $jacocoInit[11] = true;
        }
        if (event.getType() == null) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            Event.Type type2 = event.getType();
            $jacocoInit[14] = true;
            String str = type2.toString();
            $jacocoInit[15] = true;
            args.putString("type", str);
            $jacocoInit[16] = true;
        }
        if (event.getName() == null) {
            $jacocoInit[17] = true;
        } else {
            $jacocoInit[18] = true;
            Name name2 = event.getName();
            $jacocoInit[19] = true;
            String str2 = name2.toString();
            $jacocoInit[20] = true;
            args.putString("name", str2);
            $jacocoInit[21] = true;
        }
        if (event.getData() == null) {
            $jacocoInit[22] = true;
        } else {
            $jacocoInit[23] = true;
            Data data = event.getData();
            $jacocoInit[24] = true;
            if (data.getLayout() == null) {
                $jacocoInit[25] = true;
            } else {
                $jacocoInit[26] = true;
                Data data2 = event.getData();
                $jacocoInit[27] = true;
                Layout layout2 = data2.getLayout();
                $jacocoInit[28] = true;
                String str3 = layout2.toString();
                $jacocoInit[29] = true;
                args.putString("layout", str3);
                $jacocoInit[30] = true;
            }
        }
        if (storeContext2 == null) {
            $jacocoInit[31] = true;
        } else {
            $jacocoInit[32] = true;
            args.putSerializable(BundleCons.STORE_CONTEXT, storeContext2);
            $jacocoInit[33] = true;
        }
        args.putString("title", title2);
        $jacocoInit[34] = true;
        args.putString("action", event.getAction());
        $jacocoInit[35] = true;
        args.putString("storeTheme", storeTheme2);
        $jacocoInit[36] = true;
        args.putString(BundleCons.TAG, tag2);
        $jacocoInit[37] = true;
        return args;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[38] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[39] = true;
        ActivityComponent activityComponent = ((MainActivity) getContext()).getActivityComponent();
        $jacocoInit[40] = true;
        activityComponent.inject(this);
        $jacocoInit[41] = true;
        this.storeRepository = RepositoryFactory.getStoreRepository(getContext().getApplicationContext());
        $jacocoInit[42] = true;
        super.onCreate(savedInstanceState);
        $jacocoInit[43] = true;
        setHasOptionsMenu(true);
        $jacocoInit[44] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[45] = true;
        String simpleName = cls.getSimpleName();
        String str2 = this.tag;
        StoreContext storeContext2 = this.storeContext;
        if (storeContext2 != null) {
            str = storeContext2.name();
            $jacocoInit[46] = true;
        } else {
            str = null;
            $jacocoInit[47] = true;
        }
        ScreenTagHistory build = Builder.build(simpleName, str2, str);
        $jacocoInit[48] = true;
        return build;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = BundleCons.HOME_EVENT_TYPE;
        if (!args.containsKey(str)) {
            $jacocoInit[49] = true;
        } else {
            $jacocoInit[50] = true;
            this.homeEventType = Type.valueOf(args.getString(str));
            $jacocoInit[51] = true;
        }
        String str2 = "type";
        if (!args.containsKey(str2)) {
            $jacocoInit[52] = true;
        } else {
            $jacocoInit[53] = true;
            this.type = Event.Type.valueOf(args.getString(str2));
            $jacocoInit[54] = true;
        }
        String str3 = "name";
        if (!args.containsKey(str3)) {
            $jacocoInit[55] = true;
        } else {
            $jacocoInit[56] = true;
            this.name = Name.valueOf(args.getString(str3));
            $jacocoInit[57] = true;
        }
        String str4 = "layout";
        if (!args.containsKey(str4)) {
            $jacocoInit[58] = true;
        } else {
            $jacocoInit[59] = true;
            this.layout = Layout.valueOf(args.getString(str4));
            $jacocoInit[60] = true;
        }
        String str5 = BundleCons.TAG;
        if (!args.containsKey(str5)) {
            $jacocoInit[61] = true;
        } else {
            $jacocoInit[62] = true;
            this.tag = args.getString(str5);
            $jacocoInit[63] = true;
        }
        if (!args.containsKey(BundleCons.STORE_CONTEXT)) {
            $jacocoInit[64] = true;
        } else {
            $jacocoInit[65] = true;
            this.storeContext = (StoreContext) args.getSerializable(BundleCons.STORE_CONTEXT);
            $jacocoInit[66] = true;
        }
        $jacocoInit[67] = true;
        String translate = Translator.translate("title", getContext().getApplicationContext(), this.marketName);
        $jacocoInit[68] = true;
        this.title = args.getString(translate);
        $jacocoInit[69] = true;
        this.action = args.getString("action");
        $jacocoInit[70] = true;
        this.storeTheme = args.getString("storeTheme");
        $jacocoInit[71] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        String url;
        boolean[] $jacocoInit = $jacocoInit();
        super.load(create, refresh, savedInstanceState);
        $jacocoInit[72] = true;
        if (create) {
            $jacocoInit[73] = true;
        } else if (refresh) {
            $jacocoInit[74] = true;
        } else if (hasDisplayables()) {
            $jacocoInit[75] = true;
            $jacocoInit[90] = true;
            return;
        } else {
            $jacocoInit[76] = true;
        }
        String str = this.action;
        if (str != null) {
            $jacocoInit[77] = true;
            SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
            $jacocoInit[78] = true;
            url = str.replace(C0044V7.getHost(defaultSharedPreferences), "");
            $jacocoInit[79] = true;
        } else {
            url = null;
            $jacocoInit[80] = true;
        }
        $jacocoInit[81] = true;
        if (StoreTabFragmentChooser.validateAcceptedName(this.name)) {
            $jacocoInit[85] = true;
            Observable<List<Displayable>> displayablesObservable = buildDisplayables(refresh, url, refresh);
            if (displayablesObservable == null) {
                $jacocoInit[86] = true;
            } else {
                $jacocoInit[87] = true;
                C0120S a = displayablesObservable.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(LifecycleEvent.DESTROY));
                C4940Aa aa = new C4940Aa(this);
                C5101za zaVar = new C5101za(this);
                $jacocoInit[88] = true;
                a.mo3626a((C0129b<? super T>) aa, (C0129b<Throwable>) zaVar);
                $jacocoInit[89] = true;
            }
            $jacocoInit[90] = true;
            return;
        }
        $jacocoInit[82] = true;
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid name(");
        sb.append(this.name);
        sb.append(") for event on ");
        $jacocoInit[83] = true;
        sb.append(getClass().getSimpleName());
        sb.append("!");
        RuntimeException runtimeException = new RuntimeException(sb.toString());
        $jacocoInit[84] = true;
        throw runtimeException;
    }

    /* renamed from: a */
    static /* synthetic */ void m9346a(DisplayableManager displayableManager, List displayables) {
        boolean[] $jacocoInit = $jacocoInit();
        DisplayableManager clearDisplayables = displayableManager.clearDisplayables();
        $jacocoInit[107] = true;
        clearDisplayables.addDisplayables(displayables, true);
        $jacocoInit[108] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16612a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[104] = true;
        instance.log(err);
        $jacocoInit[105] = true;
        finishLoading(err);
        $jacocoInit[106] = true;
    }

    public int getContentViewId() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.title != null) {
            $jacocoInit[91] = true;
            return C1375R.layout.recycler_swipe_fragment_with_toolbar;
        }
        int contentViewId = super.getContentViewId();
        $jacocoInit[92] = true;
        return contentViewId;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[93] = true;
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[94] = true;
        return true;
    }

    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        toolbar.setTitle((CharSequence) Translator.translate(this.title, getContext().getApplicationContext(), this.marketName));
        $jacocoInit[95] = true;
        toolbar.setLogo((int) C1375R.drawable.logo_toolbar);
        $jacocoInit[96] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[97] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[98] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[99] = true;
            getActivity().onBackPressed();
            $jacocoInit[100] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[101] = true;
        return onOptionsItemSelected;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViews();
        $jacocoInit[102] = true;
        setupToolbar();
        $jacocoInit[103] = true;
    }
}
