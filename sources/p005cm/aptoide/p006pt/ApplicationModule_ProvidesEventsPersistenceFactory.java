package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.EventsPersistence;
import p005cm.aptoide.p006pt.analytics.analytics.RealmEventMapper;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesEventsPersistenceFactory */
public final class ApplicationModule_ProvidesEventsPersistenceFactory implements C13181b<EventsPersistence> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final Provider<RealmEventMapper> mapperProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7204363390647372825L, "cm/aptoide/pt/ApplicationModule_ProvidesEventsPersistenceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesEventsPersistenceFactory(ApplicationModule module2, Provider<Database> databaseProvider2, Provider<RealmEventMapper> mapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        this.mapperProvider = mapperProvider2;
        $jacocoInit[0] = true;
    }

    public EventsPersistence get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        EventsPersistence providesEventsPersistence = applicationModule.providesEventsPersistence((Database) provider.get(), (RealmEventMapper) this.mapperProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesEventsPersistence, "Cannot return null from a non-@Nullable @Provides method");
        EventsPersistence eventsPersistence = providesEventsPersistence;
        $jacocoInit[3] = true;
        return eventsPersistence;
    }

    public static C13181b<EventsPersistence> create(ApplicationModule module2, Provider<Database> databaseProvider2, Provider<RealmEventMapper> mapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesEventsPersistenceFactory applicationModule_ProvidesEventsPersistenceFactory = new ApplicationModule_ProvidesEventsPersistenceFactory(module2, databaseProvider2, mapperProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesEventsPersistenceFactory;
    }

    public static EventsPersistence proxyProvidesEventsPersistence(ApplicationModule instance, Database database, RealmEventMapper mapper) {
        boolean[] $jacocoInit = $jacocoInit();
        EventsPersistence providesEventsPersistence = instance.providesEventsPersistence(database, mapper);
        $jacocoInit[5] = true;
        return providesEventsPersistence;
    }
}
