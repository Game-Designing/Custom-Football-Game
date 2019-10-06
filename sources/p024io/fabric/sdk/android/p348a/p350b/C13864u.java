package p024io.fabric.sdk.android.p348a.p350b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: io.fabric.sdk.android.a.b.u */
/* compiled from: ExecutorUtils */
public final class C13864u {
    /* renamed from: a */
    public static ExecutorService m44075a(String name) {
        ExecutorService executor = Executors.newSingleThreadExecutor(m44079c(name));
        m44076a(name, executor);
        return executor;
    }

    /* renamed from: b */
    public static ScheduledExecutorService m44078b(String name) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(m44079c(name));
        m44076a(name, executor);
        return executor;
    }

    /* renamed from: c */
    public static final ThreadFactory m44079c(String threadNameTemplate) {
        return new C13862s(threadNameTemplate, new AtomicLong(1));
    }

    /* renamed from: a */
    private static final void m44076a(String serviceName, ExecutorService service) {
        m44077a(serviceName, service, 2, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public static final void m44077a(String serviceName, ExecutorService service, long terminationTimeout, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        C13863t tVar = new C13863t(serviceName, service, terminationTimeout, timeUnit);
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics Shutdown Hook for ");
        sb.append(serviceName);
        runtime.addShutdownHook(new Thread(tVar, sb.toString()));
    }
}
