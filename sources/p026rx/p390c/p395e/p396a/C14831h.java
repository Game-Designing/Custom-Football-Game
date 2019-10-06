package p026rx.p390c.p395e.p396a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p026rx.p390c.p395e.p397b.C14849j;

/* renamed from: rx.c.e.a.h */
/* compiled from: SpscUnboundedAtomicArrayQueue */
public final class C14831h<T> implements Queue<T> {

    /* renamed from: a */
    static final int f44106a = Integer.getInteger("jctools.spsc.max.lookahead.step", Opcodes.ACC_SYNTHETIC).intValue();

    /* renamed from: b */
    private static final Object f44107b = new Object();

    /* renamed from: c */
    final AtomicLong f44108c = new AtomicLong();

    /* renamed from: d */
    int f44109d;

    /* renamed from: e */
    long f44110e;

    /* renamed from: f */
    int f44111f;

    /* renamed from: g */
    AtomicReferenceArray<Object> f44112g;

    /* renamed from: h */
    int f44113h;

    /* renamed from: i */
    AtomicReferenceArray<Object> f44114i;

    /* renamed from: j */
    final AtomicLong f44115j = new AtomicLong();

    public C14831h(int bufferSize) {
        int p2capacity = C14849j.m46569b(Math.max(8, bufferSize));
        int mask = p2capacity - 1;
        AtomicReferenceArray<Object> buffer = new AtomicReferenceArray<>(p2capacity + 1);
        this.f44112g = buffer;
        this.f44111f = mask;
        m46527a(p2capacity);
        this.f44114i = buffer;
        this.f44113h = mask;
        this.f44110e = (long) (mask - 1);
        m46536b(0);
    }

    public boolean offer(T e) {
        if (e != null) {
            AtomicReferenceArray<Object> buffer = this.f44112g;
            long index = m46534b();
            int mask = this.f44111f;
            int offset = m46522a(index, mask);
            if (index < this.f44110e) {
                return m46532a(buffer, e, index, offset);
            }
            int lookAheadStep = this.f44109d;
            if (m46524a(buffer, m46522a(((long) lookAheadStep) + index, mask)) == null) {
                this.f44110e = (((long) lookAheadStep) + index) - 1;
                return m46532a(buffer, e, index, offset);
            } else if (m46524a(buffer, m46522a(1 + index, mask)) != null) {
                return m46532a(buffer, e, index, offset);
            } else {
                m46530a(buffer, index, offset, e, (long) mask);
                return true;
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* renamed from: a */
    private boolean m46532a(AtomicReferenceArray<Object> buffer, T e, long index, int offset) {
        m46536b(1 + index);
        m46529a(buffer, offset, (Object) e);
        return true;
    }

    /* renamed from: a */
    private void m46530a(AtomicReferenceArray<Object> oldBuffer, long currIndex, int offset, T e, long mask) {
        AtomicReferenceArray<Object> newBuffer = new AtomicReferenceArray<>(oldBuffer.length());
        this.f44112g = newBuffer;
        this.f44110e = (currIndex + mask) - 1;
        m46536b(1 + currIndex);
        m46529a(newBuffer, offset, (Object) e);
        m46531a(oldBuffer, newBuffer);
        m46529a(oldBuffer, offset, f44107b);
    }

    /* renamed from: a */
    private void m46531a(AtomicReferenceArray<Object> curr, AtomicReferenceArray<Object> next) {
        int length = curr.length() - 1;
        m46533b(length);
        m46529a(curr, length, (Object) next);
    }

    /* renamed from: a */
    private AtomicReferenceArray<Object> m46526a(AtomicReferenceArray<Object> curr) {
        int length = curr.length() - 1;
        m46533b(length);
        return (AtomicReferenceArray) m46524a(curr, length);
    }

    public T poll() {
        AtomicReferenceArray<Object> buffer = this.f44114i;
        long index = m46523a();
        int mask = this.f44113h;
        int offset = m46522a(index, mask);
        Object e = m46524a(buffer, offset);
        boolean isNextBuffer = e == f44107b;
        if (e != null && !isNextBuffer) {
            m46528a(1 + index);
            m46529a(buffer, offset, (Object) null);
            return e;
        } else if (isNextBuffer) {
            return m46535b(m46526a(buffer), index, mask);
        } else {
            return null;
        }
    }

    /* renamed from: b */
    private T m46535b(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.f44114i = nextBuffer;
        int offsetInNew = m46522a(index, mask);
        T n = m46524a(nextBuffer, offsetInNew);
        if (n == null) {
            return null;
        }
        m46528a(1 + index);
        m46529a(nextBuffer, offsetInNew, (Object) null);
        return n;
    }

    public T peek() {
        AtomicReferenceArray<Object> buffer = this.f44114i;
        long index = m46523a();
        int mask = this.f44113h;
        Object e = m46524a(buffer, m46522a(index, mask));
        if (e == f44107b) {
            return m46525a(m46526a(buffer), index, mask);
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
    private T m46525a(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.f44114i = nextBuffer;
        return m46524a(nextBuffer, m46522a(index, mask));
    }

    public int size() {
        long before;
        long currentProducerIndex;
        long after = m46537c();
        do {
            before = after;
            currentProducerIndex = m46538d();
            after = m46537c();
        } while (before != after);
        return (int) (currentProducerIndex - after);
    }

    public boolean isEmpty() {
        return m46538d() == m46537c();
    }

    /* renamed from: a */
    private void m46527a(int capacity) {
        this.f44109d = Math.min(capacity / 4, f44106a);
    }

    /* renamed from: d */
    private long m46538d() {
        return this.f44108c.get();
    }

    /* renamed from: c */
    private long m46537c() {
        return this.f44115j.get();
    }

    /* renamed from: b */
    private long m46534b() {
        return this.f44108c.get();
    }

    /* renamed from: a */
    private long m46523a() {
        return this.f44115j.get();
    }

    /* renamed from: b */
    private void m46536b(long v) {
        this.f44108c.lazySet(v);
    }

    /* renamed from: a */
    private void m46528a(long v) {
        this.f44115j.lazySet(v);
    }

    /* renamed from: a */
    private static int m46522a(long index, int mask) {
        int i = ((int) index) & mask;
        m46533b(i);
        return i;
    }

    /* renamed from: b */
    private static int m46533b(int index) {
        return index;
    }

    /* renamed from: a */
    private static void m46529a(AtomicReferenceArray<Object> buffer, int offset, Object e) {
        buffer.lazySet(offset, e);
    }

    /* renamed from: a */
    private static <E> Object m46524a(AtomicReferenceArray<Object> buffer, int offset) {
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
}
