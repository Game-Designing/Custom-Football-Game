package p005cm.aptoide.p006pt;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.Result;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideFragmentNavigatorMapFactory */
public final class ApplicationModule_ProvideFragmentNavigatorMapFactory implements C13181b<Map<Integer, Result>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2730760031219036089L, "cm/aptoide/pt/ApplicationModule_ProvideFragmentNavigatorMapFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideFragmentNavigatorMapFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public Map<Integer, Result> get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        Map<Integer, Result> provideFragmentNavigatorMap = applicationModule.provideFragmentNavigatorMap();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideFragmentNavigatorMap, "Cannot return null from a non-@Nullable @Provides method");
        Map<Integer, Result> map = provideFragmentNavigatorMap;
        $jacocoInit[3] = true;
        return map;
    }

    public static C13181b<Map<Integer, Result>> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideFragmentNavigatorMapFactory applicationModule_ProvideFragmentNavigatorMapFactory = new ApplicationModule_ProvideFragmentNavigatorMapFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideFragmentNavigatorMapFactory;
    }

    public static Map<Integer, Result> proxyProvideFragmentNavigatorMap(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<Integer, Result> provideFragmentNavigatorMap = instance.provideFragmentNavigatorMap();
        $jacocoInit[5] = true;
        return provideFragmentNavigatorMap;
    }
}
