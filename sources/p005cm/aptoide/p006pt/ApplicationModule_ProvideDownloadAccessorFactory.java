package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideDownloadAccessorFactory */
public final class ApplicationModule_ProvideDownloadAccessorFactory implements C13181b<DownloadAccessor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1607117835714282715L, "cm/aptoide/pt/ApplicationModule_ProvideDownloadAccessorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideDownloadAccessorFactory(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        $jacocoInit[0] = true;
    }

    public DownloadAccessor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        DownloadAccessor provideDownloadAccessor = applicationModule.provideDownloadAccessor((Database) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideDownloadAccessor, "Cannot return null from a non-@Nullable @Provides method");
        DownloadAccessor downloadAccessor = provideDownloadAccessor;
        $jacocoInit[3] = true;
        return downloadAccessor;
    }

    public static C13181b<DownloadAccessor> create(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideDownloadAccessorFactory applicationModule_ProvideDownloadAccessorFactory = new ApplicationModule_ProvideDownloadAccessorFactory(module2, databaseProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideDownloadAccessorFactory;
    }

    public static DownloadAccessor proxyProvideDownloadAccessor(ApplicationModule instance, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAccessor provideDownloadAccessor = instance.provideDownloadAccessor(database);
        $jacocoInit[5] = true;
        return provideDownloadAccessor;
    }
}
