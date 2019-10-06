package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideStoreRepositoryFactory */
public final class ApplicationModule_ProvideStoreRepositoryFactory implements C13181b<StoreRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<StoreAccessor> storeAccessorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(417070925671998056L, "cm/aptoide/pt/ApplicationModule_ProvideStoreRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideStoreRepositoryFactory(ApplicationModule module2, Provider<StoreAccessor> storeAccessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.storeAccessorProvider = storeAccessorProvider2;
        $jacocoInit[0] = true;
    }

    public StoreRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<StoreAccessor> provider = this.storeAccessorProvider;
        $jacocoInit[1] = true;
        StoreRepository provideStoreRepository = applicationModule.provideStoreRepository((StoreAccessor) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideStoreRepository, "Cannot return null from a non-@Nullable @Provides method");
        StoreRepository storeRepository = provideStoreRepository;
        $jacocoInit[3] = true;
        return storeRepository;
    }

    public static C13181b<StoreRepository> create(ApplicationModule module2, Provider<StoreAccessor> storeAccessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideStoreRepositoryFactory applicationModule_ProvideStoreRepositoryFactory = new ApplicationModule_ProvideStoreRepositoryFactory(module2, storeAccessorProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideStoreRepositoryFactory;
    }

    public static StoreRepository proxyProvideStoreRepository(ApplicationModule instance, StoreAccessor storeAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreRepository provideStoreRepository = instance.provideStoreRepository(storeAccessor);
        $jacocoInit[5] = true;
        return provideStoreRepository;
    }
}
