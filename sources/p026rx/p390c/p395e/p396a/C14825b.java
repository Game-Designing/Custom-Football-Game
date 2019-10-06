package p026rx.p390c.p395e.p396a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.atomic.LinkedQueueNode;

/* renamed from: rx.c.e.a.b */
/* compiled from: BaseLinkedAtomicQueue */
abstract class C14825b<E> extends AbstractQueue<E> {

    /* renamed from: a */
    private final AtomicReference<C14826c<E>> f44084a = new AtomicReference<>();

    /* renamed from: b */
    private final AtomicReference<C14826c<E>> f44085b = new AtomicReference<>();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final C14826c<E> mo45961c() {
        return (C14826c) this.f44084a.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final C14826c<E> mo45960b(C14826c<E> node) {
        return (C14826c) this.f44084a.getAndSet(node);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final C14826c<E> mo45959b() {
        return (C14826c) this.f44085b.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C14826c<E> mo45957a() {
        return (C14826c) this.f44085b.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo45958a(C14826c<E> node) {
        this.f44085b.lazySet(node);
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        C14826c c;
        C14826c cVar;
        LinkedQueueNode<E> chaserNode = mo45959b();
        LinkedQueueNode<E> producerNode = mo45961c();
        int size = 0;
        while (chaserNode != producerNode && size < Integer.MAX_VALUE) {
            do {
                c = chaserNode.mo45969c();
                cVar = c;
            } while (c == null);
            chaserNode = cVar;
            size++;
        }
        return size;
    }

    public final boolean isEmpty() {
        return mo45959b() == mo45961c();
    }
}
