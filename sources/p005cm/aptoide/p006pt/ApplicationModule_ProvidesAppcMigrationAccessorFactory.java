package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.AppcMigrationAccessor;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppcMigrationAccessorFactory */
public final class ApplicationModule_ProvidesAppcMigrationAccessorFactory implements C13181b<AppcMigrationAccessor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4646700546244202851L, "cm/aptoide/pt/ApplicationModule_ProvidesAppcMigrationAccessorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppcMigrationAccessorFactory(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        $jacocoInit[0] = true;
    }

    public AppcMigrationAccessor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        AppcMigrationAccessor providesAppcMigrationAccessor = applicationModule.providesAppcMigrationAccessor((Database) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppcMigrationAccessor, "Cannot return null from a non-@Nullable @Provides method");
        AppcMigrationAccessor appcMigrationAccessor = providesAppcMigrationAccessor;
        $jacocoInit[3] = true;
        return appcMigrationAccessor;
    }

    public static C13181b<AppcMigrationAccessor> create(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppcMigrationAccessorFactory applicationModule_ProvidesAppcMigrationAccessorFactory = new ApplicationModule_ProvidesAppcMigrationAccessorFactory(module2, databaseProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAppcMigrationAccessorFactory;
    }

    public static AppcMigrationAccessor proxyProvidesAppcMigrationAccessor(ApplicationModule instance, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        AppcMigrationAccessor providesAppcMigrationAccessor = instance.providesAppcMigrationAccessor(database);
        $jacocoInit[5] = true;
        return providesAppcMigrationAccessor;
    }
}
