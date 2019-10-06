package p005cm.aptoide.p006pt.notification;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.notification.NotificationIdsMapper */
public class NotificationIdsMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1657985729265083243L, "cm/aptoide/pt/notification/NotificationIdsMapper", 16);
        $jacocoData = probes;
        return probes;
    }

    public NotificationIdsMapper() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: 0000 */
    public int getNotificationId(int notificationType) throws RuntimeException {
        boolean[] $jacocoInit = $jacocoInit();
        switch (notificationType) {
            case 0:
                $jacocoInit[1] = true;
                return 0;
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                $jacocoInit[2] = true;
                return 1;
            case 3:
                $jacocoInit[3] = true;
                return 2;
            case 7:
                $jacocoInit[4] = true;
                return 3;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("unknown notification type ");
                sb.append(notificationType);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
                $jacocoInit[5] = true;
                throw illegalArgumentException;
        }
    }

    /* access modifiers changed from: 0000 */
    public Integer[] getNotificationType(int notificationId) throws RuntimeException {
        boolean[] $jacocoInit = $jacocoInit();
        if (notificationId == 0) {
            $jacocoInit[6] = true;
            Integer[] numArr = {Integer.valueOf(0)};
            $jacocoInit[7] = true;
            return numArr;
        } else if (notificationId == 1) {
            $jacocoInit[8] = true;
            $jacocoInit[9] = true;
            Integer[] numArr2 = {Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(4)};
            $jacocoInit[10] = true;
            return numArr2;
        } else if (notificationId == 2) {
            $jacocoInit[11] = true;
            Integer[] numArr3 = {Integer.valueOf(3)};
            $jacocoInit[12] = true;
            return numArr3;
        } else if (notificationId == 3) {
            $jacocoInit[13] = true;
            Integer[] numArr4 = {Integer.valueOf(7)};
            $jacocoInit[14] = true;
            return numArr4;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("unknown notification notificationId ");
            sb.append(notificationId);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
            $jacocoInit[15] = true;
            throw illegalArgumentException;
        }
    }
}
