package p005cm.aptoide.p006pt.view;

import android.support.p000v4.app.C0486t;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideFragmentManagerFactory */
public final class ActivityModule_ProvideFragmentManagerFactory implements C13181b<C0486t> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7123603541721342903L, "cm/aptoide/pt/view/ActivityModule_ProvideFragmentManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideFragmentManagerFactory(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public C0486t get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        $jacocoInit[1] = true;
        C0486t provideFragmentManager = activityModule.provideFragmentManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideFragmentManager, "Cannot return null from a non-@Nullable @Provides method");
        C0486t tVar = provideFragmentManager;
        $jacocoInit[3] = true;
        return tVar;
    }

    public static C13181b<C0486t> create(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideFragmentManagerFactory activityModule_ProvideFragmentManagerFactory = new ActivityModule_ProvideFragmentManagerFactory(module2);
        $jacocoInit[4] = true;
        return activityModule_ProvideFragmentManagerFactory;
    }

    public static C0486t proxyProvideFragmentManager(ActivityModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        C0486t provideFragmentManager = instance.provideFragmentManager();
        $jacocoInit[5] = true;
        return provideFragmentManager;
    }
}
