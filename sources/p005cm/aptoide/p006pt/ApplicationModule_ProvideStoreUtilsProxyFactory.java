package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideStoreUtilsProxyFactory */
public final class ApplicationModule_ProvideStoreUtilsProxyFactory implements C13181b<StoreUtilsProxy> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<StoreAccessor> storeAccessorProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4858603600613236167L, "cm/aptoide/pt/ApplicationModule_ProvideStoreUtilsProxyFactory", 13);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideStoreUtilsProxyFactory(ApplicationModule module2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<StoreAccessor> storeAccessorProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.accountManagerProvider = accountManagerProvider2;
        this.storeAccessorProvider = storeAccessorProvider2;
        this.httpClientProvider = httpClientProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.bodyInterceptorProvider = bodyInterceptorProvider2;
        $jacocoInit[0] = true;
    }

    public StoreUtilsProxy get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AptoideAccountManager> provider = this.accountManagerProvider;
        $jacocoInit[1] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider.get();
        Provider<StoreAccessor> provider2 = this.storeAccessorProvider;
        $jacocoInit[2] = true;
        StoreAccessor storeAccessor = (StoreAccessor) provider2.get();
        Provider<OkHttpClient> provider3 = this.httpClientProvider;
        $jacocoInit[3] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider3.get();
        Provider<SharedPreferences> provider4 = this.sharedPreferencesProvider;
        $jacocoInit[4] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider4.get();
        Provider<TokenInvalidator> provider5 = this.tokenInvalidatorProvider;
        $jacocoInit[5] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider5.get();
        Provider<BodyInterceptor<BaseBody>> provider6 = this.bodyInterceptorProvider;
        $jacocoInit[6] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider6.get();
        $jacocoInit[7] = true;
        StoreUtilsProxy provideStoreUtilsProxy = applicationModule.provideStoreUtilsProxy(aptoideAccountManager, storeAccessor, okHttpClient, sharedPreferences, tokenInvalidator, bodyInterceptor);
        $jacocoInit[8] = true;
        C13182c.m43111a(provideStoreUtilsProxy, "Cannot return null from a non-@Nullable @Provides method");
        StoreUtilsProxy storeUtilsProxy = provideStoreUtilsProxy;
        $jacocoInit[9] = true;
        return storeUtilsProxy;
    }

    public static C13181b<StoreUtilsProxy> create(ApplicationModule module2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<StoreAccessor> storeAccessorProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideStoreUtilsProxyFactory applicationModule_ProvideStoreUtilsProxyFactory = new ApplicationModule_ProvideStoreUtilsProxyFactory(module2, accountManagerProvider2, storeAccessorProvider2, httpClientProvider2, sharedPreferencesProvider2, tokenInvalidatorProvider2, bodyInterceptorProvider2);
        $jacocoInit[10] = true;
        return applicationModule_ProvideStoreUtilsProxyFactory;
    }

    public static StoreUtilsProxy proxyProvideStoreUtilsProxy(ApplicationModule instance, AptoideAccountManager accountManager, StoreAccessor storeAccessor, OkHttpClient httpClient, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, BodyInterceptor<BaseBody> bodyInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreUtilsProxy provideStoreUtilsProxy = instance.provideStoreUtilsProxy(accountManager, storeAccessor, httpClient, sharedPreferences, tokenInvalidator, bodyInterceptor);
        $jacocoInit[11] = true;
        return provideStoreUtilsProxy;
    }
}
