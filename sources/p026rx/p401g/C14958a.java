package p026rx.p401g;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C14972ha;

/* renamed from: rx.g.a */
/* compiled from: BlockingSingle */
class C14958a extends C14972ha<T> {

    /* renamed from: b */
    final /* synthetic */ AtomicReference f44284b;

    /* renamed from: c */
    final /* synthetic */ CountDownLatch f44285c;

    /* renamed from: d */
    final /* synthetic */ AtomicReference f44286d;

    /* renamed from: e */
    final /* synthetic */ C14959b f44287e;

    C14958a(C14959b bVar, AtomicReference atomicReference, CountDownLatch countDownLatch, AtomicReference atomicReference2) {
        this.f44287e = bVar;
        this.f44284b = atomicReference;
        this.f44285c = countDownLatch;
        this.f44286d = atomicReference2;
    }

    /* renamed from: a */
    public void mo45712a(T value) {
        this.f44284b.set(value);
        this.f44285c.countDown();
    }

    public void onError(Throwable error) {
        this.f44286d.set(error);
        this.f44285c.countDown();
    }
}
