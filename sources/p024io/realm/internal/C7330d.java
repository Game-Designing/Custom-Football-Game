package p024io.realm.internal;

import java.lang.ref.ReferenceQueue;
import p024io.realm.log.RealmLog;

/* renamed from: io.realm.internal.d */
/* compiled from: FinalizerRunnable */
class C7330d implements Runnable {

    /* renamed from: a */
    private final ReferenceQueue<C7333h> f14308a;

    C7330d(ReferenceQueue<C7333h> referenceQueue) {
        this.f14308a = referenceQueue;
    }

    public void run() {
        while (true) {
            try {
                ((NativeObjectReference) this.f14308a.remove()).mo23595a();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                RealmLog.m16236b("The FinalizerRunnable thread has been interrupted. Native resources cannot be freed anymore", new Object[0]);
                return;
            }
        }
    }
}
