package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.InstalledAccessor;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideInstalledRepositoryFactory */
public final class ApplicationModule_ProvideInstalledRepositoryFactory implements C13181b<InstalledRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<InstalledAccessor> installedAccessorProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3535424267902741715L, "cm/aptoide/pt/ApplicationModule_ProvideInstalledRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideInstalledRepositoryFactory(ApplicationModule module2, Provider<InstalledAccessor> installedAccessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.installedAccessorProvider = installedAccessorProvider2;
        $jacocoInit[0] = true;
    }

    public InstalledRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<InstalledAccessor> provider = this.installedAccessorProvider;
        $jacocoInit[1] = true;
        InstalledRepository provideInstalledRepository = applicationModule.provideInstalledRepository((InstalledAccessor) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideInstalledRepository, "Cannot return null from a non-@Nullable @Provides method");
        InstalledRepository installedRepository = provideInstalledRepository;
        $jacocoInit[3] = true;
        return installedRepository;
    }

    public static C13181b<InstalledRepository> create(ApplicationModule module2, Provider<InstalledAccessor> installedAccessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideInstalledRepositoryFactory applicationModule_ProvideInstalledRepositoryFactory = new ApplicationModule_ProvideInstalledRepositoryFactory(module2, installedAccessorProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideInstalledRepositoryFactory;
    }

    public static InstalledRepository proxyProvideInstalledRepository(ApplicationModule instance, InstalledAccessor installedAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        InstalledRepository provideInstalledRepository = instance.provideInstalledRepository(installedAccessor);
        $jacocoInit[5] = true;
        return provideInstalledRepository;
    }
}
