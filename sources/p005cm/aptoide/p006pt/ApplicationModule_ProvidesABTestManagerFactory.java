package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.ABTestCenterRepository;
import p005cm.aptoide.p006pt.abtesting.ABTestManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesABTestManagerFactory */
public final class ApplicationModule_ProvidesABTestManagerFactory implements C13181b<ABTestManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ABTestCenterRepository> abTestCenterRepositoryProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4281881873009082503L, "cm/aptoide/pt/ApplicationModule_ProvidesABTestManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesABTestManagerFactory(ApplicationModule module2, Provider<ABTestCenterRepository> abTestCenterRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.abTestCenterRepositoryProvider = abTestCenterRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public ABTestManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ABTestCenterRepository> provider = this.abTestCenterRepositoryProvider;
        $jacocoInit[1] = true;
        ABTestManager providesABTestManager = applicationModule.providesABTestManager((ABTestCenterRepository) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesABTestManager, "Cannot return null from a non-@Nullable @Provides method");
        ABTestManager aBTestManager = providesABTestManager;
        $jacocoInit[3] = true;
        return aBTestManager;
    }

    public static C13181b<ABTestManager> create(ApplicationModule module2, Provider<ABTestCenterRepository> abTestCenterRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesABTestManagerFactory applicationModule_ProvidesABTestManagerFactory = new ApplicationModule_ProvidesABTestManagerFactory(module2, abTestCenterRepositoryProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesABTestManagerFactory;
    }

    public static ABTestManager proxyProvidesABTestManager(ApplicationModule instance, ABTestCenterRepository abTestCenterRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        ABTestManager providesABTestManager = instance.providesABTestManager(abTestCenterRepository);
        $jacocoInit[5] = true;
        return providesABTestManager;
    }
}
