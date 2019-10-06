package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.donations.WalletService;
import p005cm.aptoide.p006pt.app.view.donations.WalletService.ServiceV7;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesWalletServiceFactory */
public final class ApplicationModule_ProvidesWalletServiceFactory implements C13181b<WalletService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<ServiceV7> serviceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7482270358695547789L, "cm/aptoide/pt/ApplicationModule_ProvidesWalletServiceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesWalletServiceFactory(ApplicationModule module2, Provider<ServiceV7> serviceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.serviceProvider = serviceProvider2;
        $jacocoInit[0] = true;
    }

    public WalletService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ServiceV7> provider = this.serviceProvider;
        $jacocoInit[1] = true;
        WalletService providesWalletService = applicationModule.providesWalletService((ServiceV7) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesWalletService, "Cannot return null from a non-@Nullable @Provides method");
        WalletService walletService = providesWalletService;
        $jacocoInit[3] = true;
        return walletService;
    }

    public static C13181b<WalletService> create(ApplicationModule module2, Provider<ServiceV7> serviceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesWalletServiceFactory applicationModule_ProvidesWalletServiceFactory = new ApplicationModule_ProvidesWalletServiceFactory(module2, serviceProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesWalletServiceFactory;
    }

    public static WalletService proxyProvidesWalletService(ApplicationModule instance, ServiceV7 service) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletService providesWalletService = instance.providesWalletService(service);
        $jacocoInit[5] = true;
        return providesWalletService;
    }
}
