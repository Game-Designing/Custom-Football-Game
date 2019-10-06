package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideCachePathFactory */
public final class ApplicationModule_ProvideCachePathFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4256652816497506549L, "cm/aptoide/pt/ApplicationModule_ProvideCachePathFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideCachePathFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        String provideCachePath = applicationModule.provideCachePath();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideCachePath, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideCachePath;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideCachePathFactory applicationModule_ProvideCachePathFactory = new ApplicationModule_ProvideCachePathFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideCachePathFactory;
    }

    public static String proxyProvideCachePath(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideCachePath = instance.provideCachePath();
        $jacocoInit[5] = true;
        return provideCachePath;
    }
}
