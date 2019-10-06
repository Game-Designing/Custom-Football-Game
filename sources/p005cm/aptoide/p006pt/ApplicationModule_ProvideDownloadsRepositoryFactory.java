package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.downloadmanager.DownloadsRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideDownloadsRepositoryFactory */
public final class ApplicationModule_ProvideDownloadsRepositoryFactory implements C13181b<DownloadsRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<DownloadAccessor> downloadAccessorProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6982225604037267636L, "cm/aptoide/pt/ApplicationModule_ProvideDownloadsRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideDownloadsRepositoryFactory(ApplicationModule module2, Provider<DownloadAccessor> downloadAccessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.downloadAccessorProvider = downloadAccessorProvider2;
        $jacocoInit[0] = true;
    }

    public DownloadsRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<DownloadAccessor> provider = this.downloadAccessorProvider;
        $jacocoInit[1] = true;
        DownloadsRepository provideDownloadsRepository = applicationModule.provideDownloadsRepository((DownloadAccessor) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideDownloadsRepository, "Cannot return null from a non-@Nullable @Provides method");
        DownloadsRepository downloadsRepository = provideDownloadsRepository;
        $jacocoInit[3] = true;
        return downloadsRepository;
    }

    public static C13181b<DownloadsRepository> create(ApplicationModule module2, Provider<DownloadAccessor> downloadAccessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideDownloadsRepositoryFactory applicationModule_ProvideDownloadsRepositoryFactory = new ApplicationModule_ProvideDownloadsRepositoryFactory(module2, downloadAccessorProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideDownloadsRepositoryFactory;
    }

    public static DownloadsRepository proxyProvideDownloadsRepository(ApplicationModule instance, DownloadAccessor downloadAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadsRepository provideDownloadsRepository = instance.provideDownloadsRepository(downloadAccessor);
        $jacocoInit[5] = true;
        return provideDownloadsRepository;
    }
}
