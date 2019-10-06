package p026rx.p390c.p391a;

import java.util.Comparator;
import java.util.List;
import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.p027b.C14541q;
import p026rx.p390c.p392b.C14772c;
import rx.Subscriber;
import rx.internal.producers.SingleDelayedProducer;

/* renamed from: rx.c.a.pb */
/* compiled from: OperatorToObservableSortedList */
public final class C14705pb<T> implements C0123b<List<T>, T> {

    /* renamed from: a */
    private static final Comparator f43763a = new C14706a();

    /* renamed from: b */
    final Comparator<? super T> f43764b;

    /* renamed from: c */
    final int f43765c;

    /* renamed from: rx.c.a.pb$a */
    /* compiled from: OperatorToObservableSortedList */
    static final class C14706a implements Comparator<Object> {
        C14706a() {
        }

        public int compare(Object t1, Object t2) {
            return ((Comparable) t1).compareTo((Comparable) t2);
        }
    }

    public C14705pb(C14541q<? super T, ? super T, Integer> sortFunction, int initialCapacity) {
        this.f43765c = initialCapacity;
        this.f43764b = new C14697nb(this, sortFunction);
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super List<T>> child) {
        SingleDelayedProducer<List<T>> producer = new C14772c<>(child);
        Subscriber<T> result = new C14702ob<>(this, producer, child);
        child.add(result);
        child.setProducer(producer);
        return result;
    }
}
