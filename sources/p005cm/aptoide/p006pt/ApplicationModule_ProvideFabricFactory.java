package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p024io.fabric.sdk.android.C13920f;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideFabricFactory */
public final class ApplicationModule_ProvideFabricFactory implements C13181b<C13920f> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8434290690393498247L, "cm/aptoide/pt/ApplicationModule_ProvideFabricFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideFabricFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public C13920f get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        C13920f provideFabric = applicationModule.provideFabric();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideFabric, "Cannot return null from a non-@Nullable @Provides method");
        C13920f fVar = provideFabric;
        $jacocoInit[3] = true;
        return fVar;
    }

    public static C13181b<C13920f> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideFabricFactory applicationModule_ProvideFabricFactory = new ApplicationModule_ProvideFabricFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideFabricFactory;
    }

    public static C13920f proxyProvideFabric(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        C13920f provideFabric = instance.provideFabric();
        $jacocoInit[5] = true;
        return provideFabric;
    }
}
