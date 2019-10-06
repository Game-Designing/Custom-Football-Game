package p005cm.aptoide.p006pt;

import com.crashlytics.android.C0075a;
import java.util.List;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AdultContent;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.AdsUserPropertyManager;
import p005cm.aptoide.p006pt.analytics.FirstLaunchAnalytics;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.dataprovider.cache.L2Cache;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.file.CacheHelper;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p005cm.aptoide.p006pt.install.installer.RootInstallationRetryHandler;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.preferences.Preferences;
import p005cm.aptoide.p006pt.preferences.SecurePreferences;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionManager;
import p005cm.aptoide.p006pt.search.suggestions.TrendingManager;
import p005cm.aptoide.p006pt.sync.SyncScheduler;
import p005cm.aptoide.p006pt.sync.alarm.SyncStorage;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.AptoideApplication_MembersInjector */
public final class AptoideApplication_MembersInjector implements C13183b<AptoideApplication> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> accountManagerProvider;

    /* renamed from: accountSettingsBodyInterceptorPoolV7AndBodyInterceptorPoolV7Provider */
    private final Provider<BodyInterceptor<BaseBody>> f4256xc59f298a;
    private final Provider<AdsRepository> adsRepositoryProvider;
    private final Provider<AdsUserPropertyManager> adsUserPropertyManagerProvider;
    private final Provider<AdultContentAnalytics> adultContentAnalyticsProvider;
    private final Provider<AdultContent> adultContentProvider;
    private final Provider<SyncScheduler> alarmSyncSchedulerProvider;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<AdsApplicationVersionCodeProvider> applicationVersionCodeProvider;
    private final Provider<AptoideDownloadManager> aptoideDownloadManagerProvider;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorWebV7Provider;
    private final Provider<CacheHelper> cacheHelperProvider;
    private final Provider<C0075a> crashlyticsProvider;
    private final Provider<Database> databaseProvider;
    private final Provider<OkHttpClient> defaultClientProvider;
    private final Provider<List<String>> defaultFollowedStoresProvider;
    private final Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider;
    private final Provider<L2Cache> httpClientCacheProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final Provider<InvalidRefreshTokenLogoutManager> invalidRefreshTokenLogoutManagerProvider;
    private final Provider<NavigationTracker> navigationTrackerProvider;
    private final Provider<NotificationAnalytics> notificationAnalyticsProvider;
    private final Provider<PackageRepository> packageRepositoryProvider;
    private final Provider<Preferences> preferencesProvider;
    private final Provider<QManager> qManagerProvider;
    private final Provider<RootAvailabilityManager> rootAvailabilityManagerProvider;
    private final Provider<RootInstallationRetryHandler> rootInstallationRetryHandlerProvider;
    private final Provider<SearchSuggestionManager> searchSuggestionManagerProvider;
    private final Provider<SecurePreferences> securePreferencesProvider;
    private final Provider<SettingsManager> settingsManagerProvider;
    private final Provider<AptoideShortcutManager> shortcutManagerProvider;
    private final Provider<SyncStorage> syncStorageProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;
    private final Provider<TrendingManager> trendingManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6895489358727959369L, "cm/aptoide/pt/AptoideApplication_MembersInjector", 82);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((AptoideApplication) obj);
        $jacocoInit[81] = true;
    }

    public AptoideApplication_MembersInjector(Provider<Database> databaseProvider2, Provider<AptoideDownloadManager> aptoideDownloadManagerProvider2, Provider<CacheHelper> cacheHelperProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<Preferences> preferencesProvider2, Provider<SecurePreferences> securePreferencesProvider2, Provider<AdultContent> adultContentProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<OkHttpClient> defaultClientProvider2, Provider<RootAvailabilityManager> rootAvailabilityManagerProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<C0075a> crashlyticsProvider2, Provider<SyncScheduler> alarmSyncSchedulerProvider2, Provider<BodyInterceptor<BaseBody>> accountSettingsBodyInterceptorPoolV7AndBodyInterceptorPoolV7Provider, Provider<BodyInterceptor<BaseBody>> bodyInterceptorWebV7Provider2, Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider2, Provider<L2Cache> httpClientCacheProvider2, Provider<QManager> qManagerProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<PackageRepository> packageRepositoryProvider2, Provider<AdsApplicationVersionCodeProvider> applicationVersionCodeProvider2, Provider<AdsRepository> adsRepositoryProvider2, Provider<SyncStorage> syncStorageProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<TrendingManager> trendingManagerProvider2, Provider<AdultContentAnalytics> adultContentAnalyticsProvider2, Provider<NotificationAnalytics> notificationAnalyticsProvider2, Provider<SearchSuggestionManager> searchSuggestionManagerProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider2, Provider<InvalidRefreshTokenLogoutManager> invalidRefreshTokenLogoutManagerProvider2, Provider<RootInstallationRetryHandler> rootInstallationRetryHandlerProvider2, Provider<AptoideShortcutManager> shortcutManagerProvider2, Provider<SettingsManager> settingsManagerProvider2, Provider<InstallManager> installManagerProvider2, Provider<List<String>> defaultFollowedStoresProvider2, Provider<AdsUserPropertyManager> adsUserPropertyManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.databaseProvider = databaseProvider2;
        this.aptoideDownloadManagerProvider = aptoideDownloadManagerProvider2;
        this.cacheHelperProvider = cacheHelperProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.preferencesProvider = preferencesProvider2;
        this.securePreferencesProvider = securePreferencesProvider2;
        this.adultContentProvider = adultContentProvider2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.defaultClientProvider = defaultClientProvider2;
        this.rootAvailabilityManagerProvider = rootAvailabilityManagerProvider2;
        this.authenticationPersistenceProvider = authenticationPersistenceProvider2;
        this.crashlyticsProvider = crashlyticsProvider2;
        this.alarmSyncSchedulerProvider = alarmSyncSchedulerProvider2;
        this.f4256xc59f298a = accountSettingsBodyInterceptorPoolV7AndBodyInterceptorPoolV7Provider;
        this.bodyInterceptorWebV7Provider = bodyInterceptorWebV7Provider2;
        this.bodyInterceptorV3Provider = bodyInterceptorV3Provider2;
        this.httpClientCacheProvider = httpClientCacheProvider2;
        this.qManagerProvider = qManagerProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.packageRepositoryProvider = packageRepositoryProvider2;
        this.applicationVersionCodeProvider = applicationVersionCodeProvider2;
        this.adsRepositoryProvider = adsRepositoryProvider2;
        this.syncStorageProvider = syncStorageProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        this.trendingManagerProvider = trendingManagerProvider2;
        this.adultContentAnalyticsProvider = adultContentAnalyticsProvider2;
        this.notificationAnalyticsProvider = notificationAnalyticsProvider2;
        this.searchSuggestionManagerProvider = searchSuggestionManagerProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.firstLaunchAnalyticsProvider = firstLaunchAnalyticsProvider2;
        this.invalidRefreshTokenLogoutManagerProvider = invalidRefreshTokenLogoutManagerProvider2;
        this.rootInstallationRetryHandlerProvider = rootInstallationRetryHandlerProvider2;
        this.shortcutManagerProvider = shortcutManagerProvider2;
        this.settingsManagerProvider = settingsManagerProvider2;
        this.installManagerProvider = installManagerProvider2;
        this.defaultFollowedStoresProvider = defaultFollowedStoresProvider2;
        this.adsUserPropertyManagerProvider = adsUserPropertyManagerProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<AptoideApplication> create(Provider<Database> databaseProvider2, Provider<AptoideDownloadManager> aptoideDownloadManagerProvider2, Provider<CacheHelper> cacheHelperProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<Preferences> preferencesProvider2, Provider<SecurePreferences> securePreferencesProvider2, Provider<AdultContent> adultContentProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<OkHttpClient> defaultClientProvider2, Provider<RootAvailabilityManager> rootAvailabilityManagerProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<C0075a> crashlyticsProvider2, Provider<SyncScheduler> alarmSyncSchedulerProvider2, Provider<BodyInterceptor<BaseBody>> accountSettingsBodyInterceptorPoolV7AndBodyInterceptorPoolV7Provider, Provider<BodyInterceptor<BaseBody>> bodyInterceptorWebV7Provider2, Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider2, Provider<L2Cache> httpClientCacheProvider2, Provider<QManager> qManagerProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<PackageRepository> packageRepositoryProvider2, Provider<AdsApplicationVersionCodeProvider> applicationVersionCodeProvider2, Provider<AdsRepository> adsRepositoryProvider2, Provider<SyncStorage> syncStorageProvider2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<TrendingManager> trendingManagerProvider2, Provider<AdultContentAnalytics> adultContentAnalyticsProvider2, Provider<NotificationAnalytics> notificationAnalyticsProvider2, Provider<SearchSuggestionManager> searchSuggestionManagerProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider2, Provider<InvalidRefreshTokenLogoutManager> invalidRefreshTokenLogoutManagerProvider2, Provider<RootInstallationRetryHandler> rootInstallationRetryHandlerProvider2, Provider<AptoideShortcutManager> shortcutManagerProvider2, Provider<SettingsManager> settingsManagerProvider2, Provider<InstallManager> installManagerProvider2, Provider<List<String>> defaultFollowedStoresProvider2, Provider<AdsUserPropertyManager> adsUserPropertyManagerProvider2) {
        Provider<Database> provider = databaseProvider2;
        Provider<AptoideDownloadManager> provider2 = aptoideDownloadManagerProvider2;
        Provider<CacheHelper> provider3 = cacheHelperProvider2;
        Provider<AptoideAccountManager> provider4 = accountManagerProvider2;
        Provider<Preferences> provider5 = preferencesProvider2;
        Provider<SecurePreferences> provider6 = securePreferencesProvider2;
        Provider<AdultContent> provider7 = adultContentProvider2;
        Provider<IdsRepository> provider8 = idsRepositoryProvider2;
        Provider<OkHttpClient> provider9 = defaultClientProvider2;
        Provider<RootAvailabilityManager> provider10 = rootAvailabilityManagerProvider2;
        Provider<AuthenticationPersistence> provider11 = authenticationPersistenceProvider2;
        Provider<C0075a> provider12 = crashlyticsProvider2;
        Provider<SyncScheduler> provider13 = alarmSyncSchedulerProvider2;
        Provider<BodyInterceptor<BaseBody>> provider14 = accountSettingsBodyInterceptorPoolV7AndBodyInterceptorPoolV7Provider;
        Provider<BodyInterceptor<BaseBody>> provider15 = bodyInterceptorWebV7Provider2;
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider16 = bodyInterceptorV3Provider2;
        Provider<L2Cache> provider17 = httpClientCacheProvider2;
        Provider<QManager> provider18 = qManagerProvider2;
        Provider<TokenInvalidator> provider19 = tokenInvalidatorProvider2;
        Provider<PackageRepository> provider20 = packageRepositoryProvider2;
        Provider<AdsApplicationVersionCodeProvider> provider21 = applicationVersionCodeProvider2;
        Provider<AdsRepository> provider22 = adsRepositoryProvider2;
        Provider<SyncStorage> provider23 = syncStorageProvider2;
        Provider<NavigationTracker> provider24 = navigationTrackerProvider2;
        Provider<TrendingManager> provider25 = trendingManagerProvider2;
        Provider<AdultContentAnalytics> provider26 = adultContentAnalyticsProvider2;
        Provider<NotificationAnalytics> provider27 = notificationAnalyticsProvider2;
        Provider<SearchSuggestionManager> provider28 = searchSuggestionManagerProvider2;
        Provider<AnalyticsManager> provider29 = analyticsManagerProvider2;
        Provider<FirstLaunchAnalytics> provider30 = firstLaunchAnalyticsProvider2;
        Provider<InvalidRefreshTokenLogoutManager> provider31 = invalidRefreshTokenLogoutManagerProvider2;
        Provider<RootInstallationRetryHandler> provider32 = rootInstallationRetryHandlerProvider2;
        Provider<AptoideShortcutManager> provider33 = shortcutManagerProvider2;
        Provider<SettingsManager> provider34 = settingsManagerProvider2;
        Provider<InstallManager> provider35 = installManagerProvider2;
        Provider<List<String>> provider36 = defaultFollowedStoresProvider2;
        Provider<AdsUserPropertyManager> provider37 = adsUserPropertyManagerProvider2;
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication_MembersInjector aptoideApplication_MembersInjector = new AptoideApplication_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37);
        $jacocoInit[1] = true;
        return aptoideApplication_MembersInjector;
    }

    public void injectMembers(AptoideApplication instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectDatabase(instance, (Database) this.databaseProvider.get());
        $jacocoInit[2] = true;
        injectAptoideDownloadManager(instance, (AptoideDownloadManager) this.aptoideDownloadManagerProvider.get());
        $jacocoInit[3] = true;
        injectCacheHelper(instance, (CacheHelper) this.cacheHelperProvider.get());
        $jacocoInit[4] = true;
        injectAccountManager(instance, (AptoideAccountManager) this.accountManagerProvider.get());
        $jacocoInit[5] = true;
        injectPreferences(instance, (Preferences) this.preferencesProvider.get());
        $jacocoInit[6] = true;
        injectSecurePreferences(instance, (SecurePreferences) this.securePreferencesProvider.get());
        $jacocoInit[7] = true;
        injectAdultContent(instance, (AdultContent) this.adultContentProvider.get());
        $jacocoInit[8] = true;
        injectIdsRepository(instance, (IdsRepository) this.idsRepositoryProvider.get());
        $jacocoInit[9] = true;
        injectDefaultClient(instance, (OkHttpClient) this.defaultClientProvider.get());
        $jacocoInit[10] = true;
        injectRootAvailabilityManager(instance, (RootAvailabilityManager) this.rootAvailabilityManagerProvider.get());
        $jacocoInit[11] = true;
        injectAuthenticationPersistence(instance, (AuthenticationPersistence) this.authenticationPersistenceProvider.get());
        $jacocoInit[12] = true;
        injectCrashlytics(instance, (C0075a) this.crashlyticsProvider.get());
        $jacocoInit[13] = true;
        injectAlarmSyncScheduler(instance, (SyncScheduler) this.alarmSyncSchedulerProvider.get());
        Provider<BodyInterceptor<BaseBody>> provider = this.f4256xc59f298a;
        $jacocoInit[14] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider.get();
        $jacocoInit[15] = true;
        injectBodyInterceptorPoolV7(instance, bodyInterceptor);
        $jacocoInit[16] = true;
        injectBodyInterceptorWebV7(instance, (BodyInterceptor) this.bodyInterceptorWebV7Provider.get());
        $jacocoInit[17] = true;
        injectBodyInterceptorV3(instance, (BodyInterceptor) this.bodyInterceptorV3Provider.get());
        $jacocoInit[18] = true;
        injectHttpClientCache(instance, (L2Cache) this.httpClientCacheProvider.get());
        $jacocoInit[19] = true;
        injectQManager(instance, (QManager) this.qManagerProvider.get());
        $jacocoInit[20] = true;
        injectTokenInvalidator(instance, (TokenInvalidator) this.tokenInvalidatorProvider.get());
        $jacocoInit[21] = true;
        injectPackageRepository(instance, (PackageRepository) this.packageRepositoryProvider.get());
        $jacocoInit[22] = true;
        injectApplicationVersionCodeProvider(instance, (AdsApplicationVersionCodeProvider) this.applicationVersionCodeProvider.get());
        $jacocoInit[23] = true;
        injectAdsRepository(instance, (AdsRepository) this.adsRepositoryProvider.get());
        $jacocoInit[24] = true;
        injectSyncStorage(instance, (SyncStorage) this.syncStorageProvider.get());
        $jacocoInit[25] = true;
        injectNavigationTracker(instance, (NavigationTracker) this.navigationTrackerProvider.get());
        Provider<BodyInterceptor<BaseBody>> provider2 = this.f4256xc59f298a;
        $jacocoInit[26] = true;
        BodyInterceptor bodyInterceptor2 = (BodyInterceptor) provider2.get();
        $jacocoInit[27] = true;
        injectAccountSettingsBodyInterceptorPoolV7(instance, bodyInterceptor2);
        $jacocoInit[28] = true;
        injectTrendingManager(instance, (TrendingManager) this.trendingManagerProvider.get());
        $jacocoInit[29] = true;
        injectAdultContentAnalytics(instance, (AdultContentAnalytics) this.adultContentAnalyticsProvider.get());
        $jacocoInit[30] = true;
        injectNotificationAnalytics(instance, (NotificationAnalytics) this.notificationAnalyticsProvider.get());
        $jacocoInit[31] = true;
        injectSearchSuggestionManager(instance, (SearchSuggestionManager) this.searchSuggestionManagerProvider.get());
        $jacocoInit[32] = true;
        injectAnalyticsManager(instance, (AnalyticsManager) this.analyticsManagerProvider.get());
        $jacocoInit[33] = true;
        injectFirstLaunchAnalytics(instance, (FirstLaunchAnalytics) this.firstLaunchAnalyticsProvider.get());
        Provider<InvalidRefreshTokenLogoutManager> provider3 = this.invalidRefreshTokenLogoutManagerProvider;
        $jacocoInit[34] = true;
        InvalidRefreshTokenLogoutManager invalidRefreshTokenLogoutManager = (InvalidRefreshTokenLogoutManager) provider3.get();
        $jacocoInit[35] = true;
        injectInvalidRefreshTokenLogoutManager(instance, invalidRefreshTokenLogoutManager);
        $jacocoInit[36] = true;
        injectRootInstallationRetryHandler(instance, (RootInstallationRetryHandler) this.rootInstallationRetryHandlerProvider.get());
        $jacocoInit[37] = true;
        injectShortcutManager(instance, (AptoideShortcutManager) this.shortcutManagerProvider.get());
        $jacocoInit[38] = true;
        injectSettingsManager(instance, (SettingsManager) this.settingsManagerProvider.get());
        $jacocoInit[39] = true;
        injectInstallManager(instance, (InstallManager) this.installManagerProvider.get());
        $jacocoInit[40] = true;
        injectDefaultFollowedStores(instance, (List) this.defaultFollowedStoresProvider.get());
        $jacocoInit[41] = true;
        injectAdsUserPropertyManager(instance, (AdsUserPropertyManager) this.adsUserPropertyManagerProvider.get());
        $jacocoInit[42] = true;
    }

    public static void injectDatabase(AptoideApplication instance, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.database = database;
        $jacocoInit[43] = true;
    }

    public static void injectAptoideDownloadManager(AptoideApplication instance, AptoideDownloadManager aptoideDownloadManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.aptoideDownloadManager = aptoideDownloadManager;
        $jacocoInit[44] = true;
    }

    public static void injectCacheHelper(AptoideApplication instance, CacheHelper cacheHelper) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.cacheHelper = cacheHelper;
        $jacocoInit[45] = true;
    }

    public static void injectAccountManager(AptoideApplication instance, AptoideAccountManager accountManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.accountManager = accountManager;
        $jacocoInit[46] = true;
    }

    public static void injectPreferences(AptoideApplication instance, Preferences preferences) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.preferences = preferences;
        $jacocoInit[47] = true;
    }

    public static void injectSecurePreferences(AptoideApplication instance, SecurePreferences securePreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.securePreferences = securePreferences;
        $jacocoInit[48] = true;
    }

    public static void injectAdultContent(AptoideApplication instance, AdultContent adultContent) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.adultContent = adultContent;
        $jacocoInit[49] = true;
    }

    public static void injectIdsRepository(AptoideApplication instance, IdsRepository idsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.idsRepository = idsRepository;
        $jacocoInit[50] = true;
    }

    public static void injectDefaultClient(AptoideApplication instance, OkHttpClient defaultClient) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.defaultClient = defaultClient;
        $jacocoInit[51] = true;
    }

    public static void injectRootAvailabilityManager(AptoideApplication instance, RootAvailabilityManager rootAvailabilityManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.rootAvailabilityManager = rootAvailabilityManager;
        $jacocoInit[52] = true;
    }

    public static void injectAuthenticationPersistence(AptoideApplication instance, AuthenticationPersistence authenticationPersistence) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.authenticationPersistence = authenticationPersistence;
        $jacocoInit[53] = true;
    }

    public static void injectCrashlytics(AptoideApplication instance, C0075a crashlytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.crashlytics = crashlytics;
        $jacocoInit[54] = true;
    }

    public static void injectAlarmSyncScheduler(AptoideApplication instance, SyncScheduler alarmSyncScheduler) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.alarmSyncScheduler = alarmSyncScheduler;
        $jacocoInit[55] = true;
    }

    public static void injectBodyInterceptorPoolV7(AptoideApplication instance, BodyInterceptor<BaseBody> bodyInterceptorPoolV7) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.bodyInterceptorPoolV7 = bodyInterceptorPoolV7;
        $jacocoInit[56] = true;
    }

    public static void injectBodyInterceptorWebV7(AptoideApplication instance, BodyInterceptor<BaseBody> bodyInterceptorWebV7) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.bodyInterceptorWebV7 = bodyInterceptorWebV7;
        $jacocoInit[57] = true;
    }

    public static void injectBodyInterceptorV3(AptoideApplication instance, BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptorV3) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.bodyInterceptorV3 = bodyInterceptorV3;
        $jacocoInit[58] = true;
    }

    public static void injectHttpClientCache(AptoideApplication instance, L2Cache httpClientCache) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.httpClientCache = httpClientCache;
        $jacocoInit[59] = true;
    }

    public static void injectQManager(AptoideApplication instance, QManager qManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.qManager = qManager;
        $jacocoInit[60] = true;
    }

    public static void injectTokenInvalidator(AptoideApplication instance, TokenInvalidator tokenInvalidator) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.tokenInvalidator = tokenInvalidator;
        $jacocoInit[61] = true;
    }

    public static void injectPackageRepository(AptoideApplication instance, PackageRepository packageRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.packageRepository = packageRepository;
        $jacocoInit[62] = true;
    }

    public static void injectApplicationVersionCodeProvider(AptoideApplication instance, AdsApplicationVersionCodeProvider applicationVersionCodeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.applicationVersionCodeProvider = applicationVersionCodeProvider2;
        $jacocoInit[63] = true;
    }

    public static void injectAdsRepository(AptoideApplication instance, AdsRepository adsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.adsRepository = adsRepository;
        $jacocoInit[64] = true;
    }

    public static void injectSyncStorage(AptoideApplication instance, SyncStorage syncStorage) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.syncStorage = syncStorage;
        $jacocoInit[65] = true;
    }

    public static void injectNavigationTracker(AptoideApplication instance, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.navigationTracker = navigationTracker;
        $jacocoInit[66] = true;
    }

    public static void injectAccountSettingsBodyInterceptorPoolV7(AptoideApplication instance, BodyInterceptor<BaseBody> accountSettingsBodyInterceptorPoolV7) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.accountSettingsBodyInterceptorPoolV7 = accountSettingsBodyInterceptorPoolV7;
        $jacocoInit[67] = true;
    }

    public static void injectTrendingManager(AptoideApplication instance, TrendingManager trendingManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.trendingManager = trendingManager;
        $jacocoInit[68] = true;
    }

    public static void injectAdultContentAnalytics(AptoideApplication instance, AdultContentAnalytics adultContentAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.adultContentAnalytics = adultContentAnalytics;
        $jacocoInit[69] = true;
    }

    public static void injectNotificationAnalytics(AptoideApplication instance, NotificationAnalytics notificationAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.notificationAnalytics = notificationAnalytics;
        $jacocoInit[70] = true;
    }

    public static void injectSearchSuggestionManager(AptoideApplication instance, SearchSuggestionManager searchSuggestionManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.searchSuggestionManager = searchSuggestionManager;
        $jacocoInit[71] = true;
    }

    public static void injectAnalyticsManager(AptoideApplication instance, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.analyticsManager = analyticsManager;
        $jacocoInit[72] = true;
    }

    public static void injectFirstLaunchAnalytics(AptoideApplication instance, FirstLaunchAnalytics firstLaunchAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.firstLaunchAnalytics = firstLaunchAnalytics;
        $jacocoInit[73] = true;
    }

    public static void injectInvalidRefreshTokenLogoutManager(AptoideApplication instance, InvalidRefreshTokenLogoutManager invalidRefreshTokenLogoutManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.invalidRefreshTokenLogoutManager = invalidRefreshTokenLogoutManager;
        $jacocoInit[74] = true;
    }

    public static void injectRootInstallationRetryHandler(AptoideApplication instance, RootInstallationRetryHandler rootInstallationRetryHandler) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.rootInstallationRetryHandler = rootInstallationRetryHandler;
        $jacocoInit[75] = true;
    }

    public static void injectShortcutManager(AptoideApplication instance, AptoideShortcutManager shortcutManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.shortcutManager = shortcutManager;
        $jacocoInit[76] = true;
    }

    public static void injectSettingsManager(AptoideApplication instance, SettingsManager settingsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.settingsManager = settingsManager;
        $jacocoInit[77] = true;
    }

    public static void injectInstallManager(AptoideApplication instance, InstallManager installManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.installManager = installManager;
        $jacocoInit[78] = true;
    }

    public static void injectDefaultFollowedStores(AptoideApplication instance, List<String> defaultFollowedStores) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.defaultFollowedStores = defaultFollowedStores;
        $jacocoInit[79] = true;
    }

    public static void injectAdsUserPropertyManager(AptoideApplication instance, AdsUserPropertyManager adsUserPropertyManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.adsUserPropertyManager = adsUserPropertyManager;
        $jacocoInit[80] = true;
    }
}
