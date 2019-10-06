package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.DownloadApkPathsProvider;
import p005cm.aptoide.p006pt.download.OemidProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_DownloadApkPathsProviderFactory */
public final class ApplicationModule_DownloadApkPathsProviderFactory implements C13181b<DownloadApkPathsProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<OemidProvider> oemidProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7687588860857620378L, "cm/aptoide/pt/ApplicationModule_DownloadApkPathsProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_DownloadApkPathsProviderFactory(ApplicationModule module2, Provider<OemidProvider> oemidProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.oemidProvider = oemidProvider2;
        $jacocoInit[0] = true;
    }

    public DownloadApkPathsProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<OemidProvider> provider = this.oemidProvider;
        $jacocoInit[1] = true;
        DownloadApkPathsProvider downloadApkPathsProvider = applicationModule.downloadApkPathsProvider((OemidProvider) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(downloadApkPathsProvider, "Cannot return null from a non-@Nullable @Provides method");
        DownloadApkPathsProvider downloadApkPathsProvider2 = downloadApkPathsProvider;
        $jacocoInit[3] = true;
        return downloadApkPathsProvider2;
    }

    public static C13181b<DownloadApkPathsProvider> create(ApplicationModule module2, Provider<OemidProvider> oemidProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_DownloadApkPathsProviderFactory applicationModule_DownloadApkPathsProviderFactory = new ApplicationModule_DownloadApkPathsProviderFactory(module2, oemidProvider2);
        $jacocoInit[4] = true;
        return applicationModule_DownloadApkPathsProviderFactory;
    }

    public static DownloadApkPathsProvider proxyDownloadApkPathsProvider(ApplicationModule instance, OemidProvider oemidProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadApkPathsProvider downloadApkPathsProvider = instance.downloadApkPathsProvider(oemidProvider2);
        $jacocoInit[5] = true;
        return downloadApkPathsProvider;
    }
}
