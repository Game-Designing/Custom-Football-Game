package p026rx.p390c.p395e.p397b;

import java.util.Iterator;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: rx.c.e.b.A */
/* compiled from: SpscUnboundedArrayQueue */
public class C14833A<E> extends C14835C<E> implements C14850k {

    /* renamed from: g */
    static final int f44119g = Integer.getInteger("jctools.spsc.max.lookahead.step", Opcodes.ACC_SYNTHETIC).intValue();

    /* renamed from: h */
    private static final long f44120h;

    /* renamed from: i */
    private static final long f44121i;

    /* renamed from: j */
    private static final long f44122j = ((long) C14839G.f44131a.arrayBaseOffset(Object[].class));

    /* renamed from: k */
    private static final int f44123k;

    /* renamed from: l */
    private static final Object f44124l = new Object();

    static {
        int scale = C14839G.f44131a.arrayIndexScale(Object[].class);
        if (4 == scale) {
            f44123k = 2;
        } else if (8 == scale) {
            f44123k = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        try {
            f44120h = C14839G.f44131a.objectFieldOffset(C14838F.class.getDeclaredField("producerIndex"));
            try {
                f44121i = C14839G.f44131a.objectFieldOffset(C14835C.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e) {
                InternalError ex = new InternalError();
                ex.initCause(e);
                throw ex;
            }
        } catch (NoSuchFieldException e2) {
            InternalError ex2 = new InternalError();
            ex2.initCause(e2);
            throw ex2;
        }
    }

    public C14833A(int bufferSize) {
        int p2capacity = C14849j.m46569b(bufferSize);
        long mask = (long) (p2capacity - 1);
        E[] buffer = new Object[(p2capacity + 1)];
        this.f44130d = buffer;
        this.f44129c = mask;
        m46544a(p2capacity);
        this.f44126f = buffer;
        this.f44125e = mask;
        this.f44128b = mask - 1;
        m46553c(0);
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final boolean offer(E e) {
        if (e != null) {
            E[] buffer = this.f44130d;
            long index = this.producerIndex;
            long mask = this.f44129c;
            long offset = m46541a(index, mask);
            if (index < this.f44128b) {
                return m46548a(buffer, e, index, offset);
            }
            int lookAheadStep = this.f44127a;
            long lookAheadElementOffset = m46541a(((long) lookAheadStep) + index, mask);
            if (m46542a(buffer, lookAheadElementOffset) == null) {
                this.f44128b = (((long) lookAheadStep) + index) - 1;
                long j = lookAheadElementOffset;
                return m46548a(buffer, e, index, offset);
            }
            if (m46542a(buffer, m46541a(1 + index, mask)) != null) {
                return m46548a(buffer, e, index, offset);
            }
            int i = lookAheadStep;
            m46545a(buffer, index, offset, e, mask);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    /* renamed from: a */
    private boolean m46548a(E[] buffer, E e, long index, long offset) {
        m46546a((Object[]) buffer, offset, (Object) e);
        m46553c(1 + index);
        return true;
    }

    /* renamed from: a */
    private void m46545a(E[] oldBuffer, long currIndex, long offset, E e, long mask) {
        E[] newBuffer = new Object[oldBuffer.length];
        this.f44130d = newBuffer;
        this.f44128b = (currIndex + mask) - 1;
        m46546a((Object[]) newBuffer, offset, (Object) e);
        m46547a(oldBuffer, newBuffer);
        m46546a((Object[]) oldBuffer, offset, f44124l);
        m46553c(1 + currIndex);
    }

    /* renamed from: a */
    private void m46547a(E[] curr, E[] next) {
        m46546a((Object[]) curr, m46540a((long) (curr.length - 1)), (Object) next);
    }

    /* renamed from: a */
    private E[] m46549a(E[] curr) {
        return (Object[]) m46542a(curr, m46540a((long) (curr.length - 1)));
    }

    public final E poll() {
        E[] buffer = this.f44126f;
        long index = this.consumerIndex;
        long mask = this.f44125e;
        long offset = m46541a(index, mask);
        Object e = m46542a(buffer, offset);
        boolean isNextBuffer = e == f44124l;
        if (e != null && !isNextBuffer) {
            m46546a((Object[]) buffer, offset, (Object) null);
            m46552b(1 + index);
            return e;
        } else if (!isNextBuffer) {
            return null;
        } else {
            return m46551b(m46549a(buffer), index, mask);
        }
    }

    /* renamed from: b */
    private E m46551b(E[] nextBuffer, long index, long mask) {
        this.f44126f = nextBuffer;
        long offsetInNew = m46541a(index, mask);
        E n = m46542a(nextBuffer, offsetInNew);
        if (n == null) {
            return null;
        }
        m46546a((Object[]) nextBuffer, offsetInNew, (Object) null);
        m46552b(1 + index);
        return n;
    }

    public final E peek() {
        E[] buffer = this.f44126f;
        long index = this.consumerIndex;
        long mask = this.f44125e;
        Object e = m46542a(buffer, m46541a(index, mask));
        if (e != f44124l) {
            return e;
        }
        return m46543a((E[]) m46549a(buffer), index, mask);
    }

    /* renamed from: a */
    private E m46543a(E[] nextBuffer, long index, long mask) {
        this.f44126f = nextBuffer;
        return m46542a(nextBuffer, m46541a(index, mask));
    }

    public final int size() {
        long before;
        long currentProducerIndex;
        long after = m46539a();
        do {
            before = after;
            currentProducerIndex = m46550b();
            after = m46539a();
        } while (before != after);
        return (int) (currentProducerIndex - after);
    }

    /* renamed from: a */
    private void m46544a(int capacity) {
        this.f44127a = Math.min(capacity / 4, f44119g);
    }

    /* renamed from: b */
    private long m46550b() {
        return C14839G.f44131a.getLongVolatile(this, f44120h);
    }

    /* renamed from: a */
    private long m46539a() {
        return C14839G.f44131a.getLongVolatile(this, f44121i);
    }

    /* renamed from: c */
    private void m46553c(long v) {
        C14839G.f44131a.putOrderedLong(this, f44120h, v);
    }

    /* renamed from: b */
    private void m46552b(long v) {
        C14839G.f44131a.putOrderedLong(this, f44121i, v);
    }

    /* renamed from: a */
    private static long m46541a(long index, long mask) {
        return m46540a(index & mask);
    }

    /* renamed from: a */
    private static long m46540a(long index) {
        return f44122j + (index << f44123k);
    }

    /* renamed from: a */
    private static void m46546a(Object[] buffer, long offset, Object e) {
        C14839G.f44131a.putOrderedObject(buffer, offset, e);
    }

    /* renamed from: a */
    private static <E> Object m46542a(E[] buffer, long offset) {
        return C14839G.f44131a.getObjectVolatile(buffer, offset);
    }
}
