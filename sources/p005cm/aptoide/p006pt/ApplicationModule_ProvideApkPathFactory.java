package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideApkPathFactory */
public final class ApplicationModule_ProvideApkPathFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> cachePathProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8311498693361098315L, "cm/aptoide/pt/ApplicationModule_ProvideApkPathFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideApkPathFactory(ApplicationModule module2, Provider<String> cachePathProvider2) {
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
        String provideApkPath = applicationModule.provideApkPath((String) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideApkPath, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideApkPath;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2, Provider<String> cachePathProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideApkPathFactory applicationModule_ProvideApkPathFactory = new ApplicationModule_ProvideApkPathFactory(module2, cachePathProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideApkPathFactory;
    }

    public static String proxyProvideApkPath(ApplicationModule instance, String cachePath) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideApkPath = instance.provideApkPath(cachePath);
        $jacocoInit[5] = true;
        return provideApkPath;
    }
}
