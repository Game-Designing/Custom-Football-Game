package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.OemidProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesOemidProviderFactory */
public final class ApplicationModule_ProvidesOemidProviderFactory implements C13181b<OemidProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2912092239833214391L, "cm/aptoide/pt/ApplicationModule_ProvidesOemidProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesOemidProviderFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public OemidProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        OemidProvider providesOemidProvider = applicationModule.providesOemidProvider();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesOemidProvider, "Cannot return null from a non-@Nullable @Provides method");
        OemidProvider oemidProvider = providesOemidProvider;
        $jacocoInit[3] = true;
        return oemidProvider;
    }

    public static C13181b<OemidProvider> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesOemidProviderFactory applicationModule_ProvidesOemidProviderFactory = new ApplicationModule_ProvidesOemidProviderFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesOemidProviderFactory;
    }

    public static OemidProvider proxyProvidesOemidProvider(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        OemidProvider providesOemidProvider = instance.providesOemidProvider();
        $jacocoInit[5] = true;
        return providesOemidProvider;
    }
}
