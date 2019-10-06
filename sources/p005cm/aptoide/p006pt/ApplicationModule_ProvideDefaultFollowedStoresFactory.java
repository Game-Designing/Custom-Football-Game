package p005cm.aptoide.p006pt;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideDefaultFollowedStoresFactory */
public final class ApplicationModule_ProvideDefaultFollowedStoresFactory implements C13181b<List<String>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(147526603815644670L, "cm/aptoide/pt/ApplicationModule_ProvideDefaultFollowedStoresFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideDefaultFollowedStoresFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public List<String> get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        List<String> provideDefaultFollowedStores = applicationModule.provideDefaultFollowedStores();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideDefaultFollowedStores, "Cannot return null from a non-@Nullable @Provides method");
        List<String> list = provideDefaultFollowedStores;
        $jacocoInit[3] = true;
        return list;
    }

    public static C13181b<List<String>> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideDefaultFollowedStoresFactory applicationModule_ProvideDefaultFollowedStoresFactory = new ApplicationModule_ProvideDefaultFollowedStoresFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideDefaultFollowedStoresFactory;
    }

    public static List<String> proxyProvideDefaultFollowedStores(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> provideDefaultFollowedStores = instance.provideDefaultFollowedStores();
        $jacocoInit[5] = true;
        return provideDefaultFollowedStores;
    }
}
