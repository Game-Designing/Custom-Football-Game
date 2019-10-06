package p026rx.p390c.p391a;

import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.Single.C0124a;
import rx.internal.operators.SingleLiftObservableOperator.WrapSubscriberIntoSingle;

/* renamed from: rx.c.a.Lb */
/* compiled from: SingleToObservable */
public final class C14605Lb<T> implements C0122a<T> {

    /* renamed from: a */
    final C0124a<T> f43503a;

    public C14605Lb(C0124a<T> source) {
        this.f43503a = source;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> t) {
        WrapSubscriberIntoSingle<T> parent = new C14762yb<>(t);
        t.add(parent);
        this.f43503a.call(parent);
    }
}
