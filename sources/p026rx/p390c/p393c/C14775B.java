package p026rx.p390c.p393c;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14975b;
import p026rx.p029i.C14978f;

/* renamed from: rx.c.c.B */
/* compiled from: TrampolineScheduler */
public final class C14775B extends C0126V {

    /* renamed from: a */
    public static final C14775B f43959a = new C14775B();

    /* renamed from: rx.c.c.B$a */
    /* compiled from: TrampolineScheduler */
    static final class C14776a extends C0127a implements C0137ja {

        /* renamed from: a */
        final AtomicInteger f43960a = new AtomicInteger();

        /* renamed from: b */
        final PriorityBlockingQueue<C14777b> f43961b = new PriorityBlockingQueue<>();

        /* renamed from: c */
        private final C14975b f43962c = new C14975b();

        /* renamed from: d */
        private final AtomicInteger f43963d = new AtomicInteger();

        C14776a() {
        }

        /* renamed from: a */
        public C0137ja mo3707a(C0128a action) {
            return m46431a(action, mo3710b());
        }

        /* renamed from: a */
        public C0137ja mo3709a(C0128a action, long delayTime, TimeUnit unit) {
            long execTime = mo3710b() + unit.toMillis(delayTime);
            return m46431a(new C14819z(action, this, execTime), execTime);
        }

        /* renamed from: a */
        private C0137ja m46431a(C0128a action, long execTime) {
            if (this.f43962c.isUnsubscribed()) {
                return C14978f.m46782b();
            }
            C14777b timedAction = new C14777b(action, Long.valueOf(execTime), this.f43960a.incrementAndGet());
            this.f43961b.add(timedAction);
            if (this.f43963d.getAndIncrement() != 0) {
                return C14978f.m46781a(new C14774A(this, timedAction));
            }
            do {
                C14777b polled = (C14777b) this.f43961b.poll();
                if (polled != null) {
                    polled.f43964a.call();
                }
            } while (this.f43963d.decrementAndGet() > 0);
            return C14978f.m46782b();
        }

        public void unsubscribe() {
            this.f43962c.unsubscribe();
        }

        public boolean isUnsubscribed() {
            return this.f43962c.isUnsubscribed();
        }
    }

    /* renamed from: rx.c.c.B$b */
    /* compiled from: TrampolineScheduler */
    static final class C14777b implements Comparable<C14777b> {

        /* renamed from: a */
        final C0128a f43964a;

        /* renamed from: b */
        final Long f43965b;

        /* renamed from: c */
        final int f43966c;

        C14777b(C0128a action, Long execTime, int count) {
            this.f43964a = action;
            this.f43965b = execTime;
            this.f43966c = count;
        }

        /* renamed from: a */
        public int compareTo(C14777b that) {
            int result = this.f43965b.compareTo(that.f43965b);
            if (result == 0) {
                return C14775B.m46430a(this.f43966c, that.f43966c);
            }
            return result;
        }
    }

    public C0127a createWorker() {
        return new C14776a();
    }

    private C14775B() {
    }

    /* renamed from: a */
    static int m46430a(int x, int y) {
        if (x < y) {
            return -1;
        }
        return x == y ? 0 : 1;
    }
}
