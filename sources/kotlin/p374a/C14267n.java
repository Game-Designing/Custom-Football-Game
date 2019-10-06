package kotlin.p374a;

import java.util.Iterator;
import kotlin.p376c.p378b.p379a.C14276a;

/* renamed from: kotlin.a.n */
/* compiled from: Iterators.kt */
public abstract class C14267n implements Iterator<Integer>, C14276a {
    public abstract int nextInt();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
