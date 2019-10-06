package p026rx.p390c.p391a;

import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import rx.Subscriber;

/* renamed from: rx.c.a.db */
/* compiled from: OperatorTakeWhile */
public final class C14656db<T> implements C0123b<T, T> {

    /* renamed from: a */
    final C14541q<? super T, ? super Integer, Boolean> f43634a;

    public C14656db(C0132p<? super T, Boolean> underlying) {
        this((C14541q<? super T, ? super Integer, Boolean>) new C14648bb<Object,Object,Boolean>(underlying));
    }

    public C14656db(C14541q<? super T, ? super Integer, Boolean> predicate) {
        this.f43634a = predicate;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> subscriber) {
        Subscriber<T> s = new C14651cb<>(this, subscriber, false, subscriber);
        subscriber.add(s);
        return s;
    }
}
