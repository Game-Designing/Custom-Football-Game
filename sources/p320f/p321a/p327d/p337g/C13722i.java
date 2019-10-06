package p320f.p321a.p327d.p337g;

/* renamed from: f.a.d.g.i */
/* compiled from: ScheduledDirectPeriodicTask */
public final class C13722i extends C13707a implements Runnable {
    public C13722i(Runnable runnable) {
        super(runnable);
    }

    public void run() {
        this.f41760d = Thread.currentThread();
        try {
            this.f41759c.run();
        } catch (Throwable th) {
            this.f41760d = null;
            throw th;
        }
        this.f41760d = null;
    }
}
