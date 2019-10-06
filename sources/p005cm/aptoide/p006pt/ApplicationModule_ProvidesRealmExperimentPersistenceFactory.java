package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.RealmExperimentPersistence;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesRealmExperimentPersistenceFactory */
public final class ApplicationModule_ProvidesRealmExperimentPersistenceFactory implements C13181b<RealmExperimentPersistence> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3977825915872797410L, "cm/aptoide/pt/ApplicationModule_ProvidesRealmExperimentPersistenceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesRealmExperimentPersistenceFactory(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        $jacocoInit[0] = true;
    }

    public RealmExperimentPersistence get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        RealmExperimentPersistence providesRealmExperimentPersistence = applicationModule.providesRealmExperimentPersistence((Database) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesRealmExperimentPersistence, "Cannot return null from a non-@Nullable @Provides method");
        RealmExperimentPersistence realmExperimentPersistence = providesRealmExperimentPersistence;
        $jacocoInit[3] = true;
        return realmExperimentPersistence;
    }

    public static C13181b<RealmExperimentPersistence> create(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesRealmExperimentPersistenceFactory applicationModule_ProvidesRealmExperimentPersistenceFactory = new ApplicationModule_ProvidesRealmExperimentPersistenceFactory(module2, databaseProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesRealmExperimentPersistenceFactory;
    }

    public static RealmExperimentPersistence proxyProvidesRealmExperimentPersistence(ApplicationModule instance, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        RealmExperimentPersistence providesRealmExperimentPersistence = instance.providesRealmExperimentPersistence(database);
        $jacocoInit[5] = true;
        return providesRealmExperimentPersistence;
    }
}
