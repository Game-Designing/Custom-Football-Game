package p320f.p321a.p327d.p337g;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13217b;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.g.f */
/* compiled from: NewThreadWorker */
public class C13718f extends C13808c implements C13194b {

    /* renamed from: a */
    private final ScheduledExecutorService f41801a;

    /* renamed from: b */
    volatile boolean f41802b;

    public C13718f(ThreadFactory threadFactory) {
        this.f41801a = C13726m.m43718a(threadFactory);
    }

    /* renamed from: a */
    public C13194b mo42694a(Runnable run) {
        return mo42243a(run, 0, null);
    }

    /* renamed from: a */
    public C13194b mo42243a(Runnable action, long delayTime, TimeUnit unit) {
        if (this.f41802b) {
            return C13219d.INSTANCE;
        }
        return mo42709a(action, delayTime, unit, null);
    }

    /* renamed from: b */
    public C13194b mo42712b(Runnable run, long delayTime, TimeUnit unit) {
        Future<?> f;
        C13723j task = new C13723j(C13774a.m43831a(run));
        if (delayTime <= 0) {
            try {
                f = this.f41801a.submit(task);
            } catch (RejectedExecutionException ex) {
                C13774a.m43836b((Throwable) ex);
                return C13219d.INSTANCE;
            }
        } else {
            f = this.f41801a.schedule(task, delayTime, unit);
        }
        task.mo42691a(f);
        return task;
    }

    /* renamed from: b */
    public C13194b mo42711b(Runnable run, long initialDelay, long period, TimeUnit unit) {
        Future<?> f;
        Runnable decoratedRun = C13774a.m43831a(run);
        if (period <= 0) {
            C13712c periodicWrapper = new C13712c(decoratedRun, this.f41801a);
            if (initialDelay <= 0) {
                try {
                    f = this.f41801a.submit(periodicWrapper);
                } catch (RejectedExecutionException ex) {
                    C13774a.m43836b((Throwable) ex);
                    return C13219d.INSTANCE;
                }
            } else {
                f = this.f41801a.schedule(periodicWrapper, initialDelay, unit);
            }
            periodicWrapper.mo42697a(f);
            return periodicWrapper;
        }
        C13722i task = new C13722i(decoratedRun);
        try {
            task.mo42691a(this.f41801a.scheduleAtFixedRate(task, initialDelay, period, unit));
            return task;
        } catch (RejectedExecutionException ex2) {
            C13774a.m43836b((Throwable) ex2);
            return C13219d.INSTANCE;
        }
    }

    /* renamed from: a */
    public C13724k mo42709a(Runnable run, long delayTime, TimeUnit unit, C13217b parent) {
        Future<?> f;
        C13724k sr = new C13724k(C13774a.m43831a(run), parent);
        if (parent != null && !parent.mo42252b(sr)) {
            return sr;
        }
        if (delayTime <= 0) {
            try {
                f = this.f41801a.submit(sr);
            } catch (RejectedExecutionException ex) {
                if (parent != null) {
                    parent.mo42250a(sr);
                }
                C13774a.m43836b((Throwable) ex);
            }
        } else {
            f = this.f41801a.schedule(sr, delayTime, unit);
        }
        sr.mo42717a(f);
        return sr;
    }

    public void dispose() {
        if (!this.f41802b) {
            this.f41802b = true;
            this.f41801a.shutdownNow();
        }
    }

    /* renamed from: a */
    public void mo42710a() {
        if (!this.f41802b) {
            this.f41802b = true;
            this.f41801a.shutdown();
        }
    }
}
