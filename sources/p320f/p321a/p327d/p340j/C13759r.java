package p320f.p321a.p327d.p340j;

import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p330c.C13274i;
import p320f.p321a.p327d.p336f.C13705b;
import p320f.p321a.p327d.p336f.C13706c;

/* renamed from: f.a.d.j.r */
/* compiled from: QueueDrainHelper */
public final class C13759r {
    /* renamed from: a */
    public static <T, U> void m43798a(C13273h<T> q, C13804t<? super U> a, boolean delayError, C13194b dispose, C13756o<T, U> qd) {
        int missed = 1;
        while (!m43799a(qd.done(), q.isEmpty(), a, delayError, q, dispose, qd)) {
            while (true) {
                boolean d = qd.done();
                T v = q.poll();
                boolean empty = v == null;
                if (!m43799a(d, empty, a, delayError, q, dispose, qd)) {
                    if (empty) {
                        missed = qd.mo42342a(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        qd.mo42343a(a, v);
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static <T, U> boolean m43799a(boolean d, boolean empty, C13804t<?> s, boolean delayError, C13274i<?> q, C13194b disposable, C13756o<T, U> qd) {
        if (qd.mo42345a()) {
            q.clear();
            disposable.dispose();
            return true;
        }
        if (d) {
            if (!delayError) {
                Throwable err = qd.error();
                if (err != null) {
                    q.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    s.onError(err);
                    return true;
                } else if (empty) {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    s.onComplete();
                    return true;
                }
            } else if (empty) {
                if (disposable != null) {
                    disposable.dispose();
                }
                Throwable err2 = qd.error();
                if (err2 != null) {
                    s.onError(err2);
                } else {
                    s.onComplete();
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static <T> C13274i<T> m43797a(int capacityHint) {
        if (capacityHint < 0) {
            return new C13706c(-capacityHint);
        }
        return new C13705b(capacityHint);
    }
}
