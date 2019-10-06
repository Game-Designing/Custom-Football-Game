package p320f.p321a.p327d.p337g;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p329b.C13226a;

/* renamed from: f.a.d.g.c */
/* compiled from: InstantPeriodicTask */
final class C13712c implements Callable<Void>, C13194b {

    /* renamed from: a */
    static final FutureTask<Void> f41775a = new FutureTask<>(C13226a.f40311b, null);

    /* renamed from: b */
    final Runnable f41776b;

    /* renamed from: c */
    final AtomicReference<Future<?>> f41777c = new AtomicReference<>();

    /* renamed from: d */
    final AtomicReference<Future<?>> f41778d = new AtomicReference<>();

    /* renamed from: e */
    final ExecutorService f41779e;

    /* renamed from: f */
    Thread f41780f;

    C13712c(Runnable task, ExecutorService executor) {
        this.f41776b = task;
        this.f41779e = executor;
    }

    public Void call() throws Exception {
        try {
            this.f41780f = Thread.currentThread();
            this.f41776b.run();
            mo42698b(this.f41779e.submit(this));
        } catch (Throwable th) {
            this.f41780f = null;
            throw th;
        }
        this.f41780f = null;
        return null;
    }

    public void dispose() {
        Future<?> current = (Future) this.f41778d.getAndSet(f41775a);
        boolean z = true;
        if (!(current == null || current == f41775a)) {
            current.cancel(this.f41780f != Thread.currentThread());
        }
        Future<?> current2 = (Future) this.f41777c.getAndSet(f41775a);
        if (current2 != null && current2 != f41775a) {
            if (this.f41780f == Thread.currentThread()) {
                z = false;
            }
            current2.cancel(z);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42697a(Future<?> f) {
        Future<?> current;
        do {
            current = (Future) this.f41778d.get();
            if (current == f41775a) {
                f.cancel(this.f41780f != Thread.currentThread());
            }
        } while (!this.f41778d.compareAndSet(current, f));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo42698b(Future<?> f) {
        Future<?> current;
        do {
            current = (Future) this.f41777c.get();
            if (current == f41775a) {
                f.cancel(this.f41780f != Thread.currentThread());
            }
        } while (!this.f41777c.compareAndSet(current, f));
    }
}
