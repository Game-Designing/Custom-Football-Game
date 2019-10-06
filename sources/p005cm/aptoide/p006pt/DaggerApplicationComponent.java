package p005cm.aptoide.p006pt;

import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.support.p000v4.app.C0486t;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import com.crashlytics.android.C0075a;
import com.crashlytics.android.p124a.C6378b;
import com.facebook.C6666i;
import com.facebook.p127a.C6638q;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.safetynet.SafetyNetClient;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountFactory;
import p005cm.aptoide.accountmanager.AccountService;
import p005cm.aptoide.accountmanager.AdultContent;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.EventLogger;
import p005cm.aptoide.analytics.SessionLogger;
import p005cm.aptoide.analytics.implementation.AptoideBiEventService;
import p005cm.aptoide.analytics.implementation.EventsPersistence;
import p005cm.aptoide.analytics.implementation.PageViewsAnalytics;
import p005cm.aptoide.analytics.implementation.loggers.AptoideBiEventLogger;
import p005cm.aptoide.analytics.implementation.loggers.FlurryEventLogger;
import p005cm.aptoide.analytics.implementation.loggers.HttpKnockEventLogger;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.network.RetrofitAptoideBiService;
import p005cm.aptoide.analytics.implementation.utils.AnalyticsEventParametersNormalizer;
import p005cm.aptoide.p006pt.abtesting.ABTestCenterRepository;
import p005cm.aptoide.p006pt.abtesting.ABTestManager;
import p005cm.aptoide.p006pt.abtesting.ABTestService;
import p005cm.aptoide.p006pt.abtesting.ABTestService.ServiceV7;
import p005cm.aptoide.p006pt.abtesting.AbTestCacheValidator;
import p005cm.aptoide.p006pt.abtesting.ExperimentModel;
import p005cm.aptoide.p006pt.abtesting.RealmExperimentPersistence;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubBannerAdExperiment;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubInterstitialAdExperiment;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubNativeAdExperiment;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p005cm.aptoide.p006pt.account.AndroidAccountProvider;
import p005cm.aptoide.p006pt.account.LoginPreferences;
import p005cm.aptoide.p006pt.account.OAuthModeProvider;
import p005cm.aptoide.p006pt.account.view.AccountErrorMapper;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.account.view.ImagePickerNavigator;
import p005cm.aptoide.p006pt.account.view.ImagePickerPresenter;
import p005cm.aptoide.p006pt.account.view.ImageValidator;
import p005cm.aptoide.p006pt.account.view.LoginSignUpCredentialsFragment;
import p005cm.aptoide.p006pt.account.view.LoginSignUpCredentialsFragment_MembersInjector;
import p005cm.aptoide.p006pt.account.view.PhotoFileGenerator;
import p005cm.aptoide.p006pt.account.view.UriToPathResolver;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreErrorMapper;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreFragment;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreFragment_MembersInjector;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreNavigator;
import p005cm.aptoide.p006pt.account.view.store.ManageStorePresenter;
import p005cm.aptoide.p006pt.account.view.store.StoreManager;
import p005cm.aptoide.p006pt.account.view.user.CreateUserErrorMapper;
import p005cm.aptoide.p006pt.account.view.user.ManageUserFragment;
import p005cm.aptoide.p006pt.account.view.user.ManageUserFragment_MembersInjector;
import p005cm.aptoide.p006pt.account.view.user.ManageUserNavigator;
import p005cm.aptoide.p006pt.account.view.user.ManageUserPresenter;
import p005cm.aptoide.p006pt.account.view.user.NewsletterManager;
import p005cm.aptoide.p006pt.account.view.user.ProfileStepOneFragment;
import p005cm.aptoide.p006pt.account.view.user.ProfileStepOneFragment_MembersInjector;
import p005cm.aptoide.p006pt.account.view.user.ProfileStepTwoFragment;
import p005cm.aptoide.p006pt.account.view.user.ProfileStepTwoFragment_MembersInjector;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.AdsUserPropertyManager;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.ads.MoPubAnalytics;
import p005cm.aptoide.p006pt.ads.MoPubConsentDialogView;
import p005cm.aptoide.p006pt.ads.MoPubConsentManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferCardManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferService;
import p005cm.aptoide.p006pt.analytics.FirstLaunchAnalytics;
import p005cm.aptoide.p006pt.analytics.analytics.AnalyticsBodyInterceptorV7;
import p005cm.aptoide.p006pt.analytics.analytics.RealmEventMapper;
import p005cm.aptoide.p006pt.analytics.view.AnalyticsActivity;
import p005cm.aptoide.p006pt.analytics.view.AnalyticsActivity_MembersInjector;
import p005cm.aptoide.p006pt.app.AdsManager;
import p005cm.aptoide.p006pt.app.AppCoinsManager;
import p005cm.aptoide.p006pt.app.AppCoinsService;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.AppViewAnalytics;
import p005cm.aptoide.p006pt.app.AppViewManager;
import p005cm.aptoide.p006pt.app.CampaignAnalytics;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.app.FlagManager;
import p005cm.aptoide.p006pt.app.FlagService;
import p005cm.aptoide.p006pt.app.ReviewsManager;
import p005cm.aptoide.p006pt.app.ReviewsRepository;
import p005cm.aptoide.p006pt.app.ReviewsService;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationManager;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationService;
import p005cm.aptoide.p006pt.app.view.AppCoinsInfoFragment;
import p005cm.aptoide.p006pt.app.view.AppCoinsInfoFragment_MembersInjector;
import p005cm.aptoide.p006pt.app.view.AppViewFragment;
import p005cm.aptoide.p006pt.app.view.AppViewFragment_MembersInjector;
import p005cm.aptoide.p006pt.app.view.AppViewNavigator;
import p005cm.aptoide.p006pt.app.view.AppViewPresenter;
import p005cm.aptoide.p006pt.app.view.MoreBundleFragment;
import p005cm.aptoide.p006pt.app.view.MoreBundleFragment_MembersInjector;
import p005cm.aptoide.p006pt.app.view.MoreBundleManager;
import p005cm.aptoide.p006pt.app.view.MoreBundlePresenter;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.app.view.donations.DonationsService;
import p005cm.aptoide.p006pt.app.view.donations.DonationsService.ServiceV8;
import p005cm.aptoide.p006pt.app.view.donations.WalletService;
import p005cm.aptoide.p006pt.app.view.donations.view.DonateDialogFragment;
import p005cm.aptoide.p006pt.app.view.donations.view.DonateDialogFragment_MembersInjector;
import p005cm.aptoide.p006pt.appview.PreferencesPersister;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateManager;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateRepository;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateService;
import p005cm.aptoide.p006pt.autoupdate.Service;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.billing.view.login.PaymentLoginFlavorPresenter;
import p005cm.aptoide.p006pt.billing.view.login.PaymentLoginFragment;
import p005cm.aptoide.p006pt.billing.view.login.PaymentLoginFragment_MembersInjector;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.blacklist.BlacklistPersistence;
import p005cm.aptoide.p006pt.blacklist.BlacklistUnitMapper;
import p005cm.aptoide.p006pt.blacklist.Blacklister;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity_MembersInjector;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationAnalytics;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.comments.view.CommentListFragment;
import p005cm.aptoide.p006pt.comments.view.CommentListFragment_MembersInjector;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.accessors.AppcMigrationAccessor;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.accessors.InstallationAccessor;
import p005cm.aptoide.p006pt.database.accessors.InstalledAccessor;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.accessors.UpdateAccessor;
import p005cm.aptoide.p006pt.dataprovider.NetworkOperatorManager;
import p005cm.aptoide.p006pt.dataprovider.cache.L2Cache;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.RequestBodyFactory;
import p005cm.aptoide.p006pt.download.AppValidationAnalytics;
import p005cm.aptoide.p006pt.download.AppValidator;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadApkPathsProvider;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.download.Md5Comparator;
import p005cm.aptoide.p006pt.download.OemidProvider;
import p005cm.aptoide.p006pt.downloadmanager.AppDownloaderProvider;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.downloadmanager.DownloadAppFileMapper;
import p005cm.aptoide.p006pt.downloadmanager.DownloadAppMapper;
import p005cm.aptoide.p006pt.downloadmanager.DownloadStatusMapper;
import p005cm.aptoide.p006pt.downloadmanager.DownloadsRepository;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloaderProvider;
import p005cm.aptoide.p006pt.downloadmanager.RetryFileDownloaderProvider;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p005cm.aptoide.p006pt.editorial.EditorialAnalytics;
import p005cm.aptoide.p006pt.editorial.EditorialFragment;
import p005cm.aptoide.p006pt.editorial.EditorialFragment_MembersInjector;
import p005cm.aptoide.p006pt.editorial.EditorialManager;
import p005cm.aptoide.p006pt.editorial.EditorialNavigator;
import p005cm.aptoide.p006pt.editorial.EditorialPresenter;
import p005cm.aptoide.p006pt.editorial.EditorialRepository;
import p005cm.aptoide.p006pt.editorial.EditorialService;
import p005cm.aptoide.p006pt.editorialList.EditorialListAnalytics;
import p005cm.aptoide.p006pt.editorialList.EditorialListFragment;
import p005cm.aptoide.p006pt.editorialList.EditorialListFragment_MembersInjector;
import p005cm.aptoide.p006pt.editorialList.EditorialListManager;
import p005cm.aptoide.p006pt.editorialList.EditorialListNavigator;
import p005cm.aptoide.p006pt.editorialList.EditorialListPresenter;
import p005cm.aptoide.p006pt.editorialList.EditorialListRepository;
import p005cm.aptoide.p006pt.editorialList.EditorialListService;
import p005cm.aptoide.p006pt.file.CacheHelper;
import p005cm.aptoide.p006pt.home.AdMapper;
import p005cm.aptoide.p006pt.home.BannerRepository;
import p005cm.aptoide.p006pt.home.BundleDataSource;
import p005cm.aptoide.p006pt.home.BundlesRepository;
import p005cm.aptoide.p006pt.home.BundlesResponseMapper;
import p005cm.aptoide.p006pt.home.ChipManager;
import p005cm.aptoide.p006pt.home.GetRewardAppCoinsAppsFragment;
import p005cm.aptoide.p006pt.home.GetRewardAppCoinsAppsFragment_MembersInjector;
import p005cm.aptoide.p006pt.home.Home;
import p005cm.aptoide.p006pt.home.HomeAnalytics;
import p005cm.aptoide.p006pt.home.HomeContainerFragment;
import p005cm.aptoide.p006pt.home.HomeContainerFragment_MembersInjector;
import p005cm.aptoide.p006pt.home.HomeContainerNavigator;
import p005cm.aptoide.p006pt.home.HomeContainerPresenter;
import p005cm.aptoide.p006pt.home.HomeFragment;
import p005cm.aptoide.p006pt.home.HomeFragment_MembersInjector;
import p005cm.aptoide.p006pt.home.HomeNavigator;
import p005cm.aptoide.p006pt.home.HomePresenter;
import p005cm.aptoide.p006pt.home.apps.AppMapper;
import p005cm.aptoide.p006pt.home.apps.AppsFragment;
import p005cm.aptoide.p006pt.home.apps.AppsFragment_MembersInjector;
import p005cm.aptoide.p006pt.home.apps.AppsManager;
import p005cm.aptoide.p006pt.home.apps.AppsNavigator;
import p005cm.aptoide.p006pt.home.apps.AppsPresenter;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcFragment;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcFragment_MembersInjector;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcManager;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcPresenter;
import p005cm.aptoide.p006pt.home.apps.UpdatesManager;
import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstallService;
import p005cm.aptoide.p006pt.install.InstallService_MembersInjector;
import p005cm.aptoide.p006pt.install.InstalledIntentService;
import p005cm.aptoide.p006pt.install.InstalledIntentService_MembersInjector;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.install.Installer;
import p005cm.aptoide.p006pt.install.InstallerAnalytics;
import p005cm.aptoide.p006pt.install.PackageInstallerManager;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p005cm.aptoide.p006pt.install.installer.InstallationProvider;
import p005cm.aptoide.p006pt.install.installer.RootInstallationRetryHandler;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator_MembersInjector;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.networking.MultipartBodyInterceptor;
import p005cm.aptoide.p006pt.notification.AppcPromotionNotificationStringProvider;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.notification.PullingContentService;
import p005cm.aptoide.p006pt.notification.PullingContentService_MembersInjector;
import p005cm.aptoide.p006pt.notification.RealmLocalNotificationSyncPersistence;
import p005cm.aptoide.p006pt.notification.sync.LocalNotificationSyncManager;
import p005cm.aptoide.p006pt.notification.view.InboxFragment;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.packageinstaller.AppInstaller;
import p005cm.aptoide.p006pt.permission.AccountPermissionProvider;
import p005cm.aptoide.p006pt.preferences.LocalPersistenceAdultContent;
import p005cm.aptoide.p006pt.preferences.Preferences;
import p005cm.aptoide.p006pt.preferences.SecurePreferences;
import p005cm.aptoide.p006pt.preferences.secure.SecureCoderDecoder;
import p005cm.aptoide.p006pt.presenter.LoginSignupCredentialsFlavorPresenter;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.promotions.CaptchaService;
import p005cm.aptoide.p006pt.promotions.CaptchaService.ServiceInterface;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionDialogFragment;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionDialogFragment_MembersInjector;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionDialogPresenter;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionsManager;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionsNavigator;
import p005cm.aptoide.p006pt.promotions.PromotionViewAppMapper;
import p005cm.aptoide.p006pt.promotions.PromotionsAnalytics;
import p005cm.aptoide.p006pt.promotions.PromotionsFragment;
import p005cm.aptoide.p006pt.promotions.PromotionsFragment_MembersInjector;
import p005cm.aptoide.p006pt.promotions.PromotionsManager;
import p005cm.aptoide.p006pt.promotions.PromotionsNavigator;
import p005cm.aptoide.p006pt.promotions.PromotionsPreferencesManager;
import p005cm.aptoide.p006pt.promotions.PromotionsPresenter;
import p005cm.aptoide.p006pt.promotions.PromotionsService;
import p005cm.aptoide.p006pt.reactions.ReactionsManager;
import p005cm.aptoide.p006pt.reactions.network.ReactionsRemoteService;
import p005cm.aptoide.p006pt.reactions.network.ReactionsService;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.repository.request.RewardAppCoinsAppsRepository;
import p005cm.aptoide.p006pt.reviews.LatestReviewsFragment;
import p005cm.aptoide.p006pt.reviews.LatestReviewsFragment_MembersInjector;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment_MembersInjector;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p005cm.aptoide.p006pt.search.SearchManager;
import p005cm.aptoide.p006pt.search.SearchNavigator;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionManager;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionRemoteRepository;
import p005cm.aptoide.p006pt.search.suggestions.TrendingManager;
import p005cm.aptoide.p006pt.search.suggestions.TrendingService;
import p005cm.aptoide.p006pt.search.view.SearchResultFragment;
import p005cm.aptoide.p006pt.search.view.SearchResultFragment_MembersInjector;
import p005cm.aptoide.p006pt.search.view.SearchResultPresenter;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenManager;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenNavigator;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.store.view.FragmentTopStores;
import p005cm.aptoide.p006pt.store.view.FragmentTopStores_MembersInjector;
import p005cm.aptoide.p006pt.store.view.ListStoresFragment;
import p005cm.aptoide.p006pt.store.view.ListStoresFragment_MembersInjector;
import p005cm.aptoide.p006pt.store.view.StoreFragment;
import p005cm.aptoide.p006pt.store.view.StoreFragment_MembersInjector;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment_MembersInjector;
import p005cm.aptoide.p006pt.store.view.StoreTabWidgetsGridRecyclerFragment;
import p005cm.aptoide.p006pt.store.view.StoreTabWidgetsGridRecyclerFragment_MembersInjector;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresFragment;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresFragment_MembersInjector;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresNavigator;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresPresenter;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresSubscribedFragment;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresSubscribedFragment_MembersInjector;
import p005cm.aptoide.p006pt.sync.SyncScheduler;
import p005cm.aptoide.p006pt.sync.alarm.SyncStorage;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowersFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowersFragment_MembersInjector;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowingFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowingFragment_MembersInjector;
import p005cm.aptoide.p006pt.toolbox.ToolboxContentProvider;
import p005cm.aptoide.p006pt.toolbox.ToolboxContentProvider_MembersInjector;
import p005cm.aptoide.p006pt.updates.UpdateRepository;
import p005cm.aptoide.p006pt.updates.UpdatesAnalytics;
import p005cm.aptoide.p006pt.util.ApkFy;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p005cm.aptoide.p006pt.view.ActivityComponent;
import p005cm.aptoide.p006pt.view.ActivityModule;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideAccountNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideAccountPermissionProviderFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideApkFyFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideAutoUpdateManagerFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideBottomNavigationMapperFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideBottomNavigationNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideDeepLinkManagerFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideFragmentManagerFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideImagePickerNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideListStoreAppsNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideLocalVersionCodeFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideMainFragmentNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideMainPresenterFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideManageStoreNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideManageUserNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideMyAccountNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidePackageNameFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidePhotoFileGeneratorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideScreenOrientationManagerFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideSplashScreenManagerFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideSplashScreenNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvideUriToPathResolverFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesAppCoinsInfoNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesAppNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesAppViewNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesAutoUpdateRepositoryFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesBottomNavigationAnalyticsFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesClaimPromotionsManagerFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesClaimPromotionsNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesDialogUtilsFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesDonationsAnalyticsFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesEditorialNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesPromotionsNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesRetrofitAptoideBiServiceFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesScreenHeightFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesScreenWidthFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesSearchNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesWalletInstallAnalyticsFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesWalletInstallConfigurationFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesWalletInstallManagerFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesWalletInstallNavigatorFactory;
import p005cm.aptoide.p006pt.view.ActivityModule_ProvidesWalletInstallPresenterFactory;
import p005cm.aptoide.p006pt.view.AppCoinsInfoNavigator;
import p005cm.aptoide.p006pt.view.AppCoinsInfoPresenter;
import p005cm.aptoide.p006pt.view.AppViewConfiguration;
import p005cm.aptoide.p006pt.view.BaseActivity;
import p005cm.aptoide.p006pt.view.BundleEvent;
import p005cm.aptoide.p006pt.view.C5218xf1dd651;
import p005cm.aptoide.p006pt.view.DeepLinkManager;
import p005cm.aptoide.p006pt.view.FragmentComponent;
import p005cm.aptoide.p006pt.view.FragmentModule;
import p005cm.aptoide.p006pt.view.FragmentModule_EditorialListAnalyticsFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvideAccountErrorMapperFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvideCreateUserErrorMapperFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvideHomeFragmentNavigatorFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvideImagePickerPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvideImageValidatorFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvideLoginSignUpPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvideManageStoreErrorMapperFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvideManageStorePresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvideManageUserPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvideSearchResultPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesAppCoinsInfoPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesAppMapperFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesAppViewConfigurationFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesAppViewManagerFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesAppViewPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesAppsManagerFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesAppsNavigatorFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesAppsPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesBundleEventFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesClaimPromotionDialogPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesEditorialAnalyticsFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesEditorialListManagerFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesEditorialListNavigatorFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesEditorialListPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesEditorialListRepositoryFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesEditorialManagerFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesEditorialPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesEditorialRepositoryFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesEditorialServiceFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesFlagManagerFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesFlagServiceFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesGetStoreManagerFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesGetStoreWidgetsPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesHomeAnalyticsFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesHomeContainerNavigatorFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesHomeContainerPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesHomeFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesHomeNavigatorFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesHomePresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesMyStoreNavigatorFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesMyStorePresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesPaymentLoginPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesPromotionsPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesSeeMoreAppcPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesSeeMoreManagerFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesSplashScreenPresenterFactory;
import p005cm.aptoide.p006pt.view.FragmentModule_ProvidesWizardPresenterFactory;
import p005cm.aptoide.p006pt.view.MainActivity;
import p005cm.aptoide.p006pt.view.MainActivity_MembersInjector;
import p005cm.aptoide.p006pt.view.ThemedActivityView_MembersInjector;
import p005cm.aptoide.p006pt.view.app.AppCenter;
import p005cm.aptoide.p006pt.view.app.AppCenterRepository;
import p005cm.aptoide.p006pt.view.app.AppService;
import p005cm.aptoide.p006pt.view.app.ListStoreAppsFragment;
import p005cm.aptoide.p006pt.view.app.ListStoreAppsFragment_MembersInjector;
import p005cm.aptoide.p006pt.view.app.ListStoreAppsNavigator;
import p005cm.aptoide.p006pt.view.dialog.DialogUtils;
import p005cm.aptoide.p006pt.view.fragment.DescriptionFragment;
import p005cm.aptoide.p006pt.view.fragment.DescriptionFragment_MembersInjector;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeWithToolbarFragment;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeWithToolbarFragment_MembersInjector;
import p005cm.aptoide.p006pt.view.settings.MyAccountFragment;
import p005cm.aptoide.p006pt.view.settings.MyAccountFragment_MembersInjector;
import p005cm.aptoide.p006pt.view.settings.MyAccountNavigator;
import p005cm.aptoide.p006pt.view.settings.SettingsFragment;
import p005cm.aptoide.p006pt.view.settings.SettingsFragment_MembersInjector;
import p005cm.aptoide.p006pt.view.settings.SupportEmailProvider;
import p005cm.aptoide.p006pt.view.splashscreen.SplashScreenFragment;
import p005cm.aptoide.p006pt.view.splashscreen.SplashScreenFragment_MembersInjector;
import p005cm.aptoide.p006pt.view.splashscreen.SplashScreenPresenter;
import p005cm.aptoide.p006pt.view.wizard.WizardFragment;
import p005cm.aptoide.p006pt.view.wizard.WizardFragmentProvider;
import p005cm.aptoide.p006pt.view.wizard.WizardFragment_MembersInjector;
import p005cm.aptoide.p006pt.view.wizard.WizardPageTwoFragment;
import p005cm.aptoide.p006pt.view.wizard.WizardPageTwoFragment_MembersInjector;
import p005cm.aptoide.p006pt.view.wizard.WizardPresenter;
import p005cm.aptoide.p006pt.wallet.WalletAppProvider;
import p005cm.aptoide.p006pt.wallet.WalletInstallActivity;
import p005cm.aptoide.p006pt.wallet.WalletInstallActivity_MembersInjector;
import p005cm.aptoide.p006pt.wallet.WalletInstallAnalytics;
import p005cm.aptoide.p006pt.wallet.WalletInstallConfiguration;
import p005cm.aptoide.p006pt.wallet.WalletInstallManager;
import p005cm.aptoide.p006pt.wallet.WalletInstallNavigator;
import p005cm.aptoide.p006pt.wallet.WalletInstallPresenter;
import p019d.p022i.p023b.C0099b;
import p024io.fabric.sdk.android.C13920f;
import p318e.p319a.C13180a;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.CallAdapter.Factory;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.DaggerApplicationComponent */
public final class DaggerApplicationComponent implements ApplicationComponent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Provider<DownloadApkPathsProvider> downloadApkPathsProvider;
    private Provider<DownloadStatusMapper> downloadStatusMapperProvider;
    private Provider<AccountAnalytics> provideAccountAnalyticsProvider;
    private Provider<AccountFactory> provideAccountFactoryProvider;
    private Provider<AccountManager> provideAccountManagerProvider;
    private Provider<AccountService> provideAccountServiceProvider;
    private Provider<BodyInterceptor<BaseBody>> provideAccountSettingsBodyInterceptorPoolV7Provider;
    private Provider<String> provideAccountTypeProvider;
    private Provider<AdsRepository> provideAdsRepositoryProvider;
    private Provider<AdultContentAnalytics> provideAdultContentAnalyticsProvider;
    private Provider<AdultContent> provideAdultContentProvider;
    private Provider<AnalyticsBodyInterceptorV7> provideAnalyticsBodyInterceptorV7Provider;
    private Provider<AndroidAccountProvider> provideAndroidAccountProvider;
    private Provider<C6378b> provideAnswersProvider;
    private Provider<String> provideApkPathProvider;
    private Provider<C6638q> provideAppEventsLoggerProvider;
    private Provider<AptoideAccountManager> provideAptoideAccountManagerProvider;
    private Provider<AptoideDownloadManager> provideAptoideDownloadManagerProvider;
    private Provider<Collection<String>> provideAptoideEventsProvider;
    private Provider<String> provideAptoidePackageProvider;
    private Provider<AuthenticationPersistence> provideAuthenticationPersistenceProvider;
    private Provider<String> provideAutoUpdateStoreNameProvider;
    private Provider<BodyInterceptor<BaseBody>> provideBodyInterceptorPoolV7Provider;
    private Provider<BodyInterceptor<BaseBody>> provideBodyInterceptorWebV7Provider;
    private Provider<CacheHelper> provideCacheHelperProvider;
    private Provider<String> provideCachePathProvider;
    private Provider<C6666i> provideCallbackManagerProvider;
    private Provider<ContentResolver> provideContentResolverProvider;
    private Provider<C0075a> provideCrashlyticsProvider;
    private Provider<Database> provideDatabaseProvider;
    private Provider<DeepLinkAnalytics> provideDeepLinkAnalyticsProvider;
    private Provider<List<String>> provideDefaultFollowedStoresProvider;
    private Provider<Installer> provideDefaultInstallerProvider;
    private Provider<Preferences> provideDefaultPreferencesProvider;
    private Provider<DownloadAccessor> provideDownloadAccessorProvider;
    private Provider<DownloadFactory> provideDownloadFactoryProvider;
    private Provider<DownloadsRepository> provideDownloadsRepositoryProvider;
    private Provider<String> provideExtraIDProvider;
    private Provider<Collection<String>> provideFabricEventsProvider;
    private Provider<C13920f> provideFabricProvider;
    private Provider<Collection<String>> provideFacebookEventsProvider;
    private Provider<Collection<String>> provideFlurryEventsProvider;
    private Provider<Map<Integer, Result>> provideFragmentNavigatorMapProvider;
    private Provider<C0099b<Map<Integer, Result>>> provideFragmentNavigatorRelayProvider;
    private Provider<GoogleApiClient> provideGoogleApiClientProvider;
    private Provider<String> provideHomePromotionsIdProvider;
    private Provider<IdsRepository> provideIdsRepositoryProvider;
    private Provider<InstallAnalytics> provideInstallAnalyticsProvider;
    private Provider<InstallationProvider> provideInstallationProvider;
    private Provider<InstalledAccessor> provideInstalledAccessorProvider;
    private Provider<InstalledRepository> provideInstalledRepositoryProvider;
    private Provider<InvalidRefreshTokenLogoutManager> provideInvalidRefreshTokenLogoutManagerProvider;
    private Provider<L2Cache> provideL2CacheProvider;
    private Provider<LocalPersistenceAdultContent> provideLocalAdultContentProvider;
    private Provider<LoginPreferences> provideLoginPreferencesProvider;
    private Provider<OkHttpClient> provideLongTimeoutOkHttpClientProvider;
    private Provider<String> provideMarketNameProvider;
    private Provider<MarketResourceFormatter> provideMarketResourceFormatterProvider;
    private Provider<MultipartBodyInterceptor> provideMultipartBodyInterceptorProvider;
    private Provider<NavigationTracker> provideNavigationTrackerProvider;
    private Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provideNoAuthenticationBodyInterceptorV3Provider;
    private Provider<ObjectMapper> provideNonNullObjectMapperProvider;
    private Provider<NotificationAnalytics> provideNotificationAnalyticsProvider;
    private Provider<OAuthModeProvider> provideOAuthModeProvider;
    private Provider<String> provideObbPathProvider;
    private Provider<OkHttpClient> provideOkHttpClientProvider;
    private Provider<PageViewsAnalytics> providePageViewsAnalyticsProvider;
    private Provider<String> providePartnerIDProvider;
    private Provider<PermissionManager> providePermissionManagerProvider;
    private Provider<PromotionsManager> providePromotionsManagerProvider;
    private Provider<QManager> provideQManagerProvider;
    private Provider<RequestBodyFactory> provideRequestBodyFactoryProvider;
    private Provider<Resources> provideResourcesProvider;
    private Provider<Interceptor> provideRetrofitLogInterceptorProvider;
    private Provider<RootAvailabilityManager> provideRootAvailabilityManagerProvider;
    private Provider<RootInstallationRetryHandler> provideRootInstallationRetryHandlerProvider;
    private Provider<String> provideSearchBaseUrlProvider;
    private Provider<SecureCoderDecoder> provideSecureCoderDecoderProvider;
    private Provider<StoreAccessor> provideStoreAccessorProvider;
    private Provider<StoreManager> provideStoreManagerProvider;
    private Provider<StoreRepository> provideStoreRepositoryProvider;
    private Provider<StoreUtilsProxy> provideStoreUtilsProxyProvider;
    private Provider<SyncScheduler> provideSyncSchedulerProvider;
    private Provider<SyncStorage> provideSyncStorageProvider;
    private Provider<TokenInvalidator> provideTokenInvalidatorProvider;
    private Provider<Interceptor> provideUserAgentInterceptorProvider;
    private Provider<Interceptor> provideUserAgentInterceptorV8Provider;
    private Provider<OkHttpClient> provideV8OkHttpClientProvider;
    private Provider<WindowManager> provideWindowManagerProvider;
    private Provider<Retrofit> providesABRetrofitProvider;
    private Provider<ABTestCenterRepository> providesABTestCenterRepositoryProvider;
    private Provider<ABTestManager> providesABTestManagerProvider;
    private Provider<ABTestService> providesABTestServiceProvider;
    private Provider<ServiceV7> providesABTestServiceV7Provider;
    private Provider<String> providesABTestingBaseHostProvider;
    private Provider<AbTestCacheValidator> providesAbTestCacheValidatorProvider;
    private Provider<HashMap<String, ExperimentModel>> providesAbTestLocalCacheProvider;
    private Provider<AdMapper> providesAdMapperProvider;
    private Provider<AdsApplicationVersionCodeProvider> providesAdsApplicationVersionCodeProvider;
    private Provider<AdsManager> providesAdsManagerProvider;
    private Provider<AnalyticsLogger> providesAnalyticsDebugLoggerProvider;
    private Provider<AnalyticsManager> providesAnalyticsManagerProvider;
    private Provider<AnalyticsEventParametersNormalizer> providesAnalyticsNormalizerProvider;
    private Provider<Retrofit> providesApiChainBDSRetrofitProvider;
    private Provider<String> providesApichainBdsBaseHostProvider;
    private Provider<AppCenter> providesAppCenterProvider;
    private Provider<AppCenterRepository> providesAppCenterRepositoryProvider;
    private Provider<AppCoinsManager> providesAppCoinsManagerProvider;
    private Provider<AppCoinsService> providesAppCoinsServiceProvider;
    private Provider<AppDownloaderProvider> providesAppDownloaderProvider;
    private Provider<AppInstaller> providesAppInstallerProvider;
    private Provider<AppInstallerStatusReceiver> providesAppInstallerStatusReceiverProvider;
    private Provider<AppService> providesAppServiceProvider;
    private Provider<AppShortcutsAnalytics> providesAppShortcutsAnalyticsProvider;
    private Provider<AppValidationAnalytics> providesAppValidationAnalyticsProvider;
    private Provider<AppValidator> providesAppValidatorProvider;
    private Provider<AppViewAnalytics> providesAppViewAnalyticsProvider;
    private Provider<AppcMigrationAccessor> providesAppcMigrationAccessorProvider;
    private Provider<AppcMigrationManager> providesAppcMigrationManagerProvider;
    private Provider<AppcMigrationService> providesAppcMigrationServiceProvider;
    private Provider<AptoideBiEventLogger> providesAptoideBILoggerProvider;
    private Provider<RetrofitAptoideBiService.ServiceV7> providesAptoideBiServiceProvider;
    private Provider<EventLogger> providesAptoideEventLoggerProvider;
    private Provider<SessionLogger> providesAptoideSessionLoggerProvider;
    private Provider<String> providesAptoideThemeProvider;
    private Provider<String> providesAutoUpdateBaseHostProvider;
    private Provider<Retrofit> providesAutoUpdateRetrofitProvider;
    private Provider<Service> providesAutoUpdateServiceProvider;
    private Provider<BannerRepository> providesBannerRepositoryProvider;
    private Provider<String> providesBaseHostProvider;
    private Provider<String> providesBaseSecondaryHostProvider;
    private Provider<BillingAnalytics> providesBillingAnalyticsProvider;
    private Provider<BlacklistManager> providesBlacklistManagerProvider;
    private Provider<BlacklistPersistence> providesBlacklistPersistenceProvider;
    private Provider<Blacklister> providesBlacklisterProvider;
    private Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> providesBodyInterceptorV3Provider;
    private Provider<BundlesRepository> providesBundleRepositoryProvider;
    private Provider<BlacklistUnitMapper> providesBundleToBlacklistUnitMapperProvider;
    private Provider<BundlesResponseMapper> providesBundlesMapperProvider;
    private Provider<Factory> providesCallAdapterFactoryProvider;
    private Provider<CampaignAnalytics> providesCampaignAnalyticsProvider;
    private Provider<ServiceInterface> providesCaptchaServiceInterfaceProvider;
    private Provider<CaptchaService> providesCaptchaServiceProvider;
    private Provider<CaptionBackgroundPainter> providesCaptionBackgroundPainterProvider;
    private Provider<ChipManager> providesChipManagerProvider;
    private Provider<ConnectivityManager> providesConnectivityManagerProvider;
    private Provider<Converter.Factory> providesConverterFactoryProvider;
    private Provider<CrashReport> providesCrashReportsProvider;
    private Provider<DecimalFormat> providesDecimalFormatProvider;
    private Provider<SharedPreferences> providesDefaultSharedPerefencesProvider;
    private Provider<Retrofit> providesDonationsRetrofitProvider;
    private Provider<DonationsService> providesDonationsServiceProvider;
    private Provider<ServiceV8> providesDonationsServiceV8Provider;
    private Provider<DownloadAnalytics> providesDownloadAnalyticsProvider;
    private Provider<DownloadAppFileMapper> providesDownloadAppFileMapperProvider;
    private Provider<DownloadAppMapper> providesDownloadAppMapperProvider;
    private Provider<DownloadStateParser> providesDownloadStateParserProvider;
    private Provider<EditorialService> providesEditorialServiceProvider;
    private Provider<EventsPersistence> providesEventsPersistenceProvider;
    private Provider<EventLogger> providesFabricEventLoggerProvider;
    private Provider<EventLogger> providesFacebookEventLoggerProvider;
    private Provider<FileDownloaderProvider> providesFileDownloaderProvider;
    private Provider<FirstLaunchAnalytics> providesFirstLaunchAnalyticsProvider;
    private Provider<EventLogger> providesFlurryEventLoggerProvider;
    private Provider<FlurryEventLogger> providesFlurryLoggerProvider;
    private Provider<SessionLogger> providesFlurrySessionLoggerProvider;
    private Provider<InstallManager> providesInstallManagerProvider;
    private Provider<InstallationAccessor> providesInstallationAccessorProvider;
    private Provider<InstallerAnalytics> providesInstallerAnalyticsProvider;
    private Provider<Retrofit> providesLoadTopReactionsRetrofitProvider;
    private Provider<LocalNotificationSyncManager> providesLocalNotificationSyncManagerProvider;
    private Provider<LoginSignupManager> providesLoginSignupManagerProvider;
    private Provider<Md5Comparator> providesMd5ComparatorProvider;
    private Provider<MoPubAdsManager> providesMoPubAdsManagerProvider;
    private Provider<AdsUserPropertyManager> providesMoPubAdsServiceProvider;
    private Provider<MoPubAnalytics> providesMoPubAnalyticsProvider;
    private Provider<MoPubBannerAdExperiment> providesMoPubBannerAdExperimentProvider;
    private Provider<MoPubConsentDialogView> providesMoPubConsentDialogViewProvider;
    private Provider<MoPubConsentManager> providesMoPubConsentManagerProvider;
    private Provider<MoPubInterstitialAdExperiment> providesMoPubInterstitialAdExperimentProvider;
    private Provider<MoPubNativeAdExperiment> providesMoPubNativeAdExperimentProvider;
    private Provider<MyAccountManager> providesMyAccountManagerProvider;
    private Provider<NetworkOperatorManager> providesNetworkOperatorManagerProvider;
    private Provider<NewsletterManager> providesNewsletterManagerProvider;
    private Provider<NotificationProvider> providesNotificationProvider;
    private Provider<OemidProvider> providesOemidProvider;
    private Provider<PackageInstallerManager> providesPackageInstallerManagerProvider;
    private Provider<PackageRepository> providesPackageRepositoryProvider;
    private Provider<PromotionViewAppMapper> providesPromotionViewAppMapperProvider;
    private Provider<PromotionsAnalytics> providesPromotionsAnalyticsProvider;
    private Provider<PromotionsPreferencesManager> providesPromotionsPreferencesManagerProvider;
    private Provider<PromotionsService> providesPromotionsServiceProvider;
    private Provider<String> providesReactionsHostProvider;
    private Provider<ReactionsManager> providesReactionsManagerProvider;
    private Provider<ReactionsService> providesReactionsServiceProvider;
    private Provider<ReactionsRemoteService.ServiceV8> providesReactionsServiceV8Provider;
    private Provider<RealmEventMapper> providesRealmEventMapperProvider;
    private Provider<RealmExperimentPersistence> providesRealmExperimentPersistenceProvider;
    private Provider<RealmLocalNotificationSyncPersistence> providesRealmLocalNotificationSyncPersistenceProvider;
    private Provider<BundleDataSource> providesRemoteBundleDataSourceProvider;
    private Provider<AptoideBiEventService> providesRetrofitAptoideBiServiceProvider;
    private Provider<RetryFileDownloaderProvider> providesRetryFileDownloaderProvider;
    private Provider<ReviewsManager> providesReviewsManagerProvider;
    private Provider<ReviewsRepository> providesReviewsRepositoryProvider;
    private Provider<ReviewsService> providesReviewsServiceProvider;
    private Provider<RewardAppCoinsAppsRepository> providesRewardAppCoinsAppsRepositoryProvider;
    private Provider<SafetyNetClient> providesSafetyNetClientProvider;
    private Provider<SearchAnalytics> providesSearchAnalyticsProvider;
    private Provider<SearchManager> providesSearchManagerProvider;
    private Provider<SearchSuggestionManager> providesSearchSuggestionManagerProvider;
    private Provider<SearchSuggestionRemoteRepository> providesSearchSuggestionRemoteRepositoryProvider;
    private Provider<Retrofit> providesSearchSuggestionsRetrofitProvider;
    private Provider<SecurePreferences> providesSecurePerefencesProvider;
    private Provider<SharedPreferences> providesSecureSharedPreferencesProvider;
    private Provider<SettingsManager> providesSettingsManagerProvider;
    private Provider<AptoideShortcutManager> providesShortcutManagerProvider;
    private Provider<StoreAnalytics> providesStoreAnalyticsProvider;
    private Provider<StoreCredentialsProvider> providesStoreCredentialsProvider;
    private Provider<String> providesSupportEmailProvider;
    private Provider<SupportEmailProvider> providesSupportEmailProvider2;
    private Provider<TelephonyManager> providesTelephonyManagerProvider;
    private Provider<TrendingManager> providesTrendingManagerProvider;
    private Provider<TrendingService> providesTrendingServiceProvider;
    private Provider<UpdateAccessor> providesUpdateAccessorProvider;
    private Provider<UpdateRepository> providesUpdateRepositoryProvider;
    private Provider<UpdatesAnalytics> providesUpdatesAnalyticsProvider;
    private Provider<UpdatesManager> providesUpdatesManagerProvider;
    private Provider<PreferencesPersister> providesUserPreferencesPersisterProvider;
    private Provider<Retrofit> providesV7RetrofitProvider;
    private Provider<Retrofit> providesV7SecondaryRetrofitProvider;
    private Provider<WalletAdsOfferCardManager> providesWalletAdsOfferCardManagerProvider;
    private Provider<WalletAdsOfferManager> providesWalletAdsOfferManagerProvider;
    private Provider<WalletAdsOfferService> providesWalletAdsOfferServiceProvider;
    private Provider<WalletAppProvider> providesWalletAppProvider;
    private Provider<WalletService> providesWalletServiceProvider;
    private Provider<WalletService.ServiceV7> providesWalletServiceV8Provider;
    private Provider<HttpKnockEventLogger> providesknockEventLoggerProvider;

    /* renamed from: cm.aptoide.pt.DaggerApplicationComponent$Builder */
    public static final class Builder {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private ApplicationModule applicationModule;
        private FlavourApplicationModule flavourApplicationModule;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8103609416717545978L, "cm/aptoide/pt/DaggerApplicationComponent$Builder", 13);
            $jacocoData = probes;
            return probes;
        }

        /* synthetic */ Builder(C00371 x0) {
            boolean[] $jacocoInit = $jacocoInit();
            this();
            $jacocoInit[10] = true;
        }

        static /* synthetic */ ApplicationModule access$100(Builder x0) {
            boolean[] $jacocoInit = $jacocoInit();
            ApplicationModule applicationModule2 = x0.applicationModule;
            $jacocoInit[11] = true;
            return applicationModule2;
        }

        static /* synthetic */ FlavourApplicationModule access$200(Builder x0) {
            boolean[] $jacocoInit = $jacocoInit();
            FlavourApplicationModule flavourApplicationModule2 = x0.flavourApplicationModule;
            $jacocoInit[12] = true;
            return flavourApplicationModule2;
        }

        private Builder() {
            $jacocoInit()[0] = true;
        }

        public ApplicationComponent build() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = " must be set";
            if (this.applicationModule == null) {
                $jacocoInit[1] = true;
                StringBuilder sb = new StringBuilder();
                $jacocoInit[2] = true;
                sb.append(ApplicationModule.class.getCanonicalName());
                sb.append(str);
                IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                $jacocoInit[3] = true;
                throw illegalStateException;
            } else if (this.flavourApplicationModule != null) {
                DaggerApplicationComponent daggerApplicationComponent = new DaggerApplicationComponent(this, null);
                $jacocoInit[7] = true;
                return daggerApplicationComponent;
            } else {
                $jacocoInit[4] = true;
                StringBuilder sb2 = new StringBuilder();
                $jacocoInit[5] = true;
                sb2.append(FlavourApplicationModule.class.getCanonicalName());
                sb2.append(str);
                IllegalStateException illegalStateException2 = new IllegalStateException(sb2.toString());
                $jacocoInit[6] = true;
                throw illegalStateException2;
            }
        }

        public Builder applicationModule(ApplicationModule applicationModule2) {
            boolean[] $jacocoInit = $jacocoInit();
            C13182c.m43110a(applicationModule2);
            this.applicationModule = applicationModule2;
            $jacocoInit[8] = true;
            return this;
        }

        public Builder flavourApplicationModule(FlavourApplicationModule flavourApplicationModule2) {
            boolean[] $jacocoInit = $jacocoInit();
            C13182c.m43110a(flavourApplicationModule2);
            this.flavourApplicationModule = flavourApplicationModule2;
            $jacocoInit[9] = true;
            return this;
        }
    }

    /* renamed from: cm.aptoide.pt.DaggerApplicationComponent$1 */
    static /* synthetic */ class C00371 {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-65993164438639767L, "cm/aptoide/pt/DaggerApplicationComponent$1", 0);
            $jacocoData = probes;
            return probes;
        }
    }

    /* renamed from: cm.aptoide.pt.DaggerApplicationComponent$ActivityComponentImpl */
    private final class ActivityComponentImpl implements ActivityComponent {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final ActivityModule activityModule;
        private final FlavourActivityModule flavourActivityModule;
        private Provider<AccountNavigator> provideAccountNavigatorProvider;
        private Provider<AccountPermissionProvider> provideAccountPermissionProvider;
        private Provider<ApkFy> provideApkFyProvider;
        private Provider<AutoUpdateManager> provideAutoUpdateManagerProvider;
        private Provider<BottomNavigationMapper> provideBottomNavigationMapperProvider;
        private Provider<BottomNavigationNavigator> provideBottomNavigationNavigatorProvider;
        private Provider<DeepLinkManager> provideDeepLinkManagerProvider;
        private Provider<C0486t> provideFragmentManagerProvider;
        private Provider<ImagePickerNavigator> provideImagePickerNavigatorProvider;
        private Provider<ListStoreAppsNavigator> provideListStoreAppsNavigatorProvider;
        private Provider<Integer> provideLocalVersionCodeProvider;
        private Provider<FragmentNavigator> provideMainFragmentNavigatorProvider;
        private Provider<Presenter> provideMainPresenterProvider;
        private Provider<ManageStoreNavigator> provideManageStoreNavigatorProvider;
        private Provider<ManageUserNavigator> provideManageUserNavigatorProvider;
        private Provider<MyAccountNavigator> provideMyAccountNavigatorProvider;
        private Provider<String> providePackageNameProvider;
        private Provider<PhotoFileGenerator> providePhotoFileGeneratorProvider;
        private Provider<ScreenOrientationManager> provideScreenOrientationManagerProvider;
        private Provider<SplashScreenManager> provideSplashScreenManagerProvider;
        private Provider<SplashScreenNavigator> provideSplashScreenNavigatorProvider;
        private Provider<UriToPathResolver> provideUriToPathResolverProvider;
        private Provider<AppCoinsInfoNavigator> providesAppCoinsInfoNavigatorProvider;
        private Provider<AppNavigator> providesAppNavigatorProvider;
        private Provider<AppViewNavigator> providesAppViewNavigatorProvider;
        private Provider<AutoUpdateRepository> providesAutoUpdateRepositoryProvider;
        private Provider<BottomNavigationAnalytics> providesBottomNavigationAnalyticsProvider;
        private Provider<ClaimPromotionsManager> providesClaimPromotionsManagerProvider;
        private Provider<ClaimPromotionsNavigator> providesClaimPromotionsNavigatorProvider;
        private Provider<DialogUtils> providesDialogUtilsProvider;
        private Provider<DonationsAnalytics> providesDonationsAnalyticsProvider;
        private Provider<EditorialNavigator> providesEditorialNavigatorProvider;
        private Provider<PromotionsNavigator> providesPromotionsNavigatorProvider;
        private Provider<AutoUpdateService> providesRetrofitAptoideBiServiceProvider;
        private Provider<Float> providesScreenHeightProvider;
        private Provider<Float> providesScreenWidthProvider;
        private Provider<SearchNavigator> providesSearchNavigatorProvider;
        private Provider<WalletInstallAnalytics> providesWalletInstallAnalyticsProvider;
        private Provider<WalletInstallConfiguration> providesWalletInstallConfigurationProvider;
        private Provider<WalletInstallManager> providesWalletInstallManagerProvider;
        private Provider<WalletInstallNavigator> providesWalletInstallNavigatorProvider;
        private Provider<WalletInstallPresenter> providesWalletInstallPresenterProvider;
        final /* synthetic */ DaggerApplicationComponent this$0;

        /* renamed from: cm.aptoide.pt.DaggerApplicationComponent$ActivityComponentImpl$FragmentComponentImpl */
        private final class FragmentComponentImpl implements FragmentComponent {
            private static transient /* synthetic */ boolean[] $jacocoData;
            private Provider<EditorialListAnalytics> editorialListAnalyticsProvider;
            private final FlavourFragmentModule flavourFragmentModule;
            private final FragmentModule fragmentModule;
            private Provider<AccountErrorMapper> provideAccountErrorMapperProvider;
            private Provider<CreateUserErrorMapper> provideCreateUserErrorMapperProvider;
            private Provider<FragmentNavigator> provideHomeFragmentNavigatorProvider;
            private Provider<ImagePickerPresenter> provideImagePickerPresenterProvider;
            private Provider<ImageValidator> provideImageValidatorProvider;
            private Provider<LoginSignupCredentialsFlavorPresenter> provideLoginSignUpPresenterProvider;
            private Provider<ManageStoreErrorMapper> provideManageStoreErrorMapperProvider;
            private Provider<ManageStorePresenter> provideManageStorePresenterProvider;
            private Provider<ManageUserPresenter> provideManageUserPresenterProvider;
            private Provider<SearchResultPresenter> provideSearchResultPresenterProvider;
            private Provider<AppCoinsInfoPresenter> providesAppCoinsInfoPresenterProvider;
            private Provider<AppMapper> providesAppMapperProvider;
            private Provider<AppViewConfiguration> providesAppViewConfigurationProvider;
            private Provider<AppViewManager> providesAppViewManagerProvider;
            private Provider<AppViewPresenter> providesAppViewPresenterProvider;
            private Provider<AppcPromotionNotificationStringProvider> providesAppcPromotionNotificationStringProvider;
            private Provider<AppsManager> providesAppsManagerProvider;
            private Provider<AppsNavigator> providesAppsNavigatorProvider;
            private Provider<AppsPresenter> providesAppsPresenterProvider;
            private Provider<BundleEvent> providesBundleEventProvider;
            private Provider<ClaimPromotionDialogPresenter> providesClaimPromotionDialogPresenterProvider;
            private Provider<EditorialAnalytics> providesEditorialAnalyticsProvider;
            private Provider<EditorialListManager> providesEditorialListManagerProvider;
            private Provider<EditorialListNavigator> providesEditorialListNavigatorProvider;
            private Provider<EditorialListPresenter> providesEditorialListPresenterProvider;
            private Provider<EditorialListRepository> providesEditorialListRepositoryProvider;
            private Provider<EditorialManager> providesEditorialManagerProvider;
            private Provider<EditorialPresenter> providesEditorialPresenterProvider;
            private Provider<EditorialRepository> providesEditorialRepositoryProvider;
            private Provider<EditorialListService> providesEditorialServiceProvider;
            private Provider<FlagManager> providesFlagManagerProvider;
            private Provider<FlagService> providesFlagServiceProvider;
            private Provider<MoreBundleManager> providesGetStoreManagerProvider;
            private Provider<MoreBundlePresenter> providesGetStoreWidgetsPresenterProvider;
            private Provider<HomeAnalytics> providesHomeAnalyticsProvider;
            private Provider<HomeContainerNavigator> providesHomeContainerNavigatorProvider;
            private Provider<HomeContainerPresenter> providesHomeContainerPresenterProvider;
            private Provider<HomeNavigator> providesHomeNavigatorProvider;
            private Provider<HomePresenter> providesHomePresenterProvider;
            private Provider<Home> providesHomeProvider;
            private Provider<MyStoresNavigator> providesMyStoreNavigatorProvider;
            private Provider<MyStoresPresenter> providesMyStorePresenterProvider;
            private Provider<PaymentLoginFlavorPresenter> providesPaymentLoginPresenterProvider;
            private Provider<PromotionsPresenter> providesPromotionsPresenterProvider;
            private Provider<SeeMoreAppcPresenter> providesSeeMoreAppcPresenterProvider;
            private Provider<SeeMoreAppcManager> providesSeeMoreManagerProvider;
            private Provider<SplashScreenPresenter> providesSplashScreenPresenterProvider;
            private Provider<WizardFragmentProvider> providesWizardFragmentProvider;
            private Provider<WizardPresenter> providesWizardPresenterProvider;
            final /* synthetic */ ActivityComponentImpl this$1;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(7865535513605289418L, "cm/aptoide/pt/DaggerApplicationComponent$ActivityComponentImpl$FragmentComponentImpl", 553);
                $jacocoData = probes;
                return probes;
            }

            /* synthetic */ FragmentComponentImpl(ActivityComponentImpl x0, FragmentModule x1, FlavourFragmentModule x2, C00371 x3) {
                boolean[] $jacocoInit = $jacocoInit();
                this(x0, x1, x2);
                $jacocoInit[552] = true;
            }

            private FragmentComponentImpl(ActivityComponentImpl activityComponentImpl, FragmentModule fragmentModule2, FlavourFragmentModule flavourFragmentModule2) {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$1 = activityComponentImpl;
                $jacocoInit[0] = true;
                C13182c.m43110a(fragmentModule2);
                this.fragmentModule = fragmentModule2;
                $jacocoInit[1] = true;
                C13182c.m43110a(flavourFragmentModule2);
                this.flavourFragmentModule = flavourFragmentModule2;
                $jacocoInit[2] = true;
                initialize();
                $jacocoInit[3] = true;
            }

            private void initialize() {
                boolean[] $jacocoInit = $jacocoInit();
                FragmentModule fragmentModule2 = this.fragmentModule;
                $jacocoInit[4] = true;
                C13181b create = FragmentModule_ProvideAccountErrorMapperFactory.create(fragmentModule2);
                $jacocoInit[5] = true;
                this.provideAccountErrorMapperProvider = C13180a.m43109a(create);
                FragmentModule fragmentModule3 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[6] = true;
                Provider access$1100 = DaggerApplicationComponent.access$1100(daggerApplicationComponent);
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[7] = true;
                Provider access$5200 = ActivityComponentImpl.access$5200(activityComponentImpl);
                Provider<AccountErrorMapper> provider = this.provideAccountErrorMapperProvider;
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[8] = true;
                Provider access$1400 = DaggerApplicationComponent.access$1400(daggerApplicationComponent2);
                $jacocoInit[9] = true;
                C13181b create2 = FragmentModule_ProvideLoginSignUpPresenterFactory.create(fragmentModule3, access$1100, access$5200, provider, access$1400);
                $jacocoInit[10] = true;
                this.provideLoginSignUpPresenterProvider = C13180a.m43109a(create2);
                FragmentModule fragmentModule4 = this.fragmentModule;
                $jacocoInit[11] = true;
                C13181b create3 = FragmentModule_ProvideImageValidatorFactory.create(fragmentModule4);
                $jacocoInit[12] = true;
                this.provideImageValidatorProvider = C13180a.m43109a(create3);
                FragmentModule fragmentModule5 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl2 = this.this$1;
                $jacocoInit[13] = true;
                Provider access$5300 = ActivityComponentImpl.access$5300(activityComponentImpl2);
                ActivityComponentImpl activityComponentImpl3 = this.this$1;
                $jacocoInit[14] = true;
                Provider access$5400 = ActivityComponentImpl.access$5400(activityComponentImpl3);
                Provider<ImageValidator> provider2 = this.provideImageValidatorProvider;
                ActivityComponentImpl activityComponentImpl4 = this.this$1;
                $jacocoInit[15] = true;
                Provider access$5500 = ActivityComponentImpl.access$5500(activityComponentImpl4);
                ActivityComponentImpl activityComponentImpl5 = this.this$1;
                $jacocoInit[16] = true;
                Provider access$5600 = ActivityComponentImpl.access$5600(activityComponentImpl5);
                $jacocoInit[17] = true;
                C13181b create4 = FragmentModule_ProvideImagePickerPresenterFactory.create(fragmentModule5, access$5300, access$5400, provider2, access$5500, access$5600);
                $jacocoInit[18] = true;
                this.provideImagePickerPresenterProvider = C13180a.m43109a(create4);
                FragmentModule fragmentModule6 = this.fragmentModule;
                Provider<AccountErrorMapper> provider3 = this.provideAccountErrorMapperProvider;
                $jacocoInit[19] = true;
                C13181b create5 = FragmentModule_ProvideCreateUserErrorMapperFactory.create(fragmentModule6, provider3);
                $jacocoInit[20] = true;
                this.provideCreateUserErrorMapperProvider = C13180a.m43109a(create5);
                FragmentModule fragmentModule7 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[21] = true;
                Provider access$11002 = DaggerApplicationComponent.access$1100(daggerApplicationComponent3);
                Provider<CreateUserErrorMapper> provider4 = this.provideCreateUserErrorMapperProvider;
                ActivityComponentImpl activityComponentImpl6 = this.this$1;
                $jacocoInit[22] = true;
                Provider access$5700 = ActivityComponentImpl.access$5700(activityComponentImpl6);
                ActivityComponentImpl activityComponentImpl7 = this.this$1;
                $jacocoInit[23] = true;
                Provider access$55002 = ActivityComponentImpl.access$5500(activityComponentImpl7);
                DaggerApplicationComponent daggerApplicationComponent4 = this.this$1.this$0;
                $jacocoInit[24] = true;
                Provider access$14002 = DaggerApplicationComponent.access$1400(daggerApplicationComponent4);
                $jacocoInit[25] = true;
                C13181b create6 = FragmentModule_ProvideManageUserPresenterFactory.create(fragmentModule7, access$11002, provider4, access$5700, access$55002, access$14002);
                $jacocoInit[26] = true;
                this.provideManageUserPresenterProvider = C13180a.m43109a(create6);
                FragmentModule fragmentModule8 = this.fragmentModule;
                $jacocoInit[27] = true;
                C13181b create7 = FragmentModule_ProvideManageStoreErrorMapperFactory.create(fragmentModule8);
                $jacocoInit[28] = true;
                this.provideManageStoreErrorMapperProvider = C13180a.m43109a(create7);
                FragmentModule fragmentModule9 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl8 = this.this$1;
                $jacocoInit[29] = true;
                Provider access$55003 = ActivityComponentImpl.access$5500(activityComponentImpl8);
                ActivityComponentImpl activityComponentImpl9 = this.this$1;
                $jacocoInit[30] = true;
                Provider access$5800 = ActivityComponentImpl.access$5800(activityComponentImpl9);
                Provider<ManageStoreErrorMapper> provider5 = this.provideManageStoreErrorMapperProvider;
                DaggerApplicationComponent daggerApplicationComponent5 = this.this$1.this$0;
                $jacocoInit[31] = true;
                Provider access$11003 = DaggerApplicationComponent.access$1100(daggerApplicationComponent5);
                DaggerApplicationComponent daggerApplicationComponent6 = this.this$1.this$0;
                $jacocoInit[32] = true;
                Provider access$14003 = DaggerApplicationComponent.access$1400(daggerApplicationComponent6);
                $jacocoInit[33] = true;
                C13181b create8 = FragmentModule_ProvideManageStorePresenterFactory.create(fragmentModule9, access$55003, access$5800, provider5, access$11003, access$14003);
                $jacocoInit[34] = true;
                this.provideManageStorePresenterProvider = C13180a.m43109a(create8);
                FragmentModule fragmentModule10 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent7 = this.this$1.this$0;
                $jacocoInit[35] = true;
                Provider access$900 = DaggerApplicationComponent.access$900(daggerApplicationComponent7);
                ActivityComponentImpl activityComponentImpl10 = this.this$1;
                $jacocoInit[36] = true;
                Provider access$5900 = ActivityComponentImpl.access$5900(activityComponentImpl10);
                DaggerApplicationComponent daggerApplicationComponent8 = this.this$1.this$0;
                $jacocoInit[37] = true;
                Provider access$6000 = DaggerApplicationComponent.access$6000(daggerApplicationComponent8);
                DaggerApplicationComponent daggerApplicationComponent9 = this.this$1.this$0;
                $jacocoInit[38] = true;
                Provider access$6100 = DaggerApplicationComponent.access$6100(daggerApplicationComponent9);
                DaggerApplicationComponent daggerApplicationComponent10 = this.this$1.this$0;
                $jacocoInit[39] = true;
                Provider access$6200 = DaggerApplicationComponent.access$6200(daggerApplicationComponent10);
                ActivityComponentImpl activityComponentImpl11 = this.this$1;
                $jacocoInit[40] = true;
                Provider access$6300 = ActivityComponentImpl.access$6300(activityComponentImpl11);
                $jacocoInit[41] = true;
                C13181b create9 = FragmentModule_ProvideSearchResultPresenterFactory.create(fragmentModule10, access$900, access$5900, access$6000, access$6100, access$6200, access$6300);
                $jacocoInit[42] = true;
                this.provideSearchResultPresenterProvider = C13180a.m43109a(create9);
                FragmentModule fragmentModule11 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl12 = this.this$1;
                $jacocoInit[43] = true;
                Provider access$6400 = ActivityComponentImpl.access$6400(activityComponentImpl12);
                ActivityComponentImpl activityComponentImpl13 = this.this$1;
                $jacocoInit[44] = true;
                Provider access$63002 = ActivityComponentImpl.access$6300(activityComponentImpl13);
                $jacocoInit[45] = true;
                C13181b create10 = FragmentModule_ProvidesMyStoreNavigatorFactory.create(fragmentModule11, access$6400, access$63002);
                $jacocoInit[46] = true;
                this.providesMyStoreNavigatorProvider = C13180a.m43109a(create10);
                FragmentModule fragmentModule12 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent11 = this.this$1.this$0;
                $jacocoInit[47] = true;
                Provider access$11004 = DaggerApplicationComponent.access$1100(daggerApplicationComponent11);
                Provider<MyStoresNavigator> provider6 = this.providesMyStoreNavigatorProvider;
                $jacocoInit[48] = true;
                C13181b create11 = FragmentModule_ProvidesMyStorePresenterFactory.create(fragmentModule12, access$11004, provider6);
                $jacocoInit[49] = true;
                this.providesMyStorePresenterProvider = C13180a.m43109a(create11);
                FragmentModule fragmentModule13 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent12 = this.this$1.this$0;
                $jacocoInit[50] = true;
                Provider access$6500 = DaggerApplicationComponent.access$6500(daggerApplicationComponent12);
                DaggerApplicationComponent daggerApplicationComponent13 = this.this$1.this$0;
                $jacocoInit[51] = true;
                Provider access$4700 = DaggerApplicationComponent.access$4700(daggerApplicationComponent13);
                DaggerApplicationComponent daggerApplicationComponent14 = this.this$1.this$0;
                $jacocoInit[52] = true;
                Provider access$6600 = DaggerApplicationComponent.access$6600(daggerApplicationComponent14);
                DaggerApplicationComponent daggerApplicationComponent15 = this.this$1.this$0;
                $jacocoInit[53] = true;
                Provider access$6700 = DaggerApplicationComponent.access$6700(daggerApplicationComponent15);
                DaggerApplicationComponent daggerApplicationComponent16 = this.this$1.this$0;
                $jacocoInit[54] = true;
                Provider access$3500 = DaggerApplicationComponent.access$3500(daggerApplicationComponent16);
                DaggerApplicationComponent daggerApplicationComponent17 = this.this$1.this$0;
                $jacocoInit[55] = true;
                Provider access$6800 = DaggerApplicationComponent.access$6800(daggerApplicationComponent17);
                DaggerApplicationComponent daggerApplicationComponent18 = this.this$1.this$0;
                $jacocoInit[56] = true;
                Provider access$6900 = DaggerApplicationComponent.access$6900(daggerApplicationComponent18);
                DaggerApplicationComponent daggerApplicationComponent19 = this.this$1.this$0;
                $jacocoInit[57] = true;
                Provider access$7000 = DaggerApplicationComponent.access$7000(daggerApplicationComponent19);
                $jacocoInit[58] = true;
                C13181b create12 = FragmentModule_ProvidesHomeFactory.create(fragmentModule13, access$6500, access$4700, access$6600, access$6700, access$3500, access$6800, access$6900, access$7000);
                $jacocoInit[59] = true;
                this.providesHomeProvider = C13180a.m43109a(create12);
                FragmentModule fragmentModule14 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl14 = this.this$1;
                $jacocoInit[60] = true;
                Provider access$64002 = ActivityComponentImpl.access$6400(activityComponentImpl14);
                ActivityComponentImpl activityComponentImpl15 = this.this$1;
                $jacocoInit[61] = true;
                Provider access$63003 = ActivityComponentImpl.access$6300(activityComponentImpl15);
                ActivityComponentImpl activityComponentImpl16 = this.this$1;
                $jacocoInit[62] = true;
                Provider access$7100 = ActivityComponentImpl.access$7100(activityComponentImpl16);
                DaggerApplicationComponent daggerApplicationComponent20 = this.this$1.this$0;
                $jacocoInit[63] = true;
                Provider access$1000 = DaggerApplicationComponent.access$1000(daggerApplicationComponent20);
                ActivityComponentImpl activityComponentImpl17 = this.this$1;
                $jacocoInit[64] = true;
                Provider access$52002 = ActivityComponentImpl.access$5200(activityComponentImpl17);
                $jacocoInit[65] = true;
                C13181b create13 = FragmentModule_ProvidesHomeNavigatorFactory.create(fragmentModule14, access$64002, access$63003, access$7100, access$1000, access$52002);
                $jacocoInit[66] = true;
                this.providesHomeNavigatorProvider = C13180a.m43109a(create13);
                FragmentModule fragmentModule15 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent21 = this.this$1.this$0;
                $jacocoInit[67] = true;
                Provider access$700 = DaggerApplicationComponent.access$700(daggerApplicationComponent21);
                DaggerApplicationComponent daggerApplicationComponent22 = this.this$1.this$0;
                $jacocoInit[68] = true;
                Provider access$800 = DaggerApplicationComponent.access$800(daggerApplicationComponent22);
                $jacocoInit[69] = true;
                C13181b create14 = FragmentModule_ProvidesHomeAnalyticsFactory.create(fragmentModule15, access$700, access$800);
                $jacocoInit[70] = true;
                this.providesHomeAnalyticsProvider = C13180a.m43109a(create14);
                FragmentModule fragmentModule16 = this.fragmentModule;
                Provider<Home> provider7 = this.providesHomeProvider;
                Provider<HomeNavigator> provider8 = this.providesHomeNavigatorProvider;
                DaggerApplicationComponent daggerApplicationComponent23 = this.this$1.this$0;
                $jacocoInit[71] = true;
                Provider access$7200 = DaggerApplicationComponent.access$7200(daggerApplicationComponent23);
                DaggerApplicationComponent daggerApplicationComponent24 = this.this$1.this$0;
                $jacocoInit[72] = true;
                Provider access$11005 = DaggerApplicationComponent.access$1100(daggerApplicationComponent24);
                Provider<HomeAnalytics> provider9 = this.providesHomeAnalyticsProvider;
                $jacocoInit[73] = true;
                C13181b create15 = FragmentModule_ProvidesHomePresenterFactory.create(fragmentModule16, provider7, provider8, access$7200, access$11005, provider9);
                $jacocoInit[74] = true;
                this.providesHomePresenterProvider = C13180a.m43109a(create15);
                FragmentModule fragmentModule17 = this.fragmentModule;
                $jacocoInit[75] = true;
                this.providesAppMapperProvider = C13180a.m43109a(FragmentModule_ProvidesAppMapperFactory.create(fragmentModule17));
                FragmentModule fragmentModule18 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent25 = this.this$1.this$0;
                $jacocoInit[76] = true;
                Provider access$3200 = DaggerApplicationComponent.access$3200(daggerApplicationComponent25);
                DaggerApplicationComponent daggerApplicationComponent26 = this.this$1.this$0;
                $jacocoInit[77] = true;
                Provider access$2900 = DaggerApplicationComponent.access$2900(daggerApplicationComponent26);
                Provider<AppMapper> provider10 = this.providesAppMapperProvider;
                DaggerApplicationComponent daggerApplicationComponent27 = this.this$1.this$0;
                $jacocoInit[78] = true;
                Provider access$3000 = DaggerApplicationComponent.access$3000(daggerApplicationComponent27);
                DaggerApplicationComponent daggerApplicationComponent28 = this.this$1.this$0;
                $jacocoInit[79] = true;
                Provider access$3300 = DaggerApplicationComponent.access$3300(daggerApplicationComponent28);
                DaggerApplicationComponent daggerApplicationComponent29 = this.this$1.this$0;
                $jacocoInit[80] = true;
                Provider access$7300 = DaggerApplicationComponent.access$7300(daggerApplicationComponent29);
                DaggerApplicationComponent daggerApplicationComponent30 = this.this$1.this$0;
                $jacocoInit[81] = true;
                Provider access$2700 = DaggerApplicationComponent.access$2700(daggerApplicationComponent30);
                DaggerApplicationComponent daggerApplicationComponent31 = this.this$1.this$0;
                $jacocoInit[82] = true;
                Provider access$35002 = DaggerApplicationComponent.access$3500(daggerApplicationComponent31);
                $jacocoInit[83] = true;
                C13181b create16 = FragmentModule_ProvidesAppsManagerFactory.create(fragmentModule18, access$3200, access$2900, provider10, access$3000, access$3300, access$7300, access$2700, access$35002);
                $jacocoInit[84] = true;
                this.providesAppsManagerProvider = C13180a.m43109a(create16);
                FragmentModule fragmentModule19 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl18 = this.this$1;
                $jacocoInit[85] = true;
                Provider access$64003 = ActivityComponentImpl.access$6400(activityComponentImpl18);
                ActivityComponentImpl activityComponentImpl19 = this.this$1;
                $jacocoInit[86] = true;
                Provider access$63004 = ActivityComponentImpl.access$6300(activityComponentImpl19);
                ActivityComponentImpl activityComponentImpl20 = this.this$1;
                $jacocoInit[87] = true;
                Provider access$71002 = ActivityComponentImpl.access$7100(activityComponentImpl20);
                $jacocoInit[88] = true;
                C13181b create17 = FragmentModule_ProvidesAppsNavigatorFactory.create(fragmentModule19, access$64003, access$63004, access$71002);
                $jacocoInit[89] = true;
                this.providesAppsNavigatorProvider = C13180a.m43109a(create17);
                FragmentModule fragmentModule20 = this.fragmentModule;
                Provider<AppsManager> provider11 = this.providesAppsManagerProvider;
                DaggerApplicationComponent daggerApplicationComponent32 = this.this$1.this$0;
                $jacocoInit[90] = true;
                Provider access$11006 = DaggerApplicationComponent.access$1100(daggerApplicationComponent32);
                Provider<AppsNavigator> provider12 = this.providesAppsNavigatorProvider;
                $jacocoInit[91] = true;
                C13181b create18 = FragmentModule_ProvidesAppsPresenterFactory.create(fragmentModule20, provider11, access$11006, provider12);
                $jacocoInit[92] = true;
                this.providesAppsPresenterProvider = C13180a.m43109a(create18);
                FragmentModule fragmentModule21 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent33 = this.this$1.this$0;
                $jacocoInit[93] = true;
                Provider access$7400 = DaggerApplicationComponent.access$7400(daggerApplicationComponent33);
                DaggerApplicationComponent daggerApplicationComponent34 = this.this$1.this$0;
                $jacocoInit[94] = true;
                Provider access$4000 = DaggerApplicationComponent.access$4000(daggerApplicationComponent34);
                DaggerApplicationComponent daggerApplicationComponent35 = this.this$1.this$0;
                $jacocoInit[95] = true;
                Provider access$4200 = DaggerApplicationComponent.access$4200(daggerApplicationComponent35);
                DaggerApplicationComponent daggerApplicationComponent36 = this.this$1.this$0;
                $jacocoInit[96] = true;
                Provider access$1900 = DaggerApplicationComponent.access$1900(daggerApplicationComponent36);
                $jacocoInit[97] = true;
                C13181b create19 = FragmentModule_ProvidesFlagServiceFactory.create(fragmentModule21, access$7400, access$4000, access$4200, access$1900);
                $jacocoInit[98] = true;
                this.providesFlagServiceProvider = C13180a.m43109a(create19);
                FragmentModule fragmentModule22 = this.fragmentModule;
                Provider<FlagService> provider13 = this.providesFlagServiceProvider;
                $jacocoInit[99] = true;
                C13181b create20 = FragmentModule_ProvidesFlagManagerFactory.create(fragmentModule22, provider13);
                $jacocoInit[100] = true;
                this.providesFlagManagerProvider = C13180a.m43109a(create20);
                FragmentModule fragmentModule23 = this.fragmentModule;
                $jacocoInit[101] = true;
                C13181b create21 = FragmentModule_ProvidesAppViewConfigurationFactory.create(fragmentModule23);
                $jacocoInit[102] = true;
                this.providesAppViewConfigurationProvider = C13180a.m43109a(create21);
                FragmentModule fragmentModule24 = this.fragmentModule;
                $jacocoInit[103] = true;
                C13181b create22 = C5218xf1dd651.create(fragmentModule24);
                $jacocoInit[104] = true;
                this.providesAppcPromotionNotificationStringProvider = C13180a.m43109a(create22);
                FragmentModule fragmentModule25 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent37 = this.this$1.this$0;
                $jacocoInit[105] = true;
                Provider access$29002 = DaggerApplicationComponent.access$2900(daggerApplicationComponent37);
                DaggerApplicationComponent daggerApplicationComponent38 = this.this$1.this$0;
                $jacocoInit[106] = true;
                Provider access$27002 = DaggerApplicationComponent.access$2700(daggerApplicationComponent38);
                DaggerApplicationComponent daggerApplicationComponent39 = this.this$1.this$0;
                $jacocoInit[107] = true;
                Provider access$7500 = DaggerApplicationComponent.access$7500(daggerApplicationComponent39);
                DaggerApplicationComponent daggerApplicationComponent40 = this.this$1.this$0;
                $jacocoInit[108] = true;
                Provider access$7600 = DaggerApplicationComponent.access$7600(daggerApplicationComponent40);
                DaggerApplicationComponent daggerApplicationComponent41 = this.this$1.this$0;
                $jacocoInit[109] = true;
                Provider access$7700 = DaggerApplicationComponent.access$7700(daggerApplicationComponent41);
                DaggerApplicationComponent daggerApplicationComponent42 = this.this$1.this$0;
                $jacocoInit[110] = true;
                Provider access$7800 = DaggerApplicationComponent.access$7800(daggerApplicationComponent42);
                Provider<FlagManager> provider14 = this.providesFlagManagerProvider;
                DaggerApplicationComponent daggerApplicationComponent43 = this.this$1.this$0;
                $jacocoInit[111] = true;
                Provider access$1700 = DaggerApplicationComponent.access$1700(daggerApplicationComponent43);
                DaggerApplicationComponent daggerApplicationComponent44 = this.this$1.this$0;
                $jacocoInit[112] = true;
                Provider access$11007 = DaggerApplicationComponent.access$1100(daggerApplicationComponent44);
                Provider<AppViewConfiguration> provider15 = this.providesAppViewConfigurationProvider;
                DaggerApplicationComponent daggerApplicationComponent45 = this.this$1.this$0;
                $jacocoInit[113] = true;
                Provider access$3400 = DaggerApplicationComponent.access$3400(daggerApplicationComponent45);
                DaggerApplicationComponent daggerApplicationComponent46 = this.this$1.this$0;
                $jacocoInit[114] = true;
                Provider access$7900 = DaggerApplicationComponent.access$7900(daggerApplicationComponent46);
                DaggerApplicationComponent daggerApplicationComponent47 = this.this$1.this$0;
                $jacocoInit[115] = true;
                Provider access$1600 = DaggerApplicationComponent.access$1600(daggerApplicationComponent47);
                DaggerApplicationComponent daggerApplicationComponent48 = this.this$1.this$0;
                $jacocoInit[116] = true;
                Provider access$33002 = DaggerApplicationComponent.access$3300(daggerApplicationComponent48);
                DaggerApplicationComponent daggerApplicationComponent49 = this.this$1.this$0;
                $jacocoInit[117] = true;
                Provider access$4300 = DaggerApplicationComponent.access$4300(daggerApplicationComponent49);
                DaggerApplicationComponent daggerApplicationComponent50 = this.this$1.this$0;
                $jacocoInit[118] = true;
                Provider access$8000 = DaggerApplicationComponent.access$8000(daggerApplicationComponent50);
                DaggerApplicationComponent daggerApplicationComponent51 = this.this$1.this$0;
                $jacocoInit[119] = true;
                Provider access$4400 = DaggerApplicationComponent.access$4400(daggerApplicationComponent51);
                DaggerApplicationComponent daggerApplicationComponent52 = this.this$1.this$0;
                $jacocoInit[120] = true;
                Provider access$8100 = DaggerApplicationComponent.access$8100(daggerApplicationComponent52);
                DaggerApplicationComponent daggerApplicationComponent53 = this.this$1.this$0;
                $jacocoInit[121] = true;
                Provider access$35003 = DaggerApplicationComponent.access$3500(daggerApplicationComponent53);
                DaggerApplicationComponent daggerApplicationComponent54 = this.this$1.this$0;
                $jacocoInit[122] = true;
                Provider access$47002 = DaggerApplicationComponent.access$4700(daggerApplicationComponent54);
                DaggerApplicationComponent daggerApplicationComponent55 = this.this$1.this$0;
                $jacocoInit[123] = true;
                Provider access$3600 = DaggerApplicationComponent.access$3600(daggerApplicationComponent55);
                DaggerApplicationComponent daggerApplicationComponent56 = this.this$1.this$0;
                $jacocoInit[124] = true;
                Provider access$8200 = DaggerApplicationComponent.access$8200(daggerApplicationComponent56);
                DaggerApplicationComponent daggerApplicationComponent57 = this.this$1.this$0;
                $jacocoInit[125] = true;
                Provider access$8300 = DaggerApplicationComponent.access$8300(daggerApplicationComponent57);
                Provider<AppcPromotionNotificationStringProvider> provider16 = this.providesAppcPromotionNotificationStringProvider;
                DaggerApplicationComponent daggerApplicationComponent58 = this.this$1.this$0;
                $jacocoInit[126] = true;
                Provider access$8400 = DaggerApplicationComponent.access$8400(daggerApplicationComponent58);
                $jacocoInit[127] = true;
                C13181b create23 = FragmentModule_ProvidesAppViewManagerFactory.create(fragmentModule25, access$29002, access$27002, access$7500, access$7600, access$7700, access$7800, provider14, access$1700, access$11007, provider15, access$3400, access$7900, access$1600, access$33002, access$4300, access$8000, access$4400, access$8100, access$35003, access$47002, access$3600, access$8200, access$8300, provider16, access$8400);
                $jacocoInit[128] = true;
                this.providesAppViewManagerProvider = C13180a.m43109a(create23);
                FragmentModule fragmentModule26 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl21 = this.this$1;
                $jacocoInit[129] = true;
                Provider access$52003 = ActivityComponentImpl.access$5200(activityComponentImpl21);
                DaggerApplicationComponent daggerApplicationComponent59 = this.this$1.this$0;
                $jacocoInit[130] = true;
                Provider access$79002 = DaggerApplicationComponent.access$7900(daggerApplicationComponent59);
                DaggerApplicationComponent daggerApplicationComponent60 = this.this$1.this$0;
                $jacocoInit[131] = true;
                Provider access$8500 = DaggerApplicationComponent.access$8500(daggerApplicationComponent60);
                ActivityComponentImpl activityComponentImpl22 = this.this$1;
                $jacocoInit[132] = true;
                Provider access$8600 = ActivityComponentImpl.access$8600(activityComponentImpl22);
                Provider<AppViewManager> provider17 = this.providesAppViewManagerProvider;
                DaggerApplicationComponent daggerApplicationComponent61 = this.this$1.this$0;
                $jacocoInit[133] = true;
                Provider access$11008 = DaggerApplicationComponent.access$1100(daggerApplicationComponent61);
                DaggerApplicationComponent daggerApplicationComponent62 = this.this$1.this$0;
                $jacocoInit[134] = true;
                Provider access$8700 = DaggerApplicationComponent.access$8700(daggerApplicationComponent62);
                ActivityComponentImpl activityComponentImpl23 = this.this$1;
                $jacocoInit[135] = true;
                Provider access$8800 = ActivityComponentImpl.access$8800(activityComponentImpl23);
                $jacocoInit[136] = true;
                C13181b create24 = FragmentModule_ProvidesAppViewPresenterFactory.create(fragmentModule26, access$52003, access$79002, access$8500, access$8600, provider17, access$11008, access$8700, access$8800);
                $jacocoInit[137] = true;
                this.providesAppViewPresenterProvider = C13180a.m43109a(create24);
                FragmentModule fragmentModule27 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent63 = this.this$1.this$0;
                $jacocoInit[138] = true;
                Provider access$65002 = DaggerApplicationComponent.access$6500(daggerApplicationComponent63);
                $jacocoInit[139] = true;
                C13181b create25 = FragmentModule_ProvidesGetStoreManagerFactory.create(fragmentModule27, access$65002);
                $jacocoInit[140] = true;
                this.providesGetStoreManagerProvider = C13180a.m43109a(create25);
                FragmentModule fragmentModule28 = this.fragmentModule;
                $jacocoInit[141] = true;
                this.providesBundleEventProvider = C13180a.m43109a(FragmentModule_ProvidesBundleEventFactory.create(fragmentModule28));
                FragmentModule fragmentModule29 = this.fragmentModule;
                Provider<MoreBundleManager> provider18 = this.providesGetStoreManagerProvider;
                DaggerApplicationComponent daggerApplicationComponent64 = this.this$1.this$0;
                $jacocoInit[142] = true;
                Provider access$87002 = DaggerApplicationComponent.access$8700(daggerApplicationComponent64);
                Provider<HomeNavigator> provider19 = this.providesHomeNavigatorProvider;
                DaggerApplicationComponent daggerApplicationComponent65 = this.this$1.this$0;
                $jacocoInit[143] = true;
                Provider access$72002 = DaggerApplicationComponent.access$7200(daggerApplicationComponent65);
                Provider<BundleEvent> provider20 = this.providesBundleEventProvider;
                Provider<HomeAnalytics> provider21 = this.providesHomeAnalyticsProvider;
                DaggerApplicationComponent daggerApplicationComponent66 = this.this$1.this$0;
                $jacocoInit[144] = true;
                Provider access$8900 = DaggerApplicationComponent.access$8900(daggerApplicationComponent66);
                $jacocoInit[145] = true;
                C13181b create26 = FragmentModule_ProvidesGetStoreWidgetsPresenterFactory.create(fragmentModule29, provider18, access$87002, provider19, access$72002, provider20, provider21, access$8900);
                $jacocoInit[146] = true;
                this.providesGetStoreWidgetsPresenterProvider = C13180a.m43109a(create26);
                FragmentModule fragmentModule30 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent67 = this.this$1.this$0;
                $jacocoInit[147] = true;
                Provider access$11009 = DaggerApplicationComponent.access$1100(daggerApplicationComponent67);
                DaggerApplicationComponent daggerApplicationComponent68 = this.this$1.this$0;
                $jacocoInit[148] = true;
                Provider access$87003 = DaggerApplicationComponent.access$8700(daggerApplicationComponent68);
                DaggerApplicationComponent daggerApplicationComponent69 = this.this$1.this$0;
                $jacocoInit[149] = true;
                Provider access$14004 = DaggerApplicationComponent.access$1400(daggerApplicationComponent69);
                $jacocoInit[150] = true;
                C13181b create27 = FragmentModule_ProvidesWizardPresenterFactory.create(fragmentModule30, access$11009, access$87003, access$14004);
                $jacocoInit[151] = true;
                this.providesWizardPresenterProvider = C13180a.m43109a(create27);
                FlavourFragmentModule flavourFragmentModule2 = this.flavourFragmentModule;
                $jacocoInit[152] = true;
                C13181b create28 = FlavourFragmentModule_ProvidesWizardFragmentProviderFactory.create(flavourFragmentModule2);
                $jacocoInit[153] = true;
                this.providesWizardFragmentProvider = C13180a.m43109a(create28);
                FragmentModule fragmentModule31 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl24 = this.this$1;
                $jacocoInit[154] = true;
                Provider access$52004 = ActivityComponentImpl.access$5200(activityComponentImpl24);
                DaggerApplicationComponent daggerApplicationComponent70 = this.this$1.this$0;
                $jacocoInit[155] = true;
                Provider access$110010 = DaggerApplicationComponent.access$1100(daggerApplicationComponent70);
                DaggerApplicationComponent daggerApplicationComponent71 = this.this$1.this$0;
                $jacocoInit[156] = true;
                Provider access$87004 = DaggerApplicationComponent.access$8700(daggerApplicationComponent71);
                Provider<AccountErrorMapper> provider22 = this.provideAccountErrorMapperProvider;
                ActivityComponentImpl activityComponentImpl25 = this.this$1;
                $jacocoInit[157] = true;
                Provider access$9000 = ActivityComponentImpl.access$9000(activityComponentImpl25);
                DaggerApplicationComponent daggerApplicationComponent72 = this.this$1.this$0;
                $jacocoInit[158] = true;
                Provider access$14005 = DaggerApplicationComponent.access$1400(daggerApplicationComponent72);
                $jacocoInit[159] = true;
                C13181b create29 = FragmentModule_ProvidesPaymentLoginPresenterFactory.create(fragmentModule31, access$52004, access$110010, access$87004, provider22, access$9000, access$14005);
                $jacocoInit[160] = true;
                this.providesPaymentLoginPresenterProvider = C13180a.m43109a(create29);
                FragmentModule fragmentModule32 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl26 = this.this$1;
                $jacocoInit[161] = true;
                Provider access$9100 = ActivityComponentImpl.access$9100(activityComponentImpl26);
                DaggerApplicationComponent daggerApplicationComponent73 = this.this$1.this$0;
                $jacocoInit[162] = true;
                Provider access$29003 = DaggerApplicationComponent.access$2900(daggerApplicationComponent73);
                DaggerApplicationComponent daggerApplicationComponent74 = this.this$1.this$0;
                $jacocoInit[163] = true;
                Provider access$87005 = DaggerApplicationComponent.access$8700(daggerApplicationComponent74);
                $jacocoInit[164] = true;
                C13181b create30 = FragmentModule_ProvidesAppCoinsInfoPresenterFactory.create(fragmentModule32, access$9100, access$29003, access$87005);
                $jacocoInit[165] = true;
                this.providesAppCoinsInfoPresenterProvider = C13180a.m43109a(create30);
                FragmentModule fragmentModule33 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent75 = this.this$1.this$0;
                $jacocoInit[166] = true;
                Provider access$9200 = DaggerApplicationComponent.access$9200(daggerApplicationComponent75);
                $jacocoInit[167] = true;
                C13181b create31 = FragmentModule_ProvidesEditorialRepositoryFactory.create(fragmentModule33, access$9200);
                $jacocoInit[168] = true;
                this.providesEditorialRepositoryProvider = C13180a.m43109a(create31);
                FragmentModule fragmentModule34 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent76 = this.this$1.this$0;
                $jacocoInit[169] = true;
                Provider access$30002 = DaggerApplicationComponent.access$3000(daggerApplicationComponent76);
                DaggerApplicationComponent daggerApplicationComponent77 = this.this$1.this$0;
                $jacocoInit[170] = true;
                Provider access$7002 = DaggerApplicationComponent.access$700(daggerApplicationComponent77);
                DaggerApplicationComponent daggerApplicationComponent78 = this.this$1.this$0;
                $jacocoInit[171] = true;
                Provider access$8002 = DaggerApplicationComponent.access$800(daggerApplicationComponent78);
                $jacocoInit[172] = true;
                C13181b create32 = FragmentModule_ProvidesEditorialAnalyticsFactory.create(fragmentModule34, access$30002, access$7002, access$8002);
                $jacocoInit[173] = true;
                this.providesEditorialAnalyticsProvider = C13180a.m43109a(create32);
                FragmentModule fragmentModule35 = this.fragmentModule;
                Provider<EditorialRepository> provider23 = this.providesEditorialRepositoryProvider;
                DaggerApplicationComponent daggerApplicationComponent79 = this.this$1.this$0;
                $jacocoInit[174] = true;
                Provider access$29004 = DaggerApplicationComponent.access$2900(daggerApplicationComponent79);
                DaggerApplicationComponent daggerApplicationComponent80 = this.this$1.this$0;
                $jacocoInit[175] = true;
                Provider access$27003 = DaggerApplicationComponent.access$2700(daggerApplicationComponent80);
                DaggerApplicationComponent daggerApplicationComponent81 = this.this$1.this$0;
                $jacocoInit[176] = true;
                Provider access$34002 = DaggerApplicationComponent.access$3400(daggerApplicationComponent81);
                DaggerApplicationComponent daggerApplicationComponent82 = this.this$1.this$0;
                $jacocoInit[177] = true;
                Provider access$16002 = DaggerApplicationComponent.access$1600(daggerApplicationComponent82);
                DaggerApplicationComponent daggerApplicationComponent83 = this.this$1.this$0;
                $jacocoInit[178] = true;
                Provider access$33003 = DaggerApplicationComponent.access$3300(daggerApplicationComponent83);
                Provider<EditorialAnalytics> provider24 = this.providesEditorialAnalyticsProvider;
                DaggerApplicationComponent daggerApplicationComponent84 = this.this$1.this$0;
                $jacocoInit[179] = true;
                Provider access$70002 = DaggerApplicationComponent.access$7000(daggerApplicationComponent84);
                DaggerApplicationComponent daggerApplicationComponent85 = this.this$1.this$0;
                $jacocoInit[180] = true;
                Provider access$35004 = DaggerApplicationComponent.access$3500(daggerApplicationComponent85);
                $jacocoInit[181] = true;
                C13181b create33 = FragmentModule_ProvidesEditorialManagerFactory.create(fragmentModule35, provider23, access$29004, access$27003, access$34002, access$16002, access$33003, provider24, access$70002, access$35004);
                $jacocoInit[182] = true;
                this.providesEditorialManagerProvider = C13180a.m43109a(create33);
                FragmentModule fragmentModule36 = this.fragmentModule;
                Provider<EditorialManager> provider25 = this.providesEditorialManagerProvider;
                DaggerApplicationComponent daggerApplicationComponent86 = this.this$1.this$0;
                $jacocoInit[183] = true;
                Provider access$87006 = DaggerApplicationComponent.access$8700(daggerApplicationComponent86);
                Provider<EditorialAnalytics> provider26 = this.providesEditorialAnalyticsProvider;
                ActivityComponentImpl activityComponentImpl27 = this.this$1;
                $jacocoInit[184] = true;
                Provider access$9300 = ActivityComponentImpl.access$9300(activityComponentImpl27);
                $jacocoInit[185] = true;
                C13181b create34 = FragmentModule_ProvidesEditorialPresenterFactory.create(fragmentModule36, provider25, access$87006, provider26, access$9300);
                $jacocoInit[186] = true;
                this.providesEditorialPresenterProvider = C13180a.m43109a(create34);
                FragmentModule fragmentModule37 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent87 = this.this$1.this$0;
                $jacocoInit[187] = true;
                Provider access$47003 = DaggerApplicationComponent.access$4700(daggerApplicationComponent87);
                DaggerApplicationComponent daggerApplicationComponent88 = this.this$1.this$0;
                $jacocoInit[188] = true;
                Provider access$9400 = DaggerApplicationComponent.access$9400(daggerApplicationComponent88);
                ActivityComponentImpl activityComponentImpl28 = this.this$1;
                $jacocoInit[189] = true;
                Provider access$88002 = ActivityComponentImpl.access$8800(activityComponentImpl28);
                DaggerApplicationComponent daggerApplicationComponent89 = this.this$1.this$0;
                $jacocoInit[190] = true;
                Provider access$69002 = DaggerApplicationComponent.access$6900(daggerApplicationComponent89);
                $jacocoInit[191] = true;
                C13181b create35 = FragmentModule_ProvidesPromotionsPresenterFactory.create(fragmentModule37, access$47003, access$9400, access$88002, access$69002);
                $jacocoInit[192] = true;
                this.providesPromotionsPresenterProvider = C13180a.m43109a(create35);
                FragmentModule fragmentModule38 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl29 = this.this$1;
                $jacocoInit[193] = true;
                Provider access$9500 = ActivityComponentImpl.access$9500(activityComponentImpl29);
                DaggerApplicationComponent daggerApplicationComponent90 = this.this$1.this$0;
                $jacocoInit[194] = true;
                Provider access$94002 = DaggerApplicationComponent.access$9400(daggerApplicationComponent90);
                ActivityComponentImpl activityComponentImpl30 = this.this$1;
                $jacocoInit[195] = true;
                Provider access$9600 = ActivityComponentImpl.access$9600(activityComponentImpl30);
                $jacocoInit[196] = true;
                C13181b create36 = FragmentModule_ProvidesClaimPromotionDialogPresenterFactory.create(fragmentModule38, access$9500, access$94002, access$9600);
                $jacocoInit[197] = true;
                this.providesClaimPromotionDialogPresenterProvider = C13180a.m43109a(create36);
                FragmentModule fragmentModule39 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent91 = this.this$1.this$0;
                $jacocoInit[198] = true;
                Provider access$500 = DaggerApplicationComponent.access$500(daggerApplicationComponent91);
                DaggerApplicationComponent daggerApplicationComponent92 = this.this$1.this$0;
                $jacocoInit[199] = true;
                Provider access$600 = DaggerApplicationComponent.access$600(daggerApplicationComponent92);
                $jacocoInit[200] = true;
                C13181b create37 = FragmentModule_ProvideHomeFragmentNavigatorFactory.create(fragmentModule39, access$500, access$600);
                $jacocoInit[201] = true;
                this.provideHomeFragmentNavigatorProvider = C13180a.m43109a(create37);
                FragmentModule fragmentModule40 = this.fragmentModule;
                Provider<FragmentNavigator> provider27 = this.provideHomeFragmentNavigatorProvider;
                $jacocoInit[202] = true;
                C13181b create38 = FragmentModule_ProvidesHomeContainerNavigatorFactory.create(fragmentModule40, provider27);
                $jacocoInit[203] = true;
                this.providesHomeContainerNavigatorProvider = C13180a.m43109a(create38);
                FragmentModule fragmentModule41 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent93 = this.this$1.this$0;
                $jacocoInit[204] = true;
                Provider access$87007 = DaggerApplicationComponent.access$8700(daggerApplicationComponent93);
                DaggerApplicationComponent daggerApplicationComponent94 = this.this$1.this$0;
                $jacocoInit[205] = true;
                Provider access$110011 = DaggerApplicationComponent.access$1100(daggerApplicationComponent94);
                Provider<HomeContainerNavigator> provider28 = this.providesHomeContainerNavigatorProvider;
                Provider<HomeNavigator> provider29 = this.providesHomeNavigatorProvider;
                Provider<HomeAnalytics> provider30 = this.providesHomeAnalyticsProvider;
                Provider<Home> provider31 = this.providesHomeProvider;
                DaggerApplicationComponent daggerApplicationComponent95 = this.this$1.this$0;
                $jacocoInit[206] = true;
                Provider access$89002 = DaggerApplicationComponent.access$8900(daggerApplicationComponent95);
                $jacocoInit[207] = true;
                C13181b create39 = FragmentModule_ProvidesHomeContainerPresenterFactory.create(fragmentModule41, access$87007, access$110011, provider28, provider29, provider30, provider31, access$89002);
                $jacocoInit[208] = true;
                this.providesHomeContainerPresenterProvider = C13180a.m43109a(create39);
                FragmentModule fragmentModule42 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl31 = this.this$1;
                $jacocoInit[209] = true;
                Provider access$9700 = ActivityComponentImpl.access$9700(activityComponentImpl31);
                $jacocoInit[210] = true;
                C13181b create40 = FragmentModule_ProvidesSplashScreenPresenterFactory.create(fragmentModule42, access$9700);
                $jacocoInit[211] = true;
                this.providesSplashScreenPresenterProvider = C13180a.m43109a(create40);
                FragmentModule fragmentModule43 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent96 = this.this$1.this$0;
                $jacocoInit[212] = true;
                Provider access$3900 = DaggerApplicationComponent.access$3900(daggerApplicationComponent96);
                DaggerApplicationComponent daggerApplicationComponent97 = this.this$1.this$0;
                $jacocoInit[213] = true;
                Provider access$40002 = DaggerApplicationComponent.access$4000(daggerApplicationComponent97);
                DaggerApplicationComponent daggerApplicationComponent98 = this.this$1.this$0;
                $jacocoInit[214] = true;
                Provider access$42002 = DaggerApplicationComponent.access$4200(daggerApplicationComponent98);
                DaggerApplicationComponent daggerApplicationComponent99 = this.this$1.this$0;
                $jacocoInit[215] = true;
                Provider access$19002 = DaggerApplicationComponent.access$1900(daggerApplicationComponent99);
                $jacocoInit[216] = true;
                C13181b create41 = FragmentModule_ProvidesEditorialServiceFactory.create(fragmentModule43, access$3900, access$40002, access$42002, access$19002);
                $jacocoInit[217] = true;
                this.providesEditorialServiceProvider = C13180a.m43109a(create41);
                FragmentModule fragmentModule44 = this.fragmentModule;
                Provider<EditorialListService> provider32 = this.providesEditorialServiceProvider;
                $jacocoInit[218] = true;
                C13181b create42 = FragmentModule_ProvidesEditorialListRepositoryFactory.create(fragmentModule44, provider32);
                $jacocoInit[219] = true;
                this.providesEditorialListRepositoryProvider = C13180a.m43109a(create42);
                FragmentModule fragmentModule45 = this.fragmentModule;
                Provider<EditorialListRepository> provider33 = this.providesEditorialListRepositoryProvider;
                DaggerApplicationComponent daggerApplicationComponent100 = this.this$1.this$0;
                $jacocoInit[220] = true;
                Provider access$70003 = DaggerApplicationComponent.access$7000(daggerApplicationComponent100);
                $jacocoInit[221] = true;
                C13181b create43 = FragmentModule_ProvidesEditorialListManagerFactory.create(fragmentModule45, provider33, access$70003);
                $jacocoInit[222] = true;
                this.providesEditorialListManagerProvider = C13180a.m43109a(create43);
                FragmentModule fragmentModule46 = this.fragmentModule;
                ActivityComponentImpl activityComponentImpl32 = this.this$1;
                $jacocoInit[223] = true;
                Provider access$64004 = ActivityComponentImpl.access$6400(activityComponentImpl32);
                ActivityComponentImpl activityComponentImpl33 = this.this$1;
                $jacocoInit[224] = true;
                Provider access$52005 = ActivityComponentImpl.access$5200(activityComponentImpl33);
                $jacocoInit[225] = true;
                C13181b create44 = FragmentModule_ProvidesEditorialListNavigatorFactory.create(fragmentModule46, access$64004, access$52005);
                $jacocoInit[226] = true;
                this.providesEditorialListNavigatorProvider = C13180a.m43109a(create44);
                FragmentModule fragmentModule47 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent101 = this.this$1.this$0;
                $jacocoInit[227] = true;
                Provider access$8003 = DaggerApplicationComponent.access$800(daggerApplicationComponent101);
                DaggerApplicationComponent daggerApplicationComponent102 = this.this$1.this$0;
                $jacocoInit[228] = true;
                Provider access$7003 = DaggerApplicationComponent.access$700(daggerApplicationComponent102);
                $jacocoInit[229] = true;
                C13181b create45 = FragmentModule_EditorialListAnalyticsFactory.create(fragmentModule47, access$8003, access$7003);
                $jacocoInit[230] = true;
                this.editorialListAnalyticsProvider = C13180a.m43109a(create45);
                FragmentModule fragmentModule48 = this.fragmentModule;
                Provider<EditorialListManager> provider34 = this.providesEditorialListManagerProvider;
                DaggerApplicationComponent daggerApplicationComponent103 = this.this$1.this$0;
                $jacocoInit[231] = true;
                Provider access$110012 = DaggerApplicationComponent.access$1100(daggerApplicationComponent103);
                Provider<EditorialListNavigator> provider35 = this.providesEditorialListNavigatorProvider;
                Provider<EditorialListAnalytics> provider36 = this.editorialListAnalyticsProvider;
                $jacocoInit[232] = true;
                C13181b create46 = FragmentModule_ProvidesEditorialListPresenterFactory.create(fragmentModule48, provider34, access$110012, provider35, provider36);
                $jacocoInit[233] = true;
                this.providesEditorialListPresenterProvider = C13180a.m43109a(create46);
                FragmentModule fragmentModule49 = this.fragmentModule;
                DaggerApplicationComponent daggerApplicationComponent104 = this.this$1.this$0;
                $jacocoInit[234] = true;
                Provider access$32002 = DaggerApplicationComponent.access$3200(daggerApplicationComponent104);
                DaggerApplicationComponent daggerApplicationComponent105 = this.this$1.this$0;
                $jacocoInit[235] = true;
                Provider access$29005 = DaggerApplicationComponent.access$2900(daggerApplicationComponent105);
                Provider<AppMapper> provider37 = this.providesAppMapperProvider;
                DaggerApplicationComponent daggerApplicationComponent106 = this.this$1.this$0;
                $jacocoInit[236] = true;
                Provider access$30003 = DaggerApplicationComponent.access$3000(daggerApplicationComponent106);
                DaggerApplicationComponent daggerApplicationComponent107 = this.this$1.this$0;
                $jacocoInit[237] = true;
                Provider access$33004 = DaggerApplicationComponent.access$3300(daggerApplicationComponent107);
                DaggerApplicationComponent daggerApplicationComponent108 = this.this$1.this$0;
                $jacocoInit[238] = true;
                Provider access$27004 = DaggerApplicationComponent.access$2700(daggerApplicationComponent108);
                $jacocoInit[239] = true;
                C13181b create47 = FragmentModule_ProvidesSeeMoreManagerFactory.create(fragmentModule49, access$32002, access$29005, provider37, access$30003, access$33004, access$27004);
                $jacocoInit[240] = true;
                this.providesSeeMoreManagerProvider = C13180a.m43109a(create47);
                FragmentModule fragmentModule50 = this.fragmentModule;
                Provider<SeeMoreAppcManager> provider38 = this.providesSeeMoreManagerProvider;
                $jacocoInit[241] = true;
                C13181b create48 = FragmentModule_ProvidesSeeMoreAppcPresenterFactory.create(fragmentModule50, provider38);
                $jacocoInit[242] = true;
                this.providesSeeMoreAppcPresenterProvider = C13180a.m43109a(create48);
                $jacocoInit[243] = true;
            }

            public void inject(LoginSignUpCredentialsFragment loginSignUpCredentialsFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectLoginSignUpCredentialsFragment(loginSignUpCredentialsFragment);
                $jacocoInit[244] = true;
            }

            public void inject(ManageUserFragment manageUserFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectManageUserFragment(manageUserFragment);
                $jacocoInit[245] = true;
            }

            public void inject(ManageStoreFragment manageStoreFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectManageStoreFragment(manageStoreFragment);
                $jacocoInit[246] = true;
            }

            public void inject(SearchResultFragment searchResultFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectSearchResultFragment(searchResultFragment);
                $jacocoInit[247] = true;
            }

            public void inject(StoreFragment storeFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectStoreFragment(storeFragment);
                $jacocoInit[248] = true;
            }

            public void inject(CommentListFragment commentListFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectCommentListFragment(commentListFragment);
                $jacocoInit[249] = true;
            }

            public void inject(FragmentTopStores fragmentTopStores) {
                boolean[] $jacocoInit = $jacocoInit();
                injectFragmentTopStores(fragmentTopStores);
                $jacocoInit[250] = true;
            }

            public void inject(LatestReviewsFragment latestReviewsFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectLatestReviewsFragment(latestReviewsFragment);
                $jacocoInit[251] = true;
            }

            public void inject(ListStoresFragment listStoresFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectListStoresFragment(listStoresFragment);
                $jacocoInit[252] = true;
            }

            public void inject(MyStoresSubscribedFragment myStoresSubscribedFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectMyStoresSubscribedFragment(myStoresSubscribedFragment);
                $jacocoInit[253] = true;
            }

            public void inject(StoreTabWidgetsGridRecyclerFragment storeTabWidgetsGridRecyclerFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectStoreTabWidgetsGridRecyclerFragment(storeTabWidgetsGridRecyclerFragment);
                $jacocoInit[254] = true;
            }

            public void inject(MyStoresFragment myStoresFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectMyStoresFragment(myStoresFragment);
                $jacocoInit[255] = true;
            }

            public void inject(InboxFragment inboxFragment) {
                $jacocoInit()[256] = true;
            }

            public void inject(ProfileStepOneFragment profileStepOneFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectProfileStepOneFragment(profileStepOneFragment);
                $jacocoInit[257] = true;
            }

            public void inject(ProfileStepTwoFragment profileStepTwoFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectProfileStepTwoFragment(profileStepTwoFragment);
                $jacocoInit[258] = true;
            }

            public void inject(ListStoreAppsFragment listStoreAppsFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectListStoreAppsFragment(listStoreAppsFragment);
                $jacocoInit[259] = true;
            }

            public void inject(HomeFragment homeFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectHomeFragment(homeFragment);
                $jacocoInit[260] = true;
            }

            public void inject(AppsFragment appsFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectAppsFragment(appsFragment);
                $jacocoInit[261] = true;
            }

            public void inject(MyAccountFragment myAccountFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectMyAccountFragment(myAccountFragment);
                $jacocoInit[262] = true;
            }

            public void inject(GetRewardAppCoinsAppsFragment getRewardAppCoinsAppsFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectGetRewardAppCoinsAppsFragment(getRewardAppCoinsAppsFragment);
                $jacocoInit[263] = true;
            }

            public void inject(AppViewFragment appViewFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectAppViewFragment(appViewFragment);
                $jacocoInit[264] = true;
            }

            public void inject(RateAndReviewsFragment rateAndReviewsFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectRateAndReviewsFragment(rateAndReviewsFragment);
                $jacocoInit[265] = true;
            }

            public void inject(MoreBundleFragment moreBundleFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectMoreBundleFragment(moreBundleFragment);
                $jacocoInit[266] = true;
            }

            public void inject(WizardFragment wizardFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectWizardFragment(wizardFragment);
                $jacocoInit[267] = true;
            }

            public void inject(PaymentLoginFragment paymentLoginFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectPaymentLoginFragment(paymentLoginFragment);
                $jacocoInit[268] = true;
            }

            public void inject(AppCoinsInfoFragment appCoinsInfoFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectAppCoinsInfoFragment(appCoinsInfoFragment);
                $jacocoInit[269] = true;
            }

            public void inject(EditorialFragment editorialFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectEditorialFragment(editorialFragment);
                $jacocoInit[270] = true;
            }

            public void inject(PromotionsFragment promotionsFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectPromotionsFragment(promotionsFragment);
                $jacocoInit[271] = true;
            }

            public void inject(DescriptionFragment descriptionFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectDescriptionFragment(descriptionFragment);
                $jacocoInit[272] = true;
            }

            public void inject(TimeLineFollowingFragment timeLineFollowingFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectTimeLineFollowingFragment(timeLineFollowingFragment);
                $jacocoInit[273] = true;
            }

            public void inject(TimeLineFollowersFragment timeLineFollowersFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectTimeLineFollowersFragment(timeLineFollowersFragment);
                $jacocoInit[274] = true;
            }

            public void inject(GridRecyclerSwipeWithToolbarFragment gridRecyclerSwipeWithToolbarFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectGridRecyclerSwipeWithToolbarFragment(gridRecyclerSwipeWithToolbarFragment);
                $jacocoInit[275] = true;
            }

            public void inject(SettingsFragment settingsFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectSettingsFragment(settingsFragment);
                $jacocoInit[276] = true;
            }

            public void inject(WizardFragmentProvider wizardFragmentProvider) {
                $jacocoInit()[277] = true;
            }

            public void inject(WizardPageTwoFragment wizardPageTwoFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectWizardPageTwoFragment(wizardPageTwoFragment);
                $jacocoInit[278] = true;
            }

            public void inject(ClaimPromotionDialogFragment claimPromotionDialogFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectClaimPromotionDialogFragment(claimPromotionDialogFragment);
                $jacocoInit[279] = true;
            }

            public void inject(HomeContainerFragment homeContainerFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectHomeContainerFragment(homeContainerFragment);
                $jacocoInit[280] = true;
            }

            public void inject(SplashScreenFragment splashScreenFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectSplashScreenFragment(splashScreenFragment);
                $jacocoInit[281] = true;
            }

            public void inject(EditorialListFragment editorialListFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectEditorialListFragment(editorialListFragment);
                $jacocoInit[282] = true;
            }

            public void inject(SeeMoreAppcFragment seeMoreAppcFragment) {
                boolean[] $jacocoInit = $jacocoInit();
                injectSeeMoreAppcFragment(seeMoreAppcFragment);
                $jacocoInit[283] = true;
            }

            private LoginSignUpCredentialsFragment injectLoginSignUpCredentialsFragment(LoginSignUpCredentialsFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<LoginSignupCredentialsFlavorPresenter> provider = this.provideLoginSignUpPresenterProvider;
                $jacocoInit[284] = true;
                LoginSignupCredentialsFlavorPresenter loginSignupCredentialsFlavorPresenter = (LoginSignupCredentialsFlavorPresenter) provider.get();
                $jacocoInit[285] = true;
                LoginSignUpCredentialsFragment_MembersInjector.injectPresenter(instance, loginSignupCredentialsFlavorPresenter);
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[286] = true;
                ScreenOrientationManager screenOrientationManager = (ScreenOrientationManager) ActivityComponentImpl.access$9000(activityComponentImpl).get();
                $jacocoInit[287] = true;
                LoginSignUpCredentialsFragment_MembersInjector.injectOrientationManager(instance, screenOrientationManager);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[288] = true;
                AccountAnalytics accountAnalytics = (AccountAnalytics) DaggerApplicationComponent.access$1400(daggerApplicationComponent).get();
                $jacocoInit[289] = true;
                LoginSignUpCredentialsFragment_MembersInjector.injectAccountAnalytics(instance, accountAnalytics);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[290] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent2).get();
                $jacocoInit[291] = true;
                LoginSignUpCredentialsFragment_MembersInjector.injectMarketName(instance, str);
                $jacocoInit[292] = true;
                return instance;
            }

            private ManageUserFragment injectManageUserFragment(ManageUserFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<ImagePickerPresenter> provider = this.provideImagePickerPresenterProvider;
                $jacocoInit[293] = true;
                ImagePickerPresenter imagePickerPresenter = (ImagePickerPresenter) provider.get();
                $jacocoInit[294] = true;
                ManageUserFragment_MembersInjector.injectImagePickerPresenter(instance, imagePickerPresenter);
                Provider<ManageUserPresenter> provider2 = this.provideManageUserPresenterProvider;
                $jacocoInit[295] = true;
                ManageUserPresenter manageUserPresenter = (ManageUserPresenter) provider2.get();
                $jacocoInit[296] = true;
                ManageUserFragment_MembersInjector.injectManageUserPresenter(instance, manageUserPresenter);
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[297] = true;
                ScreenOrientationManager screenOrientationManager = (ScreenOrientationManager) ActivityComponentImpl.access$9000(activityComponentImpl).get();
                $jacocoInit[298] = true;
                ManageUserFragment_MembersInjector.injectOrientationManager(instance, screenOrientationManager);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[299] = true;
                NewsletterManager newsletterManager = (NewsletterManager) DaggerApplicationComponent.access$9800(daggerApplicationComponent).get();
                $jacocoInit[300] = true;
                ManageUserFragment_MembersInjector.injectNewsletterManager(instance, newsletterManager);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[301] = true;
                String str = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent2).get();
                $jacocoInit[302] = true;
                ManageUserFragment_MembersInjector.injectTheme(instance, str);
                $jacocoInit[303] = true;
                return instance;
            }

            private ManageStoreFragment injectManageStoreFragment(ManageStoreFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<ImagePickerPresenter> provider = this.provideImagePickerPresenterProvider;
                $jacocoInit[304] = true;
                ImagePickerPresenter imagePickerPresenter = (ImagePickerPresenter) provider.get();
                $jacocoInit[305] = true;
                ManageStoreFragment_MembersInjector.injectImagePickerPresenter(instance, imagePickerPresenter);
                Provider<ManageStorePresenter> provider2 = this.provideManageStorePresenterProvider;
                $jacocoInit[306] = true;
                ManageStorePresenter manageStorePresenter = (ManageStorePresenter) provider2.get();
                $jacocoInit[307] = true;
                ManageStoreFragment_MembersInjector.injectManageStorePresenter(instance, manageStorePresenter);
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[308] = true;
                ScreenOrientationManager screenOrientationManager = (ScreenOrientationManager) ActivityComponentImpl.access$9000(activityComponentImpl).get();
                $jacocoInit[309] = true;
                ManageStoreFragment_MembersInjector.injectOrientationManager(instance, screenOrientationManager);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[310] = true;
                String str = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent).get();
                $jacocoInit[311] = true;
                ManageStoreFragment_MembersInjector.injectTheme(instance, str);
                $jacocoInit[312] = true;
                return instance;
            }

            private SearchResultFragment injectSearchResultFragment(SearchResultFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<SearchResultPresenter> provider = this.provideSearchResultPresenterProvider;
                $jacocoInit[313] = true;
                SearchResultPresenter searchResultPresenter = (SearchResultPresenter) provider.get();
                $jacocoInit[314] = true;
                SearchResultFragment_MembersInjector.injectSearchResultPresenter(instance, searchResultPresenter);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[315] = true;
                String str = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent).get();
                $jacocoInit[316] = true;
                SearchResultFragment_MembersInjector.injectTheme(instance, str);
                $jacocoInit[317] = true;
                return instance;
            }

            private StoreFragment injectStoreFragment(StoreFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[318] = true;
                AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent).get();
                $jacocoInit[319] = true;
                StoreFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[320] = true;
                NavigationTracker navigationTracker = (NavigationTracker) DaggerApplicationComponent.access$800(daggerApplicationComponent2).get();
                $jacocoInit[321] = true;
                StoreFragment_MembersInjector.injectNavigationTracker(instance, navigationTracker);
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[322] = true;
                AppNavigator appNavigator = (AppNavigator) ActivityComponentImpl.access$7100(activityComponentImpl).get();
                $jacocoInit[323] = true;
                StoreFragment_MembersInjector.injectAppNavigator(instance, appNavigator);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[324] = true;
                String str = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent3).get();
                $jacocoInit[325] = true;
                StoreFragment_MembersInjector.injectTheme(instance, str);
                DaggerApplicationComponent daggerApplicationComponent4 = this.this$1.this$0;
                $jacocoInit[326] = true;
                String str2 = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent4).get();
                $jacocoInit[327] = true;
                StoreFragment_MembersInjector.injectMarketName(instance, str2);
                DaggerApplicationComponent daggerApplicationComponent5 = this.this$1.this$0;
                $jacocoInit[328] = true;
                MarketResourceFormatter marketResourceFormatter = (MarketResourceFormatter) DaggerApplicationComponent.access$4500(daggerApplicationComponent5).get();
                $jacocoInit[329] = true;
                StoreFragment_MembersInjector.injectMarketResourceFormatter(instance, marketResourceFormatter);
                $jacocoInit[330] = true;
                return instance;
            }

            private CommentListFragment injectCommentListFragment(CommentListFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[331] = true;
                AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent).get();
                $jacocoInit[332] = true;
                CommentListFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[333] = true;
                NavigationTracker navigationTracker = (NavigationTracker) DaggerApplicationComponent.access$800(daggerApplicationComponent2).get();
                $jacocoInit[334] = true;
                CommentListFragment_MembersInjector.injectNavigationTracker(instance, navigationTracker);
                $jacocoInit[335] = true;
                return instance;
            }

            private FragmentTopStores injectFragmentTopStores(FragmentTopStores instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[336] = true;
                AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent).get();
                $jacocoInit[337] = true;
                FragmentTopStores_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[338] = true;
                NavigationTracker navigationTracker = (NavigationTracker) DaggerApplicationComponent.access$800(daggerApplicationComponent2).get();
                $jacocoInit[339] = true;
                FragmentTopStores_MembersInjector.injectNavigationTracker(instance, navigationTracker);
                $jacocoInit[340] = true;
                return instance;
            }

            private LatestReviewsFragment injectLatestReviewsFragment(LatestReviewsFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[341] = true;
                AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent).get();
                $jacocoInit[342] = true;
                LatestReviewsFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[343] = true;
                NavigationTracker navigationTracker = (NavigationTracker) DaggerApplicationComponent.access$800(daggerApplicationComponent2).get();
                $jacocoInit[344] = true;
                LatestReviewsFragment_MembersInjector.injectNavigationTracker(instance, navigationTracker);
                $jacocoInit[345] = true;
                return instance;
            }

            private ListStoresFragment injectListStoresFragment(ListStoresFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[346] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[347] = true;
                StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[348] = true;
                AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent2).get();
                $jacocoInit[349] = true;
                StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[350] = true;
                String str2 = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent3).get();
                $jacocoInit[351] = true;
                StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(instance, str2);
                DaggerApplicationComponent daggerApplicationComponent4 = this.this$1.this$0;
                $jacocoInit[352] = true;
                AnalyticsManager analyticsManager2 = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent4).get();
                $jacocoInit[353] = true;
                ListStoresFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager2);
                DaggerApplicationComponent daggerApplicationComponent5 = this.this$1.this$0;
                $jacocoInit[354] = true;
                NavigationTracker navigationTracker = (NavigationTracker) DaggerApplicationComponent.access$800(daggerApplicationComponent5).get();
                $jacocoInit[355] = true;
                ListStoresFragment_MembersInjector.injectNavigationTracker(instance, navigationTracker);
                $jacocoInit[356] = true;
                return instance;
            }

            private MyStoresSubscribedFragment injectMyStoresSubscribedFragment(MyStoresSubscribedFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[357] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[358] = true;
                StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[359] = true;
                AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent2).get();
                $jacocoInit[360] = true;
                StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[361] = true;
                String str2 = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent3).get();
                $jacocoInit[362] = true;
                StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(instance, str2);
                DaggerApplicationComponent daggerApplicationComponent4 = this.this$1.this$0;
                $jacocoInit[363] = true;
                AnalyticsManager analyticsManager2 = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent4).get();
                $jacocoInit[364] = true;
                MyStoresSubscribedFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager2);
                DaggerApplicationComponent daggerApplicationComponent5 = this.this$1.this$0;
                $jacocoInit[365] = true;
                NavigationTracker navigationTracker = (NavigationTracker) DaggerApplicationComponent.access$800(daggerApplicationComponent5).get();
                $jacocoInit[366] = true;
                MyStoresSubscribedFragment_MembersInjector.injectNavigationTracker(instance, navigationTracker);
                $jacocoInit[367] = true;
                return instance;
            }

            private StoreTabWidgetsGridRecyclerFragment injectStoreTabWidgetsGridRecyclerFragment(StoreTabWidgetsGridRecyclerFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[368] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[369] = true;
                StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[370] = true;
                AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent2).get();
                $jacocoInit[371] = true;
                StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[372] = true;
                String str2 = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent3).get();
                $jacocoInit[373] = true;
                StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(instance, str2);
                $jacocoInit[374] = true;
                return instance;
            }

            private MyStoresFragment injectMyStoresFragment(MyStoresFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[375] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[376] = true;
                StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[377] = true;
                AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent2).get();
                $jacocoInit[378] = true;
                StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[379] = true;
                String str2 = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent3).get();
                $jacocoInit[380] = true;
                StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(instance, str2);
                Provider<MyStoresPresenter> provider = this.providesMyStorePresenterProvider;
                $jacocoInit[381] = true;
                MyStoresPresenter myStoresPresenter = (MyStoresPresenter) provider.get();
                $jacocoInit[382] = true;
                MyStoresFragment_MembersInjector.injectMyStoresPresenter(instance, myStoresPresenter);
                $jacocoInit[383] = true;
                return instance;
            }

            private ProfileStepOneFragment injectProfileStepOneFragment(ProfileStepOneFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[384] = true;
                ScreenOrientationManager screenOrientationManager = (ScreenOrientationManager) ActivityComponentImpl.access$9000(activityComponentImpl).get();
                $jacocoInit[385] = true;
                ProfileStepOneFragment_MembersInjector.injectOrientationManager(instance, screenOrientationManager);
                ActivityComponentImpl activityComponentImpl2 = this.this$1;
                $jacocoInit[386] = true;
                AccountNavigator accountNavigator = (AccountNavigator) ActivityComponentImpl.access$5200(activityComponentImpl2).get();
                $jacocoInit[387] = true;
                ProfileStepOneFragment_MembersInjector.injectAccountNavigator(instance, accountNavigator);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[388] = true;
                AccountAnalytics accountAnalytics = (AccountAnalytics) DaggerApplicationComponent.access$1400(daggerApplicationComponent).get();
                $jacocoInit[389] = true;
                ProfileStepOneFragment_MembersInjector.injectAccountAnalytics(instance, accountAnalytics);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[390] = true;
                LoginSignupManager loginSignupManager = (LoginSignupManager) DaggerApplicationComponent.access$9900(daggerApplicationComponent2).get();
                $jacocoInit[391] = true;
                ProfileStepOneFragment_MembersInjector.injectLoginSignupManager(instance, loginSignupManager);
                $jacocoInit[392] = true;
                return instance;
            }

            private ProfileStepTwoFragment injectProfileStepTwoFragment(ProfileStepTwoFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[393] = true;
                AccountAnalytics accountAnalytics = (AccountAnalytics) DaggerApplicationComponent.access$1400(daggerApplicationComponent).get();
                $jacocoInit[394] = true;
                ProfileStepTwoFragment_MembersInjector.injectAccountAnalytics(instance, accountAnalytics);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[395] = true;
                LoginSignupManager loginSignupManager = (LoginSignupManager) DaggerApplicationComponent.access$9900(daggerApplicationComponent2).get();
                $jacocoInit[396] = true;
                ProfileStepTwoFragment_MembersInjector.injectLoginSignupManager(instance, loginSignupManager);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[397] = true;
                MarketResourceFormatter marketResourceFormatter = (MarketResourceFormatter) DaggerApplicationComponent.access$4500(daggerApplicationComponent3).get();
                $jacocoInit[398] = true;
                ProfileStepTwoFragment_MembersInjector.injectMarketResourceFormatter(instance, marketResourceFormatter);
                $jacocoInit[399] = true;
                return instance;
            }

            private ListStoreAppsFragment injectListStoreAppsFragment(ListStoreAppsFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[400] = true;
                ListStoreAppsNavigator listStoreAppsNavigator = (ListStoreAppsNavigator) ActivityComponentImpl.access$10000(activityComponentImpl).get();
                $jacocoInit[401] = true;
                ListStoreAppsFragment_MembersInjector.injectListStoreAppsNavigator(instance, listStoreAppsNavigator);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[402] = true;
                AppCenter appCenter = (AppCenter) DaggerApplicationComponent.access$7500(daggerApplicationComponent).get();
                $jacocoInit[403] = true;
                ListStoreAppsFragment_MembersInjector.injectAppCenter(instance, appCenter);
                $jacocoInit[404] = true;
                return instance;
            }

            private HomeFragment injectHomeFragment(HomeFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                HomeFragment_MembersInjector.injectPresenter(instance, (HomePresenter) this.providesHomePresenterProvider.get());
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[405] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[406] = true;
                HomeFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[407] = true;
                MoPubConsentDialogView moPubConsentDialogView = (MoPubConsentDialogView) DaggerApplicationComponent.access$10100(daggerApplicationComponent2).get();
                $jacocoInit[408] = true;
                HomeFragment_MembersInjector.injectConsentDialogView(instance, moPubConsentDialogView);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[409] = true;
                CaptionBackgroundPainter captionBackgroundPainter = (CaptionBackgroundPainter) DaggerApplicationComponent.access$10200(daggerApplicationComponent3).get();
                $jacocoInit[410] = true;
                HomeFragment_MembersInjector.injectCaptionBackgroundPainter(instance, captionBackgroundPainter);
                $jacocoInit[411] = true;
                return instance;
            }

            private AppsFragment injectAppsFragment(AppsFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<AppsPresenter> provider = this.providesAppsPresenterProvider;
                $jacocoInit[412] = true;
                AppsPresenter appsPresenter = (AppsPresenter) provider.get();
                $jacocoInit[413] = true;
                AppsFragment_MembersInjector.injectAppsPresenter(instance, appsPresenter);
                $jacocoInit[414] = true;
                return instance;
            }

            private MyAccountFragment injectMyAccountFragment(MyAccountFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[415] = true;
                MyAccountNavigator myAccountNavigator = (MyAccountNavigator) ActivityComponentImpl.access$10300(activityComponentImpl).get();
                $jacocoInit[416] = true;
                MyAccountFragment_MembersInjector.injectMyAccountNavigator(instance, myAccountNavigator);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[417] = true;
                AccountAnalytics accountAnalytics = (AccountAnalytics) DaggerApplicationComponent.access$1400(daggerApplicationComponent).get();
                $jacocoInit[418] = true;
                MyAccountFragment_MembersInjector.injectAccountAnalytics(instance, accountAnalytics);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[419] = true;
                MyAccountManager myAccountManager = (MyAccountManager) DaggerApplicationComponent.access$10400(daggerApplicationComponent2).get();
                $jacocoInit[420] = true;
                MyAccountFragment_MembersInjector.injectMyAccountManager(instance, myAccountManager);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[421] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent3).get();
                $jacocoInit[422] = true;
                MyAccountFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent4 = this.this$1.this$0;
                $jacocoInit[423] = true;
                MarketResourceFormatter marketResourceFormatter = (MarketResourceFormatter) DaggerApplicationComponent.access$4500(daggerApplicationComponent4).get();
                $jacocoInit[424] = true;
                MyAccountFragment_MembersInjector.injectMarketFormatter(instance, marketResourceFormatter);
                DaggerApplicationComponent daggerApplicationComponent5 = this.this$1.this$0;
                $jacocoInit[425] = true;
                String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent5).get();
                $jacocoInit[426] = true;
                MyAccountFragment_MembersInjector.injectTheme(instance, str2);
                $jacocoInit[427] = true;
                return instance;
            }

            private GetRewardAppCoinsAppsFragment injectGetRewardAppCoinsAppsFragment(GetRewardAppCoinsAppsFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[428] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[429] = true;
                StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[430] = true;
                RewardAppCoinsAppsRepository rewardAppCoinsAppsRepository = (RewardAppCoinsAppsRepository) DaggerApplicationComponent.access$10500(daggerApplicationComponent2).get();
                $jacocoInit[431] = true;
                GetRewardAppCoinsAppsFragment_MembersInjector.injectRewardAppsRepository(instance, rewardAppCoinsAppsRepository);
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[432] = true;
                AppNavigator appNavigator = (AppNavigator) ActivityComponentImpl.access$7100(activityComponentImpl).get();
                $jacocoInit[433] = true;
                GetRewardAppCoinsAppsFragment_MembersInjector.injectAppNavigator(instance, appNavigator);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[434] = true;
                AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent3).get();
                $jacocoInit[435] = true;
                GetRewardAppCoinsAppsFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
                $jacocoInit[436] = true;
                return instance;
            }

            private AppViewFragment injectAppViewFragment(AppViewFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<AppViewPresenter> provider = this.providesAppViewPresenterProvider;
                $jacocoInit[437] = true;
                AppViewPresenter appViewPresenter = (AppViewPresenter) provider.get();
                $jacocoInit[438] = true;
                AppViewFragment_MembersInjector.injectPresenter(instance, appViewPresenter);
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[439] = true;
                DialogUtils dialogUtils = (DialogUtils) ActivityComponentImpl.access$10600(activityComponentImpl).get();
                $jacocoInit[440] = true;
                AppViewFragment_MembersInjector.injectDialogUtils(instance, dialogUtils);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[441] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[442] = true;
                AppViewFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[443] = true;
                String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent2).get();
                $jacocoInit[444] = true;
                AppViewFragment_MembersInjector.injectTheme(instance, str2);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[445] = true;
                DecimalFormat decimalFormat = (DecimalFormat) DaggerApplicationComponent.access$10700(daggerApplicationComponent3).get();
                $jacocoInit[446] = true;
                AppViewFragment_MembersInjector.injectOneDecimalFormat(instance, decimalFormat);
                DaggerApplicationComponent daggerApplicationComponent4 = this.this$1.this$0;
                $jacocoInit[447] = true;
                MoPubConsentDialogView moPubConsentDialogView = (MoPubConsentDialogView) DaggerApplicationComponent.access$10100(daggerApplicationComponent4).get();
                $jacocoInit[448] = true;
                AppViewFragment_MembersInjector.injectConsentDialogView(instance, moPubConsentDialogView);
                $jacocoInit[449] = true;
                return instance;
            }

            private RateAndReviewsFragment injectRateAndReviewsFragment(RateAndReviewsFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[450] = true;
                AppNavigator appNavigator = (AppNavigator) ActivityComponentImpl.access$7100(activityComponentImpl).get();
                $jacocoInit[451] = true;
                RateAndReviewsFragment_MembersInjector.injectAppNavigator(instance, appNavigator);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[452] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[453] = true;
                RateAndReviewsFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[454] = true;
                MarketResourceFormatter marketResourceFormatter = (MarketResourceFormatter) DaggerApplicationComponent.access$4500(daggerApplicationComponent2).get();
                $jacocoInit[455] = true;
                RateAndReviewsFragment_MembersInjector.injectMarketResourceFormatter(instance, marketResourceFormatter);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[456] = true;
                String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent3).get();
                $jacocoInit[457] = true;
                RateAndReviewsFragment_MembersInjector.injectTheme(instance, str2);
                $jacocoInit[458] = true;
                return instance;
            }

            private MoreBundleFragment injectMoreBundleFragment(MoreBundleFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<MoreBundlePresenter> provider = this.providesGetStoreWidgetsPresenterProvider;
                $jacocoInit[459] = true;
                MoreBundlePresenter moreBundlePresenter = (MoreBundlePresenter) provider.get();
                $jacocoInit[460] = true;
                MoreBundleFragment_MembersInjector.injectPresenter(instance, moreBundlePresenter);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[461] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[462] = true;
                MoreBundleFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[463] = true;
                CaptionBackgroundPainter captionBackgroundPainter = (CaptionBackgroundPainter) DaggerApplicationComponent.access$10200(daggerApplicationComponent2).get();
                $jacocoInit[464] = true;
                MoreBundleFragment_MembersInjector.injectCaptionBackgroundPainter(instance, captionBackgroundPainter);
                $jacocoInit[465] = true;
                return instance;
            }

            private WizardFragment injectWizardFragment(WizardFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<WizardPresenter> provider = this.providesWizardPresenterProvider;
                $jacocoInit[466] = true;
                WizardPresenter wizardPresenter = (WizardPresenter) provider.get();
                $jacocoInit[467] = true;
                WizardFragment_MembersInjector.injectWizardPresenter(instance, wizardPresenter);
                Provider<WizardFragmentProvider> provider2 = this.providesWizardFragmentProvider;
                $jacocoInit[468] = true;
                WizardFragmentProvider wizardFragmentProvider = (WizardFragmentProvider) provider2.get();
                $jacocoInit[469] = true;
                WizardFragment_MembersInjector.injectWizardFragmentProvider(instance, wizardFragmentProvider);
                $jacocoInit[470] = true;
                return instance;
            }

            private PaymentLoginFragment injectPaymentLoginFragment(PaymentLoginFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<PaymentLoginFlavorPresenter> provider = this.providesPaymentLoginPresenterProvider;
                $jacocoInit[471] = true;
                PaymentLoginFlavorPresenter paymentLoginFlavorPresenter = (PaymentLoginFlavorPresenter) provider.get();
                $jacocoInit[472] = true;
                PaymentLoginFragment_MembersInjector.injectPresenter(instance, paymentLoginFlavorPresenter);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[473] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[474] = true;
                PaymentLoginFragment_MembersInjector.injectMarketName(instance, str);
                $jacocoInit[475] = true;
                return instance;
            }

            private AppCoinsInfoFragment injectAppCoinsInfoFragment(AppCoinsInfoFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<AppCoinsInfoPresenter> provider = this.providesAppCoinsInfoPresenterProvider;
                $jacocoInit[476] = true;
                AppCoinsInfoPresenter appCoinsInfoPresenter = (AppCoinsInfoPresenter) provider.get();
                $jacocoInit[477] = true;
                AppCoinsInfoFragment_MembersInjector.injectAppCoinsInfoPresenter(instance, appCoinsInfoPresenter);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[478] = true;
                String str = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent).get();
                $jacocoInit[479] = true;
                AppCoinsInfoFragment_MembersInjector.injectTheme(instance, str);
                $jacocoInit[480] = true;
                return instance;
            }

            private EditorialFragment injectEditorialFragment(EditorialFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<EditorialPresenter> provider = this.providesEditorialPresenterProvider;
                $jacocoInit[481] = true;
                EditorialPresenter editorialPresenter = (EditorialPresenter) provider.get();
                $jacocoInit[482] = true;
                EditorialFragment_MembersInjector.injectPresenter(instance, editorialPresenter);
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[483] = true;
                float floatValue = ((Float) ActivityComponentImpl.access$10800(activityComponentImpl).get()).floatValue();
                $jacocoInit[484] = true;
                EditorialFragment_MembersInjector.injectScreenWidth(instance, floatValue);
                ActivityComponentImpl activityComponentImpl2 = this.this$1;
                $jacocoInit[485] = true;
                float floatValue2 = ((Float) ActivityComponentImpl.access$10900(activityComponentImpl2).get()).floatValue();
                $jacocoInit[486] = true;
                EditorialFragment_MembersInjector.injectScreenHeight(instance, floatValue2);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[487] = true;
                String str = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent).get();
                $jacocoInit[488] = true;
                EditorialFragment_MembersInjector.injectTheme(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[489] = true;
                CaptionBackgroundPainter captionBackgroundPainter = (CaptionBackgroundPainter) DaggerApplicationComponent.access$10200(daggerApplicationComponent2).get();
                $jacocoInit[490] = true;
                EditorialFragment_MembersInjector.injectCaptionBackgroundPainter(instance, captionBackgroundPainter);
                $jacocoInit[491] = true;
                return instance;
            }

            private PromotionsFragment injectPromotionsFragment(PromotionsFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<PromotionsPresenter> provider = this.providesPromotionsPresenterProvider;
                $jacocoInit[492] = true;
                PromotionsPresenter promotionsPresenter = (PromotionsPresenter) provider.get();
                $jacocoInit[493] = true;
                PromotionsFragment_MembersInjector.injectPromotionsPresenter(instance, promotionsPresenter);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[494] = true;
                String str = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent).get();
                $jacocoInit[495] = true;
                PromotionsFragment_MembersInjector.injectTheme(instance, str);
                $jacocoInit[496] = true;
                return instance;
            }

            private DescriptionFragment injectDescriptionFragment(DescriptionFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[497] = true;
                String str = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent).get();
                $jacocoInit[498] = true;
                DescriptionFragment_MembersInjector.injectTheme(instance, str);
                $jacocoInit[499] = true;
                return instance;
            }

            private TimeLineFollowingFragment injectTimeLineFollowingFragment(TimeLineFollowingFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[500] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[501] = true;
                GridRecyclerSwipeWithToolbarFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[502] = true;
                String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent2).get();
                $jacocoInit[503] = true;
                TimeLineFollowingFragment_MembersInjector.injectTheme(instance, str2);
                $jacocoInit[504] = true;
                return instance;
            }

            private TimeLineFollowersFragment injectTimeLineFollowersFragment(TimeLineFollowersFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[505] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[506] = true;
                GridRecyclerSwipeWithToolbarFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[507] = true;
                String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent2).get();
                $jacocoInit[508] = true;
                TimeLineFollowersFragment_MembersInjector.injectTheme(instance, str2);
                $jacocoInit[509] = true;
                return instance;
            }

            private GridRecyclerSwipeWithToolbarFragment injectGridRecyclerSwipeWithToolbarFragment(GridRecyclerSwipeWithToolbarFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[510] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[511] = true;
                GridRecyclerSwipeWithToolbarFragment_MembersInjector.injectMarketName(instance, str);
                $jacocoInit[512] = true;
                return instance;
            }

            private SettingsFragment injectSettingsFragment(SettingsFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[513] = true;
                String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
                $jacocoInit[514] = true;
                SettingsFragment_MembersInjector.injectMarketName(instance, str);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[515] = true;
                MarketResourceFormatter marketResourceFormatter = (MarketResourceFormatter) DaggerApplicationComponent.access$4500(daggerApplicationComponent2).get();
                $jacocoInit[516] = true;
                SettingsFragment_MembersInjector.injectMarketResourceFormatter(instance, marketResourceFormatter);
                DaggerApplicationComponent daggerApplicationComponent3 = this.this$1.this$0;
                $jacocoInit[517] = true;
                String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent3).get();
                $jacocoInit[518] = true;
                SettingsFragment_MembersInjector.injectTheme(instance, str2);
                DaggerApplicationComponent daggerApplicationComponent4 = this.this$1.this$0;
                $jacocoInit[519] = true;
                SupportEmailProvider supportEmailProvider = (SupportEmailProvider) DaggerApplicationComponent.access$5100(daggerApplicationComponent4).get();
                $jacocoInit[520] = true;
                SettingsFragment_MembersInjector.injectSupportEmailProvider(instance, supportEmailProvider);
                $jacocoInit[521] = true;
                return instance;
            }

            private WizardPageTwoFragment injectWizardPageTwoFragment(WizardPageTwoFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[522] = true;
                MarketResourceFormatter marketResourceFormatter = (MarketResourceFormatter) DaggerApplicationComponent.access$4500(daggerApplicationComponent).get();
                $jacocoInit[523] = true;
                WizardPageTwoFragment_MembersInjector.injectMarketResourceFormatter(instance, marketResourceFormatter);
                $jacocoInit[524] = true;
                return instance;
            }

            private ClaimPromotionDialogFragment injectClaimPromotionDialogFragment(ClaimPromotionDialogFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<ClaimPromotionDialogPresenter> provider = this.providesClaimPromotionDialogPresenterProvider;
                $jacocoInit[525] = true;
                ClaimPromotionDialogPresenter claimPromotionDialogPresenter = (ClaimPromotionDialogPresenter) provider.get();
                $jacocoInit[526] = true;
                ClaimPromotionDialogFragment_MembersInjector.injectPresenter(instance, claimPromotionDialogPresenter);
                ActivityComponentImpl activityComponentImpl = this.this$1;
                $jacocoInit[527] = true;
                ClaimPromotionsManager claimPromotionsManager = (ClaimPromotionsManager) ActivityComponentImpl.access$9500(activityComponentImpl).get();
                $jacocoInit[528] = true;
                ClaimPromotionDialogFragment_MembersInjector.injectClaimPromotionsManager(instance, claimPromotionsManager);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[529] = true;
                IdsRepository idsRepository = (IdsRepository) DaggerApplicationComponent.access$11000(daggerApplicationComponent).get();
                $jacocoInit[530] = true;
                ClaimPromotionDialogFragment_MembersInjector.injectIdsRepository(instance, idsRepository);
                DaggerApplicationComponent daggerApplicationComponent2 = this.this$1.this$0;
                $jacocoInit[531] = true;
                PromotionsAnalytics promotionsAnalytics = (PromotionsAnalytics) DaggerApplicationComponent.access$9400(daggerApplicationComponent2).get();
                $jacocoInit[532] = true;
                ClaimPromotionDialogFragment_MembersInjector.injectPromotionsAnalytics(instance, promotionsAnalytics);
                ActivityComponentImpl activityComponentImpl2 = this.this$1;
                $jacocoInit[533] = true;
                ClaimPromotionsNavigator claimPromotionsNavigator = (ClaimPromotionsNavigator) ActivityComponentImpl.access$9600(activityComponentImpl2).get();
                $jacocoInit[534] = true;
                ClaimPromotionDialogFragment_MembersInjector.injectNavigator(instance, claimPromotionsNavigator);
                $jacocoInit[535] = true;
                return instance;
            }

            private HomeContainerFragment injectHomeContainerFragment(HomeContainerFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<HomeContainerPresenter> provider = this.providesHomeContainerPresenterProvider;
                $jacocoInit[536] = true;
                HomeContainerPresenter homeContainerPresenter = (HomeContainerPresenter) provider.get();
                $jacocoInit[537] = true;
                HomeContainerFragment_MembersInjector.injectPresenter(instance, homeContainerPresenter);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[538] = true;
                String str = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent).get();
                $jacocoInit[539] = true;
                HomeContainerFragment_MembersInjector.injectTheme(instance, str);
                $jacocoInit[540] = true;
                return instance;
            }

            private SplashScreenFragment injectSplashScreenFragment(SplashScreenFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<SplashScreenPresenter> provider = this.providesSplashScreenPresenterProvider;
                $jacocoInit[541] = true;
                SplashScreenPresenter splashScreenPresenter = (SplashScreenPresenter) provider.get();
                $jacocoInit[542] = true;
                SplashScreenFragment_MembersInjector.injectPresenter(instance, splashScreenPresenter);
                $jacocoInit[543] = true;
                return instance;
            }

            private EditorialListFragment injectEditorialListFragment(EditorialListFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<EditorialListPresenter> provider = this.providesEditorialListPresenterProvider;
                $jacocoInit[544] = true;
                EditorialListPresenter editorialListPresenter = (EditorialListPresenter) provider.get();
                $jacocoInit[545] = true;
                EditorialListFragment_MembersInjector.injectPresenter(instance, editorialListPresenter);
                DaggerApplicationComponent daggerApplicationComponent = this.this$1.this$0;
                $jacocoInit[546] = true;
                CaptionBackgroundPainter captionBackgroundPainter = (CaptionBackgroundPainter) DaggerApplicationComponent.access$10200(daggerApplicationComponent).get();
                $jacocoInit[547] = true;
                EditorialListFragment_MembersInjector.injectCaptionBackgroundPainter(instance, captionBackgroundPainter);
                $jacocoInit[548] = true;
                return instance;
            }

            private SeeMoreAppcFragment injectSeeMoreAppcFragment(SeeMoreAppcFragment instance) {
                boolean[] $jacocoInit = $jacocoInit();
                Provider<SeeMoreAppcPresenter> provider = this.providesSeeMoreAppcPresenterProvider;
                $jacocoInit[549] = true;
                SeeMoreAppcPresenter seeMoreAppcPresenter = (SeeMoreAppcPresenter) provider.get();
                $jacocoInit[550] = true;
                SeeMoreAppcFragment_MembersInjector.injectSeeMoreAppcPresenter(instance, seeMoreAppcPresenter);
                $jacocoInit[551] = true;
                return instance;
            }
        }

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(4817500290835159368L, "cm/aptoide/pt/DaggerApplicationComponent$ActivityComponentImpl", 279);
            $jacocoData = probes;
            return probes;
        }

        /* synthetic */ ActivityComponentImpl(DaggerApplicationComponent x0, ActivityModule x1, FlavourActivityModule x2, C00371 x3) {
            boolean[] $jacocoInit = $jacocoInit();
            this(x0, x1, x2);
            $jacocoInit[254] = true;
        }

        static /* synthetic */ Provider access$10000(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<ListStoreAppsNavigator> provider = x0.provideListStoreAppsNavigatorProvider;
            $jacocoInit[274] = true;
            return provider;
        }

        static /* synthetic */ Provider access$10300(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<MyAccountNavigator> provider = x0.provideMyAccountNavigatorProvider;
            $jacocoInit[275] = true;
            return provider;
        }

        static /* synthetic */ Provider access$10600(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<DialogUtils> provider = x0.providesDialogUtilsProvider;
            $jacocoInit[276] = true;
            return provider;
        }

        static /* synthetic */ Provider access$10800(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<Float> provider = x0.providesScreenWidthProvider;
            $jacocoInit[277] = true;
            return provider;
        }

        static /* synthetic */ Provider access$10900(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<Float> provider = x0.providesScreenHeightProvider;
            $jacocoInit[278] = true;
            return provider;
        }

        static /* synthetic */ Provider access$5200(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<AccountNavigator> provider = x0.provideAccountNavigatorProvider;
            $jacocoInit[255] = true;
            return provider;
        }

        static /* synthetic */ Provider access$5300(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<AccountPermissionProvider> provider = x0.provideAccountPermissionProvider;
            $jacocoInit[256] = true;
            return provider;
        }

        static /* synthetic */ Provider access$5400(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<PhotoFileGenerator> provider = x0.providePhotoFileGeneratorProvider;
            $jacocoInit[257] = true;
            return provider;
        }

        static /* synthetic */ Provider access$5500(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<UriToPathResolver> provider = x0.provideUriToPathResolverProvider;
            $jacocoInit[258] = true;
            return provider;
        }

        static /* synthetic */ Provider access$5600(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<ImagePickerNavigator> provider = x0.provideImagePickerNavigatorProvider;
            $jacocoInit[259] = true;
            return provider;
        }

        static /* synthetic */ Provider access$5700(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<ManageUserNavigator> provider = x0.provideManageUserNavigatorProvider;
            $jacocoInit[260] = true;
            return provider;
        }

        static /* synthetic */ Provider access$5800(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<ManageStoreNavigator> provider = x0.provideManageStoreNavigatorProvider;
            $jacocoInit[261] = true;
            return provider;
        }

        static /* synthetic */ Provider access$5900(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<SearchNavigator> provider = x0.providesSearchNavigatorProvider;
            $jacocoInit[262] = true;
            return provider;
        }

        static /* synthetic */ Provider access$6300(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<BottomNavigationMapper> provider = x0.provideBottomNavigationMapperProvider;
            $jacocoInit[263] = true;
            return provider;
        }

        static /* synthetic */ Provider access$6400(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<FragmentNavigator> provider = x0.provideMainFragmentNavigatorProvider;
            $jacocoInit[264] = true;
            return provider;
        }

        static /* synthetic */ Provider access$7100(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<AppNavigator> provider = x0.providesAppNavigatorProvider;
            $jacocoInit[265] = true;
            return provider;
        }

        static /* synthetic */ Provider access$8600(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<AppViewNavigator> provider = x0.providesAppViewNavigatorProvider;
            $jacocoInit[266] = true;
            return provider;
        }

        static /* synthetic */ Provider access$8800(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<PromotionsNavigator> provider = x0.providesPromotionsNavigatorProvider;
            $jacocoInit[267] = true;
            return provider;
        }

        static /* synthetic */ Provider access$9000(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<ScreenOrientationManager> provider = x0.provideScreenOrientationManagerProvider;
            $jacocoInit[268] = true;
            return provider;
        }

        static /* synthetic */ Provider access$9100(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<AppCoinsInfoNavigator> provider = x0.providesAppCoinsInfoNavigatorProvider;
            $jacocoInit[269] = true;
            return provider;
        }

        static /* synthetic */ Provider access$9300(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<EditorialNavigator> provider = x0.providesEditorialNavigatorProvider;
            $jacocoInit[270] = true;
            return provider;
        }

        static /* synthetic */ Provider access$9500(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<ClaimPromotionsManager> provider = x0.providesClaimPromotionsManagerProvider;
            $jacocoInit[271] = true;
            return provider;
        }

        static /* synthetic */ Provider access$9600(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<ClaimPromotionsNavigator> provider = x0.providesClaimPromotionsNavigatorProvider;
            $jacocoInit[272] = true;
            return provider;
        }

        static /* synthetic */ Provider access$9700(ActivityComponentImpl x0) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<SplashScreenNavigator> provider = x0.provideSplashScreenNavigatorProvider;
            $jacocoInit[273] = true;
            return provider;
        }

        private ActivityComponentImpl(DaggerApplicationComponent daggerApplicationComponent, ActivityModule activityModule2, FlavourActivityModule flavourActivityModule2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = daggerApplicationComponent;
            $jacocoInit[0] = true;
            C13182c.m43110a(activityModule2);
            this.activityModule = activityModule2;
            $jacocoInit[1] = true;
            C13182c.m43110a(flavourActivityModule2);
            this.flavourActivityModule = flavourActivityModule2;
            $jacocoInit[2] = true;
            initialize();
            $jacocoInit[3] = true;
        }

        private void initialize() {
            boolean[] $jacocoInit = $jacocoInit();
            ActivityModule activityModule2 = this.activityModule;
            $jacocoInit[4] = true;
            this.provideFragmentManagerProvider = C13180a.m43109a(ActivityModule_ProvideFragmentManagerFactory.create(activityModule2));
            ActivityModule activityModule3 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent = this.this$0;
            $jacocoInit[5] = true;
            Provider access$500 = DaggerApplicationComponent.access$500(daggerApplicationComponent);
            DaggerApplicationComponent daggerApplicationComponent2 = this.this$0;
            $jacocoInit[6] = true;
            Provider access$600 = DaggerApplicationComponent.access$600(daggerApplicationComponent2);
            Provider<C0486t> provider = this.provideFragmentManagerProvider;
            $jacocoInit[7] = true;
            C13181b create = ActivityModule_ProvideMainFragmentNavigatorFactory.create(activityModule3, access$500, access$600, provider);
            $jacocoInit[8] = true;
            this.provideMainFragmentNavigatorProvider = C13180a.m43109a(create);
            ActivityModule activityModule4 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent3 = this.this$0;
            $jacocoInit[9] = true;
            Provider access$700 = DaggerApplicationComponent.access$700(daggerApplicationComponent3);
            DaggerApplicationComponent daggerApplicationComponent4 = this.this$0;
            $jacocoInit[10] = true;
            Provider access$800 = DaggerApplicationComponent.access$800(daggerApplicationComponent4);
            $jacocoInit[11] = true;
            C13181b create2 = ActivityModule_ProvidesBottomNavigationAnalyticsFactory.create(activityModule4, access$700, access$800);
            $jacocoInit[12] = true;
            this.providesBottomNavigationAnalyticsProvider = C13180a.m43109a(create2);
            ActivityModule activityModule5 = this.activityModule;
            Provider<FragmentNavigator> provider2 = this.provideMainFragmentNavigatorProvider;
            Provider<BottomNavigationAnalytics> provider3 = this.providesBottomNavigationAnalyticsProvider;
            DaggerApplicationComponent daggerApplicationComponent5 = this.this$0;
            $jacocoInit[13] = true;
            Provider access$900 = DaggerApplicationComponent.access$900(daggerApplicationComponent5);
            DaggerApplicationComponent daggerApplicationComponent6 = this.this$0;
            $jacocoInit[14] = true;
            Provider access$1000 = DaggerApplicationComponent.access$1000(daggerApplicationComponent6);
            $jacocoInit[15] = true;
            C13181b create3 = ActivityModule_ProvideBottomNavigationNavigatorFactory.create(activityModule5, provider2, provider3, access$900, access$1000);
            $jacocoInit[16] = true;
            this.provideBottomNavigationNavigatorProvider = C13180a.m43109a(create3);
            ActivityModule activityModule6 = this.activityModule;
            Provider<FragmentNavigator> provider4 = this.provideMainFragmentNavigatorProvider;
            DaggerApplicationComponent daggerApplicationComponent7 = this.this$0;
            $jacocoInit[17] = true;
            Provider access$1100 = DaggerApplicationComponent.access$1100(daggerApplicationComponent7);
            DaggerApplicationComponent daggerApplicationComponent8 = this.this$0;
            $jacocoInit[18] = true;
            Provider access$1200 = DaggerApplicationComponent.access$1200(daggerApplicationComponent8);
            DaggerApplicationComponent daggerApplicationComponent9 = this.this$0;
            $jacocoInit[19] = true;
            Provider access$1300 = DaggerApplicationComponent.access$1300(daggerApplicationComponent9);
            DaggerApplicationComponent daggerApplicationComponent10 = this.this$0;
            $jacocoInit[20] = true;
            Provider access$1400 = DaggerApplicationComponent.access$1400(daggerApplicationComponent10);
            Provider<BottomNavigationNavigator> provider5 = this.provideBottomNavigationNavigatorProvider;
            DaggerApplicationComponent daggerApplicationComponent11 = this.this$0;
            $jacocoInit[21] = true;
            Provider access$10002 = DaggerApplicationComponent.access$1000(daggerApplicationComponent11);
            $jacocoInit[22] = true;
            C13181b create4 = ActivityModule_ProvideAccountNavigatorFactory.create(activityModule6, provider4, access$1100, access$1200, access$1300, access$1400, provider5, access$10002);
            $jacocoInit[23] = true;
            this.provideAccountNavigatorProvider = C13180a.m43109a(create4);
            ActivityModule activityModule7 = this.activityModule;
            $jacocoInit[24] = true;
            C13181b create5 = ActivityModule_ProvideBottomNavigationMapperFactory.create(activityModule7);
            $jacocoInit[25] = true;
            this.provideBottomNavigationMapperProvider = C13180a.m43109a(create5);
            ActivityModule activityModule8 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent12 = this.this$0;
            $jacocoInit[26] = true;
            Provider access$1500 = DaggerApplicationComponent.access$1500(daggerApplicationComponent12);
            $jacocoInit[27] = true;
            C13181b create6 = ActivityModule_ProvideApkFyFactory.create(activityModule8, access$1500);
            $jacocoInit[28] = true;
            this.provideApkFyProvider = C13180a.m43109a(create6);
            ActivityModule activityModule9 = this.activityModule;
            Provider<FragmentNavigator> provider6 = this.provideMainFragmentNavigatorProvider;
            $jacocoInit[29] = true;
            C13181b create7 = ActivityModule_ProvidesAppNavigatorFactory.create(activityModule9, provider6);
            $jacocoInit[30] = true;
            this.providesAppNavigatorProvider = C13180a.m43109a(create7);
            ActivityModule activityModule10 = this.activityModule;
            Provider<FragmentNavigator> provider7 = this.provideMainFragmentNavigatorProvider;
            Provider<AppNavigator> provider8 = this.providesAppNavigatorProvider;
            $jacocoInit[31] = true;
            C13181b create8 = ActivityModule_ProvidesSearchNavigatorFactory.create(activityModule10, provider7, provider8);
            $jacocoInit[32] = true;
            this.providesSearchNavigatorProvider = C13180a.m43109a(create8);
            ActivityModule activityModule11 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent13 = this.this$0;
            $jacocoInit[33] = true;
            Provider access$1600 = DaggerApplicationComponent.access$1600(daggerApplicationComponent13);
            DaggerApplicationComponent daggerApplicationComponent14 = this.this$0;
            $jacocoInit[34] = true;
            Provider access$1700 = DaggerApplicationComponent.access$1700(daggerApplicationComponent14);
            DaggerApplicationComponent daggerApplicationComponent15 = this.this$0;
            $jacocoInit[35] = true;
            Provider access$1800 = DaggerApplicationComponent.access$1800(daggerApplicationComponent15);
            Provider<FragmentNavigator> provider9 = this.provideMainFragmentNavigatorProvider;
            Provider<BottomNavigationNavigator> provider10 = this.provideBottomNavigationNavigatorProvider;
            Provider<SearchNavigator> provider11 = this.providesSearchNavigatorProvider;
            DaggerApplicationComponent daggerApplicationComponent16 = this.this$0;
            $jacocoInit[36] = true;
            Provider access$1900 = DaggerApplicationComponent.access$1900(daggerApplicationComponent16);
            DaggerApplicationComponent daggerApplicationComponent17 = this.this$0;
            $jacocoInit[37] = true;
            Provider access$2000 = DaggerApplicationComponent.access$2000(daggerApplicationComponent17);
            DaggerApplicationComponent daggerApplicationComponent18 = this.this$0;
            $jacocoInit[38] = true;
            Provider access$8002 = DaggerApplicationComponent.access$800(daggerApplicationComponent18);
            DaggerApplicationComponent daggerApplicationComponent19 = this.this$0;
            $jacocoInit[39] = true;
            Provider access$9002 = DaggerApplicationComponent.access$900(daggerApplicationComponent19);
            DaggerApplicationComponent daggerApplicationComponent20 = this.this$0;
            $jacocoInit[40] = true;
            Provider access$2100 = DaggerApplicationComponent.access$2100(daggerApplicationComponent20);
            DaggerApplicationComponent daggerApplicationComponent21 = this.this$0;
            $jacocoInit[41] = true;
            Provider access$2200 = DaggerApplicationComponent.access$2200(daggerApplicationComponent21);
            DaggerApplicationComponent daggerApplicationComponent22 = this.this$0;
            $jacocoInit[42] = true;
            Provider access$11002 = DaggerApplicationComponent.access$1100(daggerApplicationComponent22);
            DaggerApplicationComponent daggerApplicationComponent23 = this.this$0;
            $jacocoInit[43] = true;
            Provider access$2300 = DaggerApplicationComponent.access$2300(daggerApplicationComponent23);
            DaggerApplicationComponent daggerApplicationComponent24 = this.this$0;
            $jacocoInit[44] = true;
            Provider access$2400 = DaggerApplicationComponent.access$2400(daggerApplicationComponent24);
            Provider<AppNavigator> provider12 = this.providesAppNavigatorProvider;
            DaggerApplicationComponent daggerApplicationComponent25 = this.this$0;
            $jacocoInit[45] = true;
            Provider access$10003 = DaggerApplicationComponent.access$1000(daggerApplicationComponent25);
            $jacocoInit[46] = true;
            C13181b create9 = ActivityModule_ProvideDeepLinkManagerFactory.create(activityModule11, access$1600, access$1700, access$1800, provider9, provider10, provider11, access$1900, access$2000, access$8002, access$9002, access$2100, access$2200, access$11002, access$2300, access$2400, provider12, access$10003);
            $jacocoInit[47] = true;
            this.provideDeepLinkManagerProvider = C13180a.m43109a(create9);
            ActivityModule activityModule12 = this.activityModule;
            $jacocoInit[48] = true;
            this.providePackageNameProvider = C13180a.m43109a(ActivityModule_ProvidePackageNameFactory.create(activityModule12));
            ActivityModule activityModule13 = this.activityModule;
            Provider<String> provider13 = this.providePackageNameProvider;
            $jacocoInit[49] = true;
            C13181b create10 = ActivityModule_ProvideLocalVersionCodeFactory.create(activityModule13, provider13);
            $jacocoInit[50] = true;
            this.provideLocalVersionCodeProvider = C13180a.m43109a(create10);
            ActivityModule activityModule14 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent26 = this.this$0;
            $jacocoInit[51] = true;
            Provider access$2500 = DaggerApplicationComponent.access$2500(daggerApplicationComponent26);
            Provider<String> provider14 = this.providePackageNameProvider;
            DaggerApplicationComponent daggerApplicationComponent27 = this.this$0;
            $jacocoInit[52] = true;
            Provider access$2600 = DaggerApplicationComponent.access$2600(daggerApplicationComponent27);
            $jacocoInit[53] = true;
            C13181b create11 = ActivityModule_ProvidesRetrofitAptoideBiServiceFactory.create(activityModule14, access$2500, provider14, access$2600);
            $jacocoInit[54] = true;
            this.providesRetrofitAptoideBiServiceProvider = C13180a.m43109a(create11);
            ActivityModule activityModule15 = this.activityModule;
            Provider<AutoUpdateService> provider15 = this.providesRetrofitAptoideBiServiceProvider;
            $jacocoInit[55] = true;
            C13181b create12 = ActivityModule_ProvidesAutoUpdateRepositoryFactory.create(activityModule15, provider15);
            $jacocoInit[56] = true;
            this.providesAutoUpdateRepositoryProvider = C13180a.m43109a(create12);
            ActivityModule activityModule16 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent28 = this.this$0;
            $jacocoInit[57] = true;
            Provider access$2700 = DaggerApplicationComponent.access$2700(daggerApplicationComponent28);
            DaggerApplicationComponent daggerApplicationComponent29 = this.this$0;
            $jacocoInit[58] = true;
            Provider access$2800 = DaggerApplicationComponent.access$2800(daggerApplicationComponent29);
            DaggerApplicationComponent daggerApplicationComponent30 = this.this$0;
            $jacocoInit[59] = true;
            Provider access$2900 = DaggerApplicationComponent.access$2900(daggerApplicationComponent30);
            DaggerApplicationComponent daggerApplicationComponent31 = this.this$0;
            $jacocoInit[60] = true;
            Provider access$3000 = DaggerApplicationComponent.access$3000(daggerApplicationComponent31);
            Provider<Integer> provider16 = this.provideLocalVersionCodeProvider;
            Provider<AutoUpdateRepository> provider17 = this.providesAutoUpdateRepositoryProvider;
            $jacocoInit[61] = true;
            C13181b create13 = ActivityModule_ProvideAutoUpdateManagerFactory.create(activityModule16, access$2700, access$2800, access$2900, access$3000, provider16, provider17);
            $jacocoInit[62] = true;
            this.provideAutoUpdateManagerProvider = C13180a.m43109a(create13);
            ActivityModule activityModule17 = this.activityModule;
            $jacocoInit[63] = true;
            C13181b create14 = ActivityModule_ProvideSplashScreenManagerFactory.create(activityModule17);
            $jacocoInit[64] = true;
            this.provideSplashScreenManagerProvider = C13180a.m43109a(create14);
            ActivityModule activityModule18 = this.activityModule;
            Provider<BottomNavigationNavigator> provider18 = this.provideBottomNavigationNavigatorProvider;
            Provider<FragmentNavigator> provider19 = this.provideMainFragmentNavigatorProvider;
            $jacocoInit[65] = true;
            C13181b create15 = ActivityModule_ProvideSplashScreenNavigatorFactory.create(activityModule18, provider18, provider19);
            $jacocoInit[66] = true;
            this.provideSplashScreenNavigatorProvider = C13180a.m43109a(create15);
            ActivityModule activityModule19 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent32 = this.this$0;
            $jacocoInit[67] = true;
            Provider access$3100 = DaggerApplicationComponent.access$3100(daggerApplicationComponent32);
            Provider<ApkFy> provider20 = this.provideApkFyProvider;
            DaggerApplicationComponent daggerApplicationComponent33 = this.this$0;
            $jacocoInit[68] = true;
            Provider access$29002 = DaggerApplicationComponent.access$2900(daggerApplicationComponent33);
            DaggerApplicationComponent daggerApplicationComponent34 = this.this$0;
            $jacocoInit[69] = true;
            Provider access$19002 = DaggerApplicationComponent.access$1900(daggerApplicationComponent34);
            DaggerApplicationComponent daggerApplicationComponent35 = this.this$0;
            $jacocoInit[70] = true;
            Provider access$15002 = DaggerApplicationComponent.access$1500(daggerApplicationComponent35);
            Provider<FragmentNavigator> provider21 = this.provideMainFragmentNavigatorProvider;
            Provider<DeepLinkManager> provider22 = this.provideDeepLinkManagerProvider;
            Provider<BottomNavigationNavigator> provider23 = this.provideBottomNavigationNavigatorProvider;
            DaggerApplicationComponent daggerApplicationComponent36 = this.this$0;
            $jacocoInit[71] = true;
            Provider access$3200 = DaggerApplicationComponent.access$3200(daggerApplicationComponent36);
            Provider<AutoUpdateManager> provider24 = this.provideAutoUpdateManagerProvider;
            Provider<SplashScreenManager> provider25 = this.provideSplashScreenManagerProvider;
            Provider<SplashScreenNavigator> provider26 = this.provideSplashScreenNavigatorProvider;
            $jacocoInit[72] = true;
            C13181b create16 = ActivityModule_ProvideMainPresenterFactory.create(activityModule19, access$3100, provider20, access$29002, access$19002, access$15002, provider21, provider22, provider23, access$3200, provider24, provider25, provider26);
            $jacocoInit[73] = true;
            this.provideMainPresenterProvider = C13180a.m43109a(create16);
            ActivityModule activityModule20 = this.activityModule;
            Provider<FragmentNavigator> provider27 = this.provideMainFragmentNavigatorProvider;
            $jacocoInit[74] = true;
            C13181b create17 = ActivityModule_ProvidesWalletInstallNavigatorFactory.create(activityModule20, provider27);
            $jacocoInit[75] = true;
            this.providesWalletInstallNavigatorProvider = C13180a.m43109a(create17);
            ActivityModule activityModule21 = this.activityModule;
            $jacocoInit[76] = true;
            C13181b create18 = ActivityModule_ProvidesWalletInstallConfigurationFactory.create(activityModule21);
            $jacocoInit[77] = true;
            this.providesWalletInstallConfigurationProvider = C13180a.m43109a(create18);
            ActivityModule activityModule22 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent37 = this.this$0;
            $jacocoInit[78] = true;
            Provider access$30002 = DaggerApplicationComponent.access$3000(daggerApplicationComponent37);
            DaggerApplicationComponent daggerApplicationComponent38 = this.this$0;
            $jacocoInit[79] = true;
            Provider access$16002 = DaggerApplicationComponent.access$1600(daggerApplicationComponent38);
            DaggerApplicationComponent daggerApplicationComponent39 = this.this$0;
            $jacocoInit[80] = true;
            Provider access$3300 = DaggerApplicationComponent.access$3300(daggerApplicationComponent39);
            DaggerApplicationComponent daggerApplicationComponent40 = this.this$0;
            $jacocoInit[81] = true;
            Provider access$3400 = DaggerApplicationComponent.access$3400(daggerApplicationComponent40);
            DaggerApplicationComponent daggerApplicationComponent41 = this.this$0;
            $jacocoInit[82] = true;
            Provider access$7002 = DaggerApplicationComponent.access$700(daggerApplicationComponent41);
            DaggerApplicationComponent daggerApplicationComponent42 = this.this$0;
            $jacocoInit[83] = true;
            Provider access$8003 = DaggerApplicationComponent.access$800(daggerApplicationComponent42);
            $jacocoInit[84] = true;
            C13181b create19 = ActivityModule_ProvidesWalletInstallAnalyticsFactory.create(activityModule22, access$30002, access$16002, access$3300, access$3400, access$7002, access$8003);
            $jacocoInit[85] = true;
            this.providesWalletInstallAnalyticsProvider = C13180a.m43109a(create19);
            ActivityModule activityModule23 = this.activityModule;
            Provider<WalletInstallConfiguration> provider28 = this.providesWalletInstallConfigurationProvider;
            DaggerApplicationComponent daggerApplicationComponent43 = this.this$0;
            $jacocoInit[86] = true;
            Provider access$29003 = DaggerApplicationComponent.access$2900(daggerApplicationComponent43);
            DaggerApplicationComponent daggerApplicationComponent44 = this.this$0;
            $jacocoInit[87] = true;
            Provider access$27002 = DaggerApplicationComponent.access$2700(daggerApplicationComponent44);
            DaggerApplicationComponent daggerApplicationComponent45 = this.this$0;
            $jacocoInit[88] = true;
            Provider access$34002 = DaggerApplicationComponent.access$3400(daggerApplicationComponent45);
            DaggerApplicationComponent daggerApplicationComponent46 = this.this$0;
            $jacocoInit[89] = true;
            Provider access$3500 = DaggerApplicationComponent.access$3500(daggerApplicationComponent46);
            Provider<WalletInstallAnalytics> provider29 = this.providesWalletInstallAnalyticsProvider;
            DaggerApplicationComponent daggerApplicationComponent47 = this.this$0;
            $jacocoInit[90] = true;
            Provider access$3600 = DaggerApplicationComponent.access$3600(daggerApplicationComponent47);
            DaggerApplicationComponent daggerApplicationComponent48 = this.this$0;
            $jacocoInit[91] = true;
            Provider access$3700 = DaggerApplicationComponent.access$3700(daggerApplicationComponent48);
            DaggerApplicationComponent daggerApplicationComponent49 = this.this$0;
            $jacocoInit[92] = true;
            Provider access$3800 = DaggerApplicationComponent.access$3800(daggerApplicationComponent49);
            $jacocoInit[93] = true;
            C13181b create20 = ActivityModule_ProvidesWalletInstallManagerFactory.create(activityModule23, provider28, access$29003, access$27002, access$34002, access$3500, provider29, access$3600, access$3700, access$3800);
            $jacocoInit[94] = true;
            this.providesWalletInstallManagerProvider = C13180a.m43109a(create20);
            ActivityModule activityModule24 = this.activityModule;
            Provider<WalletInstallNavigator> provider30 = this.providesWalletInstallNavigatorProvider;
            Provider<WalletInstallManager> provider31 = this.providesWalletInstallManagerProvider;
            $jacocoInit[95] = true;
            C13181b create21 = ActivityModule_ProvidesWalletInstallPresenterFactory.create(activityModule24, provider30, provider31);
            $jacocoInit[96] = true;
            this.providesWalletInstallPresenterProvider = C13180a.m43109a(create21);
            ActivityModule activityModule25 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent50 = this.this$0;
            $jacocoInit[97] = true;
            Provider access$7003 = DaggerApplicationComponent.access$700(daggerApplicationComponent50);
            DaggerApplicationComponent daggerApplicationComponent51 = this.this$0;
            $jacocoInit[98] = true;
            Provider access$8004 = DaggerApplicationComponent.access$800(daggerApplicationComponent51);
            $jacocoInit[99] = true;
            C13181b create22 = ActivityModule_ProvidesDonationsAnalyticsFactory.create(activityModule25, access$7003, access$8004);
            $jacocoInit[100] = true;
            this.providesDonationsAnalyticsProvider = C13180a.m43109a(create22);
            ActivityModule activityModule26 = this.activityModule;
            $jacocoInit[101] = true;
            C13181b create23 = ActivityModule_ProvideScreenOrientationManagerFactory.create(activityModule26);
            $jacocoInit[102] = true;
            this.provideScreenOrientationManagerProvider = C13180a.m43109a(create23);
            ActivityModule activityModule27 = this.activityModule;
            $jacocoInit[103] = true;
            C13181b create24 = ActivityModule_ProvideAccountPermissionProviderFactory.create(activityModule27);
            $jacocoInit[104] = true;
            this.provideAccountPermissionProvider = C13180a.m43109a(create24);
            ActivityModule activityModule28 = this.activityModule;
            $jacocoInit[105] = true;
            C13181b create25 = ActivityModule_ProvidePhotoFileGeneratorFactory.create(activityModule28);
            $jacocoInit[106] = true;
            this.providePhotoFileGeneratorProvider = C13180a.m43109a(create25);
            ActivityModule activityModule29 = this.activityModule;
            $jacocoInit[107] = true;
            C13181b create26 = ActivityModule_ProvideUriToPathResolverFactory.create(activityModule29);
            $jacocoInit[108] = true;
            this.provideUriToPathResolverProvider = C13180a.m43109a(create26);
            ActivityModule activityModule30 = this.activityModule;
            $jacocoInit[109] = true;
            C13181b create27 = ActivityModule_ProvideImagePickerNavigatorFactory.create(activityModule30);
            $jacocoInit[110] = true;
            this.provideImagePickerNavigatorProvider = C13180a.m43109a(create27);
            ActivityModule activityModule31 = this.activityModule;
            Provider<FragmentNavigator> provider32 = this.provideMainFragmentNavigatorProvider;
            Provider<BottomNavigationNavigator> provider33 = this.provideBottomNavigationNavigatorProvider;
            $jacocoInit[111] = true;
            C13181b create28 = ActivityModule_ProvideManageUserNavigatorFactory.create(activityModule31, provider32, provider33);
            $jacocoInit[112] = true;
            this.provideManageUserNavigatorProvider = C13180a.m43109a(create28);
            ActivityModule activityModule32 = this.activityModule;
            Provider<FragmentNavigator> provider34 = this.provideMainFragmentNavigatorProvider;
            Provider<BottomNavigationNavigator> provider35 = this.provideBottomNavigationNavigatorProvider;
            $jacocoInit[113] = true;
            C13181b create29 = ActivityModule_ProvideManageStoreNavigatorFactory.create(activityModule32, provider34, provider35);
            $jacocoInit[114] = true;
            this.provideManageStoreNavigatorProvider = C13180a.m43109a(create29);
            ActivityModule activityModule33 = this.activityModule;
            Provider<FragmentNavigator> provider36 = this.provideMainFragmentNavigatorProvider;
            Provider<AppNavigator> provider37 = this.providesAppNavigatorProvider;
            $jacocoInit[115] = true;
            C13181b create30 = ActivityModule_ProvideListStoreAppsNavigatorFactory.create(activityModule33, provider36, provider37);
            $jacocoInit[116] = true;
            this.provideListStoreAppsNavigatorProvider = C13180a.m43109a(create30);
            ActivityModule activityModule34 = this.activityModule;
            Provider<FragmentNavigator> provider38 = this.provideMainFragmentNavigatorProvider;
            Provider<AccountNavigator> provider39 = this.provideAccountNavigatorProvider;
            Provider<AppNavigator> provider40 = this.providesAppNavigatorProvider;
            $jacocoInit[117] = true;
            C13181b create31 = ActivityModule_ProvideMyAccountNavigatorFactory.create(activityModule34, provider38, provider39, provider40);
            $jacocoInit[118] = true;
            this.provideMyAccountNavigatorProvider = C13180a.m43109a(create31);
            ActivityModule activityModule35 = this.activityModule;
            Provider<FragmentNavigator> provider41 = this.provideMainFragmentNavigatorProvider;
            Provider<AppNavigator> provider42 = this.providesAppNavigatorProvider;
            $jacocoInit[119] = true;
            C13181b create32 = ActivityModule_ProvidesAppViewNavigatorFactory.create(activityModule35, provider41, provider42);
            $jacocoInit[120] = true;
            this.providesAppViewNavigatorProvider = C13180a.m43109a(create32);
            ActivityModule activityModule36 = this.activityModule;
            Provider<FragmentNavigator> provider43 = this.provideMainFragmentNavigatorProvider;
            $jacocoInit[121] = true;
            C13181b create33 = ActivityModule_ProvidesPromotionsNavigatorFactory.create(activityModule36, provider43);
            $jacocoInit[122] = true;
            this.providesPromotionsNavigatorProvider = C13180a.m43109a(create33);
            ActivityModule activityModule37 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent52 = this.this$0;
            $jacocoInit[123] = true;
            Provider access$11003 = DaggerApplicationComponent.access$1100(daggerApplicationComponent52);
            Provider<AccountNavigator> provider44 = this.provideAccountNavigatorProvider;
            DaggerApplicationComponent daggerApplicationComponent53 = this.this$0;
            $jacocoInit[124] = true;
            Provider access$3900 = DaggerApplicationComponent.access$3900(daggerApplicationComponent53);
            DaggerApplicationComponent daggerApplicationComponent54 = this.this$0;
            $jacocoInit[125] = true;
            Provider access$4000 = DaggerApplicationComponent.access$4000(daggerApplicationComponent54);
            DaggerApplicationComponent daggerApplicationComponent55 = this.this$0;
            $jacocoInit[126] = true;
            Provider access$4100 = DaggerApplicationComponent.access$4100(daggerApplicationComponent55);
            DaggerApplicationComponent daggerApplicationComponent56 = this.this$0;
            $jacocoInit[127] = true;
            Provider access$36002 = DaggerApplicationComponent.access$3600(daggerApplicationComponent56);
            DaggerApplicationComponent daggerApplicationComponent57 = this.this$0;
            $jacocoInit[128] = true;
            Provider access$4200 = DaggerApplicationComponent.access$4200(daggerApplicationComponent57);
            DaggerApplicationComponent daggerApplicationComponent58 = this.this$0;
            $jacocoInit[129] = true;
            Provider access$19003 = DaggerApplicationComponent.access$1900(daggerApplicationComponent58);
            DaggerApplicationComponent daggerApplicationComponent59 = this.this$0;
            $jacocoInit[130] = true;
            Provider access$4300 = DaggerApplicationComponent.access$4300(daggerApplicationComponent59);
            DaggerApplicationComponent daggerApplicationComponent60 = this.this$0;
            $jacocoInit[131] = true;
            Provider access$4400 = DaggerApplicationComponent.access$4400(daggerApplicationComponent60);
            DaggerApplicationComponent daggerApplicationComponent61 = this.this$0;
            $jacocoInit[132] = true;
            Provider access$4500 = DaggerApplicationComponent.access$4500(daggerApplicationComponent61);
            $jacocoInit[133] = true;
            C13181b create34 = ActivityModule_ProvidesDialogUtilsFactory.create(activityModule37, access$11003, provider44, access$3900, access$4000, access$4100, access$36002, access$4200, access$19003, access$4300, access$4400, access$4500);
            $jacocoInit[134] = true;
            this.providesDialogUtilsProvider = C13180a.m43109a(create34);
            ActivityModule activityModule38 = this.activityModule;
            Provider<FragmentNavigator> provider45 = this.provideMainFragmentNavigatorProvider;
            $jacocoInit[135] = true;
            C13181b create35 = ActivityModule_ProvidesAppCoinsInfoNavigatorFactory.create(activityModule38, provider45);
            $jacocoInit[136] = true;
            this.providesAppCoinsInfoNavigatorProvider = C13180a.m43109a(create35);
            ActivityModule activityModule39 = this.activityModule;
            Provider<AppNavigator> provider46 = this.providesAppNavigatorProvider;
            Provider<AccountNavigator> provider47 = this.provideAccountNavigatorProvider;
            $jacocoInit[137] = true;
            C13181b create36 = ActivityModule_ProvidesEditorialNavigatorFactory.create(activityModule39, provider46, provider47);
            $jacocoInit[138] = true;
            this.providesEditorialNavigatorProvider = C13180a.m43109a(create36);
            ActivityModule activityModule40 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent62 = this.this$0;
            $jacocoInit[139] = true;
            Provider access$43002 = DaggerApplicationComponent.access$4300(daggerApplicationComponent62);
            $jacocoInit[140] = true;
            C13181b create37 = ActivityModule_ProvidesScreenWidthFactory.create(activityModule40, access$43002);
            $jacocoInit[141] = true;
            this.providesScreenWidthProvider = C13180a.m43109a(create37);
            ActivityModule activityModule41 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent63 = this.this$0;
            $jacocoInit[142] = true;
            Provider access$43003 = DaggerApplicationComponent.access$4300(daggerApplicationComponent63);
            $jacocoInit[143] = true;
            C13181b create38 = ActivityModule_ProvidesScreenHeightFactory.create(activityModule41, access$43003);
            $jacocoInit[144] = true;
            this.providesScreenHeightProvider = C13180a.m43109a(create38);
            ActivityModule activityModule42 = this.activityModule;
            DaggerApplicationComponent daggerApplicationComponent64 = this.this$0;
            $jacocoInit[145] = true;
            Provider access$4600 = DaggerApplicationComponent.access$4600(daggerApplicationComponent64);
            DaggerApplicationComponent daggerApplicationComponent65 = this.this$0;
            $jacocoInit[146] = true;
            Provider access$4700 = DaggerApplicationComponent.access$4700(daggerApplicationComponent65);
            $jacocoInit[147] = true;
            C13181b create39 = ActivityModule_ProvidesClaimPromotionsManagerFactory.create(activityModule42, access$4600, access$4700);
            $jacocoInit[148] = true;
            this.providesClaimPromotionsManagerProvider = C13180a.m43109a(create39);
            ActivityModule activityModule43 = this.activityModule;
            Provider<FragmentNavigator> provider48 = this.provideMainFragmentNavigatorProvider;
            $jacocoInit[149] = true;
            C13181b create40 = ActivityModule_ProvidesClaimPromotionsNavigatorFactory.create(activityModule43, provider48);
            $jacocoInit[150] = true;
            this.providesClaimPromotionsNavigatorProvider = C13180a.m43109a(create40);
            $jacocoInit[151] = true;
        }

        public void inject(MainActivity activity) {
            boolean[] $jacocoInit = $jacocoInit();
            injectMainActivity(activity);
            $jacocoInit[152] = true;
        }

        public void inject(WalletInstallActivity activity) {
            boolean[] $jacocoInit = $jacocoInit();
            injectWalletInstallActivity(activity);
            $jacocoInit[153] = true;
        }

        public void inject(ActivityResultNavigator activityResultNavigator) {
            boolean[] $jacocoInit = $jacocoInit();
            injectActivityResultNavigator(activityResultNavigator);
            $jacocoInit[154] = true;
        }

        public void inject(AnalyticsActivity analyticsActivity) {
            boolean[] $jacocoInit = $jacocoInit();
            injectAnalyticsActivity(analyticsActivity);
            $jacocoInit[155] = true;
        }

        public void inject(BottomNavigationActivity bottomNavigationActivity) {
            boolean[] $jacocoInit = $jacocoInit();
            injectBottomNavigationActivity(bottomNavigationActivity);
            $jacocoInit[156] = true;
        }

        public void inject(DialogUtils dialogUtils) {
            $jacocoInit()[157] = true;
        }

        public void inject(DonateDialogFragment donateDialogFragment) {
            boolean[] $jacocoInit = $jacocoInit();
            injectDonateDialogFragment(donateDialogFragment);
            $jacocoInit[158] = true;
        }

        public void inject(BaseActivity baseActivity) {
            $jacocoInit()[159] = true;
        }

        public void inject(SettingsFragment settingsFragment) {
            boolean[] $jacocoInit = $jacocoInit();
            injectSettingsFragment(settingsFragment);
            $jacocoInit[160] = true;
        }

        public void inject(StoreTabGridRecyclerFragment storeTabGridRecyclerFragment) {
            boolean[] $jacocoInit = $jacocoInit();
            injectStoreTabGridRecyclerFragment(storeTabGridRecyclerFragment);
            $jacocoInit[161] = true;
        }

        public FragmentComponent plus(FragmentModule fragmentModule, FlavourFragmentModule flavourFragmentModule) {
            boolean[] $jacocoInit = $jacocoInit();
            FragmentComponentImpl fragmentComponentImpl = new FragmentComponentImpl(this, fragmentModule, flavourFragmentModule, null);
            $jacocoInit[162] = true;
            return fragmentComponentImpl;
        }

        private MainActivity injectMainActivity(MainActivity instance) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<AccountNavigator> provider = this.provideAccountNavigatorProvider;
            $jacocoInit[163] = true;
            AccountNavigator accountNavigator = (AccountNavigator) provider.get();
            $jacocoInit[164] = true;
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(instance, accountNavigator);
            DaggerApplicationComponent daggerApplicationComponent = this.this$0;
            $jacocoInit[165] = true;
            String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
            $jacocoInit[166] = true;
            ActivityResultNavigator_MembersInjector.injectMarketName(instance, str);
            DaggerApplicationComponent daggerApplicationComponent2 = this.this$0;
            $jacocoInit[167] = true;
            String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent2).get();
            $jacocoInit[168] = true;
            ActivityResultNavigator_MembersInjector.injectTheme(instance, str2);
            DaggerApplicationComponent daggerApplicationComponent3 = this.this$0;
            $jacocoInit[169] = true;
            AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent3).get();
            $jacocoInit[170] = true;
            AnalyticsActivity_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
            DaggerApplicationComponent daggerApplicationComponent4 = this.this$0;
            $jacocoInit[171] = true;
            FirstLaunchAnalytics firstLaunchAnalytics = (FirstLaunchAnalytics) DaggerApplicationComponent.access$4900(daggerApplicationComponent4).get();
            $jacocoInit[172] = true;
            AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(instance, firstLaunchAnalytics);
            DaggerApplicationComponent daggerApplicationComponent5 = this.this$0;
            $jacocoInit[173] = true;
            String str3 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent5).get();
            $jacocoInit[174] = true;
            ThemedActivityView_MembersInjector.injectTheme(instance, str3);
            Provider<BottomNavigationMapper> provider2 = this.provideBottomNavigationMapperProvider;
            $jacocoInit[175] = true;
            BottomNavigationMapper bottomNavigationMapper = (BottomNavigationMapper) provider2.get();
            $jacocoInit[176] = true;
            BottomNavigationActivity_MembersInjector.injectBottomNavigationMapper(instance, bottomNavigationMapper);
            Provider<BottomNavigationNavigator> provider3 = this.provideBottomNavigationNavigatorProvider;
            $jacocoInit[177] = true;
            BottomNavigationNavigator bottomNavigationNavigator = (BottomNavigationNavigator) provider3.get();
            $jacocoInit[178] = true;
            BottomNavigationActivity_MembersInjector.injectBottomNavigationNavigator(instance, bottomNavigationNavigator);
            $jacocoInit[179] = true;
            MainActivity_MembersInjector.injectPresenter(instance, (Presenter) this.provideMainPresenterProvider.get());
            DaggerApplicationComponent daggerApplicationComponent6 = this.this$0;
            $jacocoInit[180] = true;
            Resources resources = (Resources) DaggerApplicationComponent.access$4300(daggerApplicationComponent6).get();
            $jacocoInit[181] = true;
            MainActivity_MembersInjector.injectResources(instance, resources);
            DaggerApplicationComponent daggerApplicationComponent7 = this.this$0;
            $jacocoInit[182] = true;
            MarketResourceFormatter marketResourceFormatter = (MarketResourceFormatter) DaggerApplicationComponent.access$4500(daggerApplicationComponent7).get();
            $jacocoInit[183] = true;
            MainActivity_MembersInjector.injectMarketResourceFormatter(instance, marketResourceFormatter);
            $jacocoInit[184] = true;
            return instance;
        }

        private WalletInstallActivity injectWalletInstallActivity(WalletInstallActivity instance) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<AccountNavigator> provider = this.provideAccountNavigatorProvider;
            $jacocoInit[185] = true;
            AccountNavigator accountNavigator = (AccountNavigator) provider.get();
            $jacocoInit[186] = true;
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(instance, accountNavigator);
            DaggerApplicationComponent daggerApplicationComponent = this.this$0;
            $jacocoInit[187] = true;
            String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
            $jacocoInit[188] = true;
            ActivityResultNavigator_MembersInjector.injectMarketName(instance, str);
            DaggerApplicationComponent daggerApplicationComponent2 = this.this$0;
            $jacocoInit[189] = true;
            String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent2).get();
            $jacocoInit[190] = true;
            ActivityResultNavigator_MembersInjector.injectTheme(instance, str2);
            DaggerApplicationComponent daggerApplicationComponent3 = this.this$0;
            $jacocoInit[191] = true;
            AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent3).get();
            $jacocoInit[192] = true;
            AnalyticsActivity_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
            DaggerApplicationComponent daggerApplicationComponent4 = this.this$0;
            $jacocoInit[193] = true;
            FirstLaunchAnalytics firstLaunchAnalytics = (FirstLaunchAnalytics) DaggerApplicationComponent.access$4900(daggerApplicationComponent4).get();
            $jacocoInit[194] = true;
            AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(instance, firstLaunchAnalytics);
            Provider<WalletInstallPresenter> provider2 = this.providesWalletInstallPresenterProvider;
            $jacocoInit[195] = true;
            WalletInstallPresenter walletInstallPresenter = (WalletInstallPresenter) provider2.get();
            $jacocoInit[196] = true;
            WalletInstallActivity_MembersInjector.injectPresenter(instance, walletInstallPresenter);
            $jacocoInit[197] = true;
            return instance;
        }

        private ActivityResultNavigator injectActivityResultNavigator(ActivityResultNavigator instance) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<AccountNavigator> provider = this.provideAccountNavigatorProvider;
            $jacocoInit[198] = true;
            AccountNavigator accountNavigator = (AccountNavigator) provider.get();
            $jacocoInit[199] = true;
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(instance, accountNavigator);
            DaggerApplicationComponent daggerApplicationComponent = this.this$0;
            $jacocoInit[200] = true;
            String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
            $jacocoInit[201] = true;
            ActivityResultNavigator_MembersInjector.injectMarketName(instance, str);
            DaggerApplicationComponent daggerApplicationComponent2 = this.this$0;
            $jacocoInit[202] = true;
            String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent2).get();
            $jacocoInit[203] = true;
            ActivityResultNavigator_MembersInjector.injectTheme(instance, str2);
            $jacocoInit[204] = true;
            return instance;
        }

        private AnalyticsActivity injectAnalyticsActivity(AnalyticsActivity instance) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<AccountNavigator> provider = this.provideAccountNavigatorProvider;
            $jacocoInit[205] = true;
            AccountNavigator accountNavigator = (AccountNavigator) provider.get();
            $jacocoInit[206] = true;
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(instance, accountNavigator);
            DaggerApplicationComponent daggerApplicationComponent = this.this$0;
            $jacocoInit[207] = true;
            String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
            $jacocoInit[208] = true;
            ActivityResultNavigator_MembersInjector.injectMarketName(instance, str);
            DaggerApplicationComponent daggerApplicationComponent2 = this.this$0;
            $jacocoInit[209] = true;
            String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent2).get();
            $jacocoInit[210] = true;
            ActivityResultNavigator_MembersInjector.injectTheme(instance, str2);
            DaggerApplicationComponent daggerApplicationComponent3 = this.this$0;
            $jacocoInit[211] = true;
            AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent3).get();
            $jacocoInit[212] = true;
            AnalyticsActivity_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
            DaggerApplicationComponent daggerApplicationComponent4 = this.this$0;
            $jacocoInit[213] = true;
            FirstLaunchAnalytics firstLaunchAnalytics = (FirstLaunchAnalytics) DaggerApplicationComponent.access$4900(daggerApplicationComponent4).get();
            $jacocoInit[214] = true;
            AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(instance, firstLaunchAnalytics);
            $jacocoInit[215] = true;
            return instance;
        }

        private BottomNavigationActivity injectBottomNavigationActivity(BottomNavigationActivity instance) {
            boolean[] $jacocoInit = $jacocoInit();
            Provider<AccountNavigator> provider = this.provideAccountNavigatorProvider;
            $jacocoInit[216] = true;
            AccountNavigator accountNavigator = (AccountNavigator) provider.get();
            $jacocoInit[217] = true;
            ActivityResultNavigator_MembersInjector.injectAccountNavigator(instance, accountNavigator);
            DaggerApplicationComponent daggerApplicationComponent = this.this$0;
            $jacocoInit[218] = true;
            String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
            $jacocoInit[219] = true;
            ActivityResultNavigator_MembersInjector.injectMarketName(instance, str);
            DaggerApplicationComponent daggerApplicationComponent2 = this.this$0;
            $jacocoInit[220] = true;
            String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent2).get();
            $jacocoInit[221] = true;
            ActivityResultNavigator_MembersInjector.injectTheme(instance, str2);
            DaggerApplicationComponent daggerApplicationComponent3 = this.this$0;
            $jacocoInit[222] = true;
            AnalyticsManager analyticsManager = (AnalyticsManager) DaggerApplicationComponent.access$700(daggerApplicationComponent3).get();
            $jacocoInit[223] = true;
            AnalyticsActivity_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
            DaggerApplicationComponent daggerApplicationComponent4 = this.this$0;
            $jacocoInit[224] = true;
            FirstLaunchAnalytics firstLaunchAnalytics = (FirstLaunchAnalytics) DaggerApplicationComponent.access$4900(daggerApplicationComponent4).get();
            $jacocoInit[225] = true;
            AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(instance, firstLaunchAnalytics);
            DaggerApplicationComponent daggerApplicationComponent5 = this.this$0;
            $jacocoInit[226] = true;
            String str3 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent5).get();
            $jacocoInit[227] = true;
            ThemedActivityView_MembersInjector.injectTheme(instance, str3);
            Provider<BottomNavigationMapper> provider2 = this.provideBottomNavigationMapperProvider;
            $jacocoInit[228] = true;
            BottomNavigationMapper bottomNavigationMapper = (BottomNavigationMapper) provider2.get();
            $jacocoInit[229] = true;
            BottomNavigationActivity_MembersInjector.injectBottomNavigationMapper(instance, bottomNavigationMapper);
            Provider<BottomNavigationNavigator> provider3 = this.provideBottomNavigationNavigatorProvider;
            $jacocoInit[230] = true;
            BottomNavigationNavigator bottomNavigationNavigator = (BottomNavigationNavigator) provider3.get();
            $jacocoInit[231] = true;
            BottomNavigationActivity_MembersInjector.injectBottomNavigationNavigator(instance, bottomNavigationNavigator);
            $jacocoInit[232] = true;
            return instance;
        }

        private DonateDialogFragment injectDonateDialogFragment(DonateDialogFragment instance) {
            boolean[] $jacocoInit = $jacocoInit();
            DaggerApplicationComponent daggerApplicationComponent = this.this$0;
            $jacocoInit[233] = true;
            WalletService walletService = (WalletService) DaggerApplicationComponent.access$5000(daggerApplicationComponent).get();
            $jacocoInit[234] = true;
            DonateDialogFragment_MembersInjector.injectWalletService(instance, walletService);
            Provider<AppNavigator> provider = this.providesAppNavigatorProvider;
            $jacocoInit[235] = true;
            AppNavigator appNavigator = (AppNavigator) provider.get();
            $jacocoInit[236] = true;
            DonateDialogFragment_MembersInjector.injectAppNavigator(instance, appNavigator);
            Provider<DonationsAnalytics> provider2 = this.providesDonationsAnalyticsProvider;
            $jacocoInit[237] = true;
            DonationsAnalytics donationsAnalytics = (DonationsAnalytics) provider2.get();
            $jacocoInit[238] = true;
            DonateDialogFragment_MembersInjector.injectDonationsAnalytics(instance, donationsAnalytics);
            DaggerApplicationComponent daggerApplicationComponent2 = this.this$0;
            $jacocoInit[239] = true;
            String str = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent2).get();
            $jacocoInit[240] = true;
            DonateDialogFragment_MembersInjector.injectTheme(instance, str);
            $jacocoInit[241] = true;
            return instance;
        }

        private SettingsFragment injectSettingsFragment(SettingsFragment instance) {
            boolean[] $jacocoInit = $jacocoInit();
            DaggerApplicationComponent daggerApplicationComponent = this.this$0;
            $jacocoInit[242] = true;
            String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
            $jacocoInit[243] = true;
            SettingsFragment_MembersInjector.injectMarketName(instance, str);
            DaggerApplicationComponent daggerApplicationComponent2 = this.this$0;
            $jacocoInit[244] = true;
            MarketResourceFormatter marketResourceFormatter = (MarketResourceFormatter) DaggerApplicationComponent.access$4500(daggerApplicationComponent2).get();
            $jacocoInit[245] = true;
            SettingsFragment_MembersInjector.injectMarketResourceFormatter(instance, marketResourceFormatter);
            DaggerApplicationComponent daggerApplicationComponent3 = this.this$0;
            $jacocoInit[246] = true;
            String str2 = (String) DaggerApplicationComponent.access$1000(daggerApplicationComponent3).get();
            $jacocoInit[247] = true;
            SettingsFragment_MembersInjector.injectTheme(instance, str2);
            DaggerApplicationComponent daggerApplicationComponent4 = this.this$0;
            $jacocoInit[248] = true;
            SupportEmailProvider supportEmailProvider = (SupportEmailProvider) DaggerApplicationComponent.access$5100(daggerApplicationComponent4).get();
            $jacocoInit[249] = true;
            SettingsFragment_MembersInjector.injectSupportEmailProvider(instance, supportEmailProvider);
            $jacocoInit[250] = true;
            return instance;
        }

        private StoreTabGridRecyclerFragment injectStoreTabGridRecyclerFragment(StoreTabGridRecyclerFragment instance) {
            boolean[] $jacocoInit = $jacocoInit();
            DaggerApplicationComponent daggerApplicationComponent = this.this$0;
            $jacocoInit[251] = true;
            String str = (String) DaggerApplicationComponent.access$4400(daggerApplicationComponent).get();
            $jacocoInit[252] = true;
            StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(instance, str);
            $jacocoInit[253] = true;
            return instance;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7371887183785075658L, "cm/aptoide/pt/DaggerApplicationComponent", 934);
        $jacocoData = probes;
        return probes;
    }

    /* synthetic */ DaggerApplicationComponent(Builder x0, C00371 x1) {
        boolean[] $jacocoInit = $jacocoInit();
        this(x0);
        $jacocoInit[852] = true;
    }

    static /* synthetic */ Provider access$1000(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = x0.providesAptoideThemeProvider;
        $jacocoInit[858] = true;
        return provider;
    }

    static /* synthetic */ Provider access$10100(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<MoPubConsentDialogView> provider = x0.providesMoPubConsentDialogViewProvider;
        $jacocoInit[928] = true;
        return provider;
    }

    static /* synthetic */ Provider access$10200(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<CaptionBackgroundPainter> provider = x0.providesCaptionBackgroundPainterProvider;
        $jacocoInit[929] = true;
        return provider;
    }

    static /* synthetic */ Provider access$10400(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<MyAccountManager> provider = x0.providesMyAccountManagerProvider;
        $jacocoInit[930] = true;
        return provider;
    }

    static /* synthetic */ Provider access$10500(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<RewardAppCoinsAppsRepository> provider = x0.providesRewardAppCoinsAppsRepositoryProvider;
        $jacocoInit[931] = true;
        return provider;
    }

    static /* synthetic */ Provider access$10700(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<DecimalFormat> provider = x0.providesDecimalFormatProvider;
        $jacocoInit[932] = true;
        return provider;
    }

    static /* synthetic */ Provider access$1100(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AptoideAccountManager> provider = x0.provideAptoideAccountManagerProvider;
        $jacocoInit[859] = true;
        return provider;
    }

    static /* synthetic */ Provider access$11000(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<IdsRepository> provider = x0.provideIdsRepositoryProvider;
        $jacocoInit[933] = true;
        return provider;
    }

    static /* synthetic */ Provider access$1200(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<C6666i> provider = x0.provideCallbackManagerProvider;
        $jacocoInit[860] = true;
        return provider;
    }

    static /* synthetic */ Provider access$1300(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<GoogleApiClient> provider = x0.provideGoogleApiClientProvider;
        $jacocoInit[861] = true;
        return provider;
    }

    static /* synthetic */ Provider access$1400(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AccountAnalytics> provider = x0.provideAccountAnalyticsProvider;
        $jacocoInit[862] = true;
        return provider;
    }

    static /* synthetic */ Provider access$1500(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<SharedPreferences> provider = x0.providesSecureSharedPreferencesProvider;
        $jacocoInit[863] = true;
        return provider;
    }

    static /* synthetic */ Provider access$1600(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<NotificationAnalytics> provider = x0.provideNotificationAnalyticsProvider;
        $jacocoInit[864] = true;
        return provider;
    }

    static /* synthetic */ Provider access$1700(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<StoreUtilsProxy> provider = x0.provideStoreUtilsProxyProvider;
        $jacocoInit[865] = true;
        return provider;
    }

    static /* synthetic */ Provider access$1800(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<StoreRepository> provider = x0.provideStoreRepositoryProvider;
        $jacocoInit[866] = true;
        return provider;
    }

    static /* synthetic */ Provider access$1900(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<SharedPreferences> provider = x0.providesDefaultSharedPerefencesProvider;
        $jacocoInit[867] = true;
        return provider;
    }

    static /* synthetic */ Provider access$2000(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<StoreAccessor> provider = x0.provideStoreAccessorProvider;
        $jacocoInit[868] = true;
        return provider;
    }

    static /* synthetic */ Provider access$2100(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<DeepLinkAnalytics> provider = x0.provideDeepLinkAnalyticsProvider;
        $jacocoInit[869] = true;
        return provider;
    }

    static /* synthetic */ Provider access$2200(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AppShortcutsAnalytics> provider = x0.providesAppShortcutsAnalyticsProvider;
        $jacocoInit[870] = true;
        return provider;
    }

    static /* synthetic */ Provider access$2300(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<StoreAnalytics> provider = x0.providesStoreAnalyticsProvider;
        $jacocoInit[871] = true;
        return provider;
    }

    static /* synthetic */ Provider access$2400(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AdsRepository> provider = x0.provideAdsRepositoryProvider;
        $jacocoInit[872] = true;
        return provider;
    }

    static /* synthetic */ Provider access$2500(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<Service> provider = x0.providesAutoUpdateServiceProvider;
        $jacocoInit[873] = true;
        return provider;
    }

    static /* synthetic */ Provider access$2600(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = x0.provideAutoUpdateStoreNameProvider;
        $jacocoInit[874] = true;
        return provider;
    }

    static /* synthetic */ Provider access$2700(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<DownloadFactory> provider = x0.provideDownloadFactoryProvider;
        $jacocoInit[875] = true;
        return provider;
    }

    static /* synthetic */ Provider access$2800(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<PermissionManager> provider = x0.providePermissionManagerProvider;
        $jacocoInit[876] = true;
        return provider;
    }

    static /* synthetic */ Provider access$2900(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<InstallManager> provider = x0.providesInstallManagerProvider;
        $jacocoInit[877] = true;
        return provider;
    }

    static /* synthetic */ Provider access$3000(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<DownloadAnalytics> provider = x0.providesDownloadAnalyticsProvider;
        $jacocoInit[878] = true;
        return provider;
    }

    static /* synthetic */ Provider access$3100(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<RootInstallationRetryHandler> provider = x0.provideRootInstallationRetryHandlerProvider;
        $jacocoInit[879] = true;
        return provider;
    }

    static /* synthetic */ Provider access$3200(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<UpdatesManager> provider = x0.providesUpdatesManagerProvider;
        $jacocoInit[880] = true;
        return provider;
    }

    static /* synthetic */ Provider access$3300(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<InstallAnalytics> provider = x0.provideInstallAnalyticsProvider;
        $jacocoInit[881] = true;
        return provider;
    }

    static /* synthetic */ Provider access$3400(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<DownloadStateParser> provider = x0.providesDownloadStateParserProvider;
        $jacocoInit[882] = true;
        return provider;
    }

    static /* synthetic */ Provider access$3500(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<MoPubAdsManager> provider = x0.providesMoPubAdsManagerProvider;
        $jacocoInit[883] = true;
        return provider;
    }

    static /* synthetic */ Provider access$3600(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<InstalledRepository> provider = x0.provideInstalledRepositoryProvider;
        $jacocoInit[884] = true;
        return provider;
    }

    static /* synthetic */ Provider access$3700(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<WalletAppProvider> provider = x0.providesWalletAppProvider;
        $jacocoInit[885] = true;
        return provider;
    }

    static /* synthetic */ Provider access$3800(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AppInstallerStatusReceiver> provider = x0.providesAppInstallerStatusReceiverProvider;
        $jacocoInit[886] = true;
        return provider;
    }

    static /* synthetic */ Provider access$3900(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<BodyInterceptor<BaseBody>> provider = x0.provideAccountSettingsBodyInterceptorPoolV7Provider;
        $jacocoInit[887] = true;
        return provider;
    }

    static /* synthetic */ Provider access$4000(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<OkHttpClient> provider = x0.provideOkHttpClientProvider;
        $jacocoInit[888] = true;
        return provider;
    }

    static /* synthetic */ Provider access$4100(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<Converter.Factory> provider = x0.providesConverterFactoryProvider;
        $jacocoInit[889] = true;
        return provider;
    }

    static /* synthetic */ Provider access$4200(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<TokenInvalidator> provider = x0.provideTokenInvalidatorProvider;
        $jacocoInit[890] = true;
        return provider;
    }

    static /* synthetic */ Provider access$4300(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<Resources> provider = x0.provideResourcesProvider;
        $jacocoInit[891] = true;
        return provider;
    }

    static /* synthetic */ Provider access$4400(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = x0.provideMarketNameProvider;
        $jacocoInit[892] = true;
        return provider;
    }

    static /* synthetic */ Provider access$4500(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<MarketResourceFormatter> provider = x0.provideMarketResourceFormatterProvider;
        $jacocoInit[893] = true;
        return provider;
    }

    static /* synthetic */ Provider access$4600(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<CaptchaService> provider = x0.providesCaptchaServiceProvider;
        $jacocoInit[894] = true;
        return provider;
    }

    static /* synthetic */ Provider access$4700(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<PromotionsManager> provider = x0.providePromotionsManagerProvider;
        $jacocoInit[895] = true;
        return provider;
    }

    static /* synthetic */ Provider access$4900(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<FirstLaunchAnalytics> provider = x0.providesFirstLaunchAnalyticsProvider;
        $jacocoInit[896] = true;
        return provider;
    }

    static /* synthetic */ Provider access$500(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<Map<Integer, Result>> provider = x0.provideFragmentNavigatorMapProvider;
        $jacocoInit[853] = true;
        return provider;
    }

    static /* synthetic */ Provider access$5000(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<WalletService> provider = x0.providesWalletServiceProvider;
        $jacocoInit[897] = true;
        return provider;
    }

    static /* synthetic */ Provider access$5100(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<SupportEmailProvider> provider = x0.providesSupportEmailProvider2;
        $jacocoInit[898] = true;
        return provider;
    }

    static /* synthetic */ Provider access$600(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<C0099b<Map<Integer, Result>>> provider = x0.provideFragmentNavigatorRelayProvider;
        $jacocoInit[854] = true;
        return provider;
    }

    static /* synthetic */ Provider access$6000(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<SearchManager> provider = x0.providesSearchManagerProvider;
        $jacocoInit[899] = true;
        return provider;
    }

    static /* synthetic */ Provider access$6100(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<TrendingManager> provider = x0.providesTrendingManagerProvider;
        $jacocoInit[900] = true;
        return provider;
    }

    static /* synthetic */ Provider access$6200(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<SearchSuggestionManager> provider = x0.providesSearchSuggestionManagerProvider;
        $jacocoInit[901] = true;
        return provider;
    }

    static /* synthetic */ Provider access$6500(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<BundlesRepository> provider = x0.providesBundleRepositoryProvider;
        $jacocoInit[902] = true;
        return provider;
    }

    static /* synthetic */ Provider access$6600(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<PromotionsPreferencesManager> provider = x0.providesPromotionsPreferencesManagerProvider;
        $jacocoInit[903] = true;
        return provider;
    }

    static /* synthetic */ Provider access$6700(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<BannerRepository> provider = x0.providesBannerRepositoryProvider;
        $jacocoInit[904] = true;
        return provider;
    }

    static /* synthetic */ Provider access$6800(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<BlacklistManager> provider = x0.providesBlacklistManagerProvider;
        $jacocoInit[905] = true;
        return provider;
    }

    static /* synthetic */ Provider access$6900(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = x0.provideHomePromotionsIdProvider;
        $jacocoInit[906] = true;
        return provider;
    }

    static /* synthetic */ Provider access$700(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AnalyticsManager> provider = x0.providesAnalyticsManagerProvider;
        $jacocoInit[855] = true;
        return provider;
    }

    static /* synthetic */ Provider access$7000(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<ReactionsManager> provider = x0.providesReactionsManagerProvider;
        $jacocoInit[907] = true;
        return provider;
    }

    static /* synthetic */ Provider access$7200(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AdMapper> provider = x0.providesAdMapperProvider;
        $jacocoInit[908] = true;
        return provider;
    }

    static /* synthetic */ Provider access$7300(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<UpdatesAnalytics> provider = x0.providesUpdatesAnalyticsProvider;
        $jacocoInit[909] = true;
        return provider;
    }

    static /* synthetic */ Provider access$7400(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider = x0.providesBodyInterceptorV3Provider;
        $jacocoInit[910] = true;
        return provider;
    }

    static /* synthetic */ Provider access$7500(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AppCenter> provider = x0.providesAppCenterProvider;
        $jacocoInit[911] = true;
        return provider;
    }

    static /* synthetic */ Provider access$7600(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<ReviewsManager> provider = x0.providesReviewsManagerProvider;
        $jacocoInit[912] = true;
        return provider;
    }

    static /* synthetic */ Provider access$7700(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AdsManager> provider = x0.providesAdsManagerProvider;
        $jacocoInit[913] = true;
        return provider;
    }

    static /* synthetic */ Provider access$7800(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<StoreManager> provider = x0.provideStoreManagerProvider;
        $jacocoInit[914] = true;
        return provider;
    }

    static /* synthetic */ Provider access$7900(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AppViewAnalytics> provider = x0.providesAppViewAnalyticsProvider;
        $jacocoInit[915] = true;
        return provider;
    }

    static /* synthetic */ Provider access$800(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<NavigationTracker> provider = x0.provideNavigationTrackerProvider;
        $jacocoInit[856] = true;
        return provider;
    }

    static /* synthetic */ Provider access$8000(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<WindowManager> provider = x0.provideWindowManagerProvider;
        $jacocoInit[916] = true;
        return provider;
    }

    static /* synthetic */ Provider access$8100(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AppCoinsManager> provider = x0.providesAppCoinsManagerProvider;
        $jacocoInit[917] = true;
        return provider;
    }

    static /* synthetic */ Provider access$8200(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AppcMigrationManager> provider = x0.providesAppcMigrationManagerProvider;
        $jacocoInit[918] = true;
        return provider;
    }

    static /* synthetic */ Provider access$8300(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<LocalNotificationSyncManager> provider = x0.providesLocalNotificationSyncManagerProvider;
        $jacocoInit[919] = true;
        return provider;
    }

    static /* synthetic */ Provider access$8400(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AppcMigrationService> provider = x0.providesAppcMigrationServiceProvider;
        $jacocoInit[920] = true;
        return provider;
    }

    static /* synthetic */ Provider access$8500(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<CampaignAnalytics> provider = x0.providesCampaignAnalyticsProvider;
        $jacocoInit[921] = true;
        return provider;
    }

    static /* synthetic */ Provider access$8700(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<CrashReport> provider = x0.providesCrashReportsProvider;
        $jacocoInit[922] = true;
        return provider;
    }

    static /* synthetic */ Provider access$8900(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<ChipManager> provider = x0.providesChipManagerProvider;
        $jacocoInit[923] = true;
        return provider;
    }

    static /* synthetic */ Provider access$900(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<SearchAnalytics> provider = x0.providesSearchAnalyticsProvider;
        $jacocoInit[857] = true;
        return provider;
    }

    static /* synthetic */ Provider access$9200(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<EditorialService> provider = x0.providesEditorialServiceProvider;
        $jacocoInit[924] = true;
        return provider;
    }

    static /* synthetic */ Provider access$9400(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<PromotionsAnalytics> provider = x0.providesPromotionsAnalyticsProvider;
        $jacocoInit[925] = true;
        return provider;
    }

    static /* synthetic */ Provider access$9800(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<NewsletterManager> provider = x0.providesNewsletterManagerProvider;
        $jacocoInit[926] = true;
        return provider;
    }

    static /* synthetic */ Provider access$9900(DaggerApplicationComponent x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<LoginSignupManager> provider = x0.providesLoginSignupManagerProvider;
        $jacocoInit[927] = true;
        return provider;
    }

    private DaggerApplicationComponent(Builder builder) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        initialize(builder);
        $jacocoInit[1] = true;
        initialize2(builder);
        $jacocoInit[2] = true;
        initialize3(builder);
        $jacocoInit[3] = true;
    }

    public static Builder builder() {
        boolean[] $jacocoInit = $jacocoInit();
        Builder builder = new Builder(null);
        $jacocoInit[4] = true;
        return builder;
    }

    private void initialize(Builder builder) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[5] = true;
        C13181b create = ApplicationModule_ProvideDatabaseFactory.create(Builder.access$100(builder));
        $jacocoInit[6] = true;
        this.provideDatabaseProvider = C13180a.m43109a(create);
        $jacocoInit[7] = true;
        ApplicationModule access$100 = Builder.access$100(builder);
        Provider<Database> provider = this.provideDatabaseProvider;
        $jacocoInit[8] = true;
        C13181b create2 = ApplicationModule_ProvideDownloadAccessorFactory.create(access$100, provider);
        $jacocoInit[9] = true;
        this.provideDownloadAccessorProvider = C13180a.m43109a(create2);
        $jacocoInit[10] = true;
        ApplicationModule access$1002 = Builder.access$100(builder);
        Provider<DownloadAccessor> provider2 = this.provideDownloadAccessorProvider;
        $jacocoInit[11] = true;
        C13181b create3 = ApplicationModule_ProvideDownloadsRepositoryFactory.create(access$1002, provider2);
        $jacocoInit[12] = true;
        this.provideDownloadsRepositoryProvider = C13180a.m43109a(create3);
        $jacocoInit[13] = true;
        C13181b create4 = ApplicationModule_DownloadStatusMapperFactory.create(Builder.access$100(builder));
        $jacocoInit[14] = true;
        this.downloadStatusMapperProvider = C13180a.m43109a(create4);
        $jacocoInit[15] = true;
        C13181b create5 = ApplicationModule_ProvideCachePathFactory.create(Builder.access$100(builder));
        $jacocoInit[16] = true;
        this.provideCachePathProvider = C13180a.m43109a(create5);
        $jacocoInit[17] = true;
        ApplicationModule access$1003 = Builder.access$100(builder);
        $jacocoInit[18] = true;
        C13181b create6 = ApplicationModule_ProvidesDownloadAppFileMapperFactory.create(access$1003);
        $jacocoInit[19] = true;
        this.providesDownloadAppFileMapperProvider = C13180a.m43109a(create6);
        $jacocoInit[20] = true;
        ApplicationModule access$1004 = Builder.access$100(builder);
        Provider<DownloadAppFileMapper> provider3 = this.providesDownloadAppFileMapperProvider;
        $jacocoInit[21] = true;
        C13181b create7 = ApplicationModule_ProvidesDownloadAppMapperFactory.create(access$1004, provider3);
        $jacocoInit[22] = true;
        this.providesDownloadAppMapperProvider = C13180a.m43109a(create7);
        $jacocoInit[23] = true;
        C13181b create8 = ApplicationModule_ProvideAccountManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[24] = true;
        this.provideAccountManagerProvider = C13180a.m43109a(create8);
        $jacocoInit[25] = true;
        C13181b create9 = ApplicationModule_ProvideAccountTypeFactory.create(Builder.access$100(builder));
        $jacocoInit[26] = true;
        this.provideAccountTypeProvider = C13180a.m43109a(create9);
        $jacocoInit[27] = true;
        ApplicationModule access$1005 = Builder.access$100(builder);
        Provider<AccountManager> provider4 = this.provideAccountManagerProvider;
        Provider<String> provider5 = this.provideAccountTypeProvider;
        $jacocoInit[28] = true;
        C13181b create10 = ApplicationModule_ProvideAndroidAccountProviderFactory.create(access$1005, provider4, provider5);
        $jacocoInit[29] = true;
        this.provideAndroidAccountProvider = C13180a.m43109a(create10);
        $jacocoInit[30] = true;
        ApplicationModule access$1006 = Builder.access$100(builder);
        $jacocoInit[31] = true;
        C13181b create11 = ApplicationModule_ProvidesDefaultSharedPerefencesFactory.create(access$1006);
        $jacocoInit[32] = true;
        this.providesDefaultSharedPerefencesProvider = C13180a.m43109a(create11);
        $jacocoInit[33] = true;
        C13181b create12 = ApplicationModule_ProvideContentResolverFactory.create(Builder.access$100(builder));
        $jacocoInit[34] = true;
        this.provideContentResolverProvider = C13180a.m43109a(create12);
        $jacocoInit[35] = true;
        ApplicationModule access$1007 = Builder.access$100(builder);
        Provider<SharedPreferences> provider6 = this.providesDefaultSharedPerefencesProvider;
        Provider<ContentResolver> provider7 = this.provideContentResolverProvider;
        $jacocoInit[36] = true;
        C13181b create13 = ApplicationModule_ProvideIdsRepositoryFactory.create(access$1007, provider6, provider7);
        $jacocoInit[37] = true;
        this.provideIdsRepositoryProvider = C13180a.m43109a(create13);
        $jacocoInit[38] = true;
        FlavourApplicationModule access$200 = Builder.access$200(builder);
        $jacocoInit[39] = true;
        C13181b create14 = FlavourApplicationModule_ProvidePartnerIDFactory.create(access$200);
        $jacocoInit[40] = true;
        this.providePartnerIDProvider = C13180a.m43109a(create14);
        $jacocoInit[41] = true;
        ApplicationModule access$1008 = Builder.access$100(builder);
        Provider<AndroidAccountProvider> provider8 = this.provideAndroidAccountProvider;
        Provider<IdsRepository> provider9 = this.provideIdsRepositoryProvider;
        Provider<String> provider10 = this.providePartnerIDProvider;
        $jacocoInit[42] = true;
        C13181b create15 = ApplicationModule_ProvideUserAgentInterceptorFactory.create(access$1008, provider8, provider9, provider10);
        $jacocoInit[43] = true;
        this.provideUserAgentInterceptorProvider = C13180a.m43109a(create15);
        $jacocoInit[44] = true;
        ApplicationModule access$1009 = Builder.access$100(builder);
        Provider<AndroidAccountProvider> provider11 = this.provideAndroidAccountProvider;
        $jacocoInit[45] = true;
        C13181b create16 = ApplicationModule_ProvideAuthenticationPersistenceFactory.create(access$1009, provider11);
        $jacocoInit[46] = true;
        this.provideAuthenticationPersistenceProvider = C13180a.m43109a(create16);
        $jacocoInit[47] = true;
        C13181b create17 = ApplicationModule_ProvideNonNullObjectMapperFactory.create(Builder.access$100(builder));
        $jacocoInit[48] = true;
        this.provideNonNullObjectMapperProvider = C13180a.m43109a(create17);
        $jacocoInit[49] = true;
        ApplicationModule access$10010 = Builder.access$100(builder);
        Provider<ObjectMapper> provider12 = this.provideNonNullObjectMapperProvider;
        $jacocoInit[50] = true;
        C13181b create18 = ApplicationModule_ProvidesRealmEventMapperFactory.create(access$10010, provider12);
        $jacocoInit[51] = true;
        this.providesRealmEventMapperProvider = C13180a.m43109a(create18);
        $jacocoInit[52] = true;
        ApplicationModule access$10011 = Builder.access$100(builder);
        Provider<Database> provider13 = this.provideDatabaseProvider;
        Provider<RealmEventMapper> provider14 = this.providesRealmEventMapperProvider;
        $jacocoInit[53] = true;
        C13181b create19 = ApplicationModule_ProvidesEventsPersistenceFactory.create(access$10011, provider13, provider14);
        $jacocoInit[54] = true;
        this.providesEventsPersistenceProvider = C13180a.m43109a(create19);
        $jacocoInit[55] = true;
        ApplicationModule access$10012 = Builder.access$100(builder);
        Provider<SharedPreferences> provider15 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[56] = true;
        C13181b create20 = ApplicationModule_ProvidesBaseHostFactory.create(access$10012, provider15);
        $jacocoInit[57] = true;
        this.providesBaseHostProvider = C13180a.m43109a(create20);
        $jacocoInit[58] = true;
        C13181b create21 = ApplicationModule_ProvideL2CacheFactory.create(Builder.access$100(builder));
        $jacocoInit[59] = true;
        this.provideL2CacheProvider = C13180a.m43109a(create21);
        $jacocoInit[60] = true;
        ApplicationModule access$10013 = Builder.access$100(builder);
        $jacocoInit[61] = true;
        C13181b create22 = ApplicationModule_ProvideRetrofitLogInterceptorFactory.create(access$10013);
        $jacocoInit[62] = true;
        this.provideRetrofitLogInterceptorProvider = C13180a.m43109a(create22);
        $jacocoInit[63] = true;
        ApplicationModule access$10014 = Builder.access$100(builder);
        Provider<L2Cache> provider16 = this.provideL2CacheProvider;
        Provider<Interceptor> provider17 = this.provideUserAgentInterceptorProvider;
        Provider<SharedPreferences> provider18 = this.providesDefaultSharedPerefencesProvider;
        Provider<Interceptor> provider19 = this.provideRetrofitLogInterceptorProvider;
        $jacocoInit[64] = true;
        C13181b create23 = ApplicationModule_ProvideOkHttpClientFactory.create(access$10014, provider16, provider17, provider18, provider19);
        $jacocoInit[65] = true;
        this.provideOkHttpClientProvider = C13180a.m43109a(create23);
        $jacocoInit[66] = true;
        C13181b create24 = ApplicationModule_ProvidesConverterFactoryFactory.create(Builder.access$100(builder));
        $jacocoInit[67] = true;
        this.providesConverterFactoryProvider = C13180a.m43109a(create24);
        $jacocoInit[68] = true;
        C13181b create25 = ApplicationModule_ProvidesCallAdapterFactoryFactory.create(Builder.access$100(builder));
        $jacocoInit[69] = true;
        this.providesCallAdapterFactoryProvider = C13180a.m43109a(create25);
        $jacocoInit[70] = true;
        ApplicationModule access$10015 = Builder.access$100(builder);
        Provider<String> provider20 = this.providesBaseHostProvider;
        Provider<OkHttpClient> provider21 = this.provideOkHttpClientProvider;
        Provider<Converter.Factory> provider22 = this.providesConverterFactoryProvider;
        Provider<Factory> provider23 = this.providesCallAdapterFactoryProvider;
        $jacocoInit[71] = true;
        C13181b create26 = ApplicationModule_ProvidesV7RetrofitFactory.create(access$10015, provider20, provider21, provider22, provider23);
        $jacocoInit[72] = true;
        this.providesV7RetrofitProvider = C13180a.m43109a(create26);
        $jacocoInit[73] = true;
        ApplicationModule access$10016 = Builder.access$100(builder);
        Provider<Retrofit> provider24 = this.providesV7RetrofitProvider;
        $jacocoInit[74] = true;
        C13181b create27 = ApplicationModule_ProvidesAptoideBiServiceFactory.create(access$10016, provider24);
        $jacocoInit[75] = true;
        this.providesAptoideBiServiceProvider = C13180a.m43109a(create27);
        $jacocoInit[76] = true;
        C13181b create28 = ApplicationModule_ProvideResourcesFactory.create(Builder.access$100(builder));
        $jacocoInit[77] = true;
        this.provideResourcesProvider = C13180a.m43109a(create28);
        $jacocoInit[78] = true;
        C13181b create29 = ApplicationModule_ProvideWindowManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[79] = true;
        this.provideWindowManagerProvider = C13180a.m43109a(create29);
        $jacocoInit[80] = true;
        ApplicationModule access$10017 = Builder.access$100(builder);
        Provider<SharedPreferences> provider25 = this.providesDefaultSharedPerefencesProvider;
        Provider<Resources> provider26 = this.provideResourcesProvider;
        Provider<WindowManager> provider27 = this.provideWindowManagerProvider;
        $jacocoInit[81] = true;
        C13181b create30 = ApplicationModule_ProvideQManagerFactory.create(access$10017, provider25, provider26, provider27);
        $jacocoInit[82] = true;
        this.provideQManagerProvider = C13180a.m43109a(create30);
        $jacocoInit[83] = true;
        C13181b create31 = ApplicationModule_ProvideAptoidePackageFactory.create(Builder.access$100(builder));
        $jacocoInit[84] = true;
        this.provideAptoidePackageProvider = C13180a.m43109a(create31);
        $jacocoInit[85] = true;
        ApplicationModule access$10018 = Builder.access$100(builder);
        Provider<AuthenticationPersistence> provider28 = this.provideAuthenticationPersistenceProvider;
        Provider<IdsRepository> provider29 = this.provideIdsRepositoryProvider;
        Provider<SharedPreferences> provider30 = this.providesDefaultSharedPerefencesProvider;
        Provider<Resources> provider31 = this.provideResourcesProvider;
        Provider<QManager> provider32 = this.provideQManagerProvider;
        Provider<String> provider33 = this.provideAptoidePackageProvider;
        $jacocoInit[86] = true;
        C13181b create32 = ApplicationModule_ProvideAnalyticsBodyInterceptorV7Factory.create(access$10018, provider28, provider29, provider30, provider31, provider32, provider33);
        $jacocoInit[87] = true;
        this.provideAnalyticsBodyInterceptorV7Provider = C13180a.m43109a(create32);
        $jacocoInit[88] = true;
        ApplicationModule access$10019 = Builder.access$100(builder);
        Provider<RetrofitAptoideBiService.ServiceV7> provider34 = this.providesAptoideBiServiceProvider;
        Provider<AnalyticsBodyInterceptorV7> provider35 = this.provideAnalyticsBodyInterceptorV7Provider;
        $jacocoInit[89] = true;
        C13181b create33 = ApplicationModule_ProvidesRetrofitAptoideBiServiceFactory.create(access$10019, provider34, provider35);
        $jacocoInit[90] = true;
        this.providesRetrofitAptoideBiServiceProvider = C13180a.m43109a(create33);
        $jacocoInit[91] = true;
        C13181b create34 = ApplicationModule_ProvideFabricFactory.create(Builder.access$100(builder));
        $jacocoInit[92] = true;
        this.provideFabricProvider = C13180a.m43109a(create34);
        $jacocoInit[93] = true;
        ApplicationModule access$10020 = Builder.access$100(builder);
        Provider<C13920f> provider36 = this.provideFabricProvider;
        $jacocoInit[94] = true;
        C13181b create35 = ApplicationModule_ProvideCrashlyticsFactory.create(access$10020, provider36);
        $jacocoInit[95] = true;
        this.provideCrashlyticsProvider = C13180a.m43109a(create35);
        $jacocoInit[96] = true;
        ApplicationModule access$10021 = Builder.access$100(builder);
        $jacocoInit[97] = true;
        C13181b create36 = ApplicationModule_ProvidesAnalyticsDebugLoggerFactory.create(access$10021);
        $jacocoInit[98] = true;
        this.providesAnalyticsDebugLoggerProvider = C13180a.m43109a(create36);
        $jacocoInit[99] = true;
        ApplicationModule access$10022 = Builder.access$100(builder);
        Provider<EventsPersistence> provider37 = this.providesEventsPersistenceProvider;
        Provider<AptoideBiEventService> provider38 = this.providesRetrofitAptoideBiServiceProvider;
        Provider<C0075a> provider39 = this.provideCrashlyticsProvider;
        Provider<SharedPreferences> provider40 = this.providesDefaultSharedPerefencesProvider;
        Provider<AnalyticsLogger> provider41 = this.providesAnalyticsDebugLoggerProvider;
        $jacocoInit[100] = true;
        C13181b create37 = ApplicationModule_ProvidesAptoideBILoggerFactory.create(access$10022, provider37, provider38, provider39, provider40, provider41);
        $jacocoInit[101] = true;
        this.providesAptoideBILoggerProvider = C13180a.m43109a(create37);
        $jacocoInit[102] = true;
        ApplicationModule access$10023 = Builder.access$100(builder);
        Provider<AptoideBiEventLogger> provider42 = this.providesAptoideBILoggerProvider;
        $jacocoInit[103] = true;
        C13181b create38 = ApplicationModule_ProvidesAptoideEventLoggerFactory.create(access$10023, provider42);
        $jacocoInit[104] = true;
        this.providesAptoideEventLoggerProvider = C13180a.m43109a(create38);
        $jacocoInit[105] = true;
        C13181b create39 = ApplicationModule_ProvideAppEventsLoggerFactory.create(Builder.access$100(builder));
        $jacocoInit[106] = true;
        this.provideAppEventsLoggerProvider = C13180a.m43109a(create39);
        $jacocoInit[107] = true;
        ApplicationModule access$10024 = Builder.access$100(builder);
        Provider<C6638q> provider43 = this.provideAppEventsLoggerProvider;
        Provider<AnalyticsLogger> provider44 = this.providesAnalyticsDebugLoggerProvider;
        $jacocoInit[108] = true;
        C13181b create40 = ApplicationModule_ProvidesFacebookEventLoggerFactory.create(access$10024, provider43, provider44);
        $jacocoInit[109] = true;
        this.providesFacebookEventLoggerProvider = C13180a.m43109a(create40);
        $jacocoInit[110] = true;
        ApplicationModule access$10025 = Builder.access$100(builder);
        Provider<C13920f> provider45 = this.provideFabricProvider;
        $jacocoInit[111] = true;
        C13181b create41 = ApplicationModule_ProvideAnswersFactory.create(access$10025, provider45);
        $jacocoInit[112] = true;
        this.provideAnswersProvider = C13180a.m43109a(create41);
        $jacocoInit[113] = true;
        ApplicationModule access$10026 = Builder.access$100(builder);
        Provider<C6378b> provider46 = this.provideAnswersProvider;
        Provider<AnalyticsLogger> provider47 = this.providesAnalyticsDebugLoggerProvider;
        $jacocoInit[114] = true;
        C13181b create42 = ApplicationModule_ProvidesFabricEventLoggerFactory.create(access$10026, provider46, provider47);
        $jacocoInit[115] = true;
        this.providesFabricEventLoggerProvider = C13180a.m43109a(create42);
        $jacocoInit[116] = true;
        ApplicationModule access$10027 = Builder.access$100(builder);
        Provider<AnalyticsLogger> provider48 = this.providesAnalyticsDebugLoggerProvider;
        $jacocoInit[117] = true;
        C13181b create43 = ApplicationModule_ProvidesFlurryLoggerFactory.create(access$10027, provider48);
        $jacocoInit[118] = true;
        this.providesFlurryLoggerProvider = C13180a.m43109a(create43);
        $jacocoInit[119] = true;
        ApplicationModule access$10028 = Builder.access$100(builder);
        Provider<FlurryEventLogger> provider49 = this.providesFlurryLoggerProvider;
        $jacocoInit[120] = true;
        C13181b create44 = ApplicationModule_ProvidesFlurryEventLoggerFactory.create(access$10028, provider49);
        $jacocoInit[121] = true;
        this.providesFlurryEventLoggerProvider = C13180a.m43109a(create44);
        $jacocoInit[122] = true;
        ApplicationModule access$10029 = Builder.access$100(builder);
        Provider<OkHttpClient> provider50 = this.provideOkHttpClientProvider;
        $jacocoInit[123] = true;
        C13181b create45 = ApplicationModule_ProvidesknockEventLoggerFactory.create(access$10029, provider50);
        $jacocoInit[124] = true;
        this.providesknockEventLoggerProvider = C13180a.m43109a(create45);
        $jacocoInit[125] = true;
        C13181b create46 = ApplicationModule_ProvideAptoideEventsFactory.create(Builder.access$100(builder));
        $jacocoInit[126] = true;
        this.provideAptoideEventsProvider = C13180a.m43109a(create46);
        $jacocoInit[127] = true;
        C13181b create47 = ApplicationModule_ProvideFacebookEventsFactory.create(Builder.access$100(builder));
        $jacocoInit[128] = true;
        this.provideFacebookEventsProvider = C13180a.m43109a(create47);
        $jacocoInit[129] = true;
        C13181b create48 = ApplicationModule_ProvideFabricEventsFactory.create(Builder.access$100(builder));
        $jacocoInit[130] = true;
        this.provideFabricEventsProvider = C13180a.m43109a(create48);
        $jacocoInit[131] = true;
        C13181b create49 = ApplicationModule_ProvideFlurryEventsFactory.create(Builder.access$100(builder));
        $jacocoInit[132] = true;
        this.provideFlurryEventsProvider = C13180a.m43109a(create49);
        $jacocoInit[133] = true;
        ApplicationModule access$10030 = Builder.access$100(builder);
        Provider<FlurryEventLogger> provider51 = this.providesFlurryLoggerProvider;
        $jacocoInit[134] = true;
        C13181b create50 = ApplicationModule_ProvidesFlurrySessionLoggerFactory.create(access$10030, provider51);
        $jacocoInit[135] = true;
        this.providesFlurrySessionLoggerProvider = C13180a.m43109a(create50);
        $jacocoInit[136] = true;
        ApplicationModule access$10031 = Builder.access$100(builder);
        Provider<AptoideBiEventLogger> provider52 = this.providesAptoideBILoggerProvider;
        $jacocoInit[137] = true;
        C13181b create51 = ApplicationModule_ProvidesAptoideSessionLoggerFactory.create(access$10031, provider52);
        $jacocoInit[138] = true;
        this.providesAptoideSessionLoggerProvider = C13180a.m43109a(create51);
        $jacocoInit[139] = true;
        C13181b create52 = ApplicationModule_ProvidesAnalyticsNormalizerFactory.create(Builder.access$100(builder));
        $jacocoInit[140] = true;
        this.providesAnalyticsNormalizerProvider = C13180a.m43109a(create52);
        $jacocoInit[141] = true;
        ApplicationModule access$10032 = Builder.access$100(builder);
        Provider<EventLogger> provider53 = this.providesAptoideEventLoggerProvider;
        Provider<EventLogger> provider54 = this.providesFacebookEventLoggerProvider;
        Provider<EventLogger> provider55 = this.providesFabricEventLoggerProvider;
        Provider<EventLogger> provider56 = this.providesFlurryEventLoggerProvider;
        Provider<HttpKnockEventLogger> provider57 = this.providesknockEventLoggerProvider;
        Provider<Collection<String>> provider58 = this.provideAptoideEventsProvider;
        Provider<Collection<String>> provider59 = this.provideFacebookEventsProvider;
        Provider<Collection<String>> provider60 = this.provideFabricEventsProvider;
        Provider<Collection<String>> provider61 = this.provideFlurryEventsProvider;
        Provider<SessionLogger> provider62 = this.providesFlurrySessionLoggerProvider;
        Provider<SessionLogger> provider63 = this.providesAptoideSessionLoggerProvider;
        Provider<AnalyticsEventParametersNormalizer> provider64 = this.providesAnalyticsNormalizerProvider;
        Provider<AnalyticsLogger> provider65 = this.providesAnalyticsDebugLoggerProvider;
        $jacocoInit[142] = true;
        C13181b create53 = ApplicationModule_ProvidesAnalyticsManagerFactory.create(access$10032, provider53, provider54, provider55, provider56, provider57, provider58, provider59, provider60, provider61, provider62, provider63, provider64, provider65);
        $jacocoInit[143] = true;
        this.providesAnalyticsManagerProvider = C13180a.m43109a(create53);
        $jacocoInit[144] = true;
        ApplicationModule access$10033 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider66 = this.providesAnalyticsManagerProvider;
        $jacocoInit[145] = true;
        C13181b create54 = ApplicationModule_ProvidePageViewsAnalyticsFactory.create(access$10033, provider66);
        $jacocoInit[146] = true;
        this.providePageViewsAnalyticsProvider = C13180a.m43109a(create54);
        $jacocoInit[147] = true;
        ApplicationModule access$10034 = Builder.access$100(builder);
        Provider<PageViewsAnalytics> provider67 = this.providePageViewsAnalyticsProvider;
        Provider<AnalyticsLogger> provider68 = this.providesAnalyticsDebugLoggerProvider;
        $jacocoInit[148] = true;
        C13181b create55 = ApplicationModule_ProvideNavigationTrackerFactory.create(access$10034, provider67, provider68);
        $jacocoInit[149] = true;
        this.provideNavigationTrackerProvider = C13180a.m43109a(create55);
        $jacocoInit[150] = true;
        C13181b create56 = ApplicationModule_ProvidesConnectivityManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[151] = true;
        this.providesConnectivityManagerProvider = C13180a.m43109a(create56);
        $jacocoInit[152] = true;
        C13181b create57 = ApplicationModule_ProvidesTelephonyManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[153] = true;
        this.providesTelephonyManagerProvider = C13180a.m43109a(create57);
        $jacocoInit[154] = true;
        ApplicationModule access$10035 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider69 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider70 = this.provideNavigationTrackerProvider;
        Provider<ConnectivityManager> provider71 = this.providesConnectivityManagerProvider;
        Provider<TelephonyManager> provider72 = this.providesTelephonyManagerProvider;
        $jacocoInit[155] = true;
        C13181b create58 = ApplicationModule_ProvidesDownloadAnalyticsFactory.create(access$10035, provider69, provider70, provider71, provider72);
        $jacocoInit[156] = true;
        this.providesDownloadAnalyticsProvider = C13180a.m43109a(create58);
        $jacocoInit[157] = true;
        ApplicationModule access$10036 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider73 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider74 = this.provideNavigationTrackerProvider;
        Provider<ConnectivityManager> provider75 = this.providesConnectivityManagerProvider;
        Provider<TelephonyManager> provider76 = this.providesTelephonyManagerProvider;
        $jacocoInit[158] = true;
        C13181b create59 = ApplicationModule_ProvideInstallAnalyticsFactory.create(access$10036, provider73, provider74, provider75, provider76);
        $jacocoInit[159] = true;
        this.provideInstallAnalyticsProvider = C13180a.m43109a(create59);
        $jacocoInit[160] = true;
        ApplicationModule access$10037 = Builder.access$100(builder);
        Provider<String> provider77 = this.provideCachePathProvider;
        $jacocoInit[161] = true;
        C13181b create60 = ApplicationModule_ProvidesMd5ComparatorFactory.create(access$10037, provider77);
        $jacocoInit[162] = true;
        this.providesMd5ComparatorProvider = C13180a.m43109a(create60);
        $jacocoInit[163] = true;
        ApplicationModule access$10038 = Builder.access$100(builder);
        Provider<String> provider78 = this.provideCachePathProvider;
        Provider<Interceptor> provider79 = this.provideUserAgentInterceptorProvider;
        Provider<AuthenticationPersistence> provider80 = this.provideAuthenticationPersistenceProvider;
        Provider<DownloadAnalytics> provider81 = this.providesDownloadAnalyticsProvider;
        Provider<InstallAnalytics> provider82 = this.provideInstallAnalyticsProvider;
        Provider<Md5Comparator> provider83 = this.providesMd5ComparatorProvider;
        $jacocoInit[164] = true;
        C13181b create61 = ApplicationModule_ProvidesFileDownloaderProviderFactory.create(access$10038, provider78, provider79, provider80, provider81, provider82, provider83);
        $jacocoInit[165] = true;
        this.providesFileDownloaderProvider = C13180a.m43109a(create61);
        $jacocoInit[166] = true;
        ApplicationModule access$10039 = Builder.access$100(builder);
        Provider<FileDownloaderProvider> provider84 = this.providesFileDownloaderProvider;
        $jacocoInit[167] = true;
        C13181b create62 = ApplicationModule_ProvidesRetryFileDownloaderProviderFactory.create(access$10039, provider84);
        $jacocoInit[168] = true;
        this.providesRetryFileDownloaderProvider = C13180a.m43109a(create62);
        $jacocoInit[169] = true;
        ApplicationModule access$10040 = Builder.access$100(builder);
        Provider<RetryFileDownloaderProvider> provider85 = this.providesRetryFileDownloaderProvider;
        Provider<DownloadAnalytics> provider86 = this.providesDownloadAnalyticsProvider;
        $jacocoInit[170] = true;
        C13181b create63 = ApplicationModule_ProvidesAppDownloaderProviderFactory.create(access$10040, provider85, provider86);
        $jacocoInit[171] = true;
        this.providesAppDownloaderProvider = C13180a.m43109a(create63);
        $jacocoInit[172] = true;
        ApplicationModule access$10041 = Builder.access$100(builder);
        Provider<String> provider87 = this.provideCachePathProvider;
        $jacocoInit[173] = true;
        C13181b create64 = ApplicationModule_ProvideApkPathFactory.create(access$10041, provider87);
        $jacocoInit[174] = true;
        this.provideApkPathProvider = C13180a.m43109a(create64);
        $jacocoInit[175] = true;
        ApplicationModule access$10042 = Builder.access$100(builder);
        Provider<String> provider88 = this.provideCachePathProvider;
        $jacocoInit[176] = true;
        C13181b create65 = ApplicationModule_ProvideObbPathFactory.create(access$10042, provider88);
        $jacocoInit[177] = true;
        this.provideObbPathProvider = C13180a.m43109a(create65);
        $jacocoInit[178] = true;
        ApplicationModule access$10043 = Builder.access$100(builder);
        Provider<DownloadsRepository> provider89 = this.provideDownloadsRepositoryProvider;
        Provider<DownloadStatusMapper> provider90 = this.downloadStatusMapperProvider;
        Provider<String> provider91 = this.provideCachePathProvider;
        Provider<DownloadAppMapper> provider92 = this.providesDownloadAppMapperProvider;
        Provider<AppDownloaderProvider> provider93 = this.providesAppDownloaderProvider;
        Provider<String> provider94 = this.provideApkPathProvider;
        Provider<String> provider95 = this.provideObbPathProvider;
        Provider<DownloadAnalytics> provider96 = this.providesDownloadAnalyticsProvider;
        $jacocoInit[179] = true;
        C13181b create66 = ApplicationModule_ProvideAptoideDownloadManagerFactory.create(access$10043, provider89, provider90, provider91, provider92, provider93, provider94, provider95, provider96);
        $jacocoInit[180] = true;
        this.provideAptoideDownloadManagerProvider = C13180a.m43109a(create66);
        $jacocoInit[181] = true;
        ApplicationModule access$10044 = Builder.access$100(builder);
        Provider<SharedPreferences> provider97 = this.providesDefaultSharedPerefencesProvider;
        Provider<String> provider98 = this.provideCachePathProvider;
        $jacocoInit[182] = true;
        C13181b create67 = ApplicationModule_ProvideCacheHelperFactory.create(access$10044, provider97, provider98);
        $jacocoInit[183] = true;
        this.provideCacheHelperProvider = C13180a.m43109a(create67);
        $jacocoInit[184] = true;
        ApplicationModule access$10045 = Builder.access$100(builder);
        Provider<SharedPreferences> provider99 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[185] = true;
        C13181b create68 = ApplicationModule_ProvideDefaultPreferencesFactory.create(access$10045, provider99);
        $jacocoInit[186] = true;
        this.provideDefaultPreferencesProvider = C13180a.m43109a(create68);
        $jacocoInit[187] = true;
        ApplicationModule access$10046 = Builder.access$100(builder);
        Provider<SharedPreferences> provider100 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[188] = true;
        C13181b create69 = ApplicationModule_ProvideSecureCoderDecoderFactory.create(access$10046, provider100);
        $jacocoInit[189] = true;
        this.provideSecureCoderDecoderProvider = C13180a.m43109a(create69);
        $jacocoInit[190] = true;
        ApplicationModule access$10047 = Builder.access$100(builder);
        Provider<SharedPreferences> provider101 = this.providesDefaultSharedPerefencesProvider;
        Provider<SecureCoderDecoder> provider102 = this.provideSecureCoderDecoderProvider;
        $jacocoInit[191] = true;
        C13181b create70 = ApplicationModule_ProvidesSecurePerefencesFactory.create(access$10047, provider101, provider102);
        $jacocoInit[192] = true;
        this.providesSecurePerefencesProvider = C13180a.m43109a(create70);
        $jacocoInit[193] = true;
        FlavourApplicationModule access$2002 = Builder.access$200(builder);
        Provider<Preferences> provider103 = this.provideDefaultPreferencesProvider;
        Provider<SecurePreferences> provider104 = this.providesSecurePerefencesProvider;
        $jacocoInit[194] = true;
        C13181b create71 = FlavourApplicationModule_ProvideLocalAdultContentFactory.create(access$2002, provider103, provider104);
        $jacocoInit[195] = true;
        this.provideLocalAdultContentProvider = C13180a.m43109a(create71);
        $jacocoInit[196] = true;
        ApplicationModule access$10048 = Builder.access$100(builder);
        Provider<Interceptor> provider105 = this.provideUserAgentInterceptorProvider;
        Provider<SharedPreferences> provider106 = this.providesDefaultSharedPerefencesProvider;
        Provider<Interceptor> provider107 = this.provideRetrofitLogInterceptorProvider;
        $jacocoInit[197] = true;
        C13181b create72 = ApplicationModule_ProvideLongTimeoutOkHttpClientFactory.create(access$10048, provider105, provider106, provider107);
        $jacocoInit[198] = true;
        this.provideLongTimeoutOkHttpClientProvider = C13180a.m43109a(create72);
        $jacocoInit[199] = true;
        ApplicationModule access$10049 = Builder.access$100(builder);
        Provider<IdsRepository> provider108 = this.provideIdsRepositoryProvider;
        Provider<String> provider109 = this.provideAptoidePackageProvider;
        $jacocoInit[200] = true;
        C13181b create73 = C1362xcbc5ac1.create(access$10049, provider108, provider109);
        $jacocoInit[201] = true;
        this.provideNoAuthenticationBodyInterceptorV3Provider = C13180a.m43109a(create73);
        $jacocoInit[202] = true;
        C13181b create74 = ApplicationModule_ProvideExtraIDFactory.create(Builder.access$100(builder));
        $jacocoInit[203] = true;
        this.provideExtraIDProvider = C13180a.m43109a(create74);
        $jacocoInit[204] = true;
        ApplicationModule access$10050 = Builder.access$100(builder);
        Provider<OkHttpClient> provider110 = this.provideOkHttpClientProvider;
        Provider<SharedPreferences> provider111 = this.providesDefaultSharedPerefencesProvider;
        Provider<AuthenticationPersistence> provider112 = this.provideAuthenticationPersistenceProvider;
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider113 = this.provideNoAuthenticationBodyInterceptorV3Provider;
        Provider<String> provider114 = this.provideExtraIDProvider;
        $jacocoInit[205] = true;
        C13181b create75 = ApplicationModule_ProvideTokenInvalidatorFactory.create(access$10050, provider110, provider111, provider112, provider113, provider114);
        $jacocoInit[206] = true;
        this.provideTokenInvalidatorProvider = C13180a.m43109a(create75);
        $jacocoInit[207] = true;
        ApplicationModule access$10051 = Builder.access$100(builder);
        Provider<AuthenticationPersistence> provider115 = this.provideAuthenticationPersistenceProvider;
        Provider<IdsRepository> provider116 = this.provideIdsRepositoryProvider;
        Provider<SharedPreferences> provider117 = this.providesDefaultSharedPerefencesProvider;
        Provider<Resources> provider118 = this.provideResourcesProvider;
        Provider<QManager> provider119 = this.provideQManagerProvider;
        Provider<String> provider120 = this.provideAptoidePackageProvider;
        $jacocoInit[208] = true;
        C13181b create76 = ApplicationModule_ProvideBodyInterceptorPoolV7Factory.create(access$10051, provider115, provider116, provider117, provider118, provider119, provider120);
        $jacocoInit[209] = true;
        this.provideBodyInterceptorPoolV7Provider = C13180a.m43109a(create76);
        $jacocoInit[210] = true;
        ApplicationModule access$10052 = Builder.access$100(builder);
        Provider<AuthenticationPersistence> provider121 = this.provideAuthenticationPersistenceProvider;
        Provider<IdsRepository> provider122 = this.provideIdsRepositoryProvider;
        Provider<SharedPreferences> provider123 = this.providesDefaultSharedPerefencesProvider;
        Provider<Resources> provider124 = this.provideResourcesProvider;
        Provider<QManager> provider125 = this.provideQManagerProvider;
        Provider<String> provider126 = this.provideAptoidePackageProvider;
        $jacocoInit[211] = true;
        C13181b create77 = ApplicationModule_ProvideBodyInterceptorWebV7Factory.create(access$10052, provider121, provider122, provider123, provider124, provider125, provider126);
        $jacocoInit[212] = true;
        this.provideBodyInterceptorWebV7Provider = C13180a.m43109a(create77);
        $jacocoInit[213] = true;
        C13181b create78 = ApplicationModule_ProvideRequestBodyFactoryFactory.create(Builder.access$100(builder));
        $jacocoInit[214] = true;
        this.provideRequestBodyFactoryProvider = C13180a.m43109a(create78);
        $jacocoInit[215] = true;
        ApplicationModule access$10053 = Builder.access$100(builder);
        Provider<IdsRepository> provider127 = this.provideIdsRepositoryProvider;
        Provider<AuthenticationPersistence> provider128 = this.provideAuthenticationPersistenceProvider;
        Provider<RequestBodyFactory> provider129 = this.provideRequestBodyFactoryProvider;
        $jacocoInit[216] = true;
        C13181b create79 = ApplicationModule_ProvideMultipartBodyInterceptorFactory.create(access$10053, provider127, provider128, provider129);
        $jacocoInit[217] = true;
        this.provideMultipartBodyInterceptorProvider = C13180a.m43109a(create79);
        $jacocoInit[218] = true;
        ApplicationModule access$10054 = Builder.access$100(builder);
        Provider<TelephonyManager> provider130 = this.providesTelephonyManagerProvider;
        $jacocoInit[219] = true;
        C13181b create80 = ApplicationModule_ProvidesNetworkOperatorManagerFactory.create(access$10054, provider130);
        $jacocoInit[220] = true;
        this.providesNetworkOperatorManagerProvider = C13180a.m43109a(create80);
        $jacocoInit[221] = true;
        ApplicationModule access$10055 = Builder.access$100(builder);
        Provider<IdsRepository> provider131 = this.provideIdsRepositoryProvider;
        Provider<QManager> provider132 = this.provideQManagerProvider;
        Provider<SharedPreferences> provider133 = this.providesDefaultSharedPerefencesProvider;
        Provider<NetworkOperatorManager> provider134 = this.providesNetworkOperatorManagerProvider;
        Provider<AuthenticationPersistence> provider135 = this.provideAuthenticationPersistenceProvider;
        Provider<String> provider136 = this.provideAptoidePackageProvider;
        $jacocoInit[222] = true;
        C13181b create81 = ApplicationModule_ProvidesBodyInterceptorV3Factory.create(access$10055, provider131, provider132, provider133, provider134, provider135, provider136);
        $jacocoInit[223] = true;
        this.providesBodyInterceptorV3Provider = C13180a.m43109a(create81);
        $jacocoInit[224] = true;
        C13181b create82 = ApplicationModule_ProvideAccountFactoryFactory.create(Builder.access$100(builder));
        $jacocoInit[225] = true;
        this.provideAccountFactoryProvider = C13180a.m43109a(create82);
        $jacocoInit[226] = true;
        C13181b create83 = ApplicationModule_ProvideOAuthModeProviderFactory.create(Builder.access$100(builder));
        $jacocoInit[227] = true;
        this.provideOAuthModeProvider = C13180a.m43109a(create83);
        $jacocoInit[228] = true;
        ApplicationModule access$10056 = Builder.access$100(builder);
        Provider<OkHttpClient> provider137 = this.provideOkHttpClientProvider;
        Provider<OkHttpClient> provider138 = this.provideLongTimeoutOkHttpClientProvider;
        Provider<SharedPreferences> provider139 = this.providesDefaultSharedPerefencesProvider;
        Provider<AuthenticationPersistence> provider140 = this.provideAuthenticationPersistenceProvider;
        Provider<TokenInvalidator> provider141 = this.provideTokenInvalidatorProvider;
        Provider<BodyInterceptor<BaseBody>> provider142 = this.provideBodyInterceptorPoolV7Provider;
        Provider<BodyInterceptor<BaseBody>> provider143 = this.provideBodyInterceptorWebV7Provider;
        Provider<MultipartBodyInterceptor> provider144 = this.provideMultipartBodyInterceptorProvider;
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider145 = this.provideNoAuthenticationBodyInterceptorV3Provider;
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider146 = this.providesBodyInterceptorV3Provider;
        Provider<ObjectMapper> provider147 = this.provideNonNullObjectMapperProvider;
        Provider<Converter.Factory> provider148 = this.providesConverterFactoryProvider;
        Provider<String> provider149 = this.provideExtraIDProvider;
        Provider<AccountFactory> provider150 = this.provideAccountFactoryProvider;
        Provider<OAuthModeProvider> provider151 = this.provideOAuthModeProvider;
        $jacocoInit[229] = true;
        C13181b create84 = ApplicationModule_ProvideAccountServiceFactory.create(access$10056, provider137, provider138, provider139, provider140, provider141, provider142, provider143, provider144, provider145, provider146, provider147, provider148, provider149, provider150, provider151);
        $jacocoInit[230] = true;
        this.provideAccountServiceProvider = C13180a.m43109a(create84);
        $jacocoInit[231] = true;
        FlavourApplicationModule access$2003 = Builder.access$200(builder);
        Provider<LocalPersistenceAdultContent> provider152 = this.provideLocalAdultContentProvider;
        Provider<AccountService> provider153 = this.provideAccountServiceProvider;
        $jacocoInit[232] = true;
        C13181b create85 = FlavourApplicationModule_ProvideAdultContentFactory.create(access$2003, provider152, provider153);
        $jacocoInit[233] = true;
        this.provideAdultContentProvider = C13180a.m43109a(create85);
        $jacocoInit[234] = true;
        ApplicationModule access$10057 = Builder.access$100(builder);
        Provider<Database> provider154 = this.provideDatabaseProvider;
        $jacocoInit[235] = true;
        C13181b create86 = ApplicationModule_ProvideStoreAccessorFactory.create(access$10057, provider154);
        $jacocoInit[236] = true;
        this.provideStoreAccessorProvider = C13180a.m43109a(create86);
        $jacocoInit[237] = true;
        C13181b create87 = ApplicationModule_ProvideGoogleApiClientFactory.create(Builder.access$100(builder));
        $jacocoInit[238] = true;
        this.provideGoogleApiClientProvider = C13180a.m43109a(create87);
        $jacocoInit[239] = true;
        ApplicationModule access$10058 = Builder.access$100(builder);
        Provider<BodyInterceptor<BaseBody>> provider155 = this.provideBodyInterceptorPoolV7Provider;
        Provider<AdultContent> provider156 = this.provideAdultContentProvider;
        $jacocoInit[240] = true;
        C13181b create88 = C1361xe98d65dc.create(access$10058, provider155, provider156);
        $jacocoInit[241] = true;
        this.provideAccountSettingsBodyInterceptorPoolV7Provider = C13180a.m43109a(create88);
        $jacocoInit[242] = true;
        ApplicationModule access$10059 = Builder.access$100(builder);
        Provider<StoreAccessor> provider157 = this.provideStoreAccessorProvider;
        $jacocoInit[243] = true;
        C13181b create89 = ApplicationModule_ProvideStoreRepositoryFactory.create(access$10059, provider157);
        $jacocoInit[244] = true;
        this.provideStoreRepositoryProvider = C13180a.m43109a(create89);
        $jacocoInit[245] = true;
        ApplicationModule access$10060 = Builder.access$100(builder);
        Provider<OkHttpClient> provider158 = this.provideOkHttpClientProvider;
        Provider<MultipartBodyInterceptor> provider159 = this.provideMultipartBodyInterceptorProvider;
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider160 = this.providesBodyInterceptorV3Provider;
        Provider<BodyInterceptor<BaseBody>> provider161 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<SharedPreferences> provider162 = this.providesDefaultSharedPerefencesProvider;
        Provider<TokenInvalidator> provider163 = this.provideTokenInvalidatorProvider;
        Provider<RequestBodyFactory> provider164 = this.provideRequestBodyFactoryProvider;
        Provider<ObjectMapper> provider165 = this.provideNonNullObjectMapperProvider;
        Provider<StoreRepository> provider166 = this.provideStoreRepositoryProvider;
        $jacocoInit[246] = true;
        C13181b create90 = ApplicationModule_ProvideStoreManagerFactory.create(access$10060, provider158, provider159, provider160, provider161, provider162, provider163, provider164, provider165, provider166);
        $jacocoInit[247] = true;
        this.provideStoreManagerProvider = C13180a.m43109a(create90);
        $jacocoInit[248] = true;
        FlavourApplicationModule access$2004 = Builder.access$200(builder);
        $jacocoInit[249] = true;
        C13181b create91 = FlavourApplicationModule_ProvideLoginPreferencesFactory.create(access$2004);
        $jacocoInit[250] = true;
        this.provideLoginPreferencesProvider = C13180a.m43109a(create91);
        $jacocoInit[251] = true;
        ApplicationModule access$10061 = Builder.access$100(builder);
        Provider<AdultContent> provider167 = this.provideAdultContentProvider;
        Provider<StoreAccessor> provider168 = this.provideStoreAccessorProvider;
        Provider<AccountManager> provider169 = this.provideAccountManagerProvider;
        Provider<SharedPreferences> provider170 = this.providesDefaultSharedPerefencesProvider;
        Provider<AuthenticationPersistence> provider171 = this.provideAuthenticationPersistenceProvider;
        Provider<AndroidAccountProvider> provider172 = this.provideAndroidAccountProvider;
        Provider<GoogleApiClient> provider173 = this.provideGoogleApiClientProvider;
        Provider<StoreManager> provider174 = this.provideStoreManagerProvider;
        Provider<AccountService> provider175 = this.provideAccountServiceProvider;
        Provider<AccountFactory> provider176 = this.provideAccountFactoryProvider;
        Provider<LoginPreferences> provider177 = this.provideLoginPreferencesProvider;
        $jacocoInit[252] = true;
        C13181b create92 = ApplicationModule_ProvideAptoideAccountManagerFactory.create(access$10061, provider167, provider168, provider169, provider170, provider171, provider172, provider173, provider174, provider175, provider176, provider177);
        $jacocoInit[253] = true;
        this.provideAptoideAccountManagerProvider = C13180a.m43109a(create92);
        $jacocoInit[254] = true;
        ApplicationModule access$10062 = Builder.access$100(builder);
        Provider<SecurePreferences> provider178 = this.providesSecurePerefencesProvider;
        $jacocoInit[255] = true;
        C13181b create93 = ApplicationModule_ProvideRootAvailabilityManagerFactory.create(access$10062, provider178);
        $jacocoInit[256] = true;
        this.provideRootAvailabilityManagerProvider = C13180a.m43109a(create93);
        $jacocoInit[257] = true;
        ApplicationModule access$10063 = Builder.access$100(builder);
        Provider<Database> provider179 = this.provideDatabaseProvider;
        $jacocoInit[258] = true;
        C13181b create94 = ApplicationModule_ProvidesNotificationProviderFactory.create(access$10063, provider179);
        $jacocoInit[259] = true;
        this.providesNotificationProvider = C13180a.m43109a(create94);
        $jacocoInit[260] = true;
        ApplicationModule access$10064 = Builder.access$100(builder);
        Provider<Database> provider180 = this.provideDatabaseProvider;
        Provider<NotificationProvider> provider181 = this.providesNotificationProvider;
        $jacocoInit[261] = true;
        C13181b create95 = C1364xde78e542.create(access$10064, provider180, provider181);
        $jacocoInit[262] = true;
        this.providesRealmLocalNotificationSyncPersistenceProvider = C13180a.m43109a(create95);
        $jacocoInit[263] = true;
        ApplicationModule access$10065 = Builder.access$100(builder);
        Provider<RealmLocalNotificationSyncPersistence> provider182 = this.providesRealmLocalNotificationSyncPersistenceProvider;
        $jacocoInit[264] = true;
        C13181b create96 = ApplicationModule_ProvideSyncStorageFactory.create(access$10065, provider182);
        $jacocoInit[265] = true;
        this.provideSyncStorageProvider = C13180a.m43109a(create96);
        $jacocoInit[266] = true;
        ApplicationModule access$10066 = Builder.access$100(builder);
        Provider<SyncStorage> provider183 = this.provideSyncStorageProvider;
        $jacocoInit[267] = true;
        C13181b create97 = ApplicationModule_ProvideSyncSchedulerFactory.create(access$10066, provider183);
        $jacocoInit[268] = true;
        this.provideSyncSchedulerProvider = C13180a.m43109a(create97);
        $jacocoInit[269] = true;
        C13181b create98 = ApplicationModule_ProvidesPackageRepositoryFactory.create(Builder.access$100(builder));
        $jacocoInit[270] = true;
        this.providesPackageRepositoryProvider = C13180a.m43109a(create98);
        $jacocoInit[271] = true;
        ApplicationModule access$10067 = Builder.access$100(builder);
        Provider<PackageRepository> provider184 = this.providesPackageRepositoryProvider;
        $jacocoInit[272] = true;
        C13181b create99 = C1363x234ee129.create(access$10067, provider184);
        $jacocoInit[273] = true;
        this.providesAdsApplicationVersionCodeProvider = C13180a.m43109a(create99);
        $jacocoInit[274] = true;
        ApplicationModule access$10068 = Builder.access$100(builder);
        Provider<IdsRepository> provider185 = this.provideIdsRepositoryProvider;
        Provider<AptoideAccountManager> provider186 = this.provideAptoideAccountManagerProvider;
        Provider<OkHttpClient> provider187 = this.provideOkHttpClientProvider;
        Provider<QManager> provider188 = this.provideQManagerProvider;
        Provider<SharedPreferences> provider189 = this.providesDefaultSharedPerefencesProvider;
        Provider<AdsApplicationVersionCodeProvider> provider190 = this.providesAdsApplicationVersionCodeProvider;
        Provider<ConnectivityManager> provider191 = this.providesConnectivityManagerProvider;
        $jacocoInit[275] = true;
        C13181b create100 = ApplicationModule_ProvideAdsRepositoryFactory.create(access$10068, provider185, provider186, provider187, provider188, provider189, provider190, provider191);
        $jacocoInit[276] = true;
        this.provideAdsRepositoryProvider = C13180a.m43109a(create100);
        $jacocoInit[277] = true;
    }

    private void initialize2(Builder builder) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[278] = true;
        ApplicationModule access$100 = Builder.access$100(builder);
        Provider<StoreAccessor> provider = this.provideStoreAccessorProvider;
        $jacocoInit[279] = true;
        C13181b create = ApplicationModule_ProvidesStoreCredentialsProviderFactory.create(access$100, provider);
        $jacocoInit[280] = true;
        this.providesStoreCredentialsProvider = C13180a.m43109a(create);
        $jacocoInit[281] = true;
        ApplicationModule access$1002 = Builder.access$100(builder);
        Provider<StoreCredentialsProvider> provider2 = this.providesStoreCredentialsProvider;
        Provider<SharedPreferences> provider3 = this.providesDefaultSharedPerefencesProvider;
        Provider<TokenInvalidator> provider4 = this.provideTokenInvalidatorProvider;
        Provider<Converter.Factory> provider5 = this.providesConverterFactoryProvider;
        Provider<OkHttpClient> provider6 = this.provideOkHttpClientProvider;
        Provider<BodyInterceptor<BaseBody>> provider7 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        $jacocoInit[282] = true;
        C13181b create2 = ApplicationModule_ProvidesTrendingServiceFactory.create(access$1002, provider2, provider3, provider4, provider5, provider6, provider7);
        $jacocoInit[283] = true;
        this.providesTrendingServiceProvider = C13180a.m43109a(create2);
        $jacocoInit[284] = true;
        ApplicationModule access$1003 = Builder.access$100(builder);
        Provider<TrendingService> provider8 = this.providesTrendingServiceProvider;
        $jacocoInit[285] = true;
        C13181b create3 = ApplicationModule_ProvidesTrendingManagerFactory.create(access$1003, provider8);
        $jacocoInit[286] = true;
        this.providesTrendingManagerProvider = C13180a.m43109a(create3);
        $jacocoInit[287] = true;
        ApplicationModule access$1004 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider9 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider10 = this.provideNavigationTrackerProvider;
        $jacocoInit[288] = true;
        C13181b create4 = ApplicationModule_ProvideAdultContentAnalyticsFactory.create(access$1004, provider9, provider10);
        $jacocoInit[289] = true;
        this.provideAdultContentAnalyticsProvider = C13180a.m43109a(create4);
        $jacocoInit[290] = true;
        ApplicationModule access$1005 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider11 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider12 = this.provideNavigationTrackerProvider;
        $jacocoInit[291] = true;
        C13181b create5 = ApplicationModule_ProvideNotificationAnalyticsFactory.create(access$1005, provider11, provider12);
        $jacocoInit[292] = true;
        this.provideNotificationAnalyticsProvider = C13180a.m43109a(create5);
        $jacocoInit[293] = true;
        ApplicationModule access$1006 = Builder.access$100(builder);
        Provider<SharedPreferences> provider13 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[294] = true;
        C13181b create6 = ApplicationModule_ProvideSearchBaseUrlFactory.create(access$1006, provider13);
        $jacocoInit[295] = true;
        this.provideSearchBaseUrlProvider = C13180a.m43109a(create6);
        $jacocoInit[296] = true;
        ApplicationModule access$1007 = Builder.access$100(builder);
        Provider<String> provider14 = this.provideSearchBaseUrlProvider;
        Provider<OkHttpClient> provider15 = this.provideOkHttpClientProvider;
        Provider<Converter.Factory> provider16 = this.providesConverterFactoryProvider;
        Provider<Factory> provider17 = this.providesCallAdapterFactoryProvider;
        $jacocoInit[297] = true;
        C13181b create7 = ApplicationModule_ProvidesSearchSuggestionsRetrofitFactory.create(access$1007, provider14, provider15, provider16, provider17);
        $jacocoInit[298] = true;
        this.providesSearchSuggestionsRetrofitProvider = C13180a.m43109a(create7);
        $jacocoInit[299] = true;
        ApplicationModule access$1008 = Builder.access$100(builder);
        Provider<Retrofit> provider18 = this.providesSearchSuggestionsRetrofitProvider;
        $jacocoInit[300] = true;
        C13181b create8 = C1365xf5423e59.create(access$1008, provider18);
        $jacocoInit[301] = true;
        this.providesSearchSuggestionRemoteRepositoryProvider = C13180a.m43109a(create8);
        $jacocoInit[302] = true;
        ApplicationModule access$1009 = Builder.access$100(builder);
        Provider<SearchSuggestionRemoteRepository> provider19 = this.providesSearchSuggestionRemoteRepositoryProvider;
        $jacocoInit[303] = true;
        C13181b create9 = ApplicationModule_ProvidesSearchSuggestionManagerFactory.create(access$1009, provider19);
        $jacocoInit[304] = true;
        this.providesSearchSuggestionManagerProvider = C13180a.m43109a(create9);
        $jacocoInit[305] = true;
        C13181b create10 = ApplicationModule_ProvidesSafetyNetClientFactory.create(Builder.access$100(builder));
        $jacocoInit[306] = true;
        this.providesSafetyNetClientProvider = C13180a.m43109a(create10);
        $jacocoInit[307] = true;
        ApplicationModule access$10010 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider20 = this.providesAnalyticsManagerProvider;
        Provider<AnalyticsLogger> provider21 = this.providesAnalyticsDebugLoggerProvider;
        Provider<SafetyNetClient> provider22 = this.providesSafetyNetClientProvider;
        $jacocoInit[308] = true;
        C13181b create11 = ApplicationModule_ProvidesFirstLaunchAnalyticsFactory.create(access$10010, provider20, provider21, provider22);
        $jacocoInit[309] = true;
        this.providesFirstLaunchAnalyticsProvider = C13180a.m43109a(create11);
        $jacocoInit[310] = true;
        ApplicationModule access$10011 = Builder.access$100(builder);
        Provider<AptoideAccountManager> provider23 = this.provideAptoideAccountManagerProvider;
        Provider<TokenInvalidator> provider24 = this.provideTokenInvalidatorProvider;
        $jacocoInit[311] = true;
        C13181b create12 = ApplicationModule_ProvideInvalidRefreshTokenLogoutManagerFactory.create(access$10011, provider23, provider24);
        $jacocoInit[312] = true;
        this.provideInvalidRefreshTokenLogoutManagerProvider = C13180a.m43109a(create12);
        $jacocoInit[313] = true;
        ApplicationModule access$10012 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider25 = this.providesAnalyticsManagerProvider;
        Provider<InstallAnalytics> provider26 = this.provideInstallAnalyticsProvider;
        Provider<SharedPreferences> provider27 = this.providesDefaultSharedPerefencesProvider;
        Provider<RootAvailabilityManager> provider28 = this.provideRootAvailabilityManagerProvider;
        Provider<NavigationTracker> provider29 = this.provideNavigationTrackerProvider;
        $jacocoInit[314] = true;
        C13181b create13 = ApplicationModule_ProvidesInstallerAnalyticsFactory.create(access$10012, provider25, provider26, provider27, provider28, provider29);
        $jacocoInit[315] = true;
        this.providesInstallerAnalyticsProvider = C13180a.m43109a(create13);
        $jacocoInit[316] = true;
        ApplicationModule access$10013 = Builder.access$100(builder);
        Provider<SharedPreferences> provider30 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[317] = true;
        C13181b create14 = ApplicationModule_ProvidesSecureSharedPreferencesFactory.create(access$10013, provider30);
        $jacocoInit[318] = true;
        this.providesSecureSharedPreferencesProvider = C13180a.m43109a(create14);
        $jacocoInit[319] = true;
        ApplicationModule access$10014 = Builder.access$100(builder);
        Provider<Database> provider31 = this.provideDatabaseProvider;
        $jacocoInit[320] = true;
        C13181b create15 = ApplicationModule_ProvidesInstallationAccessorFactory.create(access$10014, provider31);
        $jacocoInit[321] = true;
        this.providesInstallationAccessorProvider = C13180a.m43109a(create15);
        $jacocoInit[322] = true;
        ApplicationModule access$10015 = Builder.access$100(builder);
        Provider<Database> provider32 = this.provideDatabaseProvider;
        Provider<InstallationAccessor> provider33 = this.providesInstallationAccessorProvider;
        $jacocoInit[323] = true;
        C13181b create16 = ApplicationModule_ProvideInstalledAccessorFactory.create(access$10015, provider32, provider33);
        $jacocoInit[324] = true;
        this.provideInstalledAccessorProvider = C13180a.m43109a(create16);
        $jacocoInit[325] = true;
        ApplicationModule access$10016 = Builder.access$100(builder);
        Provider<InstalledAccessor> provider34 = this.provideInstalledAccessorProvider;
        $jacocoInit[326] = true;
        C13181b create17 = ApplicationModule_ProvideInstalledRepositoryFactory.create(access$10016, provider34);
        $jacocoInit[327] = true;
        this.provideInstalledRepositoryProvider = C13180a.m43109a(create17);
        $jacocoInit[328] = true;
        ApplicationModule access$10017 = Builder.access$100(builder);
        $jacocoInit[329] = true;
        C13181b create18 = ApplicationModule_ProvidesAppInstallerStatusReceiverFactory.create(access$10017);
        $jacocoInit[330] = true;
        this.providesAppInstallerStatusReceiverProvider = C13180a.m43109a(create18);
        $jacocoInit[331] = true;
        ApplicationModule access$10018 = Builder.access$100(builder);
        Provider<AppInstallerStatusReceiver> provider35 = this.providesAppInstallerStatusReceiverProvider;
        $jacocoInit[332] = true;
        C13181b create19 = ApplicationModule_ProvidesAppInstallerFactory.create(access$10018, provider35);
        $jacocoInit[333] = true;
        this.providesAppInstallerProvider = C13180a.m43109a(create19);
        $jacocoInit[334] = true;
        ApplicationModule access$10019 = Builder.access$100(builder);
        $jacocoInit[335] = true;
        C13181b create20 = ApplicationModule_ProvidesPackageInstallerManagerFactory.create(access$10019);
        $jacocoInit[336] = true;
        this.providesPackageInstallerManagerProvider = C13180a.m43109a(create20);
        $jacocoInit[337] = true;
        ApplicationModule access$10020 = Builder.access$100(builder);
        Provider<AptoideDownloadManager> provider36 = this.provideAptoideDownloadManagerProvider;
        Provider<InstallerAnalytics> provider37 = this.providesInstallerAnalyticsProvider;
        Provider<RootAvailabilityManager> provider38 = this.provideRootAvailabilityManagerProvider;
        Provider<SharedPreferences> provider39 = this.providesDefaultSharedPerefencesProvider;
        Provider<SharedPreferences> provider40 = this.providesSecureSharedPreferencesProvider;
        Provider<DownloadsRepository> provider41 = this.provideDownloadsRepositoryProvider;
        Provider<InstalledRepository> provider42 = this.provideInstalledRepositoryProvider;
        Provider<String> provider43 = this.provideCachePathProvider;
        Provider<String> provider44 = this.provideApkPathProvider;
        Provider<String> provider45 = this.provideObbPathProvider;
        Provider<AppInstaller> provider46 = this.providesAppInstallerProvider;
        Provider<AppInstallerStatusReceiver> provider47 = this.providesAppInstallerStatusReceiverProvider;
        Provider<PackageInstallerManager> provider48 = this.providesPackageInstallerManagerProvider;
        $jacocoInit[338] = true;
        C13181b create21 = ApplicationModule_ProvidesInstallManagerFactory.create(access$10020, provider36, provider37, provider38, provider39, provider40, provider41, provider42, provider43, provider44, provider45, provider46, provider47, provider48);
        $jacocoInit[339] = true;
        this.providesInstallManagerProvider = C13180a.m43109a(create21);
        $jacocoInit[340] = true;
        ApplicationModule access$10021 = Builder.access$100(builder);
        Provider<InstallManager> provider49 = this.providesInstallManagerProvider;
        $jacocoInit[341] = true;
        C13181b create22 = ApplicationModule_ProvideRootInstallationRetryHandlerFactory.create(access$10021, provider49);
        $jacocoInit[342] = true;
        this.provideRootInstallationRetryHandlerProvider = C13180a.m43109a(create22);
        $jacocoInit[343] = true;
        C13181b create23 = ApplicationModule_ProvidesShortcutManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[344] = true;
        this.providesShortcutManagerProvider = C13180a.m43109a(create23);
        $jacocoInit[345] = true;
        C13181b create24 = ApplicationModule_ProvidesSettingsManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[346] = true;
        this.providesSettingsManagerProvider = C13180a.m43109a(create24);
        $jacocoInit[347] = true;
        ApplicationModule access$10022 = Builder.access$100(builder);
        $jacocoInit[348] = true;
        C13181b create25 = ApplicationModule_ProvideDefaultFollowedStoresFactory.create(access$10022);
        $jacocoInit[349] = true;
        this.provideDefaultFollowedStoresProvider = C13180a.m43109a(create25);
        $jacocoInit[350] = true;
        ApplicationModule access$10023 = Builder.access$100(builder);
        Provider<SharedPreferences> provider50 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[351] = true;
        C13181b create26 = ApplicationModule_ProvidesABTestingBaseHostFactory.create(access$10023, provider50);
        $jacocoInit[352] = true;
        this.providesABTestingBaseHostProvider = C13180a.m43109a(create26);
        $jacocoInit[353] = true;
        ApplicationModule access$10024 = Builder.access$100(builder);
        Provider<String> provider51 = this.providesABTestingBaseHostProvider;
        Provider<OkHttpClient> provider52 = this.provideOkHttpClientProvider;
        Provider<Converter.Factory> provider53 = this.providesConverterFactoryProvider;
        Provider<Factory> provider54 = this.providesCallAdapterFactoryProvider;
        $jacocoInit[354] = true;
        C13181b create27 = ApplicationModule_ProvidesABRetrofitFactory.create(access$10024, provider51, provider52, provider53, provider54);
        $jacocoInit[355] = true;
        this.providesABRetrofitProvider = C13180a.m43109a(create27);
        $jacocoInit[356] = true;
        ApplicationModule access$10025 = Builder.access$100(builder);
        Provider<Retrofit> provider55 = this.providesABRetrofitProvider;
        $jacocoInit[357] = true;
        C13181b create28 = ApplicationModule_ProvidesABTestServiceV7Factory.create(access$10025, provider55);
        $jacocoInit[358] = true;
        this.providesABTestServiceV7Provider = C13180a.m43109a(create28);
        $jacocoInit[359] = true;
        ApplicationModule access$10026 = Builder.access$100(builder);
        Provider<ServiceV7> provider56 = this.providesABTestServiceV7Provider;
        Provider<IdsRepository> provider57 = this.provideIdsRepositoryProvider;
        $jacocoInit[360] = true;
        C13181b create29 = ApplicationModule_ProvidesABTestServiceFactory.create(access$10026, provider56, provider57);
        $jacocoInit[361] = true;
        this.providesABTestServiceProvider = C13180a.m43109a(create29);
        $jacocoInit[362] = true;
        ApplicationModule access$10027 = Builder.access$100(builder);
        Provider<Database> provider58 = this.provideDatabaseProvider;
        $jacocoInit[363] = true;
        C13181b create30 = ApplicationModule_ProvidesRealmExperimentPersistenceFactory.create(access$10027, provider58);
        $jacocoInit[364] = true;
        this.providesRealmExperimentPersistenceProvider = C13180a.m43109a(create30);
        $jacocoInit[365] = true;
        C13181b create31 = ApplicationModule_ProvidesAbTestLocalCacheFactory.create(Builder.access$100(builder));
        $jacocoInit[366] = true;
        this.providesAbTestLocalCacheProvider = C13180a.m43109a(create31);
        $jacocoInit[367] = true;
        ApplicationModule access$10028 = Builder.access$100(builder);
        Provider<HashMap<String, ExperimentModel>> provider59 = this.providesAbTestLocalCacheProvider;
        $jacocoInit[368] = true;
        C13181b create32 = ApplicationModule_ProvidesAbTestCacheValidatorFactory.create(access$10028, provider59);
        $jacocoInit[369] = true;
        this.providesAbTestCacheValidatorProvider = C13180a.m43109a(create32);
        $jacocoInit[370] = true;
        ApplicationModule access$10029 = Builder.access$100(builder);
        Provider<ABTestService> provider60 = this.providesABTestServiceProvider;
        Provider<RealmExperimentPersistence> provider61 = this.providesRealmExperimentPersistenceProvider;
        Provider<HashMap<String, ExperimentModel>> provider62 = this.providesAbTestLocalCacheProvider;
        Provider<AbTestCacheValidator> provider63 = this.providesAbTestCacheValidatorProvider;
        $jacocoInit[371] = true;
        C13181b create33 = ApplicationModule_ProvidesABTestCenterRepositoryFactory.create(access$10029, provider60, provider61, provider62, provider63);
        $jacocoInit[372] = true;
        this.providesABTestCenterRepositoryProvider = C13180a.m43109a(create33);
        $jacocoInit[373] = true;
        ApplicationModule access$10030 = Builder.access$100(builder);
        Provider<ABTestCenterRepository> provider64 = this.providesABTestCenterRepositoryProvider;
        $jacocoInit[374] = true;
        C13181b create34 = ApplicationModule_ProvidesABTestManagerFactory.create(access$10030, provider64);
        $jacocoInit[375] = true;
        this.providesABTestManagerProvider = C13180a.m43109a(create34);
        $jacocoInit[376] = true;
        C13181b create35 = ApplicationModule_ProvidesMoPubAnalyticsFactory.create(Builder.access$100(builder));
        $jacocoInit[377] = true;
        this.providesMoPubAnalyticsProvider = C13180a.m43109a(create35);
        $jacocoInit[378] = true;
        FlavourApplicationModule access$200 = Builder.access$200(builder);
        Provider<ABTestManager> provider65 = this.providesABTestManagerProvider;
        Provider<MoPubAnalytics> provider66 = this.providesMoPubAnalyticsProvider;
        $jacocoInit[379] = true;
        C13181b create36 = C1369x4984df09.create(access$200, provider65, provider66);
        $jacocoInit[380] = true;
        this.providesMoPubInterstitialAdExperimentProvider = C13180a.m43109a(create36);
        $jacocoInit[381] = true;
        FlavourApplicationModule access$2002 = Builder.access$200(builder);
        Provider<ABTestManager> provider67 = this.providesABTestManagerProvider;
        Provider<MoPubAnalytics> provider68 = this.providesMoPubAnalyticsProvider;
        $jacocoInit[382] = true;
        C13181b create37 = FlavourApplicationModule_ProvidesMoPubBannerAdExperimentFactory.create(access$2002, provider67, provider68);
        $jacocoInit[383] = true;
        this.providesMoPubBannerAdExperimentProvider = C13180a.m43109a(create37);
        $jacocoInit[384] = true;
        FlavourApplicationModule access$2003 = Builder.access$200(builder);
        Provider<ABTestManager> provider69 = this.providesABTestManagerProvider;
        Provider<MoPubAnalytics> provider70 = this.providesMoPubAnalyticsProvider;
        $jacocoInit[385] = true;
        C13181b create38 = FlavourApplicationModule_ProvidesMoPubNativeAdExperimentFactory.create(access$2003, provider69, provider70);
        $jacocoInit[386] = true;
        this.providesMoPubNativeAdExperimentProvider = C13180a.m43109a(create38);
        $jacocoInit[387] = true;
        ApplicationModule access$10031 = Builder.access$100(builder);
        Provider<BodyInterceptor<BaseBody>> provider71 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<OkHttpClient> provider72 = this.provideOkHttpClientProvider;
        Provider<TokenInvalidator> provider73 = this.provideTokenInvalidatorProvider;
        Provider<Converter.Factory> provider74 = this.providesConverterFactoryProvider;
        Provider<SharedPreferences> provider75 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[388] = true;
        C13181b create39 = ApplicationModule_ProvidesWalletAdsOfferServiceFactory.create(access$10031, provider71, provider72, provider73, provider74, provider75);
        $jacocoInit[389] = true;
        this.providesWalletAdsOfferServiceProvider = C13180a.m43109a(create39);
        $jacocoInit[390] = true;
        FlavourApplicationModule access$2004 = Builder.access$200(builder);
        Provider<WalletAdsOfferService> provider76 = this.providesWalletAdsOfferServiceProvider;
        $jacocoInit[391] = true;
        C13181b create40 = FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory.create(access$2004, provider76);
        $jacocoInit[392] = true;
        this.providesWalletAdsOfferManagerProvider = C13180a.m43109a(create40);
        $jacocoInit[393] = true;
        FlavourApplicationModule access$2005 = Builder.access$200(builder);
        $jacocoInit[394] = true;
        C13181b create41 = FlavourApplicationModule_ProvidesMoPubConsentManagerFactory.create(access$2005);
        $jacocoInit[395] = true;
        this.providesMoPubConsentManagerProvider = C13180a.m43109a(create41);
        $jacocoInit[396] = true;
        ApplicationModule access$10032 = Builder.access$100(builder);
        Provider<MoPubInterstitialAdExperiment> provider77 = this.providesMoPubInterstitialAdExperimentProvider;
        Provider<MoPubBannerAdExperiment> provider78 = this.providesMoPubBannerAdExperimentProvider;
        Provider<MoPubNativeAdExperiment> provider79 = this.providesMoPubNativeAdExperimentProvider;
        Provider<WalletAdsOfferManager> provider80 = this.providesWalletAdsOfferManagerProvider;
        Provider<MoPubConsentManager> provider81 = this.providesMoPubConsentManagerProvider;
        $jacocoInit[397] = true;
        C13181b create42 = ApplicationModule_ProvidesMoPubAdsManagerFactory.create(access$10032, provider77, provider78, provider79, provider80, provider81);
        $jacocoInit[398] = true;
        this.providesMoPubAdsManagerProvider = C13180a.m43109a(create42);
        $jacocoInit[399] = true;
        C13181b create43 = ApplicationModule_ProvidesCrashReportsFactory.create(Builder.access$100(builder));
        $jacocoInit[400] = true;
        this.providesCrashReportsProvider = C13180a.m43109a(create43);
        $jacocoInit[401] = true;
        ApplicationModule access$10033 = Builder.access$100(builder);
        Provider<MoPubAdsManager> provider82 = this.providesMoPubAdsManagerProvider;
        Provider<InstalledRepository> provider83 = this.provideInstalledRepositoryProvider;
        Provider<MoPubAnalytics> provider84 = this.providesMoPubAnalyticsProvider;
        Provider<CrashReport> provider85 = this.providesCrashReportsProvider;
        $jacocoInit[402] = true;
        C13181b create44 = ApplicationModule_ProvidesMoPubAdsServiceFactory.create(access$10033, provider82, provider83, provider84, provider85);
        $jacocoInit[403] = true;
        this.providesMoPubAdsServiceProvider = C13180a.m43109a(create44);
        $jacocoInit[404] = true;
        ApplicationModule access$10034 = Builder.access$100(builder);
        Provider<AptoideDownloadManager> provider86 = this.provideAptoideDownloadManagerProvider;
        Provider<DownloadAccessor> provider87 = this.provideDownloadAccessorProvider;
        Provider<InstalledRepository> provider88 = this.provideInstalledRepositoryProvider;
        Provider<Database> provider89 = this.provideDatabaseProvider;
        $jacocoInit[405] = true;
        C13181b create45 = ApplicationModule_ProvideInstallationProviderFactory.create(access$10034, provider86, provider87, provider88, provider89);
        $jacocoInit[406] = true;
        this.provideInstallationProvider = C13180a.m43109a(create45);
        $jacocoInit[407] = true;
        ApplicationModule access$10035 = Builder.access$100(builder);
        Provider<InstallationProvider> provider90 = this.provideInstallationProvider;
        Provider<SharedPreferences> provider91 = this.providesDefaultSharedPerefencesProvider;
        Provider<InstalledRepository> provider92 = this.provideInstalledRepositoryProvider;
        Provider<RootAvailabilityManager> provider93 = this.provideRootAvailabilityManagerProvider;
        Provider<InstallerAnalytics> provider94 = this.providesInstallerAnalyticsProvider;
        Provider<AppInstaller> provider95 = this.providesAppInstallerProvider;
        Provider<AppInstallerStatusReceiver> provider96 = this.providesAppInstallerStatusReceiverProvider;
        $jacocoInit[408] = true;
        C13181b create46 = ApplicationModule_ProvideDefaultInstallerFactory.create(access$10035, provider90, provider91, provider92, provider93, provider94, provider95, provider96);
        $jacocoInit[409] = true;
        this.provideDefaultInstallerProvider = C13180a.m43109a(create46);
        $jacocoInit[410] = true;
        ApplicationModule access$10036 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider97 = this.providesAnalyticsManagerProvider;
        $jacocoInit[411] = true;
        C13181b create47 = ApplicationModule_ProvidesCampaignAnalyticsFactory.create(access$10036, provider97);
        $jacocoInit[412] = true;
        this.providesCampaignAnalyticsProvider = C13180a.m43109a(create47);
        $jacocoInit[413] = true;
        ApplicationModule access$10037 = Builder.access$100(builder);
        Provider<Database> provider98 = this.provideDatabaseProvider;
        $jacocoInit[414] = true;
        C13181b create48 = ApplicationModule_ProvidesAppcMigrationAccessorFactory.create(access$10037, provider98);
        $jacocoInit[415] = true;
        this.providesAppcMigrationAccessorProvider = C13180a.m43109a(create48);
        $jacocoInit[416] = true;
        ApplicationModule access$10038 = Builder.access$100(builder);
        Provider<AppcMigrationAccessor> provider99 = this.providesAppcMigrationAccessorProvider;
        $jacocoInit[417] = true;
        C13181b create49 = ApplicationModule_ProvidesAppcMigrationServiceFactory.create(access$10038, provider99);
        $jacocoInit[418] = true;
        this.providesAppcMigrationServiceProvider = C13180a.m43109a(create49);
        $jacocoInit[419] = true;
        ApplicationModule access$10039 = Builder.access$100(builder);
        Provider<InstalledRepository> provider100 = this.provideInstalledRepositoryProvider;
        Provider<AppcMigrationService> provider101 = this.providesAppcMigrationServiceProvider;
        $jacocoInit[420] = true;
        C13181b create50 = ApplicationModule_ProvidesAppcMigrationManagerFactory.create(access$10039, provider100, provider101);
        $jacocoInit[421] = true;
        this.providesAppcMigrationManagerProvider = C13180a.m43109a(create50);
        $jacocoInit[422] = true;
        C13181b create51 = ApplicationModule_ProvideMarketNameFactory.create(Builder.access$100(builder));
        $jacocoInit[423] = true;
        this.provideMarketNameProvider = C13180a.m43109a(create51);
        $jacocoInit[424] = true;
        C13181b create52 = ApplicationModule_ProvidesOemidProviderFactory.create(Builder.access$100(builder));
        $jacocoInit[425] = true;
        this.providesOemidProvider = C13180a.m43109a(create52);
        $jacocoInit[426] = true;
        ApplicationModule access$10040 = Builder.access$100(builder);
        Provider<OemidProvider> provider102 = this.providesOemidProvider;
        $jacocoInit[427] = true;
        C13181b create53 = ApplicationModule_DownloadApkPathsProviderFactory.create(access$10040, provider102);
        $jacocoInit[428] = true;
        this.downloadApkPathsProvider = C13180a.m43109a(create53);
        $jacocoInit[429] = true;
        ApplicationModule access$10041 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider103 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider104 = this.provideNavigationTrackerProvider;
        $jacocoInit[430] = true;
        C13181b create54 = ApplicationModule_ProvidesAppValidationAnalyticsFactory.create(access$10041, provider103, provider104);
        $jacocoInit[431] = true;
        this.providesAppValidationAnalyticsProvider = C13180a.m43109a(create54);
        $jacocoInit[432] = true;
        ApplicationModule access$10042 = Builder.access$100(builder);
        Provider<AppValidationAnalytics> provider105 = this.providesAppValidationAnalyticsProvider;
        $jacocoInit[433] = true;
        C13181b create55 = ApplicationModule_ProvidesAppValidatorFactory.create(access$10042, provider105);
        $jacocoInit[434] = true;
        this.providesAppValidatorProvider = C13180a.m43109a(create55);
        $jacocoInit[435] = true;
        ApplicationModule access$10043 = Builder.access$100(builder);
        Provider<String> provider106 = this.provideMarketNameProvider;
        Provider<DownloadApkPathsProvider> provider107 = this.downloadApkPathsProvider;
        Provider<String> provider108 = this.provideCachePathProvider;
        Provider<AppValidator> provider109 = this.providesAppValidatorProvider;
        $jacocoInit[436] = true;
        C13181b create56 = ApplicationModule_ProvideDownloadFactoryFactory.create(access$10043, provider106, provider107, provider108, provider109);
        $jacocoInit[437] = true;
        this.provideDownloadFactoryProvider = C13180a.m43109a(create56);
        $jacocoInit[438] = true;
        C13181b create57 = ApplicationModule_ProvideFragmentNavigatorMapFactory.create(Builder.access$100(builder));
        $jacocoInit[439] = true;
        this.provideFragmentNavigatorMapProvider = C13180a.m43109a(create57);
        $jacocoInit[440] = true;
        ApplicationModule access$10044 = Builder.access$100(builder);
        $jacocoInit[441] = true;
        C13181b create58 = ApplicationModule_ProvideFragmentNavigatorRelayFactory.create(access$10044);
        $jacocoInit[442] = true;
        this.provideFragmentNavigatorRelayProvider = C13180a.m43109a(create58);
        $jacocoInit[443] = true;
        C13181b create59 = ApplicationModule_ProvideCallbackManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[444] = true;
        this.provideCallbackManagerProvider = C13180a.m43109a(create59);
        $jacocoInit[445] = true;
        ApplicationModule access$10045 = Builder.access$100(builder);
        Provider<NavigationTracker> provider110 = this.provideNavigationTrackerProvider;
        Provider<AnalyticsManager> provider111 = this.providesAnalyticsManagerProvider;
        $jacocoInit[446] = true;
        C13181b create60 = ApplicationModule_ProvideAccountAnalyticsFactory.create(access$10045, provider110, provider111);
        $jacocoInit[447] = true;
        this.provideAccountAnalyticsProvider = C13180a.m43109a(create60);
        $jacocoInit[448] = true;
        ApplicationModule access$10046 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider112 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider113 = this.provideNavigationTrackerProvider;
        $jacocoInit[449] = true;
        C13181b create61 = ApplicationModule_ProvidesSearchAnalyticsFactory.create(access$10046, provider112, provider113);
        $jacocoInit[450] = true;
        this.providesSearchAnalyticsProvider = C13180a.m43109a(create61);
        $jacocoInit[451] = true;
        C13181b create62 = ApplicationModule_ProvidesAptoideThemeFactory.create(Builder.access$100(builder));
        $jacocoInit[452] = true;
        this.providesAptoideThemeProvider = C13180a.m43109a(create62);
        $jacocoInit[453] = true;
        ApplicationModule access$10047 = Builder.access$100(builder);
        Provider<AptoideAccountManager> provider114 = this.provideAptoideAccountManagerProvider;
        Provider<StoreAccessor> provider115 = this.provideStoreAccessorProvider;
        Provider<OkHttpClient> provider116 = this.provideOkHttpClientProvider;
        Provider<SharedPreferences> provider117 = this.providesDefaultSharedPerefencesProvider;
        Provider<TokenInvalidator> provider118 = this.provideTokenInvalidatorProvider;
        Provider<BodyInterceptor<BaseBody>> provider119 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        $jacocoInit[454] = true;
        C13181b create63 = ApplicationModule_ProvideStoreUtilsProxyFactory.create(access$10047, provider114, provider115, provider116, provider117, provider118, provider119);
        $jacocoInit[455] = true;
        this.provideStoreUtilsProxyProvider = C13180a.m43109a(create63);
        $jacocoInit[456] = true;
        ApplicationModule access$10048 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider120 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider121 = this.provideNavigationTrackerProvider;
        $jacocoInit[457] = true;
        C13181b create64 = ApplicationModule_ProvideDeepLinkAnalyticsFactory.create(access$10048, provider120, provider121);
        $jacocoInit[458] = true;
        this.provideDeepLinkAnalyticsProvider = C13180a.m43109a(create64);
        $jacocoInit[459] = true;
        ApplicationModule access$10049 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider122 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider123 = this.provideNavigationTrackerProvider;
        $jacocoInit[460] = true;
        C13181b create65 = ApplicationModule_ProvidesAppShortcutsAnalyticsFactory.create(access$10049, provider122, provider123);
        $jacocoInit[461] = true;
        this.providesAppShortcutsAnalyticsProvider = C13180a.m43109a(create65);
        $jacocoInit[462] = true;
        ApplicationModule access$10050 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider124 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider125 = this.provideNavigationTrackerProvider;
        $jacocoInit[463] = true;
        C13181b create66 = ApplicationModule_ProvidesStoreAnalyticsFactory.create(access$10050, provider124, provider125);
        $jacocoInit[464] = true;
        this.providesStoreAnalyticsProvider = C13180a.m43109a(create66);
        $jacocoInit[465] = true;
        ApplicationModule access$10051 = Builder.access$100(builder);
        Provider<Database> provider126 = this.provideDatabaseProvider;
        $jacocoInit[466] = true;
        C13181b create67 = ApplicationModule_ProvidesUpdateAccessorFactory.create(access$10051, provider126);
        $jacocoInit[467] = true;
        this.providesUpdateAccessorProvider = C13180a.m43109a(create67);
        $jacocoInit[468] = true;
        ApplicationModule access$10052 = Builder.access$100(builder);
        Provider<UpdateAccessor> provider127 = this.providesUpdateAccessorProvider;
        Provider<StoreAccessor> provider128 = this.provideStoreAccessorProvider;
        Provider<IdsRepository> provider129 = this.provideIdsRepositoryProvider;
        Provider<BodyInterceptor<BaseBody>> provider130 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<OkHttpClient> provider131 = this.provideOkHttpClientProvider;
        Provider<Converter.Factory> provider132 = this.providesConverterFactoryProvider;
        Provider<TokenInvalidator> provider133 = this.provideTokenInvalidatorProvider;
        Provider<SharedPreferences> provider134 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[469] = true;
        C13181b create68 = ApplicationModule_ProvidesUpdateRepositoryFactory.create(access$10052, provider127, provider128, provider129, provider130, provider131, provider132, provider133, provider134);
        $jacocoInit[470] = true;
        this.providesUpdateRepositoryProvider = C13180a.m43109a(create68);
        $jacocoInit[471] = true;
        ApplicationModule access$10053 = Builder.access$100(builder);
        Provider<UpdateRepository> provider135 = this.providesUpdateRepositoryProvider;
        $jacocoInit[472] = true;
        C13181b create69 = ApplicationModule_ProvidesUpdatesManagerFactory.create(access$10053, provider135);
        $jacocoInit[473] = true;
        this.providesUpdatesManagerProvider = C13180a.m43109a(create69);
        $jacocoInit[474] = true;
        C13181b create70 = ApplicationModule_ProvidePermissionManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[475] = true;
        this.providePermissionManagerProvider = C13180a.m43109a(create70);
        $jacocoInit[476] = true;
        C13181b create71 = ApplicationModule_ProvidesAutoUpdateBaseHostFactory.create(Builder.access$100(builder));
        $jacocoInit[477] = true;
        this.providesAutoUpdateBaseHostProvider = C13180a.m43109a(create71);
        $jacocoInit[478] = true;
        ApplicationModule access$10054 = Builder.access$100(builder);
        Provider<OkHttpClient> provider136 = this.provideOkHttpClientProvider;
        Provider<String> provider137 = this.providesAutoUpdateBaseHostProvider;
        Provider<Converter.Factory> provider138 = this.providesConverterFactoryProvider;
        Provider<Factory> provider139 = this.providesCallAdapterFactoryProvider;
        $jacocoInit[479] = true;
        C13181b create72 = ApplicationModule_ProvidesAutoUpdateRetrofitFactory.create(access$10054, provider136, provider137, provider138, provider139);
        $jacocoInit[480] = true;
        this.providesAutoUpdateRetrofitProvider = C13180a.m43109a(create72);
        $jacocoInit[481] = true;
        ApplicationModule access$10055 = Builder.access$100(builder);
        Provider<Retrofit> provider140 = this.providesAutoUpdateRetrofitProvider;
        $jacocoInit[482] = true;
        C13181b create73 = ApplicationModule_ProvidesAutoUpdateServiceFactory.create(access$10055, provider140);
        $jacocoInit[483] = true;
        this.providesAutoUpdateServiceProvider = C13180a.m43109a(create73);
        $jacocoInit[484] = true;
        FlavourApplicationModule access$2006 = Builder.access$200(builder);
        $jacocoInit[485] = true;
        C13181b create74 = FlavourApplicationModule_ProvideAutoUpdateStoreNameFactory.create(access$2006);
        $jacocoInit[486] = true;
        this.provideAutoUpdateStoreNameProvider = C13180a.m43109a(create74);
        $jacocoInit[487] = true;
        ApplicationModule access$10056 = Builder.access$100(builder);
        Provider<String> provider141 = this.provideMarketNameProvider;
        $jacocoInit[488] = true;
        C13181b create75 = ApplicationModule_ProvideMarketResourceFormatterFactory.create(access$10056, provider141);
        $jacocoInit[489] = true;
        this.provideMarketResourceFormatterProvider = C13180a.m43109a(create75);
        $jacocoInit[490] = true;
        C13181b create76 = ApplicationModule_ProvidesDownloadStateParserFactory.create(Builder.access$100(builder));
        $jacocoInit[491] = true;
        this.providesDownloadStateParserProvider = C13180a.m43109a(create76);
        $jacocoInit[492] = true;
        ApplicationModule access$10057 = Builder.access$100(builder);
        Provider<StoreCredentialsProvider> provider142 = this.providesStoreCredentialsProvider;
        Provider<BodyInterceptor<BaseBody>> provider143 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider144 = this.providesBodyInterceptorV3Provider;
        Provider<OkHttpClient> provider145 = this.provideOkHttpClientProvider;
        Provider<TokenInvalidator> provider146 = this.provideTokenInvalidatorProvider;
        Provider<SharedPreferences> provider147 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[493] = true;
        C13181b create77 = ApplicationModule_ProvidesAppServiceFactory.create(access$10057, provider142, provider143, provider144, provider145, provider146, provider147);
        $jacocoInit[494] = true;
        this.providesAppServiceProvider = C13180a.m43109a(create77);
        $jacocoInit[495] = true;
        ApplicationModule access$10058 = Builder.access$100(builder);
        Provider<AppService> provider148 = this.providesAppServiceProvider;
        $jacocoInit[496] = true;
        C13181b create78 = ApplicationModule_ProvidesAppCenterRepositoryFactory.create(access$10058, provider148);
        $jacocoInit[497] = true;
        this.providesAppCenterRepositoryProvider = C13180a.m43109a(create78);
        $jacocoInit[498] = true;
        ApplicationModule access$10059 = Builder.access$100(builder);
        Provider<AppCenterRepository> provider149 = this.providesAppCenterRepositoryProvider;
        $jacocoInit[499] = true;
        C13181b create79 = ApplicationModule_ProvidesAppCenterFactory.create(access$10059, provider149);
        $jacocoInit[500] = true;
        this.providesAppCenterProvider = C13180a.m43109a(create79);
        $jacocoInit[501] = true;
        ApplicationModule access$10060 = Builder.access$100(builder);
        Provider<AppCenter> provider150 = this.providesAppCenterProvider;
        Provider<InstalledRepository> provider151 = this.provideInstalledRepositoryProvider;
        Provider<InstallManager> provider152 = this.providesInstallManagerProvider;
        Provider<DownloadStateParser> provider153 = this.providesDownloadStateParserProvider;
        $jacocoInit[502] = true;
        C13181b create80 = ApplicationModule_ProvidesWalletAppProviderFactory.create(access$10060, provider150, provider151, provider152, provider153);
        $jacocoInit[503] = true;
        this.providesWalletAppProvider = C13180a.m43109a(create80);
        $jacocoInit[504] = true;
        ApplicationModule access$10061 = Builder.access$100(builder);
        Provider<SharedPreferences> provider154 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[505] = true;
        C13181b create81 = ApplicationModule_ProvidesBaseSecondaryHostFactory.create(access$10061, provider154);
        $jacocoInit[506] = true;
        this.providesBaseSecondaryHostProvider = C13180a.m43109a(create81);
        $jacocoInit[507] = true;
        ApplicationModule access$10062 = Builder.access$100(builder);
        Provider<OkHttpClient> provider155 = this.provideOkHttpClientProvider;
        Provider<String> provider156 = this.providesBaseSecondaryHostProvider;
        Provider<Converter.Factory> provider157 = this.providesConverterFactoryProvider;
        Provider<Factory> provider158 = this.providesCallAdapterFactoryProvider;
        $jacocoInit[508] = true;
        C13181b create82 = ApplicationModule_ProvidesV7SecondaryRetrofitFactory.create(access$10062, provider155, provider156, provider157, provider158);
        $jacocoInit[509] = true;
        this.providesV7SecondaryRetrofitProvider = C13180a.m43109a(create82);
        $jacocoInit[510] = true;
        ApplicationModule access$10063 = Builder.access$100(builder);
        Provider<Retrofit> provider159 = this.providesV7SecondaryRetrofitProvider;
        $jacocoInit[511] = true;
        C13181b create83 = ApplicationModule_ProvidesWalletServiceV8Factory.create(access$10063, provider159);
        $jacocoInit[512] = true;
        this.providesWalletServiceV8Provider = C13180a.m43109a(create83);
        $jacocoInit[513] = true;
        ApplicationModule access$10064 = Builder.access$100(builder);
        Provider<WalletService.ServiceV7> provider160 = this.providesWalletServiceV8Provider;
        $jacocoInit[514] = true;
        C13181b create84 = ApplicationModule_ProvidesWalletServiceFactory.create(access$10064, provider160);
        $jacocoInit[515] = true;
        this.providesWalletServiceProvider = C13180a.m43109a(create84);
        $jacocoInit[516] = true;
        FlavourApplicationModule access$2007 = Builder.access$200(builder);
        $jacocoInit[517] = true;
        C13181b create85 = FlavourApplicationModule_ProvidesSupportEmailFactory.create(access$2007);
        $jacocoInit[518] = true;
        this.providesSupportEmailProvider = C13180a.m43109a(create85);
        $jacocoInit[519] = true;
        ApplicationModule access$10065 = Builder.access$100(builder);
        Provider<String> provider161 = this.providesSupportEmailProvider;
        $jacocoInit[520] = true;
        C13181b create86 = ApplicationModule_ProvidesSupportEmailProviderFactory.create(access$10065, provider161);
        $jacocoInit[521] = true;
        this.providesSupportEmailProvider2 = C13180a.m43109a(create86);
        $jacocoInit[522] = true;
        C13181b create87 = ApplicationModule_ProvidesNewsletterManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[523] = true;
        this.providesNewsletterManagerProvider = C13180a.m43109a(create87);
        $jacocoInit[524] = true;
        ApplicationModule access$10066 = Builder.access$100(builder);
        Provider<BodyInterceptor<BaseBody>> provider162 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<SharedPreferences> provider163 = this.providesDefaultSharedPerefencesProvider;
        Provider<TokenInvalidator> provider164 = this.provideTokenInvalidatorProvider;
        Provider<OkHttpClient> provider165 = this.provideOkHttpClientProvider;
        Provider<Converter.Factory> provider166 = this.providesConverterFactoryProvider;
        Provider<Database> provider167 = this.provideDatabaseProvider;
        Provider<AdsRepository> provider168 = this.provideAdsRepositoryProvider;
        Provider<AptoideAccountManager> provider169 = this.provideAptoideAccountManagerProvider;
        Provider<MoPubAdsManager> provider170 = this.providesMoPubAdsManagerProvider;
        $jacocoInit[525] = true;
        C13181b create88 = ApplicationModule_ProvidesSearchManagerFactory.create(access$10066, provider162, provider163, provider164, provider165, provider166, provider167, provider168, provider169, provider170);
        $jacocoInit[526] = true;
        this.providesSearchManagerProvider = C13180a.m43109a(create88);
        $jacocoInit[527] = true;
        C13181b create89 = ApplicationModule_ProvidesLoginSignupManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[528] = true;
        this.providesLoginSignupManagerProvider = C13180a.m43109a(create89);
        $jacocoInit[529] = true;
        ApplicationModule access$10067 = Builder.access$100(builder);
        Provider<SharedPreferences> provider171 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[530] = true;
        C13181b create90 = ApplicationModule_ProvidesBlacklistPersistenceFactory.create(access$10067, provider171);
        $jacocoInit[531] = true;
        this.providesBlacklistPersistenceProvider = C13180a.m43109a(create90);
        $jacocoInit[532] = true;
        ApplicationModule access$10068 = Builder.access$100(builder);
        Provider<BlacklistPersistence> provider172 = this.providesBlacklistPersistenceProvider;
        $jacocoInit[533] = true;
        C13181b create91 = ApplicationModule_ProvidesBlacklisterFactory.create(access$10068, provider172);
        $jacocoInit[534] = true;
        this.providesBlacklisterProvider = C13180a.m43109a(create91);
        $jacocoInit[535] = true;
        ApplicationModule access$10069 = Builder.access$100(builder);
        $jacocoInit[536] = true;
        C13181b create92 = ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory.create(access$10069);
        $jacocoInit[537] = true;
        this.providesBundleToBlacklistUnitMapperProvider = C13180a.m43109a(create92);
        $jacocoInit[538] = true;
        ApplicationModule access$10070 = Builder.access$100(builder);
        Provider<Blacklister> provider173 = this.providesBlacklisterProvider;
        Provider<BlacklistUnitMapper> provider174 = this.providesBundleToBlacklistUnitMapperProvider;
        $jacocoInit[539] = true;
        C13181b create93 = ApplicationModule_ProvidesBlacklistManagerFactory.create(access$10070, provider173, provider174);
        $jacocoInit[540] = true;
        this.providesBlacklistManagerProvider = C13180a.m43109a(create93);
        $jacocoInit[541] = true;
        FlavourApplicationModule access$2008 = Builder.access$200(builder);
        Provider<BlacklistManager> provider175 = this.providesBlacklistManagerProvider;
        Provider<PackageRepository> provider176 = this.providesPackageRepositoryProvider;
        $jacocoInit[542] = true;
        C13181b create94 = C1370x7d1c8138.create(access$2008, provider175, provider176);
        $jacocoInit[543] = true;
        this.providesWalletAdsOfferCardManagerProvider = C13180a.m43109a(create94);
        $jacocoInit[544] = true;
        ApplicationModule access$10071 = Builder.access$100(builder);
        Provider<String> provider177 = this.provideMarketNameProvider;
        Provider<InstallManager> provider178 = this.providesInstallManagerProvider;
        Provider<WalletAdsOfferCardManager> provider179 = this.providesWalletAdsOfferCardManagerProvider;
        Provider<BlacklistManager> provider180 = this.providesBlacklistManagerProvider;
        $jacocoInit[545] = true;
        C13181b create95 = ApplicationModule_ProvidesBundlesMapperFactory.create(access$10071, provider177, provider178, provider179, provider180);
        $jacocoInit[546] = true;
        this.providesBundlesMapperProvider = C13180a.m43109a(create95);
        $jacocoInit[547] = true;
        ApplicationModule access$10072 = Builder.access$100(builder);
        Provider<BodyInterceptor<BaseBody>> provider181 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<OkHttpClient> provider182 = this.provideOkHttpClientProvider;
        Provider<Converter.Factory> provider183 = this.providesConverterFactoryProvider;
        Provider<BundlesResponseMapper> provider184 = this.providesBundlesMapperProvider;
        Provider<TokenInvalidator> provider185 = this.provideTokenInvalidatorProvider;
        Provider<SharedPreferences> provider186 = this.providesDefaultSharedPerefencesProvider;
        Provider<AptoideAccountManager> provider187 = this.provideAptoideAccountManagerProvider;
        Provider<PackageRepository> provider188 = this.providesPackageRepositoryProvider;
        Provider<Database> provider189 = this.provideDatabaseProvider;
        Provider<IdsRepository> provider190 = this.provideIdsRepositoryProvider;
        Provider<QManager> provider191 = this.provideQManagerProvider;
        Provider<Resources> provider192 = this.provideResourcesProvider;
        Provider<WindowManager> provider193 = this.provideWindowManagerProvider;
        Provider<ConnectivityManager> provider194 = this.providesConnectivityManagerProvider;
        Provider<AdsApplicationVersionCodeProvider> provider195 = this.providesAdsApplicationVersionCodeProvider;
        $jacocoInit[548] = true;
        C13181b create96 = ApplicationModule_ProvidesRemoteBundleDataSourceFactory.create(access$10072, provider181, provider182, provider183, provider184, provider185, provider186, provider187, provider188, provider189, provider190, provider191, provider192, provider193, provider194, provider195);
        $jacocoInit[549] = true;
        this.providesRemoteBundleDataSourceProvider = C13180a.m43109a(create96);
        $jacocoInit[550] = true;
        ApplicationModule access$10073 = Builder.access$100(builder);
        Provider<BundleDataSource> provider196 = this.providesRemoteBundleDataSourceProvider;
        $jacocoInit[551] = true;
        C13181b create97 = ApplicationModule_ProvidesBundleRepositoryFactory.create(access$10073, provider196);
        $jacocoInit[552] = true;
        this.providesBundleRepositoryProvider = C13180a.m43109a(create97);
        $jacocoInit[553] = true;
        ApplicationModule access$10074 = Builder.access$100(builder);
        Provider<DownloadStateParser> provider197 = this.providesDownloadStateParserProvider;
        $jacocoInit[554] = true;
        C13181b create98 = ApplicationModule_ProvidesPromotionViewAppMapperFactory.create(access$10074, provider197);
        $jacocoInit[555] = true;
        this.providesPromotionViewAppMapperProvider = C13180a.m43109a(create98);
        $jacocoInit[556] = true;
        ApplicationModule access$10075 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider198 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider199 = this.provideNavigationTrackerProvider;
        Provider<DownloadAnalytics> provider200 = this.providesDownloadAnalyticsProvider;
        $jacocoInit[557] = true;
        C13181b create99 = ApplicationModule_ProvidesPromotionsAnalyticsFactory.create(access$10075, provider198, provider199, provider200);
        $jacocoInit[558] = true;
        this.providesPromotionsAnalyticsProvider = C13180a.m43109a(create99);
        $jacocoInit[559] = true;
        ApplicationModule access$10076 = Builder.access$100(builder);
        Provider<BodyInterceptor<BaseBody>> provider201 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<OkHttpClient> provider202 = this.provideOkHttpClientProvider;
        Provider<TokenInvalidator> provider203 = this.provideTokenInvalidatorProvider;
        Provider<Converter.Factory> provider204 = this.providesConverterFactoryProvider;
        Provider<SharedPreferences> provider205 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[560] = true;
        C13181b create100 = ApplicationModule_ProvidesPromotionsServiceFactory.create(access$10076, provider201, provider202, provider203, provider204, provider205);
        $jacocoInit[561] = true;
        this.providesPromotionsServiceProvider = C13180a.m43109a(create100);
        $jacocoInit[562] = true;
    }

    private void initialize3(Builder builder) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[563] = true;
        ApplicationModule access$100 = Builder.access$100(builder);
        Provider<InstallManager> provider = this.providesInstallManagerProvider;
        Provider<PromotionViewAppMapper> provider2 = this.providesPromotionViewAppMapperProvider;
        Provider<DownloadFactory> provider3 = this.provideDownloadFactoryProvider;
        Provider<DownloadStateParser> provider4 = this.providesDownloadStateParserProvider;
        Provider<PromotionsAnalytics> provider5 = this.providesPromotionsAnalyticsProvider;
        Provider<NotificationAnalytics> provider6 = this.provideNotificationAnalyticsProvider;
        Provider<InstallAnalytics> provider7 = this.provideInstallAnalyticsProvider;
        Provider<PromotionsService> provider8 = this.providesPromotionsServiceProvider;
        Provider<InstalledRepository> provider9 = this.provideInstalledRepositoryProvider;
        Provider<MoPubAdsManager> provider10 = this.providesMoPubAdsManagerProvider;
        Provider<WalletAppProvider> provider11 = this.providesWalletAppProvider;
        $jacocoInit[564] = true;
        C13181b create = ApplicationModule_ProvidePromotionsManagerFactory.create(access$100, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
        $jacocoInit[565] = true;
        this.providePromotionsManagerProvider = C13180a.m43109a(create);
        $jacocoInit[566] = true;
        ApplicationModule access$1002 = Builder.access$100(builder);
        Provider<SharedPreferences> provider12 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[567] = true;
        C13181b create2 = ApplicationModule_ProvidesUserPreferencesPersisterFactory.create(access$1002, provider12);
        $jacocoInit[568] = true;
        this.providesUserPreferencesPersisterProvider = C13180a.m43109a(create2);
        $jacocoInit[569] = true;
        ApplicationModule access$1003 = Builder.access$100(builder);
        Provider<PreferencesPersister> provider13 = this.providesUserPreferencesPersisterProvider;
        $jacocoInit[570] = true;
        C13181b create3 = ApplicationModule_ProvidesPromotionsPreferencesManagerFactory.create(access$1003, provider13);
        $jacocoInit[571] = true;
        this.providesPromotionsPreferencesManagerProvider = C13180a.m43109a(create3);
        $jacocoInit[572] = true;
        C13181b create4 = ApplicationModule_ProvidesBannerRepositoryFactory.create(Builder.access$100(builder));
        $jacocoInit[573] = true;
        this.providesBannerRepositoryProvider = C13180a.m43109a(create4);
        $jacocoInit[574] = true;
        C13181b create5 = ApplicationModule_ProvideHomePromotionsIdFactory.create(Builder.access$100(builder));
        $jacocoInit[575] = true;
        this.provideHomePromotionsIdProvider = C13180a.m43109a(create5);
        $jacocoInit[576] = true;
        C13181b create6 = ApplicationModule_ProvidesReactionsHostFactory.create(Builder.access$100(builder));
        $jacocoInit[577] = true;
        this.providesReactionsHostProvider = C13180a.m43109a(create6);
        $jacocoInit[578] = true;
        ApplicationModule access$1004 = Builder.access$100(builder);
        Provider<IdsRepository> provider14 = this.provideIdsRepositoryProvider;
        Provider<String> provider15 = this.provideAptoidePackageProvider;
        Provider<AuthenticationPersistence> provider16 = this.provideAuthenticationPersistenceProvider;
        $jacocoInit[579] = true;
        C13181b create7 = ApplicationModule_ProvideUserAgentInterceptorV8Factory.create(access$1004, provider14, provider15, provider16);
        $jacocoInit[580] = true;
        this.provideUserAgentInterceptorV8Provider = C13180a.m43109a(create7);
        $jacocoInit[581] = true;
        ApplicationModule access$1005 = Builder.access$100(builder);
        Provider<L2Cache> provider17 = this.provideL2CacheProvider;
        Provider<Interceptor> provider18 = this.provideUserAgentInterceptorV8Provider;
        Provider<SharedPreferences> provider19 = this.providesDefaultSharedPerefencesProvider;
        Provider<Interceptor> provider20 = this.provideRetrofitLogInterceptorProvider;
        $jacocoInit[582] = true;
        C13181b create8 = ApplicationModule_ProvideV8OkHttpClientFactory.create(access$1005, provider17, provider18, provider19, provider20);
        $jacocoInit[583] = true;
        this.provideV8OkHttpClientProvider = C13180a.m43109a(create8);
        $jacocoInit[584] = true;
        ApplicationModule access$1006 = Builder.access$100(builder);
        Provider<String> provider21 = this.providesReactionsHostProvider;
        Provider<OkHttpClient> provider22 = this.provideV8OkHttpClientProvider;
        Provider<Converter.Factory> provider23 = this.providesConverterFactoryProvider;
        Provider<Factory> provider24 = this.providesCallAdapterFactoryProvider;
        $jacocoInit[585] = true;
        C13181b create9 = ApplicationModule_ProvidesLoadTopReactionsRetrofitFactory.create(access$1006, provider21, provider22, provider23, provider24);
        $jacocoInit[586] = true;
        this.providesLoadTopReactionsRetrofitProvider = C13180a.m43109a(create9);
        $jacocoInit[587] = true;
        ApplicationModule access$1007 = Builder.access$100(builder);
        Provider<Retrofit> provider25 = this.providesLoadTopReactionsRetrofitProvider;
        $jacocoInit[588] = true;
        C13181b create10 = ApplicationModule_ProvidesReactionsServiceV8Factory.create(access$1007, provider25);
        $jacocoInit[589] = true;
        this.providesReactionsServiceV8Provider = C13180a.m43109a(create10);
        $jacocoInit[590] = true;
        ApplicationModule access$1008 = Builder.access$100(builder);
        Provider<ReactionsRemoteService.ServiceV8> provider26 = this.providesReactionsServiceV8Provider;
        $jacocoInit[591] = true;
        C13181b create11 = ApplicationModule_ProvidesReactionsServiceFactory.create(access$1008, provider26);
        $jacocoInit[592] = true;
        this.providesReactionsServiceProvider = C13180a.m43109a(create11);
        $jacocoInit[593] = true;
        ApplicationModule access$1009 = Builder.access$100(builder);
        Provider<ReactionsService> provider27 = this.providesReactionsServiceProvider;
        $jacocoInit[594] = true;
        C13181b create12 = ApplicationModule_ProvidesReactionsManagerFactory.create(access$1009, provider27);
        $jacocoInit[595] = true;
        this.providesReactionsManagerProvider = C13180a.m43109a(create12);
        $jacocoInit[596] = true;
        C13181b create13 = ApplicationModule_ProvidesAdMapperFactory.create(Builder.access$100(builder));
        $jacocoInit[597] = true;
        this.providesAdMapperProvider = C13180a.m43109a(create13);
        $jacocoInit[598] = true;
        FlavourApplicationModule access$200 = Builder.access$200(builder);
        Provider<MoPubConsentManager> provider28 = this.providesMoPubConsentManagerProvider;
        $jacocoInit[599] = true;
        C13181b create14 = FlavourApplicationModule_ProvidesMoPubConsentDialogViewFactory.create(access$200, provider28);
        $jacocoInit[600] = true;
        this.providesMoPubConsentDialogViewProvider = C13180a.m43109a(create14);
        $jacocoInit[601] = true;
        ApplicationModule access$10010 = Builder.access$100(builder);
        $jacocoInit[602] = true;
        C13181b create15 = ApplicationModule_ProvidesCaptionBackgroundPainterFactory.create(access$10010);
        $jacocoInit[603] = true;
        this.providesCaptionBackgroundPainterProvider = C13180a.m43109a(create15);
        $jacocoInit[604] = true;
        ApplicationModule access$10011 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider29 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider30 = this.provideNavigationTrackerProvider;
        $jacocoInit[605] = true;
        C13181b create16 = ApplicationModule_ProvidesUpdatesAnalyticsFactory.create(access$10011, provider29, provider30);
        $jacocoInit[606] = true;
        this.providesUpdatesAnalyticsProvider = C13180a.m43109a(create16);
        $jacocoInit[607] = true;
        C13181b create17 = ApplicationModule_ProvidesMyAccountManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[608] = true;
        this.providesMyAccountManagerProvider = C13180a.m43109a(create17);
        $jacocoInit[609] = true;
        ApplicationModule access$10012 = Builder.access$100(builder);
        Provider<OkHttpClient> provider31 = this.provideOkHttpClientProvider;
        Provider<BodyInterceptor<BaseBody>> provider32 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<TokenInvalidator> provider33 = this.provideTokenInvalidatorProvider;
        Provider<SharedPreferences> provider34 = this.providesDefaultSharedPerefencesProvider;
        Provider<InstallManager> provider35 = this.providesInstallManagerProvider;
        $jacocoInit[610] = true;
        C13181b create18 = ApplicationModule_ProvidesRewardAppCoinsAppsRepositoryFactory.create(access$10012, provider31, provider32, provider33, provider34, provider35);
        $jacocoInit[611] = true;
        this.providesRewardAppCoinsAppsRepositoryProvider = C13180a.m43109a(create18);
        $jacocoInit[612] = true;
        ApplicationModule access$10013 = Builder.access$100(builder);
        Provider<AnalyticsManager> provider36 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider37 = this.provideNavigationTrackerProvider;
        $jacocoInit[613] = true;
        C13181b create19 = ApplicationModule_ProvidesBillingAnalyticsFactory.create(access$10013, provider36, provider37);
        $jacocoInit[614] = true;
        this.providesBillingAnalyticsProvider = C13180a.m43109a(create19);
        $jacocoInit[615] = true;
        ApplicationModule access$10014 = Builder.access$100(builder);
        Provider<DownloadAnalytics> provider38 = this.providesDownloadAnalyticsProvider;
        Provider<AnalyticsManager> provider39 = this.providesAnalyticsManagerProvider;
        Provider<NavigationTracker> provider40 = this.provideNavigationTrackerProvider;
        Provider<BillingAnalytics> provider41 = this.providesBillingAnalyticsProvider;
        Provider<StoreAnalytics> provider42 = this.providesStoreAnalyticsProvider;
        $jacocoInit[616] = true;
        C13181b create20 = ApplicationModule_ProvidesAppViewAnalyticsFactory.create(access$10014, provider38, provider39, provider40, provider41, provider42);
        $jacocoInit[617] = true;
        this.providesAppViewAnalyticsProvider = C13180a.m43109a(create20);
        $jacocoInit[618] = true;
        ApplicationModule access$10015 = Builder.access$100(builder);
        Provider<StoreCredentialsProvider> provider43 = this.providesStoreCredentialsProvider;
        Provider<BodyInterceptor<BaseBody>> provider44 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<OkHttpClient> provider45 = this.provideOkHttpClientProvider;
        Provider<TokenInvalidator> provider46 = this.provideTokenInvalidatorProvider;
        Provider<SharedPreferences> provider47 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[619] = true;
        C13181b create21 = ApplicationModule_ProvidesReviewsServiceFactory.create(access$10015, provider43, provider44, provider45, provider46, provider47);
        $jacocoInit[620] = true;
        this.providesReviewsServiceProvider = C13180a.m43109a(create21);
        $jacocoInit[621] = true;
        ApplicationModule access$10016 = Builder.access$100(builder);
        Provider<ReviewsService> provider48 = this.providesReviewsServiceProvider;
        $jacocoInit[622] = true;
        C13181b create22 = ApplicationModule_ProvidesReviewsRepositoryFactory.create(access$10016, provider48);
        $jacocoInit[623] = true;
        this.providesReviewsRepositoryProvider = C13180a.m43109a(create22);
        $jacocoInit[624] = true;
        ApplicationModule access$10017 = Builder.access$100(builder);
        Provider<ReviewsRepository> provider49 = this.providesReviewsRepositoryProvider;
        $jacocoInit[625] = true;
        C13181b create23 = ApplicationModule_ProvidesReviewsManagerFactory.create(access$10017, provider49);
        $jacocoInit[626] = true;
        this.providesReviewsManagerProvider = C13180a.m43109a(create23);
        $jacocoInit[627] = true;
        ApplicationModule access$10018 = Builder.access$100(builder);
        Provider<AdsRepository> provider50 = this.provideAdsRepositoryProvider;
        $jacocoInit[628] = true;
        C13181b create24 = ApplicationModule_ProvidesAdsManagerFactory.create(access$10018, provider50);
        $jacocoInit[629] = true;
        this.providesAdsManagerProvider = C13180a.m43109a(create24);
        $jacocoInit[630] = true;
        ApplicationModule access$10019 = Builder.access$100(builder);
        Provider<BodyInterceptor<BaseBody>> provider51 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<OkHttpClient> provider52 = this.provideOkHttpClientProvider;
        Provider<TokenInvalidator> provider53 = this.provideTokenInvalidatorProvider;
        Provider<SharedPreferences> provider54 = this.providesDefaultSharedPerefencesProvider;
        Provider<Converter.Factory> provider55 = this.providesConverterFactoryProvider;
        $jacocoInit[631] = true;
        C13181b create25 = ApplicationModule_ProvidesAppCoinsServiceFactory.create(access$10019, provider51, provider52, provider53, provider54, provider55);
        $jacocoInit[632] = true;
        this.providesAppCoinsServiceProvider = C13180a.m43109a(create25);
        $jacocoInit[633] = true;
        ApplicationModule access$10020 = Builder.access$100(builder);
        Provider<OkHttpClient> provider56 = this.provideV8OkHttpClientProvider;
        Provider<Converter.Factory> provider57 = this.providesConverterFactoryProvider;
        Provider<Factory> provider58 = this.providesCallAdapterFactoryProvider;
        $jacocoInit[634] = true;
        C13181b create26 = ApplicationModule_ProvidesDonationsRetrofitFactory.create(access$10020, provider56, provider57, provider58);
        $jacocoInit[635] = true;
        this.providesDonationsRetrofitProvider = C13180a.m43109a(create26);
        $jacocoInit[636] = true;
        ApplicationModule access$10021 = Builder.access$100(builder);
        Provider<Retrofit> provider59 = this.providesDonationsRetrofitProvider;
        $jacocoInit[637] = true;
        C13181b create27 = ApplicationModule_ProvidesDonationsServiceV8Factory.create(access$10021, provider59);
        $jacocoInit[638] = true;
        this.providesDonationsServiceV8Provider = C13180a.m43109a(create27);
        $jacocoInit[639] = true;
        ApplicationModule access$10022 = Builder.access$100(builder);
        Provider<ServiceV8> provider60 = this.providesDonationsServiceV8Provider;
        $jacocoInit[640] = true;
        C13181b create28 = ApplicationModule_ProvidesDonationsServiceFactory.create(access$10022, provider60);
        $jacocoInit[641] = true;
        this.providesDonationsServiceProvider = C13180a.m43109a(create28);
        $jacocoInit[642] = true;
        ApplicationModule access$10023 = Builder.access$100(builder);
        Provider<AppCoinsService> provider61 = this.providesAppCoinsServiceProvider;
        Provider<DonationsService> provider62 = this.providesDonationsServiceProvider;
        $jacocoInit[643] = true;
        C13181b create29 = ApplicationModule_ProvidesAppCoinsManagerFactory.create(access$10023, provider61, provider62);
        $jacocoInit[644] = true;
        this.providesAppCoinsManagerProvider = C13180a.m43109a(create29);
        $jacocoInit[645] = true;
        ApplicationModule access$10024 = Builder.access$100(builder);
        Provider<SyncScheduler> provider63 = this.provideSyncSchedulerProvider;
        Provider<NotificationProvider> provider64 = this.providesNotificationProvider;
        $jacocoInit[646] = true;
        C13181b create30 = ApplicationModule_ProvidesLocalNotificationSyncManagerFactory.create(access$10024, provider63, provider64);
        $jacocoInit[647] = true;
        this.providesLocalNotificationSyncManagerProvider = C13180a.m43109a(create30);
        $jacocoInit[648] = true;
        C13181b create31 = ApplicationModule_ProvidesDecimalFormatFactory.create(Builder.access$100(builder));
        $jacocoInit[649] = true;
        this.providesDecimalFormatProvider = C13180a.m43109a(create31);
        $jacocoInit[650] = true;
        C13181b create32 = ApplicationModule_ProvidesChipManagerFactory.create(Builder.access$100(builder));
        $jacocoInit[651] = true;
        this.providesChipManagerProvider = C13180a.m43109a(create32);
        $jacocoInit[652] = true;
        ApplicationModule access$10025 = Builder.access$100(builder);
        Provider<BodyInterceptor<BaseBody>> provider65 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        Provider<OkHttpClient> provider66 = this.provideOkHttpClientProvider;
        Provider<Converter.Factory> provider67 = this.providesConverterFactoryProvider;
        Provider<TokenInvalidator> provider68 = this.provideTokenInvalidatorProvider;
        Provider<SharedPreferences> provider69 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[653] = true;
        C13181b create33 = ApplicationModule_ProvidesEditorialServiceFactory.create(access$10025, provider65, provider66, provider67, provider68, provider69);
        $jacocoInit[654] = true;
        this.providesEditorialServiceProvider = C13180a.m43109a(create33);
        $jacocoInit[655] = true;
        ApplicationModule access$10026 = Builder.access$100(builder);
        Provider<SharedPreferences> provider70 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[656] = true;
        C13181b create34 = ApplicationModule_ProvidesApichainBdsBaseHostFactory.create(access$10026, provider70);
        $jacocoInit[657] = true;
        this.providesApichainBdsBaseHostProvider = C13180a.m43109a(create34);
        $jacocoInit[658] = true;
        ApplicationModule access$10027 = Builder.access$100(builder);
        Provider<OkHttpClient> provider71 = this.provideV8OkHttpClientProvider;
        Provider<Converter.Factory> provider72 = this.providesConverterFactoryProvider;
        Provider<Factory> provider73 = this.providesCallAdapterFactoryProvider;
        Provider<String> provider74 = this.providesApichainBdsBaseHostProvider;
        $jacocoInit[659] = true;
        C13181b create35 = ApplicationModule_ProvidesApiChainBDSRetrofitFactory.create(access$10027, provider71, provider72, provider73, provider74);
        $jacocoInit[660] = true;
        this.providesApiChainBDSRetrofitProvider = C13180a.m43109a(create35);
        $jacocoInit[661] = true;
        ApplicationModule access$10028 = Builder.access$100(builder);
        Provider<Retrofit> provider75 = this.providesApiChainBDSRetrofitProvider;
        $jacocoInit[662] = true;
        C13181b create36 = ApplicationModule_ProvidesCaptchaServiceInterfaceFactory.create(access$10028, provider75);
        $jacocoInit[663] = true;
        this.providesCaptchaServiceInterfaceProvider = C13180a.m43109a(create36);
        $jacocoInit[664] = true;
        ApplicationModule access$10029 = Builder.access$100(builder);
        Provider<ServiceInterface> provider76 = this.providesCaptchaServiceInterfaceProvider;
        Provider<IdsRepository> provider77 = this.provideIdsRepositoryProvider;
        $jacocoInit[665] = true;
        C13181b create37 = ApplicationModule_ProvidesCaptchaServiceFactory.create(access$10029, provider76, provider77);
        $jacocoInit[666] = true;
        this.providesCaptchaServiceProvider = C13180a.m43109a(create37);
        $jacocoInit[667] = true;
    }

    public void inject(AptoideApplication application) {
        boolean[] $jacocoInit = $jacocoInit();
        injectAptoideApplication(application);
        $jacocoInit[668] = true;
    }

    public void inject(NotificationApplicationView notificationApplicationView) {
        boolean[] $jacocoInit = $jacocoInit();
        injectNotificationApplicationView(notificationApplicationView);
        $jacocoInit[669] = true;
    }

    public void inject(ToolboxContentProvider toolboxContentProvider) {
        boolean[] $jacocoInit = $jacocoInit();
        injectToolboxContentProvider(toolboxContentProvider);
        $jacocoInit[670] = true;
    }

    public void inject(InstallService installService) {
        boolean[] $jacocoInit = $jacocoInit();
        injectInstallService(installService);
        $jacocoInit[671] = true;
    }

    public void inject(InstalledIntentService installedIntentService) {
        boolean[] $jacocoInit = $jacocoInit();
        injectInstalledIntentService(installedIntentService);
        $jacocoInit[672] = true;
    }

    public void inject(PullingContentService pullingContentService) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPullingContentService(pullingContentService);
        $jacocoInit[673] = true;
    }

    public ActivityComponent plus(ActivityModule activityModule, FlavourActivityModule flavourActivityModule) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityComponentImpl activityComponentImpl = new ActivityComponentImpl(this, activityModule, flavourActivityModule, null);
        $jacocoInit[674] = true;
        return activityComponentImpl;
    }

    private AptoideApplication injectAptoideApplication(AptoideApplication instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication_MembersInjector.injectDatabase(instance, (Database) this.provideDatabaseProvider.get());
        Provider<AptoideDownloadManager> provider = this.provideAptoideDownloadManagerProvider;
        $jacocoInit[675] = true;
        AptoideDownloadManager aptoideDownloadManager = (AptoideDownloadManager) provider.get();
        $jacocoInit[676] = true;
        AptoideApplication_MembersInjector.injectAptoideDownloadManager(instance, aptoideDownloadManager);
        Provider<CacheHelper> provider2 = this.provideCacheHelperProvider;
        $jacocoInit[677] = true;
        CacheHelper cacheHelper = (CacheHelper) provider2.get();
        $jacocoInit[678] = true;
        AptoideApplication_MembersInjector.injectCacheHelper(instance, cacheHelper);
        Provider<AptoideAccountManager> provider3 = this.provideAptoideAccountManagerProvider;
        $jacocoInit[679] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider3.get();
        $jacocoInit[680] = true;
        AptoideApplication_MembersInjector.injectAccountManager(instance, aptoideAccountManager);
        Provider<Preferences> provider4 = this.provideDefaultPreferencesProvider;
        $jacocoInit[681] = true;
        Preferences preferences = (Preferences) provider4.get();
        $jacocoInit[682] = true;
        AptoideApplication_MembersInjector.injectPreferences(instance, preferences);
        Provider<SecurePreferences> provider5 = this.providesSecurePerefencesProvider;
        $jacocoInit[683] = true;
        SecurePreferences securePreferences = (SecurePreferences) provider5.get();
        $jacocoInit[684] = true;
        AptoideApplication_MembersInjector.injectSecurePreferences(instance, securePreferences);
        Provider<AdultContent> provider6 = this.provideAdultContentProvider;
        $jacocoInit[685] = true;
        AdultContent adultContent = (AdultContent) provider6.get();
        $jacocoInit[686] = true;
        AptoideApplication_MembersInjector.injectAdultContent(instance, adultContent);
        Provider<IdsRepository> provider7 = this.provideIdsRepositoryProvider;
        $jacocoInit[687] = true;
        IdsRepository idsRepository = (IdsRepository) provider7.get();
        $jacocoInit[688] = true;
        AptoideApplication_MembersInjector.injectIdsRepository(instance, idsRepository);
        Provider<OkHttpClient> provider8 = this.provideOkHttpClientProvider;
        $jacocoInit[689] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider8.get();
        $jacocoInit[690] = true;
        AptoideApplication_MembersInjector.injectDefaultClient(instance, okHttpClient);
        Provider<RootAvailabilityManager> provider9 = this.provideRootAvailabilityManagerProvider;
        $jacocoInit[691] = true;
        RootAvailabilityManager rootAvailabilityManager = (RootAvailabilityManager) provider9.get();
        $jacocoInit[692] = true;
        AptoideApplication_MembersInjector.injectRootAvailabilityManager(instance, rootAvailabilityManager);
        Provider<AuthenticationPersistence> provider10 = this.provideAuthenticationPersistenceProvider;
        $jacocoInit[693] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider10.get();
        $jacocoInit[694] = true;
        AptoideApplication_MembersInjector.injectAuthenticationPersistence(instance, authenticationPersistence);
        Provider<C0075a> provider11 = this.provideCrashlyticsProvider;
        $jacocoInit[695] = true;
        C0075a aVar = (C0075a) provider11.get();
        $jacocoInit[696] = true;
        AptoideApplication_MembersInjector.injectCrashlytics(instance, aVar);
        Provider<SyncScheduler> provider12 = this.provideSyncSchedulerProvider;
        $jacocoInit[697] = true;
        SyncScheduler syncScheduler = (SyncScheduler) provider12.get();
        $jacocoInit[698] = true;
        AptoideApplication_MembersInjector.injectAlarmSyncScheduler(instance, syncScheduler);
        Provider<BodyInterceptor<BaseBody>> provider13 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        $jacocoInit[699] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider13.get();
        $jacocoInit[700] = true;
        AptoideApplication_MembersInjector.injectBodyInterceptorPoolV7(instance, bodyInterceptor);
        Provider<BodyInterceptor<BaseBody>> provider14 = this.provideBodyInterceptorWebV7Provider;
        $jacocoInit[701] = true;
        BodyInterceptor bodyInterceptor2 = (BodyInterceptor) provider14.get();
        $jacocoInit[702] = true;
        AptoideApplication_MembersInjector.injectBodyInterceptorWebV7(instance, bodyInterceptor2);
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider15 = this.providesBodyInterceptorV3Provider;
        $jacocoInit[703] = true;
        BodyInterceptor bodyInterceptor3 = (BodyInterceptor) provider15.get();
        $jacocoInit[704] = true;
        AptoideApplication_MembersInjector.injectBodyInterceptorV3(instance, bodyInterceptor3);
        Provider<L2Cache> provider16 = this.provideL2CacheProvider;
        $jacocoInit[705] = true;
        L2Cache l2Cache = (L2Cache) provider16.get();
        $jacocoInit[706] = true;
        AptoideApplication_MembersInjector.injectHttpClientCache(instance, l2Cache);
        $jacocoInit[707] = true;
        AptoideApplication_MembersInjector.injectQManager(instance, (QManager) this.provideQManagerProvider.get());
        Provider<TokenInvalidator> provider17 = this.provideTokenInvalidatorProvider;
        $jacocoInit[708] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider17.get();
        $jacocoInit[709] = true;
        AptoideApplication_MembersInjector.injectTokenInvalidator(instance, tokenInvalidator);
        Provider<PackageRepository> provider18 = this.providesPackageRepositoryProvider;
        $jacocoInit[710] = true;
        PackageRepository packageRepository = (PackageRepository) provider18.get();
        $jacocoInit[711] = true;
        AptoideApplication_MembersInjector.injectPackageRepository(instance, packageRepository);
        Provider<AdsApplicationVersionCodeProvider> provider19 = this.providesAdsApplicationVersionCodeProvider;
        $jacocoInit[712] = true;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = (AdsApplicationVersionCodeProvider) provider19.get();
        $jacocoInit[713] = true;
        AptoideApplication_MembersInjector.injectApplicationVersionCodeProvider(instance, adsApplicationVersionCodeProvider);
        Provider<AdsRepository> provider20 = this.provideAdsRepositoryProvider;
        $jacocoInit[714] = true;
        AdsRepository adsRepository = (AdsRepository) provider20.get();
        $jacocoInit[715] = true;
        AptoideApplication_MembersInjector.injectAdsRepository(instance, adsRepository);
        Provider<SyncStorage> provider21 = this.provideSyncStorageProvider;
        $jacocoInit[716] = true;
        SyncStorage syncStorage = (SyncStorage) provider21.get();
        $jacocoInit[717] = true;
        AptoideApplication_MembersInjector.injectSyncStorage(instance, syncStorage);
        Provider<NavigationTracker> provider22 = this.provideNavigationTrackerProvider;
        $jacocoInit[718] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider22.get();
        $jacocoInit[719] = true;
        AptoideApplication_MembersInjector.injectNavigationTracker(instance, navigationTracker);
        Provider<BodyInterceptor<BaseBody>> provider23 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        $jacocoInit[720] = true;
        BodyInterceptor bodyInterceptor4 = (BodyInterceptor) provider23.get();
        $jacocoInit[721] = true;
        AptoideApplication_MembersInjector.injectAccountSettingsBodyInterceptorPoolV7(instance, bodyInterceptor4);
        Provider<TrendingManager> provider24 = this.providesTrendingManagerProvider;
        $jacocoInit[722] = true;
        TrendingManager trendingManager = (TrendingManager) provider24.get();
        $jacocoInit[723] = true;
        AptoideApplication_MembersInjector.injectTrendingManager(instance, trendingManager);
        Provider<AdultContentAnalytics> provider25 = this.provideAdultContentAnalyticsProvider;
        $jacocoInit[724] = true;
        AdultContentAnalytics adultContentAnalytics = (AdultContentAnalytics) provider25.get();
        $jacocoInit[725] = true;
        AptoideApplication_MembersInjector.injectAdultContentAnalytics(instance, adultContentAnalytics);
        Provider<NotificationAnalytics> provider26 = this.provideNotificationAnalyticsProvider;
        $jacocoInit[726] = true;
        NotificationAnalytics notificationAnalytics = (NotificationAnalytics) provider26.get();
        $jacocoInit[727] = true;
        AptoideApplication_MembersInjector.injectNotificationAnalytics(instance, notificationAnalytics);
        Provider<SearchSuggestionManager> provider27 = this.providesSearchSuggestionManagerProvider;
        $jacocoInit[728] = true;
        SearchSuggestionManager searchSuggestionManager = (SearchSuggestionManager) provider27.get();
        $jacocoInit[729] = true;
        AptoideApplication_MembersInjector.injectSearchSuggestionManager(instance, searchSuggestionManager);
        Provider<AnalyticsManager> provider28 = this.providesAnalyticsManagerProvider;
        $jacocoInit[730] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider28.get();
        $jacocoInit[731] = true;
        AptoideApplication_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
        Provider<FirstLaunchAnalytics> provider29 = this.providesFirstLaunchAnalyticsProvider;
        $jacocoInit[732] = true;
        FirstLaunchAnalytics firstLaunchAnalytics = (FirstLaunchAnalytics) provider29.get();
        $jacocoInit[733] = true;
        AptoideApplication_MembersInjector.injectFirstLaunchAnalytics(instance, firstLaunchAnalytics);
        Provider<InvalidRefreshTokenLogoutManager> provider30 = this.provideInvalidRefreshTokenLogoutManagerProvider;
        $jacocoInit[734] = true;
        InvalidRefreshTokenLogoutManager invalidRefreshTokenLogoutManager = (InvalidRefreshTokenLogoutManager) provider30.get();
        $jacocoInit[735] = true;
        AptoideApplication_MembersInjector.injectInvalidRefreshTokenLogoutManager(instance, invalidRefreshTokenLogoutManager);
        Provider<RootInstallationRetryHandler> provider31 = this.provideRootInstallationRetryHandlerProvider;
        $jacocoInit[736] = true;
        RootInstallationRetryHandler rootInstallationRetryHandler = (RootInstallationRetryHandler) provider31.get();
        $jacocoInit[737] = true;
        AptoideApplication_MembersInjector.injectRootInstallationRetryHandler(instance, rootInstallationRetryHandler);
        Provider<AptoideShortcutManager> provider32 = this.providesShortcutManagerProvider;
        $jacocoInit[738] = true;
        AptoideShortcutManager aptoideShortcutManager = (AptoideShortcutManager) provider32.get();
        $jacocoInit[739] = true;
        AptoideApplication_MembersInjector.injectShortcutManager(instance, aptoideShortcutManager);
        Provider<SettingsManager> provider33 = this.providesSettingsManagerProvider;
        $jacocoInit[740] = true;
        SettingsManager settingsManager = (SettingsManager) provider33.get();
        $jacocoInit[741] = true;
        AptoideApplication_MembersInjector.injectSettingsManager(instance, settingsManager);
        Provider<InstallManager> provider34 = this.providesInstallManagerProvider;
        $jacocoInit[742] = true;
        InstallManager installManager = (InstallManager) provider34.get();
        $jacocoInit[743] = true;
        AptoideApplication_MembersInjector.injectInstallManager(instance, installManager);
        Provider<List<String>> provider35 = this.provideDefaultFollowedStoresProvider;
        $jacocoInit[744] = true;
        List list = (List) provider35.get();
        $jacocoInit[745] = true;
        AptoideApplication_MembersInjector.injectDefaultFollowedStores(instance, list);
        Provider<AdsUserPropertyManager> provider36 = this.providesMoPubAdsServiceProvider;
        $jacocoInit[746] = true;
        AdsUserPropertyManager adsUserPropertyManager = (AdsUserPropertyManager) provider36.get();
        $jacocoInit[747] = true;
        AptoideApplication_MembersInjector.injectAdsUserPropertyManager(instance, adsUserPropertyManager);
        $jacocoInit[748] = true;
        return instance;
    }

    private NotificationApplicationView injectNotificationApplicationView(NotificationApplicationView instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication_MembersInjector.injectDatabase(instance, (Database) this.provideDatabaseProvider.get());
        Provider<AptoideDownloadManager> provider = this.provideAptoideDownloadManagerProvider;
        $jacocoInit[749] = true;
        AptoideDownloadManager aptoideDownloadManager = (AptoideDownloadManager) provider.get();
        $jacocoInit[750] = true;
        AptoideApplication_MembersInjector.injectAptoideDownloadManager(instance, aptoideDownloadManager);
        Provider<CacheHelper> provider2 = this.provideCacheHelperProvider;
        $jacocoInit[751] = true;
        CacheHelper cacheHelper = (CacheHelper) provider2.get();
        $jacocoInit[752] = true;
        AptoideApplication_MembersInjector.injectCacheHelper(instance, cacheHelper);
        Provider<AptoideAccountManager> provider3 = this.provideAptoideAccountManagerProvider;
        $jacocoInit[753] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider3.get();
        $jacocoInit[754] = true;
        AptoideApplication_MembersInjector.injectAccountManager(instance, aptoideAccountManager);
        Provider<Preferences> provider4 = this.provideDefaultPreferencesProvider;
        $jacocoInit[755] = true;
        Preferences preferences = (Preferences) provider4.get();
        $jacocoInit[756] = true;
        AptoideApplication_MembersInjector.injectPreferences(instance, preferences);
        Provider<SecurePreferences> provider5 = this.providesSecurePerefencesProvider;
        $jacocoInit[757] = true;
        SecurePreferences securePreferences = (SecurePreferences) provider5.get();
        $jacocoInit[758] = true;
        AptoideApplication_MembersInjector.injectSecurePreferences(instance, securePreferences);
        Provider<AdultContent> provider6 = this.provideAdultContentProvider;
        $jacocoInit[759] = true;
        AdultContent adultContent = (AdultContent) provider6.get();
        $jacocoInit[760] = true;
        AptoideApplication_MembersInjector.injectAdultContent(instance, adultContent);
        Provider<IdsRepository> provider7 = this.provideIdsRepositoryProvider;
        $jacocoInit[761] = true;
        IdsRepository idsRepository = (IdsRepository) provider7.get();
        $jacocoInit[762] = true;
        AptoideApplication_MembersInjector.injectIdsRepository(instance, idsRepository);
        Provider<OkHttpClient> provider8 = this.provideOkHttpClientProvider;
        $jacocoInit[763] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider8.get();
        $jacocoInit[764] = true;
        AptoideApplication_MembersInjector.injectDefaultClient(instance, okHttpClient);
        Provider<RootAvailabilityManager> provider9 = this.provideRootAvailabilityManagerProvider;
        $jacocoInit[765] = true;
        RootAvailabilityManager rootAvailabilityManager = (RootAvailabilityManager) provider9.get();
        $jacocoInit[766] = true;
        AptoideApplication_MembersInjector.injectRootAvailabilityManager(instance, rootAvailabilityManager);
        Provider<AuthenticationPersistence> provider10 = this.provideAuthenticationPersistenceProvider;
        $jacocoInit[767] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider10.get();
        $jacocoInit[768] = true;
        AptoideApplication_MembersInjector.injectAuthenticationPersistence(instance, authenticationPersistence);
        Provider<C0075a> provider11 = this.provideCrashlyticsProvider;
        $jacocoInit[769] = true;
        C0075a aVar = (C0075a) provider11.get();
        $jacocoInit[770] = true;
        AptoideApplication_MembersInjector.injectCrashlytics(instance, aVar);
        Provider<SyncScheduler> provider12 = this.provideSyncSchedulerProvider;
        $jacocoInit[771] = true;
        SyncScheduler syncScheduler = (SyncScheduler) provider12.get();
        $jacocoInit[772] = true;
        AptoideApplication_MembersInjector.injectAlarmSyncScheduler(instance, syncScheduler);
        Provider<BodyInterceptor<BaseBody>> provider13 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        $jacocoInit[773] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider13.get();
        $jacocoInit[774] = true;
        AptoideApplication_MembersInjector.injectBodyInterceptorPoolV7(instance, bodyInterceptor);
        Provider<BodyInterceptor<BaseBody>> provider14 = this.provideBodyInterceptorWebV7Provider;
        $jacocoInit[775] = true;
        BodyInterceptor bodyInterceptor2 = (BodyInterceptor) provider14.get();
        $jacocoInit[776] = true;
        AptoideApplication_MembersInjector.injectBodyInterceptorWebV7(instance, bodyInterceptor2);
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider15 = this.providesBodyInterceptorV3Provider;
        $jacocoInit[777] = true;
        BodyInterceptor bodyInterceptor3 = (BodyInterceptor) provider15.get();
        $jacocoInit[778] = true;
        AptoideApplication_MembersInjector.injectBodyInterceptorV3(instance, bodyInterceptor3);
        Provider<L2Cache> provider16 = this.provideL2CacheProvider;
        $jacocoInit[779] = true;
        L2Cache l2Cache = (L2Cache) provider16.get();
        $jacocoInit[780] = true;
        AptoideApplication_MembersInjector.injectHttpClientCache(instance, l2Cache);
        $jacocoInit[781] = true;
        AptoideApplication_MembersInjector.injectQManager(instance, (QManager) this.provideQManagerProvider.get());
        Provider<TokenInvalidator> provider17 = this.provideTokenInvalidatorProvider;
        $jacocoInit[782] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider17.get();
        $jacocoInit[783] = true;
        AptoideApplication_MembersInjector.injectTokenInvalidator(instance, tokenInvalidator);
        Provider<PackageRepository> provider18 = this.providesPackageRepositoryProvider;
        $jacocoInit[784] = true;
        PackageRepository packageRepository = (PackageRepository) provider18.get();
        $jacocoInit[785] = true;
        AptoideApplication_MembersInjector.injectPackageRepository(instance, packageRepository);
        Provider<AdsApplicationVersionCodeProvider> provider19 = this.providesAdsApplicationVersionCodeProvider;
        $jacocoInit[786] = true;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = (AdsApplicationVersionCodeProvider) provider19.get();
        $jacocoInit[787] = true;
        AptoideApplication_MembersInjector.injectApplicationVersionCodeProvider(instance, adsApplicationVersionCodeProvider);
        Provider<AdsRepository> provider20 = this.provideAdsRepositoryProvider;
        $jacocoInit[788] = true;
        AdsRepository adsRepository = (AdsRepository) provider20.get();
        $jacocoInit[789] = true;
        AptoideApplication_MembersInjector.injectAdsRepository(instance, adsRepository);
        Provider<SyncStorage> provider21 = this.provideSyncStorageProvider;
        $jacocoInit[790] = true;
        SyncStorage syncStorage = (SyncStorage) provider21.get();
        $jacocoInit[791] = true;
        AptoideApplication_MembersInjector.injectSyncStorage(instance, syncStorage);
        Provider<NavigationTracker> provider22 = this.provideNavigationTrackerProvider;
        $jacocoInit[792] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider22.get();
        $jacocoInit[793] = true;
        AptoideApplication_MembersInjector.injectNavigationTracker(instance, navigationTracker);
        Provider<BodyInterceptor<BaseBody>> provider23 = this.provideAccountSettingsBodyInterceptorPoolV7Provider;
        $jacocoInit[794] = true;
        BodyInterceptor bodyInterceptor4 = (BodyInterceptor) provider23.get();
        $jacocoInit[795] = true;
        AptoideApplication_MembersInjector.injectAccountSettingsBodyInterceptorPoolV7(instance, bodyInterceptor4);
        Provider<TrendingManager> provider24 = this.providesTrendingManagerProvider;
        $jacocoInit[796] = true;
        TrendingManager trendingManager = (TrendingManager) provider24.get();
        $jacocoInit[797] = true;
        AptoideApplication_MembersInjector.injectTrendingManager(instance, trendingManager);
        Provider<AdultContentAnalytics> provider25 = this.provideAdultContentAnalyticsProvider;
        $jacocoInit[798] = true;
        AdultContentAnalytics adultContentAnalytics = (AdultContentAnalytics) provider25.get();
        $jacocoInit[799] = true;
        AptoideApplication_MembersInjector.injectAdultContentAnalytics(instance, adultContentAnalytics);
        Provider<NotificationAnalytics> provider26 = this.provideNotificationAnalyticsProvider;
        $jacocoInit[800] = true;
        NotificationAnalytics notificationAnalytics = (NotificationAnalytics) provider26.get();
        $jacocoInit[801] = true;
        AptoideApplication_MembersInjector.injectNotificationAnalytics(instance, notificationAnalytics);
        Provider<SearchSuggestionManager> provider27 = this.providesSearchSuggestionManagerProvider;
        $jacocoInit[802] = true;
        SearchSuggestionManager searchSuggestionManager = (SearchSuggestionManager) provider27.get();
        $jacocoInit[803] = true;
        AptoideApplication_MembersInjector.injectSearchSuggestionManager(instance, searchSuggestionManager);
        Provider<AnalyticsManager> provider28 = this.providesAnalyticsManagerProvider;
        $jacocoInit[804] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider28.get();
        $jacocoInit[805] = true;
        AptoideApplication_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
        Provider<FirstLaunchAnalytics> provider29 = this.providesFirstLaunchAnalyticsProvider;
        $jacocoInit[806] = true;
        FirstLaunchAnalytics firstLaunchAnalytics = (FirstLaunchAnalytics) provider29.get();
        $jacocoInit[807] = true;
        AptoideApplication_MembersInjector.injectFirstLaunchAnalytics(instance, firstLaunchAnalytics);
        Provider<InvalidRefreshTokenLogoutManager> provider30 = this.provideInvalidRefreshTokenLogoutManagerProvider;
        $jacocoInit[808] = true;
        InvalidRefreshTokenLogoutManager invalidRefreshTokenLogoutManager = (InvalidRefreshTokenLogoutManager) provider30.get();
        $jacocoInit[809] = true;
        AptoideApplication_MembersInjector.injectInvalidRefreshTokenLogoutManager(instance, invalidRefreshTokenLogoutManager);
        Provider<RootInstallationRetryHandler> provider31 = this.provideRootInstallationRetryHandlerProvider;
        $jacocoInit[810] = true;
        RootInstallationRetryHandler rootInstallationRetryHandler = (RootInstallationRetryHandler) provider31.get();
        $jacocoInit[811] = true;
        AptoideApplication_MembersInjector.injectRootInstallationRetryHandler(instance, rootInstallationRetryHandler);
        Provider<AptoideShortcutManager> provider32 = this.providesShortcutManagerProvider;
        $jacocoInit[812] = true;
        AptoideShortcutManager aptoideShortcutManager = (AptoideShortcutManager) provider32.get();
        $jacocoInit[813] = true;
        AptoideApplication_MembersInjector.injectShortcutManager(instance, aptoideShortcutManager);
        Provider<SettingsManager> provider33 = this.providesSettingsManagerProvider;
        $jacocoInit[814] = true;
        SettingsManager settingsManager = (SettingsManager) provider33.get();
        $jacocoInit[815] = true;
        AptoideApplication_MembersInjector.injectSettingsManager(instance, settingsManager);
        Provider<InstallManager> provider34 = this.providesInstallManagerProvider;
        $jacocoInit[816] = true;
        InstallManager installManager = (InstallManager) provider34.get();
        $jacocoInit[817] = true;
        AptoideApplication_MembersInjector.injectInstallManager(instance, installManager);
        Provider<List<String>> provider35 = this.provideDefaultFollowedStoresProvider;
        $jacocoInit[818] = true;
        List list = (List) provider35.get();
        $jacocoInit[819] = true;
        AptoideApplication_MembersInjector.injectDefaultFollowedStores(instance, list);
        Provider<AdsUserPropertyManager> provider36 = this.providesMoPubAdsServiceProvider;
        $jacocoInit[820] = true;
        AdsUserPropertyManager adsUserPropertyManager = (AdsUserPropertyManager) provider36.get();
        $jacocoInit[821] = true;
        AptoideApplication_MembersInjector.injectAdsUserPropertyManager(instance, adsUserPropertyManager);
        $jacocoInit[822] = true;
        return instance;
    }

    private ToolboxContentProvider injectToolboxContentProvider(ToolboxContentProvider instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AuthenticationPersistence> provider = this.provideAuthenticationPersistenceProvider;
        $jacocoInit[823] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider.get();
        $jacocoInit[824] = true;
        ToolboxContentProvider_MembersInjector.injectAuthenticationPersistence(instance, authenticationPersistence);
        Provider<SharedPreferences> provider2 = this.providesDefaultSharedPerefencesProvider;
        $jacocoInit[825] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider2.get();
        $jacocoInit[826] = true;
        ToolboxContentProvider_MembersInjector.injectSharedPreferences(instance, sharedPreferences);
        Provider<AptoideAccountManager> provider3 = this.provideAptoideAccountManagerProvider;
        $jacocoInit[827] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider3.get();
        $jacocoInit[828] = true;
        ToolboxContentProvider_MembersInjector.injectAccountManager(instance, aptoideAccountManager);
        $jacocoInit[829] = true;
        return instance;
    }

    private InstallService injectInstallService(InstallService instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AptoideDownloadManager> provider = this.provideAptoideDownloadManagerProvider;
        $jacocoInit[830] = true;
        AptoideDownloadManager aptoideDownloadManager = (AptoideDownloadManager) provider.get();
        $jacocoInit[831] = true;
        InstallService_MembersInjector.injectDownloadManager(instance, aptoideDownloadManager);
        Provider<Installer> provider2 = this.provideDefaultInstallerProvider;
        $jacocoInit[832] = true;
        Installer installer = (Installer) provider2.get();
        $jacocoInit[833] = true;
        InstallService_MembersInjector.injectDefaultInstaller(instance, installer);
        Provider<InstalledRepository> provider3 = this.provideInstalledRepositoryProvider;
        $jacocoInit[834] = true;
        InstalledRepository installedRepository = (InstalledRepository) provider3.get();
        $jacocoInit[835] = true;
        InstallService_MembersInjector.injectInstalledRepository(instance, installedRepository);
        Provider<DownloadAnalytics> provider4 = this.providesDownloadAnalyticsProvider;
        $jacocoInit[836] = true;
        DownloadAnalytics downloadAnalytics = (DownloadAnalytics) provider4.get();
        $jacocoInit[837] = true;
        InstallService_MembersInjector.injectDownloadAnalytics(instance, downloadAnalytics);
        $jacocoInit[838] = true;
        InstallService_MembersInjector.injectCacheManager(instance, (CacheHelper) this.provideCacheHelperProvider.get());
        $jacocoInit[839] = true;
        return instance;
    }

    private InstalledIntentService injectInstalledIntentService(InstalledIntentService instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<InstallAnalytics> provider = this.provideInstallAnalyticsProvider;
        $jacocoInit[840] = true;
        InstallAnalytics installAnalytics = (InstallAnalytics) provider.get();
        $jacocoInit[841] = true;
        InstalledIntentService_MembersInjector.injectInstallAnalytics(instance, installAnalytics);
        Provider<CampaignAnalytics> provider2 = this.providesCampaignAnalyticsProvider;
        $jacocoInit[842] = true;
        CampaignAnalytics campaignAnalytics = (CampaignAnalytics) provider2.get();
        $jacocoInit[843] = true;
        InstalledIntentService_MembersInjector.injectCampaignAnalytics(instance, campaignAnalytics);
        Provider<AppcMigrationManager> provider3 = this.providesAppcMigrationManagerProvider;
        $jacocoInit[844] = true;
        AppcMigrationManager appcMigrationManager = (AppcMigrationManager) provider3.get();
        $jacocoInit[845] = true;
        InstalledIntentService_MembersInjector.injectAppcMigrationManager(instance, appcMigrationManager);
        $jacocoInit[846] = true;
        return instance;
    }

    private PullingContentService injectPullingContentService(PullingContentService instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = this.provideMarketNameProvider;
        $jacocoInit[847] = true;
        String str = (String) provider.get();
        $jacocoInit[848] = true;
        PullingContentService_MembersInjector.injectMarketName(instance, str);
        Provider<DownloadFactory> provider2 = this.provideDownloadFactoryProvider;
        $jacocoInit[849] = true;
        DownloadFactory downloadFactory = (DownloadFactory) provider2.get();
        $jacocoInit[850] = true;
        PullingContentService_MembersInjector.injectDownloadFactory(instance, downloadFactory);
        $jacocoInit[851] = true;
        return instance;
    }
}
