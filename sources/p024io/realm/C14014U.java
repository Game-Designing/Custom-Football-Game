package p024io.realm;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import p024io.realm.C0105Y;
import p024io.realm.internal.C7331e;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.Collection;
import p024io.realm.internal.LinkView;
import p024io.realm.internal.SortDescriptor;

/* renamed from: io.realm.U */
/* compiled from: RealmList */
public class C14014U<E extends C0105Y> extends AbstractList<E> implements OrderedRealmCollection<E> {

    /* renamed from: a */
    private final Collection f42478a;

    /* renamed from: b */
    protected Class<E> f42479b;

    /* renamed from: c */
    protected String f42480c;

    /* renamed from: d */
    final LinkView f42481d;

    /* renamed from: e */
    protected C14048d f42482e;

    /* renamed from: f */
    private List<E> f42483f;

    /* renamed from: io.realm.U$a */
    /* compiled from: RealmList */
    private class C14015a implements Iterator<E> {

        /* renamed from: a */
        int f42484a;

        /* renamed from: b */
        int f42485b;

        /* renamed from: c */
        int f42486c;

        private C14015a() {
            this.f42484a = 0;
            this.f42485b = -1;
            this.f42486c = C14014U.this.modCount;
        }

        public boolean hasNext() {
            C14014U.this.f42482e.mo43690d();
            mo43617a();
            return this.f42484a != C14014U.this.size();
        }

        public E next() {
            C14014U.this.f42482e.mo43690d();
            mo43617a();
            int i = this.f42484a;
            try {
                E next = C14014U.this.get(i);
                this.f42485b = i;
                this.f42484a = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                mo43617a();
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot access index ");
                sb.append(i);
                sb.append(" when size is ");
                sb.append(C14014U.this.size());
                sb.append(". Remember to check hasNext() before using next().");
                throw new NoSuchElementException(sb.toString());
            }
        }

        public void remove() {
            C14014U.this.f42482e.mo43690d();
            if (this.f42485b >= 0) {
                mo43617a();
                try {
                    C14014U.this.remove(this.f42485b);
                    if (this.f42485b < this.f42484a) {
                        this.f42484a--;
                    }
                    this.f42485b = -1;
                    this.f42486c = C14014U.this.modCount;
                } catch (IndexOutOfBoundsException e) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new IllegalStateException("Cannot call remove() twice. Must call next() in between.");
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo43617a() {
            if (C14014U.this.modCount != this.f42486c) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* renamed from: io.realm.U$b */
    /* compiled from: RealmList */
    private class C14016b extends C14015a implements ListIterator<E> {
        C14016b(int index) {
            super();
            if (index < 0 || index > C14014U.this.size()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Starting location must be a valid index: [0, ");
                sb.append(C14014U.this.size() - 1);
                sb.append("]. Index was ");
                sb.append(index);
                throw new IndexOutOfBoundsException(sb.toString());
            }
            this.f42484a = index;
        }

        public boolean hasPrevious() {
            return this.f42484a != 0;
        }

        public E previous() {
            mo43617a();
            int i = this.f42484a - 1;
            try {
                E previous = C14014U.this.get(i);
                this.f42484a = i;
                this.f42485b = i;
                return previous;
            } catch (IndexOutOfBoundsException e) {
                mo43617a();
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot access index less than zero. This was ");
                sb.append(i);
                sb.append(". Remember to check hasPrevious() before using previous().");
                throw new NoSuchElementException(sb.toString());
            }
        }

        public int nextIndex() {
            return this.f42484a;
        }

        public int previousIndex() {
            return this.f42484a - 1;
        }

        /* renamed from: b */
        public void set(E e) {
            C14014U.this.f42482e.mo43690d();
            if (this.f42485b >= 0) {
                mo43617a();
                try {
                    C14014U.this.set(this.f42485b, e);
                    this.f42486c = C14014U.this.modCount;
                } catch (IndexOutOfBoundsException e2) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new IllegalStateException();
            }
        }

        /* renamed from: a */
        public void add(E e) {
            C14014U.this.f42482e.mo43690d();
            mo43617a();
            try {
                int i = this.f42484a;
                C14014U.this.add(i, e);
                this.f42485b = -1;
                this.f42484a = i + 1;
                this.f42486c = C14014U.this.modCount;
            } catch (IndexOutOfBoundsException e2) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public C14014U() {
        this.f42478a = null;
        this.f42481d = null;
        this.f42483f = new ArrayList();
    }

    public C14014U(E... objects) {
        if (objects != null) {
            this.f42478a = null;
            this.f42481d = null;
            this.f42483f = new ArrayList(objects.length);
            Collections.addAll(this.f42483f, objects);
            return;
        }
        throw new IllegalArgumentException("The objects argument cannot be null");
    }

    C14014U(Class<E> clazz, LinkView linkView, C14048d realm) {
        this.f42478a = new Collection(realm.f42568g, linkView, (SortDescriptor) null);
        this.f42479b = clazz;
        this.f42481d = linkView;
        this.f42482e = realm;
    }

    /* renamed from: a */
    public boolean mo43600a() {
        return this.f42482e != null;
    }

    /* renamed from: c */
    private boolean m44672c() {
        LinkView linkView = this.f42481d;
        return linkView != null && linkView.mo23593c();
    }

    /* renamed from: a */
    public void add(int location, E object) {
        m44669b(object);
        if (mo43600a()) {
            m44668b();
            if (location < 0 || location > size()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid index ");
                sb.append(location);
                sb.append(", size is ");
                sb.append(size());
                throw new IndexOutOfBoundsException(sb.toString());
            }
            this.f42481d.mo23588a((long) location, ((C7344p) m44671c(object)).mo23791a().mo43515d().getIndex());
        } else {
            this.f42483f.add(location, object);
        }
        this.modCount++;
    }

    /* renamed from: a */
    public boolean add(E object) {
        m44669b(object);
        if (mo43600a()) {
            m44668b();
            this.f42481d.mo23587a(((C7344p) m44671c(object)).mo23791a().mo43515d().getIndex());
        } else {
            this.f42483f.add(object);
        }
        this.modCount++;
        return true;
    }

    /* renamed from: b */
    public E set(int location, E object) {
        m44669b(object);
        if (!mo43600a()) {
            return (C0105Y) this.f42483f.set(location, object);
        }
        m44668b();
        C7344p proxy = (C7344p) m44671c(object);
        E oldObject = get(location);
        this.f42481d.mo23591b((long) location, proxy.mo23791a().mo43515d().getIndex());
        return oldObject;
    }

    /* renamed from: c */
    private E m44671c(E object) {
        if (object instanceof C7344p) {
            C7344p proxy = (C7344p) object;
            if (proxy instanceof C14065j) {
                String listClassName = this.f42481d.mo23590b().mo23659c();
                C14048d c = proxy.mo23791a().mo43514c();
                C14048d dVar = this.f42482e;
                if (c == dVar) {
                    String objectClassName = ((C14065j) object).getType();
                    if (listClassName.equals(objectClassName)) {
                        return object;
                    }
                    throw new IllegalArgumentException(String.format(Locale.US, "The object has a different type from list's. Type of the list is '%s', type of object is '%s'.", new Object[]{listClassName, objectClassName}));
                } else if (dVar.f42565d == proxy.mo23791a().mo43514c().f42565d) {
                    throw new IllegalArgumentException("Cannot copy DynamicRealmObject between Realm instances.");
                } else {
                    throw new IllegalStateException("Cannot copy an object to a Realm instance created in another thread.");
                }
            } else if (proxy.mo23791a().mo43515d() != null && proxy.mo23791a().mo43514c().mo43545j().equals(this.f42482e.mo43545j())) {
                if (this.f42482e == proxy.mo23791a().mo43514c()) {
                    return object;
                }
                throw new IllegalArgumentException("Cannot copy an object from another Realm instance.");
            }
        }
        C13990F realm = (C13990F) this.f42482e;
        if (realm.mo43537b(object.getClass()).mo23671h()) {
            return realm.mo43539c(object);
        }
        return realm.mo43536b(object);
    }

    public void clear() {
        if (mo43600a()) {
            m44668b();
            this.f42481d.mo23586a();
        } else {
            this.f42483f.clear();
        }
        this.modCount++;
    }

    public E remove(int location) {
        E removedItem;
        if (mo43600a()) {
            m44668b();
            removedItem = get(location);
            this.f42481d.mo23592c((long) location);
        } else {
            removedItem = (C0105Y) this.f42483f.remove(location);
        }
        this.modCount++;
        return removedItem;
    }

    public boolean remove(Object object) {
        if (!mo43600a() || this.f42482e.mo43548y()) {
            return super.remove(object);
        }
        throw new IllegalStateException("Objects can only be removed from inside a write transaction");
    }

    public boolean removeAll(java.util.Collection<?> collection) {
        if (!mo43600a() || this.f42482e.mo43548y()) {
            return super.removeAll(collection);
        }
        throw new IllegalStateException("Objects can only be removed from inside a write transaction");
    }

    public E get(int location) {
        if (!mo43600a()) {
            return (C0105Y) this.f42483f.get(location);
        }
        m44668b();
        return this.f42482e.mo43686a(this.f42479b, this.f42480c, this.f42481d.mo23589b((long) location));
    }

    public int size() {
        if (!mo43600a()) {
            return this.f42483f.size();
        }
        m44668b();
        long size = this.f42481d.mo23594d();
        return size < 2147483647L ? (int) size : MoPubClientPositioning.NO_REPEAT;
    }

    public boolean contains(Object object) {
        if (!mo43600a()) {
            return this.f42483f.contains(object);
        }
        this.f42482e.mo43690d();
        if ((object instanceof C7344p) && ((C7344p) object).mo23791a().mo43515d() == C7331e.INSTANCE) {
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

    public Iterator<E> iterator() {
        if (mo43600a()) {
            return new C14015a();
        }
        return super.iterator();
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int location) {
        if (mo43600a()) {
            return new C14016b(location);
        }
        return super.listIterator(location);
    }

    /* renamed from: b */
    private void m44669b(E object) {
        if (object == null) {
            throw new IllegalArgumentException("RealmList does not accept null values");
        }
    }

    /* renamed from: b */
    private void m44668b() {
        this.f42482e.mo43690d();
        LinkView linkView = this.f42481d;
        if (linkView == null || !linkView.mo23593c()) {
            throw new IllegalStateException("Realm instance has been closed or this object or its parent has been deleted.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((mo43600a() ? this.f42479b : getClass()).getSimpleName());
        sb.append("@[");
        if (!mo43600a() || m44672c()) {
            for (int i = 0; i < size(); i++) {
                if (mo43600a()) {
                    sb.append(((C7344p) get(i)).mo23791a().mo43515d().getIndex());
                } else {
                    sb.append(System.identityHashCode(get(i)));
                }
                if (i < size() - 1) {
                    sb.append(',');
                }
            }
        } else {
            sb.append("invalid");
        }
        sb.append("]");
        return sb.toString();
    }
}
