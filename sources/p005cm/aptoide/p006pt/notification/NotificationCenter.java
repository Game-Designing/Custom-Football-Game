package p005cm.aptoide.p006pt.notification;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.notification.NotificationCenter */
public class NotificationCenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private NotificationAnalytics notificationAnalytics;
    private NotificationPolicyFactory notificationPolicyFactory;
    private NotificationProvider notificationProvider;
    private NotificationSyncScheduler notificationSyncScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7498908060593525225L, "cm/aptoide/pt/notification/NotificationCenter", 49);
        $jacocoData = probes;
        return probes;
    }

    public NotificationCenter(NotificationProvider notificationProvider2, NotificationSyncScheduler notificationSyncScheduler2, NotificationPolicyFactory notificationPolicyFactory2, NotificationAnalytics notificationAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationSyncScheduler = notificationSyncScheduler2;
        this.notificationProvider = notificationProvider2;
        this.notificationPolicyFactory = notificationPolicyFactory2;
        this.notificationAnalytics = notificationAnalytics2;
        $jacocoInit[0] = true;
    }

    public void setup() {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationSyncScheduler.schedule();
        $jacocoInit[1] = true;
    }

    public C0120S<AptoideNotification> getNewNotifications() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S aptoideNotifications = this.notificationProvider.getAptoideNotifications();
        C4186a aVar = C4186a.f7741a;
        $jacocoInit[2] = true;
        C0120S h = aptoideNotifications.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) aVar);
        C4202i iVar = C4202i.f7759a;
        $jacocoInit[3] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) iVar);
        C4200h hVar = new C4200h(this);
        $jacocoInit[4] = true;
        C0120S i = d.mo3668i(hVar);
        C4196f fVar = new C4196f(this);
        $jacocoInit[5] = true;
        C0120S f = i.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fVar);
        C4188b bVar = C4188b.f7743a;
        $jacocoInit[6] = true;
        C0120S<AptoideNotification> k = f.mo3671k(bVar);
        $jacocoInit[7] = true;
        return k;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m408a(List notifications) {
        $jacocoInit()[48] = true;
        return notifications;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m407a(AptoideNotification notification) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!notification.isProcessed()) {
            $jacocoInit[45] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[46] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[47] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo2196b(AptoideNotification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        if (notification.getType() == 7) {
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[37] = true;
            NotificationAnalytics notificationAnalytics2 = this.notificationAnalytics;
            int type = notification.getType();
            $jacocoInit[38] = true;
            String abTestingGroup = notification.getAbTestingGroup();
            int campaignId = notification.getCampaignId();
            $jacocoInit[39] = true;
            String url = notification.getUrl();
            $jacocoInit[40] = true;
            notificationAnalytics2.sendPushNotificationReceivedEvent(type, abTestingGroup, campaignId, url);
            $jacocoInit[41] = true;
        }
        notification.setProcessed(true);
        $jacocoInit[42] = true;
        C0117M save = this.notificationProvider.save(notification);
        $jacocoInit[43] = true;
        Single b = save.mo3597b(notification);
        $jacocoInit[44] = true;
        return b;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo2197c(AptoideNotification aptoideNotification) {
        boolean[] $jacocoInit = $jacocoInit();
        Policy policy = this.notificationPolicyFactory.getPolicy(aptoideNotification);
        $jacocoInit[30] = true;
        Single shouldShow = policy.shouldShow();
        C4198g gVar = new C4198g(aptoideNotification);
        $jacocoInit[31] = true;
        C0120S c = shouldShow.mo3697c(gVar);
        $jacocoInit[32] = true;
        return c;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m409a(AptoideNotification aptoideNotification, Boolean shouldShow) {
        boolean[] $jacocoInit = $jacocoInit();
        if (shouldShow.booleanValue()) {
            $jacocoInit[33] = true;
            C0120S c = C0120S.m652c(aptoideNotification);
            $jacocoInit[34] = true;
            return c;
        }
        C0120S c2 = C0120S.m651c();
        $jacocoInit[35] = true;
        return c2;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m410a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[28] = true;
        C0120S c = C0120S.m651c();
        $jacocoInit[29] = true;
        return c;
    }

    public C0120S<List<AptoideNotification>> getInboxNotifications(int entries) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<AptoideNotification>> notifications = this.notificationProvider.getNotifications(entries);
        $jacocoInit[8] = true;
        return notifications;
    }

    public C0120S<Boolean> haveNotifications() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S notifications = this.notificationProvider.getNotifications(1);
        C4190c cVar = C4190c.f7745a;
        $jacocoInit[9] = true;
        C0120S<Boolean> j = notifications.mo3669j(cVar);
        $jacocoInit[10] = true;
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m411b(List list) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!list.isEmpty()) {
            $jacocoInit[25] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[26] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[27] = true;
        return valueOf;
    }

    public C0117M notificationDismissed(Integer[] notificationType) {
        boolean[] $jacocoInit = $jacocoInit();
        Single lastShowed = this.notificationProvider.getLastShowed(notificationType);
        C4194e eVar = new C4194e(this);
        $jacocoInit[11] = true;
        C0117M b = lastShowed.mo3693b((C0132p<? super T, ? extends C0117M>) eVar);
        $jacocoInit[12] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo2194a(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        notification.setDismissed(System.currentTimeMillis());
        $jacocoInit[23] = true;
        C0117M save = this.notificationProvider.save(notification);
        $jacocoInit[24] = true;
        return save;
    }

    public C0117M setAllNotificationsRead() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S notifications = this.notificationProvider.getNotifications();
        $jacocoInit[13] = true;
        C0120S d = notifications.mo3647d();
        C4192d dVar = C4192d.f7747a;
        $jacocoInit[14] = true;
        C0120S h = d.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) dVar);
        C4204j jVar = new C4204j(this);
        $jacocoInit[15] = true;
        C0120S g = h.mo3663g((C0132p<? super T, ? extends C0117M>) jVar);
        $jacocoInit[16] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[17] = true;
        return l;
    }

    /* renamed from: c */
    static /* synthetic */ Iterable m412c(List notifications) {
        $jacocoInit()[22] = true;
        return notifications;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo2195b(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        if (notification.getDismissed() == -1) {
            $jacocoInit[18] = true;
            notification.setDismissed(System.currentTimeMillis());
            $jacocoInit[19] = true;
            C0117M save = this.notificationProvider.save(notification);
            $jacocoInit[20] = true;
            return save;
        }
        C0117M b = C0117M.m590b();
        $jacocoInit[21] = true;
        return b;
    }
}
