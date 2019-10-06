package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.BundleDataSource;
import p005cm.aptoide.p006pt.home.BundlesRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesBundleRepositoryFactory */
public final class ApplicationModule_ProvidesBundleRepositoryFactory implements C13181b<BundlesRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<BundleDataSource> remoteBundleDataSourceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7675709192463242760L, "cm/aptoide/pt/ApplicationModule_ProvidesBundleRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesBundleRepositoryFactory(ApplicationModule module2, Provider<BundleDataSource> remoteBundleDataSourceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.remoteBundleDataSourceProvider = remoteBundleDataSourceProvider2;
        $jacocoInit[0] = true;
    }

    public BundlesRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<BundleDataSource> provider = this.remoteBundleDataSourceProvider;
        $jacocoInit[1] = true;
        BundlesRepository providesBundleRepository = applicationModule.providesBundleRepository((BundleDataSource) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesBundleRepository, "Cannot return null from a non-@Nullable @Provides method");
        BundlesRepository bundlesRepository = providesBundleRepository;
        $jacocoInit[3] = true;
        return bundlesRepository;
    }

    public static C13181b<BundlesRepository> create(ApplicationModule module2, Provider<BundleDataSource> remoteBundleDataSourceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesBundleRepositoryFactory applicationModule_ProvidesBundleRepositoryFactory = new ApplicationModule_ProvidesBundleRepositoryFactory(module2, remoteBundleDataSourceProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesBundleRepositoryFactory;
    }

    public static BundlesRepository proxyProvidesBundleRepository(ApplicationModule instance, BundleDataSource remoteBundleDataSource) {
        boolean[] $jacocoInit = $jacocoInit();
        BundlesRepository providesBundleRepository = instance.providesBundleRepository(remoteBundleDataSource);
        $jacocoInit[5] = true;
        return providesBundleRepository;
    }
}
