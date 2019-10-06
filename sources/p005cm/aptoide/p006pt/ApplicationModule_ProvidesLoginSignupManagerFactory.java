package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesLoginSignupManagerFactory */
public final class ApplicationModule_ProvidesLoginSignupManagerFactory implements C13181b<LoginSignupManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5774480912104659001L, "cm/aptoide/pt/ApplicationModule_ProvidesLoginSignupManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesLoginSignupManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public LoginSignupManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        LoginSignupManager providesLoginSignupManager = applicationModule.providesLoginSignupManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesLoginSignupManager, "Cannot return null from a non-@Nullable @Provides method");
        LoginSignupManager loginSignupManager = providesLoginSignupManager;
        $jacocoInit[3] = true;
        return loginSignupManager;
    }

    public static C13181b<LoginSignupManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesLoginSignupManagerFactory applicationModule_ProvidesLoginSignupManagerFactory = new ApplicationModule_ProvidesLoginSignupManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesLoginSignupManagerFactory;
    }

    public static LoginSignupManager proxyProvidesLoginSignupManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        LoginSignupManager providesLoginSignupManager = instance.providesLoginSignupManager();
        $jacocoInit[5] = true;
        return providesLoginSignupManager;
    }
}
