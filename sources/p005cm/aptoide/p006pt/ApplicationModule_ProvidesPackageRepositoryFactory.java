package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesPackageRepositoryFactory */
public final class ApplicationModule_ProvidesPackageRepositoryFactory implements C13181b<PackageRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(406205279263178585L, "cm/aptoide/pt/ApplicationModule_ProvidesPackageRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesPackageRepositoryFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public PackageRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        PackageRepository providesPackageRepository = applicationModule.providesPackageRepository();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesPackageRepository, "Cannot return null from a non-@Nullable @Provides method");
        PackageRepository packageRepository = providesPackageRepository;
        $jacocoInit[3] = true;
        return packageRepository;
    }

    public static C13181b<PackageRepository> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesPackageRepositoryFactory applicationModule_ProvidesPackageRepositoryFactory = new ApplicationModule_ProvidesPackageRepositoryFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesPackageRepositoryFactory;
    }

    public static PackageRepository proxyProvidesPackageRepository(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        PackageRepository providesPackageRepository = instance.providesPackageRepository();
        $jacocoInit[5] = true;
        return providesPackageRepository;
    }
}
