package p320f.p321a.p327d.p337g;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p329b.C13226a;
import p320f.p321a.p344h.C13776a;

/* renamed from: f.a.d.g.a */
/* compiled from: AbstractDirectTask */
abstract class C13707a extends AtomicReference<Future<?>> implements C13194b, C13776a {

    /* renamed from: a */
    protected static final FutureTask<Void> f41757a = new FutureTask<>(C13226a.f40311b, null);

    /* renamed from: b */
    protected static final FutureTask<Void> f41758b = new FutureTask<>(C13226a.f40311b, null);

    /* renamed from: c */
    protected final Runnable f41759c;

    /* renamed from: d */
    protected Thread f41760d;

    C13707a(Runnable runnable) {
        this.f41759c = runnable;
    }

    public final void dispose() {
        Future<?> f = (Future) get();
        if (f != f41757a) {
            Future<?> future = f41758b;
            if (f != future && compareAndSet(f, future) && f != null) {
                f.cancel(this.f41760d != Thread.currentThread());
            }
        }
    }

    /* renamed from: a */
    public final void mo42691a(Future<?> future) {
        Future<?> f;
        do {
            f = (Future) get();
            if (f != f41757a) {
                if (f == f41758b) {
                    future.cancel(this.f41760d != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(f, future));
    }
}
