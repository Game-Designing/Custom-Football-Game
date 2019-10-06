package p024io.realm;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import p024io.realm.C0105Y;
import p026rx.C0120S;

/* renamed from: io.realm.da */
/* compiled from: RealmResults */
public class C14052da<E extends C0105Y> extends C13982B<E> {
    @Deprecated
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo43484a(int i, C0105Y y) {
        super.mo43484a(i, y);
        throw null;
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo43485a() {
        return super.mo43485a();
    }

    @Deprecated
    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo43486a(C0105Y y) {
        super.mo43486a(y);
        throw null;
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(int i, Collection collection) {
        super.addAll(i, collection);
        throw null;
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        super.addAll(collection);
        throw null;
    }

    @Deprecated
    /* renamed from: b */
    public /* bridge */ /* synthetic */ C0105Y mo43491b(int i, C0105Y y) {
        super.mo43491b(i, y);
        throw null;
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ boolean mo43492b() {
        return super.mo43492b();
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
        throw null;
    }

    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    public /* bridge */ /* synthetic */ C0105Y get(int i) {
        return super.get(i);
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ C0105Y remove(int i) {
        super.remove(i);
        throw null;
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        super.remove(obj);
        throw null;
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        super.removeAll(collection);
        throw null;
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        super.retainAll(collection);
        throw null;
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    C14052da(C14048d realm, p024io.realm.internal.Collection collection, Class<E> clazz) {
        super(realm, collection, clazz);
    }

    C14052da(C14048d realm, p024io.realm.internal.Collection collection, String className) {
        super(realm, collection, className);
    }

    public boolean isLoaded() {
        this.f42358a.mo43690d();
        return this.f42361d.isLoaded();
    }

    /* renamed from: d */
    public boolean mo43708d() {
        this.f42358a.mo43690d();
        this.f42361d.load();
        return true;
    }

    /* renamed from: a */
    public void mo43705a(C14000K<C14052da<E>> listener) {
        m44814a((Object) listener, true);
        this.f42361d.addListener(this, listener);
    }

    /* renamed from: a */
    private void m44814a(Object listener, boolean checkListener) {
        if (!checkListener || listener != null) {
            this.f42358a.mo43690d();
            this.f42358a.f42568g.f14229g.mo23727a("Listeners cannot be used on current thread.");
            return;
        }
        throw new IllegalArgumentException("Listener should not be null");
    }

    /* renamed from: b */
    public void mo43706b(C14000K<C14052da<E>> listener) {
        m44814a((Object) listener, true);
        this.f42361d.removeListener(this, listener);
    }

    /* renamed from: c */
    public C0120S<C14052da<E>> mo43707c() {
        C14048d dVar = this.f42358a;
        if (dVar instanceof C13990F) {
            return dVar.f42566e.mo43571k().mo43644a((C13990F) this.f42358a, this);
        }
        if (dVar instanceof C14061h) {
            return dVar.f42566e.mo43571k().mo43645a((C14061h) dVar, this);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f42358a.getClass());
        sb.append(" does not support RxJava.");
        throw new UnsupportedOperationException(sb.toString());
    }
}
