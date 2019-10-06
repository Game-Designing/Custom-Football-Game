package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppCoinsService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppCoinsServiceFactory */
public final class ApplicationModule_ProvidesAppCoinsServiceFactory implements C13181b<AppCoinsService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final Provider<Factory> converterFactoryProvider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8659496798924345946L, "cm/aptoide/pt/ApplicationModule_ProvidesAppCoinsServiceFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppCoinsServiceFactory(ApplicationModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Factory> converterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.bodyInterceptorPoolV7Provider = bodyInterceptorPoolV7Provider2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        $jacocoInit[0] = true;
    }

    public AppCoinsService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<BodyInterceptor<BaseBody>> provider = this.bodyInterceptorPoolV7Provider;
        $jacocoInit[1] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider.get();
        Provider<OkHttpClient> provider2 = this.okHttpClientProvider;
        $jacocoInit[2] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider2.get();
        Provider<TokenInvalidator> provider3 = this.tokenInvalidatorProvider;
        $jacocoInit[3] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider3.get();
        Provider<SharedPreferences> provider4 = this.sharedPreferencesProvider;
        $jacocoInit[4] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider4.get();
        Provider<Factory> provider5 = this.converterFactoryProvider;
        $jacocoInit[5] = true;
        Factory factory = (Factory) provider5.get();
        $jacocoInit[6] = true;
        AppCoinsService providesAppCoinsService = applicationModule.providesAppCoinsService(bodyInterceptor, okHttpClient, tokenInvalidator, sharedPreferences, factory);
        $jacocoInit[7] = true;
        C13182c.m43111a(providesAppCoinsService, "Cannot return null from a non-@Nullable @Provides method");
        AppCoinsService appCoinsService = providesAppCoinsService;
        $jacocoInit[8] = true;
        return appCoinsService;
    }

    public static C13181b<AppCoinsService> create(ApplicationModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Factory> converterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppCoinsServiceFactory applicationModule_ProvidesAppCoinsServiceFactory = new ApplicationModule_ProvidesAppCoinsServiceFactory(module2, bodyInterceptorPoolV7Provider2, okHttpClientProvider2, tokenInvalidatorProvider2, sharedPreferencesProvider2, converterFactoryProvider2);
        $jacocoInit[9] = true;
        return applicationModule_ProvidesAppCoinsServiceFactory;
    }

    public static AppCoinsService proxyProvidesAppCoinsService(ApplicationModule instance, BodyInterceptor<BaseBody> bodyInterceptorPoolV7, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Factory converterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsService providesAppCoinsService = instance.providesAppCoinsService(bodyInterceptorPoolV7, okHttpClient, tokenInvalidator, sharedPreferences, converterFactory);
        $jacocoInit[10] = true;
        return providesAppCoinsService;
    }
}
