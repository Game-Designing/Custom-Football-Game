package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C14972ha;
import p026rx.C14980ia;
import p026rx.Single;
import p026rx.Single.C0124a;
import p026rx.p029i.C14977e;
import rx.SingleSubscriber;
import rx.Subscriber;

/* renamed from: rx.c.a.Db */
/* compiled from: SingleOnSubscribeDelaySubscriptionOther */
public final class C14570Db<T> implements C0124a<T> {

    /* renamed from: a */
    final Single<? extends T> f43414a;

    /* renamed from: b */
    final C0120S<?> f43415b;

    public C14570Db(Single<? extends T> main, C0120S<?> other) {
        this.f43414a = main;
        this.f43415b = other;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> subscriber) {
        SingleSubscriber<T> child = new C14563Bb<>(this, subscriber);
        C14977e serial = new C14977e();
        subscriber.mo46195b(serial);
        Subscriber<Object> otherSubscriber = new C14567Cb<>(this, child, serial);
        serial.mo46198a(otherSubscriber);
        this.f43415b.mo3627a((C14980ia<? super T>) otherSubscriber);
    }
}
