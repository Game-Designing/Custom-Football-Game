package p005cm.aptoide.p006pt.notification;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.RealmLocalNotificationSync;
import p005cm.aptoide.p006pt.notification.sync.LocalNotificationSync;

/* renamed from: cm.aptoide.pt.notification.RealmLocalNotificationSyncMapper */
public class RealmLocalNotificationSyncMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2538524808735151589L, "cm/aptoide/pt/notification/RealmLocalNotificationSyncMapper", 6);
        $jacocoData = probes;
        return probes;
    }

    public RealmLocalNotificationSyncMapper() {
        $jacocoInit()[0] = true;
    }

    public RealmLocalNotificationSync map(LocalNotificationSync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        String id = sync.getId();
        String title = sync.getTitle();
        String body = sync.getBody();
        $jacocoInit[1] = true;
        RealmLocalNotificationSync realmLocalNotificationSync = new RealmLocalNotificationSync(id, title, body, sync.getImage(), sync.getNavigationUrl(), sync.getTrigger(), sync.getId());
        $jacocoInit[2] = true;
        return realmLocalNotificationSync;
    }

    public LocalNotificationSync map(RealmLocalNotificationSync realmSync, NotificationProvider provider) {
        boolean[] $jacocoInit = $jacocoInit();
        long trigger = realmSync.getTrigger();
        $jacocoInit[3] = true;
        String title = realmSync.getTitle();
        String body = realmSync.getBody();
        String image = realmSync.getImage();
        $jacocoInit[4] = true;
        LocalNotificationSync localNotificationSync = new LocalNotificationSync(provider, false, false, 0, trigger, title, body, image, realmSync.getNavigationUrl(), realmSync.getId());
        $jacocoInit[5] = true;
        return localNotificationSync;
    }
}
