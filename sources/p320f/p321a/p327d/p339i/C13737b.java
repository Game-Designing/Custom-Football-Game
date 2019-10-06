package p320f.p321a.p327d.p339i;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.ProtocolViolationException;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p340j.C13742d;
import p320f.p321a.p343g.C13774a;
import p363i.p368b.C14230c;

/* renamed from: f.a.d.i.b */
/* compiled from: SubscriptionHelper */
public enum C13737b implements C14230c {
    CANCELLED;

    public void request(long n) {
    }

    public void cancel() {
    }

    /* renamed from: a */
    public static boolean m43736a(C14230c current, C14230c next) {
        if (next == null) {
            C13774a.m43836b((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (current == null) {
            return true;
        } else {
            next.cancel();
            m43740e();
            return false;
        }
    }

    /* renamed from: e */
    public static void m43740e() {
        C13774a.m43836b((Throwable) new ProtocolViolationException("Subscription already set!"));
    }

    /* renamed from: a */
    public static boolean m43735a(long n) {
        if (n > 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("n > 0 required but it was ");
        sb.append(n);
        C13774a.m43836b((Throwable) new IllegalArgumentException(sb.toString()));
        return false;
    }

    /* renamed from: a */
    public static boolean m43738a(AtomicReference<C14230c> field, C14230c s) {
        C13264b.m43226a(s, "s is null");
        if (field.compareAndSet(null, s)) {
            return true;
        }
        s.cancel();
        if (field.get() != CANCELLED) {
            m43740e();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m43737a(AtomicReference<C14230c> field) {
        C14230c current = (C14230c) field.get();
        C13737b bVar = CANCELLED;
        if (current != bVar) {
            C14230c current2 = (C14230c) field.getAndSet(bVar);
            if (current2 != CANCELLED) {
                if (current2 != null) {
                    current2.cancel();
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m43739a(AtomicReference<C14230c> field, AtomicLong requested, C14230c s) {
        if (!m43738a(field, s)) {
            return false;
        }
        long r = requested.getAndSet(0);
        if (r != 0) {
            s.request(r);
        }
        return true;
    }

    /* renamed from: a */
    public static void m43734a(AtomicReference<C14230c> field, AtomicLong requested, long n) {
        C14230c s = (C14230c) field.get();
        if (s != null) {
            s.request(n);
        } else if (m43735a(n)) {
            C13742d.m43750a(requested, n);
            C14230c s2 = (C14230c) field.get();
            if (s2 != null) {
                long r = requested.getAndSet(0);
                if (r != 0) {
                    s2.request(r);
                }
            }
        }
    }
}
