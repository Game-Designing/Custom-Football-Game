package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.ABTestService;
import p005cm.aptoide.p006pt.abtesting.ABTestService.ServiceV7;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesABTestServiceFactory */
public final class ApplicationModule_ProvidesABTestServiceFactory implements C13181b<ABTestService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<ServiceV7> serviceV7Provider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3344187607911454531L, "cm/aptoide/pt/ApplicationModule_ProvidesABTestServiceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesABTestServiceFactory(ApplicationModule module2, Provider<ServiceV7> serviceV7Provider2, Provider<IdsRepository> idsRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.serviceV7Provider = serviceV7Provider2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public ABTestService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ServiceV7> provider = this.serviceV7Provider;
        $jacocoInit[1] = true;
        ABTestService providesABTestService = applicationModule.providesABTestService((ServiceV7) provider.get(), (IdsRepository) this.idsRepositoryProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesABTestService, "Cannot return null from a non-@Nullable @Provides method");
        ABTestService aBTestService = providesABTestService;
        $jacocoInit[3] = true;
        return aBTestService;
    }

    public static C13181b<ABTestService> create(ApplicationModule module2, Provider<ServiceV7> serviceV7Provider2, Provider<IdsRepository> idsRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesABTestServiceFactory applicationModule_ProvidesABTestServiceFactory = new ApplicationModule_ProvidesABTestServiceFactory(module2, serviceV7Provider2, idsRepositoryProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesABTestServiceFactory;
    }

    public static ABTestService proxyProvidesABTestService(ApplicationModule instance, ServiceV7 serviceV7, IdsRepository idsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        ABTestService providesABTestService = instance.providesABTestService(serviceV7, idsRepository);
        $jacocoInit[5] = true;
        return providesABTestService;
    }
}
