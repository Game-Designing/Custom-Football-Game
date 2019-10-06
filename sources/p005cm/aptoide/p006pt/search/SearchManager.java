package p005cm.aptoide.p006pt.search;

import android.content.SharedPreferences;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.search.ListSearchApps;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.search.SearchApp;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListSearchAppsRequest;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.search.model.SearchAppResult;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.search.SearchManager */
public class SearchManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;
    private final AdsRepository adsRepository;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Factory converterFactory;
    private final Database database;
    private final OkHttpClient httpClient;
    private final MoPubAdsManager moPubAdsManager;
    private final SharedPreferences sharedPreferences;
    private final HashMapNotNull<String, List<String>> subscribedStoresAuthMap;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8852650400806380032L, "cm/aptoide/pt/search/SearchManager", 69);
        $jacocoData = probes;
        return probes;
    }

    public SearchManager(SharedPreferences sharedPreferences2, TokenInvalidator tokenInvalidator2, BodyInterceptor<BaseBody> bodyInterceptor2, OkHttpClient httpClient2, Factory converterFactory2, HashMapNotNull<String, List<String>> subscribedStoresAuthMap2, AdsRepository adsRepository2, Database database2, AptoideAccountManager accountManager2, MoPubAdsManager moPubAdsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.sharedPreferences = sharedPreferences2;
        this.tokenInvalidator = tokenInvalidator2;
        this.bodyInterceptor = bodyInterceptor2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.subscribedStoresAuthMap = subscribedStoresAuthMap2;
        this.adsRepository = adsRepository2;
        this.database = database2;
        this.accountManager = accountManager2;
        this.moPubAdsManager = moPubAdsManager2;
        $jacocoInit[0] = true;
    }

    public C0120S<SearchAdResult> getAdsForQuery(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S adsFromSearch = this.adsRepository.getAdsFromSearch(query);
        C4659h hVar = C4659h.f8292a;
        $jacocoInit[1] = true;
        C0120S<SearchAdResult> j = adsFromSearch.mo3669j(hVar);
        $jacocoInit[2] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ SearchAdResult m9002a(MinimalAd minimalAd) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAdResult searchAdResult = new SearchAdResult(minimalAd);
        $jacocoInit[68] = true;
        return searchAdResult;
    }

    public Single<List<SearchAppResult>> searchInNonFollowedStores(String query, boolean onlyTrustedApps, int offset) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S enabled = this.accountManager.enabled();
        $jacocoInit[3] = true;
        C0120S d = enabled.mo3647d();
        C4662k kVar = new C4662k(this, query, offset, onlyTrustedApps);
        $jacocoInit[4] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) kVar);
        C4658g gVar = new C4658g(this);
        $jacocoInit[5] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) gVar);
        C4654c cVar = C4654c.f8287a;
        $jacocoInit[6] = true;
        C0120S j = d2.mo3669j(cVar);
        C4656e eVar = C4656e.f8289a;
        $jacocoInit[7] = true;
        C0120S h = j.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) eVar);
        C4669n nVar = C4669n.f8301a;
        $jacocoInit[8] = true;
        C0120S j2 = h.mo3669j(nVar);
        $jacocoInit[9] = true;
        C0120S m = j2.mo3675m();
        $jacocoInit[10] = true;
        C0120S d3 = m.mo3647d();
        $jacocoInit[11] = true;
        Single<List<SearchAppResult>> n = d3.mo3678n();
        $jacocoInit[12] = true;
        return n;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo16036b(String query, int offset, boolean onlyTrustedApps, Boolean enabled) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[63] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(this.database, Store.class);
        $jacocoInit[64] = true;
        List subscribedStoresIds = StoreUtils.getSubscribedStoresIds(storeAccessor);
        BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[65] = true;
        ListSearchAppsRequest of = ListSearchAppsRequest.m7478of(query, offset, false, onlyTrustedApps, subscribedStoresIds, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, enabled);
        $jacocoInit[66] = true;
        C0120S observe = of.observe(true);
        $jacocoInit[67] = true;
        return observe;
    }

    /* renamed from: c */
    public /* synthetic */ Boolean mo16037c(ListSearchApps listSearchApps) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(hasResults(listSearchApps));
        $jacocoInit[62] = true;
        return valueOf;
    }

    /* renamed from: d */
    static /* synthetic */ List m9010d(ListSearchApps data) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = data.getDataList();
        $jacocoInit[60] = true;
        List list = dataList.getList();
        $jacocoInit[61] = true;
        return list;
    }

    /* renamed from: b */
    static /* synthetic */ Iterable m9006b(List list) {
        $jacocoInit()[59] = true;
        return list;
    }

    /* renamed from: b */
    static /* synthetic */ SearchAppResult m9005b(SearchApp searchApp) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAppResult searchAppResult = new SearchAppResult(searchApp);
        $jacocoInit[58] = true;
        return searchAppResult;
    }

    public Single<List<SearchAppResult>> searchInFollowedStores(String query, boolean onlyTrustedApps, int offset) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S enabled = this.accountManager.enabled();
        $jacocoInit[13] = true;
        C0120S d = enabled.mo3647d();
        C4652a aVar = new C4652a(this, query, offset, onlyTrustedApps);
        $jacocoInit[14] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aVar);
        C4664m mVar = new C4664m(this);
        $jacocoInit[15] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) mVar);
        C4663l lVar = C4663l.f8299a;
        $jacocoInit[16] = true;
        C0120S j = d2.mo3669j(lVar);
        C4661j jVar = C4661j.f8294a;
        $jacocoInit[17] = true;
        C0120S h = j.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) jVar);
        C4653b bVar = C4653b.f8286a;
        $jacocoInit[18] = true;
        C0120S j2 = h.mo3669j(bVar);
        $jacocoInit[19] = true;
        C0120S m = j2.mo3675m();
        $jacocoInit[20] = true;
        C0120S d3 = m.mo3647d();
        $jacocoInit[21] = true;
        Single<List<SearchAppResult>> n = d3.mo3678n();
        $jacocoInit[22] = true;
        return n;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16035a(String query, int offset, boolean onlyTrustedApps, Boolean enabled) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[53] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(this.database, Store.class);
        $jacocoInit[54] = true;
        List subscribedStoresIds = StoreUtils.getSubscribedStoresIds(storeAccessor);
        BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[55] = true;
        ListSearchAppsRequest of = ListSearchAppsRequest.m7478of(query, offset, true, onlyTrustedApps, subscribedStoresIds, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, enabled);
        $jacocoInit[56] = true;
        C0120S observe = of.observe(true);
        $jacocoInit[57] = true;
        return observe;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo16034a(ListSearchApps listSearchApps) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(hasResults(listSearchApps));
        $jacocoInit[52] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ List m9007b(ListSearchApps data) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = data.getDataList();
        $jacocoInit[50] = true;
        List list = dataList.getList();
        $jacocoInit[51] = true;
        return list;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m9004a(List list) {
        $jacocoInit()[49] = true;
        return list;
    }

    /* renamed from: a */
    static /* synthetic */ SearchAppResult m9003a(SearchApp searchApp) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAppResult searchAppResult = new SearchAppResult(searchApp);
        $jacocoInit[48] = true;
        return searchAppResult;
    }

    public Single<List<SearchAppResult>> searchInStore(String query, String storeName, int offset) {
        boolean[] $jacocoInit = $jacocoInit();
        ListSearchAppsRequest of = ListSearchAppsRequest.m7479of(query, storeName, offset, this.subscribedStoresAuthMap, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[23] = true;
        C0120S observe = of.observe(true);
        C4660i iVar = new C4660i(this);
        $jacocoInit[24] = true;
        C0120S d = observe.mo3653d((C0132p<? super T, Boolean>) iVar);
        C4655d dVar = C4655d.f8288a;
        $jacocoInit[25] = true;
        C0120S j = d.mo3669j(dVar);
        C4657f fVar = C4657f.f8290a;
        $jacocoInit[26] = true;
        C0120S h = j.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) fVar);
        C4670o oVar = C4670o.f8302a;
        $jacocoInit[27] = true;
        C0120S j2 = h.mo3669j(oVar);
        $jacocoInit[28] = true;
        C0120S m = j2.mo3675m();
        $jacocoInit[29] = true;
        C0120S d2 = m.mo3647d();
        $jacocoInit[30] = true;
        Single<List<SearchAppResult>> n = d2.mo3678n();
        $jacocoInit[31] = true;
        return n;
    }

    /* renamed from: e */
    public /* synthetic */ Boolean mo16038e(ListSearchApps listSearchApps) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(hasResults(listSearchApps));
        $jacocoInit[47] = true;
        return valueOf;
    }

    /* renamed from: f */
    static /* synthetic */ List m9011f(ListSearchApps data) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = data.getDataList();
        $jacocoInit[45] = true;
        List list = dataList.getList();
        $jacocoInit[46] = true;
        return list;
    }

    /* renamed from: c */
    static /* synthetic */ Iterable m9009c(List list) {
        $jacocoInit()[44] = true;
        return list;
    }

    /* renamed from: c */
    static /* synthetic */ SearchAppResult m9008c(SearchApp searchApp) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAppResult searchAppResult = new SearchAppResult(searchApp);
        $jacocoInit[43] = true;
        return searchAppResult;
    }

    private boolean hasResults(ListSearchApps listSearchApps) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        DataList<SearchApp> dataList = listSearchApps.getDataList();
        if (dataList == null) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            if (dataList.getList() == null) {
                $jacocoInit[34] = true;
            } else {
                $jacocoInit[35] = true;
                List list = dataList.getList();
                $jacocoInit[36] = true;
                if (list.size() <= 0) {
                    $jacocoInit[37] = true;
                } else {
                    $jacocoInit[38] = true;
                    z = true;
                    $jacocoInit[40] = true;
                    return z;
                }
            }
        }
        z = false;
        $jacocoInit[39] = true;
        $jacocoInit[40] = true;
        return z;
    }

    public Single<Boolean> shouldLoadBannerAd() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> shouldLoadBannerAd = this.moPubAdsManager.shouldLoadBannerAd();
        $jacocoInit[41] = true;
        return shouldLoadBannerAd;
    }

    public Single<Boolean> shouldLoadNativeAds() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> shouldLoadNativeAds = this.moPubAdsManager.shouldLoadNativeAds();
        $jacocoInit[42] = true;
        return shouldLoadNativeAds;
    }
}
