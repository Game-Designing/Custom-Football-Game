package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidePermissionManagerFactory */
public final class ApplicationModule_ProvidePermissionManagerFactory implements C13181b<PermissionManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1344558813884069695L, "cm/aptoide/pt/ApplicationModule_ProvidePermissionManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidePermissionManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public PermissionManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        PermissionManager providePermissionManager = applicationModule.providePermissionManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providePermissionManager, "Cannot return null from a non-@Nullable @Provides method");
        PermissionManager permissionManager = providePermissionManager;
        $jacocoInit[3] = true;
        return permissionManager;
    }

    public static C13181b<PermissionManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidePermissionManagerFactory applicationModule_ProvidePermissionManagerFactory = new ApplicationModule_ProvidePermissionManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidePermissionManagerFactory;
    }

    public static PermissionManager proxyProvidePermissionManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        PermissionManager providePermissionManager = instance.providePermissionManager();
        $jacocoInit[5] = true;
        return providePermissionManager;
    }
}
