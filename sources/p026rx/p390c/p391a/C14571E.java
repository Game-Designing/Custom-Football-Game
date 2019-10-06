package p026rx.p390c.p391a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0120S.C0122a;
import p026rx.C0125T;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import rx.Subscriber;

/* renamed from: rx.c.a.E */
/* compiled from: OnSubscribeFromIterable */
public final class C14571E<T> implements C0122a<T> {

    /* renamed from: a */
    final Iterable<? extends T> f43416a;

    /* renamed from: rx.c.a.E$a */
    /* compiled from: OnSubscribeFromIterable */
    static final class C14572a<T> extends AtomicLong implements C14508U {

        /* renamed from: a */
        private final C14980ia<? super T> f43417a;

        /* renamed from: b */
        private final Iterator<? extends T> f43418b;

        C14572a(C14980ia<? super T> o, Iterator<? extends T> it) {
            this.f43417a = o;
            this.f43418b = it;
        }

        public void request(long n) {
            if (get() != Long.MAX_VALUE) {
                if (n == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                    mo45750a();
                } else if (n > 0 && C14640a.m46283a((AtomicLong) this, n) == 0) {
                    mo45751a(n);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45751a(long n) {
            Subscriber<? super T> o = this.f43417a;
            Iterator<? extends T> it = this.f43418b;
            long r = n;
            long e = 0;
            while (true) {
                if (e == r) {
                    r = get();
                    if (e == r) {
                        r = C14640a.m46285b(this, e);
                        if (r != 0) {
                            e = 0;
                        } else {
                            return;
                        }
                    } else {
                        continue;
                    }
                } else if (!o.isUnsubscribed()) {
                    try {
                        o.onNext(it.next());
                        if (!o.isUnsubscribed()) {
                            try {
                                if (!it.hasNext()) {
                                    if (!o.isUnsubscribed()) {
                                        o.onCompleted();
                                    }
                                    return;
                                }
                                e++;
                            } catch (Throwable ex) {
                                C14927a.m46672a(ex, (C0125T<?>) o);
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable ex2) {
                        C14927a.m46672a(ex2, (C0125T<?>) o);
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45750a() {
            Subscriber<? super T> o = this.f43417a;
            Iterator<? extends T> it = this.f43418b;
            while (!o.isUnsubscribed()) {
                try {
                    o.onNext(it.next());
                    if (!o.isUnsubscribed()) {
                        try {
                            if (!it.hasNext()) {
                                if (!o.isUnsubscribed()) {
                                    o.onCompleted();
                                }
                                return;
                            }
                        } catch (Throwable ex) {
                            C14927a.m46672a(ex, (C0125T<?>) o);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable ex2) {
                    C14927a.m46672a(ex2, (C0125T<?>) o);
                    return;
                }
            }
        }
    }

    public C14571E(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.f43416a = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> o) {
        try {
            Iterator<? extends T> it = this.f43416a.iterator();
            try {
                boolean b = it.hasNext();
                if (!o.isUnsubscribed()) {
                    if (!b) {
                        o.onCompleted();
                    } else {
                        o.setProducer(new C14572a(o, it));
                    }
                }
            } catch (Throwable th) {
                ex = th;
                C14927a.m46672a(ex, (C0125T<?>) o);
            }
        } catch (Throwable th2) {
            ex = th2;
            C14927a.m46672a(ex, (C0125T<?>) o);
        }
    }
}
