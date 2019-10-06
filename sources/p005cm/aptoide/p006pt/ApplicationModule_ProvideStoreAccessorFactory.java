package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideStoreAccessorFactory */
public final class ApplicationModule_ProvideStoreAccessorFactory implements C13181b<StoreAccessor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6184256330193738527L, "cm/aptoide/pt/ApplicationModule_ProvideStoreAccessorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideStoreAccessorFactory(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        $jacocoInit[0] = true;
    }

    public StoreAccessor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        StoreAccessor provideStoreAccessor = applicationModule.provideStoreAccessor((Database) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideStoreAccessor, "Cannot return null from a non-@Nullable @Provides method");
        StoreAccessor storeAccessor = provideStoreAccessor;
        $jacocoInit[3] = true;
        return storeAccessor;
    }

    public static C13181b<StoreAccessor> create(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideStoreAccessorFactory applicationModule_ProvideStoreAccessorFactory = new ApplicationModule_ProvideStoreAccessorFactory(module2, databaseProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideStoreAccessorFactory;
    }

    public static StoreAccessor proxyProvideStoreAccessor(ApplicationModule instance, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreAccessor provideStoreAccessor = instance.provideStoreAccessor(database);
        $jacocoInit[5] = true;
        return provideStoreAccessor;
    }
}
