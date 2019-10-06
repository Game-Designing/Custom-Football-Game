package p005cm.aptoide.p006pt.view;

import com.facebook.C6666i;
import com.google.android.gms.common.api.GoogleApiClient;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideAccountNavigatorFactory */
public final class ActivityModule_ProvideAccountNavigatorFactory implements C13181b<AccountNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider;
    private final Provider<C6666i> callbackManagerProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final Provider<GoogleApiClient> googleApiClientProvider;
    private final ActivityModule module;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-363569702640561046L, "cm/aptoide/pt/view/ActivityModule_ProvideAccountNavigatorFactory", 14);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideAccountNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<C6666i> callbackManagerProvider2, Provider<GoogleApiClient> googleApiClientProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.callbackManagerProvider = callbackManagerProvider2;
        this.googleApiClientProvider = googleApiClientProvider2;
        this.accountAnalyticsProvider = accountAnalyticsProvider2;
        this.bottomNavigationNavigatorProvider = bottomNavigationNavigatorProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public AccountNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider.get();
        Provider<AptoideAccountManager> provider2 = this.accountManagerProvider;
        $jacocoInit[2] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider2.get();
        Provider<C6666i> provider3 = this.callbackManagerProvider;
        $jacocoInit[3] = true;
        C6666i iVar = (C6666i) provider3.get();
        Provider<GoogleApiClient> provider4 = this.googleApiClientProvider;
        $jacocoInit[4] = true;
        GoogleApiClient googleApiClient = (GoogleApiClient) provider4.get();
        Provider<AccountAnalytics> provider5 = this.accountAnalyticsProvider;
        $jacocoInit[5] = true;
        AccountAnalytics accountAnalytics = (AccountAnalytics) provider5.get();
        Provider<BottomNavigationNavigator> provider6 = this.bottomNavigationNavigatorProvider;
        $jacocoInit[6] = true;
        BottomNavigationNavigator bottomNavigationNavigator = (BottomNavigationNavigator) provider6.get();
        Provider<String> provider7 = this.themeProvider;
        $jacocoInit[7] = true;
        String str = (String) provider7.get();
        $jacocoInit[8] = true;
        AccountNavigator provideAccountNavigator = activityModule.provideAccountNavigator(fragmentNavigator, aptoideAccountManager, iVar, googleApiClient, accountAnalytics, bottomNavigationNavigator, str);
        $jacocoInit[9] = true;
        C13182c.m43111a(provideAccountNavigator, "Cannot return null from a non-@Nullable @Provides method");
        AccountNavigator accountNavigator = provideAccountNavigator;
        $jacocoInit[10] = true;
        return accountNavigator;
    }

    public static C13181b<AccountNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<C6666i> callbackManagerProvider2, Provider<GoogleApiClient> googleApiClientProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideAccountNavigatorFactory activityModule_ProvideAccountNavigatorFactory = new ActivityModule_ProvideAccountNavigatorFactory(module2, fragmentNavigatorProvider2, accountManagerProvider2, callbackManagerProvider2, googleApiClientProvider2, accountAnalyticsProvider2, bottomNavigationNavigatorProvider2, themeProvider2);
        $jacocoInit[11] = true;
        return activityModule_ProvideAccountNavigatorFactory;
    }

    public static AccountNavigator proxyProvideAccountNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator, AptoideAccountManager accountManager, C6666i callbackManager, GoogleApiClient googleApiClient, AccountAnalytics accountAnalytics, BottomNavigationNavigator bottomNavigationNavigator, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountNavigator provideAccountNavigator = instance.provideAccountNavigator(fragmentNavigator, accountManager, callbackManager, googleApiClient, accountAnalytics, bottomNavigationNavigator, theme);
        $jacocoInit[12] = true;
        return provideAccountNavigator;
    }
}
