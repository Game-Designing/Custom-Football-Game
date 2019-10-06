package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesShortcutManagerFactory */
public final class ApplicationModule_ProvidesShortcutManagerFactory implements C13181b<AptoideShortcutManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1547677949927624054L, "cm/aptoide/pt/ApplicationModule_ProvidesShortcutManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesShortcutManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AptoideShortcutManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        AptoideShortcutManager providesShortcutManager = applicationModule.providesShortcutManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesShortcutManager, "Cannot return null from a non-@Nullable @Provides method");
        AptoideShortcutManager aptoideShortcutManager = providesShortcutManager;
        $jacocoInit[3] = true;
        return aptoideShortcutManager;
    }

    public static C13181b<AptoideShortcutManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesShortcutManagerFactory applicationModule_ProvidesShortcutManagerFactory = new ApplicationModule_ProvidesShortcutManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesShortcutManagerFactory;
    }

    public static AptoideShortcutManager proxyProvidesShortcutManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideShortcutManager providesShortcutManager = instance.providesShortcutManager();
        $jacocoInit[5] = true;
        return providesShortcutManager;
    }
}
