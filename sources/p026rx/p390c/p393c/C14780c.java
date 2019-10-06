package p026rx.p390c.p393c;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p029i.C0136c;
import p026rx.p029i.C14978f;
import p026rx.p390c.p395e.C14882j;

/* renamed from: rx.c.c.c */
/* compiled from: CachedThreadScheduler */
public final class C14780c extends C0126V implements C14809t {

    /* renamed from: a */
    private static final long f43970a = ((long) Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue());

    /* renamed from: b */
    private static final TimeUnit f43971b = TimeUnit.SECONDS;

    /* renamed from: c */
    static final C14783c f43972c = new C14783c(C14882j.f44169a);

    /* renamed from: d */
    static final C14781a f43973d = new C14781a(null, 0, null);

    /* renamed from: e */
    final ThreadFactory f43974e;

    /* renamed from: f */
    final AtomicReference<C14781a> f43975f = new AtomicReference<>(f43973d);

    /* renamed from: rx.c.c.c$a */
    /* compiled from: CachedThreadScheduler */
    static final class C14781a {

        /* renamed from: a */
        private final ThreadFactory f43976a;

        /* renamed from: b */
        private final long f43977b;

        /* renamed from: c */
        private final ConcurrentLinkedQueue<C14783c> f43978c;

        /* renamed from: d */
        private final C0136c f43979d;

        /* renamed from: e */
        private final ScheduledExecutorService f43980e;

        /* renamed from: f */
        private final Future<?> f43981f;

        C14781a(ThreadFactory threadFactory, long keepAliveTime, TimeUnit unit) {
            this.f43976a = threadFactory;
            this.f43977b = unit != null ? unit.toNanos(keepAliveTime) : 0;
            this.f43978c = new ConcurrentLinkedQueue<>();
            this.f43979d = new C0136c();
            ScheduledExecutorService evictor = null;
            Future<?> task = null;
            if (unit != null) {
                evictor = Executors.newScheduledThreadPool(1, new C14778a(this, threadFactory));
                C14801p.m46461c(evictor);
                C14779b bVar = new C14779b(this);
                long j = this.f43977b;
                task = evictor.scheduleWithFixedDelay(bVar, j, j, TimeUnit.NANOSECONDS);
            }
            this.f43980e = evictor;
            this.f43981f = task;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C14783c mo45925b() {
            if (this.f43979d.isUnsubscribed()) {
                return C14780c.f43972c;
            }
            while (!this.f43978c.isEmpty()) {
                C14783c threadWorker = (C14783c) this.f43978c.poll();
                if (threadWorker != null) {
                    return threadWorker;
                }
            }
            C14783c w = new C14783c(this.f43976a);
            this.f43979d.mo3713a((C0137ja) w);
            return w;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45924a(C14783c threadWorker) {
            threadWorker.mo45928a(mo45926c() + this.f43977b);
            this.f43978c.offer(threadWorker);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45923a() {
            if (!this.f43978c.isEmpty()) {
                long currentTimestamp = mo45926c();
                Iterator i$ = this.f43978c.iterator();
                while (i$.hasNext()) {
                    C14783c threadWorker = (C14783c) i$.next();
                    if (threadWorker.mo45929d() > currentTimestamp) {
                        return;
                    }
                    if (this.f43978c.remove(threadWorker)) {
                        this.f43979d.mo3714b(threadWorker);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public long mo45926c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo45927d() {
            try {
                if (this.f43981f != null) {
                    this.f43981f.cancel(true);
                }
                if (this.f43980e != null) {
                    this.f43980e.shutdownNow();
                }
            } finally {
                this.f43979d.unsubscribe();
            }
        }
    }

    /* renamed from: rx.c.c.c$b */
    /* compiled from: CachedThreadScheduler */
    static final class C14782b extends C0127a implements C0128a {

        /* renamed from: a */
        private final C0136c f43982a = new C0136c();

        /* renamed from: b */
        private final C14781a f43983b;

        /* renamed from: c */
        private final C14783c f43984c;

        /* renamed from: d */
        final AtomicBoolean f43985d;

        C14782b(C14781a pool) {
            this.f43983b = pool;
            this.f43985d = new AtomicBoolean();
            this.f43984c = pool.mo45925b();
        }

        public void unsubscribe() {
            if (this.f43985d.compareAndSet(false, true)) {
                this.f43984c.mo3707a((C0128a) this);
            }
            this.f43982a.unsubscribe();
        }

        public void call() {
            this.f43983b.mo45924a(this.f43984c);
        }

        public boolean isUnsubscribed() {
            return this.f43982a.isUnsubscribed();
        }

        /* renamed from: a */
        public C0137ja mo3707a(C0128a action) {
            return mo3709a(action, 0, null);
        }

        /* renamed from: a */
        public C0137ja mo3709a(C0128a action, long delayTime, TimeUnit unit) {
            if (this.f43982a.isUnsubscribed()) {
                return C14978f.m46782b();
            }
            C14805s s = this.f43984c.mo45937b(new C14784d(this, action), delayTime, unit);
            this.f43982a.mo3713a((C0137ja) s);
            s.mo45941a(this.f43982a);
            return s;
        }
    }

    /* renamed from: rx.c.c.c$c */
    /* compiled from: CachedThreadScheduler */
    static final class C14783c extends C14801p {

        /* renamed from: i */
        private long f43986i = 0;

        C14783c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        /* renamed from: d */
        public long mo45929d() {
            return this.f43986i;
        }

        /* renamed from: a */
        public void mo45928a(long expirationTime) {
            this.f43986i = expirationTime;
        }
    }

    static {
        f43972c.unsubscribe();
        f43973d.mo45927d();
    }

    public C14780c(ThreadFactory threadFactory) {
        this.f43974e = threadFactory;
        start();
    }

    public void start() {
        C14781a update = new C14781a(this.f43974e, f43970a, f43971b);
        if (!this.f43975f.compareAndSet(f43973d, update)) {
            update.mo45927d();
        }
    }

    public void shutdown() {
        C14781a curr;
        C14781a aVar;
        do {
            curr = (C14781a) this.f43975f.get();
            aVar = f43973d;
            if (curr == aVar) {
                return;
            }
        } while (!this.f43975f.compareAndSet(curr, aVar));
        curr.mo45927d();
    }

    public C0127a createWorker() {
        return new C14782b((C14781a) this.f43975f.get());
    }
}
