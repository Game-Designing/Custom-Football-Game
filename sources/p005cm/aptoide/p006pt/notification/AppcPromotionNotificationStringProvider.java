package p005cm.aptoide.p006pt.notification;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.notification.AppcPromotionNotificationStringProvider */
public class AppcPromotionNotificationStringProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String notificationBody;
    private final String notificationTitle;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3845329721412036904L, "cm/aptoide/pt/notification/AppcPromotionNotificationStringProvider", 3);
        $jacocoData = probes;
        return probes;
    }

    public AppcPromotionNotificationStringProvider(String notificationTitle2, String notificationBody2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationTitle = notificationTitle2;
        this.notificationBody = notificationBody2;
        $jacocoInit[0] = true;
    }

    public String getNotificationTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.notificationTitle;
        $jacocoInit[1] = true;
        return str;
    }

    public String getNotificationBody() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.notificationBody;
        $jacocoInit[2] = true;
        return str;
    }
}
