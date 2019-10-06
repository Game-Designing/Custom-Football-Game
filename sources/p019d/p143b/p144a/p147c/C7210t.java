package p019d.p143b.p144a.p147c;

import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: d.b.a.c.t */
class C7210t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f13959a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f13960b;

    /* renamed from: c */
    final /* synthetic */ C7206s f13961c;

    C7210t(C7206s sVar, AtomicReference atomicReference, CountDownLatch countDownLatch) {
        this.f13961c = sVar;
        this.f13959a = atomicReference;
        this.f13960b = countDownLatch;
    }

    public void run() {
        try {
            this.f13959a.set(new WebView(this.f13961c.f13946g).getSettings().getUserAgentString());
        } catch (Throwable th) {
            this.f13960b.countDown();
            throw th;
        }
        this.f13960b.countDown();
    }
}
