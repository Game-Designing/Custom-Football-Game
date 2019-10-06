package p005cm.aptoide.p006pt.store.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.WindowManager;
import java.util.List;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablesFactory;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment */
public abstract class StoreTabWidgetsGridRecyclerFragment extends StoreTabGridRecyclerFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    protected AptoideAccountManager accountManager;
    @Inject
    AnalyticsManager analyticsManager;
    protected InstalledRepository installedRepository;
    @Inject
    String marketName;
    protected NavigationTracker navigationTracker;
    protected StoreAnalytics storeAnalytics;
    private StoreTabNavigator storeTabNavigator;
    protected StoreUtilsProxy storeUtilsProxy;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7858265079318518442L, "cm/aptoide/pt/store/view/StoreTabWidgetsGridRecyclerFragment", 37);
        $jacocoData = probes;
        return probes;
    }

    public StoreTabWidgetsGridRecyclerFragment() {
        $jacocoInit()[0] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[2] = true;
        this.navigationTracker = ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker();
        $jacocoInit[3] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[4] = true;
        $jacocoInit[5] = true;
        StoreCredentialsProvider storeCredentialsProvider = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[6] = true;
        OkHttpClient httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[7] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[8] = true;
        BodyInterceptor<BaseBody> bodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[9] = true;
        TokenInvalidator tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        $jacocoInit[10] = true;
        Context applicationContext2 = getContext().getApplicationContext();
        $jacocoInit[11] = true;
        $jacocoInit[12] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext2.getApplicationContext()).getDatabase(), Store.class);
        $jacocoInit[13] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        $jacocoInit[14] = true;
        StoreUtilsProxy storeUtilsProxy2 = new StoreUtilsProxy(aptoideAccountManager, bodyInterceptor, storeCredentialsProvider, storeAccessor, httpClient, defaultConverter, tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
        this.storeUtilsProxy = storeUtilsProxy2;
        $jacocoInit[15] = true;
        this.installedRepository = RepositoryFactory.getInstalledRepository(getContext().getApplicationContext());
        $jacocoInit[16] = true;
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        $jacocoInit[17] = true;
        this.storeTabNavigator = new StoreTabNavigator(getFragmentNavigator());
        $jacocoInit[18] = true;
    }

    public C0120S<List<Displayable>> parseDisplayables(GetStoreWidgets getStoreWidgets) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = getStoreWidgets.getDataList();
        $jacocoInit[19] = true;
        List list = dataList.getList();
        $jacocoInit[20] = true;
        C0120S a = C0120S.m629a((Iterable<? extends T>) list);
        C4944Ba ba = new C4944Ba(this);
        $jacocoInit[21] = true;
        C0120S b = a.mo3637b((C0132p<? super T, ? extends C0120S<? extends R>>) ba);
        $jacocoInit[22] = true;
        C0120S m = b.mo3675m();
        $jacocoInit[23] = true;
        C0120S<List<Displayable>> d = m.mo3647d();
        $jacocoInit[24] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16617a(WSWidget wsWidget) {
        WSWidget wSWidget = wsWidget;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[25] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        String str = this.marketName;
        String str2 = this.storeTheme;
        StoreRepository storeRepository = this.storeRepository;
        StoreContext storeContext = this.storeContext;
        $jacocoInit[26] = true;
        Context context = getContext();
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        StoreUtilsProxy storeUtilsProxy2 = this.storeUtilsProxy;
        $jacocoInit[27] = true;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        $jacocoInit[28] = true;
        Resources resources = getContext().getResources();
        InstalledRepository installedRepository2 = this.installedRepository;
        StoreAnalytics storeAnalytics2 = this.storeAnalytics;
        StoreTabNavigator storeTabNavigator2 = this.storeTabNavigator;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[29] = true;
        String str3 = str;
        BadgeDialogFactory badgeDialogFactory = new BadgeDialogFactory(getContext());
        $jacocoInit[30] = true;
        FragmentNavigator fragmentNavigator = ((ActivityResultNavigator) getContext()).getFragmentNavigator();
        $jacocoInit[31] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(application.getDatabase(), Store.class);
        $jacocoInit[32] = true;
        BodyInterceptor bodyInterceptorPoolV7 = application.getBodyInterceptorPoolV7();
        OkHttpClient defaultClient = application.getDefaultClient();
        $jacocoInit[33] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        TokenInvalidator tokenInvalidator = application.getTokenInvalidator();
        $jacocoInit[34] = true;
        SharedPreferences defaultSharedPreferences = application.getDefaultSharedPreferences();
        $jacocoInit[35] = true;
        C0120S parse = DisplayablesFactory.parse(str3, wSWidget, str2, storeRepository, storeContext, context, aptoideAccountManager, storeUtilsProxy2, windowManager, resources, installedRepository2, storeAnalytics2, storeTabNavigator2, navigationTracker2, badgeDialogFactory, fragmentNavigator, storeAccessor, bodyInterceptorPoolV7, defaultClient, defaultConverter, tokenInvalidator, defaultSharedPreferences);
        $jacocoInit[36] = true;
        return parse;
    }
}
