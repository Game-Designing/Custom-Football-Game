package p005cm.aptoide.p006pt;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.Result;
import p019d.p022i.p023b.C0099b;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideFragmentNavigatorRelayFactory */
public final class ApplicationModule_ProvideFragmentNavigatorRelayFactory implements C13181b<C0099b<Map<Integer, Result>>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5459466579496305113L, "cm/aptoide/pt/ApplicationModule_ProvideFragmentNavigatorRelayFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideFragmentNavigatorRelayFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public C0099b<Map<Integer, Result>> get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        C0099b<Map<Integer, Result>> provideFragmentNavigatorRelay = applicationModule.provideFragmentNavigatorRelay();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideFragmentNavigatorRelay, "Cannot return null from a non-@Nullable @Provides method");
        C0099b<Map<Integer, Result>> bVar = provideFragmentNavigatorRelay;
        $jacocoInit[3] = true;
        return bVar;
    }

    public static C13181b<C0099b<Map<Integer, Result>>> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideFragmentNavigatorRelayFactory applicationModule_ProvideFragmentNavigatorRelayFactory = new ApplicationModule_ProvideFragmentNavigatorRelayFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideFragmentNavigatorRelayFactory;
    }

    public static C0099b<Map<Integer, Result>> proxyProvideFragmentNavigatorRelay(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        C0099b<Map<Integer, Result>> provideFragmentNavigatorRelay = instance.provideFragmentNavigatorRelay();
        $jacocoInit[5] = true;
        return provideFragmentNavigatorRelay;
    }
}
