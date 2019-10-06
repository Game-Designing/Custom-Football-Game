package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideImageCachePatchFactory */
public final class ApplicationModule_ProvideImageCachePatchFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> cachePathProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1046164578988358078L, "cm/aptoide/pt/ApplicationModule_ProvideImageCachePatchFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideImageCachePatchFactory(ApplicationModule module2, Provider<String> cachePathProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.cachePathProvider = cachePathProvider2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<String> provider = this.cachePathProvider;
        $jacocoInit[1] = true;
        String provideImageCachePatch = applicationModule.provideImageCachePatch((String) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideImageCachePatch, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideImageCachePatch;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2, Provider<String> cachePathProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideImageCachePatchFactory applicationModule_ProvideImageCachePatchFactory = new ApplicationModule_ProvideImageCachePatchFactory(module2, cachePathProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideImageCachePatchFactory;
    }

    public static String proxyProvideImageCachePatch(ApplicationModule instance, String cachePath) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideImageCachePatch = instance.provideImageCachePatch(cachePath);
        $jacocoInit[5] = true;
        return provideImageCachePatch;
    }
}
