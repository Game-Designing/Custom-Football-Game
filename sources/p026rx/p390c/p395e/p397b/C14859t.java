package p026rx.p390c.p395e.p397b;

/* renamed from: rx.c.e.b.t */
/* compiled from: SpscArrayQueue */
public final class C14859t<E> extends C14864y<E> {
    public C14859t(int capacity) {
        super(capacity);
    }

    public boolean offer(E e) {
        if (e != null) {
            E[] lElementBuffer = this.f44139e;
            long index = this.producerIndex;
            long offset = mo46045a(index);
            if (mo46050b(lElementBuffer, offset) != null) {
                return false;
            }
            mo46048a(lElementBuffer, offset, e);
            m46579d(1 + index);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E poll() {
        long index = this.consumerIndex;
        long offset = mo46045a(index);
        E[] lElementBuffer = this.f44139e;
        E e = mo46050b(lElementBuffer, offset);
        if (e == null) {
            return null;
        }
        mo46048a(lElementBuffer, offset, null);
        m46578c(1 + index);
        return e;
    }

    public E peek() {
        return mo46049b(mo46045a(this.consumerIndex));
    }

    public int size() {
        long before;
        long currentProducerIndex;
        long after = m46576a();
        do {
            before = after;
            currentProducerIndex = m46577b();
            after = m46576a();
        } while (before != after);
        return (int) (currentProducerIndex - after);
    }

    public boolean isEmpty() {
        return m46577b() == m46576a();
    }

    /* renamed from: d */
    private void m46579d(long v) {
        C14839G.f44131a.putOrderedLong(this, C14865z.f44146h, v);
    }

    /* renamed from: c */
    private void m46578c(long v) {
        C14839G.f44131a.putOrderedLong(this, C14861v.f44145i, v);
    }

    /* renamed from: b */
    private long m46577b() {
        return C14839G.f44131a.getLongVolatile(this, C14865z.f44146h);
    }

    /* renamed from: a */
    private long m46576a() {
        return C14839G.f44131a.getLongVolatile(this, C14861v.f44145i);
    }
}
