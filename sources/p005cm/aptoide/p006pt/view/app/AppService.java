package p005cm.aptoide.p006pt.view.app;

import android.content.SharedPreferences;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp.Path;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp.Payment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetApp;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetApp.Nodes;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Age;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Developer;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.GetAppMetaFile;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.GetAppMetaFile.Flags;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.GetAppMetaFile.Flags.Vote;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.GetAppMetaFile.Flags.Vote.Type;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.GetAppMetaFile.Signature;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Media;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Media.Screenshot;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Media.Video;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Pay;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Urls;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListApps;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Rank;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats.Rating;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.AppCoinsInfo;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.File;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.ListAppVersions;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.GetApkInfoRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetAppRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetRecommendedRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListAppsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListAppsRequest.Body;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.repository.exception.RepositoryItemNotFoundException;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.view.app.AppsList.Error;
import p005cm.aptoide.p006pt.view.app.FlagsVote.VoteType;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.view.app.AppService */
public class AppService {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int MATURE_APP_RATING = 18;
    private final BodyInterceptor<BaseBody> bodyInterceptorV3;
    private final BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody> bodyInterceptorV7;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private boolean loadingAppcSimilarApps;
    private boolean loadingApps;
    private boolean loadingSimilarApps;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;

    /* renamed from: cm.aptoide.pt.view.app.AppService$1 */
    static /* synthetic */ class C52271 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type */
        static final /* synthetic */ int[] f8996xb9b5ac52 = new int[Type.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(1918435809670976767L, "cm/aptoide/pt/view/app/AppService$1", 12);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f8996xb9b5ac52[Type.FAKE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                $jacocoInit[10] = true;
                            }
                        }
                    }
                }
            }
            f8996xb9b5ac52[Type.GOOD.ordinal()] = 2;
            $jacocoInit[3] = true;
            f8996xb9b5ac52[Type.VIRUS.ordinal()] = 3;
            $jacocoInit[5] = true;
            f8996xb9b5ac52[Type.FREEZE.ordinal()] = 4;
            $jacocoInit[7] = true;
            f8996xb9b5ac52[Type.LICENSE.ordinal()] = 5;
            $jacocoInit[9] = true;
            $jacocoInit[11] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8557502453068843403L, "cm/aptoide/pt/view/app/AppService", 273);
        $jacocoData = probes;
        return probes;
    }

    public AppService(StoreCredentialsProvider storeCredentialsProvider2, BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody> bodyInterceptorV72, BodyInterceptor<BaseBody> bodyInterceptorV32, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, Resources resources2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.bodyInterceptorV7 = bodyInterceptorV72;
        this.bodyInterceptorV3 = bodyInterceptorV32;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.resources = resources2;
        $jacocoInit[0] = true;
    }

    private Single<AppsList> loadApps(long storeId, boolean bypassCache, int offset, int limit) {
        long j = storeId;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loadingApps) {
            $jacocoInit[1] = true;
            Single<AppsList> a = Single.m734a(new AppsList(true));
            $jacocoInit[2] = true;
            return a;
        }
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[3] = true;
        Body body = new Body(storeCredentialsProvider2.get(j), limit, this.sharedPreferences);
        $jacocoInit[4] = true;
        body.setOffset(offset);
        $jacocoInit[5] = true;
        body.setStoreId(j);
        $jacocoInit[6] = true;
        ListAppsRequest listAppsRequest = new ListAppsRequest(body, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[7] = true;
        C0120S observe = listAppsRequest.observe(bypassCache, false);
        C5253V v = new C5253V(this);
        $jacocoInit[8] = true;
        C0120S b = observe.mo3635b((C0128a) v);
        C5290q qVar = new C5290q(this);
        $jacocoInit[9] = true;
        C0120S d = b.mo3652d((C0128a) qVar);
        C5241L l = new C5241L(this);
        $jacocoInit[10] = true;
        C0120S c = d.mo3644c((C0128a) l);
        C5300v vVar = new C5300v(this);
        $jacocoInit[11] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vVar);
        $jacocoInit[12] = true;
        Single n = f.mo3678n();
        C5235F f2 = new C5235F(this);
        $jacocoInit[13] = true;
        Single<AppsList> f3 = n.mo3700f(f2);
        $jacocoInit[14] = true;
        return f3;
    }

    /* renamed from: d */
    public /* synthetic */ void mo16977d() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = true;
        $jacocoInit[272] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo16979e() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = false;
        $jacocoInit[271] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo16981f() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = false;
        $jacocoInit[270] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo16970b(ListApps appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapListApps = mapListApps(appsList);
        $jacocoInit[269] = true;
        return mapListApps;
    }

    /* renamed from: b */
    public /* synthetic */ AppsList mo16968b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsList createErrorAppsList = createErrorAppsList(throwable);
        $jacocoInit[268] = true;
        return createErrorAppsList;
    }

    private C0120S<AppsList> mapListApps(ListApps listApps) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (listApps.isOk()) {
            $jacocoInit[15] = true;
            List<Application> list = new ArrayList<>();
            $jacocoInit[16] = true;
            DataList dataList = listApps.getDataList();
            $jacocoInit[17] = true;
            List<App> list2 = dataList.getList();
            $jacocoInit[18] = true;
            $jacocoInit[19] = true;
            for (App app : list2) {
                $jacocoInit[20] = true;
                String name = app.getName();
                String icon = app.getIcon();
                Stats stats = app.getStats();
                $jacocoInit[21] = true;
                Rating rating = stats.getRating();
                $jacocoInit[22] = true;
                float avg = rating.getAvg();
                Stats stats2 = app.getStats();
                $jacocoInit[23] = true;
                int downloads = stats2.getDownloads();
                String packageName = app.getPackageName();
                long id = app.getId();
                $jacocoInit[24] = true;
                if (app.getAppcoins() == null) {
                    $jacocoInit[25] = true;
                } else {
                    AppCoinsInfo appcoins = app.getAppcoins();
                    $jacocoInit[26] = true;
                    if (!appcoins.hasBilling()) {
                        $jacocoInit[27] = true;
                    } else {
                        $jacocoInit[28] = true;
                        z = true;
                        Application application = new Application(name, icon, avg, downloads, packageName, id, "", z);
                        $jacocoInit[30] = true;
                        list.add(application);
                        $jacocoInit[31] = true;
                    }
                }
                $jacocoInit[29] = true;
                z = false;
                Application application2 = new Application(name, icon, avg, downloads, packageName, id, "", z);
                $jacocoInit[30] = true;
                list.add(application2);
                $jacocoInit[31] = true;
            }
            DataList dataList2 = listApps.getDataList();
            $jacocoInit[32] = true;
            AppsList appsList = new AppsList(list, false, dataList2.getNext());
            $jacocoInit[33] = true;
            C0120S<AppsList> c = C0120S.m652c(appsList);
            $jacocoInit[34] = true;
            return c;
        }
        C0120S<AppsList> a = C0120S.m631a((Throwable) new IllegalStateException("Could not obtain request from server."));
        $jacocoInit[35] = true;
        return a;
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(long appId, String storeName, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loadingApps) {
            $jacocoInit[36] = true;
            Single<DetailedAppRequestResult> a = Single.m734a(new DetailedAppRequestResult(true));
            $jacocoInit[37] = true;
            return a;
        }
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[38] = true;
        StoreCredentials storeCredentials = StoreUtils.getStoreCredentials(storeName, storeCredentialsProvider2);
        BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody> bodyInterceptor = this.bodyInterceptorV7;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[39] = true;
        GetAppRequest of = GetAppRequest.m7460of(appId, null, storeCredentials, packageName, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2);
        $jacocoInit[40] = true;
        C0120S observe = of.observe(false, false);
        C5245M m = new C5245M(this);
        $jacocoInit[41] = true;
        C0120S b = observe.mo3635b((C0128a) m);
        C5284n nVar = new C5284n(this);
        $jacocoInit[42] = true;
        C0120S d = b.mo3652d((C0128a) nVar);
        C5282m mVar = new C5282m(this);
        $jacocoInit[43] = true;
        C0120S c = d.mo3644c((C0128a) mVar);
        C5292r rVar = new C5292r(this);
        $jacocoInit[44] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rVar);
        $jacocoInit[45] = true;
        Single n = f.mo3678n();
        C5234E e = new C5234E(this);
        $jacocoInit[46] = true;
        Single<DetailedAppRequestResult> f2 = n.mo3700f(e);
        $jacocoInit[47] = true;
        return f2;
    }

    /* renamed from: j */
    public /* synthetic */ void mo16986j() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = true;
        $jacocoInit[267] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo16987k() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = false;
        $jacocoInit[266] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo16988l() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = false;
        $jacocoInit[265] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo16969b(GetApp getApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapApp = mapApp(getApp, "");
        $jacocoInit[264] = true;
        return mapApp;
    }

    /* renamed from: d */
    public /* synthetic */ DetailedAppRequestResult mo16976d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedAppRequestResult createDetailedAppRequestResultError = createDetailedAppRequestResultError(throwable);
        $jacocoInit[263] = true;
        return createDetailedAppRequestResultError;
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(String packageName, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loadingApps) {
            $jacocoInit[48] = true;
            Single<DetailedAppRequestResult> a = Single.m734a(new DetailedAppRequestResult(true));
            $jacocoInit[49] = true;
            return a;
        }
        GetAppRequest of = GetAppRequest.m7463of(packageName, storeName, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[50] = true;
        C0120S observe = of.observe(false, false);
        C5249Q q = new C5249Q(this);
        $jacocoInit[51] = true;
        C0120S b = observe.mo3635b((C0128a) q);
        C5286o oVar = new C5286o(this);
        $jacocoInit[52] = true;
        C0120S d = b.mo3652d((C0128a) oVar);
        C5237H h = new C5237H(this);
        $jacocoInit[53] = true;
        C0120S c = d.mo3644c((C0128a) h);
        C5225A a2 = new C5225A(this);
        $jacocoInit[54] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) a2);
        $jacocoInit[55] = true;
        Single n = f.mo3678n();
        C5232D d2 = new C5232D(this);
        $jacocoInit[56] = true;
        Single<DetailedAppRequestResult> f2 = n.mo3700f(d2);
        $jacocoInit[57] = true;
        return f2;
    }

    /* renamed from: g */
    public /* synthetic */ void mo16983g() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = true;
        $jacocoInit[262] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo16984h() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = false;
        $jacocoInit[261] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo16985i() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = false;
        $jacocoInit[260] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16964a(GetApp getApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapApp = mapApp(getApp, "");
        $jacocoInit[259] = true;
        return mapApp;
    }

    /* renamed from: c */
    public /* synthetic */ DetailedAppRequestResult mo16972c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedAppRequestResult createDetailedAppRequestResultError = createDetailedAppRequestResultError(throwable);
        $jacocoInit[258] = true;
        return createDetailedAppRequestResultError;
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromMd5(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loadingApps) {
            $jacocoInit[58] = true;
            Single<DetailedAppRequestResult> a = Single.m734a(new DetailedAppRequestResult(true));
            $jacocoInit[59] = true;
            return a;
        }
        GetAppRequest ofMd5 = GetAppRequest.ofMd5(md5, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[60] = true;
        C0120S observe = ofMd5.observe(false, ManagerPreferences.getAndResetForceServerRefresh(sharedPreferences2));
        C5252U u = new C5252U(this);
        $jacocoInit[61] = true;
        C0120S b = observe.mo3635b((C0128a) u);
        C5298u uVar = new C5298u(this);
        $jacocoInit[62] = true;
        C0120S d = b.mo3652d((C0128a) uVar);
        C5304x xVar = new C5304x(this);
        $jacocoInit[63] = true;
        C0120S c = d.mo3644c((C0128a) xVar);
        C5239J j = new C5239J(this);
        $jacocoInit[64] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) j);
        $jacocoInit[65] = true;
        Single n = f.mo3678n();
        C5228B b2 = new C5228B(this);
        $jacocoInit[66] = true;
        Single<DetailedAppRequestResult> f2 = n.mo3700f(b2);
        $jacocoInit[67] = true;
        return f2;
    }

    /* renamed from: m */
    public /* synthetic */ void mo16997m() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = true;
        $jacocoInit[257] = true;
    }

    /* renamed from: n */
    public /* synthetic */ void mo16998n() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = false;
        $jacocoInit[256] = true;
    }

    /* renamed from: o */
    public /* synthetic */ void mo16999o() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = false;
        $jacocoInit[255] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo16973c(GetApp getApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapApp = mapApp(getApp, "");
        $jacocoInit[254] = true;
        return mapApp;
    }

    /* renamed from: e */
    public /* synthetic */ DetailedAppRequestResult mo16978e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedAppRequestResult createDetailedAppRequestResultError = createDetailedAppRequestResultError(throwable);
        $jacocoInit[253] = true;
        return createDetailedAppRequestResultError;
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromUniqueName(String uniqueName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loadingApps) {
            $jacocoInit[68] = true;
            Single<DetailedAppRequestResult> a = Single.m734a(new DetailedAppRequestResult(true));
            $jacocoInit[69] = true;
            return a;
        }
        GetAppRequest ofUname = GetAppRequest.ofUname(uniqueName, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[70] = true;
        C0120S observe = ofUname.observe(false, false);
        C5296t tVar = new C5296t(this);
        $jacocoInit[71] = true;
        C0120S b = observe.mo3635b((C0128a) tVar);
        C5248P p = new C5248P(this);
        $jacocoInit[72] = true;
        C0120S d = b.mo3652d((C0128a) p);
        C5251T t = new C5251T(this);
        $jacocoInit[73] = true;
        C0120S c = d.mo3644c((C0128a) t);
        C5255X x = new C5255X(this, uniqueName);
        $jacocoInit[74] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) x);
        $jacocoInit[75] = true;
        Single n = f.mo3678n();
        C5230C c2 = new C5230C(this);
        $jacocoInit[76] = true;
        Single<DetailedAppRequestResult> f2 = n.mo3700f(c2);
        $jacocoInit[77] = true;
        return f2;
    }

    /* renamed from: p */
    public /* synthetic */ void mo17000p() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = true;
        $jacocoInit[252] = true;
    }

    /* renamed from: q */
    public /* synthetic */ void mo17001q() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = false;
        $jacocoInit[251] = true;
    }

    /* renamed from: r */
    public /* synthetic */ void mo17002r() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingApps = false;
        $jacocoInit[250] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16966a(String uniqueName, GetApp getApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapApp = mapApp(getApp, uniqueName);
        $jacocoInit[249] = true;
        return mapApp;
    }

    /* renamed from: f */
    public /* synthetic */ DetailedAppRequestResult mo16980f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedAppRequestResult createDetailedAppRequestResultError = createDetailedAppRequestResultError(throwable);
        $jacocoInit[248] = true;
        return createDetailedAppRequestResultError;
    }

    public Single<AppsList> loadRecommendedApps(int limit, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loadingSimilarApps) {
            $jacocoInit[78] = true;
            Single<AppsList> a = Single.m734a(new AppsList(true));
            $jacocoInit[79] = true;
            return a;
        }
        GetRecommendedRequest getRecommendedRequest = new GetRecommendedRequest(new GetRecommendedRequest.Body(limit, packageName), this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[80] = true;
        C0120S observe = getRecommendedRequest.observe(true, false);
        C5250S s = new C5250S(this);
        $jacocoInit[81] = true;
        C0120S b = observe.mo3635b((C0128a) s);
        C5238I i = new C5238I(this);
        $jacocoInit[82] = true;
        C0120S d = b.mo3652d((C0128a) i);
        C5302w wVar = new C5302w(this);
        $jacocoInit[83] = true;
        C0120S c = d.mo3644c((C0128a) wVar);
        C5246N n = new C5246N(this);
        $jacocoInit[84] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) n);
        $jacocoInit[85] = true;
        Single n2 = f.mo3678n();
        C5254W w = new C5254W(this);
        $jacocoInit[86] = true;
        Single<AppsList> f2 = n2.mo3700f(w);
        $jacocoInit[87] = true;
        return f2;
    }

    /* renamed from: s */
    public /* synthetic */ void mo17003s() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingSimilarApps = true;
        $jacocoInit[247] = true;
    }

    /* renamed from: t */
    public /* synthetic */ void mo17004t() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingSimilarApps = false;
        $jacocoInit[246] = true;
    }

    /* renamed from: u */
    public /* synthetic */ void mo17005u() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingSimilarApps = false;
        $jacocoInit[245] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo16974c(ListApps appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapListApps = mapListApps(appsList);
        $jacocoInit[244] = true;
        return mapListApps;
    }

    /* renamed from: g */
    public /* synthetic */ AppsList mo16982g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsList createErrorAppsList = createErrorAppsList(throwable);
        $jacocoInit[243] = true;
        return createErrorAppsList;
    }

    public Single<AppsList> loadFreshApps(long storeId, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AppsList> loadApps = loadApps(storeId, true, 0, limit);
        $jacocoInit[88] = true;
        return loadApps;
    }

    public Single<AppsList> loadApps(long storeId, int offset, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AppsList> loadApps = loadApps(storeId, false, offset, limit);
        $jacocoInit[89] = true;
        return loadApps;
    }

    private C0120S<DetailedAppRequestResult> mapApp(GetApp getApp, String uniqueName) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (getApp.isOk()) {
            $jacocoInit[90] = true;
            Nodes nodes = getApp.getNodes();
            $jacocoInit[91] = true;
            GetAppMeta meta = nodes.getMeta();
            $jacocoInit[92] = true;
            GetAppMeta.App app = meta.getData();
            $jacocoInit[93] = true;
            Nodes nodes2 = getApp.getNodes();
            $jacocoInit[94] = true;
            ListAppVersions listAppVersions = nodes2.getVersions();
            $jacocoInit[95] = true;
            GetAppMetaFile file = app.getFile();
            $jacocoInit[96] = true;
            GetAppMetaFile file2 = app.getFile();
            $jacocoInit[97] = true;
            Flags flags = file2.getFlags();
            $jacocoInit[98] = true;
            Developer developer = app.getDeveloper();
            $jacocoInit[99] = true;
            GetAppMeta.Stats stats = app.getStats();
            $jacocoInit[100] = true;
            GetAppMeta.Stats.Rating rating = stats.getRating();
            $jacocoInit[101] = true;
            GetAppMeta.Stats.Rating globalRating = stats.getGlobalRating();
            $jacocoInit[102] = true;
            Media media = app.getMedia();
            $jacocoInit[103] = true;
            AppFlags appFlags = new AppFlags(flags.getReview(), mapToFlagsVote(flags.getVotes()));
            $jacocoInit[104] = true;
            String name = developer.getName();
            String email = developer.getEmail();
            String privacy = developer.getPrivacy();
            $jacocoInit[105] = true;
            AppDeveloper appDeveloper = new AppDeveloper(name, email, privacy, developer.getWebsite());
            $jacocoInit[106] = true;
            AppRating appRating = new AppRating(rating.getAvg(), rating.getTotal(), mapToRatingsVote(rating.getVotes()));
            $jacocoInit[107] = true;
            AppRating appRating2 = appRating;
            float avg = globalRating.getAvg();
            int total = globalRating.getTotal();
            $jacocoInit[108] = true;
            AppRating globalAppRating = new AppRating(avg, total, mapToRatingsVote(globalRating.getVotes()));
            $jacocoInit[109] = true;
            AppStats appStats = new AppStats(appRating2, globalAppRating, stats.getDownloads(), stats.getPdownloads());
            $jacocoInit[110] = true;
            String description = media.getDescription();
            List keywords = media.getKeywords();
            String news = media.getNews();
            $jacocoInit[111] = true;
            AppMedia appMedia = new AppMedia(description, keywords, news, mapToScreenShots(media.getScreenshots()), mapToVideo(media.getVideos()));
            $jacocoInit[112] = true;
            AppMedia appMedia2 = appMedia;
            if (app.isPaid()) {
                $jacocoInit[113] = true;
                C5240K k = r0;
                C0120S paidApp = getPaidApp(app.getId());
                AppRating appRating3 = globalAppRating;
                AppRating appRating4 = appRating2;
                C5240K k2 = new C5240K(this, app, file, appFlags, appDeveloper, appMedia2, appStats, listAppVersions, uniqueName);
                C0120S<DetailedAppRequestResult> j = paidApp.mo3669j(k);
                $jacocoInit[114] = true;
                return j;
            }
            AppRating appRating5 = appRating2;
            $jacocoInit[115] = true;
            long id = app.getId();
            String name2 = app.getName();
            String packageName = app.getPackageName();
            long size = app.getSize();
            $jacocoInit[116] = true;
            String icon = app.getIcon();
            String graphic = app.getGraphic();
            String added = app.getAdded();
            String modified = app.getModified();
            boolean isGoodApp = file.isGoodApp();
            $jacocoInit[117] = true;
            Malware malware = file.getMalware();
            List tags = file.getTags();
            List usedFeatures = file.getUsedFeatures();
            $jacocoInit[118] = true;
            List usedPermissions = file.getUsedPermissions();
            long filesize = file.getFilesize();
            String md5 = app.getMd5();
            String path = file.getPath();
            $jacocoInit[119] = true;
            String pathAlt = file.getPathAlt();
            int vercode = file.getVercode();
            String vername = file.getVername();
            Store store = app.getStore();
            $jacocoInit[120] = true;
            Obb obb = app.getObb();
            Pay pay = app.getPay();
            Urls urls = app.getUrls();
            $jacocoInit[121] = true;
            String w = urls.getW();
            boolean isPaid = app.isPaid();
            boolean isLatestTrustedVersion = isLatestTrustedVersion(listAppVersions, file);
            $jacocoInit[122] = true;
            boolean hasBilling = app.hasBilling();
            boolean hasAdvertising = app.hasAdvertising();
            List bdsFlags = app.getBdsFlags();
            Age age = app.getAge();
            $jacocoInit[123] = true;
            if (age.getRating() == 18) {
                $jacocoInit[124] = true;
                z = true;
            } else {
                $jacocoInit[125] = true;
                z = false;
            }
            GetAppMetaFile file3 = app.getFile();
            $jacocoInit[126] = true;
            Signature signature = file3.getSignature();
            $jacocoInit[127] = true;
            DetailedApp detailedApp = new DetailedApp(id, name2, packageName, size, icon, graphic, added, modified, isGoodApp, malware, appFlags, tags, usedFeatures, usedPermissions, filesize, md5, path, pathAlt, vercode, vername, appDeveloper, store, appMedia2, appStats, obb, pay, w, isPaid, isLatestTrustedVersion, uniqueName, hasBilling, hasAdvertising, bdsFlags, z, signature.getSha1());
            $jacocoInit[128] = true;
            C0120S<DetailedAppRequestResult> c = C0120S.m652c(new DetailedAppRequestResult(detailedApp));
            $jacocoInit[129] = true;
            return c;
        }
        C0120S<DetailedAppRequestResult> a = C0120S.m631a((Throwable) new IllegalStateException("Could not obtain request from server."));
        $jacocoInit[130] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ DetailedAppRequestResult mo16963a(GetAppMeta.App app, GetAppMetaFile file, AppFlags appFlags, AppDeveloper appDeveloper, AppMedia appMedia, AppStats appStats, ListAppVersions listAppVersions, String uniqueName, PaidApp paidApp) {
        boolean z;
        DetailedAppRequestResult detailedAppRequestResult;
        boolean[] $jacocoInit = $jacocoInit();
        Pay pay = app.getPay();
        $jacocoInit[222] = true;
        Payment payment = paidApp.getPayment();
        $jacocoInit[223] = true;
        String status = payment.getStatus();
        $jacocoInit[224] = true;
        pay.setStatus(status);
        $jacocoInit[225] = true;
        long id = app.getId();
        String name = app.getName();
        String packageName = app.getPackageName();
        long size = app.getSize();
        $jacocoInit[226] = true;
        String icon = app.getIcon();
        String graphic = app.getGraphic();
        String added = app.getAdded();
        String modified = app.getModified();
        $jacocoInit[227] = true;
        boolean isGoodApp = file.isGoodApp();
        Malware malware = file.getMalware();
        List tags = file.getTags();
        $jacocoInit[228] = true;
        List usedFeatures = file.getUsedFeatures();
        List usedPermissions = file.getUsedPermissions();
        long filesize = file.getFilesize();
        $jacocoInit[229] = true;
        String md5 = app.getMd5();
        String path = file.getPath();
        String pathAlt = file.getPathAlt();
        int vercode = file.getVercode();
        $jacocoInit[230] = true;
        String vername = file.getVername();
        Store store = app.getStore();
        Obb obb = app.getObb();
        $jacocoInit[231] = true;
        Pay pay2 = app.getPay();
        Urls urls = app.getUrls();
        $jacocoInit[232] = true;
        String w = urls.getW();
        boolean isPaid = app.isPaid();
        Payment payment2 = paidApp.getPayment();
        $jacocoInit[233] = true;
        boolean isPaid2 = payment2.isPaid();
        Path path2 = paidApp.getPath();
        $jacocoInit[234] = true;
        String stringPath = path2.getStringPath();
        Payment payment3 = paidApp.getPayment();
        $jacocoInit[235] = true;
        String status2 = payment3.getStatus();
        DetailedAppRequestResult detailedAppRequestResult2 = detailedAppRequestResult;
        boolean isLatestTrustedVersion = isLatestTrustedVersion(listAppVersions, file);
        $jacocoInit[236] = true;
        boolean hasBilling = app.hasBilling();
        boolean hasAdvertising = app.hasAdvertising();
        List bdsFlags = app.getBdsFlags();
        Age age = app.getAge();
        $jacocoInit[237] = true;
        if (age.getRating() == 18) {
            $jacocoInit[238] = true;
            z = true;
        } else {
            $jacocoInit[239] = true;
            z = false;
        }
        GetAppMetaFile file2 = app.getFile();
        $jacocoInit[240] = true;
        Signature signature = file2.getSignature();
        $jacocoInit[241] = true;
        String sha1 = signature.getSha1();
        DetailedApp detailedApp = r3;
        DetailedApp detailedApp2 = new DetailedApp(id, name, packageName, size, icon, graphic, added, modified, isGoodApp, malware, appFlags, tags, usedFeatures, usedPermissions, filesize, md5, path, pathAlt, vercode, vername, appDeveloper, store, appMedia, appStats, obb, pay2, w, isPaid, isPaid2, stringPath, status2, isLatestTrustedVersion, uniqueName, hasBilling, hasAdvertising, bdsFlags, z, sha1);
        detailedAppRequestResult = new DetailedAppRequestResult(detailedApp);
        $jacocoInit[242] = true;
        return detailedAppRequestResult;
    }

    private C0120S<PaidApp> getPaidApp(long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        GetApkInfoRequest of = GetApkInfoRequest.m7448of(appId, this.bodyInterceptorV3, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.resources);
        $jacocoInit[131] = true;
        C0120S observe = of.observe(true);
        C5308z zVar = new C5308z(appId);
        $jacocoInit[132] = true;
        C0120S<PaidApp> f = observe.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zVar);
        $jacocoInit[133] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m9528a(long appId, PaidApp response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response == null) {
            $jacocoInit[216] = true;
        } else if (!response.isOk()) {
            $jacocoInit[217] = true;
        } else if (!response.isPaid()) {
            $jacocoInit[218] = true;
        } else {
            $jacocoInit[219] = true;
            C0120S c = C0120S.m652c(response);
            $jacocoInit[220] = true;
            return c;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No paid app found for app id ");
        sb.append(appId);
        C0120S a = C0120S.m631a((Throwable) new RepositoryItemNotFoundException(sb.toString()));
        $jacocoInit[221] = true;
        return a;
    }

    private boolean isLatestTrustedVersion(ListAppVersions listAppVersions, File file) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (!canCompare(listAppVersions)) {
            $jacocoInit[134] = true;
        } else {
            $jacocoInit[135] = true;
            String md5sum = file.getMd5sum();
            $jacocoInit[136] = true;
            List list = listAppVersions.getList();
            $jacocoInit[137] = true;
            App app = (App) list.get(0);
            $jacocoInit[138] = true;
            File file2 = app.getFile();
            $jacocoInit[139] = true;
            String md5sum2 = file2.getMd5sum();
            $jacocoInit[140] = true;
            if (!md5sum.equals(md5sum2)) {
                $jacocoInit[141] = true;
            } else {
                $jacocoInit[142] = true;
                Malware malware = file.getMalware();
                $jacocoInit[143] = true;
                if (malware.getRank() == Rank.TRUSTED) {
                    $jacocoInit[144] = true;
                    z = true;
                } else {
                    $jacocoInit[145] = true;
                }
                $jacocoInit[146] = true;
                return z;
            }
        }
        $jacocoInit[147] = true;
        return false;
    }

    private boolean canCompare(ListAppVersions listAppVersions) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (listAppVersions == null) {
            $jacocoInit[148] = true;
        } else {
            $jacocoInit[149] = true;
            if (listAppVersions.getList() == null) {
                $jacocoInit[150] = true;
            } else {
                $jacocoInit[151] = true;
                List list = listAppVersions.getList();
                $jacocoInit[152] = true;
                if (list.isEmpty()) {
                    $jacocoInit[153] = true;
                } else {
                    $jacocoInit[154] = true;
                    z = true;
                    $jacocoInit[156] = true;
                    return z;
                }
            }
        }
        z = false;
        $jacocoInit[155] = true;
        $jacocoInit[156] = true;
        return z;
    }

    private AppsList createErrorAppsList(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof NoNetworkConnectionException) {
            $jacocoInit[157] = true;
            AppsList appsList = new AppsList(Error.NETWORK);
            $jacocoInit[158] = true;
            return appsList;
        }
        AppsList appsList2 = new AppsList(Error.GENERIC);
        $jacocoInit[159] = true;
        return appsList2;
    }

    private DetailedAppRequestResult createDetailedAppRequestResultError(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof NoNetworkConnectionException) {
            $jacocoInit[160] = true;
            DetailedAppRequestResult detailedAppRequestResult = new DetailedAppRequestResult(DetailedAppRequestResult.Error.NETWORK);
            $jacocoInit[161] = true;
            return detailedAppRequestResult;
        }
        DetailedAppRequestResult detailedAppRequestResult2 = new DetailedAppRequestResult(DetailedAppRequestResult.Error.GENERIC);
        $jacocoInit[162] = true;
        return detailedAppRequestResult2;
    }

    private List<FlagsVote> mapToFlagsVote(List<Vote> votes) {
        boolean[] $jacocoInit = $jacocoInit();
        List<FlagsVote> flagsVotes = new ArrayList<>();
        if (votes == null) {
            $jacocoInit[163] = true;
        } else {
            $jacocoInit[164] = true;
            $jacocoInit[165] = true;
            for (Vote vote : votes) {
                $jacocoInit[167] = true;
                flagsVotes.add(new FlagsVote(vote.getCount(), map(vote.getType())));
                $jacocoInit[168] = true;
            }
            $jacocoInit[166] = true;
        }
        $jacocoInit[169] = true;
        return flagsVotes;
    }

    private List<RatingVote> mapToRatingsVote(List<GetAppMeta.Stats.Rating.Vote> votes) {
        boolean[] $jacocoInit = $jacocoInit();
        List<RatingVote> ratingVotes = new ArrayList<>();
        $jacocoInit[171] = true;
        $jacocoInit[172] = true;
        for (GetAppMeta.Stats.Rating.Vote vote : votes) {
            $jacocoInit[174] = true;
            ratingVotes.add(new RatingVote(vote.getCount(), vote.getValue()));
            $jacocoInit[175] = true;
        }
        $jacocoInit[173] = true;
        $jacocoInit[176] = true;
        return ratingVotes;
    }

    private List<AppVideo> mapToVideo(List<Video> videos) {
        boolean[] $jacocoInit = $jacocoInit();
        List<AppVideo> appVideos = new ArrayList<>();
        if (videos == null) {
            $jacocoInit[177] = true;
        } else {
            $jacocoInit[178] = true;
            $jacocoInit[179] = true;
            for (Video video : videos) {
                $jacocoInit[181] = true;
                appVideos.add(new AppVideo(video.getThumbnail(), video.getType(), video.getUrl()));
                $jacocoInit[182] = true;
            }
            $jacocoInit[180] = true;
        }
        $jacocoInit[183] = true;
        return appVideos;
    }

    private List<AppScreenshot> mapToScreenShots(List<Screenshot> screenshots) {
        boolean[] $jacocoInit = $jacocoInit();
        List<AppScreenshot> appScreenShots = new ArrayList<>();
        if (screenshots == null) {
            $jacocoInit[184] = true;
        } else {
            $jacocoInit[185] = true;
            $jacocoInit[186] = true;
            for (Screenshot screenshot : screenshots) {
                $jacocoInit[188] = true;
                int height = screenshot.getHeight();
                int width = screenshot.getWidth();
                $jacocoInit[189] = true;
                AppScreenshot appScreenshot = new AppScreenshot(height, width, screenshot.getOrientation(), screenshot.getUrl());
                $jacocoInit[190] = true;
                appScreenShots.add(appScreenshot);
                $jacocoInit[191] = true;
            }
            $jacocoInit[187] = true;
        }
        $jacocoInit[192] = true;
        return appScreenShots;
    }

    private VoteType map(Type type) {
        boolean[] $jacocoInit = $jacocoInit();
        VoteType flagsVoteVoteType = null;
        $jacocoInit[193] = true;
        int i = C52271.f8996xb9b5ac52[type.ordinal()];
        if (i == 1) {
            flagsVoteVoteType = VoteType.FAKE;
            $jacocoInit[195] = true;
        } else if (i == 2) {
            flagsVoteVoteType = VoteType.GOOD;
            $jacocoInit[196] = true;
        } else if (i == 3) {
            flagsVoteVoteType = VoteType.VIRUS;
            $jacocoInit[197] = true;
        } else if (i == 4) {
            flagsVoteVoteType = VoteType.FREEZE;
            $jacocoInit[198] = true;
        } else if (i != 5) {
            $jacocoInit[194] = true;
        } else {
            flagsVoteVoteType = VoteType.LICENSE;
            $jacocoInit[199] = true;
        }
        $jacocoInit[200] = true;
        return flagsVoteVoteType;
    }

    public Single<AppsList> loadAppcRecommendedApps(int limit, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loadingAppcSimilarApps) {
            $jacocoInit[201] = true;
            Single<AppsList> a = Single.m734a(new AppsList(true));
            $jacocoInit[202] = true;
            return a;
        }
        GetRecommendedRequest getRecommendedRequest = new GetRecommendedRequest(new GetRecommendedRequest.Body(limit, packageName, "appc"), this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[203] = true;
        C0120S observe = getRecommendedRequest.observe(true, false);
        C5247O o = new C5247O(this);
        $jacocoInit[204] = true;
        C0120S b = observe.mo3635b((C0128a) o);
        C5294s sVar = new C5294s(this);
        $jacocoInit[205] = true;
        C0120S d = b.mo3652d((C0128a) sVar);
        C5236G g = new C5236G(this);
        $jacocoInit[206] = true;
        C0120S c = d.mo3644c((C0128a) g);
        C5288p pVar = new C5288p(this);
        $jacocoInit[207] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pVar);
        $jacocoInit[208] = true;
        Single n = f.mo3678n();
        C5306y yVar = new C5306y(this);
        $jacocoInit[209] = true;
        Single<AppsList> f2 = n.mo3700f(yVar);
        $jacocoInit[210] = true;
        return f2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16967a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingAppcSimilarApps = true;
        $jacocoInit[215] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16971b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingAppcSimilarApps = false;
        $jacocoInit[214] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16975c() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingAppcSimilarApps = false;
        $jacocoInit[213] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16965a(ListApps appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapListApps = mapListApps(appsList);
        $jacocoInit[212] = true;
        return mapListApps;
    }

    /* renamed from: a */
    public /* synthetic */ AppsList mo16962a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsList createErrorAppsList = createErrorAppsList(throwable);
        $jacocoInit[211] = true;
        return createErrorAppsList;
    }
}
