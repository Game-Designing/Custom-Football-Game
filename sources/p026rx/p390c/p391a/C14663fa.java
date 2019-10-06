package p026rx.p390c.p391a;

import java.util.concurrent.TimeUnit;
import p026rx.C0120S.C0122a;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14980ia;

/* renamed from: rx.c.a.fa */
/* compiled from: OnSubscribeTimerPeriodically */
public final class C14663fa implements C0122a<Long> {

    /* renamed from: a */
    final long f43649a;

    /* renamed from: b */
    final long f43650b;

    /* renamed from: c */
    final TimeUnit f43651c;

    /* renamed from: d */
    final C0126V f43652d;

    public C14663fa(long initialDelay, long period, TimeUnit unit, C0126V scheduler) {
        this.f43649a = initialDelay;
        this.f43650b = period;
        this.f43651c = unit;
        this.f43652d = scheduler;
    }

    /* renamed from: a */
    public void call(C14980ia<? super Long> child) {
        C0127a worker = this.f43652d.createWorker();
        child.add(worker);
        worker.mo3708a(new C14659ea(this, child, worker), this.f43649a, this.f43650b, this.f43651c);
    }
}
