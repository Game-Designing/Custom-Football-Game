package p026rx.p390c.p395e.p396a;

import rx.internal.util.atomic.LinkedQueueNode;

/* renamed from: rx.c.e.a.d */
/* compiled from: MpscLinkedAtomicQueue */
public final class C14827d<E> extends C14825b<E> {
    public C14827d() {
        LinkedQueueNode<E> node = new C14826c<>();
        mo45958a(node);
        mo45960b(node);
    }

    public boolean offer(E nextValue) {
        if (nextValue != null) {
            LinkedQueueNode<E> nextNode = new C14826c<>(nextValue);
            mo45960b(nextNode).mo45967a((C14826c<E>) nextNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E poll() {
        C14826c c;
        C14826c cVar;
        E currConsumerNode = mo45957a();
        LinkedQueueNode<E> nextNode = currConsumerNode.mo45969c();
        if (nextNode != null) {
            E nextValue = nextNode.mo45965a();
            mo45958a(nextNode);
            return nextValue;
        } else if (currConsumerNode == mo45961c()) {
            return null;
        } else {
            do {
                c = currConsumerNode.mo45969c();
                cVar = c;
            } while (c == null);
            E nextValue2 = cVar.mo45965a();
            mo45958a(cVar);
            return nextValue2;
        }
    }

    public E peek() {
        C14826c c;
        C14826c cVar;
        LinkedQueueNode<E> currConsumerNode = mo45957a();
        LinkedQueueNode<E> nextNode = currConsumerNode.mo45969c();
        if (nextNode != null) {
            return nextNode.mo45968b();
        }
        if (currConsumerNode == mo45961c()) {
            return null;
        }
        do {
            c = currConsumerNode.mo45969c();
            cVar = c;
        } while (c == null);
        return cVar.mo45968b();
    }
}
