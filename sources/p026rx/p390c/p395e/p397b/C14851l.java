package p026rx.p390c.p395e.p397b;

/* renamed from: rx.c.e.b.l */
/* compiled from: SpmcArrayQueue */
public final class C14851l<E> extends C14855p<E> {
    public C14851l(int capacity) {
        super(capacity);
    }

    public boolean offer(E e) {
        if (e != null) {
            E[] lb = this.f44139e;
            long lMask = this.f44138d;
            long currProducerIndex = mo46065a();
            long offset = mo46045a(currProducerIndex);
            if (mo46050b(lb, offset) == null) {
                mo46051b(lb, offset, e);
                mo46066c(1 + currProducerIndex);
            } else if (currProducerIndex - mo46063b() > lMask) {
                return false;
            } else {
                do {
                } while (mo46050b(lb, offset) != null);
            }
            mo46051b(lb, offset, e);
            mo46066c(1 + currProducerIndex);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long currentConsumerIndex;
        long currProducerIndexCache = mo46067c();
        do {
            currentConsumerIndex = mo46063b();
            if (currentConsumerIndex >= currProducerIndexCache) {
                long currProducerIndex = mo46065a();
                if (currentConsumerIndex >= currProducerIndex) {
                    return null;
                }
                mo46068d(currProducerIndex);
            }
        } while (!mo46064b(currentConsumerIndex, 1 + currentConsumerIndex));
        long offset = mo46045a(currentConsumerIndex);
        E[] lb = this.f44139e;
        E e = mo46047a(lb, offset);
        mo46048a(lb, offset, null);
        return e;
    }

    public E peek() {
        Object b;
        Object obj;
        long currProducerIndexCache = mo46067c();
        do {
            long currentConsumerIndex = mo46063b();
            if (currentConsumerIndex >= currProducerIndexCache) {
                long currProducerIndex = mo46065a();
                if (currentConsumerIndex >= currProducerIndex) {
                    return null;
                }
                mo46068d(currProducerIndex);
            }
            b = mo46049b(mo46045a(currentConsumerIndex));
            obj = b;
        } while (b == null);
        return obj;
    }

    public int size() {
        long before;
        long currentProducerIndex;
        long after = mo46063b();
        do {
            before = after;
            currentProducerIndex = mo46065a();
            after = mo46063b();
        } while (before != after);
        return (int) (currentProducerIndex - after);
    }

    public boolean isEmpty() {
        return mo46063b() == mo46065a();
    }
}
