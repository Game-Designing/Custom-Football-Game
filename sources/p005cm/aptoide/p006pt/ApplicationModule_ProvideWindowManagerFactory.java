package p005cm.aptoide.p006pt;

import android.view.WindowManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideWindowManagerFactory */
public final class ApplicationModule_ProvideWindowManagerFactory implements C13181b<WindowManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8947329098497504812L, "cm/aptoide/pt/ApplicationModule_ProvideWindowManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideWindowManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public WindowManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        WindowManager provideWindowManager = applicationModule.provideWindowManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideWindowManager, "Cannot return null from a non-@Nullable @Provides method");
        WindowManager windowManager = provideWindowManager;
        $jacocoInit[3] = true;
        return windowManager;
    }

    public static C13181b<WindowManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideWindowManagerFactory applicationModule_ProvideWindowManagerFactory = new ApplicationModule_ProvideWindowManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideWindowManagerFactory;
    }

    public static WindowManager proxyProvideWindowManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        WindowManager provideWindowManager = instance.provideWindowManager();
        $jacocoInit[5] = true;
        return provideWindowManager;
    }
}
