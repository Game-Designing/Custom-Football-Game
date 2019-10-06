package p026rx.p390c.p395e.p397b;

import java.util.Iterator;

/* renamed from: rx.c.e.b.f */
/* compiled from: ConcurrentCircularArrayQueue */
public abstract class C14845f<E> extends C14846g<E> {

    /* renamed from: a */
    protected static final int f44135a = Integer.getInteger("sparse.shift", 0).intValue();

    /* renamed from: b */
    private static final long f44136b = ((long) (C14839G.f44131a.arrayBaseOffset(Object[].class) + (32 << (f44137c - f44135a))));

    /* renamed from: c */
    private static final int f44137c;

    /* renamed from: d */
    protected final long f44138d;

    /* renamed from: e */
    protected final E[] f44139e;

    static {
        int scale = C14839G.f44131a.arrayIndexScale(Object[].class);
        if (4 == scale) {
            f44137c = f44135a + 2;
        } else if (8 == scale) {
            f44137c = f44135a + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
    }

    public C14845f(int capacity) {
        int actualCapacity = C14849j.m46569b(capacity);
        this.f44138d = (long) (actualCapacity - 1);
        this.f44139e = new Object[((actualCapacity << f44135a) + 64)];
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final long mo46045a(long index) {
        return mo46046a(index, this.f44138d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final long mo46046a(long index, long mask) {
        return f44136b + ((index & mask) << f44137c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo46051b(E[] buffer, long offset, E e) {
        C14839G.f44131a.putObject(buffer, offset, e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo46048a(E[] buffer, long offset, E e) {
        C14839G.f44131a.putOrderedObject(buffer, offset, e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final E mo46047a(E[] buffer, long offset) {
        return C14839G.f44131a.getObject(buffer, offset);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final E mo46049b(long offset) {
        return mo46050b(this.f44139e, offset);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final E mo46050b(E[] buffer, long offset) {
        return C14839G.f44131a.getObjectVolatile(buffer, offset);
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }
}
