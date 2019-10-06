package p320f.p321a.p327d.p328a;

import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.ProtocolViolationException;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.a.c */
/* compiled from: DisposableHelper */
public enum C13218c implements C13194b {
    DISPOSED;

    /* renamed from: a */
    public static boolean m43148a(C13194b d) {
        return d == DISPOSED;
    }

    /* renamed from: b */
    public static boolean m43152b(AtomicReference<C13194b> field, C13194b d) {
        C13194b current;
        do {
            current = (C13194b) field.get();
            if (current == DISPOSED) {
                if (d != null) {
                    d.dispose();
                }
                return false;
            }
        } while (!field.compareAndSet(current, d));
        if (current != null) {
            current.dispose();
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m43153c(AtomicReference<C13194b> field, C13194b d) {
        C13264b.m43226a(d, "d is null");
        if (field.compareAndSet(null, d)) {
            return true;
        }
        d.dispose();
        if (field.get() != DISPOSED) {
            m43155e();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m43151a(AtomicReference<C13194b> field, C13194b d) {
        C13194b current;
        do {
            current = (C13194b) field.get();
            if (current == DISPOSED) {
                if (d != null) {
                    d.dispose();
                }
                return false;
            }
        } while (!field.compareAndSet(current, d));
        return true;
    }

    /* renamed from: a */
    public static boolean m43150a(AtomicReference<C13194b> field) {
        C13194b current = (C13194b) field.get();
        C13194b d = DISPOSED;
        if (current != d) {
            C13194b current2 = (C13194b) field.getAndSet(d);
            if (current2 != d) {
                if (current2 != null) {
                    current2.dispose();
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m43149a(C13194b current, C13194b next) {
        if (next == null) {
            C13774a.m43836b((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (current == null) {
            return true;
        } else {
            next.dispose();
            m43155e();
            return false;
        }
    }

    /* renamed from: e */
    public static void m43155e() {
        C13774a.m43836b((Throwable) new ProtocolViolationException("Disposable already set!"));
    }

    /* renamed from: d */
    public static boolean m43154d(AtomicReference<C13194b> field, C13194b d) {
        if (field.compareAndSet(null, d)) {
            return true;
        }
        if (field.get() == DISPOSED) {
            d.dispose();
        }
        return false;
    }

    public void dispose() {
    }
}
