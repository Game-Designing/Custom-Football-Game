package p002b.p003c.p053g.p059d;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: b.c.g.d.k */
/* compiled from: SelfDestructiveThread */
public class C1240k {

    /* renamed from: a */
    private final Object f3999a = new Object();

    /* renamed from: b */
    private HandlerThread f4000b;

    /* renamed from: c */
    private Handler f4001c;

    /* renamed from: d */
    private int f4002d;

    /* renamed from: e */
    private Callback f4003e = new C1236g(this);

    /* renamed from: f */
    private final int f4004f;

    /* renamed from: g */
    private final int f4005g;

    /* renamed from: h */
    private final String f4006h;

    /* renamed from: b.c.g.d.k$a */
    /* compiled from: SelfDestructiveThread */
    public interface C1241a<T> {
        /* renamed from: a */
        void mo8996a(T t);
    }

    public C1240k(String threadName, int priority, int destructAfterMillisec) {
        this.f4006h = threadName;
        this.f4005g = priority;
        this.f4004f = destructAfterMillisec;
        this.f4002d = 0;
    }

    /* renamed from: b */
    private void m5859b(Runnable runnable) {
        synchronized (this.f3999a) {
            if (this.f4000b == null) {
                this.f4000b = new HandlerThread(this.f4006h, this.f4005g);
                this.f4000b.start();
                this.f4001c = new Handler(this.f4000b.getLooper(), this.f4003e);
                this.f4002d++;
            }
            this.f4001c.removeMessages(0);
            this.f4001c.sendMessage(this.f4001c.obtainMessage(1, runnable));
        }
    }

    /* renamed from: a */
    public <T> void mo9012a(Callable<T> callable, C1241a<T> reply) {
        m5859b(new C1238i(this, callable, new Handler(), reply));
    }

    /* renamed from: a */
    public <T> T mo9011a(Callable<T> callable, int timeoutMillis) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition cond = lock.newCondition();
        AtomicReference<T> holder = new AtomicReference<>();
        AtomicBoolean running = new AtomicBoolean(true);
        C1239j jVar = new C1239j(this, holder, callable, lock, running, cond);
        m5859b(jVar);
        lock.lock();
        try {
            if (!running.get()) {
                return holder.get();
            }
            long remaining = TimeUnit.MILLISECONDS.toNanos((long) timeoutMillis);
            do {
                try {
                    remaining = cond.awaitNanos(remaining);
                } catch (InterruptedException e) {
                }
                if (!running.get()) {
                    T t = holder.get();
                    lock.unlock();
                    return t;
                }
            } while (remaining > 0);
            throw new InterruptedException("timeout");
        } finally {
            lock.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5858a(Runnable runnable) {
        runnable.run();
        synchronized (this.f3999a) {
            this.f4001c.removeMessages(0);
            this.f4001c.sendMessageDelayed(this.f4001c.obtainMessage(0), (long) this.f4004f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5855a() {
        synchronized (this.f3999a) {
            if (!this.f4001c.hasMessages(1)) {
                this.f4000b.quit();
                this.f4000b = null;
                this.f4001c = null;
            }
        }
    }
}
