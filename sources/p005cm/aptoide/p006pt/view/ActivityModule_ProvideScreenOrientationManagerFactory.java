package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideScreenOrientationManagerFactory */
public final class ActivityModule_ProvideScreenOrientationManagerFactory implements C13181b<ScreenOrientationManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4447300377590385230L, "cm/aptoide/pt/view/ActivityModule_ProvideScreenOrientationManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideScreenOrientationManagerFactory(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public ScreenOrientationManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        $jacocoInit[1] = true;
        ScreenOrientationManager provideScreenOrientationManager = activityModule.provideScreenOrientationManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideScreenOrientationManager, "Cannot return null from a non-@Nullable @Provides method");
        ScreenOrientationManager screenOrientationManager = provideScreenOrientationManager;
        $jacocoInit[3] = true;
        return screenOrientationManager;
    }

    public static C13181b<ScreenOrientationManager> create(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideScreenOrientationManagerFactory activityModule_ProvideScreenOrientationManagerFactory = new ActivityModule_ProvideScreenOrientationManagerFactory(module2);
        $jacocoInit[4] = true;
        return activityModule_ProvideScreenOrientationManagerFactory;
    }

    public static ScreenOrientationManager proxyProvideScreenOrientationManager(ActivityModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        ScreenOrientationManager provideScreenOrientationManager = instance.provideScreenOrientationManager();
        $jacocoInit[5] = true;
        return provideScreenOrientationManager;
    }
}
