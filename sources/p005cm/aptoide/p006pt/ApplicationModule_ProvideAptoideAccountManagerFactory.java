package p005cm.aptoide.p006pt;

import android.accounts.AccountManager;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.GoogleApiClient;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountFactory;
import p005cm.aptoide.accountmanager.AccountService;
import p005cm.aptoide.accountmanager.AdultContent;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.AndroidAccountProvider;
import p005cm.aptoide.p006pt.account.LoginPreferences;
import p005cm.aptoide.p006pt.account.view.store.StoreManager;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAptoideAccountManagerFactory */
public final class ApplicationModule_ProvideAptoideAccountManagerFactory implements C13181b<AptoideAccountManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountFactory> accountFactoryProvider;
    private final Provider<AccountManager> accountManagerProvider;
    private final Provider<AccountService> accountServiceProvider;
    private final Provider<AdultContent> adultContentProvider;
    private final Provider<AndroidAccountProvider> androidAccountProvider;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<SharedPreferences> defaultSharedPreferencesProvider;
    private final Provider<GoogleApiClient> googleApiClientProvider;
    private final Provider<LoginPreferences> loginPreferencesProvider;
    private final ApplicationModule module;
    private final Provider<StoreAccessor> storeAccessorProvider;
    private final Provider<StoreManager> storeManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7989543786717025145L, "cm/aptoide/pt/ApplicationModule_ProvideAptoideAccountManagerFactory", 18);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAptoideAccountManagerFactory(ApplicationModule module2, Provider<AdultContent> adultContentProvider2, Provider<StoreAccessor> storeAccessorProvider2, Provider<AccountManager> accountManagerProvider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<AndroidAccountProvider> androidAccountProvider2, Provider<GoogleApiClient> googleApiClientProvider2, Provider<StoreManager> storeManagerProvider2, Provider<AccountService> accountServiceProvider2, Provider<AccountFactory> accountFactoryProvider2, Provider<LoginPreferences> loginPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.adultContentProvider = adultContentProvider2;
        this.storeAccessorProvider = storeAccessorProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.defaultSharedPreferencesProvider = defaultSharedPreferencesProvider2;
        this.authenticationPersistenceProvider = authenticationPersistenceProvider2;
        this.androidAccountProvider = androidAccountProvider2;
        this.googleApiClientProvider = googleApiClientProvider2;
        this.storeManagerProvider = storeManagerProvider2;
        this.accountServiceProvider = accountServiceProvider2;
        this.accountFactoryProvider = accountFactoryProvider2;
        this.loginPreferencesProvider = loginPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public AptoideAccountManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AdultContent> provider = this.adultContentProvider;
        $jacocoInit[1] = true;
        AdultContent adultContent = (AdultContent) provider.get();
        Provider<StoreAccessor> provider2 = this.storeAccessorProvider;
        $jacocoInit[2] = true;
        StoreAccessor storeAccessor = (StoreAccessor) provider2.get();
        Provider<AccountManager> provider3 = this.accountManagerProvider;
        $jacocoInit[3] = true;
        AccountManager accountManager = (AccountManager) provider3.get();
        Provider<SharedPreferences> provider4 = this.defaultSharedPreferencesProvider;
        $jacocoInit[4] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider4.get();
        Provider<AuthenticationPersistence> provider5 = this.authenticationPersistenceProvider;
        $jacocoInit[5] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider5.get();
        Provider<AndroidAccountProvider> provider6 = this.androidAccountProvider;
        $jacocoInit[6] = true;
        AndroidAccountProvider androidAccountProvider2 = (AndroidAccountProvider) provider6.get();
        Provider<GoogleApiClient> provider7 = this.googleApiClientProvider;
        $jacocoInit[7] = true;
        GoogleApiClient googleApiClient = (GoogleApiClient) provider7.get();
        Provider<StoreManager> provider8 = this.storeManagerProvider;
        $jacocoInit[8] = true;
        StoreManager storeManager = (StoreManager) provider8.get();
        Provider<AccountService> provider9 = this.accountServiceProvider;
        $jacocoInit[9] = true;
        AccountService accountService = (AccountService) provider9.get();
        Provider<AccountFactory> provider10 = this.accountFactoryProvider;
        $jacocoInit[10] = true;
        AccountFactory accountFactory = (AccountFactory) provider10.get();
        Provider<LoginPreferences> provider11 = this.loginPreferencesProvider;
        $jacocoInit[11] = true;
        LoginPreferences loginPreferences = (LoginPreferences) provider11.get();
        $jacocoInit[12] = true;
        AptoideAccountManager provideAptoideAccountManager = applicationModule.provideAptoideAccountManager(adultContent, storeAccessor, accountManager, sharedPreferences, authenticationPersistence, androidAccountProvider2, googleApiClient, storeManager, accountService, accountFactory, loginPreferences);
        $jacocoInit[13] = true;
        C13182c.m43111a(provideAptoideAccountManager, "Cannot return null from a non-@Nullable @Provides method");
        AptoideAccountManager aptoideAccountManager = provideAptoideAccountManager;
        $jacocoInit[14] = true;
        return aptoideAccountManager;
    }

    public static C13181b<AptoideAccountManager> create(ApplicationModule module2, Provider<AdultContent> adultContentProvider2, Provider<StoreAccessor> storeAccessorProvider2, Provider<AccountManager> accountManagerProvider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<AndroidAccountProvider> androidAccountProvider2, Provider<GoogleApiClient> googleApiClientProvider2, Provider<StoreManager> storeManagerProvider2, Provider<AccountService> accountServiceProvider2, Provider<AccountFactory> accountFactoryProvider2, Provider<LoginPreferences> loginPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAptoideAccountManagerFactory applicationModule_ProvideAptoideAccountManagerFactory = new ApplicationModule_ProvideAptoideAccountManagerFactory(module2, adultContentProvider2, storeAccessorProvider2, accountManagerProvider2, defaultSharedPreferencesProvider2, authenticationPersistenceProvider2, androidAccountProvider2, googleApiClientProvider2, storeManagerProvider2, accountServiceProvider2, accountFactoryProvider2, loginPreferencesProvider2);
        $jacocoInit[15] = true;
        return applicationModule_ProvideAptoideAccountManagerFactory;
    }

    public static AptoideAccountManager proxyProvideAptoideAccountManager(ApplicationModule instance, AdultContent adultContent, StoreAccessor storeAccessor, AccountManager accountManager, SharedPreferences defaultSharedPreferences, AuthenticationPersistence authenticationPersistence, AndroidAccountProvider androidAccountProvider2, GoogleApiClient googleApiClient, StoreManager storeManager, AccountService accountService, AccountFactory accountFactory, LoginPreferences loginPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideAccountManager provideAptoideAccountManager = instance.provideAptoideAccountManager(adultContent, storeAccessor, accountManager, defaultSharedPreferences, authenticationPersistence, androidAccountProvider2, googleApiClient, storeManager, accountService, accountFactory, loginPreferences);
        $jacocoInit[16] = true;
        return provideAptoideAccountManager;
    }
}
