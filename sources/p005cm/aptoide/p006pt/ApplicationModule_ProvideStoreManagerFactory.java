package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.store.StoreManager;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.RequestBodyFactory;
import p005cm.aptoide.p006pt.networking.MultipartBodyInterceptor;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideStoreManagerFactory */
public final class ApplicationModule_ProvideStoreManagerFactory implements C13181b<StoreManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BodyInterceptor<BaseBody>> accountSettingsBodyInterceptorPoolV7Provider;
    private final Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider;
    private final Provider<SharedPreferences> defaultSharedPreferencesProvider;
    private final ApplicationModule module;
    private final Provider<MultipartBodyInterceptor> multipartBodyInterceptorProvider;
    private final Provider<ObjectMapper> nonNullObjectMapperProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<RequestBodyFactory> requestBodyFactoryProvider;
    private final Provider<StoreRepository> storeRepositoryProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5050668492005974143L, "cm/aptoide/pt/ApplicationModule_ProvideStoreManagerFactory", 16);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideStoreManagerFactory(ApplicationModule module2, Provider<OkHttpClient> okHttpClientProvider2, Provider<MultipartBodyInterceptor> multipartBodyInterceptorProvider2, Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider2, Provider<BodyInterceptor<BaseBody>> accountSettingsBodyInterceptorPoolV7Provider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<RequestBodyFactory> requestBodyFactoryProvider2, Provider<ObjectMapper> nonNullObjectMapperProvider2, Provider<StoreRepository> storeRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.multipartBodyInterceptorProvider = multipartBodyInterceptorProvider2;
        this.bodyInterceptorV3Provider = bodyInterceptorV3Provider2;
        this.accountSettingsBodyInterceptorPoolV7Provider = accountSettingsBodyInterceptorPoolV7Provider2;
        this.defaultSharedPreferencesProvider = defaultSharedPreferencesProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.requestBodyFactoryProvider = requestBodyFactoryProvider2;
        this.nonNullObjectMapperProvider = nonNullObjectMapperProvider2;
        this.storeRepositoryProvider = storeRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public StoreManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<OkHttpClient> provider = this.okHttpClientProvider;
        $jacocoInit[1] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider.get();
        Provider<MultipartBodyInterceptor> provider2 = this.multipartBodyInterceptorProvider;
        $jacocoInit[2] = true;
        MultipartBodyInterceptor multipartBodyInterceptor = (MultipartBodyInterceptor) provider2.get();
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider3 = this.bodyInterceptorV3Provider;
        $jacocoInit[3] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider3.get();
        Provider<BodyInterceptor<BaseBody>> provider4 = this.accountSettingsBodyInterceptorPoolV7Provider;
        $jacocoInit[4] = true;
        BodyInterceptor bodyInterceptor2 = (BodyInterceptor) provider4.get();
        Provider<SharedPreferences> provider5 = this.defaultSharedPreferencesProvider;
        $jacocoInit[5] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider5.get();
        Provider<TokenInvalidator> provider6 = this.tokenInvalidatorProvider;
        $jacocoInit[6] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider6.get();
        Provider<RequestBodyFactory> provider7 = this.requestBodyFactoryProvider;
        $jacocoInit[7] = true;
        RequestBodyFactory requestBodyFactory = (RequestBodyFactory) provider7.get();
        Provider<ObjectMapper> provider8 = this.nonNullObjectMapperProvider;
        $jacocoInit[8] = true;
        ObjectMapper objectMapper = (ObjectMapper) provider8.get();
        Provider<StoreRepository> provider9 = this.storeRepositoryProvider;
        $jacocoInit[9] = true;
        StoreRepository storeRepository = (StoreRepository) provider9.get();
        $jacocoInit[10] = true;
        StoreManager provideStoreManager = applicationModule.provideStoreManager(okHttpClient, multipartBodyInterceptor, bodyInterceptor, bodyInterceptor2, sharedPreferences, tokenInvalidator, requestBodyFactory, objectMapper, storeRepository);
        $jacocoInit[11] = true;
        C13182c.m43111a(provideStoreManager, "Cannot return null from a non-@Nullable @Provides method");
        StoreManager storeManager = provideStoreManager;
        $jacocoInit[12] = true;
        return storeManager;
    }

    public static C13181b<StoreManager> create(ApplicationModule module2, Provider<OkHttpClient> okHttpClientProvider2, Provider<MultipartBodyInterceptor> multipartBodyInterceptorProvider2, Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider2, Provider<BodyInterceptor<BaseBody>> accountSettingsBodyInterceptorPoolV7Provider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<RequestBodyFactory> requestBodyFactoryProvider2, Provider<ObjectMapper> nonNullObjectMapperProvider2, Provider<StoreRepository> storeRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideStoreManagerFactory applicationModule_ProvideStoreManagerFactory = new ApplicationModule_ProvideStoreManagerFactory(module2, okHttpClientProvider2, multipartBodyInterceptorProvider2, bodyInterceptorV3Provider2, accountSettingsBodyInterceptorPoolV7Provider2, defaultSharedPreferencesProvider2, tokenInvalidatorProvider2, requestBodyFactoryProvider2, nonNullObjectMapperProvider2, storeRepositoryProvider2);
        $jacocoInit[13] = true;
        return applicationModule_ProvideStoreManagerFactory;
    }

    public static StoreManager proxyProvideStoreManager(ApplicationModule instance, OkHttpClient okHttpClient, MultipartBodyInterceptor multipartBodyInterceptor, BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptorV3, BodyInterceptor<BaseBody> accountSettingsBodyInterceptorPoolV7, SharedPreferences defaultSharedPreferences, TokenInvalidator tokenInvalidator, RequestBodyFactory requestBodyFactory, ObjectMapper nonNullObjectMapper, StoreRepository storeRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreManager provideStoreManager = instance.provideStoreManager(okHttpClient, multipartBodyInterceptor, bodyInterceptorV3, accountSettingsBodyInterceptorPoolV7, defaultSharedPreferences, tokenInvalidator, requestBodyFactory, nonNullObjectMapper, storeRepository);
        $jacocoInit[14] = true;
        return provideStoreManager;
    }
}
