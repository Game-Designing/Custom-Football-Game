package p026rx.p390c.p392b;

import java.util.concurrent.atomic.AtomicBoolean;
import p026rx.C0125T;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import rx.Subscriber;

/* renamed from: rx.c.b.d */
/* compiled from: SingleProducer */
public final class C14773d<T> extends AtomicBoolean implements C14508U {

    /* renamed from: a */
    final C14980ia<? super T> f43955a;

    /* renamed from: b */
    final T f43956b;

    public C14773d(C14980ia<? super T> child, T value) {
        this.f43955a = child;
        this.f43956b = value;
    }

    public void request(long n) {
        if (n >= 0) {
            if (n != 0 && compareAndSet(false, true)) {
                Subscriber<? super T> c = this.f43955a;
                if (!c.isUnsubscribed()) {
                    T v = this.f43956b;
                    try {
                        c.onNext(v);
                        if (!c.isUnsubscribed()) {
                            c.onCompleted();
                        } else {
                            return;
                        }
                    } catch (Throwable e) {
                        C14927a.m46673a(e, (C0125T<?>) c, (Object) v);
                        return;
                    }
                } else {
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
