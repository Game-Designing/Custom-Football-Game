package p026rx.p390c.p395e.p396a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p026rx.p390c.p395e.p397b.C14849j;

/* renamed from: rx.c.e.a.f */
/* compiled from: SpscExactAtomicArrayQueue */
public final class C14829f<T> extends AtomicReferenceArray<T> implements Queue<T> {

    /* renamed from: a */
    final int f44092a;

    /* renamed from: b */
    final int f44093b;

    /* renamed from: c */
    final AtomicLong f44094c = new AtomicLong();

    /* renamed from: d */
    final AtomicLong f44095d = new AtomicLong();

    public C14829f(int capacity) {
        super(C14849j.m46569b(capacity));
        int len = length();
        this.f44092a = len - 1;
        this.f44093b = len - capacity;
    }

    public boolean offer(T value) {
        if (value != null) {
            long pi = this.f44094c.get();
            int m = this.f44092a;
            if (get(((int) (((long) this.f44093b) + pi)) & m) != null) {
                return false;
            }
            int offset = ((int) pi) & m;
            this.f44094c.lazySet(1 + pi);
            lazySet(offset, value);
            return true;
        }
        throw new NullPointerException();
    }

    public T poll() {
        long ci = this.f44095d.get();
        int offset = ((int) ci) & this.f44092a;
        T value = get(offset);
        if (value == null) {
            return null;
        }
        this.f44095d.lazySet(1 + ci);
        lazySet(offset, null);
        return value;
    }

    public T peek() {
        return get(this.f44092a & ((int) this.f44095d.get()));
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.f44094c == this.f44095d;
    }

    public int size() {
        long ci = this.f44095d.get();
        while (true) {
            long pi = this.f44094c.get();
            long ci2 = this.f44095d.get();
            if (ci == ci2) {
                return (int) (pi - ci2);
            }
            ci = ci2;
        }
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    public T remove() {
        throw new UnsupportedOperationException();
    }

    public T element() {
        throw new UnsupportedOperationException();
    }
}
