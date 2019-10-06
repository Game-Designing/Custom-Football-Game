package p005cm.aptoide.p006pt.view;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateManager;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.home.apps.UpdatesManager;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.installer.RootInstallationRetryHandler;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenManager;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenNavigator;
import p005cm.aptoide.p006pt.util.ApkFy;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideMainPresenterFactory */
public final class ActivityModule_ProvideMainPresenterFactory implements C13181b<Presenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ApkFy> apkFyProvider;
    private final Provider<AutoUpdateManager> autoUpdateManagerProvider;
    private final Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider;
    private final Provider<DeepLinkManager> deepLinkManagerProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final ActivityModule module;
    private final Provider<RootInstallationRetryHandler> rootInstallationRetryHandlerProvider;
    private final Provider<SharedPreferences> secureSharedPreferencesProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<SplashScreenManager> splashScreenManagerProvider;
    private final Provider<SplashScreenNavigator> splashScreenNavigatorProvider;
    private final Provider<UpdatesManager> updatesManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4210193559283714220L, "cm/aptoide/pt/view/ActivityModule_ProvideMainPresenterFactory", 19);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideMainPresenterFactory(ActivityModule module2, Provider<RootInstallationRetryHandler> rootInstallationRetryHandlerProvider2, Provider<ApkFy> apkFyProvider2, Provider<InstallManager> installManagerProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<SharedPreferences> secureSharedPreferencesProvider2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<DeepLinkManager> deepLinkManagerProvider2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2, Provider<UpdatesManager> updatesManagerProvider2, Provider<AutoUpdateManager> autoUpdateManagerProvider2, Provider<SplashScreenManager> splashScreenManagerProvider2, Provider<SplashScreenNavigator> splashScreenNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.rootInstallationRetryHandlerProvider = rootInstallationRetryHandlerProvider2;
        this.apkFyProvider = apkFyProvider2;
        this.installManagerProvider = installManagerProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.secureSharedPreferencesProvider = secureSharedPreferencesProvider2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.deepLinkManagerProvider = deepLinkManagerProvider2;
        this.bottomNavigationNavigatorProvider = bottomNavigationNavigatorProvider2;
        this.updatesManagerProvider = updatesManagerProvider2;
        this.autoUpdateManagerProvider = autoUpdateManagerProvider2;
        this.splashScreenManagerProvider = splashScreenManagerProvider2;
        this.splashScreenNavigatorProvider = splashScreenNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public Presenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<RootInstallationRetryHandler> provider = this.rootInstallationRetryHandlerProvider;
        $jacocoInit[1] = true;
        RootInstallationRetryHandler rootInstallationRetryHandler = (RootInstallationRetryHandler) provider.get();
        Provider<ApkFy> provider2 = this.apkFyProvider;
        $jacocoInit[2] = true;
        ApkFy apkFy = (ApkFy) provider2.get();
        Provider<InstallManager> provider3 = this.installManagerProvider;
        $jacocoInit[3] = true;
        InstallManager installManager = (InstallManager) provider3.get();
        Provider<SharedPreferences> provider4 = this.sharedPreferencesProvider;
        $jacocoInit[4] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider4.get();
        Provider<SharedPreferences> provider5 = this.secureSharedPreferencesProvider;
        $jacocoInit[5] = true;
        SharedPreferences sharedPreferences2 = (SharedPreferences) provider5.get();
        Provider<FragmentNavigator> provider6 = this.fragmentNavigatorProvider;
        $jacocoInit[6] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider6.get();
        Provider<DeepLinkManager> provider7 = this.deepLinkManagerProvider;
        $jacocoInit[7] = true;
        DeepLinkManager deepLinkManager = (DeepLinkManager) provider7.get();
        Provider<BottomNavigationNavigator> provider8 = this.bottomNavigationNavigatorProvider;
        $jacocoInit[8] = true;
        BottomNavigationNavigator bottomNavigationNavigator = (BottomNavigationNavigator) provider8.get();
        Provider<UpdatesManager> provider9 = this.updatesManagerProvider;
        $jacocoInit[9] = true;
        UpdatesManager updatesManager = (UpdatesManager) provider9.get();
        Provider<AutoUpdateManager> provider10 = this.autoUpdateManagerProvider;
        $jacocoInit[10] = true;
        AutoUpdateManager autoUpdateManager = (AutoUpdateManager) provider10.get();
        Provider<SplashScreenManager> provider11 = this.splashScreenManagerProvider;
        $jacocoInit[11] = true;
        SplashScreenManager splashScreenManager = (SplashScreenManager) provider11.get();
        Provider<SplashScreenNavigator> provider12 = this.splashScreenNavigatorProvider;
        $jacocoInit[12] = true;
        SplashScreenNavigator splashScreenNavigator = (SplashScreenNavigator) provider12.get();
        $jacocoInit[13] = true;
        Presenter provideMainPresenter = activityModule.provideMainPresenter(rootInstallationRetryHandler, apkFy, installManager, sharedPreferences, sharedPreferences2, fragmentNavigator, deepLinkManager, bottomNavigationNavigator, updatesManager, autoUpdateManager, splashScreenManager, splashScreenNavigator);
        $jacocoInit[14] = true;
        C13182c.m43111a(provideMainPresenter, "Cannot return null from a non-@Nullable @Provides method");
        Presenter presenter = provideMainPresenter;
        $jacocoInit[15] = true;
        return presenter;
    }

    public static C13181b<Presenter> create(ActivityModule module2, Provider<RootInstallationRetryHandler> rootInstallationRetryHandlerProvider2, Provider<ApkFy> apkFyProvider2, Provider<InstallManager> installManagerProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<SharedPreferences> secureSharedPreferencesProvider2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<DeepLinkManager> deepLinkManagerProvider2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2, Provider<UpdatesManager> updatesManagerProvider2, Provider<AutoUpdateManager> autoUpdateManagerProvider2, Provider<SplashScreenManager> splashScreenManagerProvider2, Provider<SplashScreenNavigator> splashScreenNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideMainPresenterFactory activityModule_ProvideMainPresenterFactory = new ActivityModule_ProvideMainPresenterFactory(module2, rootInstallationRetryHandlerProvider2, apkFyProvider2, installManagerProvider2, sharedPreferencesProvider2, secureSharedPreferencesProvider2, fragmentNavigatorProvider2, deepLinkManagerProvider2, bottomNavigationNavigatorProvider2, updatesManagerProvider2, autoUpdateManagerProvider2, splashScreenManagerProvider2, splashScreenNavigatorProvider2);
        $jacocoInit[16] = true;
        return activityModule_ProvideMainPresenterFactory;
    }

    public static Presenter proxyProvideMainPresenter(ActivityModule instance, RootInstallationRetryHandler rootInstallationRetryHandler, ApkFy apkFy, InstallManager installManager, SharedPreferences sharedPreferences, SharedPreferences secureSharedPreferences, FragmentNavigator fragmentNavigator, DeepLinkManager deepLinkManager, BottomNavigationNavigator bottomNavigationNavigator, UpdatesManager updatesManager, AutoUpdateManager autoUpdateManager, SplashScreenManager splashScreenManager, SplashScreenNavigator splashScreenNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        Presenter provideMainPresenter = instance.provideMainPresenter(rootInstallationRetryHandler, apkFy, installManager, sharedPreferences, secureSharedPreferences, fragmentNavigator, deepLinkManager, bottomNavigationNavigator, updatesManager, autoUpdateManager, splashScreenManager, splashScreenNavigator);
        $jacocoInit[17] = true;
        return provideMainPresenter;
    }
}
