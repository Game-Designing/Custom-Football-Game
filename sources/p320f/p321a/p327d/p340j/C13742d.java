package p320f.p321a.p327d.p340j;

import java.util.concurrent.atomic.AtomicLong;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.j.d */
/* compiled from: BackpressureHelper */
public final class C13742d {
    /* renamed from: a */
    public static long m43749a(long a, long b) {
        long u = a + b;
        if (u < 0) {
            return Long.MAX_VALUE;
        }
        return u;
    }

    /* renamed from: a */
    public static long m43750a(AtomicLong requested, long n) {
        long r;
        do {
            r = requested.get();
            if (r == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!requested.compareAndSet(r, m43749a(r, n)));
        return r;
    }

    /* renamed from: b */
    public static long m43751b(AtomicLong requested, long n) {
        long current;
        long update;
        do {
            current = requested.get();
            if (current == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            update = current - n;
            if (update < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("More produced than requested: ");
                sb.append(update);
                C13774a.m43836b((Throwable) new IllegalStateException(sb.toString()));
                update = 0;
            }
        } while (!requested.compareAndSet(current, update));
        return update;
    }
}
