package p024io.fabric.sdk.android.services.concurrency;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: io.fabric.sdk.android.services.concurrency.r */
/* compiled from: PriorityThreadPoolExecutor */
public class C13958r extends ThreadPoolExecutor {

    /* renamed from: a */
    private static final int f42312a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final int f42313b;

    /* renamed from: c */
    private static final int f42314c;

    /* renamed from: io.fabric.sdk.android.services.concurrency.r$a */
    /* compiled from: PriorityThreadPoolExecutor */
    protected static final class C13959a implements ThreadFactory {

        /* renamed from: a */
        private final int f42315a;

        public C13959a(int threadPriority) {
            this.f42315a = threadPriority;
        }

        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setPriority(this.f42315a);
            thread.setName("Queue");
            return thread;
        }
    }

    static {
        int i = f42312a;
        f42313b = i + 1;
        f42314c = (i * 2) + 1;
    }

    <T extends Runnable & C13948h & C13960s & C13956p> C13958r(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, C13949i<T> workQueue, ThreadFactory factory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, factory);
        prestartAllCoreThreads();
    }

    /* renamed from: a */
    public static <T extends Runnable & C13948h & C13960s & C13956p> C13958r m44362a(int corePoolSize, int maxPoolSize) {
        C13958r rVar = new C13958r(corePoolSize, maxPoolSize, 1, TimeUnit.SECONDS, new C13949i(), new C13959a(10));
        return rVar;
    }

    /* renamed from: a */
    public static C13958r m44361a() {
        return m44362a(f42313b, f42314c);
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new C13955o(runnable, value);
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C13955o(callable);
    }

    @TargetApi(9)
    public void execute(Runnable command) {
        if (C13957q.m44353b(command)) {
            super.execute(command);
        } else {
            super.execute(newTaskFor(command, null));
        }
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable throwable) {
        C13960s task = (C13960s) runnable;
        task.mo43407a(true);
        task.mo43405a(throwable);
        getQueue().mo43385a();
        super.afterExecute(runnable, throwable);
    }

    public C13949i getQueue() {
        return (C13949i) super.getQueue();
    }
}
