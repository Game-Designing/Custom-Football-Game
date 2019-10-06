package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountFactory;
import p005cm.aptoide.accountmanager.AccountService;
import p005cm.aptoide.p006pt.account.OAuthModeProvider;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.MultipartBodyInterceptor;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAccountServiceFactory */
public final class ApplicationModule_ProvideAccountServiceFactory implements C13181b<AccountService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountFactory> accountFactoryProvider;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorWebV7Provider;
    private final Provider<Factory> converterFactoryProvider;
    private final Provider<SharedPreferences> defaultSharedPreferencesProvider;
    private final Provider<String> extraIdProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final Provider<OkHttpClient> longTimeoutHttpClientProvider;
    private final ApplicationModule module;
    private final Provider<MultipartBodyInterceptor> multipartBodyInterceptorProvider;
    private final Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> noAuthenticationBodyInterceptorV3Provider;
    private final Provider<OAuthModeProvider> oAuthModeProvider;
    private final Provider<ObjectMapper> objectMapperProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7973913178641539044L, "cm/aptoide/pt/ApplicationModule_ProvideAccountServiceFactory", 22);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAccountServiceFactory(ApplicationModule module2, Provider<OkHttpClient> httpClientProvider2, Provider<OkHttpClient> longTimeoutHttpClientProvider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorWebV7Provider2, Provider<MultipartBodyInterceptor> multipartBodyInterceptorProvider2, Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> noAuthenticationBodyInterceptorV3Provider2, Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider2, Provider<ObjectMapper> objectMapperProvider2, Provider<Factory> converterFactoryProvider2, Provider<String> extraIdProvider2, Provider<AccountFactory> accountFactoryProvider2, Provider<OAuthModeProvider> oAuthModeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.httpClientProvider = httpClientProvider2;
        this.longTimeoutHttpClientProvider = longTimeoutHttpClientProvider2;
        this.defaultSharedPreferencesProvider = defaultSharedPreferencesProvider2;
        this.authenticationPersistenceProvider = authenticationPersistenceProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.bodyInterceptorPoolV7Provider = bodyInterceptorPoolV7Provider2;
        this.bodyInterceptorWebV7Provider = bodyInterceptorWebV7Provider2;
        this.multipartBodyInterceptorProvider = multipartBodyInterceptorProvider2;
        this.noAuthenticationBodyInterceptorV3Provider = noAuthenticationBodyInterceptorV3Provider2;
        this.bodyInterceptorV3Provider = bodyInterceptorV3Provider2;
        this.objectMapperProvider = objectMapperProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        this.extraIdProvider = extraIdProvider2;
        this.accountFactoryProvider = accountFactoryProvider2;
        this.oAuthModeProvider = oAuthModeProvider2;
        $jacocoInit[0] = true;
    }

    public AccountService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<OkHttpClient> provider = this.httpClientProvider;
        $jacocoInit[1] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider.get();
        Provider<OkHttpClient> provider2 = this.longTimeoutHttpClientProvider;
        $jacocoInit[2] = true;
        OkHttpClient okHttpClient2 = (OkHttpClient) provider2.get();
        Provider<SharedPreferences> provider3 = this.defaultSharedPreferencesProvider;
        $jacocoInit[3] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider3.get();
        Provider<AuthenticationPersistence> provider4 = this.authenticationPersistenceProvider;
        $jacocoInit[4] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider4.get();
        Provider<TokenInvalidator> provider5 = this.tokenInvalidatorProvider;
        $jacocoInit[5] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider5.get();
        Provider<BodyInterceptor<BaseBody>> provider6 = this.bodyInterceptorPoolV7Provider;
        $jacocoInit[6] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider6.get();
        Provider<BodyInterceptor<BaseBody>> provider7 = this.bodyInterceptorWebV7Provider;
        $jacocoInit[7] = true;
        BodyInterceptor bodyInterceptor2 = (BodyInterceptor) provider7.get();
        Provider<MultipartBodyInterceptor> provider8 = this.multipartBodyInterceptorProvider;
        $jacocoInit[8] = true;
        MultipartBodyInterceptor multipartBodyInterceptor = (MultipartBodyInterceptor) provider8.get();
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider9 = this.noAuthenticationBodyInterceptorV3Provider;
        $jacocoInit[9] = true;
        BodyInterceptor bodyInterceptor3 = (BodyInterceptor) provider9.get();
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider10 = this.bodyInterceptorV3Provider;
        $jacocoInit[10] = true;
        BodyInterceptor bodyInterceptor4 = (BodyInterceptor) provider10.get();
        Provider<ObjectMapper> provider11 = this.objectMapperProvider;
        $jacocoInit[11] = true;
        ObjectMapper objectMapper = (ObjectMapper) provider11.get();
        Provider<Factory> provider12 = this.converterFactoryProvider;
        $jacocoInit[12] = true;
        Factory factory = (Factory) provider12.get();
        Provider<String> provider13 = this.extraIdProvider;
        $jacocoInit[13] = true;
        String str = (String) provider13.get();
        Provider<AccountFactory> provider14 = this.accountFactoryProvider;
        $jacocoInit[14] = true;
        AccountFactory accountFactory = (AccountFactory) provider14.get();
        Provider<OAuthModeProvider> provider15 = this.oAuthModeProvider;
        $jacocoInit[15] = true;
        OAuthModeProvider oAuthModeProvider2 = (OAuthModeProvider) provider15.get();
        $jacocoInit[16] = true;
        AccountService provideAccountService = applicationModule.provideAccountService(okHttpClient, okHttpClient2, sharedPreferences, authenticationPersistence, tokenInvalidator, bodyInterceptor, bodyInterceptor2, multipartBodyInterceptor, bodyInterceptor3, bodyInterceptor4, objectMapper, factory, str, accountFactory, oAuthModeProvider2);
        $jacocoInit[17] = true;
        C13182c.m43111a(provideAccountService, "Cannot return null from a non-@Nullable @Provides method");
        AccountService accountService = provideAccountService;
        $jacocoInit[18] = true;
        return accountService;
    }

    public static C13181b<AccountService> create(ApplicationModule module2, Provider<OkHttpClient> httpClientProvider2, Provider<OkHttpClient> longTimeoutHttpClientProvider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorWebV7Provider2, Provider<MultipartBodyInterceptor> multipartBodyInterceptorProvider2, Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> noAuthenticationBodyInterceptorV3Provider2, Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider2, Provider<ObjectMapper> objectMapperProvider2, Provider<Factory> converterFactoryProvider2, Provider<String> extraIdProvider2, Provider<AccountFactory> accountFactoryProvider2, Provider<OAuthModeProvider> oAuthModeProvider2) {
        ApplicationModule applicationModule = module2;
        Provider<OkHttpClient> provider = httpClientProvider2;
        Provider<OkHttpClient> provider2 = longTimeoutHttpClientProvider2;
        Provider<SharedPreferences> provider3 = defaultSharedPreferencesProvider2;
        Provider<AuthenticationPersistence> provider4 = authenticationPersistenceProvider2;
        Provider<TokenInvalidator> provider5 = tokenInvalidatorProvider2;
        Provider<BodyInterceptor<BaseBody>> provider6 = bodyInterceptorPoolV7Provider2;
        Provider<BodyInterceptor<BaseBody>> provider7 = bodyInterceptorWebV7Provider2;
        Provider<MultipartBodyInterceptor> provider8 = multipartBodyInterceptorProvider2;
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider9 = noAuthenticationBodyInterceptorV3Provider2;
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider10 = bodyInterceptorV3Provider2;
        Provider<ObjectMapper> provider11 = objectMapperProvider2;
        Provider<Factory> provider12 = converterFactoryProvider2;
        Provider<String> provider13 = extraIdProvider2;
        Provider<AccountFactory> provider14 = accountFactoryProvider2;
        Provider<OAuthModeProvider> provider15 = oAuthModeProvider2;
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAccountServiceFactory applicationModule_ProvideAccountServiceFactory = new ApplicationModule_ProvideAccountServiceFactory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
        $jacocoInit[19] = true;
        return applicationModule_ProvideAccountServiceFactory;
    }

    public static AccountService proxyProvideAccountService(ApplicationModule instance, OkHttpClient httpClient, OkHttpClient longTimeoutHttpClient, SharedPreferences defaultSharedPreferences, AuthenticationPersistence authenticationPersistence, TokenInvalidator tokenInvalidator, BodyInterceptor<BaseBody> bodyInterceptorPoolV7, BodyInterceptor<BaseBody> bodyInterceptorWebV7, MultipartBodyInterceptor multipartBodyInterceptor, BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> noAuthenticationBodyInterceptorV3, BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptorV3, ObjectMapper objectMapper, Factory converterFactory, String extraId, AccountFactory accountFactory, OAuthModeProvider oAuthModeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountService provideAccountService = instance.provideAccountService(httpClient, longTimeoutHttpClient, defaultSharedPreferences, authenticationPersistence, tokenInvalidator, bodyInterceptorPoolV7, bodyInterceptorWebV7, multipartBodyInterceptor, noAuthenticationBodyInterceptorV3, bodyInterceptorV3, objectMapper, converterFactory, extraId, accountFactory, oAuthModeProvider2);
        $jacocoInit[20] = true;
        return provideAccountService;
    }
}
