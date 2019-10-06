package kotlin.p374a;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.p376c.p378b.p379a.C14276a;

/* renamed from: kotlin.a.l */
/* compiled from: Collections.kt */
public final class C14265l implements ListIterator, C14276a {

    /* renamed from: a */
    public static final C14265l f43210a = new C14265l();

    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private C14265l() {
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public int nextIndex() {
        return 0;
    }

    public int previousIndex() {
        return -1;
    }

    public Void next() {
        throw new NoSuchElementException();
    }

    public Void previous() {
        throw new NoSuchElementException();
    }
}
