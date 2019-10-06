package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.AppValidator;
import p005cm.aptoide.p006pt.download.DownloadApkPathsProvider;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideDownloadFactoryFactory */
public final class ApplicationModule_ProvideDownloadFactoryFactory implements C13181b<DownloadFactory> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppValidator> appValidatorProvider;
    private final Provider<String> cachePathProvider;
    private final Provider<DownloadApkPathsProvider> downloadApkPathsProvider;
    private final Provider<String> marketNameProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8512801339493408142L, "cm/aptoide/pt/ApplicationModule_ProvideDownloadFactoryFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideDownloadFactoryFactory(ApplicationModule module2, Provider<String> marketNameProvider2, Provider<DownloadApkPathsProvider> downloadApkPathsProvider2, Provider<String> cachePathProvider2, Provider<AppValidator> appValidatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.marketNameProvider = marketNameProvider2;
        this.downloadApkPathsProvider = downloadApkPathsProvider2;
        this.cachePathProvider = cachePathProvider2;
        this.appValidatorProvider = appValidatorProvider2;
        $jacocoInit[0] = true;
    }

    public DownloadFactory get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<String> provider = this.marketNameProvider;
        $jacocoInit[1] = true;
        String str = (String) provider.get();
        Provider<DownloadApkPathsProvider> provider2 = this.downloadApkPathsProvider;
        $jacocoInit[2] = true;
        DownloadApkPathsProvider downloadApkPathsProvider2 = (DownloadApkPathsProvider) provider2.get();
        Provider<String> provider3 = this.cachePathProvider;
        $jacocoInit[3] = true;
        String str2 = (String) provider3.get();
        Provider<AppValidator> provider4 = this.appValidatorProvider;
        $jacocoInit[4] = true;
        AppValidator appValidator = (AppValidator) provider4.get();
        $jacocoInit[5] = true;
        DownloadFactory provideDownloadFactory = applicationModule.provideDownloadFactory(str, downloadApkPathsProvider2, str2, appValidator);
        $jacocoInit[6] = true;
        C13182c.m43111a(provideDownloadFactory, "Cannot return null from a non-@Nullable @Provides method");
        DownloadFactory downloadFactory = provideDownloadFactory;
        $jacocoInit[7] = true;
        return downloadFactory;
    }

    public static C13181b<DownloadFactory> create(ApplicationModule module2, Provider<String> marketNameProvider2, Provider<DownloadApkPathsProvider> downloadApkPathsProvider2, Provider<String> cachePathProvider2, Provider<AppValidator> appValidatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideDownloadFactoryFactory applicationModule_ProvideDownloadFactoryFactory = new ApplicationModule_ProvideDownloadFactoryFactory(module2, marketNameProvider2, downloadApkPathsProvider2, cachePathProvider2, appValidatorProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvideDownloadFactoryFactory;
    }

    public static DownloadFactory proxyProvideDownloadFactory(ApplicationModule instance, String marketName, DownloadApkPathsProvider downloadApkPathsProvider2, String cachePath, AppValidator appValidator) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadFactory provideDownloadFactory = instance.provideDownloadFactory(marketName, downloadApkPathsProvider2, cachePath, appValidator);
        $jacocoInit[9] = true;
        return provideDownloadFactory;
    }
}
