package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.BannerRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesBannerRepositoryFactory */
public final class ApplicationModule_ProvidesBannerRepositoryFactory implements C13181b<BannerRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7355327104819584671L, "cm/aptoide/pt/ApplicationModule_ProvidesBannerRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesBannerRepositoryFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public BannerRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        BannerRepository providesBannerRepository = applicationModule.providesBannerRepository();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesBannerRepository, "Cannot return null from a non-@Nullable @Provides method");
        BannerRepository bannerRepository = providesBannerRepository;
        $jacocoInit[3] = true;
        return bannerRepository;
    }

    public static C13181b<BannerRepository> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesBannerRepositoryFactory applicationModule_ProvidesBannerRepositoryFactory = new ApplicationModule_ProvidesBannerRepositoryFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesBannerRepositoryFactory;
    }

    public static BannerRepository proxyProvidesBannerRepository(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        BannerRepository providesBannerRepository = instance.providesBannerRepository();
        $jacocoInit[5] = true;
        return providesBannerRepository;
    }
}
