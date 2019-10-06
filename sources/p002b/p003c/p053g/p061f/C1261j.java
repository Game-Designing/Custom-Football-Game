package p002b.p003c.p053g.p061f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: b.c.g.f.j */
/* compiled from: MapCollections */
abstract class C1261j<K, V> {

    /* renamed from: a */
    C1263b f4054a;

    /* renamed from: b */
    C1264c f4055b;

    /* renamed from: c */
    C1266e f4056c;

    /* renamed from: b.c.g.f.j$a */
    /* compiled from: MapCollections */
    final class C1262a<T> implements Iterator<T> {

        /* renamed from: a */
        final int f4057a;

        /* renamed from: b */
        int f4058b;

        /* renamed from: c */
        int f4059c;

        /* renamed from: d */
        boolean f4060d = false;

        C1262a(int offset) {
            this.f4057a = offset;
            this.f4058b = C1261j.this.mo9024c();
        }

        public boolean hasNext() {
            return this.f4059c < this.f4058b;
        }

        public T next() {
            if (hasNext()) {
                Object res = C1261j.this.mo9017a(this.f4059c, this.f4057a);
                this.f4059c++;
                this.f4060d = true;
                return res;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f4060d) {
                this.f4059c--;
                this.f4058b--;
                this.f4060d = false;
                C1261j.this.mo9020a(this.f4059c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: b.c.g.f.j$b */
    /* compiled from: MapCollections */
    final class C1263b implements Set<Entry<K, V>> {
        C1263b() {
        }

        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            mo9092a((Entry) obj);
            throw null;
        }

        /* renamed from: a */
        public boolean mo9092a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int oldSize = C1261j.this.mo9024c();
            for (Entry<K, V> entry : collection) {
                C1261j.this.mo9021a(entry.getKey(), entry.getValue());
            }
            return oldSize != C1261j.this.mo9024c();
        }

        public void clear() {
            C1261j.this.mo9019a();
        }

        public boolean contains(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry<?, ?> e = (Entry) o;
            int index = C1261j.this.mo9016a(e.getKey());
            if (index < 0) {
                return false;
            }
            return C1256e.m5910a(C1261j.this.mo9017a(index, 1), e.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return C1261j.this.mo9024c() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C1265d();
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return C1261j.this.mo9024c();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object object) {
            return C1261j.m5932a((Set<T>) this, object);
        }

        public int hashCode() {
            int result = 0;
            for (int i = C1261j.this.mo9024c() - 1; i >= 0; i--) {
                int i2 = 0;
                Object key = C1261j.this.mo9017a(i, 0);
                Object value = C1261j.this.mo9017a(i, 1);
                int hashCode = key == null ? 0 : key.hashCode();
                if (value != null) {
                    i2 = value.hashCode();
                }
                result += i2 ^ hashCode;
            }
            return result;
        }
    }

    /* renamed from: b.c.g.f.j$c */
    /* compiled from: MapCollections */
    final class C1264c implements Set<K> {
        C1264c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C1261j.this.mo9019a();
        }

        public boolean contains(Object object) {
            return C1261j.this.mo9016a(object) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C1261j.m5931a(C1261j.this.mo9023b(), collection);
        }

        public boolean isEmpty() {
            return C1261j.this.mo9024c() == 0;
        }

        public Iterator<K> iterator() {
            return new C1262a(0);
        }

        public boolean remove(Object object) {
            int index = C1261j.this.mo9016a(object);
            if (index < 0) {
                return false;
            }
            C1261j.this.mo9020a(index);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C1261j.m5933b(C1261j.this.mo9023b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C1261j.m5934c(C1261j.this.mo9023b(), collection);
        }

        public int size() {
            return C1261j.this.mo9024c();
        }

        public Object[] toArray() {
            return C1261j.this.mo9085b(0);
        }

        public <T> T[] toArray(T[] array) {
            return C1261j.this.mo9084a(array, 0);
        }

        public boolean equals(Object object) {
            return C1261j.m5932a((Set<T>) this, object);
        }

        public int hashCode() {
            int result = 0;
            for (int i = C1261j.this.mo9024c() - 1; i >= 0; i--) {
                int i2 = 0;
                Object obj = C1261j.this.mo9017a(i, 0);
                if (obj != null) {
                    i2 = obj.hashCode();
                }
                result += i2;
            }
            return result;
        }
    }

    /* renamed from: b.c.g.f.j$d */
    /* compiled from: MapCollections */
    final class C1265d implements Iterator<Entry<K, V>>, Entry<K, V> {

        /* renamed from: a */
        int f4064a;

        /* renamed from: b */
        int f4065b;

        /* renamed from: c */
        boolean f4066c = false;

        C1265d() {
            this.f4064a = C1261j.this.mo9024c() - 1;
            this.f4065b = -1;
        }

        public boolean hasNext() {
            return this.f4065b < this.f4064a;
        }

        public Entry<K, V> next() {
            if (hasNext()) {
                this.f4065b++;
                this.f4066c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f4066c) {
                C1261j.this.mo9020a(this.f4065b);
                this.f4065b--;
                this.f4064a--;
                this.f4066c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f4066c) {
                return C1261j.this.mo9017a(this.f4065b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f4066c) {
                return C1261j.this.mo9017a(this.f4065b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V object) {
            if (this.f4066c) {
                return C1261j.this.mo9018a(this.f4065b, object);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean equals(Object o) {
            if (this.f4066c) {
                boolean z = false;
                if (!(o instanceof Entry)) {
                    return false;
                }
                Entry<?, ?> e = (Entry) o;
                if (C1256e.m5910a(e.getKey(), C1261j.this.mo9017a(this.f4065b, 0)) && C1256e.m5910a(e.getValue(), C1261j.this.mo9017a(this.f4065b, 1))) {
                    z = true;
                }
                return z;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public int hashCode() {
            if (this.f4066c) {
                int i = 0;
                Object key = C1261j.this.mo9017a(this.f4065b, 0);
                Object value = C1261j.this.mo9017a(this.f4065b, 1);
                int hashCode = key == null ? 0 : key.hashCode();
                if (value != null) {
                    i = value.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append("=");
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* renamed from: b.c.g.f.j$e */
    /* compiled from: MapCollections */
    final class C1266e implements Collection<V> {
        C1266e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C1261j.this.mo9019a();
        }

        public boolean contains(Object object) {
            return C1261j.this.mo9022b(object) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return C1261j.this.mo9024c() == 0;
        }

        public Iterator<V> iterator() {
            return new C1262a(1);
        }

        public boolean remove(Object object) {
            int index = C1261j.this.mo9022b(object);
            if (index < 0) {
                return false;
            }
            C1261j.this.mo9020a(index);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int N = C1261j.this.mo9024c();
            boolean changed = false;
            int i = 0;
            while (i < N) {
                if (collection.contains(C1261j.this.mo9017a(i, 1))) {
                    C1261j.this.mo9020a(i);
                    i--;
                    N--;
                    changed = true;
                }
                i++;
            }
            return changed;
        }

        public boolean retainAll(Collection<?> collection) {
            int N = C1261j.this.mo9024c();
            boolean changed = false;
            int i = 0;
            while (i < N) {
                if (!collection.contains(C1261j.this.mo9017a(i, 1))) {
                    C1261j.this.mo9020a(i);
                    i--;
                    N--;
                    changed = true;
                }
                i++;
            }
            return changed;
        }

        public int size() {
            return C1261j.this.mo9024c();
        }

        public Object[] toArray() {
            return C1261j.this.mo9085b(1);
        }

        public <T> T[] toArray(T[] array) {
            return C1261j.this.mo9084a(array, 1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo9016a(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo9017a(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract V mo9018a(int i, V v);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9019a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9020a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9021a(K k, V v);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo9022b(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Map<K, V> mo9023b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract int mo9024c();

    C1261j() {
    }

    /* renamed from: a */
    public static <K, V> boolean m5931a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static <K, V> boolean m5933b(Map<K, V> map, Collection<?> collection) {
        int oldSize = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return oldSize != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m5934c(Map<K, V> map, Collection<?> collection) {
        int oldSize = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return oldSize != map.size();
    }

    /* renamed from: b */
    public Object[] mo9085b(int offset) {
        int N = mo9024c();
        Object[] result = new Object[N];
        for (int i = 0; i < N; i++) {
            result[i] = mo9017a(i, offset);
        }
        return result;
    }

    /* renamed from: a */
    public <T> T[] mo9084a(T[] array, int offset) {
        int N = mo9024c();
        if (array.length < N) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), N);
        }
        for (int i = 0; i < N; i++) {
            array[i] = mo9017a(i, offset);
        }
        if (array.length > N) {
            array[N] = null;
        }
        return array;
    }

    /* renamed from: a */
    public static <T> boolean m5932a(Set<T> set, Object object) {
        boolean z = true;
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set<?> s = (Set) object;
        try {
            if (set.size() != s.size() || !set.containsAll(s)) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    /* renamed from: d */
    public Set<Entry<K, V>> mo9086d() {
        if (this.f4054a == null) {
            this.f4054a = new C1263b<>();
        }
        return this.f4054a;
    }

    /* renamed from: e */
    public Set<K> mo9087e() {
        if (this.f4055b == null) {
            this.f4055b = new C1264c<>();
        }
        return this.f4055b;
    }

    /* renamed from: f */
    public Collection<V> mo9088f() {
        if (this.f4056c == null) {
            this.f4056c = new C1266e<>();
        }
        return this.f4056c;
    }
}
