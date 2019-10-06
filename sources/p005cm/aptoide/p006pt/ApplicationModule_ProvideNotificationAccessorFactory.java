package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.NotificationAccessor;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideNotificationAccessorFactory */
public final class ApplicationModule_ProvideNotificationAccessorFactory implements C13181b<NotificationAccessor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7043691433896810587L, "cm/aptoide/pt/ApplicationModule_ProvideNotificationAccessorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideNotificationAccessorFactory(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        $jacocoInit[0] = true;
    }

    public NotificationAccessor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        NotificationAccessor provideNotificationAccessor = applicationModule.provideNotificationAccessor((Database) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideNotificationAccessor, "Cannot return null from a non-@Nullable @Provides method");
        NotificationAccessor notificationAccessor = provideNotificationAccessor;
        $jacocoInit[3] = true;
        return notificationAccessor;
    }

    public static C13181b<NotificationAccessor> create(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideNotificationAccessorFactory applicationModule_ProvideNotificationAccessorFactory = new ApplicationModule_ProvideNotificationAccessorFactory(module2, databaseProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideNotificationAccessorFactory;
    }

    public static NotificationAccessor proxyProvideNotificationAccessor(ApplicationModule instance, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationAccessor provideNotificationAccessor = instance.provideNotificationAccessor(database);
        $jacocoInit[5] = true;
        return provideNotificationAccessor;
    }
}
