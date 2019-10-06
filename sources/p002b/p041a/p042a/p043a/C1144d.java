package p002b.p041a.p042a.p043a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: b.a.a.a.d */
/* compiled from: DefaultTaskExecutor */
public class C1144d extends C1145e {

    /* renamed from: a */
    private final Object f3797a = new Object();

    /* renamed from: b */
    private ExecutorService f3798b = Executors.newFixedThreadPool(2);

    /* renamed from: c */
    private volatile Handler f3799c;

    /* renamed from: a */
    public void mo8747a(Runnable runnable) {
        this.f3798b.execute(runnable);
    }

    /* renamed from: b */
    public void mo8749b(Runnable runnable) {
        if (this.f3799c == null) {
            synchronized (this.f3797a) {
                if (this.f3799c == null) {
                    this.f3799c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f3799c.post(runnable);
    }

    /* renamed from: a */
    public boolean mo8748a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
