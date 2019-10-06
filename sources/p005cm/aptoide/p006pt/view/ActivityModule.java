package p005cm.aptoide.p006pt.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.p000v4.app.C0486t;
import android.support.p001v7.app.C0019n;
import android.view.WindowManager;
import com.facebook.C6666i;
import com.facebook.login.C6745C;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Map;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.AppShortcutsAnalytics;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.DeepLinkAnalytics;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksKeys;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.account.view.ImagePickerNavigator;
import p005cm.aptoide.p006pt.account.view.PhotoFileGenerator;
import p005cm.aptoide.p006pt.account.view.UriToPathResolver;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreNavigator;
import p005cm.aptoide.p006pt.account.view.user.ManageUserNavigator;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.app.view.AppViewNavigator;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateManager;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateRepository;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateService;
import p005cm.aptoide.p006pt.autoupdate.Service;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationAnalytics;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.editorial.EditorialNavigator;
import p005cm.aptoide.p006pt.home.AptoideBottomNavigator;
import p005cm.aptoide.p006pt.home.apps.UpdatesManager;
import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallCompletedNotifier;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.install.installer.RootInstallationRetryHandler;
import p005cm.aptoide.p006pt.navigator.ActivityNavigator;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentResultNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.notification.ContentPuller;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.notification.NotificationSyncScheduler;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.permission.AccountPermissionProvider;
import p005cm.aptoide.p006pt.permission.PermissionProvider;
import p005cm.aptoide.p006pt.presenter.MainPresenter;
import p005cm.aptoide.p006pt.presenter.MainView;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View;
import p005cm.aptoide.p006pt.promotions.CaptchaService;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionsManager;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionsNavigator;
import p005cm.aptoide.p006pt.promotions.PromotionsManager;
import p005cm.aptoide.p006pt.promotions.PromotionsNavigator;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.search.SearchNavigator;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenManager;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenNavigator;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.util.ApkFy;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.view.DeepLinkManager.DeepLinkMessages;
import p005cm.aptoide.p006pt.view.app.ListStoreAppsNavigator;
import p005cm.aptoide.p006pt.view.dialog.DialogUtils;
import p005cm.aptoide.p006pt.view.settings.MyAccountNavigator;
import p005cm.aptoide.p006pt.wallet.WalletAppProvider;
import p005cm.aptoide.p006pt.wallet.WalletInstallAnalytics;
import p005cm.aptoide.p006pt.wallet.WalletInstallConfiguration;
import p005cm.aptoide.p006pt.wallet.WalletInstallManager;
import p005cm.aptoide.p006pt.wallet.WalletInstallNavigator;
import p005cm.aptoide.p006pt.wallet.WalletInstallPresenter;
import p005cm.aptoide.p006pt.wallet.WalletInstallView;
import p019d.p022i.p023b.C0099b;
import p019d.p022i.p023b.C0100e;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.view.ActivityModule */
public class ActivityModule {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C0019n activity;
    private final String fileProviderAuthority;
    private boolean firstCreated;
    private final Intent intent;
    private final NotificationSyncScheduler notificationSyncScheduler;
    private final View view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-9166984670542616751L, "cm/aptoide/pt/view/ActivityModule", 56);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule(C0019n activity2, Intent intent2, NotificationSyncScheduler notificationSyncScheduler2, View view2, boolean firstCreated2, String fileProviderAuthority2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.activity = activity2;
        this.intent = intent2;
        this.notificationSyncScheduler = notificationSyncScheduler2;
        this.view = view2;
        this.firstCreated = firstCreated2;
        this.fileProviderAuthority = fileProviderAuthority2;
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public ApkFy provideApkFy(@Named("secureShared") SharedPreferences securePreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        ApkFy apkFy = new ApkFy(this.activity, this.intent, securePreferences);
        $jacocoInit[1] = true;
        return apkFy;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public AutoUpdateService providesRetrofitAptoideBiService(Service service, @Named("package-name") String packageName, @Named("auto-update-store-name") String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateService autoUpdateService = new AutoUpdateService(service, packageName, storeName);
        $jacocoInit[2] = true;
        return autoUpdateService;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public AutoUpdateRepository providesAutoUpdateRepository(AutoUpdateService autoUpdateService) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateRepository autoUpdateRepository = new AutoUpdateRepository(autoUpdateService);
        $jacocoInit[3] = true;
        return autoUpdateRepository;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public FragmentNavigator provideMainFragmentNavigator(Map<Integer, Result> fragmentResultMap, C0099b<Map<Integer, Result>> fragmentResultRelay, C0486t fragmentManager) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentResultNavigator fragmentResultNavigator = new FragmentResultNavigator(fragmentManager, C1375R.C1376id.fragment_placeholder, 17432576, 17432577, fragmentResultMap, fragmentResultRelay);
        $jacocoInit[4] = true;
        return fragmentResultNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public C0486t provideFragmentManager() {
        boolean[] $jacocoInit = $jacocoInit();
        C0486t supportFragmentManager = this.activity.getSupportFragmentManager();
        $jacocoInit[5] = true;
        return supportFragmentManager;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public SearchNavigator providesSearchNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchNavigator searchNavigator = new SearchNavigator(fragmentNavigator, appNavigator);
        $jacocoInit[6] = true;
        return searchNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public DeepLinkManager provideDeepLinkManager(NotificationAnalytics notificationAnalytics, StoreUtilsProxy storeUtilsProxy, StoreRepository storeRepository, @Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator, SearchNavigator searchNavigator, @Named("default") SharedPreferences sharedPreferences, StoreAccessor storeAccessor, NavigationTracker navigationTracker, SearchAnalytics searchAnalytics, DeepLinkAnalytics deepLinkAnalytics, AppShortcutsAnalytics appShortcutsAnalytics, AptoideAccountManager accountManager, StoreAnalytics storeAnalytics, AdsRepository adsRepository, AppNavigator appNavigator, @Named("aptoide-theme") String theme) {
        NotificationAnalytics notificationAnalytics2 = notificationAnalytics;
        StoreUtilsProxy storeUtilsProxy2 = storeUtilsProxy;
        StoreRepository storeRepository2 = storeRepository;
        FragmentNavigator fragmentNavigator2 = fragmentNavigator;
        BottomNavigationNavigator bottomNavigationNavigator2 = bottomNavigationNavigator;
        SearchNavigator searchNavigator2 = searchNavigator;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        StoreAccessor storeAccessor2 = storeAccessor;
        NavigationTracker navigationTracker2 = navigationTracker;
        SearchAnalytics searchAnalytics2 = searchAnalytics;
        DeepLinkAnalytics deepLinkAnalytics2 = deepLinkAnalytics;
        AppShortcutsAnalytics appShortcutsAnalytics2 = appShortcutsAnalytics;
        AptoideAccountManager aptoideAccountManager = accountManager;
        StoreAnalytics storeAnalytics2 = storeAnalytics;
        AdsRepository adsRepository2 = adsRepository;
        AppNavigator appNavigator2 = appNavigator;
        String str = theme;
        boolean[] $jacocoInit = $jacocoInit();
        DeepLinkManager deepLinkManager = new DeepLinkManager(storeUtilsProxy2, storeRepository2, fragmentNavigator2, bottomNavigationNavigator2, searchNavigator2, (DeepLinkMessages) this.activity, sharedPreferences2, storeAccessor2, str, notificationAnalytics2, navigationTracker2, searchAnalytics2, appShortcutsAnalytics2, aptoideAccountManager, deepLinkAnalytics2, storeAnalytics2, adsRepository2, appNavigator2);
        $jacocoInit[7] = true;
        return deepLinkManager;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public Presenter provideMainPresenter(RootInstallationRetryHandler rootInstallationRetryHandler, ApkFy apkFy, InstallManager installManager, @Named("default") SharedPreferences sharedPreferences, @Named("secureShared") SharedPreferences secureSharedPreferences, @Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, DeepLinkManager deepLinkManager, BottomNavigationNavigator bottomNavigationNavigator, UpdatesManager updatesManager, AutoUpdateManager autoUpdateManager, SplashScreenManager splashScreenManager, SplashScreenNavigator splashScreenNavigator) {
        RootInstallationRetryHandler rootInstallationRetryHandler2 = rootInstallationRetryHandler;
        ApkFy apkFy2 = apkFy;
        InstallManager installManager2 = installManager;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        SharedPreferences sharedPreferences3 = secureSharedPreferences;
        FragmentNavigator fragmentNavigator2 = fragmentNavigator;
        DeepLinkManager deepLinkManager2 = deepLinkManager;
        BottomNavigationNavigator bottomNavigationNavigator2 = bottomNavigationNavigator;
        UpdatesManager updatesManager2 = updatesManager;
        AutoUpdateManager autoUpdateManager2 = autoUpdateManager;
        SplashScreenManager splashScreenManager2 = splashScreenManager;
        SplashScreenNavigator splashScreenNavigator2 = splashScreenNavigator;
        boolean[] $jacocoInit = $jacocoInit();
        MainView mainView = (MainView) this.view;
        $jacocoInit[8] = true;
        CrashReport instance = CrashReport.getInstance();
        ContentPuller contentPuller = r8;
        ContentPuller contentPuller2 = new ContentPuller(this.activity);
        NotificationSyncScheduler notificationSyncScheduler2 = this.notificationSyncScheduler;
        InstallCompletedNotifier installCompletedNotifier = r14;
        $jacocoInit[9] = true;
        C0100e o = C0100e.m565o();
        $jacocoInit[10] = true;
        MainView mainView2 = mainView;
        InstallCompletedNotifier installCompletedNotifier2 = new InstallCompletedNotifier(o, installManager, CrashReport.getInstance());
        boolean z = this.firstCreated;
        AptoideBottomNavigator aptoideBottomNavigator = (AptoideBottomNavigator) this.activity;
        $jacocoInit[11] = true;
        MainPresenter mainPresenter = new MainPresenter(mainView2, installManager2, rootInstallationRetryHandler2, instance, apkFy2, contentPuller, notificationSyncScheduler2, installCompletedNotifier, sharedPreferences2, sharedPreferences3, fragmentNavigator2, deepLinkManager2, z, aptoideBottomNavigator, C14522a.m46170a(), Schedulers.m776io(), bottomNavigationNavigator2, updatesManager2, autoUpdateManager2, splashScreenManager2, splashScreenNavigator2);
        $jacocoInit[12] = true;
        return mainPresenter;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public SplashScreenManager provideSplashScreenManager() {
        boolean[] $jacocoInit = $jacocoInit();
        SplashScreenManager splashScreenManager = new SplashScreenManager();
        $jacocoInit[13] = true;
        return splashScreenManager;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public SplashScreenNavigator provideSplashScreenNavigator(BottomNavigationNavigator bottomNavigationNavigator, @Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        SplashScreenNavigator splashScreenNavigator = new SplashScreenNavigator(bottomNavigationNavigator, fragmentNavigator);
        $jacocoInit[14] = true;
        return splashScreenNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public AccountNavigator provideAccountNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AptoideAccountManager accountManager, C6666i callbackManager, GoogleApiClient googleApiClient, AccountAnalytics accountAnalytics, BottomNavigationNavigator bottomNavigationNavigator, @Named("aptoide-theme") String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityNavigator activityNavigator = (ActivityNavigator) this.activity;
        $jacocoInit[15] = true;
        C6745C a = C6745C.m13592a();
        $jacocoInit[16] = true;
        AccountNavigator accountNavigator = new AccountNavigator(bottomNavigationNavigator, fragmentNavigator, accountManager, activityNavigator, a, callbackManager, googleApiClient, C0100e.m565o(), "http://m.aptoide.com/account/password-recovery", accountAnalytics, theme);
        $jacocoInit[17] = true;
        return accountNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public ScreenOrientationManager provideScreenOrientationManager() {
        boolean[] $jacocoInit = $jacocoInit();
        C0019n nVar = this.activity;
        $jacocoInit[18] = true;
        ScreenOrientationManager screenOrientationManager = new ScreenOrientationManager(nVar, (WindowManager) nVar.getSystemService("window"));
        $jacocoInit[19] = true;
        return screenOrientationManager;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public AccountPermissionProvider provideAccountPermissionProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        AccountPermissionProvider accountPermissionProvider = new AccountPermissionProvider((PermissionProvider) this.activity);
        $jacocoInit[20] = true;
        return accountPermissionProvider;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public PhotoFileGenerator providePhotoFileGenerator() {
        boolean[] $jacocoInit = $jacocoInit();
        C0019n nVar = this.activity;
        String str = Environment.DIRECTORY_PICTURES;
        $jacocoInit[21] = true;
        PhotoFileGenerator photoFileGenerator = new PhotoFileGenerator(nVar, nVar.getExternalFilesDir(str), this.fileProviderAuthority);
        $jacocoInit[22] = true;
        return photoFileGenerator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public UriToPathResolver provideUriToPathResolver() {
        boolean[] $jacocoInit = $jacocoInit();
        UriToPathResolver uriToPathResolver = new UriToPathResolver(this.activity.getContentResolver());
        $jacocoInit[23] = true;
        return uriToPathResolver;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public ImagePickerNavigator provideImagePickerNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        ImagePickerNavigator imagePickerNavigator = new ImagePickerNavigator((ActivityNavigator) this.activity);
        $jacocoInit[24] = true;
        return imagePickerNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public ManageStoreNavigator provideManageStoreNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStoreNavigator manageStoreNavigator = new ManageStoreNavigator(fragmentNavigator, bottomNavigationNavigator);
        $jacocoInit[25] = true;
        return manageStoreNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public ManageUserNavigator provideManageUserNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageUserNavigator manageUserNavigator = new ManageUserNavigator(fragmentNavigator, bottomNavigationNavigator);
        $jacocoInit[26] = true;
        return manageUserNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public ListStoreAppsNavigator provideListStoreAppsNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoreAppsNavigator listStoreAppsNavigator = new ListStoreAppsNavigator(fragmentNavigator, appNavigator);
        $jacocoInit[27] = true;
        return listStoreAppsNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public MyAccountNavigator provideMyAccountNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AccountNavigator accountNavigator, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        MyAccountNavigator myAccountNavigator = new MyAccountNavigator(fragmentNavigator, accountNavigator, appNavigator);
        $jacocoInit[28] = true;
        return myAccountNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public BottomNavigationMapper provideBottomNavigationMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationMapper bottomNavigationMapper = new BottomNavigationMapper();
        $jacocoInit[29] = true;
        return bottomNavigationMapper;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public BottomNavigationNavigator provideBottomNavigationNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationAnalytics bottomNavigationAnalytics, SearchAnalytics searchAnalytics, @Named("aptoide-theme") String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationNavigator bottomNavigationNavigator = new BottomNavigationNavigator(fragmentNavigator, bottomNavigationAnalytics, searchAnalytics, theme);
        $jacocoInit[30] = true;
        return bottomNavigationNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public BottomNavigationAnalytics providesBottomNavigationAnalytics(AnalyticsManager manager, NavigationTracker tracker) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationAnalytics bottomNavigationAnalytics = new BottomNavigationAnalytics(manager, tracker);
        $jacocoInit[31] = true;
        return bottomNavigationAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public AppViewNavigator providesAppViewNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewNavigator appViewNavigator = new AppViewNavigator(fragmentNavigator, (ActivityNavigator) this.activity, appNavigator);
        $jacocoInit[32] = true;
        return appViewNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public DialogUtils providesDialogUtils(AptoideAccountManager accountManager, AccountNavigator accountNavigator, @Named("mature-pool-v7") BodyInterceptor<BaseBody> bodyInterceptor, @Named("default") OkHttpClient httpClient, Factory converterFactory, InstalledRepository installedRepository, TokenInvalidator tokenInvalidator, @Named("default") SharedPreferences sharedPreferences, Resources resources, @Named("marketName") String marketName, MarketResourceFormatter marketResourceFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        DialogUtils dialogUtils = new DialogUtils(accountManager, accountNavigator, bodyInterceptor, httpClient, converterFactory, installedRepository, tokenInvalidator, sharedPreferences, resources, marketName, marketResourceFormatter);
        $jacocoInit[33] = true;
        return dialogUtils;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public AppNavigator providesAppNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppNavigator appNavigator = new AppNavigator(fragmentNavigator);
        $jacocoInit[34] = true;
        return appNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public AppCoinsInfoNavigator providesAppCoinsInfoNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsInfoNavigator appCoinsInfoNavigator = new AppCoinsInfoNavigator(fragmentNavigator);
        $jacocoInit[35] = true;
        return appCoinsInfoNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public EditorialNavigator providesEditorialNavigator(AppNavigator appNavigator, AccountNavigator accountNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialNavigator editorialNavigator = new EditorialNavigator((ActivityNavigator) this.activity, appNavigator, accountNavigator);
        $jacocoInit[36] = true;
        return editorialNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public float providesScreenHeight(Resources resources) {
        float f = (float) resources.getDisplayMetrics().heightPixels;
        $jacocoInit()[37] = true;
        return f;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public float providesScreenWidth(Resources resources) {
        float f = (float) resources.getDisplayMetrics().widthPixels;
        $jacocoInit()[38] = true;
        return f;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public DonationsAnalytics providesDonationsAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        DonationsAnalytics donationsAnalytics = new DonationsAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[39] = true;
        return donationsAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public AutoUpdateManager provideAutoUpdateManager(DownloadFactory downloadFactory, PermissionManager permissionManager, InstallManager installManager, DownloadAnalytics downloadAnalytics, @Named("local-version-code") int localVersionCode, AutoUpdateRepository autoUpdateRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateManager autoUpdateManager = new AutoUpdateManager(downloadFactory, permissionManager, installManager, downloadAnalytics, localVersionCode, autoUpdateRepository, VERSION.SDK_INT);
        $jacocoInit[40] = true;
        return autoUpdateManager;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public String providePackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = this.activity.getPackageName();
        $jacocoInit[41] = true;
        return packageName;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public int provideLocalVersionCode(@Named("package-name") String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            PackageManager packageManager = this.activity.getPackageManager();
            $jacocoInit[42] = true;
            int i = packageManager.getPackageInfo(packageName, 0).versionCode;
            $jacocoInit[43] = true;
            return i;
        } catch (NameNotFoundException e) {
            $jacocoInit[44] = true;
            return -1;
        }
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public ClaimPromotionsManager providesClaimPromotionsManager(CaptchaService captchaService, PromotionsManager promotionsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionsManager claimPromotionsManager = new ClaimPromotionsManager(promotionsManager, captchaService);
        $jacocoInit[45] = true;
        return claimPromotionsManager;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public ClaimPromotionsNavigator providesClaimPromotionsNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionsNavigator claimPromotionsNavigator = new ClaimPromotionsNavigator(fragmentNavigator, (ActivityResultNavigator) this.activity);
        $jacocoInit[46] = true;
        return claimPromotionsNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public PromotionsNavigator providesPromotionsNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsNavigator promotionsNavigator = new PromotionsNavigator(fragmentNavigator);
        $jacocoInit[47] = true;
        return promotionsNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public WalletInstallPresenter providesWalletInstallPresenter(WalletInstallNavigator walletInstallNavigator, WalletInstallManager walletInstallManager) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallView walletInstallView = (WalletInstallView) this.view;
        PermissionManager permissionManager = new PermissionManager();
        PermissionService permissionService = (PermissionService) this.activity;
        $jacocoInit[48] = true;
        WalletInstallPresenter walletInstallPresenter = new WalletInstallPresenter(walletInstallView, walletInstallManager, walletInstallNavigator, permissionManager, permissionService, C14522a.m46170a(), Schedulers.m776io());
        $jacocoInit[49] = true;
        return walletInstallPresenter;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public WalletInstallNavigator providesWalletInstallNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallNavigator walletInstallNavigator = new WalletInstallNavigator(fragmentNavigator);
        $jacocoInit[50] = true;
        return walletInstallNavigator;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public WalletInstallManager providesWalletInstallManager(WalletInstallConfiguration configuration, InstallManager installManager, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, MoPubAdsManager moPubAdsManager, WalletInstallAnalytics walletInstallAnalytics, InstalledRepository installedRepository, WalletAppProvider walletAppProvider, AppInstallerStatusReceiver appInstallerStatusReceiver) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallManager walletInstallManager = new WalletInstallManager(configuration, this.activity.getPackageManager(), installManager, downloadFactory, downloadStateParser, moPubAdsManager, walletInstallAnalytics, installedRepository, walletAppProvider, appInstallerStatusReceiver);
        $jacocoInit[51] = true;
        return walletInstallManager;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public WalletInstallAnalytics providesWalletInstallAnalytics(DownloadAnalytics downloadAnalytics, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, DownloadStateParser downloadStateParser, AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallAnalytics walletInstallAnalytics = new WalletInstallAnalytics(downloadAnalytics, notificationAnalytics, installAnalytics, downloadStateParser, analyticsManager, navigationTracker);
        $jacocoInit[52] = true;
        return walletInstallAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @ActivityScope
    public WalletInstallConfiguration providesWalletInstallConfiguration() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent2 = this.intent;
        $jacocoInit[53] = true;
        String stringExtra = intent2.getStringExtra("packageName");
        Intent intent3 = this.intent;
        $jacocoInit[54] = true;
        WalletInstallConfiguration walletInstallConfiguration = new WalletInstallConfiguration(stringExtra, intent3.getStringExtra(DeepLinksKeys.WALLET_PACKAGE_NAME_KEY));
        $jacocoInit[55] = true;
        return walletInstallConfiguration;
    }
}
