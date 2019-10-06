package p005cm.aptoide.p006pt.notification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.accessors.NotificationAccessor;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p024io.realm.C14064ia;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.notification.NotificationsCleaner */
public class NotificationsCleaner {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int MAX_NUMBER_NOTIFICATIONS_SAVED = 50;
    private AptoideAccountManager accountManager;
    private final Calendar calendar;
    private CrashReport crashReport;
    private final NotificationAccessor notificationAccessor;
    private NotificationProvider notificationProvider;
    private final C0136c subscriptions = new C0136c();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8469842556635080618L, "cm/aptoide/pt/notification/NotificationsCleaner", 61);
        $jacocoData = probes;
        return probes;
    }

    public NotificationsCleaner(NotificationAccessor notificationAccessor2, Calendar calendar2, AptoideAccountManager accountManager2, NotificationProvider notificationProvider2, CrashReport crashReport2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationAccessor = notificationAccessor2;
        this.calendar = calendar2;
        this.accountManager = accountManager2;
        this.notificationProvider = notificationProvider2;
        this.crashReport = crashReport2;
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    public void setup() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S accountStatus = this.accountManager.accountStatus();
        C4169I i = C4169I.f7721a;
        $jacocoInit[2] = true;
        C0120S d = accountStatus.mo3653d((C0132p<? super T, Boolean>) i);
        C4252y yVar = new C4252y(this);
        $jacocoInit[3] = true;
        C0120S g = d.mo3663g((C0132p<? super T, ? extends C0117M>) yVar);
        C4162D d2 = C4162D.f7714a;
        C4254z zVar = new C4254z(this);
        $jacocoInit[4] = true;
        C0137ja a = g.mo3626a((C0129b<? super T>) d2, (C0129b<Throwable>) zVar);
        $jacocoInit[5] = true;
        cVar.mo3713a(a);
        $jacocoInit[6] = true;
        C0136c cVar2 = this.subscriptions;
        C0120S notifications = this.notificationProvider.getNotifications(1);
        C4158B b = new C4158B(this);
        $jacocoInit[7] = true;
        C0120S g2 = notifications.mo3663g((C0132p<? super T, ? extends C0117M>) b);
        C4168H h = C4168H.f7720a;
        C4170J j = new C4170J(this);
        $jacocoInit[8] = true;
        C0137ja a2 = g2.mo3626a((C0129b<? super T>) h, (C0129b<Throwable>) j);
        $jacocoInit[9] = true;
        cVar2.mo3713a(a2);
        $jacocoInit[10] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m430a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(account.isLoggedIn());
        $jacocoInit[60] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo2244b(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M cleanOtherUsersNotifications = cleanOtherUsersNotifications(account.getId());
        $jacocoInit[59] = true;
        return cleanOtherUsersNotifications;
    }

    /* renamed from: c */
    static /* synthetic */ void m434c(Account notificationsCleaned) {
        $jacocoInit()[58] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2243a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[57] = true;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo2250e(List aptoideNotifications) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M cleanLimitExceededNotifications = cleanLimitExceededNotifications(50);
        $jacocoInit[56] = true;
        return cleanLimitExceededNotifications;
    }

    /* renamed from: f */
    static /* synthetic */ void m435f(List aptoideNotifications) {
        $jacocoInit()[55] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo2246b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[54] = true;
    }

    public C0117M cleanOtherUsersNotifications(String id) {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> idsList = new ArrayList<>(2);
        $jacocoInit[11] = true;
        idsList.add(id);
        $jacocoInit[12] = true;
        idsList.add("");
        $jacocoInit[13] = true;
        C0117M deleteAllExcluding = this.notificationAccessor.deleteAllExcluding(idsList);
        $jacocoInit[14] = true;
        return deleteAllExcluding;
    }

    public C0117M cleanLimitExceededNotifications(int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = removeExpiredNotifications().mo3580a(removeExceededLimitNotifications(limit));
        $jacocoInit[15] = true;
        return a;
    }

    private C0117M removeExpiredNotifications() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m643a((C0131o<C0120S<T>>) new C4167G<C0120S<T>>(this));
        $jacocoInit[16] = true;
        C0120S d = a.mo3647d();
        C4250x xVar = C4250x.f7828a;
        $jacocoInit[17] = true;
        C0120S h = d.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) xVar);
        C4164E e = new C4164E(this);
        $jacocoInit[18] = true;
        C0120S f = h.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) e);
        $jacocoInit[19] = true;
        C0120S m = f.mo3675m();
        C4171K k = new C4171K(this);
        $jacocoInit[20] = true;
        C0120S g = m.mo3663g((C0132p<? super T, ? extends C0117M>) k);
        $jacocoInit[21] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[22] = true;
        return l;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo2245b() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S allSorted = this.notificationAccessor.getAllSorted(C14064ia.DESCENDING);
        $jacocoInit[53] = true;
        return allSorted;
    }

    /* renamed from: b */
    static /* synthetic */ Iterable m431b(List notifications) {
        $jacocoInit()[52] = true;
        return notifications;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2242a(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isNotificationExpired(notification)) {
            $jacocoInit[49] = true;
            C0120S c = C0120S.m652c(notification);
            $jacocoInit[50] = true;
            return c;
        }
        C0120S c2 = C0120S.m651c();
        $jacocoInit[51] = true;
        return c2;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo2240a(List notifications) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removeNotifications = removeNotifications(notifications);
        $jacocoInit[48] = true;
        return removeNotifications;
    }

    private boolean isNotificationExpired(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        Long expire = notification.getExpire();
        boolean z = false;
        if (expire != null) {
            $jacocoInit[23] = true;
            long now = this.calendar.getTimeInMillis();
            $jacocoInit[24] = true;
            if (now > expire.longValue()) {
                $jacocoInit[25] = true;
                z = true;
            } else {
                $jacocoInit[26] = true;
            }
            $jacocoInit[27] = true;
            return z;
        }
        $jacocoInit[28] = true;
        return false;
    }

    private C0117M removeExceededLimitNotifications(int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m643a((C0131o<C0120S<T>>) new C4173M<C0120S<T>>(this));
        $jacocoInit[29] = true;
        C0120S d = a.mo3647d();
        C4172L l = new C4172L(this, limit);
        $jacocoInit[30] = true;
        C0120S g = d.mo3663g((C0132p<? super T, ? extends C0117M>) l);
        $jacocoInit[31] = true;
        C0117M l2 = g.mo3673l();
        $jacocoInit[32] = true;
        return l2;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2241a() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S allSorted = this.notificationAccessor.getAllSorted(C14064ia.DESCENDING);
        $jacocoInit[47] = true;
        return allSorted;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo2239a(int limit, List notifications) {
        boolean[] $jacocoInit = $jacocoInit();
        if (notifications.size() > limit) {
            $jacocoInit[44] = true;
            C0117M removeNotifications = removeNotifications(notifications.subList(limit, notifications.size()));
            $jacocoInit[45] = true;
            return removeNotifications;
        }
        C0117M b = C0117M.m590b();
        $jacocoInit[46] = true;
        return b;
    }

    private C0117M removeNotifications(List<Notification> notifications) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) notifications);
        C4156A a2 = C4156A.f7703a;
        $jacocoInit[33] = true;
        C0120S j = a.mo3669j(a2);
        $jacocoInit[34] = true;
        C0120S m = j.mo3675m();
        C4160C c = C4160C.f7707a;
        $jacocoInit[35] = true;
        C0120S d = m.mo3653d((C0132p<? super T, Boolean>) c);
        C4166F f = new C4166F(this);
        $jacocoInit[36] = true;
        C0120S g = d.mo3663g((C0132p<? super T, ? extends C0117M>) f);
        $jacocoInit[37] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[38] = true;
        return l;
    }

    /* renamed from: b */
    static /* synthetic */ String m432b(Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        String key = notification.getKey();
        $jacocoInit[43] = true;
        return key;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m433c(List list) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!list.isEmpty()) {
            $jacocoInit[40] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[41] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[42] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo2249d(List keys) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M delete = this.notificationAccessor.delete((String[]) keys.toArray(new String[keys.size()]));
        $jacocoInit[39] = true;
        return delete;
    }
}
