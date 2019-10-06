package p026rx.p390c.p395e;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: rx.c.e.j */
/* compiled from: RxThreadFactory */
public final class C14882j extends AtomicLong implements ThreadFactory {

    /* renamed from: a */
    public static final ThreadFactory f44169a = new C14881i();

    /* renamed from: b */
    final String f44170b;

    public C14882j(String prefix) {
        this.f44170b = prefix;
    }

    public Thread newThread(Runnable r) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f44170b);
        sb.append(incrementAndGet());
        Thread t = new Thread(r, sb.toString());
        t.setDaemon(true);
        return t;
    }
}
