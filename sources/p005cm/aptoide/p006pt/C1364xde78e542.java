package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.notification.RealmLocalNotificationSyncPersistence;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesRealmLocalNotificationSyncPersistenceFactory */
public final class C1364xde78e542 implements C13181b<RealmLocalNotificationSyncPersistence> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final ApplicationModule module;
    private final Provider<NotificationProvider> providerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4116660064925128878L, "cm/aptoide/pt/ApplicationModule_ProvidesRealmLocalNotificationSyncPersistenceFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public C1364xde78e542(ApplicationModule module2, Provider<Database> databaseProvider2, Provider<NotificationProvider> providerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        this.providerProvider = providerProvider2;
        $jacocoInit[0] = true;
    }

    public RealmLocalNotificationSyncPersistence get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        Database database = (Database) provider.get();
        NotificationProvider notificationProvider = (NotificationProvider) this.providerProvider.get();
        $jacocoInit[2] = true;
        RealmLocalNotificationSyncPersistence providesRealmLocalNotificationSyncPersistence = applicationModule.providesRealmLocalNotificationSyncPersistence(database, notificationProvider);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesRealmLocalNotificationSyncPersistence, "Cannot return null from a non-@Nullable @Provides method");
        RealmLocalNotificationSyncPersistence realmLocalNotificationSyncPersistence = providesRealmLocalNotificationSyncPersistence;
        $jacocoInit[4] = true;
        return realmLocalNotificationSyncPersistence;
    }

    public static C13181b<RealmLocalNotificationSyncPersistence> create(ApplicationModule module2, Provider<Database> databaseProvider2, Provider<NotificationProvider> providerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        C1364xde78e542 applicationModule_ProvidesRealmLocalNotificationSyncPersistenceFactory = new C1364xde78e542(module2, databaseProvider2, providerProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesRealmLocalNotificationSyncPersistenceFactory;
    }

    public static RealmLocalNotificationSyncPersistence proxyProvidesRealmLocalNotificationSyncPersistence(ApplicationModule instance, Database database, NotificationProvider provider) {
        boolean[] $jacocoInit = $jacocoInit();
        RealmLocalNotificationSyncPersistence providesRealmLocalNotificationSyncPersistence = instance.providesRealmLocalNotificationSyncPersistence(database, provider);
        $jacocoInit[6] = true;
        return providesRealmLocalNotificationSyncPersistence;
    }
}
