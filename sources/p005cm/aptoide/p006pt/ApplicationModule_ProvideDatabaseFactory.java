package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideDatabaseFactory */
public final class ApplicationModule_ProvideDatabaseFactory implements C13181b<Database> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1172201173918892775L, "cm/aptoide/pt/ApplicationModule_ProvideDatabaseFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideDatabaseFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public Database get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        Database provideDatabase = applicationModule.provideDatabase();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideDatabase, "Cannot return null from a non-@Nullable @Provides method");
        Database database = provideDatabase;
        $jacocoInit[3] = true;
        return database;
    }

    public static C13181b<Database> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideDatabaseFactory applicationModule_ProvideDatabaseFactory = new ApplicationModule_ProvideDatabaseFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideDatabaseFactory;
    }

    public static Database proxyProvideDatabase(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Database provideDatabase = instance.provideDatabase();
        $jacocoInit[5] = true;
        return provideDatabase;
    }
}
