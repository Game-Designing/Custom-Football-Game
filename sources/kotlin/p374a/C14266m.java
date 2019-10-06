package kotlin.p374a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.p376c.p378b.C14279d;
import kotlin.p376c.p378b.C14281f;
import kotlin.p376c.p378b.p379a.C14276a;

/* renamed from: kotlin.a.m */
/* compiled from: Collections.kt */
public final class C14266m implements List, Serializable, RandomAccess, C14276a {

    /* renamed from: a */
    public static final C14266m f43211a = new C14266m();

    public /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return C14279d.m45909a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return C14279d.m45910a(this, tArr);
    }

    private C14266m() {
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return mo44393a((Void) obj);
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return mo44398b((Void) obj);
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return mo44399c((Void) obj);
        }
        return -1;
    }

    public final /* bridge */ int size() {
        return mo44392a();
    }

    public boolean equals(Object other) {
        return (other instanceof List) && ((List) other).isEmpty();
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "[]";
    }

    /* renamed from: a */
    public int mo44392a() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    /* renamed from: a */
    public boolean mo44393a(Void element) {
        C14281f.m45916b(element, "element");
        return false;
    }

    public boolean containsAll(Collection elements) {
        C14281f.m45916b(elements, "elements");
        return elements.isEmpty();
    }

    public Void get(int index) {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty list doesn't contain element at index ");
        sb.append(index);
        sb.append('.');
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* renamed from: b */
    public int mo44398b(Void element) {
        C14281f.m45916b(element, "element");
        return -1;
    }

    /* renamed from: c */
    public int mo44399c(Void element) {
        C14281f.m45916b(element, "element");
        return -1;
    }

    public Iterator iterator() {
        return C14265l.f43210a;
    }

    public ListIterator listIterator() {
        return C14265l.f43210a;
    }

    public ListIterator listIterator(int index) {
        if (index == 0) {
            return C14265l.f43210a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index: ");
        sb.append(index);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public List subList(int fromIndex, int toIndex) {
        if (fromIndex == 0 && toIndex == 0) {
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("fromIndex: ");
        sb.append(fromIndex);
        sb.append(", toIndex: ");
        sb.append(toIndex);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    private final Object readResolve() {
        return f43211a;
    }
}
