package p320f.p321a.p327d.p340j;

import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.ProtocolViolationException;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.j.h */
/* compiled from: EndConsumerHelper */
public final class C13746h {
    /* renamed from: a */
    public static boolean m43759a(C13194b upstream, C13194b next, Class<?> observer) {
        C13264b.m43226a(next, "next is null");
        if (upstream == null) {
            return true;
        }
        next.dispose();
        if (upstream != C13218c.DISPOSED) {
            m43758a(observer);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m43760a(AtomicReference<C13194b> upstream, C13194b next, Class<?> observer) {
        C13264b.m43226a(next, "next is null");
        if (upstream.compareAndSet(null, next)) {
            return true;
        }
        next.dispose();
        if (upstream.get() != C13218c.DISPOSED) {
            m43758a(observer);
        }
        return false;
    }

    /* renamed from: a */
    public static String m43757a(String consumer) {
        StringBuilder sb = new StringBuilder();
        sb.append("It is not allowed to subscribe with a(n) ");
        sb.append(consumer);
        sb.append(" multiple times. Please create a fresh instance of ");
        sb.append(consumer);
        sb.append(" and subscribe that to the target source instead.");
        return sb.toString();
    }

    /* renamed from: a */
    public static void m43758a(Class<?> consumer) {
        C13774a.m43836b((Throwable) new ProtocolViolationException(m43757a(consumer.getName())));
    }
}
