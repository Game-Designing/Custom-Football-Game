package p320f.p321a.p327d.p337g;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p325b.C13195c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.g.o */
/* compiled from: TrampolineScheduler */
public final class C13730o extends C13805u {

    /* renamed from: b */
    private static final C13730o f41822b = new C13730o();

    /* renamed from: f.a.d.g.o$a */
    /* compiled from: TrampolineScheduler */
    static final class C13731a implements Runnable {

        /* renamed from: a */
        private final Runnable f41823a;

        /* renamed from: b */
        private final C13733c f41824b;

        /* renamed from: c */
        private final long f41825c;

        C13731a(Runnable run, C13733c worker, long execTime) {
            this.f41823a = run;
            this.f41824b = worker;
            this.f41825c = execTime;
        }

        public void run() {
            if (!this.f41824b.f41833d) {
                long t = this.f41824b.mo43150a(TimeUnit.MILLISECONDS);
                long j = this.f41825c;
                if (j > t) {
                    long delay = j - t;
                    if (delay > 0) {
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            C13774a.m43836b((Throwable) e);
                            return;
                        }
                    }
                }
                if (!this.f41824b.f41833d) {
                    this.f41823a.run();
                }
            }
        }
    }

    /* renamed from: f.a.d.g.o$b */
    /* compiled from: TrampolineScheduler */
    static final class C13732b implements Comparable<C13732b> {

        /* renamed from: a */
        final Runnable f41826a;

        /* renamed from: b */
        final long f41827b;

        /* renamed from: c */
        final int f41828c;

        /* renamed from: d */
        volatile boolean f41829d;

        C13732b(Runnable run, Long execTime, int count) {
            this.f41826a = run;
            this.f41827b = execTime.longValue();
            this.f41828c = count;
        }

        /* renamed from: a */
        public int compareTo(C13732b that) {
            int result = C13264b.m43223a(this.f41827b, that.f41827b);
            if (result == 0) {
                return C13264b.m43221a(this.f41828c, that.f41828c);
            }
            return result;
        }
    }

    /* renamed from: f.a.d.g.o$c */
    /* compiled from: TrampolineScheduler */
    static final class C13733c extends C13808c implements C13194b {

        /* renamed from: a */
        final PriorityBlockingQueue<C13732b> f41830a = new PriorityBlockingQueue<>();

        /* renamed from: b */
        private final AtomicInteger f41831b = new AtomicInteger();

        /* renamed from: c */
        final AtomicInteger f41832c = new AtomicInteger();

        /* renamed from: d */
        volatile boolean f41833d;

        /* renamed from: f.a.d.g.o$c$a */
        /* compiled from: TrampolineScheduler */
        final class C13734a implements Runnable {

            /* renamed from: a */
            final C13732b f41834a;

            C13734a(C13732b timedRunnable) {
                this.f41834a = timedRunnable;
            }

            public void run() {
                C13732b bVar = this.f41834a;
                bVar.f41829d = true;
                C13733c.this.f41830a.remove(bVar);
            }
        }

        C13733c() {
        }

        /* renamed from: a */
        public C13194b mo42694a(Runnable action) {
            return mo42725a(action, mo43150a(TimeUnit.MILLISECONDS));
        }

        /* renamed from: a */
        public C13194b mo42243a(Runnable action, long delayTime, TimeUnit unit) {
            long execTime = mo43150a(TimeUnit.MILLISECONDS) + unit.toMillis(delayTime);
            return mo42725a(new C13731a(action, this, execTime), execTime);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C13194b mo42725a(Runnable action, long execTime) {
            if (this.f41833d) {
                return C13219d.INSTANCE;
            }
            C13732b timedRunnable = new C13732b(action, Long.valueOf(execTime), this.f41832c.incrementAndGet());
            this.f41830a.add(timedRunnable);
            if (this.f41831b.getAndIncrement() != 0) {
                return C13195c.m43131a(new C13734a(timedRunnable));
            }
            int missed = 1;
            while (!this.f41833d) {
                C13732b polled = (C13732b) this.f41830a.poll();
                if (polled == null) {
                    missed = this.f41831b.addAndGet(-missed);
                    if (missed == 0) {
                        return C13219d.INSTANCE;
                    }
                } else if (!polled.f41829d) {
                    polled.f41826a.run();
                }
            }
            this.f41830a.clear();
            return C13219d.INSTANCE;
        }

        public void dispose() {
            this.f41833d = true;
        }
    }

    /* renamed from: b */
    public static C13730o m43725b() {
        return f41822b;
    }

    /* renamed from: a */
    public C13808c mo42242a() {
        return new C13733c();
    }

    C13730o() {
    }

    /* renamed from: a */
    public C13194b mo42721a(Runnable run) {
        C13774a.m43831a(run).run();
        return C13219d.INSTANCE;
    }

    /* renamed from: a */
    public C13194b mo42241a(Runnable run, long delay, TimeUnit unit) {
        try {
            unit.sleep(delay);
            C13774a.m43831a(run).run();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            C13774a.m43836b((Throwable) ex);
        }
        return C13219d.INSTANCE;
    }
}
