package p026rx.p390c.p391a;

import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.p027b.C0132p;
import p026rx.p390c.p392b.C14772c;
import rx.Subscriber;
import rx.internal.producers.SingleDelayedProducer;

/* renamed from: rx.c.a.ha */
/* compiled from: OperatorAny */
public final class C14670ha<T> implements C0123b<Boolean, T> {

    /* renamed from: a */
    final C0132p<? super T, Boolean> f43673a;

    /* renamed from: b */
    final boolean f43674b;

    public C14670ha(C0132p<? super T, Boolean> predicate, boolean returnOnEmpty) {
        this.f43673a = predicate;
        this.f43674b = returnOnEmpty;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super Boolean> child) {
        SingleDelayedProducer<Boolean> producer = new C14772c<>(child);
        Subscriber<T> s = new C14667ga<>(this, producer, child);
        child.add(s);
        child.setProducer(producer);
        return s;
    }
}
