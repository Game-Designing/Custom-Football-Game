package p024io.fabric.sdk.android.services.concurrency;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: io.fabric.sdk.android.services.concurrency.a */
/* compiled from: AsyncTask */
class C13931a implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f42262a = new AtomicInteger(1);

    C13931a() {
    }

    public Thread newThread(Runnable r) {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTask #");
        sb.append(this.f42262a.getAndIncrement());
        return new Thread(r, sb.toString());
    }
}
