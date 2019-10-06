package p320f.p321a.p327d.p336f;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p340j.C13758q;

/* renamed from: f.a.d.f.c */
/* compiled from: SpscLinkedArrayQueue */
public final class C13706c<T> implements C13273h<T> {

    /* renamed from: a */
    static final int f41747a = Integer.getInteger("jctools.spsc.max.lookahead.step", Opcodes.ACC_SYNTHETIC).intValue();

    /* renamed from: b */
    private static final Object f41748b = new Object();

    /* renamed from: c */
    final AtomicLong f41749c = new AtomicLong();

    /* renamed from: d */
    int f41750d;

    /* renamed from: e */
    long f41751e;

    /* renamed from: f */
    final int f41752f;

    /* renamed from: g */
    AtomicReferenceArray<Object> f41753g;

    /* renamed from: h */
    final int f41754h;

    /* renamed from: i */
    AtomicReferenceArray<Object> f41755i;

    /* renamed from: j */
    final AtomicLong f41756j = new AtomicLong();

    public C13706c(int bufferSize) {
        int p2capacity = C13758q.m43796a(Math.max(8, bufferSize));
        int mask = p2capacity - 1;
        AtomicReferenceArray<Object> buffer = new AtomicReferenceArray<>(p2capacity + 1);
        this.f41753g = buffer;
        this.f41752f = mask;
        m43671a(p2capacity);
        this.f41755i = buffer;
        this.f41754h = mask;
        this.f41751e = (long) (mask - 1);
        m43680b(0);
    }

    public boolean offer(T e) {
        if (e != null) {
            AtomicReferenceArray<Object> buffer = this.f41753g;
            long index = m43682d();
            int mask = this.f41752f;
            int offset = m43668a(index, mask);
            if (index < this.f41751e) {
                return m43676a(buffer, e, index, offset);
            }
            int lookAheadStep = this.f41750d;
            if (m43669a(buffer, m43668a(((long) lookAheadStep) + index, mask)) == null) {
                this.f41751e = (((long) lookAheadStep) + index) - 1;
                return m43676a(buffer, e, index, offset);
            } else if (m43669a(buffer, m43668a(1 + index, mask)) == null) {
                return m43676a(buffer, e, index, offset);
            } else {
                m43674a(buffer, index, offset, e, (long) mask);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    /* renamed from: a */
    private boolean m43676a(AtomicReferenceArray<Object> buffer, T e, long index, int offset) {
        m43673a(buffer, offset, (Object) e);
        m43680b(1 + index);
        return true;
    }

    /* renamed from: a */
    private void m43674a(AtomicReferenceArray<Object> oldBuffer, long currIndex, int offset, T e, long mask) {
        AtomicReferenceArray<Object> newBuffer = new AtomicReferenceArray<>(oldBuffer.length());
        this.f41753g = newBuffer;
        this.f41751e = (currIndex + mask) - 1;
        m43673a(newBuffer, offset, (Object) e);
        m43675a(oldBuffer, newBuffer);
        m43673a(oldBuffer, offset, f41748b);
        m43680b(1 + currIndex);
    }

    /* renamed from: a */
    private void m43675a(AtomicReferenceArray<Object> curr, AtomicReferenceArray<Object> next) {
        int length = curr.length() - 1;
        m43677b(length);
        m43673a(curr, length, (Object) next);
    }

    /* renamed from: b */
    private AtomicReferenceArray<Object> m43679b(AtomicReferenceArray<Object> curr, int nextIndex) {
        int nextOffset = m43677b(nextIndex);
        AtomicReferenceArray<Object> nextBuffer = (AtomicReferenceArray) m43669a(curr, nextOffset);
        m43673a(curr, nextOffset, (Object) null);
        return nextBuffer;
    }

    public T poll() {
        AtomicReferenceArray<Object> buffer = this.f41755i;
        long index = m43681c();
        int mask = this.f41754h;
        int offset = m43668a(index, mask);
        Object e = m43669a(buffer, offset);
        boolean isNextBuffer = e == f41748b;
        if (e != null && !isNextBuffer) {
            m43673a(buffer, offset, (Object) null);
            m43672a(1 + index);
            return e;
        } else if (isNextBuffer) {
            return m43678b(m43679b(buffer, mask + 1), index, mask);
        } else {
            return null;
        }
    }

    /* renamed from: b */
    private T m43678b(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.f41755i = nextBuffer;
        int offsetInNew = m43668a(index, mask);
        T n = m43669a(nextBuffer, offsetInNew);
        if (n != null) {
            m43673a(nextBuffer, offsetInNew, (Object) null);
            m43672a(1 + index);
        }
        return n;
    }

    /* renamed from: a */
    public T mo42688a() {
        AtomicReferenceArray<Object> buffer = this.f41755i;
        long index = m43681c();
        int mask = this.f41754h;
        Object e = m43669a(buffer, m43668a(index, mask));
        if (e == f41748b) {
            return m43670a(m43679b(buffer, mask + 1), index, mask);
        }
        return e;
    }

    /* renamed from: a */
    private T m43670a(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.f41755i = nextBuffer;
        return m43669a(nextBuffer, m43668a(index, mask));
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* renamed from: b */
    public int mo42690b() {
        long before;
        long currentProducerIndex;
        long after = m43683e();
        do {
            before = after;
            currentProducerIndex = m43684f();
            after = m43683e();
        } while (before != after);
        return (int) (currentProducerIndex - after);
    }

    public boolean isEmpty() {
        return m43684f() == m43683e();
    }

    /* renamed from: a */
    private void m43671a(int capacity) {
        this.f41750d = Math.min(capacity / 4, f41747a);
    }

    /* renamed from: f */
    private long m43684f() {
        return this.f41749c.get();
    }

    /* renamed from: e */
    private long m43683e() {
        return this.f41756j.get();
    }

    /* renamed from: d */
    private long m43682d() {
        return this.f41749c.get();
    }

    /* renamed from: c */
    private long m43681c() {
        return this.f41756j.get();
    }

    /* renamed from: b */
    private void m43680b(long v) {
        this.f41749c.lazySet(v);
    }

    /* renamed from: a */
    private void m43672a(long v) {
        this.f41756j.lazySet(v);
    }

    /* renamed from: a */
    private static int m43668a(long index, int mask) {
        int i = ((int) index) & mask;
        m43677b(i);
        return i;
    }

    /* renamed from: b */
    private static int m43677b(int index) {
        return index;
    }

    /* renamed from: a */
    private static void m43673a(AtomicReferenceArray<Object> buffer, int offset, Object e) {
        buffer.lazySet(offset, e);
    }

    /* renamed from: a */
    private static <E> Object m43669a(AtomicReferenceArray<Object> buffer, int offset) {
        return buffer.get(offset);
    }

    /* renamed from: a */
    public boolean mo42689a(T first, T second) {
        AtomicReferenceArray<Object> buffer = this.f41753g;
        long p = m43684f();
        int m = this.f41752f;
        if (m43669a(buffer, m43668a(p + 2, m)) == null) {
            int pi = m43668a(p, m);
            m43673a(buffer, pi + 1, (Object) second);
            m43673a(buffer, pi, (Object) first);
            m43680b(2 + p);
        } else {
            AtomicReferenceArray<Object> newBuffer = new AtomicReferenceArray<>(buffer.length());
            this.f41753g = newBuffer;
            int pi2 = m43668a(p, m);
            m43673a(newBuffer, pi2 + 1, (Object) second);
            m43673a(newBuffer, pi2, (Object) first);
            m43675a(buffer, newBuffer);
            m43673a(buffer, pi2, f41748b);
            m43680b(2 + p);
        }
        return true;
    }
}
