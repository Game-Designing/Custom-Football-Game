package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.MoreBundleManager;
import p005cm.aptoide.p006pt.home.BundlesRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesGetStoreManagerFactory */
public final class FragmentModule_ProvidesGetStoreManagerFactory implements C13181b<MoreBundleManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BundlesRepository> bundlesRepositoryProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4792549963107357915L, "cm/aptoide/pt/view/FragmentModule_ProvidesGetStoreManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesGetStoreManagerFactory(FragmentModule module2, Provider<BundlesRepository> bundlesRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.bundlesRepositoryProvider = bundlesRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public MoreBundleManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<BundlesRepository> provider = this.bundlesRepositoryProvider;
        $jacocoInit[1] = true;
        MoreBundleManager providesGetStoreManager = fragmentModule.providesGetStoreManager((BundlesRepository) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesGetStoreManager, "Cannot return null from a non-@Nullable @Provides method");
        MoreBundleManager moreBundleManager = providesGetStoreManager;
        $jacocoInit[3] = true;
        return moreBundleManager;
    }

    public static C13181b<MoreBundleManager> create(FragmentModule module2, Provider<BundlesRepository> bundlesRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesGetStoreManagerFactory fragmentModule_ProvidesGetStoreManagerFactory = new FragmentModule_ProvidesGetStoreManagerFactory(module2, bundlesRepositoryProvider2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesGetStoreManagerFactory;
    }

    public static MoreBundleManager proxyProvidesGetStoreManager(FragmentModule instance, BundlesRepository bundlesRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        MoreBundleManager providesGetStoreManager = instance.providesGetStoreManager(bundlesRepository);
        $jacocoInit[5] = true;
        return providesGetStoreManager;
    }
}
