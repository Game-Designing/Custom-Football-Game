package p005cm.aptoide.p006pt.database.accessors;

import java.util.List;
import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.database.realm.MigratedApp;
import p005cm.aptoide.p006pt.database.schedulers.RealmSchedulers;
import p024io.realm.C13990F;
import p024io.realm.C14047ca;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.database.accessors.AppcMigrationAccessor */
public class AppcMigrationAccessor extends SimpleAccessor<MigratedApp> {
    public AppcMigrationAccessor(Database db) {
        super(db, MigratedApp.class);
    }

    /* renamed from: a */
    public /* synthetic */ C13990F mo11641a() throws Exception {
        return this.database.get();
    }

    public C0120S<Boolean> isAppMigrated(String packageName) {
        C0120S f = C0120S.m633a((Callable<? extends T>) new C2774b<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2771a<Object,Object>(packageName));
        Database database = this.database;
        database.getClass();
        return f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2803kb<Object,Object>(database)).mo3634b(RealmSchedulers.getScheduler()).mo3669j(C2777c.f5994a).mo3669j(C2780d.f5997a);
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m7382a(String packageName, C13990F realm) {
        C14047ca c = realm.mo43540c(MigratedApp.class);
        c.mo43679b("packageName", packageName);
        return c.mo43681b().mo43707c().mo3643c(RealmSchedulers.getScheduler());
    }

    /* renamed from: a */
    static /* synthetic */ MigratedApp m7380a(List migratedApps) {
        if (migratedApps.isEmpty()) {
            return null;
        }
        return (MigratedApp) migratedApps.get(0);
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7381a(MigratedApp migratedApp) {
        return Boolean.valueOf(migratedApp != null);
    }

    public void insert(String packageName) {
        this.database.insert(new MigratedApp(packageName));
    }
}
