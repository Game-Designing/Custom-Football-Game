package p005cm.aptoide.p006pt;

import java.util.HashMap;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.ABTestCenterRepository;
import p005cm.aptoide.p006pt.abtesting.ABTestService;
import p005cm.aptoide.p006pt.abtesting.AbTestCacheValidator;
import p005cm.aptoide.p006pt.abtesting.ExperimentModel;
import p005cm.aptoide.p006pt.abtesting.RealmExperimentPersistence;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesABTestCenterRepositoryFactory */
public final class ApplicationModule_ProvidesABTestCenterRepositoryFactory implements C13181b<ABTestCenterRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ABTestService> abTestServiceProvider;
    private final Provider<AbTestCacheValidator> cacheValidatorProvider;
    private final Provider<HashMap<String, ExperimentModel>> localCacheProvider;
    private final ApplicationModule module;
    private final Provider<RealmExperimentPersistence> persistenceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-815454025728450192L, "cm/aptoide/pt/ApplicationModule_ProvidesABTestCenterRepositoryFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesABTestCenterRepositoryFactory(ApplicationModule module2, Provider<ABTestService> abTestServiceProvider2, Provider<RealmExperimentPersistence> persistenceProvider2, Provider<HashMap<String, ExperimentModel>> localCacheProvider2, Provider<AbTestCacheValidator> cacheValidatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.abTestServiceProvider = abTestServiceProvider2;
        this.persistenceProvider = persistenceProvider2;
        this.localCacheProvider = localCacheProvider2;
        this.cacheValidatorProvider = cacheValidatorProvider2;
        $jacocoInit[0] = true;
    }

    public ABTestCenterRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ABTestService> provider = this.abTestServiceProvider;
        $jacocoInit[1] = true;
        ABTestService aBTestService = (ABTestService) provider.get();
        Provider<RealmExperimentPersistence> provider2 = this.persistenceProvider;
        $jacocoInit[2] = true;
        RealmExperimentPersistence realmExperimentPersistence = (RealmExperimentPersistence) provider2.get();
        Provider<HashMap<String, ExperimentModel>> provider3 = this.localCacheProvider;
        $jacocoInit[3] = true;
        HashMap hashMap = (HashMap) provider3.get();
        Provider<AbTestCacheValidator> provider4 = this.cacheValidatorProvider;
        $jacocoInit[4] = true;
        AbTestCacheValidator abTestCacheValidator = (AbTestCacheValidator) provider4.get();
        $jacocoInit[5] = true;
        ABTestCenterRepository providesABTestCenterRepository = applicationModule.providesABTestCenterRepository(aBTestService, realmExperimentPersistence, hashMap, abTestCacheValidator);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesABTestCenterRepository, "Cannot return null from a non-@Nullable @Provides method");
        ABTestCenterRepository aBTestCenterRepository = providesABTestCenterRepository;
        $jacocoInit[7] = true;
        return aBTestCenterRepository;
    }

    public static C13181b<ABTestCenterRepository> create(ApplicationModule module2, Provider<ABTestService> abTestServiceProvider2, Provider<RealmExperimentPersistence> persistenceProvider2, Provider<HashMap<String, ExperimentModel>> localCacheProvider2, Provider<AbTestCacheValidator> cacheValidatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesABTestCenterRepositoryFactory applicationModule_ProvidesABTestCenterRepositoryFactory = new ApplicationModule_ProvidesABTestCenterRepositoryFactory(module2, abTestServiceProvider2, persistenceProvider2, localCacheProvider2, cacheValidatorProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvidesABTestCenterRepositoryFactory;
    }

    public static ABTestCenterRepository proxyProvidesABTestCenterRepository(ApplicationModule instance, ABTestService abTestService, RealmExperimentPersistence persistence, HashMap<String, ExperimentModel> localCache, AbTestCacheValidator cacheValidator) {
        boolean[] $jacocoInit = $jacocoInit();
        ABTestCenterRepository providesABTestCenterRepository = instance.providesABTestCenterRepository(abTestService, persistence, localCache, cacheValidator);
        $jacocoInit[9] = true;
        return providesABTestCenterRepository;
    }
}
