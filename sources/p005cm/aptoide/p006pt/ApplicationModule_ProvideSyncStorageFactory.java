package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.RealmLocalNotificationSyncPersistence;
import p005cm.aptoide.p006pt.sync.alarm.SyncStorage;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideSyncStorageFactory */
public final class ApplicationModule_ProvideSyncStorageFactory implements C13181b<SyncStorage> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<RealmLocalNotificationSyncPersistence> persistenceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4412354331003514723L, "cm/aptoide/pt/ApplicationModule_ProvideSyncStorageFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideSyncStorageFactory(ApplicationModule module2, Provider<RealmLocalNotificationSyncPersistence> persistenceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.persistenceProvider = persistenceProvider2;
        $jacocoInit[0] = true;
    }

    public SyncStorage get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<RealmLocalNotificationSyncPersistence> provider = this.persistenceProvider;
        $jacocoInit[1] = true;
        SyncStorage provideSyncStorage = applicationModule.provideSyncStorage((RealmLocalNotificationSyncPersistence) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideSyncStorage, "Cannot return null from a non-@Nullable @Provides method");
        SyncStorage syncStorage = provideSyncStorage;
        $jacocoInit[3] = true;
        return syncStorage;
    }

    public static C13181b<SyncStorage> create(ApplicationModule module2, Provider<RealmLocalNotificationSyncPersistence> persistenceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideSyncStorageFactory applicationModule_ProvideSyncStorageFactory = new ApplicationModule_ProvideSyncStorageFactory(module2, persistenceProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideSyncStorageFactory;
    }

    public static SyncStorage proxyProvideSyncStorage(ApplicationModule instance, RealmLocalNotificationSyncPersistence persistence) {
        boolean[] $jacocoInit = $jacocoInit();
        SyncStorage provideSyncStorage = instance.provideSyncStorage(persistence);
        $jacocoInit[5] = true;
        return provideSyncStorage;
    }
}
