package p026rx.p390c.p395e.p397b;

/* renamed from: rx.c.e.b.m */
/* compiled from: SpmcArrayQueue */
abstract class C14852m<E> extends C14854o<E> {

    /* renamed from: g */
    protected static final long f44140g = C14839G.m46554a(C14852m.class, "consumerIndex");
    private volatile long consumerIndex;

    public C14852m(int capacity) {
        super(capacity);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final long mo46063b() {
        return this.consumerIndex;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean mo46064b(long expect, long newValue) {
        return C14839G.f44131a.compareAndSwapLong(this, f44140g, expect, newValue);
    }
}
