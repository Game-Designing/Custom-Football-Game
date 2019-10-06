package p005cm.aptoide.p006pt.app;

import java.util.List;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.account.view.store.StoreManager;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.ads.data.AptoideNativeAd;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationManager;
import p005cm.aptoide.p006pt.app.view.AppCoinsViewModel;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.app.view.donations.Donation;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Pay;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.GenericResponseV2;
import p005cm.aptoide.p006pt.download.AppContext;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.download.Origin;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.Install.InstallationType;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.notification.AppcPromotionNotificationStringProvider;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.notification.sync.LocalNotificationSync;
import p005cm.aptoide.p006pt.notification.sync.LocalNotificationSyncManager;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction;
import p005cm.aptoide.p006pt.promotions.PromotionsManager;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.view.AppViewConfiguration;
import p005cm.aptoide.p006pt.view.app.AppCenter;
import p005cm.aptoide.p006pt.view.app.AppDeveloper;
import p005cm.aptoide.p006pt.view.app.AppFlags;
import p005cm.aptoide.p006pt.view.app.AppMedia;
import p005cm.aptoide.p006pt.view.app.AppRating;
import p005cm.aptoide.p006pt.view.app.AppStats;
import p005cm.aptoide.p006pt.view.app.AppsList;
import p005cm.aptoide.p006pt.view.app.DetailedApp;
import p005cm.aptoide.p006pt.view.app.DetailedAppRequestResult;
import p005cm.aptoide.p006pt.view.app.DetailedAppRequestResult.Error;
import p005cm.aptoide.p006pt.view.app.FlagsVote.VoteType;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import p026rx.p027b.C14542r;
import rx.Observable;

/* renamed from: cm.aptoide.pt.app.AppViewManager */
public class AppViewManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AdsManager adsManager;
    private final AppCenter appCenter;
    private AppCoinsManager appCoinsManager;
    private AppViewAnalytics appViewAnalytics;
    private final AppViewConfiguration appViewConfiguration;
    private AppcMigrationManager appcMigrationManager;
    private boolean appcPromotionImpressionSent = false;
    private AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider;
    private final AptoideAccountManager aptoideAccountManager;
    private DetailedApp cachedApp;
    private AppCoinsViewModel cachedAppCoinsViewModel;
    private SimilarAppsViewModel cachedAppcSimilarAppsViewModel;
    private PromotionViewModel cachedPromotionViewModel;
    private SimilarAppsViewModel cachedSimilarAppsViewModel;
    private final DownloadFactory downloadFactory;
    private DownloadStateParser downloadStateParser;
    private final FlagManager flagManager;
    private final InstallAnalytics installAnalytics;
    private final InstallManager installManager;
    private final InstalledRepository installedRepository;
    private final C0126V ioScheduler;
    private boolean isFirstLoad = true;
    private final int limit;
    private LocalNotificationSyncManager localNotificationSyncManager;
    private String marketName;
    private boolean migrationImpressionSent = false;
    private final MoPubAdsManager moPubAdsManager;
    private NotificationAnalytics notificationAnalytics;
    private final PromotionsManager promotionsManager;
    private final ReviewsManager reviewsManager;
    private SearchAdResult searchAdResult;
    private final StoreManager storeManager;
    private final StoreUtilsProxy storeUtilsProxy;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2148387353731402717L, "cm/aptoide/pt/app/AppViewManager", 381);
        $jacocoData = probes;
        return probes;
    }

    public AppViewManager(InstallManager installManager2, DownloadFactory downloadFactory2, AppCenter appCenter2, ReviewsManager reviewsManager2, AdsManager adsManager2, StoreManager storeManager2, FlagManager flagManager2, StoreUtilsProxy storeUtilsProxy2, AptoideAccountManager aptoideAccountManager2, AppViewConfiguration appViewConfiguration2, MoPubAdsManager moPubAdsManager2, DownloadStateParser downloadStateParser2, AppViewAnalytics appViewAnalytics2, NotificationAnalytics notificationAnalytics2, InstallAnalytics installAnalytics2, int limit2, C0126V ioScheduler2, String marketName2, AppCoinsManager appCoinsManager2, PromotionsManager promotionsManager2, InstalledRepository installedRepository2, AppcMigrationManager appcMigrationManager2, LocalNotificationSyncManager localNotificationSyncManager2, AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager = installManager2;
        this.downloadFactory = downloadFactory2;
        this.appCenter = appCenter2;
        this.reviewsManager = reviewsManager2;
        this.adsManager = adsManager2;
        this.storeManager = storeManager2;
        this.flagManager = flagManager2;
        this.storeUtilsProxy = storeUtilsProxy2;
        this.aptoideAccountManager = aptoideAccountManager2;
        this.appViewConfiguration = appViewConfiguration2;
        this.moPubAdsManager = moPubAdsManager2;
        this.downloadStateParser = downloadStateParser2;
        this.appViewAnalytics = appViewAnalytics2;
        this.notificationAnalytics = notificationAnalytics2;
        this.installAnalytics = installAnalytics2;
        this.ioScheduler = ioScheduler2;
        this.limit = limit2;
        this.marketName = marketName2;
        this.appCoinsManager = appCoinsManager2;
        this.promotionsManager = promotionsManager2;
        this.installedRepository = installedRepository2;
        this.appcMigrationManager = appcMigrationManager2;
        this.localNotificationSyncManager = localNotificationSyncManager2;
        this.appcPromotionNotificationStringProvider = appcPromotionNotificationStringProvider2;
        $jacocoInit[0] = true;
    }

    public Single<AppViewViewModel> loadAppViewViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.appViewConfiguration.getAppId() >= 0) {
            $jacocoInit[1] = true;
            long appId = this.appViewConfiguration.getAppId();
            AppViewConfiguration appViewConfiguration2 = this.appViewConfiguration;
            $jacocoInit[2] = true;
            String storeName = appViewConfiguration2.getStoreName();
            String packageName = this.appViewConfiguration.getPackageName();
            $jacocoInit[3] = true;
            Single<AppViewViewModel> loadAppViewViewModel = loadAppViewViewModel(appId, storeName, packageName);
            $jacocoInit[4] = true;
            return loadAppViewViewModel;
        } else if (this.appViewConfiguration.hasMd5()) {
            $jacocoInit[5] = true;
            Single<AppViewViewModel> loadAppViewViewModelFromMd5 = loadAppViewViewModelFromMd5(this.appViewConfiguration.getMd5());
            $jacocoInit[6] = true;
            return loadAppViewViewModelFromMd5;
        } else if (this.appViewConfiguration.hasUniqueName()) {
            $jacocoInit[7] = true;
            Single<AppViewViewModel> loadAppViewViewModelFromUniqueName = loadAppViewViewModelFromUniqueName(this.appViewConfiguration.getUniqueName());
            $jacocoInit[8] = true;
            return loadAppViewViewModelFromUniqueName;
        } else {
            String packageName2 = this.appViewConfiguration.getPackageName();
            AppViewConfiguration appViewConfiguration3 = this.appViewConfiguration;
            $jacocoInit[9] = true;
            String storeName2 = appViewConfiguration3.getStoreName();
            $jacocoInit[10] = true;
            Single<AppViewViewModel> loadAppViewViewModel2 = loadAppViewViewModel(packageName2, storeName2);
            $jacocoInit[11] = true;
            return loadAppViewViewModel2;
        }
    }

    public Single<ReviewsViewModel> loadReviewsViewModel(String storeName, String packageName, String languagesFilterSort) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadReviews = this.reviewsManager.loadReviews(storeName, packageName, 3, languagesFilterSort);
        C2276x xVar = C2276x.f5351a;
        $jacocoInit[12] = true;
        Single<ReviewsViewModel> d = loadReviews.mo3698d(xVar);
        $jacocoInit[13] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ ReviewsViewModel m6424a(ReviewRequestResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        List reviewList = result.getReviewList();
        boolean isLoading = result.isLoading();
        $jacocoInit[379] = true;
        ReviewsViewModel reviewsViewModel = new ReviewsViewModel(reviewList, isLoading, result.getError());
        $jacocoInit[380] = true;
        return reviewsViewModel;
    }

    public Single<SimilarAppsViewModel> loadAppcSimilarAppsViewModel(String packageName, List<String> list) {
        boolean[] $jacocoInit = $jacocoInit();
        SimilarAppsViewModel similarAppsViewModel = this.cachedAppcSimilarAppsViewModel;
        if (similarAppsViewModel != null) {
            $jacocoInit[14] = true;
            Single<SimilarAppsViewModel> a = Single.m734a(similarAppsViewModel);
            $jacocoInit[15] = true;
            return a;
        }
        Single<SimilarAppsViewModel> d = loadAppcRecommended(this.limit, packageName).mo3698d(new C1748u(this));
        $jacocoInit[16] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ SimilarAppsViewModel mo10157a(AppsList recommendedAppsRequestResult) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[376] = true;
        List list = recommendedAppsRequestResult.getList();
        $jacocoInit[377] = true;
        SimilarAppsViewModel similarAppsViewModel = new SimilarAppsViewModel(null, list, recommendedAppsRequestResult.isLoading(), recommendedAppsRequestResult.getError(), null);
        this.cachedAppcSimilarAppsViewModel = similarAppsViewModel;
        SimilarAppsViewModel similarAppsViewModel2 = this.cachedAppcSimilarAppsViewModel;
        $jacocoInit[378] = true;
        return similarAppsViewModel2;
    }

    public Single<SimilarAppsViewModel> loadSimilarAppsViewModel(String packageName, List<String> keyWords) {
        boolean[] $jacocoInit = $jacocoInit();
        SimilarAppsViewModel similarAppsViewModel = this.cachedSimilarAppsViewModel;
        if (similarAppsViewModel != null) {
            $jacocoInit[17] = true;
            Single<SimilarAppsViewModel> a = Single.m734a(similarAppsViewModel);
            $jacocoInit[18] = true;
            return a;
        }
        Single loadAd = this.adsManager.loadAd(packageName, keyWords);
        C1717X x = new C1717X(this, packageName);
        $jacocoInit[19] = true;
        Single<SimilarAppsViewModel> a2 = loadAd.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) x);
        $jacocoInit[20] = true;
        return a2;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo10184b(String packageName, MinimalAdRequestResult adResult) {
        boolean[] $jacocoInit = $jacocoInit();
        Single d = loadRecommended(this.limit, packageName).mo3698d(new C1697D(this, adResult));
        $jacocoInit[371] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ SimilarAppsViewModel mo10156a(MinimalAdRequestResult adResult, AppsList recommendedAppsRequestResult) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationAd ad = adResult.getAd();
        $jacocoInit[372] = true;
        List list = recommendedAppsRequestResult.getList();
        $jacocoInit[373] = true;
        boolean isLoading = recommendedAppsRequestResult.isLoading();
        $jacocoInit[374] = true;
        SimilarAppsViewModel similarAppsViewModel = new SimilarAppsViewModel(ad, list, isLoading, recommendedAppsRequestResult.getError(), adResult.getError());
        this.cachedSimilarAppsViewModel = similarAppsViewModel;
        SimilarAppsViewModel similarAppsViewModel2 = this.cachedSimilarAppsViewModel;
        $jacocoInit[375] = true;
        return similarAppsViewModel2;
    }

    public Single<SimilarAppsViewModel> loadAptoideSimilarAppsViewModel(String packageName, List<String> keyWords) {
        boolean[] $jacocoInit = $jacocoInit();
        SimilarAppsViewModel similarAppsViewModel = this.cachedSimilarAppsViewModel;
        if (similarAppsViewModel != null) {
            $jacocoInit[21] = true;
            Single<SimilarAppsViewModel> a = Single.m734a(similarAppsViewModel);
            $jacocoInit[22] = true;
            return a;
        }
        Single<SimilarAppsViewModel> a2 = loadAdForSimilarApps(packageName, keyWords).mo3688a((C0132p<? super T, ? extends Single<? extends R>>) new C1711Q<Object,Object>(this, packageName));
        $jacocoInit[23] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo10167a(String packageName, MinimalAdRequestResult adResult) {
        boolean[] $jacocoInit = $jacocoInit();
        Single d = loadRecommended(this.limit, packageName).mo3698d(new C1742o(this, adResult));
        $jacocoInit[362] = true;
        return d;
    }

    /* renamed from: b */
    public /* synthetic */ SimilarAppsViewModel mo10179b(MinimalAdRequestResult adResult, AppsList recommendedAppsRequestResult) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationAd applicationAd = null;
        $jacocoInit[363] = true;
        if (adResult.getMinimalAd() == null) {
            $jacocoInit[364] = true;
        } else {
            $jacocoInit[365] = true;
            applicationAd = new AptoideNativeAd(adResult.getMinimalAd());
            $jacocoInit[366] = true;
        }
        $jacocoInit[367] = true;
        List list = recommendedAppsRequestResult.getList();
        $jacocoInit[368] = true;
        boolean isLoading = recommendedAppsRequestResult.isLoading();
        $jacocoInit[369] = true;
        SimilarAppsViewModel similarAppsViewModel = new SimilarAppsViewModel(applicationAd, list, isLoading, recommendedAppsRequestResult.getError(), adResult.getError());
        this.cachedSimilarAppsViewModel = similarAppsViewModel;
        SimilarAppsViewModel similarAppsViewModel2 = this.cachedSimilarAppsViewModel;
        $jacocoInit[370] = true;
        return similarAppsViewModel2;
    }

    public Single<SearchAdResult> loadAdsFromAppView() {
        boolean[] $jacocoInit = $jacocoInit();
        AdsManager adsManager2 = this.adsManager;
        String packageName = this.cachedApp.getPackageName();
        Store store = this.cachedApp.getStore();
        $jacocoInit[24] = true;
        String name = store.getName();
        $jacocoInit[25] = true;
        Single loadAds = adsManager2.loadAds(packageName, name);
        C1733ga gaVar = C1733ga.f4705a;
        $jacocoInit[26] = true;
        Single<SearchAdResult> d = loadAds.mo3698d(gaVar);
        $jacocoInit[27] = true;
        return d;
    }

    public Single<Boolean> recordInterstitialImpression() {
        boolean[] $jacocoInit = $jacocoInit();
        Single recordInterstitialAdImpression = this.moPubAdsManager.recordInterstitialAdImpression();
        C0126V v = this.ioScheduler;
        $jacocoInit[28] = true;
        Single<Boolean> b = recordInterstitialAdImpression.mo3694b(v);
        $jacocoInit[29] = true;
        return b;
    }

    public Single<Boolean> recordInterstitialClick() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> recordInterstitialAdClick = this.moPubAdsManager.recordInterstitialAdClick();
        $jacocoInit[30] = true;
        return recordInterstitialAdClick;
    }

    public C0120S<DownloadAppViewModel> loadDownloadAppViewModel(String md5, String packageName, int versionCode, boolean paidApp, Pay pay, String signature, long storeId, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadDownloadModel = loadDownloadModel(md5, packageName, versionCode, paidApp, pay, signature, storeId, hasAppc);
        C1702H h = new C1702H(this);
        $jacocoInit[31] = true;
        C0120S<DownloadAppViewModel> j = loadDownloadModel.mo3669j(h);
        $jacocoInit[32] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ DownloadAppViewModel mo10153a(DownloadModel downloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAppViewModel downloadAppViewModel = new DownloadAppViewModel(downloadModel, this.cachedSimilarAppsViewModel, this.cachedAppcSimilarAppsViewModel, this.cachedAppCoinsViewModel);
        $jacocoInit[361] = true;
        return downloadAppViewModel;
    }

    public Single<Boolean> flagApk(String storeName, String md5, VoteType type) {
        boolean[] $jacocoInit = $jacocoInit();
        FlagManager flagManager2 = this.flagManager;
        String name = type.name();
        $jacocoInit[33] = true;
        String lowerCase = name.toLowerCase();
        $jacocoInit[34] = true;
        Single flagApk = flagManager2.flagApk(storeName, md5, lowerCase);
        C1747t tVar = C1747t.f4739a;
        $jacocoInit[35] = true;
        Single<Boolean> d = flagApk.mo3698d(tVar);
        $jacocoInit[36] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6427a(GenericResponseV2 response) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!response.isOk()) {
            $jacocoInit[356] = true;
        } else if (response.hasErrors()) {
            $jacocoInit[357] = true;
        } else {
            $jacocoInit[358] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[360] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[359] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[360] = true;
        return valueOf2;
    }

    public C0117M subscribeStore(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1710P(this, storeName));
        $jacocoInit[37] = true;
        return c;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10190c(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeUtilsProxy.subscribeStore(storeName, null, null, this.aptoideAccountManager);
        $jacocoInit[355] = true;
    }

    private Single<AppViewViewModel> loadAppViewViewModel(long appId, String storeName, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedApp detailedApp = this.cachedApp;
        if (detailedApp != null) {
            $jacocoInit[38] = true;
            Single<AppViewViewModel> createAppViewViewModel = createAppViewViewModel(detailedApp);
            $jacocoInit[39] = true;
            return createAppViewViewModel;
        }
        Single loadDetailedApp = this.appCenter.loadDetailedApp(appId, storeName, packageName);
        C1738l lVar = new C1738l(this);
        $jacocoInit[40] = true;
        Single<AppViewViewModel> a = loadDetailedApp.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) lVar);
        $jacocoInit[41] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo10182b(DetailedAppRequestResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        Single map = map(result);
        $jacocoInit[354] = true;
        return map;
    }

    private Single<AppViewViewModel> loadAppViewViewModel(String packageName, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedApp detailedApp = this.cachedApp;
        if (detailedApp == null) {
            $jacocoInit[42] = true;
        } else {
            String packageName2 = detailedApp.getPackageName();
            $jacocoInit[43] = true;
            if (!packageName2.equals(packageName)) {
                $jacocoInit[44] = true;
            } else {
                Store store = this.cachedApp.getStore();
                $jacocoInit[45] = true;
                String name = store.getName();
                $jacocoInit[46] = true;
                if (!name.equals(storeName)) {
                    $jacocoInit[47] = true;
                } else {
                    $jacocoInit[48] = true;
                    Single<AppViewViewModel> createAppViewViewModel = createAppViewViewModel(this.cachedApp);
                    $jacocoInit[49] = true;
                    return createAppViewViewModel;
                }
            }
        }
        Single loadDetailedApp = this.appCenter.loadDetailedApp(packageName, storeName);
        C1714U u = new C1714U(this);
        $jacocoInit[50] = true;
        Single<AppViewViewModel> a = loadDetailedApp.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) u);
        $jacocoInit[51] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo10166a(DetailedAppRequestResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        Single map = map(result);
        $jacocoInit[353] = true;
        return map;
    }

    private Single<AppViewViewModel> loadAppViewViewModelFromMd5(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedApp detailedApp = this.cachedApp;
        if (detailedApp == null) {
            $jacocoInit[52] = true;
        } else {
            String md52 = detailedApp.getMd5();
            $jacocoInit[53] = true;
            if (!md52.equals(md5)) {
                $jacocoInit[54] = true;
            } else {
                $jacocoInit[55] = true;
                Single<AppViewViewModel> createAppViewViewModel = createAppViewViewModel(this.cachedApp);
                $jacocoInit[56] = true;
                return createAppViewViewModel;
            }
        }
        Single loadDetailedAppFromMd5 = this.appCenter.loadDetailedAppFromMd5(md5);
        C1715V v = new C1715V(this);
        $jacocoInit[57] = true;
        Single<AppViewViewModel> a = loadDetailedAppFromMd5.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) v);
        $jacocoInit[58] = true;
        return a;
    }

    /* renamed from: c */
    public /* synthetic */ Single mo10188c(DetailedAppRequestResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        Single map = map(result);
        $jacocoInit[352] = true;
        return map;
    }

    private Single<AppViewViewModel> loadAppViewViewModelFromUniqueName(String uniqueName) {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedApp detailedApp = this.cachedApp;
        if (detailedApp == null) {
            $jacocoInit[59] = true;
        } else {
            String uniqueName2 = detailedApp.getUniqueName();
            $jacocoInit[60] = true;
            if (!uniqueName2.equals(uniqueName)) {
                $jacocoInit[61] = true;
            } else {
                $jacocoInit[62] = true;
                Single<AppViewViewModel> createAppViewViewModel = createAppViewViewModel(this.cachedApp);
                $jacocoInit[63] = true;
                return createAppViewViewModel;
            }
        }
        Single loadDetailedAppFromUniqueName = this.appCenter.loadDetailedAppFromUniqueName(uniqueName);
        C1741n nVar = new C1741n(this);
        $jacocoInit[64] = true;
        Single<AppViewViewModel> a = loadDetailedAppFromUniqueName.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) nVar);
        $jacocoInit[65] = true;
        return a;
    }

    /* renamed from: d */
    public /* synthetic */ Single mo10192d(DetailedAppRequestResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        Single map = map(result);
        $jacocoInit[351] = true;
        return map;
    }

    private Single<AppsList> loadRecommended(int limit2, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AppsList> loadRecommendedApps = this.appCenter.loadRecommendedApps(limit2, packageName);
        $jacocoInit[66] = true;
        return loadRecommendedApps;
    }

    private Single<AppsList> loadAppcRecommended(int limit2, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AppsList> loadAppcRecommendedApps = this.appCenter.loadAppcRecommendedApps(limit2, packageName);
        $jacocoInit[67] = true;
        return loadAppcRecommendedApps;
    }

    private Single<MinimalAdRequestResult> loadAdForSimilarApps(String packageName, List<String> keyWords) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<MinimalAdRequestResult> loadAd = this.adsManager.loadAd(packageName, keyWords);
        $jacocoInit[68] = true;
        return loadAd;
    }

    public SimilarAppsViewModel getCachedSimilarAppsViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        SimilarAppsViewModel similarAppsViewModel = this.cachedSimilarAppsViewModel;
        $jacocoInit[69] = true;
        return similarAppsViewModel;
    }

    private Single<Boolean> isStoreFollowed(long storeId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isSubscribed = this.storeManager.isSubscribed(storeId);
        $jacocoInit[70] = true;
        C0120S d = isSubscribed.mo3647d();
        $jacocoInit[71] = true;
        Single<Boolean> n = d.mo3678n();
        $jacocoInit[72] = true;
        return n;
    }

    private Single<AppViewViewModel> createAppViewViewModel(DetailedApp app) {
        boolean[] $jacocoInit = $jacocoInit();
        AppStats stats = app.getStats();
        this.cachedApp = app;
        $jacocoInit[73] = true;
        Store store = app.getStore();
        $jacocoInit[74] = true;
        long id = store.getId();
        $jacocoInit[75] = true;
        Single isStoreFollowed = isStoreFollowed(id);
        C1737k kVar = new C1737k(this, app, stats);
        $jacocoInit[76] = true;
        Single<AppViewViewModel> d = isStoreFollowed.mo3698d(kVar);
        $jacocoInit[77] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ AppViewViewModel mo10152a(DetailedApp app, AppStats stats, Boolean isStoreFollowed) {
        boolean[] $jacocoInit = $jacocoInit();
        long id = app.getId();
        String name = app.getName();
        Store store = app.getStore();
        AppViewConfiguration appViewConfiguration2 = this.appViewConfiguration;
        $jacocoInit[337] = true;
        String storeTheme = appViewConfiguration2.getStoreTheme();
        boolean isGoodApp = app.isGoodApp();
        Malware malware = app.getMalware();
        $jacocoInit[338] = true;
        AppFlags appFlags = app.getAppFlags();
        List tags = app.getTags();
        List usedFeatures = app.getUsedFeatures();
        List usedPermissions = app.getUsedPermissions();
        $jacocoInit[339] = true;
        long fileSize = app.getFileSize();
        String md5 = app.getMd5();
        String path = app.getPath();
        String pathAlt = app.getPathAlt();
        int versionCode = app.getVersionCode();
        $jacocoInit[340] = true;
        String versionName = app.getVersionName();
        String packageName = app.getPackageName();
        long size = app.getSize();
        int downloads = stats.getDownloads();
        $jacocoInit[341] = true;
        AppRating globalRating = stats.getGlobalRating();
        int packageDownloads = stats.getPackageDownloads();
        AppRating rating = stats.getRating();
        $jacocoInit[342] = true;
        AppDeveloper developer = app.getDeveloper();
        String graphic = app.getGraphic();
        String icon = app.getIcon();
        AppMedia media = app.getMedia();
        String modified = app.getModified();
        $jacocoInit[343] = true;
        String added = app.getAdded();
        Obb obb = app.getObb();
        Pay pay = app.getPay();
        String webUrls = app.getWebUrls();
        boolean isPaid = app.isPaid();
        $jacocoInit[344] = true;
        boolean wasPaid = app.wasPaid();
        String paidAppPath = app.getPaidAppPath();
        String paymentStatus = app.getPaymentStatus();
        $jacocoInit[345] = true;
        boolean isLatestTrustedVersion = app.isLatestTrustedVersion();
        String uniqueName = app.getUniqueName();
        OpenType shouldInstall = this.appViewConfiguration.shouldInstall();
        AppViewConfiguration appViewConfiguration3 = this.appViewConfiguration;
        $jacocoInit[346] = true;
        double appc = appViewConfiguration3.getAppc();
        SearchAdResult minimalAd = this.appViewConfiguration.getMinimalAd();
        AppViewConfiguration appViewConfiguration4 = this.appViewConfiguration;
        $jacocoInit[347] = true;
        String editorsChoice = appViewConfiguration4.getEditorsChoice();
        String originTag = this.appViewConfiguration.getOriginTag();
        $jacocoInit[348] = true;
        boolean booleanValue = isStoreFollowed.booleanValue();
        String str = this.marketName;
        boolean hasBilling = app.hasBilling();
        boolean hasAdvertising = app.hasAdvertising();
        List bdsFlags = app.getBdsFlags();
        AppViewConfiguration appViewConfiguration5 = this.appViewConfiguration;
        $jacocoInit[349] = true;
        AppViewViewModel appViewViewModel = new AppViewViewModel(id, name, store, storeTheme, isGoodApp, malware, appFlags, tags, usedFeatures, usedPermissions, fileSize, md5, path, pathAlt, versionCode, versionName, packageName, size, downloads, globalRating, packageDownloads, rating, developer, graphic, icon, media, modified, added, obb, pay, webUrls, isPaid, wasPaid, paidAppPath, paymentStatus, isLatestTrustedVersion, uniqueName, shouldInstall, appc, minimalAd, editorsChoice, originTag, booleanValue, str, hasBilling, hasAdvertising, bdsFlags, appViewConfiguration5.getCampaignUrl(), app.getSignature());
        $jacocoInit[350] = true;
        return appViewViewModel;
    }

    private Single<AppViewViewModel> map(DetailedAppRequestResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getDetailedApp() != null) {
            $jacocoInit[78] = true;
            Single<AppViewViewModel> createAppViewViewModel = createAppViewViewModel(result.getDetailedApp());
            $jacocoInit[79] = true;
            return createAppViewViewModel;
        } else if (result.isLoading()) {
            $jacocoInit[80] = true;
            Single<AppViewViewModel> a = Single.m734a(new AppViewViewModel(result.isLoading()));
            $jacocoInit[81] = true;
            return a;
        } else if (result.hasError()) {
            $jacocoInit[82] = true;
            Single<AppViewViewModel> a2 = Single.m734a(new AppViewViewModel(result.getError()));
            $jacocoInit[83] = true;
            return a2;
        } else {
            Single<AppViewViewModel> a3 = Single.m734a(new AppViewViewModel(Error.GENERIC));
            $jacocoInit[84] = true;
            return a3;
        }
    }

    public boolean shouldShowRootInstallWarningPopup() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean showWarning = this.installManager.showWarning();
        $jacocoInit[85] = true;
        return showWarning;
    }

    public void allowRootInstall(Boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.rootInstallAllowed(answer.booleanValue());
        $jacocoInit[86] = true;
    }

    public C0117M downloadApp(Action downloadAction, long appId, String trustedValue, String editorsChoicePosition) {
        boolean z;
        Action action = downloadAction;
        boolean[] $jacocoInit = $jacocoInit();
        DownloadFactory downloadFactory2 = this.downloadFactory;
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[87] = true;
        int parseDownloadAction = downloadStateParser2.parseDownloadAction(action);
        DetailedApp detailedApp = this.cachedApp;
        $jacocoInit[88] = true;
        String name = detailedApp.getName();
        String packageName = this.cachedApp.getPackageName();
        String md5 = this.cachedApp.getMd5();
        DetailedApp detailedApp2 = this.cachedApp;
        $jacocoInit[89] = true;
        String icon = detailedApp2.getIcon();
        String versionName = this.cachedApp.getVersionName();
        int versionCode = this.cachedApp.getVersionCode();
        DetailedApp detailedApp3 = this.cachedApp;
        $jacocoInit[90] = true;
        String path = detailedApp3.getPath();
        String pathAlt = this.cachedApp.getPathAlt();
        Obb obb = this.cachedApp.getObb();
        DetailedApp detailedApp4 = this.cachedApp;
        $jacocoInit[91] = true;
        if (detailedApp4.hasAdvertising()) {
            $jacocoInit[92] = true;
        } else if (this.cachedApp.hasBilling()) {
            $jacocoInit[93] = true;
        } else {
            $jacocoInit[95] = true;
            z = false;
            long size = this.cachedApp.getSize();
            $jacocoInit[96] = true;
            Download create = downloadFactory2.create(parseDownloadAction, name, packageName, md5, icon, versionName, versionCode, path, pathAlt, obb, z, size);
            $jacocoInit[97] = true;
            C0120S c = C0120S.m652c(create);
            C1716W w = new C1716W(this, downloadAction, appId, trustedValue, editorsChoicePosition);
            $jacocoInit[98] = true;
            C0120S i = c.mo3668i(w);
            C1712S s = new C1712S(this, action);
            $jacocoInit[99] = true;
            C0120S b = i.mo3636b((C0129b<? super T>) s);
            C1703I i2 = new C1703I(this);
            $jacocoInit[100] = true;
            C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) i2);
            $jacocoInit[101] = true;
            C0117M l = g.mo3673l();
            $jacocoInit[102] = true;
            return l;
        }
        $jacocoInit[94] = true;
        z = true;
        long size2 = this.cachedApp.getSize();
        $jacocoInit[96] = true;
        Download create2 = downloadFactory2.create(parseDownloadAction, name, packageName, md5, icon, versionName, versionCode, path, pathAlt, obb, z, size2);
        $jacocoInit[97] = true;
        C0120S c2 = C0120S.m652c(create2);
        C1716W w2 = new C1716W(this, downloadAction, appId, trustedValue, editorsChoicePosition);
        $jacocoInit[98] = true;
        C0120S i3 = c2.mo3668i(w2);
        C1712S s2 = new C1712S(this, action);
        $jacocoInit[99] = true;
        C0120S b2 = i3.mo3636b((C0129b<? super T>) s2);
        C1703I i22 = new C1703I(this);
        $jacocoInit[100] = true;
        C0120S g2 = b2.mo3663g((C0132p<? super T, ? extends C0117M>) i22);
        $jacocoInit[101] = true;
        C0117M l2 = g2.mo3673l();
        $jacocoInit[102] = true;
        return l2;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo10164a(Action downloadAction, long appId, String trustedValue, String editorsChoicePosition, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        C1746s sVar = new C1746s(this, download, downloadAction, appId, trustedValue, editorsChoicePosition);
        $jacocoInit[328] = true;
        Single b = adsVisibilityStatus.mo3695b((C0129b<? super T>) sVar);
        C1708N n = new C1708N(download);
        $jacocoInit[329] = true;
        Single d = b.mo3698d(n);
        $jacocoInit[330] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10171a(Download download, Action downloadAction, long appId, String trustedValue, String editorsChoicePosition, OfferResponseStatus status) {
        boolean[] $jacocoInit = $jacocoInit();
        setupDownloadEvents(download, downloadAction, appId, trustedValue, editorsChoicePosition, status);
        $jacocoInit[332] = true;
        if (!Action.MIGRATE.equals(downloadAction)) {
            $jacocoInit[333] = true;
        } else {
            $jacocoInit[334] = true;
            setupMigratorUninstallEvent(download.getPackageName());
            $jacocoInit[335] = true;
        }
        $jacocoInit[336] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Download m6425a(Download download, OfferResponseStatus __) {
        $jacocoInit()[331] = true;
        return download;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10168a(Action downloadAction, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        if (downloadAction != Action.MIGRATE) {
            $jacocoInit[324] = true;
        } else {
            $jacocoInit[325] = true;
            this.appcMigrationManager.addMigrationCandidate(download.getPackageName());
            $jacocoInit[326] = true;
        }
        $jacocoInit[327] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo10160a(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[323] = true;
        return install;
    }

    public C0117M downloadApp(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadFactory downloadFactory2 = this.downloadFactory;
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[103] = true;
        DownloadModel downloadModel = walletApp.getDownloadModel();
        $jacocoInit[104] = true;
        Action action = downloadModel.getAction();
        $jacocoInit[105] = true;
        int parseDownloadAction = downloadStateParser2.parseDownloadAction(action);
        $jacocoInit[106] = true;
        String appName = walletApp.getAppName();
        String packageName = walletApp.getPackageName();
        $jacocoInit[107] = true;
        String md5sum = walletApp.getMd5sum();
        String icon = walletApp.getIcon();
        String versionName = walletApp.getVersionName();
        $jacocoInit[108] = true;
        int versionCode = walletApp.getVersionCode();
        String path = walletApp.getPath();
        String pathAlt = walletApp.getPathAlt();
        Obb obb = walletApp.getObb();
        $jacocoInit[109] = true;
        long size = walletApp.getSize();
        $jacocoInit[110] = true;
        C0120S c = C0120S.m652c(downloadFactory2.create(parseDownloadAction, appName, packageName, md5sum, icon, versionName, versionCode, path, pathAlt, obb, false, size));
        C2278z zVar = new C2278z(this, walletApp);
        $jacocoInit[111] = true;
        C0120S i = c.mo3668i(zVar);
        C1701G g = new C1701G(this);
        $jacocoInit[112] = true;
        C0120S g2 = i.mo3663g((C0132p<? super T, ? extends C0117M>) g);
        $jacocoInit[113] = true;
        C0117M l = g2.mo3673l();
        $jacocoInit[114] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo10165a(WalletApp walletApp, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        C1704J j = new C1704J(this, download, walletApp);
        $jacocoInit[315] = true;
        Single b = adsVisibilityStatus.mo3695b((C0129b<? super T>) j);
        C1696C c = new C1696C(download);
        $jacocoInit[316] = true;
        Single d = b.mo3698d(c);
        $jacocoInit[317] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10172a(Download download, WalletApp walletApp, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[319] = true;
        DownloadModel downloadModel = walletApp.getDownloadModel();
        $jacocoInit[320] = true;
        Action action = downloadModel.getAction();
        long id = walletApp.getId();
        $jacocoInit[321] = true;
        setupDownloadEvents(download, action, id, offerResponseStatus);
        $jacocoInit[322] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Download m6430b(Download download, OfferResponseStatus __) {
        $jacocoInit()[318] = true;
        return download;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo10180b(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[314] = true;
        return install;
    }

    private void setupDownloadEvents(Download download, Action downloadAction, long appId, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        setupDownloadEvents(download, downloadAction, appId, null, null, offerResponseStatus);
        $jacocoInit[115] = true;
    }

    private void setupDownloadEvents(Download download, Action downloadAction, long appId, String malwareRank, String editorsChoice, OfferResponseStatus offerResponseStatus) {
        boolean z;
        Action action = downloadAction;
        long j = appId;
        boolean[] $jacocoInit = $jacocoInit();
        int campaignId = this.notificationAnalytics.getCampaignId(download.getPackageName(), j);
        $jacocoInit[116] = true;
        String abTestGroup = this.notificationAnalytics.getAbTestingGroup(download.getPackageName(), j);
        $jacocoInit[117] = true;
        this.appViewAnalytics.setupDownloadEvents(download, campaignId, abTestGroup, downloadAction, AnalyticsManager.Action.CLICK, malwareRank, editorsChoice, offerResponseStatus);
        $jacocoInit[118] = true;
        InstallAnalytics installAnalytics2 = this.installAnalytics;
        String packageName = download.getPackageName();
        int versionCode = download.getVersionCode();
        AnalyticsManager.Action action2 = AnalyticsManager.Action.INSTALL;
        AppContext appContext = AppContext.APPVIEW;
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[119] = true;
        Origin origin = downloadStateParser2.getOrigin(download.getAction());
        if (action == null) {
            $jacocoInit[120] = true;
        } else {
            Action action3 = Action.MIGRATE;
            $jacocoInit[121] = true;
            if (!action.equals(action3)) {
                $jacocoInit[122] = true;
            } else {
                $jacocoInit[123] = true;
                z = true;
                $jacocoInit[125] = true;
                boolean hasAppc = download.hasAppc();
                $jacocoInit[126] = true;
                installAnalytics2.installStarted(packageName, versionCode, action2, appContext, origin, campaignId, abTestGroup, z, hasAppc);
                $jacocoInit[127] = true;
            }
        }
        $jacocoInit[124] = true;
        z = false;
        $jacocoInit[125] = true;
        boolean hasAppc2 = download.hasAppc();
        $jacocoInit[126] = true;
        installAnalytics2.installStarted(packageName, versionCode, action2, appContext, origin, campaignId, abTestGroup, z, hasAppc2);
        $jacocoInit[127] = true;
    }

    public void setupMigratorUninstallEvent(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installAnalytics.uninstallStarted(packageName, AnalyticsManager.Action.INSTALL, AppContext.APPVIEW);
        $jacocoInit[128] = true;
    }

    public C0120S<DownloadModel> loadDownloadModel(String md5, String packageName, int versionCode, boolean paidApp, Pay pay, String signature, long storeId, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = md5;
        C0120S install = this.installManager.getInstall(md5, packageName, versionCode);
        AppcMigrationManager appcMigrationManager2 = this.appcMigrationManager;
        $jacocoInit[129] = true;
        C0120S isMigrationApp = appcMigrationManager2.isMigrationApp(packageName, signature, versionCode, storeId, hasAppc);
        C1735i iVar = new C1735i(this, paidApp, pay);
        $jacocoInit[130] = true;
        C0120S<DownloadModel> a = C0120S.m641a(install, isMigrationApp, (C14541q<? super T1, ? super T2, ? extends R>) iVar);
        $jacocoInit[131] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ DownloadModel mo10154a(boolean paidApp, Pay pay, Install install, Boolean isMigration) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[304] = true;
        InstallationType type = install.getType();
        if (pay == null) {
            $jacocoInit[305] = true;
        } else {
            $jacocoInit[306] = true;
            if (!pay.isPaid()) {
                $jacocoInit[307] = true;
            } else {
                $jacocoInit[308] = true;
                z = true;
                boolean booleanValue = isMigration.booleanValue();
                $jacocoInit[310] = true;
                Action parseDownloadType = downloadStateParser2.parseDownloadType(type, paidApp, z, booleanValue);
                $jacocoInit[311] = true;
                int progress = install.getProgress();
                DownloadStateParser downloadStateParser3 = this.downloadStateParser;
                $jacocoInit[312] = true;
                DownloadModel downloadModel = new DownloadModel(parseDownloadType, progress, downloadStateParser3.parseDownloadState(install.getState()), pay);
                $jacocoInit[313] = true;
                return downloadModel;
            }
        }
        z = false;
        $jacocoInit[309] = true;
        boolean booleanValue2 = isMigration.booleanValue();
        $jacocoInit[310] = true;
        Action parseDownloadType2 = downloadStateParser2.parseDownloadType(type, paidApp, z, booleanValue2);
        $jacocoInit[311] = true;
        int progress2 = install.getProgress();
        DownloadStateParser downloadStateParser32 = this.downloadStateParser;
        $jacocoInit[312] = true;
        DownloadModel downloadModel2 = new DownloadModel(parseDownloadType2, progress2, downloadStateParser32.parseDownloadState(install.getState()), pay);
        $jacocoInit[313] = true;
        return downloadModel2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10185b(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.stopInstallation(md5);
        $jacocoInit[303] = true;
    }

    public C0117M pauseDownload(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1695B(this, md5));
        $jacocoInit[132] = true;
        return c;
    }

    public C0117M resumeDownload(String md5, long appId, Action action) {
        boolean[] $jacocoInit = $jacocoInit();
        Single download = this.installManager.getDownload(md5);
        C1732g gVar = new C1732g(this, action, appId);
        $jacocoInit[133] = true;
        Single a = download.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) gVar);
        C1730f fVar = C1730f.f4700a;
        $jacocoInit[134] = true;
        Single a2 = a.mo3687a((C0129b<Throwable>) fVar);
        C1699E e = new C1699E(this);
        $jacocoInit[135] = true;
        C0117M b = a2.mo3693b((C0132p<? super T, ? extends C0117M>) e);
        $jacocoInit[136] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo10163a(Action action, long appId, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        C1739m mVar = new C1739m(this, download, action, appId);
        $jacocoInit[298] = true;
        Single b = adsVisibilityStatus.mo3695b((C0129b<? super T>) mVar);
        C1705K k = new C1705K(download);
        $jacocoInit[299] = true;
        Single d = b.mo3698d(k);
        $jacocoInit[300] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10170a(Download download, Action action, long appId, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        setupDownloadEvents(download, action, appId, offerResponseStatus);
        $jacocoInit[302] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Download m6432c(Download download, OfferResponseStatus __) {
        $jacocoInit()[301] = true;
        return download;
    }

    /* renamed from: a */
    static /* synthetic */ void m6429a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[297] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo10186c(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[296] = true;
        return install;
    }

    public C0117M cancelDownload(String md5, String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1743p(this, md5, packageName, versionCode));
        $jacocoInit[137] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10175a(String md5, String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.removeInstallationFile(md5, packageName, versionCode);
        $jacocoInit[295] = true;
    }

    public SearchAdResult getSearchAdResult() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAdResult searchAdResult2 = this.searchAdResult;
        $jacocoInit[138] = true;
        return searchAdResult2;
    }

    public void setSearchAdResult(SearchAdResult searchAdResult2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchAdResult = searchAdResult2;
        $jacocoInit[139] = true;
    }

    public void handleAdsLogic(SearchAdResult searchAdResult2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adsManager.handleAdsLogic(searchAdResult2);
        $jacocoInit[140] = true;
    }

    private boolean isAppcApp() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsViewModel appCoinsViewModel = this.cachedAppCoinsViewModel;
        if (appCoinsViewModel == null) {
            $jacocoInit[141] = true;
        } else {
            AppCoinsAdvertisingModel advertisingModel = appCoinsViewModel.getAdvertisingModel();
            $jacocoInit[142] = true;
            if (advertisingModel.getHasAdvertising()) {
                $jacocoInit[143] = true;
            } else if (!this.cachedAppCoinsViewModel.hasBilling()) {
                $jacocoInit[144] = true;
            } else {
                $jacocoInit[145] = true;
            }
            $jacocoInit[146] = true;
            z = true;
            $jacocoInit[148] = true;
            return z;
        }
        z = false;
        $jacocoInit[147] = true;
        $jacocoInit[148] = true;
        return z;
    }

    public C0117M appBought(String path) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1718Y(this, path));
        $jacocoInit[149] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10174a(String path) {
        boolean[] $jacocoInit = $jacocoInit();
        Pay pay = this.cachedApp.getPay();
        $jacocoInit[292] = true;
        pay.setPaid();
        $jacocoInit[293] = true;
        this.cachedApp.setPath(path);
        $jacocoInit[294] = true;
    }

    public void sendAppViewOpenedFromEvent(String packageName, String publisher, String badge, boolean hasBilling, boolean hasAdvertising) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.isFirstLoad) {
            $jacocoInit[150] = true;
        } else {
            $jacocoInit[151] = true;
            this.appViewAnalytics.sendAppViewOpenedFromEvent(packageName, publisher, badge, hasBilling, hasAdvertising);
            this.isFirstLoad = false;
            $jacocoInit[152] = true;
        }
        $jacocoInit[153] = true;
    }

    public void sendEditorsChoiceClickEvent(String packageName, String editorsBrickPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.isFirstLoad) {
            $jacocoInit[154] = true;
        } else {
            $jacocoInit[155] = true;
            this.appViewAnalytics.sendEditorsChoiceClickEvent(packageName, editorsBrickPosition);
            this.isFirstLoad = false;
            $jacocoInit[156] = true;
        }
        $jacocoInit[157] = true;
    }

    public String getMarketName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.marketName;
        $jacocoInit[158] = true;
        return str;
    }

    public C0117M loadAppCoinsInformation() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.cachedAppCoinsViewModel == null) {
            $jacocoInit[159] = true;
            C0120S a = C0120S.m633a((Callable<? extends T>) new C2275w<Object>(this));
            C1726d dVar = new C1726d(this);
            $jacocoInit[160] = true;
            C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) dVar);
            $jacocoInit[161] = true;
            C0117M b = C0117M.m592b(g);
            $jacocoInit[162] = true;
            return b;
        }
        C0117M b2 = C0117M.m590b();
        $jacocoInit[163] = true;
        return b2;
    }

    /* renamed from: a */
    public /* synthetic */ DetailedApp mo10159a() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedApp detailedApp = this.cachedApp;
        $jacocoInit[291] = true;
        return detailedApp;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo10161a(DetailedApp app) {
        boolean[] $jacocoInit = $jacocoInit();
        if (app.hasAdvertising()) {
            $jacocoInit[282] = true;
            Single advertising = this.appCoinsManager.getAdvertising(app.getPackageName(), app.getVersionCode());
            C1744q qVar = new C1744q(this, app);
            $jacocoInit[283] = true;
            Single d = advertising.mo3698d(qVar);
            $jacocoInit[284] = true;
            C0117M b = d.mo3692b();
            $jacocoInit[285] = true;
            return b;
        }
        $jacocoInit[286] = true;
        this.cachedAppCoinsViewModel = new AppCoinsViewModel(false, app.hasBilling(), new AppCoinsAdvertisingModel());
        $jacocoInit[287] = true;
        C0117M b2 = C0117M.m590b();
        $jacocoInit[288] = true;
        return b2;
    }

    /* renamed from: a */
    public /* synthetic */ AppCoinsViewModel mo10158a(DetailedApp app, AppCoinsAdvertisingModel advertisingModel) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[289] = true;
        AppCoinsViewModel appCoinsViewModel = new AppCoinsViewModel(false, app.hasBilling(), advertisingModel);
        this.cachedAppCoinsViewModel = appCoinsViewModel;
        $jacocoInit[290] = true;
        return appCoinsViewModel;
    }

    public Single<List<Donation>> getTopDonations(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<List<Donation>> donationsList = this.appCoinsManager.getDonationsList(packageName);
        $jacocoInit[164] = true;
        return donationsList;
    }

    public Single<Boolean> shouldLoadInterstitialAd() {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldHaveInterstitialAds = this.moPubAdsManager.shouldHaveInterstitialAds();
        C1713T t = new C1713T(this);
        $jacocoInit[165] = true;
        Single a = shouldHaveInterstitialAds.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) t);
        C1719Z z = new C1719Z(this);
        $jacocoInit[166] = true;
        Single<Boolean> a2 = a.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) z);
        $jacocoInit[167] = true;
        return a2;
    }

    /* renamed from: c */
    public /* synthetic */ Single mo10189c(Boolean hasAds) {
        boolean[] $jacocoInit = $jacocoInit();
        if (hasAds.booleanValue()) {
            $jacocoInit[274] = true;
            Single shouldShowAds = this.moPubAdsManager.shouldShowAds();
            C1749v vVar = new C1749v(this);
            $jacocoInit[275] = true;
            Single b = shouldShowAds.mo3695b((C0129b<? super T>) vVar);
            $jacocoInit[276] = true;
            return b;
        }
        Single a = Single.m734a(Boolean.valueOf(false));
        $jacocoInit[277] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10173a(Boolean showAds) {
        boolean[] $jacocoInit = $jacocoInit();
        if (showAds.booleanValue()) {
            $jacocoInit[278] = true;
        } else {
            $jacocoInit[279] = true;
            sendAdsBlockByOfferEvent();
            $jacocoInit[280] = true;
        }
        $jacocoInit[281] = true;
    }

    /* renamed from: d */
    public /* synthetic */ Single mo10193d(Boolean shouldLoadAd) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!shouldLoadAd.booleanValue()) {
            $jacocoInit[263] = true;
        } else {
            AppCoinsViewModel appCoinsViewModel = this.cachedAppCoinsViewModel;
            $jacocoInit[264] = true;
            if (appCoinsViewModel.hasBilling()) {
                $jacocoInit[265] = true;
            } else {
                AppCoinsViewModel appCoinsViewModel2 = this.cachedAppCoinsViewModel;
                $jacocoInit[266] = true;
                AppCoinsAdvertisingModel advertisingModel = appCoinsViewModel2.getAdvertisingModel();
                $jacocoInit[267] = true;
                if (advertisingModel.getHasAdvertising()) {
                    $jacocoInit[268] = true;
                } else {
                    DetailedApp detailedApp = this.cachedApp;
                    $jacocoInit[269] = true;
                    if (detailedApp.isMature()) {
                        $jacocoInit[270] = true;
                    } else {
                        $jacocoInit[271] = true;
                        z = true;
                        Single a = Single.m734a(Boolean.valueOf(z));
                        $jacocoInit[273] = true;
                        return a;
                    }
                }
            }
        }
        z = false;
        $jacocoInit[272] = true;
        Single a2 = Single.m734a(Boolean.valueOf(z));
        $jacocoInit[273] = true;
        return a2;
    }

    private void sendAdsBlockByOfferEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendAdsBlockByOfferEvent();
        $jacocoInit[168] = true;
    }

    public Single<Boolean> shouldLoadBannerAd() {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadBannerAd = this.moPubAdsManager.shouldLoadBannerAd();
        C1707M m = new C1707M(this);
        $jacocoInit[169] = true;
        Single<Boolean> a = shouldLoadBannerAd.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) m);
        $jacocoInit[170] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo10183b(Boolean shouldLoadAd) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!shouldLoadAd.booleanValue()) {
            $jacocoInit[252] = true;
        } else {
            AppCoinsViewModel appCoinsViewModel = this.cachedAppCoinsViewModel;
            $jacocoInit[253] = true;
            if (appCoinsViewModel.hasBilling()) {
                $jacocoInit[254] = true;
            } else {
                AppCoinsViewModel appCoinsViewModel2 = this.cachedAppCoinsViewModel;
                $jacocoInit[255] = true;
                AppCoinsAdvertisingModel advertisingModel = appCoinsViewModel2.getAdvertisingModel();
                $jacocoInit[256] = true;
                if (advertisingModel.getHasAdvertising()) {
                    $jacocoInit[257] = true;
                } else {
                    DetailedApp detailedApp = this.cachedApp;
                    $jacocoInit[258] = true;
                    if (detailedApp.isMature()) {
                        $jacocoInit[259] = true;
                    } else {
                        $jacocoInit[260] = true;
                        z = true;
                        Single a = Single.m734a(Boolean.valueOf(z));
                        $jacocoInit[262] = true;
                        return a;
                    }
                }
            }
        }
        z = false;
        $jacocoInit[261] = true;
        Single a2 = Single.m734a(Boolean.valueOf(z));
        $jacocoInit[262] = true;
        return a2;
    }

    public Single<Boolean> shouldLoadNativeAds() {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadNativeAds = this.moPubAdsManager.shouldLoadNativeAds();
        C1709O o = new C1709O(this);
        $jacocoInit[171] = true;
        Single<Boolean> a = shouldLoadNativeAds.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) o);
        $jacocoInit[172] = true;
        return a;
    }

    /* renamed from: e */
    public /* synthetic */ Single mo10197e(Boolean shouldLoadAd) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!shouldLoadAd.booleanValue()) {
            $jacocoInit[241] = true;
        } else {
            AppCoinsViewModel appCoinsViewModel = this.cachedAppCoinsViewModel;
            $jacocoInit[242] = true;
            if (appCoinsViewModel.hasBilling()) {
                $jacocoInit[243] = true;
            } else {
                AppCoinsViewModel appCoinsViewModel2 = this.cachedAppCoinsViewModel;
                $jacocoInit[244] = true;
                AppCoinsAdvertisingModel advertisingModel = appCoinsViewModel2.getAdvertisingModel();
                $jacocoInit[245] = true;
                if (advertisingModel.getHasAdvertising()) {
                    $jacocoInit[246] = true;
                } else {
                    DetailedApp detailedApp = this.cachedApp;
                    $jacocoInit[247] = true;
                    if (detailedApp.isMature()) {
                        $jacocoInit[248] = true;
                    } else {
                        $jacocoInit[249] = true;
                        z = true;
                        Single a = Single.m734a(Boolean.valueOf(z));
                        $jacocoInit[251] = true;
                        return a;
                    }
                }
            }
        }
        z = false;
        $jacocoInit[250] = true;
        Single a2 = Single.m734a(Boolean.valueOf(z));
        $jacocoInit[251] = true;
        return a2;
    }

    public C0120S<DownloadModel> appViewAppDownloadModel() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = loadAppViewViewModel().mo3696c();
        C1693A a = new C1693A(this);
        $jacocoInit[173] = true;
        C0120S<DownloadModel> f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) a);
        $jacocoInit[174] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10162a(AppViewViewModel app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String md5 = app.getMd5();
        String packageName = app.getPackageName();
        int versionCode = app.getVersionCode();
        $jacocoInit[234] = true;
        boolean isPaid = app.isPaid();
        Pay pay = app.getPay();
        String signature = app.getSignature();
        Store store = app.getStore();
        $jacocoInit[235] = true;
        long id = store.getId();
        if (app.hasAdvertising()) {
            $jacocoInit[236] = true;
        } else if (app.hasBilling()) {
            $jacocoInit[237] = true;
        } else {
            $jacocoInit[239] = true;
            z = false;
            C0120S loadDownloadModel = loadDownloadModel(md5, packageName, versionCode, isPaid, pay, signature, id, z);
            $jacocoInit[240] = true;
            return loadDownloadModel;
        }
        $jacocoInit[238] = true;
        z = true;
        C0120S loadDownloadModel2 = loadDownloadModel(md5, packageName, versionCode, isPaid, pay, signature, id, z);
        $jacocoInit[240] = true;
        return loadDownloadModel2;
    }

    public C0120S<PromotionViewModel> loadPromotionViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        Observable<PromotionViewModel> promoViewModelObs = C0120S.m652c(new PromotionViewModel());
        if (this.cachedPromotionViewModel != null) {
            $jacocoInit[175] = true;
            Observable<DownloadModel> downloadModel = appViewAppDownloadModel();
            AppcMigrationManager appcMigrationManager2 = this.appcMigrationManager;
            DetailedApp detailedApp = this.cachedApp;
            $jacocoInit[176] = true;
            Observable<Boolean> isAppMigrated = appcMigrationManager2.isAppMigrated(detailedApp.getPackageName());
            $jacocoInit[177] = true;
            Observable<PromotionViewModel> cachedViewModel = C0120S.m652c(this.cachedPromotionViewModel);
            $jacocoInit[178] = true;
            C0120S<PromotionViewModel> a = C0120S.m640a((C0120S<? extends T1>) cachedViewModel, (C0120S<? extends T2>) downloadModel, (C0120S<? extends T3>) isAppMigrated, (C14542r<? super T1, ? super T2, ? super T3, ? extends R>) new C1745r<Object,Object,Object,Object>(this));
            $jacocoInit[179] = true;
            return a;
        }
        C0120S promotionsForPackage = this.promotionsManager.getPromotionsForPackage(this.cachedApp.getPackageName());
        C1706L l = C1706L.f4665a;
        $jacocoInit[180] = true;
        C0120S d = promotionsForPackage.mo3653d((C0132p<? super T, Boolean>) l);
        C1736j jVar = new C1736j(this);
        $jacocoInit[181] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jVar);
        C1700F f2 = new C1700F(this);
        $jacocoInit[182] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) f2);
        $jacocoInit[183] = true;
        C0120S<PromotionViewModel> f3 = b.mo3659f((C0120S<? extends T>) promoViewModelObs);
        $jacocoInit[184] = true;
        return f3;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6428a(List promotions) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!promotions.isEmpty()) {
            $jacocoInit[231] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[232] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[233] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo10181b(List promotionList) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(promotionList);
        $jacocoInit[224] = true;
        C0120S walletApp = this.promotionsManager.getWalletApp();
        $jacocoInit[225] = true;
        C0120S appViewAppDownloadModel = appViewAppDownloadModel();
        $jacocoInit[226] = true;
        C0120S c2 = C0120S.m652c(this.cachedApp);
        AppcMigrationManager appcMigrationManager2 = this.appcMigrationManager;
        DetailedApp detailedApp = this.cachedApp;
        $jacocoInit[227] = true;
        C0120S isAppMigrated = appcMigrationManager2.isAppMigrated(detailedApp.getPackageName());
        $jacocoInit[228] = true;
        C0120S a = C0120S.m639a(c, walletApp, appViewAppDownloadModel, c2, isAppMigrated, new C1728e(this));
        $jacocoInit[229] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ PromotionViewModel mo10155a(List proms, WalletApp wallet, DownloadModel appDLM, DetailedApp appVM, Boolean migrate) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewModel mergeToPromotionViewModel = mergeToPromotionViewModel(wallet, proms, appDLM, appVM, migrate);
        $jacocoInit[230] = true;
        return mergeToPromotionViewModel;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10169a(PromotionViewModel promotionViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.cachedPromotionViewModel = promotionViewModel;
        $jacocoInit[223] = true;
    }

    public boolean hasClaimablePromotion(ClaimAction action) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewModel promotionViewModel = this.cachedPromotionViewModel;
        if (promotionViewModel == null) {
            $jacocoInit[185] = true;
        } else {
            $jacocoInit[186] = true;
            if (getClaimablePromotion(promotionViewModel.getPromotions(), action) == null) {
                $jacocoInit[187] = true;
            } else {
                $jacocoInit[188] = true;
                z = true;
                $jacocoInit[190] = true;
                return z;
            }
        }
        z = false;
        $jacocoInit[189] = true;
        $jacocoInit[190] = true;
        return z;
    }

    public Promotion getClaimablePromotion(List<Promotion> promotions, ClaimAction claimAction) {
        boolean[] $jacocoInit = $jacocoInit();
        Promotion claimablePromotion = this.promotionsManager.getClaimablePromotion(promotions, claimAction);
        $jacocoInit[191] = true;
        return claimablePromotion;
    }

    /* access modifiers changed from: private */
    public PromotionViewModel mergeToCachedPromotionViewModel(PromotionViewModel cached, DownloadModel appDownloadModel, Boolean isMigrated) {
        boolean[] $jacocoInit = $jacocoInit();
        cached.setAppMigrated(isMigrated.booleanValue());
        $jacocoInit[192] = true;
        cached.setAppDownloadModel(appDownloadModel);
        $jacocoInit[193] = true;
        return cached;
    }

    private PromotionViewModel mergeToPromotionViewModel(WalletApp walletApp, List<Promotion> promotions, DownloadModel appDownloadModel, DetailedApp app, Boolean isAppMigrated) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewModel promotionViewModel = new PromotionViewModel(walletApp, promotions, appDownloadModel, app, isAppMigrated.booleanValue());
        $jacocoInit[194] = true;
        return promotionViewModel;
    }

    public SimilarAppsViewModel getCachedAppcSimilarAppsViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        SimilarAppsViewModel similarAppsViewModel = this.cachedAppcSimilarAppsViewModel;
        $jacocoInit[195] = true;
        return similarAppsViewModel;
    }

    public C0120S<DownloadAppViewModel> downloadStarted() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = loadAppViewViewModel().mo3696c();
        C2277y yVar = C2277y.f5352a;
        $jacocoInit[196] = true;
        C0120S d = c.mo3653d((C0132p<? super T, Boolean>) yVar);
        C1734h hVar = new C1734h(this);
        $jacocoInit[197] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) hVar);
        C1721aa aaVar = C1721aa.f4691a;
        $jacocoInit[198] = true;
        C0120S<DownloadAppViewModel> d2 = f.mo3653d((C0132p<? super T, Boolean>) aaVar);
        $jacocoInit[199] = true;
        return d2;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m6431b(AppViewViewModel app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!app.isLoading()) {
            $jacocoInit[220] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[221] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[222] = true;
        return valueOf;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo10187c(AppViewViewModel app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String md5 = app.getMd5();
        String packageName = app.getPackageName();
        $jacocoInit[213] = true;
        int versionCode = app.getVersionCode();
        boolean isPaid = app.isPaid();
        Pay pay = app.getPay();
        String signature = app.getSignature();
        Store store = app.getStore();
        $jacocoInit[214] = true;
        long id = store.getId();
        if (app.hasAdvertising()) {
            $jacocoInit[215] = true;
        } else if (app.hasBilling()) {
            $jacocoInit[216] = true;
        } else {
            $jacocoInit[218] = true;
            z = false;
            C0120S loadDownloadAppViewModel = loadDownloadAppViewModel(md5, packageName, versionCode, isPaid, pay, signature, id, z);
            $jacocoInit[219] = true;
            return loadDownloadAppViewModel;
        }
        $jacocoInit[217] = true;
        z = true;
        C0120S loadDownloadAppViewModel2 = loadDownloadAppViewModel(md5, packageName, versionCode, isPaid, pay, signature, id, z);
        $jacocoInit[219] = true;
        return loadDownloadAppViewModel2;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6426a(DownloadAppViewModel download) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = download.getDownloadModel();
        $jacocoInit[210] = true;
        boolean isDownloading = downloadModel.isDownloading();
        $jacocoInit[211] = true;
        Boolean valueOf = Boolean.valueOf(isDownloading);
        $jacocoInit[212] = true;
        return valueOf;
    }

    public boolean isAppcPromotionImpressionSent() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.appcPromotionImpressionSent;
        $jacocoInit[200] = true;
        return z;
    }

    public void setAppcPromotionImpressionSent() {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcPromotionImpressionSent = true;
        $jacocoInit[201] = true;
    }

    public boolean isMigrationImpressionSent() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.migrationImpressionSent;
        $jacocoInit[202] = true;
        return z;
    }

    public void setMigrationImpressionSent() {
        boolean[] $jacocoInit = $jacocoInit();
        this.migrationImpressionSent = true;
        $jacocoInit[203] = true;
    }

    public void scheduleNotification(String appcValue, String image, String packageName, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        LocalNotificationSyncManager localNotificationSyncManager2 = this.localNotificationSyncManager;
        AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider2 = this.appcPromotionNotificationStringProvider;
        $jacocoInit[204] = true;
        String format = String.format(appcPromotionNotificationStringProvider2.getNotificationTitle(), new Object[]{appcValue});
        AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider3 = this.appcPromotionNotificationStringProvider;
        $jacocoInit[205] = true;
        String notificationBody = appcPromotionNotificationStringProvider3.getNotificationBody();
        StringBuilder sb = new StringBuilder();
        sb.append("aptoideinstall://package=");
        sb.append(packageName);
        sb.append("&store=");
        sb.append(storeName);
        sb.append("&show_install_popup=false");
        String sb2 = sb.toString();
        $jacocoInit[206] = true;
        localNotificationSyncManager2.schedule(format, notificationBody, image, sb2, LocalNotificationSync.APPC_CAMPAIGN_NOTIFICATION);
        $jacocoInit[207] = true;
    }

    public void unscheduleNotificationSync() {
        boolean[] $jacocoInit = $jacocoInit();
        this.localNotificationSyncManager.unschedule(LocalNotificationSync.APPC_CAMPAIGN_NOTIFICATION);
        $jacocoInit[208] = true;
    }

    public Single<Boolean> shouldShowConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> shouldShowConsentDialog = this.moPubAdsManager.shouldShowConsentDialog();
        $jacocoInit[209] = true;
        return shouldShowConsentDialog;
    }
}
