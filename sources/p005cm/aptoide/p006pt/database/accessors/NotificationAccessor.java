package p005cm.aptoide.p006pt.database.accessors;

import java.util.List;
import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p005cm.aptoide.p006pt.database.schedulers.RealmSchedulers;
import p024io.realm.C13990F;
import p024io.realm.C14047ca;
import p024io.realm.C14052da;
import p024io.realm.C14064ia;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.database.accessors.NotificationAccessor */
public class NotificationAccessor extends SimpleAccessor<Notification> {
    public NotificationAccessor(Database db) {
        super(db, Notification.class);
    }

    /* renamed from: c */
    public /* synthetic */ C13990F mo991c() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Notification>> getDismissed(Integer[] notificationType, long startingTime, long endTime) {
        C0120S a = C0120S.m633a((Callable<? extends T>) new C2829xa<Object>(this));
        C2728Ea ea = new C2728Ea(notificationType, startingTime, endTime);
        return a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ea).mo3643c(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2732Ga<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m241a(Integer[] notificationType, long startingTime, long endTime, C13990F realm) {
        C14047ca c = realm.mo43540c(Notification.class);
        c.mo43673a("type", notificationType);
        String str = "dismissed";
        c.mo43667a(str, startingTime);
        c.mo43678b(str, endTime);
        return c.mo43681b().mo43707c();
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo992c(C14052da data) {
        return this.database.mo940f(data);
    }

    /* renamed from: d */
    public /* synthetic */ C13990F mo993d() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Notification>> getUnread() {
        return C0120S.m633a((Callable<? extends T>) new C2831ya<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C2722Ba.f5924a).mo3643c(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2730Fa<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m239a(C13990F realm) {
        C14047ca c = realm.mo43540c(Notification.class);
        c.mo43669a("dismissed", Integer.valueOf(-1));
        return c.mo43677a("timeStamp", C14064ia.DESCENDING).mo43707c();
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo994d(C14052da data) {
        return this.database.mo940f(data);
    }

    /* renamed from: b */
    public /* synthetic */ C13990F mo989b() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Notification>> getAllSorted(C14064ia sortOrder, Integer[] notificationType) {
        return C0120S.m633a((Callable<? extends T>) new C2724Ca<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2740Ka<Object,Object>(notificationType, sortOrder)).mo3643c(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2734Ha<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m242a(Integer[] notificationType, C14064ia sortOrder, C13990F realm) {
        C14047ca c = realm.mo43540c(Notification.class);
        c.mo43673a("type", notificationType);
        return c.mo43677a("timeStamp", sortOrder).mo43707c();
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo990b(C14052da data) {
        return this.database.mo940f(data);
    }

    public Single<Notification> getLastShowed(Integer[] notificationType) {
        return getAllSorted(C14064ia.DESCENDING, notificationType).mo3647d().mo3669j(C2738Ja.f5943a).mo3678n();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<cm.aptoide.pt.database.realm.Notification>, for r3v0, types: [java.util.List, java.util.List<cm.aptoide.pt.database.realm.Notification>] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ p005cm.aptoide.p006pt.database.realm.Notification m243b(java.util.List<p005cm.aptoide.p006pt.database.realm.Notification> r3) {
        /*
            java.util.Iterator r0 = r3.iterator()
        L_0x0004:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0018
            java.lang.Object r1 = r0.next()
            cm.aptoide.pt.database.realm.Notification r1 = (p005cm.aptoide.p006pt.database.realm.Notification) r1
            boolean r2 = r1.isDismissed()
            if (r2 != 0) goto L_0x0017
            return r1
        L_0x0017:
            goto L_0x0004
        L_0x0018:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.database.accessors.NotificationAccessor.m243b(java.util.List):cm.aptoide.pt.database.realm.Notification");
    }

    /* renamed from: a */
    public /* synthetic */ C13990F mo984a() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Notification>> getAllSorted(C14064ia sort) {
        return C0120S.m633a((Callable<? extends T>) new C2825va<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2726Da<Object,Object>(sort)).mo3643c(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2827wa<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo985a(C14052da data) {
        return this.database.mo940f(data);
    }

    public C0117M deleteAllExcluding(List<String> ids) {
        return C0117M.m597c((C0128a) new C2720Aa(this, ids));
    }

    /* renamed from: a */
    public /* synthetic */ void mo987a(List ids) {
        this.database.deleteAllExcluding(Notification.class, "ownerId", ids);
    }

    public C0117M delete(String[] keys) {
        return C0117M.m597c((C0128a) new C2833za(this, keys));
    }

    /* renamed from: a */
    public /* synthetic */ void mo988a(String[] keys) {
        this.database.deleteAllIn(Notification.class, Notification.KEY, keys);
    }

    public C0120S<List<Notification>> getAll() {
        return this.database.getAll(Notification.class);
    }

    /* renamed from: a */
    public /* synthetic */ void mo986a(int type) {
        this.database.delete(Notification.class, "type", Integer.valueOf(type));
    }

    public C0117M deleteAllOfType(int type) {
        return C0117M.m597c((C0128a) new C2736Ia(this, type));
    }
}
