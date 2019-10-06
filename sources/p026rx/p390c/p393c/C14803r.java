package p026rx.p390c.p393c;

import java.util.concurrent.TimeUnit;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p390c.p394d.C14821b;

/* renamed from: rx.c.c.r */
/* compiled from: SchedulePeriodicHelper */
public final class C14803r {

    /* renamed from: a */
    public static final long f44046a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* renamed from: rx.c.c.r$a */
    /* compiled from: SchedulePeriodicHelper */
    public interface C14804a {
        /* renamed from: a */
        long mo45938a();
    }

    /* renamed from: a */
    public static C0137ja m46467a(C0127a worker, C0128a action, long initialDelay, long period, TimeUnit unit, C14804a nowNanoSupplier) {
        long j = initialDelay;
        TimeUnit timeUnit = unit;
        long periodInNanos = timeUnit.toNanos(period);
        long firstNowNanos = nowNanoSupplier != null ? nowNanoSupplier.mo45938a() : TimeUnit.MILLISECONDS.toNanos(worker.mo3710b());
        long firstStartInNanos = firstNowNanos + timeUnit.toNanos(j);
        C14821b first = new C14821b();
        C14821b mas = new C14821b(first);
        C14821b first2 = first;
        C14802q qVar = new C14802q(firstNowNanos, firstStartInNanos, action, mas, nowNanoSupplier, worker, periodInNanos);
        first2.mo45948a(worker.mo3709a(qVar, j, timeUnit));
        return mas;
    }
}
