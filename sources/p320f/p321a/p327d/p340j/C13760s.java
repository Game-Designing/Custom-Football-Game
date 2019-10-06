package p320f.p321a.p327d.p340j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: f.a.d.j.s */
/* compiled from: VolatileSizeArrayList */
public final class C13760s<T> extends AtomicInteger implements List<T>, RandomAccess {

    /* renamed from: a */
    final ArrayList<T> f41874a = new ArrayList<>();

    public int size() {
        return get();
    }

    public boolean isEmpty() {
        return get() == 0;
    }

    public boolean contains(Object o) {
        return this.f41874a.contains(o);
    }

    public Iterator<T> iterator() {
        return this.f41874a.iterator();
    }

    public Object[] toArray() {
        return this.f41874a.toArray();
    }

    public <E> E[] toArray(E[] a) {
        return this.f41874a.toArray(a);
    }

    public boolean add(T e) {
        boolean b = this.f41874a.add(e);
        lazySet(this.f41874a.size());
        return b;
    }

    public boolean remove(Object o) {
        boolean b = this.f41874a.remove(o);
        lazySet(this.f41874a.size());
        return b;
    }

    public boolean containsAll(Collection<?> c) {
        return this.f41874a.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean b = this.f41874a.addAll(c);
        lazySet(this.f41874a.size());
        return b;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        boolean b = this.f41874a.addAll(index, c);
        lazySet(this.f41874a.size());
        return b;
    }

    public boolean removeAll(Collection<?> c) {
        boolean b = this.f41874a.removeAll(c);
        lazySet(this.f41874a.size());
        return b;
    }

    public boolean retainAll(Collection<?> c) {
        boolean b = this.f41874a.retainAll(c);
        lazySet(this.f41874a.size());
        return b;
    }

    public void clear() {
        this.f41874a.clear();
        lazySet(0);
    }

    public T get(int index) {
        return this.f41874a.get(index);
    }

    public T set(int index, T element) {
        return this.f41874a.set(index, element);
    }

    public void add(int index, T element) {
        this.f41874a.add(index, element);
        lazySet(this.f41874a.size());
    }

    public T remove(int index) {
        T v = this.f41874a.remove(index);
        lazySet(this.f41874a.size());
        return v;
    }

    public int indexOf(Object o) {
        return this.f41874a.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return this.f41874a.lastIndexOf(o);
    }

    public ListIterator<T> listIterator() {
        return this.f41874a.listIterator();
    }

    public ListIterator<T> listIterator(int index) {
        return this.f41874a.listIterator(index);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return this.f41874a.subList(fromIndex, toIndex);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C13760s) {
            return this.f41874a.equals(((C13760s) obj).f41874a);
        }
        return this.f41874a.equals(obj);
    }

    public int hashCode() {
        return this.f41874a.hashCode();
    }

    public String toString() {
        return this.f41874a.toString();
    }
}
