package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideStoreNameFactory */
public final class ApplicationModule_ProvideStoreNameFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4340848697913057315L, "cm/aptoide/pt/ApplicationModule_ProvideStoreNameFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideStoreNameFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        String provideStoreName = applicationModule.provideStoreName();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideStoreName, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideStoreName;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideStoreNameFactory applicationModule_ProvideStoreNameFactory = new ApplicationModule_ProvideStoreNameFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideStoreNameFactory;
    }

    public static String proxyProvideStoreName(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideStoreName = instance.provideStoreName();
        $jacocoInit[5] = true;
        return provideStoreName;
    }
}
