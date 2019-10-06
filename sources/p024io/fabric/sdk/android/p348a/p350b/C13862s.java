package p024io.fabric.sdk.android.p348a.p350b;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: io.fabric.sdk.android.a.b.s */
/* compiled from: ExecutorUtils */
class C13862s implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ String f42060a;

    /* renamed from: b */
    final /* synthetic */ AtomicLong f42061b;

    C13862s(String str, AtomicLong atomicLong) {
        this.f42060a = str;
        this.f42061b = atomicLong;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = Executors.defaultThreadFactory().newThread(new C13861r(this, runnable));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f42060a);
        sb.append(this.f42061b.getAndIncrement());
        thread.setName(sb.toString());
        return thread;
    }
}
