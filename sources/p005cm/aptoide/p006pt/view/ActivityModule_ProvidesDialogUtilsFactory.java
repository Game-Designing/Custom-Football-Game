package p005cm.aptoide.p006pt.view;

import android.content.SharedPreferences;
import android.content.res.Resources;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.view.dialog.DialogUtils;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesDialogUtilsFactory */
public final class ActivityModule_ProvidesDialogUtilsFactory implements C13181b<DialogUtils> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider;
    private final Provider<Factory> converterFactoryProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final Provider<InstalledRepository> installedRepositoryProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<MarketResourceFormatter> marketResourceFormatterProvider;
    private final ActivityModule module;
    private final Provider<Resources> resourcesProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2441150539592624503L, "cm/aptoide/pt/view/ActivityModule_ProvidesDialogUtilsFactory", 18);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesDialogUtilsFactory(ActivityModule module2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Resources> resourcesProvider2, Provider<String> marketNameProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.accountManagerProvider = accountManagerProvider2;
        this.accountNavigatorProvider = accountNavigatorProvider2;
        this.bodyInterceptorProvider = bodyInterceptorProvider2;
        this.httpClientProvider = httpClientProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        this.installedRepositoryProvider = installedRepositoryProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.resourcesProvider = resourcesProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.marketResourceFormatterProvider = marketResourceFormatterProvider2;
        $jacocoInit[0] = true;
    }

    public DialogUtils get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<AptoideAccountManager> provider = this.accountManagerProvider;
        $jacocoInit[1] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider.get();
        Provider<AccountNavigator> provider2 = this.accountNavigatorProvider;
        $jacocoInit[2] = true;
        AccountNavigator accountNavigator = (AccountNavigator) provider2.get();
        Provider<BodyInterceptor<BaseBody>> provider3 = this.bodyInterceptorProvider;
        $jacocoInit[3] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider3.get();
        Provider<OkHttpClient> provider4 = this.httpClientProvider;
        $jacocoInit[4] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider4.get();
        Provider<Factory> provider5 = this.converterFactoryProvider;
        $jacocoInit[5] = true;
        Factory factory = (Factory) provider5.get();
        Provider<InstalledRepository> provider6 = this.installedRepositoryProvider;
        $jacocoInit[6] = true;
        InstalledRepository installedRepository = (InstalledRepository) provider6.get();
        Provider<TokenInvalidator> provider7 = this.tokenInvalidatorProvider;
        $jacocoInit[7] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider7.get();
        Provider<SharedPreferences> provider8 = this.sharedPreferencesProvider;
        $jacocoInit[8] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider8.get();
        Provider<Resources> provider9 = this.resourcesProvider;
        $jacocoInit[9] = true;
        Resources resources = (Resources) provider9.get();
        Provider<String> provider10 = this.marketNameProvider;
        $jacocoInit[10] = true;
        String str = (String) provider10.get();
        Provider<MarketResourceFormatter> provider11 = this.marketResourceFormatterProvider;
        $jacocoInit[11] = true;
        MarketResourceFormatter marketResourceFormatter = (MarketResourceFormatter) provider11.get();
        $jacocoInit[12] = true;
        DialogUtils providesDialogUtils = activityModule.providesDialogUtils(aptoideAccountManager, accountNavigator, bodyInterceptor, okHttpClient, factory, installedRepository, tokenInvalidator, sharedPreferences, resources, str, marketResourceFormatter);
        $jacocoInit[13] = true;
        C13182c.m43111a(providesDialogUtils, "Cannot return null from a non-@Nullable @Provides method");
        DialogUtils dialogUtils = providesDialogUtils;
        $jacocoInit[14] = true;
        return dialogUtils;
    }

    public static C13181b<DialogUtils> create(ActivityModule module2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Resources> resourcesProvider2, Provider<String> marketNameProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesDialogUtilsFactory activityModule_ProvidesDialogUtilsFactory = new ActivityModule_ProvidesDialogUtilsFactory(module2, accountManagerProvider2, accountNavigatorProvider2, bodyInterceptorProvider2, httpClientProvider2, converterFactoryProvider2, installedRepositoryProvider2, tokenInvalidatorProvider2, sharedPreferencesProvider2, resourcesProvider2, marketNameProvider2, marketResourceFormatterProvider2);
        $jacocoInit[15] = true;
        return activityModule_ProvidesDialogUtilsFactory;
    }

    public static DialogUtils proxyProvidesDialogUtils(ActivityModule instance, AptoideAccountManager accountManager, AccountNavigator accountNavigator, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, InstalledRepository installedRepository, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, String marketName, MarketResourceFormatter marketResourceFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        DialogUtils providesDialogUtils = instance.providesDialogUtils(accountManager, accountNavigator, bodyInterceptor, httpClient, converterFactory, installedRepository, tokenInvalidator, sharedPreferences, resources, marketName, marketResourceFormatter);
        $jacocoInit[16] = true;
        return providesDialogUtils;
    }
}
