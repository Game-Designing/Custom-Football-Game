package p026rx.p390c.p395e.p397b;

import p026rx.p390c.p395e.p396a.C14826c;
import rx.internal.util.atomic.LinkedQueueNode;

/* renamed from: rx.c.e.b.i */
/* compiled from: MpscLinkedQueue */
public final class C14848i<E> extends C14840a<E> {
    public C14848i() {
        mo46055b(this.consumerNode);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C14826c<E> mo46055b(C14826c<E> newVal) {
        C14826c<E> cVar;
        do {
            cVar = this.producerNode;
        } while (!C14839G.f44131a.compareAndSwapObject(this, C14844e.f44134a, cVar, newVal));
        return cVar;
    }

    public boolean offer(E nextValue) {
        if (nextValue != null) {
            LinkedQueueNode<E> nextNode = new C14826c<>(nextValue);
            mo46055b(nextNode).mo45967a((C14826c<E>) nextNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E poll() {
        C14826c c;
        C14826c cVar;
        E currConsumerNode = mo46042b();
        LinkedQueueNode<E> nextNode = currConsumerNode.mo45969c();
        if (nextNode != null) {
            E nextValue = nextNode.mo45965a();
            mo46041a(nextNode);
            return nextValue;
        } else if (currConsumerNode == mo46044a()) {
            return null;
        } else {
            do {
                c = currConsumerNode.mo45969c();
                cVar = c;
            } while (c == null);
            E nextValue2 = cVar.mo45965a();
            this.consumerNode = cVar;
            return nextValue2;
        }
    }

    public E peek() {
        C14826c c;
        C14826c cVar;
        LinkedQueueNode<E> currConsumerNode = this.consumerNode;
        LinkedQueueNode<E> nextNode = currConsumerNode.mo45969c();
        if (nextNode != null) {
            return nextNode.mo45968b();
        }
        if (currConsumerNode == mo46044a()) {
            return null;
        }
        do {
            c = currConsumerNode.mo45969c();
            cVar = c;
        } while (c == null);
        return cVar.mo45968b();
    }
}
