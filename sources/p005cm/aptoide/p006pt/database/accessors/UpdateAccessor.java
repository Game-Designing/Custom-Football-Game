package p005cm.aptoide.p006pt.database.accessors;

import java.util.List;
import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.database.schedulers.RealmSchedulers;
import p024io.realm.C13990F;
import p024io.realm.C14047ca;
import p024io.realm.C14052da;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.database.accessors.UpdateAccessor */
public class UpdateAccessor extends SimpleAccessor<Update> {
    public UpdateAccessor(Database db) {
        super(db, Update.class);
    }

    public C0120S<Update> get(String packageName) {
        return this.database.get(Update.class, "packageName", packageName);
    }

    /* renamed from: c */
    public /* synthetic */ C13990F mo11681c() throws Exception {
        return this.database.get();
    }

    public C0120S<Update> get(String packageName, boolean isExcluded) {
        return C0120S.m633a((Callable<? extends T>) new C2788fb<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2770_a<Object,Object>(this, packageName, isExcluded)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11678a(String packageName, boolean isExcluded, C13990F realm) {
        Database database = this.database;
        C14047ca c = realm.mo43540c(Update.class);
        c.mo43679b("packageName", packageName);
        c.mo43668a(Update.EXCLUDED, Boolean.valueOf(isExcluded));
        return database.mo925c(c);
    }

    public C0120S<List<Update>> getAll() {
        return this.database.getAll(Update.class);
    }

    /* renamed from: d */
    public /* synthetic */ C13990F mo11684d() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Update>> getAll(boolean isExcluded) {
        return C0120S.m633a((Callable<? extends T>) new C2779cb<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2763Wa<Object,Object>(isExcluded)).mo3643c(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2791gb<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m7420a(boolean isExcluded, C13990F realm) {
        C14047ca c = realm.mo43540c(Update.class);
        c.mo43668a(Update.EXCLUDED, Boolean.valueOf(isExcluded));
        return c.mo43681b().mo43707c();
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11676a(C14052da data) {
        return this.database.mo940f(data);
    }

    /* renamed from: e */
    public /* synthetic */ C13990F mo11685e() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Update>> getAllSorted(boolean isExcluded) {
        return C0120S.m633a((Callable<? extends T>) new C2776bb<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2759Ua<Object,Object>(isExcluded)).mo3643c(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2794hb<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m7423b(boolean isExcluded, C13990F realm) {
        C14047ca c = realm.mo43540c(Update.class);
        c.mo43668a(Update.EXCLUDED, Boolean.valueOf(isExcluded));
        return c.mo43676a(Update.LABEL).mo43707c();
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo11680b(C14052da data) {
        return this.database.mo940f(data);
    }

    /* renamed from: b */
    public /* synthetic */ C13990F mo11679b() throws Exception {
        return this.database.get();
    }

    public C0120S<Boolean> contains(String packageName, boolean isExcluded) {
        return C0120S.m633a((Callable<? extends T>) new C2800jb<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2767Ya<Object,Object>(isExcluded, packageName)).mo3643c(RealmSchedulers.getScheduler()).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m7418a(C13990F realm, boolean isExcluded, String packageName) {
        C14047ca c = realm.mo43540c(Update.class);
        c.mo43668a(Update.EXCLUDED, Boolean.valueOf(isExcluded));
        c.mo43671a("packageName", packageName);
        return C0120S.m652c(Boolean.valueOf(((Update) c.mo43682c()) != null));
    }

    /* renamed from: a */
    public /* synthetic */ C13990F mo11675a() throws Exception {
        return this.database.get();
    }

    public C0120S<Boolean> contains(String packageName, boolean isExcluded, boolean isAppcUpgrade) {
        return C0120S.m633a((Callable<? extends T>) new C2785eb<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2765Xa<Object,Object>(isExcluded, isAppcUpgrade, packageName)).mo3643c(RealmSchedulers.getScheduler()).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m7419a(C13990F realm, boolean isExcluded, boolean isAppcUpgrade, String packageName) {
        C14047ca c = realm.mo43540c(Update.class);
        c.mo43668a(Update.EXCLUDED, Boolean.valueOf(isExcluded));
        c.mo43668a(Update.APPC_UPGRADE, Boolean.valueOf(isAppcUpgrade));
        c.mo43671a("packageName", packageName);
        return C0120S.m652c(Boolean.valueOf(((Update) c.mo43682c()) != null));
    }

    public void remove(String packageName) {
        this.database.delete(Update.class, "packageName", packageName);
    }

    public void removeAll(List<String> packageNameList) {
        this.database.deleteAllIn(Update.class, "packageName", (String[]) packageNameList.toArray(new String[0]));
    }

    public void saveAll(List<Update> updates) {
        this.database.insertAll(updates);
    }

    public void save(Update update) {
        this.database.insert(update);
    }

    /* renamed from: f */
    public /* synthetic */ C13990F mo11686f() throws Exception {
        return this.database.get();
    }

    public C0120S<Boolean> isExcluded(String packageName) {
        return C0120S.m633a((Callable<? extends T>) new C2797ib<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2769Za<Object,Object>(this, packageName)).mo3643c(RealmSchedulers.getScheduler()).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11677a(String packageName, C13990F realm) {
        Database database = this.database;
        C14047ca c = realm.mo43540c(Update.class);
        c.mo43679b("packageName", packageName);
        c.mo43668a(Update.EXCLUDED, Boolean.valueOf(true));
        return database.count(c).mo3669j(C2773ab.f5990a);
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7417a(Long count) {
        return Boolean.valueOf(count.longValue() > 0);
    }
}
