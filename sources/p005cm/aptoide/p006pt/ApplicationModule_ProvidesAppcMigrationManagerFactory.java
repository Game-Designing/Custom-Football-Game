package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationManager;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationService;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppcMigrationManagerFactory */
public final class ApplicationModule_ProvidesAppcMigrationManagerFactory implements C13181b<AppcMigrationManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppcMigrationService> appcMigrationServiceProvider;
    private final ApplicationModule module;
    private final Provider<InstalledRepository> repositoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8958707568798992701L, "cm/aptoide/pt/ApplicationModule_ProvidesAppcMigrationManagerFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppcMigrationManagerFactory(ApplicationModule module2, Provider<InstalledRepository> repositoryProvider2, Provider<AppcMigrationService> appcMigrationServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.repositoryProvider = repositoryProvider2;
        this.appcMigrationServiceProvider = appcMigrationServiceProvider2;
        $jacocoInit[0] = true;
    }

    public AppcMigrationManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<InstalledRepository> provider = this.repositoryProvider;
        $jacocoInit[1] = true;
        InstalledRepository installedRepository = (InstalledRepository) provider.get();
        AppcMigrationService appcMigrationService = (AppcMigrationService) this.appcMigrationServiceProvider.get();
        $jacocoInit[2] = true;
        AppcMigrationManager providesAppcMigrationManager = applicationModule.providesAppcMigrationManager(installedRepository, appcMigrationService);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesAppcMigrationManager, "Cannot return null from a non-@Nullable @Provides method");
        AppcMigrationManager appcMigrationManager = providesAppcMigrationManager;
        $jacocoInit[4] = true;
        return appcMigrationManager;
    }

    public static C13181b<AppcMigrationManager> create(ApplicationModule module2, Provider<InstalledRepository> repositoryProvider2, Provider<AppcMigrationService> appcMigrationServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppcMigrationManagerFactory applicationModule_ProvidesAppcMigrationManagerFactory = new ApplicationModule_ProvidesAppcMigrationManagerFactory(module2, repositoryProvider2, appcMigrationServiceProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesAppcMigrationManagerFactory;
    }

    public static AppcMigrationManager proxyProvidesAppcMigrationManager(ApplicationModule instance, InstalledRepository repository, AppcMigrationService appcMigrationService) {
        boolean[] $jacocoInit = $jacocoInit();
        AppcMigrationManager providesAppcMigrationManager = instance.providesAppcMigrationManager(repository, appcMigrationService);
        $jacocoInit[6] = true;
        return providesAppcMigrationManager;
    }
}
