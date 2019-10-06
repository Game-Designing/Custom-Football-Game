package p026rx.p390c.p395e.p396a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p026rx.p390c.p395e.p397b.C14849j;

/* renamed from: rx.c.e.a.g */
/* compiled from: SpscLinkedArrayQueue */
public final class C14830g<T> implements Queue<T> {

    /* renamed from: a */
    static final int f44096a = Integer.getInteger("jctools.spsc.max.lookahead.step", Opcodes.ACC_SYNTHETIC).intValue();

    /* renamed from: b */
    private static final Object f44097b = new Object();

    /* renamed from: c */
    final AtomicLong f44098c = new AtomicLong();

    /* renamed from: d */
    int f44099d;

    /* renamed from: e */
    long f44100e;

    /* renamed from: f */
    int f44101f;

    /* renamed from: g */
    AtomicReferenceArray<Object> f44102g;

    /* renamed from: h */
    int f44103h;

    /* renamed from: i */
    AtomicReferenceArray<Object> f44104i;

    /* renamed from: j */
    final AtomicLong f44105j = new AtomicLong();

    public C14830g(int bufferSize) {
        int p2capacity = C14849j.m46569b(bufferSize);
        int mask = p2capacity - 1;
        AtomicReferenceArray<Object> buffer = new AtomicReferenceArray<>(p2capacity + 1);
        this.f44102g = buffer;
        this.f44101f = mask;
        m46509a(p2capacity);
        this.f44104i = buffer;
        this.f44103h = mask;
        this.f44100e = (long) (mask - 1);
    }

    public boolean offer(T e) {
        AtomicReferenceArray<Object> buffer = this.f44102g;
        long index = m46516b();
        int mask = this.f44101f;
        int offset = m46504a(index, mask);
        if (index < this.f44100e) {
            return m46514a(buffer, e, index, offset);
        }
        int lookAheadStep = this.f44099d;
        if (m46506a(buffer, m46504a(((long) lookAheadStep) + index, mask)) == null) {
            this.f44100e = (((long) lookAheadStep) + index) - 1;
            return m46514a(buffer, e, index, offset);
        } else if (m46506a(buffer, m46504a(1 + index, mask)) == null) {
            return m46514a(buffer, e, index, offset);
        } else {
            m46512a(buffer, index, offset, e, (long) mask);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m46514a(AtomicReferenceArray<Object> buffer, T e, long index, int offset) {
        m46511a(buffer, offset, (Object) e);
        m46518b(1 + index);
        return true;
    }

    /* renamed from: a */
    private void m46512a(AtomicReferenceArray<Object> oldBuffer, long currIndex, int offset, T e, long mask) {
        AtomicReferenceArray<Object> newBuffer = new AtomicReferenceArray<>(oldBuffer.length());
        this.f44102g = newBuffer;
        this.f44100e = (currIndex + mask) - 1;
        m46511a(newBuffer, offset, (Object) e);
        m46513a(oldBuffer, newBuffer);
        m46511a(oldBuffer, offset, f44097b);
        m46518b(1 + currIndex);
    }

    /* renamed from: a */
    private void m46513a(AtomicReferenceArray<Object> curr, AtomicReferenceArray<Object> next) {
        int length = curr.length() - 1;
        m46515b(length);
        m46511a(curr, length, (Object) next);
    }

    /* renamed from: a */
    private AtomicReferenceArray<Object> m46508a(AtomicReferenceArray<Object> curr) {
        int length = curr.length() - 1;
        m46515b(length);
        return (AtomicReferenceArray) m46506a(curr, length);
    }

    public T poll() {
        AtomicReferenceArray<Object> buffer = this.f44104i;
        long index = m46505a();
        int mask = this.f44103h;
        int offset = m46504a(index, mask);
        Object e = m46506a(buffer, offset);
        boolean isNextBuffer = e == f44097b;
        if (e != null && !isNextBuffer) {
            m46511a(buffer, offset, (Object) null);
            m46510a(1 + index);
            return e;
        } else if (isNextBuffer) {
            return m46517b(m46508a(buffer), index, mask);
        } else {
            return null;
        }
    }

    /* renamed from: b */
    private T m46517b(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.f44104i = nextBuffer;
        int offsetInNew = m46504a(index, mask);
        T n = m46506a(nextBuffer, offsetInNew);
        if (n == null) {
            return null;
        }
        m46511a(nextBuffer, offsetInNew, (Object) null);
        m46510a(1 + index);
        return n;
    }

    public T peek() {
        AtomicReferenceArray<Object> buffer = this.f44104i;
        long index = m46505a();
        int mask = this.f44103h;
        Object e = m46506a(buffer, m46504a(index, mask));
        if (e == f44097b) {
            return m46507a(m46508a(buffer), index, mask);
        }
        return e;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* renamed from: a */
    private T m46507a(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.f44104i = nextBuffer;
        return m46506a(nextBuffer, m46504a(index, mask));
    }

    public int size() {
        long before;
        long currentProducerIndex;
        long after = m46519c();
        do {
            before = after;
            currentProducerIndex = m46520d();
            after = m46519c();
        } while (before != after);
        return (int) (currentProducerIndex - after);
    }

    public boolean isEmpty() {
        return m46520d() == m46519c();
    }

    /* renamed from: a */
    private void m46509a(int capacity) {
        this.f44099d = Math.min(capacity / 4, f44096a);
    }

    /* renamed from: d */
    private long m46520d() {
        return this.f44098c.get();
    }

    /* renamed from: c */
    private long m46519c() {
        return this.f44105j.get();
    }

    /* renamed from: b */
    private long m46516b() {
        return this.f44098c.get();
    }

    /* renamed from: a */
    private long m46505a() {
        return this.f44105j.get();
    }

    /* renamed from: b */
    private void m46518b(long v) {
        this.f44098c.lazySet(v);
    }

    /* renamed from: a */
    private void m46510a(long v) {
        this.f44105j.lazySet(v);
    }

    /* renamed from: a */
    private static int m46504a(long index, int mask) {
        int i = ((int) index) & mask;
        m46515b(i);
        return i;
    }

    /* renamed from: b */
    private static int m46515b(int index) {
        return index;
    }

    /* renamed from: a */
    private static void m46511a(AtomicReferenceArray<Object> buffer, int offset, Object e) {
        buffer.lazySet(offset, e);
    }

    /* renamed from: a */
    private static <E> Object m46506a(AtomicReferenceArray<Object> buffer, int offset) {
        return buffer.get(offset);
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object o) {
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

    /* renamed from: a */
    public boolean mo45996a(T first, T second) {
        AtomicReferenceArray<Object> buffer = this.f44102g;
        long p = m46520d();
        int m = this.f44101f;
        if (m46506a(buffer, m46504a(p + 2, m)) == null) {
            int pi = m46504a(p, m);
            m46511a(buffer, pi + 1, (Object) second);
            m46511a(buffer, pi, (Object) first);
            m46518b(2 + p);
        } else {
            AtomicReferenceArray<Object> newBuffer = new AtomicReferenceArray<>(buffer.length());
            this.f44102g = newBuffer;
            int pi2 = m46504a(p, m);
            m46511a(newBuffer, pi2 + 1, (Object) second);
            m46511a(newBuffer, pi2, (Object) first);
            m46513a(buffer, newBuffer);
            m46511a(buffer, pi2, f44097b);
            m46518b(2 + p);
        }
        return true;
    }
}
