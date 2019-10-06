package p026rx.p390c.p393c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p029i.C0136c;
import p026rx.p029i.C14976d;
import p026rx.p029i.C14978f;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.c.j */
/* compiled from: ExecutorScheduler */
public final class C14793j extends C0126V {

    /* renamed from: a */
    final Executor f44011a;

    /* renamed from: rx.c.c.j$a */
    /* compiled from: ExecutorScheduler */
    static final class C14794a extends C0127a implements Runnable {

        /* renamed from: a */
        final Executor f44012a;

        /* renamed from: b */
        final C0136c f44013b = new C0136c();

        /* renamed from: c */
        final ConcurrentLinkedQueue<C14805s> f44014c = new ConcurrentLinkedQueue<>();

        /* renamed from: d */
        final AtomicInteger f44015d = new AtomicInteger();

        /* renamed from: e */
        final ScheduledExecutorService f44016e = C14795k.m46451a();

        public C14794a(Executor executor) {
            this.f44012a = executor;
        }

        /* renamed from: a */
        public C0137ja mo3707a(C0128a action) {
            if (isUnsubscribed()) {
                return C14978f.m46782b();
            }
            C14805s ea = new C14805s(C14948s.m46713a(action), this.f44013b);
            this.f44013b.mo3713a((C0137ja) ea);
            this.f44014c.offer(ea);
            if (this.f44015d.getAndIncrement() == 0) {
                try {
                    this.f44012a.execute(this);
                } catch (RejectedExecutionException t) {
                    this.f44013b.mo3714b(ea);
                    this.f44015d.decrementAndGet();
                    C14948s.m46719b((Throwable) t);
                    throw t;
                }
            }
            return ea;
        }

        public void run() {
            while (!this.f44013b.isUnsubscribed()) {
                C14805s sa = (C14805s) this.f44014c.poll();
                if (sa != null) {
                    if (!sa.isUnsubscribed()) {
                        if (!this.f44013b.isUnsubscribed()) {
                            sa.run();
                        } else {
                            this.f44014c.clear();
                            return;
                        }
                    }
                    if (this.f44015d.decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f44014c.clear();
        }

        /* renamed from: a */
        public C0137ja mo3709a(C0128a action, long delayTime, TimeUnit unit) {
            if (delayTime <= 0) {
                return mo3707a(action);
            }
            if (isUnsubscribed()) {
                return C14978f.m46782b();
            }
            C0128a decorated = C14948s.m46713a(action);
            C14976d first = new C14976d();
            C14976d mas = new C14976d();
            mas.mo46196a(first);
            this.f44013b.mo3713a((C0137ja) mas);
            C0137ja removeMas = C14978f.m46781a(new C14791h(this, mas));
            C14805s ea = new C14805s(new C14792i(this, mas, decorated, removeMas));
            first.mo46196a(ea);
            try {
                ea.mo45940a(this.f44016e.schedule(ea, delayTime, unit));
                return removeMas;
            } catch (RejectedExecutionException t) {
                C14948s.m46719b((Throwable) t);
                throw t;
            }
        }

        public boolean isUnsubscribed() {
            return this.f44013b.isUnsubscribed();
        }

        public void unsubscribe() {
            this.f44013b.unsubscribe();
            this.f44014c.clear();
        }
    }

    public C14793j(Executor executor) {
        this.f44011a = executor;
    }

    public C0127a createWorker() {
        return new C14794a(this.f44011a);
    }
}
