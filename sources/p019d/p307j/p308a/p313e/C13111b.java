package p019d.p307j.p308a.p313e;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: d.j.a.e.b */
/* compiled from: FileDownloadExecutors */
public class C13111b {

    /* renamed from: d.j.a.e.b$a */
    /* compiled from: FileDownloadExecutors */
    static class C13112a implements ThreadFactory {

        /* renamed from: a */
        private static final AtomicInteger f40134a = new AtomicInteger(1);

        /* renamed from: b */
        private final String f40135b;

        /* renamed from: c */
        private final ThreadGroup f40136c = Thread.currentThread().getThreadGroup();

        /* renamed from: d */
        private final AtomicInteger f40137d = new AtomicInteger(1);

        C13112a(String prefix) {
            this.f40135b = C13121g.m42809h(prefix);
        }

        public Thread newThread(Runnable r) {
            ThreadGroup threadGroup = this.f40136c;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f40135b);
            sb.append(this.f40137d.getAndIncrement());
            Thread t = new Thread(threadGroup, r, sb.toString(), 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != 5) {
                t.setPriority(5);
            }
            return t;
        }
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m42766a(int nThreads, String prefix) {
        return m42767a(nThreads, new LinkedBlockingQueue(), prefix);
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m42767a(int nThreads, LinkedBlockingQueue<Runnable> queue, String prefix) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(nThreads, nThreads, 5, TimeUnit.SECONDS, queue, new C13112a(prefix));
        executor.allowCoreThreadTimeOut(true);
        return executor;
    }
}
