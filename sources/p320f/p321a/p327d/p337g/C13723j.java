package p320f.p321a.p327d.p337g;

import java.util.concurrent.Callable;

/* renamed from: f.a.d.g.j */
/* compiled from: ScheduledDirectTask */
public final class C13723j extends C13707a implements Callable<Void> {
    public C13723j(Runnable runnable) {
        super(runnable);
    }

    public Void call() throws Exception {
        this.f41760d = Thread.currentThread();
        try {
            this.f41759c.run();
            return null;
        } finally {
            lazySet(C13707a.f41757a);
            this.f41760d = null;
        }
    }
}
