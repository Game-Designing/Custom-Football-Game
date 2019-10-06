package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p029i.C14977e;
import p026rx.p399e.C14920i;
import rx.Subscriber;

/* renamed from: rx.c.a.v */
/* compiled from: OnSubscribeDelaySubscriptionOther */
public final class C14737v<T, U> implements C0122a<T> {

    /* renamed from: a */
    final C0120S<? extends T> f43841a;

    /* renamed from: b */
    final C0120S<U> f43842b;

    public C14737v(C0120S<? extends T> main, C0120S<U> other) {
        this.f43841a = main;
        this.f43842b = other;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> t) {
        C14977e serial = new C14977e();
        t.add(serial);
        Subscriber<U> otherSubscriber = new C14730u<>(this, C14920i.m46653a(t), serial);
        serial.mo46198a(otherSubscriber);
        this.f43842b.mo3640b((C14980ia<? super T>) otherSubscriber);
    }
}
