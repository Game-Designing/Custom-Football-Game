package p005cm.aptoide.p006pt.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.view.WindowManager;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14377B;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.ErrorsMapper;
import p005cm.aptoide.p006pt.account.view.AccountErrorMapper;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.account.view.ImagePickerNavigator;
import p005cm.aptoide.p006pt.account.view.ImagePickerPresenter;
import p005cm.aptoide.p006pt.account.view.ImagePickerView;
import p005cm.aptoide.p006pt.account.view.ImageValidator;
import p005cm.aptoide.p006pt.account.view.PhotoFileGenerator;
import p005cm.aptoide.p006pt.account.view.UriToPathResolver;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreErrorMapper;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreNavigator;
import p005cm.aptoide.p006pt.account.view.store.ManageStorePresenter;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreView;
import p005cm.aptoide.p006pt.account.view.store.StoreManager;
import p005cm.aptoide.p006pt.account.view.user.CreateUserErrorMapper;
import p005cm.aptoide.p006pt.account.view.user.ManageUserNavigator;
import p005cm.aptoide.p006pt.account.view.user.ManageUserPresenter;
import p005cm.aptoide.p006pt.account.view.user.ManageUserView;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.app.AdsManager;
import p005cm.aptoide.p006pt.app.AppCoinsManager;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.AppViewAnalytics;
import p005cm.aptoide.p006pt.app.AppViewManager;
import p005cm.aptoide.p006pt.app.CampaignAnalytics;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.app.FlagManager;
import p005cm.aptoide.p006pt.app.FlagService;
import p005cm.aptoide.p006pt.app.ReviewsManager;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationManager;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationService;
import p005cm.aptoide.p006pt.app.view.AppCoinsInfoView;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.BundleKeys;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.app.view.AppViewNavigator;
import p005cm.aptoide.p006pt.app.view.AppViewPresenter;
import p005cm.aptoide.p006pt.app.view.AppViewView;
import p005cm.aptoide.p006pt.app.view.MoreBundleManager;
import p005cm.aptoide.p006pt.app.view.MoreBundlePresenter;
import p005cm.aptoide.p006pt.app.view.MoreBundleView;
import p005cm.aptoide.p006pt.billing.view.login.PaymentLoginFlavorPresenter;
import p005cm.aptoide.p006pt.billing.view.login.PaymentLoginView;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.editorial.EditorialAnalytics;
import p005cm.aptoide.p006pt.editorial.EditorialFragment;
import p005cm.aptoide.p006pt.editorial.EditorialManager;
import p005cm.aptoide.p006pt.editorial.EditorialNavigator;
import p005cm.aptoide.p006pt.editorial.EditorialPresenter;
import p005cm.aptoide.p006pt.editorial.EditorialRepository;
import p005cm.aptoide.p006pt.editorial.EditorialService;
import p005cm.aptoide.p006pt.editorial.EditorialView;
import p005cm.aptoide.p006pt.editorialList.EditorialListAnalytics;
import p005cm.aptoide.p006pt.editorialList.EditorialListManager;
import p005cm.aptoide.p006pt.editorialList.EditorialListNavigator;
import p005cm.aptoide.p006pt.editorialList.EditorialListPresenter;
import p005cm.aptoide.p006pt.editorialList.EditorialListRepository;
import p005cm.aptoide.p006pt.editorialList.EditorialListService;
import p005cm.aptoide.p006pt.editorialList.EditorialListView;
import p005cm.aptoide.p006pt.home.AdMapper;
import p005cm.aptoide.p006pt.home.AptoideBottomNavigator;
import p005cm.aptoide.p006pt.home.BannerRepository;
import p005cm.aptoide.p006pt.home.BundlesRepository;
import p005cm.aptoide.p006pt.home.ChipManager;
import p005cm.aptoide.p006pt.home.Home;
import p005cm.aptoide.p006pt.home.HomeAnalytics;
import p005cm.aptoide.p006pt.home.HomeContainerNavigator;
import p005cm.aptoide.p006pt.home.HomeContainerPresenter;
import p005cm.aptoide.p006pt.home.HomeContainerView;
import p005cm.aptoide.p006pt.home.HomeNavigator;
import p005cm.aptoide.p006pt.home.HomePresenter;
import p005cm.aptoide.p006pt.home.HomeView;
import p005cm.aptoide.p006pt.home.apps.AppMapper;
import p005cm.aptoide.p006pt.home.apps.AppsFragmentView;
import p005cm.aptoide.p006pt.home.apps.AppsManager;
import p005cm.aptoide.p006pt.home.apps.AppsNavigator;
import p005cm.aptoide.p006pt.home.apps.AppsPresenter;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcFragment;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcManager;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcPresenter;
import p005cm.aptoide.p006pt.home.apps.UpdatesManager;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.navigator.ActivityNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentResultNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.notification.AppcPromotionNotificationStringProvider;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.notification.sync.LocalNotificationSyncManager;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.permission.AccountPermissionProvider;
import p005cm.aptoide.p006pt.presenter.LoginSignUpCredentialsView;
import p005cm.aptoide.p006pt.presenter.LoginSignupCredentialsFlavorPresenter;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionDialogPresenter;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionDialogView;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionsManager;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionsNavigator;
import p005cm.aptoide.p006pt.promotions.PromotionViewAppMapper;
import p005cm.aptoide.p006pt.promotions.PromotionsAnalytics;
import p005cm.aptoide.p006pt.promotions.PromotionsManager;
import p005cm.aptoide.p006pt.promotions.PromotionsNavigator;
import p005cm.aptoide.p006pt.promotions.PromotionsPreferencesManager;
import p005cm.aptoide.p006pt.promotions.PromotionsPresenter;
import p005cm.aptoide.p006pt.promotions.PromotionsView;
import p005cm.aptoide.p006pt.reactions.ReactionsManager;
import p005cm.aptoide.p006pt.search.SearchManager;
import p005cm.aptoide.p006pt.search.SearchNavigator;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionManager;
import p005cm.aptoide.p006pt.search.suggestions.TrendingManager;
import p005cm.aptoide.p006pt.search.view.SearchResultPresenter;
import p005cm.aptoide.p006pt.search.view.SearchResultView;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenNavigator;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresNavigator;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresPresenter;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresView;
import p005cm.aptoide.p006pt.updates.UpdatesAnalytics;
import p005cm.aptoide.p006pt.view.app.AppCenter;
import p005cm.aptoide.p006pt.view.splashscreen.SplashScreenPresenter;
import p005cm.aptoide.p006pt.view.splashscreen.SplashScreenView;
import p005cm.aptoide.p006pt.view.wizard.WizardPresenter;
import p005cm.aptoide.p006pt.view.wizard.WizardView;
import p019d.p022i.p023b.C0099b;
import p026rx.C0126V;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.view.FragmentModule */
public class FragmentModule {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Bundle arguments;
    private final Fragment fragment;
    private final boolean isCreateStoreUserPrivacyEnabled;
    private final String packageName;
    private final Bundle savedInstance;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6887221636410798437L, "cm/aptoide/pt/view/FragmentModule", 107);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule(Fragment fragment2, Bundle savedInstance2, Bundle arguments2, boolean isCreateStoreUserPrivacyEnabled2, String packageName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragment = fragment2;
        this.savedInstance = savedInstance2;
        this.arguments = arguments2;
        this.isCreateStoreUserPrivacyEnabled = isCreateStoreUserPrivacyEnabled2;
        this.packageName = packageName2;
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public LoginSignupCredentialsFlavorPresenter provideLoginSignUpPresenter(AptoideAccountManager accountManager, AccountNavigator accountNavigator, AccountErrorMapper errorMapper, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        LoginSignUpCredentialsView loginSignUpCredentialsView = (LoginSignUpCredentialsView) this.fragment;
        $jacocoInit[1] = true;
        CrashReport instance = CrashReport.getInstance();
        Bundle bundle = this.arguments;
        $jacocoInit[2] = true;
        boolean z = bundle.getBoolean("dismiss_to_navigate_to_main_view");
        Bundle bundle2 = this.arguments;
        $jacocoInit[3] = true;
        boolean z2 = bundle2.getBoolean("clean_back_stack");
        String str = "email";
        String[] strArr = {str, "user_friends"};
        $jacocoInit[4] = true;
        List asList = Arrays.asList(strArr);
        String[] strArr2 = {str};
        LoginSignupCredentialsFlavorPresenter loginSignupCredentialsFlavorPresenter = new LoginSignupCredentialsFlavorPresenter(loginSignUpCredentialsView, accountManager, instance, z, z2, accountNavigator, asList, Arrays.asList(strArr2), errorMapper, accountAnalytics);
        $jacocoInit[5] = true;
        return loginSignupCredentialsFlavorPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public FragmentNavigator provideHomeFragmentNavigator(Map<Integer, Result> fragmentResultMap, C0099b<Map<Integer, Result>> fragmentResultRelay) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentResultNavigator fragmentResultNavigator = new FragmentResultNavigator(this.fragment.getChildFragmentManager(), C1375R.C1376id.main_home_container_content, 17432576, 17432577, fragmentResultMap, fragmentResultRelay);
        $jacocoInit[6] = true;
        return fragmentResultNavigator;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public ImagePickerPresenter provideImagePickerPresenter(AccountPermissionProvider accountPermissionProvider, PhotoFileGenerator photoFileGenerator, ImageValidator imageValidator, UriToPathResolver uriToPathResolver, ImagePickerNavigator imagePickerNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ImagePickerView imagePickerView = (ImagePickerView) this.fragment;
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[7] = true;
        C0126V a = C14522a.m46170a();
        Fragment fragment2 = this.fragment;
        $jacocoInit[8] = true;
        C0014p activity = fragment2.getActivity();
        $jacocoInit[9] = true;
        ImagePickerPresenter imagePickerPresenter = new ImagePickerPresenter(imagePickerView, instance, accountPermissionProvider, photoFileGenerator, imageValidator, a, uriToPathResolver, imagePickerNavigator, activity.getContentResolver(), ImageLoader.with(this.fragment.getContext()));
        $jacocoInit[10] = true;
        return imagePickerPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public ManageStorePresenter provideManageStorePresenter(UriToPathResolver uriToPathResolver, ManageStoreNavigator manageStoreNavigator, ManageStoreErrorMapper manageStoreErrorMapper, AptoideAccountManager accountManager, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStoreView manageStoreView = (ManageStoreView) this.fragment;
        CrashReport instance = CrashReport.getInstance();
        String str = this.packageName;
        Bundle bundle = this.arguments;
        $jacocoInit[11] = true;
        boolean z = bundle.getBoolean("go_to_home", true);
        Bundle bundle2 = this.arguments;
        $jacocoInit[12] = true;
        ManageStorePresenter manageStorePresenter = new ManageStorePresenter(manageStoreView, instance, uriToPathResolver, str, manageStoreNavigator, z, manageStoreErrorMapper, accountManager, bundle2.getInt(FragmentNavigator.REQUEST_CODE_EXTRA), accountAnalytics);
        $jacocoInit[13] = true;
        return manageStorePresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public ManageUserPresenter provideManageUserPresenter(AptoideAccountManager accountManager, CreateUserErrorMapper errorMapper, ManageUserNavigator manageUserNavigator, UriToPathResolver uriToPathResolver, AccountAnalytics accountAnalytics) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        ManageUserView manageUserView = (ManageUserView) this.fragment;
        CrashReport instance = CrashReport.getInstance();
        Bundle bundle = this.arguments;
        $jacocoInit[14] = true;
        boolean z2 = bundle.getBoolean("is_edit", false);
        boolean z3 = this.isCreateStoreUserPrivacyEnabled;
        if (this.savedInstance == null) {
            $jacocoInit[15] = true;
            z = true;
        } else {
            $jacocoInit[16] = true;
            z = false;
        }
        ManageUserPresenter manageUserPresenter = new ManageUserPresenter(manageUserView, instance, accountManager, errorMapper, manageUserNavigator, z2, uriToPathResolver, z3, z, accountAnalytics);
        $jacocoInit[17] = true;
        return manageUserPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public ImageValidator provideImageValidator() {
        boolean[] $jacocoInit = $jacocoInit();
        ImageValidator imageValidator = new ImageValidator(ImageLoader.with(this.fragment.getContext()), Schedulers.computation());
        $jacocoInit[18] = true;
        return imageValidator;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public CreateUserErrorMapper provideCreateUserErrorMapper(AccountErrorMapper accountErrorMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = this.fragment.getContext();
        Fragment fragment2 = this.fragment;
        $jacocoInit[19] = true;
        CreateUserErrorMapper createUserErrorMapper = new CreateUserErrorMapper(context, accountErrorMapper, fragment2.getResources());
        $jacocoInit[20] = true;
        return createUserErrorMapper;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public AccountErrorMapper provideAccountErrorMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        AccountErrorMapper accountErrorMapper = new AccountErrorMapper(this.fragment.getContext(), new ErrorsMapper());
        $jacocoInit[21] = true;
        return accountErrorMapper;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public ManageStoreErrorMapper provideManageStoreErrorMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStoreErrorMapper manageStoreErrorMapper = new ManageStoreErrorMapper(this.fragment.getResources(), new ErrorsMapper());
        $jacocoInit[22] = true;
        return manageStoreErrorMapper;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public SearchResultPresenter provideSearchResultPresenter(SearchAnalytics searchAnalytics, SearchNavigator searchNavigator, SearchManager searchManager, TrendingManager trendingManager, SearchSuggestionManager searchSuggestionManager, BottomNavigationMapper bottomNavigationMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchResultView searchResultView = (SearchResultView) this.fragment;
        $jacocoInit[23] = true;
        CrashReport instance = CrashReport.getInstance();
        C0126V a = C14522a.m46170a();
        Fragment fragment2 = this.fragment;
        $jacocoInit[24] = true;
        AptoideBottomNavigator aptoideBottomNavigator = (AptoideBottomNavigator) fragment2.getActivity();
        $jacocoInit[25] = true;
        SearchResultPresenter searchResultPresenter = new SearchResultPresenter(searchResultView, searchAnalytics, searchNavigator, instance, a, searchManager, trendingManager, searchSuggestionManager, aptoideBottomNavigator, bottomNavigationMapper, Schedulers.m776io());
        $jacocoInit[26] = true;
        return searchResultPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public SplashScreenPresenter providesSplashScreenPresenter(SplashScreenNavigator splashScreenNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        SplashScreenPresenter splashScreenPresenter = new SplashScreenPresenter((SplashScreenView) this.fragment, splashScreenNavigator);
        $jacocoInit[27] = true;
        return splashScreenPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public HomePresenter providesHomePresenter(Home home, HomeNavigator homeNavigator, AdMapper adMapper, AptoideAccountManager aptoideAccountManager, HomeAnalytics homeAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeView homeView = (HomeView) this.fragment;
        C0126V a = C14522a.m46170a();
        $jacocoInit[28] = true;
        HomePresenter homePresenter = new HomePresenter(homeView, home, a, CrashReport.getInstance(), homeNavigator, adMapper, homeAnalytics);
        $jacocoInit[29] = true;
        return homePresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public HomeNavigator providesHomeNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper, AppNavigator appNavigator, @Named("aptoide-theme") String theme, AccountNavigator accountNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideBottomNavigator aptoideBottomNavigator = (AptoideBottomNavigator) this.fragment.getActivity();
        Fragment fragment2 = this.fragment;
        $jacocoInit[30] = true;
        HomeNavigator homeNavigator = new HomeNavigator(fragmentNavigator, aptoideBottomNavigator, bottomNavigationMapper, appNavigator, (ActivityNavigator) fragment2.getActivity(), theme, accountNavigator);
        $jacocoInit[31] = true;
        return homeNavigator;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public HomeContainerNavigator providesHomeContainerNavigator(@Named("home-fragment-navigator") FragmentNavigator childFragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeContainerNavigator homeContainerNavigator = new HomeContainerNavigator(childFragmentNavigator);
        $jacocoInit[32] = true;
        return homeContainerNavigator;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public Home providesHome(BundlesRepository bundlesRepository, PromotionsManager promotionsManager, PromotionsPreferencesManager promotionsPreferencesManager, BannerRepository bannerRepository, MoPubAdsManager moPubAdsManager, BlacklistManager blacklistManager, @Named("homePromotionsId") String promotionsType, ReactionsManager reactionsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        Home home = new Home(bundlesRepository, promotionsManager, bannerRepository, moPubAdsManager, promotionsPreferencesManager, blacklistManager, promotionsType, reactionsManager);
        $jacocoInit[33] = true;
        return home;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public MyStoresPresenter providesMyStorePresenter(AptoideAccountManager aptoideAccountManager, MyStoresNavigator navigator) {
        boolean[] $jacocoInit = $jacocoInit();
        MyStoresPresenter myStoresPresenter = new MyStoresPresenter((MyStoresView) this.fragment, C14522a.m46170a(), aptoideAccountManager, navigator);
        $jacocoInit[34] = true;
        return myStoresPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public MyStoresNavigator providesMyStoreNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        MyStoresNavigator myStoresNavigator = new MyStoresNavigator(fragmentNavigator, (AptoideBottomNavigator) this.fragment.getActivity(), bottomNavigationMapper);
        $jacocoInit[35] = true;
        return myStoresNavigator;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public HomeAnalytics providesHomeAnalytics(AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics homeAnalytics = new HomeAnalytics(navigationTracker, analyticsManager);
        $jacocoInit[36] = true;
        return homeAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public AppsNavigator providesAppsNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsNavigator appsNavigator = new AppsNavigator(fragmentNavigator, (AptoideBottomNavigator) this.fragment.getActivity(), bottomNavigationMapper, appNavigator);
        $jacocoInit[37] = true;
        return appsNavigator;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public FlagManager providesFlagManager(FlagService flagService) {
        boolean[] $jacocoInit = $jacocoInit();
        FlagManager flagManager = new FlagManager(flagService);
        $jacocoInit[38] = true;
        return flagManager;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public FlagService providesFlagService(@Named("defaultInterceptorV3") BodyInterceptor<BaseBody> bodyInterceptorV3, @Named("default") OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        FlagService flagService = new FlagService(bodyInterceptorV3, okHttpClient, tokenInvalidator, sharedPreferences);
        $jacocoInit[39] = true;
        return flagService;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public AppViewManager providesAppViewManager(InstallManager installManager, DownloadFactory downloadFactory, AppCenter appCenter, ReviewsManager reviewsManager, AdsManager adsManager, StoreManager storeManager, FlagManager flagManager, StoreUtilsProxy storeUtilsProxy, AptoideAccountManager aptoideAccountManager, AppViewConfiguration appViewConfiguration, DownloadStateParser downloadStateParser, AppViewAnalytics appViewAnalytics, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, Resources resources, WindowManager windowManager, @Named("marketName") String marketName, AppCoinsManager appCoinsManager, MoPubAdsManager moPubAdsManager, PromotionsManager promotionsManager, InstalledRepository installedRepository, AppcMigrationManager appcMigrationManager, LocalNotificationSyncManager localNotificationSyncManager, AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider, AppcMigrationService appcMigrationService) {
        InstallManager installManager2 = installManager;
        DownloadFactory downloadFactory2 = downloadFactory;
        AppCenter appCenter2 = appCenter;
        ReviewsManager reviewsManager2 = reviewsManager;
        AdsManager adsManager2 = adsManager;
        StoreManager storeManager2 = storeManager;
        FlagManager flagManager2 = flagManager;
        StoreUtilsProxy storeUtilsProxy2 = storeUtilsProxy;
        AptoideAccountManager aptoideAccountManager2 = aptoideAccountManager;
        AppViewConfiguration appViewConfiguration2 = appViewConfiguration;
        DownloadStateParser downloadStateParser2 = downloadStateParser;
        AppViewAnalytics appViewAnalytics2 = appViewAnalytics;
        NotificationAnalytics notificationAnalytics2 = notificationAnalytics;
        InstallAnalytics installAnalytics2 = installAnalytics;
        String str = marketName;
        AppCoinsManager appCoinsManager2 = appCoinsManager;
        MoPubAdsManager moPubAdsManager2 = moPubAdsManager;
        PromotionsManager promotionsManager2 = promotionsManager;
        InstalledRepository installedRepository2 = installedRepository;
        AppcMigrationManager appcMigrationManager2 = appcMigrationManager;
        LocalNotificationSyncManager localNotificationSyncManager2 = localNotificationSyncManager;
        AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider2 = appcPromotionNotificationStringProvider;
        boolean[] $jacocoInit = $jacocoInit();
        Type type = Type.APPS_GROUP;
        $jacocoInit[40] = true;
        AppViewManager appViewManager = new AppViewManager(installManager2, downloadFactory2, appCenter2, reviewsManager2, adsManager2, storeManager2, flagManager2, storeUtilsProxy2, aptoideAccountManager2, appViewConfiguration2, moPubAdsManager2, downloadStateParser2, appViewAnalytics2, notificationAnalytics2, installAnalytics2, type.getPerLineCount(resources, windowManager) * 6, Schedulers.m776io(), str, appCoinsManager2, promotionsManager2, installedRepository2, appcMigrationManager2, localNotificationSyncManager2, appcPromotionNotificationStringProvider2);
        $jacocoInit[41] = true;
        return appViewManager;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public AppViewPresenter providesAppViewPresenter(AccountNavigator accountNavigator, AppViewAnalytics analytics, CampaignAnalytics campaignAnalytics, AppViewNavigator appViewNavigator, AppViewManager appViewManager, AptoideAccountManager accountManager, CrashReport crashReport, PromotionsNavigator promotionsNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewView appViewView = (AppViewView) this.fragment;
        $jacocoInit[42] = true;
        C0126V a = C14522a.m46170a();
        PermissionManager permissionManager = new PermissionManager();
        Fragment fragment2 = this.fragment;
        $jacocoInit[43] = true;
        AppViewPresenter appViewPresenter = new AppViewPresenter(appViewView, accountNavigator, analytics, campaignAnalytics, appViewNavigator, appViewManager, accountManager, a, crashReport, permissionManager, (PermissionService) fragment2.getContext(), promotionsNavigator);
        $jacocoInit[44] = true;
        return appViewPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public AppViewConfiguration providesAppViewConfiguration() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.arguments.getLong(BundleKeys.APP_ID.name(), -1);
        Bundle bundle = this.arguments;
        BundleKeys bundleKeys = BundleKeys.PACKAGE_NAME;
        $jacocoInit[45] = true;
        String string = bundle.getString(bundleKeys.name(), null);
        Bundle bundle2 = this.arguments;
        BundleKeys bundleKeys2 = BundleKeys.STORE_NAME;
        $jacocoInit[46] = true;
        String string2 = bundle2.getString(bundleKeys2.name(), null);
        Bundle bundle3 = this.arguments;
        BundleKeys bundleKeys3 = BundleKeys.STORE_THEME;
        $jacocoInit[47] = true;
        String str = "";
        String string3 = bundle3.getString(bundleKeys3.name(), str);
        Bundle bundle4 = this.arguments;
        BundleKeys bundleKeys4 = BundleKeys.MINIMAL_AD;
        $jacocoInit[48] = true;
        SearchAdResult searchAdResult = (SearchAdResult) C14377B.m45945a(bundle4.getParcelable(bundleKeys4.name()));
        Bundle bundle5 = this.arguments;
        BundleKeys bundleKeys5 = BundleKeys.SHOULD_INSTALL;
        $jacocoInit[49] = true;
        OpenType openType = (OpenType) bundle5.getSerializable(bundleKeys5.name());
        Bundle bundle6 = this.arguments;
        BundleKeys bundleKeys6 = BundleKeys.MD5;
        $jacocoInit[50] = true;
        String string4 = bundle6.getString(bundleKeys6.name(), str);
        Bundle bundle7 = this.arguments;
        BundleKeys bundleKeys7 = BundleKeys.UNAME;
        $jacocoInit[51] = true;
        String string5 = bundle7.getString(bundleKeys7.name(), str);
        Bundle bundle8 = this.arguments;
        BundleKeys bundleKeys8 = BundleKeys.APPC;
        $jacocoInit[52] = true;
        double d = bundle8.getDouble(bundleKeys8.name(), -1.0d);
        Bundle bundle9 = this.arguments;
        BundleKeys bundleKeys9 = BundleKeys.EDITORS_CHOICE_POSITION;
        $jacocoInit[53] = true;
        String string6 = bundle9.getString(bundleKeys9.name(), str);
        Bundle bundle10 = this.arguments;
        BundleKeys bundleKeys10 = BundleKeys.ORIGIN_TAG;
        $jacocoInit[54] = true;
        String str2 = string6;
        String string7 = bundle10.getString(bundleKeys10.name(), str);
        Bundle bundle11 = this.arguments;
        BundleKeys bundleKeys11 = BundleKeys.DOWNLOAD_CONVERSION_URL;
        $jacocoInit[55] = true;
        AppViewConfiguration appViewConfiguration = new AppViewConfiguration(j, string, string2, string3, searchAdResult, openType, string4, string5, d, str2, string7, bundle11.getString(bundleKeys11.name(), str));
        $jacocoInit[56] = true;
        return appViewConfiguration;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public MoreBundlePresenter providesGetStoreWidgetsPresenter(MoreBundleManager moreBundleManager, CrashReport crashReport, HomeNavigator homeNavigator, AdMapper adMapper, BundleEvent bundleEvent, HomeAnalytics homeAnalytics, ChipManager chipManager) {
        boolean[] $jacocoInit = $jacocoInit();
        MoreBundleView moreBundleView = (MoreBundleView) this.fragment;
        $jacocoInit[57] = true;
        MoreBundlePresenter moreBundlePresenter = new MoreBundlePresenter(moreBundleView, moreBundleManager, C14522a.m46170a(), crashReport, homeNavigator, adMapper, bundleEvent, homeAnalytics, chipManager);
        $jacocoInit[58] = true;
        return moreBundlePresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public MoreBundleManager providesGetStoreManager(BundlesRepository bundlesRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        MoreBundleManager moreBundleManager = new MoreBundleManager(bundlesRepository);
        $jacocoInit[59] = true;
        return moreBundleManager;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public BundleEvent providesBundleEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        String string = this.arguments.getString("title");
        Bundle bundle = this.arguments;
        $jacocoInit[60] = true;
        BundleEvent bundleEvent = new BundleEvent(string, bundle.getString("action"));
        $jacocoInit[61] = true;
        return bundleEvent;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public WizardPresenter providesWizardPresenter(AptoideAccountManager aptoideAccountManager, CrashReport crashReport, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        WizardPresenter wizardPresenter = new WizardPresenter((WizardView) this.fragment, aptoideAccountManager, crashReport, accountAnalytics);
        $jacocoInit[62] = true;
        return wizardPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public PaymentLoginFlavorPresenter providesPaymentLoginPresenter(AccountNavigator accountNavigator, AptoideAccountManager accountManager, CrashReport crashReport, AccountErrorMapper accountErrorMapper, ScreenOrientationManager screenOrientationManager, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        PaymentLoginView paymentLoginView = (PaymentLoginView) this.fragment;
        Bundle bundle = this.arguments;
        $jacocoInit[63] = true;
        int i = bundle.getInt(FragmentNavigator.REQUEST_CODE_EXTRA);
        String str = "email";
        String[] strArr = {str, "user_friends"};
        $jacocoInit[64] = true;
        List asList = Arrays.asList(strArr);
        List asList2 = Arrays.asList(new String[]{str});
        $jacocoInit[65] = true;
        PaymentLoginFlavorPresenter paymentLoginFlavorPresenter = new PaymentLoginFlavorPresenter(paymentLoginView, i, asList, accountNavigator, asList2, accountManager, crashReport, accountErrorMapper, C14522a.m46170a(), screenOrientationManager, accountAnalytics);
        $jacocoInit[66] = true;
        return paymentLoginFlavorPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public AppCoinsInfoPresenter providesAppCoinsInfoPresenter(AppCoinsInfoNavigator appCoinsInfoNavigator, InstallManager installManager, CrashReport crashReport) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsInfoView appCoinsInfoView = (AppCoinsInfoView) this.fragment;
        $jacocoInit[67] = true;
        AppCoinsInfoNavigator appCoinsInfoNavigator2 = appCoinsInfoNavigator;
        InstallManager installManager2 = installManager;
        CrashReport crashReport2 = crashReport;
        AppCoinsInfoPresenter appCoinsInfoPresenter = new AppCoinsInfoPresenter(appCoinsInfoView, appCoinsInfoNavigator2, installManager2, crashReport2, "com.appcoins.wallet", C14522a.m46170a());
        $jacocoInit[68] = true;
        return appCoinsInfoPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public EditorialManager providesEditorialManager(EditorialRepository editorialRepository, InstallManager installManager, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, EditorialAnalytics editorialAnalytics, ReactionsManager reactionsManager, MoPubAdsManager moPubAdsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = this.arguments;
        $jacocoInit[69] = true;
        EditorialManager editorialManager = new EditorialManager(editorialRepository, bundle.getString("cardId", ""), installManager, downloadFactory, downloadStateParser, notificationAnalytics, installAnalytics, editorialAnalytics, reactionsManager, moPubAdsManager);
        $jacocoInit[70] = true;
        return editorialManager;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public EditorialRepository providesEditorialRepository(EditorialService editorialService) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialRepository editorialRepository = new EditorialRepository(editorialService);
        $jacocoInit[71] = true;
        return editorialRepository;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public EditorialPresenter providesEditorialPresenter(EditorialManager editorialManager, CrashReport crashReport, EditorialAnalytics editorialAnalytics, EditorialNavigator editorialNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialView editorialView = (EditorialView) this.fragment;
        $jacocoInit[72] = true;
        C0126V a = C14522a.m46170a();
        PermissionManager permissionManager = new PermissionManager();
        Fragment fragment2 = this.fragment;
        $jacocoInit[73] = true;
        EditorialPresenter editorialPresenter = new EditorialPresenter(editorialView, editorialManager, a, crashReport, permissionManager, (PermissionService) fragment2.getContext(), editorialAnalytics, editorialNavigator);
        $jacocoInit[74] = true;
        return editorialPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public PromotionsPresenter providesPromotionsPresenter(PromotionsManager promotionsManager, PromotionsAnalytics promotionsAnalytics, PromotionsNavigator promotionsNavigator, @Named("homePromotionsId") String promotionsType) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsView promotionsView = (PromotionsView) this.fragment;
        PermissionManager permissionManager = new PermissionManager();
        Fragment fragment2 = this.fragment;
        $jacocoInit[75] = true;
        PermissionService permissionService = (PermissionService) fragment2.getContext();
        $jacocoInit[76] = true;
        PromotionsPresenter promotionsPresenter = new PromotionsPresenter(promotionsView, promotionsManager, permissionManager, permissionService, C14522a.m46170a(), promotionsAnalytics, promotionsNavigator, promotionsType);
        $jacocoInit[77] = true;
        return promotionsPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public PromotionViewAppMapper providesPromotionViewAppMapper(DownloadStateParser downloadStateParser) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewAppMapper promotionViewAppMapper = new PromotionViewAppMapper(downloadStateParser);
        $jacocoInit[78] = true;
        return promotionViewAppMapper;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public ClaimPromotionDialogPresenter providesClaimPromotionDialogPresenter(ClaimPromotionsManager claimPromotionsManager, PromotionsAnalytics promotionsAnalytics, ClaimPromotionsNavigator navigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionDialogView claimPromotionDialogView = (ClaimPromotionDialogView) this.fragment;
        C0136c cVar = new C0136c();
        $jacocoInit[79] = true;
        C0126V a = C14522a.m46170a();
        Bundle bundle = this.arguments;
        $jacocoInit[80] = true;
        ClaimPromotionDialogPresenter claimPromotionDialogPresenter = new ClaimPromotionDialogPresenter(claimPromotionDialogView, cVar, a, claimPromotionsManager, promotionsAnalytics, navigator, bundle.getString("promotion_id", BuildConfig.APTOIDE_THEME));
        $jacocoInit[81] = true;
        return claimPromotionDialogPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public EditorialListPresenter providesEditorialListPresenter(EditorialListManager editorialListManager, AptoideAccountManager aptoideAccountManager, EditorialListNavigator editorialListNavigator, EditorialListAnalytics editorialListAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListView editorialListView = (EditorialListView) this.fragment;
        $jacocoInit[82] = true;
        EditorialListPresenter editorialListPresenter = new EditorialListPresenter(editorialListView, editorialListManager, aptoideAccountManager, editorialListNavigator, editorialListAnalytics, CrashReport.getInstance(), C14522a.m46170a());
        $jacocoInit[83] = true;
        return editorialListPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public EditorialListManager providesEditorialListManager(EditorialListRepository editorialListRepository, ReactionsManager reactionsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListManager editorialListManager = new EditorialListManager(editorialListRepository, reactionsManager);
        $jacocoInit[84] = true;
        return editorialListManager;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public EditorialListRepository providesEditorialListRepository(EditorialListService editorialListService) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListRepository editorialListRepository = new EditorialListRepository(editorialListService);
        $jacocoInit[85] = true;
        return editorialListRepository;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public EditorialListService providesEditorialService(@Named("mature-pool-v7") BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody> bodyInterceptorPoolV7, @Named("default") OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, @Named("default") SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[86] = true;
        EditorialListService editorialListService = new EditorialListService(bodyInterceptorPoolV7, okHttpClient, tokenInvalidator, WebService.getDefaultConverter(), sharedPreferences, 10);
        $jacocoInit[87] = true;
        return editorialListService;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public EditorialListNavigator providesEditorialListNavigator(@Named("main-fragment-navigator") FragmentNavigator fragmentNavigator, AccountNavigator accountNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListNavigator editorialListNavigator = new EditorialListNavigator(fragmentNavigator, accountNavigator);
        $jacocoInit[88] = true;
        return editorialListNavigator;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public EditorialListAnalytics editorialListAnalytics(NavigationTracker navigationTracker, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListAnalytics editorialListAnalytics = new EditorialListAnalytics(navigationTracker, analyticsManager);
        $jacocoInit[89] = true;
        return editorialListAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public EditorialAnalytics providesEditorialAnalytics(DownloadAnalytics downloadAnalytics, AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = this.arguments;
        $jacocoInit[90] = true;
        EditorialAnalytics editorialAnalytics = new EditorialAnalytics(downloadAnalytics, analyticsManager, navigationTracker, bundle.getBoolean(EditorialFragment.FROM_HOME));
        $jacocoInit[91] = true;
        return editorialAnalytics;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public HomeContainerPresenter providesHomeContainerPresenter(CrashReport crashReport, AptoideAccountManager accountManager, HomeContainerNavigator homeContainerNavigator, HomeNavigator homeNavigator, HomeAnalytics homeAnalytics, Home home, ChipManager chipManager) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeContainerPresenter homeContainerPresenter = new HomeContainerPresenter((HomeContainerView) this.fragment, C14522a.m46170a(), crashReport, accountManager, homeContainerNavigator, homeNavigator, homeAnalytics, home, chipManager);
        $jacocoInit[92] = true;
        return homeContainerPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public AppMapper providesAppMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        AppMapper appMapper = new AppMapper();
        $jacocoInit[93] = true;
        return appMapper;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public AppsManager providesAppsManager(UpdatesManager updatesManager, InstallManager installManager, AppMapper appMapper, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, UpdatesAnalytics updatesAnalytics, DownloadFactory downloadFactory, MoPubAdsManager moPubAdsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment fragment2 = this.fragment;
        $jacocoInit[94] = true;
        Context context = fragment2.getContext();
        $jacocoInit[95] = true;
        AppsManager appsManager = new AppsManager(updatesManager, installManager, appMapper, downloadAnalytics, installAnalytics, updatesAnalytics, context.getPackageManager(), this.fragment.getContext(), downloadFactory, moPubAdsManager);
        $jacocoInit[96] = true;
        return appsManager;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public AppsPresenter providesAppsPresenter(AppsManager appsManager, AptoideAccountManager aptoideAccountManager, AppsNavigator appsNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsFragmentView appsFragmentView = (AppsFragmentView) this.fragment;
        $jacocoInit[97] = true;
        C0126V a = C14522a.m46170a();
        C0126V io = Schedulers.m776io();
        CrashReport instance = CrashReport.getInstance();
        PermissionManager permissionManager = new PermissionManager();
        Fragment fragment2 = this.fragment;
        $jacocoInit[98] = true;
        AppsPresenter appsPresenter = new AppsPresenter(appsFragmentView, appsManager, a, io, instance, permissionManager, (PermissionService) fragment2.getContext(), aptoideAccountManager, appsNavigator);
        $jacocoInit[99] = true;
        return appsPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public SeeMoreAppcManager providesSeeMoreManager(UpdatesManager updatesManager, InstallManager installManager, AppMapper appMapper, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, DownloadFactory downloadFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        SeeMoreAppcManager seeMoreAppcManager = new SeeMoreAppcManager(updatesManager, installManager, appMapper, downloadFactory, downloadAnalytics, installAnalytics);
        $jacocoInit[100] = true;
        return seeMoreAppcManager;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public SeeMoreAppcPresenter providesSeeMoreAppcPresenter(SeeMoreAppcManager seeMoreAppcManager) {
        boolean[] $jacocoInit = $jacocoInit();
        SeeMoreAppcFragment seeMoreAppcFragment = (SeeMoreAppcFragment) this.fragment;
        $jacocoInit[101] = true;
        C0126V a = C14522a.m46170a();
        C0126V io = Schedulers.m776io();
        CrashReport instance = CrashReport.getInstance();
        PermissionManager permissionManager = new PermissionManager();
        Fragment fragment2 = this.fragment;
        $jacocoInit[102] = true;
        SeeMoreAppcPresenter seeMoreAppcPresenter = new SeeMoreAppcPresenter(seeMoreAppcFragment, a, io, instance, permissionManager, (PermissionService) fragment2.getContext(), seeMoreAppcManager);
        $jacocoInit[103] = true;
        return seeMoreAppcPresenter;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public AppcPromotionNotificationStringProvider providesAppcPromotionNotificationStringProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = this.fragment.getContext();
        $jacocoInit[104] = true;
        String string = context.getString(C1375R.string.promo_update2appc_claim_notification_title);
        Context context2 = this.fragment.getContext();
        $jacocoInit[105] = true;
        AppcPromotionNotificationStringProvider appcPromotionNotificationStringProvider = new AppcPromotionNotificationStringProvider(string, context2.getString(C1375R.string.promo_update2appc_claim_notification_body));
        $jacocoInit[106] = true;
        return appcPromotionNotificationStringProvider;
    }
}
