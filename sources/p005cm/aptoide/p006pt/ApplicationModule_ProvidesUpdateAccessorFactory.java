package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.UpdateAccessor;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesUpdateAccessorFactory */
public final class ApplicationModule_ProvidesUpdateAccessorFactory implements C13181b<UpdateAccessor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2118258237696521557L, "cm/aptoide/pt/ApplicationModule_ProvidesUpdateAccessorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesUpdateAccessorFactory(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        $jacocoInit[0] = true;
    }

    public UpdateAccessor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        UpdateAccessor providesUpdateAccessor = applicationModule.providesUpdateAccessor((Database) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesUpdateAccessor, "Cannot return null from a non-@Nullable @Provides method");
        UpdateAccessor updateAccessor = providesUpdateAccessor;
        $jacocoInit[3] = true;
        return updateAccessor;
    }

    public static C13181b<UpdateAccessor> create(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesUpdateAccessorFactory applicationModule_ProvidesUpdateAccessorFactory = new ApplicationModule_ProvidesUpdateAccessorFactory(module2, databaseProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesUpdateAccessorFactory;
    }

    public static UpdateAccessor proxyProvidesUpdateAccessor(ApplicationModule instance, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        UpdateAccessor providesUpdateAccessor = instance.providesUpdateAccessor(database);
        $jacocoInit[5] = true;
        return providesUpdateAccessor;
    }
}
