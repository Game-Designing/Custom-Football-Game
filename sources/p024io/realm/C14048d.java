package p024io.realm;

import android.content.Context;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p024io.realm.exceptions.RealmMigrationNeededException;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.C7331e;
import p024io.realm.internal.C7347r;
import p024io.realm.internal.CheckedRow;
import p024io.realm.internal.SharedRealm;
import p024io.realm.internal.Table;
import p024io.realm.internal.UncheckedRow;
import p024io.realm.internal.async.C7323b;
import p024io.realm.log.RealmLog;

/* renamed from: io.realm.d */
/* compiled from: BaseRealm */
abstract class C14048d implements Closeable {

    /* renamed from: a */
    static volatile Context f42562a;

    /* renamed from: b */
    static final C7323b f42563b = C7323b.m16085a();

    /* renamed from: c */
    public static final C14051c f42564c = new C14051c();

    /* renamed from: d */
    final long f42565d;

    /* renamed from: e */
    protected final C14001L f42566e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C13996J f42567f;

    /* renamed from: g */
    protected SharedRealm f42568g;

    /* renamed from: h */
    protected final C14054ea f42569h;

    /* renamed from: io.realm.d$a */
    /* compiled from: BaseRealm */
    protected interface C14049a {
        /* renamed from: a */
        void mo43525a();
    }

    /* renamed from: io.realm.d$b */
    /* compiled from: BaseRealm */
    public static final class C14050b {

        /* renamed from: a */
        private C14048d f42570a;

        /* renamed from: b */
        private C7347r f42571b;

        /* renamed from: c */
        private C7327c f42572c;

        /* renamed from: d */
        private boolean f42573d;

        /* renamed from: e */
        private List<String> f42574e;

        /* renamed from: a */
        public void mo43698a(C14048d realm, C7347r row, C7327c columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
            this.f42570a = realm;
            this.f42571b = row;
            this.f42572c = columnInfo;
            this.f42573d = acceptDefaultValue;
            this.f42574e = excludeFields;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public C14048d mo43702e() {
            return this.f42570a;
        }

        /* renamed from: f */
        public C7347r mo43703f() {
            return this.f42571b;
        }

        /* renamed from: c */
        public C7327c mo43700c() {
            return this.f42572c;
        }

        /* renamed from: b */
        public boolean mo43699b() {
            return this.f42573d;
        }

        /* renamed from: d */
        public List<String> mo43701d() {
            return this.f42574e;
        }

        /* renamed from: a */
        public void mo43697a() {
            this.f42570a = null;
            this.f42571b = null;
            this.f42572c = null;
            this.f42573d = false;
            this.f42574e = null;
        }
    }

    /* renamed from: io.realm.d$c */
    /* compiled from: BaseRealm */
    static final class C14051c extends ThreadLocal<C14050b> {
        C14051c() {
        }

        /* access modifiers changed from: protected */
        public C14050b initialValue() {
            return new C14050b();
        }
    }

    C14048d(C13996J cache) {
        this(cache.mo43553a());
        this.f42567f = cache;
    }

    C14048d(C14001L configuration) {
        this.f42565d = Thread.currentThread().getId();
        this.f42566e = configuration;
        C14021a aVar = null;
        this.f42567f = null;
        if (this instanceof C13990F) {
            aVar = new C14021a(this);
        }
        this.f42568g = SharedRealm.m15930a(configuration, aVar, true);
        this.f42569h = new C14054ea(this);
    }

    /* renamed from: y */
    public boolean mo43548y() {
        mo43690d();
        return this.f42568g.mo23636j();
    }

    /* renamed from: a */
    public void mo43533a() {
        mo43688a(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo43688a(boolean ignoreReadOnly) {
        mo43690d();
        this.f42568g.mo23621a(ignoreReadOnly);
    }

    /* renamed from: g */
    public void mo43543g() {
        mo43690d();
        this.f42568g.mo23624c();
    }

    /* renamed from: b */
    public void mo43538b() {
        mo43690d();
        this.f42568g.mo23623b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo43690d() {
        SharedRealm sharedRealm = this.f42568g;
        if (sharedRealm == null || sharedRealm.isClosed()) {
            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
        } else if (this.f42565d != Thread.currentThread().getId()) {
            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo43689c() {
        if (!this.f42568g.mo23636j()) {
            throw new IllegalStateException("Changing Realm data can only be done from inside a transaction.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo43691e() {
        if (!mo43548y()) {
            throw new IllegalStateException("Changing Realm data can only be done from inside a transaction.");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo43692f() {
        if (this.f42566e.mo43576q()) {
            throw new IllegalArgumentException("You cannot perform changes to a schema. Please update app and restart.");
        }
    }

    /* renamed from: j */
    public String mo43545j() {
        return this.f42566e.mo43567h();
    }

    /* renamed from: i */
    public C14001L mo43544i() {
        return this.f42566e;
    }

    /* renamed from: x */
    public long mo43547x() {
        return this.f42568g.mo23631g();
    }

    public void close() {
        if (this.f42565d == Thread.currentThread().getId()) {
            C13996J j = this.f42567f;
            if (j != null) {
                j.mo43555a(this);
            } else {
                mo43694h();
            }
        } else {
            throw new IllegalStateException("Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo43694h() {
        this.f42567f = null;
        SharedRealm sharedRealm = this.f42568g;
        if (sharedRealm != null) {
            sharedRealm.close();
            this.f42568g = null;
        }
        C14054ea eaVar = this.f42569h;
        if (eaVar != null) {
            eaVar.mo43711a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo43695h(long version) {
        this.f42568g.mo23633h(version);
    }

    /* renamed from: v */
    public C14054ea mo43546v() {
        return this.f42569h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <E extends C0105Y> E mo43687a(Class<E> clazz, String dynamicClassName, UncheckedRow row) {
        if (dynamicClassName != null) {
            return new C14065j(this, CheckedRow.m15876a(row));
        }
        return this.f42566e.mo43572l().mo23749a(clazz, this, row, this.f42569h.mo43710a(clazz), false, Collections.emptyList());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <E extends C0105Y> E mo43686a(Class<E> clazz, String dynamicClassName, long rowIndex) {
        Class<E> cls = clazz;
        String str = dynamicClassName;
        long j = rowIndex;
        boolean isDynamicRealmObject = str != null;
        Table table = isDynamicRealmObject ? this.f42569h.mo43726f(str) : this.f42569h.mo43722c(clazz);
        if (isDynamicRealmObject) {
            return new C14065j(this, j != -1 ? table.mo23664e(j) : C7331e.INSTANCE);
        }
        return this.f42566e.mo43572l().mo23749a(clazz, this, j != -1 ? table.mo23672i(j) : C7331e.INSTANCE, this.f42569h.mo43710a(clazz), false, Collections.emptyList());
    }

    /* renamed from: a */
    static boolean m44787a(C14001L configuration) {
        AtomicBoolean realmDeleted = new AtomicBoolean(true);
        C13996J.m44566a(configuration, (C13997a) new C14041b(configuration, realmDeleted));
        return realmDeleted.get();
    }

    /* renamed from: a */
    protected static void m44786a(C14001L configuration, C14020X migration, C14049a callback, RealmMigrationNeededException cause) throws FileNotFoundException {
        if (configuration == null) {
            throw new IllegalArgumentException("RealmConfiguration must be provided");
        } else if (configuration.mo43576q()) {
            throw new IllegalArgumentException("Manual migrations are not supported for synced Realms");
        } else if (migration == null && configuration.mo43566g() == null) {
            throw new RealmMigrationNeededException(configuration.mo43567h(), "RealmMigration must be provided", cause);
        } else {
            AtomicBoolean fileNotFound = new AtomicBoolean(false);
            C13996J.m44566a(configuration, (C13997a) new C14046c(configuration, fileNotFound, migration, callback));
            if (fileNotFound.get()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot migrate a Realm file which doesn't exist: ");
                sb.append(configuration.mo43567h());
                throw new FileNotFoundException(sb.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        SharedRealm sharedRealm = this.f42568g;
        if (sharedRealm != null && !sharedRealm.isClosed()) {
            RealmLog.m16238c("Remember to call close() on all Realm instances. Realm %s is being finalized without being closed, this can lead to running out of native memory.", this.f42566e.mo43567h());
            C13996J j = this.f42567f;
            if (j != null) {
                j.mo43557c();
            }
        }
        super.finalize();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: w */
    public SharedRealm mo43696w() {
        return this.f42568g;
    }
}
