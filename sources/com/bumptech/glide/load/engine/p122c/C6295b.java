package com.bumptech.glide.load.engine.p122c;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.bumptech.glide.load.engine.c.b */
/* compiled from: GlideExecutor */
public final class C6295b implements ExecutorService {

    /* renamed from: a */
    private static final long f11142a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b */
    private static volatile int f11143b;

    /* renamed from: c */
    private final ExecutorService f11144c;

    /* renamed from: com.bumptech.glide.load.engine.c.b$a */
    /* compiled from: GlideExecutor */
    private static final class C6296a implements ThreadFactory {

        /* renamed from: a */
        private final String f11145a;

        /* renamed from: b */
        final C6297b f11146b;

        /* renamed from: c */
        final boolean f11147c;

        /* renamed from: d */
        private int f11148d;

        C6296a(String name, C6297b uncaughtThrowableStrategy, boolean preventNetworkOperations) {
            this.f11145a = name;
            this.f11146b = uncaughtThrowableStrategy;
            this.f11147c = preventNetworkOperations;
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread result;
            StringBuilder sb = new StringBuilder();
            sb.append("glide-");
            sb.append(this.f11145a);
            sb.append("-thread-");
            sb.append(this.f11148d);
            result = new C6294a(this, runnable, sb.toString());
            this.f11148d++;
            return result;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.c.b$b */
    /* compiled from: GlideExecutor */
    public interface C6297b {

        /* renamed from: a */
        public static final C6297b f11149a = new C6298c();

        /* renamed from: b */
        public static final C6297b f11150b = new C6299d();

        /* renamed from: c */
        public static final C6297b f11151c = new C6300e();

        /* renamed from: d */
        public static final C6297b f11152d = f11150b;

        /* renamed from: a */
        void mo19224a(Throwable th);
    }

    /* renamed from: c */
    public static C6295b m12085c() {
        return m12082a(1, "disk-cache", C6297b.f11152d);
    }

    /* renamed from: a */
    public static C6295b m12082a(int threadCount, String name, C6297b uncaughtThrowableStrategy) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadCount, threadCount, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C6296a(name, uncaughtThrowableStrategy, true));
        return new C6295b(threadPoolExecutor);
    }

    /* renamed from: d */
    public static C6295b m12086d() {
        return m12084b(m12080a(), "source", C6297b.f11152d);
    }

    /* renamed from: b */
    public static C6295b m12084b(int threadCount, String name, C6297b uncaughtThrowableStrategy) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadCount, threadCount, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C6296a(name, uncaughtThrowableStrategy, false));
        return new C6295b(threadPoolExecutor);
    }

    /* renamed from: e */
    public static C6295b m12087e() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, MoPubClientPositioning.NO_REPEAT, f11142a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new C6296a("source-unlimited", C6297b.f11152d, false));
        return new C6295b(threadPoolExecutor);
    }

    /* renamed from: b */
    public static C6295b m12083b() {
        return m12081a(m12080a() >= 4 ? 2 : 1, C6297b.f11152d);
    }

    /* renamed from: a */
    public static C6295b m12081a(int threadCount, C6297b uncaughtThrowableStrategy) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, threadCount, f11142a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C6296a("animation", uncaughtThrowableStrategy, true));
        return new C6295b(threadPoolExecutor);
    }

    C6295b(ExecutorService delegate) {
        this.f11144c = delegate;
    }

    public void execute(Runnable command) {
        this.f11144c.execute(command);
    }

    public Future<?> submit(Runnable task) {
        return this.f11144c.submit(task);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return this.f11144c.invokeAll(tasks);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return this.f11144c.invokeAll(tasks, timeout, unit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return this.f11144c.invokeAny(tasks);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f11144c.invokeAny(tasks, timeout, unit);
    }

    public <T> Future<T> submit(Runnable task, T result) {
        return this.f11144c.submit(task, result);
    }

    public <T> Future<T> submit(Callable<T> task) {
        return this.f11144c.submit(task);
    }

    public void shutdown() {
        this.f11144c.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f11144c.shutdownNow();
    }

    public boolean isShutdown() {
        return this.f11144c.isShutdown();
    }

    public boolean isTerminated() {
        return this.f11144c.isTerminated();
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.f11144c.awaitTermination(timeout, unit);
    }

    public String toString() {
        return this.f11144c.toString();
    }

    /* renamed from: a */
    public static int m12080a() {
        if (f11143b == 0) {
            f11143b = Math.min(4, C6302g.m12092a());
        }
        return f11143b;
    }
}
