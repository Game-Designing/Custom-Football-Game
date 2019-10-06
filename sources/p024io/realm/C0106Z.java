package p024io.realm;

import p024io.realm.internal.C0107f;
import p024io.realm.internal.C7331e;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.C7347r;
import p026rx.C0120S;

/* renamed from: io.realm.Z */
/* compiled from: RealmObject */
public abstract class C0106Z implements C0105Y, C0107f {
    public final void deleteFromRealm() {
        deleteFromRealm(this);
    }

    public static <E extends C0105Y> void deleteFromRealm(E object) {
        if (object instanceof C7344p) {
            C7344p proxy = (C7344p) object;
            if (proxy.mo23791a().mo43515d() == null) {
                throw new IllegalStateException("Object malformed: missing object in Realm. Make sure to instantiate RealmObjects with Realm.createObject()");
            } else if (proxy.mo23791a().mo43514c() != null) {
                proxy.mo23791a().mo43514c().mo43690d();
                C7347r row = proxy.mo23791a().mo43515d();
                row.mo23711f().mo23679m(row.getIndex());
                proxy.mo23791a().mo43513b((C7347r) C7331e.INSTANCE);
            } else {
                throw new IllegalStateException("Object malformed: missing Realm. Make sure to instantiate RealmObjects with Realm.createObject()");
            }
        } else {
            throw new IllegalArgumentException("Object not managed by Realm, so it cannot be removed.");
        }
    }

    public final boolean isValid() {
        return isValid(this);
    }

    public static <E extends C0105Y> boolean isValid(E object) {
        boolean z = true;
        if (!(object instanceof C7344p)) {
            return true;
        }
        C7347r row = ((C7344p) object).mo23791a().mo43515d();
        if (row == null || !row.mo23709e()) {
            z = false;
        }
        return z;
    }

    public final boolean isLoaded() {
        return isLoaded(this);
    }

    public static <E extends C0105Y> boolean isLoaded(E object) {
        if (!(object instanceof C7344p)) {
            return true;
        }
        C7344p proxy = (C7344p) object;
        proxy.mo23791a().mo43514c().mo43690d();
        return proxy.mo23791a().mo43516e();
    }

    public boolean isManaged() {
        return isManaged(this);
    }

    public static <E extends C0105Y> boolean isManaged(E object) {
        return object instanceof C7344p;
    }

    public final boolean load() {
        return load(this);
    }

    public static <E extends C0105Y> boolean load(E object) {
        if (isLoaded(object)) {
            return true;
        }
        if (!(object instanceof C7344p)) {
            return false;
        }
        ((C7344p) object).mo23791a().mo43518g();
        return true;
    }

    public final <E extends C0105Y> void addChangeListener(C14040aa<E> listener) {
        addChangeListener((E) this, listener);
    }

    public final <E extends C0105Y> void addChangeListener(C14000K<E> listener) {
        addChangeListener((E) this, listener);
    }

    public static <E extends C0105Y> void addChangeListener(E object, C14040aa<E> listener) {
        if (object == null) {
            throw new IllegalArgumentException("Object should not be null");
        } else if (listener == null) {
            throw new IllegalArgumentException("Listener should not be null");
        } else if (object instanceof C7344p) {
            C7344p proxy = (C7344p) object;
            C14048d realm = proxy.mo23791a().mo43514c();
            realm.mo43690d();
            realm.f42568g.f14229g.mo23727a("Listeners cannot be used on current thread.");
            proxy.mo23791a().mo43506a(listener);
        } else {
            throw new IllegalArgumentException("Cannot add listener from this unmanaged RealmObject (created outside of Realm)");
        }
    }

    public static <E extends C0105Y> void addChangeListener(E object, C14000K<E> listener) {
        addChangeListener(object, (C14040aa<E>) new C13988b<E>(listener));
    }

    public final void removeChangeListener(C14040aa listener) {
        removeChangeListener((E) this, listener);
    }

    public final void removeChangeListener(C14000K listener) {
        removeChangeListener((E) this, listener);
    }

    public static <E extends C0105Y> void removeChangeListener(E object, C14040aa listener) {
        if (object == null) {
            throw new IllegalArgumentException("Object should not be null");
        } else if (listener == null) {
            throw new IllegalArgumentException("Listener should not be null");
        } else if (object instanceof C7344p) {
            C7344p proxy = (C7344p) object;
            C14048d realm = proxy.mo23791a().mo43514c();
            realm.mo43690d();
            realm.f42568g.f14229g.mo23727a("Listeners cannot be used on current thread.");
            proxy.mo23791a().mo43512b(listener);
        } else {
            throw new IllegalArgumentException("Cannot remove listener from this unmanaged RealmObject (created outside of Realm)");
        }
    }

    public static <E extends C0105Y> void removeChangeListener(E object, C14000K<E> listener) {
        removeChangeListener(object, (C14040aa) new C13988b(listener));
    }

    @Deprecated
    public final void removeChangeListeners() {
        removeChangeListeners(this);
    }

    public final void removeAllChangeListeners() {
        removeAllChangeListeners(this);
    }

    @Deprecated
    public static <E extends C0105Y> void removeChangeListeners(E object) {
        removeAllChangeListeners(object);
    }

    public static <E extends C0105Y> void removeAllChangeListeners(E object) {
        if (object instanceof C7344p) {
            C7344p proxy = (C7344p) object;
            C14048d realm = proxy.mo23791a().mo43514c();
            realm.mo43690d();
            realm.f42568g.f14229g.mo23727a("Listeners cannot be used on current thread.");
            proxy.mo23791a().mo43519h();
            return;
        }
        throw new IllegalArgumentException("Cannot remove listeners from this unmanaged RealmObject (created outside of Realm)");
    }

    public final <E extends C0106Z> C0120S<E> asObservable() {
        return asObservable(this);
    }

    public static <E extends C0105Y> C0120S<E> asObservable(E object) {
        if (object instanceof C7344p) {
            C14048d realm = ((C7344p) object).mo23791a().mo43514c();
            if (realm instanceof C13990F) {
                return realm.f42566e.mo43571k().mo43643a((C13990F) realm, object);
            }
            if (realm instanceof C14061h) {
                return realm.f42566e.mo43571k().mo43646a((C14061h) realm, (C14065j) object);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(realm.getClass());
            sb.append(" does not support RxJava. See https://realm.io/docs/java/latest/#rxjava for more details.");
            throw new UnsupportedOperationException(sb.toString());
        }
        throw new IllegalArgumentException("Cannot create Observables from unmanaged RealmObjects");
    }
}
