package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicLong;

/* renamed from: rx.c.a.a */
/* compiled from: BackpressureUtils */
public final class C14640a {
    /* renamed from: a */
    public static long m46283a(AtomicLong requested, long n) {
        long current;
        do {
            current = requested.get();
        } while (!requested.compareAndSet(current, m46282a(current, n)));
        return current;
    }

    /* renamed from: a */
    public static long m46282a(long a, long b) {
        long u = a + b;
        if (u < 0) {
            return Long.MAX_VALUE;
        }
        return u;
    }

    /* renamed from: b */
    public static long m46285b(AtomicLong requested, long n) {
        long current;
        long next;
        do {
            current = requested.get();
            if (current == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            next = current - n;
            if (next < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("More produced than requested: ");
                sb.append(next);
                throw new IllegalStateException(sb.toString());
            }
        } while (!requested.compareAndSet(current, next));
        return next;
    }

    /* renamed from: a */
    public static boolean m46284a(long n) {
        if (n >= 0) {
            return n != 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("n >= 0 required but it was ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
}
