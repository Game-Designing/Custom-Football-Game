package p005cm.aptoide.p006pt.notification.sync;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.sync.SyncScheduler;

/* renamed from: cm.aptoide.pt.notification.sync.LocalNotificationSyncManager */
public class LocalNotificationSyncManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final long FIVE_MINUTES = 300000;
    private boolean enabled;
    private final NotificationProvider provider;
    private final SyncScheduler syncScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8341215977936926220L, "cm/aptoide/pt/notification/sync/LocalNotificationSyncManager", 6);
        $jacocoData = probes;
        return probes;
    }

    public LocalNotificationSyncManager(SyncScheduler syncScheduler2, boolean enabled2, NotificationProvider provider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.syncScheduler = syncScheduler2;
        this.enabled = enabled2;
        this.provider = provider2;
        $jacocoInit[0] = true;
    }

    public void schedule(String title, String body, String image, String navigationUrl, String id) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = true;
        if (!this.enabled) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            SyncScheduler syncScheduler2 = this.syncScheduler;
            LocalNotificationSync localNotificationSync = r4;
            LocalNotificationSync localNotificationSync2 = new LocalNotificationSync(this.provider, false, true, 0, FIVE_MINUTES, title, body, image, navigationUrl, id);
            syncScheduler2.schedule(localNotificationSync);
            z = true;
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = z;
    }

    public void unschedule(String type) {
        boolean[] $jacocoInit = $jacocoInit();
        this.syncScheduler.cancel(type);
        $jacocoInit[5] = true;
    }
}
