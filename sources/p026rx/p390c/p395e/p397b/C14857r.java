package p026rx.p390c.p395e.p397b;

/* renamed from: rx.c.e.b.r */
/* compiled from: SpmcArrayQueue */
abstract class C14857r<E> extends C14853n<E> {

    /* renamed from: f */
    protected static final long f44141f = C14839G.m46554a(C14857r.class, "producerIndex");
    private volatile long producerIndex;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final long mo46065a() {
        return this.producerIndex;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo46066c(long v) {
        C14839G.f44131a.putOrderedLong(this, f44141f, v);
    }

    public C14857r(int capacity) {
        super(capacity);
    }
}
