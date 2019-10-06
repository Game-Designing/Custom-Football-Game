package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.InstallationAccessor;
import p005cm.aptoide.p006pt.database.accessors.InstalledAccessor;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideInstalledAccessorFactory */
public final class ApplicationModule_ProvideInstalledAccessorFactory implements C13181b<InstalledAccessor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final Provider<InstallationAccessor> installationAccessorProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6520788402029376475L, "cm/aptoide/pt/ApplicationModule_ProvideInstalledAccessorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideInstalledAccessorFactory(ApplicationModule module2, Provider<Database> databaseProvider2, Provider<InstallationAccessor> installationAccessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        this.installationAccessorProvider = installationAccessorProvider2;
        $jacocoInit[0] = true;
    }

    public InstalledAccessor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        InstalledAccessor provideInstalledAccessor = applicationModule.provideInstalledAccessor((Database) provider.get(), (InstallationAccessor) this.installationAccessorProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideInstalledAccessor, "Cannot return null from a non-@Nullable @Provides method");
        InstalledAccessor installedAccessor = provideInstalledAccessor;
        $jacocoInit[3] = true;
        return installedAccessor;
    }

    public static C13181b<InstalledAccessor> create(ApplicationModule module2, Provider<Database> databaseProvider2, Provider<InstallationAccessor> installationAccessorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideInstalledAccessorFactory applicationModule_ProvideInstalledAccessorFactory = new ApplicationModule_ProvideInstalledAccessorFactory(module2, databaseProvider2, installationAccessorProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideInstalledAccessorFactory;
    }

    public static InstalledAccessor proxyProvideInstalledAccessor(ApplicationModule instance, Database database, InstallationAccessor installationAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        InstalledAccessor provideInstalledAccessor = instance.provideInstalledAccessor(database, installationAccessor);
        $jacocoInit[5] = true;
        return provideInstalledAccessor;
    }
}
