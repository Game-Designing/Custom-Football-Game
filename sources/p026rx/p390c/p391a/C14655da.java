package p026rx.p390c.p391a;

import java.util.concurrent.TimeUnit;
import p026rx.C0120S.C0122a;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14980ia;

/* renamed from: rx.c.a.da */
/* compiled from: OnSubscribeTimerOnce */
public final class C14655da implements C0122a<Long> {

    /* renamed from: a */
    final long f43631a;

    /* renamed from: b */
    final TimeUnit f43632b;

    /* renamed from: c */
    final C0126V f43633c;

    public C14655da(long time, TimeUnit unit, C0126V scheduler) {
        this.f43631a = time;
        this.f43632b = unit;
        this.f43633c = scheduler;
    }

    /* renamed from: a */
    public void call(C14980ia<? super Long> child) {
        C0127a worker = this.f43633c.createWorker();
        child.add(worker);
        worker.mo3709a(new C14650ca(this, child), this.f43631a, this.f43632b);
    }
}
