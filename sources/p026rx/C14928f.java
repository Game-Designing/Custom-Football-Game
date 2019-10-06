package p026rx;

import java.util.concurrent.CountDownLatch;

/* renamed from: rx.f */
/* compiled from: Completable */
class C14928f implements C14503O {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f44248a;

    /* renamed from: b */
    final /* synthetic */ Throwable[] f44249b;

    /* renamed from: c */
    final /* synthetic */ C0117M f44250c;

    C14928f(C0117M m, CountDownLatch countDownLatch, Throwable[] thArr) {
        this.f44250c = m;
        this.f44248a = countDownLatch;
        this.f44249b = thArr;
    }

    public void onCompleted() {
        this.f44248a.countDown();
    }

    public void onError(Throwable e) {
        this.f44249b[0] = e;
        this.f44248a.countDown();
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
    }
}
