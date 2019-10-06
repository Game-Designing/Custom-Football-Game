package p320f.p321a.p327d.p340j;

import java.util.concurrent.atomic.AtomicInteger;
import p320f.p321a.C13804t;
import p320f.p321a.p343g.C13774a;
import p363i.p368b.C14229b;

/* renamed from: f.a.d.j.k */
/* compiled from: HalfSerializer */
public final class C13750k {
    /* renamed from: a */
    public static <T> void m43767a(C14229b<? super T> subscriber, T value, AtomicInteger wip, C13741c error) {
        if (wip.get() == 0 && wip.compareAndSet(0, 1)) {
            subscriber.onNext(value);
            if (wip.decrementAndGet() != 0) {
                Throwable ex = error.mo42732a();
                if (ex != null) {
                    subscriber.onError(ex);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m43768a(C14229b<?> subscriber, Throwable ex, AtomicInteger wip, C13741c error) {
        if (!error.mo42733a(ex)) {
            C13774a.m43836b(ex);
        } else if (wip.getAndIncrement() == 0) {
            subscriber.onError(error.mo42732a());
        }
    }

    /* renamed from: a */
    public static void m43769a(C14229b<?> subscriber, AtomicInteger wip, C13741c error) {
        if (wip.getAndIncrement() == 0) {
            Throwable ex = error.mo42732a();
            if (ex != null) {
                subscriber.onError(ex);
            } else {
                subscriber.onComplete();
            }
        }
    }

    /* renamed from: a */
    public static <T> void m43764a(C13804t<? super T> observer, T value, AtomicInteger wip, C13741c error) {
        if (wip.get() == 0 && wip.compareAndSet(0, 1)) {
            observer.onNext(value);
            if (wip.decrementAndGet() != 0) {
                Throwable ex = error.mo42732a();
                if (ex != null) {
                    observer.onError(ex);
                } else {
                    observer.onComplete();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m43765a(C13804t<?> observer, Throwable ex, AtomicInteger wip, C13741c error) {
        if (!error.mo42733a(ex)) {
            C13774a.m43836b(ex);
        } else if (wip.getAndIncrement() == 0) {
            observer.onError(error.mo42732a());
        }
    }

    /* renamed from: a */
    public static void m43766a(C13804t<?> observer, AtomicInteger wip, C13741c error) {
        if (wip.getAndIncrement() == 0) {
            Throwable ex = error.mo42732a();
            if (ex != null) {
                observer.onError(ex);
            } else {
                observer.onComplete();
            }
        }
    }
}
