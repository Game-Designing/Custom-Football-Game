package p026rx.p390c.p391a;

import java.util.List;
import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.p390c.p392b.C14772c;
import rx.Subscriber;
import rx.internal.producers.SingleDelayedProducer;

/* renamed from: rx.c.a.mb */
/* compiled from: OperatorToObservableList */
public final class C14693mb<T> implements C0123b<List<T>, T> {

    /* renamed from: rx.c.a.mb$a */
    /* compiled from: OperatorToObservableList */
    static final class C14694a {

        /* renamed from: a */
        static final C14693mb<Object> f43723a = new C14693mb<>();
    }

    /* renamed from: a */
    public static <T> C14693mb<T> m46332a() {
        return C14694a.f43723a;
    }

    C14693mb() {
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super List<T>> o) {
        SingleDelayedProducer<List<T>> producer = new C14772c<>(o);
        Subscriber<T> result = new C14688lb<>(this, producer, o);
        o.add(result);
        o.setProducer(producer);
        return result;
    }
}
