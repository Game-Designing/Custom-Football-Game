package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.editorial.EditorialService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesEditorialServiceFactory */
public final class ApplicationModule_ProvidesEditorialServiceFactory implements C13181b<EditorialService> {
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
        boolean[] probes = Offline.getProbes(-6337492965471889062L, "cm/aptoide/pt/ApplicationModule_ProvidesEditorialServiceFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesEditorialServiceFactory(ApplicationModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.bodyInterceptorPoolV7Provider = bodyInterceptorPoolV7Provider2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<BodyInterceptor<BaseBody>> provider = this.bodyInterceptorPoolV7Provider;
        $jacocoInit[1] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider.get();
        Provider<OkHttpClient> provider2 = this.okHttpClientProvider;
        $jacocoInit[2] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider2.get();
        Provider<Factory> provider3 = this.converterFactoryProvider;
        $jacocoInit[3] = true;
        Factory factory = (Factory) provider3.get();
        Provider<TokenInvalidator> provider4 = this.tokenInvalidatorProvider;
        $jacocoInit[4] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider4.get();
        Provider<SharedPreferences> provider5 = this.sharedPreferencesProvider;
        $jacocoInit[5] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider5.get();
        $jacocoInit[6] = true;
        EditorialService providesEditorialService = applicationModule.providesEditorialService(bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
        $jacocoInit[7] = true;
        C13182c.m43111a(providesEditorialService, "Cannot return null from a non-@Nullable @Provides method");
        EditorialService editorialService = providesEditorialService;
        $jacocoInit[8] = true;
        return editorialService;
    }

    public static C13181b<EditorialService> create(ApplicationModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesEditorialServiceFactory applicationModule_ProvidesEditorialServiceFactory = new ApplicationModule_ProvidesEditorialServiceFactory(module2, bodyInterceptorPoolV7Provider2, okHttpClientProvider2, converterFactoryProvider2, tokenInvalidatorProvider2, sharedPreferencesProvider2);
        $jacocoInit[9] = true;
        return applicationModule_ProvidesEditorialServiceFactory;
    }

    public static EditorialService proxyProvidesEditorialService(ApplicationModule instance, BodyInterceptor<BaseBody> bodyInterceptorPoolV7, OkHttpClient okHttpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialService providesEditorialService = instance.providesEditorialService(bodyInterceptorPoolV7, okHttpClient, converterFactory, tokenInvalidator, sharedPreferences);
        $jacocoInit[10] = true;
        return providesEditorialService;
    }
}
