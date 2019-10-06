package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.search.suggestions.TrendingService;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesTrendingServiceFactory */
public final class ApplicationModule_ProvidesTrendingServiceFactory implements C13181b<TrendingService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider;
    private final Provider<Factory> converterFactoryProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<StoreCredentialsProvider> storeCredentialsProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6416307684254670111L, "cm/aptoide/pt/ApplicationModule_ProvidesTrendingServiceFactory", 13);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesTrendingServiceFactory(ApplicationModule module2, Provider<StoreCredentialsProvider> storeCredentialsProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<Factory> converterFactoryProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        this.httpClientProvider = httpClientProvider2;
        this.bodyInterceptorProvider = bodyInterceptorProvider2;
        $jacocoInit[0] = true;
    }

    public TrendingService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<StoreCredentialsProvider> provider = this.storeCredentialsProvider;
        $jacocoInit[1] = true;
        StoreCredentialsProvider storeCredentialsProvider2 = (StoreCredentialsProvider) provider.get();
        Provider<SharedPreferences> provider2 = this.sharedPreferencesProvider;
        $jacocoInit[2] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider2.get();
        Provider<TokenInvalidator> provider3 = this.tokenInvalidatorProvider;
        $jacocoInit[3] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider3.get();
        Provider<Factory> provider4 = this.converterFactoryProvider;
        $jacocoInit[4] = true;
        Factory factory = (Factory) provider4.get();
        Provider<OkHttpClient> provider5 = this.httpClientProvider;
        $jacocoInit[5] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider5.get();
        Provider<BodyInterceptor<BaseBody>> provider6 = this.bodyInterceptorProvider;
        $jacocoInit[6] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider6.get();
        $jacocoInit[7] = true;
        TrendingService providesTrendingService = applicationModule.providesTrendingService(storeCredentialsProvider2, sharedPreferences, tokenInvalidator, factory, okHttpClient, bodyInterceptor);
        $jacocoInit[8] = true;
        C13182c.m43111a(providesTrendingService, "Cannot return null from a non-@Nullable @Provides method");
        TrendingService trendingService = providesTrendingService;
        $jacocoInit[9] = true;
        return trendingService;
    }

    public static C13181b<TrendingService> create(ApplicationModule module2, Provider<StoreCredentialsProvider> storeCredentialsProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<Factory> converterFactoryProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesTrendingServiceFactory applicationModule_ProvidesTrendingServiceFactory = new ApplicationModule_ProvidesTrendingServiceFactory(module2, storeCredentialsProvider2, sharedPreferencesProvider2, tokenInvalidatorProvider2, converterFactoryProvider2, httpClientProvider2, bodyInterceptorProvider2);
        $jacocoInit[10] = true;
        return applicationModule_ProvidesTrendingServiceFactory;
    }

    public static TrendingService proxyProvidesTrendingService(ApplicationModule instance, StoreCredentialsProvider storeCredentialsProvider2, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, Factory converterFactory, OkHttpClient httpClient, BodyInterceptor<BaseBody> bodyInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        TrendingService providesTrendingService = instance.providesTrendingService(storeCredentialsProvider2, sharedPreferences, tokenInvalidator, converterFactory, httpClient, bodyInterceptor);
        $jacocoInit[11] = true;
        return providesTrendingService;
    }
}
