package p005cm.aptoide.p006pt.notification;

import android.content.BroadcastReceiver;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p019d.p022i.p023b.C0100e;

/* renamed from: cm.aptoide.pt.notification.NotificationReceiver */
public class NotificationReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ACTION = "action";
    public static final String NOTIFICATION_DISMISSED_ACTION = "PUSH_NOTIFICATION_DISMISSED";
    public static final String NOTIFICATION_NOTIFICATION_ID = "PUSH_NOTIFICATION_NOTIFICATION_ID";
    public static final String NOTIFICATION_PRESSED_ACTION = "NOTIFICATION_PRESSED_ACTION";
    public static final String NOTIFICATION_TARGET_URL = "PUSH_NOTIFICATION_TARGET_URL";
    public static final String NOTIFICATION_TRACK_URL = "PUSH_NOTIFICATION_TRACK_URL";
    private C0100e<NotificationInfo> notificationPublishRelay;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7020700854130608971L, "cm/aptoide/pt/notification/NotificationReceiver", 30);
        $jacocoData = probes;
        return probes;
    }

    public NotificationReceiver() {
        $jacocoInit()[0] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
            r13 = this;
            boolean[] r0 = $jacocoInit()
            r1 = 1
            r0[r1] = r1
            android.content.Context r2 = r14.getApplicationContext()
            cm.aptoide.pt.AptoideApplication r2 = (p005cm.aptoide.p006pt.AptoideApplication) r2
            d.i.b.e r2 = r2.getNotificationsPublishRelay()
            r13.notificationPublishRelay = r2
            r2 = 2
            r0[r2] = r1
            android.os.Bundle r3 = r15.getExtras()
            r4 = 3
            r0[r4] = r1
            java.lang.String r4 = "notification"
            java.lang.Object r4 = r14.getSystemService(r4)
            android.app.NotificationManager r4 = (android.app.NotificationManager) r4
            r5 = 4
            r0[r5] = r1
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = "android.intent.action.CLOSE_SYSTEM_DIALOGS"
            r5.<init>(r6)
            r6 = 5
            r0[r6] = r1
            java.lang.String r6 = r15.getAction()
            int r7 = r6.hashCode()
            r8 = -1304544537(0xffffffffb23e3ae7, float:-1.1072848E-8)
            java.lang.String r9 = "android.intent.action.BOOT_COMPLETED"
            java.lang.String r10 = "PUSH_NOTIFICATION_DISMISSED"
            java.lang.String r11 = "NOTIFICATION_PRESSED_ACTION"
            r12 = -1
            if (r7 == r8) goto L_0x0075
            r8 = 542552314(0x2056b0fa, float:1.8185062E-19)
            if (r7 == r8) goto L_0x0064
            r8 = 798292259(0x2f94f923, float:2.7098065E-10)
            if (r7 == r8) goto L_0x0054
            r6 = 6
            r0[r6] = r1
            goto L_0x007f
        L_0x0054:
            boolean r6 = r6.equals(r9)
            if (r6 != 0) goto L_0x005e
            r6 = 7
            r0[r6] = r1
            goto L_0x007f
        L_0x005e:
            r6 = 0
            r7 = 8
            r0[r7] = r1
            goto L_0x0086
        L_0x0064:
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x006f
            r6 = 11
            r0[r6] = r1
            goto L_0x007f
        L_0x006f:
            r6 = 12
            r0[r6] = r1
            r6 = 2
            goto L_0x0086
        L_0x0075:
            boolean r6 = r6.equals(r11)
            if (r6 != 0) goto L_0x0081
            r6 = 9
            r0[r6] = r1
        L_0x007f:
            r6 = -1
            goto L_0x0086
        L_0x0081:
            r6 = 10
            r0[r6] = r1
            r6 = 1
        L_0x0086:
            if (r6 == 0) goto L_0x010b
            java.lang.String r7 = "PUSH_NOTIFICATION_TARGET_URL"
            java.lang.String r8 = "PUSH_NOTIFICATION_TRACK_URL"
            java.lang.String r9 = "PUSH_NOTIFICATION_NOTIFICATION_ID"
            if (r6 == r1) goto L_0x00ce
            if (r6 == r2) goto L_0x0098
            r2 = 13
            r0[r2] = r1
            goto L_0x011d
        L_0x0098:
            cm.aptoide.pt.notification.NotificationInfo r2 = new cm.aptoide.pt.notification.NotificationInfo
            r6 = 23
            r0[r6] = r1
            int r6 = r3.getInt(r9)
            r11 = 24
            r0[r11] = r1
            java.lang.String r8 = r3.getString(r8)
            r11 = 25
            r0[r11] = r1
            java.lang.String r7 = r3.getString(r7)
            r2.<init>(r10, r6, r8, r7)
            r6 = 26
            r0[r6] = r1
            int r6 = r15.getIntExtra(r9, r12)
            r4.cancel(r6)
            r6 = 27
            r0[r6] = r1
            d.i.b.e<cm.aptoide.pt.notification.NotificationInfo> r6 = r13.notificationPublishRelay
            r6.call(r2)
            r6 = 28
            r0[r6] = r1
            goto L_0x011d
        L_0x00ce:
            cm.aptoide.pt.notification.NotificationInfo r2 = new cm.aptoide.pt.notification.NotificationInfo
            r6 = 16
            r0[r6] = r1
            int r6 = r3.getInt(r9)
            r10 = 17
            r0[r10] = r1
            java.lang.String r8 = r3.getString(r8)
            r10 = 18
            r0[r10] = r1
            java.lang.String r7 = r3.getString(r7)
            r2.<init>(r11, r6, r8, r7)
            r6 = 19
            r0[r6] = r1
            int r6 = r15.getIntExtra(r9, r12)
            r4.cancel(r6)
            r6 = 20
            r0[r6] = r1
            r14.sendBroadcast(r5)
            r6 = 21
            r0[r6] = r1
            d.i.b.e<cm.aptoide.pt.notification.NotificationInfo> r6 = r13.notificationPublishRelay
            r6.call(r2)
            r6 = 22
            r0[r6] = r1
            goto L_0x011d
        L_0x010b:
            cm.aptoide.pt.notification.NotificationInfo r2 = new cm.aptoide.pt.notification.NotificationInfo
            r2.<init>(r9)
            r6 = 14
            r0[r6] = r1
            d.i.b.e<cm.aptoide.pt.notification.NotificationInfo> r6 = r13.notificationPublishRelay
            r6.call(r2)
            r6 = 15
            r0[r6] = r1
        L_0x011d:
            r2 = 29
            r0[r2] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.notification.NotificationReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
