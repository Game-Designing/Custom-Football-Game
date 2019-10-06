package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.cache.L2Cache;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideL2CacheFactory */
public final class ApplicationModule_ProvideL2CacheFactory implements C13181b<L2Cache> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6879026728502540713L, "cm/aptoide/pt/ApplicationModule_ProvideL2CacheFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideL2CacheFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public L2Cache get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        L2Cache provideL2Cache = applicationModule.provideL2Cache();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideL2Cache, "Cannot return null from a non-@Nullable @Provides method");
        L2Cache l2Cache = provideL2Cache;
        $jacocoInit[3] = true;
        return l2Cache;
    }

    public static C13181b<L2Cache> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideL2CacheFactory applicationModule_ProvideL2CacheFactory = new ApplicationModule_ProvideL2CacheFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideL2CacheFactory;
    }

    public static L2Cache proxyProvideL2Cache(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        L2Cache provideL2Cache = instance.provideL2Cache();
        $jacocoInit[5] = true;
        return provideL2Cache;
    }
}
