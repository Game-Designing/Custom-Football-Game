package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesReactionsHostFactory */
public final class ApplicationModule_ProvidesReactionsHostFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1326718630227605446L, "cm/aptoide/pt/ApplicationModule_ProvidesReactionsHostFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesReactionsHostFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        String providesReactionsHost = applicationModule.providesReactionsHost();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesReactionsHost, "Cannot return null from a non-@Nullable @Provides method");
        String str = providesReactionsHost;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesReactionsHostFactory applicationModule_ProvidesReactionsHostFactory = new ApplicationModule_ProvidesReactionsHostFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesReactionsHostFactory;
    }

    public static String proxyProvidesReactionsHost(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String providesReactionsHost = instance.providesReactionsHost();
        $jacocoInit[5] = true;
        return providesReactionsHost;
    }
}
