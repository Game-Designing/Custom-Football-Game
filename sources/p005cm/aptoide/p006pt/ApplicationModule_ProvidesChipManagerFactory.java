package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.ChipManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesChipManagerFactory */
public final class ApplicationModule_ProvidesChipManagerFactory implements C13181b<ChipManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2007627871413558801L, "cm/aptoide/pt/ApplicationModule_ProvidesChipManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesChipManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public ChipManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        ChipManager providesChipManager = applicationModule.providesChipManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesChipManager, "Cannot return null from a non-@Nullable @Provides method");
        ChipManager chipManager = providesChipManager;
        $jacocoInit[3] = true;
        return chipManager;
    }

    public static C13181b<ChipManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesChipManagerFactory applicationModule_ProvidesChipManagerFactory = new ApplicationModule_ProvidesChipManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesChipManagerFactory;
    }

    public static ChipManager proxyProvidesChipManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        ChipManager providesChipManager = instance.providesChipManager();
        $jacocoInit[5] = true;
        return providesChipManager;
    }
}
