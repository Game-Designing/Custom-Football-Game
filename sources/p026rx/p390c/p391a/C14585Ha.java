package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import rx.internal.operators.OperatorPublish.InnerProducer;

/* renamed from: rx.c.a.Ha */
/* compiled from: OperatorPublish */
class C14585Ha implements C0122a<T> {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f43448a;

    C14585Ha(AtomicReference atomicReference) {
        this.f43448a = atomicReference;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> child) {
        while (true) {
            C14590b bVar = (C14590b) this.f43448a.get();
            if (bVar == null || bVar.isUnsubscribed()) {
                C14590b bVar2 = new C14590b(this.f43448a);
                bVar2.mo45768b();
                if (!this.f43448a.compareAndSet(bVar, bVar2)) {
                    continue;
                } else {
                    bVar = bVar2;
                }
            }
            InnerProducer<T> inner = new C14589a<>(bVar, child);
            if (bVar.mo45767a(inner)) {
                child.add(inner);
                child.setProducer(inner);
                return;
            }
        }
    }
}
