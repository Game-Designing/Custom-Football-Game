package p320f.p321a.p327d.p337g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13193a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p328a.C13223h;

/* renamed from: f.a.d.g.b */
/* compiled from: ComputationScheduler */
public final class C13708b extends C13805u implements C13725l {

    /* renamed from: b */
    static final C13710b f41761b = new C13710b(0, f41762c);

    /* renamed from: c */
    static final C13720h f41762c = new C13720h("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);

    /* renamed from: d */
    static final int f41763d = m43689a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: e */
    static final C13711c f41764e = new C13711c(new C13720h("RxComputationShutdown"));

    /* renamed from: f */
    final ThreadFactory f41765f;

    /* renamed from: g */
    final AtomicReference<C13710b> f41766g;

    /* renamed from: f.a.d.g.b$a */
    /* compiled from: ComputationScheduler */
    static final class C13709a extends C13808c {

        /* renamed from: a */
        private final C13223h f41767a = new C13223h();

        /* renamed from: b */
        private final C13193a f41768b = new C13193a();

        /* renamed from: c */
        private final C13223h f41769c = new C13223h();

        /* renamed from: d */
        private final C13711c f41770d;

        /* renamed from: e */
        volatile boolean f41771e;

        C13709a(C13711c poolWorker) {
            this.f41770d = poolWorker;
            this.f41769c.mo42252b(this.f41767a);
            this.f41769c.mo42252b(this.f41768b);
        }

        public void dispose() {
            if (!this.f41771e) {
                this.f41771e = true;
                this.f41769c.dispose();
            }
        }

        /* renamed from: a */
        public C13194b mo42694a(Runnable action) {
            if (this.f41771e) {
                return C13219d.INSTANCE;
            }
            return this.f41770d.mo42709a(action, 0, TimeUnit.MILLISECONDS, this.f41767a);
        }

        /* renamed from: a */
        public C13194b mo42243a(Runnable action, long delayTime, TimeUnit unit) {
            if (this.f41771e) {
                return C13219d.INSTANCE;
            }
            return this.f41770d.mo42709a(action, delayTime, unit, this.f41768b);
        }
    }

    /* renamed from: f.a.d.g.b$b */
    /* compiled from: ComputationScheduler */
    static final class C13710b implements C13725l {

        /* renamed from: a */
        final int f41772a;

        /* renamed from: b */
        final C13711c[] f41773b;

        /* renamed from: c */
        long f41774c;

        C13710b(int maxThreads, ThreadFactory threadFactory) {
            this.f41772a = maxThreads;
            this.f41773b = new C13711c[maxThreads];
            for (int i = 0; i < maxThreads; i++) {
                this.f41773b[i] = new C13711c(threadFactory);
            }
        }

        /* renamed from: a */
        public C13711c mo42695a() {
            int c = this.f41772a;
            if (c == 0) {
                return C13708b.f41764e;
            }
            C13711c[] cVarArr = this.f41773b;
            long j = this.f41774c;
            this.f41774c = 1 + j;
            return cVarArr[(int) (j % ((long) c))];
        }

        /* renamed from: b */
        public void mo42696b() {
            for (C13711c w : this.f41773b) {
                w.dispose();
            }
        }
    }

    /* renamed from: f.a.d.g.b$c */
    /* compiled from: ComputationScheduler */
    static final class C13711c extends C13718f {
        C13711c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        f41764e.dispose();
        f41761b.mo42696b();
    }

    /* renamed from: a */
    static int m43689a(int cpuCount, int paramThreads) {
        return (paramThreads <= 0 || paramThreads > cpuCount) ? cpuCount : paramThreads;
    }

    public C13708b() {
        this(f41762c);
    }

    public C13708b(ThreadFactory threadFactory) {
        this.f41765f = threadFactory;
        this.f41766g = new AtomicReference<>(f41761b);
        mo42693b();
    }

    /* renamed from: a */
    public C13808c mo42242a() {
        return new C13709a(((C13710b) this.f41766g.get()).mo42695a());
    }

    /* renamed from: a */
    public C13194b mo42241a(Runnable run, long delay, TimeUnit unit) {
        return ((C13710b) this.f41766g.get()).mo42695a().mo42712b(run, delay, unit);
    }

    /* renamed from: a */
    public C13194b mo42692a(Runnable run, long initialDelay, long period, TimeUnit unit) {
        return ((C13710b) this.f41766g.get()).mo42695a().mo42711b(run, initialDelay, period, unit);
    }

    /* renamed from: b */
    public void mo42693b() {
        C13710b update = new C13710b(f41763d, this.f41765f);
        if (!this.f41766g.compareAndSet(f41761b, update)) {
            update.mo42696b();
        }
    }
}
