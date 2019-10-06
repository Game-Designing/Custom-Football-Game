package p005cm.aptoide.p006pt.notification;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.notification.NotificationInfo */
public class NotificationInfo {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String action;
    private String notificationTrackUrl;
    private int notificationType;
    private String notificationUrl;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6534676008527804684L, "cm/aptoide/pt/notification/NotificationInfo", 6);
        $jacocoData = probes;
        return probes;
    }

    public NotificationInfo(String action2, int notificationType2, String notificationTrackUrl2, String notificationUrl2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.action = action2;
        this.notificationType = notificationType2;
        this.notificationTrackUrl = notificationTrackUrl2;
        this.notificationUrl = notificationUrl2;
        $jacocoInit[0] = true;
    }

    public NotificationInfo(String action2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.action = action2;
        $jacocoInit[1] = true;
    }

    public int getNotificationType() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.notificationType;
        $jacocoInit[2] = true;
        return i;
    }

    public String getNotificationTrackUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.notificationTrackUrl;
        $jacocoInit[3] = true;
        return str;
    }

    public String getNotificationUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.notificationUrl;
        $jacocoInit[4] = true;
        return str;
    }

    public String getAction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.action;
        $jacocoInit[5] = true;
        return str;
    }
}
