package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.donations.DonationsService;
import p005cm.aptoide.p006pt.app.view.donations.DonationsService.ServiceV8;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesDonationsServiceFactory */
public final class ApplicationModule_ProvidesDonationsServiceFactory implements C13181b<DonationsService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<ServiceV8> serviceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2022307355201256634L, "cm/aptoide/pt/ApplicationModule_ProvidesDonationsServiceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesDonationsServiceFactory(ApplicationModule module2, Provider<ServiceV8> serviceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.serviceProvider = serviceProvider2;
        $jacocoInit[0] = true;
    }

    public DonationsService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ServiceV8> provider = this.serviceProvider;
        $jacocoInit[1] = true;
        DonationsService providesDonationsService = applicationModule.providesDonationsService((ServiceV8) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesDonationsService, "Cannot return null from a non-@Nullable @Provides method");
        DonationsService donationsService = providesDonationsService;
        $jacocoInit[3] = true;
        return donationsService;
    }

    public static C13181b<DonationsService> create(ApplicationModule module2, Provider<ServiceV8> serviceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesDonationsServiceFactory applicationModule_ProvidesDonationsServiceFactory = new ApplicationModule_ProvidesDonationsServiceFactory(module2, serviceProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesDonationsServiceFactory;
    }

    public static DonationsService proxyProvidesDonationsService(ApplicationModule instance, ServiceV8 service) {
        boolean[] $jacocoInit = $jacocoInit();
        DonationsService providesDonationsService = instance.providesDonationsService(service);
        $jacocoInit[5] = true;
        return providesDonationsService;
    }
}
