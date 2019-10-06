package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesDefaultSharedPerefencesFactory */
public final class ApplicationModule_ProvidesDefaultSharedPerefencesFactory implements C13181b<SharedPreferences> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1897134189881772733L, "cm/aptoide/pt/ApplicationModule_ProvidesDefaultSharedPerefencesFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesDefaultSharedPerefencesFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public SharedPreferences get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        SharedPreferences providesDefaultSharedPerefences = applicationModule.providesDefaultSharedPerefences();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesDefaultSharedPerefences, "Cannot return null from a non-@Nullable @Provides method");
        SharedPreferences sharedPreferences = providesDefaultSharedPerefences;
        $jacocoInit[3] = true;
        return sharedPreferences;
    }

    public static C13181b<SharedPreferences> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesDefaultSharedPerefencesFactory applicationModule_ProvidesDefaultSharedPerefencesFactory = new ApplicationModule_ProvidesDefaultSharedPerefencesFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesDefaultSharedPerefencesFactory;
    }

    public static SharedPreferences proxyProvidesDefaultSharedPerefences(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        SharedPreferences providesDefaultSharedPerefences = instance.providesDefaultSharedPerefences();
        $jacocoInit[5] = true;
        return providesDefaultSharedPerefences;
    }
}
