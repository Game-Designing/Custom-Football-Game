package android.support.p000v4.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: android.support.v4.content.f */
/* compiled from: ModernAsyncTask */
class C0518f implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f1685a = new AtomicInteger(1);

    C0518f() {
    }

    public Thread newThread(Runnable r) {
        StringBuilder sb = new StringBuilder();
        sb.append("ModernAsyncTask #");
        sb.append(this.f1685a.getAndIncrement());
        return new Thread(r, sb.toString());
    }
}
