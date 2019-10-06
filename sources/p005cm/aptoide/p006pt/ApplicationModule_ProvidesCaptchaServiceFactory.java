package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.promotions.CaptchaService;
import p005cm.aptoide.p006pt.promotions.CaptchaService.ServiceInterface;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesCaptchaServiceFactory */
public final class ApplicationModule_ProvidesCaptchaServiceFactory implements C13181b<CaptchaService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<ServiceInterface> serviceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8730859793313132815L, "cm/aptoide/pt/ApplicationModule_ProvidesCaptchaServiceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesCaptchaServiceFactory(ApplicationModule module2, Provider<ServiceInterface> serviceProvider2, Provider<IdsRepository> idsRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.serviceProvider = serviceProvider2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public CaptchaService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ServiceInterface> provider = this.serviceProvider;
        $jacocoInit[1] = true;
        CaptchaService providesCaptchaService = applicationModule.providesCaptchaService((ServiceInterface) provider.get(), (IdsRepository) this.idsRepositoryProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesCaptchaService, "Cannot return null from a non-@Nullable @Provides method");
        CaptchaService captchaService = providesCaptchaService;
        $jacocoInit[3] = true;
        return captchaService;
    }

    public static C13181b<CaptchaService> create(ApplicationModule module2, Provider<ServiceInterface> serviceProvider2, Provider<IdsRepository> idsRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesCaptchaServiceFactory applicationModule_ProvidesCaptchaServiceFactory = new ApplicationModule_ProvidesCaptchaServiceFactory(module2, serviceProvider2, idsRepositoryProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesCaptchaServiceFactory;
    }

    public static CaptchaService proxyProvidesCaptchaService(ApplicationModule instance, ServiceInterface service, IdsRepository idsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        CaptchaService providesCaptchaService = instance.providesCaptchaService(service, idsRepository);
        $jacocoInit[5] = true;
        return providesCaptchaService;
    }
}
