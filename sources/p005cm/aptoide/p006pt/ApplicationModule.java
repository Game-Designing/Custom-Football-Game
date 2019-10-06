package p005cm.aptoide.p006pt;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.support.p000v4.app.C0448aa.C0449a;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.crashlytics.android.C0075a;
import com.crashlytics.android.C0075a.C0076a;
import com.crashlytics.android.p124a.C6378b;
import com.crashlytics.android.p126c.C6472aa;
import com.crashlytics.android.p126c.C6472aa.C6473a;
import com.facebook.C6666i;
import com.facebook.C6787r;
import com.facebook.internal.C6722l;
import com.facebook.login.C6745C;
import com.facebook.p127a.C6638q;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.liulishuo.filedownloader.services.C10917d.C10918a;
import com.mopub.common.Constants;
import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountFactory;
import p005cm.aptoide.accountmanager.AccountService;
import p005cm.aptoide.accountmanager.AdultContent;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.EventLogger;
import p005cm.aptoide.analytics.SessionLogger;
import p005cm.aptoide.analytics.implementation.AptoideBiAnalytics;
import p005cm.aptoide.analytics.implementation.AptoideBiEventService;
import p005cm.aptoide.analytics.implementation.EventsPersistence;
import p005cm.aptoide.analytics.implementation.PageViewsAnalytics;
import p005cm.aptoide.analytics.implementation.loggers.AptoideBiEventLogger;
import p005cm.aptoide.analytics.implementation.loggers.FabricEventLogger;
import p005cm.aptoide.analytics.implementation.loggers.FacebookEventLogger;
import p005cm.aptoide.analytics.implementation.loggers.FlurryEventLogger;
import p005cm.aptoide.analytics.implementation.loggers.HttpKnockEventLogger;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.network.RetrofitAptoideBiService;
import p005cm.aptoide.analytics.implementation.network.RetrofitAptoideBiService.ServiceV7;
import p005cm.aptoide.analytics.implementation.persistence.SharedPreferencesSessionPersistence;
import p005cm.aptoide.analytics.implementation.utils.AnalyticsEventParametersNormalizer;
import p005cm.aptoide.p006pt.abtesting.ABTestCenterRepository;
import p005cm.aptoide.p006pt.abtesting.ABTestManager;
import p005cm.aptoide.p006pt.abtesting.ABTestService;
import p005cm.aptoide.p006pt.abtesting.AbTestCacheValidator;
import p005cm.aptoide.p006pt.abtesting.ExperimentModel;
import p005cm.aptoide.p006pt.abtesting.RealmExperimentMapper;
import p005cm.aptoide.p006pt.abtesting.RealmExperimentPersistence;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubBannerAdExperiment;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubInterstitialAdExperiment;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubNativeAdExperiment;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.AccountServiceV3;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p005cm.aptoide.p006pt.account.AndroidAccountDataMigration;
import p005cm.aptoide.p006pt.account.AndroidAccountManagerPersistence;
import p005cm.aptoide.p006pt.account.AndroidAccountProvider;
import p005cm.aptoide.p006pt.account.DatabaseStoreDataPersist;
import p005cm.aptoide.p006pt.account.DatabaseStoreDataPersist.DatabaseStoreMapper;
import p005cm.aptoide.p006pt.account.FacebookSignUpAdapter;
import p005cm.aptoide.p006pt.account.GoogleSignUpAdapter;
import p005cm.aptoide.p006pt.account.LoginPreferences;
import p005cm.aptoide.p006pt.account.MatureBodyInterceptorV7;
import p005cm.aptoide.p006pt.account.MatureContentPersistence;
import p005cm.aptoide.p006pt.account.OAuthModeProvider;
import p005cm.aptoide.p006pt.account.view.store.StoreManager;
import p005cm.aptoide.p006pt.account.view.user.NewsletterManager;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.AdsUserPropertyManager;
import p005cm.aptoide.p006pt.ads.MinimalAdMapper;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.ads.MoPubAnalytics;
import p005cm.aptoide.p006pt.ads.MoPubConsentManager;
import p005cm.aptoide.p006pt.ads.PackageRepositoryVersionCodeProvider;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferCardManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferService;
import p005cm.aptoide.p006pt.analytics.FirstLaunchAnalytics;
import p005cm.aptoide.p006pt.analytics.TrackerFilter;
import p005cm.aptoide.p006pt.analytics.analytics.AnalyticsBodyInterceptorV7;
import p005cm.aptoide.p006pt.analytics.analytics.RealmEventMapper;
import p005cm.aptoide.p006pt.analytics.analytics.RealmEventPersistence;
import p005cm.aptoide.p006pt.app.AdsManager;
import p005cm.aptoide.p006pt.app.AppCoinsManager;
import p005cm.aptoide.p006pt.app.AppCoinsService;
import p005cm.aptoide.p006pt.app.AppViewAnalytics;
import p005cm.aptoide.p006pt.app.CampaignAnalytics;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.app.ReviewsManager;
import p005cm.aptoide.p006pt.app.ReviewsRepository;
import p005cm.aptoide.p006pt.app.ReviewsService;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationManager;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationService;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.app.view.donations.DonationsService;
import p005cm.aptoide.p006pt.app.view.donations.DonationsService.ServiceV8;
import p005cm.aptoide.p006pt.app.view.donations.WalletService;
import p005cm.aptoide.p006pt.appview.PreferencesPersister;
import p005cm.aptoide.p006pt.autoupdate.Service;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.blacklist.BlacklistPersistence;
import p005cm.aptoide.p006pt.blacklist.BlacklistUnitMapper;
import p005cm.aptoide.p006pt.blacklist.Blacklister;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationAnalytics;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.crashreports.CrashlyticsCrashLogger;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.AppcMigrationAccessor;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.accessors.InstallationAccessor;
import p005cm.aptoide.p006pt.database.accessors.InstalledAccessor;
import p005cm.aptoide.p006pt.database.accessors.NotificationAccessor;
import p005cm.aptoide.p006pt.database.accessors.RealmToRealmDatabaseMigration;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.accessors.StoredMinimalAdAccessor;
import p005cm.aptoide.p006pt.database.accessors.UpdateAccessor;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.NetworkOperatorManager;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.ads.AdNetworkUtils;
import p005cm.aptoide.p006pt.dataprovider.cache.L2Cache;
import p005cm.aptoide.p006pt.dataprovider.cache.POSTCacheKeyAlgorithm;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.WSWidgetsUtils;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.RequestBodyFactory;
import p005cm.aptoide.p006pt.deprecated.SQLiteDatabaseHelper;
import p005cm.aptoide.p006pt.download.AppValidationAnalytics;
import p005cm.aptoide.p006pt.download.AppValidator;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadApkPathsProvider;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.download.DownloadInstallationProvider;
import p005cm.aptoide.p006pt.download.DownloadMirrorEventInterceptor;
import p005cm.aptoide.p006pt.download.FileDownloadManagerProvider;
import p005cm.aptoide.p006pt.download.Md5Comparator;
import p005cm.aptoide.p006pt.download.OemidProvider;
import p005cm.aptoide.p006pt.download.PaidAppsDownloadInterceptor;
import p005cm.aptoide.p006pt.downloadmanager.AppDownloaderProvider;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.downloadmanager.DownloadAppFileMapper;
import p005cm.aptoide.p006pt.downloadmanager.DownloadAppMapper;
import p005cm.aptoide.p006pt.downloadmanager.DownloadStatusMapper;
import p005cm.aptoide.p006pt.downloadmanager.DownloadsRepository;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloaderProvider;
import p005cm.aptoide.p006pt.downloadmanager.RetryFileDownloadManagerProvider;
import p005cm.aptoide.p006pt.downloadmanager.RetryFileDownloaderProvider;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p005cm.aptoide.p006pt.editorial.EditorialAnalytics;
import p005cm.aptoide.p006pt.editorial.EditorialService;
import p005cm.aptoide.p006pt.editorialList.EditorialListAnalytics;
import p005cm.aptoide.p006pt.file.CacheHelper;
import p005cm.aptoide.p006pt.file.CacheHelper.FolderToManage;
import p005cm.aptoide.p006pt.home.AdMapper;
import p005cm.aptoide.p006pt.home.BannerRepository;
import p005cm.aptoide.p006pt.home.BundleDataSource;
import p005cm.aptoide.p006pt.home.BundlesRepository;
import p005cm.aptoide.p006pt.home.BundlesResponseMapper;
import p005cm.aptoide.p006pt.home.ChipManager;
import p005cm.aptoide.p006pt.home.HomeAnalytics;
import p005cm.aptoide.p006pt.home.RemoteBundleDataSource;
import p005cm.aptoide.p006pt.home.apps.UpdatesManager;
import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallEvents;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.install.Installer;
import p005cm.aptoide.p006pt.install.InstallerAnalytics;
import p005cm.aptoide.p006pt.install.InstallerFactory;
import p005cm.aptoide.p006pt.install.PackageInstallerManager;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p005cm.aptoide.p006pt.install.RootInstallNotificationEventReceiver;
import p005cm.aptoide.p006pt.install.installer.DefaultInstaller;
import p005cm.aptoide.p006pt.install.installer.InstallationProvider;
import p005cm.aptoide.p006pt.install.installer.RootInstallErrorNotificationFactory;
import p005cm.aptoide.p006pt.install.installer.RootInstallationRetryHandler;
import p005cm.aptoide.p006pt.link.AptoideInstallParser;
import p005cm.aptoide.p006pt.logger.AnalyticsLogcatLogger;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.BodyInterceptorV3;
import p005cm.aptoide.p006pt.networking.BodyInterceptorV7;
import p005cm.aptoide.p006pt.networking.Cdn;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.networking.MultipartBodyInterceptor;
import p005cm.aptoide.p006pt.networking.NoAuthenticationBodyInterceptorV3;
import p005cm.aptoide.p006pt.networking.NoOpTokenInvalidator;
import p005cm.aptoide.p006pt.networking.RefreshTokenInvalidator;
import p005cm.aptoide.p006pt.networking.UserAgentInterceptor;
import p005cm.aptoide.p006pt.networking.UserAgentInterceptorV8;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.notification.PullingContentService;
import p005cm.aptoide.p006pt.notification.RealmLocalNotificationSyncMapper;
import p005cm.aptoide.p006pt.notification.RealmLocalNotificationSyncPersistence;
import p005cm.aptoide.p006pt.notification.SystemNotificationShower;
import p005cm.aptoide.p006pt.notification.sync.LocalNotificationSyncManager;
import p005cm.aptoide.p006pt.packageinstaller.AppInstaller;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus;
import p005cm.aptoide.p006pt.preferences.Preferences;
import p005cm.aptoide.p006pt.preferences.SecurePreferences;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.preferences.secure.SecureCoderDecoder;
import p005cm.aptoide.p006pt.preferences.secure.SecurePreferencesImplementation;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p005cm.aptoide.p006pt.promotions.CaptchaService;
import p005cm.aptoide.p006pt.promotions.CaptchaService.ServiceInterface;
import p005cm.aptoide.p006pt.promotions.PromotionViewAppMapper;
import p005cm.aptoide.p006pt.promotions.PromotionsAnalytics;
import p005cm.aptoide.p006pt.promotions.PromotionsManager;
import p005cm.aptoide.p006pt.promotions.PromotionsPreferencesManager;
import p005cm.aptoide.p006pt.promotions.PromotionsService;
import p005cm.aptoide.p006pt.reactions.ReactionsManager;
import p005cm.aptoide.p006pt.reactions.network.ReactionsRemoteService;
import p005cm.aptoide.p006pt.reactions.network.ReactionsService;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.repository.request.RewardAppCoinsAppsRepository;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p005cm.aptoide.p006pt.root.RootValueSaver;
import p005cm.aptoide.p006pt.search.SearchHostProvider;
import p005cm.aptoide.p006pt.search.SearchManager;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionManager;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionRemoteRepository;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionService;
import p005cm.aptoide.p006pt.search.suggestions.TrendingManager;
import p005cm.aptoide.p006pt.search.suggestions.TrendingService;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.sync.SyncScheduler;
import p005cm.aptoide.p006pt.sync.alarm.AlarmSyncScheduler;
import p005cm.aptoide.p006pt.sync.alarm.AlarmSyncService;
import p005cm.aptoide.p006pt.sync.alarm.SyncStorage;
import p005cm.aptoide.p006pt.updates.UpdateRepository;
import p005cm.aptoide.p006pt.updates.UpdatesAnalytics;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.utils.AptoideUtils.Core;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.FileUtils;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p005cm.aptoide.p006pt.view.app.AppCenter;
import p005cm.aptoide.p006pt.view.app.AppCenterRepository;
import p005cm.aptoide.p006pt.view.app.AppService;
import p005cm.aptoide.p006pt.view.settings.SupportEmailProvider;
import p005cm.aptoide.p006pt.wallet.WalletAppProvider;
import p019d.p022i.p023b.C0099b;
import p019d.p022i.p023b.C0100e;
import p019d.p307j.p308a.C13149w;
import p019d.p307j.p308a.p313e.C13113c.C13114a;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.realm.C13990F;
import p024io.realm.C14001L;
import p024io.realm.C14001L.C14002a;
import p024io.realm.C14020X;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p028h.C14963c;
import p026rx.p029i.C0136c;
import p026rx.schedulers.Schedulers;
import p072c.p073a.p074a.C1313a.C1314a;
import retrofit2.CallAdapter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/* renamed from: cm.aptoide.pt.ApplicationModule */
public class ApplicationModule {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String DONATIONS_URL = "https://api.blockchainds.com/";
    private final AptoideApplication application;
    private final String aptoideMd5sum;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6732123711504502889L, "cm/aptoide/pt/ApplicationModule", 436);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule(AptoideApplication application2, String aptoideMd5sum2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.application = application2;
        this.aptoideMd5sum = aptoideMd5sum2;
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public InstallManager providesInstallManager(AptoideDownloadManager aptoideDownloadManager, InstallerAnalytics installerAnalytics, RootAvailabilityManager rootAvailabilityManager, @Named("default") SharedPreferences defaultSharedPreferences, @Named("secureShared") SharedPreferences secureSharedPreferences, DownloadsRepository downloadsRepository, InstalledRepository installedRepository, @Named("cachePath") String cachePath, @Named("apkPath") String apkPath, @Named("obbPath") String obbPath, AppInstaller appInstaller, AppInstallerStatusReceiver appInstallerStatusReceiver, PackageInstallerManager packageInstallerManager) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication aptoideApplication = this.application;
        MinimalAdMapper minimalAdMapper = new MinimalAdMapper();
        $jacocoInit[1] = true;
        InstallerFactory installerFactory = new InstallerFactory(minimalAdMapper, installerAnalytics, appInstaller, getInstallingStateTimeout(), appInstallerStatusReceiver);
        InstallManager installManager = new InstallManager(aptoideApplication, aptoideDownloadManager, installerFactory.create(this.application), rootAvailabilityManager, defaultSharedPreferences, secureSharedPreferences, downloadsRepository, installedRepository, cachePath, apkPath, obbPath, new FileUtils(), packageInstallerManager);
        $jacocoInit[2] = true;
        return installManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public InstallerAnalytics providesInstallerAnalytics(AnalyticsManager analyticsManager, InstallAnalytics installAnalytics, @Named("default") SharedPreferences sharedPreferences, RootAvailabilityManager rootAvailabilityManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallEvents installEvents = new InstallEvents(analyticsManager, installAnalytics, sharedPreferences, rootAvailabilityManager, navigationTracker);
        $jacocoInit[3] = true;
        return installEvents;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DownloadAnalytics providesDownloadAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker, ConnectivityManager connectivityManager, TelephonyManager providesSystemService) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAnalytics downloadAnalytics = new DownloadAnalytics(connectivityManager, providesSystemService, navigationTracker, analyticsManager);
        $jacocoInit[4] = true;
        return downloadAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public UpdatesAnalytics providesUpdatesAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        UpdatesAnalytics updatesAnalytics = new UpdatesAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[5] = true;
        return updatesAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public CampaignAnalytics providesCampaignAnalytics(AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        CampaignAnalytics campaignAnalytics = new CampaignAnalytics(new HashMap(), analyticsManager);
        $jacocoInit[6] = true;
        return campaignAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public TelephonyManager providesTelephonyManager() {
        TelephonyManager telephonyManager = (TelephonyManager) this.application.getSystemService("phone");
        $jacocoInit()[7] = true;
        return telephonyManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ConnectivityManager providesConnectivityManager() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.application.getSystemService("connectivity");
        $jacocoInit()[8] = true;
        return connectivityManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public InstallAnalytics provideInstallAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker, ConnectivityManager connectivityManager, TelephonyManager telephonyManager) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallAnalytics installAnalytics = new InstallAnalytics(CrashReport.getInstance(), analyticsManager, navigationTracker, new HashMap(), connectivityManager, telephonyManager);
        $jacocoInit[9] = true;
        return installAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideAptoidePackage() {
        $jacocoInit()[10] = true;
        return "cm.aptoide.pt";
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideApkPath(@Named("cachePath") String cachePath) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(cachePath);
        sb.append("apks/");
        String sb2 = sb.toString();
        $jacocoInit[11] = true;
        return sb2;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideObbPath(@Named("cachePath") String cachePath) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(cachePath);
        sb.append("obb/");
        String sb2 = sb.toString();
        $jacocoInit[12] = true;
        return sb2;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AptoideDownloadManager provideAptoideDownloadManager(DownloadsRepository downloadsRepository, DownloadStatusMapper downloadStatusMapper, @Named("cachePath") String cachePath, DownloadAppMapper downloadAppMapper, AppDownloaderProvider appDownloaderProvider, @Named("apkPath") String apkPath, @Named("obbPath") String obbPath, DownloadAnalytics downloadAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        FileUtils.createDir(apkPath);
        $jacocoInit[13] = true;
        FileUtils.createDir(obbPath);
        $jacocoInit[14] = true;
        AptoideDownloadManager aptoideDownloadManager = new AptoideDownloadManager(downloadsRepository, downloadStatusMapper, cachePath, downloadAppMapper, appDownloaderProvider, downloadAnalytics);
        $jacocoInit[15] = true;
        return aptoideDownloadManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DownloadAppFileMapper providesDownloadAppFileMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAppFileMapper downloadAppFileMapper = new DownloadAppFileMapper();
        $jacocoInit[16] = true;
        return downloadAppFileMapper;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DownloadAppMapper providesDownloadAppMapper(DownloadAppFileMapper downloadAppFileMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAppMapper downloadAppMapper = new DownloadAppMapper(downloadAppFileMapper);
        $jacocoInit[17] = true;
        return downloadAppMapper;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public FileDownloaderProvider providesFileDownloaderProvider(@Named("cachePath") String cachePath, @Named("user-agent") Interceptor userAgentInterceptor, AuthenticationPersistence authenticationPersistence, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, Md5Comparator md5Comparator) {
        boolean[] $jacocoInit = $jacocoInit();
        Builder builder = new Builder();
        $jacocoInit[18] = true;
        Builder addInterceptor = builder.addInterceptor(userAgentInterceptor);
        PaidAppsDownloadInterceptor paidAppsDownloadInterceptor = new PaidAppsDownloadInterceptor(authenticationPersistence);
        $jacocoInit[19] = true;
        Builder addInterceptor2 = addInterceptor.addInterceptor(paidAppsDownloadInterceptor);
        DownloadMirrorEventInterceptor downloadMirrorEventInterceptor = new DownloadMirrorEventInterceptor(downloadAnalytics, installAnalytics);
        $jacocoInit[20] = true;
        Builder addInterceptor3 = addInterceptor2.addInterceptor(downloadMirrorEventInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        $jacocoInit[21] = true;
        Builder connectTimeout = addInterceptor3.connectTimeout(20, timeUnit);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        $jacocoInit[22] = true;
        Builder writeTimeout = connectTimeout.writeTimeout(20, timeUnit2);
        TimeUnit timeUnit3 = TimeUnit.SECONDS;
        $jacocoInit[23] = true;
        Builder httpClientBuilder = writeTimeout.readTimeout(20, timeUnit3);
        $jacocoInit[24] = true;
        AptoideApplication aptoideApplication = this.application;
        C10918a aVar = new C10918a();
        C1314a aVar2 = new C1314a(httpClientBuilder);
        $jacocoInit[25] = true;
        aVar.mo35775a((C13114a) aVar2);
        $jacocoInit[26] = true;
        C13149w.m42915a((Context) aptoideApplication, aVar);
        $jacocoInit[27] = true;
        FileDownloadManagerProvider fileDownloadManagerProvider = new FileDownloadManagerProvider(cachePath, C13149w.m42916b(), md5Comparator);
        $jacocoInit[28] = true;
        return fileDownloadManagerProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Md5Comparator providesMd5Comparator(@Named("cachePath") String cachePath) {
        boolean[] $jacocoInit = $jacocoInit();
        Md5Comparator md5Comparator = new Md5Comparator(cachePath);
        $jacocoInit[29] = true;
        return md5Comparator;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppDownloaderProvider providesAppDownloaderProvider(RetryFileDownloaderProvider fileDownloaderProvider, DownloadAnalytics downloadAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        AppDownloaderProvider appDownloaderProvider = new AppDownloaderProvider(fileDownloaderProvider, downloadAnalytics);
        $jacocoInit[30] = true;
        return appDownloaderProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public RetryFileDownloaderProvider providesRetryFileDownloaderProvider(FileDownloaderProvider fileDownloaderProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        RetryFileDownloadManagerProvider retryFileDownloadManagerProvider = new RetryFileDownloadManagerProvider(fileDownloaderProvider);
        $jacocoInit[31] = true;
        return retryFileDownloadManagerProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DownloadsRepository provideDownloadsRepository(DownloadAccessor downloadAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadsRepository downloadsRepository = new DownloadsRepository(downloadAccessor);
        $jacocoInit[32] = true;
        return downloadsRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DownloadStatusMapper downloadStatusMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadStatusMapper downloadStatusMapper = new DownloadStatusMapper();
        $jacocoInit[33] = true;
        return downloadStatusMapper;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Installer provideDefaultInstaller(InstallationProvider installationProvider, @Named("default") SharedPreferences sharedPreferences, InstalledRepository installedRepository, RootAvailabilityManager rootAvailabilityManager, InstallerAnalytics installerAnalytics, AppInstaller appInstaller, AppInstallerStatusReceiver appInstallerStatusReceiver) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        PackageManager packageManager = this.application.getPackageManager();
        FileUtils fileUtils = new FileUtils();
        $jacocoInit[34] = true;
        if (ToolboxManager.isDebug(sharedPreferences)) {
            $jacocoInit[35] = true;
        } else if (BuildConfig.DEBUG) {
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[38] = true;
            z = false;
            $jacocoInit[39] = true;
            DefaultInstaller defaultInstaller = new DefaultInstaller(packageManager, installationProvider, appInstaller, fileUtils, z, installedRepository, BuildConfig.ROOT_TIMEOUT, rootAvailabilityManager, sharedPreferences, installerAnalytics, getInstallingStateTimeout(), appInstallerStatusReceiver);
            $jacocoInit[40] = true;
            return defaultInstaller;
        }
        $jacocoInit[37] = true;
        z = true;
        $jacocoInit[39] = true;
        DefaultInstaller defaultInstaller2 = new DefaultInstaller(packageManager, installationProvider, appInstaller, fileUtils, z, installedRepository, BuildConfig.ROOT_TIMEOUT, rootAvailabilityManager, sharedPreferences, installerAnalytics, getInstallingStateTimeout(), appInstallerStatusReceiver);
        $jacocoInit[40] = true;
        return defaultInstaller2;
    }

    private int getInstallingStateTimeout() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT >= 21) {
            i = BuildConfig.INSTALLING_STATE_INSTALLER_TIMEOUT_IN_MILLIS_21_PLUS;
            $jacocoInit[41] = true;
        } else {
            i = 60000;
            $jacocoInit[42] = true;
        }
        $jacocoInit[43] = true;
        return i;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public InstallationProvider provideInstallationProvider(AptoideDownloadManager downloadManager, DownloadAccessor downloadAccessor, InstalledRepository installedRepository, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        MinimalAdMapper minimalAdMapper = new MinimalAdMapper();
        $jacocoInit[44] = true;
        DownloadInstallationProvider downloadInstallationProvider = new DownloadInstallationProvider(downloadManager, downloadAccessor, installedRepository, minimalAdMapper, (StoredMinimalAdAccessor) AccessorFactory.getAccessorFor(database, StoredMinimalAd.class));
        $jacocoInit[45] = true;
        return downloadInstallationProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public CacheHelper provideCacheHelper(@Named("default") SharedPreferences defaultSharedPreferences, @Named("cachePath") String cachePath) {
        boolean[] $jacocoInit = $jacocoInit();
        List<FolderToManage> folders = new LinkedList<>();
        $jacocoInit[46] = true;
        folders.add(new FolderToManage(new File(cachePath), PullingContentService.UPDATES_INTERVAL));
        $jacocoInit[47] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(cachePath);
        sb.append("icons/");
        folders.add(new FolderToManage(new File(sb.toString()), PullingContentService.UPDATES_INTERVAL));
        $jacocoInit[48] = true;
        StringBuilder sb2 = new StringBuilder();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[49] = true;
        sb2.append(aptoideApplication.getCacheDir());
        sb2.append("image_manager_disk_cache/");
        FolderToManage folderToManage = new FolderToManage(new File(sb2.toString()), PullingContentService.UPDATES_INTERVAL);
        $jacocoInit[50] = true;
        folders.add(folderToManage);
        $jacocoInit[51] = true;
        CacheHelper cacheHelper = new CacheHelper(ManagerPreferences.getCacheLimit(defaultSharedPreferences), folders, new FileUtils());
        $jacocoInit[52] = true;
        return cacheHelper;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public C6638q provideAppEventsLogger() {
        boolean[] $jacocoInit = $jacocoInit();
        C6638q b = C6638q.m13220b((Context) this.application);
        $jacocoInit[53] = true;
        return b;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public C6378b provideAnswers(C13920f fabric) {
        C6378b bVar = (C6378b) C13920f.m44237a(C6378b.class);
        $jacocoInit()[54] = true;
        return bVar;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public C0075a provideCrashlytics(C13920f fabric) {
        C0075a aVar = (C0075a) C13920f.m44237a(C0075a.class);
        $jacocoInit()[55] = true;
        return aVar;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public C13920f provideFabric() {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication aptoideApplication = this.application;
        C0076a aVar = new C0076a();
        C6473a aVar2 = new C6473a();
        $jacocoInit[56] = true;
        aVar2.mo19523a(false);
        $jacocoInit[57] = true;
        C6472aa a = aVar2.mo19524a();
        $jacocoInit[58] = true;
        aVar.mo2537a(a);
        $jacocoInit[59] = true;
        C0102l[] lVarArr = {new C6378b(), aVar.mo2538a()};
        $jacocoInit[60] = true;
        C13920f a2 = C13920f.m44236a((Context) aptoideApplication, lVarArr);
        $jacocoInit[61] = true;
        return a2;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public InstalledRepository provideInstalledRepository(InstalledAccessor installedAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        InstalledRepository installedRepository = new InstalledRepository(installedAccessor);
        $jacocoInit[62] = true;
        return installedRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public OemidProvider providesOemidProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        OemidProvider oemidProvider = new OemidProvider();
        $jacocoInit[63] = true;
        return oemidProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DownloadApkPathsProvider downloadApkPathsProvider(OemidProvider oemidProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadApkPathsProvider downloadApkPathsProvider = new DownloadApkPathsProvider(oemidProvider);
        $jacocoInit[64] = true;
        return downloadApkPathsProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppValidationAnalytics providesAppValidationAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        AppValidationAnalytics appValidationAnalytics = new AppValidationAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[65] = true;
        return appValidationAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppValidator providesAppValidator(AppValidationAnalytics appValidationAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        AppValidator appValidator = new AppValidator(appValidationAnalytics);
        $jacocoInit[66] = true;
        return appValidator;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DownloadFactory provideDownloadFactory(@Named("marketName") String marketName, DownloadApkPathsProvider downloadApkPathsProvider, @Named("cachePath") String cachePath, AppValidator appValidator) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadFactory downloadFactory = new DownloadFactory(marketName, downloadApkPathsProvider, cachePath, appValidator);
        $jacocoInit[67] = true;
        return downloadFactory;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public InstalledAccessor provideInstalledAccessor(Database database, InstallationAccessor installationAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        InstalledAccessor installedAccessor = new InstalledAccessor(database, installationAccessor);
        $jacocoInit[68] = true;
        return installedAccessor;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public InstallationAccessor providesInstallationAccessor(Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallationAccessor installationAccessor = new InstallationAccessor(database);
        $jacocoInit[69] = true;
        return installationAccessor;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DownloadAccessor provideDownloadAccessor(Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAccessor downloadAccessor = new DownloadAccessor(database);
        $jacocoInit[70] = true;
        return downloadAccessor;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Interceptor provideUserAgentInterceptor(AndroidAccountProvider androidAccountProvider, IdsRepository idsRepository, @Named("partnerID") String partnerId) {
        boolean[] $jacocoInit = $jacocoInit();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        String str = SystemU.TERMINAL_INFO;
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[71] = true;
        UserAgentInterceptor userAgentInterceptor = new UserAgentInterceptor(idsRepository, partnerId, displayMetrics, str, Core.getDefaultVername(aptoideApplication));
        $jacocoInit[72] = true;
        return userAgentInterceptor;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Interceptor provideUserAgentInterceptorV8(IdsRepository idsRepository, @Named("aptoidePackage") String aptoidePackage, AuthenticationPersistence authenticationPersistence) {
        boolean[] $jacocoInit = $jacocoInit();
        String release = SystemU.getRelease();
        int i = VERSION.SDK_INT;
        $jacocoInit[73] = true;
        String model = SystemU.getModel();
        String product = SystemU.getProduct();
        $jacocoInit[74] = true;
        String property = System.getProperty("os.arch");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[75] = true;
        String defaultVername = Core.getDefaultVername(aptoideApplication);
        $jacocoInit[76] = true;
        UserAgentInterceptorV8 userAgentInterceptorV8 = new UserAgentInterceptorV8(idsRepository, release, i, model, product, property, displayMetrics, defaultVername.replace("aptoide-", ""), aptoidePackage, this.aptoideMd5sum, BuildConfig.VERSION_CODE, authenticationPersistence);
        $jacocoInit[77] = true;
        return userAgentInterceptorV8;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Interceptor provideRetrofitLogInterceptor() {
        boolean[] $jacocoInit = $jacocoInit();
        HttpLoggingInterceptor level = new HttpLoggingInterceptor().setLevel(Level.BODY);
        $jacocoInit[78] = true;
        return level;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public IdsRepository provideIdsRepository(@Named("default") SharedPreferences defaultSharedPreferences, ContentResolver contentResolver) {
        boolean[] $jacocoInit = $jacocoInit();
        Context applicationContext = this.application.getApplicationContext();
        $jacocoInit[79] = true;
        SharedPreferences instance = SecurePreferencesImplementation.getInstance(applicationContext, defaultSharedPreferences);
        $jacocoInit[80] = true;
        IdsRepository idsRepository = new IdsRepository(instance, applicationContext, Secure.getString(contentResolver, "android_id"));
        $jacocoInit[81] = true;
        return idsRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ContentResolver provideContentResolver() {
        boolean[] $jacocoInit = $jacocoInit();
        ContentResolver contentResolver = this.application.getContentResolver();
        $jacocoInit[82] = true;
        return contentResolver;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AndroidAccountProvider provideAndroidAccountProvider(AccountManager accountManager, @Named("accountType") String accountType) {
        boolean[] $jacocoInit = $jacocoInit();
        AndroidAccountProvider androidAccountProvider = new AndroidAccountProvider(accountManager, accountType, Schedulers.m776io());
        $jacocoInit[83] = true;
        return androidAccountProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public PermissionManager providePermissionManager() {
        boolean[] $jacocoInit = $jacocoInit();
        PermissionManager permissionManager = new PermissionManager();
        $jacocoInit[84] = true;
        return permissionManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AccountManager provideAccountManager() {
        boolean[] $jacocoInit = $jacocoInit();
        AccountManager accountManager = AccountManager.get(this.application);
        $jacocoInit[85] = true;
        return accountManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public RootAvailabilityManager provideRootAvailabilityManager(@Named("secure") final SecurePreferences securePreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        RootAvailabilityManager rootAvailabilityManager = new RootAvailabilityManager(new RootValueSaver(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final String IS_PHONE_ROOTED = "IS_PHONE_ROOTED";
            final /* synthetic */ ApplicationModule this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-5744249823083898785L, "cm/aptoide/pt/ApplicationModule$1", 5);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public Single<Boolean> isPhoneRoot() {
                boolean[] $jacocoInit = $jacocoInit();
                C0120S s = securePreferences.getBoolean("IS_PHONE_ROOTED", false);
                $jacocoInit[1] = true;
                C0120S d = s.mo3647d();
                $jacocoInit[2] = true;
                Single<Boolean> n = d.mo3678n();
                $jacocoInit[3] = true;
                return n;
            }

            public C0117M save(boolean rootAvailable) {
                boolean[] $jacocoInit = $jacocoInit();
                C0117M save = securePreferences.save("IS_PHONE_ROOTED", rootAvailable);
                $jacocoInit[4] = true;
                return save;
            }
        });
        $jacocoInit[86] = true;
        return rootAvailabilityManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Map<Integer, Result> provideFragmentNavigatorMap() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap hashMap = new HashMap();
        $jacocoInit[87] = true;
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public C0099b<Map<Integer, Result>> provideFragmentNavigatorRelay() {
        boolean[] $jacocoInit = $jacocoInit();
        C0099b<Map<Integer, Result>> o = C0099b.m564o();
        $jacocoInit[88] = true;
        return o;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Resources provideResources() {
        boolean[] $jacocoInit = $jacocoInit();
        Resources resources = this.application.getResources();
        $jacocoInit[89] = true;
        return resources;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AuthenticationPersistence provideAuthenticationPersistence(AndroidAccountProvider androidAccountProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[90] = true;
        AuthenticationPersistence authenticationPersistence = new AuthenticationPersistence(androidAccountProvider, (AccountManager) aptoideApplication.getSystemService("account"));
        $jacocoInit[91] = true;
        return authenticationPersistence;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SharedPreferences providesDefaultSharedPerefences() {
        boolean[] $jacocoInit = $jacocoInit();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.application);
        $jacocoInit[92] = true;
        return defaultSharedPreferences;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SecurePreferences providesSecurePerefences(@Named("default") SharedPreferences defaultSharedPreferences, SecureCoderDecoder secureCoderDecoder) {
        boolean[] $jacocoInit = $jacocoInit();
        SecurePreferences securePreferences = new SecurePreferences(defaultSharedPreferences, secureCoderDecoder);
        $jacocoInit[93] = true;
        return securePreferences;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SharedPreferences providesSecureSharedPreferences(@Named("default") SharedPreferences defaultSharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        SharedPreferences instance = SecurePreferencesImplementation.getInstance(C6787r.m13815e(), defaultSharedPreferences);
        $jacocoInit[94] = true;
        return instance;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String providesAptoideTheme() {
        $jacocoInit()[95] = true;
        return BuildConfig.APTOIDE_THEME;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public RootInstallationRetryHandler provideRootInstallationRetryHandler(InstallManager installManager) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent retryActionIntent = new Intent(this.application, RootInstallNotificationEventReceiver.class);
        $jacocoInit[96] = true;
        retryActionIntent.setAction(RootInstallNotificationEventReceiver.ROOT_INSTALL_RETRY_ACTION);
        $jacocoInit[97] = true;
        PendingIntent retryPendingIntent = PendingIntent.getBroadcast(this.application, 2, retryActionIntent, 134217728);
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[98] = true;
        C0449a action = new C0449a(C1375R.drawable.ic_refresh_action_black, aptoideApplication.getString(C1375R.string.generalscreen_short_root_install_timeout_error_action), retryPendingIntent);
        AptoideApplication aptoideApplication2 = this.application;
        $jacocoInit[99] = true;
        Intent action2 = retryActionIntent.setAction(RootInstallNotificationEventReceiver.ROOT_INSTALL_DISMISS_ACTION);
        $jacocoInit[100] = true;
        PendingIntent deleteAction = PendingIntent.getBroadcast(aptoideApplication2, 3, action2, 134217728);
        AptoideApplication aptoideApplication3 = this.application;
        $jacocoInit[101] = true;
        SystemNotificationShower systemNotificationShower = aptoideApplication3.getSystemNotificationShower();
        C0100e o = C0100e.m565o();
        AptoideApplication aptoideApplication4 = this.application;
        $jacocoInit[102] = true;
        RootInstallationRetryHandler rootInstallationRetryHandler = new RootInstallationRetryHandler(230498, systemNotificationShower, installManager, o, 0, aptoideApplication4, new RootInstallErrorNotificationFactory(230498, BitmapFactory.decodeResource(aptoideApplication4.getResources(), C1375R.mipmap.ic_launcher), action, deleteAction));
        $jacocoInit[103] = true;
        return rootInstallationRetryHandler;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public GoogleApiClient provideGoogleApiClient() {
        boolean[] $jacocoInit = $jacocoInit();
        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.application);
        Api<GoogleSignInOptions> api = Auth.f19284g;
        GoogleSignInOptions.Builder builder2 = new GoogleSignInOptions.Builder(GoogleSignInOptions.f19436f);
        $jacocoInit[104] = true;
        GoogleSignInOptions.Builder b = builder2.mo27206b();
        Scope scope = new Scope("https://www.googleapis.com/auth/contacts.readonly");
        Scope[] scopeArr = new Scope[0];
        $jacocoInit[105] = true;
        GoogleSignInOptions.Builder a = b.mo27202a(scope, scopeArr);
        Scope scope2 = new Scope("profile");
        Scope[] scopeArr2 = new Scope[0];
        $jacocoInit[106] = true;
        GoogleSignInOptions.Builder a2 = a.mo27202a(scope2, scopeArr2);
        $jacocoInit[107] = true;
        GoogleSignInOptions.Builder a3 = a2.mo27203a(BuildConfig.GMS_SERVER_ID);
        $jacocoInit[108] = true;
        GoogleSignInOptions a4 = a3.mo27205a();
        $jacocoInit[109] = true;
        GoogleApiClient.Builder a5 = builder.mo27392a(api, a4);
        $jacocoInit[110] = true;
        GoogleApiClient a6 = a5.mo27395a();
        $jacocoInit[111] = true;
        return a6;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AptoideAccountManager provideAptoideAccountManager(AdultContent adultContent, StoreAccessor storeAccessor, AccountManager accountManager, @Named("default") SharedPreferences defaultSharedPreferences, AuthenticationPersistence authenticationPersistence, AndroidAccountProvider androidAccountProvider, GoogleApiClient googleApiClient, StoreManager storeManager, AccountService accountService, AccountFactory accountFactory, LoginPreferences loginPreferences) {
        AdultContent adultContent2 = adultContent;
        SharedPreferences sharedPreferences = defaultSharedPreferences;
        LoginPreferences loginPreferences2 = loginPreferences;
        boolean[] $jacocoInit = $jacocoInit();
        C6787r.m13813c(this.application);
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[112] = true;
        SharedPreferences instance = SecurePreferencesImplementation.getInstance(aptoideApplication, sharedPreferences);
        AptoideApplication aptoideApplication2 = this.application;
        $jacocoInit[113] = true;
        AccountManager accountManager2 = AccountManager.get(aptoideApplication2);
        SecureCoderDecoder.Builder builder = new SecureCoderDecoder.Builder(this.application, sharedPreferences);
        $jacocoInit[114] = true;
        SecureCoderDecoder create = builder.create();
        AptoideApplication aptoideApplication3 = this.application;
        $jacocoInit[115] = true;
        File databasePath = aptoideApplication3.getDatabasePath(SQLiteDatabaseHelper.DATABASE_NAME);
        $jacocoInit[116] = true;
        SharedPreferences sharedPreferences2 = defaultSharedPreferences;
        AndroidAccountDataMigration androidAccountDataMigration = new AndroidAccountDataMigration(instance, sharedPreferences2, accountManager2, create, 60, databasePath.getPath(), this.application.getAccountType(), BuildConfig.VERSION_NAME, Schedulers.m776io());
        $jacocoInit[117] = true;
        AndroidAccountDataMigration accountDataMigration = androidAccountDataMigration;
        DatabaseStoreDataPersist databaseStoreDataPersist = new DatabaseStoreDataPersist(storeAccessor, new DatabaseStoreMapper());
        $jacocoInit[118] = true;
        AndroidAccountManagerPersistence androidAccountManagerPersistence = new AndroidAccountManagerPersistence(accountManager, databaseStoreDataPersist, accountFactory, accountDataMigration, androidAccountProvider, authenticationPersistence, Schedulers.m776io());
        $jacocoInit[119] = true;
        AptoideAccountManager.Builder accountPersistence = new AptoideAccountManager.Builder().setAccountPersistence(new MatureContentPersistence(androidAccountManagerPersistence, adultContent2));
        $jacocoInit[120] = true;
        AptoideAccountManager.Builder accountService2 = accountPersistence.setAccountService(accountService);
        $jacocoInit[121] = true;
        AptoideAccountManager.Builder adultService = accountService2.setAdultService(adultContent2);
        GoogleSignUpAdapter googleSignUpAdapter = new GoogleSignUpAdapter(googleApiClient, loginPreferences2);
        $jacocoInit[122] = true;
        AptoideAccountManager.Builder registerSignUpAdapter = adultService.registerSignUpAdapter(GoogleSignUpAdapter.TYPE, googleSignUpAdapter);
        String[] strArr = {"email"};
        $jacocoInit[123] = true;
        FacebookSignUpAdapter facebookSignUpAdapter = new FacebookSignUpAdapter(Arrays.asList(strArr), C6745C.m13592a(), loginPreferences2);
        $jacocoInit[124] = true;
        AptoideAccountManager.Builder registerSignUpAdapter2 = registerSignUpAdapter.registerSignUpAdapter(FacebookSignUpAdapter.TYPE, facebookSignUpAdapter);
        $jacocoInit[125] = true;
        AptoideAccountManager.Builder storeManager2 = registerSignUpAdapter2.setStoreManager(storeManager);
        $jacocoInit[126] = true;
        AptoideAccountManager build = storeManager2.build();
        $jacocoInit[127] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AccountFactory provideAccountFactory() {
        boolean[] $jacocoInit = $jacocoInit();
        AccountFactory accountFactory = new AccountFactory();
        $jacocoInit[128] = true;
        return accountFactory;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AccountService provideAccountService(@Named("default") OkHttpClient httpClient, @Named("long-timeout") OkHttpClient longTimeoutHttpClient, @Named("default") SharedPreferences defaultSharedPreferences, AuthenticationPersistence authenticationPersistence, TokenInvalidator tokenInvalidator, @Named("pool-v7") BodyInterceptor<BaseBody> bodyInterceptorPoolV7, @Named("web-v7") BodyInterceptor<BaseBody> bodyInterceptorWebV7, @Named("multipart") MultipartBodyInterceptor multipartBodyInterceptor, @Named("no-authentication-v3") BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> noAuthenticationBodyInterceptorV3, @Named("defaultInterceptorV3") BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptorV3, @Named("default") ObjectMapper objectMapper, Factory converterFactory, @Named("extraID") String extraId, AccountFactory accountFactory, OAuthModeProvider oAuthModeProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountServiceV3 accountServiceV3 = new AccountServiceV3(accountFactory, httpClient, longTimeoutHttpClient, converterFactory, objectMapper, defaultSharedPreferences, extraId, tokenInvalidator, authenticationPersistence, noAuthenticationBodyInterceptorV3, bodyInterceptorV3, multipartBodyInterceptor, bodyInterceptorWebV7, bodyInterceptorPoolV7, oAuthModeProvider);
        $jacocoInit[129] = true;
        return accountServiceV3;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public OAuthModeProvider provideOAuthModeProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        OAuthModeProvider oAuthModeProvider = new OAuthModeProvider();
        $jacocoInit[130] = true;
        return oAuthModeProvider;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0068  */
    @javax.inject.Singleton
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.OkHttpClient provideOkHttpClient(p005cm.aptoide.p006pt.dataprovider.cache.L2Cache r8, @javax.inject.Named("user-agent") okhttp3.Interceptor r9, @javax.inject.Named("default") android.content.SharedPreferences r10, @javax.inject.Named("retrofit-log") okhttp3.Interceptor r11) {
        /*
            r7 = this;
            boolean[] r0 = $jacocoInit()
            okhttp3.OkHttpClient$Builder r1 = new okhttp3.OkHttpClient$Builder
            r1.<init>()
            r2 = 1
            r3 = 131(0x83, float:1.84E-43)
            r0[r3] = r2
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            r4 = 45
            r1.readTimeout(r4, r3)
            r3 = 132(0x84, float:1.85E-43)
            r0[r3] = r2
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            r1.writeTimeout(r4, r3)
            r3 = 133(0x85, float:1.86E-43)
            r0[r3] = r2
            okhttp3.Cache r3 = new okhttp3.Cache
            cm.aptoide.pt.AptoideApplication r4 = r7.application
            java.io.File r4 = r4.getCacheDir()
            r5 = 10485760(0xa00000, double:5.180654E-317)
            r3.<init>(r4, r5)
            r4 = 134(0x86, float:1.88E-43)
            r0[r4] = r2     // Catch:{ IOException -> 0x003e }
            r3.evictAll()     // Catch:{ IOException -> 0x003c }
            r4 = 135(0x87, float:1.89E-43)
            r0[r4] = r2
            goto L_0x0043
        L_0x003c:
            r4 = move-exception
            goto L_0x003f
        L_0x003e:
            r4 = move-exception
        L_0x003f:
            r4 = 136(0x88, float:1.9E-43)
            r0[r4] = r2
        L_0x0043:
            r1.cache(r3)
            r4 = 137(0x89, float:1.92E-43)
            r0[r4] = r2
            cm.aptoide.pt.dataprovider.cache.POSTCacheInterceptor r4 = new cm.aptoide.pt.dataprovider.cache.POSTCacheInterceptor
            r4.<init>(r8)
            r1.addInterceptor(r4)
            r4 = 138(0x8a, float:1.93E-43)
            r0[r4] = r2
            r1.addInterceptor(r9)
            r4 = 139(0x8b, float:1.95E-43)
            r0[r4] = r2
            boolean r4 = p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager.isToolboxEnableRetrofitLogs(r10)
            if (r4 != 0) goto L_0x0068
            r4 = 140(0x8c, float:1.96E-43)
            r0[r4] = r2
            goto L_0x0073
        L_0x0068:
            r4 = 141(0x8d, float:1.98E-43)
            r0[r4] = r2
            r1.addInterceptor(r11)
            r4 = 142(0x8e, float:1.99E-43)
            r0[r4] = r2
        L_0x0073:
            okhttp3.OkHttpClient r4 = r1.build()
            r5 = 143(0x8f, float:2.0E-43)
            r0[r5] = r2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.ApplicationModule.provideOkHttpClient(cm.aptoide.pt.dataprovider.cache.L2Cache, okhttp3.Interceptor, android.content.SharedPreferences, okhttp3.Interceptor):okhttp3.OkHttpClient");
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public OkHttpClient provideLongTimeoutOkHttpClient(@Named("user-agent") Interceptor userAgentInterceptor, @Named("default") SharedPreferences sharedPreferences, @Named("retrofit-log") Interceptor retrofitLogInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        Builder okHttpClientBuilder = new Builder();
        $jacocoInit[144] = true;
        okHttpClientBuilder.addInterceptor(userAgentInterceptor);
        $jacocoInit[145] = true;
        okHttpClientBuilder.addInterceptor(retrofitLogInterceptor);
        $jacocoInit[146] = true;
        okHttpClientBuilder.connectTimeout(2, TimeUnit.MINUTES);
        $jacocoInit[147] = true;
        okHttpClientBuilder.readTimeout(2, TimeUnit.MINUTES);
        $jacocoInit[148] = true;
        okHttpClientBuilder.writeTimeout(2, TimeUnit.MINUTES);
        $jacocoInit[149] = true;
        if (!ToolboxManager.isToolboxEnableRetrofitLogs(sharedPreferences)) {
            $jacocoInit[150] = true;
        } else {
            $jacocoInit[151] = true;
            okHttpClientBuilder.addInterceptor(retrofitLogInterceptor);
            $jacocoInit[152] = true;
        }
        OkHttpClient build = okHttpClientBuilder.build();
        $jacocoInit[153] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public OkHttpClient provideWebSocketOkHttpClient(@Named("user-agent") Interceptor userAgentInterceptor, @Named("default") SharedPreferences sharedPreferences, @Named("retrofit-log") Interceptor retrofitLogInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        Builder okHttpClientBuilder = new Builder();
        $jacocoInit[154] = true;
        okHttpClientBuilder.addInterceptor(userAgentInterceptor);
        $jacocoInit[155] = true;
        okHttpClientBuilder.addInterceptor(retrofitLogInterceptor);
        $jacocoInit[156] = true;
        okHttpClientBuilder.connectTimeout(2, TimeUnit.MINUTES);
        $jacocoInit[157] = true;
        okHttpClientBuilder.readTimeout(1, TimeUnit.MINUTES);
        $jacocoInit[158] = true;
        okHttpClientBuilder.writeTimeout(1, TimeUnit.MINUTES);
        $jacocoInit[159] = true;
        okHttpClientBuilder.pingInterval(10, TimeUnit.SECONDS);
        $jacocoInit[160] = true;
        if (!ToolboxManager.isToolboxEnableRetrofitLogs(sharedPreferences)) {
            $jacocoInit[161] = true;
        } else {
            $jacocoInit[162] = true;
            okHttpClientBuilder.addInterceptor(retrofitLogInterceptor);
            $jacocoInit[163] = true;
        }
        OkHttpClient build = okHttpClientBuilder.build();
        $jacocoInit[164] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0068  */
    @javax.inject.Singleton
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.OkHttpClient provideV8OkHttpClient(p005cm.aptoide.p006pt.dataprovider.cache.L2Cache r8, @javax.inject.Named("user-agent-v8") okhttp3.Interceptor r9, @javax.inject.Named("default") android.content.SharedPreferences r10, @javax.inject.Named("retrofit-log") okhttp3.Interceptor r11) {
        /*
            r7 = this;
            boolean[] r0 = $jacocoInit()
            okhttp3.OkHttpClient$Builder r1 = new okhttp3.OkHttpClient$Builder
            r1.<init>()
            r2 = 1
            r3 = 165(0xa5, float:2.31E-43)
            r0[r3] = r2
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            r4 = 45
            r1.readTimeout(r4, r3)
            r3 = 166(0xa6, float:2.33E-43)
            r0[r3] = r2
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            r1.writeTimeout(r4, r3)
            r3 = 167(0xa7, float:2.34E-43)
            r0[r3] = r2
            okhttp3.Cache r3 = new okhttp3.Cache
            cm.aptoide.pt.AptoideApplication r4 = r7.application
            java.io.File r4 = r4.getCacheDir()
            r5 = 10485760(0xa00000, double:5.180654E-317)
            r3.<init>(r4, r5)
            r4 = 168(0xa8, float:2.35E-43)
            r0[r4] = r2     // Catch:{ IOException -> 0x003e }
            r3.evictAll()     // Catch:{ IOException -> 0x003c }
            r4 = 169(0xa9, float:2.37E-43)
            r0[r4] = r2
            goto L_0x0043
        L_0x003c:
            r4 = move-exception
            goto L_0x003f
        L_0x003e:
            r4 = move-exception
        L_0x003f:
            r4 = 170(0xaa, float:2.38E-43)
            r0[r4] = r2
        L_0x0043:
            r1.cache(r3)
            r4 = 171(0xab, float:2.4E-43)
            r0[r4] = r2
            cm.aptoide.pt.dataprovider.cache.POSTCacheInterceptor r4 = new cm.aptoide.pt.dataprovider.cache.POSTCacheInterceptor
            r4.<init>(r8)
            r1.addInterceptor(r4)
            r4 = 172(0xac, float:2.41E-43)
            r0[r4] = r2
            r1.addInterceptor(r9)
            r4 = 173(0xad, float:2.42E-43)
            r0[r4] = r2
            boolean r4 = p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager.isToolboxEnableRetrofitLogs(r10)
            if (r4 != 0) goto L_0x0068
            r4 = 174(0xae, float:2.44E-43)
            r0[r4] = r2
            goto L_0x0073
        L_0x0068:
            r4 = 175(0xaf, float:2.45E-43)
            r0[r4] = r2
            r1.addInterceptor(r11)
            r4 = 176(0xb0, float:2.47E-43)
            r0[r4] = r2
        L_0x0073:
            okhttp3.OkHttpClient r4 = r1.build()
            r5 = 177(0xb1, float:2.48E-43)
            r0[r5] = r2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.ApplicationModule.provideV8OkHttpClient(cm.aptoide.pt.dataprovider.cache.L2Cache, okhttp3.Interceptor, android.content.SharedPreferences, okhttp3.Interceptor):okhttp3.OkHttpClient");
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ObjectMapper provideNonNullObjectMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        ObjectMapper objectMapper = new ObjectMapper();
        $jacocoInit[178] = true;
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        $jacocoInit[179] = true;
        return objectMapper;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public L2Cache provideL2Cache() {
        boolean[] $jacocoInit = $jacocoInit();
        POSTCacheKeyAlgorithm pOSTCacheKeyAlgorithm = new POSTCacheKeyAlgorithm();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[180] = true;
        L2Cache l2Cache = new L2Cache(pOSTCacheKeyAlgorithm, new File(aptoideApplication.getCacheDir(), "aptoide.wscache"));
        $jacocoInit[181] = true;
        return l2Cache;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public NotificationAccessor provideNotificationAccessor(Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationAccessor notificationAccessor = new NotificationAccessor(database);
        $jacocoInit[182] = true;
        return notificationAccessor;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SyncScheduler provideSyncScheduler(SyncStorage syncStorage) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[183] = true;
        AlarmSyncScheduler alarmSyncScheduler = new AlarmSyncScheduler(aptoideApplication, AlarmSyncService.class, (AlarmManager) aptoideApplication.getSystemService("alarm"), syncStorage);
        $jacocoInit[184] = true;
        return alarmSyncScheduler;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SyncStorage provideSyncStorage(RealmLocalNotificationSyncPersistence persistence) {
        boolean[] $jacocoInit = $jacocoInit();
        SyncStorage syncStorage = new SyncStorage(new HashMap(), persistence);
        $jacocoInit[185] = true;
        return syncStorage;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public StoreUtilsProxy provideStoreUtilsProxy(AptoideAccountManager accountManager, StoreAccessor storeAccessor, @Named("default") OkHttpClient httpClient, @Named("default") SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreAccessor storeAccessor2 = storeAccessor;
        StoreCredentialsProviderImpl storeCredentialsProviderImpl = new StoreCredentialsProviderImpl(storeAccessor);
        $jacocoInit[186] = true;
        StoreUtilsProxy storeUtilsProxy = new StoreUtilsProxy(accountManager, bodyInterceptor, storeCredentialsProviderImpl, storeAccessor, httpClient, WebService.getDefaultConverter(), tokenInvalidator, sharedPreferences);
        $jacocoInit[187] = true;
        return storeUtilsProxy;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public TokenInvalidator provideTokenInvalidator(@Named("default") OkHttpClient httpClient, @Named("default") SharedPreferences sharedPreferences, AuthenticationPersistence authenticationPersistence, @Named("no-authentication-v3") BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptor, @Named("extraID") String extraId) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[188] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        NoOpTokenInvalidator noOpTokenInvalidator = new NoOpTokenInvalidator();
        $jacocoInit[189] = true;
        RefreshTokenInvalidator refreshTokenInvalidator = new RefreshTokenInvalidator(bodyInterceptor, httpClient, defaultConverter, sharedPreferences, extraId, noOpTokenInvalidator, authenticationPersistence, C14963c.m46753p());
        $jacocoInit[190] = true;
        return refreshTokenInvalidator;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public InvalidRefreshTokenLogoutManager provideInvalidRefreshTokenLogoutManager(AptoideAccountManager aptoideAccountManager, TokenInvalidator refreshTokenInvalidator) {
        boolean[] $jacocoInit = $jacocoInit();
        InvalidRefreshTokenLogoutManager invalidRefreshTokenLogoutManager = new InvalidRefreshTokenLogoutManager(aptoideAccountManager, (RefreshTokenInvalidator) refreshTokenInvalidator);
        $jacocoInit[191] = true;
        return invalidRefreshTokenLogoutManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> provideNoAuthenticationBodyInterceptorV3(IdsRepository idsRepository, @Named("aptoidePackage") String aptoidePackage) {
        boolean[] $jacocoInit = $jacocoInit();
        NoAuthenticationBodyInterceptorV3 noAuthenticationBodyInterceptorV3 = new NoAuthenticationBodyInterceptorV3(idsRepository, this.aptoideMd5sum, aptoidePackage);
        $jacocoInit[192] = true;
        return noAuthenticationBodyInterceptorV3;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BodyInterceptor<BaseBody> provideAccountSettingsBodyInterceptorPoolV7(@Named("pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, AdultContent adultContent) {
        boolean[] $jacocoInit = $jacocoInit();
        MatureBodyInterceptorV7 matureBodyInterceptorV7 = new MatureBodyInterceptorV7(bodyInterceptor, adultContent);
        $jacocoInit[193] = true;
        return matureBodyInterceptorV7;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BodyInterceptor<BaseBody> provideBodyInterceptorPoolV7(AuthenticationPersistence authenticationPersistence, IdsRepository idsRepository, @Named("default") SharedPreferences sharedPreferences, Resources resources, QManager qManager, @Named("aptoidePackage") String aptoidePackage) {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptorV7 bodyInterceptorV7 = new BodyInterceptorV7(idsRepository, authenticationPersistence, this.aptoideMd5sum, aptoidePackage, qManager, Cdn.POOL, sharedPreferences, resources, BuildConfig.VERSION_CODE);
        $jacocoInit[194] = true;
        return bodyInterceptorV7;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MultipartBodyInterceptor provideMultipartBodyInterceptor(IdsRepository idsRepository, AuthenticationPersistence authenticationPersistence, RequestBodyFactory requestBodyFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        MultipartBodyInterceptor multipartBodyInterceptor = new MultipartBodyInterceptor(idsRepository, requestBodyFactory, authenticationPersistence);
        $jacocoInit[195] = true;
        return multipartBodyInterceptor;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public RequestBodyFactory provideRequestBodyFactory() {
        boolean[] $jacocoInit = $jacocoInit();
        RequestBodyFactory requestBodyFactory = new RequestBodyFactory();
        $jacocoInit[196] = true;
        return requestBodyFactory;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BodyInterceptor<BaseBody> provideBodyInterceptorWebV7(AuthenticationPersistence authenticationPersistence, IdsRepository idsRepository, @Named("default") SharedPreferences sharedPreferences, Resources resources, QManager qManager, @Named("aptoidePackage") String aptoidePackage) {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptorV7 bodyInterceptorV7 = new BodyInterceptorV7(idsRepository, authenticationPersistence, this.aptoideMd5sum, aptoidePackage, qManager, Cdn.WEB, sharedPreferences, resources, BuildConfig.VERSION_CODE);
        $jacocoInit[197] = true;
        return bodyInterceptorV7;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AnalyticsBodyInterceptorV7 provideAnalyticsBodyInterceptorV7(AuthenticationPersistence authenticationPersistence, IdsRepository idsRepository, @Named("default") SharedPreferences sharedPreferences, Resources resources, QManager qManager, @Named("aptoidePackage") String aptoidePackage) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsBodyInterceptorV7 analyticsBodyInterceptorV7 = new AnalyticsBodyInterceptorV7(idsRepository, authenticationPersistence, this.aptoideMd5sum, aptoidePackage, resources, BuildConfig.VERSION_CODE, qManager, sharedPreferences);
        $jacocoInit[198] = true;
        return analyticsBodyInterceptorV7;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public QManager provideQManager(@Named("default") SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[199] = true;
        ActivityManager activityManager = (ActivityManager) aptoideApplication.getSystemService("activity");
        AptoideApplication aptoideApplication2 = this.application;
        $jacocoInit[200] = true;
        QManager qManager = new QManager(sharedPreferences, resources, activityManager, windowManager, (UiModeManager) aptoideApplication2.getSystemService("uimode"));
        $jacocoInit[201] = true;
        return qManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public WindowManager provideWindowManager() {
        WindowManager windowManager = (WindowManager) this.application.getSystemService("window");
        $jacocoInit()[202] = true;
        return windowManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Preferences provideDefaultPreferences(@Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        Preferences preferences = new Preferences(sharedPreferences);
        $jacocoInit[203] = true;
        return preferences;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public StoreAccessor provideStoreAccessor(Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreAccessor storeAccessor = new StoreAccessor(database);
        $jacocoInit[204] = true;
        return storeAccessor;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public UpdateAccessor providesUpdateAccessor(Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        UpdateAccessor updateAccessor = new UpdateAccessor(database);
        $jacocoInit[205] = true;
        return updateAccessor;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SecureCoderDecoder provideSecureCoderDecoder(@Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        SecureCoderDecoder create = new SecureCoderDecoder.Builder(this.application, sharedPreferences).create();
        $jacocoInit[206] = true;
        return create;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public StoreRepository provideStoreRepository(StoreAccessor storeAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreRepository storeRepository = new StoreRepository(storeAccessor);
        $jacocoInit[207] = true;
        return storeRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public PageViewsAnalytics providePageViewsAnalytics(AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        PageViewsAnalytics pageViewsAnalytics = new PageViewsAnalytics(analyticsManager);
        $jacocoInit[208] = true;
        return pageViewsAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public NotificationAnalytics provideNotificationAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationAnalytics notificationAnalytics = new NotificationAnalytics(new AptoideInstallParser(), analyticsManager, navigationTracker);
        $jacocoInit[209] = true;
        return notificationAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SearchAnalytics providesSearchAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAnalytics searchAnalytics = new SearchAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[210] = true;
        return searchAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AnalyticsLogger providesAnalyticsDebugLogger() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsLogcatLogger analyticsLogcatLogger = new AnalyticsLogcatLogger();
        $jacocoInit[211] = true;
        return analyticsLogcatLogger;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public NavigationTracker provideNavigationTracker(PageViewsAnalytics pageViewsAnalytics, AnalyticsLogger logger) {
        boolean[] $jacocoInit = $jacocoInit();
        NavigationTracker navigationTracker = new NavigationTracker(new ArrayList(), new TrackerFilter(), pageViewsAnalytics, logger);
        $jacocoInit[212] = true;
        return navigationTracker;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Database provideDatabase() {
        boolean[] $jacocoInit = $jacocoInit();
        C13990F.m44511a((Context) this.application);
        $jacocoInit[213] = true;
        C14002a aVar = new C14002a();
        $jacocoInit[214] = true;
        aVar.mo43582a(BuildConfig.REALM_FILE_NAME);
        $jacocoInit[215] = true;
        aVar.mo43580a(8102);
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[216] = true;
        aVar.mo43581a((C14020X) new RealmToRealmDatabaseMigration(aptoideApplication.getApplicationContext()));
        $jacocoInit[217] = true;
        C14001L realmConfiguration = aVar.mo43583a();
        $jacocoInit[218] = true;
        C13990F.m44518c(realmConfiguration);
        $jacocoInit[219] = true;
        Database database = new Database();
        $jacocoInit[220] = true;
        return database;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public C6666i provideCallbackManager() {
        boolean[] $jacocoInit = $jacocoInit();
        C6722l lVar = new C6722l();
        $jacocoInit[221] = true;
        return lVar;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AccountAnalytics provideAccountAnalytics(NavigationTracker navigationTracker, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountAnalytics accountAnalytics = new AccountAnalytics(navigationTracker, CrashReport.getInstance(), analyticsManager);
        $jacocoInit[222] = true;
        return accountAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AdultContentAnalytics provideAdultContentAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        AdultContentAnalytics adultContentAnalytics = new AdultContentAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[223] = true;
        return adultContentAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DeepLinkAnalytics provideDeepLinkAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        DeepLinkAnalytics deepLinkAnalytics = new DeepLinkAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[224] = true;
        return deepLinkAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public StoreManager provideStoreManager(@Named("default") OkHttpClient okHttpClient, @Named("multipart") MultipartBodyInterceptor multipartBodyInterceptor, @Named("defaultInterceptorV3") BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptorV3, @Named("mature-pool-v7") BodyInterceptor<BaseBody> accountSettingsBodyInterceptorPoolV7, @Named("default") SharedPreferences defaultSharedPreferences, TokenInvalidator tokenInvalidator, RequestBodyFactory requestBodyFactory, @Named("default") ObjectMapper nonNullObjectMapper, StoreRepository storeRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreManager storeManager = new StoreManager(okHttpClient, WebService.getDefaultConverter(), multipartBodyInterceptor, bodyInterceptorV3, accountSettingsBodyInterceptorPoolV7, defaultSharedPreferences, tokenInvalidator, requestBodyFactory, nonNullObjectMapper, storeRepository);
        $jacocoInit[225] = true;
        return storeManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AdsRepository provideAdsRepository(IdsRepository idsRepository, AptoideAccountManager accountManager, @Named("default") OkHttpClient okHttpClient, QManager qManager, @Named("default") SharedPreferences defaultSharedPreferences, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, ConnectivityManager connectivityManager) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[226] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[227] = true;
        Context applicationContext = aptoideApplication.getApplicationContext();
        Resources resources = this.application.getResources();
        C1373L l = C1373L.f4262a;
        AptoideApplication aptoideApplication2 = this.application;
        aptoideApplication2.getClass();
        AdsRepository adsRepository = new AdsRepository(idsRepository, accountManager, okHttpClient, defaultConverter, qManager, defaultSharedPreferences, applicationContext, connectivityManager, resources, adsApplicationVersionCodeProvider, l, new C1379a(aptoideApplication2), new MinimalAdMapper());
        $jacocoInit[228] = true;
        return adsRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public RewardAppCoinsAppsRepository providesRewardAppCoinsAppsRepository(@Named("default") OkHttpClient okHttpClient, @Named("mature-pool-v7") BodyInterceptor<BaseBody> baseBodyBodyInterceptor, TokenInvalidator tokenInvalidator, @Named("default") SharedPreferences sharedPreferences, InstallManager installManager) {
        boolean[] $jacocoInit = $jacocoInit();
        RewardAppCoinsAppsRepository rewardAppCoinsAppsRepository = new RewardAppCoinsAppsRepository(okHttpClient, WebService.getDefaultConverter(), baseBodyBodyInterceptor, tokenInvalidator, sharedPreferences, installManager);
        $jacocoInit[229] = true;
        return rewardAppCoinsAppsRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AdsApplicationVersionCodeProvider providesAdsApplicationVersionCodeProvider(PackageRepository packageRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[230] = true;
        PackageRepositoryVersionCodeProvider packageRepositoryVersionCodeProvider = new PackageRepositoryVersionCodeProvider(packageRepository, aptoideApplication.getPackageName());
        $jacocoInit[231] = true;
        return packageRepositoryVersionCodeProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public PackageRepository providesPackageRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        PackageRepository packageRepository = new PackageRepository(this.application.getPackageManager());
        $jacocoInit[232] = true;
        return packageRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> providesBodyInterceptorV3(IdsRepository idsRepository, QManager qManager, @Named("default") SharedPreferences defaultSharedPreferences, NetworkOperatorManager networkOperatorManager, AuthenticationPersistence authenticationPersistence, @Named("aptoidePackage") String aptoidePackage) {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository idsRepository2 = idsRepository;
        String str = aptoidePackage;
        QManager qManager2 = qManager;
        SharedPreferences sharedPreferences = defaultSharedPreferences;
        BodyInterceptorV3 bodyInterceptorV3 = new BodyInterceptorV3(idsRepository2, this.aptoideMd5sum, str, qManager2, sharedPreferences, "json", VERSION.SDK_INT, networkOperatorManager, authenticationPersistence);
        $jacocoInit[233] = true;
        return bodyInterceptorV3;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public NetworkOperatorManager providesNetworkOperatorManager(TelephonyManager telephonyManager) {
        boolean[] $jacocoInit = $jacocoInit();
        NetworkOperatorManager networkOperatorManager = new NetworkOperatorManager(telephonyManager);
        $jacocoInit[234] = true;
        return networkOperatorManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public TrendingManager providesTrendingManager(TrendingService trendingService) {
        boolean[] $jacocoInit = $jacocoInit();
        TrendingManager trendingManager = new TrendingManager(trendingService);
        $jacocoInit[235] = true;
        return trendingManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Factory providesConverterFactory() {
        boolean[] $jacocoInit = $jacocoInit();
        Factory defaultConverter = WebService.getDefaultConverter();
        $jacocoInit[236] = true;
        return defaultConverter;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public StoreCredentialsProvider providesStoreCredentialsProvider(StoreAccessor storeAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentialsProviderImpl storeCredentialsProviderImpl = new StoreCredentialsProviderImpl(storeAccessor);
        $jacocoInit[237] = true;
        return storeCredentialsProviderImpl;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public TrendingService providesTrendingService(StoreCredentialsProvider storeCredentialsProvider, @Named("default") SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, Factory converterFactory, @Named("default") OkHttpClient httpClient, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        TrendingService trendingService = new TrendingService(storeCredentialsProvider, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        $jacocoInit[238] = true;
        return trendingService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideSearchBaseUrl(@Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchHostProvider searchHostProvider = new SearchHostProvider(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences), "https", BuildConfig.APTOIDE_WEB_SERVICES_SEARCH_HOST, BuildConfig.APTOIDE_WEB_SERVICES_SEARCH_SSL_HOST);
        $jacocoInit[239] = true;
        String searchHost = searchHostProvider.getSearchHost();
        $jacocoInit[240] = true;
        return searchHost;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public CallAdapter.Factory providesCallAdapterFactory() {
        boolean[] $jacocoInit = $jacocoInit();
        RxJavaCallAdapterFactory create = RxJavaCallAdapterFactory.create();
        $jacocoInit[241] = true;
        return create;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SearchManager providesSearchManager(@Named("mature-pool-v7") BodyInterceptor<BaseBody> baseBodyBodyInterceptor, @Named("default") SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, @Named("default") OkHttpClient okHttpClient, Factory converterFactory, Database database, AdsRepository adsRepository, AptoideAccountManager accountManager, MoPubAdsManager moPubAdsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[242] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(database, Store.class);
        $jacocoInit[243] = true;
        SearchManager searchManager = new SearchManager(sharedPreferences, tokenInvalidator, baseBodyBodyInterceptor, okHttpClient, converterFactory, StoreUtils.getSubscribedStoresAuthMap(storeAccessor), adsRepository, database, accountManager, moPubAdsManager);
        $jacocoInit[244] = true;
        return searchManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SearchSuggestionManager providesSearchSuggestionManager(SearchSuggestionRemoteRepository remoteRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchSuggestionService searchSuggestionService = new SearchSuggestionService(remoteRepository);
        $jacocoInit[245] = true;
        SearchSuggestionManager searchSuggestionManager = new SearchSuggestionManager(searchSuggestionService, Schedulers.m776io());
        $jacocoInit[246] = true;
        return searchSuggestionManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public WalletAdsOfferService providesWalletAdsOfferService(@Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptorPoolV7, @Named("default") OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, Factory converterFactory, @Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletAdsOfferService walletAdsOfferService = new WalletAdsOfferService(bodyInterceptorPoolV7, okHttpClient, tokenInvalidator, converterFactory, sharedPreferences);
        $jacocoInit[247] = true;
        return walletAdsOfferService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MoPubAdsManager providesMoPubAdsManager(MoPubInterstitialAdExperiment moPubInterstitialAdExperiment, MoPubBannerAdExperiment moPubBannerAdExperiment, MoPubNativeAdExperiment moPubNativeAdExperiment, WalletAdsOfferManager walletAdsOfferManager, MoPubConsentManager moPubConsentDialogManager) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubAdsManager moPubAdsManager = new MoPubAdsManager(moPubInterstitialAdExperiment, moPubBannerAdExperiment, moPubNativeAdExperiment, walletAdsOfferManager, moPubConsentDialogManager);
        $jacocoInit[248] = true;
        return moPubAdsManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AdsUserPropertyManager providesMoPubAdsService(MoPubAdsManager moPubAdsManager, InstalledRepository installedRepository, MoPubAnalytics moPubAnalytics, CrashReport crashReport) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[249] = true;
        AdsUserPropertyManager adsUserPropertyManager = new AdsUserPropertyManager(moPubAdsManager, installedRepository, moPubAnalytics, crashReport, Schedulers.m776io());
        $jacocoInit[250] = true;
        return adsUserPropertyManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Retrofit providesSearchSuggestionsRetrofit(@Named("ws-prod-suggestions-base-url") String baseUrl, @Named("default") OkHttpClient httpClient, Factory converterFactory, @Named("rx") CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit.Builder baseUrl2 = new Retrofit.Builder().baseUrl(baseUrl);
        $jacocoInit[251] = true;
        Retrofit.Builder client = baseUrl2.client(httpClient);
        $jacocoInit[252] = true;
        Retrofit.Builder addConverterFactory = client.addConverterFactory(converterFactory);
        $jacocoInit[253] = true;
        Retrofit.Builder addCallAdapterFactory = addConverterFactory.addCallAdapterFactory(rxCallAdapterFactory);
        $jacocoInit[254] = true;
        Retrofit build = addCallAdapterFactory.build();
        $jacocoInit[255] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String providesReactionsHost() {
        $jacocoInit()[256] = true;
        return "https://api.aptoide.com/";
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String providesBaseHost(@Named("default") SharedPreferences sharedPreferences) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        if (ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences)) {
            $jacocoInit[257] = true;
            str = Constants.HTTP;
        } else {
            $jacocoInit[258] = true;
            str = "https";
        }
        sb.append(str);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_HOST);
        sb.append("/api/7/");
        String sb2 = sb.toString();
        $jacocoInit[259] = true;
        return sb2;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String providesBaseSecondaryHost(@Named("default") SharedPreferences sharedPreferences) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        if (ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences)) {
            $jacocoInit[260] = true;
            str = Constants.HTTP;
        } else {
            $jacocoInit[261] = true;
            str = "https";
        }
        sb.append(str);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_READ_V7_HOST);
        sb.append("/api/7/");
        String sb2 = sb.toString();
        $jacocoInit[262] = true;
        return sb2;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Retrofit providesV7Retrofit(@Named("base-host") String baseHost, @Named("default") OkHttpClient httpClient, Factory converterFactory, @Named("rx") CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(baseHost);
        $jacocoInit[263] = true;
        Retrofit.Builder client = baseUrl.client(httpClient);
        $jacocoInit[264] = true;
        Retrofit.Builder addCallAdapterFactory = client.addCallAdapterFactory(rxCallAdapterFactory);
        $jacocoInit[265] = true;
        Retrofit.Builder addConverterFactory = addCallAdapterFactory.addConverterFactory(converterFactory);
        $jacocoInit[266] = true;
        Retrofit build = addConverterFactory.build();
        $jacocoInit[267] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String providesABTestingBaseHost(@Named("default") SharedPreferences sharedPreferences) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        if (ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences)) {
            $jacocoInit[268] = true;
            str = Constants.HTTP;
        } else {
            $jacocoInit[269] = true;
            str = "https";
        }
        sb.append(str);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_AB_TESTING_HOST);
        sb.append("/api/v1/");
        String sb2 = sb.toString();
        $jacocoInit[270] = true;
        return sb2;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String providesApichainBdsBaseHost(@Named("default") SharedPreferences sharedPreferences) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        if (ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences)) {
            $jacocoInit[271] = true;
            str = Constants.HTTP;
        } else {
            $jacocoInit[272] = true;
            str = "https";
        }
        sb.append(str);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_APICHAIN_BDS_HOST);
        String sb2 = sb.toString();
        $jacocoInit[273] = true;
        return sb2;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Retrofit providesABRetrofit(@Named("ab-testing-base-host") String baseHost, @Named("default") OkHttpClient httpClient, Factory converterFactory, @Named("rx") CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(baseHost);
        $jacocoInit[274] = true;
        Retrofit.Builder client = baseUrl.client(httpClient);
        $jacocoInit[275] = true;
        Retrofit.Builder addCallAdapterFactory = client.addCallAdapterFactory(rxCallAdapterFactory);
        $jacocoInit[276] = true;
        Retrofit.Builder addConverterFactory = addCallAdapterFactory.addConverterFactory(converterFactory);
        $jacocoInit[277] = true;
        Retrofit build = addConverterFactory.build();
        $jacocoInit[278] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Retrofit providesDonationsRetrofit(@Named("v8") OkHttpClient httpClient, Factory converterFactory, @Named("rx") CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(DONATIONS_URL);
        $jacocoInit[279] = true;
        Retrofit.Builder client = baseUrl.client(httpClient);
        $jacocoInit[280] = true;
        Retrofit.Builder addCallAdapterFactory = client.addCallAdapterFactory(rxCallAdapterFactory);
        $jacocoInit[281] = true;
        Retrofit.Builder addConverterFactory = addCallAdapterFactory.addConverterFactory(converterFactory);
        $jacocoInit[282] = true;
        Retrofit build = addConverterFactory.build();
        $jacocoInit[283] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Retrofit providesLoadTopReactionsRetrofit(@Named("reactions-host") String baseHost, @Named("v8") OkHttpClient httpClient, Factory converterFactory, @Named("rx") CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(baseHost);
        $jacocoInit[284] = true;
        Retrofit.Builder client = baseUrl.client(httpClient);
        $jacocoInit[285] = true;
        Retrofit.Builder addCallAdapterFactory = client.addCallAdapterFactory(rxCallAdapterFactory);
        $jacocoInit[286] = true;
        Retrofit.Builder addConverterFactory = addCallAdapterFactory.addConverterFactory(converterFactory);
        $jacocoInit[287] = true;
        Retrofit build = addConverterFactory.build();
        $jacocoInit[288] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Retrofit providesApiChainBDSRetrofit(@Named("v8") OkHttpClient httpClient, Factory converterFactory, @Named("rx") CallAdapter.Factory rxCallAdapterFactory, @Named("apichain-bds-base-host") String baseHost) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(baseHost);
        $jacocoInit[289] = true;
        Retrofit.Builder client = baseUrl.client(httpClient);
        $jacocoInit[290] = true;
        Retrofit.Builder addCallAdapterFactory = client.addCallAdapterFactory(rxCallAdapterFactory);
        $jacocoInit[291] = true;
        Retrofit.Builder addConverterFactory = addCallAdapterFactory.addConverterFactory(converterFactory);
        $jacocoInit[292] = true;
        Retrofit build = addConverterFactory.build();
        $jacocoInit[293] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Retrofit providesV7SecondaryRetrofit(@Named("default") OkHttpClient httpClient, @Named("base-secondary-host") String baseHost, Factory converterFactory, @Named("rx") CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(baseHost);
        $jacocoInit[294] = true;
        Retrofit.Builder client = baseUrl.client(httpClient);
        $jacocoInit[295] = true;
        Retrofit.Builder addCallAdapterFactory = client.addCallAdapterFactory(rxCallAdapterFactory);
        $jacocoInit[296] = true;
        Retrofit.Builder addConverterFactory = addCallAdapterFactory.addConverterFactory(converterFactory);
        $jacocoInit[297] = true;
        Retrofit build = addConverterFactory.build();
        $jacocoInit[298] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SearchSuggestionRemoteRepository providesSearchSuggestionRemoteRepository(Retrofit retrofit) {
        SearchSuggestionRemoteRepository searchSuggestionRemoteRepository = (SearchSuggestionRemoteRepository) retrofit.create(SearchSuggestionRemoteRepository.class);
        $jacocoInit()[299] = true;
        return searchSuggestionRemoteRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ServiceV7 providesAptoideBiService(@Named("retrofit-v7") Retrofit retrofit) {
        ServiceV7 serviceV7 = (ServiceV7) retrofit.create(ServiceV7.class);
        $jacocoInit()[300] = true;
        return serviceV7;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Service providesAutoUpdateService(@Named("retrofit-auto-update") Retrofit retrofit) {
        Service service = (Service) retrofit.create(Service.class);
        $jacocoInit()[301] = true;
        return service;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ABTestService.ServiceV7 providesABTestServiceV7(@Named("retrofit-AB") Retrofit retrofit) {
        ABTestService.ServiceV7 serviceV7 = (ABTestService.ServiceV7) retrofit.create(ABTestService.ServiceV7.class);
        $jacocoInit()[302] = true;
        return serviceV7;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ServiceV8 providesDonationsServiceV8(@Named("retrofit-donations") Retrofit retrofit) {
        ServiceV8 serviceV8 = (ServiceV8) retrofit.create(ServiceV8.class);
        $jacocoInit()[303] = true;
        return serviceV8;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ReactionsRemoteService.ServiceV8 providesReactionsServiceV8(@Named("retrofit-load-top-reactions") Retrofit retrofit) {
        ReactionsRemoteService.ServiceV8 serviceV8 = (ReactionsRemoteService.ServiceV8) retrofit.create(ReactionsRemoteService.ServiceV8.class);
        $jacocoInit()[304] = true;
        return serviceV8;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ReactionsService providesReactionsService(ReactionsRemoteService.ServiceV8 reactionServiceV8) {
        boolean[] $jacocoInit = $jacocoInit();
        ReactionsRemoteService reactionsRemoteService = new ReactionsRemoteService(reactionServiceV8, Schedulers.m776io());
        $jacocoInit[305] = true;
        return reactionsRemoteService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ServiceInterface providesCaptchaServiceInterface(@Named("retrofit-apichain-bds") Retrofit retrofit) {
        ServiceInterface serviceInterface = (ServiceInterface) retrofit.create(ServiceInterface.class);
        $jacocoInit()[306] = true;
        return serviceInterface;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public PromotionsService providesPromotionsService(@Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptorPoolV7, @Named("default") OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, Factory converterFactory, @Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsService promotionsService = new PromotionsService(bodyInterceptorPoolV7, okHttpClient, tokenInvalidator, converterFactory, sharedPreferences);
        $jacocoInit[307] = true;
        return promotionsService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public CaptchaService providesCaptchaService(ServiceInterface service, IdsRepository idsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        CaptchaService captchaService = new CaptchaService(service, idsRepository);
        $jacocoInit[308] = true;
        return captchaService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public WalletService.ServiceV7 providesWalletServiceV8(@Named("retrofit-v7-secondary") Retrofit retrofit) {
        WalletService.ServiceV7 serviceV7 = (WalletService.ServiceV7) retrofit.create(WalletService.ServiceV7.class);
        $jacocoInit()[309] = true;
        return serviceV7;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public CrashReport providesCrashReports() {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[310] = true;
        return instance;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public RealmEventMapper providesRealmEventMapper(@Named("default") ObjectMapper objectMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        RealmEventMapper realmEventMapper = new RealmEventMapper(objectMapper);
        $jacocoInit[311] = true;
        return realmEventMapper;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public EventsPersistence providesEventsPersistence(Database database, RealmEventMapper mapper) {
        boolean[] $jacocoInit = $jacocoInit();
        RealmEventPersistence realmEventPersistence = new RealmEventPersistence(database, mapper);
        $jacocoInit[312] = true;
        return realmEventPersistence;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AptoideBiEventService providesRetrofitAptoideBiService(ServiceV7 serviceV7, @Named("analytics-interceptor") AnalyticsBodyInterceptorV7 bodyInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        $jacocoInit[313] = true;
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        $jacocoInit[314] = true;
        RetrofitAptoideBiService retrofitAptoideBiService = new RetrofitAptoideBiService(dateFormat, serviceV7, bodyInterceptor);
        $jacocoInit[315] = true;
        return retrofitAptoideBiService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public FirstLaunchAnalytics providesFirstLaunchAnalytics(AnalyticsManager analyticsManager, AnalyticsLogger logger, SafetyNetClient safetyNetClient) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[316] = true;
        FirstLaunchAnalytics firstLaunchAnalytics = new FirstLaunchAnalytics(analyticsManager, logger, safetyNetClient, aptoideApplication.getPackageName());
        $jacocoInit[317] = true;
        return firstLaunchAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SafetyNetClient providesSafetyNetClient() {
        boolean[] $jacocoInit = $jacocoInit();
        SafetyNetClient a = SafetyNet.m32726a(this.application);
        $jacocoInit[318] = true;
        return a;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public EventLogger providesAptoideEventLogger(@Named("aptoide") AptoideBiEventLogger aptoideBiEventLogger) {
        $jacocoInit()[319] = true;
        return aptoideBiEventLogger;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SessionLogger providesAptoideSessionLogger(@Named("aptoide") AptoideBiEventLogger aptoideBiEventLogger) {
        $jacocoInit()[320] = true;
        return aptoideBiEventLogger;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public EventLogger providesFacebookEventLogger(C6638q facebook, AnalyticsLogger logger) {
        boolean[] $jacocoInit = $jacocoInit();
        FacebookEventLogger facebookEventLogger = new FacebookEventLogger(facebook, logger);
        $jacocoInit[321] = true;
        return facebookEventLogger;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public FlurryEventLogger providesFlurryLogger(AnalyticsLogger logger) {
        boolean[] $jacocoInit = $jacocoInit();
        FlurryEventLogger flurryEventLogger = new FlurryEventLogger(this.application, logger);
        $jacocoInit[322] = true;
        return flurryEventLogger;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public EventLogger providesFlurryEventLogger(@Named("flurry") FlurryEventLogger eventLogger) {
        $jacocoInit()[323] = true;
        return eventLogger;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SessionLogger providesFlurrySessionLogger(@Named("flurry") FlurryEventLogger eventLogger) {
        $jacocoInit()[324] = true;
        return eventLogger;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AptoideBiEventLogger providesAptoideBILogger(EventsPersistence persistence, AptoideBiEventService service, C0075a crashlytics, @Named("default") SharedPreferences preferences, AnalyticsLogger debugLogger) {
        boolean[] $jacocoInit = $jacocoInit();
        SharedPreferencesSessionPersistence sharedPreferencesSessionPersistence = new SharedPreferencesSessionPersistence(preferences);
        C0136c cVar = new C0136c();
        $jacocoInit[325] = true;
        AptoideBiAnalytics aptoideBiAnalytics = new AptoideBiAnalytics(persistence, sharedPreferencesSessionPersistence, service, cVar, Schedulers.computation(), 0, 60000, new CrashlyticsCrashLogger(crashlytics), debugLogger);
        AptoideBiEventLogger aptoideBiEventLogger = new AptoideBiEventLogger(aptoideBiAnalytics, BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS);
        $jacocoInit[326] = true;
        return aptoideBiEventLogger;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public EventLogger providesFabricEventLogger(C6378b fabric, AnalyticsLogger logger) {
        boolean[] $jacocoInit = $jacocoInit();
        FabricEventLogger fabricEventLogger = new FabricEventLogger(fabric, logger);
        $jacocoInit[327] = true;
        return fabricEventLogger;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public HttpKnockEventLogger providesknockEventLogger(@Named("default") OkHttpClient client) {
        boolean[] $jacocoInit = $jacocoInit();
        HttpKnockEventLogger httpKnockEventLogger = new HttpKnockEventLogger(client);
        $jacocoInit[328] = true;
        return httpKnockEventLogger;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Collection<String> provideAptoideEvents() {
        boolean[] $jacocoInit = $jacocoInit();
        List asList = Arrays.asList(new String[]{FirstLaunchAnalytics.FIRST_LAUNCH_BI, FirstLaunchAnalytics.PLAY_PROTECT_EVENT, "OPEN_APP_VIEW", NotificationAnalytics.NOTIFICATION_EVENT_NAME, AccountAnalytics.APTOIDE_EVENT_NAME, DownloadAnalytics.DOWNLOAD_EVENT_NAME, InstallAnalytics.INSTALL_EVENT_NAME, PromotionsAnalytics.VALENTINE_MIGRATOR});
        $jacocoInit[329] = true;
        return asList;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Collection<String> provideFabricEvents() {
        boolean[] $jacocoInit = $jacocoInit();
        List asList = Arrays.asList(new String[]{DownloadAnalytics.DOWNLOAD_COMPLETE_EVENT, InstallEvents.ROOT_V2_COMPLETE, InstallEvents.ROOT_V2_START, InstallEvents.IS_INSTALLATION_TYPE_EVENT_NAME, AppValidationAnalytics.INVALID_DOWNLOAD_PATH_EVENT});
        $jacocoInit[330] = true;
        return asList;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AnalyticsManager providesAnalyticsManager(@Named("aptoideLogger") EventLogger aptoideBiEventLogger, @Named("facebook") EventLogger facebookEventLogger, @Named("fabric") EventLogger fabricEventLogger, @Named("flurryLogger") EventLogger flurryEventLogger, HttpKnockEventLogger knockEventLogger, @Named("aptoideEvents") Collection<String> aptoideEvents, @Named("facebookEvents") Collection<String> facebookEvents, @Named("fabricEvents") Collection<String> fabricEvents, @Named("flurryEvents") Collection<String> flurryEvents, @Named("flurrySession") SessionLogger flurrySessionLogger, @Named("aptoideSession") SessionLogger aptoideSessionLogger, @Named("normalizer") AnalyticsEventParametersNormalizer analyticsNormalizer, AnalyticsLogger logger) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager.Builder addLogger = new AnalyticsManager.Builder().addLogger(aptoideBiEventLogger, aptoideEvents);
        $jacocoInit[331] = true;
        AnalyticsManager.Builder addLogger2 = addLogger.addLogger(facebookEventLogger, facebookEvents);
        $jacocoInit[332] = true;
        AnalyticsManager.Builder addLogger3 = addLogger2.addLogger(fabricEventLogger, fabricEvents);
        $jacocoInit[333] = true;
        AnalyticsManager.Builder addLogger4 = addLogger3.addLogger(flurryEventLogger, flurryEvents);
        $jacocoInit[334] = true;
        AnalyticsManager.Builder addSessionLogger = addLogger4.addSessionLogger(flurrySessionLogger);
        $jacocoInit[335] = true;
        AnalyticsManager.Builder addSessionLogger2 = addSessionLogger.addSessionLogger(aptoideSessionLogger);
        $jacocoInit[336] = true;
        AnalyticsManager.Builder knockLogger = addSessionLogger2.setKnockLogger(knockEventLogger);
        $jacocoInit[337] = true;
        AnalyticsManager.Builder analyticsNormalizer2 = knockLogger.setAnalyticsNormalizer(analyticsNormalizer);
        $jacocoInit[338] = true;
        AnalyticsManager.Builder debugLogger = analyticsNormalizer2.setDebugLogger(logger);
        $jacocoInit[339] = true;
        AnalyticsManager build = debugLogger.build();
        $jacocoInit[340] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AnalyticsEventParametersNormalizer providesAnalyticsNormalizer() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsEventParametersNormalizer analyticsEventParametersNormalizer = new AnalyticsEventParametersNormalizer();
        $jacocoInit[341] = true;
        return analyticsEventParametersNormalizer;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppShortcutsAnalytics providesAppShortcutsAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        AppShortcutsAnalytics appShortcutsAnalytics = new AppShortcutsAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[342] = true;
        return appShortcutsAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public StoreAnalytics providesStoreAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreAnalytics storeAnalytics = new StoreAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[343] = true;
        return storeAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppService providesAppService(StoreCredentialsProvider storeCredentialsProvider, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptorPoolV7, @Named("defaultInterceptorV3") BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptorV3, @Named("default") OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[344] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[345] = true;
        AppService appService = new AppService(storeCredentialsProvider, bodyInterceptorPoolV7, bodyInterceptorV3, okHttpClient, defaultConverter, tokenInvalidator, sharedPreferences, aptoideApplication.getResources());
        $jacocoInit[346] = true;
        return appService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppCenterRepository providesAppCenterRepository(AppService appService) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCenterRepository appCenterRepository = new AppCenterRepository(appService, new HashMap());
        $jacocoInit[347] = true;
        return appCenterRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppCenter providesAppCenter(AppCenterRepository appCenterRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCenter appCenter = new AppCenter(appCenterRepository);
        $jacocoInit[348] = true;
        return appCenter;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppCoinsManager providesAppCoinsManager(AppCoinsService appCoinsService, DonationsService donationsService) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsManager appCoinsManager = new AppCoinsManager(appCoinsService, donationsService);
        $jacocoInit[349] = true;
        return appCoinsManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppCoinsService providesAppCoinsService(@Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptorPoolV7, @Named("default") OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named("default") SharedPreferences sharedPreferences, Factory converterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsService appCoinsService = new AppCoinsService(okHttpClient, tokenInvalidator, sharedPreferences, bodyInterceptorPoolV7, converterFactory);
        $jacocoInit[350] = true;
        return appCoinsService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BundleDataSource providesRemoteBundleDataSource(@Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptorPoolV7, @Named("default") OkHttpClient okHttpClient, Factory converter, BundlesResponseMapper mapper, TokenInvalidator tokenInvalidator, @Named("default") SharedPreferences sharedPreferences, AptoideAccountManager accountManager, PackageRepository packageRepository, Database database, IdsRepository idsRepository, QManager qManager, Resources resources, WindowManager windowManager, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider) {
        BodyInterceptor<BaseBody> bodyInterceptor = bodyInterceptorPoolV7;
        OkHttpClient okHttpClient2 = okHttpClient;
        Factory factory = converter;
        BundlesResponseMapper bundlesResponseMapper = mapper;
        TokenInvalidator tokenInvalidator2 = tokenInvalidator;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        AptoideAccountManager aptoideAccountManager = accountManager;
        PackageRepository packageRepository2 = packageRepository;
        Resources resources2 = resources;
        WindowManager windowManager2 = windowManager;
        ConnectivityManager connectivityManager2 = connectivityManager;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider2 = adsApplicationVersionCodeProvider;
        boolean[] $jacocoInit = $jacocoInit();
        HashMap hashMap = r1;
        HashMap hashMap2 = new HashMap();
        WSWidgetsUtils wSWidgetsUtils = r1;
        WSWidgetsUtils wSWidgetsUtils2 = new WSWidgetsUtils();
        StoreCredentialsProviderImpl storeCredentialsProviderImpl = r1;
        $jacocoInit[351] = true;
        StoreCredentialsProviderImpl storeCredentialsProviderImpl2 = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(database, Store.class));
        $jacocoInit[352] = true;
        String uniqueIdentifier = idsRepository.getUniqueIdentifier();
        $jacocoInit[353] = true;
        boolean isGooglePlayServicesAvailable = AdNetworkUtils.isGooglePlayServicesAvailable(C6787r.m13815e());
        $jacocoInit[354] = true;
        String partnerId = ((AptoideApplication) C6787r.m13815e()).getPartnerId();
        $jacocoInit[355] = true;
        RemoteBundleDataSource remoteBundleDataSource = new RemoteBundleDataSource(5, hashMap, bodyInterceptor, okHttpClient2, factory, bundlesResponseMapper, tokenInvalidator2, sharedPreferences2, wSWidgetsUtils, storeCredentialsProviderImpl, uniqueIdentifier, isGooglePlayServicesAvailable, partnerId, aptoideAccountManager, qManager.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences)), resources2, windowManager2, connectivityManager2, adsApplicationVersionCodeProvider2, packageRepository2, 10, 10);
        $jacocoInit[356] = true;
        return remoteBundleDataSource;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BundlesRepository providesBundleRepository(@Named("remote") BundleDataSource remoteBundleDataSource) {
        boolean[] $jacocoInit = $jacocoInit();
        BundlesRepository bundlesRepository = new BundlesRepository(remoteBundleDataSource, new HashMap(), new HashMap(), 5);
        $jacocoInit[357] = true;
        return bundlesRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BannerRepository providesBannerRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        BannerRepository bannerRepository = new BannerRepository();
        $jacocoInit[358] = true;
        return bannerRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AdMapper providesAdMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        AdMapper adMapper = new AdMapper();
        $jacocoInit[359] = true;
        return adMapper;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Blacklister providesBlacklister(BlacklistPersistence blacklistPersistence) {
        boolean[] $jacocoInit = $jacocoInit();
        Blacklister blacklister = new Blacklister(blacklistPersistence);
        $jacocoInit[360] = true;
        return blacklister;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BlacklistPersistence providesBlacklistPersistence(@Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        BlacklistPersistence blacklistPersistence = new BlacklistPersistence(sharedPreferences);
        $jacocoInit[361] = true;
        return blacklistPersistence;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BlacklistUnitMapper providesBundleToBlacklistUnitMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        BlacklistUnitMapper blacklistUnitMapper = new BlacklistUnitMapper();
        $jacocoInit[362] = true;
        return blacklistUnitMapper;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BlacklistManager providesBlacklistManager(Blacklister blacklister, BlacklistUnitMapper blacklistUnitMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        BlacklistManager blacklistManager = new BlacklistManager(blacklister, blacklistUnitMapper);
        $jacocoInit[363] = true;
        return blacklistManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BundlesResponseMapper providesBundlesMapper(@Named("marketName") String marketName, InstallManager installManager, WalletAdsOfferCardManager walletAdsOfferCardManager, BlacklistManager blacklistManager) {
        boolean[] $jacocoInit = $jacocoInit();
        BundlesResponseMapper bundlesResponseMapper = new BundlesResponseMapper(installManager, walletAdsOfferCardManager, blacklistManager);
        $jacocoInit[364] = true;
        return bundlesResponseMapper;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public UpdatesManager providesUpdatesManager(UpdateRepository updateRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        UpdatesManager updatesManager = new UpdatesManager(updateRepository);
        $jacocoInit[365] = true;
        return updatesManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public UpdateRepository providesUpdateRepository(UpdateAccessor updateAccessor, StoreAccessor storeAccessor, IdsRepository idsRepository, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptorPoolV7, @Named("default") OkHttpClient okHttpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, @Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[366] = true;
        UpdateRepository updateRepository = new UpdateRepository(updateAccessor, storeAccessor, idsRepository, bodyInterceptorPoolV7, okHttpClient, converterFactory, tokenInvalidator, sharedPreferences, aptoideApplication.getPackageManager());
        $jacocoInit[367] = true;
        return updateRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppViewAnalytics providesAppViewAnalytics(DownloadAnalytics downloadAnalytics, AnalyticsManager analyticsManager, NavigationTracker navigationTracker, BillingAnalytics billingAnalytics, StoreAnalytics storeAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewAnalytics appViewAnalytics = new AppViewAnalytics(downloadAnalytics, analyticsManager, navigationTracker, billingAnalytics, storeAnalytics);
        $jacocoInit[368] = true;
        return appViewAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public PreferencesPersister providesUserPreferencesPersister(@Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        PreferencesPersister preferencesPersister = new PreferencesPersister(sharedPreferences);
        $jacocoInit[369] = true;
        return preferencesPersister;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ReviewsManager providesReviewsManager(ReviewsRepository reviewsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        ReviewsManager reviewsManager = new ReviewsManager(reviewsRepository);
        $jacocoInit[370] = true;
        return reviewsManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ReviewsRepository providesReviewsRepository(ReviewsService reviewsService) {
        boolean[] $jacocoInit = $jacocoInit();
        ReviewsRepository reviewsRepository = new ReviewsRepository(reviewsService);
        $jacocoInit[371] = true;
        return reviewsRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ReviewsService providesReviewsService(StoreCredentialsProvider storeCredentialsProvider, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptorPoolV7, @Named("default") OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[372] = true;
        ReviewsService reviewsService = new ReviewsService(storeCredentialsProvider, bodyInterceptorPoolV7, okHttpClient, WebService.getDefaultConverter(), tokenInvalidator, sharedPreferences);
        $jacocoInit[373] = true;
        return reviewsService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AdsManager providesAdsManager(AdsRepository adsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[374] = true;
        $jacocoInit[375] = true;
        AdsManager adsManager = new AdsManager(adsRepository, (StoredMinimalAdAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) aptoideApplication.getApplicationContext()).getDatabase(), StoredMinimalAd.class), new MinimalAdMapper());
        $jacocoInit[376] = true;
        return adsManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public BillingAnalytics providesBillingAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        BillingAnalytics billingAnalytics = new BillingAnalytics("cm.aptoide.pt", analyticsManager, navigationTracker);
        $jacocoInit[377] = true;
        return billingAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ABTestService providesABTestService(ABTestService.ServiceV7 serviceV7, IdsRepository idsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        ABTestService aBTestService = new ABTestService(serviceV7, idsRepository, Schedulers.m776io());
        $jacocoInit[378] = true;
        return aBTestService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public RealmExperimentPersistence providesRealmExperimentPersistence(Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        RealmExperimentPersistence realmExperimentPersistence = new RealmExperimentPersistence(database, new RealmExperimentMapper());
        $jacocoInit[379] = true;
        return realmExperimentPersistence;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public HashMap<String, ExperimentModel> providesAbTestLocalCache() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, ExperimentModel> hashMap = new HashMap<>();
        $jacocoInit[380] = true;
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AbTestCacheValidator providesAbTestCacheValidator(@Named("ab-test-local-cache") HashMap<String, ExperimentModel> localCache) {
        boolean[] $jacocoInit = $jacocoInit();
        AbTestCacheValidator abTestCacheValidator = new AbTestCacheValidator(localCache);
        $jacocoInit[381] = true;
        return abTestCacheValidator;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ABTestCenterRepository providesABTestCenterRepository(ABTestService abTestService, RealmExperimentPersistence persistence, @Named("ab-test-local-cache") HashMap<String, ExperimentModel> localCache, AbTestCacheValidator cacheValidator) {
        boolean[] $jacocoInit = $jacocoInit();
        ABTestCenterRepository aBTestCenterRepository = new ABTestCenterRepository(abTestService, localCache, persistence, cacheValidator);
        $jacocoInit[382] = true;
        return aBTestCenterRepository;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ABTestManager providesABTestManager(ABTestCenterRepository abTestCenterRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        ABTestManager aBTestManager = new ABTestManager(abTestCenterRepository);
        $jacocoInit[383] = true;
        return aBTestManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public PromotionsManager providePromotionsManager(InstallManager installManager, PromotionViewAppMapper promotionViewAppMapper, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, PromotionsAnalytics promotionsAnalytics, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, PromotionsService promotionsService, InstalledRepository installedRepository, MoPubAdsManager moPubAdsManager, WalletAppProvider walletAppProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication aptoideApplication = this.application;
        $jacocoInit[384] = true;
        Context applicationContext = aptoideApplication.getApplicationContext();
        $jacocoInit[385] = true;
        PromotionsManager promotionsManager = new PromotionsManager(promotionViewAppMapper, installManager, downloadFactory, downloadStateParser, promotionsAnalytics, notificationAnalytics, installAnalytics, applicationContext.getPackageManager(), promotionsService, installedRepository, moPubAdsManager, walletAppProvider);
        $jacocoInit[386] = true;
        return promotionsManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public WalletAppProvider providesWalletAppProvider(AppCenter appCenter, InstalledRepository installedRepository, InstallManager installManager, DownloadStateParser downloadStateParser) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletAppProvider walletAppProvider = new WalletAppProvider(appCenter, installedRepository, installManager, downloadStateParser);
        $jacocoInit[387] = true;
        return walletAppProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public PromotionViewAppMapper providesPromotionViewAppMapper(DownloadStateParser downloadStateParser) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewAppMapper promotionViewAppMapper = new PromotionViewAppMapper(downloadStateParser);
        $jacocoInit[388] = true;
        return promotionViewAppMapper;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DownloadStateParser providesDownloadStateParser() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadStateParser downloadStateParser = new DownloadStateParser();
        $jacocoInit[389] = true;
        return downloadStateParser;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public EditorialService providesEditorialService(@Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptorPoolV7, @Named("default") OkHttpClient okHttpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, @Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialService editorialService = new EditorialService(bodyInterceptorPoolV7, okHttpClient, tokenInvalidator, converterFactory, sharedPreferences);
        $jacocoInit[390] = true;
        return editorialService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DonationsService providesDonationsService(ServiceV8 service) {
        boolean[] $jacocoInit = $jacocoInit();
        DonationsService donationsService = new DonationsService(service, Schedulers.m776io());
        $jacocoInit[391] = true;
        return donationsService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public WalletService providesWalletService(WalletService.ServiceV7 service) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletService walletService = new WalletService(service, Schedulers.m776io());
        $jacocoInit[392] = true;
        return walletService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideStoreName() {
        $jacocoInit()[393] = true;
        return "apps";
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideExtraID() {
        $jacocoInit()[394] = true;
        return "";
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideMarketName() {
        $jacocoInit()[395] = true;
        return BuildConfig.MARKET_NAME;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MarketResourceFormatter provideMarketResourceFormatter(@Named("marketName") String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        MarketResourceFormatter marketResourceFormatter = new MarketResourceFormatter(marketName);
        $jacocoInit[396] = true;
        return marketResourceFormatter;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideHomePromotionsId() {
        $jacocoInit()[397] = true;
        return BuildConfig.HOME_PROMOTION_ID;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideAccountType() {
        $jacocoInit()[398] = true;
        return "cm.aptoide.pt";
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideCachePath() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        $jacocoInit[399] = true;
        sb.append(externalStorageDirectory.getAbsolutePath());
        sb.append("/.aptoide/");
        String sb2 = sb.toString();
        $jacocoInit[400] = true;
        return sb2;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String provideImageCachePatch(@Named("cachePath") String cachePath) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(cachePath);
        sb.append("icons/");
        String sb2 = sb.toString();
        $jacocoInit[401] = true;
        return sb2;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public List<String> provideDefaultFollowedStores() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> asList = Arrays.asList(new String[]{"apps", "catappult"});
        $jacocoInit[402] = true;
        return asList;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AptoideApplicationAnalytics provideAptoideApplicationAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplicationAnalytics aptoideApplicationAnalytics = new AptoideApplicationAnalytics();
        $jacocoInit[403] = true;
        return aptoideApplicationAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MoPubAnalytics providesMoPubAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubAnalytics moPubAnalytics = new MoPubAnalytics();
        $jacocoInit[404] = true;
        return moPubAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Collection<String> provideFlurryEvents() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> flurryEvents = new LinkedList<>(Arrays.asList(new String[]{InstallAnalytics.APPLICATION_INSTALL, DownloadAnalytics.EDITORS_CHOICE_DOWNLOAD_COMPLETE_EVENT_NAME, DownloadAnalytics.DOWNLOAD_COMPLETE_EVENT, AppViewAnalytics.HOME_PAGE_EDITORS_CHOICE_FLURRY, AppViewAnalytics.APP_VIEW_OPEN_FROM, StoreAnalytics.STORES_TAB_INTERACT, StoreAnalytics.STORES_OPEN, StoreAnalytics.STORES_INTERACT, AccountAnalytics.SIGN_UP_EVENT_NAME, AccountAnalytics.LOGIN_EVENT_NAME, FirstLaunchAnalytics.FIRST_LAUNCH, AccountAnalytics.LOGIN_SIGN_UP_START_SCREEN, AccountAnalytics.CREATE_USER_PROFILE, AccountAnalytics.CREATE_YOUR_STORE, AccountAnalytics.PROFILE_SETTINGS, AdultContentAnalytics.ADULT_CONTENT, DeepLinkAnalytics.APP_LAUNCH, DeepLinkAnalytics.FACEBOOK_APP_LAUNCH, AppViewAnalytics.CLICK_INSTALL}));
        $jacocoInit[405] = true;
        return flurryEvents;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Collection<String> provideFacebookEvents() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = NotificationAnalytics.NOTIFICATION_RECEIVED;
        String str2 = DeepLinkAnalytics.FACEBOOK_APP_LAUNCH;
        String str3 = AppViewAnalytics.CLICK_INSTALL;
        String str4 = BillingAnalytics.PAYMENT_AUTH;
        String str5 = BillingAnalytics.PAYMENT_LOGIN;
        String str6 = BillingAnalytics.PAYMENT_POPUP;
        String str7 = AccountAnalytics.PROMOTE_APTOIDE_EVENT_NAME;
        List asList = Arrays.asList(new String[]{InstallAnalytics.APPLICATION_INSTALL, InstallAnalytics.NOTIFICATION_APPLICATION_INSTALL, InstallAnalytics.EDITORS_APPLICATION_INSTALL, DownloadAnalytics.EDITORS_CHOICE_DOWNLOAD_COMPLETE_EVENT_NAME, DownloadAnalytics.NOTIFICATION_DOWNLOAD_COMPLETE_EVENT_NAME, DownloadAnalytics.DOWNLOAD_COMPLETE_EVENT, SearchAnalytics.SEARCH, SearchAnalytics.NO_RESULTS, SearchAnalytics.APP_CLICK, SearchAnalytics.SEARCH_START, SearchAnalytics.AB_SEARCH_ACTION, SearchAnalytics.AB_SEARCH_IMPRESSION, AppViewAnalytics.EDITORS_CHOICE_CLICKS, AppViewAnalytics.APP_VIEW_OPEN_FROM, AppViewAnalytics.APP_VIEW_INTERACT, AppViewAnalytics.DONATIONS_IMPRESSION, str, NotificationAnalytics.NOTIFICATION_IMPRESSION, NotificationAnalytics.NOTIFICATION_PRESSED, str, StoreAnalytics.STORES_TAB_INTERACT, StoreAnalytics.STORES_OPEN, StoreAnalytics.STORES_INTERACT, AccountAnalytics.SIGN_UP_EVENT_NAME, AccountAnalytics.LOGIN_EVENT_NAME, UpdatesAnalytics.UPDATE_EVENT, PageViewsAnalytics.PAGE_VIEW_EVENT, FirstLaunchAnalytics.FIRST_LAUNCH, FirstLaunchAnalytics.PLAY_PROTECT_EVENT, InstallEvents.ROOT_V2_COMPLETE, InstallEvents.ROOT_V2_START, AppViewAnalytics.SIMILAR_APP_INTERACT, AccountAnalytics.LOGIN_SIGN_UP_START_SCREEN, AccountAnalytics.CREATE_USER_PROFILE, AccountAnalytics.PROFILE_SETTINGS, AccountAnalytics.ENTRY, str2, str3, str4, str5, str6, AppShortcutsAnalytics.APPS_SHORTCUTS, AccountAnalytics.CREATE_YOUR_STORE, str2, str3, str4, str5, str6, HomeAnalytics.HOME_INTERACT, HomeAnalytics.CURATION_CARD_CLICK, HomeAnalytics.CURATION_CARD_IMPRESSION, HomeAnalytics.HOME_CHIP_INTERACT, str7, EditorialListAnalytics.EDITORIAL_BN_CURATION_CARD_CLICK, EditorialListAnalytics.EDITORIAL_BN_CURATION_CARD_IMPRESSION, str7, BottomNavigationAnalytics.BOTTOM_NAVIGATION_INTERACT, DownloadAnalytics.DOWNLOAD_INTERACT, DonationsAnalytics.DONATIONS_INTERACT, EditorialAnalytics.CURATION_CARD_INSTALL, EditorialAnalytics.EDITORIAL_BN_CURATION_CARD_INSTALL, EditorialAnalytics.REACTION_INTERACT, PromotionsAnalytics.PROMOTION_DIALOG, PromotionsAnalytics.PROMOTIONS_INTERACT, PromotionsAnalytics.VALENTINE_MIGRATOR, AppViewAnalytics.ADS_BLOCK_BY_OFFER, AppViewAnalytics.APPC_SIMILAR_APP_INTERACT, AppViewAnalytics.BONUS_MIGRATION_APPVIEW, AppViewAnalytics.BONUS_GAME_WALLET_OFFER_19, DeepLinkAnalytics.APPCOINS_WALLET_DEEPLINK, InstallEvents.MIUI_INSTALLATION_ABOVE_20_EVENT_NAME});
        $jacocoInit[406] = true;
        return asList;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AptoideShortcutManager providesShortcutManager() {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideShortcutManager aptoideShortcutManager = new AptoideShortcutManager();
        $jacocoInit[407] = true;
        return aptoideShortcutManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SettingsManager providesSettingsManager() {
        boolean[] $jacocoInit = $jacocoInit();
        SettingsManager settingsManager = new SettingsManager();
        $jacocoInit[408] = true;
        return settingsManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public LoginSignupManager providesLoginSignupManager() {
        boolean[] $jacocoInit = $jacocoInit();
        LoginSignupManager loginSignupManager = new LoginSignupManager();
        $jacocoInit[409] = true;
        return loginSignupManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public MyAccountManager providesMyAccountManager() {
        boolean[] $jacocoInit = $jacocoInit();
        MyAccountManager myAccountManager = new MyAccountManager();
        $jacocoInit[410] = true;
        return myAccountManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public PromotionsPreferencesManager providesPromotionsPreferencesManager(PreferencesPersister persister) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsPreferencesManager promotionsPreferencesManager = new PromotionsPreferencesManager(persister);
        $jacocoInit[411] = true;
        return promotionsPreferencesManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public PromotionsAnalytics providesPromotionsAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker, DownloadAnalytics downloadAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsAnalytics promotionsAnalytics = new PromotionsAnalytics(analyticsManager, navigationTracker, downloadAnalytics);
        $jacocoInit[412] = true;
        return promotionsAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public Retrofit providesAutoUpdateRetrofit(@Named("default") OkHttpClient httpClient, @Named("auto-update-base-host") String baseHost, Factory converterFactory, @Named("rx") CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(baseHost);
        $jacocoInit[413] = true;
        Retrofit.Builder client = baseUrl.client(httpClient);
        $jacocoInit[414] = true;
        Retrofit.Builder addCallAdapterFactory = client.addCallAdapterFactory(rxCallAdapterFactory);
        $jacocoInit[415] = true;
        Retrofit.Builder addConverterFactory = addCallAdapterFactory.addConverterFactory(converterFactory);
        $jacocoInit[416] = true;
        Retrofit build = addConverterFactory.build();
        $jacocoInit[417] = true;
        return build;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public String providesAutoUpdateBaseHost() {
        $jacocoInit()[418] = true;
        return "http://imgs.aptoide.com/";
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public SupportEmailProvider providesSupportEmailProvider(@Named("support-email") String supportEmail) {
        boolean[] $jacocoInit = $jacocoInit();
        SupportEmailProvider supportEmailProvider = new SupportEmailProvider(supportEmail, this.application.getString(C1375R.string.aptoide_email));
        $jacocoInit[419] = true;
        return supportEmailProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public NewsletterManager providesNewsletterManager() {
        boolean[] $jacocoInit = $jacocoInit();
        NewsletterManager newsletterManager = new NewsletterManager();
        $jacocoInit[420] = true;
        return newsletterManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public DecimalFormat providesDecimalFormat() {
        boolean[] $jacocoInit = $jacocoInit();
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        $jacocoInit[421] = true;
        return decimalFormat;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ReactionsManager providesReactionsManager(ReactionsService reactionsService) {
        boolean[] $jacocoInit = $jacocoInit();
        ReactionsManager reactionsManager = new ReactionsManager(reactionsService, new HashMap());
        $jacocoInit[422] = true;
        return reactionsManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppInstaller providesAppInstaller(AppInstallerStatusReceiver appInstallerStatusReceiver) {
        boolean[] $jacocoInit = $jacocoInit();
        AppInstaller appInstaller = new AppInstaller(this.application.getApplicationContext(), new C2282b(appInstallerStatusReceiver));
        $jacocoInit[423] = true;
        return appInstaller;
    }

    /* renamed from: a */
    static /* synthetic */ void m87a(AppInstallerStatusReceiver appInstallerStatusReceiver, InstallStatus installStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        appInstallerStatusReceiver.onStatusReceived(installStatus);
        $jacocoInit[435] = true;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppInstallerStatusReceiver providesAppInstallerStatusReceiver() {
        boolean[] $jacocoInit = $jacocoInit();
        AppInstallerStatusReceiver appInstallerStatusReceiver = new AppInstallerStatusReceiver(C14963c.m46753p());
        $jacocoInit[424] = true;
        return appInstallerStatusReceiver;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public PackageInstallerManager providesPackageInstallerManager() {
        boolean[] $jacocoInit = $jacocoInit();
        PackageInstallerManager packageInstallerManager = new PackageInstallerManager();
        $jacocoInit[425] = true;
        return packageInstallerManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public NotificationProvider providesNotificationProvider(Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationAccessor notificationAccessor = (NotificationAccessor) AccessorFactory.getAccessorFor(database, Notification.class);
        $jacocoInit[426] = true;
        NotificationProvider notificationProvider = new NotificationProvider(notificationAccessor, Schedulers.m776io());
        $jacocoInit[427] = true;
        return notificationProvider;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public RealmLocalNotificationSyncPersistence providesRealmLocalNotificationSyncPersistence(Database database, NotificationProvider provider) {
        boolean[] $jacocoInit = $jacocoInit();
        RealmLocalNotificationSyncPersistence realmLocalNotificationSyncPersistence = new RealmLocalNotificationSyncPersistence(database, new RealmLocalNotificationSyncMapper(), provider);
        $jacocoInit[428] = true;
        return realmLocalNotificationSyncPersistence;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public LocalNotificationSyncManager providesLocalNotificationSyncManager(SyncScheduler syncScheduler, NotificationProvider provider) {
        boolean[] $jacocoInit = $jacocoInit();
        LocalNotificationSyncManager localNotificationSyncManager = new LocalNotificationSyncManager(syncScheduler, true, provider);
        $jacocoInit[429] = true;
        return localNotificationSyncManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public ChipManager providesChipManager() {
        boolean[] $jacocoInit = $jacocoInit();
        ChipManager chipManager = new ChipManager();
        $jacocoInit[430] = true;
        return chipManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppcMigrationManager providesAppcMigrationManager(InstalledRepository repository, AppcMigrationService appcMigrationService) {
        boolean[] $jacocoInit = $jacocoInit();
        AppcMigrationManager appcMigrationManager = new AppcMigrationManager(repository, appcMigrationService);
        $jacocoInit[431] = true;
        return appcMigrationManager;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppcMigrationService providesAppcMigrationService(AppcMigrationAccessor accessor) {
        boolean[] $jacocoInit = $jacocoInit();
        AppcMigrationService appcMigrationService = new AppcMigrationService(accessor);
        $jacocoInit[432] = true;
        return appcMigrationService;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public AppcMigrationAccessor providesAppcMigrationAccessor(Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        AppcMigrationAccessor appcMigrationAccessor = new AppcMigrationAccessor(database);
        $jacocoInit[433] = true;
        return appcMigrationAccessor;
    }

    /* access modifiers changed from: 0000 */
    @Singleton
    public CaptionBackgroundPainter providesCaptionBackgroundPainter() {
        boolean[] $jacocoInit = $jacocoInit();
        CaptionBackgroundPainter captionBackgroundPainter = new CaptionBackgroundPainter(C6787r.m13815e().getResources());
        $jacocoInit[434] = true;
        return captionBackgroundPainter;
    }
}
