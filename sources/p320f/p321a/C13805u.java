package p320f.p321a;

import java.util.concurrent.TimeUnit;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p328a.C13225j;
import p320f.p321a.p327d.p337g.C13718f;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p343g.C13774a;
import p320f.p321a.p344h.C13776a;

/* renamed from: f.a.u */
/* compiled from: Scheduler */
public abstract class C13805u {

    /* renamed from: a */
    static final long f41959a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* renamed from: f.a.u$a */
    /* compiled from: Scheduler */
    static final class C13806a implements C13194b, Runnable, C13776a {

        /* renamed from: a */
        final Runnable f41960a;

        /* renamed from: b */
        final C13808c f41961b;

        /* renamed from: c */
        Thread f41962c;

        C13806a(Runnable decoratedRun, C13808c w) {
            this.f41960a = decoratedRun;
            this.f41961b = w;
        }

        public void run() {
            this.f41962c = Thread.currentThread();
            try {
                this.f41960a.run();
            } finally {
                dispose();
                this.f41962c = null;
            }
        }

        public void dispose() {
            if (this.f41962c == Thread.currentThread()) {
                C13808c cVar = this.f41961b;
                if (cVar instanceof C13718f) {
                    ((C13718f) cVar).mo42710a();
                    return;
                }
            }
            this.f41961b.dispose();
        }
    }

    /* renamed from: f.a.u$b */
    /* compiled from: Scheduler */
    static class C13807b implements C13194b, Runnable, C13776a {

        /* renamed from: a */
        final Runnable f41963a;

        /* renamed from: b */
        final C13808c f41964b;

        /* renamed from: c */
        volatile boolean f41965c;

        C13807b(Runnable run, C13808c worker) {
            this.f41963a = run;
            this.f41964b = worker;
        }

        public void run() {
            if (!this.f41965c) {
                try {
                    this.f41963a.run();
                } catch (Throwable ex) {
                    C13980a.m44462b(ex);
                    this.f41964b.dispose();
                    throw C13748j.m43761a(ex);
                }
            }
        }

        public void dispose() {
            this.f41965c = true;
            this.f41964b.dispose();
        }
    }

    /* renamed from: f.a.u$c */
    /* compiled from: Scheduler */
    public static abstract class C13808c implements C13194b {

        /* renamed from: f.a.u$c$a */
        /* compiled from: Scheduler */
        final class C13809a implements Runnable, C13776a {

            /* renamed from: a */
            final Runnable f41966a;

            /* renamed from: b */
            final C13225j f41967b;

            /* renamed from: c */
            final long f41968c;

            /* renamed from: d */
            long f41969d;

            /* renamed from: e */
            long f41970e;

            /* renamed from: f */
            long f41971f;

            C13809a(long firstStartInNanoseconds, Runnable decoratedRun, long firstNowNanoseconds, C13225j sd, long periodInNanoseconds) {
                this.f41966a = decoratedRun;
                this.f41967b = sd;
                this.f41968c = periodInNanoseconds;
                this.f41970e = firstNowNanoseconds;
                this.f41971f = firstStartInNanoseconds;
            }

            public void run() {
                long nextTick;
                this.f41966a.run();
                if (!this.f41967b.mo42286a()) {
                    long nowNanoseconds = C13808c.this.mo43150a(TimeUnit.NANOSECONDS);
                    long j = C13805u.f41959a;
                    long j2 = nowNanoseconds + j;
                    long j3 = this.f41970e;
                    if (j2 >= j3) {
                        long j4 = this.f41968c;
                        if (nowNanoseconds < j3 + j4 + j) {
                            long j5 = this.f41971f;
                            long j6 = this.f41969d + 1;
                            this.f41969d = j6;
                            nextTick = j5 + (j6 * j4);
                            this.f41970e = nowNanoseconds;
                            this.f41967b.mo42287a(C13808c.this.mo42243a(this, nextTick - nowNanoseconds, TimeUnit.NANOSECONDS));
                        }
                    }
                    long nextTick2 = this.f41968c;
                    long nextTick3 = nowNanoseconds + nextTick2;
                    long j7 = this.f41969d + 1;
                    this.f41969d = j7;
                    this.f41971f = nextTick3 - (nextTick2 * j7);
                    nextTick = nextTick3;
                    this.f41970e = nowNanoseconds;
                    this.f41967b.mo42287a(C13808c.this.mo42243a(this, nextTick - nowNanoseconds, TimeUnit.NANOSECONDS));
                }
            }
        }

        /* renamed from: a */
        public abstract C13194b mo42243a(Runnable runnable, long j, TimeUnit timeUnit);

        /* renamed from: a */
        public C13194b mo42694a(Runnable run) {
            return mo42243a(run, 0, TimeUnit.NANOSECONDS);
        }

        /* renamed from: a */
        public C13194b mo43151a(Runnable run, long initialDelay, long period, TimeUnit unit) {
            long j = initialDelay;
            TimeUnit timeUnit = unit;
            C13225j first = new C13225j();
            C13225j sd = new C13225j(first);
            Runnable decoratedRun = C13774a.m43831a(run);
            long periodInNanoseconds = timeUnit.toNanos(period);
            long firstNowNanoseconds = mo43150a(TimeUnit.NANOSECONDS);
            C13225j first2 = first;
            C13809a aVar = r0;
            C13809a aVar2 = new C13809a(firstNowNanoseconds + timeUnit.toNanos(j), decoratedRun, firstNowNanoseconds, sd, periodInNanoseconds);
            C13194b d = mo42243a(aVar, j, timeUnit);
            if (d == C13219d.INSTANCE) {
                return d;
            }
            first2.mo42287a(d);
            return sd;
        }

        /* renamed from: a */
        public long mo43150a(TimeUnit unit) {
            return unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    public abstract C13808c mo42242a();

    /* renamed from: a */
    public long mo43147a(TimeUnit unit) {
        return unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public C13194b mo42721a(Runnable run) {
        return mo42241a(run, 0, TimeUnit.NANOSECONDS);
    }

    /* renamed from: a */
    public C13194b mo42241a(Runnable run, long delay, TimeUnit unit) {
        C13808c w = mo42242a();
        C13806a task = new C13806a(C13774a.m43831a(run), w);
        w.mo42243a(task, delay, unit);
        return task;
    }

    /* renamed from: a */
    public C13194b mo42692a(Runnable run, long initialDelay, long period, TimeUnit unit) {
        C13808c w = mo42242a();
        C13807b periodicTask = new C13807b(C13774a.m43831a(run), w);
        C13194b d = w.mo43151a(periodicTask, initialDelay, period, unit);
        if (d == C13219d.INSTANCE) {
            return d;
        }
        return periodicTask;
    }
}
