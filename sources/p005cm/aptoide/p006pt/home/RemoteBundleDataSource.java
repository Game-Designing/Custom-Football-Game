package p005cm.aptoide.p006pt.home;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.V7Url;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.WSWidgetsUtils;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.GetHomeBundlesRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreWidgetsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreWidgetsRequest.Body;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.WidgetsArgs;
import p005cm.aptoide.p006pt.home.HomeBundle.BundleType;
import p005cm.aptoide.p006pt.home.HomeBundlesModel.Error;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;
import p026rx.p401g.C14959b;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.home.RemoteBundleDataSource */
public class RemoteBundleDataSource implements BundleDataSource {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final String clientUniqueId;
    private final ConnectivityManager connectivityManager;
    private final Factory converterFactory;
    private final String filters;
    private final boolean isGooglePlayServicesAvailable;
    private final int latestPackagesCount;
    private final int limit;
    private Map<String, Boolean> loading = new HashMap();
    private final BundlesResponseMapper mapper;
    private final OkHttpClient okHttpClient;
    private final PackageRepository packageRepository;
    private final String partnerId;
    private final int randomPackagesCount;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;
    private Map<String, Integer> total;
    private final AdsApplicationVersionCodeProvider versionCodeProvider;
    private final WSWidgetsUtils widgetsUtils;
    private final WindowManager windowManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4299019120233780497L, "cm/aptoide/pt/home/RemoteBundleDataSource", 100);
        $jacocoData = probes;
        return probes;
    }

    public RemoteBundleDataSource(int limit2, Map<String, Integer> initialTotal, BodyInterceptor<BaseBody> bodyInterceptor2, OkHttpClient okHttpClient2, Factory converterFactory2, BundlesResponseMapper mapper2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, WSWidgetsUtils widgetsUtils2, StoreCredentialsProvider storeCredentialsProvider2, String clientUniqueId2, boolean isGooglePlayServicesAvailable2, String partnerId2, AptoideAccountManager accountManager2, String filters2, Resources resources2, WindowManager windowManager2, ConnectivityManager connectivityManager2, AdsApplicationVersionCodeProvider versionCodeProvider2, PackageRepository packageRepository2, int latestPackagesCount2, int randomPackagesCount2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.limit = limit2;
        this.total = initialTotal;
        this.bodyInterceptor = bodyInterceptor2;
        this.okHttpClient = okHttpClient2;
        this.converterFactory = converterFactory2;
        this.mapper = mapper2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.widgetsUtils = widgetsUtils2;
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.clientUniqueId = clientUniqueId2;
        this.isGooglePlayServicesAvailable = isGooglePlayServicesAvailable2;
        this.partnerId = partnerId2;
        this.accountManager = accountManager2;
        this.filters = filters2;
        this.resources = resources2;
        this.windowManager = windowManager2;
        this.connectivityManager = connectivityManager2;
        this.versionCodeProvider = versionCodeProvider2;
        this.packageRepository = packageRepository2;
        this.latestPackagesCount = latestPackagesCount2;
        this.randomPackagesCount = randomPackagesCount2;
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    private Single<HomeBundlesModel> getHomeBundles(int offset, int limit2, boolean invalidateHttpCache, String key) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isLoading(key)) {
            $jacocoInit[2] = true;
            Single<HomeBundlesModel> a = Single.m734a(new HomeBundlesModel(true));
            $jacocoInit[3] = true;
            return a;
        }
        C0120S enabled = this.accountManager.enabled();
        $jacocoInit[4] = true;
        C0120S d = enabled.mo3647d();
        $jacocoInit[5] = true;
        Single n = d.mo3678n();
        $jacocoInit[6] = true;
        C14959b a2 = n.mo3689a();
        $jacocoInit[7] = true;
        boolean adultContentEnabled = ((Boolean) a2.mo46175a()).booleanValue();
        $jacocoInit[8] = true;
        Single packages = getPackages();
        C3884ke keVar = new C3884ke(this, limit2, offset, adultContentEnabled, invalidateHttpCache, key);
        Single<HomeBundlesModel> a3 = packages.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) keVar);
        $jacocoInit[9] = true;
        return a3;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14550a(int limit2, int offset, boolean adultContentEnabled, boolean invalidateHttpCache, String key, List packageNames) {
        String str = key;
        int i = limit2;
        int i2 = offset;
        boolean z = adultContentEnabled;
        List list = packageNames;
        boolean[] $jacocoInit = $jacocoInit();
        OkHttpClient okHttpClient2 = this.okHttpClient;
        Factory factory = this.converterFactory;
        BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        WSWidgetsUtils wSWidgetsUtils = this.widgetsUtils;
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[86] = true;
        StoreCredentials fromUrl = storeCredentialsProvider2.fromUrl("");
        String str2 = this.clientUniqueId;
        boolean z2 = this.isGooglePlayServicesAvailable;
        String str3 = this.partnerId;
        String str4 = this.filters;
        Resources resources2 = this.resources;
        WindowManager windowManager2 = this.windowManager;
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = this.versionCodeProvider;
        $jacocoInit[87] = true;
        GetHomeBundlesRequest of = GetHomeBundlesRequest.m7549of(i, i2, okHttpClient2, factory, bodyInterceptor2, tokenInvalidator2, sharedPreferences2, wSWidgetsUtils, fromUrl, str2, z2, str3, z, str4, resources2, windowManager2, connectivityManager2, adsApplicationVersionCodeProvider, list);
        $jacocoInit[88] = true;
        C0120S observe = of.observe(invalidateHttpCache, false);
        String str5 = key;
        C3860ge geVar = new C3860ge(this, str5);
        $jacocoInit[89] = true;
        C0120S b = observe.mo3635b((C0128a) geVar);
        C3842de deVar = new C3842de(this, str5);
        $jacocoInit[90] = true;
        C0120S d = b.mo3652d((C0128a) deVar);
        C3854fe feVar = new C3854fe(this, str5);
        $jacocoInit[91] = true;
        C0120S c = d.mo3644c((C0128a) feVar);
        C3872ie ieVar = new C3872ie(this, str5);
        $jacocoInit[92] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ieVar);
        $jacocoInit[93] = true;
        Single n = f.mo3678n();
        C3848ee eeVar = new C3848ee(this);
        $jacocoInit[94] = true;
        Single f2 = n.mo3700f(eeVar);
        $jacocoInit[95] = true;
        return f2;
    }

    /* renamed from: d */
    public /* synthetic */ void mo14555d(String key) {
        Boolean bool = (Boolean) this.loading.put(key, Boolean.valueOf(true));
        $jacocoInit()[99] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo14556e(String key) {
        Boolean bool = (Boolean) this.loading.put(key, Boolean.valueOf(false));
        $jacocoInit()[98] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo14557f(String key) {
        Boolean bool = (Boolean) this.loading.put(key, Boolean.valueOf(false));
        $jacocoInit()[97] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo14552b(String key, GetStoreWidgets homeResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapHomeResponse = mapHomeResponse(homeResponse, key);
        $jacocoInit[96] = true;
        return mapHomeResponse;
    }

    public GetStoreWidgetsRequest getMoreBundlesRequest(String url, int offset, int limit2) {
        String str = url;
        boolean[] $jacocoInit = $jacocoInit();
        C0120S enabled = this.accountManager.enabled();
        $jacocoInit[10] = true;
        C0120S d = enabled.mo3647d();
        $jacocoInit[11] = true;
        Single n = d.mo3678n();
        $jacocoInit[12] = true;
        C14959b a = n.mo3689a();
        $jacocoInit[13] = true;
        boolean booleanValue = ((Boolean) a.mo46175a()).booleanValue();
        $jacocoInit[14] = true;
        StoreCredentials storeCredentials = this.storeCredentialsProvider.fromUrl(str);
        StoreCredentials storeCredentials2 = storeCredentials;
        Resources resources2 = this.resources;
        WindowManager windowManager2 = this.windowManager;
        $jacocoInit[15] = true;
        Body body = new Body(storeCredentials, WidgetsArgs.createWithLineMultiplier(resources2, windowManager2, 3), limit2);
        $jacocoInit[16] = true;
        Body body2 = body;
        Body body3 = body2;
        body2.setOffset(offset);
        $jacocoInit[17] = true;
        V7Url remove = new V7Url(str).remove("getStoreWidgets");
        $jacocoInit[18] = true;
        String str2 = remove.get();
        BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
        OkHttpClient okHttpClient2 = this.okHttpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        Body body4 = body2;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        String str3 = this.clientUniqueId;
        StoreCredentials storeCredentials3 = storeCredentials;
        boolean z = this.isGooglePlayServicesAvailable;
        String str4 = this.partnerId;
        String str5 = this.filters;
        Resources resources3 = this.resources;
        WindowManager windowManager3 = this.windowManager;
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = this.versionCodeProvider;
        WSWidgetsUtils wSWidgetsUtils = r4;
        WSWidgetsUtils wSWidgetsUtils2 = new WSWidgetsUtils();
        GetStoreWidgetsRequest getStoreWidgetsRequest = new GetStoreWidgetsRequest(str2, body3, bodyInterceptor2, okHttpClient2, factory, tokenInvalidator2, sharedPreferences2, storeCredentials2, str3, z, str4, booleanValue, str5, resources3, windowManager3, connectivityManager2, adsApplicationVersionCodeProvider, wSWidgetsUtils);
        $jacocoInit[19] = true;
        return getStoreWidgetsRequest;
    }

    private Single<List<String>> getPackages() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S latestInstalledPackages = this.packageRepository.getLatestInstalledPackages(this.latestPackagesCount);
        PackageRepository packageRepository2 = this.packageRepository;
        int i = this.randomPackagesCount;
        $jacocoInit[20] = true;
        C0120S randomInstalledPackages = packageRepository2.getRandomInstalledPackages(i);
        $jacocoInit[21] = true;
        C0120S a = C0120S.m636a(latestInstalledPackages, randomInstalledPackages);
        $jacocoInit[22] = true;
        C0120S m = a.mo3675m();
        $jacocoInit[23] = true;
        Single<List<String>> n = m.mo3678n();
        $jacocoInit[24] = true;
        return n;
    }

    /* access modifiers changed from: private */
    public HomeBundlesModel createErrorAppsList(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof NoNetworkConnectionException) {
            $jacocoInit[25] = true;
            HomeBundlesModel homeBundlesModel = new HomeBundlesModel(Error.NETWORK);
            $jacocoInit[26] = true;
            return homeBundlesModel;
        }
        HomeBundlesModel homeBundlesModel2 = new HomeBundlesModel(Error.GENERIC);
        $jacocoInit[27] = true;
        return homeBundlesModel2;
    }

    private C0120S<HomeBundlesModel> mapHomeResponse(GetStoreWidgets homeResponse, String key) {
        boolean[] $jacocoInit = $jacocoInit();
        if (homeResponse.isOk()) {
            $jacocoInit[28] = true;
            BundlesResponseMapper bundlesResponseMapper = this.mapper;
            DataList dataList = homeResponse.getDataList();
            $jacocoInit[29] = true;
            List list = dataList.getList();
            $jacocoInit[30] = true;
            List<HomeBundle> homeBundles = bundlesResponseMapper.fromWidgetsToBundles(list);
            $jacocoInit[31] = true;
            List<HomeBundle> homeBundles2 = removeEmptyBundles(homeBundles);
            $jacocoInit[32] = true;
            DataList dataList2 = homeResponse.getDataList();
            $jacocoInit[33] = true;
            int responseBundletotal = dataList2.getTotal();
            $jacocoInit[34] = true;
            this.total.put(key, Integer.valueOf(responseBundletotal));
            $jacocoInit[35] = true;
            DataList dataList3 = homeResponse.getDataList();
            $jacocoInit[36] = true;
            HomeBundlesModel homeBundlesModel = new HomeBundlesModel(homeBundles2, false, dataList3.getNext());
            $jacocoInit[37] = true;
            C0120S<HomeBundlesModel> c = C0120S.m652c(homeBundlesModel);
            $jacocoInit[38] = true;
            return c;
        }
        C0120S<HomeBundlesModel> a = C0120S.m631a((Throwable) new IllegalStateException("Could not obtain home bundles from server."));
        $jacocoInit[39] = true;
        return a;
    }

    public Single<HomeBundlesModel> loadFreshHomeBundles(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> homeBundles = getHomeBundles(0, this.limit, true, key);
        $jacocoInit[40] = true;
        return homeBundles;
    }

    public Single<HomeBundlesModel> loadNextHomeBundles(int offset, int limit2, String key) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> homeBundles = getHomeBundles(offset, limit2, false, key);
        $jacocoInit[41] = true;
        return homeBundles;
    }

    public boolean hasMore(Integer offset, String key) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (offset.intValue() >= getTotal(key)) {
            $jacocoInit[42] = true;
        } else if (isLoading(key)) {
            $jacocoInit[43] = true;
        } else {
            $jacocoInit[44] = true;
            z = true;
            $jacocoInit[46] = true;
            return z;
        }
        z = false;
        $jacocoInit[45] = true;
        $jacocoInit[46] = true;
        return z;
    }

    public Single<HomeBundlesModel> loadFreshBundleForEvent(String url, String key) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> eventBundles = getEventBundles(url, true, key, 0, this.limit);
        $jacocoInit[47] = true;
        return eventBundles;
    }

    public Single<HomeBundlesModel> loadNextBundleForEvent(String url, int offset, String key, int limit2) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> eventBundles = getEventBundles(url, false, key, offset, limit2);
        $jacocoInit[48] = true;
        return eventBundles;
    }

    private Single<HomeBundlesModel> getEventBundles(String url, boolean invalidateHttpCache, String key, int offset, int limit2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isLoading(key)) {
            $jacocoInit[49] = true;
            Single<HomeBundlesModel> a = Single.m734a(new HomeBundlesModel(true));
            $jacocoInit[50] = true;
            return a;
        }
        String newUrl = url.replace(C0044V7.getHost(this.sharedPreferences), "");
        $jacocoInit[51] = true;
        C0120S observe = getMoreBundlesRequest(newUrl, offset, limit2).observe(invalidateHttpCache, false);
        C3878je jeVar = new C3878je(this, key);
        $jacocoInit[52] = true;
        C0120S b = observe.mo3635b((C0128a) jeVar);
        C3836ce ceVar = new C3836ce(this, key);
        $jacocoInit[53] = true;
        C0120S d = b.mo3652d((C0128a) ceVar);
        C3866he heVar = new C3866he(this, key);
        $jacocoInit[54] = true;
        C0120S c = d.mo3644c((C0128a) heVar);
        C3890le leVar = new C3890le(this, key);
        $jacocoInit[55] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) leVar);
        $jacocoInit[56] = true;
        Single n = f.mo3678n();
        C3848ee eeVar = new C3848ee(this);
        $jacocoInit[57] = true;
        Single<HomeBundlesModel> f2 = n.mo3700f(eeVar);
        $jacocoInit[58] = true;
        return f2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14551a(String key) {
        Boolean bool = (Boolean) this.loading.put(key, Boolean.valueOf(true));
        $jacocoInit()[85] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14553b(String key) {
        Boolean bool = (Boolean) this.loading.put(key, Boolean.valueOf(false));
        $jacocoInit()[84] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14554c(String key) {
        Boolean bool = (Boolean) this.loading.put(key, Boolean.valueOf(false));
        $jacocoInit()[83] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14549a(String key, GetStoreWidgets homeResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapHomeResponse = mapHomeResponse(homeResponse, key);
        $jacocoInit[82] = true;
        return mapHomeResponse;
    }

    private boolean isLoading(String key) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.loading.containsKey(key)) {
            $jacocoInit[59] = true;
        } else if (!((Boolean) this.loading.get(key)).booleanValue()) {
            $jacocoInit[60] = true;
        } else {
            $jacocoInit[61] = true;
            z = true;
            $jacocoInit[63] = true;
            return z;
        }
        z = false;
        $jacocoInit[62] = true;
        $jacocoInit[63] = true;
        return z;
    }

    private int getTotal(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.total.containsKey(key)) {
            $jacocoInit[64] = true;
            int intValue = ((Integer) this.total.get(key)).intValue();
            $jacocoInit[65] = true;
            return intValue;
        }
        $jacocoInit[66] = true;
        return MoPubClientPositioning.NO_REPEAT;
    }

    private List<HomeBundle> removeEmptyBundles(List<HomeBundle> homeBundles) {
        boolean[] $jacocoInit = $jacocoInit();
        List<HomeBundle> newHomeBundleList = new ArrayList<>();
        $jacocoInit[67] = true;
        $jacocoInit[68] = true;
        for (HomeBundle homeBundle : homeBundles) {
            $jacocoInit[69] = true;
            BundleType type = homeBundle.getType();
            $jacocoInit[70] = true;
            if (!type.isApp()) {
                $jacocoInit[71] = true;
            } else {
                List content = homeBundle.getContent();
                $jacocoInit[72] = true;
                if (content.isEmpty()) {
                    $jacocoInit[73] = true;
                } else {
                    $jacocoInit[74] = true;
                    newHomeBundleList.add(homeBundle);
                    $jacocoInit[75] = true;
                    $jacocoInit[80] = true;
                }
            }
            BundleType type2 = homeBundle.getType();
            $jacocoInit[76] = true;
            if (type2.isApp()) {
                $jacocoInit[77] = true;
            } else {
                $jacocoInit[78] = true;
                newHomeBundleList.add(homeBundle);
                $jacocoInit[79] = true;
            }
            $jacocoInit[80] = true;
        }
        $jacocoInit[81] = true;
        return newHomeBundleList;
    }
}
