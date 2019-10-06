package p005cm.aptoide.p006pt.store.view.p079my;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Layout;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.ListStores;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.WSWidgetsUtils;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetMyStoreListRequest;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.store.view.GetStoreEndlessFragment;
import p005cm.aptoide.p006pt.store.view.GridStoreDisplayable;
import p005cm.aptoide.p006pt.store.view.recommended.RecommendedStoreDisplayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablesFactory;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.store.view.my.MyStoresSubscribedFragment */
public class MyStoresSubscribedFragment extends GetStoreEndlessFragment<ListStores> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String USER_NOT_LOGGED_ERROR = "AUTH-5";
    private AptoideAccountManager accountManager;
    @Inject
    AnalyticsManager analyticsManager;
    private BodyInterceptor<BaseBody> bodyInterceptor;
    private Factory converterFactory;
    private OkHttpClient httpClient;
    @Inject
    NavigationTracker navigationTracker;
    private StoreAnalytics storeAnalytics;
    private StoreCredentialsProvider storeCredentialsProvider;
    private TokenInvalidator tokenInvalidator;
    private WSWidgetsUtils widgetsUtils;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3302811625394900591L, "cm/aptoide/pt/store/view/my/MyStoresSubscribedFragment", 60);
        $jacocoData = probes;
        return probes;
    }

    public MyStoresSubscribedFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        MyStoresSubscribedFragment myStoresSubscribedFragment = new MyStoresSubscribedFragment();
        $jacocoInit[1] = true;
        return myStoresSubscribedFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[3] = true;
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[4] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[5] = true;
        $jacocoInit[6] = true;
        this.storeCredentialsProvider = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[7] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[8] = true;
        this.bodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[9] = true;
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[10] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[11] = true;
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        $jacocoInit[12] = true;
        this.widgetsUtils = new WSWidgetsUtils();
        $jacocoInit[13] = true;
    }

    /* access modifiers changed from: protected */
    public C0044V7<ListStores, ? extends Endless> buildRequest(boolean refresh, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[14] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[15] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[16] = true;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        $jacocoInit[17] = true;
        GetMyStoreListRequest request = GetMyStoreListRequest.m7581of(url, true, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences, resources, windowManager);
        $jacocoInit[18] = true;
        return request;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16683a(ListStores listStores) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = listStores.getDataList();
        $jacocoInit[57] = true;
        List list = dataList.getList();
        $jacocoInit[58] = true;
        addDisplayables(getStoresDisplayable(list));
        $jacocoInit[59] = true;
    }

    /* access modifiers changed from: protected */
    public C0129b<ListStores> buildAction() {
        boolean[] $jacocoInit = $jacocoInit();
        C5031A a = new C5031A(this);
        $jacocoInit[19] = true;
        return a;
    }

    /* access modifiers changed from: protected */
    public ErrorRequestListener getErrorRequestListener() {
        boolean[] $jacocoInit = $jacocoInit();
        C5058w wVar = new C5058w(this);
        $jacocoInit[20] = true;
        return wVar;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16685b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        getRecyclerView().mo7557c();
        $jacocoInit[45] = true;
        LinkedList<String> errorsList = new LinkedList<>();
        $jacocoInit[46] = true;
        errorsList.add(USER_NOT_LOGGED_ERROR);
        $jacocoInit[47] = true;
        if (this.widgetsUtils.shouldAddObjectView(errorsList, throwable)) {
            $jacocoInit[48] = true;
            C0120S loadLocalSubscribedStores = DisplayablesFactory.loadLocalSubscribedStores(this.storeRepository);
            LifecycleEvent lifecycleEvent = LifecycleEvent.DESTROY;
            $jacocoInit[49] = true;
            C0120S a = loadLocalSubscribedStores.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(lifecycleEvent));
            C5060y yVar = new C5060y(this);
            C5061z zVar = C5061z.f8749a;
            $jacocoInit[50] = true;
            a.mo3626a((C0129b<? super T>) yVar, (C0129b<Throwable>) zVar);
            $jacocoInit[51] = true;
        } else {
            finishLoading(throwable);
            $jacocoInit[52] = true;
        }
        $jacocoInit[53] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16684a(List stores) {
        boolean[] $jacocoInit = $jacocoInit();
        addDisplayables(getStoresDisplayable(stores));
        $jacocoInit[56] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9398c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[54] = true;
        instance.log(err);
        $jacocoInit[55] = true;
    }

    private ArrayList<Displayable> getStoresDisplayable(List<p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store> list) {
        List<p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store> list2 = list;
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<Displayable> storesDisplayables = new ArrayList<>(list.size());
        $jacocoInit[21] = true;
        Collections.sort(list2, C5059x.f8747a);
        $jacocoInit[22] = true;
        int i = 0;
        $jacocoInit[23] = true;
        while (i < list.size()) {
            if (i == 0) {
                $jacocoInit[24] = true;
            } else {
                int i2 = i - 1;
                $jacocoInit[25] = true;
                p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store = (p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store) list2.get(i2);
                $jacocoInit[26] = true;
                long id = store.getId();
                p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store2 = (p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store) list2.get(i);
                $jacocoInit[27] = true;
                if (id == store2.getId()) {
                    $jacocoInit[28] = true;
                    i++;
                    $jacocoInit[41] = true;
                } else {
                    $jacocoInit[29] = true;
                }
            }
            if (this.layout == Layout.LIST) {
                $jacocoInit[30] = true;
                p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store3 = (p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store) list2.get(i);
                StoreRepository storeRepository = this.storeRepository;
                AptoideAccountManager aptoideAccountManager = this.accountManager;
                BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
                StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
                $jacocoInit[31] = true;
                Context applicationContext = getContext().getApplicationContext();
                $jacocoInit[32] = true;
                $jacocoInit[33] = true;
                StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class);
                OkHttpClient okHttpClient = this.httpClient;
                $jacocoInit[34] = true;
                Factory defaultConverter = WebService.getDefaultConverter();
                TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
                $jacocoInit[35] = true;
                TokenInvalidator tokenInvalidator3 = tokenInvalidator2;
                StoreUtilsProxy storeUtilsProxy = new StoreUtilsProxy(aptoideAccountManager, bodyInterceptor2, storeCredentialsProvider2, storeAccessor, okHttpClient, defaultConverter, tokenInvalidator3, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
                RecommendedStoreDisplayable recommendedStoreDisplayable = new RecommendedStoreDisplayable(store3, storeRepository, aptoideAccountManager, storeUtilsProxy, this.storeCredentialsProvider);
                $jacocoInit[36] = true;
                storesDisplayables.add(recommendedStoreDisplayable);
                $jacocoInit[37] = true;
            } else {
                $jacocoInit[38] = true;
                GridStoreDisplayable gridStoreDisplayable = new GridStoreDisplayable((p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store) list2.get(i), "More Followed Stores", this.storeAnalytics);
                $jacocoInit[39] = true;
                storesDisplayables.add(gridStoreDisplayable);
                $jacocoInit[40] = true;
            }
            i++;
            $jacocoInit[41] = true;
        }
        $jacocoInit[42] = true;
        return storesDisplayables;
    }

    /* renamed from: a */
    static /* synthetic */ int m9397a(p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store, p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store t1) {
        boolean[] $jacocoInit = $jacocoInit();
        String name = store.getName();
        $jacocoInit[43] = true;
        int compareTo = name.compareTo(t1.getName());
        $jacocoInit[44] = true;
        return compareTo;
    }
}
