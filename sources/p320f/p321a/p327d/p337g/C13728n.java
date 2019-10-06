package p320f.p321a.p327d.p337g;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13193a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.g.n */
/* compiled from: SingleScheduler */
public final class C13728n extends C13805u {

    /* renamed from: b */
    static final C13720h f41815b = new C13720h("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: c */
    static final ScheduledExecutorService f41816c = Executors.newScheduledThreadPool(0);

    /* renamed from: d */
    final ThreadFactory f41817d;

    /* renamed from: e */
    final AtomicReference<ScheduledExecutorService> f41818e;

    /* renamed from: f.a.d.g.n$a */
    /* compiled from: SingleScheduler */
    static final class C13729a extends C13808c {

        /* renamed from: a */
        final ScheduledExecutorService f41819a;

        /* renamed from: b */
        final C13193a f41820b = new C13193a();

        /* renamed from: c */
        volatile boolean f41821c;

        C13729a(ScheduledExecutorService executor) {
            this.f41819a = executor;
        }

        /* renamed from: a */
        public C13194b mo42243a(Runnable run, long delay, TimeUnit unit) {
            Future<?> f;
            if (this.f41821c) {
                return C13219d.INSTANCE;
            }
            C13724k sr = new C13724k(C13774a.m43831a(run), this.f41820b);
            this.f41820b.mo42252b(sr);
            if (delay <= 0) {
                try {
                    f = this.f41819a.submit(sr);
                } catch (RejectedExecutionException ex) {
                    dispose();
                    C13774a.m43836b((Throwable) ex);
                    return C13219d.INSTANCE;
                }
            } else {
                f = this.f41819a.schedule(sr, delay, unit);
            }
            sr.mo42717a(f);
            return sr;
        }

        public void dispose() {
            if (!this.f41821c) {
                this.f41821c = true;
                this.f41820b.dispose();
            }
        }
    }

    static {
        f41816c.shutdown();
    }

    public C13728n() {
        this(f41815b);
    }

    public C13728n(ThreadFactory threadFactory) {
        this.f41818e = new AtomicReference<>();
        this.f41817d = threadFactory;
        this.f41818e.lazySet(m43720a(threadFactory));
    }

    /* renamed from: a */
    static ScheduledExecutorService m43720a(ThreadFactory threadFactory) {
        return C13726m.m43718a(threadFactory);
    }

    /* renamed from: a */
    public C13808c mo42242a() {
        return new C13729a((ScheduledExecutorService) this.f41818e.get());
    }

    /* renamed from: a */
    public C13194b mo42241a(Runnable run, long delay, TimeUnit unit) {
        Future<?> f;
        C13723j task = new C13723j(C13774a.m43831a(run));
        if (delay <= 0) {
            try {
                f = ((ScheduledExecutorService) this.f41818e.get()).submit(task);
            } catch (RejectedExecutionException ex) {
                C13774a.m43836b((Throwable) ex);
                return C13219d.INSTANCE;
            }
        } else {
            f = ((ScheduledExecutorService) this.f41818e.get()).schedule(task, delay, unit);
        }
        task.mo42691a(f);
        return task;
    }

    /* renamed from: a */
    public C13194b mo42692a(Runnable run, long initialDelay, long period, TimeUnit unit) {
        Future<?> f;
        Runnable decoratedRun = C13774a.m43831a(run);
        if (period <= 0) {
            ScheduledExecutorService exec = (ScheduledExecutorService) this.f41818e.get();
            C13712c periodicWrapper = new C13712c(decoratedRun, exec);
            if (initialDelay <= 0) {
                try {
                    f = exec.submit(periodicWrapper);
                } catch (RejectedExecutionException ex) {
                    C13774a.m43836b((Throwable) ex);
                    return C13219d.INSTANCE;
                }
            } else {
                f = exec.schedule(periodicWrapper, initialDelay, unit);
            }
            periodicWrapper.mo42697a(f);
            return periodicWrapper;
        }
        C13722i task = new C13722i(decoratedRun);
        try {
            task.mo42691a(((ScheduledExecutorService) this.f41818e.get()).scheduleAtFixedRate(task, initialDelay, period, unit));
            return task;
        } catch (RejectedExecutionException ex2) {
            C13774a.m43836b((Throwable) ex2);
            return C13219d.INSTANCE;
        }
    }
}
