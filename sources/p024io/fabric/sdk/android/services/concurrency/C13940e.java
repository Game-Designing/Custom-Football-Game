package p024io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: io.fabric.sdk.android.services.concurrency.e */
/* compiled from: AsyncTask */
public abstract class C13940e<Params, Progress, Result> {

    /* renamed from: a */
    private static final int f42272a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final int f42273b;

    /* renamed from: c */
    private static final int f42274c;

    /* renamed from: d */
    private static final ThreadFactory f42275d = new C13931a();

    /* renamed from: e */
    private static final BlockingQueue<Runnable> f42276e = new LinkedBlockingQueue(128);

    /* renamed from: f */
    public static final Executor f42277f;

    /* renamed from: g */
    public static final Executor f42278g = new C13943c(null);

    /* renamed from: h */
    private static final C13942b f42279h = new C13942b();

    /* renamed from: i */
    private static volatile Executor f42280i = f42278g;

    /* renamed from: j */
    private final C13945e<Params, Result> f42281j = new C13937b(this);

    /* renamed from: k */
    private final FutureTask<Result> f42282k = new C13938c(this, this.f42281j);

    /* renamed from: l */
    private volatile C13944d f42283l = C13944d.PENDING;

    /* renamed from: m */
    private final AtomicBoolean f42284m = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final AtomicBoolean f42285n = new AtomicBoolean();

    /* renamed from: io.fabric.sdk.android.services.concurrency.e$a */
    /* compiled from: AsyncTask */
    private static class C13941a<Data> {

        /* renamed from: a */
        final C13940e f42286a;

        /* renamed from: b */
        final Data[] f42287b;

        C13941a(C13940e task, Data... data) {
            this.f42286a = task;
            this.f42287b = data;
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.e$b */
    /* compiled from: AsyncTask */
    private static class C13942b extends Handler {
        public C13942b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message msg) {
            C13941a result = (C13941a) msg.obj;
            int i = msg.what;
            if (i == 1) {
                result.f42286a.m44310d(result.f42287b[0]);
            } else if (i == 2) {
                result.f42286a.mo43373b((Progress[]) result.f42287b);
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.e$c */
    /* compiled from: AsyncTask */
    private static class C13943c implements Executor {

        /* renamed from: a */
        final LinkedList<Runnable> f42288a;

        /* renamed from: b */
        Runnable f42289b;

        private C13943c() {
            this.f42288a = new LinkedList<>();
        }

        /* synthetic */ C13943c(C13931a x0) {
            this();
        }

        public synchronized void execute(Runnable r) {
            this.f42288a.offer(new C13946f(this, r));
            if (this.f42289b == null) {
                mo43378a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public synchronized void mo43378a() {
            Runnable runnable = (Runnable) this.f42288a.poll();
            this.f42289b = runnable;
            if (runnable != null) {
                C13940e.f42277f.execute(this.f42289b);
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.e$d */
    /* compiled from: AsyncTask */
    public enum C13944d {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.e$e */
    /* compiled from: AsyncTask */
    private static abstract class C13945e<Params, Result> implements Callable<Result> {

        /* renamed from: a */
        Params[] f42294a;

        private C13945e() {
        }

        /* synthetic */ C13945e(C13931a x0) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo43356a(Params... paramsArr);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo43358b(Result result);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo43359c(Result result);

    static {
        int i = f42272a;
        f42273b = i + 1;
        f42274c = (i * 2) + 1;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f42273b, f42274c, 1, TimeUnit.SECONDS, f42276e, f42275d);
        f42277f = threadPoolExecutor;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m44312f(Result result) {
        if (!this.f42285n.get()) {
            m44311e(result);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public Result m44311e(Result result) {
        f42279h.obtainMessage(1, new C13941a(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: d */
    public final C13944d mo43375d() {
        return this.f42283l;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo43360f() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo43373b(Progress... progressArr) {
    }

    /* renamed from: e */
    public final boolean mo43376e() {
        return this.f42284m.get();
    }

    /* renamed from: b */
    public final boolean mo43374b(boolean mayInterruptIfRunning) {
        this.f42284m.set(true);
        return this.f42282k.cancel(mayInterruptIfRunning);
    }

    /* renamed from: a */
    public final C13940e<Params, Progress, Result> mo43372a(Executor exec, Params... params) {
        if (this.f42283l != C13944d.PENDING) {
            int i = C13939d.f42271a[this.f42283l.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f42283l = C13944d.RUNNING;
        mo43360f();
        this.f42281j.f42294a = params;
        exec.execute(this.f42282k);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m44310d(Result result) {
        if (mo43376e()) {
            mo43358b(result);
        } else {
            mo43359c(result);
        }
        this.f42283l = C13944d.FINISHED;
    }
}
