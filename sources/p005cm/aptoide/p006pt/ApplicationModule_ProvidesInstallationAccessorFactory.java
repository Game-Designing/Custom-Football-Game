package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.InstallationAccessor;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesInstallationAccessorFactory */
public final class ApplicationModule_ProvidesInstallationAccessorFactory implements C13181b<InstallationAccessor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5504775359074787607L, "cm/aptoide/pt/ApplicationModule_ProvidesInstallationAccessorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesInstallationAccessorFactory(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        $jacocoInit[0] = true;
    }

    public InstallationAccessor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        InstallationAccessor providesInstallationAccessor = applicationModule.providesInstallationAccessor((Database) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesInstallationAccessor, "Cannot return null from a non-@Nullable @Provides method");
        InstallationAccessor installationAccessor = providesInstallationAccessor;
        $jacocoInit[3] = true;
        return installationAccessor;
    }

    public static C13181b<InstallationAccessor> create(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesInstallationAccessorFactory applicationModule_ProvidesInstallationAccessorFactory = new ApplicationModule_ProvidesInstallationAccessorFactory(module2, databaseProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesInstallationAccessorFactory;
    }

    public static InstallationAccessor proxyProvidesInstallationAccessor(ApplicationModule instance, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallationAccessor providesInstallationAccessor = instance.providesInstallationAccessor(database);
        $jacocoInit[5] = true;
        return providesInstallationAccessor;
    }
}
