package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.view.app.AppService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppServiceFactory */
public final class ApplicationModule_ProvidesAppServiceFactory implements C13181b<AppService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<StoreCredentialsProvider> storeCredentialsProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5802263842574990872L, "cm/aptoide/pt/ApplicationModule_ProvidesAppServiceFactory", 13);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppServiceFactory(ApplicationModule module2, Provider<StoreCredentialsProvider> storeCredentialsProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.bodyInterceptorPoolV7Provider = bodyInterceptorPoolV7Provider2;
        this.bodyInterceptorV3Provider = bodyInterceptorV3Provider2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public AppService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<StoreCredentialsProvider> provider = this.storeCredentialsProvider;
        $jacocoInit[1] = true;
        StoreCredentialsProvider storeCredentialsProvider2 = (StoreCredentialsProvider) provider.get();
        Provider<BodyInterceptor<BaseBody>> provider2 = this.bodyInterceptorPoolV7Provider;
        $jacocoInit[2] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider2.get();
        Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> provider3 = this.bodyInterceptorV3Provider;
        $jacocoInit[3] = true;
        BodyInterceptor bodyInterceptor2 = (BodyInterceptor) provider3.get();
        Provider<OkHttpClient> provider4 = this.okHttpClientProvider;
        $jacocoInit[4] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider4.get();
        Provider<TokenInvalidator> provider5 = this.tokenInvalidatorProvider;
        $jacocoInit[5] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider5.get();
        Provider<SharedPreferences> provider6 = this.sharedPreferencesProvider;
        $jacocoInit[6] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider6.get();
        $jacocoInit[7] = true;
        AppService providesAppService = applicationModule.providesAppService(storeCredentialsProvider2, bodyInterceptor, bodyInterceptor2, okHttpClient, tokenInvalidator, sharedPreferences);
        $jacocoInit[8] = true;
        C13182c.m43111a(providesAppService, "Cannot return null from a non-@Nullable @Provides method");
        AppService appService = providesAppService;
        $jacocoInit[9] = true;
        return appService;
    }

    public static C13181b<AppService> create(ApplicationModule module2, Provider<StoreCredentialsProvider> storeCredentialsProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody>> bodyInterceptorV3Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppServiceFactory applicationModule_ProvidesAppServiceFactory = new ApplicationModule_ProvidesAppServiceFactory(module2, storeCredentialsProvider2, bodyInterceptorPoolV7Provider2, bodyInterceptorV3Provider2, okHttpClientProvider2, tokenInvalidatorProvider2, sharedPreferencesProvider2);
        $jacocoInit[10] = true;
        return applicationModule_ProvidesAppServiceFactory;
    }

    public static AppService proxyProvidesAppService(ApplicationModule instance, StoreCredentialsProvider storeCredentialsProvider2, BodyInterceptor<BaseBody> bodyInterceptorPoolV7, BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptorV3, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        AppService providesAppService = instance.providesAppService(storeCredentialsProvider2, bodyInterceptorPoolV7, bodyInterceptorV3, okHttpClient, tokenInvalidator, sharedPreferences);
        $jacocoInit[11] = true;
        return providesAppService;
    }
}
