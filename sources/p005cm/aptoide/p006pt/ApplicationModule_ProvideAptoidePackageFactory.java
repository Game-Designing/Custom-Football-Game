package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAptoidePackageFactory */
public final class ApplicationModule_ProvideAptoidePackageFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7873530388703421632L, "cm/aptoide/pt/ApplicationModule_ProvideAptoidePackageFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAptoidePackageFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        String provideAptoidePackage = applicationModule.provideAptoidePackage();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAptoidePackage, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideAptoidePackage;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAptoidePackageFactory applicationModule_ProvideAptoidePackageFactory = new ApplicationModule_ProvideAptoidePackageFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideAptoidePackageFactory;
    }

    public static String proxyProvideAptoidePackage(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideAptoidePackage = instance.provideAptoidePackage();
        $jacocoInit[5] = true;
        return provideAptoidePackage;
    }
}
