package p026rx.p398d;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C14980ia;

/* renamed from: rx.d.a */
/* compiled from: BlockingObservable */
class C14905a extends C14980ia<T> {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f44212a;

    /* renamed from: b */
    final /* synthetic */ AtomicReference f44213b;

    /* renamed from: c */
    final /* synthetic */ AtomicReference f44214c;

    /* renamed from: d */
    final /* synthetic */ C14906b f44215d;

    C14905a(C14906b bVar, CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
        this.f44215d = bVar;
        this.f44212a = countDownLatch;
        this.f44213b = atomicReference;
        this.f44214c = atomicReference2;
    }

    public void onCompleted() {
        this.f44212a.countDown();
    }

    public void onError(Throwable e) {
        this.f44213b.set(e);
        this.f44212a.countDown();
    }

    public void onNext(T item) {
        this.f44214c.set(item);
    }
}
