package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.RequestBodyFactory;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.networking.MultipartBodyInterceptor;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideMultipartBodyInterceptorFactory */
public final class ApplicationModule_ProvideMultipartBodyInterceptorFactory implements C13181b<MultipartBodyInterceptor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<RequestBodyFactory> requestBodyFactoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5403467327607601612L, "cm/aptoide/pt/ApplicationModule_ProvideMultipartBodyInterceptorFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideMultipartBodyInterceptorFactory(ApplicationModule module2, Provider<IdsRepository> idsRepositoryProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<RequestBodyFactory> requestBodyFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.authenticationPersistenceProvider = authenticationPersistenceProvider2;
        this.requestBodyFactoryProvider = requestBodyFactoryProvider2;
        $jacocoInit[0] = true;
    }

    public MultipartBodyInterceptor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<IdsRepository> provider = this.idsRepositoryProvider;
        $jacocoInit[1] = true;
        IdsRepository idsRepository = (IdsRepository) provider.get();
        Provider<AuthenticationPersistence> provider2 = this.authenticationPersistenceProvider;
        $jacocoInit[2] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider2.get();
        Provider<RequestBodyFactory> provider3 = this.requestBodyFactoryProvider;
        $jacocoInit[3] = true;
        RequestBodyFactory requestBodyFactory = (RequestBodyFactory) provider3.get();
        $jacocoInit[4] = true;
        MultipartBodyInterceptor provideMultipartBodyInterceptor = applicationModule.provideMultipartBodyInterceptor(idsRepository, authenticationPersistence, requestBodyFactory);
        $jacocoInit[5] = true;
        C13182c.m43111a(provideMultipartBodyInterceptor, "Cannot return null from a non-@Nullable @Provides method");
        MultipartBodyInterceptor multipartBodyInterceptor = provideMultipartBodyInterceptor;
        $jacocoInit[6] = true;
        return multipartBodyInterceptor;
    }

    public static C13181b<MultipartBodyInterceptor> create(ApplicationModule module2, Provider<IdsRepository> idsRepositoryProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<RequestBodyFactory> requestBodyFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideMultipartBodyInterceptorFactory applicationModule_ProvideMultipartBodyInterceptorFactory = new ApplicationModule_ProvideMultipartBodyInterceptorFactory(module2, idsRepositoryProvider2, authenticationPersistenceProvider2, requestBodyFactoryProvider2);
        $jacocoInit[7] = true;
        return applicationModule_ProvideMultipartBodyInterceptorFactory;
    }

    public static MultipartBodyInterceptor proxyProvideMultipartBodyInterceptor(ApplicationModule instance, IdsRepository idsRepository, AuthenticationPersistence authenticationPersistence, RequestBodyFactory requestBodyFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        MultipartBodyInterceptor provideMultipartBodyInterceptor = instance.provideMultipartBodyInterceptor(idsRepository, authenticationPersistence, requestBodyFactory);
        $jacocoInit[8] = true;
        return provideMultipartBodyInterceptor;
    }
}
