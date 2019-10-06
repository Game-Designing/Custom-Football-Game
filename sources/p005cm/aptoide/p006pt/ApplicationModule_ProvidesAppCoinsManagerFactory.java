package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppCoinsManager;
import p005cm.aptoide.p006pt.app.AppCoinsService;
import p005cm.aptoide.p006pt.app.view.donations.DonationsService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppCoinsManagerFactory */
public final class ApplicationModule_ProvidesAppCoinsManagerFactory implements C13181b<AppCoinsManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppCoinsService> appCoinsServiceProvider;
    private final Provider<DonationsService> donationsServiceProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6439889323894563488L, "cm/aptoide/pt/ApplicationModule_ProvidesAppCoinsManagerFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppCoinsManagerFactory(ApplicationModule module2, Provider<AppCoinsService> appCoinsServiceProvider2, Provider<DonationsService> donationsServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.appCoinsServiceProvider = appCoinsServiceProvider2;
        this.donationsServiceProvider = donationsServiceProvider2;
        $jacocoInit[0] = true;
    }

    public AppCoinsManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AppCoinsService> provider = this.appCoinsServiceProvider;
        $jacocoInit[1] = true;
        AppCoinsService appCoinsService = (AppCoinsService) provider.get();
        DonationsService donationsService = (DonationsService) this.donationsServiceProvider.get();
        $jacocoInit[2] = true;
        AppCoinsManager providesAppCoinsManager = applicationModule.providesAppCoinsManager(appCoinsService, donationsService);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesAppCoinsManager, "Cannot return null from a non-@Nullable @Provides method");
        AppCoinsManager appCoinsManager = providesAppCoinsManager;
        $jacocoInit[4] = true;
        return appCoinsManager;
    }

    public static C13181b<AppCoinsManager> create(ApplicationModule module2, Provider<AppCoinsService> appCoinsServiceProvider2, Provider<DonationsService> donationsServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppCoinsManagerFactory applicationModule_ProvidesAppCoinsManagerFactory = new ApplicationModule_ProvidesAppCoinsManagerFactory(module2, appCoinsServiceProvider2, donationsServiceProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesAppCoinsManagerFactory;
    }

    public static AppCoinsManager proxyProvidesAppCoinsManager(ApplicationModule instance, AppCoinsService appCoinsService, DonationsService donationsService) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsManager providesAppCoinsManager = instance.providesAppCoinsManager(appCoinsService, donationsService);
        $jacocoInit[6] = true;
        return providesAppCoinsManager;
    }
}
