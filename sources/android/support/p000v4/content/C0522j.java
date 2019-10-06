package android.support.p000v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: android.support.v4.content.j */
/* compiled from: ModernAsyncTask */
abstract class C0522j<Params, Progress, Result> {

    /* renamed from: a */
    private static final ThreadFactory f1689a = new C0518f();

    /* renamed from: b */
    private static final BlockingQueue<Runnable> f1690b = new LinkedBlockingQueue(10);

    /* renamed from: c */
    public static final Executor f1691c;

    /* renamed from: d */
    private static C0524b f1692d;

    /* renamed from: e */
    private static volatile Executor f1693e = f1691c;

    /* renamed from: f */
    private final C0526d<Params, Result> f1694f = new C0519g(this);

    /* renamed from: g */
    private final FutureTask<Result> f1695g = new C0520h(this, this.f1694f);

    /* renamed from: h */
    private volatile C0525c f1696h = C0525c.PENDING;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final AtomicBoolean f1697i = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final AtomicBoolean f1698j = new AtomicBoolean();

    /* renamed from: android.support.v4.content.j$a */
    /* compiled from: ModernAsyncTask */
    private static class C0523a<Data> {

        /* renamed from: a */
        final C0522j f1699a;

        /* renamed from: b */
        final Data[] f1700b;

        C0523a(C0522j task, Data... data) {
            this.f1699a = task;
            this.f1700b = data;
        }
    }

    /* renamed from: android.support.v4.content.j$b */
    /* compiled from: ModernAsyncTask */
    private static class C0524b extends Handler {
        C0524b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message msg) {
            C0523a result = (C0523a) msg.obj;
            int i = msg.what;
            if (i == 1) {
                result.f1699a.mo5320a(result.f1700b[0]);
            } else if (i == 2) {
                result.f1699a.mo5324b((Progress[]) result.f1700b);
            }
        }
    }

    /* renamed from: android.support.v4.content.j$c */
    /* compiled from: ModernAsyncTask */
    public enum C0525c {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: android.support.v4.content.j$d */
    /* compiled from: ModernAsyncTask */
    private static abstract class C0526d<Params, Result> implements Callable<Result> {

        /* renamed from: a */
        Params[] f1705a;

        C0526d() {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo5271a(Params... paramsArr);

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f1690b, f1689a);
        f1691c = threadPoolExecutor;
    }

    /* renamed from: d */
    private static Handler m2605d() {
        C0524b bVar;
        synchronized (C0522j.class) {
            if (f1692d == null) {
                f1692d = new C0524b();
            }
            bVar = f1692d;
        }
        return bVar;
    }

    C0522j() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo5327e(Result result) {
        if (!this.f1698j.get()) {
            mo5326d(result);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Result mo5326d(Result result) {
        m2605d().obtainMessage(1, new C0523a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5325c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5274c(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5324b(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5273b(Result result) {
        mo5323b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5323b() {
    }

    /* renamed from: a */
    public final boolean mo5321a() {
        return this.f1697i.get();
    }

    /* renamed from: a */
    public final boolean mo5322a(boolean mayInterruptIfRunning) {
        this.f1697i.set(true);
        return this.f1695g.cancel(mayInterruptIfRunning);
    }

    /* renamed from: a */
    public final C0522j<Params, Progress, Result> mo5319a(Executor exec, Params... params) {
        if (this.f1696h != C0525c.PENDING) {
            int i = C0521i.f1688a[this.f1696h.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.f1696h = C0525c.RUNNING;
            mo5325c();
            this.f1694f.f1705a = params;
            exec.execute(this.f1695g);
            return this;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5320a(Result result) {
        if (mo5321a()) {
            mo5273b(result);
        } else {
            mo5274c(result);
        }
        this.f1696h = C0525c.FINISHED;
    }
}
