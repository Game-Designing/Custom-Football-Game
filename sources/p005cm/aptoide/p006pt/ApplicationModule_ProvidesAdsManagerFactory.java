package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.app.AdsManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAdsManagerFactory */
public final class ApplicationModule_ProvidesAdsManagerFactory implements C13181b<AdsManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AdsRepository> adsRepositoryProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3578157206233604712L, "cm/aptoide/pt/ApplicationModule_ProvidesAdsManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAdsManagerFactory(ApplicationModule module2, Provider<AdsRepository> adsRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.adsRepositoryProvider = adsRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public AdsManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AdsRepository> provider = this.adsRepositoryProvider;
        $jacocoInit[1] = true;
        AdsManager providesAdsManager = applicationModule.providesAdsManager((AdsRepository) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAdsManager, "Cannot return null from a non-@Nullable @Provides method");
        AdsManager adsManager = providesAdsManager;
        $jacocoInit[3] = true;
        return adsManager;
    }

    public static C13181b<AdsManager> create(ApplicationModule module2, Provider<AdsRepository> adsRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAdsManagerFactory applicationModule_ProvidesAdsManagerFactory = new ApplicationModule_ProvidesAdsManagerFactory(module2, adsRepositoryProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAdsManagerFactory;
    }

    public static AdsManager proxyProvidesAdsManager(ApplicationModule instance, AdsRepository adsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        AdsManager providesAdsManager = instance.providesAdsManager(adsRepository);
        $jacocoInit[5] = true;
        return providesAdsManager;
    }
}
