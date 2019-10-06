package p320f.p321a.p327d.p336f;

import io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.p327d.p330c.C13273h;

/* renamed from: f.a.d.f.a */
/* compiled from: MpscLinkedQueue */
public final class C13703a<T> implements C13273h<T> {

    /* renamed from: a */
    private final AtomicReference<C13704a<T>> f41738a = new AtomicReference<>();

    /* renamed from: b */
    private final AtomicReference<C13704a<T>> f41739b = new AtomicReference<>();

    /* renamed from: f.a.d.f.a$a */
    /* compiled from: MpscLinkedQueue */
    static final class C13704a<E> extends AtomicReference<C13704a<E>> {

        /* renamed from: a */
        private E f41740a;

        C13704a() {
        }

        C13704a(E val) {
            mo42679a(val);
        }

        /* renamed from: a */
        public E mo42677a() {
            E temp = mo42680b();
            mo42679a((E) null);
            return temp;
        }

        /* renamed from: b */
        public E mo42680b() {
            return this.f41740a;
        }

        /* renamed from: a */
        public void mo42679a(E newValue) {
            this.f41740a = newValue;
        }

        /* renamed from: a */
        public void mo42678a(C13704a<E> n) {
            lazySet(n);
        }

        /* renamed from: c */
        public C13704a<E> mo42681c() {
            return (C13704a) get();
        }
    }

    public C13703a() {
        LinkedQueueNode<T> node = new C13704a<>();
        mo42673a(node);
        mo42675b(node);
    }

    public boolean offer(T e) {
        if (e != null) {
            LinkedQueueNode<T> nextNode = new C13704a<>(e);
            mo42675b(nextNode).mo42678a((C13704a<E>) nextNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T poll() {
        C13704a c;
        C13704a aVar;
        T currConsumerNode = mo42672a();
        LinkedQueueNode<T> nextNode = currConsumerNode.mo42681c();
        if (nextNode != null) {
            T nextValue = nextNode.mo42677a();
            mo42673a(nextNode);
            return nextValue;
        } else if (currConsumerNode == mo42676c()) {
            return null;
        } else {
            do {
                c = currConsumerNode.mo42681c();
                aVar = c;
            } while (c == null);
            T nextValue2 = aVar.mo42677a();
            mo42673a(aVar);
            return nextValue2;
        }
    }

    public void clear() {
        while (poll() != null) {
            if (isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C13704a<T> mo42676c() {
        return (C13704a) this.f41738a.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C13704a<T> mo42675b(C13704a<T> node) {
        return (C13704a) this.f41738a.getAndSet(node);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C13704a<T> mo42674b() {
        return (C13704a) this.f41739b.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C13704a<T> mo42672a() {
        return (C13704a) this.f41739b.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42673a(C13704a<T> node) {
        this.f41739b.lazySet(node);
    }

    public boolean isEmpty() {
        return mo42674b() == mo42676c();
    }
}
