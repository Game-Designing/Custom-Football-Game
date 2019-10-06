package p024io.realm;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import p024io.realm.C0105Y;
import p024io.realm.internal.C7331e;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.Collection;
import p024io.realm.internal.Collection.C7301d;
import p024io.realm.internal.Collection.C7302e;
import p024io.realm.internal.UncheckedRow;

/* renamed from: io.realm.B */
/* compiled from: OrderedRealmCollectionImpl */
abstract class C13982B<E extends C0105Y> extends AbstractList<E> implements OrderedRealmCollection<E> {

    /* renamed from: a */
    final C14048d f42358a;

    /* renamed from: b */
    final Class<E> f42359b;

    /* renamed from: c */
    final String f42360c;

    /* renamed from: d */
    final Collection f42361d;

    /* renamed from: io.realm.B$a */
    /* compiled from: OrderedRealmCollectionImpl */
    private class C13983a extends C7301d<E> {
        C13983a() {
            super(C13982B.this.f42361d);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public E m44470a(UncheckedRow row) {
            C13982B b = C13982B.this;
            return b.f42358a.mo43687a(b.f42359b, b.f42360c, row);
        }
    }

    /* renamed from: io.realm.B$b */
    /* compiled from: OrderedRealmCollectionImpl */
    private class C13984b extends C7302e<E> {
        C13984b(int start) {
            super(C13982B.this.f42361d, start);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public E m44472a(UncheckedRow row) {
            C13982B b = C13982B.this;
            return b.f42358a.mo43687a(b.f42359b, b.f42360c, row);
        }
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        mo43484a(i, (C0105Y) obj);
        throw null;
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        mo43486a((C0105Y) obj);
        throw null;
    }

    @Deprecated
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        mo43491b(i, (C0105Y) obj);
        throw null;
    }

    C13982B(C14048d realm, Collection collection, Class<E> clazz) {
        this(realm, collection, clazz, null);
    }

    C13982B(C14048d realm, Collection collection, String className) {
        this(realm, collection, null, className);
    }

    private C13982B(C14048d realm, Collection collection, Class<E> clazz, String className) {
        this.f42358a = realm;
        this.f42361d = collection;
        this.f42359b = clazz;
        this.f42360c = className;
    }

    /* renamed from: b */
    public boolean mo43492b() {
        return this.f42361d.isValid();
    }

    public boolean contains(Object object) {
        if (!isLoaded() || ((object instanceof C7344p) && ((C7344p) object).mo23791a().mo43515d() == C7331e.INSTANCE)) {
            return false;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((C0105Y) it.next()).equals(object)) {
                return true;
            }
        }
        return false;
    }

    public E get(int location) {
        this.f42358a.mo43690d();
        return this.f42358a.mo43687a(this.f42359b, this.f42360c, this.f42361d.getUncheckedRow(location));
    }

    /* renamed from: a */
    public boolean mo43485a() {
        this.f42358a.mo43690d();
        if (size() <= 0) {
            return false;
        }
        this.f42361d.clear();
        return true;
    }

    public Iterator<E> iterator() {
        return new C13983a();
    }

    public ListIterator<E> listIterator() {
        return new C13984b(0);
    }

    public ListIterator<E> listIterator(int location) {
        return new C13984b(location);
    }

    public int size() {
        if (!isLoaded()) {
            return 0;
        }
        long size = this.f42361d.size();
        return size > 2147483647L ? MoPubClientPositioning.NO_REPEAT : (int) size;
    }

    @Deprecated
    public E remove(int index) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean remove(Object object) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean removeAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    /* renamed from: b */
    public E mo43491b(int location, E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    /* renamed from: a */
    public boolean mo43486a(E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    /* renamed from: a */
    public void mo43484a(int index, E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean addAll(int location, java.util.Collection<? extends E> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean addAll(java.util.Collection<? extends E> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }
}
