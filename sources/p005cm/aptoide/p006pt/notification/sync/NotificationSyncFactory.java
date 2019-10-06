package p005cm.aptoide.p006pt.notification.sync;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.notification.NotificationService;

/* renamed from: cm.aptoide.pt.notification.sync.NotificationSyncFactory */
public class NotificationSyncFactory {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String CAMPAIGN_NOTIFICATION_SYNC_IMMEDIATE = "CAMPAIGN_IMMEDIATE";
    public static final String CAMPAIGN_NOTIFICATION_SYNC_PERIODIC = "CAMPAIGN";
    private final NotificationProvider notificationPersistence;
    private final NotificationService notificationService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5925713936494581790L, "cm/aptoide/pt/notification/sync/NotificationSyncFactory", 9);
        $jacocoData = probes;
        return probes;
    }

    public NotificationSyncFactory(NotificationService notificationService2, NotificationProvider notificationPersistence2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationService = notificationService2;
        this.notificationPersistence = notificationPersistence2;
        $jacocoInit[0] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p005cm.aptoide.p006pt.sync.Sync create(java.lang.String r15) {
        /*
            r14 = this;
            boolean[] r0 = $jacocoInit()
            int r1 = r15.hashCode()
            r2 = 642707728(0x264ef110, float:7.179731E-16)
            r3 = 1
            if (r1 == r2) goto L_0x0027
            r2 = 1203674914(0x47be9f22, float:97598.266)
            if (r1 == r2) goto L_0x0016
            r0[r3] = r3
            goto L_0x0032
        L_0x0016:
            java.lang.String r1 = "CAMPAIGN_IMMEDIATE"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x0022
            r1 = 4
            r0[r1] = r3
            goto L_0x0032
        L_0x0022:
            r1 = 5
            r0[r1] = r3
            r1 = 1
            goto L_0x0038
        L_0x0027:
            java.lang.String r1 = "CAMPAIGN"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x0034
            r1 = 2
            r0[r1] = r3
        L_0x0032:
            r1 = -1
            goto L_0x0038
        L_0x0034:
            r1 = 0
            r2 = 3
            r0[r2] = r3
        L_0x0038:
            if (r1 == 0) goto L_0x006c
            if (r1 != r3) goto L_0x0051
            cm.aptoide.pt.notification.sync.CampaignNotificationSync r1 = new cm.aptoide.pt.notification.sync.CampaignNotificationSync
            cm.aptoide.pt.notification.NotificationService r6 = r14.notificationService
            cm.aptoide.pt.notification.NotificationProvider r7 = r14.notificationPersistence
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r4 = r1
            r5 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r12)
            r2 = 7
            r0[r2] = r3
            return r1
        L_0x0051:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Invalid sync "
            r2.append(r4)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = 8
            r0[r2] = r3
            throw r1
        L_0x006c:
            cm.aptoide.pt.notification.sync.CampaignNotificationSync r1 = new cm.aptoide.pt.notification.sync.CampaignNotificationSync
            cm.aptoide.pt.notification.NotificationService r6 = r14.notificationService
            cm.aptoide.pt.notification.NotificationProvider r7 = r14.notificationPersistence
            r8 = 1
            r9 = 0
            r10 = 43200000(0x2932e00, double:2.1343636E-316)
            r12 = 0
            r4 = r1
            r5 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r12)
            r2 = 6
            r0[r2] = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.notification.sync.NotificationSyncFactory.create(java.lang.String):cm.aptoide.pt.sync.Sync");
    }
}
