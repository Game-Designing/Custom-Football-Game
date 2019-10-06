package p005cm.aptoide.p006pt.notification;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.NotificationAccessor;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p024io.realm.C14064ia;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.notification.NotificationProvider */
public class NotificationProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final NotificationAccessor notificationAccessor;
    private final C0126V scheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-176344310309964766L, "cm/aptoide/pt/notification/NotificationProvider", 58);
        $jacocoData = probes;
        return probes;
    }

    public NotificationProvider(NotificationAccessor notificationAccessor2, C0126V scheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.scheduler = scheduler2;
        this.notificationAccessor = notificationAccessor2;
        $jacocoInit[0] = true;
    }

    private Notification convertToNotification(AptoideNotification aptoideNotification) {
        boolean[] $jacocoInit = $jacocoInit();
        Long expire = aptoideNotification.getExpire();
        $jacocoInit[1] = true;
        String abTestingGroup = aptoideNotification.getAbTestingGroup();
        String body = aptoideNotification.getBody();
        $jacocoInit[2] = true;
        int campaignId = aptoideNotification.getCampaignId();
        String img = aptoideNotification.getImg();
        $jacocoInit[3] = true;
        String lang = aptoideNotification.getLang();
        String title = aptoideNotification.getTitle();
        String url = aptoideNotification.getUrl();
        $jacocoInit[4] = true;
        String urlTrack = aptoideNotification.getUrlTrack();
        String notificationCenterUrlTrack = aptoideNotification.getNotificationCenterUrlTrack();
        $jacocoInit[5] = true;
        long timeStamp = aptoideNotification.getTimeStamp();
        int type = aptoideNotification.getType();
        $jacocoInit[6] = true;
        long dismissed = aptoideNotification.getDismissed();
        String appName = aptoideNotification.getAppName();
        $jacocoInit[7] = true;
        String graphic = aptoideNotification.getGraphic();
        String ownerId = aptoideNotification.getOwnerId();
        $jacocoInit[8] = true;
        Notification notification = new Notification(expire, abTestingGroup, body, campaignId, img, lang, title, url, urlTrack, notificationCenterUrlTrack, timeStamp, type, dismissed, appName, graphic, ownerId, aptoideNotification.isProcessed());
        $jacocoInit[9] = true;
        return notification;
    }

    public Single<List<AptoideNotification>> getDismissedNotifications(Integer[] notificationsTypes, long startTime, long endTime) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S dismissed = this.notificationAccessor.getDismissed(notificationsTypes, startTime, endTime);
        $jacocoInit[10] = true;
        C0120S d = dismissed.mo3647d();
        C4222r rVar = new C4222r(this);
        $jacocoInit[11] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rVar);
        $jacocoInit[12] = true;
        Single<List<AptoideNotification>> n = f.mo3678n();
        $jacocoInit[13] = true;
        return n;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo2216b(List notifications) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) notifications);
        C4220q qVar = new C4220q(this);
        $jacocoInit[54] = true;
        C0120S j = a.mo3669j(qVar);
        $jacocoInit[55] = true;
        C0120S m = j.mo3675m();
        $jacocoInit[56] = true;
        return m;
    }

    /* renamed from: a */
    public /* synthetic */ AptoideNotification mo2212a(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideNotification convertToAptoideNotification = convertToAptoideNotification(notification);
        $jacocoInit[57] = true;
        return convertToAptoideNotification;
    }

    private AptoideNotification convertToAptoideNotification(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        String body = notification.getBody();
        String img = notification.getImg();
        $jacocoInit[14] = true;
        String title = notification.getTitle();
        String url = notification.getUrl();
        int type = notification.getType();
        $jacocoInit[15] = true;
        String appName = notification.getAppName();
        String graphic = notification.getGraphic();
        long dismissed = notification.getDismissed();
        $jacocoInit[16] = true;
        String ownerId = notification.getOwnerId();
        String urlTrack = notification.getUrlTrack();
        $jacocoInit[17] = true;
        String notificationCenterUrlTrack = notification.getNotificationCenterUrlTrack();
        boolean isProcessed = notification.isProcessed();
        $jacocoInit[18] = true;
        long timeStamp = notification.getTimeStamp();
        Long expire = notification.getExpire();
        String abTestingGroup = notification.getAbTestingGroup();
        $jacocoInit[19] = true;
        AptoideNotification aptoideNotification = new AptoideNotification(body, img, title, url, type, appName, graphic, dismissed, ownerId, urlTrack, notificationCenterUrlTrack, isProcessed, timeStamp, expire, abTestingGroup, notification.getCampaignId(), notification.getLang());
        $jacocoInit[20] = true;
        return aptoideNotification;
    }

    public C0117M save(List<AptoideNotification> aptideNotifications) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) aptideNotifications);
        C4227t tVar = new C4227t(this);
        $jacocoInit[21] = true;
        C0120S j = a.mo3669j(tVar);
        $jacocoInit[22] = true;
        C0120S m = j.mo3675m();
        C4212n nVar = new C4212n(this);
        $jacocoInit[23] = true;
        C0120S b = m.mo3636b((C0129b<? super T>) nVar);
        $jacocoInit[24] = true;
        C0117M l = b.mo3673l();
        $jacocoInit[25] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ Notification mo2211a(AptoideNotification aptoideNotification) {
        boolean[] $jacocoInit = $jacocoInit();
        Notification convertToNotification = convertToNotification(aptoideNotification);
        $jacocoInit[53] = true;
        return convertToNotification;
    }

    /* renamed from: d */
    public /* synthetic */ void mo2220d(List notifications) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationAccessor.insertAll(notifications);
        $jacocoInit[52] = true;
    }

    public C0120S<List<AptoideNotification>> getNotifications(int entries) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S allSorted = this.notificationAccessor.getAllSorted(C14064ia.DESCENDING);
        C4214o oVar = new C4214o(this, entries);
        $jacocoInit[26] = true;
        C0120S<List<AptoideNotification>> f = allSorted.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) oVar);
        $jacocoInit[27] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2213a(int entries, List notifications) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) notifications);
        C4216p pVar = new C4216p(this);
        $jacocoInit[47] = true;
        C0120S j = a.mo3669j(pVar);
        $jacocoInit[48] = true;
        C0120S b = j.mo3629b(entries);
        $jacocoInit[49] = true;
        C0120S m = b.mo3675m();
        $jacocoInit[50] = true;
        return m;
    }

    /* renamed from: b */
    public /* synthetic */ AptoideNotification mo2215b(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideNotification convertToAptoideNotification = convertToAptoideNotification(notification);
        $jacocoInit[51] = true;
        return convertToAptoideNotification;
    }

    public C0120S<List<Notification>> getNotifications() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Notification>> all = this.notificationAccessor.getAll();
        $jacocoInit[28] = true;
        return all;
    }

    public C0120S<List<AptoideNotification>> getAptoideNotifications() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = this.notificationAccessor.getAll();
        C4210m mVar = new C4210m(this);
        $jacocoInit[29] = true;
        C0120S<List<AptoideNotification>> f = all.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mVar);
        $jacocoInit[30] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2214a(List notifications) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) notifications);
        C4206k kVar = new C4206k(this);
        $jacocoInit[43] = true;
        C0120S j = a.mo3669j(kVar);
        $jacocoInit[44] = true;
        C0120S m = j.mo3675m();
        $jacocoInit[45] = true;
        return m;
    }

    /* renamed from: c */
    public /* synthetic */ AptoideNotification mo2217c(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideNotification convertToAptoideNotification = convertToAptoideNotification(notification);
        $jacocoInit[46] = true;
        return convertToAptoideNotification;
    }

    public Single<Notification> getLastShowed(Integer[] notificationType) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Notification> lastShowed = this.notificationAccessor.getLastShowed(notificationType);
        $jacocoInit[31] = true;
        return lastShowed;
    }

    public C0117M save(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C4224s(this, notification));
        C0126V v = this.scheduler;
        $jacocoInit[32] = true;
        C0117M b = c.mo3593b(v);
        $jacocoInit[33] = true;
        return b;
    }

    /* renamed from: e */
    public /* synthetic */ void mo2222e(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationAccessor.insert(notification);
        $jacocoInit[42] = true;
    }

    public C0120S<List<AptoideNotification>> getUnreadNotifications() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S unread = this.notificationAccessor.getUnread();
        C4208l lVar = new C4208l(this);
        $jacocoInit[34] = true;
        C0120S<List<AptoideNotification>> f = unread.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) lVar);
        $jacocoInit[35] = true;
        return f;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo2218c(List notifications) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) notifications);
        C4229u uVar = new C4229u(this);
        $jacocoInit[38] = true;
        C0120S j = a.mo3669j(uVar);
        $jacocoInit[39] = true;
        C0120S m = j.mo3675m();
        $jacocoInit[40] = true;
        return m;
    }

    /* renamed from: d */
    public /* synthetic */ AptoideNotification mo2219d(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideNotification convertToAptoideNotification = convertToAptoideNotification(notification);
        $jacocoInit[41] = true;
        return convertToAptoideNotification;
    }

    public C0117M save(AptoideNotification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = save(convertToNotification(notification));
        $jacocoInit[36] = true;
        return save;
    }

    public C0117M deleteAllForType(int type) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M deleteAllOfType = this.notificationAccessor.deleteAllOfType(type);
        $jacocoInit[37] = true;
        return deleteAllOfType;
    }
}
