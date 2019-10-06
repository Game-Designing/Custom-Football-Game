package p026rx.p390c.p395e.p397b;

import java.util.Iterator;
import p026rx.p390c.p395e.p396a.C14826c;
import rx.internal.util.atomic.LinkedQueueNode;

/* renamed from: rx.c.e.b.a */
/* compiled from: BaseLinkedQueue */
abstract class C14840a<E> extends C14841b<E> {
    C14840a() {
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        C14826c c;
        C14826c cVar;
        LinkedQueueNode<E> chaserNode = mo46043c();
        LinkedQueueNode<E> producerNode = mo46044a();
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
        return mo46043c() == mo46044a();
    }
}
