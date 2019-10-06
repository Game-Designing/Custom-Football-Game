package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import okhttp3.Interceptor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideUserAgentInterceptorV8Factory */
public final class ApplicationModule_ProvideUserAgentInterceptorV8Factory implements C13181b<Interceptor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> aptoidePackageProvider;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4704095112464095114L, "cm/aptoide/pt/ApplicationModule_ProvideUserAgentInterceptorV8Factory", 10);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideUserAgentInterceptorV8Factory(ApplicationModule module2, Provider<IdsRepository> idsRepositoryProvider2, Provider<String> aptoidePackageProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.aptoidePackageProvider = aptoidePackageProvider2;
        this.authenticationPersistenceProvider = authenticationPersistenceProvider2;
        $jacocoInit[0] = true;
    }

    public Interceptor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<IdsRepository> provider = this.idsRepositoryProvider;
        $jacocoInit[1] = true;
        IdsRepository idsRepository = (IdsRepository) provider.get();
        Provider<String> provider2 = this.aptoidePackageProvider;
        $jacocoInit[2] = true;
        String str = (String) provider2.get();
        Provider<AuthenticationPersistence> provider3 = this.authenticationPersistenceProvider;
        $jacocoInit[3] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider3.get();
        $jacocoInit[4] = true;
        Interceptor provideUserAgentInterceptorV8 = applicationModule.provideUserAgentInterceptorV8(idsRepository, str, authenticationPersistence);
        $jacocoInit[5] = true;
        C13182c.m43111a(provideUserAgentInterceptorV8, "Cannot return null from a non-@Nullable @Provides method");
        Interceptor interceptor = provideUserAgentInterceptorV8;
        $jacocoInit[6] = true;
        return interceptor;
    }

    public static C13181b<Interceptor> create(ApplicationModule module2, Provider<IdsRepository> idsRepositoryProvider2, Provider<String> aptoidePackageProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideUserAgentInterceptorV8Factory applicationModule_ProvideUserAgentInterceptorV8Factory = new ApplicationModule_ProvideUserAgentInterceptorV8Factory(module2, idsRepositoryProvider2, aptoidePackageProvider2, authenticationPersistenceProvider2);
        $jacocoInit[7] = true;
        return applicationModule_ProvideUserAgentInterceptorV8Factory;
    }

    public static Interceptor proxyProvideUserAgentInterceptorV8(ApplicationModule instance, IdsRepository idsRepository, String aptoidePackage, AuthenticationPersistence authenticationPersistence) {
        boolean[] $jacocoInit = $jacocoInit();
        Interceptor provideUserAgentInterceptorV8 = instance.provideUserAgentInterceptorV8(idsRepository, aptoidePackage, authenticationPersistence);
        $jacocoInit[8] = true;
        return provideUserAgentInterceptorV8;
    }
}
