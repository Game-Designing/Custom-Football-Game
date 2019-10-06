package p024io.realm;

import java.util.List;
import p024io.realm.C0105Y;
import p024io.realm.internal.C7336k;
import p024io.realm.internal.C7336k.C7337a;
import p024io.realm.internal.C7340m;
import p024io.realm.internal.C7340m.C7341a;
import p024io.realm.internal.C7347r;
import p024io.realm.internal.OsObject;
import p024io.realm.internal.OsObject.C7307b;
import p024io.realm.internal.SharedRealm;
import p024io.realm.internal.UncheckedRow;

/* renamed from: io.realm.D */
/* compiled from: ProxyState */
public final class C13986D<E extends C0105Y> implements C7341a {

    /* renamed from: a */
    private static C13987a f42364a = new C13987a();

    /* renamed from: b */
    private E f42365b;

    /* renamed from: c */
    private boolean f42366c = true;

    /* renamed from: d */
    private C7347r f42367d;

    /* renamed from: e */
    private OsObject f42368e;

    /* renamed from: f */
    private C14048d f42369f;

    /* renamed from: g */
    private boolean f42370g;

    /* renamed from: h */
    private List<String> f42371h;

    /* renamed from: i */
    private C7336k<C7307b> f42372i = new C7336k<>();

    /* renamed from: io.realm.D$a */
    /* compiled from: ProxyState */
    private static class C13987a implements C7337a<C7307b> {
        private C13987a() {
        }

        /* renamed from: a */
        public void mo23567a(C7307b pair, Object observer) {
            pair.mo23603a((C0105Y) observer, null);
        }
    }

    /* renamed from: io.realm.D$b */
    /* compiled from: ProxyState */
    static class C13988b<T extends C0105Y> implements C14040aa<T> {

        /* renamed from: a */
        private final C14000K<T> f42373a;

        C13988b(C14000K<T> listener) {
            if (listener != null) {
                this.f42373a = listener;
                return;
            }
            throw new IllegalArgumentException("Listener should not be null");
        }

        /* renamed from: a */
        public void mo43522a(T object, C14092y changes) {
            this.f42373a.mo43559a(object);
        }

        public boolean equals(Object obj) {
            return (obj instanceof C13988b) && this.f42373a == ((C13988b) obj).f42373a;
        }

        public int hashCode() {
            return this.f42373a.hashCode();
        }
    }

    public C13986D(E model) {
        this.f42365b = model;
    }

    /* renamed from: c */
    public C14048d mo43514c() {
        return this.f42369f;
    }

    /* renamed from: a */
    public void mo43507a(C14048d realm) {
        this.f42369f = realm;
    }

    /* renamed from: d */
    public C7347r mo43515d() {
        return this.f42367d;
    }

    /* renamed from: b */
    public void mo43513b(C7347r row) {
        this.f42367d = row;
    }

    /* renamed from: a */
    public boolean mo43510a() {
        return this.f42370g;
    }

    /* renamed from: a */
    public void mo43509a(boolean acceptDefaultValue) {
        this.f42370g = acceptDefaultValue;
    }

    /* renamed from: b */
    public List<String> mo43511b() {
        return this.f42371h;
    }

    /* renamed from: a */
    public void mo43508a(List<String> excludeFields) {
        this.f42371h = excludeFields;
    }

    /* renamed from: j */
    private void m44473j() {
        this.f42372i.mo23780a((C7337a<T>) f42364a);
    }

    /* renamed from: a */
    public void mo43506a(C14040aa<E> listener) {
        C7347r rVar = this.f42367d;
        if (rVar instanceof C7340m) {
            this.f42372i.mo23781a(new C7307b(this.f42365b, listener));
        } else if (rVar instanceof UncheckedRow) {
            m44474k();
            OsObject osObject = this.f42368e;
            if (osObject != null) {
                osObject.mo23599a(this.f42365b, listener);
            }
        }
    }

    /* renamed from: b */
    public void mo43512b(C14040aa<E> listener) {
        OsObject osObject = this.f42368e;
        if (osObject != null) {
            osObject.mo23601b(this.f42365b, listener);
        } else {
            this.f42372i.mo23783a(this.f42365b, listener);
        }
    }

    /* renamed from: h */
    public void mo43519h() {
        OsObject osObject = this.f42368e;
        if (osObject != null) {
            osObject.mo23598a(this.f42365b);
        } else {
            this.f42372i.mo23779a();
        }
    }

    /* renamed from: f */
    public boolean mo43517f() {
        return this.f42366c;
    }

    /* renamed from: i */
    public void mo43520i() {
        this.f42366c = false;
        this.f42371h = null;
    }

    /* renamed from: k */
    private void m44474k() {
        SharedRealm sharedRealm = this.f42369f.f42568g;
        if (sharedRealm != null && !sharedRealm.isClosed() && this.f42367d.mo23709e() && this.f42368e == null) {
            this.f42368e = new OsObject(this.f42369f.f42568g, (UncheckedRow) this.f42367d);
            this.f42368e.mo23600a(this.f42372i);
            this.f42372i = null;
        }
    }

    /* renamed from: e */
    public boolean mo43516e() {
        return !(this.f42367d instanceof C7340m);
    }

    /* renamed from: g */
    public void mo43518g() {
        C7347r rVar = this.f42367d;
        if (rVar instanceof C7340m) {
            ((C7340m) rVar).mo23788a();
        }
    }

    /* renamed from: a */
    public void mo23789a(C7347r row) {
        this.f42367d = row;
        m44473j();
        if (row.mo23709e()) {
            m44474k();
        }
    }
}
