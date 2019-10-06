package p320f.p321a.p327d.p340j;

import java.util.concurrent.CountDownLatch;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p326c.C13204f;

/* renamed from: f.a.d.j.f */
/* compiled from: BlockingIgnoringReceiver */
public final class C13744f extends CountDownLatch implements C13204f<Throwable>, C13199a {

    /* renamed from: a */
    public Throwable f41850a;

    public C13744f() {
        super(1);
    }

    /* renamed from: a */
    public void accept(Throwable e) {
        this.f41850a = e;
        countDown();
    }

    public void run() {
        countDown();
    }
}
