package p005cm.aptoide.p006pt;

import java.util.HashMap;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.AbTestCacheValidator;
import p005cm.aptoide.p006pt.abtesting.ExperimentModel;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAbTestCacheValidatorFactory */
public final class ApplicationModule_ProvidesAbTestCacheValidatorFactory implements C13181b<AbTestCacheValidator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<HashMap<String, ExperimentModel>> localCacheProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5630298549327889285L, "cm/aptoide/pt/ApplicationModule_ProvidesAbTestCacheValidatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAbTestCacheValidatorFactory(ApplicationModule module2, Provider<HashMap<String, ExperimentModel>> localCacheProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.localCacheProvider = localCacheProvider2;
        $jacocoInit[0] = true;
    }

    public AbTestCacheValidator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<HashMap<String, ExperimentModel>> provider = this.localCacheProvider;
        $jacocoInit[1] = true;
        AbTestCacheValidator providesAbTestCacheValidator = applicationModule.providesAbTestCacheValidator((HashMap) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAbTestCacheValidator, "Cannot return null from a non-@Nullable @Provides method");
        AbTestCacheValidator abTestCacheValidator = providesAbTestCacheValidator;
        $jacocoInit[3] = true;
        return abTestCacheValidator;
    }

    public static C13181b<AbTestCacheValidator> create(ApplicationModule module2, Provider<HashMap<String, ExperimentModel>> localCacheProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAbTestCacheValidatorFactory applicationModule_ProvidesAbTestCacheValidatorFactory = new ApplicationModule_ProvidesAbTestCacheValidatorFactory(module2, localCacheProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAbTestCacheValidatorFactory;
    }

    public static AbTestCacheValidator proxyProvidesAbTestCacheValidator(ApplicationModule instance, HashMap<String, ExperimentModel> localCache) {
        boolean[] $jacocoInit = $jacocoInit();
        AbTestCacheValidator providesAbTestCacheValidator = instance.providesAbTestCacheValidator(localCache);
        $jacocoInit[5] = true;
        return providesAbTestCacheValidator;
    }
}
