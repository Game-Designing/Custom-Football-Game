package p320f.p321a.p327d.p340j;

import java.util.concurrent.CountDownLatch;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p337g.C13719g;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.j.e */
/* compiled from: BlockingHelper */
public final class C13743e {
    /* renamed from: a */
    public static void m43753a(CountDownLatch latch, C13194b subscription) {
        if (latch.getCount() != 0) {
            try {
                m43752a();
                latch.await();
            } catch (InterruptedException e) {
                subscription.dispose();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            }
        }
    }

    /* renamed from: a */
    public static void m43752a() {
        if (!C13774a.m43832a()) {
            return;
        }
        if ((Thread.currentThread() instanceof C13719g) || C13774a.m43837b()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attempt to block on a Scheduler ");
            sb.append(Thread.currentThread().getName());
            sb.append(" that doesn't support blocking operators as they may lead to deadlock");
            throw new IllegalStateException(sb.toString());
        }
    }
}
