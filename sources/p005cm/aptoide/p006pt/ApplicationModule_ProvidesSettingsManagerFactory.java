package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesSettingsManagerFactory */
public final class ApplicationModule_ProvidesSettingsManagerFactory implements C13181b<SettingsManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7399031963553988552L, "cm/aptoide/pt/ApplicationModule_ProvidesSettingsManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesSettingsManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public SettingsManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        SettingsManager providesSettingsManager = applicationModule.providesSettingsManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesSettingsManager, "Cannot return null from a non-@Nullable @Provides method");
        SettingsManager settingsManager = providesSettingsManager;
        $jacocoInit[3] = true;
        return settingsManager;
    }

    public static C13181b<SettingsManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesSettingsManagerFactory applicationModule_ProvidesSettingsManagerFactory = new ApplicationModule_ProvidesSettingsManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesSettingsManagerFactory;
    }

    public static SettingsManager proxyProvidesSettingsManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        SettingsManager providesSettingsManager = instance.providesSettingsManager();
        $jacocoInit[5] = true;
        return providesSettingsManager;
    }
}
