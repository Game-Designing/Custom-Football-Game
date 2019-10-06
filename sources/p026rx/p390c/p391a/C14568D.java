package p026rx.p390c.p391a;

import java.util.concurrent.Callable;
import p026rx.C0120S.C0122a;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p390c.p392b.C14772c;
import rx.internal.producers.SingleDelayedProducer;

/* renamed from: rx.c.a.D */
/* compiled from: OnSubscribeFromCallable */
public final class C14568D<T> implements C0122a<T> {

    /* renamed from: a */
    private final Callable<? extends T> f43412a;

    public C14568D(Callable<? extends T> resultFactory) {
        this.f43412a = resultFactory;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> subscriber) {
        SingleDelayedProducer<T> singleDelayedProducer = new C14772c<>(subscriber);
        subscriber.setProducer(singleDelayedProducer);
        try {
            singleDelayedProducer.mo45916a(this.f43412a.call());
        } catch (Throwable t) {
            C14927a.m46672a(t, (C0125T<?>) subscriber);
        }
    }
}
