package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationService;
import p005cm.aptoide.p006pt.database.accessors.AppcMigrationAccessor;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppcMigrationServiceFactory */
public final class ApplicationModule_ProvidesAppcMigrationServiceFactory implements C13181b<AppcMigrationService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppcMigrationAccessor> accessorProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1063357057187556366L, "cm/aptoide/pt/ApplicationModule_ProvidesAppcMigrationServiceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppcMigrationServiceFactory(ApplicationModule module2, Provider<AppcMigrationAccessor> accessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.accessorProvider = accessorProvider2;
        $jacocoInit[0] = true;
    }

    public AppcMigrationService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AppcMigrationAccessor> provider = this.accessorProvider;
        $jacocoInit[1] = true;
        AppcMigrationService providesAppcMigrationService = applicationModule.providesAppcMigrationService((AppcMigrationAccessor) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppcMigrationService, "Cannot return null from a non-@Nullable @Provides method");
        AppcMigrationService appcMigrationService = providesAppcMigrationService;
        $jacocoInit[3] = true;
        return appcMigrationService;
    }

    public static C13181b<AppcMigrationService> create(ApplicationModule module2, Provider<AppcMigrationAccessor> accessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppcMigrationServiceFactory applicationModule_ProvidesAppcMigrationServiceFactory = new ApplicationModule_ProvidesAppcMigrationServiceFactory(module2, accessorProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAppcMigrationServiceFactory;
    }

    public static AppcMigrationService proxyProvidesAppcMigrationService(ApplicationModule instance, AppcMigrationAccessor accessor) {
        boolean[] $jacocoInit = $jacocoInit();
        AppcMigrationService providesAppcMigrationService = instance.providesAppcMigrationService(accessor);
        $jacocoInit[5] = true;
        return providesAppcMigrationService;
    }
}
