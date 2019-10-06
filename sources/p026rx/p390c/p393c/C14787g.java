package p026rx.p390c.p393c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p029i.C0136c;
import p026rx.p029i.C14978f;
import p026rx.p390c.p395e.C14882j;
import p026rx.p390c.p395e.C14899t;

/* renamed from: rx.c.c.g */
/* compiled from: EventLoopsScheduler */
public final class C14787g extends C0126V implements C14809t {

    /* renamed from: a */
    static final int f43993a;

    /* renamed from: b */
    static final C14790c f43994b = new C14790c(C14882j.f44169a);

    /* renamed from: c */
    static final C14789b f43995c = new C14789b(null, 0);

    /* renamed from: d */
    final ThreadFactory f43996d;

    /* renamed from: e */
    final AtomicReference<C14789b> f43997e = new AtomicReference<>(f43995c);

    /* renamed from: rx.c.c.g$a */
    /* compiled from: EventLoopsScheduler */
    static final class C14788a extends C0127a {

        /* renamed from: a */
        private final C14899t f43998a = new C14899t();

        /* renamed from: b */
        private final C0136c f43999b = new C0136c();

        /* renamed from: c */
        private final C14899t f44000c = new C14899t(this.f43998a, this.f43999b);

        /* renamed from: d */
        private final C14790c f44001d;

        C14788a(C14790c poolWorker) {
            this.f44001d = poolWorker;
        }

        public void unsubscribe() {
            this.f44000c.unsubscribe();
        }

        public boolean isUnsubscribed() {
            return this.f44000c.isUnsubscribed();
        }

        /* renamed from: a */
        public C0137ja mo3707a(C0128a action) {
            if (isUnsubscribed()) {
                return C14978f.m46782b();
            }
            return this.f44001d.mo45935a((C0128a) new C14785e(this, action), 0, (TimeUnit) null, this.f43998a);
        }

        /* renamed from: a */
        public C0137ja mo3709a(C0128a action, long delayTime, TimeUnit unit) {
            if (isUnsubscribed()) {
                return C14978f.m46782b();
            }
            return this.f44001d.mo45936a((C0128a) new C14786f(this, action), delayTime, unit, this.f43999b);
        }
    }

    /* renamed from: rx.c.c.g$b */
    /* compiled from: EventLoopsScheduler */
    static final class C14789b {

        /* renamed from: a */
        final int f44002a;

        /* renamed from: b */
        final C14790c[] f44003b;

        /* renamed from: c */
        long f44004c;

        C14789b(ThreadFactory threadFactory, int maxThreads) {
            this.f44002a = maxThreads;
            this.f44003b = new C14790c[maxThreads];
            for (int i = 0; i < maxThreads; i++) {
                this.f44003b[i] = new C14790c(threadFactory);
            }
        }

        /* renamed from: a */
        public C14790c mo45931a() {
            int c = this.f44002a;
            if (c == 0) {
                return C14787g.f43994b;
            }
            C14790c[] cVarArr = this.f44003b;
            long j = this.f44004c;
            this.f44004c = 1 + j;
            return cVarArr[(int) (j % ((long) c))];
        }

        /* renamed from: b */
        public void mo45932b() {
            for (C14790c w : this.f44003b) {
                w.unsubscribe();
            }
        }
    }

    /* renamed from: rx.c.c.g$c */
    /* compiled from: EventLoopsScheduler */
    static final class C14790c extends C14801p {
        C14790c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int max;
        int maxThreads = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int cpuCount = Runtime.getRuntime().availableProcessors();
        if (maxThreads <= 0 || maxThreads > cpuCount) {
            max = cpuCount;
        } else {
            max = maxThreads;
        }
        f43993a = max;
        f43994b.unsubscribe();
    }

    public C14787g(ThreadFactory threadFactory) {
        this.f43996d = threadFactory;
        start();
    }

    public C0127a createWorker() {
        return new C14788a(((C14789b) this.f43997e.get()).mo45931a());
    }

    public void start() {
        C14789b update = new C14789b(this.f43996d, f43993a);
        if (!this.f43997e.compareAndSet(f43995c, update)) {
            update.mo45932b();
        }
    }

    public void shutdown() {
        C14789b curr;
        C14789b bVar;
        do {
            curr = (C14789b) this.f43997e.get();
            bVar = f43995c;
            if (curr == bVar) {
                return;
            }
        } while (!this.f43997e.compareAndSet(curr, bVar));
        curr.mo45932b();
    }

    /* renamed from: a */
    public C0137ja mo45930a(C0128a action) {
        return ((C14789b) this.f43997e.get()).mo45931a().mo45937b(action, -1, TimeUnit.NANOSECONDS);
    }
}
