package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.notification.sync.LocalNotificationSyncManager;
import p005cm.aptoide.p006pt.sync.SyncScheduler;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesLocalNotificationSyncManagerFactory */
public final class ApplicationModule_ProvidesLocalNotificationSyncManagerFactory implements C13181b<LocalNotificationSyncManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<NotificationProvider> providerProvider;
    private final Provider<SyncScheduler> syncSchedulerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2496813456647063016L, "cm/aptoide/pt/ApplicationModule_ProvidesLocalNotificationSyncManagerFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesLocalNotificationSyncManagerFactory(ApplicationModule module2, Provider<SyncScheduler> syncSchedulerProvider2, Provider<NotificationProvider> providerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.syncSchedulerProvider = syncSchedulerProvider2;
        this.providerProvider = providerProvider2;
        $jacocoInit[0] = true;
    }

    public LocalNotificationSyncManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SyncScheduler> provider = this.syncSchedulerProvider;
        $jacocoInit[1] = true;
        SyncScheduler syncScheduler = (SyncScheduler) provider.get();
        NotificationProvider notificationProvider = (NotificationProvider) this.providerProvider.get();
        $jacocoInit[2] = true;
        LocalNotificationSyncManager providesLocalNotificationSyncManager = applicationModule.providesLocalNotificationSyncManager(syncScheduler, notificationProvider);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesLocalNotificationSyncManager, "Cannot return null from a non-@Nullable @Provides method");
        LocalNotificationSyncManager localNotificationSyncManager = providesLocalNotificationSyncManager;
        $jacocoInit[4] = true;
        return localNotificationSyncManager;
    }

    public static C13181b<LocalNotificationSyncManager> create(ApplicationModule module2, Provider<SyncScheduler> syncSchedulerProvider2, Provider<NotificationProvider> providerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesLocalNotificationSyncManagerFactory applicationModule_ProvidesLocalNotificationSyncManagerFactory = new ApplicationModule_ProvidesLocalNotificationSyncManagerFactory(module2, syncSchedulerProvider2, providerProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesLocalNotificationSyncManagerFactory;
    }

    public static LocalNotificationSyncManager proxyProvidesLocalNotificationSyncManager(ApplicationModule instance, SyncScheduler syncScheduler, NotificationProvider provider) {
        boolean[] $jacocoInit = $jacocoInit();
        LocalNotificationSyncManager providesLocalNotificationSyncManager = instance.providesLocalNotificationSyncManager(syncScheduler, provider);
        $jacocoInit[6] = true;
        return providesLocalNotificationSyncManager;
    }
}
