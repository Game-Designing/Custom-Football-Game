package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideNoAuthenticationBodyInterceptorV3Factory */
public final class C1362xcbc5ac1 implements C13181b<BodyInterceptor<BaseBody>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> aptoidePackageProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3732215889502038173L, "cm/aptoide/pt/ApplicationModule_ProvideNoAuthenticationBodyInterceptorV3Factory", 8);
        $jacocoData = probes;
        return probes;
    }

    public C1362xcbc5ac1(ApplicationModule module2, Provider<IdsRepository> idsRepositoryProvider2, Provider<String> aptoidePackageProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.aptoidePackageProvider = aptoidePackageProvider2;
        $jacocoInit[0] = true;
    }

    public BodyInterceptor<BaseBody> get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<IdsRepository> provider = this.idsRepositoryProvider;
        $jacocoInit[1] = true;
        IdsRepository idsRepository = (IdsRepository) provider.get();
        String str = (String) this.aptoidePackageProvider.get();
        $jacocoInit[2] = true;
        BodyInterceptor<BaseBody> provideNoAuthenticationBodyInterceptorV3 = applicationModule.provideNoAuthenticationBodyInterceptorV3(idsRepository, str);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideNoAuthenticationBodyInterceptorV3, "Cannot return null from a non-@Nullable @Provides method");
        BodyInterceptor<BaseBody> bodyInterceptor = provideNoAuthenticationBodyInterceptorV3;
        $jacocoInit[4] = true;
        return bodyInterceptor;
    }

    public static C13181b<BodyInterceptor<BaseBody>> create(ApplicationModule module2, Provider<IdsRepository> idsRepositoryProvider2, Provider<String> aptoidePackageProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        C1362xcbc5ac1 applicationModule_ProvideNoAuthenticationBodyInterceptorV3Factory = new C1362xcbc5ac1(module2, idsRepositoryProvider2, aptoidePackageProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvideNoAuthenticationBodyInterceptorV3Factory;
    }

    public static BodyInterceptor<BaseBody> proxyProvideNoAuthenticationBodyInterceptorV3(ApplicationModule instance, IdsRepository idsRepository, String aptoidePackage) {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> provideNoAuthenticationBodyInterceptorV3 = instance.provideNoAuthenticationBodyInterceptorV3(idsRepository, aptoidePackage);
        $jacocoInit[6] = true;
        return provideNoAuthenticationBodyInterceptorV3;
    }
}
