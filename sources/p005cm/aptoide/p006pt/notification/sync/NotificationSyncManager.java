package p005cm.aptoide.p006pt.notification.sync;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.NotificationSyncScheduler;
import p005cm.aptoide.p006pt.sync.SyncScheduler;

/* renamed from: cm.aptoide.pt.notification.sync.NotificationSyncManager */
public class NotificationSyncManager implements NotificationSyncScheduler {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private boolean enabled;
    private final NotificationSyncFactory notificationSyncFactory;
    private final SyncScheduler syncScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6246439014725612185L, "cm/aptoide/pt/notification/sync/NotificationSyncManager", 11);
        $jacocoData = probes;
        return probes;
    }

    public NotificationSyncManager(SyncScheduler syncScheduler2, boolean enabled2, NotificationSyncFactory notificationSyncFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.syncScheduler = syncScheduler2;
        this.enabled = enabled2;
        this.notificationSyncFactory = notificationSyncFactory2;
        $jacocoInit[0] = true;
    }

    public void schedule() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.enabled) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            this.syncScheduler.schedule(this.notificationSyncFactory.create(NotificationSyncFactory.CAMPAIGN_NOTIFICATION_SYNC_PERIODIC));
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = true;
    }

    public void forceSync() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.enabled) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            this.syncScheduler.schedule(this.notificationSyncFactory.create(NotificationSyncFactory.CAMPAIGN_NOTIFICATION_SYNC_IMMEDIATE));
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
    }

    public void removeSchedules() {
        boolean[] $jacocoInit = $jacocoInit();
        this.syncScheduler.cancel(NotificationSyncFactory.CAMPAIGN_NOTIFICATION_SYNC_PERIODIC);
        $jacocoInit[9] = true;
    }

    public void setEnabled(boolean enabled2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.enabled = enabled2;
        $jacocoInit[10] = true;
    }
}
