package p005cm.aptoide.p006pt.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import java.util.List;
import java.util.Random;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.Partner;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.GetAdsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.Location;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.ads.AdsRepository */
public class AdsRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;
    private final MinimalAdMapper adMapper;
    private final ConnectivityManager connectivityManager;
    private final Context context;
    private final Factory converterFactory;
    private final GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker;
    private final OkHttpClient httpClient;
    private final IdsRepository idsRepository;
    private final PartnerIdProvider partnerIdProvider;
    private final QManager qManager;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final AdsApplicationVersionCodeProvider versionCodeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5576786267761979970L, "cm/aptoide/pt/ads/AdsRepository", 128);
        $jacocoData = probes;
        return probes;
    }

    public AdsRepository(IdsRepository idsRepository2, AptoideAccountManager accountManager2, OkHttpClient httpClient2, Factory converterFactory2, QManager qManager2, SharedPreferences sharedPreferences2, Context applicationContext, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2, GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker2, PartnerIdProvider partnerIdProvider2, MinimalAdMapper adMapper2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.idsRepository = idsRepository2;
        this.accountManager = accountManager2;
        this.versionCodeProvider = versionCodeProvider2;
        this.googlePlayServicesAvailabilityChecker = googlePlayServicesAvailabilityChecker2;
        this.partnerIdProvider = partnerIdProvider2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.qManager = qManager2;
        this.sharedPreferences = sharedPreferences2;
        this.context = applicationContext;
        this.connectivityManager = connectivityManager2;
        this.resources = resources2;
        this.adMapper = adMapper2;
        $jacocoInit[0] = true;
    }

    public static boolean validAds(List<C2842Ad> ads) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (ads == null) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            if (ads.isEmpty()) {
                $jacocoInit[3] = true;
            } else {
                $jacocoInit[4] = true;
                if (ads.get(0) == null) {
                    $jacocoInit[5] = true;
                } else {
                    $jacocoInit[6] = true;
                    C2842Ad ad = (C2842Ad) ads.get(0);
                    $jacocoInit[7] = true;
                    if (ad.getPartner() == null) {
                        $jacocoInit[8] = true;
                    } else {
                        $jacocoInit[9] = true;
                        C2842Ad ad2 = (C2842Ad) ads.get(0);
                        $jacocoInit[10] = true;
                        Partner partner = ad2.getPartner();
                        $jacocoInit[11] = true;
                        if (partner.getData() == null) {
                            $jacocoInit[12] = true;
                        } else {
                            $jacocoInit[13] = true;
                            z = true;
                            $jacocoInit[15] = true;
                            return z;
                        }
                    }
                }
            }
        }
        $jacocoInit[14] = true;
        $jacocoInit[15] = true;
        return z;
    }

    public static boolean validAds(GetAdsResponse getAdsResponse) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (getAdsResponse == null) {
            $jacocoInit[16] = true;
        } else if (!validAds(getAdsResponse.getAds())) {
            $jacocoInit[17] = true;
        } else {
            $jacocoInit[18] = true;
            z = true;
            $jacocoInit[20] = true;
            return z;
        }
        z = false;
        $jacocoInit[19] = true;
        $jacocoInit[20] = true;
        return z;
    }

    public C0120S<MinimalAd> loadAdsFromAppView(String packageName, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[21] = true;
        C0120S d = accountStatus.mo3647d();
        C1663l lVar = new C1663l(this, packageName, storeName);
        $jacocoInit[22] = true;
        C0120S<MinimalAd> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) lVar);
        $jacocoInit[23] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo782a(String packageName, String storeName, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository idsRepository2 = this.idsRepository;
        $jacocoInit[120] = true;
        String uniqueIdentifier = idsRepository2.getUniqueIdentifier();
        GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker2 = this.googlePlayServicesAvailabilityChecker;
        Context context2 = this.context;
        $jacocoInit[121] = true;
        boolean isAvailable = googlePlayServicesAvailabilityChecker2.isAvailable(context2);
        PartnerIdProvider partnerIdProvider2 = this.partnerIdProvider;
        $jacocoInit[122] = true;
        String partnerId = partnerIdProvider2.getPartnerId();
        boolean isAdultContentEnabled = account.isAdultContentEnabled();
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        QManager qManager2 = this.qManager;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[123] = true;
        String filters = qManager2.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences2));
        SharedPreferences sharedPreferences3 = this.sharedPreferences;
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        Resources resources2 = this.resources;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = this.versionCodeProvider;
        $jacocoInit[124] = true;
        GetAdsRequest ofAppviewOrganic = GetAdsRequest.ofAppviewOrganic(packageName, storeName, uniqueIdentifier, isAvailable, partnerId, isAdultContentEnabled, okHttpClient, factory, filters, sharedPreferences3, connectivityManager2, resources2, adsApplicationVersionCodeProvider);
        $jacocoInit[125] = true;
        C0120S observe = ofAppviewOrganic.observe();
        $jacocoInit[126] = true;
        C0120S mapToMinimalAd = mapToMinimalAd(observe);
        $jacocoInit[127] = true;
        return mapToMinimalAd;
    }

    /* renamed from: b */
    static /* synthetic */ List m127b(GetAdsResponse getAdsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        List ads = getAdsResponse.getAds();
        $jacocoInit[119] = true;
        return ads;
    }

    private C0120S<MinimalAd> mapToMinimalAd(C0120S<GetAdsResponse> getAdsResponseObservable) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S j = getAdsResponseObservable.mo3669j(C1657f.f4604a);
        C1660i iVar = C1660i.f4610a;
        $jacocoInit[24] = true;
        C0120S f = j.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) iVar);
        C1653b bVar = new C1653b(this);
        $jacocoInit[25] = true;
        C0120S<MinimalAd> j2 = f.mo3669j(bVar);
        $jacocoInit[26] = true;
        return j2;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m125a(List ads) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!validAds(ads)) {
            $jacocoInit[116] = true;
            C0120S a = C0120S.m631a((Throwable) new IllegalStateException("Invalid ads returned from server"));
            $jacocoInit[117] = true;
            return a;
        }
        C0120S c = C0120S.m652c(ads.get(0));
        $jacocoInit[118] = true;
        return c;
    }

    /* renamed from: b */
    public /* synthetic */ MinimalAd mo785b(C2842Ad ad) {
        boolean[] $jacocoInit = $jacocoInit();
        MinimalAd map = this.adMapper.map(ad);
        $jacocoInit[115] = true;
        return map;
    }

    public C0120S<List<MinimalAd>> getAdsFromHomepageMore(boolean refresh) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[27] = true;
        C0120S d = accountStatus.mo3647d();
        C1661j jVar = new C1661j(this, refresh);
        $jacocoInit[28] = true;
        C0120S<List<MinimalAd>> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jVar);
        $jacocoInit[29] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo784a(boolean refresh, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository idsRepository2 = this.idsRepository;
        $jacocoInit[107] = true;
        String uniqueIdentifier = idsRepository2.getUniqueIdentifier();
        GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker2 = this.googlePlayServicesAvailabilityChecker;
        Context context2 = this.context;
        $jacocoInit[108] = true;
        boolean isAvailable = googlePlayServicesAvailabilityChecker2.isAvailable(context2);
        PartnerIdProvider partnerIdProvider2 = this.partnerIdProvider;
        $jacocoInit[109] = true;
        String partnerId = partnerIdProvider2.getPartnerId();
        boolean isAdultContentEnabled = account.isAdultContentEnabled();
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        QManager qManager2 = this.qManager;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[110] = true;
        String filters = qManager2.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences2));
        SharedPreferences sharedPreferences3 = this.sharedPreferences;
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        Resources resources2 = this.resources;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = this.versionCodeProvider;
        $jacocoInit[111] = true;
        GetAdsRequest ofHomepageMore = GetAdsRequest.ofHomepageMore(uniqueIdentifier, isAvailable, partnerId, isAdultContentEnabled, okHttpClient, factory, filters, sharedPreferences3, connectivityManager2, resources2, adsApplicationVersionCodeProvider);
        $jacocoInit[112] = true;
        C0120S observe = ofHomepageMore.observe(refresh);
        $jacocoInit[113] = true;
        C0120S mapToMinimalAds = mapToMinimalAds(observe);
        $jacocoInit[114] = true;
        return mapToMinimalAds;
    }

    private C0120S<List<MinimalAd>> mapToMinimalAds(C0120S<GetAdsResponse> getAdsResponseObservable) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S f = getAdsResponseObservable.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C1667p.f4620a);
        C1666o oVar = C1666o.f4619a;
        $jacocoInit[30] = true;
        C0120S j = f.mo3669j(oVar);
        C1656e eVar = new C1656e(this);
        $jacocoInit[31] = true;
        C0120S<List<MinimalAd>> j2 = j.mo3669j(eVar);
        $jacocoInit[32] = true;
        return j2;
    }

    /* renamed from: c */
    static /* synthetic */ C0120S m128c(GetAdsResponse ads) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!validAds(ads)) {
            $jacocoInit[104] = true;
            C0120S a = C0120S.m631a((Throwable) new IllegalStateException("Invalid ads returned from server"));
            $jacocoInit[105] = true;
            return a;
        }
        C0120S c = C0120S.m652c(ads);
        $jacocoInit[106] = true;
        return c;
    }

    /* renamed from: d */
    static /* synthetic */ List m129d(GetAdsResponse getAdsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        List ads = getAdsResponse.getAds();
        $jacocoInit[103] = true;
        return ads;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Ad>, for r7v0, types: [java.util.List, java.util.List<cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Ad>] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.util.List mo786b(java.util.List<p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad> r7) {
        /*
            r6 = this;
            boolean[] r0 = $jacocoInit()
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            r2 = 1
            r3 = 98
            r0[r3] = r2
            java.util.Iterator r3 = r7.iterator()
            r4 = 99
            r0[r4] = r2
        L_0x0016:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0034
            java.lang.Object r4 = r3.next()
            cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Ad r4 = (p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad) r4
            r5 = 100
            r0[r5] = r2
            cm.aptoide.pt.ads.MinimalAdMapper r5 = r6.adMapper
            cm.aptoide.pt.database.realm.MinimalAd r5 = r5.map(r4)
            r1.add(r5)
            r4 = 101(0x65, float:1.42E-43)
            r0[r4] = r2
            goto L_0x0016
        L_0x0034:
            r3 = 102(0x66, float:1.43E-43)
            r0[r3] = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.ads.AdsRepository.mo786b(java.util.List):java.util.List");
    }

    public C0120S<List<MinimalAd>> loadAdsFromAppviewSuggested(String packageName, List<String> keywords) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[33] = true;
        C0120S d = accountStatus.mo3647d();
        C1658g gVar = new C1658g(this, keywords, packageName);
        $jacocoInit[34] = true;
        C0120S<List<MinimalAd>> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gVar);
        $jacocoInit[35] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo783a(List keywords, String packageName, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository idsRepository2 = this.idsRepository;
        $jacocoInit[89] = true;
        String uniqueIdentifier = idsRepository2.getUniqueIdentifier();
        GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker2 = this.googlePlayServicesAvailabilityChecker;
        Context context2 = this.context;
        $jacocoInit[90] = true;
        boolean isAvailable = googlePlayServicesAvailabilityChecker2.isAvailable(context2);
        PartnerIdProvider partnerIdProvider2 = this.partnerIdProvider;
        $jacocoInit[91] = true;
        String partnerId = partnerIdProvider2.getPartnerId();
        boolean isAdultContentEnabled = account.isAdultContentEnabled();
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        QManager qManager2 = this.qManager;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[92] = true;
        String filters = qManager2.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences2));
        SharedPreferences sharedPreferences3 = this.sharedPreferences;
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        Resources resources2 = this.resources;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = this.versionCodeProvider;
        $jacocoInit[93] = true;
        GetAdsRequest ofAppviewSuggested = GetAdsRequest.ofAppviewSuggested(keywords, uniqueIdentifier, isAvailable, packageName, partnerId, isAdultContentEnabled, okHttpClient, factory, filters, sharedPreferences3, connectivityManager2, resources2, adsApplicationVersionCodeProvider);
        $jacocoInit[94] = true;
        C0120S observe = ofAppviewSuggested.observe();
        $jacocoInit[95] = true;
        C0120S mapToMinimalAds = mapToMinimalAds(observe);
        $jacocoInit[96] = true;
        C0120S b = mapToMinimalAds.mo3634b(Schedulers.m776io());
        $jacocoInit[97] = true;
        return b;
    }

    public C0120S<MinimalAd> getAdsFromSearch(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[36] = true;
        C0120S d = accountStatus.mo3647d();
        C1652a aVar = new C1652a(this, query);
        $jacocoInit[37] = true;
        C0120S<MinimalAd> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aVar);
        $jacocoInit[38] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo781a(String query, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository idsRepository2 = this.idsRepository;
        $jacocoInit[81] = true;
        String uniqueIdentifier = idsRepository2.getUniqueIdentifier();
        GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker2 = this.googlePlayServicesAvailabilityChecker;
        Context context2 = this.context;
        $jacocoInit[82] = true;
        boolean isAvailable = googlePlayServicesAvailabilityChecker2.isAvailable(context2);
        PartnerIdProvider partnerIdProvider2 = this.partnerIdProvider;
        $jacocoInit[83] = true;
        String partnerId = partnerIdProvider2.getPartnerId();
        boolean isAdultContentEnabled = account.isAdultContentEnabled();
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        QManager qManager2 = this.qManager;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[84] = true;
        String filters = qManager2.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences2));
        SharedPreferences sharedPreferences3 = this.sharedPreferences;
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        Resources resources2 = this.resources;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = this.versionCodeProvider;
        $jacocoInit[85] = true;
        GetAdsRequest ofSearch = GetAdsRequest.ofSearch(query, uniqueIdentifier, isAvailable, partnerId, isAdultContentEnabled, okHttpClient, factory, filters, sharedPreferences3, connectivityManager2, resources2, adsApplicationVersionCodeProvider);
        $jacocoInit[86] = true;
        C0120S observe = ofSearch.observe();
        $jacocoInit[87] = true;
        C0120S mapToMinimalAd = mapToMinimalAd(observe);
        $jacocoInit[88] = true;
        return mapToMinimalAd;
    }

    public C0120S<MinimalAd> getAdsFromSecondInstall(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[39] = true;
        C0120S d = accountStatus.mo3647d();
        C1659h hVar = new C1659h(this, packageName);
        $jacocoInit[40] = true;
        C0120S<MinimalAd> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) hVar);
        $jacocoInit[41] = true;
        return f;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo787b(String packageName, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository idsRepository2 = this.idsRepository;
        $jacocoInit[73] = true;
        String uniqueIdentifier = idsRepository2.getUniqueIdentifier();
        GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker2 = this.googlePlayServicesAvailabilityChecker;
        Context context2 = this.context;
        $jacocoInit[74] = true;
        boolean isAvailable = googlePlayServicesAvailabilityChecker2.isAvailable(context2);
        PartnerIdProvider partnerIdProvider2 = this.partnerIdProvider;
        $jacocoInit[75] = true;
        String partnerId = partnerIdProvider2.getPartnerId();
        boolean isAdultContentEnabled = account.isAdultContentEnabled();
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        QManager qManager2 = this.qManager;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[76] = true;
        String filters = qManager2.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences2));
        SharedPreferences sharedPreferences3 = this.sharedPreferences;
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        Resources resources2 = this.resources;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = this.versionCodeProvider;
        $jacocoInit[77] = true;
        GetAdsRequest ofSecondInstall = GetAdsRequest.ofSecondInstall(packageName, uniqueIdentifier, isAvailable, partnerId, isAdultContentEnabled, okHttpClient, factory, filters, sharedPreferences3, connectivityManager2, resources2, adsApplicationVersionCodeProvider);
        $jacocoInit[78] = true;
        C0120S observe = ofSecondInstall.observe();
        $jacocoInit[79] = true;
        C0120S mapToMinimalAd = mapToMinimalAd(observe);
        $jacocoInit[80] = true;
        return mapToMinimalAd;
    }

    public C0120S<MinimalAd> getAdsFromSecondTry(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[42] = true;
        C0120S d = accountStatus.mo3647d();
        C1654c cVar = new C1654c(this, packageName);
        $jacocoInit[43] = true;
        C0120S<MinimalAd> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) cVar);
        $jacocoInit[44] = true;
        return f;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo788c(String packageName, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository idsRepository2 = this.idsRepository;
        $jacocoInit[65] = true;
        String uniqueIdentifier = idsRepository2.getUniqueIdentifier();
        GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker2 = this.googlePlayServicesAvailabilityChecker;
        Context context2 = this.context;
        $jacocoInit[66] = true;
        boolean isAvailable = googlePlayServicesAvailabilityChecker2.isAvailable(context2);
        PartnerIdProvider partnerIdProvider2 = this.partnerIdProvider;
        $jacocoInit[67] = true;
        String partnerId = partnerIdProvider2.getPartnerId();
        boolean isAdultContentEnabled = account.isAdultContentEnabled();
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        QManager qManager2 = this.qManager;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[68] = true;
        String filters = qManager2.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences2));
        SharedPreferences sharedPreferences3 = this.sharedPreferences;
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        Resources resources2 = this.resources;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = this.versionCodeProvider;
        $jacocoInit[69] = true;
        GetAdsRequest ofSecondTry = GetAdsRequest.ofSecondTry(packageName, uniqueIdentifier, isAvailable, partnerId, isAdultContentEnabled, okHttpClient, factory, filters, sharedPreferences3, connectivityManager2, resources2, adsApplicationVersionCodeProvider);
        $jacocoInit[70] = true;
        C0120S observe = ofSecondTry.observe();
        $jacocoInit[71] = true;
        C0120S mapToMinimalAd = mapToMinimalAd(observe);
        $jacocoInit[72] = true;
        return mapToMinimalAd;
    }

    public C0120S<MinimalAd> getAdForShortcut() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[45] = true;
        C0120S d = accountStatus.mo3647d();
        C1665n nVar = new C1665n(this);
        $jacocoInit[46] = true;
        C0120S<MinimalAd> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nVar);
        $jacocoInit[47] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo780a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        Location location = Location.homepage;
        $jacocoInit[57] = true;
        Integer valueOf = Integer.valueOf(10);
        String uniqueIdentifier = this.idsRepository.getUniqueIdentifier();
        GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker2 = this.googlePlayServicesAvailabilityChecker;
        Context context2 = this.context;
        $jacocoInit[58] = true;
        boolean isAvailable = googlePlayServicesAvailabilityChecker2.isAvailable(context2);
        PartnerIdProvider partnerIdProvider2 = this.partnerIdProvider;
        $jacocoInit[59] = true;
        String partnerId = partnerIdProvider2.getPartnerId();
        boolean isAdultContentEnabled = account.isAdultContentEnabled();
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        QManager qManager2 = this.qManager;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[60] = true;
        String filters = qManager2.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences2));
        SharedPreferences sharedPreferences3 = this.sharedPreferences;
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        Resources resources2 = this.resources;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = this.versionCodeProvider;
        $jacocoInit[61] = true;
        GetAdsRequest of = GetAdsRequest.m7438of(location, "__NULL__", valueOf, uniqueIdentifier, isAvailable, partnerId, isAdultContentEnabled, okHttpClient, factory, filters, sharedPreferences3, connectivityManager2, resources2, adsApplicationVersionCodeProvider);
        $jacocoInit[62] = true;
        C0120S observe = of.observe();
        $jacocoInit[63] = true;
        C0120S mapRandomAd = mapRandomAd(observe);
        $jacocoInit[64] = true;
        return mapRandomAd;
    }

    private C0120S<MinimalAd> mapRandomAd(C0120S<GetAdsResponse> getAdsResponseObservable) {
        boolean[] $jacocoInit = $jacocoInit();
        Random rand = new Random();
        $jacocoInit[48] = true;
        C0120S j = getAdsResponseObservable.mo3669j(C1655d.f4602a);
        C1664m mVar = new C1664m(rand);
        $jacocoInit[49] = true;
        C0120S f = j.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mVar);
        C1662k kVar = new C1662k(this);
        $jacocoInit[50] = true;
        C0120S<MinimalAd> j2 = f.mo3669j(kVar);
        $jacocoInit[51] = true;
        return j2;
    }

    /* renamed from: a */
    static /* synthetic */ List m124a(GetAdsResponse getAdsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        List ads = getAdsResponse.getAds();
        $jacocoInit[56] = true;
        return ads;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m126a(Random rand, List ads) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!validAds(ads)) {
            $jacocoInit[53] = true;
            C0120S a = C0120S.m631a((Throwable) new IllegalStateException("Invalid ads returned from server"));
            $jacocoInit[54] = true;
            return a;
        }
        C0120S c = C0120S.m652c(ads.get(rand.nextInt(10)));
        $jacocoInit[55] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ MinimalAd mo779a(C2842Ad ad) {
        boolean[] $jacocoInit = $jacocoInit();
        MinimalAd map = this.adMapper.map(ad);
        $jacocoInit[52] = true;
        return map;
    }
}
