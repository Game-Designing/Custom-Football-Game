package p026rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14975b;
import p026rx.p029i.C14978f;
import p026rx.p390c.p393c.C14803r;
import p026rx.p390c.p393c.C14803r.C14804a;

/* renamed from: rx.schedulers.TestScheduler */
public class TestScheduler extends C0126V {

    /* renamed from: a */
    static long f44356a;

    /* renamed from: b */
    final Queue<C14993c> f44357b = new PriorityQueue(11, new C14991a());

    /* renamed from: c */
    long f44358c;

    /* renamed from: rx.schedulers.TestScheduler$a */
    static final class C14991a implements Comparator<C14993c> {
        C14991a() {
        }

        /* renamed from: a */
        public int compare(C14993c action1, C14993c action2) {
            long j = action1.f44361a;
            long j2 = action2.f44361a;
            int i = 1;
            if (j == j2) {
                if (action1.f44364d < action2.f44364d) {
                    i = -1;
                } else if (action1.f44364d <= action2.f44364d) {
                    i = 0;
                }
                return i;
            }
            if (j < j2) {
                i = -1;
            } else if (j <= j2) {
                i = 0;
            }
            return i;
        }
    }

    /* renamed from: rx.schedulers.TestScheduler$b */
    final class C14992b extends C0127a implements C14804a {

        /* renamed from: a */
        private final C14975b f44359a = new C14975b();

        C14992b() {
        }

        public void unsubscribe() {
            this.f44359a.unsubscribe();
        }

        public boolean isUnsubscribed() {
            return this.f44359a.isUnsubscribed();
        }

        /* renamed from: a */
        public C0137ja mo3709a(C0128a action, long delayTime, TimeUnit unit) {
            C14993c timedAction = new C14993c(this, TestScheduler.this.f44358c + unit.toNanos(delayTime), action);
            TestScheduler.this.f44357b.add(timedAction);
            return C14978f.m46781a(new C14994a(this, timedAction));
        }

        /* renamed from: a */
        public C0137ja mo3707a(C0128a action) {
            C14993c timedAction = new C14993c(this, 0, action);
            TestScheduler.this.f44357b.add(timedAction);
            return C14978f.m46781a(new C14995b(this, timedAction));
        }

        /* renamed from: a */
        public C0137ja mo3708a(C0128a action, long initialDelay, long period, TimeUnit unit) {
            return C14803r.m46467a(this, action, initialDelay, period, unit, this);
        }

        /* renamed from: b */
        public long mo3710b() {
            return TestScheduler.this.now();
        }

        /* renamed from: a */
        public long mo45938a() {
            return TestScheduler.this.f44358c;
        }
    }

    /* renamed from: rx.schedulers.TestScheduler$c */
    static final class C14993c {

        /* renamed from: a */
        final long f44361a;

        /* renamed from: b */
        final C0128a f44362b;

        /* renamed from: c */
        final C0127a f44363c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final long f44364d;

        C14993c(C0127a scheduler, long time, C0128a action) {
            long j = TestScheduler.f44356a;
            TestScheduler.f44356a = 1 + j;
            this.f44364d = j;
            this.f44361a = time;
            this.f44362b = action;
            this.f44363c = scheduler;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", new Object[]{Long.valueOf(this.f44361a), this.f44362b.toString()});
        }
    }

    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.f44358c);
    }

    public void advanceTimeBy(long delayTime, TimeUnit unit) {
        advanceTimeTo(this.f44358c + unit.toNanos(delayTime), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long delayTime, TimeUnit unit) {
        m46790a(unit.toNanos(delayTime));
    }

    public void triggerActions() {
        m46790a(this.f44358c);
    }

    /* renamed from: a */
    private void m46790a(long targetTimeInNanos) {
        while (!this.f44357b.isEmpty()) {
            C14993c current = (C14993c) this.f44357b.peek();
            long j = current.f44361a;
            if (j > targetTimeInNanos) {
                break;
            }
            if (j == 0) {
                j = this.f44358c;
            }
            this.f44358c = j;
            this.f44357b.remove();
            if (!current.f44363c.isUnsubscribed()) {
                current.f44362b.call();
            }
        }
        this.f44358c = targetTimeInNanos;
    }

    public C0127a createWorker() {
        return new C14992b();
    }
}
