package p005cm.aptoide.p006pt.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetApp;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetApp.Nodes;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Media;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetAppRequest;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.utils.AptoideUtils.HtmlU;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.ThemeUtils;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.view.fragment.DescriptionFragment */
public class DescriptionFragment extends BaseLoaderToolbarFragment implements NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String APP_ID = "app_id";
    private static final String APP_NAME = "APP_NAME";
    private static final String DESCRIPTION = "description";
    private static final String PACKAGE_NAME = "packageName";
    private static final String STORE_NAME = "store_name";
    private static final String STORE_THEME = "store_theme";
    private static final String TAG = DescriptionFragment.class.getSimpleName();
    private long appId;
    private String appName;
    private BodyInterceptor<BaseBody> baseBodyBodyInterceptor;
    private Factory converterFactory;
    private String description;
    private TextView descriptionContainer;
    private TextView emptyData;
    private boolean hasAppId = false;
    private OkHttpClient httpClient;
    private String packageName;
    private String partnerId;
    private StoreCredentialsProvider storeCredentialsProvider;
    private String storeName;
    private String storeTheme;
    @Inject
    String theme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5590768363947727396L, "cm/aptoide/pt/view/fragment/DescriptionFragment", Opcodes.LXOR);
        $jacocoData = probes;
        return probes;
    }

    public DescriptionFragment() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[130] = true;
    }

    public static DescriptionFragment newInstance(String appName2, String description2, String storeTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        DescriptionFragment fragment = new DescriptionFragment();
        $jacocoInit[1] = true;
        Bundle args = new Bundle();
        $jacocoInit[2] = true;
        args.putString(APP_NAME, appName2);
        $jacocoInit[3] = true;
        args.putString("store_theme", storeTheme2);
        $jacocoInit[4] = true;
        args.putString("description", description2);
        $jacocoInit[5] = true;
        fragment.setArguments(args);
        $jacocoInit[6] = true;
        return fragment;
    }

    public static DescriptionFragment newInstance(long appId2, String packageName2, String storeName2, String storeTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        DescriptionFragment fragment = new DescriptionFragment();
        $jacocoInit[7] = true;
        Bundle args = new Bundle();
        $jacocoInit[8] = true;
        args.putLong("app_id", appId2);
        $jacocoInit[9] = true;
        args.putString("packageName", packageName2);
        $jacocoInit[10] = true;
        args.putString("store_name", storeName2);
        $jacocoInit[11] = true;
        args.putString("store_theme", storeTheme2);
        $jacocoInit[12] = true;
        fragment.setArguments(args);
        $jacocoInit[13] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[14] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[15] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[16] = true;
        $jacocoInit[17] = true;
        this.storeCredentialsProvider = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[18] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[19] = true;
        this.baseBodyBodyInterceptor = application.getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[20] = true;
        this.httpClient = application.getDefaultClient();
        $jacocoInit[21] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[22] = true;
        this.partnerId = application.getPartnerId();
        $jacocoInit[23] = true;
        setHasOptionsMenu(true);
        $jacocoInit[24] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[25] = true;
        String str = "app_id";
        if (!args.containsKey(str)) {
            $jacocoInit[26] = true;
        } else {
            $jacocoInit[27] = true;
            this.appId = args.getLong(str, -1);
            this.hasAppId = true;
            $jacocoInit[28] = true;
        }
        String str2 = "packageName";
        if (!args.containsKey(str2)) {
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
            this.packageName = args.getString(str2);
            $jacocoInit[31] = true;
        }
        String str3 = "store_name";
        if (!args.containsKey(str3)) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            this.storeName = args.getString(str3);
            $jacocoInit[34] = true;
        }
        String str4 = "store_theme";
        if (!args.containsKey(str4)) {
            $jacocoInit[35] = true;
        } else {
            $jacocoInit[36] = true;
            this.storeTheme = args.getString(str4);
            $jacocoInit[37] = true;
        }
        String str5 = "description";
        if (!args.containsKey(str5)) {
            $jacocoInit[38] = true;
        } else {
            $jacocoInit[39] = true;
            this.description = args.getString(str5);
            $jacocoInit[40] = true;
        }
        String str6 = APP_NAME;
        if (!args.containsKey(str6)) {
            $jacocoInit[41] = true;
        } else {
            $jacocoInit[42] = true;
            this.appName = args.getString(str6);
            $jacocoInit[43] = true;
        }
        $jacocoInit[44] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[45] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[46] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[47] = true;
        return build;
    }

    /* access modifiers changed from: protected */
    public int[] getViewsToShowAfterLoadingId() {
        int[] iArr = new int[0];
        $jacocoInit()[48] = true;
        return iArr;
    }

    /* access modifiers changed from: protected */
    public int getViewToShowAfterLoadingId() {
        $jacocoInit()[49] = true;
        return C1375R.C1376id.data_container;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        if (TextUtils.isEmpty(this.description)) {
            $jacocoInit[50] = true;
        } else if (TextUtils.isEmpty(this.appName)) {
            $jacocoInit[51] = true;
        } else {
            $jacocoInit[52] = true;
            this.descriptionContainer.setText(HtmlU.parse(this.description));
            $jacocoInit[53] = true;
            if (!hasToolbar()) {
                $jacocoInit[54] = true;
            } else {
                $jacocoInit[55] = true;
                C0760a bar = ((C0019n) getActivity()).getSupportActionBar();
                if (bar == null) {
                    $jacocoInit[56] = true;
                } else {
                    $jacocoInit[57] = true;
                    bar.mo6147a((CharSequence) this.appName);
                    $jacocoInit[58] = true;
                }
            }
            finishLoading();
            $jacocoInit[59] = true;
            $jacocoInit[71] = true;
        }
        if (this.hasAppId) {
            long j = this.appId;
            if (this.partnerId == null) {
                str = null;
                $jacocoInit[60] = true;
            } else {
                str = this.storeName;
                $jacocoInit[61] = true;
            }
            String str2 = str;
            String str3 = this.storeName;
            StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
            $jacocoInit[62] = true;
            StoreCredentials storeCredentials = StoreUtils.getStoreCredentials(str3, storeCredentialsProvider2);
            String str4 = this.packageName;
            BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyBodyInterceptor;
            OkHttpClient okHttpClient = this.httpClient;
            Factory factory = this.converterFactory;
            $jacocoInit[63] = true;
            TokenInvalidator tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
            $jacocoInit[64] = true;
            SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
            $jacocoInit[65] = true;
            GetAppRequest of = GetAppRequest.m7460of(j, str2, storeCredentials, str4, bodyInterceptor, okHttpClient, factory, tokenInvalidator, defaultSharedPreferences);
            C5346b bVar = new C5346b(this);
            $jacocoInit[66] = true;
            of.execute((SuccessRequestListener<U>) bVar, false);
            $jacocoInit[67] = true;
        } else {
            Logger instance = Logger.getInstance();
            String str5 = TAG;
            $jacocoInit[68] = true;
            instance.mo2140e(str5, "App id unavailable");
            $jacocoInit[69] = true;
            setDataUnavailable();
            $jacocoInit[70] = true;
        }
        $jacocoInit[71] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17247a(GetApp getApp) {
        boolean[] $jacocoInit = $jacocoInit();
        setupAppDescription(getApp);
        $jacocoInit[127] = true;
        setupTitle(getApp);
        $jacocoInit[128] = true;
        finishLoading();
        $jacocoInit[129] = true;
    }

    private void setupAppDescription(GetApp getApp) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            Nodes nodes = getApp.getNodes();
            $jacocoInit[72] = true;
            GetAppMeta meta = nodes.getMeta();
            $jacocoInit[73] = true;
            App data = meta.getData();
            $jacocoInit[74] = true;
            Media media = data.getMedia();
            $jacocoInit[75] = true;
            if (!TextUtils.isEmpty(media.getDescription())) {
                $jacocoInit[76] = true;
                this.descriptionContainer.setText(HtmlU.parse(media.getDescription()));
                $jacocoInit[77] = true;
                return;
            }
            $jacocoInit[78] = true;
            setDataUnavailable();
            $jacocoInit[82] = true;
        } catch (NullPointerException e) {
            $jacocoInit[79] = true;
            CrashReport instance = CrashReport.getInstance();
            $jacocoInit[80] = true;
            instance.log(e);
            $jacocoInit[81] = true;
        }
    }

    private void setupTitle(GetApp getApp) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            Nodes nodes = getApp.getNodes();
            $jacocoInit[83] = true;
            GetAppMeta meta = nodes.getMeta();
            $jacocoInit[84] = true;
            App data = meta.getData();
            $jacocoInit[85] = true;
            String appName2 = data.getName();
            $jacocoInit[86] = true;
            if (TextUtils.isEmpty(appName2)) {
                $jacocoInit[87] = true;
            } else {
                $jacocoInit[88] = true;
                if (!hasToolbar()) {
                    $jacocoInit[89] = true;
                } else {
                    $jacocoInit[90] = true;
                    C0760a bar = ((C0019n) getActivity()).getSupportActionBar();
                    $jacocoInit[91] = true;
                    bar.mo6147a((CharSequence) appName2);
                    $jacocoInit[92] = true;
                    return;
                }
            }
            $jacocoInit[93] = true;
        } catch (NullPointerException e) {
            $jacocoInit[94] = true;
            CrashReport instance = CrashReport.getInstance();
            $jacocoInit[95] = true;
            instance.log(e);
            $jacocoInit[96] = true;
        }
        setDataUnavailable();
        $jacocoInit[97] = true;
    }

    private void setDataUnavailable() {
        boolean[] $jacocoInit = $jacocoInit();
        this.emptyData.setVisibility(0);
        $jacocoInit[98] = true;
        this.descriptionContainer.setVisibility(8);
        $jacocoInit[99] = true;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[100] = true;
        return true;
    }

    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.storeTheme == null) {
            $jacocoInit[101] = true;
        } else {
            $jacocoInit[102] = true;
            C0760a bar = ((C0019n) getActivity()).getSupportActionBar();
            $jacocoInit[103] = true;
            ThemeUtils.setStatusBarThemeColor(getActivity(), this.storeTheme);
            if (bar == null) {
                $jacocoInit[104] = true;
            } else {
                $jacocoInit[105] = true;
                Resources resources = getActivity().getResources();
                String str = this.storeTheme;
                $jacocoInit[106] = true;
                StoreTheme storeTheme2 = StoreTheme.get(str);
                $jacocoInit[107] = true;
                int gradientDrawable = storeTheme2.getGradientDrawable();
                $jacocoInit[108] = true;
                Drawable drawable = resources.getDrawable(gradientDrawable);
                $jacocoInit[109] = true;
                bar.mo6146a(drawable);
                $jacocoInit[110] = true;
            }
        }
        $jacocoInit[111] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[112] = true;
        this.emptyData = (TextView) view.findViewById(C1375R.C1376id.empty_data);
        $jacocoInit[113] = true;
        this.descriptionContainer = (TextView) view.findViewById(C1375R.C1376id.data_container);
        $jacocoInit[114] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        ThemeUtils.setStatusBarThemeColor(getActivity(), this.theme);
        $jacocoInit[115] = true;
        C0760a bar = ((C0019n) getActivity()).getSupportActionBar();
        if (bar == null) {
            $jacocoInit[116] = true;
        } else {
            $jacocoInit[117] = true;
            Resources resources = getActivity().getResources();
            String str = this.theme;
            $jacocoInit[118] = true;
            StoreTheme storeTheme2 = StoreTheme.get(str);
            $jacocoInit[119] = true;
            int gradientDrawable = storeTheme2.getGradientDrawable();
            $jacocoInit[120] = true;
            Drawable drawable = resources.getDrawable(gradientDrawable);
            $jacocoInit[121] = true;
            bar.mo6146a(drawable);
            $jacocoInit[122] = true;
        }
        super.onDestroyView();
        $jacocoInit[123] = true;
    }

    public int getContentViewId() {
        $jacocoInit()[124] = true;
        return C1375R.layout.fragment_app_view_description;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[125] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[126] = true;
    }
}
