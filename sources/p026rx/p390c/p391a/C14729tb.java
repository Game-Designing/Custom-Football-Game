package p026rx.p390c.p391a;

import p026rx.C0120S.C0123b;
import p026rx.C0126V;
import p026rx.C14980ia;
import p026rx.p029i.C14978f;
import rx.Subscriber;

/* renamed from: rx.c.a.tb */
/* compiled from: OperatorUnsubscribeOn */
public class C14729tb<T> implements C0123b<T, T> {

    /* renamed from: a */
    final C0126V f43820a;

    public C14729tb(C0126V scheduler) {
        this.f43820a = scheduler;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> subscriber) {
        Subscriber<T> parent = new C14712qb<>(this, subscriber);
        subscriber.add(C14978f.m46781a(new C14725sb(this, parent)));
        return parent;
    }
}
