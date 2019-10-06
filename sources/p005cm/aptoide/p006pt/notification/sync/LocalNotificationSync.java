package p005cm.aptoide.p006pt.notification.sync;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.AptoideNotification;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.sync.Sync;
import p026rx.C0117M;

/* renamed from: cm.aptoide.pt.notification.sync.LocalNotificationSync */
public class LocalNotificationSync extends Sync {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String APPC_CAMPAIGN_NOTIFICATION = "APPC_CAMPAIGN";
    private static final long TWENTY_FOUR_HOURS = 86400000;
    private final String body;

    /* renamed from: id */
    private final String f7799id;
    private final String image;
    private final String navigationUrl;
    private final NotificationProvider notificationProvider;
    private final String title;
    private final long trigger;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2629128703545277725L, "cm/aptoide/pt/notification/sync/LocalNotificationSync", 11);
        $jacocoData = probes;
        return probes;
    }

    public LocalNotificationSync(NotificationProvider notificationProvider2, boolean periodic, boolean exact, long interval, long trigger2, String title2, String body2, String image2, String navigationUrl2, String id) {
        boolean[] $jacocoInit = $jacocoInit();
        super(APPC_CAMPAIGN_NOTIFICATION, periodic, exact, trigger2, interval);
        this.notificationProvider = notificationProvider2;
        this.title = title2;
        this.body = body2;
        this.image = image2;
        this.navigationUrl = navigationUrl2;
        this.trigger = trigger2;
        this.f7799id = id;
        $jacocoInit[0] = true;
    }

    private AptoideNotification createNotification() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.body;
        String str2 = this.image;
        String str3 = this.title;
        String str4 = this.navigationUrl;
        $jacocoInit[1] = true;
        long currentTimeMillis = System.currentTimeMillis();
        String str5 = this.f7799id;
        $jacocoInit[2] = true;
        AptoideNotification aptoideNotification = new AptoideNotification(str, str2, str3, str4, 7, currentTimeMillis, "", "", -1, str5, "", "", false, Long.valueOf(System.currentTimeMillis() + 86400000));
        $jacocoInit[3] = true;
        return aptoideNotification;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[4] = true;
        return str;
    }

    public String getBody() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.body;
        $jacocoInit[5] = true;
        return str;
    }

    public String getImage() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.image;
        $jacocoInit[6] = true;
        return str;
    }

    public String getNavigationUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.navigationUrl;
        $jacocoInit[7] = true;
        return str;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.f7799id;
        $jacocoInit[8] = true;
        return str;
    }

    public long getTrigger() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.trigger;
        $jacocoInit[9] = true;
        return j;
    }

    public C0117M execute() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = this.notificationProvider.save(createNotification());
        $jacocoInit[10] = true;
        return save;
    }
}
