package p026rx.p390c.p393c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: rx.c.c.k */
/* compiled from: GenericScheduledExecutorService */
public final class C14795k implements C14809t {

    /* renamed from: a */
    private static final ScheduledExecutorService[] f44017a = new ScheduledExecutorService[0];

    /* renamed from: b */
    private static final ScheduledExecutorService f44018b = Executors.newScheduledThreadPool(0);

    /* renamed from: c */
    public static final C14795k f44019c = new C14795k();

    /* renamed from: d */
    private static int f44020d;

    /* renamed from: e */
    private final AtomicReference<ScheduledExecutorService[]> f44021e = new AtomicReference<>(f44017a);

    static {
        f44018b.shutdown();
    }

    private C14795k() {
        start();
    }

    public void start() {
        ScheduledExecutorService[] arr$;
        int count = Runtime.getRuntime().availableProcessors();
        if (count > 4) {
            count /= 2;
        }
        if (count > 8) {
            count = 8;
        }
        ScheduledExecutorService[] execs = new ScheduledExecutorService[count];
        for (int i = 0; i < count; i++) {
            execs[i] = C14796l.m46452e();
        }
        if (this.f44021e.compareAndSet(f44017a, execs)) {
            for (ScheduledExecutorService exec : execs) {
                if (!C14801p.m46461c(exec) && (exec instanceof ScheduledThreadPoolExecutor)) {
                    C14801p.m46458a((ScheduledThreadPoolExecutor) exec);
                }
            }
            return;
        }
        for (ScheduledExecutorService exec2 : execs) {
            exec2.shutdownNow();
        }
    }

    public void shutdown() {
        ScheduledExecutorService[] execs;
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] arr$;
        do {
            execs = (ScheduledExecutorService[]) this.f44021e.get();
            scheduledExecutorServiceArr = f44017a;
            if (execs == scheduledExecutorServiceArr) {
                return;
            }
        } while (!this.f44021e.compareAndSet(execs, scheduledExecutorServiceArr));
        for (ScheduledExecutorService exec : execs) {
            C14801p.m46457a(exec);
            exec.shutdownNow();
        }
    }

    /* renamed from: a */
    public static ScheduledExecutorService m46451a() {
        ScheduledExecutorService[] execs = (ScheduledExecutorService[]) f44019c.f44021e.get();
        if (execs == f44017a) {
            return f44018b;
        }
        int r = f44020d + 1;
        if (r >= execs.length) {
            r = 0;
        }
        f44020d = r;
        return execs[r];
    }
}
