package p026rx.p390c.p392b;

import java.util.concurrent.atomic.AtomicInteger;
import p026rx.C0125T;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;

/* renamed from: rx.c.b.c */
/* compiled from: SingleDelayedProducer */
public final class C14772c<T> extends AtomicInteger implements C14508U {

    /* renamed from: a */
    final C14980ia<? super T> f43953a;

    /* renamed from: b */
    T f43954b;

    public C14772c(C14980ia<? super T> child) {
        this.f43953a = child;
    }

    public void request(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (n != 0) {
            while (true) {
                int s = get();
                if (s == 0) {
                    if (compareAndSet(0, 2)) {
                        break;
                    }
                } else if (s == 1 && compareAndSet(1, 3)) {
                    m46428a(this.f43953a, this.f43954b);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo45916a(T value) {
        do {
            int s = get();
            if (s == 0) {
                this.f43954b = value;
            } else if (s == 2 && compareAndSet(2, 3)) {
                m46428a(this.f43953a, value);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }

    /* renamed from: a */
    private static <T> void m46428a(C14980ia<? super T> c, T v) {
        if (!c.isUnsubscribed()) {
            try {
                c.onNext(v);
                if (!c.isUnsubscribed()) {
                    c.onCompleted();
                }
            } catch (Throwable e) {
                C14927a.m46673a(e, (C0125T<?>) c, (Object) v);
            }
        }
    }
}
