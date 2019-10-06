package p026rx.p390c.p391a;

import java.util.concurrent.TimeUnit;
import p026rx.C0120S.C0123b;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14980ia;

/* renamed from: rx.c.a.ra */
/* compiled from: OperatorDelay */
public final class C14714ra<T> implements C0123b<T, T> {

    /* renamed from: a */
    final long f43792a;

    /* renamed from: b */
    final TimeUnit f43793b;

    /* renamed from: c */
    final C0126V f43794c;

    public C14714ra(long delay, TimeUnit unit, C0126V scheduler) {
        this.f43792a = delay;
        this.f43793b = unit;
        this.f43794c = scheduler;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        C0127a worker = this.f43794c.createWorker();
        child.add(worker);
        return new C14711qa(this, child, worker, child);
    }
}
