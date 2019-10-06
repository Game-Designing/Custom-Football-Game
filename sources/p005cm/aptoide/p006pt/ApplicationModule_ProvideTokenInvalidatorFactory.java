package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideTokenInvalidatorFactory */
public final class ApplicationModule_ProvideTokenInvalidatorFactory implements C13181b<TokenInvalidator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider;
    private final Provider<String> extraIdProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6042097189927529589L, "cm/aptoide/pt/ApplicationModule_ProvideTokenInvalidatorFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideTokenInvalidatorFactory(ApplicationModule module2, Provider<OkHttpClient> httpClientProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider2, Provider<String> extraIdProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.httpClientProvider = httpClientProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.authenticationPersistenceProvider = authenticationPersistenceProvider2;
        this.bodyInterceptorProvider = bodyInterceptorProvider2;
        this.extraIdProvider = extraIdProvider2;
        $jacocoInit[0] = true;
    }

    public TokenInvalidator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<OkHttpClient> provider = this.httpClientProvider;
        $jacocoInit[1] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider.get();
        Provider<SharedPreferences> provider2 = this.sharedPreferencesProvider;
        $jacocoInit[2] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider2.get();
        Provider<AuthenticationPersistence> provider3 = this.authenticationPersistenceProvider;
        $jacocoInit[3] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider3.get();
        Provider<BodyInterceptor<BaseBody>> provider4 = this.bodyInterceptorProvider;
        $jacocoInit[4] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider4.get();
        Provider<String> provider5 = this.extraIdProvider;
        $jacocoInit[5] = true;
        String str = (String) provider5.get();
        $jacocoInit[6] = true;
        TokenInvalidator provideTokenInvalidator = applicationModule.provideTokenInvalidator(okHttpClient, sharedPreferences, authenticationPersistence, bodyInterceptor, str);
        $jacocoInit[7] = true;
        C13182c.m43111a(provideTokenInvalidator, "Cannot return null from a non-@Nullable @Provides method");
        TokenInvalidator tokenInvalidator = provideTokenInvalidator;
        $jacocoInit[8] = true;
        return tokenInvalidator;
    }

    public static C13181b<TokenInvalidator> create(ApplicationModule module2, Provider<OkHttpClient> httpClientProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider2, Provider<String> extraIdProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideTokenInvalidatorFactory applicationModule_ProvideTokenInvalidatorFactory = new ApplicationModule_ProvideTokenInvalidatorFactory(module2, httpClientProvider2, sharedPreferencesProvider2, authenticationPersistenceProvider2, bodyInterceptorProvider2, extraIdProvider2);
        $jacocoInit[9] = true;
        return applicationModule_ProvideTokenInvalidatorFactory;
    }

    public static TokenInvalidator proxyProvideTokenInvalidator(ApplicationModule instance, OkHttpClient httpClient, SharedPreferences sharedPreferences, AuthenticationPersistence authenticationPersistence, BodyInterceptor<BaseBody> bodyInterceptor, String extraId) {
        boolean[] $jacocoInit = $jacocoInit();
        TokenInvalidator provideTokenInvalidator = instance.provideTokenInvalidator(httpClient, sharedPreferences, authenticationPersistence, bodyInterceptor, extraId);
        $jacocoInit[10] = true;
        return provideTokenInvalidator;
    }
}
