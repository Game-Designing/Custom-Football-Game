package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAdsApplicationVersionCodeProviderFactory */
public final class C1363x234ee129 implements C13181b<AdsApplicationVersionCodeProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<PackageRepository> packageRepositoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5856764374364025533L, "cm/aptoide/pt/ApplicationModule_ProvidesAdsApplicationVersionCodeProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public C1363x234ee129(ApplicationModule module2, Provider<PackageRepository> packageRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.packageRepositoryProvider = packageRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public AdsApplicationVersionCodeProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<PackageRepository> provider = this.packageRepositoryProvider;
        $jacocoInit[1] = true;
        AdsApplicationVersionCodeProvider providesAdsApplicationVersionCodeProvider = applicationModule.providesAdsApplicationVersionCodeProvider((PackageRepository) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAdsApplicationVersionCodeProvider, "Cannot return null from a non-@Nullable @Provides method");
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = providesAdsApplicationVersionCodeProvider;
        $jacocoInit[3] = true;
        return adsApplicationVersionCodeProvider;
    }

    public static C13181b<AdsApplicationVersionCodeProvider> create(ApplicationModule module2, Provider<PackageRepository> packageRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        C1363x234ee129 applicationModule_ProvidesAdsApplicationVersionCodeProviderFactory = new C1363x234ee129(module2, packageRepositoryProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAdsApplicationVersionCodeProviderFactory;
    }

    public static AdsApplicationVersionCodeProvider proxyProvidesAdsApplicationVersionCodeProvider(ApplicationModule instance, PackageRepository packageRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        AdsApplicationVersionCodeProvider providesAdsApplicationVersionCodeProvider = instance.providesAdsApplicationVersionCodeProvider(packageRepository);
        $jacocoInit[5] = true;
        return providesAdsApplicationVersionCodeProvider;
    }
}
