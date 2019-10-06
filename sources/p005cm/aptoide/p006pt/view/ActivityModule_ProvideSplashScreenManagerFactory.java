package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideSplashScreenManagerFactory */
public final class ActivityModule_ProvideSplashScreenManagerFactory implements C13181b<SplashScreenManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7578455141608415307L, "cm/aptoide/pt/view/ActivityModule_ProvideSplashScreenManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideSplashScreenManagerFactory(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public SplashScreenManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        $jacocoInit[1] = true;
        SplashScreenManager provideSplashScreenManager = activityModule.provideSplashScreenManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideSplashScreenManager, "Cannot return null from a non-@Nullable @Provides method");
        SplashScreenManager splashScreenManager = provideSplashScreenManager;
        $jacocoInit[3] = true;
        return splashScreenManager;
    }

    public static C13181b<SplashScreenManager> create(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideSplashScreenManagerFactory activityModule_ProvideSplashScreenManagerFactory = new ActivityModule_ProvideSplashScreenManagerFactory(module2);
        $jacocoInit[4] = true;
        return activityModule_ProvideSplashScreenManagerFactory;
    }

    public static SplashScreenManager proxyProvideSplashScreenManager(ActivityModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        SplashScreenManager provideSplashScreenManager = instance.provideSplashScreenManager();
        $jacocoInit[5] = true;
        return provideSplashScreenManager;
    }
}
