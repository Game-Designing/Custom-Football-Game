package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.accessors.UpdateAccessor;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.updates.UpdateRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesUpdateRepositoryFactory */
public final class ApplicationModule_ProvidesUpdateRepositoryFactory implements C13181b<UpdateRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final Provider<Factory> converterFactoryProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<StoreAccessor> storeAccessorProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;
    private final Provider<UpdateAccessor> updateAccessorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8999319519423189594L, "cm/aptoide/pt/ApplicationModule_ProvidesUpdateRepositoryFactory", 15);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesUpdateRepositoryFactory(ApplicationModule module2, Provider<UpdateAccessor> updateAccessorProvider2, Provider<StoreAccessor> storeAccessorProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.updateAccessorProvider = updateAccessorProvider2;
        this.storeAccessorProvider = storeAccessorProvider2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.bodyInterceptorPoolV7Provider = bodyInterceptorPoolV7Provider2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public UpdateRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<UpdateAccessor> provider = this.updateAccessorProvider;
        $jacocoInit[1] = true;
        UpdateAccessor updateAccessor = (UpdateAccessor) provider.get();
        Provider<StoreAccessor> provider2 = this.storeAccessorProvider;
        $jacocoInit[2] = true;
        StoreAccessor storeAccessor = (StoreAccessor) provider2.get();
        Provider<IdsRepository> provider3 = this.idsRepositoryProvider;
        $jacocoInit[3] = true;
        IdsRepository idsRepository = (IdsRepository) provider3.get();
        Provider<BodyInterceptor<BaseBody>> provider4 = this.bodyInterceptorPoolV7Provider;
        $jacocoInit[4] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider4.get();
        Provider<OkHttpClient> provider5 = this.okHttpClientProvider;
        $jacocoInit[5] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider5.get();
        Provider<Factory> provider6 = this.converterFactoryProvider;
        $jacocoInit[6] = true;
        Factory factory = (Factory) provider6.get();
        Provider<TokenInvalidator> provider7 = this.tokenInvalidatorProvider;
        $jacocoInit[7] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider7.get();
        Provider<SharedPreferences> provider8 = this.sharedPreferencesProvider;
        $jacocoInit[8] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider8.get();
        $jacocoInit[9] = true;
        UpdateRepository providesUpdateRepository = applicationModule.providesUpdateRepository(updateAccessor, storeAccessor, idsRepository, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
        $jacocoInit[10] = true;
        C13182c.m43111a(providesUpdateRepository, "Cannot return null from a non-@Nullable @Provides method");
        UpdateRepository updateRepository = providesUpdateRepository;
        $jacocoInit[11] = true;
        return updateRepository;
    }

    public static C13181b<UpdateRepository> create(ApplicationModule module2, Provider<UpdateAccessor> updateAccessorProvider2, Provider<StoreAccessor> storeAccessorProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesUpdateRepositoryFactory applicationModule_ProvidesUpdateRepositoryFactory = new ApplicationModule_ProvidesUpdateRepositoryFactory(module2, updateAccessorProvider2, storeAccessorProvider2, idsRepositoryProvider2, bodyInterceptorPoolV7Provider2, okHttpClientProvider2, converterFactoryProvider2, tokenInvalidatorProvider2, sharedPreferencesProvider2);
        $jacocoInit[12] = true;
        return applicationModule_ProvidesUpdateRepositoryFactory;
    }

    public static UpdateRepository proxyProvidesUpdateRepository(ApplicationModule instance, UpdateAccessor updateAccessor, StoreAccessor storeAccessor, IdsRepository idsRepository, BodyInterceptor<BaseBody> bodyInterceptorPoolV7, OkHttpClient okHttpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        UpdateRepository providesUpdateRepository = instance.providesUpdateRepository(updateAccessor, storeAccessor, idsRepository, bodyInterceptorPoolV7, okHttpClient, converterFactory, tokenInvalidator, sharedPreferences);
        $jacocoInit[13] = true;
        return providesUpdateRepository;
    }
}
