package p024io.realm;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: io.realm.c */
/* compiled from: BaseRealm */
class C14046c implements C13997a {

    /* renamed from: a */
    final /* synthetic */ C14001L f42551a;

    /* renamed from: b */
    final /* synthetic */ AtomicBoolean f42552b;

    /* renamed from: c */
    final /* synthetic */ C14020X f42553c;

    /* renamed from: d */
    final /* synthetic */ C14049a f42554d;

    C14046c(C14001L l, AtomicBoolean atomicBoolean, C14020X x, C14049a aVar) {
        this.f42551a = l;
        this.f42552b = atomicBoolean;
        this.f42553c = x;
        this.f42554d = aVar;
    }

    /* renamed from: a */
    public void mo43558a(int count) {
        if (count != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot migrate a Realm file that is already open: ");
            sb.append(this.f42551a.mo43567h());
            throw new IllegalStateException(sb.toString());
        } else if (!new File(this.f42551a.mo43567h()).exists()) {
            this.f42552b.set(true);
        } else {
            C14020X x = this.f42553c;
            if (x == null) {
                x = this.f42551a.mo43566g();
            }
            C14020X realmMigration = x;
            C14061h realm = null;
            try {
                realm = C14061h.m44875b(this.f42551a);
                realm.mo43533a();
                realmMigration.migrate(realm, realm.mo43547x(), this.f42551a.mo43573m());
                realm.mo43695h(this.f42551a.mo43573m());
                realm.mo43543g();
                if (realm != null) {
                    realm.close();
                    this.f42554d.mo43525a();
                }
            } catch (RuntimeException e) {
                if (realm != null) {
                    realm.mo43538b();
                }
                throw e;
            } catch (Throwable th) {
                if (realm != null) {
                    realm.close();
                    this.f42554d.mo43525a();
                }
                throw th;
            }
        }
    }
}
