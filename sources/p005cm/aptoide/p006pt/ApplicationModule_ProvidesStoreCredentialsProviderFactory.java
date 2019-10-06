package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesStoreCredentialsProviderFactory */
public final class ApplicationModule_ProvidesStoreCredentialsProviderFactory implements C13181b<StoreCredentialsProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<StoreAccessor> storeAccessorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1083695173117897963L, "cm/aptoide/pt/ApplicationModule_ProvidesStoreCredentialsProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesStoreCredentialsProviderFactory(ApplicationModule module2, Provider<StoreAccessor> storeAccessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.storeAccessorProvider = storeAccessorProvider2;
        $jacocoInit[0] = true;
    }

    public StoreCredentialsProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<StoreAccessor> provider = this.storeAccessorProvider;
        $jacocoInit[1] = true;
        StoreCredentialsProvider providesStoreCredentialsProvider = applicationModule.providesStoreCredentialsProvider((StoreAccessor) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesStoreCredentialsProvider, "Cannot return null from a non-@Nullable @Provides method");
        StoreCredentialsProvider storeCredentialsProvider = providesStoreCredentialsProvider;
        $jacocoInit[3] = true;
        return storeCredentialsProvider;
    }

    public static C13181b<StoreCredentialsProvider> create(ApplicationModule module2, Provider<StoreAccessor> storeAccessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesStoreCredentialsProviderFactory applicationModule_ProvidesStoreCredentialsProviderFactory = new ApplicationModule_ProvidesStoreCredentialsProviderFactory(module2, storeAccessorProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesStoreCredentialsProviderFactory;
    }

    public static StoreCredentialsProvider proxyProvidesStoreCredentialsProvider(ApplicationModule instance, StoreAccessor storeAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentialsProvider providesStoreCredentialsProvider = instance.providesStoreCredentialsProvider(storeAccessor);
        $jacocoInit[5] = true;
        return providesStoreCredentialsProvider;
    }
}
