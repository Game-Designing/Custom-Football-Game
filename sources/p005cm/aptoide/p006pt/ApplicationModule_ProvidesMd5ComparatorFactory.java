package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.Md5Comparator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesMd5ComparatorFactory */
public final class ApplicationModule_ProvidesMd5ComparatorFactory implements C13181b<Md5Comparator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> cachePathProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7155717837893456958L, "cm/aptoide/pt/ApplicationModule_ProvidesMd5ComparatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesMd5ComparatorFactory(ApplicationModule module2, Provider<String> cachePathProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.cachePathProvider = cachePathProvider2;
        $jacocoInit[0] = true;
    }

    public Md5Comparator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<String> provider = this.cachePathProvider;
        $jacocoInit[1] = true;
        Md5Comparator providesMd5Comparator = applicationModule.providesMd5Comparator((String) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesMd5Comparator, "Cannot return null from a non-@Nullable @Provides method");
        Md5Comparator md5Comparator = providesMd5Comparator;
        $jacocoInit[3] = true;
        return md5Comparator;
    }

    public static C13181b<Md5Comparator> create(ApplicationModule module2, Provider<String> cachePathProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesMd5ComparatorFactory applicationModule_ProvidesMd5ComparatorFactory = new ApplicationModule_ProvidesMd5ComparatorFactory(module2, cachePathProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesMd5ComparatorFactory;
    }

    public static Md5Comparator proxyProvidesMd5Comparator(ApplicationModule instance, String cachePath) {
        boolean[] $jacocoInit = $jacocoInit();
        Md5Comparator providesMd5Comparator = instance.providesMd5Comparator(cachePath);
        $jacocoInit[5] = true;
        return providesMd5Comparator;
    }
}
