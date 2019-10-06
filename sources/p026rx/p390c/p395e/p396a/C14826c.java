package p026rx.p390c.p395e.p396a;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: rx.c.e.a.c */
/* compiled from: LinkedQueueNode */
public final class C14826c<E> extends AtomicReference<C14826c<E>> {

    /* renamed from: a */
    private E f44086a;

    public C14826c() {
    }

    public C14826c(E val) {
        mo45966a(val);
    }

    /* renamed from: a */
    public E mo45965a() {
        E temp = mo45968b();
        mo45966a((E) null);
        return temp;
    }

    /* renamed from: b */
    public E mo45968b() {
        return this.f44086a;
    }

    /* renamed from: a */
    public void mo45966a(E newValue) {
        this.f44086a = newValue;
    }

    /* renamed from: a */
    public void mo45967a(C14826c<E> n) {
        lazySet(n);
    }

    /* renamed from: c */
    public C14826c<E> mo45969c() {
        return (C14826c) get();
    }
}
