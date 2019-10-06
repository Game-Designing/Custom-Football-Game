package p005cm.aptoide.p006pt;

import java.util.HashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.ExperimentModel;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAbTestLocalCacheFactory */
public final class ApplicationModule_ProvidesAbTestLocalCacheFactory implements C13181b<HashMap<String, ExperimentModel>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2859229809345795484L, "cm/aptoide/pt/ApplicationModule_ProvidesAbTestLocalCacheFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAbTestLocalCacheFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public HashMap<String, ExperimentModel> get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        HashMap<String, ExperimentModel> providesAbTestLocalCache = applicationModule.providesAbTestLocalCache();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAbTestLocalCache, "Cannot return null from a non-@Nullable @Provides method");
        HashMap<String, ExperimentModel> hashMap = providesAbTestLocalCache;
        $jacocoInit[3] = true;
        return hashMap;
    }

    public static C13181b<HashMap<String, ExperimentModel>> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAbTestLocalCacheFactory applicationModule_ProvidesAbTestLocalCacheFactory = new ApplicationModule_ProvidesAbTestLocalCacheFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAbTestLocalCacheFactory;
    }

    public static HashMap<String, ExperimentModel> proxyProvidesAbTestLocalCache(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, ExperimentModel> providesAbTestLocalCache = instance.providesAbTestLocalCache();
        $jacocoInit[5] = true;
        return providesAbTestLocalCache;
    }
}
