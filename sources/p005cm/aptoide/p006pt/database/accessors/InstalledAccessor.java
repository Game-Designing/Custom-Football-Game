package p005cm.aptoide.p006pt.database.accessors;

import java.util.List;
import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.database.realm.Installation;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.schedulers.RealmSchedulers;
import p024io.realm.C0106Z;
import p024io.realm.C13990F;
import p024io.realm.C14047ca;
import p024io.realm.C14052da;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.database.accessors.InstalledAccessor */
public class InstalledAccessor extends SimpleAccessor<Installed> {
    private final InstallationAccessor installationAccessor;

    public InstalledAccessor(Database db, InstallationAccessor installationAccessor2) {
        super(db, Installed.class);
        this.installationAccessor = installationAccessor2;
    }

    public C0120S<List<Installed>> getAllInstalled() {
        return this.database.getAll(Installed.class).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2813pa<Object,Object>(this));
    }

    public C0120S<List<Installed>> getAll() {
        return this.database.getAll(Installed.class);
    }

    /* renamed from: c */
    public /* synthetic */ C13990F mo959c() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Installed>> getAllInstalledSorted() {
        return C0120S.m633a((Callable<? extends T>) new C2772aa<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C2802ka.f6028a).mo3653d((C0132p<? super T, Boolean>) C2787fa.f6009a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2781da<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2790ga<Object,Object>(this));
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo960c(C14052da installed) {
        return this.database.mo940f(installed);
    }

    /* access modifiers changed from: private */
    /* renamed from: filterCompleted */
    public C0120S<List<Installed>> mo967e(List<Installed> installs) {
        return C0120S.m629a((Iterable<? extends T>) installs).mo3653d((C0132p<? super T, Boolean>) C2760V.f5968a).mo3675m();
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m213a(Installed installed) {
        return Boolean.valueOf(installed.getStatus() == 4);
    }

    public C0117M remove(String packageName, int versionCode) {
        return this.database.getRealm().mo3636b((C0129b<? super T>) new C2805la<Object>(this, packageName, versionCode)).mo3616a(Schedulers.m776io()).mo3673l();
    }

    /* renamed from: c */
    public /* synthetic */ void mo962c(String packageName, int versionCode, C13990F realm) {
        Database database = this.database;
        C14047ca c = realm.mo43540c(Installed.class);
        c.mo43679b("packageName", packageName);
        c.mo43669a("versionCode", Integer.valueOf(versionCode));
        database.deleteObject(realm, (C0106Z) c.mo43682c());
    }

    public C0120S<Boolean> isInstalled(String packageName) {
        return getInstalled(packageName).mo3669j(C2823ua.f6054a);
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m217b(Installed installed) {
        return Boolean.valueOf(installed != null && installed.getStatus() == 4);
    }

    public C0120S<Installed> getInstalled(String packageName) {
        return getInstalledAsList(packageName).mo3669j(C2775ba.f5992a);
    }

    /* renamed from: d */
    static /* synthetic */ Installed m221d(List installeds) {
        if (installeds.isEmpty()) {
            return null;
        }
        return (Installed) installeds.get(0);
    }

    /* renamed from: a */
    public /* synthetic */ C13990F mo953a() throws Exception {
        return this.database.get();
    }

    public C0120S<Installed> get(String packageName, int versionCode) {
        return C0120S.m633a((Callable<? extends T>) new C2819sa<Object>(this)).mo3669j(new C2815qa(packageName, versionCode)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2809na<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler());
    }

    /* renamed from: a */
    static /* synthetic */ C14047ca m212a(String packageName, int versionCode, C13990F realm) {
        C14047ca c = realm.mo43540c(Installed.class);
        c.mo43679b("packageName", packageName);
        c.mo43669a("versionCode", Integer.valueOf(versionCode));
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo954a(C14047ca installed) {
        return this.database.mo925c(installed);
    }

    /* renamed from: d */
    public /* synthetic */ C13990F mo963d() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Installed>> getAsList(String packageName, int versionCode) {
        return C0120S.m633a((Callable<? extends T>) new C2821ta<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2764X<Object,Object>(packageName, versionCode)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2768Z<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler());
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m219b(String packageName, int versionCode, C13990F realm) {
        C14047ca c = realm.mo43540c(Installed.class);
        c.mo43679b("packageName", packageName);
        c.mo43669a("versionCode", Integer.valueOf(versionCode));
        return c.mo43681b().mo43707c().mo3643c(RealmSchedulers.getScheduler());
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo964d(C14052da installeds) {
        return this.database.mo940f(installeds);
    }

    /* renamed from: f */
    public /* synthetic */ C13990F mo968f() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Installed>> getInstalledAsList(String packageName) {
        return C0120S.m633a((Callable<? extends T>) new C2796ia<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2811oa<Object,Object>(packageName)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2766Y<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2758U<Object,Object>(this));
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m220b(String packageName, C13990F realm) {
        C14047ca c = realm.mo43540c(Installed.class);
        c.mo43679b("packageName", packageName);
        return c.mo43681b().mo43707c().mo3643c(RealmSchedulers.getScheduler());
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo969f(C14052da installeds) {
        return this.database.mo940f(installeds);
    }

    /* renamed from: e */
    public /* synthetic */ C13990F mo965e() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Installed>> getInstalled(String[] apps) {
        return C0120S.m633a((Callable<? extends T>) new C2817ra<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2807ma<Object,Object>(apps)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2762W<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2793ha<Object,Object>(this));
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m216a(String[] apps, C13990F realm) {
        C14047ca c = realm.mo43540c(Installed.class);
        c.mo43674a("packageName", apps);
        return c.mo43681b().mo43707c().mo3643c(RealmSchedulers.getScheduler());
    }

    /* renamed from: e */
    public /* synthetic */ C0120S mo966e(C14052da installeds) {
        return this.database.mo940f(installeds);
    }

    public C0120S<List<Installation>> getInstallationsHistory() {
        return this.installationAccessor.getInstallationsHistory();
    }

    public void insertAll(List<Installed> installedList) {
        this.database.insertAll(installedList);
        for (Installed installed : installedList) {
            InstallationAccessor installationAccessor2 = this.installationAccessor;
            Installation installation = new Installation(installed.getPackageName(), installed.getName(), installed.getIcon(), installed.getVersionCode(), installed.getVersionName());
            installationAccessor2.insert(installation);
        }
    }

    public void insert(Installed installed) {
        this.database.insert(installed);
        InstallationAccessor installationAccessor2 = this.installationAccessor;
        Installation installation = new Installation(installed.getPackageName(), installed.getName(), installed.getIcon(), installed.getVersionCode(), installed.getVersionName());
        installationAccessor2.insert(installation);
    }

    /* renamed from: b */
    public /* synthetic */ C13990F mo957b() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Installed>> getAllAsList(String packageName) {
        return C0120S.m633a((Callable<? extends T>) new C2778ca<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2784ea<Object,Object>(packageName)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2799ja<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler());
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m215a(String packageName, C13990F realm) {
        C14047ca c = realm.mo43540c(Installed.class);
        c.mo43679b("packageName", packageName);
        return c.mo43681b().mo43707c().mo3643c(RealmSchedulers.getScheduler());
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo955a(C14052da installeds) {
        return this.database.mo940f(installeds);
    }
}
