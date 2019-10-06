package p026rx.p390c.p395e;

import java.util.concurrent.CountDownLatch;
import p026rx.C0137ja;

/* renamed from: rx.c.e.d */
/* compiled from: BlockingUtils */
public final class C14868d {
    /* renamed from: a */
    public static void m46584a(CountDownLatch latch, C0137ja subscription) {
        if (latch.getCount() != 0) {
            try {
                latch.await();
            } catch (InterruptedException e) {
                subscription.unsubscribe();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            }
        }
    }
}
