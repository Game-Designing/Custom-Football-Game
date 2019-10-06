package p320f.p321a.p327d.p337g;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13193a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13219d;

/* renamed from: f.a.d.g.d */
/* compiled from: IoScheduler */
public final class C13713d extends C13805u {

    /* renamed from: b */
    static final C13720h f41781b;

    /* renamed from: c */
    static final C13720h f41782c;

    /* renamed from: d */
    private static final TimeUnit f41783d = TimeUnit.SECONDS;

    /* renamed from: e */
    static final C13716c f41784e = new C13716c(new C13720h("RxCachedThreadSchedulerShutdown"));

    /* renamed from: f */
    static final C13714a f41785f = new C13714a(0, null, f41781b);

    /* renamed from: g */
    final ThreadFactory f41786g;

    /* renamed from: h */
    final AtomicReference<C13714a> f41787h;

    /* renamed from: f.a.d.g.d$a */
    /* compiled from: IoScheduler */
    static final class C13714a implements Runnable {

        /* renamed from: a */
        private final long f41788a;

        /* renamed from: b */
        private final ConcurrentLinkedQueue<C13716c> f41789b;

        /* renamed from: c */
        final C13193a f41790c;

        /* renamed from: d */
        private final ScheduledExecutorService f41791d;

        /* renamed from: e */
        private final Future<?> f41792e;

        /* renamed from: f */
        private final ThreadFactory f41793f;

        C13714a(long keepAliveTime, TimeUnit unit, ThreadFactory threadFactory) {
            this.f41788a = unit != null ? unit.toNanos(keepAliveTime) : 0;
            this.f41789b = new ConcurrentLinkedQueue<>();
            this.f41790c = new C13193a();
            this.f41793f = threadFactory;
            ScheduledExecutorService evictor = null;
            Future<?> task = null;
            if (unit != null) {
                evictor = Executors.newScheduledThreadPool(1, C13713d.f41782c);
                long j = this.f41788a;
                task = evictor.scheduleWithFixedDelay(this, j, j, TimeUnit.NANOSECONDS);
            }
            this.f41791d = evictor;
            this.f41792e = task;
        }

        public void run() {
            mo42701a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C13716c mo42703b() {
            if (this.f41790c.mo42249a()) {
                return C13713d.f41784e;
            }
            while (!this.f41789b.isEmpty()) {
                C13716c threadWorker = (C13716c) this.f41789b.poll();
                if (threadWorker != null) {
                    return threadWorker;
                }
            }
            C13716c w = new C13716c(this.f41793f);
            this.f41790c.mo42252b(w);
            return w;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42702a(C13716c threadWorker) {
            threadWorker.mo42707a(mo42704c() + this.f41788a);
            this.f41789b.offer(threadWorker);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42701a() {
            if (!this.f41789b.isEmpty()) {
                long currentTimestamp = mo42704c();
                Iterator it = this.f41789b.iterator();
                while (it.hasNext()) {
                    C13716c threadWorker = (C13716c) it.next();
                    if (threadWorker.mo42708b() > currentTimestamp) {
                        return;
                    }
                    if (this.f41789b.remove(threadWorker)) {
                        this.f41790c.mo42250a((C13194b) threadWorker);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public long mo42704c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42705d() {
            this.f41790c.dispose();
            Future<?> future = this.f41792e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f41791d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    /* renamed from: f.a.d.g.d$b */
    /* compiled from: IoScheduler */
    static final class C13715b extends C13808c {

        /* renamed from: a */
        private final C13193a f41794a;

        /* renamed from: b */
        private final C13714a f41795b;

        /* renamed from: c */
        private final C13716c f41796c;

        /* renamed from: d */
        final AtomicBoolean f41797d = new AtomicBoolean();

        C13715b(C13714a pool) {
            this.f41795b = pool;
            this.f41794a = new C13193a();
            this.f41796c = pool.mo42703b();
        }

        public void dispose() {
            if (this.f41797d.compareAndSet(false, true)) {
                this.f41794a.dispose();
                this.f41795b.mo42702a(this.f41796c);
            }
        }

        /* renamed from: a */
        public C13194b mo42243a(Runnable action, long delayTime, TimeUnit unit) {
            if (this.f41794a.mo42249a()) {
                return C13219d.INSTANCE;
            }
            return this.f41796c.mo42709a(action, delayTime, unit, this.f41794a);
        }
    }

    /* renamed from: f.a.d.g.d$c */
    /* compiled from: IoScheduler */
    static final class C13716c extends C13718f {

        /* renamed from: c */
        private long f41798c = 0;

        C13716c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        /* renamed from: b */
        public long mo42708b() {
            return this.f41798c;
        }

        /* renamed from: a */
        public void mo42707a(long expirationTime) {
            this.f41798c = expirationTime;
        }
    }

    static {
        f41784e.dispose();
        int priority = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f41781b = new C13720h("RxCachedThreadScheduler", priority);
        f41782c = new C13720h("RxCachedWorkerPoolEvictor", priority);
        f41785f.mo42705d();
    }

    public C13713d() {
        this(f41781b);
    }

    public C13713d(ThreadFactory threadFactory) {
        this.f41786g = threadFactory;
        this.f41787h = new AtomicReference<>(f41785f);
        mo42700b();
    }

    /* renamed from: b */
    public void mo42700b() {
        C13714a update = new C13714a(60, f41783d, this.f41786g);
        if (!this.f41787h.compareAndSet(f41785f, update)) {
            update.mo42705d();
        }
    }

    /* renamed from: a */
    public C13808c mo42242a() {
        return new C13715b((C13714a) this.f41787h.get());
    }
}
