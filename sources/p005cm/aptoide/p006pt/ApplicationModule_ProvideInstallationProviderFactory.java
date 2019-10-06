package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.install.installer.InstallationProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideInstallationProviderFactory */
public final class ApplicationModule_ProvideInstallationProviderFactory implements C13181b<InstallationProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final Provider<DownloadAccessor> downloadAccessorProvider;
    private final Provider<AptoideDownloadManager> downloadManagerProvider;
    private final Provider<InstalledRepository> installedRepositoryProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6438111646432780860L, "cm/aptoide/pt/ApplicationModule_ProvideInstallationProviderFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideInstallationProviderFactory(ApplicationModule module2, Provider<AptoideDownloadManager> downloadManagerProvider2, Provider<DownloadAccessor> downloadAccessorProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.downloadManagerProvider = downloadManagerProvider2;
        this.downloadAccessorProvider = downloadAccessorProvider2;
        this.installedRepositoryProvider = installedRepositoryProvider2;
        this.databaseProvider = databaseProvider2;
        $jacocoInit[0] = true;
    }

    public InstallationProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AptoideDownloadManager> provider = this.downloadManagerProvider;
        $jacocoInit[1] = true;
        AptoideDownloadManager aptoideDownloadManager = (AptoideDownloadManager) provider.get();
        Provider<DownloadAccessor> provider2 = this.downloadAccessorProvider;
        $jacocoInit[2] = true;
        DownloadAccessor downloadAccessor = (DownloadAccessor) provider2.get();
        Provider<InstalledRepository> provider3 = this.installedRepositoryProvider;
        $jacocoInit[3] = true;
        InstalledRepository installedRepository = (InstalledRepository) provider3.get();
        Provider<Database> provider4 = this.databaseProvider;
        $jacocoInit[4] = true;
        Database database = (Database) provider4.get();
        $jacocoInit[5] = true;
        InstallationProvider provideInstallationProvider = applicationModule.provideInstallationProvider(aptoideDownloadManager, downloadAccessor, installedRepository, database);
        $jacocoInit[6] = true;
        C13182c.m43111a(provideInstallationProvider, "Cannot return null from a non-@Nullable @Provides method");
        InstallationProvider installationProvider = provideInstallationProvider;
        $jacocoInit[7] = true;
        return installationProvider;
    }

    public static C13181b<InstallationProvider> create(ApplicationModule module2, Provider<AptoideDownloadManager> downloadManagerProvider2, Provider<DownloadAccessor> downloadAccessorProvider2, Provider<InstalledRepository> installedRepositoryProvider2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideInstallationProviderFactory applicationModule_ProvideInstallationProviderFactory = new ApplicationModule_ProvideInstallationProviderFactory(module2, downloadManagerProvider2, downloadAccessorProvider2, installedRepositoryProvider2, databaseProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvideInstallationProviderFactory;
    }

    public static InstallationProvider proxyProvideInstallationProvider(ApplicationModule instance, AptoideDownloadManager downloadManager, DownloadAccessor downloadAccessor, InstalledRepository installedRepository, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallationProvider provideInstallationProvider = instance.provideInstallationProvider(downloadManager, downloadAccessor, installedRepository, database);
        $jacocoInit[9] = true;
        return provideInstallationProvider;
    }
}
